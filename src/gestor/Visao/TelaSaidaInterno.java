/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleItensPrevisaoSaida;
import gestor.Controle.ControleItensSaidaInterno;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleModificaAgendaEscoltaSaida;
import gestor.Controle.ControleMovInternos;
import gestor.Controle.ControleMovSaidaEvasao;
import gestor.Controle.ControleSaidaInternos;
import gestor.Controle.ControleSituacao;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.LimiteDigitosAlfa;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.ItensAgendaEscolta;
import gestor.Modelo.ItensMovSaidaRetorno;
import gestor.Modelo.ItensPrevisaoSaida;
import gestor.Modelo.ItensSaidaInterno;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProntuarioCrc;
import gestor.Modelo.SaidaInternos;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloCRC.codAbrirCRC;
import static gestor.Visao.TelaModuloCRC.codAlterarCRC;
import static gestor.Visao.TelaModuloCRC.codConsultarCRC;
import static gestor.Visao.TelaModuloCRC.codExcluirCRC;
import static gestor.Visao.TelaModuloCRC.codGravarCRC;
import static gestor.Visao.TelaModuloCRC.codIncluirCRC;
import static gestor.Visao.TelaModuloCRC.codUserAcessoCRC;
import static gestor.Visao.TelaModuloCRC.codigoGrupoCRC;
import static gestor.Visao.TelaModuloCRC.codigoUserCRC;
import static gestor.Visao.TelaModuloCRC.codigoUserGroupCRC;
import static gestor.Visao.TelaModuloCRC.nomeGrupoCRC;
import static gestor.Visao.TelaModuloCRC.nomeTelaCRC;
import static gestor.Visao.TelaModuloCRC.telaPrevisaoSaidaInteCRC;
import static gestor.Visao.TelaModuloCRC.telaPrevisaoSaidaManuCRC;
import static gestor.Visao.TelaModuloCRC.telaSaidaInternosAgenCRC;
import static gestor.Visao.TelaModuloCRC.telaSaidaInternosInteCRC;
import static gestor.Visao.TelaModuloCRC.telaSaidaInternosManuCRC;
import static gestor.Visao.TelaModuloCRC.telaSaidaInternosPrevCRC;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author user
 */
public class TelaSaidaInterno extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SaidaInternos objSaida = new SaidaInternos();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    ControleSaidaInternos control = new ControleSaidaInternos();
    ItensSaidaInterno objItemSaida = new ItensSaidaInterno();
    ControleItensSaidaInterno controle = new ControleItensSaidaInterno();
    ControleSituacao mod = new ControleSituacao();
    ItensMovSaidaRetorno objMovSaiRetornoEva = new ItensMovSaidaRetorno(); // Classe de saida com verificação de retorno
    ControleMovSaidaEvasao controlMovSaiRet = new ControleMovSaidaEvasao(); // Classe que grava os dados para retorno saida temporaria MOVISR
    ControleMovInternos controlMov = new ControleMovInternos(); // HISTÓRICO DE MOVIMENTAÇÃO DE SAIDA NO CRC
    // Alterar a utilização da previsão de saida como "Não" caso seja excluido o interno e tenha previsão de saida
    ItensPrevisaoSaida objItensPreSaida = new ItensPrevisaoSaida();
    ControleItensPrevisaoSaida controlePrevSai = new ControleItensPrevisaoSaida();
    // ATUALIZAR A AGENDA MÉDICA/ESCOLTA
    ItensAgendaEscolta objItensAgenda = new ItensAgendaEscolta();
    ControleModificaAgendaEscoltaSaida controleAgenda = new ControleModificaAgendaEscoltaSaida();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "CRC:Saida de Internos:Manutenção";
    String nomeModuloTela2 = "CRC:Saida de Internos:Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int acao;
    int flag;
    int codSai;
    String tipo = "Saídas";
    String situacao = "SAIDA TEMPORARIA"; // Máximo 19 caracteres
    String saidaAudiencia = "SAIDA PARA AUDIENCIA";
    int flagItem;
    int codItem = 0;
    public static String idItem;
    String nrDoc;
    String nrDocumentoRetorno = ""; //Número documeto vazio para gerar o aviso de evasão
    String codSaida;
    String dataLancaMov;
    String dataSaida;
    String dataInicial, dataBrasil;
    String dataFinal;
    String statusSaida = "ABERTO";
    String idInternoAudiencia; // Código do interno da audiencia
    String evadido = "";
    String caminho;
    String Saidaconfirmada = "Não"; // CRC Informa como não para PORTARIA PODER DA SAIDA
    String idInternoTrans;
    String confirmacaoSaida;
    // Variaveis para exclusão dos ITENSPREVSAIDA
    String utilizacaoPrevSaida;
    String utilizadoSaida = "Sim"; // Para pesquisa da exclusão
    int count = 0;
    // DADOS DA AGENDA DE ESCOLTA
    String utilizaAgenda;
    public static int codItemAgenda;
    String codInternoAnt; // CÓDIGO DO INTERNO PARA SER  ALTERADO A AGENDA DE ESCOLTA
    String codDocAnterior;

    /**
     * Creates new form TelaSaidaInterno
     */
    public TelaSaidaInterno() {
        initComponents();
        formatarCampos();
        corCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jIDPesqLan = new javax.swing.JTextField();
        jBtDataLanc = new javax.swing.JButton();
        jBtIdLanc = new javax.swing.JButton();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtNomeInterno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaSaidaInterno = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jBtNovolanc = new javax.swing.JButton();
        jBtAlterarlanc = new javax.swing.JButton();
        jBtExcluirlanc = new javax.swing.JButton();
        jBtSalvarlanc = new javax.swing.JButton();
        jBtCancelarlanc = new javax.swing.JButton();
        jBtAudiSaida = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTabelaItensInterno = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jIDlanc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jStatusSaida = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jDescricaoOp = new javax.swing.JTextField();
        jBtPesqOperacao = new javax.swing.JButton();
        jDataLancamento = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaObs = new javax.swing.JTextArea();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jIDInterno = new javax.swing.JTextField();
        jNomeInterno = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jBtPesInterno = new javax.swing.JButton();
        jDataSaida = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        totalRegistrosInternos = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabelEvadido = new javax.swing.JLabel();
        jNrDocumento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jHoraSaida = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jProcedencia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jDestinoInterno = new javax.swing.JTextField();
        jDataEntrada = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jDataRetorno = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jBtNovoItem = new javax.swing.JButton();
        jBtAlterarItem = new javax.swing.JButton();
        jBtExcluirItem = new javax.swing.JButton();
        jBtSalvarItem = new javax.swing.JButton();
        jBtCancelarItem = new javax.swing.JButton();
        jBtItensAudiSaidaInternos = new javax.swing.JButton();
        jBtBuscarPrevisao = new javax.swing.JButton();
        jBtSairItens = new javax.swing.JButton();
        jBtBuscarAgenda = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        FotoInternoCrcSaida = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Saida de Internos :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa Lançamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Data Inicial:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Código:");

        jIDPesqLan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtDataLanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtDataLanc.setContentAreaFilled(false);
        jBtDataLanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDataLancActionPerformed(evt);
            }
        });

        jBtIdLanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtIdLanc.setContentAreaFilled(false);
        jBtIdLanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIdLancActionPerformed(evt);
            }
        });

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Data Final:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Nome do Interno:");

        jPesqNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtNomeInterno.setContentAreaFilled(false);
        jBtNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNomeInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jCheckBox1)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtIdLanc)
                    .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtDataLanc)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtNomeInterno)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaSaidaInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaSaidaInterno.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTabelaSaidaInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"
            }
        ));
        jTabelaSaidaInterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaSaidaInternoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaSaidaInterno);
        if (jTabelaSaidaInterno.getColumnModel().getColumnCount() > 0) {
            jTabelaSaidaInterno.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaSaidaInterno.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaSaidaInterno.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaSaidaInterno.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaSaidaInterno.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaSaidaInterno.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaSaidaInterno.getColumnModel().getColumn(3).setMinWidth(120);
            jTabelaSaidaInterno.getColumnModel().getColumn(3).setMaxWidth(120);
            jTabelaSaidaInterno.getColumnModel().getColumn(4).setMinWidth(180);
            jTabelaSaidaInterno.getColumnModel().getColumn(4).setMaxWidth(180);
            jTabelaSaidaInterno.getColumnModel().getColumn(5).setMinWidth(280);
            jTabelaSaidaInterno.getColumnModel().getColumn(5).setMaxWidth(280);
        }

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel63.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel63))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63)
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        jBtNovolanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovolanc.setText("Novo");
        jBtNovolanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovolancActionPerformed(evt);
            }
        });

        jBtAlterarlanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarlanc.setText("Alterar");
        jBtAlterarlanc.setEnabled(false);
        jBtAlterarlanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarlancActionPerformed(evt);
            }
        });

        jBtExcluirlanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirlanc.setText("Excluir");
        jBtExcluirlanc.setEnabled(false);
        jBtExcluirlanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirlancActionPerformed(evt);
            }
        });

        jBtSalvarlanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarlanc.setText("Gravar");
        jBtSalvarlanc.setEnabled(false);
        jBtSalvarlanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarlancActionPerformed(evt);
            }
        });

        jBtCancelarlanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarlanc.setText("Cancelar");
        jBtCancelarlanc.setEnabled(false);
        jBtCancelarlanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarlancActionPerformed(evt);
            }
        });

        jBtAudiSaida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAudiSaida.setForeground(new java.awt.Color(0, 0, 255));
        jBtAudiSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAudiSaida.setContentAreaFilled(false);
        jBtAudiSaida.setEnabled(false);
        jBtAudiSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAudiSaidaActionPerformed(evt);
            }
        });

        jBtFinalizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtFinalizar.setForeground(new java.awt.Color(255, 0, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovolanc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarlanc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirlanc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarlanc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarlanc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAudiSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtAudiSaida)
                    .addComponent(jBtCancelarlanc)
                    .addComponent(jBtSalvarlanc)
                    .addComponent(jBtExcluirlanc)
                    .addComponent(jBtAlterarlanc)
                    .addComponent(jBtNovolanc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarlanc, jBtCancelarlanc, jBtExcluirlanc, jBtFinalizar, jBtNovolanc, jBtSalvarlanc});

        jTabelaItensInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaItensInterno.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTabelaItensInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Seq.", "Nome do Interno", "Data Saída", "Destino", "Documento"
            }
        ));
        jTabelaItensInterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaItensInternoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTabelaItensInterno);
        if (jTabelaItensInterno.getColumnModel().getColumnCount() > 0) {
            jTabelaItensInterno.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaItensInterno.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaItensInterno.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaItensInterno.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaItensInterno.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaItensInterno.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaItensInterno.getColumnModel().getColumn(3).setMinWidth(170);
            jTabelaItensInterno.getColumnModel().getColumn(3).setMaxWidth(170);
            jTabelaItensInterno.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaItensInterno.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jIDlanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDlanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDlanc.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Código");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Status");

        jStatusSaida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusSaida.setForeground(new java.awt.Color(255, 0, 0));
        jStatusSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusSaida.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Descrição da Operação");

        jDescricaoOp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoOp.setEnabled(false);

        jBtPesqOperacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqOperacao.setContentAreaFilled(false);
        jBtPesqOperacao.setEnabled(false);
        jBtPesqOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqOperacaoActionPerformed(evt);
            }
        });

        jDataLancamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLancamento.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Data Doc.");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jDescricaoOp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jIDlanc, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(0, 139, Short.MAX_VALUE))
                                    .addComponent(jStatusSaida))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIDlanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDescricaoOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dados Documento", jPanel11);

        jTextAreaObs.setColumns(20);
        jTextAreaObs.setRows(5);
        jTextAreaObs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextAreaObs.setEnabled(false);
        jScrollPane2.setViewportView(jTextAreaObs);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Observação", jPanel12);

        jTabbedPane3.setForeground(new java.awt.Color(0, 153, 0));
        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Código:");

        jIDInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDInterno.setEnabled(false);

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);
        jNomeInterno.setPreferredSize(new java.awt.Dimension(3, 18));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Nome Completo do Interno");

        jBtPesInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesInterno.setContentAreaFilled(false);
        jBtPesInterno.setEnabled(false);
        jBtPesInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesInternoActionPerformed(evt);
            }
        });

        jDataSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataSaida.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Data Saida");

        totalRegistrosInternos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalRegistrosInternos.setForeground(new java.awt.Color(255, 0, 0));
        totalRegistrosInternos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalRegistrosInternos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Total Reg.");

        jLabelEvadido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelEvadido.setForeground(new java.awt.Color(255, 0, 0));

        jNrDocumento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNrDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNrDocumento.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Documento");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Horário Saída");

        jHoraSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHoraSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHoraSaida.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIDInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addComponent(jLabel18)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jHoraSaida)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jNrDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(totalRegistrosInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jNomeInterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(143, 143, 143))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(jIDInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel18))
                    .addComponent(jLabel8)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jHoraSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNrDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalRegistrosInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Dados do Interno", jPanel13);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Origem");

        jProcedencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jProcedencia.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Destino");

        jDestinoInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDestinoInterno.setEnabled(false);

        jDataEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrada.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Data Entrada");

        jDataRetorno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRetorno.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Data Retorno");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jDestinoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jDestinoInterno, jProcedencia});

        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDestinoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Dados Documento", jPanel14);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        jBtNovoItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoItem.setText("Novo");
        jBtNovoItem.setEnabled(false);
        jBtNovoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoItemActionPerformed(evt);
            }
        });

        jBtAlterarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarItem.setText("Alterar");
        jBtAlterarItem.setEnabled(false);
        jBtAlterarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarItemActionPerformed(evt);
            }
        });

        jBtExcluirItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirItem.setText("Excluir");
        jBtExcluirItem.setEnabled(false);
        jBtExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirItemActionPerformed(evt);
            }
        });

        jBtSalvarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarItem.setText("Gravar");
        jBtSalvarItem.setEnabled(false);
        jBtSalvarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarItemActionPerformed(evt);
            }
        });

        jBtCancelarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarItem.setText("Cancelar");
        jBtCancelarItem.setEnabled(false);
        jBtCancelarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarItemActionPerformed(evt);
            }
        });

        jBtItensAudiSaidaInternos.setForeground(new java.awt.Color(255, 0, 0));
        jBtItensAudiSaidaInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtItensAudiSaidaInternos.setToolTipText("Auditoria");
        jBtItensAudiSaidaInternos.setContentAreaFilled(false);
        jBtItensAudiSaidaInternos.setEnabled(false);
        jBtItensAudiSaidaInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtItensAudiSaidaInternosActionPerformed(evt);
            }
        });

        jBtBuscarPrevisao.setForeground(new java.awt.Color(0, 0, 255));
        jBtBuscarPrevisao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtBuscarPrevisao.setText("Previsão");
        jBtBuscarPrevisao.setToolTipText("Buscar Previsão");
        jBtBuscarPrevisao.setEnabled(false);
        jBtBuscarPrevisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarPrevisaoActionPerformed(evt);
            }
        });

        jBtSairItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairItens.setText("Sair");
        jBtSairItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairItensActionPerformed(evt);
            }
        });

        jBtBuscarAgenda.setForeground(new java.awt.Color(255, 0, 0));
        jBtBuscarAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtBuscarAgenda.setText("Agenda");
        jBtBuscarAgenda.setToolTipText("Buscar na Agenda");
        jBtBuscarAgenda.setEnabled(false);
        jBtBuscarAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarAgendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jBtItensAudiSaidaInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtBuscarAgenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtExcluirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtNovoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtAlterarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtSalvarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtSairItens, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtBuscarPrevisao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtCancelarItem))))
                .addGap(125, 125, 125))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarItem, jBtBuscarPrevisao, jBtCancelarItem, jBtExcluirItem, jBtNovoItem, jBtSairItens, jBtSalvarItem});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jBtNovoItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtBuscarPrevisao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtBuscarAgenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSairItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtItensAudiSaidaInternos)
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarItem, jBtCancelarItem, jBtExcluirItem, jBtItensAudiSaidaInternos, jBtNovoItem, jBtSairItens, jBtSalvarItem});

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1117_128x128_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FotoInternoCrcSaida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FotoInternoCrcSaida, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, Short.MAX_VALUE)
        );

        setBounds(300, 20, 693, 535);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqOperacaoActionPerformed
        // TODO add your handling code here:
        TelaPesquisaOpSaida objOpSaida = new TelaPesquisaOpSaida();
        TelaModuloCRC.jPainelCRC.add(objOpSaida);
        objOpSaida.show();
    }//GEN-LAST:event_jBtPesqOperacaoActionPerformed

    private void jBtNovolancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovolancActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSaidaInternosManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaSaidaInternosManuCRC) && codIncluirCRC == 1) {
            acao = 1;
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovolancActionPerformed

    private void jBtAlterarlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarlancActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSaidaInternosManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaSaidaInternosManuCRC) && codAlterarCRC == 1) {
            objSaida.setStatusSaida(jStatusSaida.getText());
            if (jStatusSaida.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                Alterar();
                corCampos();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarlancActionPerformed

    private void jBtExcluirlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirlancActionPerformed
        buscarAcessoUsuario(telaSaidaInternosManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaSaidaInternosManuCRC) && codExcluirCRC == 1) {
            objSaida.setStatusSaida(jStatusSaida.getText());
            if (jStatusSaida.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser excluída, o mesmo encontra-se FINALIZADO");
            } else {
                verificarItens();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirlancActionPerformed

    private void jBtSalvarlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarlancActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSaidaInternosManuCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaSaidaInternosManuCRC) && codGravarCRC == 1) {
            if (jDescricaoOp.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome da operação de saida");
                jDescricaoOp.requestFocus();
            } else {
                if (jDataLancamento.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data de lançamento");
                } else {
                    objSaida.setDataLanc(jDataLancamento.getDate());
                    objSaida.setStatusSaida(statusSaida);
                    objSaida.setNomeOperacao(jDescricaoOp.getText());
                    objSaida.setObsSaida(jTextAreaObs.getText());
                    try {
                        if (acao == 1) {
                            objSaida.setUsuarioInsert(nameUser);
                            objSaida.setDataInsert(dataModFinal);
                            objSaida.setHoraInsert(horaMov);
                            //
                            control.incluirSaidaInternos(objSaida);
                            buscarCodSaida();
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            JOptionPane.showMessageDialog(rootPane, "Registro INCLUIDO com sucesso, será necessário\nincluir os internos na aba (INTERNOS)\npara que possa ser registrado a movimentação.");
                            Salvar();
                        }
                        if (acao == 2) {
                            objSaida.setUsuarioUp(nameUser);
                            objSaida.setDataUp(dataModFinal);
                            objSaida.setHoraUp(horaMov);
                            //
                            objSaida.setIdSaida(Integer.parseInt(jIDlanc.getText()));
                            control.alterarSaidaInternos(objSaida);
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            JOptionPane.showMessageDialog(rootPane, "Registro ALTERADO com sucesso, será necessário\nincluir os internos na aba (INTERNOS)\npara que possa ser registrado a movimentação.");
                            Salvar();
                        }
                    } catch (HeadlessException | NumberFormatException e) {
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível gravar o registro \nERRO: " + e);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarlancActionPerformed

    private void jBtCancelarlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarlancActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarlancActionPerformed

    private void jBtDataLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDataLancActionPerformed
        // TODO add your handling code here
        count = 0;
        flag = 1;
        if (jDataPesqInicial.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
            jDataPesqInicial.requestFocus();
        } else {
            if (jDataPesFinal.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                jDataPesFinal.requestFocus();
            } else {
                if (jDataPesqInicial.getDate().after(jDataPesFinal.getDate())) {
                    JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                } else {
                    SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                    dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                    dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                    jTabelaSaidaInterno.setVisible(true);
                    pesquisarLancCod("SELECT * FROM SAIDACRC "
                            + "INNER JOIN OPERACAO "
                            + "ON SAIDACRC.IdOp = OPERACAO.IdOp "
                            + "WHERE DataLancaMov BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                }
            }
        }
    }//GEN-LAST:event_jBtDataLancActionPerformed

    private void jBtIdLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIdLancActionPerformed
        // TODO add your handling code here:
        // Pesquisa por data de lançamento
        count = 0;
        jTabelaSaidaInterno.setVisible(true);
        pesquisarLancCod("SELECT * FROM SAIDACRC "
                + "INNER JOIN OPERACAO "
                + "ON SAIDACRC.IdOp=OPERACAO.IdOp "
                + "WHERE IdSaida='" + jIDPesqLan.getText() + "'");
    }//GEN-LAST:event_jBtIdLancActionPerformed

    private void jTabelaSaidaInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaSaidaInternoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaSaidaInterno.getValueAt(jTabelaSaidaInterno.getSelectedRow(), 0);
            jIDPesqLan.setText(IdLanc);
            // jDataLancamento.setDate(jDataLancamento.getDate());
            jBtNovolanc.setEnabled(!true);
            jBtAlterarlanc.setEnabled(true);
            jBtExcluirlanc.setEnabled(true);
            jBtSalvarlanc.setEnabled(!true);
            jBtCancelarlanc.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtNovoItem.setEnabled(true);
            jBtAudiSaida.setEnabled(true);
            //
            bloquearCamposPesquisa();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM SAIDACRC "
                        + "INNER JOIN OPERACAO "
                        + "ON SAIDACRC.IdOp = OPERACAO.IdOp "
                        + "WHERE IdSaida ='" + IdLanc + "'");
                conecta.rs.first();
                jIDlanc.setText(String.valueOf(conecta.rs.getInt("IdSaida")));
                jStatusSaida.setText(conecta.rs.getString("StatusSai"));
                jDataLancamento.setDate(conecta.rs.getDate("DataLancaMov"));
                jDescricaoOp.setText(conecta.rs.getString("DescricaoOp"));
                jTextAreaObs.setText(conecta.rs.getString("ObsSaida"));
                conecta.desconecta();
                jTabelaItensInterno.setVisible(true);
                jTabelaItensInterno.setEnabled(true);
                count = 0;
                preencherTabelaItens("SELECT * FROM ITENSSAIDA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdSaida='" + IdLanc + "'");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por DATA " + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaSaidaInternoMouseClicked

    private void jBtPesInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesInternoActionPerformed
        // TODO add your handling code here:
        TelaPesquisaSaidaInterno objSaidafInt = new TelaPesquisaSaidaInterno();
        TelaModuloCRC.jPainelCRC.add(objSaidafInt);
        objSaidafInt.show();
    }//GEN-LAST:event_jBtPesInternoActionPerformed

    private void jTabelaItensInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaItensInternoMouseClicked
        // TODO add your handling code here:
//        jTabelaItensInterno.setVisible(true);
//        jTabelaItensInterno.setEnabled(true);
        if (flag == 1) {
            String nomeInterno = "" + jTabelaItensInterno.getValueAt(jTabelaItensInterno.getSelectedRow(), 1);
            jNomeInterno.setText(nomeInterno);
            idItem = "" + jTabelaItensInterno.getValueAt(jTabelaItensInterno.getSelectedRow(), 0);
            nrDoc = "" + jTabelaItensInterno.getValueAt(jTabelaItensInterno.getSelectedRow(), 4);
            // Habilitar os botões
            jBtNovoItem.setEnabled(!true);
            jBtAlterarItem.setEnabled(true);
            jBtExcluirItem.setEnabled(true);
            jBtSalvarItem.setEnabled(!true);
            jBtCancelarItem.setEnabled(true);
            jBtItensAudiSaidaInternos.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN UNIDADE "
                        + "ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid "
                        + "INNER JOIN ITENSSAIDA "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSSAIDA.IdInternoCrc "
                        + "WHERE NomeInternoCrc='" + jNomeInterno.getText() + "' AND IdSaida='" + jIDlanc.getText() + "'AND DocumentoSaida='" + nrDoc + "'AND IdItem='" + idItem + "'");
                conecta.rs.first();
                jIDInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                // CASO NECESSITE MUDAR O INTERNO - TESTADO COM SUCESSO EM 09/09/2016
                codInternoAnt = conecta.rs.getString("IdInternoCrc");
                codDocAnterior = conecta.rs.getString("DocumentoSaida");
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                FotoInternoCrcSaida.setIcon(i);
                FotoInternoCrcSaida.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoInternoCrcSaida.getWidth(), FotoInternoCrcSaida.getHeight(), Image.SCALE_DEFAULT)));
                //
                idItem = conecta.rs.getString("IdItem");
                codItem = conecta.rs.getInt("IdItem");
                jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                jHoraSaida.setText(conecta.rs.getString("HoraSaida"));
                jDataRetorno.setDate(conecta.rs.getDate("DataRetorno"));
                jProcedencia.setText(conecta.rs.getString("DescricaoUnid"));
                jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                jDestinoInterno.setText(conecta.rs.getString("DestinoSaida"));
                jNrDocumento.setText(conecta.rs.getString("DocumentoSaida"));
                jLabelEvadido.setText(conecta.rs.getString("Evadido"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!\nERRO: " + ex);
            }
        }
    }//GEN-LAST:event_jTabelaItensInternoMouseClicked

    private void jBtNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSaidaInternosInteCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaSaidaInternosInteCRC) && codIncluirCRC == 1) {
            objSaida.setStatusSaida(jStatusSaida.getText());
            if (jStatusSaida.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                if (jDescricaoOp.getText().equals(situacao)) {
                    jDataRetorno.setCalendar(Calendar.getInstance());
                    jDataRetorno.setEnabled(true);
                }
                NovoItem();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                codItem = 0; // zera na memória o item
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoItemActionPerformed

    private void jBtAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSaidaInternosInteCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaSaidaInternosInteCRC) && codAlterarCRC == 1) {
            objSaida.setStatusSaida(jStatusSaida.getText());
            if (jStatusSaida.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                if (jLabelEvadido.getText().equals("EVADIDO")) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o interno está evadido.");
                } else {
                    acao = 4;
                    flag = 1;
                    if (jDescricaoOp.getText().equals(situacao)) {
                        jDataRetorno.setEnabled(true);
                    }
                    verificarSaidaPortaria();
                    if (confirmacaoSaida.equals("Sim")) {
                        JOptionPane.showMessageDialog(rootPane, "Não é possível alterar esse registro, o mesmo está\nfazendo parte de uma integração com a portaria.");
                    } else {
                        verificarUtilizacaoPrevisaoSaida();
                        if (utilizacaoPrevSaida == null) {
                            AlterarItem();
                            statusMov = "Alterou";
                            horaMov = jHoraSistema.getText();
                            dataModFinal = jDataSistema.getText();
                        } else {
                            if (utilizacaoPrevSaida.equals("Sim")) {
                                JOptionPane.showMessageDialog(rootPane, "Não é possível alterar esse registro, o mesmo está\nfazendo parte de uma integração com a previsão de saida.");
                            } else {
                                AlterarItem();
                                statusMov = "Alterou";
                                horaMov = jHoraSistema.getText();
                                dataModFinal = jDataSistema.getText();
                            }
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarItemActionPerformed

    private void jBtExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSaidaInternosInteCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaSaidaInternosInteCRC) && codExcluirCRC == 1) {
            verificarSaidaPortaria();
            buscarItemInternoAgenda(); // BUSCAR ITEM DA TABELA ITENSAGENDA PARA MODIFICAR A RESPOSTA DE "Sim" PARA "Não"
            if (confirmacaoSaida.equals("Sim")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível excluir esse registro, o mesmo está\nfazendo parte de uma integração com a portaria.");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                objSaida.setStatusSaida(jStatusSaida.getText());
                if (jStatusSaida.getText().equals("FINALIZADO")) {
                    JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser excluida, o mesmo encontra-se FINALIZADO");
                } else {
                    if (jLabelEvadido.getText().equals("EVADIDO")) {
                        JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, o interno está evadido.");
                    } else {
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o INTERNO selecionado?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            objItemSaida.setIdItemSaida(Integer.valueOf(idItem));
                            controle.excluirItensSaida(objItemSaida);
                            //Excluir movimento de saida MOVIMENTOCRC - Corrigido em 23/01/2015 - as 15:57Hs.
                            objItemSaida.setIdSaida(Integer.valueOf(jIDlanc.getText()));
                            objItemSaida.setIdItemSaida(codItem);
                            controlMov.excluirMovSaida(objItemSaida);
                            //Alterar previsão de retorno de saida como não utilizada
                            objItensPreSaida.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                            controlePrevSai.alterarUtilizacaoPrevisaoSaida(objItensPreSaida); // Atualizar a Previsão de saida como não ITENSPREVISAOSAIDA
                            //
                            objDadosSaidaRetornoInterno();
                            controlMovSaiRet.excluirMovSaidaEvasao(objMovSaiRetornoEva); //Excluir a saida com previsão de retorno                    
                            //Excluir interno na tabela ITENSCRCPORTARIA para não da mais saida
                            // Implementado em 04/06/2015
                            objItemSaida.setIdSaida(Integer.valueOf(jIDlanc.getText()));
                            objItemSaida.setIdInternoSaida(Integer.valueOf(jIDInterno.getText()));
                            controle.excluirItensCrcPortaria(objItemSaida);
                            // MODIFICA O CAMPO (UtilizaSaida) COMO "Não"
                            utilizaAgenda = "Não";
                            modificarAgendaEscolta();
                            //
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            preencherTabelaItens("SELECT * FROM ITENSSAIDA "
                                    + "INNER JOIN PRONTUARIOSCRC "
                                    + "ON ITENSSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                    + "WHERE IdSaida='" + jIDlanc.getText() + "'");
                            JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                            ExcluirItem();

                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirItemActionPerformed

    private void jBtSalvarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarItemActionPerformed
        // TODO add your handling code here:    
        buscarAcessoUsuario(telaSaidaInternosInteCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaSaidaInternosInteCRC) && codGravarCRC == 1) {
            utilizaAgenda = "Sim"; // RESPOSTA PARA AGENDA
            if (jDestinoInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o destino do interno.");
                jDestinoInterno.requestFocus();
            } else {
                if (jNrDocumento.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe o número do documento.");
                    jNrDocumento.requestFocus();
                } else {
                    if (jDataSaida.getDate() == null) {
                        JOptionPane.showMessageDialog(rootPane, "Data de saida não pode ser em branco.");
                        jDataSaida.requestFocus();
                    } else {
                        if (jNomeInterno.getText().equals("")) {
                            JOptionPane.showMessageDialog(rootPane, "Dados do interno não pode ser em branco, faça pesquisa\ne escolha o interno");
                        } else {
                            if (jDescricaoOp.getText().equals(situacao) && jDataRetorno.getDate() == null) {
                                JOptionPane.showMessageDialog(rootPane, "Informe a data de retorno para esse interno");
                            } else {
                                objItemSaida.setIdInternoSaida(Integer.valueOf(jIDInterno.getText()));
                                objItemSaida.setNomeInterno(jNomeInterno.getText());
                                objItemSaida.setDataSaida(jDataSaida.getDate());
                                objItemSaida.setDataRetorno(jDataRetorno.getDate());
                                objItemSaida.setNomeDestino(jDescricaoOp.getText());
                                objItemSaida.setDocumento(jNrDocumento.getText());
                                objItemSaida.setConfirmaSaida(Saidaconfirmada);
                                objProCrc.setSituacao(jDescricaoOp.getText());
                                // Para o log do registro
                                objItemSaida.setUsuarioInsert(nameUser);
                                objItemSaida.setDataInsert(dataModFinal);
                                objItemSaida.setHoraInsert(horaMov);
                                try {
                                    //Incluir itens (INTERNOS)
                                    if (acao == 3) {
                                        objItemSaida.setInternoEvadido(evadido);
                                        objItemSaida.setIdSaida((Integer.parseInt(jIDlanc.getText())));
                                        controle.incluirItensSaida(objItemSaida); // Gravar registro na tabela de itens  
                                        objItemSaida.setIdSaida((Integer.parseInt(jIDlanc.getText())));
                                        buscarIdItem();
                                        objDadosSaidaRetornoInterno();
                                        // TABELA MOVISR
                                        controlMovSaiRet.incluirMovSaidaEvasao(objMovSaiRetornoEva); // Grava registros para retorno de interno (Sinalizar evasão) MOVISR
                                        // Incluir os itens na tabela para portaria registrar a saida.
                                        objItemSaida.setIdItemSaida(codItem);
                                        objItemSaida.setInternoEvadido(evadido);
                                        controle.incluirItensSaidaPortaria(objItemSaida); // Registros para portaria na tabela ITENSCRCPORTARIA
                                        if (jDescricaoOp.getText().equals(saidaAudiencia)) { // quando a saida for para audiencia
                                            int resposta = JOptionPane.showConfirmDialog(this, "Deseja lançar histórico de movimentação do interno?", "Confirmação",
                                                    JOptionPane.YES_NO_OPTION);
                                            if (resposta == JOptionPane.YES_OPTION) {
                                                //Inserir na tabela de movimentação (SAIDA) HISTÓRICO DE MOVIMENTAÇÃO NO CRC                                            
                                                objItemSaida.setIdItemSaida(codItem);
                                                controlMov.incluirMovSaida(objItemSaida);
                                                objLog2();
                                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                            }
                                        } else {
                                            if (!jDescricaoOp.getText().equals(saidaAudiencia)) {
                                                //Inserir na tabela de movimentação (SAIDA)                                             
                                                objItemSaida.setIdItemSaida(codItem);
                                                controlMov.incluirMovSaida(objItemSaida);
                                                objLog2();
                                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                            }
                                        }
                                        buscarItemInternoAgenda(); // BUSCAR ITEM DA TABELA ITENSAGENDA PARA MODIFICAR A RESPOSTA DE "Sim" PARA "Não"
                                        modificarAgendaEscolta();
                                        SalvarItem();
                                        preencherTabelaItens("SELECT * FROM ITENSSAIDA "
                                                + "INNER JOIN PRONTUARIOSCRC "
                                                + "ON ITENSSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                                + "WHERE IdSaida='" + jIDlanc.getText() + "'");
                                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                    }
                                    // Alterar os Itens (INTERNOS)
                                    if (acao == 4) {
                                        // Para o log do registro
                                        objItemSaida.setUsuarioUp(nameUser);
                                        objItemSaida.setDataUp(jDataSistema.getText());
                                        objItemSaida.setHoraUp(jHoraSistema.getText());
                                        //
                                        objItemSaida.setInternoEvadido(evadido);
                                        objItemSaida.setIdSaida((Integer.parseInt(jIDlanc.getText())));
                                        objProCrc.setIdInterno(Integer.parseInt(jIDInterno.getText()));
                                        objItemSaida.setIdItemSaida(Integer.valueOf(idItem));
                                        controle.alterarItensSaida(objItemSaida);
                                        objItemSaida.setIdSaida(Integer.valueOf(jIDlanc.getText()));
                                        // Alterar os itens na tabela para portaria registrar a saida.
                                        objItemSaida.setInternoEvadido(evadido);
                                        objItemSaida.setIdItemSaida(Integer.valueOf(idItem));
                                        controle.alterarItensSaidaPortaria(objItemSaida);
                                        objDadosSaidaRetornoInterno();
                                        controlMovSaiRet.alterarMovSaidaEvasao(objMovSaiRetornoEva);
                                        if (jDescricaoOp.getText().equals(saidaAudiencia)) { // quando a saida for para audiencia
                                            int resposta = JOptionPane.showConfirmDialog(this, "Deseja lançar histórico de movimentação do interno?", "Confirmação",
                                                    JOptionPane.YES_NO_OPTION);
                                            if (resposta == JOptionPane.YES_OPTION) {
                                                verificaSaidaAudiencia();
                                            }
                                        } else {
                                            if (!jDescricaoOp.getText().equals(saidaAudiencia)) {
                                                verificaSaidaAudiencia();
                                                objDadosSaidaRetornoInterno();
                                                controlMovSaiRet.alterarMovSaidaEvasao(objMovSaiRetornoEva);
                                                objLog2();
                                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                            }
                                        }
                                        // SE MUDAR O CÓDIGO DO INTERNO
                                        if (jIDInterno.getText() == null ? codInternoAnt != null : !jIDInterno.getText().equals(codInternoAnt)) {
                                            buscarItemInternoAgenda1();
                                            modificarAgendaEscolta1();
                                        }
                                        buscarItemInternoAgenda();
                                        modificarAgendaEscolta();
                                        //                                    
                                        SalvarItem();
                                        preencherTabelaItens("SELECT * FROM ITENSSAIDA "
                                                + "INNER JOIN PRONTUARIOSCRC "
                                                + "ON ITENSSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                                + "WHERE IdSaida='" + jIDlanc.getText() + "'");
                                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                    }
                                } catch (NumberFormatException | HeadlessException e) {
                                    JOptionPane.showMessageDialog(rootPane, "Não foi possível GRAVAR o registro" + e);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarItemActionPerformed

    private void jBtCancelarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarItemActionPerformed
        // TODO add your handling code here:
        CancelarItem();
    }//GEN-LAST:event_jBtCancelarItemActionPerformed

    private void jBtSairItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairItensActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairItensActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SAIDACRC WHERE IdSaida='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            jStatusSaida.setText(conecta.rs.getString("StatusSai"));
            if (jStatusSaida.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
            } else {
                Finalizar();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar se lançamento foi finalizado\nERRO: " + ex);
        }
        conecta.desconecta();
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodasEntradas("SELECT * FROM SAIDACRC "
                    + "INNER JOIN OPERACAO "
                    + "ON SAIDACRC.IdOp=OPERACAO.IdOp ORDER BY IdSaida");
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário informar um nome ou parte do nome para pesquuisa.");
        } else {
            jTabelaSaidaInterno.setVisible(true);
            pesquisarSaidaInterno("SELECT * FROM SAIDACRC "
                    + "INNER JOIN ITENSSAIDA "
                    + "ON SAIDACRC.IdSaida=ITENSSAIDA.IdSaida "
                    + "INNER JOIN OPERACAO ON SAIDACRC.IdOp=OPERACAO.IdOp "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'" + jPesqNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtNomeInternoActionPerformed

    private void jBtAudiSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAudiSaidaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaSaidaInternos objAudSaida = new TelaAuditoriaSaidaInternos();
        TelaModuloCRC.jPainelCRC.add(objAudSaida);
        objAudSaida.show();
    }//GEN-LAST:event_jBtAudiSaidaActionPerformed

    private void jBtItensAudiSaidaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtItensAudiSaidaInternosActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensSaidasInternos objItensAudiSaida = new TelaAuditoriaItensSaidasInternos();
        TelaModuloCRC.jPainelCRC.add(objItensAudiSaida);
        objItensAudiSaida.show();
    }//GEN-LAST:event_jBtItensAudiSaidaInternosActionPerformed

    private void jBtBuscarPrevisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarPrevisaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSaidaInternosPrevCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaSaidaInternosPrevCRC) && codAbrirCRC == 1) {
            jDataSaida.setEnabled(!true);
            TelaBuscarPrevisaoSaidaInternos objBuscarPrevSaidInternos = new TelaBuscarPrevisaoSaidaInternos();
            TelaModuloCRC.jPainelCRC.add(objBuscarPrevSaidInternos);
            objBuscarPrevSaidInternos.show();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtBuscarPrevisaoActionPerformed

    private void jBtBuscarAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarAgendaActionPerformed
        // TODO add your handling code here:telaSaidaInternosAgenCRC
        buscarAcessoUsuario(telaSaidaInternosAgenCRC);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaSaidaInternosAgenCRC) && codAbrirCRC == 1) {
            TelaPesquisaSaidaInternosAgendaEscolta objPesqAgenda = new TelaPesquisaSaidaInternosAgendaEscolta();
            TelaModuloCRC.jPainelCRC.add(objPesqAgenda);
            objPesqAgenda.show();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtBuscarAgendaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel FotoInternoCrcSaida;
    public static javax.swing.JButton jBtAlterarItem;
    private javax.swing.JButton jBtAlterarlanc;
    private javax.swing.JButton jBtAudiSaida;
    private javax.swing.JButton jBtBuscarAgenda;
    public static javax.swing.JButton jBtBuscarPrevisao;
    public static javax.swing.JButton jBtCancelarItem;
    private javax.swing.JButton jBtCancelarlanc;
    private javax.swing.JButton jBtDataLanc;
    public static javax.swing.JButton jBtExcluirItem;
    private javax.swing.JButton jBtExcluirlanc;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtIdLanc;
    public static javax.swing.JButton jBtItensAudiSaidaInternos;
    private javax.swing.JButton jBtNomeInterno;
    public static javax.swing.JButton jBtNovoItem;
    private javax.swing.JButton jBtNovolanc;
    public static javax.swing.JButton jBtPesInterno;
    private javax.swing.JButton jBtPesqOperacao;
    private javax.swing.JButton jBtSairItens;
    public static javax.swing.JButton jBtSalvarItem;
    private javax.swing.JButton jBtSalvarlanc;
    private javax.swing.JCheckBox jCheckBox1;
    public static com.toedter.calendar.JDateChooser jDataEntrada;
    private com.toedter.calendar.JDateChooser jDataLancamento;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static com.toedter.calendar.JDateChooser jDataRetorno;
    public static com.toedter.calendar.JDateChooser jDataSaida;
    public static javax.swing.JTextField jDescricaoOp;
    private javax.swing.JTextField jDestinoInterno;
    private javax.swing.JTextField jHoraSaida;
    public static javax.swing.JTextField jIDInterno;
    private javax.swing.JTextField jIDPesqLan;
    public static javax.swing.JTextField jIDlanc;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEvadido;
    public static javax.swing.JTextField jNomeInterno;
    public static javax.swing.JTextField jNrDocumento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jPesqNomeInterno;
    public static javax.swing.JTextField jProcedencia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    public static javax.swing.JTextField jStatusSaida;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    public static javax.swing.JTable jTabelaItensInterno;
    private javax.swing.JTable jTabelaSaidaInterno;
    private javax.swing.JTextArea jTextAreaObs;
    private javax.swing.JLabel jtotalRegistros;
    public static javax.swing.JLabel totalRegistrosInternos;
    // End of variables declaration//GEN-END:variables

    public void bloquearCamposPesquisa() {
        jIDlanc.setEnabled(!true);
        jStatusSaida.setEnabled(!true);
        jDataLancamento.setEnabled(!true);
        jDescricaoOp.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        //        
        jIDInterno.setEnabled(!true);
        jNomeInterno.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jDataRetorno.setEnabled(!true);
        jDestinoInterno.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
        //
        jBtPesqOperacao.setEnabled(!true);
        jBtPesInterno.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtItensAudiSaidaInternos.setEnabled(!true);
        //
        jIDInterno.setText("");
        jNomeInterno.setText("");
        FotoInternoCrcSaida.setIcon(null);
        jDataEntrada.setDate(null);
        jDataSaida.setDate(null);
        jHoraSaida.setText("");
        jDataRetorno.setEnabled(!true);
        jDestinoInterno.setText("");
        jNrDocumento.setText("");
    }

    public void formatarCampos() {
        jDestinoInterno.setDocument(new LimiteDigitosAlfa(32));
        jNrDocumento.setDocument(new LimiteDigitosAlfa(16));
    }

    public void corCampos() {
        jStatusSaida.setBackground(Color.white);
        jDataLancamento.setBackground(Color.white);
        // Limpar os campos para inclusão
        jIDlanc.setBackground(Color.white);
        jDescricaoOp.setBackground(Color.white);
        jTextAreaObs.setBackground(Color.white);
        //
        jIDInterno.setBackground(Color.white);
        jDataSaida.setBackground(Color.white);
        jHoraSaida.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jProcedencia.setBackground(Color.white);
        jDataEntrada.setBackground(Color.white);
        jDestinoInterno.setBackground(Color.white);
        jNrDocumento.setBackground(Color.white);
    }

    public void Novo() {
        totalRegistrosInternos.setText("");
        jStatusSaida.setText("ABERTO");
        jDataLancamento.setCalendar(Calendar.getInstance());
        // Limpar os campos para inclusão
        jIDlanc.setText("");
        jDescricaoOp.setText("");
        jTextAreaObs.setText("");
        // Habilitar campos para inclusãoi
        jDataLancamento.setEnabled(true);
        jTextAreaObs.setEnabled(true);
        jBtPesqOperacao.setEnabled(true);
        jBtNovolanc.setEnabled(!true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(true);
        jBtCancelarlanc.setEnabled(true);
        jBtAudiSaida.setEnabled(!true);
        // Limpar a tabela de itens
        limparTabelaItens();
        // Habilitar os campos para inclusão/alteração
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtPesInterno.setEnabled(!true);
        jBtBuscarAgenda.setEnabled(!true);
        jBtItensAudiSaidaInternos.setEnabled(!true);
        //
        jIDInterno.setText("");
        jNomeInterno.setText("");
        FotoInternoCrcSaida.setIcon(null);
        jDataSaida.setDate(null);
        jHoraSaida.setText("");
        jProcedencia.setText("");
        jDataEntrada.setDate(null);
        jDataRetorno.setDate(null);
        jDestinoInterno.setText("");
        jNrDocumento.setText("");
        //
        jDataSaida.setEnabled(!true);
        jDestinoInterno.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
    }

    public void Alterar() {

        jDataLancamento.setEnabled(true);
        jTextAreaObs.setEnabled(true);
        jBtPesqOperacao.setEnabled(true);
        jBtNovolanc.setEnabled(!true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(true);
        jBtCancelarlanc.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        // Habilitar os campos para inclusão/alteração
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtPesInterno.setEnabled(!true);
        jBtBuscarAgenda.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jDestinoInterno.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
    }

    public void Excluir() {

        // Limpar os campos para inclusão
        jDataLancamento.setDate(null);
        jIDlanc.setText("");
        jTextAreaObs.setText("");
        // Limpar a tabela de itens
        limparTabelaItens();
    }

    public void Salvar() {

        jDataLancamento.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(true);
        jBtExcluirlanc.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    public void Cancelar() {

        jDataLancamento.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusSaida = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se essa saída de internos for finalizado, você não poderá\nmais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZAR a saída selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objSaida.setStatusSaida(statusSaida);
            objSaida.setIdSaida(Integer.valueOf(jIDlanc.getText()));
            control.finalizarSaidaInternos(objSaida);
            jStatusSaida.setText(statusMov);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            jStatusSaida.setText(statusSaida);
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            jBtPesqOperacao.setEnabled(!true);
            jDataEntrada.setEnabled(!true);
            jTextAreaObs.setEnabled(!true);
            jBtNovolanc.setEnabled(true);
            jBtAlterarlanc.setEnabled(!true);
            jBtExcluirlanc.setEnabled(!true);
            jBtSalvarlanc.setEnabled(!true);
            jBtCancelarlanc.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtNovoItem.setEnabled(!true);
        }
    }

    public void NovoItem() {
        jDataSaida.setCalendar(Calendar.getInstance());
        jHoraSaida.setText("");
        jIDInterno.setText("");
        jNomeInterno.setText("");
        FotoInternoCrcSaida.setIcon(null);
        jDestinoInterno.setText(jDescricaoOp.getText());
        jNrDocumento.setText("");
        jProcedencia.setText("");
        jDataEntrada.setDate(null);
        // Habilitar os campos para inclusão/alteração
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        jBtPesInterno.setEnabled(true);
        jBtBuscarAgenda.setEnabled(true);
        jDataSaida.setEnabled(true);
        jDestinoInterno.setEnabled(!true);
        jNrDocumento.setEnabled(true);
        jTabelaItensInterno.setVisible(true);
        jTabelaItensInterno.setEnabled(true);
        //    
        totalRegistrosInternos.setText("");  // Limpar campo do contador 
        count = 0; // Zerar o contador
        jDataLancamento.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        //
        jBtNovolanc.setEnabled(!true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtBuscarPrevisao.setEnabled(true);
    }

    public void AlterarItem() {

        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        jBtPesInterno.setEnabled(true);
        jBtBuscarAgenda.setEnabled(true);
        jDataSaida.setEnabled(true);
        //  jDataRetorno.setEnabled(true);
        jDestinoInterno.setEnabled(!true);
        jNrDocumento.setEnabled(true);
        //
        jDataLancamento.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        //
        jBtNovolanc.setEnabled(!true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
    }

    public void ExcluirItem() {

        jIDInterno.setText("");
        jNomeInterno.setText("");
        FotoInternoCrcSaida.setIcon(null);
        jDataSaida.setDate(null);
        jHoraSaida.setText("");
        jDataRetorno.setDate(null);
        jProcedencia.setText("");
        jDataEntrada.setDate(null);
        jDestinoInterno.setText("");
        jNrDocumento.setText("");
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtPesInterno.setEnabled(!true);
        jBtBuscarAgenda.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jDataRetorno.setEnabled(!true);
        jDestinoInterno.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
        //       
        jDataLancamento.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        //
        jBtNovolanc.setEnabled(!true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
    }

    public void SalvarItem() {
        //
        jIDInterno.setText("");
        FotoInternoCrcSaida.setIcon(null);
        jNomeInterno.setText("");
        jDataSaida.setDate(null);
        jHoraSaida.setText("");
        jDataRetorno.setDate(null);
        jProcedencia.setText("");
        jDataEntrada.setDate(null);
        jDestinoInterno.setText("");
        jNrDocumento.setText("");
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtPesInterno.setEnabled(!true);
        jBtBuscarAgenda.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jDataRetorno.setEnabled(!true);
        jDestinoInterno.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
        //       
        jDataLancamento.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        //
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(true);
        jBtExcluirlanc.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jTabelaItensInterno.setVisible(true);
    }

    public void CancelarItem() {

        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(true);
        jBtExcluirItem.setEnabled(true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtPesInterno.setEnabled(!true);
        jBtBuscarAgenda.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jDataRetorno.setEnabled(!true);
        jDestinoInterno.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
        //       
        jDataLancamento.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        //
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(true);
        jBtExcluirlanc.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    //Buscar código de Saída
    public void buscarCodSaida() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SAIDACRC");
            conecta.rs.last();
            codSai = conecta.rs.getInt("IdSaida");
            jIDlanc.setText(conecta.rs.getString("IdSaida"));
            objSaida.setIdSaida(Integer.valueOf(jIDlanc.getText()));
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar LANÇAMENTO DE SAIDA \nERRO: " + ex);
        }
    }

    public void buscarItemInternoAgenda() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSAGENDA WHERE IdInternoCrc='" + jIDInterno.getText() + "'AND OficioAgenda='" + jNrDocumento.getText() + "'");
            conecta.rs.first();
            codItemAgenda = conecta.rs.getInt("IdItem");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarItemInternoAgenda1() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSAGENDA "
                    + "WHERE IdInternoCrc='" + codInternoAnt + "' "
                    + "AND OficioAgenda='" + jNrDocumento.getText() + "'");
            conecta.rs.first();
            codItemAgenda = conecta.rs.getInt("IdItem");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void modificarAgendaEscolta() {
        utilizaAgenda = "Sim";
        // MODIFICAR A AGENDA DO INTERNO (ESCOLTA/MÉDICO) 
        objItensAgenda.setUtilizaAgenda(utilizaAgenda);
        objItensAgenda.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
        objItensAgenda.setIdItem(codItemAgenda);
        controleAgenda.modificarAgendaInterno(objItensAgenda);
    }

    public void modificarAgendaEscolta1() {
        utilizaAgenda = "Não";
        // MODIFICAR A AGENDA DO INTERNO (ESCOLTA/MÉDICO) 
        objItensAgenda.setUtilizaAgenda(utilizaAgenda);
        objItensAgenda.setIdInternoCrc(Integer.valueOf(codInternoAnt));
        objItensAgenda.setIdItem(codItemAgenda);
        controleAgenda.modificarAgendaInterno(objItensAgenda);
    }

    public void preencherTodasEntradas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1; // Contador de registros
                // Formatar a data no formato Brasil
                dataLancaMov = conecta.rs.getString("DataLancaMov");
                String dia = dataLancaMov.substring(8, 10);
                String mes = dataLancaMov.substring(5, 7);
                String ano = dataLancaMov.substring(0, 4);
                dataLancaMov = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdSaida"), dataLancaMov, conecta.rs.getString("StatusSai"), conecta.rs.getString("TipoOp"), conecta.rs.getString("DescricaoOp"), conecta.rs.getString("ObsSaida")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaSaidaInterno.setModel(modelo);
        jTabelaSaidaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaSaidaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaSaidaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaSaidaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaSaidaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTabelaSaidaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(5).setPreferredWidth(380);
        jTabelaSaidaInterno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaSaidaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaSaidaInterno.setAutoResizeMode(jTabelaSaidaInterno.AUTO_RESIZE_OFF);
        jTabelaSaidaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void pesquisarSaidaInterno(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Codigo", "Data", "Status", "Operação", "Descrição", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1; // Contador de registros
                // Formatar a data no formato Brasil
                dataBrasil = conecta.rs.getString("DataLancaMov");
                String dia = dataBrasil.substring(8, 10);
                String mes = dataBrasil.substring(5, 7);
                String ano = dataBrasil.substring(0, 4);
                dataBrasil = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdSaida"), dataBrasil, conecta.rs.getString("StatusSai"), conecta.rs.getString("TipoOp"), conecta.rs.getString("DescricaoOp"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaSaidaInterno.setModel(modelo);
        jTabelaSaidaInterno.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTabelaSaidaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaSaidaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaSaidaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaSaidaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTabelaSaidaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(5).setPreferredWidth(280);
        jTabelaSaidaInterno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaSaidaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaSaidaInterno.setAutoResizeMode(jTabelaSaidaInterno.AUTO_RESIZE_OFF);
        jTabelaSaidaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaSaidaInterno.setModel(modelo);
        jTabelaSaidaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaSaidaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaSaidaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaSaidaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaSaidaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTabelaSaidaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(5).setPreferredWidth(280);
        jTabelaSaidaInterno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaSaidaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaSaidaInterno.setAutoResizeMode(jTabelaSaidaInterno.AUTO_RESIZE_OFF);
        jTabelaSaidaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaSaidaInterno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaSaidaInterno.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaSaidaInterno.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void pesquisarLancCod(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1; // Contador de registros
                // Formatar a data no formato Brasil
                dataLancaMov = conecta.rs.getString("DataLancaMov");
                String dia = dataLancaMov.substring(8, 10);
                String mes = dataLancaMov.substring(5, 7);
                String ano = dataLancaMov.substring(0, 4);
                dataLancaMov = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdSaida"), dataLancaMov, conecta.rs.getString("StatusSai"), conecta.rs.getString("TipoOp"), conecta.rs.getString("DescricaoOp"), conecta.rs.getString("ObsSaida")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaSaidaInterno.setModel(modelo);
        jTabelaSaidaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaSaidaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaSaidaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaSaidaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaSaidaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTabelaSaidaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(5).setPreferredWidth(380);
        jTabelaSaidaInterno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaSaidaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaSaidaInterno.setAutoResizeMode(jTabelaSaidaInterno.AUTO_RESIZE_OFF);
        jTabelaSaidaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }

    // Verificar se existe itens na saida do interno
    public void verificarItens() {
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSSAIDA WHERE IdSaida='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            codSaida = conecta.rs.getString("IdSaida");
            if (jIDlanc.getText().equals(codSaida)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os internos relacionados a esse registro.");
            }
            conecta.desconecta();
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objSaida.setIdSaida(Integer.parseInt(jIDlanc.getText()));
                control.excluirSaidaInternos(objSaida);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel EXCLUIR Lançamento...\nERRO :" + ex);
            }
        }
    }

    public void preencherTabelaItens(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Seq.", "Nome do Interno", "Data Saida", "Destino", "Documento"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1; // Contador de registros
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
        alinharCamposTabelaItens();
        conecta.desconecta();
    }

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Seq.", "Nome do Interno", "Data Saida", "Destino", "Documento"};
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
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaItens() {
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

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIDlanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIDlanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarIdItem() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSSAIDA ");
            conecta.rs.last();
            codItem = conecta.rs.getInt("IdItem");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do item.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    // Verifica se a resposta para inclusão no historico foi "sim"
    public void verificaSaidaAudiencia() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MOVIMENTOCRC "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "' "
                    + "AND IdDoc='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            idInternoAudiencia = conecta.rs.getString("IdInternoCrc");
        } catch (SQLException ex) {
        }
        if (jIDInterno.getText().equals(idInternoAudiencia)) {
            objProCrc.setIdInterno(Integer.parseInt(jIDInterno.getText()));
            objItemSaida.setIdSaida((Integer.valueOf(jIDlanc.getText())));
            controlMov.alterarMovSaida(objItemSaida);
            objLog2();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
        } else {
            //Inserir na tabela de movimentação (SAIDA) 
            objProCrc.setIdInterno(Integer.parseInt(jIDInterno.getText()));
            objItemSaida.setIdSaida((Integer.valueOf(jIDlanc.getText())));
            controlMov.incluirMovSaida(objItemSaida);
            objLog2();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
        }
    }

    public void objDadosSaidaRetornoInterno() {
        objMovSaiRetornoEva.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
        objMovSaiRetornoEva.setIdSaida(Integer.valueOf(jIDlanc.getText()));
        objMovSaiRetornoEva.setNrDocSaida(jNrDocumento.getText());
        objMovSaiRetornoEva.setDataSaida(jDataSaida.getDate());
        objMovSaiRetornoEva.setDataPrevRetorno(jDataRetorno.getDate());
        objMovSaiRetornoEva.setNrDocRetorno(nrDocumentoRetorno);
        objMovSaiRetornoEva.setDataEvasao(evadido);
    }

    // Verificar se o interno já passou na portaria e foi registrado.
    public void verificarSaidaPortaria() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSSAIDA "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "' "
                    + "AND DestinoSaida='" + jDestinoInterno.getText() + "' "
                    + "AND IdSaida='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            idInternoTrans = conecta.rs.getString("IdInternoCrc");
            confirmacaoSaida = conecta.rs.getString("SaidaConfirmada");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    // Verificar interno a tabela ITENSPREVISAOSAIDA para ser excluido da Tabela ITENSSAIDA e atualizar como não utilizado na tabela ITENSPREVSAIDA
    public void verificarUtilizacaoPrevisaoSaida() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSPREVISAOSAIDA "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "' "
                    + "AND UtilizadoSaida='" + utilizadoSaida + "' "
                    + "AND Beneficio='" + jDestinoInterno.getText() + "'");
            conecta.rs.first();
            idInternoTrans = conecta.rs.getString("IdInternoCrc");
            utilizacaoPrevSaida = conecta.rs.getString("UtilizadoSaida");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserCRC = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserCRC + "'");
            conecta.rs.first();
            codigoUserGroupCRC = conecta.rs.getInt("IdUsuario");
            codigoGrupoCRC = conecta.rs.getInt("IdGrupo");
            nomeGrupoCRC = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserCRC + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoCRC = conecta.rs.getInt("IdUsuario");
            codAbrirCRC = conecta.rs.getInt("Abrir");
            codIncluirCRC = conecta.rs.getInt("Incluir");
            codAlterarCRC = conecta.rs.getInt("Alterar");
            codExcluirCRC = conecta.rs.getInt("Excluir");
            codGravarCRC = conecta.rs.getInt("Gravar");
            codConsultarCRC = conecta.rs.getInt("Consultar");
            nomeTelaCRC = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
