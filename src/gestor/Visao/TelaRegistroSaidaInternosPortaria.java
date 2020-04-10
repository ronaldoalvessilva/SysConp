/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleItensLocacaoInternos;
import gestor.Controle.ControleItensPrevisaoSaida;
import gestor.Controle.ControleItensRegSaidaInternos;
import gestor.Controle.ControleItensTransfInterno;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovInternos;
import gestor.Controle.ControleRegistroSaida;
import gestor.Controle.ControleRolVisitas;
import gestor.Controle.ControleSituacao;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.ModeloTabela;
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
import static gestor.Visao.TelaModuloPortarias.telaRegistroSaidaInternoBioP1;
import static gestor.Visao.TelaModuloPortarias.telaRegistroSaidaInternoExpP1;
import static gestor.Visao.TelaModuloPortarias.telaRegistroSaidaInternoIntP1;
import static gestor.Visao.TelaModuloPortarias.telaRegistroSaidaInternoManuP1;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaPesquisaRegistroSaidaInterno.idItemSaida;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.SQLException;
import java.text.ParseException;
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
public class TelaRegistroSaidaInternosPortaria extends javax.swing.JInternalFrame {

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
    String nomeModuloTela = "Portaria:Registro Saida de Internos:Manutenção";
    String nomeModuloTela2 = "Portaria:Registro Saida de Internos:Internos";
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
    String saidaMedico = "SAIDA PARA MEDICO";
    String saidaOutras = "OUTRAS SAIDAS";
    String saidaTemporaria = "SAIDA TEMPORARIA"; // MODIFICADO EM 08/07/2016 TORNOU-SE PADRÃO DA SECRETARIA
    String pPRISAO_DOMICILIAR_COVID = "PRISAO DOMICILIAR - COVID-19";
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
    String confirmaRegSaida; // Variavel Confirma a saida nas tabelas ITENSSAIDA E ITENSREGSAIDA
    String idSaidaTmp; // Item da tabela ITENSSAIDA gravado na tabela ITENSREGSAIDA
    String idSaidTransfTmp; // Item da tabela ITENTRANSFERENCIA gravado na tabela ITENSREGSAIDA
    //
    // Variáveis de pesquisa dos documentos DOCREGISTROS
    String rgInterno = "";
    String cpfInterno = "";
    String cnhInterno = "";
    String tituloInterno = "";
    String outrosDocInterno = "";
    String reservistaInterno = "";
    String ctpsInterno = "";
    String certidaoNascInterno = "";
    String certidaoCasaInterno = "";
    //
    String campoCredito = "C";
    String campoDebito = "D";
    double valorTotal = 0; // Total geral
    double valorCredito = 0; // Calcular os créditos
    double valorDebito = 0; // Calcular os débitos
    double valorTotalCredito = 0; // Total dos Créditos
    double valorTotalDebito = 0; // Total dos débitos
    //
    String statusRol = "ABERTO"; // Se o Rol estiver ABERTO, irá ser FINALIZADO para não ser mostrado na lista do Rol na portaria
    String statusRolFechado = "FINALIZADO"; // Se o Rol estiver fechado e o usuário excluir, o Rol volta a ser ABERTO
    String observacaoRol; // Varivael que irá informar no Rol do Interno se ele está na unidade
    int idInternoRol; // Código do interno no Rol de Visitas.
    //
    String codInternoCela; // Código do interno na cela paa excluir se for qualquer saida, menos audiência.      
    // Variaveis de Verificação dos parametros para dinheiro e documentos.
    String docAudiencia;
    String docTransferencia;
    String docSaidaTmp;
    String docLivraPro;
    String valAudiencia;
    String valTransferencia;
    String valSaidaTmp;
    String valLivraPro;
    String docPro;
    String docAlvara;
    String valPro;
    String valAlvara;
    int count = 0;
    //
    String idInternoSaida = "";
    String idLancSaida = "";
    //
    byte[] assinaturaDigital = null;
    public static int idItemCrcPort; // Item da tabela ITENSCRCPORTARIA
    //VERIFICAR SE O INTERNO TEM ASSINATURA BIOMETRICA
    String codigoSaidaBio;
    String codigoSaidaInterno;
    byte[] pAssinaturaInterno;
    /**
     * Creates new form TelaSaidaInterno
     */
    public static TelaFotoPortaria telafotoportaria;
    public static TelaBiometriaEntradaSaidaPortaria telaBioMov;
    public static TelaExportarInternosUnidades telaExpPor;

    public TelaRegistroSaidaInternosPortaria() {
        super();
        initComponents();
        setResizable(false);
        formatarCampos();
        corCampos();
    }

    public void mostraFotoPortaria() {
        telafotoportaria = new TelaFotoPortaria(this, true);
        telafotoportaria.setVisible(true);
    }

    public void mostrarBiometriaMov() {
        telaBioMov = new TelaBiometriaEntradaSaidaPortaria(this, true);
        telaBioMov.setVisible(true);
    }

    public void mostrarImportarInternos() {
        telaExpPor = new TelaExportarInternosUnidades(this, true);
        telaExpPor.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jIDlanc = new javax.swing.JTextField();
        jDataLancamento = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jStatusSaida = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jBtNovolanc = new javax.swing.JButton();
        jBtAlterarlanc = new javax.swing.JButton();
        jBtExcluirlanc = new javax.swing.JButton();
        jBtSalvarlanc = new javax.swing.JButton();
        jBtCancelarlanc = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtAudiSaida = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jIDInterno = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTipoSaida = new javax.swing.JTextField();
        jHorarioSaida = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jDataSaida = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jNrDocumento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelEvadido = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxUnidadeDestino = new javax.swing.JComboBox<>();
        totalRegistrosInternos = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTabelaItensInterno = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jBtNovoItem = new javax.swing.JButton();
        jBtAlterarItem = new javax.swing.JButton();
        jBtExcluirItem = new javax.swing.JButton();
        jBtSalvarItem = new javax.swing.JButton();
        jBtCancelarItem = new javax.swing.JButton();
        jBtSairItens = new javax.swing.JButton();
        jBtItensAudiSaidaInternos = new javax.swing.JButton();
        jBtBiometria = new javax.swing.JButton();
        jBtExportarRegistros = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        FotoInternoCrcSaida = new javax.swing.JLabel();
        jBtPesInterno = new javax.swing.JButton();
        jBtZoon = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Registro de Saida de Internos na Portaria {P1} :::...");

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
        jLabel10.setText("Nome Interno:");

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
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtDataLanc)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jBtIdLanc)
                    .addComponent(jIDPesqLan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBox1)
                    .addComponent(jBtNomeInterno)
                    .addComponent(jPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaSaidaInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaSaidaInterno.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTabelaSaidaInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Observação"
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
            jTabelaSaidaInterno.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaSaidaInterno.getColumnModel().getColumn(2).setMaxWidth(70);
            jTabelaSaidaInterno.getColumnModel().getColumn(3).setMinWidth(520);
            jTabelaSaidaInterno.getColumnModel().getColumn(3).setMaxWidth(520);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Código");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Data Doc.");

        jIDlanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDlanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDlanc.setEnabled(false);

        jDataLancamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLancamento.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Status");

        jStatusSaida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusSaida.setForeground(new java.awt.Color(255, 0, 0));
        jStatusSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusSaida.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jIDlanc, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 182, Short.MAX_VALUE))
                    .addComponent(jStatusSaida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIDlanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStatusSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Botões", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 0, 255))); // NOI18N

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

        jBtAudiSaida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAudiSaida.setForeground(new java.awt.Color(0, 0, 255));
        jBtAudiSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAudiSaida.setText("Auditoria");
        jBtAudiSaida.setEnabled(false);
        jBtAudiSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAudiSaidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jBtNovolanc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelarlanc))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jBtAlterarlanc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtFinalizar))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jBtExcluirlanc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAudiSaida))
                    .addComponent(jBtSalvarlanc))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarlanc, jBtAudiSaida, jBtCancelarlanc, jBtExcluirlanc, jBtFinalizar, jBtNovolanc, jBtSalvarlanc});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtNovolanc)
                    .addComponent(jBtCancelarlanc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtAlterarlanc)
                    .addComponent(jBtFinalizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtExcluirlanc)
                    .addComponent(jBtAudiSaida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarlanc)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarlanc, jBtAudiSaida, jBtCancelarlanc, jBtExcluirlanc, jBtFinalizar, jBtNovolanc, jBtSalvarlanc});

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane2.setViewportView(jObservacao);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Código");

        jIDInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIDInterno.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Nome Completo do Interno");

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);
        jNomeInterno.setPreferredSize(new java.awt.Dimension(3, 18));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Tipo Operação");

        jTipoSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTipoSaida.setEnabled(false);

        jHorarioSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioSaida.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Hora Saída");

        jDataSaida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataSaida.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Data Saida");

        jNrDocumento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNrDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNrDocumento.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Documento");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Situação");

        jLabelEvadido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelEvadido.setForeground(new java.awt.Color(255, 0, 0));
        jLabelEvadido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Unidade de Destino");

        jComboBoxUnidadeDestino.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUnidadeDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxUnidadeDestino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUnidadeDestino.setEnabled(false);

        totalRegistrosInternos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalRegistrosInternos.setForeground(new java.awt.Color(255, 0, 0));
        totalRegistrosInternos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalRegistrosInternos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("T.Reg");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel13))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(193, 193, 193))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jNrDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(79, 79, 79))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jIDInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jNomeInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTipoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(jLabel7))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabelEvadido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxUnidadeDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(totalRegistrosInternos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIDInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTipoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEvadido, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jNrDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxUnidadeDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalRegistrosInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaItensInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaItensInterno.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTabelaItensInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        jBtNovoItem.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
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

        jBtItensAudiSaidaInternos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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

        jBtBiometria.setForeground(new java.awt.Color(204, 0, 0));
        jBtBiometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Biometria16Vermelho.png"))); // NOI18N
        jBtBiometria.setText("Biometria");
        jBtBiometria.setEnabled(false);
        jBtBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBiometriaActionPerformed(evt);
            }
        });

        jBtExportarRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtExportarRegistros.setForeground(new java.awt.Color(102, 0, 0));
        jBtExportarRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/upload-16.png"))); // NOI18N
        jBtExportarRegistros.setText("Exportar");
        jBtExportarRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExportarRegistrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtItensAudiSaidaInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtNovoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAlterarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtSalvarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtCancelarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtSairItens, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtBiometria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtExportarRegistros))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarItem, jBtBiometria, jBtCancelarItem, jBtExcluirItem, jBtExportarRegistros, jBtNovoItem, jBtSairItens, jBtSalvarItem});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
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
                .addComponent(jBtBiometria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExportarRegistros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSairItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtItensAudiSaidaInternos))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarItem, jBtCancelarItem, jBtExcluirItem, jBtItensAudiSaidaInternos, jBtNovoItem, jBtSairItens, jBtSalvarItem});

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FotoInternoCrcSaida, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FotoInternoCrcSaida, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        );

        jBtPesInterno.setForeground(new java.awt.Color(255, 0, 0));
        jBtPesInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesInterno.setToolTipText("Buscar Interno");
        jBtPesInterno.setContentAreaFilled(false);
        jBtPesInterno.setEnabled(false);
        jBtPesInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesInternoActionPerformed(evt);
            }
        });

        jBtZoon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/11985_16x16.png"))); // NOI18N
        jBtZoon.setToolTipText("Ampliar Foto do Interno");
        jBtZoon.setContentAreaFilled(false);
        jBtZoon.setEnabled(false);
        jBtZoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtZoonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jBtPesInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtZoon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtPesInterno, jBtZoon});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtPesInterno)
                                    .addComponent(jBtZoon)))
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtPesInterno, jBtZoon});

        jTabbedPane1.addTab("Manutenção", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(300, 20, 726, 540);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNovolancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovolancActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroSaidaInternoManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroSaidaInternoManuP1) && codAbrirP1 == 1) {
            acao = 1;
            Novo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            limparTabelaItens();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovolancActionPerformed

    private void jBtAlterarlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarlancActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroSaidaInternoManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroSaidaInternoManuP1) && codAlterarP1 == 1) {
            objSaida.setStatusSaida(jStatusSaida.getText());
            if (jStatusSaida.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                Alterar();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarlancActionPerformed

    private void jBtExcluirlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirlancActionPerformed
        buscarAcessoUsuario(telaRegistroSaidaInternoManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroSaidaInternoManuP1) && codExcluirP1 == 1) {
            objSaida.setStatusSaida(jStatusSaida.getText());
            if (jStatusSaida.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser excluída, o mesmo encontra-se FINALIZADO");
            } else {
                verificarItens();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirlancActionPerformed

    private void jBtSalvarlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarlancActionPerformed
        // TODO add your handling code here:   
        buscarAcessoUsuario(telaRegistroSaidaInternoManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroSaidaInternoManuP1) && codGravarP1 == 1) {
            if (jDataLancamento.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de lançamento");
            } else {
                objSaida.setDataLanc(jDataLancamento.getDate());
                objSaida.setStatusSaida(statusSaida);
                objSaida.setObsSaida(jObservacao.getText());
                objSaida.setUsuarioInsert(nameUser);
                objSaida.setDataInsert(dataModFinal);
                objSaida.setHoraInsert(horaMov);
                try {
                    if (acao == 1) {
                        control.incluirRegSaidaInternos(objSaida);
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
                        objSaida.setIdSaida(Integer.parseInt(jIDlanc.getText()));
                        control.alterarRegSaidaInternos(objSaida);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro ALTERADO com sucesso, será necessário\nincluir os internos na aba (INTERNOS)\npara que possa ser registrado a movimentação.");
                        Salvar();
                    }
                } catch (HeadlessException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível gravar o registro \nERRO: " + e);
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
                    pesquisarLancCod("SELECT * FROM REGSAIDACRC "
                            + "WHERE DataLancaMov BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                }
            }
        }

    }//GEN-LAST:event_jBtDataLancActionPerformed

    private void jBtIdLancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIdLancActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesqLan.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o código do registro para pesquisa.");
        } else {
            pesquisarLancCod("SELECT * FROM REGSAIDACRC "
                    + "WHERE IdSaida='" + jIDPesqLan.getText() + "'");
        }
    }//GEN-LAST:event_jBtIdLancActionPerformed

    private void jTabelaSaidaInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaSaidaInternoMouseClicked
        // TODO add your handling code here:        
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaSaidaInterno.getValueAt(jTabelaSaidaInterno.getSelectedRow(), 0);
            jIDPesqLan.setText(IdLanc);
            //            
            bloquearCamposPesquisa();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM REGSAIDACRC "
                        + "WHERE IdSaida='" + IdLanc + "'");
                conecta.rs.first();
                jIDlanc.setText(String.valueOf(conecta.rs.getInt("IdSaida")));
                jStatusSaida.setText(conecta.rs.getString("StatusSai"));
                jDataLancamento.setDate(conecta.rs.getDate("DataLancaMov"));
                jObservacao.setText(conecta.rs.getString("ObsSaida"));
                conecta.desconecta();
                count = 0;
                jTabelaItensInterno.setVisible(true);
                preencherTabelaItens("SELECT * FROM ITENSREGSAIDA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENSREGSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdSaida='" + IdLanc + "'");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por DATA " + e);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaSaidaInternoMouseClicked

    private void jBtPesInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesInternoActionPerformed
        // TODO add your handling code here:
        TelaPesquisaRegistroSaidaInterno objSaidaRegInt = new TelaPesquisaRegistroSaidaInterno();
        TelaModuloPortarias.jPainelPortarias.add(objSaidaRegInt);
        objSaidaRegInt.show();
    }//GEN-LAST:event_jBtPesInternoActionPerformed

    private void jTabelaItensInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaItensInternoMouseClicked
        // TODO add your handling code here:
        count = 0;
        if (flag == 1) {
            String nomeInterno = "" + jTabelaItensInterno.getValueAt(jTabelaItensInterno.getSelectedRow(), 1);
            jNomeInterno.setText(nomeInterno);
            idItem = "" + jTabelaItensInterno.getValueAt(jTabelaItensInterno.getSelectedRow(), 0);
            nrDoc = "" + jTabelaItensInterno.getValueAt(jTabelaItensInterno.getSelectedRow(), 4);
            // Habilitar os botões
            jBtZoon.setEnabled(true);
            jBtNovoItem.setEnabled(!true);
            jBtAlterarItem.setEnabled(true);
            jBtExcluirItem.setEnabled(true);
            jBtSalvarItem.setEnabled(!true);
            jBtCancelarItem.setEnabled(true);
            jBtItensAudiSaidaInternos.setEnabled(true);
            //
            jDataSaida.setDate(null);
            jTipoSaida.setText("");
            jNrDocumento.setText("");
            jHorarioSaida.setText("");
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                        + "INNER JOIN ITENSREGSAIDA "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSREGSAIDA.IdInternoCrc "
                        + "WHERE NomeInternoCrc='" + jNomeInterno.getText() + "' "
                        + "AND IdSaida='" + jIDlanc.getText() + "' "
                        + "AND DocumentoSaida='" + nrDoc + "'AND IdItem='" + idItem + "'");
                conecta.rs.first();
                jIDInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    FotoInternoCrcSaida.setIcon(i);
                    FotoInternoCrcSaida.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoInternoCrcSaida.getWidth(), FotoInternoCrcSaida.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(FotoInternoCrcSaida.getWidth(), FotoInternoCrcSaida.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(scaled);
                    FotoInternoCrcSaida.setIcon(icon);
                }
                idItem = conecta.rs.getString("IdItem");
                codItem = conecta.rs.getInt("IdItem");
                idSaidaTmp = conecta.rs.getString("IdSaidaTmp"); // Item da tabela ITENSSAIDA gravado na tabela ITENSREGSAIDA
                idSaidTransfTmp = conecta.rs.getString("IdSaidaTmp"); // Item da tabela ITENSTRANSFERENCIA gravado na tabela ITENSREGSAIDA
                jDataSaida.setDate(conecta.rs.getDate("DataSaida"));
                jTipoSaida.setText(conecta.rs.getString("DestinoSaida"));
                jComboBoxUnidadeDestino.setSelectedItem(conecta.rs.getString("LocalSaida"));
                jNrDocumento.setText(conecta.rs.getString("DocumentoSaida"));
                jHorarioSaida.setText(conecta.rs.getString("HoraSaida"));
                assinaturaDigital = conecta.rs.getBytes("AssinaturaSaida");
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
        }
    }//GEN-LAST:event_jTabelaItensInternoMouseClicked

    private void jBtNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroSaidaInternoIntP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroSaidaInternoIntP1) && codIncluirP1 == 1) {
            objSaida.setStatusSaida(jStatusSaida.getText());
            if (jStatusSaida.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovoItem();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                codItem = 0; // zera na memória o item
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoItemActionPerformed

    private void jBtAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroSaidaInternoIntP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroSaidaInternoIntP1) && codAlterarP1 == 1) {
            acao = 4;
            flag = 1;
            objSaida.setStatusSaida(jStatusSaida.getText());
            if (jStatusSaida.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                if (jLabelEvadido.getText().equals("EVADIDO")) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o interno está evadido.");
                } else {
                    AlterarItem();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarItemActionPerformed

    private void jBtExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirItemActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroSaidaInternoIntP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroSaidaInternoIntP1) && codExcluirP1 == 1) {
            confirmaRegSaida = "Não"; // Variavel que confirma a saida do interno na portaria.
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objSaida.setStatusSaida(jStatusSaida.getText());
            if (jStatusSaida.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa saida de internos não poderá ser excluida, o mesmo encontra-se FINALIZADO");
            } else {
                if (jLabelEvadido.getText().equals("EVADIDO")) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o interno está evadido.");
                } else {
                    verificarAssiaturaBiometricaInterno();
                    if (jIDlanc.getText().equals(codigoSaidaBio) && jIDInterno.getText().equals(codigoSaidaInterno) && pAssinaturaInterno != null) {
                        JOptionPane.showMessageDialog(rootPane, "Não é possível excluir esse registro, o mesmo foi assinado através da biometria.");
                    } else {
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o INTERNO selecionado?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            objItemSaida.setConfirmaSaida(confirmaRegSaida);
                            objItemSaida.setIdItemSaida(idSaidaTmp); // Item do documento de saida (ITENSSAIDA)
                            controle.confirmaRegistroSaida(objItemSaida); // Modifica na tabela ITENSSAIDA (confirma a saida) do interno como não.
                            //
                            objItemSaida.setIdItemSaida(idItem);
                            controle.excluirItensRegSaida(objItemSaida);
                            // Modifica na tabela ITENSCRCPORTARIA (confirma a saida) do interno como não.
                            objItemSaida.setIdItemCrcPortaria(idItemCrcPort); // Item da tabela ITENSCRCPORTARIA      
                            objItemSaida.setIdInternoSaida(Integer.valueOf(jIDInterno.getText()));
                            objItemSaida.setIdItemSaida(idItemSaida); // Item referente a saída vinda do CRC para Portaria
                            controle.confirmaRegSaidaItensCrcPort(objItemSaida);
                            // TRANSFERENCIA
                            //Atualiza tabela de ITENSCRCPORTARIA
                            objItensTrans.setConfirmaSaida(confirmaRegSaida);
                            objItensTrans.setIdSaidTransfTmp(idSaidTransfTmp); // Item do documento de saida (ITENSCRCPORTARIA)                    
                            controle.confirmaRegistroSaida(objItemSaida);
                            // Atualiza tabela de ITENSTRANSFERENCIA
                            objItensTrans.setConfirmaSaida(confirmaRegSaida);
                            objItensTrans.setIdItemCrcPortaria(idItemCrcPort); // Item da tabela ITENSTRANSFERENCIA 
                            controle.confirmaRegistroTransferencia(objItensTrans);
                            // Atualiza o Rol para ABERTO quando usuario exclui o interno
                            atualizarRolSaidaInternoExcluir();
                            // Falta atualizar o MOVIMENTOCRC, ou seja não tá excluindo (04/06/2015)
                            // Confirma "Sim" na tabela ITENSSAIDA para impedir a exclusão ou alteração do interno
                            confirmaRegSaida = "Não";
                            objItemSaida.setIdInternoSaida(Integer.valueOf(jIDInterno.getText()));
                            objItemSaida.setIdItemSaida(idSaidaTmp); // Item do documento de saida (ITENSSAIDA) 
                            objItemSaida.setConfirmaSaida(confirmaRegSaida);
                            objItemSaida.setHorarioSaida(jHorarioSaida.getText());
                            controle.confirmaRegistroSaida(objItemSaida); // Modifica na tabela ITENSSAIDA (confirma a saida) do interno e horário para CRC                                             
                            //
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            preencherTabelaItens("SELECT * FROM ITENSREGSAIDA "
                                    + "INNER JOIN PRONTUARIOSCRC "
                                    + "ON ITENSREGSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                    + "WHERE IdSaida='" + jIDlanc.getText() + "'");
                            JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                            ExcluirItem();
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirItemActionPerformed

    private void jBtSalvarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarItemActionPerformed
        // TODO add your handling code here:     
        buscarAcessoUsuario(telaRegistroSaidaInternoIntP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroSaidaInternoIntP1) && codGravarP1 == 1) {
            confirmaRegSaida = "Sim"; // Variavel que confirma a saida do interno na portaria.                   
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
                        if (jHorarioSaida.getText().equals("")) {
                            JOptionPane.showMessageDialog(rootPane, "Informe o horario de saida do interno.");
                            jHorarioSaida.requestFocus();
                        } else {
                            verificarDocumentos(); // Verificar se o interno tem pendências de documento  
                            if (rgInterno.equals("Sim")) {
                                JOptionPane.showMessageDialog(rootPane, "Interno tem pendência de RG");
                            } else {
                                if (cpfInterno.equals("Sim")) {
                                    JOptionPane.showMessageDialog(rootPane, "Interno tem pendência de CPF");
                                } else {
                                    if (cnhInterno.equals("Sim")) {
                                        JOptionPane.showMessageDialog(rootPane, "Interno tem pendência de CNH");
                                    } else {
                                        if (tituloInterno.equals("Sim")) {
                                            JOptionPane.showMessageDialog(rootPane, "Interno tem pendência de TITULO DE ELEITOR");
                                        } else {
                                            if (outrosDocInterno.equals("Sim")) {
                                                JOptionPane.showMessageDialog(rootPane, "Interno tem pendência de OUTROS DOCUMENTOS");
                                            } else {
                                                if (reservistaInterno.equals("Sim")) {
                                                    JOptionPane.showMessageDialog(rootPane, "Interno tem pendência de CARTEIRA DE RESERVISTA");
                                                } else {
                                                    if (ctpsInterno.equals("Sim")) {
                                                        JOptionPane.showMessageDialog(rootPane, "Interno tem pendência de CTPS");
                                                    } else {
                                                        if (certidaoNascInterno.equals("Sim")) {
                                                            JOptionPane.showMessageDialog(rootPane, "Interno tem pendência de CERTIDÃO DE NASCIMENTO");
                                                        } else {
                                                            if (certidaoCasaInterno.equals("Sim")) {
                                                                JOptionPane.showMessageDialog(rootPane, "Interno tem pendência de CERTIDÃO DE CASAMENTO");
                                                            } else {
                                                                if (jTipoSaida.getText().equals("TRANSFERENCIA") && jComboBoxUnidadeDestino.getSelectedItem().equals("Selecione...")) {
                                                                    JOptionPane.showMessageDialog(rootPane, "É necessário informar o destino desse interno.");
                                                                } else {
                                                                    verificarValores();
                                                                    if (valorTotal != 0) {
                                                                        JOptionPane.showMessageDialog(rootPane, "Interno tem pendências financeira, solicite que o mesmo\ndirija-se ao setor finaceiro para resolver. Valor R$ " + valorTotal);
                                                                        valorTotalCredito = 0;
                                                                        valorTotalDebito = 0;
                                                                        valorTotal = 0;
                                                                    } else {
                                                                        objItemSaida.setIdInternoSaida(Integer.valueOf(jIDInterno.getText()));
                                                                        objItemSaida.setNomeInterno(jNomeInterno.getText());
                                                                        objItemSaida.setDataSaida(jDataSaida.getDate());
                                                                        objItemSaida.setDocumento(jNrDocumento.getText());
                                                                        objItemSaida.setNomeDestino(jTipoSaida.getText());
                                                                        objItemSaida.setLocaSaida((String) jComboBoxUnidadeDestino.getSelectedItem());
                                                                        objItemSaida.setHorarioSaida(jHorarioSaida.getText());
                                                                        //
                                                                        objItemSaida.setIdItemRegSaida(idItemSaida); // Iditem da tabela de ITENSSAIDA
                                                                        // Para o log do registro
                                                                        objItemSaida.setUsuarioInsert(nameUser);
                                                                        objItemSaida.setDataInsert(dataModFinal);
                                                                        objItemSaida.setHoraInsert(horaMov);
                                                                        if (acao == 3) {
                                                                            objItemSaida.setConfirmaSaida(confirmaRegSaida);
                                                                            objItemSaida.setIdSaida((Integer.valueOf(jIDlanc.getText())));
                                                                            objItemSaida.setIdItemCrcPortaria(idItemCrcPort); // Item da tabela ITENSCRCPORTARIA                                                                                                                                        
                                                                            controle.incluirItensRegSaida(objItemSaida); // Gravar registro na tabela de itens ITENSREGSAIDA (PORTARIA INTERNA)                                                                                                            
                                                                            // VERIFICAR O REGISTRO NA TABELA (ITENSREGSAIDA) 
                                                                            // DA PORTARIA PARA SABER SE REALMENTE FOI GRAVADO 
                                                                            // PARA RETIRAR O ERRO DE FICAR DESAPARECENDO O O REGISTRO NA TABELA ITENSREGSAIDA(22/11/2017) - CORREÇÃO
                                                                            confirmarSaidaPortaria();
                                                                            if (!jIDInterno.getText().equals(idInternoSaida) && !jIDlanc.getText().equals(idLancSaida)) {
                                                                                JOptionPane.showMessageDialog(rootPane, "Um ERRO desconhecido na tabela (ITENSREGSAIDA), não foi possível incluir o registro, tente novamente...");
                                                                            } else {
                                                                                objItemSaida.setIdItemSaida(idItemSaida); // Item do documento de saida (ITENSSAIDA)                                                                  
                                                                                // Confirma "Sim" na tabela ITENSSAIDA para impedir a exclusão ou alteração do interno  
                                                                                objItemSaida.setIdInternoSaida(Integer.valueOf(jIDInterno.getText()));
                                                                                objItemSaida.setConfirmaSaida(confirmaRegSaida);
                                                                                objItemSaida.setHorarioSaida(jHorarioSaida.getText());
                                                                                controle.confirmaRegistroSaida(objItemSaida); // Modifica na tabela ITENSSAIDA (confirma a saida) do interno e horário para CRC                                                             
                                                                                // Confirma "Sim" no arquivo intermediario ITENSCRCPORTARIA para não pesquisar novamente o interno
                                                                                objItemSaida.setIdItemCrcPortaria(idItemCrcPort); // Item da tabela ITENSCRCPORTARIA
                                                                                objItemSaida.setIdItemSaida(idItemSaida); // Item referente a saída vinda do CRC para Portaria
                                                                                objItemSaida.setIdInternoSaida(Integer.valueOf(jIDInterno.getText())); // Id do interno - São 3 variaveis
                                                                                controle.confirmaRegSaidaItensCrcPort(objItemSaida); // CONFIRMA COM "Sim" PARA A PORTARIA NÃO FAZER SAIDA EM DUPLICIDADE
                                                                                // Confirmar "Sim" na tabela de ITENSTRANSFERENCIA para para impedir exclusão ou alterarção do interno
                                                                                objItensTrans.setIdItemTrans(idItemCrcPort); // Item do documento de saida (ITENSSAIDA)
                                                                                objItensTrans.setConfirmaSaida(confirmaRegSaida);;
                                                                                controle.confirmaRegistroTransferencia(objItensTrans); // Tabela ITENSTRANSFERENCIA - (SAIDA POR TRANSFERENCIA)
                                                                                // Bloquear interno no Rol (FINALIZAR)
                                                                                objItemSaida.setIdSaida((Integer.valueOf(jIDlanc.getText())));
                                                                                atualizarRolSaidaInterno();
                                                                                //Atualiza como "Sim" a utilização do interno na previsão de saida campo "ConfirmaUtilizacao" tabela ITENSPREVSAIDA
                                                                                objItensPreSaida.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                                                objItensPreSaida.setBeneficio(jTipoSaida.getText());
                                                                                objItensPreSaida.setConfirmaSaida(confirmaRegSaida);
                                                                                controlePrevSaida.atualizaConfirmacaoSaidaPortaria(objItensPreSaida); // Tabela ITENSPREVISAOSAIDA
                                                                                objProCrc.setIdInterno(Integer.valueOf(jIDInterno.getText()));
                                                                                objItensPreSaida.setBeneficio(jTipoSaida.getText());
                                                                                // Se a saida não for para AUDIENCIA, SAIDA PARA MÉDICO E OUTRAS SAIDAS, excluir da cela CONSERTADO EM 07/08/2015
                                                                                // SAIDA TEMPORARIA TAMBÉM NÃO RETIRAR DA CELA. SÓ RETIRAR APÓS O PRAZO DE VENCIDO, NA EVASÃO - 08/07/2016 
                                                                                verificarInternoCela(); // 
                                                                                if (!jTipoSaida.getText().equals(saidaAudiencia) && !jTipoSaida.getText().equals(saidaMedico) && !jTipoSaida.getText().equals(saidaOutras) && !jTipoSaida.getText().equals(saidaTemporaria) && !jTipoSaida.getText().equals(pPRISAO_DOMICILIAR_COVID)) {
                                                                                    // RETIRAR DA POPULAÇÃO, MODIFICADO EM 11/07/2016
                                                                                    objProCrc.setIdInterno(Integer.valueOf(jIDInterno.getText()));
                                                                                    objProCrc.setSituacao(jTipoSaida.getText());
                                                                                    mod.alterarSituacaoInterno(objProCrc);
                                                                                    // EXCLUIR O INTERNO DA CELA NO MOMENTO DA SAIDA NA PORTARIA.
                                                                                    objItensLoca.setIdInternoCrc(Integer.valueOf(jIDInterno.getText()));
                                                                                    excluirInternoCela.deletarInternoLocacaoSaida(objItensLoca);
                                                                                }
                                                                                // SE FOR SAIDA TEMPORARIA, MODIFICAR "SituacaoCrc" E NÃO RETIRAR DA CELA (09/08/2016)
                                                                                if (jTipoSaida.getText().equals(saidaTemporaria)) {
                                                                                    objProCrc.setIdInterno(Integer.valueOf(jIDInterno.getText()));
                                                                                    objProCrc.setSituacao(jTipoSaida.getText());
                                                                                    mod.alterarSituacaoInterno(objProCrc);
                                                                                }
                                                                                // SE FOR SAIDA PRISAO DOMICILIAR HUMANITARIA COVID-19, MODIFICAR "SituacaoCrc" E NÃO RETIRAR DA CELA (23/03/2020)
                                                                                if (jTipoSaida.getText().equals(pPRISAO_DOMICILIAR_COVID)) {
                                                                                    objProCrc.setIdInterno(Integer.valueOf(jIDInterno.getText()));
                                                                                    objProCrc.setSituacao(jTipoSaida.getText());
                                                                                    mod.alterarSituacaoInterno(objProCrc);
                                                                                }
                                                                                objLog2();
                                                                                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                                                                                
                                                                                preencherTabelaItens("SELECT * FROM ITENSREGSAIDA "
                                                                                        + "INNER JOIN PRONTUARIOSCRC "
                                                                                        + "ON ITENSREGSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                                                                        + "WHERE IdSaida='" + jIDlanc.getText() + "'");
                                                                                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                                                                SalvarItem();
                                                                            }
                                                                        }
                                                                        // Alterar os Itens (INTERNOS NA PORTARIA)
                                                                        if (acao == 4) {
                                                                            // Para o log do registro
                                                                            objItemSaida.setUsuarioUp(nameUser);
                                                                            objItemSaida.setDataUp(jDataSistema.getText());
                                                                            objItemSaida.setHoraUp(jHoraSistema.getText());
                                                                            //
                                                                            objItemSaida.setIdSaida((Integer.valueOf(jIDlanc.getText())));
                                                                            objProCrc.setIdInterno(Integer.valueOf(jIDInterno.getText()));
                                                                            objItemSaida.setConfirmaSaida(confirmaRegSaida);
                                                                            objItemSaida.setIdItemRegSaida(idSaidaTmp); // Item da tabela ITENSCRCPORTARIA  
                                                                            objItemSaida.setIdItemSaida(idItem);
                                                                            controle.alterarItensRegSaida(objItemSaida);
                                                                            // Confirma "Sim" na tabela ITENSSAIDA para impedir a exclusão ou alteração do interno                                                                      
                                                                            objItemSaida.setIdInternoSaida(Integer.valueOf(jIDInterno.getText()));
                                                                            objItemSaida.setIdItemSaida(idSaidaTmp); // Item do documento de saida (ITENSSAIDA) 
                                                                            objItemSaida.setConfirmaSaida(confirmaRegSaida);
                                                                            objItemSaida.setHorarioSaida(jHorarioSaida.getText());
                                                                            controle.confirmaRegistroSaida(objItemSaida); // Modifica na tabela ITENSSAIDA (confirma a saida) do interno e horário para CRC                                             
                                                                            //
                                                                            preencherTabelaItens("SELECT * FROM ITENSREGSAIDA "
                                                                                    + "INNER JOIN PRONTUARIOSCRC "
                                                                                    + "ON ITENSREGSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                                                                    + "WHERE IdSaida='" + jIDlanc.getText() + "'");
                                                                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                                                                            SalvarItem();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
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

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGSAIDACRC "
                    + "WHERE IdSaida='" + jIDlanc.getText() + "'");
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
            jTabelaSaidaInterno.setVisible(true);
            this.preencherTodasEntradas();
        } else {
            jtotalRegistros.setText("");
            limparTabelaRegistroSaida();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jPesqNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário informar um nome ou parte do nome para pesquuisa.");
        } else {
            pesquisarSaidaInterno("SELECT * FROM  REGSAIDACRC "
                    + "INNER JOIN ITENSREGSAIDA "
                    + "ON REGSAIDACRC.IdSaida=ITENSREGSAIDA.IdSaida "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSREGSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtNomeInternoActionPerformed

    private void jBtAudiSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAudiSaidaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaRegistroSaidaInternosP1 objAudSaida = new TelaAuditoriaRegistroSaidaInternosP1();
        TelaModuloPortarias.jPainelPortarias.add(objAudSaida);
        objAudSaida.show();
    }//GEN-LAST:event_jBtAudiSaidaActionPerformed

    private void jBtItensAudiSaidaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtItensAudiSaidaInternosActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensRegistroSaidasInternos objItensAudiRegSaida = new TelaAuditoriaItensRegistroSaidasInternos();
        TelaModuloPortarias.jPainelPortarias.add(objItensAudiRegSaida);
        objItensAudiRegSaida.show();
    }//GEN-LAST:event_jBtItensAudiSaidaInternosActionPerformed

    private void jBtZoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtZoonActionPerformed
        // TODO add your handling code here:
        mostraFotoPortaria();
    }//GEN-LAST:event_jBtZoonActionPerformed

    private void jBtBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBiometriaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroSaidaInternoBioP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroSaidaInternoBioP1) && codAbrirP1 == 1) {
            if (jStatusSaida.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível utilizar essa funcionalidade, o registro já foi finalizado");
            } else {
                mostrarBiometriaMov();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtBiometriaActionPerformed

    private void jBtExportarRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExportarRegistrosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroSaidaInternoExpP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaRegistroSaidaInternoExpP1) && codAbrirP1 == 1) {
            if (jStatusSaida.getText().equals("ABERTO")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário FINALIZAR o documento para poder exportar os registros de internos.");
            } else {
                mostrarImportarInternos();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExportarRegistrosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel FotoInternoCrcSaida;
    private javax.swing.JButton jBtAlterarItem;
    private javax.swing.JButton jBtAlterarlanc;
    private javax.swing.JButton jBtAudiSaida;
    private javax.swing.JButton jBtBiometria;
    private javax.swing.JButton jBtCancelarItem;
    private javax.swing.JButton jBtCancelarlanc;
    private javax.swing.JButton jBtDataLanc;
    private javax.swing.JButton jBtExcluirItem;
    private javax.swing.JButton jBtExcluirlanc;
    private javax.swing.JButton jBtExportarRegistros;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtIdLanc;
    private javax.swing.JButton jBtItensAudiSaidaInternos;
    private javax.swing.JButton jBtNomeInterno;
    private javax.swing.JButton jBtNovoItem;
    private javax.swing.JButton jBtNovolanc;
    private javax.swing.JButton jBtPesInterno;
    private javax.swing.JButton jBtSairItens;
    private javax.swing.JButton jBtSalvarItem;
    private javax.swing.JButton jBtSalvarlanc;
    public static javax.swing.JButton jBtZoon;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JComboBox<String> jComboBoxUnidadeDestino;
    private com.toedter.calendar.JDateChooser jDataLancamento;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static com.toedter.calendar.JDateChooser jDataSaida;
    private javax.swing.JFormattedTextField jHorarioSaida;
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
    private javax.swing.JTextArea jObservacao;
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
    public static javax.swing.JTextField jStatusSaida;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable jTabelaItensInterno;
    private javax.swing.JTable jTabelaSaidaInterno;
    public static javax.swing.JTextField jTipoSaida;
    private javax.swing.JLabel jtotalRegistros;
    public static javax.swing.JLabel totalRegistrosInternos;
    // End of variables declaration//GEN-END:variables

    public void preencherComboBoxGrupo() {
//        jComboBoxUnidadeDestino.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM UNIDADE");
            conecta.rs.first();
            do {
                jComboBoxUnidadeDestino.addItem(conecta.rs.getString("DescricaoUnid"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void confirmarSaidaPortaria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSREGSAIDA "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "' "
                    + "AND IdSaida='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            idInternoSaida = conecta.rs.getString("IdInternoCrc");
            idLancSaida = conecta.rs.getString("IdSaida");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void formatarCampos() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
        jTipoSaida.setDocument(new LimiteDigitosAlfa(100));
        jNrDocumento.setDocument(new LimiteDigitosAlfa(16));
        try {
            MaskFormatter horario = new MaskFormatter("##:##");
            jHorarioSaida.setFormatterFactory(new DefaultFormatterFactory(horario));
        } catch (ParseException ex) {
        }
    }

    public void bloquearCamposPesquisa() {
        jDataLancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(true);
        jBtExcluirlanc.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtNovoItem.setEnabled(true);
        jBtAudiSaida.setEnabled(true);
        jBtBiometria.setEnabled(true);
        //
        jDataSaida.setDate(null);
        jIDInterno.setText("");
        jNomeInterno.setText("");
        FotoInternoCrcSaida.setIcon(null);
        jTipoSaida.setText("");
        jNrDocumento.setText("");
        jHorarioSaida.setText("");
        //
        jDataSaida.setEnabled(!true);
        jIDInterno.setEnabled(!true);
        jNomeInterno.setEnabled(!true);
        jTipoSaida.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(true);
        jBtExcluirItem.setEnabled(true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(true);
        jBtItensAudiSaidaInternos.setEnabled(true);
        jBtPesInterno.setEnabled(!true);
        jBtZoon.setEnabled(!true);
    }

    public void corCampos() {
        jIDlanc.setBackground(Color.white);
        jStatusSaida.setBackground(Color.white);
        jDataLancamento.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jIDInterno.setBackground(Color.white);
        jDataSaida.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jTipoSaida.setBackground(Color.white);
        jNrDocumento.setBackground(Color.white);
        jHorarioSaida.setBackground(Color.white);

    }

    public void Novo() {
        totalRegistrosInternos.setText("");
        // Limpar os campos para inclusão
        jIDlanc.setText("");
        jStatusSaida.setText("ABERTO");
        jDataLancamento.setCalendar(Calendar.getInstance());
        jObservacao.setText("");
        // Habilitar campos para inclusãoi
        jDataLancamento.setEnabled(true);
        jObservacao.setEnabled(true);
        jBtNovolanc.setEnabled(!true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(true);
        jBtCancelarlanc.setEnabled(true);
        // Habilitar os campos para inclusão/alteração
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtPesInterno.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        jBtBiometria.setEnabled(!true);
        //
        limparTabelaItens();
        jIDInterno.setText("");
        FotoInternoCrcSaida.setIcon(null);
        jDataSaida.setDate(null);
        jNomeInterno.setText("");
        jTipoSaida.setText("");
        jNrDocumento.setText("");
        //
        jDataSaida.setEnabled(!true);
        jTipoSaida.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
    }

    public void Alterar() {

        jDataLancamento.setEnabled(true);
        jObservacao.setEnabled(true);
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
        jBtBiometria.setEnabled(!true);
        jBtPesInterno.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jTipoSaida.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
    }

    public void Excluir() {

        // Limpar os campos para inclusão
        jDataLancamento.setDate(null);
        jIDlanc.setText("");
        jObservacao.setText("");
        jTabelaItensInterno.setVisible(!true); // Limpar a tabela de itens
    }

    public void Salvar() {

        jDataLancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(true);
        jBtExcluirlanc.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        //
        jBtNovoItem.setEnabled(true);
        jBtBiometria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    public void Cancelar() {

        jDataLancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
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
            control.finalizarRegSaidaInternos(objSaida);
            jStatusSaida.setText(statusMov);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            jStatusSaida.setText(statusSaida);
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            jObservacao.setEnabled(!true);
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
        jIDInterno.setText("");
        jNomeInterno.setText("");
        FotoInternoCrcSaida.setIcon(null);
        jTipoSaida.setText("");
        jNrDocumento.setText("");
        jHorarioSaida.setText(jHoraSistema.getText());
        // Habilitar os campos para inclusão/alteração
        jBtNovoItem.setEnabled(!true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(true);
        jBtCancelarItem.setEnabled(true);
        jBtPesInterno.setEnabled(true);
        jBtZoon.setEnabled(!true);
        jDataSaida.setEnabled(true);
        jTipoSaida.setEnabled(!true);
        jNrDocumento.setEnabled(true);
        jHorarioSaida.setEnabled(true);
        jTabelaItensInterno.setEnabled(true);
        //       
        jDataLancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovolanc.setEnabled(!true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        if (jTipoSaida.getText().equals("TRANSFERENCIA")) {
            jComboBoxUnidadeDestino.setEnabled(true);
            preencherComboBoxGrupo();
        } else {
            jComboBoxUnidadeDestino.setEnabled(!true);
        }
    }

    public void AlterarItem() {

//        if (idSaidaTmp == null || idSaidaTmp.equals("")) {
        if (assinaturaDigital != null) {
            JOptionPane.showMessageDialog(rootPane, "Não é possivel fazer alterações nesse registro, registro efetuado por biometria.");
        } else {
            jBtNovoItem.setEnabled(!true);
            jBtAlterarItem.setEnabled(!true);
            jBtExcluirItem.setEnabled(!true);
            jBtSalvarItem.setEnabled(true);
            jBtCancelarItem.setEnabled(true);
            jBtPesInterno.setEnabled(!true);
            jBtZoon.setEnabled(true);
            jDataSaida.setEnabled(true);
            jTipoSaida.setEnabled(!true);
            jNrDocumento.setEnabled(true);
            jHorarioSaida.setEnabled(true);
            //
            jDataLancamento.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovolanc.setEnabled(!true);
            jBtAlterarlanc.setEnabled(!true);
            jBtExcluirlanc.setEnabled(!true);
            jBtSalvarlanc.setEnabled(!true);
            jBtCancelarlanc.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
        }
        if (jTipoSaida.getText().equals("TRANSFERENCIA")) {
            jComboBoxUnidadeDestino.setEnabled(true);
            preencherComboBoxGrupo();
        } else {
            jComboBoxUnidadeDestino.setEnabled(!true);
        }
    }

    public void ExcluirItem() {

        jIDInterno.setText("");
        jNomeInterno.setText("");
        jDataSaida.setDate(null);
        FotoInternoCrcSaida.setIcon(null);
        jTipoSaida.setText("");
        jNrDocumento.setText("");
        jHorarioSaida.setText("");
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtPesInterno.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jTipoSaida.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        //       
        jDataLancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovolanc.setEnabled(!true);
        jBtAlterarlanc.setEnabled(!true);
        jBtExcluirlanc.setEnabled(!true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jComboBoxUnidadeDestino.setEnabled(!true);
    }

    public void SalvarItem() {

        //
        jIDInterno.setText("");
        jNomeInterno.setText("");
        jDataSaida.setDate(null);
        FotoInternoCrcSaida.setIcon(null);
        jTipoSaida.setText("");
        jNrDocumento.setText("");
        jHorarioSaida.setText("");
        //
        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(!true);
        jBtExcluirItem.setEnabled(!true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtBiometria.setEnabled(true);
        jBtPesInterno.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jTipoSaida.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        //       
        jDataLancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(true);
        jBtExcluirlanc.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jTabelaItensInterno.setVisible(true);
        jComboBoxUnidadeDestino.setEnabled(!true);
    }

    public void CancelarItem() {

        jBtNovoItem.setEnabled(true);
        jBtAlterarItem.setEnabled(true);
        jBtExcluirItem.setEnabled(true);
        jBtSalvarItem.setEnabled(!true);
        jBtCancelarItem.setEnabled(!true);
        jBtBiometria.setEnabled(true);
        jBtPesInterno.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        jDataSaida.setEnabled(!true);
        jTipoSaida.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
        jHorarioSaida.setEnabled(!true);
        //       
        jDataLancamento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovolanc.setEnabled(true);
        jBtAlterarlanc.setEnabled(true);
        jBtExcluirlanc.setEnabled(true);
        jBtSalvarlanc.setEnabled(!true);
        jBtCancelarlanc.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jComboBoxUnidadeDestino.setEnabled(!true);
    }

    //Buscar código de Saída
    public void buscarCodSaida() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGSAIDACRC");
            conecta.rs.last();
            codSai = conecta.rs.getInt("IdSaida");
            jIDlanc.setText(String.valueOf(conecta.rs.getInt("IdSaida")));
            objSaida.setIdSaida(Integer.valueOf(jIDlanc.getText()));
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar LANÇAMENTO DE SAIDA \nERRO: " + ex);
        }
    }

    public void verificarAssiaturaBiometricaInterno() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSREGSAIDA "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "' "
                    + "AND IdSaida='" + jIDlanc.getText() + "'");
            conecta.rs.first();
            codigoSaidaBio = conecta.rs.getString("IdSaida");
            codigoSaidaInterno = conecta.rs.getString("IdInternoCrc");
            pAssinaturaInterno = conecta.rs.getBytes("AssinaturaSaida");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherTodasEntradas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGSAIDACRC");
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
                dados.add(new Object[]{conecta.rs.getInt("IdSaida"), dataLancaMov, conecta.rs.getString("StatusSai"), conecta.rs.getString("ObsSaida")});
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
        jTabelaSaidaInterno.getColumnModel().getColumn(3).setPreferredWidth(520);
        jTabelaSaidaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaSaidaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaSaidaInterno.setAutoResizeMode(jTabelaSaidaInterno.AUTO_RESIZE_OFF);
        jTabelaSaidaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaSaidaInternos();
        conecta.desconecta();
    }

    public void limparTabelaRegistroSaida() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaSaidaInterno.setModel(modelo);
        jTabelaSaidaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaSaidaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaSaidaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaSaidaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaSaidaInterno.getColumnModel().getColumn(3).setPreferredWidth(520);
        jTabelaSaidaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaSaidaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaSaidaInterno.setAutoResizeMode(jTabelaSaidaInterno.AUTO_RESIZE_OFF);
        jTabelaSaidaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void pesquisarSaidaInterno(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
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
                dados.add(new Object[]{conecta.rs.getInt("IdSaida"), dataBrasil, conecta.rs.getString("StatusSai"), conecta.rs.getString("NomeInternoCrc")});
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
        jTabelaSaidaInterno.getColumnModel().getColumn(3).setPreferredWidth(400);
        jTabelaSaidaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaSaidaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaSaidaInterno.setAutoResizeMode(jTabelaSaidaInterno.AUTO_RESIZE_OFF);
        jTabelaSaidaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaSaidaInternos();
        conecta.desconecta();
    }
// Pesquisa de Lançamento por Código (ID)

    public void pesquisarLancCod(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
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
                dados.add(new Object[]{conecta.rs.getInt("IdSaida"), dataLancaMov, conecta.rs.getString("StatusSai"), conecta.rs.getString("ObsSaida")});
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
        jTabelaSaidaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaSaidaInterno.setAutoResizeMode(jTabelaSaidaInterno.AUTO_RESIZE_OFF);
        jTabelaSaidaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaSaidaInternos();
        conecta.desconecta();
    }

    public void alinharCamposTabelaSaidaInternos() {
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

    // Verificar se existe itens na saida do interno
    public void verificarItens() {
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSREGSAIDA "
                    + "WHERE IdSaida='" + jIDlanc.getText() + "'");
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
                control.excluirRegSaidaInternos(objSaida);
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

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Seq.", "Nome do Interno ", "Data Saida", "Destino", "Documento "};
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

    // Verificar se o interno tem pendências de documentos e financeiras
    public void verificarDocumentos() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            docAudiencia = conecta.rs.getString("DocAudiencia");
            docTransferencia = conecta.rs.getString("DocTrans");
            docSaidaTmp = conecta.rs.getString("DocSaidaTmp");
            docLivraPro = conecta.rs.getString("DocLivraPro");
            docPro = conecta.rs.getString("DocPro");
            docAlvara = conecta.rs.getString("DocAlvara");
        } catch (Exception e) {
        }
        conecta.desconecta();
        if (jTipoSaida.getText().equals("SAIDA TEMPORARIA") && docSaidaTmp.equals("Sim")
                || jTipoSaida.getText().equals("SAIDA AUDIENCIA") && docAudiencia.equals("Sim")
                || jTipoSaida.getText().equals("LIVRAMENTO CONDICIONAL") && docLivraPro.equals("Sim")
                || jTipoSaida.getText().equals("PROGRESSAO DE REGIME") && docPro.equals("Sim")
                || jTipoSaida.getText().equals("TRANSFERENCIA") && docTransferencia.equals("Sim")
                || jTipoSaida.getText().equals("SAIDA ALVARA") && docAlvara.equals("Sim")) {
            objDocInternos.setRgDoc(rgInterno);
            objDocInternos.setCpfDoc(cpfInterno);
            objDocInternos.setCnhDoc(cnhInterno);
            objDocInternos.setTituloDoc(tituloInterno);
            objDocInternos.setOutrosDoc(outrosDocInterno);
            objDocInternos.setReservistaDoc(reservistaInterno);
            objDocInternos.setCtpsDoc(ctpsInterno);
            objDocInternos.setcNascimentoDoc(certidaoNascInterno);
            objDocInternos.setcCasamentoDoc(certidaoCasaInterno);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM DOCINTERNOS "
                        + "WHERE IdInternoCrc='" + jIDInterno.getText() + "'");
                conecta.rs.first();
                rgInterno = conecta.rs.getString("RgDoc");
                cpfInterno = conecta.rs.getString("CpfDoc");
                cnhInterno = conecta.rs.getString("CnhDoc");
                tituloInterno = conecta.rs.getString("TituloDoc");
                outrosDocInterno = conecta.rs.getString("OutrosDoc");
                reservistaInterno = conecta.rs.getString("ReservistaDoc");
                ctpsInterno = conecta.rs.getString("CtpsDoc");
                certidaoNascInterno = conecta.rs.getString("CNascimentoDoc");
                certidaoCasaInterno = conecta.rs.getString("CCasamentoDoc");
            } catch (SQLException ex) {
            }
            conecta.desconecta();
        }
    }

    public void verificarValores() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            valAudiencia = conecta.rs.getString("ValAudiencia");
            valTransferencia = conecta.rs.getString("ValTrans");
            valSaidaTmp = conecta.rs.getString("ValSaidaTmp");
            valLivraPro = conecta.rs.getString("ValLivraPro");
            valPro = conecta.rs.getString("ValPro");
            valAlvara = conecta.rs.getString("ValAlvara");
        } catch (Exception e) {
        }
        conecta.desconecta();
        if (jTipoSaida.getText().equals("SAIDA TEMPORARIA") && valSaidaTmp.equals("Sim")
                || jTipoSaida.getText().equals("SAIDA AUDIENCIA") && valAudiencia.equals("Sim")
                || jTipoSaida.getText().equals("LIVRAMENTO CONDICIONAL") && valLivraPro.equals("Sim")
                || jTipoSaida.getText().equals("PROGRESSAO DE REGIME") && valPro.equals("Sim")
                || jTipoSaida.getText().equals("TRANSFERENCIA") && valTransferencia.equals("Sim")
                || jTipoSaida.getText().equals("SAIDA ALVARA") && valAlvara.equals("Sim")) {
            // Verifica o CRÉDITO do interno para deduzir do debito. Se o valor for zero permite sair
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM SALDOVALORES "
                        + "WHERE IdInternoCrc='" + jIDInterno.getText() + "' "
                        + "AND StatusMov='" + campoCredito + "'");
                conecta.rs.first();
                do {
                    valorCredito = conecta.rs.getFloat("ValorMov");
                    valorTotalCredito = valorTotalCredito + valorCredito;
                } while (conecta.rs.next());
                conecta.desconecta();
            } catch (SQLException ex) {
            }
            conecta.abrirConexao();
            //Verifica o DÉBITO do interno para deduzir do debito. Se o valor for zero permite sair
            try {
                conecta.executaSQL("SELECT * FROM SALDOVALORES "
                        + "WHERE IdInternoCrc='" + jIDInterno.getText() + "' "
                        + "AND StatusMov='" + campoDebito + "'");
                conecta.rs.first();
                do {
                    valorDebito = conecta.rs.getFloat("ValorMov");
                    valorTotalDebito = valorTotalDebito + valorDebito;
                } while (conecta.rs.next());
                valorTotal = valorTotalCredito - valorTotalDebito;
            } catch (SQLException ex) {
            }
            conecta.desconecta();
        }
    }

    // FINALIZA o Rol do interno quando o mesmo sair da unidade
    public void atualizarRolSaidaInterno() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ROLVISITAS "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "' "
                    + "AND StatusRol='" + statusRol + "'");
            conecta.rs.first();
            idInternoRol = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
        }
        statusRol = "FINALIZADO";
        objRol.setIdInterno(Integer.valueOf(jIDInterno.getText()));
        objRol.setStatusRol(statusRol);
        objRol.setObsRol(jTipoSaida.getText());
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
            conecta.executaSQL("SELECT * FROM ROLVISITAS "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "' "
                    + "AND StatusRol='" + statusRolFechado + "'");
            conecta.rs.first();
            idInternoRol = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
        }
        statusRol = "ABERTO";
        objRol.setIdInterno(Integer.valueOf(jIDInterno.getText()));
        objRol.setStatusRol(statusRol);
        objRol.setObsRol("");
        objRol.setUsuarioUp(nameUser);
        objRol.setDataUp(jDataSistema.getText());
        objRol.setHoraUp(horaMov);
        controlRol.finalizarRolVisitasPortaria(objRol);
        conecta.desconecta();
    }

    // Método para verificar se o interno existe  na cela.
    public void verificarInternoCela() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSLOCACAOINTERNO "
                    + "WHERE IdInternoCrc='" + jIDInterno.getText() + "'");
            conecta.rs.first();
            codInternoCela = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
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
    //conecta.executaSQL("SELECT SUM(ValorMov) AS '" + valorTotal + "'FROM SALDOVALORES WHERE (IdInternoCrc='" + jIDInterno.getText() + "'AND StatusMov='" + campoCredito + "')");
//conecta.executaSQL("SELECT SUM(ValorMov) AS ValorMov FROM SALDOVALORES WHERE (IdInternoCrc='" + jIDInterno.getText() + "'AND StatusMov='" + campoCredito + "')");
}
