/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleListaIndicadoresAcompanhamento;
import gestor.Controle.ControleListaIndicadoresAcompanhamentoJURI;
import gestor.Controle.ControleListaIndicadoresAcompanhamentoJURICRC;
import gestor.Controle.ControleListaIndicadoresAcompanhamentoJURICRC_LIVRA;
import gestor.Controle.ControleListaIndicadoresAcompanhamentoPEDA;
import gestor.Controle.ControleListaIndicadoresAcompanhamentoPSICOLOGIA;
import gestor.Controle.ControleListaIndicadoresAcompanhamentoPSICOLOGIA_II;
import gestor.Controle.ControleListaIndicadoresAcompanhamentoSS;
import gestor.Controle.ControleListaIndicadoresAcompanhamentoTO_APROVADO;
import gestor.Controle.ControleListaIndicadoresAcompanhamentoTO_ESTUDANDO;
import gestor.Controle.ControleListaIndicadoresAcompanhamentoTO_REP_APR_CON;
import gestor.Controle.converterDataStringDataDate;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.IndicadoresAcompanhamento;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Socializa TI 02
 */
public class TelaPRORES extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    IndicadoresAcompanhamento objPerfilInter = new IndicadoresAcompanhamento();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();
    ControleListaIndicadoresAcompanhamento control = new ControleListaIndicadoresAcompanhamento();
    ControleListaIndicadoresAcompanhamentoPEDA controle = new ControleListaIndicadoresAcompanhamentoPEDA();
    ControleListaIndicadoresAcompanhamentoJURI controleJURI = new ControleListaIndicadoresAcompanhamentoJURI();
    ControleListaIndicadoresAcompanhamentoJURICRC controleJURI_CRC = new ControleListaIndicadoresAcompanhamentoJURICRC();
    ControleListaIndicadoresAcompanhamentoJURICRC_LIVRA controleJURI_CRC_LIVRA = new ControleListaIndicadoresAcompanhamentoJURICRC_LIVRA();
    ControleListaIndicadoresAcompanhamentoPSICOLOGIA controlePSI = new ControleListaIndicadoresAcompanhamentoPSICOLOGIA();
    ControleListaIndicadoresAcompanhamentoPSICOLOGIA_II controlePSIc = new ControleListaIndicadoresAcompanhamentoPSICOLOGIA_II();
    ControleListaIndicadoresAcompanhamentoSS controleSS = new ControleListaIndicadoresAcompanhamentoSS();
    ControleListaIndicadoresAcompanhamentoTO_APROVADO controlTO_APROVADO = new ControleListaIndicadoresAcompanhamentoTO_APROVADO();
    ControleListaIndicadoresAcompanhamentoTO_ESTUDANDO controTO_ESTUDANDO = new ControleListaIndicadoresAcompanhamentoTO_ESTUDANDO();
    ControleListaIndicadoresAcompanhamentoTO_REP_APR_CON control_REP_APR_CON = new ControleListaIndicadoresAcompanhamentoTO_REP_APR_CON();
    //FALTA MÉTODO DE TO
    //PSICOLOGIA
    double qtdTratamento = 0;
    double qtdTtratamentioConcluido = 0;
    public static int pSTATUS_ANDAMENTO = 0;
    public static int pSTATUS_ANDAMENTO_CONCLUIDO = 0;
    int qtdRecuperacao = 0;
    //
    int qtdProd = 0;
    //
    String dataInicial, dataFinal = "";
    //ENFERMAGEM
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
    double pPopulacaoAtual = 0;
    double pDiab = 0;
    double pHiper = 0;
    public static int pAcessoUni = 0;
    public static int pAprovado = 0;
    public static int pReprovado = 0;
    public static int pCursando = 0;
    public static int pConcluido = 0;
    public static int pDesistente = 0;
    public static int pResenhaEntregue = 0;
    double pHepatiteB = 0;
    double pHepatiteC = 0;
    double pEscabiose = 0;
    double pHanseniase = 0;
    double pSifilis = 0;
    double pHiv = 0;
    double pTuberculose = 0;
    double pDst = 0;
    double pVdlr = 0;
    double pVacina = 0;
    //PEDAGOGIA
    double pqTdResenha = 0;
    //JURIDICO/CRC
    int qtdProcessos = 0;
    int qtdDocumentacao = 0;
    int qtdProggressao = 0;
    int qtdLivramento = 0;
    double pQTdDocumentacao = 0;
    double pQTdProgressao = 0;
    double pQtdLivramento = 0;
    public static int pDocumento = 0;
    public static int pPROGRESSAO = 0;
    public static int pLIVRAMENTO = 0;
    //SERVIÇO SOCIAL
    double qtdAcompanhaSS = 0;
    public static int pFAMILIA_ATENDIDA = 0;
    //TERAPIA OCUPACIONAL
    double qtdAprovados = 0;
    double qtdCursandos = 0;
    double qtdProfissional = 0;
    public static int pSTATUS_SITUACAO_APROVADO = 0;
    public static int pSTATUS_SITUACAO_ESTUDANDO = 0;
    public static int pSTATUS_SITUACAO_APR_REP_CON = 0;

    /**
     * Creates new form TelaPRORES
     */
    public TelaPRORES() {
        initComponents();
        corCampos();
        limparCampos();
        pesquisarPopulacao("SELECT DataPopMov,TotalGeralInternos FROM MOVPOPULACAO");
        pesquisarDadosPRORES();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jDiabetes = new javax.swing.JFormattedTextField();
        jHipertensao = new javax.swing.JFormattedTextField();
        jHepatiteB = new javax.swing.JFormattedTextField();
        jHepatiteC = new javax.swing.JFormattedTextField();
        jEscabiose = new javax.swing.JFormattedTextField();
        jHanseniase = new javax.swing.JFormattedTextField();
        jSifilis = new javax.swing.JFormattedTextField();
        jHiv = new javax.swing.JFormattedTextField();
        jTuberculose = new javax.swing.JFormattedTextField();
        jDst = new javax.swing.JFormattedTextField();
        jPanel22 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jCursandoAlfa = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jCursandoPrimeiro = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jCursandoSegundo = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jAdiquiriu = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jCursandoTerceiro = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jEducacaoLeitura = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jAtividadeComplementar = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jConcluiuPrimeiro = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jConcluiuSegundo = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jConcluiualfabetizacao = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jProgressaoRegime = new javax.swing.JTextField();
        jProcessosAcompanhado = new javax.swing.JTextField();
        jDocumentacaoCompleta = new javax.swing.JTextField();
        jLivramentoCondicional = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jFamiliaAcompanhada = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jInseridoPrograma = new javax.swing.JTextField();
        jPassaramCursos = new javax.swing.JTextField();
        jFormacaoProfissional = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        jInternosTratamento = new javax.swing.JTextField();
        jInternosTratamentoConcluido = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPopulacaoAtual = new javax.swing.JFormattedTextField();
        jDataPopulacao = new com.toedter.calendar.JDateChooser();
        jBtAtualizar = new javax.swing.JButton();
        jBtFechar = new javax.swing.JButton();
        jBtImpressao = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("...::: PRORES :::...");

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Enfermaria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Hipertensão - Controlada");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Hepatite B:");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Escabiose:");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Tuberculose - Curada:");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("HIV - Controlada:");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Diabetes  - Controlada:");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Sifilis - Controlada:");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Hanseniase - Curada:");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Hepatite C:");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("%");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("%");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("%");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("%");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("%");

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("%");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setText("%");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setText("%");

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel69.setText("%");

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel103.setText("Tratamento de DST %");

        jDiabetes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDiabetes.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jDiabetes.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDiabetes.setEnabled(false);
        jDiabetes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jHipertensao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHipertensao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHipertensao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jHipertensao.setEnabled(false);
        jHipertensao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jHepatiteB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHepatiteB.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHepatiteB.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jHepatiteB.setEnabled(false);
        jHepatiteB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jHepatiteC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHepatiteC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHepatiteC.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jHepatiteC.setEnabled(false);
        jHepatiteC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jEscabiose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEscabiose.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jEscabiose.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jEscabiose.setEnabled(false);
        jEscabiose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jHanseniase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHanseniase.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHanseniase.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jHanseniase.setEnabled(false);
        jHanseniase.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jSifilis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSifilis.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jSifilis.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jSifilis.setEnabled(false);
        jSifilis.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jHiv.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHiv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHiv.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jHiv.setEnabled(false);
        jHiv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTuberculose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTuberculose.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTuberculose.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTuberculose.setEnabled(false);
        jTuberculose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jDst.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDst.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jDst.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDst.setEnabled(false);
        jDst.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel58))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel60))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel69))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel68))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel66))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel65))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel59))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel56))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel57))
                    .addComponent(jLabel103))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDiabetes, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jHipertensao)
                    .addComponent(jHepatiteB)
                    .addComponent(jEscabiose, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jHepatiteC)
                    .addComponent(jHanseniase)
                    .addComponent(jSifilis)
                    .addComponent(jHiv)
                    .addComponent(jDst, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jTuberculose))
                .addGap(11, 11, 11))
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jDiabetes, jDst, jEscabiose, jHanseniase, jHepatiteB, jHepatiteC, jHipertensao, jHiv, jSifilis, jTuberculose});

        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel51)
                    .addComponent(jLabel56)
                    .addComponent(jDiabetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel39)
                    .addComponent(jLabel57)
                    .addComponent(jHipertensao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel46)
                    .addComponent(jLabel58)
                    .addComponent(jHepatiteB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel54)
                    .addComponent(jLabel59)
                    .addComponent(jHepatiteC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel47)
                    .addComponent(jLabel60)
                    .addComponent(jEscabiose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel53)
                    .addComponent(jLabel65)
                    .addComponent(jHanseniase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel52)
                    .addComponent(jLabel66)
                    .addComponent(jSifilis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel50)
                    .addComponent(jLabel68)
                    .addComponent(jHiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel49)
                    .addComponent(jLabel69)
                    .addComponent(jTuberculose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel103)
                    .addComponent(jDst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDiabetes, jDst, jEscabiose, jHanseniase, jHepatiteB, jHepatiteC, jHipertensao, jHiv, jSifilis, jTuberculose});

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Pedagogia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Int. cursando a alfabetização %");
        jLabel55.setToolTipText("Interno cursando a alfabetização?");

        jCursandoAlfa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCursandoAlfa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCursandoAlfa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCursandoAlfa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCursandoAlfa.setEnabled(false);

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setText("Internos cursando o 1º grau %");
        jLabel70.setToolTipText("Interno cursando o 1º grau?");

        jCursandoPrimeiro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCursandoPrimeiro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCursandoPrimeiro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCursandoPrimeiro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCursandoPrimeiro.setEnabled(false);

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel71.setText("Int. cursando 2º grau/Prof. %");
        jLabel71.setToolTipText("Interno cursando 2º grau/Profissionalizante?");

        jCursandoSegundo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCursandoSegundo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCursandoSegundo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCursandoSegundo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCursandoSegundo.setEnabled(false);

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setText("Int. que adquiriu acesso a unid. %");
        jLabel72.setToolTipText("Interno que adquiriu acesso a universidade?");

        jAdiquiriu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jAdiquiriu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAdiquiriu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAdiquiriu.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jAdiquiriu.setEnabled(false);

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setText("Interno cursando 3º grau %");
        jLabel73.setToolTipText("Interno cursando 3º grau?");

        jCursandoTerceiro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCursandoTerceiro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCursandoTerceiro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCursandoTerceiro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCursandoTerceiro.setEnabled(false);

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setText("Int. rem. p/ educação/leitura %");
        jLabel74.setToolTipText("Interno com remissão pela educação/leitura?");

        jEducacaoLeitura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jEducacaoLeitura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jEducacaoLeitura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEducacaoLeitura.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jEducacaoLeitura.setEnabled(false);

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setText("Int. atividade complementar %");
        jLabel75.setToolTipText("Interno na atividade complementar?");

        jAtividadeComplementar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jAtividadeComplementar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAtividadeComplementar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAtividadeComplementar.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jAtividadeComplementar.setEnabled(false);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Quant. Int. concluiu o 1º grau?");
        jLabel38.setToolTipText("Quantidade de  Internos concluiu o 1º grau?");

        jConcluiuPrimeiro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jConcluiuPrimeiro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jConcluiuPrimeiro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jConcluiuPrimeiro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jConcluiuPrimeiro.setEnabled(false);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Quant. Int. concluiu o 2º grau?");
        jLabel45.setToolTipText("Quantidade Interno concluiu o 2º grau?");

        jConcluiuSegundo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jConcluiuSegundo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jConcluiuSegundo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jConcluiuSegundo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jConcluiuSegundo.setEnabled(false);

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("Quant. Int. concluiu alfabetização?");

        jConcluiualfabetizacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jConcluiualfabetizacao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jConcluiualfabetizacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jConcluiualfabetizacao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jConcluiualfabetizacao.setEnabled(false);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel74, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jConcluiualfabetizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jConcluiuSegundo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jConcluiuPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCursandoTerceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAdiquiriu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCursandoSegundo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCursandoPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCursandoAlfa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jAtividadeComplementar, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jEducacaoLeitura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jCursandoAlfa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jCursandoPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCursandoSegundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72)
                    .addComponent(jAdiquiriu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCursandoTerceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(jEducacaoLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAtividadeComplementar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jConcluiuPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jConcluiuSegundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jConcluiualfabetizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Jurídico/CRC", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 0))); // NOI18N

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel79.setText("Processos acompanhado %");
        jLabel79.setToolTipText("Percentual de processos acompanhado");

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setText("Documentação completa %");
        jLabel80.setToolTipText("Percentuial de Documentação está completa");

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel81.setText("Quant.progressão de regime");
        jLabel81.setToolTipText("Quantidade de progressão de regime");

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel82.setText("Quant. livra. condicional");
        jLabel82.setToolTipText("Quantidade de livramento condicional");

        jProgressaoRegime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jProgressaoRegime.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jProgressaoRegime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jProgressaoRegime.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jProgressaoRegime.setEnabled(false);

        jProcessosAcompanhado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jProcessosAcompanhado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jProcessosAcompanhado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jProcessosAcompanhado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jProcessosAcompanhado.setEnabled(false);

        jDocumentacaoCompleta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jDocumentacaoCompleta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jDocumentacaoCompleta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDocumentacaoCompleta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDocumentacaoCompleta.setEnabled(false);

        jLivramentoCondicional.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLivramentoCondicional.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jLivramentoCondicional.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLivramentoCondicional.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jLivramentoCondicional.setEnabled(false);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel82)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLivramentoCondicional, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel81)
                            .addComponent(jLabel80)
                            .addComponent(jLabel79))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jProgressaoRegime, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jProcessosAcompanhado, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDocumentacaoCompleta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jProcessosAcompanhado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(jDocumentacaoCompleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(jProgressaoRegime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(jLivramentoCondicional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Serviço Social", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 51, 0))); // NOI18N

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel95.setText("Int. familia. acompanhado %");
        jLabel95.setToolTipText("Percentual Internos com familiares acompanhado");

        jFamiliaAcompanhada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jFamiliaAcompanhada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFamiliaAcompanhada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jFamiliaAcompanhada.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jFamiliaAcompanhada.setEnabled(false);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel95)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFamiliaAcompanhada, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFamiliaAcompanhada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Terapia Ocupacional", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(102, 0, 102))); // NOI18N

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setText("Int. inserido nos programa %");

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setText("Int.  passaram por algum curso %");

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setText("Int. concl. formação profissional %");
        jLabel88.setToolTipText("Percentual de Internos que concluiram alguma formação profissional");

        jInseridoPrograma.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jInseridoPrograma.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jInseridoPrograma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jInseridoPrograma.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jInseridoPrograma.setEnabled(false);

        jPassaramCursos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPassaramCursos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPassaramCursos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPassaramCursos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPassaramCursos.setEnabled(false);

        jFormacaoProfissional.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jFormacaoProfissional.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormacaoProfissional.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jFormacaoProfissional.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jFormacaoProfissional.setEnabled(false);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel88)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormacaoProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel86)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jInseridoPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel87)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPassaramCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(jInseridoPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(jPassaramCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(jFormacaoProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Psicologia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 102))); // NOI18N

        jInternosTratamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jInternosTratamento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jInternosTratamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jInternosTratamento.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jInternosTratamento.setEnabled(false);

        jInternosTratamentoConcluido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jInternosTratamentoConcluido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jInternosTratamentoConcluido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jInternosTratamentoConcluido.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jInternosTratamentoConcluido.setEnabled(false);

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel94.setText("Interno com tratamnto concluído %");

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel93.setText("Internos em Tratamento%");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel93, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel94, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternosTratamentoConcluido, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternosTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel93)
                    .addComponent(jInternosTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel94)
                    .addComponent(jInternosTratamentoConcluido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("População Atual:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data da População:");

        jPopulacaoAtual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPopulacaoAtual.setForeground(new java.awt.Color(153, 0, 0));
        jPopulacaoAtual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPopulacaoAtual.setDisabledTextColor(new java.awt.Color(153, 0, 0));
        jPopulacaoAtual.setEnabled(false);
        jPopulacaoAtual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jDataPopulacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPopulacao.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataPopulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPopulacaoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jDataPopulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jPopulacaoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAtualizar.setText("Refresh");
        jBtAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAtualizarActionPerformed(evt);
            }
        });

        jBtFechar.setForeground(new java.awt.Color(0, 102, 51));
        jBtFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtFechar.setText("Fechar");
        jBtFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFecharActionPerformed(evt);
            }
        });

        jBtImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao.setToolTipText("Imprimir Relatório PRORES");
        jBtImpressao.setContentAreaFilled(false);
        jBtImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(jBtAtualizar)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel24, jPanel35});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAtualizar, jBtFechar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtAtualizar)
                        .addComponent(jBtFechar))
                    .addComponent(jBtImpressao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(350, 20, 570, 558);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFecharActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtFecharActionPerformed

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtImpressaoActionPerformed

    private void jBtAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAtualizarActionPerformed
        // TODO add your handling code here:
        limparCampos();
        pesquisarPopulacao("SELECT DataPopMov,TotalGeralInternos FROM MOVPOPULACAO");
        pesquisarDadosPRORES();
    }//GEN-LAST:event_jBtAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAdiquiriu;
    private javax.swing.JTextField jAtividadeComplementar;
    private javax.swing.JButton jBtAtualizar;
    private javax.swing.JButton jBtFechar;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JTextField jConcluiuPrimeiro;
    private javax.swing.JTextField jConcluiuSegundo;
    private javax.swing.JTextField jConcluiualfabetizacao;
    private javax.swing.JTextField jCursandoAlfa;
    private javax.swing.JTextField jCursandoPrimeiro;
    private javax.swing.JTextField jCursandoSegundo;
    private javax.swing.JTextField jCursandoTerceiro;
    private com.toedter.calendar.JDateChooser jDataPopulacao;
    private javax.swing.JFormattedTextField jDiabetes;
    private javax.swing.JTextField jDocumentacaoCompleta;
    private javax.swing.JFormattedTextField jDst;
    private javax.swing.JTextField jEducacaoLeitura;
    private javax.swing.JFormattedTextField jEscabiose;
    private javax.swing.JTextField jFamiliaAcompanhada;
    private javax.swing.JTextField jFormacaoProfissional;
    private javax.swing.JFormattedTextField jHanseniase;
    private javax.swing.JFormattedTextField jHepatiteB;
    private javax.swing.JFormattedTextField jHepatiteC;
    private javax.swing.JFormattedTextField jHipertensao;
    private javax.swing.JFormattedTextField jHiv;
    private javax.swing.JTextField jInseridoPrograma;
    private javax.swing.JTextField jInternosTratamento;
    private javax.swing.JTextField jInternosTratamentoConcluido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JTextField jLivramentoCondicional;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JTextField jPassaramCursos;
    private javax.swing.JFormattedTextField jPopulacaoAtual;
    private javax.swing.JTextField jProcessosAcompanhado;
    private javax.swing.JTextField jProgressaoRegime;
    private javax.swing.JFormattedTextField jSifilis;
    private javax.swing.JFormattedTextField jTuberculose;
    // End of variables declaration//GEN-END:variables

    public void mudarCorData() {
        jDataPopulacao.getDateEditor().getUiComponent().setBackground(new Color(255, 255, 255));
    }

    public void formatarCampos() {

        try {
            MaskFormatter diab = new MaskFormatter("###,####");
            MaskFormatter hiper = new MaskFormatter("###,####");
            MaskFormatter hepab = new MaskFormatter("###,####");
            MaskFormatter hepac = new MaskFormatter("###,####");
            MaskFormatter esca = new MaskFormatter("###,####");
            MaskFormatter hanse = new MaskFormatter("###,####");
            MaskFormatter sifi = new MaskFormatter("###,####");
            MaskFormatter hiv = new MaskFormatter("###,####");
            MaskFormatter tube = new MaskFormatter("###,####");
            MaskFormatter dst = new MaskFormatter("###,####");
            jDiabetes.setFormatterFactory(new DefaultFormatterFactory(diab));
            jHipertensao.setFormatterFactory(new DefaultFormatterFactory(hiper));
            jHepatiteB.setFormatterFactory(new DefaultFormatterFactory(hepab));
            jHepatiteC.setFormatterFactory(new DefaultFormatterFactory(hepac));
            jEscabiose.setFormatterFactory(new DefaultFormatterFactory(esca));
            jHanseniase.setFormatterFactory(new DefaultFormatterFactory(hanse));
            jSifilis.setFormatterFactory(new DefaultFormatterFactory(sifi));
            jHiv.setFormatterFactory(new DefaultFormatterFactory(hiv));
            jTuberculose.setFormatterFactory(new DefaultFormatterFactory(tube));
            jDst.setFormatterFactory(new DefaultFormatterFactory(dst));
        } catch (ParseException ex) {
            Logger.getLogger(TelaPRORES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void corCampos() {
//        jDataPopulacao.setBackground(Color.white);
        jPopulacaoAtual.setBackground(Color.white);
        //ENFERMARIA
        jDiabetes.setBackground(Color.white);
        jHipertensao.setBackground(Color.white);
        jHepatiteB.setBackground(Color.white);
        jHepatiteC.setBackground(Color.white);
        jEscabiose.setBackground(Color.white);
        jHanseniase.setBackground(Color.white);
        jSifilis.setBackground(Color.white);
        jHiv.setBackground(Color.white);
        jTuberculose.setBackground(Color.white);
        jDst.setBackground(Color.white);
        //PEDAGOGIA
        jCursandoAlfa.setBackground(Color.white);
        jCursandoPrimeiro.setBackground(Color.white);
        jCursandoSegundo.setBackground(Color.white);
        jAdiquiriu.setBackground(Color.white);
        jCursandoTerceiro.setBackground(Color.white);
        jEducacaoLeitura.setBackground(Color.white);
        jAtividadeComplementar.setBackground(Color.white);
        jConcluiuPrimeiro.setBackground(Color.white);
        jConcluiuSegundo.setBackground(Color.white);
        jConcluiualfabetizacao.setBackground(Color.white);
        // JURIDICO/CRC
        jProcessosAcompanhado.setBackground(Color.white);
        jDocumentacaoCompleta.setBackground(Color.white);
        jProgressaoRegime.setBackground(Color.white);
        jLivramentoCondicional.setBackground(Color.white);
        // TERAPIA OCUPACIONAL
        jInseridoPrograma.setBackground(Color.white);
        jPassaramCursos.setBackground(Color.white);
        jFormacaoProfissional.setBackground(Color.white);
        //PSICOLOGIA       
        jInternosTratamento.setBackground(Color.white);
        jInternosTratamentoConcluido.setBackground(Color.white);
        //SERVIÇO SOCIAL
        jFamiliaAcompanhada.setBackground(Color.white);
    }

    public void limparCampos() {
        jDiabetes.setText("0");
        jHipertensao.setText("0");
        jHepatiteB.setText("0");
        jHepatiteC.setText("0");
        jEscabiose.setText("0");
        jHanseniase.setText("0");
        jSifilis.setText("0");
        jHiv.setText("0");
        jTuberculose.setText("0");
        jDst.setText("0");
        //PEDAGOGIA
        jCursandoAlfa.setText("0");
        jCursandoPrimeiro.setText("0");
        jCursandoSegundo.setText("0");
        jAdiquiriu.setText("0");
        jCursandoTerceiro.setText("0");
        jEducacaoLeitura.setText("0");
        jAtividadeComplementar.setText("0");
        jConcluiuPrimeiro.setText("0");
        jConcluiuSegundo.setText("0");
        jConcluiualfabetizacao.setText("0");
        // JURIDICO/CRC
        jProcessosAcompanhado.setText("0");
        jDocumentacaoCompleta.setText("0");
        jProgressaoRegime.setText("0");
        jLivramentoCondicional.setText("0");
        // TERAPIA OCUPACIONAL
        jInseridoPrograma.setText("0");
        jPassaramCursos.setText("0");
        jFormacaoProfissional.setText("0");
        //PSICOLOGIA
        jInternosTratamento.setText("0");
        jInternosTratamentoConcluido.setText("0");
        //SERVIÇO SOCIAL
        jFamiliaAcompanhada.setText("0");
        //ZERAR VARIÁVEIS
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
        pPopulacaoAtual = 0;
        pDiab = 0;
        pHiper = 0;
        pAcessoUni = 0;
        pAprovado = 0;
        pReprovado = 0;
        pCursando = 0;
        pConcluido = 0;
        pDesistente = 0;
        pResenhaEntregue = 0;
        pHepatiteB = 0;
        pHepatiteC = 0;
        pEscabiose = 0;
        pHanseniase = 0;
        pSifilis = 0;
        pHiv = 0;
        pTuberculose = 0;
        pDst = 0;
        pVdlr = 0;
        pVacina = 0;
        //PEDAGOGIA
        pqTdResenha = 0;
        //JURIDICO/CRC
        qtdProcessos = 0;
        qtdDocumentacao = 0;
        qtdProggressao = 0;
        qtdLivramento = 0;
        pQTdDocumentacao = 0;
        pQTdProgressao = 0;
        pQtdLivramento = 0;
        pDocumento = 0;
        pPROGRESSAO = 0;
        pLIVRAMENTO = 0;
        //SERVIÇO SOCIAL
        qtdAcompanhaSS = 0;
        pFAMILIA_ATENDIDA = 0;
        //TERAPIA OCUPACIONAL
        qtdAprovados = 0;
        qtdCursandos = 0;
        qtdProfissional = 0;
        pSTATUS_SITUACAO_APROVADO = 0;
        pSTATUS_SITUACAO_ESTUDANDO = 0;
        pSTATUS_SITUACAO_APR_REP_CON = 0;

    }

//    public void preencherTabelaEstatistica(String sql) {
//        conecta.abrirConexao();
//        try {
//            conecta.executaSQL(sql);
//            conecta.rs.first();
//            do {
//                qtdDiabetes = conecta.rs.getInt("QtdDiabetes");
//                qtdHipertensao = conecta.rs.getInt("QtdHipertensao");
//                qtdEscabiose = conecta.rs.getInt("QtdEscabiose");
//                qtdHanseniase = conecta.rs.getInt("QtdHanseniase");
//                qtdSifilis = conecta.rs.getInt("QtdSifilis");
//                qtdTuberculose = conecta.rs.getInt("QtdTuberculose");
//                qtdHib = conecta.rs.getInt("QtdHiv");
//                qtdHepatiteB = conecta.rs.getInt("QtdHepatiteB");
//                qtdHepatiteC = conecta.rs.getInt("QtdHepatiteC");
//                qtdDst = conecta.rs.getInt("QtdDst");
//                qtdVdlr = conecta.rs.getInt("QtdVdlr");
//                qtdVacina = conecta.rs.getInt("qQtdVacina");
    //PEDAGOGIA
//                qICAA = conecta.rs.getInt("QtdICAA");
//                qIC1 = conecta.rs.getInt("QtdIC1");
//                qIC2P = conecta.rs.getInt("QtdIC2P");
//                qIAAU = conecta.rs.getInt("QtdIAAU");
//                qIC3 = conecta.rs.getInt("QtdIC3");
//                qIREL = conecta.rs.getInt("QtdIREL");
//                qIAC = conecta.rs.getInt("QtdIAC");
//                qICU1 = conecta.rs.getInt("QtdICU1");
//                qIC2 = conecta.rs.getInt("QtdIC2");
//                qICA = conecta.rs.getInt("QtdICA");
    //JURIDICO/CRC
//                qtdProcessos = conecta.rs.getInt("QtdProgresso");
//                qtdDocumentacao = conecta.rs.getInt("QtdDocumentacao");
//                qtdProggressao = conecta.rs.getInt("QtdProgressao");
//                qtdLivramento = conecta.rs.getInt("QtdLivramento");
//                //TERAPIA OCUPACIONAL
//                qtdPrograma = conecta.rs.getInt("Qtdprograma");
//                qtdCurso = conecta.rs.getInt("QtdCurso");
//                qtdProfissional = conecta.rs.getInt("QtdProfissional");
//                //PSICOLOGIA
//                qtdTratamento = conecta.rs.getInt("QtdTratamento");
//                qtdAcompanha = conecta.rs.getInt("QtdAcompanha");
//                qtdRecuperacao = conecta.rs.getInt("QtdRecuparacao");
//                //SERVIÇO SOCIAL
//                qtdAcompanhaSS = conecta.rs.getInt("QtdAcompanhaSS");
//            } while (conecta.rs.next());
//        } catch (Exception e) {
//        }
//        conecta.desconecta();
//    }
    public void pesquisarPopulacao(String sql) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.last();
            jDataPopulacao.setDate(conecta.rs.getDate("DataPopMov"));
            jPopulacaoAtual.setText(conecta.rs.getString("TotalGeralInternos"));
            pPopulacaoAtual = conecta.rs.getDouble("TotalGeralInternos");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisarDadosPRORES() {

        IndicadoresAcompanhamento d = new IndicadoresAcompanhamento();
        //ENFERMARIA
        try {
            for (IndicadoresAcompanhamento dd : control.read()) {
                //ENFERMARIA
                qtdDiabetes = dd.getQtdDiabetes();
                pDiab = (100 * qtdDiabetes) / pPopulacaoAtual;
                DecimalFormat vDiab = new DecimalFormat("#,###0.00");
                String pPerdiab = vDiab.format(pDiab);
                jDiabetes.setText(String.valueOf(pPerdiab));
                //
                qtdHipertensao = dd.getQtdHipertensao();
                pHiper = (100 * qtdHipertensao) / pPopulacaoAtual;
                DecimalFormat vHeper = new DecimalFormat("#,###0.00");
                String pPerdiaHeper = vHeper.format(pHiper);
                jHipertensao.setText(String.valueOf(pPerdiaHeper));
                //
                qtdHepatiteB = dd.getQtdHepatiteB();
                pHepatiteB = (100 * qtdHepatiteB) / pPopulacaoAtual;
                DecimalFormat vHepateb = new DecimalFormat("#,###0.00");
                String pPerdiaHepB = vHepateb.format(pHepatiteB);
                jHepatiteB.setText(String.valueOf(pPerdiaHepB));
                //
                qtdHepatiteC = dd.getQtdHepatiteC();
                pHepatiteC = (100 * qtdHepatiteC) / pPopulacaoAtual;
                DecimalFormat vHepatec = new DecimalFormat("#,###0.00");
                String pPerdiaHepC = vHepatec.format(pHepatiteC);
                jHepatiteC.setText(String.valueOf(pPerdiaHepC));
                //
                qtdEscabiose = dd.getQtdEscabiose();
                pEscabiose = (100 * qtdEscabiose) / pPopulacaoAtual;
                DecimalFormat vEscabe = new DecimalFormat("#,###0.00");
                String pPerdiaEscabe = vEscabe.format(pEscabiose);
                jEscabiose.setText(String.valueOf(pPerdiaEscabe));
                //
                qtdHanseniase = dd.getQtdHanseniase();
                pHanseniase = (100 * qtdHanseniase) / pPopulacaoAtual;
                DecimalFormat vHanse = new DecimalFormat("#,###0.00");
                String pPerdiaHanse = vHanse.format(pHanseniase);
                jHanseniase.setText(String.valueOf(pPerdiaHanse));
                //
                qtdSifilis = dd.getQtdSifilis();
                pSifilis = (100 * qtdSifilis) / pPopulacaoAtual;
                DecimalFormat vSifilis = new DecimalFormat("#,###0.00");
                String pPerdiaSifilis = vSifilis.format(pSifilis);
                jSifilis.setText(String.valueOf(pPerdiaSifilis));
                //
                qtdHib = dd.getQtdHib();
                pHiv = (100 * qtdHib) / pPopulacaoAtual;
                DecimalFormat vHiv = new DecimalFormat("#,###0.00");
                String pPerdiaHiv = vHiv.format(pHiv);
                jHiv.setText(String.valueOf(pPerdiaHiv));
                //
                qtdTuberculose = dd.getQtdTuberculose();
                pTuberculose = (100 * qtdTuberculose) / pPopulacaoAtual;
                DecimalFormat vTuberculose = new DecimalFormat("#,###0.00");
                String pPerdiapTuberculose = vTuberculose.format(pTuberculose);
                jTuberculose.setText(String.valueOf(pPerdiapTuberculose));
                //
                qtdDst = dd.getQdtDst();
                pDst = (100 * qtdDst) / pPopulacaoAtual;
                DecimalFormat vDst = new DecimalFormat("#,###0.00");
                String pPerdiaDst = vDst.format(pDst);
                jDst.setText(String.valueOf(pPerdiaDst));
                //                                                                                                                                
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
        //PEDAGOGIA
        try {
            for (IndicadoresAcompanhamento bb : controle.read()) {
                pAcessoUni = bb.getqTdAcessoUni();
                jAdiquiriu.setText(String.valueOf(pAcessoUni));
                pAprovado = bb.getqTdAprova();
                pReprovado = bb.getqTdReprova();
                pCursando = bb.getqTdCursando();
                pConcluido = bb.getqTdConcluido();
                jConcluiuPrimeiro.setText(String.valueOf(pConcluido));
                pDesistente = bb.getqTdDesistente();
                //
                pResenhaEntregue = bb.getqTdResenhaEntregue();
                pqTdResenha = (100 * pResenhaEntregue) / pPopulacaoAtual;
                DecimalFormat vDst = new DecimalFormat("#,###0.00");
                String pPerdiaResen = vDst.format(pqTdResenha);
                jEducacaoLeitura.setText(String.valueOf(pPerdiaResen));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPRORES.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JURIDICO
        try {
            for (IndicadoresAcompanhamento jj : controleJURI.read()) {
                //
                pQTdDocumentacao = jj.getQtdDocumentacao();
                pQTdDocumentacao = (100 * pDocumento) / pPopulacaoAtual;
                DecimalFormat vDoc = new DecimalFormat("#,###0.00");
                String pPerdiaDocu = vDoc.format(pQTdDocumentacao);
                jDocumentacaoCompleta.setText(String.valueOf(pPerdiaDocu));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPRORES.class.getName()).log(Level.SEVERE, null, ex);
        }
        //PROGRESSÃO DE REGIME
        try {
            for (IndicadoresAcompanhamento pp : controleJURI_CRC.read()) {
                //
                pQTdProgressao = pp.getQtdProgressao();
                pQTdProgressao = (100 * pPROGRESSAO) / pPopulacaoAtual;
                DecimalFormat vProg = new DecimalFormat("#,###0.00");
                String pPerdiaProg = vProg.format(pQTdProgressao);
                jProgressaoRegime.setText(String.valueOf(pPerdiaProg));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPRORES.class.getName()).log(Level.SEVERE, null, ex);
        }
        //LIVERAMENTO CONDICIONAL
        try {
            for (IndicadoresAcompanhamento pl : controleJURI_CRC_LIVRA.read()) {
                //
                pQtdLivramento = pl.getQtdLivramento();
                pQtdLivramento = (100 * pLIVRAMENTO) / pPopulacaoAtual;
                DecimalFormat vLivra = new DecimalFormat("#,###0.00");
                String pPerdiaLivra = vLivra.format(pQtdLivramento);
                jLivramentoCondicional.setText(String.valueOf(pPerdiaLivra));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPRORES.class.getName()).log(Level.SEVERE, null, ex);
        }
        // PSICOLOGIA 
        try {
            for (IndicadoresAcompanhamento psi : controlePSI.read()) {
                //
                qtdTratamento = psi.getQtdLivramento();
                qtdTratamento = (100 * pSTATUS_ANDAMENTO) / pPopulacaoAtual;
                DecimalFormat vLivra = new DecimalFormat("#,###0.00");
                String pPerdiaLivra = vLivra.format(qtdTratamento);
                jInternosTratamento.setText(String.valueOf(pPerdiaLivra));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPRORES.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (IndicadoresAcompanhamento psi0 : controlePSIc.read()) {
                //
                qtdTtratamentioConcluido = psi0.getQtdLivramento();
                qtdTtratamentioConcluido = (100 * pSTATUS_ANDAMENTO_CONCLUIDO) / pPopulacaoAtual;
                DecimalFormat vLivra = new DecimalFormat("#,###0.00");
                String pPerdiaLivra = vLivra.format(qtdTtratamentioConcluido);
                jInternosTratamentoConcluido.setText(String.valueOf(pPerdiaLivra));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPRORES.class.getName()).log(Level.SEVERE, null, ex);
        }
        //SERVIÇO SOCIAL
        try {
            for (IndicadoresAcompanhamento ss : controleSS.read()) {
                //
                qtdAcompanhaSS = ss.getQtdAcompanhaSS();
                qtdAcompanhaSS = (100 * pFAMILIA_ATENDIDA) / pPopulacaoAtual;
                DecimalFormat vLivra = new DecimalFormat("#,###0.00");
                String pPerdiaLivra = vLivra.format(qtdAcompanhaSS);
                jFamiliaAcompanhada.setText(String.valueOf(pPerdiaLivra));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPRORES.class.getName()).log(Level.SEVERE, null, ex);
        }
        //TERAPIA OCUPACIONAL
        // APROVADOS E CONCLUÍDOS
        try {
            for (IndicadoresAcompanhamento to1 : controlTO_APROVADO.read()) {
                //
                qtdAprovados = to1.getqTdAprova();
                qtdAprovados = (100 * pSTATUS_SITUACAO_APROVADO / pPopulacaoAtual);
                DecimalFormat vAprova = new DecimalFormat("#,###0.00");
                String pAprovaPro = vAprova.format(qtdAprovados);
                jFormacaoProfissional.setText(String.valueOf(pAprovaPro));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPRORES.class.getName()).log(Level.SEVERE, null, ex);
        }
        // CURSANDO
        try {
            for (IndicadoresAcompanhamento to2 : controTO_ESTUDANDO.read()) {
                //
                qtdCursandos = to2.getqTdCursando();
                qtdCursandos = (100 * pSTATUS_SITUACAO_ESTUDANDO / pPopulacaoAtual);
                DecimalFormat vCursa = new DecimalFormat("#,###0.00");
                String pCursaApr = vCursa.format(qtdCursandos);
                jInseridoPrograma.setText(String.valueOf(pCursaApr));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPRORES.class.getName()).log(Level.SEVERE, null, ex);
        }
        // CURSANDO E APROVADOS
        try {
            for (IndicadoresAcompanhamento to3 : control_REP_APR_CON.read()) {
                //
                qtdProfissional = to3.getqTdCursando() + to3.getqTdAprova();
                qtdProfissional = (100 * pSTATUS_SITUACAO_APR_REP_CON / pPopulacaoAtual);
                DecimalFormat vTotalEst = new DecimalFormat("#,###0.00");
                String pTotalCursaApr = vTotalEst.format(qtdProfissional);
                jPassaramCursos.setText(String.valueOf(pTotalCursaApr));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPRORES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
