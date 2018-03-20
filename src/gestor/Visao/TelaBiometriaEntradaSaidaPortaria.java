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
import gestor.Controle.ControleItensLocacaoInternos;
import gestor.Controle.ControleItensPrevisaoSaida;
import gestor.Controle.ControleItensRegSaidaInternos;
import gestor.Controle.ControleItensTransfInterno;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovInternos;
import static gestor.Controle.ControleItensRegSaidaInternos.qtdInternos;
import gestor.Controle.ControleRegistroSaida;
import gestor.Controle.ControleRolVisitas;
import gestor.Controle.ControleSituacao;
import gestor.Controle.DigitalInternos;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.DocumentosInternos;
import gestor.Modelo.ItensLocacaoInternos;
import gestor.Modelo.ItensPrevisaoSaida;
import gestor.Modelo.ItensRegSaidaInternos;
import gestor.Modelo.ItensTransInterno;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProntuarioCrc;
import gestor.Modelo.RegistroSaidaPortaria;
import gestor.Modelo.RolVisitas;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaRegistroSaidaInternosPortaria.jDestinoInterno;
import static gestor.Visao.TelaRegistroSaidaInternosPortaria.jIDlanc;
import static gestor.Visao.TelaRegistroSaidaInternosPortaria.jNrDocumento;
import static gestor.Visao.TelaRegistroSaidaInternosPortaria.jTabelaItensInterno;
import static gestor.Visao.TelaRegistroSaidaInternosPortaria.totalRegistrosInternos;
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
public class TelaBiometriaEntradaSaidaPortaria extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroSaidaPortaria objSaida = new RegistroSaidaPortaria();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    ControleRegistroSaida control = new ControleRegistroSaida();
    ItensRegSaidaInternos objItemSaida = new ItensRegSaidaInternos();
    ControleItensRegSaidaInternos controle = new ControleItensRegSaidaInternos();
    DocumentosInternos objDocInternos = new DocumentosInternos(); // Classe para verificar documentos do interno
    ControleMovInternos controlMov = new ControleMovInternos();  // HISTÓRICO DE MOVIMENTAÇÃO DE SAIDA NO CRC
    ControleItensTransfInterno controleTransf = new ControleItensTransfInterno(); // Classe para que atualiza como utilizado o documento do interno
    ItensTransInterno objItensTrans = new ItensTransInterno(); // Dados dos itens do internos TRANSFRÊNCIA 
    //
    ControleRolVisitas controlRol = new ControleRolVisitas(); // Classe do Serviço social para FINALIZAR Rol quando interno sair da unidade
    RolVisitas objRol = new RolVisitas();
    // Excluir interno quando o mesmo sair da unidade, quando não for para saida audiência
    ControleItensLocacaoInternos excluirInternoCela = new ControleItensLocacaoInternos(); // Excluir Cela do Interno na saida
    ItensLocacaoInternos objItensLoca = new ItensLocacaoInternos();
    // Confirma a saida do interno na portaria na tabela ITENSPREVSAIDA   
    ItensPrevisaoSaida objItensPreSaida = new ItensPrevisaoSaida();
    ControleItensPrevisaoSaida controlePrevSaida = new ControleItensPrevisaoSaida();
    ControleSituacao mod = new ControleSituacao(); // MODIFICA A SITUAÇAO DO INTERNO NO PRONTUARIO.    
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Portaria:Saída/Entrada de Internos:Biometria";
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
    String codigoInterno = "";
    //
    String tipo = "Saídas";
    String situacao = "SAIDA TEMPORARIA"; // Máximo 19 caracteres
    String saidaAudiencia = "SAIDA PARA AUDIENCIA";
    String saidaMedico = "SAIDA PARA MEDICO";
    String saidaOutras = "OUTRAS SAIDAS";
    String saidaTemporaria = "SAIDA TEMPORARIA"; // MODIFICADO EM 08/07/2016 TORNOU-SE PADRÃO DA SECRETARIA
    String confirmaRegSaida; // Variavel Confirma a saida nas tabelas ITENSSAIDA E ITENSREGSAIDA
    String statusRol = "ABERTO"; // Se o Rol estiver ABERTO, irá ser FINALIZADO para não ser mostrado na lista do Rol na portaria
    String statusRolFechado = "FINALIZADO"; // Se o Rol estiver fechado e o usuário excluir, o Rol volta a ser ABERTO
    String observacaoRol; // Varivael que irá informar no Rol do Interno se ele está na unidade
    int idInternoRol; // Código do interno no Rol de Visitas.
    String dataSaida = "";
    int count = 0;
    String codInternoCela = "";
    String codigoRegSaida = "";
    String idItem = "";
    public static String idItemSaidaPort = ""; // Item da tabela de ITENS DE SAIDA (ITENSSAIDA)
    public static int idItemCrcPortSai = 0; // Item da tabela ITENSCRCPORTARIA

    /**
     * Creates new form TelaBiometriaKitInterno
     */
    public static TelaRegistroSaidaInternosPortaria saidaEntradaPortaria;

    public TelaBiometriaEntradaSaidaPortaria(TelaRegistroSaidaInternosPortaria parent, boolean modal) {
        this.saidaEntradaPortaria = parent;
        this.setModal(modal);
        setLocationRelativeTo(saidaEntradaPortaria);
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
        jDataSaida = new com.toedter.calendar.JDateChooser();
        jHorarioSaidaEntrada = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxTipoMovimentacao = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jBtSalvar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtIniciarLeitor = new javax.swing.JButton();
        jBtCancelarLeitura = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jFotoInternoKitBio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Registro de Saída/Entrada de Internos {Biometria} :::...");

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
        jLabel7.setText("Data Mov.");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Horário");

        jDataSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataSaida.setEnabled(false);

        jHorarioSaidaEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioSaidaEntrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioSaidaEntrada.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Tipo Movimentação");

        jComboBoxTipoMovimentacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoMovimentacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Saída Temporária", " ", " " }));
        jComboBoxTipoMovimentacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoMovimentacao.setEnabled(false);

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
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jComboBoxTipoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jHorarioSaidaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxTipoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioSaidaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jBtIniciarLeitor.setForeground(new java.awt.Color(0, 153, 0));
        jBtIniciarLeitor.setText("Iniciar Leitor Digital");
        jBtIniciarLeitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIniciarLeitorActionPerformed(evt);
            }
        });

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
            .addComponent(jFotoInternoKitBio, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtIniciarLeitor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtCancelarLeitura)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtSair, jBtSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtSair, jBtSalvar});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtCancelarLeitura, jBtIniciarLeitor});

        setSize(new java.awt.Dimension(646, 364));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        confirmaRegSaida = "Sim"; // Variavel que confirma a saida do interno na portaria.    
        verificarInternos();
        if (jIdInternoKitBio.getText().equals("") || jNomeInternoKitBio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o nome do interno.");
        } else if (jDataSaida.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Informe a data do tipo de movimento.");
        } else if (jHorarioSaidaEntrada.getText().equals("") || jHorarioSaidaEntrada.getText().equals("00:00")) {
            JOptionPane.showMessageDialog(null, "Informe o horário do movimento.");
        } else {
            objItemSaida.setIdInternoSaida(Integer.valueOf(jIdInternoKitBio.getText()));
            objItemSaida.setNomeInterno(jNomeInternoKitBio.getText());
            objItemSaida.setDataSaida(jDataSaida.getDate());
            objItemSaida.setDocumento(jNrDocumento.getText());
            objItemSaida.setNomeDestino(situacao);
            objItemSaida.setHorarioSaida(jHorarioSaidaEntrada.getText());
            objItemSaida.setIdItemRegSaida(idItemSaidaPort); // Iditem da tabela de ITENSSAIDA    
            objItemSaida.setAssinaturaDigital(pDigitalCapturada);
            // SAÍDA DO INTERNO NA UNIDADE.           
            if (jIdInternoKitBio.getText().equals(codigoInterno) && jIDlanc.getText().equals(codigoRegSaida)) {
                JOptionPane.showMessageDialog(rootPane, "Já foi lançado a saída desse interno.");
            } else {
                // Para o log do registro
                objItemSaida.setUsuarioInsert(nameUser);
                objItemSaida.setDataInsert(dataModFinal);
                objItemSaida.setHoraInsert(horaMov);
                //Incluir itens (INTERNOS)                                                                
                objItemSaida.setConfirmaSaida(confirmaRegSaida);
                objItemSaida.setIdSaida((Integer.valueOf(jIDlanc.getText())));
                objItemSaida.setIdItemCrcPortaria(idItemCrcPortSai); // Item da tabela ITENSCRCPORTARIA                               
                controle.incluirItensRegSaida(objItemSaida); // Gravar registro na tabela de itens ITENSREGSAIDA                                
                objItemSaida.setIdItemSaida(idItemSaidaPort); // Item do documento de saida (ITENSSAIDA)                                                                  
                // Confirma "Sim" na tabela ITENSSAIDA para impedir a exclusão ou alteração do interno  
                objItemSaida.setIdInternoSaida(Integer.valueOf(jIdInternoKitBio.getText()));
                objItemSaida.setConfirmaSaida(confirmaRegSaida);
                objItemSaida.setHorarioSaida(jHorarioSaidaEntrada.getText());
                controle.confirmaRegistroSaida(objItemSaida); // Modifica na tabela ITENSSAIDA (confirma a saida) do interno.                                                              
                // Confirma "Sim" no arquivo intermediario ITENSCRCPORTARIA para não pesquisar novamente o interno
                objItemSaida.setIdItemCrcPortaria(idItemCrcPortSai); // Item da tabela ITENSCRCPORTARIA
                objItemSaida.setIdItemSaida(idItemSaidaPort); // Item referente a saída vinda do CRC para Portaria
                objItemSaida.setIdInternoSaida(Integer.valueOf(jIdInternoKitBio.getText())); // Id do interno - São 3 variaveis
                controle.confirmaRegSaidaItensCrcPort(objItemSaida);
                // Confirmar "Sim" na tabela de ITENSTRANSFERENCIA para para impedir exclusão ou alterarção do interno
//                objItensTrans.setIdItemTrans(idItemCrcPort); // Item do documento de saida (ITENSSAIDA)
//                objItensTrans.setConfirmaSaida(confirmaRegSaida);;
//                controle.confirmaRegistroTransferencia(objItensTrans); // Tabela ITENSTRANSFERENCIA
                // Bloquear interno no Rol (FINALIZAR)
                objItemSaida.setIdSaida((Integer.valueOf(jIDlanc.getText())));
                atualizarRolSaidaInterno();
                //Atualiza como "Sim" a utilização do interno na previsão de saida campo "ConfirmaUtilizacao" tabela ITENSPREVSAIDA
                objItensPreSaida.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio.getText()));
                objItensPreSaida.setBeneficio(situacao);
                objItensPreSaida.setConfirmaSaida(confirmaRegSaida);
                controlePrevSaida.atualizaConfirmacaoSaidaPortaria(objItensPreSaida); // Tabela ITENSPREVISAOSAIDA
                objProCrc.setIdInterno(Integer.valueOf(jIdInternoKitBio.getText()));
                objItensPreSaida.setBeneficio(situacao);
                // Se a saida não for para AUDIENCIA, SAIDA PARA MÉDICO E OUTRAS SAIDAS, excluir da cela CONSERTADO EM 07/08/2015
                // SAIDA TEMPORARIA TAMBÉM NÃO RETIRAR DA CELA. SÓ RETIRAR APÓS O PRAZO DE VENCIDO, NA EVASÃO - 08/07/2016 
                verificarInternoCela(); // 
                if (!situacao.equals(saidaTemporaria)) {
                    // RETIRAR DA POPULAÇÃO, MODIFICADO EM 11/07/2016
                    objProCrc.setIdInterno(Integer.valueOf(jIdInternoKitBio.getText()));
                    objProCrc.setSituacao(situacao);
                    mod.alterarSituacaoInterno(objProCrc);
                    // EXCLUIR O INTERNO DA CELA NO MOMENTO DA SAIDA NA PORTARIA.
                    objItensLoca.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio.getText()));
                    excluirInternoCela.deletarInternoLocacaoSaida(objItensLoca);
                }
                // SE FOR SAIDA TEMPORARIA, MODIFICAR "SituacaoCrc" E NÃO RETIRAR DA CELA (09/08/2016)
                if (situacao.equals(saidaTemporaria)) {
                    objProCrc.setIdInterno(Integer.valueOf(jIdInternoKitBio.getText()));
                    objProCrc.setSituacao(situacao);
                    mod.alterarSituacaoInterno(objProCrc);
                }
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                Salvar();
                preencherTabelaItens("SELECT * FROM ITENSREGSAIDA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSREGSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdSaida='" + jIDlanc.getText() + "'");
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
            java.util.logging.Logger.getLogger(TelaBiometriaEntradaSaidaPortaria.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBiometriaEntradaSaidaPortaria.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBiometriaEntradaSaidaPortaria.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBiometriaEntradaSaidaPortaria.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaBiometriaEntradaSaidaPortaria dialog = new TelaBiometriaEntradaSaidaPortaria(saidaEntradaPortaria, true);
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
    private javax.swing.JComboBox jComboBoxTipoMovimentacao;
    private com.toedter.calendar.JDateChooser jDataSaida;
    public static javax.swing.JLabel jFotoInternoKitBio;
    private javax.swing.JFormattedTextField jHorarioSaidaEntrada;
    public static javax.swing.JTextField jIdInternoKitBio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
                ControleItensRegSaidaInternos digiControlSaida = new ControleItensRegSaidaInternos();
                DigitalInternos d = new DigitalInternos();
                int pVar = 0;
                for (DigitalInternos dd : digiControlSaida.read()) {
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
                        idItemSaidaPort = dd.getIdItemSaida();
                        idItemCrcPortSai = dd.getIdItemCrcPort();
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
                        idItemSaidaPort = dd.getIdItemSaida();
                        idItemCrcPortSai = dd.getIdItemCrcPort();
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
                        idItemSaidaPort = dd.getIdItemSaida();
                        idItemCrcPortSai = dd.getIdItemCrcPort();
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
                        idItemSaidaPort = dd.getIdItemSaida();
                        idItemCrcPortSai = dd.getIdItemCrcPort();
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
        jDataSaida.setCalendar(Calendar.getInstance());
        jHorarioSaidaEntrada.setText(jHoraSistema.getText());
        //
        jDataSaida.setEnabled(true);
        jHorarioSaidaEntrada.setEnabled(true);
        jComboBoxTipoMovimentacao.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtIniciarLeitor.setEnabled(true);
    }

    public void Salvar() {
        jIdInternoKitBio.setText("");
        jNomeInternoKitBio.setText("");
        jMatriculaPenalKitBio.setText("");
        jFotoInternoKitBio.setIcon(null);
        jRegimeKitBio.setText("");
        jPavilhaoKitBio.setText("");
        jCelaKitBio.setText("");
        jDataSaida.setDate(null);
        jHorarioSaidaEntrada.setText("");
        //
        jDataSaida.setEnabled(!true);
        jHorarioSaidaEntrada.setEnabled(!true);
        jComboBoxTipoMovimentacao.setEnabled(!true);
        //
        jBtSalvar.setEnabled(!true);
        jBtIniciarLeitor.setEnabled(true);
    }

    public void verificarInternos() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSREGSAIDA "
                    + "WHERE IdInternoCrc='" + jIdInternoKitBio.getText() + "'AND IdSaida='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getString("IdInternoCrc");
            codigoRegSaida = conecta.rs.getString("IdSaida");
            idItem = conecta.rs.getString("IdItem");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherTabelaItens(String sql) {
        count = 0;
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Seq.", "Nome do Interno ", "Data Saida", "Destino", "Documento "};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataSaida = conecta.rs.getString("DataSaida");
                String dia = dataSaida.substring(8, 10);
                String mes = dataSaida.substring(5, 7);
                String ano = dataSaida.substring(0, 4);
                dataSaida = dia + "/" + mes + "/" + ano;
                totalRegistrosInternos.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getString("NomeInternoCrc"), dataSaida, conecta.rs.getString("DestinoSaida"), conecta.rs.getString("DocumentoSaida")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensInterno.setModel(modelo);
        jTabelaItensInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaItensInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaItensInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaItensInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(3).setPreferredWidth(170);
        jTabelaItensInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaItensInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaItensInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaItensInterno.setAutoResizeMode(jTabelaItensInterno.AUTO_RESIZE_OFF);
        jTabelaItensInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaitens();
        conecta.desconecta();
    }

    public void alinharCamposTabelaitens() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaItensInterno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaItensInterno.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaItensInterno.getColumnModel().getColumn(4).setCellRenderer(direita);
    }
// FINALIZA o Rol do interno quando o mesmo sair da unidade

    public void atualizarRolSaidaInterno() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ROLVISITAS WHERE IdInternoCrc='" + jIdInternoKitBio.getText() + "'AND StatusRol='" + statusRol + "'");
            conecta.rs.first();
            idInternoRol = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
        }
        statusRol = "FINALIZADO";
        objRol.setIdInterno(Integer.valueOf(jIdInternoKitBio.getText()));
        objRol.setStatusRol(statusRol);
        objRol.setObsRol(jDestinoInterno.getText());
        objRol.setUsuarioUp(nameUser);
        objRol.setDataUp(jDataSistema.getText());
        objRol.setHoraUp(horaMov);
        controlRol.finalizarRolVisitasPortaria(objRol);
        conecta.desconecta();
    }

    // Se o usuário excluir o interno da saida da portaria, atualiza o status do Rol para ABERTO
    public void atualizarRolSaidaInternoExcluir() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ROLVISITAS WHERE IdInternoCrc='" + jIdInternoKitBio.getText() + "'AND StatusRol='" + statusRolFechado + "'");
            conecta.rs.first();
            idInternoRol = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
        }
        statusRol = "ABERTO";
        objRol.setIdInterno(Integer.valueOf(jIdInternoKitBio.getText()));
        objRol.setStatusRol(statusRol);
        objRol.setObsRol("");
        objRol.setUsuarioUp(nameUser);
        objRol.setDataUp(jDataSistema.getText());
        objRol.setHoraUp(horaMov);
        controlRol.finalizarRolVisitasPortaria(objRol);
        conecta.desconecta();
    }

    public void verificarInternoCela() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSLOCACAOINTERNO WHERE IdInternoCrc='" + jIdInternoKitBio.getText() + "'");
            conecta.rs.first();
            codInternoCela = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIDlanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
