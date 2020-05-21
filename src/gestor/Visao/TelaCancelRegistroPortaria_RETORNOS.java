/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Controle.ControleEntradasSaidasPopulacaoInternos;
import gestor.Controle.ControleItensEntradaPortaria_RETORNOS;
import gestor.Controle.ControleItensRegistroCanceladoCrc_RETORNOS;
import gestor.Controle.ControleRegCancelado_RETORNOS;
import gestor.Controle.ListagemRegistroEntradaSaidaPopulcao;
import gestor.Controle.ListagemUltimaPopulacaoCRC;
import gestor.Modelo.EntradaSaidasPolucaoInternos;
import gestor.Modelo.ItensEntradaInternosPortaria;
import gestor.Modelo.ItensRegistroCanceladoCrc;
import gestor.Modelo.LogSistema;
import gestor.Modelo.RegistroCanceladoCrc;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
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
import static gestor.Visao.TelaModuloCRC.telaCancelamentoRetornosInte_CRC;
import static gestor.Visao.TelaModuloCRC.telaCancelamentoRetornosManu_CRC;
import static gestor.Visao.TelaModuloPortarias.codAbrirP1;
import static gestor.Visao.TelaModuloPortarias.codAlterarP1;
import static gestor.Visao.TelaModuloPortarias.codConsultarP1;
import static gestor.Visao.TelaModuloPortarias.codExcluirP1;
import static gestor.Visao.TelaModuloPortarias.codGravarP1;
import static gestor.Visao.TelaModuloPortarias.codIncluirP1;
import static gestor.Visao.TelaModuloPortarias.codUserAcessoP1;
import static gestor.Visao.TelaModuloPortarias.codigoGrupoP1;
import static gestor.Visao.TelaModuloPortarias.codigoUserGroupP1;
import static gestor.Visao.TelaModuloPortarias.codigoUserP1;
import static gestor.Visao.TelaModuloPortarias.nomeGrupoP1;
import static gestor.Visao.TelaModuloPortarias.nomeTelaP1;
import static gestor.Visao.TelaModuloPortarias.telaCancelamentoRetornosInte_P1;
import static gestor.Visao.TelaModuloPortarias.telaCancelamentoRetornosManu_P1;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ronaldo
 */
public class TelaCancelRegistroPortaria_RETORNOS extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroCanceladoCrc objRecCancel = new RegistroCanceladoCrc();
    ItensRegistroCanceladoCrc objItensRecCancel = new ItensRegistroCanceladoCrc();
    ControleRegCancelado_RETORNOS control = new ControleRegCancelado_RETORNOS();
    ControleItensRegistroCanceladoCrc_RETORNOS controle = new ControleItensRegistroCanceladoCrc_RETORNOS();
    // Classe de origem do registro
    ItensEntradaInternosPortaria objItensEntIntPort = new ItensEntradaInternosPortaria();
    ControleItensEntradaPortaria_RETORNOS controleReg = new ControleItensEntradaPortaria_RETORNOS();
    //ADICIONAR A POPULAÇÃO NA TABELA ENTRADAS_SAIDAS_POPULACAO_INTERNOS (CONTROLE ALIMENTAÇÃO)
    ControleEntradasSaidasPopulacaoInternos populacao = new ControleEntradasSaidasPopulacaoInternos();
    EntradaSaidasPolucaoInternos objEntradaSaida = new EntradaSaidasPolucaoInternos();
    ListagemUltimaPopulacaoCRC listaUltimaPopulacao = new ListagemUltimaPopulacaoCRC();
    ListagemRegistroEntradaSaidaPopulcao listaRegistroES = new ListagemRegistroEntradaSaidaPopulcao();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "CRC:Cancelamento de Registro Retornos de Internos:Manutenção";
    String nomeModuloTela2 = "CRC:Cancelamento de Registro de Retornos de Internos:Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    String dataEntrada, datalanc;
    int acao;
    int flag;
    String confirmadoEntrada = "Não";
    String confirmaUtilizacao = "Sim";
    String dataInicial, dataFinal, dataSaida;
    String idItem;
    String codCancel;
    int count = 0;
    //POPULAÇÃO ALIMENTICIA
    String pTIPO_OPERCAO_ENTRADA = "Cancelado Retorno";
    public static String pREGISTRO_ENTRADA = "";
    int pPOPULCAO_ATUAL = 0;
    int pQUANTIDADE_ENTRADA_INTERNO = 1;
    int pID_ITEM_ALIMENTACAO = 0;
    String REGISTRO_CANCELADO = "REGISTRO CANCELADO PELO CRC";
    String pTIPO_RETORNO = "";
    String pID_INTERNO = "";
    int pID_RETORNO = 0;
    public static int pRETORNO_PORTARIA = 0;
    int pID_ITEM = 0;

    /**
     * Creates new form TelaCancelRegistroPortaria
     */
    public TelaCancelRegistroPortaria_RETORNOS() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jDataPesFinal = new com.toedter.calendar.JDateChooser();
        jCodigoPesq = new javax.swing.JTextField();
        jNomeInternoPesq = new javax.swing.JTextField();
        jBtPesqCodigo = new javax.swing.JButton();
        jBtPesqData = new javax.swing.JButton();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaPesqusaInterno = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdLanc = new javax.swing.JTextField();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jStatusLanc = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jMotivo = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaEntradaInternosPortaria = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jBtNovoInterno = new javax.swing.JButton();
        jBtAlterarInterno = new javax.swing.JButton();
        jBtExcluirInterno = new javax.swing.JButton();
        jBtSalvarInterno = new javax.swing.JButton();
        jBtCancelarInterno = new javax.swing.JButton();
        jBtAuditoriaInterno = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jIdInternoReg = new javax.swing.JTextField();
        jNomeInternoReg = new javax.swing.JTextField();
        jNrDocumento = new javax.swing.JTextField();
        jBtBuscarRegistroInterno = new javax.swing.JButton();
        jDataEntrada = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jHorario = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jBtExcluir = new javax.swing.JButton();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jBtImpressao = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("....::: Cancelamento Registro RETORNOS de Internos na Portaria :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Código:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Data Inicial:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Data Final:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Nome:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataPesFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jCodigoPesq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoPesq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jNomeInternoPesq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigo.setContentAreaFilled(false);
        jBtPesqCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoActionPerformed(evt);
            }
        });

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
            }
        });

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jCodigoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxTodos))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jNomeInternoPesq)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(83, 83, 83))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtPesqCodigo, jBtPesqData, jBtPesqNomeInterno});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(jCodigoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCodigo)
                    .addComponent(jCheckBoxTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jDataPesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel11)
                    .addComponent(jNomeInternoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeInterno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtPesqCodigo, jBtPesqData, jBtPesqNomeInterno});

        jTabelaPesqusaInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPesqusaInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Motivo"
            }
        ));
        jTabelaPesqusaInterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPesqusaInternoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaPesqusaInterno);
        if (jTabelaPesqusaInterno.getColumnModel().getColumnCount() > 0) {
            jTabelaPesqusaInterno.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaPesqusaInterno.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaPesqusaInterno.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaPesqusaInterno.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaPesqusaInterno.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaPesqusaInterno.getColumnModel().getColumn(2).setMaxWidth(70);
            jTabelaPesqusaInterno.getColumnModel().getColumn(3).setMinWidth(570);
            jTabelaPesqusaInterno.getColumnModel().getColumn(3).setMaxWidth(570);
        }

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 435, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel4);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data Registro");

        jIdLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLanc.setEnabled(false);

        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jStatusLanc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLanc.setForeground(new java.awt.Color(255, 0, 0));
        jStatusLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLanc.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Motivo");

        jMotivo.setColumns(20);
        jMotivo.setRows(5);
        jMotivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMotivo.setEnabled(false);
        jScrollPane2.setViewportView(jMotivo);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jStatusLanc)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        jTabelaEntradaInternosPortaria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEntradaInternosPortaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Nome do Interno", "Data Entrada", "Horário", "Nr. Doc."
            }
        ));
        jTabelaEntradaInternosPortaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEntradaInternosPortariaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaEntradaInternosPortaria);
        if (jTabelaEntradaInternosPortaria.getColumnModel().getColumnCount() > 0) {
            jTabelaEntradaInternosPortaria.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaEntradaInternosPortaria.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaEntradaInternosPortaria.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaEntradaInternosPortaria.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaEntradaInternosPortaria.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaEntradaInternosPortaria.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaEntradaInternosPortaria.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaEntradaInternosPortaria.getColumnModel().getColumn(3).setMaxWidth(80);
            jTabelaEntradaInternosPortaria.getColumnModel().getColumn(4).setMinWidth(50);
            jTabelaEntradaInternosPortaria.getColumnModel().getColumn(4).setMaxWidth(50);
            jTabelaEntradaInternosPortaria.getColumnModel().getColumn(5).setMinWidth(80);
            jTabelaEntradaInternosPortaria.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Botões", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jBtNovoInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoInterno.setToolTipText("Novo");
        jBtNovoInterno.setEnabled(false);
        jBtNovoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoInternoActionPerformed(evt);
            }
        });

        jBtAlterarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarInterno.setToolTipText("Alterar");
        jBtAlterarInterno.setEnabled(false);
        jBtAlterarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarInternoActionPerformed(evt);
            }
        });

        jBtExcluirInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirInterno.setToolTipText("Excluir");
        jBtExcluirInterno.setEnabled(false);
        jBtExcluirInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirInternoActionPerformed(evt);
            }
        });

        jBtSalvarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarInterno.setToolTipText("Gravar");
        jBtSalvarInterno.setEnabled(false);
        jBtSalvarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarInternoActionPerformed(evt);
            }
        });

        jBtCancelarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarInterno.setToolTipText("Cancelar");
        jBtCancelarInterno.setEnabled(false);
        jBtCancelarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarInternoActionPerformed(evt);
            }
        });

        jBtAuditoriaInterno.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoriaInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaInterno.setToolTipText("Auditoria");
        jBtAuditoriaInterno.setContentAreaFilled(false);
        jBtAuditoriaInterno.setEnabled(false);
        jBtAuditoriaInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jBtNovoInterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jBtAlterarInterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jBtExcluirInterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jBtSalvarInterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jBtCancelarInterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtAuditoriaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarInterno, jBtCancelarInterno, jBtExcluirInterno, jBtNovoInterno, jBtSalvarInterno});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtAuditoriaInterno)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarInterno, jBtCancelarInterno, jBtExcluirInterno, jBtNovoInterno, jBtSalvarInterno});

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados Interno Registrado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome do Interno");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nr. Doc.");

        jIdInternoReg.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoReg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoReg.setEnabled(false);

        jNomeInternoReg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoReg.setEnabled(false);

        jNrDocumento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNrDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNrDocumento.setEnabled(false);

        jBtBuscarRegistroInterno.setForeground(new java.awt.Color(0, 0, 255));
        jBtBuscarRegistroInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtBuscarRegistroInterno.setText("Busca");
        jBtBuscarRegistroInterno.setEnabled(false);
        jBtBuscarRegistroInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarRegistroInternoActionPerformed(evt);
            }
        });

        jDataEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrada.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Data Entrada");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Horário");

        jHorario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorario.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jNrDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(56, 56, 56))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jHorario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jBtBuscarRegistroInterno)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jIdInternoReg, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jNomeInternoReg)
                                .addContainerGap())))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeInternoReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdInternoReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNrDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtBuscarRegistroInterno))
                .addGap(4, 4, 4))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setToolTipText("Excluir");
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setToolTipText("Novo");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setToolTipText("Alterar");
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setToolTipText("Gravar");
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setToolTipText("Cancelar");
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtFinalizar.setForeground(new java.awt.Color(255, 0, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setToolTipText("Finalizar");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtAuditoria.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        jBtImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao.setToolTipText("Impressão");
        jBtImpressao.setEnabled(false);
        jBtImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setToolTipText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSair, jBtSalvar});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovo)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtSalvar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtSair)
                    .addComponent(jBtImpressao)
                    .addComponent(jBtAuditoria))
                .addGap(3, 3, 3))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSair, jBtSalvar});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(2, 2, 2)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 433, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(4, 4, 4))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBounds(250, 20, 475, 466);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jCodigoPesq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o código para pesquisa.");
        } else {
            preencherTabelaPesqRegCan("SELECT * FROM REGISTRO_CANCELADO_RETORNOS "
                    + "WHERE IdRegCancel='" + jCodigoPesq.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqCodigoActionPerformed

    private void jBtPesqDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataActionPerformed
        // TODO add your handling code here:
        count = 0;
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
                        preencherTabelaPesqRegCan("SELECT * FROM REGISTRO_CANCELADO_RETORNOS "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
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
                        preencherTabelaPesqRegCan("SELECT * FROM REGISTRO_CANCELADO_RETORNOS "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jNomeInternoPesq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o Nome para pesquisa.");
        } else {
            preencherTabelaPesqRegCanNome("SELECT * FROM REGISTRO_CANCELADO_RETORNOS "
                    + "INNER JOIN ITENS_REGISTRO_CANCELADO_NE "
                    + "ON REGISTRO_CANCELADO_RETORNOS.IdRegCancel=ITENS_REGISTRO_CANCELADO_RETORNOS.IdRegCancel "
                    + "WHERE NomeInternoCrc LIKE'%" + jNomeInternoPesq.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaPesqRegCan("SELECT * FROM REGISTRO_CANCELADO_RETORNOS");
        } else {
            jtotalRegistros.setText("");
            limparTabela();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:     
        buscarAcessoUsuario(telaCancelamentoRetornosManu_CRC);
        buscarAcessoUsuarioP1(telaCancelamentoRetornosManu_P1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCancelamentoRetornosManu_CRC) && codIncluirCRC == 1) {
            acao = 1;
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaCancelamentoRetornosManu_P1) && codIncluirP1 == 1) {
            acao = 1;
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCancelamentoRetornosManu_CRC);
        buscarAcessoUsuarioP1(telaCancelamentoRetornosManu_P1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCancelamentoRetornosManu_CRC) && codAlterarCRC == 1) {
            objRecCancel.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                Alterar();
                corCampos();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaCancelamentoRetornosManu_P1) && codAlterarP1 == 1) {
            objRecCancel.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
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
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCancelamentoRetornosManu_CRC);
        buscarAcessoUsuarioP1(telaCancelamentoRetornosManu_P1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCancelamentoRetornosManu_CRC) && codExcluirCRC == 1) {
            objRecCancel.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro de internos não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                verificarItens();
            }
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaCancelamentoRetornosManu_P1) && codExcluirP1 == 1) {
            objRecCancel.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro de internos não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                verificarItens();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCancelamentoRetornosManu_CRC);
        buscarAcessoUsuarioP1(telaCancelamentoRetornosManu_P1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCancelamentoRetornosManu_CRC) && codGravarCRC == 1) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do lançamento.");
                jDataLanc.requestFocus();
                jDataLanc.setBackground(Color.red);
            } else {
                if (jMotivo.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe o motivo do cancelamento da entrada do interno.");
                } else {
                    if (acao == 1) {
                        // Para o log do registro
                        objRecCancel.setUsuarioInsert(nameUser);
                        objRecCancel.setDataInsert(dataModFinal);
                        objRecCancel.setHorarioInsert(horaMov);
                        //
                        objRecCancel.setStatusLanc(jStatusLanc.getText());
                        objRecCancel.setDataLanc(jDataLanc.getDate());
                        objRecCancel.setMotivo(jMotivo.getText());
                        control.incluirRegCanceladoRE(objRecCancel);
                        buscarCodigo();
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                        Salvar();
                    }
                    if (acao == 2) {
                        // Para o log do registro
                        objRecCancel.setUsuarioUp(nameUser);
                        objRecCancel.setDataUp(dataModFinal);
                        objRecCancel.setHorarioUp(horaMov);
                        //
                        objRecCancel.setStatusLanc(jStatusLanc.getText());
                        objRecCancel.setDataLanc(jDataLanc.getDate());
                        objRecCancel.setMotivo(jMotivo.getText());
                        objRecCancel.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                        control.alterarRegCanceladoRE(objRecCancel);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                        Salvar();
                    }
                }
            }
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaCancelamentoRetornosManu_P1) && codGravarP1 == 1) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do lançamento.");
                jDataLanc.requestFocus();
                jDataLanc.setBackground(Color.red);
            } else {
                if (jMotivo.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe o motivo do cancelamento da entrada do interno.");
                } else {
                    if (acao == 1) {
                        // Para o log do registro
                        objRecCancel.setUsuarioInsert(nameUser);
                        objRecCancel.setDataInsert(dataModFinal);
                        objRecCancel.setHorarioInsert(horaMov);
                        //
                        objRecCancel.setStatusLanc(jStatusLanc.getText());
                        objRecCancel.setDataLanc(jDataLanc.getDate());
                        objRecCancel.setMotivo(jMotivo.getText());
                        control.incluirRegCanceladoRE(objRecCancel);
                        buscarCodigo();
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                        Salvar();
                    }
                    if (acao == 2) {
                        // Para o log do registro
                        objRecCancel.setUsuarioUp(nameUser);
                        objRecCancel.setDataUp(dataModFinal);
                        objRecCancel.setHorarioUp(horaMov);
                        //
                        objRecCancel.setStatusLanc(jStatusLanc.getText());
                        objRecCancel.setDataLanc(jDataLanc.getDate());
                        objRecCancel.setMotivo(jMotivo.getText());
                        objRecCancel.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                        control.alterarRegCanceladoRE(objRecCancel);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                        Salvar();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_CANCELADO_RETORNOS WHERE IdRegCancel='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
            } else {
                Finalizar();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar se lançamento foi finalizado\nERRO: " + ex);
        }
        conecta.desconecta();
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        if (TelaModuloCRC.jPainelCRC != null) {
            TelaAuditoriaCancelReg_RETORNOS objAudCancelReg = new TelaAuditoriaCancelReg_RETORNOS();
            TelaModuloCRC.jPainelCRC.add(objAudCancelReg);
            objAudCancelReg.show();
        } else if (TelaModuloPortarias.jPainelPortarias != null) {
            TelaAuditoriaCancelReg_RETORNOS objAudCancelReg = new TelaAuditoriaCancelReg_RETORNOS();
            TelaModuloPortarias.jPainelPortarias.add(objAudCancelReg);
            objAudCancelReg.show();
        }
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/PortariaInterna/RelatorioCancelamentoRetorno.jasper";
            conecta.executaSQL("SELECT * FROM REGISTRO_CANCELADO_NE "
                    + "WHERE IdRegCancel='" + jIdLanc.getText() + "' ");
            HashMap parametros = new HashMap();
            parametros.put("pCodigo", jIdLanc.getText());
            parametros.put("pUNIDADE", descricaoUnidade);
            parametros.put("pUSUARIO", nameUser);
            // Sub Relatório
            try {
                parametros.put("REPORT_CONNECTION", conecta.stmt.getConnection());
            } catch (SQLException ex) {
            }
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Cancelamento de Internos Nova Entrada");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jBtImpressaoActionPerformed

    private void jBtNovoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCancelamentoRetornosInte_CRC);
        buscarAcessoUsuarioP1(telaCancelamentoRetornosInte_P1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCancelamentoRetornosInte_CRC) && codIncluirCRC == 1) {
            objRecCancel.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro de internos não poderá ser incluído, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovoInterno();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaCancelamentoRetornosInte_P1) && codIncluirP1 == 1) {
            objRecCancel.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro de internos não poderá ser incluído, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovoInterno();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoInternoActionPerformed

    private void jBtAlterarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCancelamentoRetornosInte_CRC);
        buscarAcessoUsuarioP1(telaCancelamentoRetornosInte_P1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCancelamentoRetornosInte_CRC) && codAlterarCRC == 1) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível alterar o registro selecionado.");
//            objRecCancel.setStatusLanc(jStatusLanc.getText());
//            if (jStatusLanc.getText().equals("FINALIZADO")) {
//                JOptionPane.showMessageDialog(rootPane, "Esse registro de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
//            } else {
//                JOptionPane.showMessageDialog(rootPane, "Atenção, se exitir a necessidade de modificar o nome do interno,\n será necessário excluir o atual antes e lançar novamente o correto.\nDúvidas consulte o Administrador do sistema.");
//                acao = 4;
//                AlterarInterno();
//                statusMov = "Alterou";
//                horaMov = jHoraSistema.getText();
//                dataModFinal = jDataSistema.getText();
//            }
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaCancelamentoRetornosInte_P1) && codAlterarP1 == 1) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível alterar o registro selecionado.");
//            objRecCancel.setStatusLanc(jStatusLanc.getText());
//            if (jStatusLanc.getText().equals("FINALIZADO")) {
//                JOptionPane.showMessageDialog(rootPane, "Esse registro de internos não poderá ser alterado, o mesmo encontra-se FINALIZADO");
//            } else {
//                JOptionPane.showMessageDialog(rootPane, "Atenção, se exitir a necessidade de modificar o nome do interno,\n será necessário excluir o atual antes e lançar novamente o correto.\nDúvidas consulte o Administrador do sistema.");
//                acao = 4;
//                AlterarInterno();
//                statusMov = "Alterou";
//                horaMov = jHoraSistema.getText();
//                dataModFinal = jDataSistema.getText();
//            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarInternoActionPerformed

    private void jBtExcluirInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCancelamentoRetornosInte_CRC);
        buscarAcessoUsuarioP1(telaCancelamentoRetornosInte_P1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCancelamentoRetornosInte_CRC) && codExcluirCRC == 1) {
            objRecCancel.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro de internos não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não é possível excluir esse registro. Existe outras operações que depende do cancelamento realizado.");
//                confirmaUtilizacao = "Não";
//                statusMov = "Excluiu";
//                horaMov = jHoraSistema.getText();
//                dataModFinal = jDataSistema.getText();
//                objRecCancel.setStatusLanc(jStatusLanc.getText());
//                if (jStatusLanc.getText().equals("FINALIZADO")) {
//                    JOptionPane.showMessageDialog(rootPane, "Esse  interno não poderá ser excluído, o mesmo encontra-se FINALIZADO");
//                } else {
//                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o INTERNO selecionado?", "Confirmação",
//                            JOptionPane.YES_NO_OPTION);
//                    if (resposta == JOptionPane.YES_OPTION) {
//                        objItensRecCancel.setIdItem(Integer.valueOf(jIdInternoReg.getText()));
//                        objItensRecCancel.setNomeInternoCrc(jNomeInternoReg.getText());
//                        controle.excluirRegCanceladoNE(objItensRecCancel);
//                        // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para mostrar o alerta                 
//                        objItensEntIntPort.setNomeInternoCrc(jNomeInternoReg.getText());
//                        objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
//                        controleReg.confirmarEntradaPortariaCrc(objItensEntIntPort);
//                        objLog2();
//                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
//                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
//                        ExcluirInterno();
//                        preencherTabelaEntradasPortaria("SELECT * FROM ITENSREGISTROCANCELADO "
//                                + "WHERE Idlanc='" + jIdLanc.getText() + "'");
//                    }
//                }
            }
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaCancelamentoRetornosInte_P1) && codExcluirP1 == 1) {
            objRecCancel.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro de internos não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não é possível excluir esse registro. Existe outras operações que depende do cancelamento realizado.");
//                confirmaUtilizacao = "Não";
//                statusMov = "Excluiu";
//                horaMov = jHoraSistema.getText();
//                dataModFinal = jDataSistema.getText();
//                objRecCancel.setStatusLanc(jStatusLanc.getText());
//                if (jStatusLanc.getText().equals("FINALIZADO")) {
//                    JOptionPane.showMessageDialog(rootPane, "Esse  interno não poderá ser excluído, o mesmo encontra-se FINALIZADO");
//                } else {
//                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o INTERNO selecionado?", "Confirmação",
//                            JOptionPane.YES_NO_OPTION);
//                    if (resposta == JOptionPane.YES_OPTION) {
//                        objItensRecCancel.setIdItem(Integer.valueOf(jIdInternoReg.getText()));
//                        objItensRecCancel.setNomeInternoCrc(jNomeInternoReg.getText());
//                        controle.excluirRegCanceladoNE(objItensRecCancel);
//                        // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para mostrar o alerta                 
//                        objItensEntIntPort.setNomeInternoCrc(jNomeInternoReg.getText());
//                        objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
//                        controleReg.confirmarEntradaPortariaCrc(objItensEntIntPort);
//                        objLog2();
//                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
//                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
//                        ExcluirInterno();
//                        preencherTabelaEntradasPortaria("SELECT * FROM ITENSREGISTROCANCELADO "
//                                + "WHERE Idlanc='" + jIdLanc.getText() + "'");
//                    }
//                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirInternoActionPerformed

    private void jBtSalvarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCancelamentoRetornosInte_CRC);
        buscarAcessoUsuarioP1(telaCancelamentoRetornosInte_P1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoCRC.equals("ADMINISTRADORES") || codigoUserCRC == codUserAcessoCRC && nomeTelaCRC.equals(telaCancelamentoRetornosInte_CRC) && codGravarCRC == 1) {
            confirmaUtilizacao = "Sim";
            if (jNomeInternoReg.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
                jNomeInternoReg.requestFocus();
            } else {
                if (jDataEntrada.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data de Saida.");
                    jDataEntrada.requestFocus();
                    jDataEntrada.setBackground(Color.red);
                } else {
                    if (acao == 3) {
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja gravar o registro selecionado? Não será possível alterar ou excluir esse registro.", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            // Para o log do registro
                            objItensRecCancel.setUsuarioInsert(nameUser);
                            objItensRecCancel.setDataInsert(dataModFinal);
                            objItensRecCancel.setHorarioInsert(horaMov);
                            //
                            objItensRecCancel.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                            objItensRecCancel.setNomeInternoCrc(jNomeInternoReg.getText());
                            objItensRecCancel.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                            objItensRecCancel.setNrDocumento(jNrDocumento.getText());
                            objItensRecCancel.setDataSaida(jDataEntrada.getDate());
                            objItensRecCancel.setHoraSaida(jHorario.getText());
                            objItensRecCancel.setConfirmacaoRegistro(confirmaUtilizacao);
                            controle.incluirRegCanceladoRE(objItensRecCancel);
                            verificarTipoRetornoInterno();
                            //DIMINUIR A POPULAAÇÃO DA ALIMENTAÇÃO A QUANTIDADE DE INTERNOS
                            if (pTIPO_RETORNO.equals("Retorno Saída Temporaria")) {
                                populacaoAlimentacao();
                                // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para não mostrar mais o alerta 
                                // CANCELA O REGISTRO NA PORTARIA E IMPEDI QUE SEJA EXCLUÍDO E ALTERADO.
                                objItensEntIntPort.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                                objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
                                objItensEntIntPort.setRegistroCancelado(REGISTRO_CANCELADO);
                                //VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //ITENSREGISTRO
                                controleReg.confirmarEntradaPortariaCrcRET(objItensEntIntPort);
                            } else if (pTIPO_RETORNO.equals("Retorno de Prisão Domiciliar - COVID-19")) {
                                populacaoAlimentacao();
                                // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para não mostrar mais o alerta 
                                // CANCELA O REGISTRO NA PORTARIA E IMPEDI QUE SEJA EXCLUÍDO E ALTERADO.
                                objItensEntIntPort.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                                objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
                                objItensEntIntPort.setRegistroCancelado(REGISTRO_CANCELADO);
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //ITENSREGISTRO
                                controleReg.confirmarEntradaPortariaCrcRET(objItensEntIntPort);
                            } else if (pTIPO_RETORNO.equals("Retorno Transferência")) {
                                populacaoAlimentacao();
                                // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para não mostrar mais o alerta 
                                // CANCELA O REGISTRO NA PORTARIA E IMPEDI QUE SEJA EXCLUÍDO E ALTERADO.
                                objItensEntIntPort.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                                objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
                                objItensEntIntPort.setRegistroCancelado(REGISTRO_CANCELADO);
                                //VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //ITENSREGISTRO
                                controleReg.confirmarEntradaPortariaCrcRET(objItensEntIntPort);
                            } else if (pTIPO_RETORNO.equals("Retorno Recaptura")) {
                                populacaoAlimentacao();
                                // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para não mostrar mais o alerta 
                                // CANCELA O REGISTRO NA PORTARIA E IMPEDI QUE SEJA EXCLUÍDO E ALTERADO.
                                objItensEntIntPort.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                                objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
                                objItensEntIntPort.setRegistroCancelado(REGISTRO_CANCELADO);
                                //VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //ITENSREGISTRO
                                controleReg.confirmarEntradaPortariaCrcRET(objItensEntIntPort);
                            } else if (pTIPO_RETORNO.equals("Retorno por Nova Condenação")) {
                                populacaoAlimentacao();
                                // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para não mostrar mais o alerta 
                                // CANCELA O REGISTRO NA PORTARIA E IMPEDI QUE SEJA EXCLUÍDO E ALTERADO.
                                objItensEntIntPort.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                                objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
                                objItensEntIntPort.setRegistroCancelado(REGISTRO_CANCELADO);
                                //VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //ITENSREGISTRO
                                controleReg.confirmarEntradaPortariaCrcRET(objItensEntIntPort);
                            } else if (pTIPO_RETORNO.equals("Retorno Espontâneo")) {
                                populacaoAlimentacao();
                                // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para não mostrar mais o alerta 
                                // CANCELA O REGISTRO NA PORTARIA E IMPEDI QUE SEJA EXCLUÍDO E ALTERADO.
                                objItensEntIntPort.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                                objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
                                objItensEntIntPort.setRegistroCancelado(REGISTRO_CANCELADO);
                                //VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //ITENSREGISTRO
                                controleReg.confirmarEntradaPortariaCrcRET(objItensEntIntPort);
                            } else if (pTIPO_RETORNO.equals("Retorno por Nova Prisão")) {
                                populacaoAlimentacao();
                                // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para não mostrar mais o alerta 
                                // CANCELA O REGISTRO NA PORTARIA E IMPEDI QUE SEJA EXCLUÍDO E ALTERADO.
                                objItensEntIntPort.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                                objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
                                objItensEntIntPort.setRegistroCancelado(REGISTRO_CANCELADO);
                                //VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //ITENSREGISTRO
                                controleReg.confirmarEntradaPortariaCrcRET(objItensEntIntPort);
                            } else if (pTIPO_RETORNO.equals("Retorno Prisão Domiciliar")) {
                                populacaoAlimentacao();
                                // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para não mostrar mais o alerta 
                                // CANCELA O REGISTRO NA PORTARIA E IMPEDI QUE SEJA EXCLUÍDO E ALTERADO.
                                objItensEntIntPort.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                                objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
                                objItensEntIntPort.setRegistroCancelado(REGISTRO_CANCELADO);
                                //VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //ITENSREGISTRO
                                controleReg.confirmarEntradaPortariaCrcRET(objItensEntIntPort);
                            }
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            preencherTabelaEntradasPortaria("SELECT * FROM ITENS_REGISTRO_CANCELADO_RETORNOS "
                                    + "INNER JOIN PRONTUARIOSCRC "
                                    + "ON ITENS_REGISTRO_CANCELADO_RETORNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                    + "WHERE IdRegCancel='" + jIdLanc.getText() + "'");
                            SalvarInterno();
                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso. Se necessário, solicite a portaria que faça o lançamento do registro corretamente.");
                        }
                    }
                    if (acao == 4) {
                        // Para o log do registro
                        objItensRecCancel.setUsuarioUp(nameUser);
                        objItensRecCancel.setDataUp(dataModFinal);
                        objItensRecCancel.setHorarioUp(horaMov);
                        //
                        objItensRecCancel.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                        objItensRecCancel.setNomeInternoCrc(jNomeInternoReg.getText());
                        objItensRecCancel.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                        objItensRecCancel.setNrDocumento(jNrDocumento.getText());
                        objItensRecCancel.setDataSaida(jDataEntrada.getDate());
                        objItensRecCancel.setHoraSaida(jHorario.getText());
                        objItensRecCancel.setIdItem(Integer.valueOf(jIdInternoReg.getText()));
                        controle.alterarRegCanceladoRE(objItensRecCancel);
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        preencherTabelaEntradasPortaria("SELECT * FROM ITENS_REGISTRO_CANCELADO_RETORNOS "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ITENS_REGISTRO_CANCELADO_RETORNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE IdRegCancel='" + jIdLanc.getText() + "'");
                        SalvarInterno();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                    }
                }
            }
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaCancelamentoRetornosInte_P1) && codGravarP1 == 1) {
            confirmaUtilizacao = "Sim";
            if (jNomeInternoReg.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
                jNomeInternoReg.requestFocus();
            } else {
                if (jDataEntrada.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data de Saida.");
                    jDataEntrada.requestFocus();
                    jDataEntrada.setBackground(Color.red);
                } else {
                    if (acao == 3) {
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja gravar o registro selecionado? Não será possível alterar ou excluir esse registro.", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            // Para o log do registro
                            objItensRecCancel.setUsuarioInsert(nameUser);
                            objItensRecCancel.setDataInsert(dataModFinal);
                            objItensRecCancel.setHorarioInsert(horaMov);
                            //
                            objItensRecCancel.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                            objItensRecCancel.setNomeInternoCrc(jNomeInternoReg.getText());
                            objItensRecCancel.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                            objItensRecCancel.setNrDocumento(jNrDocumento.getText());
                            objItensRecCancel.setDataSaida(jDataEntrada.getDate());
                            objItensRecCancel.setHoraSaida(jHorario.getText());
                            objItensRecCancel.setConfirmacaoRegistro(confirmaUtilizacao);
                            controle.incluirRegCanceladoRE(objItensRecCancel);
                            verificarTipoRetornoInterno();
                            //DIMINUIR A POPULAAÇÃO DA ALIMENTAÇÃO A QUANTIDADE DE INTERNOS
                            if (pTIPO_RETORNO.equals("Retorno Saída Temporaria")) {
                                populacaoAlimentacao();
                                // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para não mostrar mais o alerta 
                                // CANCELA O REGISTRO NA PORTARIA E IMPEDI QUE SEJA EXCLUÍDO E ALTERADO.
                                objItensEntIntPort.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                                objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
                                objItensEntIntPort.setRegistroCancelado(REGISTRO_CANCELADO);
                                //VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //ITENSREGISTRO
                                controleReg.confirmarEntradaPortariaCrcRET(objItensEntIntPort);
                            } else if (pTIPO_RETORNO.equals("Retorno de Prisão Domiciliar - COVID-19")) {
                                populacaoAlimentacao();
                                // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para não mostrar mais o alerta 
                                // CANCELA O REGISTRO NA PORTARIA E IMPEDI QUE SEJA EXCLUÍDO E ALTERADO.
                                objItensEntIntPort.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                                objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
                                objItensEntIntPort.setRegistroCancelado(REGISTRO_CANCELADO);
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //ITENSREGISTRO
                                controleReg.confirmarEntradaPortariaCrcRET(objItensEntIntPort);
                            } else if (pTIPO_RETORNO.equals("Retorno Transferência")) {
                                populacaoAlimentacao();
                                // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para não mostrar mais o alerta 
                                // CANCELA O REGISTRO NA PORTARIA E IMPEDI QUE SEJA EXCLUÍDO E ALTERADO.
                                objItensEntIntPort.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                                objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
                                objItensEntIntPort.setRegistroCancelado(REGISTRO_CANCELADO);
                                //VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //ITENSREGISTRO
                                controleReg.confirmarEntradaPortariaCrcRET(objItensEntIntPort);
                            } else if (pTIPO_RETORNO.equals("Retorno Recaptura")) {
                                populacaoAlimentacao();
                                // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para não mostrar mais o alerta 
                                // CANCELA O REGISTRO NA PORTARIA E IMPEDI QUE SEJA EXCLUÍDO E ALTERADO.
                                objItensEntIntPort.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                                objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
                                objItensEntIntPort.setRegistroCancelado(REGISTRO_CANCELADO);
                                //VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //ITENSREGISTRO
                                controleReg.confirmarEntradaPortariaCrcRET(objItensEntIntPort);
                            } else if (pTIPO_RETORNO.equals("Retorno por Nova Condenação")) {
                                populacaoAlimentacao();
                                // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para não mostrar mais o alerta 
                                // CANCELA O REGISTRO NA PORTARIA E IMPEDI QUE SEJA EXCLUÍDO E ALTERADO.
                                objItensEntIntPort.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                                objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
                                objItensEntIntPort.setRegistroCancelado(REGISTRO_CANCELADO);
                                //VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //ITENSREGISTRO
                                controleReg.confirmarEntradaPortariaCrcRET(objItensEntIntPort);
                            } else if (pTIPO_RETORNO.equals("Retorno Espontâneo")) {
                                populacaoAlimentacao();
                                // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para não mostrar mais o alerta 
                                // CANCELA O REGISTRO NA PORTARIA E IMPEDI QUE SEJA EXCLUÍDO E ALTERADO.
                                objItensEntIntPort.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                                objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
                                objItensEntIntPort.setRegistroCancelado(REGISTRO_CANCELADO);
                                //VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //ITENSREGISTRO
                                controleReg.confirmarEntradaPortariaCrcRET(objItensEntIntPort);
                            } else if (pTIPO_RETORNO.equals("Retorno por Nova Prisão")) {
                                populacaoAlimentacao();
                                // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para não mostrar mais o alerta 
                                // CANCELA O REGISTRO NA PORTARIA E IMPEDI QUE SEJA EXCLUÍDO E ALTERADO.
                                objItensEntIntPort.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                                objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
                                objItensEntIntPort.setRegistroCancelado(REGISTRO_CANCELADO);
                                //VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //ITENSREGISTRO
                                controleReg.confirmarEntradaPortariaCrcRET(objItensEntIntPort);
                            } else if (pTIPO_RETORNO.equals("Retorno Prisão Domiciliar")) {
                                populacaoAlimentacao();
                                // Atualiza a tabela ITENSENTRADAPORTARIA na portaria para não mostrar mais o alerta 
                                // CANCELA O REGISTRO NA PORTARIA E IMPEDI QUE SEJA EXCLUÍDO E ALTERADO.
                                objItensEntIntPort.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                                objItensEntIntPort.setConfirmaEntrada(confirmaUtilizacao);
                                objItensEntIntPort.setRegistroCancelado(REGISTRO_CANCELADO);
                                //VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS
                                controleReg.confirmarEntradaPortariaCrcRE(objItensEntIntPort);
                                //ITENSREGISTRO
                                controleReg.confirmarEntradaPortariaCrcRET(objItensEntIntPort);
                            }
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            preencherTabelaEntradasPortaria("SELECT * FROM ITENS_REGISTRO_CANCELADO_RETORNOS "
                                    + "INNER JOIN PRONTUARIOSCRC "
                                    + "ON ITENS_REGISTRO_CANCELADO_RETORNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                    + "WHERE IdRegCancel='" + jIdLanc.getText() + "'");
                            SalvarInterno();
                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso. Se necessário, solicite a portaria que faça o lançamento do registro corretamente.");
                        }
                    }
                    if (acao == 4) {
                        // Para o log do registro
                        objItensRecCancel.setUsuarioUp(nameUser);
                        objItensRecCancel.setDataUp(dataModFinal);
                        objItensRecCancel.setHorarioUp(horaMov);
                        //
                        objItensRecCancel.setIdInternoCrc(Integer.valueOf(jIdInternoReg.getText()));
                        objItensRecCancel.setNomeInternoCrc(jNomeInternoReg.getText());
                        objItensRecCancel.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                        objItensRecCancel.setNrDocumento(jNrDocumento.getText());
                        objItensRecCancel.setDataSaida(jDataEntrada.getDate());
                        objItensRecCancel.setHoraSaida(jHorario.getText());
                        objItensRecCancel.setIdItem(Integer.valueOf(jIdInternoReg.getText()));
                        controle.alterarRegCanceladoRE(objItensRecCancel);
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        preencherTabelaEntradasPortaria("SELECT * FROM ITENS_REGISTRO_CANCELADO_RETORNOS "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ITENS_REGISTRO_CANCELADO_RETORNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE IdRegCancel='" + jIdLanc.getText() + "'");
                        SalvarInterno();
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarInternoActionPerformed

    private void jBtCancelarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarInternoActionPerformed
        // TODO add your handling code here:
        CancelarInterno();
    }//GEN-LAST:event_jBtCancelarInternoActionPerformed

    private void jBtAuditoriaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaInternoActionPerformed
        // TODO add your handling code here:
        if (TelaModuloCRC.jPainelCRC != null) {
            TelaAuditoriaItensRegCancel_RETORNOS objAudItensCancel = new TelaAuditoriaItensRegCancel_RETORNOS();
            TelaModuloCRC.jPainelCRC.add(objAudItensCancel);
            objAudItensCancel.show();
        } else if (TelaModuloPortarias.jPainelPortarias != null) {
            TelaAuditoriaItensRegCancel_RETORNOS objAudItensCancel = new TelaAuditoriaItensRegCancel_RETORNOS();
            TelaModuloPortarias.jPainelPortarias.add(objAudItensCancel);
            objAudItensCancel.show();
        }
    }//GEN-LAST:event_jBtAuditoriaInternoActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaEntradaInternosPortariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEntradaInternosPortariaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idItem = "" + jTabelaEntradaInternosPortaria.getValueAt(jTabelaEntradaInternosPortaria.getSelectedRow(), 0);
            String idInterno = "" + jTabelaEntradaInternosPortaria.getValueAt(jTabelaEntradaInternosPortaria.getSelectedRow(), 1);
            jIdInternoReg.setText(idInterno);
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(true);
            jBtExcluirInterno.setEnabled(true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoriaInterno.setEnabled(true);
            jBtImpressao.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENS_REGISTRO_CANCELADO_RETORNOS "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENS_REGISTRO_CANCELADO_RETORNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE ITENS_REGISTRO_CANCELADO_RETORNOS.IdInternoCrc='" + jIdInternoReg.getText() + "'" 
                        + "AND IdItem='" + idItem + "'");
                conecta.rs.first();
                pID_ITEM = conecta.rs.getInt("IdItem");
                jIdInternoReg.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jNomeInternoReg.setText(conecta.rs.getString("NomeInternoCrc"));
                jNrDocumento.setText(conecta.rs.getString("NrDocumento"));
                jDataEntrada.setDate(conecta.rs.getDate("DataSaida"));
                jHorario.setText(conecta.rs.getString("HoraSaida"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
        }
    }//GEN-LAST:event_jTabelaEntradaInternosPortariaMouseClicked

    private void jTabelaPesqusaInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesqusaInternoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaPesqusaInterno.getValueAt(jTabelaPesqusaInterno.getSelectedRow(), 0);
            jCodigoPesq.setText(IdLanc);
            // jDataLancamento.setDate(jDataLancamento.getDate());
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtImpressao.setEnabled(true);
            jBtNovoInterno.setEnabled(true);
            //
            bloquearCamposPesquisa();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM REGISTRO_CANCELADO_RETORNOS "
                        + "WHERE IdRegCancel ='" + IdLanc + "'");
                conecta.rs.first();
                jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdRegCancel")));
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                jMotivo.setText(conecta.rs.getString("Motivo"));
                //jCorpoTextoOcorrencia.setText(conecta.rs.getString("TextoArea"));
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            preencherTabelaEntradasPortaria("SELECT * FROM ITENS_REGISTRO_CANCELADO_RETORNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_REGISTRO_CANCELADO_RETORNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdRegCancel='" + jIdLanc.getText() + "'");
        }
    }//GEN-LAST:event_jTabelaPesqusaInternoMouseClicked

    private void jBtBuscarRegistroInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarRegistroInternoActionPerformed
        // TODO add your handling code here:
        if (TelaModuloCRC.jPainelCRC != null) {
            TelaPesqRegInternoPortaria_RETORNOS objPesqRegInternoPor = new TelaPesqRegInternoPortaria_RETORNOS();
            TelaModuloCRC.jPainelCRC.add(objPesqRegInternoPor);
            objPesqRegInternoPor.show();
        } else if (TelaModuloPortarias.jPainelPortarias != null) {
            TelaPesqRegInternoPortaria_RETORNOS objPesqRegInternoPor = new TelaPesqRegInternoPortaria_RETORNOS();
            TelaModuloPortarias.jPainelPortarias.add(objPesqRegInternoPor);
            objPesqRegInternoPor.show();
        }
    }//GEN-LAST:event_jBtBuscarRegistroInternoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarInterno;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaInterno;
    private javax.swing.JButton jBtBuscarRegistroInterno;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarInterno;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirInterno;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoInterno;
    private javax.swing.JButton jBtPesqCodigo;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarInterno;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JTextField jCodigoPesq;
    private com.toedter.calendar.JDateChooser jDataEntrada;
    private com.toedter.calendar.JDateChooser jDataLanc;
    private com.toedter.calendar.JDateChooser jDataPesFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    private javax.swing.JTextField jHorario;
    public static javax.swing.JTextField jIdInternoReg;
    public static javax.swing.JTextField jIdLanc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextArea jMotivo;
    private javax.swing.JTextField jNomeInternoPesq;
    public static javax.swing.JTextField jNomeInternoReg;
    public static javax.swing.JTextField jNrDocumento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaEntradaInternosPortaria;
    private javax.swing.JTable jTabelaPesqusaInterno;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void verificarTipoRetornoInterno() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdInternoCrc,OrigemRetorno "
                    + "FROM ITENSREGISTRO "
                    + "WHERE IdInternoCrc='" + jIdInternoReg.getText() + "' "
                    + "AND IdRetorno='" + pRETORNO_PORTARIA + "'");
            conecta.rs.first();
            pID_RETORNO = conecta.rs.getInt("IdRetorno");
            pID_INTERNO = conecta.rs.getString("IdInternoCrc");
            pTIPO_RETORNO = conecta.rs.getString("OrigemRetorno");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    //POPULAÇÃO ALIMENTICIA
    public void populacaoAlimentacao() {
        //ADICIONAR POPULAÇÃO NA TABELA ENTRADAS_SAIDAS_POPULCAO_INTERNOS
        objEntradaSaida.setIdDocumento(pID_ITEM_ALIMENTACAO);
        objEntradaSaida.setDataMovimento(jDataEntrada.getDate());
        objEntradaSaida.setHorarioMovimento(jHorario.getText());
        objEntradaSaida.setQuantidade(pQUANTIDADE_ENTRADA_INTERNO);
        objEntradaSaida.setTipoOperacao(pTIPO_OPERCAO_ENTRADA);
        objEntradaSaida.setUsuarioInsert(nameUser);
        objEntradaSaida.setDataInsert(jDataSistema.getText());
        objEntradaSaida.setHorarioInsert(horaMov);
        //PEGAR ULTIMA POPUÇÃO PARA EFETUAR CALCULO ANTES DE GRAVAR
        listaUltimaPopulacao.selecionarPopulacao(objEntradaSaida);
        pPOPULCAO_ATUAL = objEntradaSaida.getPopulacao() - pQUANTIDADE_ENTRADA_INTERNO;
        objEntradaSaida.setPopulacao(pPOPULCAO_ATUAL);
        populacao.incluirEntradaSaidaPortaria(objEntradaSaida);
    }

    public void bloquearCamposPesquisa() {
        jIdLanc.setEnabled(!true);
        jStatusLanc.setEnabled(!true);
        jDataLanc.setEnabled(!true);
        jMotivo.setEnabled(!true);
        //        
        jIdInternoReg.setEnabled(!true);
        jNomeInternoReg.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorario.setEnabled(!true);
        //
        jBtBuscarRegistroInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        //
        jIdInternoReg.setText("");
        jNomeInternoReg.setText("");
        jNrDocumento.setText("");
        jDataEntrada.setDate(null);
        jNrDocumento.setText("");
        jHorario.setText("");
    }

    public void formatarCampos() {
        jMotivo.setLineWrap(true);
        jMotivo.setWrapStyleWord(true);
    }

    public void corCampos() {
        jIdLanc.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        jMotivo.setBackground(Color.white);
        //
        jIdInternoReg.setBackground(Color.white);
        jNomeInternoReg.setBackground(Color.white);
        jNrDocumento.setBackground(Color.white);
        jDataEntrada.setBackground(Color.white);
        jHorario.setBackground(Color.white);
    }

    public void Novo() {
        // Limpar campos para inclusão
        jIdLanc.setText("");
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
        jMotivo.setText("");
        //
        jIdInternoReg.setText("");
        jNomeInternoReg.setText("");
        jNrDocumento.setText("");
        jDataEntrada.setDate(null);
        jHorario.setText("");
        //Habilitar/Desabilitar campos do documento
        jDataLanc.setEnabled(true);
        jMotivo.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        //
        limparTabelaItens();
        jIdInternoReg.setText("");
        jNomeInternoReg.setText("");
        jNrDocumento.setText("");
        jDataEntrada.setDate(null);
        jNrDocumento.setText("");
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void Alterar() {
        //Habilitar/Desabilitar campos do documento
        jDataLanc.setEnabled(true);
        jMotivo.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void Excluir() {
        // Limpar campos para inclusão
        jIdLanc.setText("");
        jStatusLanc.setText("");
        jDataLanc.setDate(null);
        jMotivo.setText("");
        //Habilitar/Desabilitar campos do documento
        jDataLanc.setEnabled(!true);
        jMotivo.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void Salvar() {
        //Habilitar/Desabilitar campos do documento
        jDataLanc.setEnabled(!true);
        jMotivo.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressao.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void Cancelar() {
        if (jIdLanc.getText().equals("")) {
            // Limpar campos para inclusão
            jIdLanc.setText("");
            jStatusLanc.setText("");
            jDataLanc.setDate(null);
            jMotivo.setText("");
            //Habilitar/Desabilitar campos do documento
            jDataLanc.setEnabled(!true);
            jMotivo.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            jBtImpressao.setEnabled(!true);
            //
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(!true);
            jBtExcluirInterno.setEnabled(!true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(!true);
            jBtAuditoriaInterno.setEnabled(!true);
        } else {
            //Habilitar/Desabilitar campos do documento
            jDataLanc.setEnabled(!true);
            jMotivo.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            jBtImpressao.setEnabled(!true);
            //
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(!true);
            jBtExcluirInterno.setEnabled(!true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(!true);
            jBtAuditoriaInterno.setEnabled(!true);
        }
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusEntrada = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse Cancelamento de internos for finalizado, você não poderá\nmais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZAR o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objRecCancel.setStatusLanc(statusEntrada);
            objRecCancel.setIdLanc(Integer.parseInt(jIdLanc.getText()));
            control.finalizarRegCanceladoRE(objRecCancel);
            jStatusLanc.setText(statusEntrada);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            jDataLanc.setEnabled(!true);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtNovoInterno.setEnabled(!true);
        }
    }

    public void Impressao() {

    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_CANCELADO_RETORNOS");
            conecta.rs.last();
            jIdLanc.setText(conecta.rs.getString("IdRegCancel"));
        } catch (Exception e) {
        }
    }

    public void NovoInterno() {
        //
        jIdInternoReg.setText("");
        jNomeInternoReg.setText("");
        jNrDocumento.setText("");
        jDataEntrada.setCalendar(Calendar.getInstance());
        jHorario.setText(jHoraSistema.getText());
        //        
        jBtBuscarRegistroInterno.setEnabled(true);
        jNrDocumento.setEnabled(true);
        jDataEntrada.setEnabled(true);
        jHorario.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtAuditoriaInterno.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
    }

    public void AlterarInterno() {
        jBtBuscarRegistroInterno.setEnabled(true);
        jNrDocumento.setEnabled(true);
        jDataEntrada.setEnabled(true);
        jHorario.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtAuditoriaInterno.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
    }

    public void ExcluirInterno() {
        //
        jIdInternoReg.setText("");
        jNomeInternoReg.setText("");
        jNrDocumento.setText("");
        jDataEntrada.setDate(null);
        jHorario.setText("");
        //        
        jBtBuscarRegistroInterno.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorario.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressao.setEnabled(true);
    }

    public void SalvarInterno() {
        //
        jIdInternoReg.setText("");
        jNomeInternoReg.setText("");
        jNrDocumento.setText("");
        jDataEntrada.setDate(null);
        jHorario.setText("");
        //        
        jBtBuscarRegistroInterno.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorario.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressao.setEnabled(true);
    }

    public void CancelarInterno() {
        //
        jIdInternoReg.setText("");
        jNomeInternoReg.setText("");
        jNrDocumento.setText("");
        jDataEntrada.setDate(null);
        jHorario.setText("");
        //        
        jBtBuscarRegistroInterno.setEnabled(!true);
        jNrDocumento.setEnabled(!true);
        jDataEntrada.setEnabled(!true);
        jHorario.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtImpressao.setEnabled(true);
    }

    public void verificarItens() {
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_REGISTRO_CANCELADO_RETORNOS WHERE IdRegCancel='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codCancel = conecta.rs.getString("IdRegCancel");
            if (jIdLanc.getText().equals(codCancel)) {
                JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os internos relacionados a esse registro.");
            }
            conecta.desconecta();
        } catch (SQLException ex) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objRecCancel.setIdLanc(Integer.parseInt(jIdLanc.getText()));
                control.excluirRegCanceladoRE(objRecCancel);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                Excluir();
            }
        }
    }

    public void preencherTabelaPesqRegCan(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Motivo"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                datalanc = conecta.rs.getString("DataLanc");
                String dia = datalanc.substring(8, 10);
                String mes = datalanc.substring(5, 7);
                String ano = datalanc.substring(0, 4);
                datalanc = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdRegCancel"), datalanc, conecta.rs.getString("StatusLanc"), conecta.rs.getString("Motivo")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqusaInterno.setModel(modelo);
        jTabelaPesqusaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPesqusaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqusaInterno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaPesqusaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqusaInterno.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaPesqusaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqusaInterno.getColumnModel().getColumn(3).setPreferredWidth(570);
        jTabelaPesqusaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqusaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqusaInterno.setAutoResizeMode(jTabelaPesqusaInterno.AUTO_RESIZE_OFF);
        jTabelaPesqusaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Motivo"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqusaInterno.setModel(modelo);
        jTabelaPesqusaInterno.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaPesqusaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqusaInterno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaPesqusaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqusaInterno.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaPesqusaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqusaInterno.getColumnModel().getColumn(3).setPreferredWidth(570);
        jTabelaPesqusaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqusaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqusaInterno.setAutoResizeMode(jTabelaPesqusaInterno.AUTO_RESIZE_OFF);
        jTabelaPesqusaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaPesqRegCanNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno", "Motivo"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                datalanc = conecta.rs.getString("DataLanc");
                String dia = datalanc.substring(8, 10);
                String mes = datalanc.substring(5, 7);
                String ano = datalanc.substring(0, 4);
                datalanc = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdRegCancel"), datalanc, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("Motivo")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPesqusaInterno.setModel(modelo);
        jTabelaPesqusaInterno.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaPesqusaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPesqusaInterno.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaPesqusaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPesqusaInterno.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaPesqusaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPesqusaInterno.getColumnModel().getColumn(3).setPreferredWidth(280);
        jTabelaPesqusaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPesqusaInterno.getColumnModel().getColumn(4).setPreferredWidth(280);
        jTabelaPesqusaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaPesqusaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaPesqusaInterno.setAutoResizeMode(jTabelaPesqusaInterno.AUTO_RESIZE_OFF);
        jTabelaPesqusaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaPesqusaInterno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPesqusaInterno.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaPesqusaInterno.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void preencherTabelaEntradasPortaria(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Interno", "Data Entrada", "Horario", "Nr. Doc."};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data Entrada
                dataSaida = conecta.rs.getString("DataSaida");
                String diae = dataSaida.substring(8, 10);
                String mese = dataSaida.substring(5, 7);
                String anoe = dataSaida.substring(0, 4);
                dataSaida = diae + "/" + mese + "/" + anoe;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataSaida, conecta.rs.getString("HoraSaida"), conecta.rs.getString("NrDocumento")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntradaInternosPortaria.setModel(modelo);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(4).setResizable(false);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(5).setResizable(false);
        jTabelaEntradaInternosPortaria.getTableHeader().setReorderingAllowed(false);
        jTabelaEntradaInternosPortaria.setAutoResizeMode(jTabelaEntradaInternosPortaria.AUTO_RESIZE_OFF);
        jTabelaEntradaInternosPortaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaItens();
        conecta.desconecta();
    }

    public void limparTabelaItens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Interno", "Data Entrada", "Horario", "Nr. Doc."};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEntradaInternosPortaria.setModel(modelo);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(4).setResizable(false);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(5).setResizable(false);
        jTabelaEntradaInternosPortaria.getTableHeader().setReorderingAllowed(false);
        jTabelaEntradaInternosPortaria.setAutoResizeMode(jTabelaEntradaInternosPortaria.AUTO_RESIZE_OFF);
        jTabelaEntradaInternosPortaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaEntradaInternosPortaria.getColumnModel().getColumn(5).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
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

    public void buscarAcessoUsuarioP1(String nomeTelaAcesso) {
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
}
