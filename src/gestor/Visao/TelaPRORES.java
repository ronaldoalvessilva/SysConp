/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.converterDataStringDataDate;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.IndicadoresAcompanhamento;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class TelaPRORES extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    IndicadoresAcompanhamento objPerfilInter = new IndicadoresAcompanhamento();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();
    //
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
    //PEDAGOGIA
    int qICAA = 0;
    int qIC1 = 0;
    int qIC2P = 0;
    int qIAAU = 0;
    int qIC3 = 0;
    int qIREL = 0;
    int qIAC = 0;
    int qICU1 = 0;
    int qIC2 = 0;
    int qICA = 0;
    //JURIDICO/CRC
    int qtdProcessos = 0;
    int qtdDocumentacao = 0;
    int qtdProggressao = 0;
    int qtdLivramento = 0;
    //TERAPIA OCUPACIONAL
    int qtdPrograma = 0;
    int qtdCurso = 0;
    int qtdProfissional = 0;
    //PSICOLOGIA
    int qtdTratamento = 0;
    int qtdAcompanha = 0;
    int qtdRecuperacao = 0;
    //SERVIÇO SOCIAL
    int qtdAcompanhaSS = 0;
    //
    int qtdProd = 0;
    //
    String dataInicial, dataFinal = "";

    /**
     * Creates new form TelaPRORES
     */
    public TelaPRORES() {
        initComponents();
        corCampos();
        limparCampos();
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            convertedata.converter(jDataSistema.getText());
            preencherTabelaEstatistica("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO "
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA.IdIndAco "
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA.IdIndAco "
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC.IdIndAco "
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_TO "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_TO.IdIndAco "
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_PSI "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_PSI.IdIndAco"
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_SS "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_SS.IdIndAco "
                    + "WHERE INDICADOR_ACOMPANHAMENTO_INTERNO.DataPerfil BETWEEN '" + dataInicial + "' "
                    + "AND '" + dataFinal + "'");
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            preencherTabelaEstatistica("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO "
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA.IdIndAco "
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA.IdIndAco "
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC.IdIndAco "
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_TO "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_TO.IdIndAco "
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_PSI "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_PSI.IdIndAco"
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_SS "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_SS.IdIndAco "
                    + "WHERE INDICADOR_ACOMPANHAMENTO_INTERNO.DataPerfil BETWEEN '" + dataInicial + "' "
                    + "AND '" + dataFinal + "'");
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
        jDiabetes = new javax.swing.JTextField();
        jHipertensao = new javax.swing.JTextField();
        jHepatiteB = new javax.swing.JTextField();
        jHepatiteC = new javax.swing.JTextField();
        jEscabiose = new javax.swing.JTextField();
        jHanseniase = new javax.swing.JTextField();
        jTuberculose = new javax.swing.JTextField();
        jHiv = new javax.swing.JTextField();
        jSifilis = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jDst = new javax.swing.JTextField();
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
        PassaramCursos = new javax.swing.JTextField();
        jFormacaoProfissional = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jInternosTratamento = new javax.swing.JTextField();
        jInternosAcompanhamento = new javax.swing.JTextField();
        jInternosRecuperacao = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBtFechar = new javax.swing.JButton();
        jBtImpressao = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jBtPesquisa = new javax.swing.JButton();

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

        jDiabetes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jDiabetes.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jDiabetes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDiabetes.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDiabetes.setEnabled(false);

        jHipertensao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jHipertensao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHipertensao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHipertensao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jHipertensao.setEnabled(false);

        jHepatiteB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jHepatiteB.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHepatiteB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHepatiteB.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jHepatiteB.setEnabled(false);

        jHepatiteC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jHepatiteC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHepatiteC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHepatiteC.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jHepatiteC.setEnabled(false);

        jEscabiose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jEscabiose.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jEscabiose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEscabiose.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jEscabiose.setEnabled(false);

        jHanseniase.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jHanseniase.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHanseniase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHanseniase.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jHanseniase.setEnabled(false);

        jTuberculose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTuberculose.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTuberculose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTuberculose.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTuberculose.setEnabled(false);

        jHiv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jHiv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHiv.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHiv.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jHiv.setEnabled(false);

        jSifilis.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jSifilis.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jSifilis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSifilis.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jSifilis.setEnabled(false);

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel103.setText("Tratamento de DST %");

        jDst.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jDst.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jDst.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDst.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDst.setEnabled(false);

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
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jHiv, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSifilis, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jHanseniase, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jEscabiose, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jHepatiteC, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jHepatiteB, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jHipertensao, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDiabetes, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTuberculose, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103))
                .addGap(0, 0, Short.MAX_VALUE))
        );

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
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFamiliaAcompanhada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        PassaramCursos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PassaramCursos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        PassaramCursos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        PassaramCursos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        PassaramCursos.setEnabled(false);

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
                        .addComponent(PassaramCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(PassaramCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(jFormacaoProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Psicologia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel92.setText("Internos em tratamento %");

        jInternosTratamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jInternosTratamento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jInternosTratamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jInternosTratamento.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jInternosTratamento.setEnabled(false);

        jInternosAcompanhamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jInternosAcompanhamento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jInternosAcompanhamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jInternosAcompanhamento.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jInternosAcompanhamento.setEnabled(false);

        jInternosRecuperacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jInternosRecuperacao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jInternosRecuperacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jInternosRecuperacao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jInternosRecuperacao.setEnabled(false);

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel94.setText("Interno em recuperação %");

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel93.setText("Internos em acompanhamento %");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel92)
                    .addComponent(jLabel94)
                    .addComponent(jLabel93))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternosRecuperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternosAcompanhamento, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternosTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel92)
                    .addComponent(jInternosTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel93)
                    .addComponent(jInternosAcompanhamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel94)
                    .addComponent(jInternosRecuperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174)
                .addComponent(jBtFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtFechar)
                    .addComponent(jBtImpressao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Data Inicial:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data Final:");

        jDataFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisa.setContentAreaFilled(false);
        jBtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel24, jPanel35});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(350, 120, 576, 622);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFecharActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtFecharActionPerformed

    private void jBtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtPesquisaActionPerformed

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtImpressaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PassaramCursos;
    private javax.swing.JTextField jAdiquiriu;
    private javax.swing.JTextField jAtividadeComplementar;
    private javax.swing.JButton jBtFechar;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtPesquisa;
    private javax.swing.JTextField jConcluiuPrimeiro;
    private javax.swing.JTextField jConcluiuSegundo;
    private javax.swing.JTextField jConcluiualfabetizacao;
    private javax.swing.JTextField jCursandoAlfa;
    private javax.swing.JTextField jCursandoPrimeiro;
    private javax.swing.JTextField jCursandoSegundo;
    private javax.swing.JTextField jCursandoTerceiro;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private javax.swing.JTextField jDiabetes;
    private javax.swing.JTextField jDocumentacaoCompleta;
    private javax.swing.JTextField jDst;
    private javax.swing.JTextField jEducacaoLeitura;
    private javax.swing.JTextField jEscabiose;
    private javax.swing.JTextField jFamiliaAcompanhada;
    private javax.swing.JTextField jFormacaoProfissional;
    private javax.swing.JTextField jHanseniase;
    private javax.swing.JTextField jHepatiteB;
    private javax.swing.JTextField jHepatiteC;
    private javax.swing.JTextField jHipertensao;
    private javax.swing.JTextField jHiv;
    private javax.swing.JTextField jInseridoPrograma;
    private javax.swing.JTextField jInternosAcompanhamento;
    private javax.swing.JTextField jInternosRecuperacao;
    private javax.swing.JTextField jInternosTratamento;
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
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JTextField jLivramentoCondicional;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JTextField jProcessosAcompanhado;
    private javax.swing.JTextField jProgressaoRegime;
    private javax.swing.JTextField jSifilis;
    private javax.swing.JTextField jTuberculose;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
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
        PassaramCursos.setBackground(Color.white);
        jFormacaoProfissional.setBackground(Color.white);
        //PSICOLOGIA
        jInternosTratamento.setBackground(Color.white);
        jInternosAcompanhamento.setBackground(Color.white);
        jInternosRecuperacao.setBackground(Color.white);
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
        PassaramCursos.setText("0");
        jFormacaoProfissional.setText("0");
        //PSICOLOGIA
        jInternosTratamento.setText("0");
        jInternosAcompanhamento.setText("0");
        jInternosRecuperacao.setText("0");
        //SERVIÇO SOCIAL
        jFamiliaAcompanhada.setText("0");
    }

    public void preencherTabelaEstatistica(String sql) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            qtdDiabetes = conecta.rs.getInt("QtdDiabetes");
            qtdHipertensao = conecta.rs.getInt("QtdHipertensao");
            qtdEscabiose = conecta.rs.getInt("QtdEscabiose");
            qtdHanseniase = conecta.rs.getInt("QtdHanseniase");
            qtdSifilis = conecta.rs.getInt("QtdSifilis");
            qtdTuberculose = conecta.rs.getInt("QtdTuberculose");
            qtdHib = conecta.rs.getInt("QtdHiv");
            qtdHepatiteB = conecta.rs.getInt("QtdHepatiteB");
            qtdHepatiteC = conecta.rs.getInt("QtdHepatiteC");
            qtdDst = conecta.rs.getInt("QtdDst");
            qtdVdlr = conecta.rs.getInt("QtdVdlr");
            qtdVacina = conecta.rs.getInt("qQtdVacina");
            //PEDAGOGIA
            qICAA = conecta.rs.getInt("QtdICAA");
            qIC1 = conecta.rs.getInt("QtdIC1");
            qIC2P = conecta.rs.getInt("QtdIC2P");
            qIAAU = conecta.rs.getInt("QtdIAAU");
            qIC3 = conecta.rs.getInt("QtdIC3");
            qIREL = conecta.rs.getInt("QtdIREL");
            qIAC = conecta.rs.getInt("QtdIAC");
            qICU1 = conecta.rs.getInt("QtdICU1");
            qIC2 = conecta.rs.getInt("QtdIC2");
            qICA = conecta.rs.getInt("QtdICA");
            //JURIDICO/CRC
            qtdProcessos = conecta.rs.getInt("QtdProgresso");
            qtdDocumentacao = conecta.rs.getInt("QtdDocumentacao");
            qtdProggressao = conecta.rs.getInt("QtdProgressao");
            qtdLivramento = conecta.rs.getInt("QtdLivramento");
            //TERAPIA OCUPACIONAL
            qtdPrograma = conecta.rs.getInt("Qtdprograma");
            qtdCurso = conecta.rs.getInt("QtdCurso");
            qtdProfissional = conecta.rs.getInt("QtdProfissional");
            //PSICOLOGIA
            qtdTratamento = conecta.rs.getInt("QtdTratamento");
            qtdAcompanha = conecta.rs.getInt("QtdAcompanha");
            qtdRecuperacao = conecta.rs.getInt("QtdRecuparacao");
            //SERVIÇO SOCIAL
            qtdAcompanhaSS = conecta.rs.getInt("QtdAcompanhaSS");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public List<IndicadoresAcompanhamento> read() throws Exception {
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
        dataInicial = formatoAmerica.format(jDataInicial.getDate().getTime());
        dataFinal = formatoAmerica.format(jDataFinal.getDate().getTime());
        conecta.abrirConexao();
        List<IndicadoresAcompanhamento> listaInternosPavilhaoSelecionados = new ArrayList<IndicadoresAcompanhamento>();
        try {
            conecta.executaSQL("SELECT "
                    + "SUM(Qtdprograma) AS QtdePrograma, "
                    + "SUM(QtdDiabetes)AS QtdeDiabetes, "
                    + "SUM(QtdHipertensao)AS QtdeHipertensao, "
                    + "SUM(QtdEscabiose) AS QtdeEscabiose, "
                    + "SUM(QtdHanseniase) AS QtdeHanseniase, "
                    + "SUM(QtdSifilis) AS QtdeSifilis, "
                    + "SUM(QtdTuberculose) AS QtdeTuberculose, "
                    + "SUM(QtdHiv) AS QtdeHiv, "
                    + "SUM(QtdHepatiteB) AS QtdeEpaB, "
                    + "SUM(QtdHepatiteC) AS QtdeEpaC, "
                    + "SUM(QtdDst) AS QtdeDst, "
                    + "SUM(QtdVdlr) AS QtdeVdls, "
                    + "SUM(QtdVacina) AS QtdeVacina, "
                    + "SUM(QtdICAA) AS QtdeICCA, "
                    + "SUM(QtdIC1) AS QtdeIC1, "
                    + "SUM(QtdIC2P) AS QtdeIC2P, "
                    + "SUM(QtdIAAU) AS QtdeIAAU, "
                    + "SUM(QtdIC3) AS QtdeIC3, "
                    + "SUM(QtdIREL)  AS QtdeRel, "
                    + "SUM(QtdIAC) AS QtdeIAC, "
                    + "SUM(QtdICU1) AS QtdeICU1, "
                    + "SUM(QtdIC2) AS QtdeIC2, "
                    + "SUM(QtdICA) AS QtdeICA, "
                    + "SUM(QtdProgresso) AS QtdeProgresso, "
                    + "SUM(QtdDocumentacao) AS QtdeDocumentacao, "
                    + "SUM(QtdProgressao) AS QtdeProgressao, "
                    + "SUM(QtdLivramento) AS QtdeLivramento, "
                    + "SUM(Qtdprograma) AS QtdePrograma, "
                    + "SUM(QtdCurso) AS QtdeCurso, "
                    + "SUM(QtdProfissional) AS QtdeProfissional, "
                    + "SUM(QtdTratamento) AS QtdeTratamento, "
                    + "SUM(QtdAcompanha) AS QtdeAcompanha, "
                    + "SUM(QtdRecuperacao) AS QtdeRecuperacao, "
                    + "SUM(QtdAcompanhaSS) AS QtdeAcompanhaSS FROM INDICADOR_ACOMPANHAMENTO_INTERNO "
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA.IdIndAco "
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA.IdIndAco "
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC.IdIndAco "
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_TO "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_TO.IdIndAco "
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_PSI "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_PSI.IdIndAco "
                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_SS "
                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_SS.IdIndAco "
                    + "WHERE INDICADOR_ACOMPANHAMENTO_INTERNO.DataPerfil BETWEEN '" + dataInicial + "' "
                    + "AND '" + dataFinal + "'");
            while (conecta.rs.next()) {
                IndicadoresAcompanhamento pDigiProd = new IndicadoresAcompanhamento();
                pDigiProd.setQtdDiabetes(conecta.rs.getInt("QtdeDiabetes"));
                pDigiProd.setQtdHipertensao(conecta.rs.getInt("QtdeHipertensao"));
                pDigiProd.setQtdEscabiose(conecta.rs.getInt("QtdeEscabiose"));
                pDigiProd.setQtdHanseniase(conecta.rs.getInt("QtedHanseniase"));
                pDigiProd.setQtdSifilis(conecta.rs.getInt("QtdeSifilis"));
                pDigiProd.setQtdTuberculose(conecta.rs.getInt("QtdeTuberculose"));
                pDigiProd.setQtdHib(conecta.rs.getInt("QtdeHiv"));
                pDigiProd.setQtdHepatiteB(conecta.rs.getInt("QtdeHepatiteB"));
                pDigiProd.setQtdHepatiteC(conecta.rs.getInt("QtdeHepatiteC"));
                pDigiProd.setQdtDst(conecta.rs.getInt("QtdeDst"));
                pDigiProd.setQtdVdlr(conecta.rs.getInt("QtdeVdlr"));
                pDigiProd.setQtdVacina(conecta.rs.getInt("QtdeVacina"));
                //PEDAGOGIA
                pDigiProd.setQtdICAA(conecta.rs.getInt("QtdeICAA"));
                pDigiProd.setQtdIC1(conecta.rs.getInt("QtdeIC1"));
                pDigiProd.setQtdIC2P(conecta.rs.getInt("QtdeIC2P"));
                pDigiProd.setQtdIAAU(conecta.rs.getInt("QtdeIAAU"));
                pDigiProd.setQtdIC3(conecta.rs.getInt("QtdeIC3"));
                pDigiProd.setQtdIREL(conecta.rs.getInt("QtdeIREL"));
                pDigiProd.setQtdIAC(conecta.rs.getInt("QtdeIAC"));
                pDigiProd.setQtdICU1(conecta.rs.getInt("QtdeICU1"));
                pDigiProd.setQtdIC2(conecta.rs.getInt("QtdeIC2"));
                pDigiProd.setQtdICA(conecta.rs.getInt("QtdeICA"));
                //JURIDICO/CRC
                pDigiProd.setQtdProgresso(conecta.rs.getInt("QtdeProgresso"));
                pDigiProd.setQtdDocumentacao(conecta.rs.getInt("QtdeDocumentacao"));
                pDigiProd.setQtdProgressao(conecta.rs.getInt("QtdeProgressao"));
                pDigiProd.setQtdLivramento(conecta.rs.getInt("QtdeLivramento"));
                //TERAPIA OCUPACIONAL
                pDigiProd.setQtdprograma(conecta.rs.getInt("QtdePrograma"));
                pDigiProd.setQtdCurso(conecta.rs.getInt("QtdeCurso"));
                pDigiProd.setQtdProfissional(conecta.rs.getInt("QtdeProfissional"));
                //PSICOLOGIA
                pDigiProd.setQtdTratamento(conecta.rs.getInt("QtdeTratamento"));
                pDigiProd.setQtdAcompanha(conecta.rs.getInt("QtdeAcompanha"));
                pDigiProd.setQtdRecuparacao(conecta.rs.getInt("QtdeRecuperacao"));
                //SERVIÇO SOCIAL
                pDigiProd.setQtdAcompanhaSS(conecta.rs.getInt("QtdeAcompanhaSS"));
                listaInternosPavilhaoSelecionados.add(pDigiProd);
                qtdProd = qtdProd + 1;
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(TelaPRORES.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

//    public List<IndicadoresAcompanhamento> read() throws Exception {
//        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
//        dataInicial = formatoAmerica.format(jDataInicial.getDate().getTime());
//        dataFinal = formatoAmerica.format(jDataFinal.getDate().getTime());
//        conecta.abrirConexao();
//        List<IndicadoresAcompanhamento> listaInternosPavilhaoSelecionados = new ArrayList<IndicadoresAcompanhamento>();
//        try {
//            conecta.executaSQL("SELECT * FROM INDICADOR_ACOMPANHAMENTO_INTERNO "
//                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA "
//                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA.IdIndAco "
//                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA "
//                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA.IdIndAco "
//                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC "
//                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC.IdIndAco "
//                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_TO "
//                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_TO.IdIndAco "
//                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_PSI "
//                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_PSI.IdIndAco "
//                    + "INNER JOIN INDICADOR_ACOMPANHAMENTO_INTERNO_SS "
//                    + "ON INDICADOR_ACOMPANHAMENTO_INTERNO.IdIndAco=INDICADOR_ACOMPANHAMENTO_INTERNO_SS.IdIndAco "
//                    + "WHERE INDICADOR_ACOMPANHAMENTO_INTERNO.DataPerfil BETWEEN '" + dataInicial + "' "
//                    + "AND '" + dataFinal + "'");
//            while (conecta.rs.next()) {
//                IndicadoresAcompanhamento pDigiProd = new IndicadoresAcompanhamento();
//                pDigiProd.setQtdDiabetes(conecta.rs.getInt("QtdDiabetes"));
//                pDigiProd.setQtdHipertensao(conecta.rs.getInt("QtdHipertensao"));
//                pDigiProd.setQtdEscabiose(conecta.rs.getInt("QtdEscabiose"));
//                pDigiProd.setQtdHanseniase(conecta.rs.getInt("QtdHanseniase"));
//                pDigiProd.setQtdSifilis(conecta.rs.getInt("QtdSifilis"));
//                pDigiProd.setQtdTuberculose(conecta.rs.getInt("QtdTuberculose"));
//                pDigiProd.setQtdHib(conecta.rs.getInt("QtdHiv"));
//                pDigiProd.setQtdHepatiteB(conecta.rs.getInt("QtdHepatiteB"));
//                pDigiProd.setQtdHepatiteC(conecta.rs.getInt("QtdHepatiteC"));
//                pDigiProd.setQdtDst(conecta.rs.getInt("QtdDst"));
//                pDigiProd.setQtdVdlr(conecta.rs.getInt("QtdVdlr"));
//                pDigiProd.setQtdVacina(conecta.rs.getInt("QtdVacina"));
//                //PEDAGOGIA
//                pDigiProd.setQtdICAA(conecta.rs.getInt("QtdICAA"));
//                pDigiProd.setQtdIC1(conecta.rs.getInt("QtdIC1"));
//                pDigiProd.setQtdIC2P(conecta.rs.getInt("QtdIC2P"));
//                pDigiProd.setQtdIAAU(conecta.rs.getInt("QtdIAAU"));
//                pDigiProd.setQtdIC3(conecta.rs.getInt("QtdIC3"));
//                pDigiProd.setQtdIREL(conecta.rs.getInt("QtdIREL"));
//                pDigiProd.setQtdIAC(conecta.rs.getInt("QtdIAC"));
//                pDigiProd.setQtdICU1(conecta.rs.getInt("QtdICU1"));
//                pDigiProd.setQtdIC2(conecta.rs.getInt("QtdIC2"));
//                pDigiProd.setQtdICA(conecta.rs.getInt("QtdICA"));
//                //JURIDICO/CRC
//                pDigiProd.setQtdProgresso(conecta.rs.getInt("QtdProgresso"));
//                pDigiProd.setQtdDocumentacao(conecta.rs.getInt("QtdDocumentacao"));
//                pDigiProd.setQtdProgressao(conecta.rs.getInt("QtdProgressao"));
//                pDigiProd.setQtdLivramento(conecta.rs.getInt("QtdLivramento"));
//                //TERAPIA OCUPACIONAL
//                pDigiProd.setQtdprograma(conecta.rs.getInt("Qtdprograma"));
//                pDigiProd.setQtdCurso(conecta.rs.getInt("QtdCurso"));
//                pDigiProd.setQtdProfissional(conecta.rs.getInt("QtdProfissional"));
//                //PSICOLOGIA
//                pDigiProd.setQtdTratamento(conecta.rs.getInt("QtdTratamento"));
//                pDigiProd.setQtdAcompanha(conecta.rs.getInt("QtdAcompanha"));
//                pDigiProd.setQtdRecuparacao(conecta.rs.getInt("QtdRecuperacao"));
//                //SERVIÇO SOCIAL
//                pDigiProd.setQtdAcompanhaSS(conecta.rs.getInt("QtdAcompanhaSS"));
//                listaInternosPavilhaoSelecionados.add(pDigiProd);
//                qtdProd = qtdProd + 1;
//            }
//            return listaInternosPavilhaoSelecionados;
//        } catch (SQLException ex) {
//            Logger.getLogger(TelaPRORES.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            conecta.desconecta();
//        }
//        return null;
//    }
}