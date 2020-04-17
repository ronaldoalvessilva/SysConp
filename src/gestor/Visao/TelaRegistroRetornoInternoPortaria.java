/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMOVSRPortaria;
import gestor.Controle.ControleRegistroItensRetornoInterno;
import gestor.Controle.ControleRegistroRetornoInternos;
import gestor.Controle.ControleRetornoInternoPortaria;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.ModeloTabela;
import gestor.Controle.ControleEntradasSaidasPopulacaoInternos;
import gestor.Controle.ListagemRegistroSaidaPopulcaoPortaria;
import gestor.Controle.ListagemUltimaPopulacaoCRC;
import gestor.Modelo.EntradaSaidasPolucaoInternos;
import gestor.Modelo.ItensRegistroRetornoInterno;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProntuarioCrc;
import gestor.Modelo.RegistroRetornoInternos;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPortarias.codigoUserGroupP1;
import static gestor.Visao.TelaModuloPortarias.codigoGrupoP1;
import static gestor.Visao.TelaModuloPortarias.codAbrirP1;
import static gestor.Visao.TelaModuloPortarias.codAlterarP1;
import static gestor.Visao.TelaModuloPortarias.codExcluirP1;
import static gestor.Visao.TelaModuloPortarias.codGravarP1;
import static gestor.Visao.TelaModuloPortarias.codConsultarP1;
import static gestor.Visao.TelaModuloPortarias.codIncluirP1;
import static gestor.Visao.TelaModuloPortarias.codUserAcessoP1;
import static gestor.Visao.TelaModuloPortarias.codigoUserP1;
import static gestor.Visao.TelaModuloPortarias.nomeGrupoP1;
import static gestor.Visao.TelaModuloPortarias.nomeTelaP1;
import static gestor.Visao.TelaModuloPortarias.telaRegistroRetornoRIBioP1;
import static gestor.Visao.TelaModuloPortarias.telaRegistroRetornoRIIntP1;
import static gestor.Visao.TelaModuloPortarias.telaRegistroRetornoRIManuP1;
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
public class TelaRegistroRetornoInternoPortaria extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroRetornoInternos objRetorno = new RegistroRetornoInternos();
    ItensRegistroRetornoInterno objItensRetorno = new ItensRegistroRetornoInterno();
    ControleRegistroRetornoInternos control = new ControleRegistroRetornoInternos();
    ControleRegistroItensRetornoInterno controle = new ControleRegistroItensRetornoInterno();
    ControleMOVSRPortaria controlMOVSR = new ControleMOVSRPortaria(); // Portaria atualiza tabela MOVSR no retorno do interno
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    //
    ControleRetornoInternoPortaria controleRetornoPortaria = new ControleRetornoInternoPortaria();
    //ADICIONAR A POPULAÇÃO NA TABELA ENTRADAS_SAIDAS_POPULACAO_INTERNOS (CONTROLE ALIMENTAÇÃO)
    ControleEntradasSaidasPopulacaoInternos populacao = new ControleEntradasSaidasPopulacaoInternos();
    EntradaSaidasPolucaoInternos objEntradaSaida = new EntradaSaidasPolucaoInternos();
    ListagemUltimaPopulacaoCRC listaUltimaPopulacao = new ListagemUltimaPopulacaoCRC();
    ListagemRegistroSaidaPopulcaoPortaria listaRegistroES = new ListagemRegistroSaidaPopulcaoPortaria();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Portaria:Movimentação:Registro Retorno de Internos:Manutenção";
    String nomeModuloTela2 = "Portaria:Movimentação:Registro Retorno de Internos:Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
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
    String confirma = "Não";
    String vconfirmado = " REGISTRADO - CRC";
    String documentoRetorno; //Para quando usuário atualizar a tabela MOVSR quando usuário excluir em ITENSREGISTRO portaria
    int count = 0;
    //
    String confirmarRetornoPort = "Sim"; //RETORNO DA PORTARIA
    String confirmarRetornoCrc = "Não"; // PARA SINALIZAR RETORNO NO CRC QUANDO INTERNO CHEGAR.
    //   
    String assinaturaBiometria = "";
    byte[] retornoBiometria = null;
    String codigoRetorno = "";
    String codigoInternoRet = "";
    //
    String pTIPO_OPERCAO_ENTRADA = "Entrada na Unidade";
    public static String pREGISTRO_ENTRADA = "";
    int pPOPULCAO_ATUAL = 0;
    int pQUANTIDADE_ENTRADA_INTERNO = 1;
    int pID_ITEM_ALIMENTACAO = 0;

    /**
     * Creates new form TelaRetornoInterno
     */
    public static TelaFotoPortariaRetorno telafotoretorno;
    public static TelaBiometriaRetornoInternoPortaria biometriaRetorno;

    public TelaRegistroRetornoInternoPortaria() {
        super();
        initComponents();
        setResizable(false);
        corCampos();
        formatarCampos();
    }

    public void mostrarFotoRetorno() {
        telafotoretorno = new TelaFotoPortariaRetorno(this, true);
        telafotoretorno.setVisible(true);
    }

    public void mostrarBiometriaRetorno() {
        biometriaRetorno = new TelaBiometriaRetornoInternoPortaria(this, true);
        biometriaRetorno.setVisible(true);
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
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
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
        jObservacao = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jIdInterno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jDataRetorno = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jNrDocumento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jHorarioRetorno = new javax.swing.JFormattedTextField();
        confirmadoRetorno = new javax.swing.JLabel();
        jBtPesqInterno = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jOrigemOperacao = new javax.swing.JComboBox();
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
        jBtZoon = new javax.swing.JButton();
        jBtBiometria = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jFotoInternoRetorno = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        jTextField1.setText("jTextField1");

        setClosable(true);
        setIconifiable(true);
        setTitle("...:::: Registro de Retorno de Internos na Portaria {P1} :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa Lançamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1)))
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtIdLanc)
                    .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel25)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtDataLanc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel14)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            jTabelaRetorno.getColumnModel().getColumn(4).setMinWidth(250);
            jTabelaRetorno.getColumnModel().getColumn(4).setMaxWidth(250);
            jTabelaRetorno.getColumnModel().getColumn(5).setMinWidth(380);
            jTabelaRetorno.getColumnModel().getColumn(5).setMaxWidth(380);
        }

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jStatusRetorno)
                    .addComponent(jDescricaoOpe, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
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
                .addGap(8, 8, 8)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jBtAudRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jObservacao.setColumns(20);
        jObservacao.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane2.setViewportView(jObservacao);

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
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

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Documento");

        jNrDocumento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNrDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNrDocumento.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Horário");

        jHorarioRetorno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioRetorno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jHorarioRetorno.setEnabled(false);

        confirmadoRetorno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        confirmadoRetorno.setForeground(new java.awt.Color(255, 0, 0));
        confirmadoRetorno.setToolTipText("Confirmado Retorno pelo CRC");
        confirmadoRetorno.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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

        jOrigemOperacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jOrigemOperacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Retorno Audiência", "Retorno Médico", "Retorno Saída Temporaria", "Retorno Recaptura", "Retorno Transferência", "Retorno por Nova Condenação", "Retono Espontâneo", "Outros Retornos", "Retorno por Nova Prisão", "Retorno de Prisão Domiciliar - COVID-19", "Retorno Prisão Domiciliar" }));
        jOrigemOperacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOrigemOperacao.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jOrigemOperacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jHorarioRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(146, 146, 146))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jNrDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(confirmadoRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jNomeInterno, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(145, 145, 145))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(3, 3, 3)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jIdInterno)
                        .addComponent(jBtPesqInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jOrigemOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNrDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmadoRetorno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {confirmadoRetorno, jNrDocumento});

        jTabelaItensInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaItensInterno.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTabelaItensInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seq.", "Nome do Interno", "Data Retorno", "Operação", "Documento"
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
            jTabelaItensInterno.getColumnModel().getColumn(1).setMinWidth(200);
            jTabelaItensInterno.getColumnModel().getColumn(1).setMaxWidth(200);
            jTabelaItensInterno.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaItensInterno.getColumnModel().getColumn(2).setMaxWidth(100);
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

        jBtZoon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/11985_16x16.png"))); // NOI18N
        jBtZoon.setToolTipText("Aumentar Foto do Interno");
        jBtZoon.setEnabled(false);
        jBtZoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtZoonActionPerformed(evt);
            }
        });

        jBtBiometria.setForeground(new java.awt.Color(51, 102, 0));
        jBtBiometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216082320_16.png"))); // NOI18N
        jBtBiometria.setText("Biometria");
        jBtBiometria.setEnabled(false);
        jBtBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBiometriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jBtExcluirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtNovoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBtAlterarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBtSairItens, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtSalvarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtCancelarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jBtBiometria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtZoon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAudRetInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarItem, jBtCancelarItem, jBtExcluirItem, jBtNovoItem, jBtSairItens, jBtSalvarItem});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtBiometria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtZoon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtAudRetInternos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarItem, jBtCancelarItem, jBtExcluirItem, jBtNovoItem, jBtSairItens, jBtSalvarItem});

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 0, 102))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoRetorno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 15, 729, 534);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtDataLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDataLancActionPerformed
        // TODO add your handling code here:
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
                    pesquisarLancCod("SELECT * FROM REGRETORNO "
                            + "INNER JOIN OPERACAO "
                            + "ON REGRETORNO.IdOp=OPERACAO.IdOp "
                            + "WHERE DataLancRetorno BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                }
            }
        }
    }//GEN-LAST:event_jBtDataLancActionPerformed

    private void jBtIdLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIdLancActionPerformed
        // TODO add your handling code here:
        count = 0;
        pesquisarLancCod("SELECT * FROM REGRETORNO "
                + "INNER JOIN OPERACAO "
                + "ON REGRETORNO.IdOp=OPERACAO.IdOp "
                + "WHERE IdRetorno='" + jIDPesqLan.getText() + "'");
    }//GEN-LAST:event_jBtIdLancActionPerformed

    private void jTabelaRetornoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaRetornoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaRetorno.getValueAt(jTabelaRetorno.getSelectedRow(), 0);
            jIDPesqLan.setText(IdLanc);
            jDataLancamento.setDate(jDataLancamento.getDate());
            jBtNovolanc.setEnabled(true);
            jBtAlterarlanc.setEnabled(true);
            jBtExcluirlanc.setEnabled(true);
            jBtSalvarlanc.setEnabled(!true);
            jBtCancelarlanc.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAudRetorno.setEnabled(true);
            //
            jBtNovoItem.setEnabled(true);
            jBtBiometria.setEnabled(true);
            //
            bloquearCamposPesquisa();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM REGRETORNO "
                        + "INNER JOIN OPERACAO "
                        + "ON REGRETORNO.IdOp=OPERACAO.IdOp "
                        + "WHERE IdRetorno ='" + IdLanc + "'");
                conecta.rs.first();
                jIDLanc.setText(String.valueOf(conecta.rs.getInt("IdRetorno")));
                jStatusRetorno.setText(conecta.rs.getString("StatusRet"));
                jDataLancamento.setDate(conecta.rs.getDate("DataLancRetorno"));
                jDescricaoOpe.setText(conecta.rs.getString("DescricaoOp"));
                jObservacao.setText(conecta.rs.getString("ObsRetorno"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por DATA " + e);
            }
            preencherTabelaItens("SELECT * FROM ITENSREGISTRO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSREGISTRO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdRetorno='" + IdLanc + "'");
        }
    }//GEN-LAST:event_jTabelaRetornoMouseClicked

    private void jBtPesqOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqOperacaoActionPerformed
        // TODO add your handling code here:
        TelaPesquisaOpRegistroRetorno objOpRetorno = new TelaPesquisaOpRegistroRetorno();
        TelaModuloPortarias.jPainelPortarias.add(objOpRetorno);
        objOpRetorno.show();
    }//GEN-LAST:event_jBtPesqOperacaoActionPerformed

    private void jBtNovolancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovolancActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroRetornoRIManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroRetornoRIManuP1) && codIncluirP1 == 1) {
            acao = 1;
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovolancActionPerformed

    private void jBtAlterarlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarlancActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroRetornoRIManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroRetornoRIManuP1) && codAlterarP1 == 1) {
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
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarlancActionPerformed

    private void jBtExcluirlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirlancActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroRetornoRIManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroRetornoRIManuP1) && codExcluirP1 == 1) {
            objRetorno.setStatusRetorno(jStatusRetorno.getText());
            if (jStatusRetorno.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa entrada de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                verificarItens();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirlancActionPerformed

    private void jBtSalvarlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarlancActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroRetornoRIManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroRetornoRIManuP1) && codGravarP1 == 1) {
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
                    objRetorno.setObsRetorno(jObservacao.getText());
                    objRetorno.setNomeUsuario(nameUser);
                    objRetorno.setDataInsert(jDataSistema.getText());
                    objRetorno.setHoraInsert(jHoraSistema.getText());
                    try {
                        if (acao == 1) {
                            control.incluirRetornoInternos(objRetorno);
                            buscarCodRet();
                            objLog();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            JOptionPane.showMessageDialog(rootPane, "Registro INCLUIDO com sucesso, será necessário\nincluir os internos \npara que possa ser registrado a movimentação.");
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
                        preencherTabelaItens("SELECT * FROM ITENSREGISTRO "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ITENSREGISTRO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE IdRetorno='" + jIDLanc.getText() + "'");
                    } catch (HeadlessException e) {
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível GRAVAR registro !!!\n" + e);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
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
            jBtZoon.setEnabled(true);
            jBtNovoItem.setEnabled(!true);
            jBtAlterarItem.setEnabled(true);
            jBtExcluirItem.setEnabled(true);
            jBtSalvarItem.setEnabled(!true);
            jBtCancelarItem.setEnabled(true);
            jBtAudRetInternos.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                        + "INNER JOIN ITENSREGISTRO "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSREGISTRO.IdInternoCrc "
                        + "WHERE NomeInternoCrc='" + jNomeInterno.getText() + "' "
                        + "AND IdRetorno='" + jIDLanc.getText() + "' "
                        + "AND DocumentoRetorno='" + nrDoc + "' "
                        + "AND IdItem='" + idItem + "'");
                conecta.rs.first();
                jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                idItem = conecta.rs.getString("IdItem");
                codItem = conecta.rs.getInt("IdItem");
                jDataRetorno.setDate(conecta.rs.getDate("DataRetorno"));
                jOrigemOperacao.setSelectedItem(conecta.rs.getString("OrigemRetorno"));
                jNrDocumento.setText(conecta.rs.getString("DocumentoRetorno"));
                jHorarioRetorno.setText(conecta.rs.getString("HorarioRetorno"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jFotoInternoRetorno.setIcon(i);
                    jFotoInternoRetorno.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoRetorno.getWidth(), jFotoInternoRetorno.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInternoRetorno.getWidth(), jFotoInternoRetorno.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInternoRetorno.setIcon(icon);
                }
                confirma = conecta.rs.getString("ConfirmacaoRetorno");
                // Se confirmado (Sim), siginifica que o CRC já fez o retorno do interno
                if (confirma.equals("Sim")) {
                    confirmadoRetorno.setText(vconfirmado);
                } else {
                    confirmadoRetorno.setText("");
                }
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
        }
    }//GEN-LAST:event_jTabelaItensInternoMouseClicked

    private void jBtNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroRetornoRIIntP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroRetornoRIIntP1) && codIncluirP1 == 1) {
            objRetorno.setStatusRetorno(jStatusRetorno.getText());
            if (jStatusRetorno.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse retorno de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovoItem();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoItemActionPerformed

    private void jBtAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroRetornoRIIntP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroRetornoRIIntP1) && codAlterarP1 == 1) {
            verificarBiometria();
            objRetorno.setStatusRetorno(jStatusRetorno.getText());
            objItensRetorno.setIdRetorno(Integer.valueOf(jIDLanc.getText()));
            objItensRetorno.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
            if (retornoBiometria != null) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível alterar esse registro, o mesmo tem origem da biometria.");
            } else if (jStatusRetorno.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse retorno de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else if (confirma.equals("Sim")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser mais modificado, pois, o mesmo encontra-se efetuado pelo CRC");
            } else {
                acao = 4;
                flag = 1;
                AlterarItem();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarItemActionPerformed

    private void jBtExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirItemActionPerformed
        // TODO add your handling code here:
        // documentoRetorno = jNrDocumento.getText();
        buscarAcessoUsuario(telaRegistroRetornoRIIntP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroRetornoRIIntP1) && codExcluirP1 == 1) {
            if (confirma.equals("Sim")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser mais excluído, pois, o mesmo encontra-se efetuado pelo CRC");
            } else {
                verificarBiometria();
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                objRetorno.setStatusRetorno(jStatusRetorno.getText());
                if (jStatusRetorno.getText().equals("FINALIZADO")) {
                    JOptionPane.showMessageDialog(rootPane, "Esse retorno de internos não poderá ser excluído, o mesmo encontra-se FINALIZADO");
                } else if (retornoBiometria != null) {
                    JOptionPane.showMessageDialog(rootPane, "Não é possível alterar esse registro, o mesmo tem origem da biometria.");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o INTERNO selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        // Limpa as variaveis para limpar os campos da tabela MOVSR               
                        jDataRetorno.setDate(null);
                        jNrDocumento.setText("");
                        //Atualizar a tabela MOVISR pela portaria retirando o número do documento e a data de retorno.
                        objItensRetorno.setIdRetorno(Integer.valueOf(jIDLanc.getText()));
                        objItensRetorno.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                        objItensRetorno.setDocumento("");
                        objItensRetorno.setDataRetorno(null);
                        // objItensRetorno.setIdItemRetorno(Integer.valueOf(idItem));
                        controlMOVSR.alterarRegistroRetorno(objItensRetorno); // Tabela MOVISR
                        // EXCLUIR REGISTRO DA TABELA VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                        objItensRetorno.setIdRetorno((Integer.valueOf(jIDLanc.getText())));
                        objItensRetorno.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                        controleRetornoPortaria.excluirInternoRetorno(objItensRetorno);
                        //
                        objItensRetorno.setIdItemRetorno(Integer.valueOf(idItem));
                        controle.excluirItensRetorno(objItensRetorno);
                        //
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação   
                        preencherTabelaItens("SELECT * FROM ITENSREGISTRO "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ITENSREGISTRO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE IdRetorno='" + jIDLanc.getText() + "'");

                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                        ExcluirItem();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirItemActionPerformed

    private void jBtSalvarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarItemActionPerformed
        // TODO add your handling code here
        buscarAcessoUsuario(telaRegistroRetornoRIIntP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroRetornoRIIntP1) && codGravarP1 == 1) {
            confirma = "Não";
            if (jNomeInterno.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nome do interno não pode ser em branco\nfaça uma pesquisa para preencher nome do interno");
            } else {
                if (jOrigemOperacao.getSelectedItem().equals("") || jOrigemOperacao.getSelectedItem().equals("Selecione...")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe o nome da origem.");
                } else {
                    if (jHorarioRetorno.getText().equals("")) {
                        JOptionPane.showMessageDialog(rootPane, "Informe o horário de retorno do interno.");
                        jHorarioRetorno.requestFocus();
                    } else {
                        objItensRetorno.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                        objItensRetorno.setNomeInterno(jNomeInterno.getText());
                        objItensRetorno.setDataRetorno(jDataRetorno.getDate());
                        objItensRetorno.setNomerOrigem((String) jOrigemOperacao.getSelectedItem());
                        objItensRetorno.setDocumento(jNrDocumento.getText());
                        objItensRetorno.setHorarioRetorno(jHorarioRetorno.getText());
                        objItensRetorno.setConfirmaRetorno(confirma);
                        if (acao == 3) {
                            objItensRetorno.setUsuarioInsert(nameUser);
                            objItensRetorno.setDataInsert(jDataSistema.getText());
                            objItensRetorno.setHoraInsert(jHoraSistema.getText());
                            //Inserir na tabela de movimentação (RETORNO) 
                            objItensRetorno.setIdRetorno((Integer.valueOf(jIDLanc.getText())));
                            controle.incluirItensRetorno(objItensRetorno); // Gravar registro na tabela de itens ITENSREGISTRO                                                                    
                            buscarIdItem();
                            //ADICIONAR A POPULAAÇÃO DA ALIMENTAÇÃO A QUANTIDADE DE INTERNOS
                            if (jOrigemOperacao.getSelectedItem().equals("Retorno Saída Temporaria")) {
                                populacaoAlimentacao();
                            } else if (jOrigemOperacao.getSelectedItem().equals("Retorno de Prisão Domiciliar - COVID-19")) {
                                populacaoAlimentacao();
                            } else if (jOrigemOperacao.getSelectedItem().equals("Retorno Transferência")) {
                                populacaoAlimentacao();
                            } else if (jOrigemOperacao.getSelectedItem().equals("Retorno Recaptura")) {
                                populacaoAlimentacao();
                            } else if (jOrigemOperacao.getSelectedItem().equals("Retorno por Nova Condenação")) {
                                populacaoAlimentacao();
                            } else if (jOrigemOperacao.getSelectedItem().equals("Retono Espontâneo")) {
                                populacaoAlimentacao();
                            } else if (jOrigemOperacao.getSelectedItem().equals("Retorno por Nova Prisão")) {
                                populacaoAlimentacao();
                            } else if (jOrigemOperacao.getSelectedItem().equals("Retorno Prisão Domiciliar")) {
                                populacaoAlimentacao();
                            }
                            verificarGravacaoRegistro();
                            if (jIDLanc.getText().equals(codigoRetorno) && jIdInterno.getText().equals(codigoInternoRet)) {
                                //Atualizar a tabela MOVISR pela portaria do retorno dos internos.
                                objItensRetorno.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                                objItensRetorno.setDocumento(jNrDocumento.getText());
                                objItensRetorno.setIdItemRetorno(codItem); // Item para alterar o documento na tabela MOVISR quando for excluir o interno
                                controlMOVSR.incluirRegistroRetorno(objItensRetorno);
                                // INCLUI REGISTRO NA TABELA VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                objItensRetorno.setIdRetorno((Integer.valueOf(jIDLanc.getText())));
                                objItensRetorno.setNomeInterno(jNomeInterno.getText());
                                objItensRetorno.setDataRetorno(jDataRetorno.getDate());
                                objItensRetorno.setDocumento(jNrDocumento.getText());
                                objItensRetorno.setHorarioRetorno(jHorarioRetorno.getText());
                                objItensRetorno.setConfirmaRetorno(confirmarRetornoPort); // CONFIRMA COMO "Sim" - PORTARIA
                                objItensRetorno.setConfirmaRetornoCrc(confirmarRetornoCrc); // CONFIRMA COMO "Não" - CRC
                                controleRetornoPortaria.incluirInternoRetorno(objItensRetorno);
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Não foi possível fazer o retorno do interno, tente novamente!!!");
                            }
                            //
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            preencherTabelaItens("SELECT * FROM ITENSREGISTRO "
                                    + "INNER JOIN PRONTUARIOSCRC "
                                    + "ON ITENSREGISTRO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                    + "WHERE IdRetorno='" + jIDLanc.getText() + "'");
                            SalvarItem();
                            JOptionPane.showMessageDialog(rootPane, "Registro incluido com sucesso");
                        }
                        if (acao == 4) {
                            objItensRetorno.setUsuarioUp(nameUser);
                            objItensRetorno.setDataUp(jDataSistema.getText());
                            objItensRetorno.setHoraUp(jHoraSistema.getText());
                            objItensRetorno.setIdRetorno((Integer.valueOf(jIDLanc.getText())));
                            objProCrc.setIdInterno(Integer.valueOf(jIdInterno.getText()));
                            objItensRetorno.setIdItemRetorno(Integer.valueOf(idItem));
                            controle.alterarItensRetorno(objItensRetorno);
                            // ALTERA REGISTRO NA TABELA VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                            objItensRetorno.setIdRetorno((Integer.valueOf(jIDLanc.getText())));
                            objItensRetorno.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                            objItensRetorno.setNomeInterno(jNomeInterno.getText());
                            objItensRetorno.setDataRetorno(jDataRetorno.getDate());
                            objItensRetorno.setDocumento(jNrDocumento.getText());
                            objItensRetorno.setHorarioRetorno(jHorarioRetorno.getText());
                            objItensRetorno.setConfirmaRetorno(confirmarRetornoPort); // CONFIRMA COMO "Sim" - PORTARIA
                            objItensRetorno.setConfirmaRetornoCrc(confirmarRetornoCrc); // CONFIRMA COMO "Não" - CRC
                            controleRetornoPortaria.alterarInternoRetorno(objItensRetorno);
                            //
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            preencherTabelaItens("SELECT * FROM ITENSREGISTRO "
                                    + "INNER JOIN PRONTUARIOSCRC "
                                    + "ON ITENSREGISTRO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                    + "WHERE IdRetorno='" + jIDLanc.getText() + "'");
                            SalvarItem();
                            JOptionPane.showMessageDialog(rootPane, "Registro alterado com sucesso.");
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
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
        TelaPesquisaRegistroRetornoInterno objRegRetornoInt = new TelaPesquisaRegistroRetornoInterno();
        TelaModuloPortarias.jPainelPortarias.add(objRegRetornoInt);
        objRegRetornoInt.show();
    }//GEN-LAST:event_jBtPesqInternoActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGRETORNO WHERE IdRetorno='" + jIDLanc.getText() + "'");
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
            this.preencherTodasEntradas("SELECT * FROM REGRETORNO "
                    + "INNER JOIN OPERACAO "
                    + "ON REGRETORNO.IdOp=OPERACAO.IdOp");
        } else {
            jtotalRegistros.setText("");
            limparTabelaRetorno();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário informar um nome ou parte do nome para pesquuisa.");
        } else {
            pesquisarRetornoInterno("SELECT * FROM  REGRETORNO "
                    + "INNER JOIN ITENSREGISTRO "
                    + "ON REGRETORNO.IdRetorno=ITENSREGISTRO.IdRetorno "
                    + "INNER JOIN OPERACAO "
                    + "ON REGRETORNO.IdOp=OPERACAO.IdOp "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSREGISTRO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'" + jPesqNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtNomeInternoActionPerformed

    private void jBtAudRetornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAudRetornoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaRegistroRetornoInternos objAudiRetorno = new TelaAuditoriaRegistroRetornoInternos();
        TelaModuloPortarias.jPainelPortarias.add(objAudiRetorno);
        objAudiRetorno.show();
    }//GEN-LAST:event_jBtAudRetornoActionPerformed

    private void jBtAudRetInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAudRetInternosActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensRegistroRetorno objItensAudReto = new TelaAuditoriaItensRegistroRetorno();
        TelaModuloPortarias.jPainelPortarias.add(objItensAudReto);
        objItensAudReto.show();
    }//GEN-LAST:event_jBtAudRetInternosActionPerformed

    private void jBtZoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtZoonActionPerformed
        // TODO add your handling code here:
        mostrarFotoRetorno();
    }//GEN-LAST:event_jBtZoonActionPerformed

    private void jBtBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBiometriaActionPerformed
        // TODO add your handling code here:telaRegistroRetornoRIBioP1   
        buscarAcessoUsuario(telaRegistroRetornoRIBioP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroRetornoRIBioP1) && codGravarP1 == 1) {
            if (jStatusRetorno.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro já foi FINALIZADO.");
            } else {
                mostrarBiometriaRetorno();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtBiometriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel confirmadoRetorno;
    private javax.swing.JButton jBtAlterarItem;
    private javax.swing.JButton jBtAlterarlanc;
    private javax.swing.JButton jBtAudRetInternos;
    private javax.swing.JButton jBtAudRetorno;
    private javax.swing.JButton jBtBiometria;
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
    private javax.swing.JButton jBtPesqOperacao;
    private javax.swing.JButton jBtSairItens;
    private javax.swing.JButton jBtSalvarItem;
    private javax.swing.JButton jBtSalvarlanc;
    public static javax.swing.JButton jBtZoon;
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
    private javax.swing.JTextArea jObservacao;
    public static javax.swing.JComboBox jOrigemOperacao;
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
    public static javax.swing.JTable jTabelaItensInterno;
    private javax.swing.JTable jTabelaRetorno;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void populacaoAlimentacao() {
        //ADICIONAR POPULAÇÃO NA TABELA ENTRADAS_SAIDAS_POPULCAO_INTERNOS
        objEntradaSaida.setIdDocumento(pID_ITEM_ALIMENTACAO);
        objEntradaSaida.setDataMovimento(jDataRetorno.getDate());
        objEntradaSaida.setHorarioMovimento(jHorarioRetorno.getText());
        objEntradaSaida.setQuantidade(pQUANTIDADE_ENTRADA_INTERNO);
        objEntradaSaida.setTipoOperacao(pTIPO_OPERCAO_ENTRADA);
        objEntradaSaida.setUsuarioInsert(nameUser);
        objEntradaSaida.setDataInsert(jDataSistema.getText());
        objEntradaSaida.setHorarioInsert(horaMov);
        //PEGAR ULTIMA POPUÇÃO PARA EFETUAR CALCULO ANTES DE GRAVAR
        listaUltimaPopulacao.selecionarPopulacao(objEntradaSaida);
        pPOPULCAO_ATUAL = objEntradaSaida.getPopulacao() + pQUANTIDADE_ENTRADA_INTERNO;
        objEntradaSaida.setPopulacao(pPOPULCAO_ATUAL);
        populacao.incluirEntradaSaidaPortaria(objEntradaSaida);
    }

    public void corCampos() {
        jIDLanc.setBackground(Color.white);
        jStatusRetorno.setBackground(Color.white);
        jDataLancamento.setBackground(Color.white);
        jDescricaoOpe.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        jDataLancamento.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jDataRetorno.setBackground(Color.white);
        jIdInterno.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jOrigemOperacao.setBackground(Color.white);
        jNrDocumento.setBackground(Color.white);
        jHorarioRetorno.setBackground(Color.white);
    }

    public void formatarCampos() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
        jNrDocumento.setDocument(new LimiteDigitosAlfa(11));
    }

    public void bloquearCamposPesquisa() {
        jDataLancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        //
        jDataRetorno.setEnabled(!true);
        jIdInterno.setEnabled(!true);
        jNomeInterno.setEnabled(!true);
        jOrigemOperacao.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
        jHorarioRetorno.setEnabled(!true);
        jDataRetorno.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
        //
        jDataRetorno.setDate(null);
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoRetorno.setIcon(null);
        jOrigemOperacao.setSelectedItem("Selecione...");
        jNrDocumento.setText("");
        jHorarioRetorno.setText("");
        jDataRetorno.setDate(null);
        confirmadoRetorno.setText("");
        jBtZoon.setEnabled(!true);
        //
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtAudRetInternos.setEnabled(!true);
        jBtZoon.setEnabled(!true);
    }

    public void Novo() {
        if (jIDLanc.getText().equals("")) {
            // Limpar campos para inclusão
            jIDLanc.setText("");
            jStatusRetorno.setText("ABERTO");
            jDataLancamento.setCalendar(Calendar.getInstance());
            jDescricaoOpe.setText("");
            jObservacao.setText("");
            jDataLancamento.setEnabled(true);
            jObservacao.setEnabled(true);
            //
            jIdInterno.setText("");
            jNomeInterno.setText("");
            jFotoInternoRetorno.setIcon(null);
            jOrigemOperacao.setSelectedItem("Selecione...");
            jDataRetorno.setDate(null);
            jHorarioRetorno.setText("");
            jNrDocumento.setText("");
            jBtZoon.setEnabled(!true);
            jBtPesqInterno.setEnabled(!true);
            confirmadoRetorno.setText("");
            limparTabelaItens();
        }
        // Limpar campos para inclusão
        jIDLanc.setText("");
        jStatusRetorno.setText("ABERTO");
        jDataLancamento.setCalendar(Calendar.getInstance());
        jDescricaoOpe.setText("");
        jObservacao.setText("");
        jDataLancamento.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoRetorno.setIcon(null);
        jOrigemOperacao.setSelectedItem("Selecione...");
        jDataRetorno.setDate(null);
        jHorarioRetorno.setText("");
        jNrDocumento.setText("");
        // Habilitar/Desabilitar Campos para inclusão
        jBtZoon.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
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
        limparTabelaItens();
    }

    public void Alterar() {

        jDataLancamento.setEnabled(true);
        jObservacao.setEnabled(true);
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
        //
        jBtZoon.setEnabled(!true);
        jBtPesqInterno.setEnabled(!true);
    }

    public void Excluir() {
        //Limpar campos
        jIDLanc.setText("");
        jDataLancamento.setDate(null);
        jDescricaoOpe.setText("");
        jObservacao.setText("");
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
        jObservacao.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtBiometria.setEnabled(true);
    }

    public void Cancelar() {
        if (jIDLanc.getText().equals("")) {
            // Limpar campos para inclusão
            jIDLanc.setText("");
            jStatusRetorno.setText("ABERTO");
            jDataLancamento.setCalendar(Calendar.getInstance());
            jDescricaoOpe.setText("");
            jObservacao.setText("");
            jDataLancamento.setEnabled(true);
            jObservacao.setEnabled(true);
            //
            jBtFinalizar.setEnabled(!true);
            jBtAudRetorno.setEnabled(!true);
            //
            jIdInterno.setText("");
            jNomeInterno.setText("");
            jFotoInternoRetorno.setIcon(null);
            jOrigemOperacao.setSelectedItem("Selecione...");
            jDataRetorno.setDate(null);
            jHorarioRetorno.setText("");
            jNrDocumento.setText("");
            limparTabelaItens();
        }
        jDataLancamento.setEnabled(!true);
        jDescricaoOpe.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
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
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZAR o registro selecionado?", "Confirmação",
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

        // Limpar os campos para inclusão
        jDataRetorno.setDate(null);
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoRetorno.setIcon(null);
        jOrigemOperacao.setSelectedItem("Selecione...");
        jNrDocumento.setText("");
        jHorarioRetorno.setText(jHoraSistema.getText());
        jBtPesqInterno.setEnabled(true);
        jBtZoon.setEnabled(true);
        jDataRetorno.setCalendar(Calendar.getInstance());
        //
        jDataRetorno.setEnabled(true);
        jOrigemOperacao.setEnabled(true);
        jNrDocumento.setEnabled(true);
        jHorarioRetorno.setEnabled(true);
        jBtPesqInterno.setEnabled(true);
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        //
        jDataLancamento.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovolanc.setEnabled(!true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
    }

    public void AlterarItem() {

        //Habilitar os campos       
        jBtZoon.setEnabled(true);
        jDataRetorno.setEnabled(true);
        jOrigemOperacao.setEnabled(true);
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
        jObservacao.setEnabled(!true);
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
        jBtZoon.setEnabled(!true);
        jDataRetorno.setDate(null);
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoRetorno.setIcon(null);
        jOrigemOperacao.setSelectedItem("Selecione...");
        jNrDocumento.setText("");
        jHorarioRetorno.setText("");
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
    }

    public void SalvarItem() {
        // Limpar os campos para inclusão
        jDataRetorno.setDate(null);
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoRetorno.setIcon(null);
        jOrigemOperacao.setSelectedItem("Selecione...");
        jNrDocumento.setText("");
        jHorarioRetorno.setText("");
        // Desabilitar Campos
        jBtPesqInterno.setEnabled(!true);
        jBtZoon.setEnabled(!true);
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
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jDataRetorno.setDate(null);
        jOrigemOperacao.setSelectedItem(null);
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
        jBtZoon.setEnabled(!true);
        //
        jDataLancamento.setEnabled(!true);
        jBtPesqOperacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(true);
        jBtExcluirlanc.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    public void verificarBiometria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSREGISTRO "
                    + "WHERE IdRetorno='" + jIDLanc.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            retornoBiometria = conecta.rs.getBytes("AssinaturaEntrada");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    // Verificar se existe itens na saida do interno
    public void verificarItens() {
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSREGISTRO WHERE IdRetorno='" + jIDLanc.getText() + "'");
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
    public void preencherTodasEntradas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"};
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
        alinharCamposTabelaRetorno();
        conecta.desconecta();
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
        jTabelaRetorno.getColumnModel().getColumn(0).setPreferredWidth(50);
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
        alinharCamposTabelaRetorno();
        conecta.desconecta();
    }
// Pesquisa de Lançamento por Código (ID)

    public void pesquisarLancCod(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
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
        jTabelaRetorno.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaRetorno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaRetorno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(4).setPreferredWidth(275);
        jTabelaRetorno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(5).setPreferredWidth(380);
        jTabelaRetorno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaRetorno.getTableHeader().setReorderingAllowed(false);
        jTabelaRetorno.setAutoResizeMode(jTabelaRetorno.AUTO_RESIZE_OFF);
        jTabelaRetorno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaRetorno();
        conecta.desconecta();
    }

    public void alinharCamposTabelaRetorno() {
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

    public void limparTabelaRetorno() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Tipo Operação", "Descrição", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRetorno.setModel(modelo);
        jTabelaRetorno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaRetorno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaRetorno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaRetorno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaRetorno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(4).setPreferredWidth(275);
        jTabelaRetorno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaRetorno.getColumnModel().getColumn(5).setPreferredWidth(380);
        jTabelaRetorno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaRetorno.getTableHeader().setReorderingAllowed(false);
        jTabelaRetorno.setAutoResizeMode(jTabelaRetorno.AUTO_RESIZE_OFF);
        jTabelaRetorno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaItens(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Seq.", "Nome do Interno", "Data Retorno", "Operação", "Documento"};
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
        jTabelaItensInterno.getColumnModel().getColumn(1).setPreferredWidth(200);
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
        alinhaCamposTabelaItens();
        conecta.desconecta();
    }

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Seq.", "Nome do Interno", "Data Retorno", "Operação", "Documento"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaItensInterno.setModel(modelo);
        jTabelaItensInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaItensInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaItensInterno.getColumnModel().getColumn(1).setPreferredWidth(200);
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

    public void alinhaCamposTabelaItens() {
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
            conecta.executaSQL("SELECT * FROM REGRETORNO");
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
            conecta.executaSQL("SELECT * FROM ITENSREGISTRO ");
            conecta.rs.last();
            codItem = conecta.rs.getInt("IdItem");
            // PARA A POLULAÇÃO DE ALIMENTAÇÃO
            pID_ITEM_ALIMENTACAO = conecta.rs.getInt("IdItem");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do item.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void verificarGravacaoRegistro() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSREGISTRO "
                    + "WHERE IdRetorno='" + jIDLanc.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            codigoRetorno = conecta.rs.getString("IdRetorno");
            codigoInternoRet = conecta.rs.getString("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do item.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserP1 = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserP1 + "'");
            conecta.rs.first();
            codigoUserGroupP1 = conecta.rs.getInt("IdUsuario");
            codigoGrupoP1 = conecta.rs.getInt("IdGrupo");
            nomeGrupoP1 = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserP1 + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoP1 = conecta.rs.getInt("IdUsuario");
            codAbrirP1 = conecta.rs.getInt("Abrir");
            codIncluirP1 = conecta.rs.getInt("Incluir");
            codAlterarP1 = conecta.rs.getInt("Alterar");
            codExcluirP1 = conecta.rs.getInt("Excluir");
            codGravarP1 = conecta.rs.getInt("Gravar");
            codConsultarP1 = conecta.rs.getInt("Consultar");
            nomeTelaP1 = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
//    public void objMovRetEvadidos() {
//        objMovSaiRetornoEva.setIdRetorno(Integer.valueOf(jIDLanc.getText()));
//        objMovSaiRetornoEva.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
//        objMovSaiRetornoEva.setNrDocSaida(jNrDocumento.getText());
//        objMovSaiRetornoEva.setDataRetorno(jDataRetorno.getDate());
//        objMovSaiRetornoEva.setNrDocRetorno(jNrDocumento.getText());
//        objMovSaiRetornoEva.setConfirmaEvasao(opReposta);
//    }
//
//    public void limparCamposBancoEvasao() {
//        //jIDLanc.setText("");
//        // jIdInterno.setText(null);
//        jNrDocumento.setText("");
//        jDataRetorno.setDate(null);
//        opReposta = "";
//        objMovSaiRetornoEva.setIdRetorno(Integer.valueOf(jIDLanc.getText()));
//        objMovSaiRetornoEva.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
//        objMovSaiRetornoEva.setDataRetorno(jDataRetorno.getDate());
//        objMovSaiRetornoEva.setNrDocRetorno(jNrDocumento.getText());
//        objMovSaiRetornoEva.setConfirmaEvasao(opReposta);
//    }
}
