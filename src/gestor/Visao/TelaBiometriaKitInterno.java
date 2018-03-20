/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControlePagamentosKitInternos;
import static gestor.Controle.ControlePagamentosKitInternos.qtdInternos;
import gestor.Controle.DigitalInternos;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.ItensPagamentoKitInterno;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxBolaFutsal;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxCalcaoJogo;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxCamisaJogo;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxCobertor;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxDesodorante;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxLencol;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxParMeiao;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxSabaoPo;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxAbsorvente;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxBarbeador;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxBermuda;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxCamisa;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxColchao;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxColher;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxCopo;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxCreme;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxCueca;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxEscova;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxGarfo;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxPapel;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxPrato;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxSabonete;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxSandalia;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxToalha;
import static gestor.Visao.TelaPagamentoKitInterno.jCheckBoxVasilha;
import static gestor.Visao.TelaPagamentoKitInterno.jIdLanc;
import static gestor.Visao.TelaPagamentoKitInterno.jTabelaInternos;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ronaldo
 */
public class TelaBiometriaKitInterno extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensPagamentoKitInterno objItensPagto = new ItensPagamentoKitInterno();
    ControlePagamentosKitInternos controle = new ControlePagamentosKitInternos();
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

    /**
     * Creates new form TelaBiometriaKitInterno
     */
    public static TelaPagamentoKitInterno pagamentoKit;

    public TelaBiometriaKitInterno(TelaPagamentoKitInterno parent, boolean modal) {
        this.pagamentoKit = parent;
        this.setModal(modal);
        setLocationRelativeTo(pagamentoKit);
        initComponents();
    }

    // CÓDIGO DA BIOMETRIA CIS FS-80H
    public interface CIS_SDK extends StdCallLibrary {

        CIS_SDK INSTANCE = (CIS_SDK) Native.loadLibrary("CIS_SDK", CIS_SDK.class);

        public int CIS_SDK_Biometrico_Iniciar();

        public int CIS_SDK_Biometrico_Finalizar();

        public int CIS_SDK_Biometrico_LerDigital(PointerByReference pTemplate);

        public Pointer CIS_SDK_Biometrico_LerDigital_RetornoPonteiro(IntByReference iRetorno);

        public int CIS_SDK_Biometrico_CancelarLeitura();

        public int CIS_SDK_Biometrico_CompararDigital(PointerByReference pAmostra1, PointerByReference pAmostra2);

        public Pointer CIS_SDK_Biometrico_LerWSQ(IntByReference iRetorno, IntByReference iSize);

        public int CIS_SDK_Biometrico_LerDigitalComImagem(Pointer pTemplate, IntByReference iTemplate, Pointer pImagem, IntByReference iImagem, int iFundoBranco, int iTipoImagem);

        public Pointer CIS_SDK_Versao();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdInternoKitBio = new javax.swing.JTextField();
        jNomeInternoKitBio = new javax.swing.JTextField();
        jPavilhaoKitBio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jMatriculaPenalKitBio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jRegimeKitBio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jCelaKitBio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDataEntrega = new com.toedter.calendar.JDateChooser();
        jHorarioPagto = new javax.swing.JFormattedTextField();
        jCheckBoxKitAnual = new javax.swing.JCheckBox();
        jCheckBoxDecimal = new javax.swing.JCheckBox();
        jCheckBoxSemestral = new javax.swing.JCheckBox();
        jCheckBoxMarcaTodos = new javax.swing.JCheckBox();
        jCheckBoxMensal = new javax.swing.JCheckBox();
        jCheckBoxKitQuinzenal = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jBtSalvar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtIniciarLeitor = new javax.swing.JButton();
        jBtCancelarLeitura = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jFotoInternoKitBio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Registro de Kit de Internos {Biometria} :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome Completo do Interno");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Pavilhão");

        jIdInternoKitBio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoKitBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoKitBio.setEnabled(false);

        jNomeInternoKitBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoKitBio.setEnabled(false);

        jPavilhaoKitBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPavilhaoKitBio.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Matricula Penal");

        jMatriculaPenalKitBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenalKitBio.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Regime");

        jRegimeKitBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegimeKitBio.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Cela");

        jCelaKitBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCelaKitBio.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Data Entrega");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Horário");

        jDataEntrega.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrega.setEnabled(false);

        jHorarioPagto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioPagto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioPagto.setEnabled(false);

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
        jCheckBoxDecimal.setText("Kit Decimal");
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

        jCheckBoxMarcaTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxMarcaTodos.setText("Marca Todos");
        jCheckBoxMarcaTodos.setEnabled(false);
        jCheckBoxMarcaTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxMarcaTodosItemStateChanged(evt);
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

        jCheckBoxKitQuinzenal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxKitQuinzenal.setForeground(new java.awt.Color(204, 0, 0));
        jCheckBoxKitQuinzenal.setText("Kit Quinzenal");
        jCheckBoxKitQuinzenal.setEnabled(false);
        jCheckBoxKitQuinzenal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxKitQuinzenalItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCelaKitBio)
                    .addComponent(jNomeInternoKitBio)
                    .addComponent(jPavilhaoKitBio)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(132, 132, 132)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jHorarioPagto)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jIdInternoKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jMatriculaPenalKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jRegimeKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxMarcaTodos)
                            .addComponent(jCheckBoxDecimal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxKitAnual)
                            .addComponent(jCheckBoxSemestral))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxKitQuinzenal)
                            .addComponent(jCheckBoxMensal))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRegimeKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMatriculaPenalKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdInternoKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPavilhaoKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCelaKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jHorarioPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxKitAnual)
                    .addComponent(jCheckBoxMarcaTodos)
                    .addComponent(jCheckBoxKitQuinzenal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxDecimal)
                    .addComponent(jCheckBoxSemestral)
                    .addComponent(jCheckBoxMensal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jBtIniciarLeitor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtIniciarLeitor.setForeground(new java.awt.Color(0, 153, 0));
        jBtIniciarLeitor.setText("Iniciar Leitor Digital");
        jBtIniciarLeitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIniciarLeitorActionPerformed(evt);
            }
        });

        jBtCancelarLeitura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtCancelarLeitura.setForeground(new java.awt.Color(204, 0, 0));
        jBtCancelarLeitura.setText("Cancelar Leitura");
        jBtCancelarLeitura.setEnabled(false);
        jBtCancelarLeitura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarLeituraActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jFotoInternoKitBio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoKitBio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoKitBio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(240, 240, 240)
                                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtIniciarLeitor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtCancelarLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtSair, jBtSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtIniciarLeitor)
                            .addComponent(jBtCancelarLeitura)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtSair, jBtSalvar});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtCancelarLeitura, jBtIniciarLeitor});

        setSize(new java.awt.Dimension(657, 408));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        verificarInternos();
        if (jIdInternoKitBio.getText().equals("") || jNomeInternoKitBio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o nome do interno.");
        } else if (jDataEntrega.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Informe a data de entrega do kit.");
        } else if (jHorarioPagto.getText().equals("") || jHorarioPagto.getText().equals("00:00")) {
            JOptionPane.showMessageDialog(null, "Informe o horário de entrega do kit.");
        } else if (marcaTodos == 0 && kitAnual == 0 && kitQuinzenal == 0) {
            JOptionPane.showMessageDialog(rootPane, "Informe um tipo de kit para ser entregue ao interno.");
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
            //
            objItensPagto.setTipoEntrada(tipoEntrada);
            objItensPagto.setDataEntrega(jDataEntrega.getDate());
            objItensPagto.setHoraEntrega(jHorarioPagto.getText());
            //
            objItensPagto.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio.getText()));
            objItensPagto.setNomeInternoCrcKit(jNomeInternoKitBio.getText());
            objItensPagto.setIdPagto(Integer.valueOf(jIdLanc.getText()));
            objItensPagto.setDataEntrega(jDataEntrega.getDate());
            objItensPagto.setHoraEntrega(jHorarioPagto.getText());
            objItensPagto.setAssinaturaDigital(pDigitalCapturada);
            //
            objItensPagto.setUsuarioInsert(nameUser);
            objItensPagto.setDataInsert(dataModFinal);
            objItensPagto.setHorarioInsert(horaMov);
            if (jIdInternoKitBio.getText().equals(codigoInterno) && jIdLanc.getText().equals(codigoKit)) {
                JOptionPane.showMessageDialog(rootPane, "Esse interno já recebeu o kit nesse registro.");
            } else {
                controle.incluirPagamentoKitInterno(objItensPagto);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                Salvar();
                preencherTabelaItensInterno("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdPagto='" + jIdLanc.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtIniciarLeitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIniciarLeitorActionPerformed
        // TODO add your handling code here:
        Novo();
        // Instanciar a DLL
        CIS_SDK dll = CIS_SDK.INSTANCE;
        //
        int iRetorno = dll.CIS_SDK_Biometrico_Iniciar();
        if (iRetorno != 1 && iRetorno == 0) {
            JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -1) {
            JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
            return;
        } else if (iRetorno != 1 && iRetorno == -10) {
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -11) {
            JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
            return;
        } else if (iRetorno != 1 && iRetorno == -12) {
            JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -13) {
            JOptionPane.showMessageDialog(null, "SDK EM USO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -14) {
            JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -15) {
            JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -16) {
            JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -17) {
            JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -18) {
            JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -21) {
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -22) {
            JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -23) {
            JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -24) {
            JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
            return;
        } else if (iRetorno != 1 && iRetorno == -25) {
            JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -26) {
            JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
            return;
        } else if (iRetorno != 1 && iRetorno == -27) {
            JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -28) {
            JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -29) {
            JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
            return;
        }
        jBtCancelarLeitura.setEnabled(true);
        new Thread(LerDigital1).start();
    }//GEN-LAST:event_jBtIniciarLeitorActionPerformed

    private void jBtCancelarLeituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarLeituraActionPerformed
        // TODO add your handling code here:
        // Instanciar a DLL
        CIS_SDK dll = CIS_SDK.INSTANCE;
        // Cancelar a leitura 
        dll.CIS_SDK_Biometrico_CancelarLeitura();
        // HABILITAR O BOTÃO PARA CANCELAR A LEITURA
        jBtCancelarLeitura.setEnabled(false);
    }//GEN-LAST:event_jBtCancelarLeituraActionPerformed

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
            java.util.logging.Logger.getLogger(TelaBiometriaKitInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBiometriaKitInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBiometriaKitInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBiometriaKitInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaBiometriaKitInterno dialog = new TelaBiometriaKitInterno(pagamentoKit, true);
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
    private javax.swing.JButton jBtCancelarLeitura;
    private javax.swing.JButton jBtIniciarLeitor;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    public static javax.swing.JTextField jCelaKitBio;
    public static javax.swing.JCheckBox jCheckBoxDecimal;
    private javax.swing.JCheckBox jCheckBoxKitAnual;
    private javax.swing.JCheckBox jCheckBoxKitQuinzenal;
    private javax.swing.JCheckBox jCheckBoxMarcaTodos;
    private javax.swing.JCheckBox jCheckBoxMensal;
    private javax.swing.JCheckBox jCheckBoxSemestral;
    private com.toedter.calendar.JDateChooser jDataEntrega;
    public static javax.swing.JLabel jFotoInternoKitBio;
    private javax.swing.JFormattedTextField jHorarioPagto;
    public static javax.swing.JTextField jIdInternoKitBio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JTextField jMatriculaPenalKitBio;
    public static javax.swing.JTextField jNomeInternoKitBio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField jPavilhaoKitBio;
    public static javax.swing.JTextField jRegimeKitBio;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private static Runnable LerDigital1 = new Runnable() {
        @Override
        public void run() {
            try {
                // Instanciar a DLL
                CIS_SDK dll = CIS_SDK.INSTANCE;
                // Capturar a digital no leitor   
                Pointer pDigital;
                IntByReference iRet = new IntByReference();
                pDigital = dll.CIS_SDK_Biometrico_LerDigital_RetornoPonteiro(iRet);
                int iRetorno2 = iRet.getValue();
                if (iRetorno2 != 1 && iRetorno2 == 0) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -1) {
                    JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -10) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -11) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -12) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -13) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "SDK EM USO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -14) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -15) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -16) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -17) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -18) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -21) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -22) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -23) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -24) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -25) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -26) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -27) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -28) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -29) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
                    return;
                }
                //
                byte[] pDigitalCap = pDigital.getByteArray(0, 669);
                pDigitalCapturada = pDigitalCap; // SALVAR DIGITAL NO BANCO DE DADOS
                //
                ControlePagamentosKitInternos digiControl = new ControlePagamentosKitInternos();
                DigitalInternos d = new DigitalInternos();
                int pVar = 0;
                for (DigitalInternos dd : digiControl.read()) {
                    // LER DIGITAL PARA COMPRAR
                    final Pointer p1 = new Memory(669);
                    p1.write(0, pDigitalCap, 0, pDigitalCap.length);
                    final PointerByReference pr1 = new PointerByReference();
                    pr1.setPointer(p1);
                    // DIGITAL DO BANCO DE DADOS - DEDO UM                   
                    Pointer p2 = new Memory(669);
                    p2.write(0, dd.getBiometriaDedo1(), 0, dd.getBiometriaDedo1().length);
                    PointerByReference pr2 = new PointerByReference();
                    pr2.setPointer(p2);
                    // DIGITAL DO BANCO DE DADOS - DEDO DOIS  
                    Pointer p3 = new Memory(669);
                    p3.write(0, dd.getBiometriaDedo2(), 0, dd.getBiometriaDedo2().length);
                    PointerByReference pr3 = new PointerByReference();
                    pr3.setPointer(p3);
                    // DIGITAL DO BANCO DE DADOS - DEDO TRÊS  
                    Pointer p4 = new Memory(669);
                    p4.write(0, dd.getBiometriaDedo3(), 0, dd.getBiometriaDedo3().length);
                    PointerByReference pr4 = new PointerByReference();
                    pr4.setPointer(p4);
                    // DIGITAL DO BANCO DE DADOS - DEDO QUATRO  
                    Pointer p5 = new Memory(669);
                    p5.write(0, dd.getBiometriaDedo4(), 0, dd.getBiometriaDedo4().length);
                    PointerByReference pr5 = new PointerByReference();
                    pr5.setPointer(p5);
                    // COMPARA TODAS AS DIGITAIS                 
                    int iRetorno = dll.CIS_SDK_Biometrico_CompararDigital(pr1, pr2);
                    int iRetornod1 = dll.CIS_SDK_Biometrico_CompararDigital(pr1, pr3);
                    int iRetornod2 = dll.CIS_SDK_Biometrico_CompararDigital(pr1, pr4);
                    int iRetornod3 = dll.CIS_SDK_Biometrico_CompararDigital(pr1, pr5);
                    // VERIFICAR SE A DIGITAL EXISTE OU NÃO
                    if (iRetorno == 1) {
                        jIdInternoKitBio.setText(String.valueOf(dd.getIdInternoCrc()));
                        jNomeInternoKitBio.setText(dd.getNomeInternoCrc());
                        jMatriculaPenalKitBio.setText(dd.getMatriculaPenal());
                        jRegimeKitBio.setText(dd.getRegime());
                        jPavilhaoKitBio.setText(dd.getPavilhao());
                        jCelaKitBio.setText(dd.getCela());
                        caminhoFotoInterno = dd.getCaminhoFotoInterno();
                        javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoInterno);
                        jFotoInternoKitBio.setIcon(a);
                        jFotoInternoKitBio.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoInternoKitBio.getWidth(), jFotoInternoKitBio.getHeight(), Image.SCALE_DEFAULT)));
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                    } else if (iRetornod1 == 1) {
                        jIdInternoKitBio.setText(String.valueOf(dd.getIdInternoCrc()));
                        jNomeInternoKitBio.setText(dd.getNomeInternoCrc());
                        jMatriculaPenalKitBio.setText(dd.getMatriculaPenal());
                        jRegimeKitBio.setText(dd.getRegime());
                        jPavilhaoKitBio.setText(dd.getPavilhao());
                        jCelaKitBio.setText(dd.getCela());
                        caminhoFotoInterno = dd.getCaminhoFotoInterno();
                        javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoInterno);
                        jFotoInternoKitBio.setIcon(a);
                        jFotoInternoKitBio.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoInternoKitBio.getWidth(), jFotoInternoKitBio.getHeight(), Image.SCALE_DEFAULT)));
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                    } else if (iRetornod2 == 1) {
                        jIdInternoKitBio.setText(String.valueOf(dd.getIdInternoCrc()));
                        jNomeInternoKitBio.setText(dd.getNomeInternoCrc());
                        jMatriculaPenalKitBio.setText(dd.getMatriculaPenal());
                        jRegimeKitBio.setText(dd.getRegime());
                        jPavilhaoKitBio.setText(dd.getPavilhao());
                        jCelaKitBio.setText(dd.getCela());
                        caminhoFotoInterno = dd.getCaminhoFotoInterno();
                        javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoInterno);
                        jFotoInternoKitBio.setIcon(a);
                        jFotoInternoKitBio.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoInternoKitBio.getWidth(), jFotoInternoKitBio.getHeight(), Image.SCALE_DEFAULT)));
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                    } else if (iRetornod3 == 1) {
                        jIdInternoKitBio.setText(String.valueOf(dd.getIdInternoCrc()));
                        jNomeInternoKitBio.setText(dd.getNomeInternoCrc());
                        jMatriculaPenalKitBio.setText(dd.getMatriculaPenal());
                        jRegimeKitBio.setText(dd.getRegime());
                        jPavilhaoKitBio.setText(dd.getPavilhao());
                        jCelaKitBio.setText(dd.getCela());
                        caminhoFotoInterno = dd.getCaminhoFotoInterno();
                        javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoInterno);
                        jFotoInternoKitBio.setIcon(a);
                        jFotoInternoKitBio.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoInternoKitBio.getWidth(), jFotoInternoKitBio.getHeight(), Image.SCALE_DEFAULT)));
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                    }
                    // SE iRetorno FOR IGUAL A -2 E pVar FOR IGUAL A count DIGITAL NÃO CADASTRADA                        
                    if (iRetorno == -2 && iRetornod1 == -2 && iRetornod2 == -2 && iRetornod3 == -2 && qtdInternos == pVar) {
                        break;
                    }
                    pVar = pVar + 1;
                }
                JOptionPane.showMessageDialog(null, "Digital não cadastrada, procure o CRC !!!");
                // Finalizar o SDK 
                int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                if (idRetorno != 1 && idRetorno == 0) {
                    JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -1) {
                    JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -10) {
                    JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -11) {
                    JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -12) {
                    JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -13) {
                    JOptionPane.showMessageDialog(null, "SDK EM USO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -14) {
                    JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -15) {
                    JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -16) {
                    JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -17) {
                    JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -18) {
                    JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -21) {
                    JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -22) {
                    JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -23) {
                    JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -24) {
                    JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -25) {
                    JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -26) {
                    JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -27) {
                    JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -28) {
                    JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -29) {
                    JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
                    return;
                }
                d.setBiometriaDedo1(pDigitalCap);
                d.setBiometriaDedo2(pDigitalCap);
                d.setBiometriaDedo3(pDigitalCap);
                d.setBiometriaDedo4(pDigitalCap);
            } catch (Exception e) {
            }
        }
    ;

    };            
 
 //---------------------------------------------------------------------
     
     public void Novo() {
        jIdInternoKitBio.setText("");
        jNomeInternoKitBio.setText("");
        jRegimeKitBio.setText("");
        jPavilhaoKitBio.setText("");
        jCelaKitBio.setText("");
        //
        jDataEntrega.setCalendar(Calendar.getInstance());
        jHorarioPagto.setText(jHoraSistema.getText());
        //
        jDataEntrega.setEnabled(true);
        jHorarioPagto.setEnabled(true);
        jCheckBoxMarcaTodos.setEnabled(true);        
        jCheckBoxKitQuinzenal.setEnabled(true);
        jCheckBoxMensal.setEnabled(true);
        jCheckBoxKitAnual.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtIniciarLeitor.setEnabled(true);
        //
        jCheckBoxMarcaTodos.setEnabled(true);
        jCheckBoxDecimal.setEnabled(true);
        jCheckBoxKitQuinzenal.setEnabled(true);
        jCheckBoxSemestral.setEnabled(true);
        jCheckBoxKitAnual.setEnabled(true);        
    }

    public void Salvar() {
        jIdInternoKitBio.setText("");
        jNomeInternoKitBio.setText("");
        jMatriculaPenalKitBio.setText("");
        jFotoInternoKitBio.setIcon(null);
        jRegimeKitBio.setText("");
        jPavilhaoKitBio.setText("");
        jCelaKitBio.setText("");
        jDataEntrega.setDate(null);
        jHorarioPagto.setText("");
        //
        jCheckBoxMarcaTodos.setSelected(!true);
        jCheckBoxDecimal.setSelected(!true);
        jCheckBoxKitQuinzenal.setSelected(!true);
        jCheckBoxSemestral.setSelected(!true);
        jCheckBoxMensal.setEnabled(!true);
        jCheckBoxKitAnual.setSelected(!true);
        //
        jDataEntrega.setEnabled(!true);
        jHorarioPagto.setEnabled(!true);
        //
        jCheckBoxMarcaTodos.setEnabled(!true);
        jCheckBoxDecimal.setEnabled(!true);
        jCheckBoxKitQuinzenal.setEnabled(!true);
        jCheckBoxSemestral.setEnabled(!true);
        jCheckBoxKitAnual.setEnabled(!true); 
        //
        jBtSalvar.setEnabled(!true);
        jBtIniciarLeitor.setEnabled(true);
    }

    public void verificarInternos() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "WHERE IdInternoCrc='" + jIdInternoKitBio.getText() + "'AND IdPagto='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getString("IdInternoCrc");
            codigoKit = conecta.rs.getString("IdPagto");
        } catch (Exception e) {
        }
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

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
