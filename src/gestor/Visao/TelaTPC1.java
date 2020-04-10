/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAcompanhaEnfermaria;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Modelo.IndicadoresAcompanhamento;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.acao;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.jIdLanc;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.jStatusLanc;
import static gestor.Visao.TelaAdmissaoSecundariaEnfermagem.pGravar;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloEnfermaria.codAbrirENF;
import static gestor.Visao.TelaModuloEnfermaria.codAlterarENF;
import static gestor.Visao.TelaModuloEnfermaria.codConsultarENF;
import static gestor.Visao.TelaModuloEnfermaria.codExcluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codGravarENF;
import static gestor.Visao.TelaModuloEnfermaria.codIncluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codUserAcessoENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserGroupENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeTelaENF;
import static gestor.Visao.TelaModuloEnfermaria.telaIndAcompanhaAbaE;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import static gestor.Visao.TelaAdmissaoEnfermagem.jIdInternoEnfermeiro;
import static gestor.Visao.TelaAdmissaoEnfermagem.jNomeInternoEnfermeiro;

/**
 *
 * @author ronal
 */
public class TelaTPC1 extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    IndicadoresAcompanhamento objPerfilInter = new IndicadoresAcompanhamento();
    ControleAcompanhaEnfermaria controle = new ControleAcompanhaEnfermaria();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    String nomeModuloTela1 = "Indicadores de Acompanhamento:Enfermaria";
    //
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int pAcao;
    int flag;
    int count = 0;
    String dataPAI1;
    //ENFERMARIA
    int qtdDiabetes = 0;
    int qtdHipertensao = 0;
    int qtdEscabiose = 0;
    int qtdHanseniase = 0;
    int qtdSifilis = 0;
    int qtdTuberculose = 0;
    int qtdHib = 0;
    int qtdHepatiteB = 0;
    int qtdHepatiteC = 0;
    int qtdDst = 0;
    int qtdVdlr = 0;
    int qtdVacina = 0;
    //
    public static int codigoEnf = 0;

    /**
     * Creates new form TelaTPC
     */
    public static TelaAdmissaoSecundariaEnfermagem tAEP;
//    public static TelaAuditoriaAcompanhamentoEnfermaria tAAE;

    public TelaTPC1(TelaAdmissaoSecundariaEnfermagem parent, boolean modal) {
        this.tAEP = parent;
        this.setModal(modal);
        setLocationRelativeTo(tAEP);
        initComponents();
        corCampos();
        preencherTabelaEnfermaria("SELECT * FROM ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                + "WHERE IdLanc='" + jIdLanc.getText() + "'");
        //IMPEDIR QUE O USUÁRIO FECHA A TELA PELO X
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //Impedir que a janela seja fechada pelo X    
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (e.getID() == WindowEvent.WINDOW_CLOSING) {
//                    int selectedOption = JOptionPane.showConfirmDialog(null, "Deseja realmente sair da tela?", "Sistema informa:", JOptionPane.YES_NO_OPTION);
//                    if (selectedOption == JOptionPane.YES_OPTION) {
//                        if (pGravar == 0) {
//                            dispose();
//                        }else{
//                            JOptionPane.showMessageDialog(rootPane, "Você não poderá sair da tela sem antes gravar os dados.");
//
//                        }
//                    }
                }
            }
        });
    }

//    public void mostrarAuditoria() {
//        tAAE = new TelaAuditoriaAcompanhamentoEnfermaria(this, true);
//        tAAE.setVisible(true);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel13 = new javax.swing.JPanel();
        jComboBoxHIV = new javax.swing.JComboBox();
        jComboBoxHanseniaseCont = new javax.swing.JComboBox();
        jComboBoxSifilisCont = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jComboBoxHipertensao = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jComboBoxEscabioseCont = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxEscabiose = new javax.swing.JComboBox();
        jComboBoxHepatiteB = new javax.swing.JComboBox();
        jComboBoxTuberculose = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jComboBoxHipertensaoCont = new javax.swing.JComboBox();
        jComboBoxDiabetesCont = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxDiabetes = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        jComboBoxSifilis = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jComboBoxHanseniase = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jComboBoxHepatiteC = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jComboBoxTuberculoseCont = new javax.swing.JComboBox();
        jLabel104 = new javax.swing.JLabel();
        jComboBoxVacina = new javax.swing.JComboBox();
        jLabel106 = new javax.swing.JLabel();
        jComboBoxhepatiteBContro = new javax.swing.JComboBox();
        jLabel107 = new javax.swing.JLabel();
        jComboBoxHepatiteCcurada = new javax.swing.JComboBox();
        jLabel105 = new javax.swing.JLabel();
        jComboBoxVDRL = new javax.swing.JComboBox();
        jLabel108 = new javax.swing.JLabel();
        jComboBoxDST = new javax.swing.JComboBox();
        jDataRegEnfermaria = new com.toedter.calendar.JDateChooser();
        jLabel97 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jComboBoxHIVCont = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jObservacaoEnfermaria = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTabelaEnfermaria = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jBtNovoEnfermaria = new javax.swing.JButton();
        jBtAlterarEnfermaria = new javax.swing.JButton();
        jBtExcluirEnfermaria = new javax.swing.JButton();
        jBtSalvarEnfermaria = new javax.swing.JButton();
        jBtCancelarEnfermaria = new javax.swing.JButton();
        jBtSairEnfermaria = new javax.swing.JButton();
        jBtAuditoriaEnfermaria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Controle de Patologias de Internos :::...");

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jComboBoxHIV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHIV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Reagente", "Reagente", "Não Realizado" }));
        jComboBoxHIV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHIV.setEnabled(false);
        jComboBoxHIV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHIVItemStateChanged(evt);
            }
        });

        jComboBoxHanseniaseCont.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHanseniaseCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxHanseniaseCont.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHanseniaseCont.setEnabled(false);

        jComboBoxSifilisCont.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSifilisCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxSifilisCont.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSifilisCont.setEnabled(false);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Hipertensão?");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Curada?");

        jComboBoxHipertensao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHipertensao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxHipertensao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHipertensao.setEnabled(false);
        jComboBoxHipertensao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHipertensaoItemStateChanged(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Curada?");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Hepatite B?");

        jComboBoxEscabioseCont.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEscabioseCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxEscabioseCont.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEscabioseCont.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Escabiose?");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Curada?");

        jComboBoxEscabiose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEscabiose.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxEscabiose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEscabiose.setEnabled(false);

        jComboBoxHepatiteB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHepatiteB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Reagente", "Reagente", "Não Realizado" }));
        jComboBoxHepatiteB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHepatiteB.setEnabled(false);
        jComboBoxHepatiteB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHepatiteBItemStateChanged(evt);
            }
        });

        jComboBoxTuberculose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTuberculose.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Reagente", "Reagente", "Não Realizado" }));
        jComboBoxTuberculose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTuberculose.setEnabled(false);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Tuberculose?");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("HIV?");

        jComboBoxHipertensaoCont.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHipertensaoCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxHipertensaoCont.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHipertensaoCont.setEnabled(false);
        jComboBoxHipertensaoCont.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHipertensaoContItemStateChanged(evt);
            }
        });

        jComboBoxDiabetesCont.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDiabetesCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxDiabetesCont.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDiabetesCont.setEnabled(false);
        jComboBoxDiabetesCont.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDiabetesContItemStateChanged(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Controlada?");

        jComboBoxDiabetes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDiabetes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxDiabetes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDiabetes.setEnabled(false);
        jComboBoxDiabetes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDiabetesItemStateChanged(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Diabetes?");

        jComboBoxSifilis.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSifilis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Reagente", "Reagente", "Não Realizado" }));
        jComboBoxSifilis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSifilis.setEnabled(false);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Sifilis:");

        jComboBoxHanseniase.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHanseniase.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxHanseniase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHanseniase.setEnabled(false);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Hanseniase?");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Controlada?");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Hepatite C?");

        jComboBoxHepatiteC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHepatiteC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Reagente", "Reagente", "Não Realizado" }));
        jComboBoxHepatiteC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHepatiteC.setEnabled(false);
        jComboBoxHepatiteC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHepatiteCItemStateChanged(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Curada?");

        jComboBoxTuberculoseCont.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTuberculoseCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxTuberculoseCont.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTuberculoseCont.setEnabled(false);

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel104.setText("T. DST?");

        jComboBoxVacina.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxVacina.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxVacina.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxVacina.setEnabled(false);

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel106.setText("Controlada?");

        jComboBoxhepatiteBContro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxhepatiteBContro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxhepatiteBContro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxhepatiteBContro.setEnabled(false);
        jComboBoxhepatiteBContro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxhepatiteBControItemStateChanged(evt);
            }
        });

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel107.setText("Controlada?");

        jComboBoxHepatiteCcurada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHepatiteCcurada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxHepatiteCcurada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHepatiteCcurada.setEnabled(false);
        jComboBoxHepatiteCcurada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHepatiteCcuradaItemStateChanged(evt);
            }
        });

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel105.setText("VDLR:");

        jComboBoxVDRL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxVDRL.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Reagente", "Reagente", "Não Realizado" }));
        jComboBoxVDRL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxVDRL.setEnabled(false);

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel108.setText("Vacina:");

        jComboBoxDST.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDST.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxDST.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDST.setEnabled(false);
        jComboBoxDST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDSTActionPerformed(evt);
            }
        });

        jDataRegEnfermaria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRegEnfermaria.setEnabled(false);

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel97.setText("Data Registro");

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel109.setText("Controlada?");

        jComboBoxHIVCont.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxHIVCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "N/R" }));
        jComboBoxHIVCont.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxHIVCont.setEnabled(false);
        jComboBoxHIVCont.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHIVContItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Observação:");

        jObservacaoEnfermaria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoEnfermaria.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBoxHepatiteC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxHepatiteB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxHIV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBoxHipertensao, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxDiabetes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxHanseniase, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxEscabiose, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jComboBoxSifilis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBoxTuberculose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(1, 1, 1)))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel106, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel107, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxHipertensaoCont, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxDiabetesCont, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxHanseniaseCont, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxSifilisCont, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxTuberculoseCont, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxhepatiteBContro, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxEscabioseCont, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxHepatiteCcurada, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel105, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel108, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel109)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxHIVCont, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel104)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxVDRL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataRegEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel97))
                            .addComponent(jComboBoxDST, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jObservacaoEnfermaria))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel31)
                            .addComponent(jComboBoxDiabetes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel30)
                            .addComponent(jComboBoxHipertensao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel40)
                            .addComponent(jComboBoxEscabiose, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jComboBoxHanseniase, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxDiabetesCont, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxHipertensaoCont, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel97)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataRegEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxEscabioseCont, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxHanseniaseCont, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel33)
                    .addComponent(jComboBoxSifilis, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jComboBoxSifilisCont, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel32)
                    .addComponent(jLabel21)
                    .addComponent(jComboBoxTuberculose, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTuberculoseCont, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel34)
                    .addComponent(jComboBoxHIV, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel104)
                    .addComponent(jComboBoxDST, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxHIVCont, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel109)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxhepatiteBContro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jComboBoxHepatiteB, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel106)
                    .addComponent(jLabel108)
                    .addComponent(jComboBoxVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel37)
                    .addComponent(jComboBoxHepatiteC, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107)
                    .addComponent(jComboBoxHepatiteCcurada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel105)
                        .addComponent(jComboBoxVDRL, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jObservacaoEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaEnfermaria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEnfermaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Data", "Diabetes", "Controlada", "Hipertensão", "Controlada", "Escabiose", "Curada", "Hanseniase", "Curada", "Sifilis", "Curada", "Tuberculose", "Curada", "HIV", "Controlada", "Hepatite B", "Controlada", "Hepatite C", "Controlada"
            }
        ));
        jTabelaEnfermaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEnfermariaMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTabelaEnfermaria);
        if (jTabelaEnfermaria.getColumnModel().getColumnCount() > 0) {
            jTabelaEnfermaria.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaEnfermaria.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaEnfermaria.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaEnfermaria.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaEnfermaria.getColumnModel().getColumn(2).setMinWidth(60);
            jTabelaEnfermaria.getColumnModel().getColumn(2).setMaxWidth(60);
            jTabelaEnfermaria.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaEnfermaria.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaEnfermaria.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaEnfermaria.getColumnModel().getColumn(4).setMaxWidth(80);
            jTabelaEnfermaria.getColumnModel().getColumn(5).setMinWidth(80);
            jTabelaEnfermaria.getColumnModel().getColumn(5).setMaxWidth(80);
            jTabelaEnfermaria.getColumnModel().getColumn(6).setMinWidth(80);
            jTabelaEnfermaria.getColumnModel().getColumn(6).setMaxWidth(80);
            jTabelaEnfermaria.getColumnModel().getColumn(7).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(7).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(8).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(8).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(9).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(9).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(10).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(10).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(11).setMinWidth(60);
            jTabelaEnfermaria.getColumnModel().getColumn(11).setMaxWidth(60);
            jTabelaEnfermaria.getColumnModel().getColumn(12).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(12).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(13).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(13).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(14).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(14).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(15).setMinWidth(60);
            jTabelaEnfermaria.getColumnModel().getColumn(15).setMaxWidth(60);
            jTabelaEnfermaria.getColumnModel().getColumn(16).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(16).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(17).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(17).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(18).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(18).setMaxWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(19).setMinWidth(70);
            jTabelaEnfermaria.getColumnModel().getColumn(19).setMaxWidth(70);
        }

        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtNovoEnfermaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoEnfermaria.setText("Novo");
        jBtNovoEnfermaria.setContentAreaFilled(false);
        jBtNovoEnfermaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoEnfermaria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoEnfermaria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoEnfermariaActionPerformed(evt);
            }
        });

        jBtAlterarEnfermaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jBtAlterarEnfermaria.setText("Alterar");
        jBtAlterarEnfermaria.setContentAreaFilled(false);
        jBtAlterarEnfermaria.setEnabled(false);
        jBtAlterarEnfermaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarEnfermaria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarEnfermaria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarEnfermariaActionPerformed(evt);
            }
        });

        jBtExcluirEnfermaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirEnfermaria.setText("Excluir");
        jBtExcluirEnfermaria.setContentAreaFilled(false);
        jBtExcluirEnfermaria.setEnabled(false);
        jBtExcluirEnfermaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirEnfermaria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirEnfermaria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEnfermariaActionPerformed(evt);
            }
        });

        jBtSalvarEnfermaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarEnfermaria.setText("Gravar");
        jBtSalvarEnfermaria.setContentAreaFilled(false);
        jBtSalvarEnfermaria.setEnabled(false);
        jBtSalvarEnfermaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarEnfermaria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarEnfermaria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEnfermariaActionPerformed(evt);
            }
        });

        jBtCancelarEnfermaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEnfermaria.setText("Cancelar");
        jBtCancelarEnfermaria.setContentAreaFilled(false);
        jBtCancelarEnfermaria.setEnabled(false);
        jBtCancelarEnfermaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarEnfermaria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarEnfermaria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarEnfermariaActionPerformed(evt);
            }
        });

        jBtSairEnfermaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairEnfermaria.setText("Sair");
        jBtSairEnfermaria.setContentAreaFilled(false);
        jBtSairEnfermaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairEnfermaria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairEnfermaria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairEnfermariaActionPerformed(evt);
            }
        });

        jBtAuditoriaEnfermaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaEnfermaria.setToolTipText("Auditoria");
        jBtAuditoriaEnfermaria.setContentAreaFilled(false);
        jBtAuditoriaEnfermaria.setEnabled(false);
        jBtAuditoriaEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaEnfermariaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jBtNovoEnfermaria)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterarEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluirEnfermaria)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvarEnfermaria)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelarEnfermaria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairEnfermaria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtAlterarEnfermaria)
                .addComponent(jBtExcluirEnfermaria)
                .addComponent(jBtNovoEnfermaria)
                .addComponent(jBtSalvarEnfermaria)
                .addComponent(jBtCancelarEnfermaria)
                .addComponent(jBtSairEnfermaria)
                .addComponent(jBtAuditoriaEnfermaria))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxHIVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHIVItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxHIV.getSelectedItem().equals("Reagente")) {
            jComboBoxHIVCont.setSelectedItem("Sim");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxHIV.getSelectedItem().equals("Não Reagente")) {
            jComboBoxHIVCont.setSelectedItem("Não");
        }
    }//GEN-LAST:event_jComboBoxHIVItemStateChanged

    private void jComboBoxHipertensaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHipertensaoItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxHipertensao.getSelectedItem().equals("Sim")) {
            jComboBoxHipertensaoCont.setSelectedItem("Sim");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxHipertensao.getSelectedItem().equals("Não")) {
            jComboBoxHipertensaoCont.setSelectedItem("Não");
        }
    }//GEN-LAST:event_jComboBoxHipertensaoItemStateChanged

    private void jComboBoxHepatiteBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHepatiteBItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxHepatiteB.getSelectedItem().equals("Reagente")) {
            jComboBoxhepatiteBContro.setSelectedItem("Sim");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxHepatiteB.getSelectedItem().equals("Não Reagente")) {
            jComboBoxhepatiteBContro.setSelectedItem("Não");
        }
    }//GEN-LAST:event_jComboBoxHepatiteBItemStateChanged

    private void jComboBoxHipertensaoContItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHipertensaoContItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxHipertensaoCont.getSelectedItem().equals("Sim")) {
            jComboBoxHipertensao.setSelectedItem("Sim");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxHipertensaoCont.getSelectedItem().equals("Não")) {
            jComboBoxHipertensao.setSelectedItem("Não");
        }
    }//GEN-LAST:event_jComboBoxHipertensaoContItemStateChanged

    private void jComboBoxDiabetesContItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDiabetesContItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxDiabetesCont.getSelectedItem().equals("Sim")) {
            jComboBoxDiabetes.setSelectedItem("Sim");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxDiabetesCont.getSelectedItem().equals("Não")) {
            jComboBoxDiabetes.setSelectedItem("Não");
        }
    }//GEN-LAST:event_jComboBoxDiabetesContItemStateChanged

    private void jComboBoxDiabetesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDiabetesItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxDiabetes.getSelectedItem().equals("Sim")) {
            jComboBoxDiabetesCont.setSelectedItem("Sim");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxDiabetes.getSelectedItem().equals("Não")) {
            jComboBoxDiabetesCont.setSelectedItem("Não");
        }
    }//GEN-LAST:event_jComboBoxDiabetesItemStateChanged

    private void jComboBoxHepatiteCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHepatiteCItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxHepatiteC.getSelectedItem().equals("Reagente")) {
            jComboBoxHepatiteCcurada.setSelectedItem("Sim");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxHepatiteC.getSelectedItem().equals("Não Reagente")) {
            jComboBoxHepatiteCcurada.setSelectedItem("Não");
        }
    }//GEN-LAST:event_jComboBoxHepatiteCItemStateChanged

    private void jComboBoxhepatiteBControItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxhepatiteBControItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxhepatiteBContro.getSelectedItem().equals("Sim")) {
            jComboBoxHepatiteB.setSelectedItem("Reagente");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxhepatiteBContro.getSelectedItem().equals("Não")) {
            jComboBoxHepatiteB.setSelectedItem("Não Reagente");
        }
    }//GEN-LAST:event_jComboBoxhepatiteBControItemStateChanged

    private void jComboBoxHepatiteCcuradaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHepatiteCcuradaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxHepatiteCcurada.getSelectedItem().equals("Sim")) {
            jComboBoxHepatiteC.setSelectedItem("Reagente");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxHepatiteCcurada.getSelectedItem().equals("Não")) {
            jComboBoxHepatiteC.setSelectedItem("Não Reagente");
        }
    }//GEN-LAST:event_jComboBoxHepatiteCcuradaItemStateChanged

    private void jComboBoxDSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDSTActionPerformed

    private void jComboBoxHIVContItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHIVContItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED && jComboBoxHIVCont.getSelectedItem().equals("Sim")) {
            jComboBoxHIV.setSelectedItem("Reagente");
        } else if (evt.getStateChange() == evt.SELECTED && jComboBoxHIVCont.getSelectedItem().equals("Não")) {
            jComboBoxHIV.setSelectedItem("Não Reagente");
        }
    }//GEN-LAST:event_jComboBoxHIVContItemStateChanged

    private void jTabelaEnfermariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEnfermariaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idEnf = "" + jTabelaEnfermaria.getValueAt(jTabelaEnfermaria.getSelectedRow(), 0);
            String idIndAco = "" + jTabelaEnfermaria.getValueAt(jTabelaEnfermaria.getSelectedRow(), 1);
            bloquearCampos();
            bloquearBotoes();
            //ENFERMAGEM
            jBtNovoEnfermaria.setEnabled(true);
            jBtAlterarEnfermaria.setEnabled(true);
            jBtExcluirEnfermaria.setEnabled(true);
            jBtAuditoriaEnfermaria.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                        + "INNER JOIN ADMISSAOENFERMEIRA "
                        + "ON ACOMPANHAMENTO_INTERNO_ENFERMARIA.IdLanc=ADMISSAOENFERMEIRA.IdLanc "
                        + "WHERE ACOMPANHAMENTO_INTERNO_ENFERMARIA.IdEnf='" + idEnf + "' "
                        + "AND ACOMPANHAMENTO_INTERNO_ENFERMARIA.IdLanc='" + idIndAco + "'");
                conecta.rs.first();
                codigoEnf = conecta.rs.getInt("IdEnf");
                jComboBoxDiabetes.setSelectedItem(conecta.rs.getString("Diabetes"));
                jComboBoxDiabetesCont.setSelectedItem(conecta.rs.getString("DiabControl"));
                jComboBoxHipertensao.setSelectedItem(conecta.rs.getString("Hipertensao"));
                jComboBoxHipertensaoCont.setSelectedItem(conecta.rs.getString("HiperControl"));
                jComboBoxEscabiose.setSelectedItem(conecta.rs.getString("Escabiose"));
                jComboBoxEscabioseCont.setSelectedItem(conecta.rs.getString("EscabioseCura"));
                jComboBoxHanseniase.setSelectedItem(conecta.rs.getString("Hanseniase"));
                jComboBoxHanseniaseCont.setSelectedItem(conecta.rs.getString("HanseniaseCura"));
                jComboBoxSifilis.setSelectedItem(conecta.rs.getString("Sifilis"));
                jComboBoxSifilisCont.setSelectedItem(conecta.rs.getString("SifilisCura"));
                jComboBoxTuberculose.setSelectedItem(conecta.rs.getString("Tuberculose"));
                jComboBoxTuberculoseCont.setSelectedItem(conecta.rs.getString("TuberculoseCura"));
                jComboBoxHIV.setSelectedItem(conecta.rs.getString("Hiv"));
                jComboBoxHIVCont.setSelectedItem(conecta.rs.getString("HivControlada"));
                jComboBoxHepatiteB.setSelectedItem(conecta.rs.getString("HepatiteB"));
                jComboBoxhepatiteBContro.setSelectedItem(conecta.rs.getString("HepatiteBCont"));
                jComboBoxHepatiteC.setSelectedItem(conecta.rs.getString("HepatiteC"));
                jComboBoxHepatiteCcurada.setSelectedItem(conecta.rs.getString("HepatiteCCont"));
                jComboBoxDST.setSelectedItem(conecta.rs.getString("Dst"));
                jComboBoxVDRL.setSelectedItem(conecta.rs.getString("Vdlr"));
                jComboBoxVacina.setSelectedItem(conecta.rs.getString("Vacina"));
                jDataRegEnfermaria.setDate(conecta.rs.getDate("DataReg"));
                jObservacaoEnfermaria.setText(conecta.rs.getString("Observacao"));
            } catch (SQLException e) {
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaEnfermariaMouseClicked

    private void jBtNovoEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoEnfermariaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaAbaE);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaAbaE) && codIncluirENF == 1) {
            if (acao == 5 || acao == 6) {
                pAcao = 7;
                pGravar = 0;
                bloquearCampos();
                bloquearBotoes();
                NovoEnfermaria();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            } else {
                JOptionPane.showMessageDialog(null, "Para incluir um registro é necessário está em modo alteração do atendimento/evolução.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoEnfermariaActionPerformed

    private void jBtAlterarEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEnfermariaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaAbaE);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaAbaE) && codAlterarENF == 1) {
            objPerfilInter.setStatusPerfil(jStatusLanc.getText());
            if (acao == 5 || acao == 6) {
                pAcao = 8;
                pGravar = 0;
                bloquearCampos();
                bloquearBotoes();
                AlterarEnfermaria();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            } else {
                JOptionPane.showMessageDialog(null, "Para alterar um registro é necessário está em modo alteração do atendimento/evolução.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarEnfermariaActionPerformed

    private void jBtExcluirEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEnfermariaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaAbaE);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaAbaE) && codExcluirENF == 1) {
            if (acao == 5 || acao == 6) {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    bloquearCampos();
                    bloquearBotoes();
                    objPerfilInter.setIdEnf(codigoEnf);
                    objPerfilInter.setIdIndAco(Integer.valueOf(jIdLanc.getText()));
                    controle.excluirAcompanhamentoEnfermaria(objPerfilInter);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    ExcluirEnfermaria();
                    preencherTabelaEnfermaria("SELECT * FROM ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                            + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Para excluir um registro é necessário está em modo alteração do atendimento/evolução.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirEnfermariaActionPerformed

    private void jBtSalvarEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEnfermariaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAcompanhaAbaE);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES") || codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaIndAcompanhaAbaE) && codGravarENF == 1) {
            objPerfilInter.setIdIndAco(Integer.valueOf(jIdLanc.getText()));
            objPerfilInter.setIdInternoCrc(Integer.valueOf(jIdInternoEnfermeiro.getText()));
            objPerfilInter.setNomeInternoPerfil(jNomeInternoEnfermeiro.getText());
            objPerfilInter.setHipertensao((String) jComboBoxHipertensao.getSelectedItem());
            objPerfilInter.setEscabiose((String) jComboBoxEscabiose.getSelectedItem());
            objPerfilInter.setEscabioseCura((String) jComboBoxEscabioseCont.getSelectedItem());
            objPerfilInter.setHanseniase((String) jComboBoxHanseniase.getSelectedItem());
            objPerfilInter.setSifilis((String) jComboBoxSifilis.getSelectedItem());
            objPerfilInter.setTuberculose((String) jComboBoxTuberculose.getSelectedItem());
            objPerfilInter.setDiabetes((String) jComboBoxDiabetes.getSelectedItem());
            objPerfilInter.setDiabControl((String) jComboBoxDiabetesCont.getSelectedItem());
            objPerfilInter.setHiperControl((String) jComboBoxHipertensaoCont.getSelectedItem());
            objPerfilInter.setHanseniaseCura((String) jComboBoxHanseniaseCont.getSelectedItem());
            objPerfilInter.setSifilisCura((String) jComboBoxSifilisCont.getSelectedItem());
            objPerfilInter.setTuberculoseCura((String) jComboBoxTuberculoseCont.getSelectedItem());
            objPerfilInter.setHiv((String) jComboBoxHIV.getSelectedItem());
            objPerfilInter.setHivControlada((String) jComboBoxHIVCont.getSelectedItem());
            objPerfilInter.setHepatiteB((String) jComboBoxHepatiteB.getSelectedItem());
            objPerfilInter.setHepatiBCont((String) jComboBoxhepatiteBContro.getSelectedItem());
            objPerfilInter.setHepatiteC((String) jComboBoxHepatiteC.getSelectedItem());
            objPerfilInter.setHepatiCcont((String) jComboBoxHepatiteCcurada.getSelectedItem());
            objPerfilInter.setDst((String) jComboBoxDST.getSelectedItem());
            objPerfilInter.setvDLR((String) jComboBoxVDRL.getSelectedItem());
            objPerfilInter.setVacina((String) jComboBoxVacina.getSelectedItem());
            objPerfilInter.setDataReg(jDataRegEnfermaria.getDate());
            objPerfilInter.setObservacaoEnf(jObservacaoEnfermaria.getText());
            //
            if (jComboBoxDiabetesCont.getSelectedItem().equals("Sim")) {
                qtdDiabetes = 1;
                objPerfilInter.setQtdDiabetes(qtdDiabetes);
            } else if (jComboBoxDiabetesCont.getSelectedItem().equals("Não")) {
                qtdDiabetes = 0;
                objPerfilInter.setQtdDiabetes(qtdDiabetes);
            }
            if (jComboBoxHipertensaoCont.getSelectedItem().equals("Sim")) {
                qtdHipertensao = 1;
                objPerfilInter.setQtdHipertensao(qtdHipertensao);
            } else if (jComboBoxHipertensaoCont.getSelectedItem().equals("Não")) {
                qtdHipertensao = 0;
                objPerfilInter.setQtdHipertensao(qtdHipertensao);
            }
            if (jComboBoxEscabioseCont.getSelectedItem().equals("Sim")) {
                qtdEscabiose = 1;
                objPerfilInter.setQtdEscabiose(qtdEscabiose);
            } else if (jComboBoxEscabioseCont.getSelectedItem().equals("Não")) {
                qtdEscabiose = 0;
                objPerfilInter.setQtdEscabiose(qtdEscabiose);
            }
            if (jComboBoxHanseniaseCont.getSelectedItem().equals("Sim")) {
                qtdHanseniase = 1;
                objPerfilInter.setQtdHanseniase(qtdHanseniase);
            } else if (jComboBoxHanseniaseCont.getSelectedItem().equals("Não")) {
                qtdHanseniase = 0;
                objPerfilInter.setQtdHanseniase(qtdHanseniase);
            }
            if (jComboBoxSifilisCont.getSelectedItem().equals("Sim")) {
                qtdSifilis = 1;
                objPerfilInter.setQtdSifilis(qtdSifilis);
            } else if (jComboBoxSifilisCont.getSelectedItem().equals("Não")) {
                qtdSifilis = 0;
                objPerfilInter.setQtdSifilis(qtdSifilis);
            }
            if (jComboBoxTuberculoseCont.getSelectedItem().equals("Sim")) {
                qtdTuberculose = 1;
                objPerfilInter.setQtdTuberculose(qtdTuberculose);
            } else if (jComboBoxTuberculoseCont.getSelectedItem().equals("Não")) {
                qtdTuberculose = 0;
                objPerfilInter.setQtdTuberculose(qtdTuberculose);
            }
            if (jComboBoxHIVCont.getSelectedItem().equals("Sim")) {
                qtdHib = 1;
                objPerfilInter.setQtdHib(qtdHib);
            } else if (jComboBoxHIVCont.getSelectedItem().equals("Não")) {
                qtdHib = 0;
                objPerfilInter.setQtdHib(qtdHib);
            }
            if (jComboBoxhepatiteBContro.getSelectedItem().equals("Sim")) {
                qtdHepatiteB = 1;
                objPerfilInter.setQtdHepatiteB(qtdHepatiteB);
            } else if (jComboBoxhepatiteBContro.getSelectedItem().equals("Não")) {
                qtdHepatiteB = 0;
                objPerfilInter.setQtdHepatiteB(qtdHepatiteB);
            }
            if (jComboBoxHepatiteCcurada.getSelectedItem().equals("Sim")) {
                qtdHepatiteC = 1;
                objPerfilInter.setQtdHepatiteC(qtdHepatiteC);
            } else if (jComboBoxHepatiteCcurada.getSelectedItem().equals("Não")) {
                qtdHepatiteC = 0;
                objPerfilInter.setQtdHepatiteC(qtdHepatiteC);
            }
            if (jComboBoxDST.getSelectedItem().equals("Sim")) {
                qtdDst = 1;
                objPerfilInter.setQdtDst(qtdDst);
            } else if (jComboBoxDST.getSelectedItem().equals("Não")) {
                qtdDst = 0;
                objPerfilInter.setQdtDst(qtdDst);
            }
            if (jComboBoxVacina.getSelectedItem().equals("Sim")) {
                qtdVacina = 1;
                objPerfilInter.setQtdVacina(qtdVacina);
            } else if (jComboBoxVacina.getSelectedItem().equals("Não")) {
                qtdVacina = 0;
                objPerfilInter.setQtdVacina(qtdVacina);
            }
            if (jComboBoxVDRL.getSelectedItem().equals("Reagente")) {
                qtdVdlr = 1;
                objPerfilInter.setQtdVdlr(qtdVdlr);
            } else if (jComboBoxVDRL.getSelectedItem().equals("Não Reagente")) {
                qtdVdlr = 0;
                objPerfilInter.setQtdVdlr(qtdVdlr);
            }
            if (pAcao == 7) {
                objPerfilInter.setUsuarioInsert(nameUser);
                objPerfilInter.setDataInsert(dataModFinal);
                objPerfilInter.setHorarioInsert(horaMov);
                //
                controle.incluirAcompanhamentoEnfermaria(objPerfilInter);
                buscarCodigoEnfermaria();
                //
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                bloquearBotoes();
                SalvarEnfermaria();
                zerarVariaveis();
                pGravar = 1;
                preencherTabelaEnfermaria("SELECT * FROM ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                        + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
            if (pAcao == 8) {
                objPerfilInter.setUsuarioUp(nameUser);
                objPerfilInter.setDataUp(dataModFinal);
                objPerfilInter.setHorarioUp(horaMov);
                //
                objPerfilInter.setIdEnf(codigoEnf);
                objPerfilInter.setIdIndAco(Integer.valueOf(jIdLanc.getText()));
                controle.alterarAcompanhamentoEnfermaria(objPerfilInter);
                //
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                bloquearBotoes();
                SalvarEnfermaria();
                zerarVariaveis();
                pGravar = 2;
                preencherTabelaEnfermaria("SELECT * FROM ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                        + "WHERE IdLanc='" + jIdLanc.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarEnfermariaActionPerformed

    private void jBtCancelarEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEnfermariaActionPerformed
        // TODO add your handling code here:
        bloquearCampos();
        bloquearBotoes();
        CancelarEnfermaria();
    }//GEN-LAST:event_jBtCancelarEnfermariaActionPerformed

    private void jBtSairEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairEnfermariaActionPerformed
        // TODO add your handling code here:
        // SE pGravar IGUAL A 1 - GRAVOU A INCLUSÃO
        // SE pGravar IGUAL A 2 - GRAVOU A ALTERAÇÃO
        if (pGravar == 1 || pGravar == 2) {
            acao = 5;
            dispose();
        } else if (pAcao == 7 && pGravar == 1) {
            dispose();
        } else if (pAcao == 8 && pGravar == 2) {
            dispose();
        } else if (pGravar == 0 && pAcao == 7) {
            JOptionPane.showMessageDialog(rootPane, "Será necessário gravar os dados do acompanhamento do interno.");
        } else if (pGravar == 0 && pAcao == 8) {
            JOptionPane.showMessageDialog(rootPane, "Será necessário gravar os dados do acompanhamento do interno.");
        } else if (pAcao == 0) {
            dispose();
        }
    }//GEN-LAST:event_jBtSairEnfermariaActionPerformed

    private void jBtAuditoriaEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEnfermariaActionPerformed
        // TODO add your handling code here:TelaAuditoriaAcompanhamentoEnfermaria
//        mostrarAuditoria();
    }//GEN-LAST:event_jBtAuditoriaEnfermariaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaTPC1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTPC1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTPC1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTPC1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaTPC1 dialog = new TelaTPC1(tAEP, true);
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
    private javax.swing.JButton jBtAlterarEnfermaria;
    private javax.swing.JButton jBtAuditoriaEnfermaria;
    private javax.swing.JButton jBtCancelarEnfermaria;
    private javax.swing.JButton jBtExcluirEnfermaria;
    private javax.swing.JButton jBtNovoEnfermaria;
    private javax.swing.JButton jBtSairEnfermaria;
    private javax.swing.JButton jBtSalvarEnfermaria;
    private javax.swing.JComboBox jComboBoxDST;
    private javax.swing.JComboBox jComboBoxDiabetes;
    private javax.swing.JComboBox jComboBoxDiabetesCont;
    private javax.swing.JComboBox jComboBoxEscabiose;
    private javax.swing.JComboBox jComboBoxEscabioseCont;
    private javax.swing.JComboBox jComboBoxHIV;
    private javax.swing.JComboBox jComboBoxHIVCont;
    private javax.swing.JComboBox jComboBoxHanseniase;
    private javax.swing.JComboBox jComboBoxHanseniaseCont;
    private javax.swing.JComboBox jComboBoxHepatiteB;
    private javax.swing.JComboBox jComboBoxHepatiteC;
    private javax.swing.JComboBox jComboBoxHepatiteCcurada;
    private javax.swing.JComboBox jComboBoxHipertensao;
    private javax.swing.JComboBox jComboBoxHipertensaoCont;
    private javax.swing.JComboBox jComboBoxSifilis;
    private javax.swing.JComboBox jComboBoxSifilisCont;
    private javax.swing.JComboBox jComboBoxTuberculose;
    private javax.swing.JComboBox jComboBoxTuberculoseCont;
    private javax.swing.JComboBox jComboBoxVDRL;
    private javax.swing.JComboBox jComboBoxVacina;
    private javax.swing.JComboBox jComboBoxhepatiteBContro;
    private com.toedter.calendar.JDateChooser jDataRegEnfermaria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JTextField jObservacaoEnfermaria;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTabelaEnfermaria;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jObservacaoEnfermaria.setBackground(Color.white);
    }

    public void bloquearBotoes() {
        //ENFERMARIA
        jBtNovoEnfermaria.setEnabled(!true);
        jBtAlterarEnfermaria.setEnabled(!true);
        jBtExcluirEnfermaria.setEnabled(!true);
        jBtSalvarEnfermaria.setEnabled(!true);
        jBtCancelarEnfermaria.setEnabled(!true);
        jBtAuditoriaEnfermaria.setEnabled(!true);
    }

    public void bloquearCampos() {
        // ENFERMARIA
        jComboBoxDiabetes.setEnabled(!true);
        jComboBoxHipertensao.setEnabled(!true);
        jComboBoxEscabiose.setEnabled(!true);
        jComboBoxHanseniase.setEnabled(!true);
        jComboBoxSifilis.setEnabled(!true);
        jComboBoxTuberculose.setEnabled(!true);
        jComboBoxDiabetesCont.setEnabled(!true);
        jComboBoxHipertensaoCont.setEnabled(!true);
        jComboBoxEscabioseCont.setEnabled(!true);
        jComboBoxHanseniaseCont.setEnabled(!true);
        jComboBoxSifilisCont.setEnabled(!true);
        jComboBoxTuberculoseCont.setEnabled(!true);
        jComboBoxHIV.setEnabled(!true);
        jComboBoxHIVCont.setEnabled(!true);
        jComboBoxDST.setEnabled(!true);
        jComboBoxVDRL.setEnabled(!true);
        jComboBoxHepatiteB.setEnabled(!true);
        jComboBoxHepatiteC.setEnabled(!true);
        jDataRegEnfermaria.setEnabled(!true);
        jComboBoxVacina.setEnabled(!true);
        jComboBoxhepatiteBContro.setEnabled(!true);
        jComboBoxHepatiteCcurada.setEnabled(!true);
        jObservacaoEnfermaria.setEnabled(!true);
    }

    public void limparCamposNovo() {
        // ENFERMARIA
        jComboBoxDiabetes.setSelectedItem("Não");
        jComboBoxHipertensao.setSelectedItem("Não");
        jComboBoxEscabiose.setSelectedItem("Não");
        jComboBoxHanseniase.setSelectedItem("Não");
        jComboBoxSifilis.setSelectedItem("Não");
        jComboBoxTuberculose.setSelectedItem("Não");
        jComboBoxDiabetesCont.setSelectedItem("Não");
        jComboBoxHipertensaoCont.setSelectedItem("Não");
        jComboBoxEscabioseCont.setSelectedItem("Não");
        jComboBoxHanseniaseCont.setSelectedItem("Não");
        jComboBoxSifilisCont.setSelectedItem("Não");
        jComboBoxTuberculoseCont.setSelectedItem("Não");
        jComboBoxHIV.setSelectedItem("Não");
        jComboBoxHIVCont.setSelectedItem("Não");
        jComboBoxDST.setSelectedItem("Não");
        jComboBoxVDRL.setSelectedItem("Não Reagente");
        jComboBoxHepatiteB.setSelectedItem("Não");
        jComboBoxHepatiteC.setSelectedItem("Não");
        jDataRegEnfermaria.setDate(null);
        jComboBoxVacina.setSelectedItem("Não");
        jComboBoxhepatiteBContro.setSelectedItem("Não");
        jComboBoxHepatiteCcurada.setSelectedItem("Não");
        jObservacaoEnfermaria.setText("");
    }

    public void NovoEnfermaria() {
        jComboBoxDiabetes.setSelectedItem("Não");
        jComboBoxHipertensao.setSelectedItem("Não");
        jComboBoxEscabiose.setSelectedItem("Não");
        jComboBoxHanseniase.setSelectedItem("Não");
        jComboBoxSifilis.setSelectedItem("Não");
        jComboBoxTuberculose.setSelectedItem("Não");
        jComboBoxDiabetesCont.setSelectedItem("Não");
        jComboBoxHipertensaoCont.setSelectedItem("Não");
        jComboBoxEscabioseCont.setSelectedItem("Não");
        jComboBoxHanseniaseCont.setSelectedItem("Não");
        jComboBoxSifilisCont.setSelectedItem("Não");
        jComboBoxTuberculoseCont.setSelectedItem("Não");
        jComboBoxHIV.setSelectedItem("Não");
        jComboBoxHepatiteB.setSelectedItem("Não");
        jComboBoxHepatiteC.setSelectedItem("Não");
        jDataRegEnfermaria.setDate(null);
        jObservacaoEnfermaria.setText("");
        //
        jComboBoxDiabetes.setEnabled(true);
        jComboBoxHipertensao.setEnabled(true);
        jComboBoxEscabiose.setEnabled(true);
        jComboBoxHanseniase.setEnabled(true);
        jComboBoxSifilis.setEnabled(true);
        jComboBoxTuberculose.setEnabled(true);
        jComboBoxDiabetesCont.setEnabled(true);
        jComboBoxHipertensaoCont.setEnabled(true);
        jComboBoxEscabioseCont.setEnabled(true);
        jComboBoxHanseniaseCont.setEnabled(true);
        jComboBoxSifilisCont.setEnabled(true);
        jComboBoxTuberculoseCont.setEnabled(true);
        jComboBoxHIV.setEnabled(true);
        jComboBoxHIVCont.setEnabled(true);
        jComboBoxDST.setEnabled(true);
        jComboBoxVDRL.setEnabled(true);
        jComboBoxHepatiteB.setEnabled(true);
        jComboBoxHepatiteC.setEnabled(true);
        jComboBoxVacina.setEnabled(true);
        jComboBoxhepatiteBContro.setEnabled(true);
        jComboBoxHepatiteCcurada.setEnabled(true);
        jObservacaoEnfermaria.setEnabled(true);
        //
        jDataRegEnfermaria.setEnabled(true);
        jDataRegEnfermaria.setCalendar(Calendar.getInstance());
        //
        jBtSalvarEnfermaria.setEnabled(true);
        jBtCancelarEnfermaria.setEnabled(true);
    }

    public void AlterarEnfermaria() {
        jComboBoxDiabetes.setEnabled(true);
        jComboBoxHipertensao.setEnabled(true);
        jComboBoxEscabiose.setEnabled(true);
        jComboBoxHanseniase.setEnabled(true);
        jComboBoxSifilis.setEnabled(true);
        jComboBoxTuberculose.setEnabled(true);
        jComboBoxDiabetesCont.setEnabled(true);
        jComboBoxHipertensaoCont.setEnabled(true);
        jComboBoxEscabioseCont.setEnabled(true);
        jComboBoxHanseniaseCont.setEnabled(true);
        jComboBoxSifilisCont.setEnabled(true);
        jComboBoxTuberculoseCont.setEnabled(true);
        jComboBoxHIV.setEnabled(true);
        jComboBoxHIVCont.setEnabled(true);
        jComboBoxDST.setEnabled(true);
        jComboBoxVDRL.setEnabled(true);
        jComboBoxHepatiteB.setEnabled(true);
        jComboBoxHepatiteC.setEnabled(true);
        jComboBoxVacina.setEnabled(true);
        jComboBoxhepatiteBContro.setEnabled(true);
        jComboBoxHepatiteCcurada.setEnabled(true);
        jObservacaoEnfermaria.setEnabled(true);
        //
        jBtSalvarEnfermaria.setEnabled(true);
        jBtCancelarEnfermaria.setEnabled(true);
    }

    public void ExcluirEnfermaria() {
        jBtNovoEnfermaria.setEnabled(true);
    }

    public void SalvarEnfermaria() {
        jBtNovoEnfermaria.setEnabled(true);
    }

    public void CancelarEnfermaria() {
        jBtNovoEnfermaria.setEnabled(true);
    }

    public void buscarCodigoEnfermaria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ACOMPANHAMENTO_INTERNO_ENFERMARIA");
            conecta.rs.last();
            codigoEnf = conecta.rs.getInt("IdEnf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void zerarVariaveis() {
        //ENFERMARIA
        qtdDiabetes = 0;
        qtdHipertensao = 0;
        qtdEscabiose = 0;
        qtdHanseniase = 0;
        qtdSifilis = 0;
        qtdTuberculose = 0;
        qtdHib = 0;
        qtdHepatiteB = 0;
        qtdHepatiteC = 0;
        qtdDst = 0;
        qtdVdlr = 0;
        qtdVacina = 0;
    }

    public void preencherTabelaEnfermaria(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Reg.", "Data", "Diabetes", "Controlada", "Hipertensão", "Controlada", "Escabiose", "Curada", "Hanseniase", "Curada", "Sifilis", "Curada", "Tuberculose", "Curada", "Hiv", "Controlada", "Hepatite B", "Controlada", "Hepatite C", "Controlada"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Entrada
                dataPAI1 = conecta.rs.getString("DataReg");
                String diae = dataPAI1.substring(8, 10);
                String mese = dataPAI1.substring(5, 7);
                String anoe = dataPAI1.substring(0, 4);
                dataPAI1 = diae + "/" + mese + "/" + anoe;
                dados.add(new Object[]{conecta.rs.getInt("IdEnf"), conecta.rs.getInt("IdLanc"), dataPAI1, conecta.rs.getString("Diabetes"), conecta.rs.getString("DiabControl"), conecta.rs.getString("Hipertensao"), conecta.rs.getString("HiperControl"), conecta.rs.getString("Escabiose"), conecta.rs.getString("EscabioseCura"), conecta.rs.getString("Hanseniase"), conecta.rs.getString("HanseniaseCura"), conecta.rs.getString("Sifilis"), conecta.rs.getString("SifilisCura"), conecta.rs.getString("Tuberculose"), conecta.rs.getString("TuberculoseCura"), conecta.rs.getString("Hiv"), conecta.rs.getString("HivControlada"), conecta.rs.getString("HepatiteB"), conecta.rs.getString("HepatiteBCont"), conecta.rs.getString("HepatiteC"), conecta.rs.getString("HepatiteCCont")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEnfermaria.setModel(modelo);
        jTabelaEnfermaria.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEnfermaria.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaEnfermaria.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaEnfermaria.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(4).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(5).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(6).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(6).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(7).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(7).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(8).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(8).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(9).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(9).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(10).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(10).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(11).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(11).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(12).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(12).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(13).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(13).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(14).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(14).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(15).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(15).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(16).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(16).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(17).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(17).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(18).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(18).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(19).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(19).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(20).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(20).setResizable(false);
        jTabelaEnfermaria.getTableHeader().setReorderingAllowed(false);
        jTabelaEnfermaria.setAutoResizeMode(jTabelaEnfermaria.AUTO_RESIZE_OFF);
        jTabelaEnfermaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCelulasTabelaEnfermagem();
        conecta.desconecta();
    }

    public void limparTabelaIndaicadoresEnfermaria() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Reg.", "Data", "Diabetes", "Controlada", "Hipertensão", "Controlada", "Escabiose", "Curada", "Hanseniase", "Curada", "Sifilis", "Curada", "Tuberculose", "Curada", "Hiv", "Controlada", "Hepatite B", "Controlada", "Hepatite C", "Controlada"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEnfermaria.setModel(modelo);
        jTabelaEnfermaria.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEnfermaria.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaEnfermaria.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaEnfermaria.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(4).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(5).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(6).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(6).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(7).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(7).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(8).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(8).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(9).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(9).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(10).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(10).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(11).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(11).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(12).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(12).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(13).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(13).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(14).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(14).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(15).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(15).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(16).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(16).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(17).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(17).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(18).setPreferredWidth(70);
        jTabelaEnfermaria.getColumnModel().getColumn(18).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(19).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(19).setResizable(false);
        jTabelaEnfermaria.getColumnModel().getColumn(20).setPreferredWidth(80);
        jTabelaEnfermaria.getColumnModel().getColumn(20).setResizable(false);
        jTabelaEnfermaria.getTableHeader().setReorderingAllowed(false);
        jTabelaEnfermaria.setAutoResizeMode(jTabelaEnfermaria.AUTO_RESIZE_OFF);
        jTabelaEnfermaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCelulasTabelaEnfermagem() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEnfermaria.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(7).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(8).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(9).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(10).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(11).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(12).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(13).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(14).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(15).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(16).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(17).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(18).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(19).setCellRenderer(centralizado);
        jTabelaEnfermaria.getColumnModel().getColumn(20).setCellRenderer(centralizado);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela1);
        objLogSys.setIdLancMov(codigoEnf);
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    //ENFERMARIA
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
