/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleItensRetornoInterno;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovInternos;
import gestor.Controle.ControleMovRetornoEvasao;
import gestor.Controle.ControleRetornoInternos;
import gestor.Controle.ControleRetornoPortariaCrc;
import gestor.Controle.ControleRolVisitas;
import gestor.Controle.ControleSituacao;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.ModeloTabela;
import gestor.Modelo.ItensMovSaidaRetorno;
import gestor.Modelo.ItensRetornoInterno;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProntuarioCrc;
import gestor.Modelo.RetornoInternos;
import gestor.Modelo.RetornoPortariaCrc;
import gestor.Modelo.RolVisitas;
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
import static gestor.Visao.TelaModuloCRC.telaRetornoTmpInteCrc;
import static gestor.Visao.TelaModuloCRC.telaRetornoTmpManuCrc;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaPesqRegistroInternoPortaria.idItemRetornoSaidaTmp;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author user
 */
public class TelaRetornoInterno extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RetornoInternos objRetorno = new RetornoInternos();
    ItensRetornoInterno objItensRetorno = new ItensRetornoInterno();
    ControleRetornoInternos control = new ControleRetornoInternos();
    ControleMovInternos controlMov = new ControleMovInternos();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    ControleSituacao mod = new ControleSituacao();
    ControleItensRetornoInterno controle = new ControleItensRetornoInterno();
    ControleMovRetornoEvasao controleMovRetEva = new ControleMovRetornoEvasao();
    ItensMovSaidaRetorno objMovSaiRetornoEva = new ItensMovSaidaRetorno();
    //
    ControleRolVisitas controlRol = new ControleRolVisitas(); // Classe do Serviço social para ABRIR Rol quando interno retornar da unidade
    RolVisitas objRol = new RolVisitas();
    //  
    RetornoPortariaCrc objRetPortCrc = new RetornoPortariaCrc();
    ControleRetornoPortariaCrc controleRepostaCrc = new ControleRetornoPortariaCrc();
    // 
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "CRC:Movimentação:Retorno de Internos:Manutenção";
    String nomeModuloTela2 = "CRC:Movimentação:Retorno de Internos:Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    String statusRol = "ABERTO"; // Se o Rol estiver FINALIZADO, irá ser ABERTO para ser mostrado na lista do Rol na portaria
    String statusRolFechado = "FINALIZADO"; // Se o Rol estiver fechado e o usuário excluir, o Rol volta a ser ABERTO
    int idInternoRol; // Código do interno no Rol de Visitas.
    int flag;
    int acao;
    int codRet;
    int codItem = 0;
    String tipo = "Retornos";
    String situacao = "RETORNO A UNIDADE"; // Máximo 19 caracteres
    String dataBrasil;
    String dataRetorno;
    String codRetorno;
    public static String idItem;
    String nrDoc;
    String dataInicial;
    String dataFinal;
    String statusRetorno = "ABERTO";
    String opReposta = "Sim";
    String caminho;
    String confirmaRetorno;
    String confirmaExclusaoRetorno;
    int idRegistro; // Variável que impede o item de alterar quando importado do registro da portaria
    String codParametrosRetorno;
    int count = 0;
    // VARIAVEIS PARA AVISO DE RETORNO DO INTERNO
    String confirmacaoCrc = "Não";
    String respostaCrc = "Sim";

    /**
     * Creates new form TelaRetornoInterno
     */
    public TelaRetornoInterno() {
        initComponents();
        corCampos();
        formatarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jIDPesqLan = new javax.swing.JTextField();
        jBtDataLanc = new javax.swing.JButton();
        jBtIdLanc = new javax.swing.JButton();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jPesqNomeInterno = new javax.swing.JTextField();
        jBtNomeInterno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaRetorno = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jIDLanc = new javax.swing.JTextField();
        jBtPesqOperacao = new javax.swing.JButton();
        jDataLancamento = new com.toedter.calendar.JDateChooser();
        jDescricaoOpe = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jStatusRetorno = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jBtNovolanc = new javax.swing.JButton();
        jBtAlterarlanc = new javax.swing.JButton();
        jBtExcluirlanc = new javax.swing.JButton();
        jBtSalvarlanc = new javax.swing.JButton();
        jBtCancelarlanc = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtAudRetorno = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaObs = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jIdInterno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jDataRetorno = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jBtPesqInterno = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jOrigemOperacao = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jNrDocumento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jHorarioRetorno = new javax.swing.JFormattedTextField();
        jBtPesqInternoPortaria = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTabelaItensInterno = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jBtNovoItem = new javax.swing.JButton();
        jBtAlterarItem = new javax.swing.JButton();
        jBtExcluirItem = new javax.swing.JButton();
        jBtSalvarItem = new javax.swing.JButton();
        jBtCancelarItem = new javax.swing.JButton();
        jBtSairItens = new javax.swing.JButton();
        jBtAudRetInternos = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jFotoInternoRetorno = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        jTextField1.setText("jTextField1");

        setClosable(true);
        setIconifiable(true);
        setTitle("...:::: Retorno de Internos  Saida Temporária CRC :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa Lançamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Código:");

        jIDPesqLan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDPesqLan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIDPesqLanActionPerformed(evt);
            }
        });

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
        jLabel24.setText("Data  Final:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Data Inicial:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Nome do Interno:");

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
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addGap(192, 192, 192))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtIdLanc)
                    .addComponent(jLabel25)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtDataLanc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jBtNomeInterno)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaRetorno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaRetorno.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTabelaRetorno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"
            }
        ));
        jTabelaRetorno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaRetornoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaRetorno);
        if (jTabelaRetorno.getColumnModel().getColumnCount() > 0) {
            jTabelaRetorno.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaRetorno.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaRetorno.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaRetorno.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaRetorno.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaRetorno.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaRetorno.getColumnModel().getColumn(3).setMinWidth(120);
            jTabelaRetorno.getColumnModel().getColumn(3).setMaxWidth(120);
            jTabelaRetorno.getColumnModel().getColumn(4).setMinWidth(180);
            jTabelaRetorno.getColumnModel().getColumn(4).setMaxWidth(180);
            jTabelaRetorno.getColumnModel().getColumn(5).setMinWidth(280);
            jTabelaRetorno.getColumnModel().getColumn(5).setMaxWidth(280);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cabeçalho do Documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Código");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Data:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Operação:");

        jIDLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDLanc.setEnabled(false);

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

        jDescricaoOpe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoOpe.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Status:");

        jStatusRetorno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusRetorno.setForeground(new java.awt.Color(255, 0, 0));
        jStatusRetorno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusRetorno.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIDLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jStatusRetorno, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(jDescricaoOpe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jIDLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jDescricaoOpe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqOperacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jStatusRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

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

        jBtAudRetorno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAudRetorno.setForeground(new java.awt.Color(51, 51, 255));
        jBtAudRetorno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAudRetorno.setToolTipText("Auditoria");
        jBtAudRetorno.setContentAreaFilled(false);
        jBtAudRetorno.setEnabled(false);
        jBtAudRetorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAudRetornoActionPerformed(evt);
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
                .addComponent(jBtCancelarlanc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAudRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtAudRetorno)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtNovolanc)
                        .addComponent(jBtAlterarlanc)
                        .addComponent(jBtExcluirlanc)
                        .addComponent(jBtSalvarlanc)
                        .addComponent(jBtCancelarlanc)
                        .addComponent(jBtFinalizar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarlanc, jBtAudRetorno, jBtCancelarlanc, jBtExcluirlanc, jBtFinalizar, jBtNovolanc, jBtSalvarlanc});

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jTextAreaObs.setColumns(20);
        jTextAreaObs.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextAreaObs.setRows(5);
        jTextAreaObs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextAreaObs.setEnabled(false);
        jScrollPane2.setViewportView(jTextAreaObs);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Código");

        jIdInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInterno.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Data");

        jDataRetorno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRetorno.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Nome Completo do Interno");

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);

        jBtPesqInterno.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jBtPesqInterno.setForeground(new java.awt.Color(0, 0, 255));
        jBtPesqInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInterno.setToolTipText("Pesquisar  Prontuário de  Internos");
        jBtPesqInterno.setContentAreaFilled(false);
        jBtPesqInterno.setEnabled(false);
        jBtPesqInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Tipo de Operação");

        jOrigemOperacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOrigemOperacao.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Documento");

        jNrDocumento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNrDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNrDocumento.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Horário");

        jHorarioRetorno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioRetorno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioRetorno.setEnabled(false);

        jBtPesqInternoPortaria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtPesqInternoPortaria.setForeground(new java.awt.Color(0, 153, 0));
        jBtPesqInternoPortaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInternoPortaria.setText("Buscar");
        jBtPesqInternoPortaria.setToolTipText("Pesquisar Registro de Interno na Portaria");
        jBtPesqInternoPortaria.setEnabled(false);
        jBtPesqInternoPortaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoPortariaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jHorarioRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jNrDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqInternoPortaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jOrigemOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jNomeInterno))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jOrigemOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqInterno)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqInternoPortaria)
                    .addComponent(jNrDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaItensInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaItensInterno.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTabelaItensInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Seq.", "Nome do Interno", "Data Retorno", "Origem", "Documento"
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
            jTabelaItensInterno.getColumnModel().getColumn(1).setMinWidth(210);
            jTabelaItensInterno.getColumnModel().getColumn(1).setMaxWidth(210);
            jTabelaItensInterno.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaItensInterno.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaItensInterno.getColumnModel().getColumn(3).setMinWidth(200);
            jTabelaItensInterno.getColumnModel().getColumn(3).setMaxWidth(200);
            jTabelaItensInterno.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaItensInterno.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Botões", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

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

        jBtSairItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairItens.setText("Sair");
        jBtSairItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairItensActionPerformed(evt);
            }
        });

        jBtAudRetInternos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAudRetInternos.setForeground(new java.awt.Color(255, 0, 0));
        jBtAudRetInternos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAudRetInternos.setToolTipText("Auditoria");
        jBtAudRetInternos.setContentAreaFilled(false);
        jBtAudRetInternos.setEnabled(false);
        jBtAudRetInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAudRetInternosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBtExcluirItem)
                        .addComponent(jBtNovoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtAlterarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtSairItens, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSalvarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtCancelarItem)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jBtAudRetInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarItem, jBtCancelarItem, jBtExcluirItem, jBtNovoItem, jBtSairItens, jBtSalvarItem});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jBtNovoItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtCancelarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jBtSalvarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jBtAudRetInternos)
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarItem, jBtAudRetInternos, jBtCancelarItem, jBtExcluirItem, jBtNovoItem, jBtSairItens, jBtSalvarItem});

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 0, 102))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoRetorno, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoRetorno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 15, 730, 534);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtDataLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDataLancActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
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
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesFinal.getDate().getTime());
                        jTabelaRetorno.setVisible(true);
                        pesquisarLancCod("SELECT * FROM RETORNOSCRC "
                                + "INNER JOIN OPERACAO "
                                + "ON RETORNOSCRC.IdOp = OPERACAO.IdOp "
                                + "WHERE DataLancRetorno BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
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
                        jTabelaRetorno.setVisible(true);
                        pesquisarLancCod("SELECT * FROM RETORNOSCRC "
                                + "INNER JOIN OPERACAO "
                                + "ON RETORNOSCRC.IdOp = OPERACAO.IdOp "
                                + "WHERE DataLancRetorno BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtDataLancActionPerformed

    private void jBtIdLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIdLancActionPerformed
        // TODO add your handling code here:
        // Pesquisa por data de lançamento
        jTabelaRetorno.setVisible(true);
        pesquisarLancCod("SELECT * FROM RETORNOSCRC "
                + "INNER JOIN OPERACAO "
                + "ON RETORNOSCRC.IdOp = OPERACAO.IdOp WHERE IdRetorno='" + jIDPesqLan.getText() + "'");
    }//GEN-LAST:event_jBtIdLancActionPerformed

    private void jTabelaRetornoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaRetornoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaRetorno.getValueAt(jTabelaRetorno.getSelectedRow(), 0);
            jIDPesqLan.setText(IdLanc);
            jDataLancamento.setDate(jDataLancamento.getDate());
            jBtNovolanc.setEnabled(!true);
            jBtAlterarlanc.setEnabled(true);
            jBtExcluirlanc.setEnabled(true);
            jBtSalvarlanc.setEnabled(!true);
            jBtCancelarlanc.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAudRetorno.setEnabled(true);
            jBtNovoItem.setEnabled(true);
            //
            jDataRetorno.setDate(null);
            jIdInterno.setText("");
            jNomeInterno.setText("");
            jFotoInternoRetorno.setIcon(null);
            jOrigemOperacao.setText("");
            jNrDocumento.setText("");
            jHorarioRetorno.setText("");
            jDataRetorno.setDate(null);
            bloquearCamposPesquisa();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM RETORNOSCRC "
                        + "INNER JOIN OPERACAO "
                        + "ON RETORNOSCRC.IdOp=OPERACAO.IdOp "
                        + "WHERE IdRetorno ='" + IdLanc + "'");
                conecta.rs.first();
                jIDLanc.setText(String.valueOf(conecta.rs.getInt("IdRetorno")));
                jStatusRetorno.setText(conecta.rs.getString("StatusRet"));
                jDataLancamento.setDate(conecta.rs.getDate("DataLancRetorno"));
                jDescricaoOpe.setText(conecta.rs.getString("DescricaoOp"));
                jTextAreaObs.setText(conecta.rs.getString("ObsRetorno"));
                conecta.desconecta();
                preencherTabelaItens("SELECT * FROM ITENSRETORNO "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSRETORNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdRetorno='" + IdLanc + "'");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por DATA " + e);
            }
        }
    }//GEN-LAST:event_jTabelaRetornoMouseClicked

    private void jBtPesqOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqOperacaoActionPerformed
        // TODO add your handling code here:
        TelaPesquisaOpRetorno objOpRetorno = new TelaPesquisaOpRetorno();
        TelaModuloCRC.jPainelCRC.add(objOpRetorno);
        objOpRetorno.show();
    }//GEN-LAST:event_jBtPesqOperacaoActionPerformed

    private void jBtNovolancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovolancActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRetornoTmpManuCrc);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaRetornoTmpManuCrc) && codIncluirCRC == 1) {
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
        buscarAcessoUsuario(telaRetornoTmpManuCrc);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaRetornoTmpManuCrc) && codAlterarCRC == 1) {
            objRetorno.setStatusRetorno(jStatusRetorno.getText());
            if (jStatusRetorno.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa retorno de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
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
        buscarAcessoUsuario(telaRetornoTmpManuCrc);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaRetornoTmpManuCrc) && codExcluirCRC == 1) {
            objRetorno.setStatusRetorno(jStatusRetorno.getText());
            if (jStatusRetorno.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                verificarItens();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirlancActionPerformed

    private void jBtSalvarlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarlancActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRetornoTmpManuCrc);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaRetornoTmpManuCrc) && codGravarCRC == 1) {
            if (jDescricaoOpe.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a descrição da operação de retorno");
                jDescricaoOpe.requestFocus();
            } else {
                if (jDataLancamento.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe da data de lançamento");
                    jDataLancamento.requestFocus();
                } else {
                    objRetorno.setDateLancamento(jDataLancamento.getDate());
                    objRetorno.setStatusRetorno(statusRetorno);
                    objRetorno.setNomeOperacao(jDescricaoOpe.getText());
                    objRetorno.setObsRetorno(jTextAreaObs.getText());
                    objRetorno.setNomeUsuario(nameUser);
                    objRetorno.setDataInsert(jDataSistema.getText());
                    objRetorno.setHoraInsert(jHoraSistema.getText());
                    try {
                        if (acao == 1) {
                            control.incluirRetornoInternos(objRetorno);
                            buscarCodRet();
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            JOptionPane.showMessageDialog(rootPane, "Registro INCLUIDO com sucesso, será necessário\nincluir os internos\npara que possa ser registrado a movimentação.");
                            Salvar();
                        }
                        if (acao == 2) {
                            objRetorno.setNomeUsuario(nameUser);
                            objRetorno.setDataUpdate(jDataSistema.getText());
                            objRetorno.setHoraUp(jHoraSistema.getText());
                            objRetorno.setIdRetorno(Integer.parseInt(jIDLanc.getText()));
                            control.alterarRetornoInternos(objRetorno);
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            JOptionPane.showMessageDialog(rootPane, "Registro ALTERADO com sucesso. Se necessário\n faça aleração dos internos");
                            Salvar();
                        }
                        preencherTabelaItens("SELECT * FROM ITENSRETORNO INNER JOIN PRONTUARIOSCRC ON ITENSRETORNO.IdInternoCrc = PRONTUARIOSCRC.IdInternoCrc  WHERE IdRetorno='" + jIDLanc.getText() + "'");
                    } catch (HeadlessException e) {
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível GRAVAR registro !!!\n" + e);
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

    private void jTabelaItensInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaItensInternoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeInterno = "" + jTabelaItensInterno.getValueAt(jTabelaItensInterno.getSelectedRow(), 1);
            jNomeInterno.setText(nomeInterno);
            idItem = "" + jTabelaItensInterno.getValueAt(jTabelaItensInterno.getSelectedRow(), 0);
            nrDoc = "" + jTabelaItensInterno.getValueAt(jTabelaItensInterno.getSelectedRow(), 4);
            jNrDocumento.setText(nrDoc);
            // Habilitar os botões
            jBtNovoItem.setEnabled(!true);
            jBtAlterarItem.setEnabled(true);
            jBtExcluirItem.setEnabled(true);
            jBtSalvarItem.setEnabled(!true);
            jBtCancelarItem.setEnabled(true);
            jBtAudRetInternos.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                        + "INNER JOIN ITENSRETORNO "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSRETORNO.IdInternoCrc "
                        + "WHERE NomeInternoCrc='" + jNomeInterno.getText() + "'AND IdRetorno='" + jIDLanc.getText() + "'AND DocumentoRetorno='" + nrDoc + "'AND IdItem='" + idItem + "'");
                conecta.rs.first();
                jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                idItem = conecta.rs.getString("IdItem");
                jDataRetorno.setDate(conecta.rs.getDate("DataRetorno"));
                jOrigemOperacao.setText(conecta.rs.getString("OrigemRetorno"));
                jNrDocumento.setText(conecta.rs.getString("DocumentoRetorno"));
                jHorarioRetorno.setText(conecta.rs.getString("HorarioRetorno"));
                idRegistro = conecta.rs.getInt("IdRegistro");
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoRetorno.setIcon(i);
                jFotoInternoRetorno.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoRetorno.getWidth(), jFotoInternoRetorno.getHeight(), Image.SCALE_DEFAULT)));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
        }
    }//GEN-LAST:event_jTabelaItensInternoMouseClicked

    private void jBtNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRetornoTmpInteCrc);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaRetornoTmpInteCrc) && codIncluirCRC == 1) {
            objRetorno.setStatusRetorno(jStatusRetorno.getText());
            if (jStatusRetorno.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse retorno de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                verificarParamentrosCrc();
                acao = 3;
                NovoItem();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoItemActionPerformed

    private void jBtAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRetornoTmpInteCrc);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaRetornoTmpInteCrc) && codAlterarCRC == 1) {
            objRetorno.setStatusRetorno(jStatusRetorno.getText());
            if (jStatusRetorno.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse retorno de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                if (idRegistro != 0) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo tem origem da portaria.\nPor medidas de segurança, você poderá exclui-lo e lançar novamente caso deseje.");
                } else {
                    verificarParamentrosCrc();
                    acao = 4;
                    flag = 1;
                    AlterarItem();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarItemActionPerformed

    private void jBtExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRetornoTmpInteCrc);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaRetornoTmpInteCrc) && codExcluirCRC == 1) {
            confirmacaoCrc = "Sim";
            respostaCrc = "Não";
            confirmaExclusaoRetorno = "Não"; // Exclusão passa a ser não para poder ser lançado novamente se necessário
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objRetorno.setStatusRetorno(jStatusRetorno.getText());
            if (jStatusRetorno.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse retorno de internos não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o INTERNO selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objItensRetorno.setIdItemRetorno(Integer.valueOf(idItem));
                    controle.excluirItensRetorno(objItensRetorno);
                    objItensRetorno.setIdRetorno(Integer.valueOf(jIDLanc.getText()));
                    controlMov.excluirMovRetorno(objItensRetorno);
                    // Modifica o registro do interno na tabela ITENSREGEISTRO caso o interno seja seja excluido do Retorno do CRC 
                    confirmaRetorno = "Não"; // Passa ser não para atualizar a tabela ITENSREGISTRO
                    objItensRetorno.setIdItemRetorno(idItemRetornoSaidaTmp); // Item da tabela ITENSREGISTRO - (PORTARIA)
                    objItensRetorno.setIdRegistro(idRegistro);
                    objItensRetorno.setConfirmaRetorno(confirmaExclusaoRetorno);
                    if (idItemRetornoSaidaTmp != 0 || idRegistro != 0) {
                        controle.alterarRegistroItensRetorno(objItensRetorno);
                    }
                    // Atualiza o Rol para FINALIZADO quando usuario exclui o interno
                    atualizarRolSaidaInternoExcluir();
                    // ATUALIZAR TABELA DE VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS COMO "Sim"
                    objRetPortCrc.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                    objRetPortCrc.setConfirmaCrc(confirmacaoCrc); // CONFIRMAÇÃO ESTÁ COM "Não"
                    objRetPortCrc.setRespostaCrc(respostaCrc); // RESPOSTA ESTÁ COMO "Sim"
                    controleRepostaCrc.alterarRespostaRetornoInterno(objRetPortCrc);
                    //
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação    
                    limparCamposBancoEvasao(); // Limpa as variaveis para passar para o banco em branco, ou seja limpar
                    controleMovRetEva.alterarMovRetornoEvasao(objMovSaiRetornoEva);
                    ExcluirItem();
                    preencherTabelaItens("SELECT * FROM ITENSRETORNO "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON ITENSRETORNO.IdInternoCrc = PRONTUARIOSCRC.IdInternoCrc "
                            + "WHERE IdRetorno='" + jIDLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirItemActionPerformed

    private void jBtSalvarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarItemActionPerformed
        // TODO add your handling code here
        buscarAcessoUsuario(telaRetornoTmpInteCrc);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaRetornoTmpInteCrc) && codGravarCRC == 1) {
            confirmaRetorno = "Sim";
            if (jNomeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome do interno não pode ser em branco\nfaça uma pesquisa para preencher nome do interno");
                jNomeInterno.requestFocus();
            } else {
                if (jOrigemOperacao.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe o nome da origem.");
                    jOrigemOperacao.requestFocus();
                } else {
                    if (jHorarioRetorno.getText().equals("")) {
                        JOptionPane.showMessageDialog(rootPane, "Informe o horário de retorno do interno.");
                        jHorarioRetorno.requestFocus();
                    } else {
                        objItensRetorno.setIdInternoCrc(Integer.parseInt(jIdInterno.getText()));
                        objItensRetorno.setNomeInterno(jNomeInterno.getText());
                        objItensRetorno.setDataRetorno(jDataRetorno.getDate());
                        objItensRetorno.setNomerOrigem(jDescricaoOpe.getText());
                        objItensRetorno.setDocumento(jNrDocumento.getText());
                        objItensRetorno.setHorarioRetorno(jHorarioRetorno.getText());
                        objItensRetorno.setUsuarioInsert(nameUser);
                        objItensRetorno.setDataInsert(jDataSistema.getText());
                        objItensRetorno.setHoraInsert(jHoraSistema.getText());
                        objProCrc.setSituacao(situacao);
                        try {
                            if (acao == 3) {
                                objItensRetorno.setIdRetorno((Integer.parseInt(jIDLanc.getText())));
                                objItensRetorno.setIdRegistro(idItemRetornoSaidaTmp); // Grava o iditem para impedir de alterar, informado ao usuário para excluir e lançar novamente
                                controle.incluirItensRetorno(objItensRetorno); // Gravar registro na tabela de itens
                                objProCrc.setIdInterno(Integer.parseInt(jIdInterno.getText()));
                                mod.alterarSituacaoInterno(objProCrc);
                                //
                                objItensRetorno.setIdRetorno((Integer.parseInt(jIDLanc.getText())));
                                buscarIdItem();
                                objItensRetorno.setIdItemRetorno(codItem);
                                controlMov.incluirMovRetorno(objItensRetorno);
                                //
                                objMovRetEvadidos();
                                controleMovRetEva.alterarMovRetornoEvasao(objMovSaiRetornoEva);
                                //
                                objItensRetorno.setIdItemRetorno(idItemRetornoSaidaTmp);
                                objItensRetorno.setConfirmaRetorno(confirmaRetorno);
                                controle.alterarRegistroItensRetorno(objItensRetorno);
                                //
                                objItensRetorno.setIdRetorno((Integer.parseInt(jIDLanc.getText())));
                                atualizarRolSaidaInterno();
                                // ATUALIZAR TABELA DE VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS COMO "Sim"
                                objRetPortCrc.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                                objRetPortCrc.setConfirmaCrc(confirmacaoCrc); // CONFIRMAÇÃO ESTÁ COM "Não"
                                objRetPortCrc.setRespostaCrc(respostaCrc); // RESPOSTA ESTÁ COMO "Sim"
                                controleRepostaCrc.alterarRespostaRetornoInterno(objRetPortCrc);
                                //
                                objLog2();
                                controlLog.incluirLogSistema(objLogSys);
                                preencherTabelaItens("SELECT * FROM ITENSRETORNO "
                                        + "INNER JOIN PRONTUARIOSCRC "
                                        + "ON ITENSRETORNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                        + "WHERE IdRetorno='" + jIDLanc.getText() + "'");
                                SalvarItem();
                                JOptionPane.showMessageDialog(rootPane, "Registro incluido com sucesso");
                            }
                            if (acao == 4) {
                                objItensRetorno.setUsuarioUp(nameUser);
                                objItensRetorno.setDataUp(jDataSistema.getText());
                                objItensRetorno.setHoraUp(jHoraSistema.getText());
                                objItensRetorno.setIdRetorno((Integer.parseInt(jIDLanc.getText())));
                                objProCrc.setIdInterno(Integer.parseInt(jIdInterno.getText()));
                                objItensRetorno.setIdItemRetorno(Integer.valueOf(idItem));
                                controle.alterarItensRetorno(objItensRetorno);
                                objProCrc.setIdInterno(Integer.parseInt(jIdInterno.getText()));
                                mod.alterarSituacaoInterno(objProCrc);
                                objItensRetorno.setIdRetorno((Integer.parseInt(jIDLanc.getText())));
                                controlMov.alterarMovRetorno(objItensRetorno);
                                objMovRetEvadidos();
                                controleMovRetEva.alterarMovRetornoEvasao(objMovSaiRetornoEva);
                                objLog2();
                                controlLog.incluirLogSistema(objLogSys);
                                preencherTabelaItens("SELECT * FROM ITENSRETORNO "
                                        + "INNER JOIN PRONTUARIOSCRC "
                                        + "ON ITENSRETORNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                        + "WHERE IdRetorno='" + jIDLanc.getText() + "'");
                                SalvarItem();
                                JOptionPane.showMessageDialog(rootPane, "Registro alterado com sucesso.");
                            }
                        } catch (HeadlessException e) {
                            JOptionPane.showMessageDialog(rootPane, "Não foi possível gravar o registro \nERRO :" + e);
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

    private void jBtPesqInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoActionPerformed
        // TODO add your handling code here:
        //Está sendo utilizada pela portaria e o CRC ate definir como será feito o retorno de internos com essa tela
        TelaPesquisaRetornoInterno objRetornoInt = new TelaPesquisaRetornoInterno();
        if (TelaModuloPortarias.jPainelPortarias != null) {
            TelaModuloPortarias.jPainelPortarias.add(objRetornoInt);
            objRetornoInt.show();
        } else {
            TelaModuloCRC.jPainelCRC.add(objRetornoInt); // Abrindo a tela no módulo do CRC
            objRetornoInt.show();
        }
    }//GEN-LAST:event_jBtPesqInternoActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM RETORNOSCRC WHERE IdRetorno='" + jIDLanc.getText() + "'");
            conecta.rs.first();
            jStatusRetorno.setText(conecta.rs.getString("StatusRet"));
            if (jStatusRetorno.getText().equals("FINALIZADO")) {
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
            this.preencherTodasEntradas();
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jIDPesqLanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIDPesqLanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIDPesqLanActionPerformed

    private void jBtNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário informar um nome ou parte do nome para pesquuisa.");
        } else {
            pesquisarRetornoInterno("SELECT * FROM RETORNOSCRC "
                    + "INNER JOIN ITENSRETORNO "
                    + "ON RETORNOSCRC.IdRetorno=ITENSRETORNO.IdRetorno "
                    + "INNER JOIN OPERACAO "
                    + "ON RETORNOSCRC.IdOp=OPERACAO.IdOp "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSRETORNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'" + jPesqNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtNomeInternoActionPerformed

    private void jBtAudRetornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAudRetornoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaRetornoInternos objAudiRetorno = new TelaAuditoriaRetornoInternos();
        TelaModuloCRC.jPainelCRC.add(objAudiRetorno);
        objAudiRetorno.show();
    }//GEN-LAST:event_jBtAudRetornoActionPerformed

    private void jBtAudRetInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAudRetInternosActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensRetorno objItensAudReto = new TelaAuditoriaItensRetorno();
        TelaModuloCRC.jPainelCRC.add(objItensAudReto);
        objItensAudReto.show();
    }//GEN-LAST:event_jBtAudRetInternosActionPerformed

    private void jBtPesqInternoPortariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoPortariaActionPerformed
        // TODO add your handling code here: 
        TelaPesqRegistroInternoPortaria objPesqRegInternoPortaria = new TelaPesqRegistroInternoPortaria();
        TelaModuloCRC.jPainelCRC.add(objPesqRegInternoPortaria);
        objPesqRegInternoPortaria.show();
    }//GEN-LAST:event_jBtPesqInternoPortariaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterarItem;
    private javax.swing.JButton jBtAlterarlanc;
    private javax.swing.JButton jBtAudRetInternos;
    private javax.swing.JButton jBtAudRetorno;
    private javax.swing.JButton jBtCancelarItem;
    private javax.swing.JButton jBtCancelarlanc;
    private javax.swing.JButton jBtDataLanc;
    private javax.swing.JButton jBtExcluirItem;
    private javax.swing.JButton jBtExcluirlanc;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtIdLanc;
    private javax.swing.JButton jBtNomeInterno;
    private javax.swing.JButton jBtNovoItem;
    private javax.swing.JButton jBtNovolanc;
    private javax.swing.JButton jBtPesqInterno;
    private javax.swing.JButton jBtPesqInternoPortaria;
    private javax.swing.JButton jBtPesqOperacao;
    private javax.swing.JButton jBtSairItens;
    private javax.swing.JButton jBtSalvarItem;
    private javax.swing.JButton jBtSalvarlanc;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDataLancamento;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static com.toedter.calendar.JDateChooser jDataRetorno;
    public static javax.swing.JTextField jDescricaoOpe;
    public static javax.swing.JLabel jFotoInternoRetorno;
    public static javax.swing.JFormattedTextField jHorarioRetorno;
    public static javax.swing.JTextField jIDLanc;
    private javax.swing.JTextField jIDPesqLan;
    public static javax.swing.JTextField jIdInterno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jNomeInterno;
    public static javax.swing.JTextField jNrDocumento;
    private javax.swing.JTextField jOrigemOperacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    public static javax.swing.JTextField jStatusRetorno;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaItensInterno;
    private javax.swing.JTable jTabelaRetorno;
    private javax.swing.JTextArea jTextAreaObs;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void bloquearCamposPesquisa() {
        jIDLanc.setEnabled(!true);
        jStatusRetorno.setEnabled(!true);
        jDataLancamento.setEnabled(!true);
        jDescricaoOpe.setEnabled(!true);
        jOrigemOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        jDataLancamento.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        //
        jDataRetorno.setEnabled(!true);
        jIdInterno.setEnabled(!true);
        jNomeInterno.setEnabled(!true);
        //
        jBtPesqOperacao.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
        jBtPesqInternoPortaria.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAudRetInternos.setEnabled(!true);
    }

    public void corCampos() {
        jIDLanc.setBackground(Color.white);
        jStatusRetorno.setBackground(Color.white);
        jDataLancamento.setBackground(Color.white);
        jDescricaoOpe.setBackground(Color.white);
        jTextAreaObs.setBackground(Color.white);
        jDataLancamento.setBackground(Color.white);
        jTextAreaObs.setBackground(Color.white);
        //
        jDataRetorno.setBackground(Color.white);
        jIdInterno.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jOrigemOperacao.setBackground(Color.white);
        jNrDocumento.setBackground(Color.white);
        jHorarioRetorno.setBackground(Color.white);
    }

    public void formatarCampos() {
        jOrigemOperacao.setDocument(new LimiteDigitosAlfa(32));
        jNrDocumento.setDocument(new LimiteDigitosAlfa(11));
        try {
            MaskFormatter telefone = new MaskFormatter("##:##:##");
            jHorarioRetorno.setFormatterFactory(new DefaultFormatterFactory(telefone));
        } catch (Exception e) {
        }
    }

    public void Novo() {
        if (jIDLanc.getText().equals("")) {
            // Limpar campos para inclusão
            jIDLanc.setText("");
            jStatusRetorno.setText("ABERTO");
            jDataLancamento.setCalendar(Calendar.getInstance());
            jDescricaoOpe.setText("");
            jTextAreaObs.setText("");
            jDataLancamento.setEnabled(true);
            jTextAreaObs.setEnabled(true);
            //
            jIdInterno.setText("");
            jNomeInterno.setText("");
            jFotoInternoRetorno.setIcon(null);
            jOrigemOperacao.setText("");
            jDataRetorno.setDate(null);
            jHorarioRetorno.setText("");
            jNrDocumento.setText("");
            limparTabelaItens();
        }
        // Limpar campos para inclusão
        jIDLanc.setText("");
        jStatusRetorno.setText("ABERTO");
        jDataLancamento.setCalendar(Calendar.getInstance());
        jDescricaoOpe.setText("");
        jTextAreaObs.setText("");
        jDataLancamento.setEnabled(true);
        jTextAreaObs.setEnabled(true);
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoRetorno.setIcon(null);
        jOrigemOperacao.setText("");
        jDataRetorno.setDate(null);
        jHorarioRetorno.setText("");
        jNrDocumento.setText("");
        // Habilitar/Desabilitar Campos para inclusão
        jBtPesqOperacao.setEnabled(true);
        jBtNovolanc.setEnabled(!true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(true);
        jBtCancelarlanc.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAudRetorno.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAudRetInternos.setEnabled(!true);
        limparTabelaItens();
    }

    public void Alterar() {

        jDataLancamento.setEnabled(true);
        jTextAreaObs.setEnabled(true);
        // Habilitar/Desabilitar Campos para inclusão
        jBtPesqOperacao.setEnabled(true);
        jBtNovolanc.setEnabled(!true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(true);
        jBtCancelarlanc.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
    }

    public void Excluir() {
        //Limpar campos
        jIDLanc.setText("");
        jDataLancamento.setDate(null);
        jDescricaoOpe.setText("");
        jTextAreaObs.setText("");
        jBtPesqOperacao.setEnabled(!true);
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
    }

    public void Salvar() {
        // Habilitar/Desabilitar Campos para inclusão
        jBtPesqOperacao.setEnabled(!true);
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(true);
        jBtExcluirlanc.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        //
        jDataLancamento.setEnabled(!true);
        jDescricaoOpe.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        jBtNovoItem.setEnabled(true);
    }

    public void Cancelar() {
        if (jIDLanc.getText().equals("")) {
            // Limpar campos para inclusão
            jIDLanc.setText("");
            jStatusRetorno.setText("ABERTO");
            jDataLancamento.setCalendar(Calendar.getInstance());
            jDescricaoOpe.setText("");
            jTextAreaObs.setText("");
            jDataLancamento.setEnabled(true);
            jTextAreaObs.setEnabled(true);
            //
            jBtFinalizar.setEnabled(!true);
            jBtAudRetorno.setEnabled(!true);
            //
            jIdInterno.setText("");
            jNomeInterno.setText("");
            jFotoInternoRetorno.setIcon(null);
            jOrigemOperacao.setText("");
            jDataRetorno.setDate(null);
            jHorarioRetorno.setText("");
            jNrDocumento.setText("");
            limparTabelaItens();
        }
        jDataLancamento.setEnabled(!true);
        jDescricaoOpe.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jTextAreaObs.setEnabled(!true);
        // Habilitar/Desabilitar Campos para inclusão
        jBtPesqOperacao.setEnabled(!true);
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        //
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusEntrada = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse retorno de internos for finalizado, você não poderá\nmais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZAR o AGENDAMENTO selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objRetorno.setStatusRetorno(statusEntrada);
            objRetorno.setIdRetorno(Integer.parseInt(jIDLanc.getText()));
            control.finalizarRetornoInternos(objRetorno);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            jStatusRetorno.setText(statusEntrada);
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            jDataLancamento.setEnabled(!true);
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

        if (codParametrosRetorno.equals("Sim")) {
            jBtPesqInternoPortaria.setEnabled(true); // Pesquisar registro da portaria
            jBtPesqInterno.setEnabled(!true); // Nega pesquisa do prontuario do CRC/TRIAGEM
        } else {
            jBtPesqInterno.setEnabled(true); // Habilita a pesquisa do prontuario do CRC/TRIAGEM
            jBtPesqInternoPortaria.setEnabled(!true); // O parametro da entrada esta como "Não", desabilitar pesquisa na portaria
        }
        // Limpar os campos para inclusão
        jDataRetorno.setDate(null);
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoRetorno.setIcon(null);
        jOrigemOperacao.setText(jDescricaoOpe.getText());
        jNrDocumento.setText("");
        jHorarioRetorno.setText(jHoraSistema.getText());
        jDataRetorno.setCalendar(Calendar.getInstance());
        jDataRetorno.setEnabled(true);
        jOrigemOperacao.setEnabled(!true);
        jNrDocumento.setEnabled(true);
        jHorarioRetorno.setEnabled(true);
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
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

    public void AlterarItem() {
        if (codParametrosRetorno.equals("Sim")) {
            jBtPesqInternoPortaria.setEnabled(true); // Pesquisar registro da portaria
            jBtPesqInterno.setEnabled(!true); // Nega pesquisa do prontuario do CRC/TRIAGEM
        } else {
            jBtPesqInterno.setEnabled(true); // Habilita a pesquisa do prontuario do CRC/TRIAGEM
            jBtPesqInternoPortaria.setEnabled(!true); // O parametro da entrada esta como "Não", desabilitar pesquisa na portaria
        }
        //Habilitar os campos       
        jDataRetorno.setEnabled(true);
        jOrigemOperacao.setEnabled(!true);
        jNrDocumento.setEnabled(true);
        jHorarioRetorno.setEnabled(true);
        // Habilitar os botões
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
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

        // Limpar os campos para inclusão
        jDataRetorno.setDate(null);
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoRetorno.setIcon(null);
        jOrigemOperacao.setText("");
        jNrDocumento.setText("");
        jHorarioRetorno.setText("");
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtPesqInternoPortaria.setEnabled(!true);
    }

    public void SalvarItem() {
        // Limpar os campos para inclusão
        jDataRetorno.setDate(null);
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoRetorno.setIcon(null);
        jOrigemOperacao.setText("");
        jNrDocumento.setText("");
        jHorarioRetorno.setText("");
        // Desabilitar Campos
        jBtPesqInterno.setEnabled(!true);
        jOrigemOperacao.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
        jDataRetorno.setEnabled(!true);
        jHorarioRetorno.setEnabled(!true);
        //Habilitar/Desabilitar botões
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(true);
        jBtPesqInternoPortaria.setEnabled(!true);
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jDataRetorno.setDate(null);
        jOrigemOperacao.setText("");
        jNrDocumento.setText("");
        jHorarioRetorno.setText("");
        //
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(true);
        jBtExcluirlanc.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(true);
        jBtFinalizar.setEnabled(true);

    }

    public void CancelarItem() {

        //Habilitar/Desabilitar campos
        jDataRetorno.setEnabled(!true);
        jOrigemOperacao.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
        jHorarioRetorno.setEnabled(!true);
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
        jBtPesqInternoPortaria.setEnabled(!true);
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

    // Verificar se existe itens na saida do interno
    public void verificarItens() {
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSRETORNO WHERE IdRetorno='" + jIDLanc.getText() + "'");
            conecta.rs.first();
            codRetorno = conecta.rs.getString("IdSaida");
            if (jIDLanc.getText().equals(codRetorno)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os internos relacionados a esse registro.");
            }
            conecta.desconecta();
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objRetorno.setIdRetorno(Integer.parseInt(jIDLanc.getText()));
                control.excluirRetornoInternos(objRetorno);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel EXCLUIR Lançamento...\nERRO :" + ex);
            }
        }
    }

    //Preencher tabela com todos os INTERNOS
    public void preencherTodasEntradas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM RETORNOSCRC"
                    + " INNER JOIN OPERACAO "
                    + "ON RETORNOSCRC.IdOp = OPERACAO.IdOp");
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataBrasil = conecta.rs.getString("DataLancRetorno");
                String dia = dataBrasil.substring(8, 10);
                String mes = dataBrasil.substring(5, 7);
                String ano = dataBrasil.substring(0, 4);
                dataBrasil = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdRetorno"), dataBrasil, conecta.rs.getString("StatusRet"), conecta.rs.getString("TipoOp"), conecta.rs.getString("DescricaoOp"), conecta.rs.getString("ObsRetorno")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRetorno.setModel(modelo);
        jTabelaRetorno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaRetorno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaRetorno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaRetorno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaRetorno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTabelaRetorno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(5).setPreferredWidth(380);
        jTabelaRetorno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaRetorno.getTableHeader().setReorderingAllowed(false);
        jTabelaRetorno.setAutoResizeMode(jTabelaRetorno.AUTO_RESIZE_OFF);
        jTabelaRetorno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRetorno.setModel(modelo);
        jTabelaRetorno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaRetorno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaRetorno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaRetorno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaRetorno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTabelaRetorno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(5).setPreferredWidth(280);
        jTabelaRetorno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaRetorno.getTableHeader().setReorderingAllowed(false);
        jTabelaRetorno.setAutoResizeMode(jTabelaRetorno.AUTO_RESIZE_OFF);
        jTabelaRetorno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void pesquisarRetornoInterno(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Operação", "Descrição", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataBrasil = conecta.rs.getString("DataLancRetorno");
                String dia = dataBrasil.substring(8, 10);
                String mes = dataBrasil.substring(5, 7);
                String ano = dataBrasil.substring(0, 4);
                dataBrasil = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdRetorno"), dataBrasil, conecta.rs.getString("StatusRet"), conecta.rs.getString("TipoOp"), conecta.rs.getString("DescricaoOp"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRetorno.setModel(modelo);
        jTabelaRetorno.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTabelaRetorno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaRetorno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaRetorno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTabelaRetorno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(4).setPreferredWidth(170);
        jTabelaRetorno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(5).setPreferredWidth(400);
        jTabelaRetorno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaRetorno.getTableHeader().setReorderingAllowed(false);
        jTabelaRetorno.setAutoResizeMode(jTabelaRetorno.AUTO_RESIZE_OFF);
        jTabelaRetorno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void alinharCamposTabela() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaRetorno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaRetorno.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaRetorno.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void pesquisarLancCod(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição ", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();

            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataBrasil = conecta.rs.getString("DataLancRetorno");
                String dia = dataBrasil.substring(8, 10);
                String mes = dataBrasil.substring(5, 7);
                String ano = dataBrasil.substring(0, 4);
                dataBrasil = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdRetorno"), dataBrasil, conecta.rs.getString("StatusRet"), conecta.rs.getString("TipoOp"), conecta.rs.getString("DescricaoOp"), conecta.rs.getString("ObsRetorno")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRetorno.setModel(modelo);
        jTabelaRetorno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaRetorno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaRetorno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaRetorno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaRetorno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTabelaRetorno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(5).setPreferredWidth(280);
        jTabelaRetorno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaRetorno.getTableHeader().setReorderingAllowed(false);
        jTabelaRetorno.setAutoResizeMode(jTabelaRetorno.AUTO_RESIZE_OFF);
        jTabelaRetorno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void preencherTabelaItens(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Seq.", "Nome do Interno", "Data Retorno", "Origem", " Documento "};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                dataRetorno = conecta.rs.getString("DataRetorno");
                String dia = dataRetorno.substring(8, 10);
                String mes = dataRetorno.substring(5, 7);
                String ano = dataRetorno.substring(0, 4);
                dataRetorno = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getString("NomeInternoCrc"), dataRetorno, conecta.rs.getString("OrigemRetorno"), conecta.rs.getString("DocumentoRetorno")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensInterno.setModel(modelo);
        jTabelaItensInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaItensInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(1).setPreferredWidth(210);
        jTabelaItensInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaItensInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(3).setPreferredWidth(200);
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
        String[] Colunas = new String[]{"Seq.", "Nome do Interno", "Data Retorno", "Origem", "Documento"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensInterno.setModel(modelo);
        jTabelaItensInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaItensInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(1).setPreferredWidth(210);
        jTabelaItensInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaItensInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(3).setPreferredWidth(200);
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

    //Buscar código de Retorno
    public void buscarCodRet() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM RETORNOSCRC");
            conecta.rs.last();
            codRet = conecta.rs.getInt("IdRetorno");
            jIDLanc.setText(String.valueOf(conecta.rs.getInt("IdRetorno")));
            objRetorno.setIdRetorno(Integer.valueOf(jIDLanc.getText()));
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar LANÇAMENTO DE SAIDA \nERRO: " + ex);
        }
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIDLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIDLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarIdItem() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSRETORNO ");
            conecta.rs.last();
            codItem = conecta.rs.getInt("IdItem");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do item.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void objMovRetEvadidos() {
        objMovSaiRetornoEva.setIdRetorno(Integer.valueOf(jIDLanc.getText()));
        objMovSaiRetornoEva.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
        objMovSaiRetornoEva.setNrDocSaida(jNrDocumento.getText());
        objMovSaiRetornoEva.setDataRetorno(jDataRetorno.getDate());
        objMovSaiRetornoEva.setNrDocRetorno(jNrDocumento.getText());
        objMovSaiRetornoEva.setConfirmaEvasao(opReposta);
    }

    public void limparCamposBancoEvasao() {
        //jIDLanc.setText("");
        // jIdInterno.setText(null);
        jNrDocumento.setText("");
        jDataRetorno.setDate(null);
        opReposta = "";
        objMovSaiRetornoEva.setIdRetorno(Integer.valueOf(jIDLanc.getText()));
        objMovSaiRetornoEva.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
        objMovSaiRetornoEva.setDataRetorno(jDataRetorno.getDate());
        objMovSaiRetornoEva.setNrDocRetorno(jNrDocumento.getText());
        objMovSaiRetornoEva.setConfirmaEvasao(opReposta);
    }

    public void verificarParamentrosCrc() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            codParametrosRetorno = conecta.rs.getString("RetornosPortaria");
        } catch (SQLException ex) {
        }
    }

    // ABRI o Rol do interno quando o mesmo RETORNAR da unidade
    public void atualizarRolSaidaInterno() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ROLVISITAS WHERE IdInternoCrc='" + jIdInterno.getText() + "'AND StatusRol='" + statusRolFechado + "'");
            conecta.rs.first();
            idInternoRol = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
        }
        statusRol = "ABERTO";
        objRol.setIdInterno(Integer.valueOf(jIdInterno.getText()));
        objRol.setStatusRol(statusRol);
        objRol.setObsRol(jDescricaoOpe.getText());
        //  objRol.setObsRol(jOrigem.getText());
        objRol.setUsuarioUp(nameUser);
        objRol.setDataUp(jDataSistema.getText());
        objRol.setHoraUp(horaMov);
        controlRol.finalizarRolVisitasPortaria(objRol);
        conecta.desconecta();
    }

    // Se o usuário excluir o interno da saida da portaria, atualiza o status do Rol para FINALIZADO
    public void atualizarRolSaidaInternoExcluir() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ROLVISITAS WHERE IdInternoCrc='" + jIdInterno.getText() + "'AND StatusRol='" + statusRol + "'");
            conecta.rs.first();
            idInternoRol = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
        }
        statusRol = "FINALIZADO";
        objRol.setIdInterno(Integer.valueOf(jIdInterno.getText()));
        objRol.setStatusRol(statusRol);
        objRol.setObsRol("");
        objRol.setUsuarioUp(nameUser);
        objRol.setDataUp(jDataSistema.getText());
        objRol.setHoraUp(horaMov);
        controlRol.finalizarRolVisitasPortaria(objRol);
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
