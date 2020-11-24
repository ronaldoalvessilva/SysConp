/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import Utilitarios.DateUtils;
import gestor.Controle.ControleEscalaFolgas;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.PesquisaMesAnoCronograma;
import gestor.Controle.PesquisarEscalasDescricao;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EscalaFolgas;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaFuncionarios.jComboBoxStatusFunc;
import static gestor.Visao.TelaFuncionarios.jDepartamento;
import static gestor.Visao.TelaFuncionarios.jIDFunc;
import static gestor.Visao.TelaFuncionarios.jNomeCargo;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloAdmPessoal.codAbrirADM;
import static gestor.Visao.TelaModuloAdmPessoal.codAlterarADM;
import static gestor.Visao.TelaModuloAdmPessoal.codConsultarADM;
import static gestor.Visao.TelaModuloAdmPessoal.codExcluirADM;
import static gestor.Visao.TelaModuloAdmPessoal.codGravarADM;
import static gestor.Visao.TelaModuloAdmPessoal.codIncluirADM;
import static gestor.Visao.TelaModuloAdmPessoal.codUserAcessoADM;
import static gestor.Visao.TelaModuloAdmPessoal.codigoGrupoADM;
import static gestor.Visao.TelaModuloAdmPessoal.codigoUserADM;
import static gestor.Visao.TelaModuloAdmPessoal.codigoUserGroupADM;
import static gestor.Visao.TelaModuloAdmPessoal.nomeGrupoADM;
import static gestor.Visao.TelaModuloAdmPessoal.nomeTelaADM;
import static gestor.Visao.TelaModuloAdmPessoal.telaCronogramaCriar_ADM;
import static gestor.Visao.TelaModuloAdmPessoal.telaCronogramaEfetuar_ADM;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class TelaCronogramaEscala extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EscalaFolgas objEscalas = new EscalaFolgas();
    PesquisarEscalasDescricao pPESQUISAR_colaborador = new PesquisarEscalasDescricao();
    DateUtils dateUtils = new DateUtils();
    ControleEscalaFolgas CONTROLE_ESCALA_colaborador = new ControleEscalaFolgas();
    //
    PesquisaMesAnoCronograma pesquisaMesAno = new PesquisaMesAnoCronograma();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    String nomeModuloTela = "AdmPessoal:Colaboradores:Ficha Cadastral:Cronograma de Trabalho";
    String statusMov;
    String horaMov;
    String dataModFinal;
    int acao = 0;

    String dataInicial;
    String dataFinal;
    String dataPrimeiraFolga;
    //
    int totalDias = 0;
    Date dataBase = null;
    Date vencimento = null;
    String dataI;
    String dataF;
    //
    long diferencaMS;
    long diferencaSegundos;
    long diferencaMinutos;
    long diferencaHoras;
    long diferencaDias;
    //
    int inteiro = 0;
    Date d1;
    Date d2;
    Date d3;
    public static Date d4;
    public static Date pDATA_cronograma = null;
    String pDATA_evento = "";
    String pDATA_d4c = "";
    int pDIAS_FOLGA = 0;
    int pTOTAL_registros = 0;
    //
    public static String pRESPOSTA_crono = "";
    //
    public static Integer pID_ESCALA = 0;
    public static Integer pID_REGISTRO = 0;
    //
    String pSITUACAO_TRABALHO_folga = "";
    //
    String data1 = null;
    String data2 = null;
    int opcao = 0;
    public static int pTOTAL_REGISTROS_crono = 1;
    //
    String pMES_01 = "01";
    String pMES_02 = "02";
    String pMES_03 = "Março";
    String pMES_04 = "Abril";
    String pMES_05 = "Maio";
    String pMES_06 = "Junho";
    String pMES_07 = "Julho";
    String pMES_08 = "Agosto";
    String pMES_09 = "Setembro";
    String pMES_10 = "Outubro";
    String pMES_11 = "Novembro";
    String pMES_12 = "Dezembro";
    //
    String pMES_REFERENCIA = "";
    String pDIA = "";
    String pMES = "";
    String pANO = "";
    String pEXISTE_ANO = "";
    String pEXISTE_MES = "";
    String pEXISTE_FUN = "";

    /**
     * Creates new form TelaCronogramaEscala
     */
    public static TelaFuncionarios pCOLABORADOR;
    public static TelaPesquisaCronogramaEscala pPESQUISAR_registros;

    public TelaCronogramaEscala(TelaFuncionarios parent, boolean modal) {
        this.pCOLABORADOR = parent;
        this.setModal(modal);
        setLocationRelativeTo(pCOLABORADOR);
        initComponents();
        corCampos();
    }

    public void mostrarRegistros() {
        pPESQUISAR_registros = new TelaPesquisaCronogramaEscala(this, true);
        pPESQUISAR_registros.setVisible(true);
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
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jQuantTrabalho = new javax.swing.JTextField();
        jComboBoxPrimeiroApt = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jQuantFolga = new javax.swing.JTextField();
        jComboBoxSegundoApt = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jCodigoFunc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jNomeColaboradorEscala = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jEscala = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTurnoEscala = new javax.swing.JTextField();
        jTurmaEscala = new javax.swing.JTextField();
        jDepartamentoEscala = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jCargo = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jDataInicialCronograma = new com.toedter.calendar.JDateChooser();
        jDataFinalCronograma = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jDataPrimeiraFolga = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jComboBoxMesReferencia = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxAnoReferencia = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jBtEfetuar = new javax.swing.JButton();
        jBtFechar = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtBuscar = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jComboBoxTipoCronograma = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: CRONOGRAMA DE ESCALA :::...");
        setIconImage(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Qtd. Dias Trabalho");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Primeiro Apt.");

        jQuantTrabalho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jQuantTrabalho.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jQuantTrabalho.setText("0");
        jQuantTrabalho.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantTrabalho.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jQuantTrabalho.setEnabled(false);

        jComboBoxPrimeiroApt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPrimeiroApt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "TRABALHADO", "FOLGA", "FÉRIAS", "ATESTADO", "INSS", "AFASTADO", "LICENÇA" }));
        jComboBoxPrimeiroApt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPrimeiroApt.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxPrimeiroApt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jQuantTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jQuantTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPrimeiroApt, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("POR");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Qtd. Dias de Folga");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Segundo Apt.");

        jQuantFolga.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jQuantFolga.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jQuantFolga.setText("0");
        jQuantFolga.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantFolga.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jQuantFolga.setEnabled(false);

        jComboBoxSegundoApt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSegundoApt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "TRABALHADO", "FOLGA", "FÉRIAS", "ATESTADO", "INSS", "AFASTADO", "LICENÇA" }));
        jComboBoxSegundoApt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSegundoApt.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jComboBoxSegundoApt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jQuantFolga, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jQuantFolga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSegundoApt, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel2, jPanel3});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel9)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel2, jPanel3});

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jCodigoFunc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCodigoFunc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoFunc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoFunc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCodigoFunc.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome do Colaborador");

        jNomeColaboradorEscala.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jNomeColaboradorEscala.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeColaboradorEscala.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeColaboradorEscala.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Descrição da Escala");

        jEscala.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jEscala.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEscala.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jEscala.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jEscala)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jCodigoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 332, Short.MAX_VALUE))
                            .addComponent(jNomeColaboradorEscala)))
                    .addComponent(jLabel3))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCodigoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeColaboradorEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Turno");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Turma");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Departamento");

        jTurnoEscala.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTurnoEscala.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTurnoEscala.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTurnoEscala.setEnabled(false);

        jTurmaEscala.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTurmaEscala.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTurmaEscala.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTurmaEscala.setEnabled(false);

        jDepartamentoEscala.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jDepartamentoEscala.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDepartamentoEscala.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDepartamentoEscala.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Cargo");

        jCargo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCargo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCargo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCargo.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jDepartamentoEscala)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTurnoEscala, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jTurmaEscala, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jCargo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTurnoEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTurmaEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDepartamentoEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel12)
                .addGap(3, 3, 3)
                .addComponent(jCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Data Inicial");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Data Final");

        jDataInicialCronograma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataInicialCronograma.setEnabled(false);

        jDataFinalCronograma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataFinalCronograma.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataInicialCronograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jDataFinalCronograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataInicialCronograma, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataFinalCronograma, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jDataPrimeiraFolga.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPrimeiraFolga.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Primeira Folga");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataPrimeiraFolga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(7, 7, 7))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataPrimeiraFolga, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jComboBoxMesReferencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxMesReferencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        jComboBoxMesReferencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxMesReferencia.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Mês Referência");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Ano");

        jComboBoxAnoReferencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAnoReferencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100", "2101", "2102", "2103", "2104", "2105", "2106", "2107", "2108", "2109", "2110", "2111", "2112", "2113", "2114", "2115", "2116", "2117", "2118", "2119", "2120", "2121", "2122", "2123", "2124", "2125", "2126", "2127", "2128", "2129", "2130", "2131", "2132", "2133", "2134", "2135", "2136", "2137", "2138", "2139", "2140", "2141", "2142", "2143", "2144", "2145", "2146", "2147", "2148", "2149", "2150", "2151", "2152", "2153", "2154", "2155", "2156", "2157", "2158", "2159", "2160", "2161", "2162", "2163", "2164", "2165", "2166", "2167", "2168", "2169", "2170", "2171", "2172", "2173", "2174", "2175", "2176", " " }));
        jComboBoxAnoReferencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAnoReferencia.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jComboBoxMesReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxAnoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxMesReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAnoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtEfetuar.setForeground(new java.awt.Color(0, 153, 0));
        jBtEfetuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Botoes_Site_5745_Knob_Valid_Green(1).png"))); // NOI18N
        jBtEfetuar.setText("EFETUAR");
        jBtEfetuar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jBtEfetuar.setEnabled(false);
        jBtEfetuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEfetuarActionPerformed(evt);
            }
        });

        jBtFechar.setForeground(new java.awt.Color(204, 0, 0));
        jBtFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-32.png"))); // NOI18N
        jBtFechar.setText("FECHAR");
        jBtFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtEfetuar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(jBtFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtEfetuar, jBtFechar});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEfetuar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtEfetuar, jBtFechar});

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Opções do Cronograma", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/calendar_add.png"))); // NOI18N
        jBtNovo.setText("Criar");
        jBtNovo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir.setText("Excluir");
        jBtExcluir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1339_03.gif"))); // NOI18N
        jBtBuscar.setText("Pesquisar");
        jBtBuscar.setToolTipText("Pesquisar registros gravados.");
        jBtBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jBtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jBtNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jBtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtBuscar, jBtExcluir, jBtNovo});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtNovo))
                .addGap(7, 7, 7))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtBuscar, jBtExcluir, jBtNovo});

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Tipo de Cronograma:");

        jComboBoxTipoCronograma.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoCronograma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Mensal", "Anual", "Semestral" }));
        jComboBoxTipoCronograma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoCronograma.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("Informe a data da primeira folga");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipoCronograma, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxTipoCronograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel7, jPanel8, jPanel9});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCronogramaCriar_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaCronogramaCriar_ADM) && codIncluirADM == 1) {
            if (jComboBoxStatusFunc.getSelectedItem().equals("Ativo")) {
                habilitarCampos(true);
                bloquearBotoes(!true);
                limparCampos();
                Novo(true);
                acao = 1;
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                pBUSCAR_dados();
            } else {
                JOptionPane.showMessageDialog(rootPane, "O colaborador não está ativo, por isso não é permitido gerar o cronograma de trabalho.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        if (jCodigoFunc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário clicar no botão busca para trazer os dados do cronograma.");
        } else {
            if (jComboBoxStatusFunc.getSelectedItem().equals("Ativo")) {
                Alterar();
                acao = 2;
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            } else {
                JOptionPane.showMessageDialog(rootPane, "O colaborador não está ativo, por isso não é permitido gerar o cronograma de trabalho.");
            }
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        if (jCodigoFunc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário clicar no botão busca para trazer os dados do cronograma.");
        } else {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                carregando.setVisible(true);//Teste tela aguarde
                Thread t = new Thread() { //Teste tela aguarde
                    public void run() { //Teste     
                        habilitarCampos(!true);
                        bloquearBotoes(!true);
                        Excluir(true);
                        statusMov = "Excluiu";
                        horaMov = jHoraSistema.getText();
                        dataModFinal = jDataSistema.getText();
                        objEscalas.setIdFunc(Integer.valueOf(jIDFunc.getText()));
                        objEscalas.setMesReferencia((String) jComboBoxMesReferencia.getSelectedItem());
                        objEscalas.setAnoReferencia((String) jComboBoxAnoReferencia.getSelectedItem());
                        CONTROLE_ESCALA_colaborador.excluirCronogramaTrabalhoFolga(objEscalas);
                        carregando.dispose(); //Teste tela aguarde
                        if (pRESPOSTA_crono.equals("Sim")) {
                            limparCampos();
                            JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                        } else if (pRESPOSTA_crono.equals("Não")) {
                            JOptionPane.showMessageDialog(rootPane, "Não foi possível excluir o registro selecionado.");
                        }
                    }
                }; //Teste tela aguarde
                t.start(); //Teste tela aguarde
            }
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarActionPerformed
        // TODO add your handling code here:
        mostrarRegistros();
    }//GEN-LAST:event_jBtBuscarActionPerformed

    private void jBtEfetuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEfetuarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCronogramaEfetuar_ADM);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoADM.equals("ADMINISTRADORES") || codigoUserADM == codUserAcessoADM && nomeTelaADM.equals(telaCronogramaEfetuar_ADM) && codGravarADM == 1) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
            dataInicial = formatoAmerica.format(jDataInicialCronograma.getDate().getTime());
            dataFinal = formatoAmerica.format(jDataFinalCronograma.getDate().getTime());
            dataPrimeiraFolga = formatoAmerica.format(jDataPrimeiraFolga.getDate().getTime());
            if (jCodigoFunc.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário clicar no botão busca para trazer os dados do cronograma.");
            } else if (jDataInicialCronograma.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data Inicial.");
            } else if (jDataFinalCronograma.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data final.");
            } else if (jDataPrimeiraFolga.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data da primeira folga");
            } else if (jDataInicialCronograma.getDate().after(jDataFinalCronograma.getDate())) {
                JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
            } else if (jDataPrimeiraFolga.getDate().before(jDataInicialCronograma.getDate())) {
                JOptionPane.showMessageDialog(rootPane, "Data da primeira folga não pode ser maior que data inicial.");
            } else if (jComboBoxPrimeiroApt.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o promeiro apontamento.");
            } else if (!jComboBoxPrimeiroApt.getSelectedItem().equals("TRABALHADO")) {
                JOptionPane.showMessageDialog(rootPane, "Só é possível selecionar a opção <TRABALHANDO>.");
            } else if (jComboBoxSegundoApt.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Selecione o segundo apontamento.");
            } else if (!jComboBoxSegundoApt.getSelectedItem().equals("FOLGA")) {
                JOptionPane.showMessageDialog(rootPane, "Só é possível selecionar a opção <FOLGA>.");
            } else if (jComboBoxMesReferencia.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o mês de referencia.");
            } else if (jComboBoxAnoReferencia.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o ano de referência.");
            } else if (jComboBoxTipoCronograma.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(rootPane, "Selecione o tipo de cronograma.");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Confirma a gravação do cronograma do colaborador?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    if (jComboBoxTipoCronograma.getSelectedItem().equals("Anual") || jComboBoxTipoCronograma.getSelectedItem().equals("Semestral")) {
                        bloquearBotoes(true);
                        habilitarCampos(!true);
                        final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                        carregando.setVisible(true);//Teste tela aguarde
                        Thread t = new Thread() { //Teste tela aguarde
                            public void run() { //Teste                                        
                                calculoDias();
                                CALCULAR_datas();
                                CALCULAR_DIAS_folgas_1X1();
                                carregando.dispose(); //Teste tela aguarde
                                Salvar(true);
                                if (pTOTAL_REGISTROS_crono == totalDias) {
                                    objLog();
                                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                } else if (pTOTAL_REGISTROS_crono < totalDias) {
                                    JOptionPane.showMessageDialog(rootPane, "Os registros não foram todos gravados, solicite ajuda do administrador do sistema.");
                                }
                            }
                        }; //Teste tela aguarde
                        t.start(); //Teste tela aguarde
                    } else if (jComboBoxTipoCronograma.getSelectedItem().equals("Mensal")) {
                        pMES_REFERENCIA = formatoAmerica.format(jDataInicialCronograma.getDate().getTime());
                        if (jComboBoxMesReferencia.getSelectedItem().equals("Janeiro")) {
                            pMES_01 = "01";
                            pDIA = pMES_REFERENCIA.substring(0, 1);
                            pMES = pMES_REFERENCIA.substring(3, 5);
                            pANO = pMES_REFERENCIA.substring(6, 10);
                            pMES_REFERENCIA = pMES;
                            if (pMES_REFERENCIA.equals(pMES_01) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                                //CRITICAR CASO O REGISTRO PARA O MÊS E ANO DE REFERÊNCIA JÁ FOI INCLUÍDO
                                try {
                                    for (EscalaFolgas pp : pesquisaMesAno.read()) {
                                        pEXISTE_FUN = pp.getIdFunc().toString();
                                        pEXISTE_ANO = pp.getAnoReferencia();
                                        pEXISTE_MES = pp.getMesReferencia();
                                    }
                                } catch (Exception ex) {
                                    Logger.getLogger(TelaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (jComboBoxAnoReferencia.getSelectedItem().equals((pEXISTE_ANO)) && jComboBoxMesReferencia.getSelectedItem().equals(pEXISTE_MES) && jCodigoFunc.getText().equals(pEXISTE_FUN)) {
                                    JOptionPane.showMessageDialog(rootPane, "Já foi cadastrado o registro para o mês e ano de referência.");
                                } else {
                                    bloquearBotoes(true);
                                    habilitarCampos(!true);
                                    final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                                    carregando.setVisible(true);//Teste tela aguarde
                                    Thread t = new Thread() { //Teste tela aguarde
                                        public void run() { //Teste                                        
                                            calculoDias();
                                            CALCULAR_datas();
                                            CALCULAR_DIAS_folgas_1X1();
                                            carregando.dispose(); //Teste tela aguarde
                                            Salvar(true);
                                            if (pTOTAL_REGISTROS_crono == totalDias) {
                                                objLog();
                                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                            } else if (pTOTAL_REGISTROS_crono < totalDias) {
                                                JOptionPane.showMessageDialog(rootPane, "Os registros não foram todos gravados, solicite ajuda do administrador do sistema.");
                                            }
                                        }
                                    }; //Teste tela aguarde
                                    t.start(); //Teste tela aguarde
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                            }
                        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Fevereiro")) {
                            pMES_02 = "02";
                            pDIA = pMES_REFERENCIA.substring(0, 1);
                            pMES = pMES_REFERENCIA.substring(3, 5);
                            pANO = pMES_REFERENCIA.substring(6, 10);
                            pMES_REFERENCIA = pMES;
                            if (pMES_REFERENCIA.equals(pMES_02) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                                //CRITICAR CASO O REGISTRO PARA O MÊS E ANO DE REFERÊNCIA JÁ FOI INCLUÍDO
                                try {
                                    for (EscalaFolgas pp : pesquisaMesAno.read()) {
                                        pEXISTE_FUN = pp.getIdFunc().toString();
                                        pEXISTE_ANO = pp.getAnoReferencia();
                                        pEXISTE_MES = pp.getMesReferencia();
                                    }
                                } catch (Exception ex) {
                                    Logger.getLogger(TelaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (jComboBoxAnoReferencia.getSelectedItem().equals((pEXISTE_ANO)) && jComboBoxMesReferencia.getSelectedItem().equals(pEXISTE_MES) && jCodigoFunc.getText().equals(pEXISTE_FUN)) {
                                    JOptionPane.showMessageDialog(rootPane, "Já foi cadastrado o registro para o mês e ano de referência.");
                                } else {
                                    bloquearBotoes(true);
                                    habilitarCampos(!true);
                                    final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                                    carregando.setVisible(true);//Teste tela aguarde
                                    Thread t = new Thread() { //Teste tela aguarde
                                        public void run() { //Teste                                        
                                            calculoDias();
                                            CALCULAR_datas();
                                            CALCULAR_DIAS_folgas_1X1();
                                            carregando.dispose(); //Teste tela aguarde
                                            Salvar(true);
                                            if (pTOTAL_REGISTROS_crono == totalDias) {
                                                objLog();
                                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                            } else if (pTOTAL_REGISTROS_crono < totalDias) {
                                                JOptionPane.showMessageDialog(rootPane, "Os registros não foram todos gravados, solicite ajuda do administrador do sistema.");
                                            }
                                        }
                                    }; //Teste tela aguarde
                                    t.start(); //Teste tela aguarde
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                            }
                        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Março")) {
                            pMES_03 = "03";
                            pDIA = pMES_REFERENCIA.substring(0, 1);
                            pMES = pMES_REFERENCIA.substring(3, 5);
                            pANO = pMES_REFERENCIA.substring(6, 10);
                            pMES_REFERENCIA = pMES;
                            if (pMES_REFERENCIA.equals(pMES_03) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                                //CRITICAR CASO O REGISTRO PARA O MÊS E ANO DE REFERÊNCIA JÁ FOI INCLUÍDO
                                try {
                                    for (EscalaFolgas pp : pesquisaMesAno.read()) {
                                        pEXISTE_FUN = pp.getIdFunc().toString();
                                        pEXISTE_ANO = pp.getAnoReferencia();
                                        pEXISTE_MES = pp.getMesReferencia();
                                    }
                                } catch (Exception ex) {
                                    Logger.getLogger(TelaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (jComboBoxAnoReferencia.getSelectedItem().equals((pEXISTE_ANO)) && jComboBoxMesReferencia.getSelectedItem().equals(pEXISTE_MES) && jCodigoFunc.getText().equals(pEXISTE_FUN)) {
                                    JOptionPane.showMessageDialog(rootPane, "Já foi cadastrado o registro para o mês e ano de referência.");
                                } else {
                                    bloquearBotoes(true);
                                    habilitarCampos(!true);
                                    final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                                    carregando.setVisible(true);//Teste tela aguarde
                                    Thread t = new Thread() { //Teste tela aguarde
                                        public void run() { //Teste                                        
                                            calculoDias();
                                            CALCULAR_datas();
                                            CALCULAR_DIAS_folgas_1X1();
                                            carregando.dispose(); //Teste tela aguarde
                                            Salvar(true);
                                            if (pTOTAL_REGISTROS_crono == totalDias) {
                                                objLog();
                                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                            } else if (pTOTAL_REGISTROS_crono < totalDias) {
                                                JOptionPane.showMessageDialog(rootPane, "Os registros não foram todos gravados, solicite ajuda do administrador do sistema.");
                                            }
                                        }
                                    }; //Teste tela aguarde
                                    t.start(); //Teste tela aguarde
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                            }
                        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Abril")) {
                            pMES_04 = "04";
                            pDIA = pMES_REFERENCIA.substring(0, 1);
                            pMES = pMES_REFERENCIA.substring(3, 5);
                            pANO = pMES_REFERENCIA.substring(6, 10);
                            pMES_REFERENCIA = pMES;
                            if (pMES_REFERENCIA.equals(pMES_04) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                                //CRITICAR CASO O REGISTRO PARA O MÊS E ANO DE REFERÊNCIA JÁ FOI INCLUÍDO
                                try {
                                    for (EscalaFolgas pp : pesquisaMesAno.read()) {
                                        pEXISTE_FUN = pp.getIdFunc().toString();
                                        pEXISTE_ANO = pp.getAnoReferencia();
                                        pEXISTE_MES = pp.getMesReferencia();
                                    }
                                } catch (Exception ex) {
                                    Logger.getLogger(TelaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (jComboBoxAnoReferencia.getSelectedItem().equals((pEXISTE_ANO)) && jComboBoxMesReferencia.getSelectedItem().equals(pEXISTE_MES) && jCodigoFunc.getText().equals(pEXISTE_FUN)) {
                                    JOptionPane.showMessageDialog(rootPane, "Já foi cadastrado o registro para o mês e ano de referência.");
                                } else {
                                    bloquearBotoes(true);
                                    habilitarCampos(!true);
                                    final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                                    carregando.setVisible(true);//Teste tela aguarde
                                    Thread t = new Thread() { //Teste tela aguarde
                                        public void run() { //Teste                                        
                                            calculoDias();
                                            CALCULAR_datas();
                                            CALCULAR_DIAS_folgas_1X1();
                                            carregando.dispose(); //Teste tela aguarde
                                            Salvar(true);
                                            if (pTOTAL_REGISTROS_crono == totalDias) {
                                                objLog();
                                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                            } else if (pTOTAL_REGISTROS_crono < totalDias) {
                                                JOptionPane.showMessageDialog(rootPane, "Os registros não foram todos gravados, solicite ajuda do administrador do sistema.");
                                            }
                                        }
                                    }; //Teste tela aguarde
                                    t.start(); //Teste tela aguarde
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                            }
                        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Maio")) {
                            pMES_05 = "05";
                            pDIA = pMES_REFERENCIA.substring(0, 1);
                            pMES = pMES_REFERENCIA.substring(3, 5);
                            pANO = pMES_REFERENCIA.substring(6, 10);
                            pMES_REFERENCIA = pMES;
                            if (pMES_REFERENCIA.equals(pMES_05) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                                //CRITICAR CASO O REGISTRO PARA O MÊS E ANO DE REFERÊNCIA JÁ FOI INCLUÍDO
                                try {
                                    for (EscalaFolgas pp : pesquisaMesAno.read()) {
                                        pEXISTE_FUN = pp.getIdFunc().toString();
                                        pEXISTE_ANO = pp.getAnoReferencia();
                                        pEXISTE_MES = pp.getMesReferencia();
                                    }
                                } catch (Exception ex) {
                                    Logger.getLogger(TelaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (jComboBoxAnoReferencia.getSelectedItem().equals((pEXISTE_ANO)) && jComboBoxMesReferencia.getSelectedItem().equals(pEXISTE_MES) && jCodigoFunc.getText().equals(pEXISTE_FUN)) {
                                    JOptionPane.showMessageDialog(rootPane, "Já foi cadastrado o registro para o mês e ano de referência.");
                                } else {
                                    bloquearBotoes(true);
                                    habilitarCampos(!true);
                                    final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                                    carregando.setVisible(true);//Teste tela aguarde
                                    Thread t = new Thread() { //Teste tela aguarde
                                        public void run() { //Teste                                        
                                            calculoDias();
                                            CALCULAR_datas();
                                            CALCULAR_DIAS_folgas_1X1();
                                            carregando.dispose(); //Teste tela aguarde
                                            Salvar(true);
                                            if (pTOTAL_REGISTROS_crono == totalDias) {
                                                objLog();
                                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                            } else if (pTOTAL_REGISTROS_crono < totalDias) {
                                                JOptionPane.showMessageDialog(rootPane, "Os registros não foram todos gravados, solicite ajuda do administrador do sistema.");
                                            }
                                        }
                                    }; //Teste tela aguarde
                                    t.start(); //Teste tela aguarde
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                            }
                        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Junho")) {
                            pMES_06 = "06";
                            pDIA = pMES_REFERENCIA.substring(0, 1);
                            pMES = pMES_REFERENCIA.substring(3, 5);
                            pANO = pMES_REFERENCIA.substring(6, 10);
                            pMES_REFERENCIA = pMES;
                            if (pMES_REFERENCIA.equals(pMES_06) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                                //CRITICAR CASO O REGISTRO PARA O MÊS E ANO DE REFERÊNCIA JÁ FOI INCLUÍDO
                                try {
                                    for (EscalaFolgas pp : pesquisaMesAno.read()) {
                                        pEXISTE_FUN = pp.getIdFunc().toString();
                                        pEXISTE_ANO = pp.getAnoReferencia();
                                        pEXISTE_MES = pp.getMesReferencia();
                                    }
                                } catch (Exception ex) {
                                    Logger.getLogger(TelaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (jComboBoxAnoReferencia.getSelectedItem().equals((pEXISTE_ANO)) && jComboBoxMesReferencia.getSelectedItem().equals(pEXISTE_MES) && jCodigoFunc.getText().equals(pEXISTE_FUN)) {
                                    JOptionPane.showMessageDialog(rootPane, "Já foi cadastrado o registro para o mês e ano de referência.");
                                } else {
                                    bloquearBotoes(true);
                                    habilitarCampos(!true);
                                    final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                                    carregando.setVisible(true);//Teste tela aguarde
                                    Thread t = new Thread() { //Teste tela aguarde
                                        public void run() { //Teste                                        
                                            calculoDias();
                                            CALCULAR_datas();
                                            CALCULAR_DIAS_folgas_1X1();
                                            carregando.dispose(); //Teste tela aguarde
                                            Salvar(true);
                                            if (pTOTAL_REGISTROS_crono == totalDias) {
                                                objLog();
                                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                            } else if (pTOTAL_REGISTROS_crono < totalDias) {
                                                JOptionPane.showMessageDialog(rootPane, "Os registros não foram todos gravados, solicite ajuda do administrador do sistema.");
                                            }
                                        }
                                    }; //Teste tela aguarde
                                    t.start(); //Teste tela aguarde
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                            }
                        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Julho")) {
                            pMES_07 = "07";
                            pDIA = pMES_REFERENCIA.substring(0, 1);
                            pMES = pMES_REFERENCIA.substring(3, 5);
                            pANO = pMES_REFERENCIA.substring(6, 10);
                            pMES_REFERENCIA = pMES;
                            if (pMES_REFERENCIA.equals(pMES_07) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                                //CRITICAR CASO O REGISTRO PARA O MÊS E ANO DE REFERÊNCIA JÁ FOI INCLUÍDO
                                try {
                                    for (EscalaFolgas pp : pesquisaMesAno.read()) {
                                        pEXISTE_FUN = pp.getIdFunc().toString();
                                        pEXISTE_ANO = pp.getAnoReferencia();
                                        pEXISTE_MES = pp.getMesReferencia();
                                    }
                                } catch (Exception ex) {
                                    Logger.getLogger(TelaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (jComboBoxAnoReferencia.getSelectedItem().equals((pEXISTE_ANO)) && jComboBoxMesReferencia.getSelectedItem().equals(pEXISTE_MES) && jCodigoFunc.getText().equals(pEXISTE_FUN)) {
                                    JOptionPane.showMessageDialog(rootPane, "Já foi cadastrado o registro para o mês e ano de referência.");
                                } else {
                                    bloquearBotoes(true);
                                    habilitarCampos(!true);
                                    final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                                    carregando.setVisible(true);//Teste tela aguarde
                                    Thread t = new Thread() { //Teste tela aguarde
                                        public void run() { //Teste                                        
                                            calculoDias();
                                            CALCULAR_datas();
                                            CALCULAR_DIAS_folgas_1X1();
                                            carregando.dispose(); //Teste tela aguarde
                                            Salvar(true);
                                            if (pTOTAL_REGISTROS_crono == totalDias) {
                                                objLog();
                                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                            } else if (pTOTAL_REGISTROS_crono < totalDias) {
                                                JOptionPane.showMessageDialog(rootPane, "Os registros não foram todos gravados, solicite ajuda do administrador do sistema.");
                                            }
                                        }
                                    }; //Teste tela aguarde
                                    t.start(); //Teste tela aguarde
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                            }
                        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Agosto")) {
                            pMES_08 = "08";
                            pDIA = pMES_REFERENCIA.substring(0, 1);
                            pMES = pMES_REFERENCIA.substring(3, 5);
                            pANO = pMES_REFERENCIA.substring(6, 10);
                            pMES_REFERENCIA = pMES;
                            if (pMES_REFERENCIA.equals(pMES_08) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                                //CRITICAR CASO O REGISTRO PARA O MÊS E ANO DE REFERÊNCIA JÁ FOI INCLUÍDO
                                try {
                                    for (EscalaFolgas pp : pesquisaMesAno.read()) {
                                        pEXISTE_FUN = pp.getIdFunc().toString();
                                        pEXISTE_ANO = pp.getAnoReferencia();
                                        pEXISTE_MES = pp.getMesReferencia();
                                    }
                                } catch (Exception ex) {
                                    Logger.getLogger(TelaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (jComboBoxAnoReferencia.getSelectedItem().equals((pEXISTE_ANO)) && jComboBoxMesReferencia.getSelectedItem().equals(pEXISTE_MES) && jCodigoFunc.getText().equals(pEXISTE_FUN)) {
                                    JOptionPane.showMessageDialog(rootPane, "Já foi cadastrado o registro para o mês e ano de referência.");
                                } else {
                                    bloquearBotoes(true);
                                    habilitarCampos(!true);
                                    final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                                    carregando.setVisible(true);//Teste tela aguarde
                                    Thread t = new Thread() { //Teste tela aguarde
                                        public void run() { //Teste                                        
                                            calculoDias();
                                            CALCULAR_datas();
                                            CALCULAR_DIAS_folgas_1X1();
                                            carregando.dispose(); //Teste tela aguarde
                                            Salvar(true);
                                            if (pTOTAL_REGISTROS_crono == totalDias) {
                                                objLog();
                                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                            } else if (pTOTAL_REGISTROS_crono < totalDias) {
                                                JOptionPane.showMessageDialog(rootPane, "Os registros não foram todos gravados, solicite ajuda do administrador do sistema.");
                                            }
                                        }
                                    }; //Teste tela aguarde
                                    t.start(); //Teste tela aguarde
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                            }
                        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Setembro")) {
                            pMES_09 = "09";
                            pDIA = pMES_REFERENCIA.substring(0, 1);
                            pMES = pMES_REFERENCIA.substring(3, 5);
                            pANO = pMES_REFERENCIA.substring(6, 10);
                            pMES_REFERENCIA = pMES;
                            if (pMES_REFERENCIA.equals(pMES_09) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                                //CRITICAR CASO O REGISTRO PARA O MÊS E ANO DE REFERÊNCIA JÁ FOI INCLUÍDO
                                try {
                                    for (EscalaFolgas pp : pesquisaMesAno.read()) {
                                        pEXISTE_FUN = pp.getIdFunc().toString();
                                        pEXISTE_ANO = pp.getAnoReferencia();
                                        pEXISTE_MES = pp.getMesReferencia();
                                    }
                                } catch (Exception ex) {
                                    Logger.getLogger(TelaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (jComboBoxAnoReferencia.getSelectedItem().equals((pEXISTE_ANO)) && jComboBoxMesReferencia.getSelectedItem().equals(pEXISTE_MES) && jCodigoFunc.getText().equals(pEXISTE_FUN)) {
                                    JOptionPane.showMessageDialog(rootPane, "Já foi cadastrado o registro para o mês e ano de referência.");
                                } else {
                                    bloquearBotoes(true);
                                    habilitarCampos(!true);
                                    final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                                    carregando.setVisible(true);//Teste tela aguarde
                                    Thread t = new Thread() { //Teste tela aguarde
                                        public void run() { //Teste                                        
                                            calculoDias();
                                            CALCULAR_datas();
                                            CALCULAR_DIAS_folgas_1X1();
                                            carregando.dispose(); //Teste tela aguarde
                                            Salvar(true);
                                            if (pTOTAL_REGISTROS_crono == totalDias) {
                                                objLog();
                                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                            } else if (pTOTAL_REGISTROS_crono < totalDias) {
                                                JOptionPane.showMessageDialog(rootPane, "Os registros não foram todos gravados, solicite ajuda do administrador do sistema.");
                                            }
                                        }
                                    }; //Teste tela aguarde
                                    t.start(); //Teste tela aguarde
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                            }
                        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Outubro")) {
                            pMES_10 = "10";
                            pDIA = pMES_REFERENCIA.substring(0, 1);
                            pMES = pMES_REFERENCIA.substring(3, 5);
                            pANO = pMES_REFERENCIA.substring(6, 10);
                            pMES_REFERENCIA = pMES;
                            if (pMES_REFERENCIA.equals(pMES_10) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                                //CRITICAR CASO O REGISTRO PARA O MÊS E ANO DE REFERÊNCIA JÁ FOI INCLUÍDO
                                try {
                                    for (EscalaFolgas pp : pesquisaMesAno.read()) {
                                        pEXISTE_FUN = pp.getIdFunc().toString();
                                        pEXISTE_ANO = pp.getAnoReferencia();
                                        pEXISTE_MES = pp.getMesReferencia();
                                    }
                                } catch (Exception ex) {
                                    Logger.getLogger(TelaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (jComboBoxAnoReferencia.getSelectedItem().equals((pEXISTE_ANO)) && jComboBoxMesReferencia.getSelectedItem().equals(pEXISTE_MES) && jCodigoFunc.getText().equals(pEXISTE_FUN)) {
                                    JOptionPane.showMessageDialog(rootPane, "Já foi cadastrado o registro para o mês e ano de referência.");
                                } else {
                                    bloquearBotoes(true);
                                    habilitarCampos(!true);
                                    final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                                    carregando.setVisible(true);//Teste tela aguarde
                                    Thread t = new Thread() { //Teste tela aguarde
                                        public void run() { //Teste                                        
                                            calculoDias();
                                            CALCULAR_datas();
                                            CALCULAR_DIAS_folgas_1X1();
                                            carregando.dispose(); //Teste tela aguarde
                                            Salvar(true);
                                            if (pTOTAL_REGISTROS_crono == totalDias) {
                                                objLog();
                                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                            } else if (pTOTAL_REGISTROS_crono < totalDias) {
                                                JOptionPane.showMessageDialog(rootPane, "Os registros não foram todos gravados, solicite ajuda do administrador do sistema.");
                                            }
                                        }
                                    }; //Teste tela aguarde
                                    t.start(); //Teste tela aguarde
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                            }
                        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Novembro")) {
                            pMES_11 = "11";
                            pDIA = pMES_REFERENCIA.substring(0, 1);
                            pMES = pMES_REFERENCIA.substring(3, 5);
                            pANO = pMES_REFERENCIA.substring(6, 10);
                            pMES_REFERENCIA = pMES;
                            if (pMES_REFERENCIA.equals(pMES_11) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                                //CRITICAR CASO O REGISTRO PARA O MÊS E ANO DE REFERÊNCIA JÁ FOI INCLUÍDO
                                try {
                                    for (EscalaFolgas pp : pesquisaMesAno.read()) {
                                        pEXISTE_FUN = pp.getIdFunc().toString();
                                        pEXISTE_ANO = pp.getAnoReferencia();
                                        pEXISTE_MES = pp.getMesReferencia();
                                    }
                                } catch (Exception ex) {
                                    Logger.getLogger(TelaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (jComboBoxAnoReferencia.getSelectedItem().equals((pEXISTE_ANO)) && jComboBoxMesReferencia.getSelectedItem().equals(pEXISTE_MES) && jCodigoFunc.getText().equals(pEXISTE_FUN)) {
                                    JOptionPane.showMessageDialog(rootPane, "Já foi cadastrado o registro para o mês e ano de referência.");
                                } else {
                                    bloquearBotoes(true);
                                    habilitarCampos(!true);
                                    final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                                    carregando.setVisible(true);//Teste tela aguarde
                                    Thread t = new Thread() { //Teste tela aguarde
                                        public void run() { //Teste                                        
                                            calculoDias();
                                            CALCULAR_datas();
                                            CALCULAR_DIAS_folgas_1X1();
                                            carregando.dispose(); //Teste tela aguarde
                                            Salvar(true);
                                            if (pTOTAL_REGISTROS_crono == totalDias) {
                                                objLog();
                                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                            } else if (pTOTAL_REGISTROS_crono < totalDias) {
                                                JOptionPane.showMessageDialog(rootPane, "Os registros não foram todos gravados, solicite ajuda do administrador do sistema.");
                                            }
                                        }
                                    }; //Teste tela aguarde
                                    t.start(); //Teste tela aguarde
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                            }
                        } else if (jComboBoxMesReferencia.getSelectedItem().equals("Dezembro")) {
                            pMES_12 = "12";
                            pDIA = pMES_REFERENCIA.substring(0, 1);
                            pMES = pMES_REFERENCIA.substring(3, 5);
                            pANO = pMES_REFERENCIA.substring(6, 10);
                            pMES_REFERENCIA = pMES;
                            if (pMES_REFERENCIA.equals(pMES_12) && jComboBoxAnoReferencia.getSelectedItem().equals(pANO)) {
                                //CRITICAR CASO O REGISTRO PARA O MÊS E ANO DE REFERÊNCIA JÁ FOI INCLUÍDO
                                try {
                                    for (EscalaFolgas pp : pesquisaMesAno.read()) {
                                        pEXISTE_FUN = pp.getIdFunc().toString();
                                        pEXISTE_ANO = pp.getAnoReferencia();
                                        pEXISTE_MES = pp.getMesReferencia();
                                    }
                                } catch (Exception ex) {
                                    Logger.getLogger(TelaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (jComboBoxAnoReferencia.getSelectedItem().equals((pEXISTE_ANO)) && jComboBoxMesReferencia.getSelectedItem().equals(pEXISTE_MES) && jCodigoFunc.getText().equals(pEXISTE_FUN)) {
                                    JOptionPane.showMessageDialog(rootPane, "Já foi cadastrado o registro para o mês e ano de referência.");
                                } else {
                                    bloquearBotoes(true);
                                    habilitarCampos(!true);
                                    final ViewAguardeProcessando carregando = new ViewAguardeProcessando(); //Teste tela aguarde
                                    carregando.setVisible(true);//Teste tela aguarde
                                    Thread t = new Thread() { //Teste tela aguarde
                                        public void run() { //Teste                                        
                                            calculoDias();
                                            CALCULAR_datas();
                                            CALCULAR_DIAS_folgas_1X1();
                                            carregando.dispose(); //Teste tela aguarde
                                            Salvar(true);
                                            if (pTOTAL_REGISTROS_crono == totalDias) {
                                                objLog();
                                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                            } else if (pTOTAL_REGISTROS_crono < totalDias) {
                                                JOptionPane.showMessageDialog(rootPane, "Os registros não foram todos gravados, solicite ajuda do administrador do sistema.");
                                            }
                                        }
                                    }; //Teste tela aguarde
                                    t.start(); //Teste tela aguarde
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Dados incorreto, verifique se mês e o ano selecionado estão de acordo com a data inicial.");
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtEfetuarActionPerformed

    private void jBtFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFecharActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtFecharActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCronogramaEscala.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCronogramaEscala.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCronogramaEscala.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCronogramaEscala.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCronogramaEscala dialog = new TelaCronogramaEscala(pCOLABORADOR, true);
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
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtBuscar;
    private javax.swing.JButton jBtEfetuar;
    public static javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtFechar;
    private javax.swing.JButton jBtNovo;
    public static javax.swing.JTextField jCargo;
    public static javax.swing.JTextField jCodigoFunc;
    public static javax.swing.JComboBox<String> jComboBoxAnoReferencia;
    public static javax.swing.JComboBox<String> jComboBoxMesReferencia;
    public static javax.swing.JComboBox<String> jComboBoxPrimeiroApt;
    public static javax.swing.JComboBox<String> jComboBoxSegundoApt;
    public static javax.swing.JComboBox<String> jComboBoxTipoCronograma;
    public static com.toedter.calendar.JDateChooser jDataFinalCronograma;
    public static com.toedter.calendar.JDateChooser jDataInicialCronograma;
    public static com.toedter.calendar.JDateChooser jDataPrimeiraFolga;
    public static javax.swing.JTextField jDepartamentoEscala;
    public static javax.swing.JTextField jEscala;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jNomeColaboradorEscala;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JTextField jQuantFolga;
    public static javax.swing.JTextField jQuantTrabalho;
    public static javax.swing.JTextField jTurmaEscala;
    public static javax.swing.JTextField jTurnoEscala;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jCodigoFunc.setBackground(Color.WHITE);
        jNomeColaboradorEscala.setBackground(Color.WHITE);
        jEscala.setBackground(Color.WHITE);
        jQuantTrabalho.setBackground(Color.WHITE);
        jQuantFolga.setBackground(Color.WHITE);
        jTurnoEscala.setBackground(Color.WHITE);
        jTurmaEscala.setBackground(Color.WHITE);
        jDepartamentoEscala.setBackground(Color.WHITE);
        jCargo.setBackground(Color.WHITE);
        jComboBoxMesReferencia.setBackground(Color.WHITE);
        jComboBoxAnoReferencia.setBackground(Color.WHITE);
        jComboBoxTipoCronograma.setBackground(Color.WHITE);
    }

    public void pBUSCAR_dados() {
        pPESQUISAR_colaborador.MOSTRAR_FUNC_cronograma(objEscalas);
        pID_REGISTRO = objEscalas.getIdRegistro();
        jCodigoFunc.setText(String.valueOf(objEscalas.getIdFunc()));
        jNomeColaboradorEscala.setText(objEscalas.getNomeFuncEscala());
        pID_ESCALA = objEscalas.getIdEscala();
        jEscala.setText(objEscalas.getDescricaoEscala());
        jQuantTrabalho.setText(String.valueOf(objEscalas.getQuantidadeTrab()));
        jQuantFolga.setText(String.valueOf(objEscalas.getQuantidadeFolga()));
        jTurnoEscala.setText(objEscalas.getTurno());
        jTurmaEscala.setText(objEscalas.getTurma());
        jDepartamentoEscala.setText(jDepartamento.getText());
        jCargo.setText(jNomeCargo.getText());
    }

    public void pBUSCAR_DADOS_crono() {
        pPESQUISAR_colaborador.MOSTRAR_DADOS_CRONOGRAMA_gravado(objEscalas);
        pID_REGISTRO = objEscalas.getIdRegistro();
        jCodigoFunc.setText(String.valueOf(objEscalas.getIdFunc()));
        jNomeColaboradorEscala.setText(objEscalas.getNomeFuncEscala());
        pID_ESCALA = objEscalas.getIdEscala();
        jEscala.setText(objEscalas.getDescricaoEscala());
        jQuantTrabalho.setText(String.valueOf(objEscalas.getQuantidadeTrab()));
        jQuantFolga.setText(String.valueOf(objEscalas.getQuantidadeFolga()));
        jTurnoEscala.setText(objEscalas.getTurno());
        jTurmaEscala.setText(objEscalas.getTurma());
        jComboBoxPrimeiroApt.setSelectedItem(objEscalas.getPrimeiroApt());
        jComboBoxSegundoApt.setSelectedItem(objEscalas.getSegundoApt());
        jDataInicialCronograma.setDate(objEscalas.getDataInicial());
        jDataFinalCronograma.setDate(objEscalas.getDataFinal());
        jDataPrimeiraFolga.setDate(objEscalas.getDataPrimeiraFolga());
        jDepartamentoEscala.setText(jDepartamento.getText());
        jCargo.setText(jNomeCargo.getText());
        jComboBoxMesReferencia.setSelectedItem(objEscalas.getMesReferencia());
        jComboBoxAnoReferencia.setSelectedItem(objEscalas.getAnoReferencia());
//        jComboBoxTipoCronograma
    }

    public void Novo(boolean opcao) {
        jBtEfetuar.setEnabled(opcao);
    }

    public void Alterar() {

    }

    public void Excluir(boolean opcao) {
        jBtNovo.setEnabled(opcao);
    }

    public void Salvar(boolean opcao) {
        jBtNovo.setEnabled(opcao);
    }

    public void bloquearBotoes(boolean opcao) {
        jBtEfetuar.setEnabled(opcao);
        jBtNovo.setEnabled(opcao);
    }

    public void habilitarCampos(boolean opcao) {
        jComboBoxPrimeiroApt.setEnabled(opcao);
        jComboBoxSegundoApt.setEnabled(opcao);
        jDataInicialCronograma.setEnabled(opcao);
        jDataFinalCronograma.setEnabled(opcao);
        jDataPrimeiraFolga.setEnabled(opcao);
        jComboBoxMesReferencia.setEnabled(opcao);
        jComboBoxAnoReferencia.setEnabled(opcao);
        jComboBoxTipoCronograma.setEnabled(opcao);
    }

    public void limparCampos() {
        jCodigoFunc.setText("");
        jNomeColaboradorEscala.setText("");
        jEscala.setText("");
        jQuantTrabalho.setText("0");
        jQuantFolga.setText("0");
        jComboBoxPrimeiroApt.setSelectedItem("Selecione...");
        jComboBoxSegundoApt.setSelectedItem("Selecione...");
        jDataInicialCronograma.setDate(null);
        jDataFinalCronograma.setDate(null);
        jDataPrimeiraFolga.setDate(null);
        jTurnoEscala.setText("");
        jTurmaEscala.setText("");
        jDepartamentoEscala.setText("");
        jCargo.setText("");
        jComboBoxMesReferencia.setSelectedItem("Selecione...");
        jComboBoxAnoReferencia.setSelectedItem("Selecione...");
        jComboBoxTipoCronograma.setSelectedItem("Selecione...");
    }

    public void calculoDias() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        dataInicial = formatoAmerica.format(jDataInicialCronograma.getDate().getTime());
        dataFinal = formatoAmerica.format(jDataFinalCronograma.getDate().getTime());
        try {
            dataBase = sdf.parse(dataInicial);
            vencimento = sdf.parse(dataFinal);
            long diferencaMS = vencimento.getTime() - dataBase.getTime();
            long diferencaSegundos = diferencaMS / 1000;
            long diferencaMinutos = diferencaSegundos / 60;
            long diferencaHoras = diferencaMinutos / 60;
            long diferencaDias = diferencaHoras / 24;
            totalDias = (int) (long) diferencaDias;
            System.out.println("Total de Dias Calculado: " + totalDias + "\n");
        } catch (ParseException ex) {
            Logger.getLogger(TelaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CALCULAR_datas() {
        pSITUACAO_TRABALHO_folga = "TRABALHANDO";
        inteiro = Integer.parseInt(jQuantTrabalho.getText());
        for (int i = 0; i < totalDias; i++) {
            try {
                d1 = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicial);
                d2 = dateUtils.addDate(Calendar.DAY_OF_MONTH, inteiro, d1);
                GRAVAR_beans();
                CONTROLE_ESCALA_colaborador.incluirCronogramaTrabalhoFolga(objEscalas);
                ++inteiro;
            } catch (ParseException ex) {
                Logger.getLogger(TelaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void CALCULAR_DIAS_folgas_1X1() {
        pDIAS_FOLGA = 0;
        pSITUACAO_TRABALHO_folga = "FOLGA";
        for (int i = 0; i < totalDias; i++) {
            try {
                d3 = new SimpleDateFormat("dd/MM/yyyy").parse(dataPrimeiraFolga);
                d4 = dateUtils.addDate(Calendar.DAY_OF_MONTH, pDIAS_FOLGA, d3);
                objEscalas.setDataCronograma(d4);
                //PESQUISAR DATA PARA COMPARAR E GRAVAR AS FOLGAS
                pPESQUISAR_data();
                if (pDATA_d4c.equals(pDATA_evento)) {
                    objEscalas.setIdFunc(Integer.valueOf(jCodigoFunc.getText()));
                    objEscalas.setStatusTrabFolga(pSITUACAO_TRABALHO_folga);
                    CONTROLE_ESCALA_colaborador.alterarStatusCronogramaTrabalhoFolga(objEscalas);
                }
            } catch (ParseException ex) {
                Logger.getLogger(TelaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
            }
            pDIAS_FOLGA = Integer.parseInt(jQuantFolga.getText()) + pDIAS_FOLGA;
            //COMPARAR AS DATAS INICIAL DE TRABALHO E DATA DA PRIMEIRA FOLGA
            COMPRARA_datas(d3, d4);
            if (opcao == 0) {
                --pDIAS_FOLGA;
            } else if (opcao == 1) {
                ++pDIAS_FOLGA;
            } else if (opcao == 2) {
                ++pDIAS_FOLGA;
            }
        }
    }

    public void COMPRARA_datas(Date a, Date b) {
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        data1 = formatoAmerica.format(jDataInicialCronograma.getDate().getTime());
        data2 = formatoAmerica.format(jDataPrimeiraFolga.getDate().getTime());
        try {
            a = new SimpleDateFormat("dd/MM/yyyy").parse(data1);
            b = new SimpleDateFormat("dd/MM/yyyy").parse(data2);
            a.compareTo(b);
            if (a.after(b)) {
                opcao = 0;
                // DATA a MAIOR QUE b
            } else if (a.before(b)) {
                opcao = 1;
                //DATA a MENOR b
            } else if (a.equals(b)) {
                opcao = 2;
                //DATAS IGUAIS
            }
        } catch (ParseException ex) {
            Logger.getLogger(TelaCronogramaEscala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ADICIONANDO DADOS NA LISTA - NÃO ESTÁ SENDO USADO POR ENQUANTO
    public List<EscalaFolgas> read() throws Exception {

        List<EscalaFolgas> listaDatas = new ArrayList<EscalaFolgas>();
        while (true) {
            EscalaFolgas pLISTA_datas = new EscalaFolgas();
            pLISTA_datas.setDataCronograma(d2);
            listaDatas.add(pLISTA_datas);
            pTOTAL_registros = pTOTAL_registros + 1;
            return listaDatas;
        }
    }

    public void GRAVAR_beans() {
        objEscalas.setIdRegistro(pID_REGISTRO);
        objEscalas.setIdEscala(pID_ESCALA);
        objEscalas.setIdFunc(Integer.valueOf(jCodigoFunc.getText()));
        objEscalas.setDataInicial(jDataInicialCronograma.getDate());
        objEscalas.setDataFinal(jDataFinalCronograma.getDate());
        objEscalas.setPrimeiroApt((String) jComboBoxPrimeiroApt.getSelectedItem());
        objEscalas.setSegundoApt((String) jComboBoxSegundoApt.getSelectedItem());
        objEscalas.setDataCronograma(d2);
        objEscalas.setDataPrimeiraFolga(jDataPrimeiraFolga.getDate());
        objEscalas.setStatusTrabFolga(pSITUACAO_TRABALHO_folga);
        objEscalas.setMesReferencia((String) jComboBoxMesReferencia.getSelectedItem());
        objEscalas.setAnoReferencia((String) jComboBoxAnoReferencia.getSelectedItem());
        objEscalas.setTipoCronograma((String) jComboBoxTipoCronograma.getSelectedItem());
    }

    public void pPESQUISAR_data() {
        CONTROLE_ESCALA_colaborador.PESQUISAR_DATA_Folga(objEscalas);
        pDATA_evento = String.valueOf(pDATA_cronograma);
        String dia = pDATA_evento.substring(8, 10);
        String mes = pDATA_evento.substring(5, 7);
        String ano = pDATA_evento.substring(0, 4);
        pDATA_evento = dia + "/" + mes + "/" + ano;
        //
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        pDATA_d4c = formatoAmerica.format(d4);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
//        objLogSys.setIdLancMov(Integer.valueOf(jIDFunc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserADM = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserADM + "'");
            conecta.rs.first();
            codigoUserGroupADM = conecta.rs.getInt("IdUsuario");
            codigoGrupoADM = conecta.rs.getInt("IdGrupo");
            nomeGrupoADM = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserADM + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoADM = conecta.rs.getInt("IdUsuario");
            codAbrirADM = conecta.rs.getInt("Abrir");
            codIncluirADM = conecta.rs.getInt("Incluir");
            codAlterarADM = conecta.rs.getInt("Alterar");
            codExcluirADM = conecta.rs.getInt("Excluir");
            codGravarADM = conecta.rs.getInt("Gravar");
            codConsultarADM = conecta.rs.getInt("Consultar");
            nomeTelaADM = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
