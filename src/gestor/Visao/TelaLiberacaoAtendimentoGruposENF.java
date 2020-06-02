/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleRegistroAtendimentoInternoBio_ENF;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Modelo.LogSistema;
import gestor.Modelo.RegistroAtendimentoInternos;
import static gestor.Visao.TelaAtendimentoGrupoENF.jBtAuditoria;
import static gestor.Visao.TelaAtendimentoGrupoENF.jBtNovo;
import static gestor.Visao.TelaAtendimentoGrupoENF.jCodigoAtend;
import static gestor.Visao.TelaAtendimentoGrupoENF.jDataAtend;
import static gestor.Visao.TelaAtendimentoGrupoENF.jStatusAtend;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloEnfermaria.codAbrirENF;
import static gestor.Visao.TelaModuloEnfermaria.codAlterarENF;
import static gestor.Visao.TelaModuloEnfermaria.codExcluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codGravarENF;
import static gestor.Visao.TelaModuloEnfermaria.codIncluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codUserAcessoENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.codConsultarENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserGroupENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeModuloENFER;
import static gestor.Visao.TelaModuloEnfermaria.nomeTelaENF;
import static gestor.Visao.TelaModuloEnfermaria.telaIndAtendimentoGrupoENF_Manu;
import java.awt.Color;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Socializa TI 02
 */
public class TelaLiberacaoAtendimentoGruposENF extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ControleRegistroAtendimentoInternoBio_ENF control = new ControleRegistroAtendimentoInternoBio_ENF();
    RegistroAtendimentoInternos objRegAtend = new RegistroAtendimentoInternos();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    String nomeModuloTela = "ENFERMARIA:Registro de Atendimento de Internos em Grupo";
    //
    int count = 0;
    int codigoDepto = 0;
    String statusMov;
    String horaMov;
    String dataModFinal;
    String atendido = "";
    //
    public static byte[] pDigitalCapturadaColaborador = null;
    String pImpressao = "Sim";
    public static String pLiberacaoImpressa = "Não";
    public static int codigoLiberador = 0;
    public static String nomeLiberador = "";
    public static String dataAssinatura = "";
    public static String horaAssinatura = "";
    int qtdAtend = 1;
    //
    int pQUANTIDADE_REGISTRO = 0;
    int STATUS_USUARIO = 1;
    int pREGISTROS_PROCESSADOS = 0;

    /**
     * Creates new form TelaLiberacaoAtendimentoGruposPSI
     */
    public static TelaAtendimentoGrupoENF atendGPSI;
    public static TelaAssinaBiometriaColaboradoresPSP_AG_ENF assinaBio;

    public TelaLiberacaoAtendimentoGruposENF(TelaAtendimentoGrupoENF parent, boolean modal) {
        this.atendGPSI = parent;
        this.setModal(modal);
        setLocationRelativeTo(atendGPSI);
        initComponents();
        jPanel3.setVisible(!true);
        jMensagemAlerta.setVisible(!true);
        jTotalRegistrosProc.setVisible(!true);
        jRegistrosProcessados.setVisible(!true);
        corCampos();
        //ABA PARTICIPANTES
        preencherTabelaParticipantes("SELECT * FROM PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM "
                + "INNER JOIN ATENDIMENTO_GRUPO_ENFERMAGEM "
                + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf=ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf "
                + "INNER JOIN PRONTUARIOSCRC "
                + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                + "INNER JOIN DADOSPENAISINTERNOS "
                + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                + "WHERE PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM.IdAtGrupoEnf='" + jCodigoAtend.getText() + "'");
    }

    public void mostrarLiberador() {
        assinaBio = new TelaAssinaBiometriaColaboradoresPSP_AG_ENF(this, true);
        assinaBio.setVisible(true);
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
        jLabel11 = new javax.swing.JLabel();
        jIdRegistro = new javax.swing.JTextField();
        jDataRegistro = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxTipoMovimentacao = new javax.swing.JComboBox();
        jHorarioSaidaEntrada = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jNomeDepartamento = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxAtendente = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jMotivo = new javax.swing.JTextArea();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTabelaInternosLiberados = new javax.swing.JTable();
        jPanel45 = new javax.swing.JPanel();
        jtotalRegistrosInternos = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtNovaLiberacao = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtBiometria = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        jMensagemAlerta = new javax.swing.JLabel();
        jTotalRegistrosProc = new javax.swing.JLabel();
        jRegistrosProcessados = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Liberação de Atendimento em Grupo :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Código");

        jIdRegistro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRegistro.setEnabled(false);

        jDataRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRegistro.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Data Mov.");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Tipo de Atendimento");

        jComboBoxTipoMovimentacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoMovimentacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Atendimento em Grupo/ENF", " " }));
        jComboBoxTipoMovimentacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoMovimentacao.setEnabled(false);

        jHorarioSaidaEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioSaidaEntrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioSaidaEntrada.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Horário");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Departamento");

        jNomeDepartamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jNomeDepartamento.setForeground(new java.awt.Color(204, 0, 0));
        jNomeDepartamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeDepartamento.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jNomeDepartamento.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 204));
        jLabel14.setText("Atendente");

        jComboBoxAtendente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAtendente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxAtendente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAtendente.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Motivo");

        jMotivo.setColumns(20);
        jMotivo.setRows(5);
        jMotivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMotivo.setEnabled(false);
        jScrollPane2.setViewportView(jMotivo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jNomeDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jComboBoxAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel13))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jComboBoxTipoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jHorarioSaidaEntrada))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jHorarioSaidaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaInternosLiberados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternosLiberados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "CNC", "Nome do Interno", "Regime"
            }
        ));
        jScrollPane15.setViewportView(jTabelaInternosLiberados);
        if (jTabelaInternosLiberados.getColumnModel().getColumnCount() > 0) {
            jTabelaInternosLiberados.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaInternosLiberados.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaInternosLiberados.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaInternosLiberados.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaInternosLiberados.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaInternosLiberados.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaInternosLiberados.getColumnModel().getColumn(3).setMinWidth(350);
            jTabelaInternosLiberados.getColumnModel().getColumn(3).setMaxWidth(350);
            jTabelaInternosLiberados.getColumnModel().getColumn(4).setMinWidth(100);
            jTabelaInternosLiberados.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistrosInternos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistrosInternos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistrosInternos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel65.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtConfirmar.setToolTipText("Gravar");
        jBtConfirmar.setContentAreaFilled(false);
        jBtConfirmar.setEnabled(false);
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setToolTipText("Sair");
        jBtSair.setContentAreaFilled(false);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtNovaLiberacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaLiberacao.setToolTipText("Novo");
        jBtNovaLiberacao.setContentAreaFilled(false);
        jBtNovaLiberacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaLiberacaoActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setToolTipText("CancelarCancelar");
        jBtCancelar.setContentAreaFilled(false);
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtBiometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16.png"))); // NOI18N
        jBtBiometria.setToolTipText("Assinatura Biometrica");
        jBtBiometria.setContentAreaFilled(false);
        jBtBiometria.setEnabled(false);
        jBtBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBiometriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovaLiberacao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jBtBiometria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovaLiberacao)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtSair)
                    .addComponent(jBtBiometria))
                .addGap(3, 3, 3))
        );

        jProgressBar1.setStringPainted(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jMensagemAlerta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMensagemAlerta.setForeground(new java.awt.Color(153, 0, 0));
        jMensagemAlerta.setText("Processando registros, aguarde...");

        jTotalRegistrosProc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTotalRegistrosProc.setForeground(new java.awt.Color(153, 0, 0));
        jTotalRegistrosProc.setText("Total de Registros:");

        jRegistrosProcessados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRegistrosProcessados.setForeground(new java.awt.Color(153, 0, 0));
        jRegistrosProcessados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jRegistrosProcessados.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jMensagemAlerta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotalRegistrosProc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRegistrosProcessados)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMensagemAlerta)
                    .addComponent(jRegistrosProcessados)
                    .addComponent(jTotalRegistrosProc))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNovaLiberacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaLiberacaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoENF_Manu);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAtendimentoGrupoENF_Manu) && codIncluirENF == 1) {
            Novo();
            pesquisarModulo();
            pesquisarAtendente();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovaLiberacaoActionPerformed

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        if (jIdRegistro.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário informar o número do registro.");
        } else if (jDataRegistro.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data do registro.");
        } else if (jNomeDepartamento.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do departamento.");
        } else if (jComboBoxAtendente.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do atendente.");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Esse procedimento irá confirmar e contabilizar os atendimentos a produção do atendente.\nUma vez confirmado, não será mais possível reverter a liberação do registro.");
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente liberar o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                // GRAVAR REGISTRO NA TABELA DE REGISTRO_ATENDIMENTO_PSP
                gravarDadosBanco();
            }
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBiometriaActionPerformed
        // TODO add your handling code here:
        mostrarLiberador();
    }//GEN-LAST:event_jBtBiometriaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLiberacaoAtendimentoGruposENF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLiberacaoAtendimentoGruposENF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLiberacaoAtendimentoGruposENF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLiberacaoAtendimentoGruposENF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaLiberacaoAtendimentoGruposENF dialog = new TelaLiberacaoAtendimentoGruposENF(atendGPSI, true);
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
    private javax.swing.JButton jBtBiometria;
    private javax.swing.JButton jBtCancelar;
    public static javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtNovaLiberacao;
    private javax.swing.JButton jBtSair;
    private javax.swing.JComboBox<String> jComboBoxAtendente;
    public static javax.swing.JComboBox jComboBoxTipoMovimentacao;
    private com.toedter.calendar.JDateChooser jDataRegistro;
    private javax.swing.JFormattedTextField jHorarioSaidaEntrada;
    public static javax.swing.JTextField jIdRegistro;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jMensagemAlerta;
    private javax.swing.JTextArea jMotivo;
    private javax.swing.JTextField jNomeDepartamento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel jRegistrosProcessados;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabelaInternosLiberados;
    private javax.swing.JLabel jTotalRegistrosProc;
    private javax.swing.JLabel jtotalRegistrosInternos;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jIdRegistro.setBackground(Color.white);
        jDataRegistro.setBackground(Color.white);
        jComboBoxTipoMovimentacao.setBackground(Color.white);
        jComboBoxAtendente.setBackground(Color.white);
        jHorarioSaidaEntrada.setBackground(Color.white);
        jNomeDepartamento.setBackground(Color.white);
        jMotivo.setBackground(Color.white);
    }

    public void Novo() {
        jIdRegistro.setText(jCodigoAtend.getText());
        jDataRegistro.setCalendar(Calendar.getInstance());
        jComboBoxTipoMovimentacao.setSelectedItem("Atendimento em Grupo/ENF");
        jComboBoxAtendente.setSelectedItem("Selecione...");
        jHorarioSaidaEntrada.setText(jHoraSistema.getText());
        jNomeDepartamento.setText(nomeModuloENFER);
        jMotivo.setText("");
        //
        jComboBoxTipoMovimentacao.setEnabled(true);
        jComboBoxAtendente.setEnabled(true);
        jMotivo.setEnabled(true);
        //
        jBtNovaLiberacao.setEnabled(!true);
        jBtBiometria.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Cancelar() {
        jIdRegistro.setText("");
        jDataRegistro.setDate(null);
        jComboBoxTipoMovimentacao.setSelectedItem("Atendimento em Grupo/ENF");
        jComboBoxAtendente.setSelectedItem("Selecione...");
        jHorarioSaidaEntrada.setText("");
        jNomeDepartamento.setText("");
        jMotivo.setText("");
        //
        jComboBoxTipoMovimentacao.setEnabled(!true);
        jComboBoxAtendente.setEnabled(!true);
        jMotivo.setEnabled(!true);
        //
        jBtNovaLiberacao.setEnabled(true);
        jBtBiometria.setEnabled(!true);
        jBtConfirmar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void pesquisarModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdDepartamento, "
                    + "NomeDepartamento "
                    + "FROM DEPARTAMENTOS "
                    + "WHERE NomeDepartamento='" + nomeModuloENFER + "'");
            conecta.rs.first();
            codigoDepto = conecta.rs.getInt("IdDepartamento");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisarAtendente() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeDepartamento='" + nomeModuloENFER + "' "
                    + "AND StatusUsuario='" + STATUS_USUARIO + "' "
                    + "ORDER BY NomeUsuario");
            conecta.rs.first();
            do {
                jComboBoxAtendente.addItem(conecta.rs.getString("NomeUsuario"));
            } while (conecta.rs.next());
            jComboBoxAtendente.updateUI();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void gravarDadosBanco() {
        jPanel3.setVisible(true);
        jMensagemAlerta.setVisible(true);
        jRegistrosProcessados.setVisible(true);
        jTotalRegistrosProc.setVisible(true);
        atendido = "Sim";
        qtdAtend = 1;
        // Para o log do registro
        objRegAtend.setUsuarioInsert(nameUser);
        objRegAtend.setDataInsert(dataModFinal);
        objRegAtend.setHorarioInsert(horaMov);
        //
        objRegAtend.setIdAtend(Integer.valueOf(jIdRegistro.getText()));
        objRegAtend.setDataAtendimento(jDataAtend.getDate());
        objRegAtend.setTipoAtemdimento((String) jComboBoxTipoMovimentacao.getSelectedItem());
        objRegAtend.setDataReg(jDataRegistro.getDate());
        objRegAtend.setHorario(jHorarioSaidaEntrada.getText());
        objRegAtend.setDataAssinatura(dataAssinatura);
        objRegAtend.setHoraAssinatura(horaAssinatura);
        objRegAtend.setCodigoFunc(codigoLiberador);
        objRegAtend.setNomeFunc(nomeLiberador);
        objRegAtend.setAssinaturaLiberador(pDigitalCapturadaColaborador);
        objRegAtend.setDataAssinatura(dataAssinatura);
        objRegAtend.setHoraAssinatura(horaAssinatura);
        objRegAtend.setAtendido(atendido);
        objRegAtend.setMotivoImpressao(jMotivo.getText());
        objRegAtend.setImpressaoAuto(pImpressao);
        objRegAtend.setQtdAtend(qtdAtend);
        objRegAtend.setUsuarioAtendente((String) jComboBoxAtendente.getSelectedItem());
        objRegAtend.setIdDepartamento(codigoDepto);
        objLog();
        try {
            Thread t0 = new Thread() {
                public void run() {
                    statusMov = "Incluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    for (int i = 0; i < jTabelaInternosLiberados.getRowCount(); i++) {
                        objRegAtend.setIdInternoCrc((int) jTabelaInternosLiberados.getValueAt(i, 1));
                        control.incluirRegAtendGrupo(objRegAtend);
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        pQUANTIDADE_REGISTRO = i + 1;
                        jRegistrosProcessados.setText(String.valueOf(pQUANTIDADE_REGISTRO));
                        if (pQUANTIDADE_REGISTRO == count) {
                            jProgressBar1.setValue(100);
                            // FINALIZAR O ATENDIMENTO PARA NÃO SER MODIFICADO.
                            statusMov = "Finalizou";
                            horaMov = jHoraSistema.getText();
                            dataModFinal = jDataSistema.getText();
                            String statusLanc = "FINALIZADO";
                            objRegAtend.setStatusAtendimento(statusLanc);
                            objRegAtend.setIdAtend(Integer.valueOf(jCodigoAtend.getText()));
                            control.finalizarAtendimentoGrupoENF(objRegAtend);
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            jStatusAtend.setText("FINALIZADO");
                            //                 
                            jBtNovo.setEnabled(true);
                            jBtAuditoria.setEnabled(true);
                            JOptionPane.showMessageDialog(rootPane, "Operação Concluída com sucesso...");
                            dispose();
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                    }
                }
            };
            t0.start();
        } catch (Exception e) {
        }
        // THREAD DA BARRA DE EXECUÇÃO
        try {
            Thread t = new Thread() {
                public void run() {
                    jProgressBar1.setMaximum(jTabelaInternosLiberados.getRowCount());
                    Rectangle rect;
                    for (int i = 0; i < jTabelaInternosLiberados.getRowCount(); i++) {
                        rect = jTabelaInternosLiberados.getCellRect(i, 0, true);
                        try {
                            jTabelaInternosLiberados.scrollRectToVisible(rect);
                        } catch (java.lang.ClassCastException e) {
                        }
                        if (i == 0) {
                            jTabelaInternosLiberados.setRowSelectionInterval(i, 0);
                            jProgressBar1.setValue((i + 1));
                        } else if (i > 0) {
                            jTabelaInternosLiberados.setRowSelectionInterval(i, 1);
                            jProgressBar1.setValue((i + 1));
                            pREGISTROS_PROCESSADOS = pREGISTROS_PROCESSADOS + 1;
                            jProgressBar1.setValue(i);
                        }
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                        }
                        jProgressBar1.setValue(100);
                        jMensagemAlerta.setText("Concluíndo, favor aguardar...");
                    }
                    try {
                    } catch (Exception e) {
                    }
                }
            };
            t.start();
        } catch (Exception e) {
        }
    }

    //ABA PARTICIPANTES
    public void preencherTabelaParticipantes(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "CNC", "Nome do Interno", "Regime"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            count = 0;
            do {
                count = count + 1;
                jtotalRegistrosInternos.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdItemPartEnf"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("Cnc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("Regime")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternosLiberados.setModel(modelo);
        jTabelaInternosLiberados.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaInternosLiberados.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternosLiberados.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternosLiberados.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternosLiberados.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaInternosLiberados.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternosLiberados.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTabelaInternosLiberados.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternosLiberados.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTabelaInternosLiberados.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInternosLiberados.getTableHeader().setReorderingAllowed(false);
        jTabelaInternosLiberados.setAutoResizeMode(jTabelaInternosLiberados.AUTO_RESIZE_OFF);
        jTabelaInternosLiberados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaParticipantes();
        conecta.desconecta();
    }

    public void alinharCamposTabelaParticipantes() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternosLiberados.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternosLiberados.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaInternosLiberados.getColumnModel().getColumn(2).setCellRenderer(direita);
    }

    public void limparTabelaParticipantes() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "CNC", "Nome do Interno", "Regime"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternosLiberados.setModel(modelo);
        jTabelaInternosLiberados.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaInternosLiberados.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternosLiberados.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternosLiberados.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternosLiberados.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaInternosLiberados.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternosLiberados.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTabelaInternosLiberados.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternosLiberados.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTabelaInternosLiberados.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInternosLiberados.getTableHeader().setReorderingAllowed(false);
        jTabelaInternosLiberados.setAutoResizeMode(jTabelaInternosLiberados.AUTO_RESIZE_OFF);
        jTabelaInternosLiberados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoAtend.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserENF = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserENF + "'");
            conecta.rs.first();
            codigoUserGroupENF = conecta.rs.getInt("IdUsuario");
            codigoGrupoENF = conecta.rs.getInt("IdGrupo");
            nomeGrupoENF = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserENF + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoENF = conecta.rs.getInt("IdUsuario");
            codAbrirENF = conecta.rs.getInt("Abrir");
            codIncluirENF = conecta.rs.getInt("Incluir");
            codAlterarENF = conecta.rs.getInt("Alterar");
            codExcluirENF = conecta.rs.getInt("Excluir");
            codGravarENF = conecta.rs.getInt("Gravar");
            codConsultarENF = conecta.rs.getInt("Consultar");
            nomeTelaENF = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
