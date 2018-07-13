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
import gestor.Controle.ControleAlertasPortariaPavilhoes;
import gestor.Controle.ControleEntradaSaidaVisitasInternos;
import gestor.Controle.ControleItensEntradaSaidaVisitasInternos;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleVisitaInterno;
import static gestor.Controle.ControleVisitaInterno.count;
import static gestor.Controle.ControleVisitaInterno.qtdVisitas;
import gestor.Controle.ControleVisitasFamiliarInternos;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.AlertaVisitasPortariaPavilhoes;
import gestor.Modelo.Digital;
import gestor.Modelo.EntradaSaidaVisitasInternos;
import gestor.Modelo.ItensEntradaSaidaVisitasInternos;
import gestor.Modelo.LogSistema;
import gestor.Modelo.VisitaInterno;
import static gestor.Visao.TelaEntradaSaidaVisitasInternos.jIDlanc;
import static gestor.Visao.TelaEntradaSaidaVisitasInternos.jTabelaVisitasInternos;
import static gestor.Visao.TelaEntradaSaidaVisitasInternos.jtotalItens;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
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
 * @author Ronaldo
 */
public class TelaAcessoBiometria extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    VisitaInterno objVisita = new VisitaInterno();
    EntradaSaidaVisitasInternos objEntSaiVisitasInterno = new EntradaSaidaVisitasInternos();
    ControleEntradaSaidaVisitasInternos control = new ControleEntradaSaidaVisitasInternos();
    //
    ItensEntradaSaidaVisitasInternos objItensVisitaInternos = new ItensEntradaSaidaVisitasInternos();
    ControleItensEntradaSaidaVisitasInternos controle = new ControleItensEntradaSaidaVisitasInternos();
    //
    ControleVisitasFamiliarInternos objControl = new ControleVisitasFamiliarInternos();
    //
    AlertaVisitasPortariaPavilhoes objAlertaPortPav = new AlertaVisitasPortariaPavilhoes();
    ControleAlertasPortariaPavilhoes controleOFPortPav = new ControleAlertasPortariaPavilhoes();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela2 = "Portaria:Entrada/Saida Visitas de Internos:Biometria";
    String statusMov;
    String horaMov;
    String dataModFinal;
    int acao;
    int flag;
    int count1;
    // VARIVAEL PARA ARMAZENAR AS DIGITAIS DO BANCO DE DADOS
    String caminhoBiometria = "";
    String caminhoBiometria1 = "";
    String caminhoBiometria2 = "";
    String caminhoBiometria3 = "";
    // PARA GRAVAR NO BANCO DE DADOS
    public static byte[] pDigitalCapturada = null;
    public static byte[] imagemFreteVisitaVI = null;
    // PESQUISA PARA TRAZER AS VISITAS ATIVAS E COM BIOMETRIA CADASTRADA   
    String pVisita = "";
    String statusVisita = "Ativo";
    // VERIFICAR SE O INTERNO E A VISITA JÁ EXISTEM, IMPEDINDO DE GRAVAR DUPLICIDADE
    String codigoInternoGrava = "";
    String codigoVisitaGrava = "";
    String codigoRegistroGrava = "";
    // VARIVAIES DE DATA DE ENTRADA E SAIDA DA VISITA
    String dataEntrada;
    String dataSaida;
    // CAMINHO DAS FOTOS DE INTERNOS E VISITAS
    public static String caminhoFotoVisita;
    public static String caminhoFotoInterno;
    String horarioSaidaBio = "00:00";
    byte[] assinaturaVisita;
    int codigoItem = 0;
    String tipoOperacao = "Entrada/Saida";
    //
    public static int codigoPavilhao = 0; // CÓDIGO DO PAVILHÃO
    String confirmacaoUso = "Não"; // VARIAVEL QUE CONTROLA SE O PAVILHAO CONFIRMOU O REGISTRO

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

    //
    /**
     * Creates new form TelaAcessoBiometria
     */
    public static TelaEntradaSaidaVisitasInternos entradaSaidaBiometria;

    public TelaAcessoBiometria(TelaEntradaSaidaVisitasInternos parent, boolean modal) {
        this.entradaSaidaBiometria = parent;
        this.setModal(modal);
        setLocationRelativeTo(entradaSaidaBiometria);
        initComponents();
        corCampos();
        verificarVisitasBiometrica();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jIdInternoBio = new javax.swing.JTextField();
        jNomeInternoBio = new javax.swing.JTextField();
        jRegimePenal = new javax.swing.JTextField();
        jPavilhao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCodigoVisita = new javax.swing.JTextField();
        jGrauParentesco = new javax.swing.JTextField();
        jNomeVisitante = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jDataEntrada = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jHorarioEntrada = new javax.swing.JFormattedTextField();
        jIdRol = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxTipoOperacao = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jBtSalvar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jBtIniciarLeitor = new javax.swing.JButton();
        jBtCancelarLeitura = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jFotoVisita = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Controle de Acesso Visitas Biometrico :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome Completo do Interno");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Regime");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Pavilhão");

        jIdInternoBio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoBio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdInternoBio.setEnabled(false);

        jNomeInternoBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoBio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeInternoBio.setEnabled(false);

        jRegimePenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegimePenal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jRegimePenal.setEnabled(false);

        jPavilhao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPavilhao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPavilhao.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Código");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Grau de Parentesco");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nome do Visitante");

        jCodigoVisita.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoVisita.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCodigoVisita.setEnabled(false);

        jGrauParentesco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jGrauParentesco.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jGrauParentesco.setEnabled(false);

        jNomeVisitante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeVisitante.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeVisitante.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jRegimePenal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdInternoBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jNomeInternoBio)))
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jCodigoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jGrauParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jNomeVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdInternoBio, jRegimePenal});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jGrauParentesco, jNomeInternoBio, jPavilhao});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jIdInternoBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInternoBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRegimePenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCodigoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGrauParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Data Entrada/Saída:");

        jDataEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Horário:");

        jHorarioEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioEntrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jIdRol.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRol.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdRol.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Rol:");

        jComboBoxTipoOperacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoOperacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entrada", "Saída" }));
        jComboBoxTipoOperacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Tipo Operação:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipoOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/filesave.png"))); // NOI18N
        jBtSalvar.setToolTipText("Gravar");
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-32.png"))); // NOI18N
        jBtSair.setToolTipText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtIniciarLeitor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtIniciarLeitor.setForeground(new java.awt.Color(0, 204, 153));
        jBtIniciarLeitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16.png"))); // NOI18N
        jBtIniciarLeitor.setText("Iniciar Leitor Digital");
        jBtIniciarLeitor.setToolTipText("Iniciar Leitura Biometrica");
        jBtIniciarLeitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIniciarLeitorActionPerformed(evt);
            }
        });

        jBtCancelarLeitura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtCancelarLeitura.setForeground(new java.awt.Color(255, 0, 0));
        jBtCancelarLeitura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16Vermelho.png"))); // NOI18N
        jBtCancelarLeitura.setText("Cancelar Leitura");
        jBtCancelarLeitura.setToolTipText("Cancelar Leitura");
        jBtCancelarLeitura.setEnabled(false);
        jBtCancelarLeitura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarLeituraActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto Visitante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jFotoVisita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jFotoVisita, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoVisita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jBtIniciarLeitor)
                            .addGap(308, 308, 308)
                            .addComponent(jBtCancelarLeitura))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtCancelarLeitura, jBtIniciarLeitor});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtSair, jBtSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtSair)
                            .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtIniciarLeitor)
                    .addComponent(jBtCancelarLeitura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtCancelarLeitura, jBtIniciarLeitor});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtSair, jBtSalvar});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        verificarInternoVisitaCadastrado();
        if (jIdInternoBio.getText().equals("") || jNomeInternoBio.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Interno não informado...");
        } else if (jCodigoVisita.equals("") || jNomeVisitante.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Visitante não informado...");
        } else if (jDataEntrada.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data de entrada da visita na unidade.");
        } else if (jHorarioEntrada.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o horário de entrada da visita na unidade.");
        } else {
            objItensVisitaInternos.setIdInternoCrc(Integer.valueOf(jIdInternoBio.getText()));
            objItensVisitaInternos.setNomeInternosCrc(jNomeInternoBio.getText());
            objItensVisitaInternos.setIdVisita(Integer.valueOf(jCodigoVisita.getText()));
            objItensVisitaInternos.setNomeVisita(jNomeVisitante.getText());
            objItensVisitaInternos.setDataEntrada(jDataEntrada.getDate());
            objItensVisitaInternos.setHorarioEntrada(jHorarioEntrada.getText());
            objItensVisitaInternos.setDataSaida(jDataEntrada.getDate());
            objItensVisitaInternos.setHorarioSaida(horarioSaidaBio);
            objItensVisitaInternos.setIdlanc(Integer.valueOf(jIDlanc.getText()));
            objItensVisitaInternos.setIdRol(Integer.valueOf(jIdRol.getText()));
            objItensVisitaInternos.setTipoOperacao(tipoOperacao);
            if (jIdInternoBio.getText().equals(codigoInternoGrava) && jCodigoVisita.getText().equals(codigoVisitaGrava) && jIDlanc.getText().equals(codigoRegistroGrava) && jComboBoxTipoOperacao.getSelectedItem().equals("Entrada")) {
                JOptionPane.showMessageDialog(rootPane, "Essa visita já está dentro da unidade.");
            } else if (!jIdInternoBio.getText().equals(codigoInternoGrava) && !jCodigoVisita.getText().equals(codigoVisitaGrava) && !jIDlanc.getText().equals(codigoRegistroGrava) && jComboBoxTipoOperacao.getSelectedItem().equals("Entrada")) {
                objItensVisitaInternos.setDataEntrada(jDataEntrada.getDate());
                objItensVisitaInternos.setHorarioEntrada(jHorarioEntrada.getText());
                objItensVisitaInternos.setHorarioSaida(horarioSaidaBio);
                objItensVisitaInternos.setAssinaturaEntradaVisita(pDigitalCapturada);
                // Para o log do registro
                objItensVisitaInternos.setUsuarioInsert(nameUser);
                objItensVisitaInternos.setDataInsert(dataModFinal);
                objItensVisitaInternos.setHoraInsert(horaMov);
                //
                controle.incluirItensVisitasInternos(objItensVisitaInternos);
                objControl.incluirInternoVisita(objItensVisitaInternos);
                // INCLUIR REGISTROS DE ALERTA PARA PORTARIA DE ACORDO COM O PARÂMETRO (HABILITADO - DESABILITADO)
                objAlertaPortPav.setIdInternoCrc(Integer.valueOf(jIdInternoBio.getText()));
                objAlertaPortPav.setNomeInternoCrc(jNomeInternoBio.getText());
                objAlertaPortPav.setIdRegistroVI(Integer.valueOf(jIDlanc.getText()));
                objAlertaPortPav.setIdVisita(Integer.valueOf(jCodigoVisita.getText()));
                objAlertaPortPav.setDataChegada(jDataEntrada.getDate());
                objAlertaPortPav.setHoraChegada(jHorarioEntrada.getText());
                objAlertaPortPav.setConfirmacao(confirmacaoUso);
                objAlertaPortPav.setIdPav(codigoPavilhao);
                objAlertaPortPav.setDescricaoPavilhao(jPavilhao.getText());
                // USUARIO NA PORTARIA QUE FEZ O LANÇAMENTO DO REGISTRO
                objAlertaPortPav.setUsuarioInsert(nameUser);
                objAlertaPortPav.setDataInsert(dataModFinal);
                objAlertaPortPav.setHorarioInsert(horaMov);
                controleOFPortPav.incluirAcessoVisitaInternoPortariaPavilhoes(objAlertaPortPav);
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                Salvar();
                preencherTabelaItens("SELECT * FROM ITENSFAMILIAR "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON ITENSFAMILIAR.IdVisita=VISITASINTERNO.IdVisita "
                        + "WHERE IdLanc='" + jIDlanc.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            } else if (jIdInternoBio.getText().equals(codigoInternoGrava) && jCodigoVisita.getText().equals(codigoVisitaGrava) && jIDlanc.getText().equals(codigoRegistroGrava) && jComboBoxTipoOperacao.getSelectedItem().equals("Saída")) {
                objItensVisitaInternos.setDataSaida(jDataEntrada.getDate());
                objItensVisitaInternos.setHorarioSaida(jHorarioEntrada.getText());
                objItensVisitaInternos.setAssinaturaSaidaVisita(pDigitalCapturada);
                // Para o log do registro
                objItensVisitaInternos.setUsuarioUp(nameUser);
                objItensVisitaInternos.setDataUp(dataModFinal);
                objItensVisitaInternos.setHoraUp(horaMov);
                //
                objItensVisitaInternos.setIdItem(codigoItem);
                controle.alterarItensVisitasInternoBio(objItensVisitaInternos);
                objControl.incluirInternoVisita(objItensVisitaInternos);
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                Salvar();
                preencherTabelaItens("SELECT * FROM ITENSFAMILIAR "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON ITENSFAMILIAR.IdVisita=VISITASINTERNO.IdVisita "
                        + "WHERE IdLanc='" + jIDlanc.getText() + "'");
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
            java.util.logging.Logger.getLogger(TelaAcessoBiometria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAcessoBiometria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAcessoBiometria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAcessoBiometria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAcessoBiometria dialog = new TelaAcessoBiometria(entradaSaidaBiometria, true);
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
    public static javax.swing.JTextField jCodigoVisita;
    private javax.swing.JComboBox jComboBoxTipoOperacao;
    private com.toedter.calendar.JDateChooser jDataEntrada;
    public static javax.swing.JLabel jFotoVisita;
    public static javax.swing.JTextField jGrauParentesco;
    private javax.swing.JFormattedTextField jHorarioEntrada;
    public static javax.swing.JTextField jIdInternoBio;
    public static javax.swing.JTextField jIdRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jNomeInternoBio;
    public static javax.swing.JTextField jNomeVisitante;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JTextField jPavilhao;
    public static javax.swing.JTextField jRegimePenal;
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
                pDigitalCapturada = pDigitalCap; // SALVAR DIGITAL NO BANCO DE DADOS - ANALISANDO
                //
                ControleVisitaInterno digiControl = new ControleVisitaInterno();
                Digital d = new Digital();
                int pVar = 0;
                for (Digital dd : digiControl.read()) {
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
                    // VERIFICAR SE A DIGITAL É IGUAL AO DEDO UM                  
                    if (iRetorno == 1) {
                        jIdRol.setText(String.valueOf(dd.getIdRol()));
                        jIdInternoBio.setText(String.valueOf(dd.getIdInternoCrc()));
                        jNomeInternoBio.setText(dd.getNomeInternoCrc());
                        jRegimePenal.setText(dd.getRegime());
                        codigoPavilhao = dd.getIdPav();
                        jPavilhao.setText(dd.getPavilhao());
                        jCodigoVisita.setText(String.valueOf(dd.getIdVisita()));
                        caminhoFotoVisita = dd.getCaminhoFotoVisita();
                        if (caminhoFotoVisita != null) {
                            javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoVisita);
                            jFotoVisita.setIcon(a);
                            jFotoVisita.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT)));
                        }
                        // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                        imagemFreteVisitaVI = dd.getImagemFrenteVI();
                        if (imagemFreteVisitaVI != null) {
                            ImageIcon pic = null;
                            pic = new ImageIcon(imagemFreteVisitaVI);
                            Image scaled = pic.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT);
                            ImageIcon icon = new ImageIcon(scaled);
                            jFotoVisita.setIcon(icon);
                        }
                        jGrauParentesco.setText(dd.getGrauParentesco());
                        jNomeVisitante.setText(dd.getNomeVisita());
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                        // VERIFICAR SE A DIGITAL É IGUAL AO DEDO DOIS
                    } else if (iRetornod1 == 1) {
                        jIdRol.setText(String.valueOf(dd.getIdRol()));
                        jIdInternoBio.setText(String.valueOf(dd.getIdInternoCrc()));
                        jNomeInternoBio.setText(dd.getNomeInternoCrc());
                        jRegimePenal.setText(dd.getRegime());
                        codigoPavilhao = dd.getIdPav();
                        jPavilhao.setText(dd.getPavilhao());
                        jCodigoVisita.setText(String.valueOf(dd.getIdVisita()));
                        caminhoFotoVisita = dd.getCaminhoFotoVisita();
                        if (caminhoFotoVisita != null) {
                            javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoVisita);
                            jFotoVisita.setIcon(a);
                            jFotoVisita.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT)));
                        }
                        // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                        imagemFreteVisitaVI = dd.getImagemFrenteVI();
                        if (imagemFreteVisitaVI != null) {
                            ImageIcon pic = null;
                            pic = new ImageIcon(imagemFreteVisitaVI);
                            Image scaled = pic.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT);
                            ImageIcon icon = new ImageIcon(scaled);
                            jFotoVisita.setIcon(icon);
                        }
                        jGrauParentesco.setText(dd.getGrauParentesco());
                        jNomeVisitante.setText(dd.getNomeVisita());
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                        // VERIFICAR SE A DIGITAL É IGUAL AO DEDO TRÊS
                    } else if (iRetornod2 == 1) {
                        jIdRol.setText(String.valueOf(dd.getIdRol()));
                        jIdInternoBio.setText(String.valueOf(dd.getIdInternoCrc()));
                        jNomeInternoBio.setText(dd.getNomeInternoCrc());
                        jRegimePenal.setText(dd.getRegime());
                        codigoPavilhao = dd.getIdPav();
                        jPavilhao.setText(dd.getPavilhao());
                        jCodigoVisita.setText(String.valueOf(dd.getIdVisita()));
                        caminhoFotoVisita = dd.getCaminhoFotoVisita();
                        javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoVisita);
                        jFotoVisita.setIcon(a);
                        jFotoVisita.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT)));
                        //
                        jGrauParentesco.setText(dd.getGrauParentesco());
                        jNomeVisitante.setText(dd.getNomeVisita());
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                        // VERIFICAR SE A DIGITAL É IGUAL AO DEDO QUATRO
                    } else if (iRetornod3 == 1) {
                        jIdRol.setText(String.valueOf(dd.getIdRol()));
                        jIdInternoBio.setText(String.valueOf(dd.getIdInternoCrc()));
                        jNomeInternoBio.setText(dd.getNomeInternoCrc());
                        jRegimePenal.setText(dd.getRegime());
                        codigoPavilhao = dd.getIdPav();
                        jPavilhao.setText(dd.getPavilhao());
                        jCodigoVisita.setText(String.valueOf(dd.getIdVisita()));
                        caminhoFotoVisita = dd.getCaminhoFotoVisita();
                        if (caminhoFotoVisita != null) {
                            javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoVisita);
                            jFotoVisita.setIcon(a);
                            jFotoVisita.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT)));
                        }
                        // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                        imagemFreteVisitaVI = dd.getImagemFrenteVI();
                        if (imagemFreteVisitaVI != null) {
                            ImageIcon pic = null;
                            pic = new ImageIcon(imagemFreteVisitaVI);
                            Image scaled = pic.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT);
                            ImageIcon icon = new ImageIcon(scaled);
                            jFotoVisita.setIcon(icon);
                        }
                        jGrauParentesco.setText(dd.getGrauParentesco());
                        jNomeVisitante.setText(dd.getNomeVisita());
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                    }
                    // SE TODOS AS DIGITAIS FOREM IGUAL A -2 , DIGITAL NÃO CADASTRADA
                    if (iRetorno == -2 && iRetornod1 == -2 && iRetornod2 == -2 && iRetornod3 == -2 && qtdVisitas == pVar) {
                        break;
                    }
                    pVar = pVar + 1;
                }
                JOptionPane.showMessageDialog(null, "Digital não cadastrada, procure o Serviço Social !!!");
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
    
    // -----------------------------------------------------------------------------
    public void corCampos() {
        jIdRol.setBackground(Color.white);
        jIdInternoBio.setBackground(Color.white);
        jNomeInternoBio.setBackground(Color.white);
        jRegimePenal.setBackground(Color.white);
        jPavilhao.setBackground(Color.white);
        jCodigoVisita.setBackground(Color.white);
        jGrauParentesco.setBackground(Color.white);
        jNomeVisitante.setBackground(Color.white);
        jDataEntrada.setBackground(Color.white);
        jHorarioEntrada.setBackground(Color.white);
    }

    public void Novo() {
        jIdInternoBio.setText("");
        jNomeInternoBio.setText("");
        jRegimePenal.setText("");
        jPavilhao.setText("");
        jCodigoVisita.setText("");
        jFotoVisita.setIcon(null);
        jGrauParentesco.setText("");
        jNomeVisitante.setText("");
        //
        jDataEntrada.setCalendar(Calendar.getInstance());
        jHorarioEntrada.setText(jHoraSistema.getText());
        //
        jComboBoxTipoOperacao.setEnabled(true);
        jDataEntrada.setEnabled(true);
        jHorarioEntrada.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtIniciarLeitor.setEnabled(true);
    }

    public void Salvar() {
        jIdInternoBio.setText("");
        jNomeInternoBio.setText("");
        jRegimePenal.setText("");
        jPavilhao.setText("");
        jCodigoVisita.setText("");
        jNomeVisitante.setText("");
        jGrauParentesco.setText("");
        jFotoVisita.setIcon(null);
        jIdRol.setText("");
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("");
        //
        jIdRol.setEnabled(!true);
        jComboBoxTipoOperacao.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorarioEntrada.setEnabled(!true);
        //
        jBtSalvar.setEnabled(!true);
        jBtIniciarLeitor.setEnabled(true);
    }

    public void Cancelar() {
        jIdInternoBio.setText("");
        jNomeInternoBio.setText("");
        jRegimePenal.setText("");
        jPavilhao.setText("");
        jCodigoVisita.setText("");
        jNomeVisitante.setText("");
        jGrauParentesco.setText("");
        jFotoVisita.setIcon(null);
        jIdRol.setText("");
        jDataEntrada.setDate(null);
        jHorarioEntrada.setText("");
        //
        jBtSalvar.setEnabled(!true);
        jBtIniciarLeitor.setEnabled(!true);
    }

    public void verificarVisitasBiometrica() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASINTERNO "
                    + "WHERE BiometriaDedo1!='" + pVisita + "' "
                    + "AND StatusVisita='" + statusVisita + "'");
            count = count + 1;
            do {
            } while (conecta.rs.next());
        } catch (Exception e) {
        }
    }

    public void verificarInternoVisitaCadastrado() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSFAMILIAR "
                    + "WHERE IdInternoCrc='" + jIdInternoBio.getText() + "' "
                    + "AND IdVisita='" + jCodigoVisita.getText() + "' "
                    + "AND IdLanc='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            codigoInternoGrava = conecta.rs.getString("IdInternoCrc");
            codigoVisitaGrava = conecta.rs.getString("IdVisita");
            codigoRegistroGrava = conecta.rs.getString("IdLanc");
            codigoItem = conecta.rs.getInt("IdItem");
            assinaturaVisita = conecta.rs.getBytes("AssinaturaEntrada");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherTabelaItens(String sql) {
        count1 = 0;
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Visitante", "Data Entrada", "Horário", " Data Saida", "Horário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count1 = count1 + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataEntrada");
                String dia = dataEntrada.substring(8, 10);
                String mes = dataEntrada.substring(5, 7);
                String ano = dataEntrada.substring(0, 4);
                dataEntrada = dia + "/" + mes + "/" + ano;
                // Data de Saida
                // Formatar a data Entrada
                dataSaida = conecta.rs.getString("DataSaida");
                String dias = dataSaida.substring(8, 10);
                String mess = dataSaida.substring(5, 7);
                String anos = dataSaida.substring(0, 4);
                dataSaida = dias + "/" + mess + "/" + anos;
                jtotalItens.setText(Integer.toString(count1)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getInt("IdVisita"), conecta.rs.getString("NomeVisita"), dataEntrada, conecta.rs.getString("HorarioEntrada"), dataSaida, conecta.rs.getString("HorarioSaida")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitasInternos.setModel(modelo);
        jTabelaVisitasInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaVisitasInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaVisitasInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaVisitasInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaVisitasInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaVisitasInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaVisitasInternos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(6).setPreferredWidth(50);
        jTabelaVisitasInternos.getColumnModel().getColumn(6).setResizable(false);
        jTabelaVisitasInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitasInternos.setAutoResizeMode(jTabelaVisitasInternos.AUTO_RESIZE_OFF);
        jTabelaVisitasInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaVisitas();
        conecta.desconecta();
    }

    public void limparTabelaVisitas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"IdItem", "Código", "Nome do Visitante", "Data Entrada", "Horário", " Data Saida", "Horário"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitasInternos.setModel(modelo);
        jTabelaVisitasInternos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaVisitasInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaVisitasInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaVisitasInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaVisitasInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaVisitasInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaVisitasInternos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(6).setPreferredWidth(50);
        jTabelaVisitasInternos.getColumnModel().getColumn(6).setResizable(false);
        jTabelaVisitasInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitasInternos.setAutoResizeMode(jTabelaVisitasInternos.AUTO_RESIZE_OFF);
        jTabelaVisitasInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharTabelaVisitas() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaVisitasInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaVisitasInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaVisitasInternos.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaVisitasInternos.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaVisitasInternos.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        jTabelaVisitasInternos.getColumnModel().getColumn(6).setCellRenderer(centralizado);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIDlanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
