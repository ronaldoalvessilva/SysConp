/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAutorRegimeDisciplinar;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleOcorrenciaDisciplinar;
import gestor.Controle.ControleRegimentoDisciplinarInterno;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.AutoresRegimentoDisciplinar;
import gestor.Modelo.LogSistema;
import gestor.Modelo.OcorrenciaRegimeDisciplinar;
import gestor.Modelo.RegistroEventosIndisciplinar;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloSeguranca.codAlterar;
import static gestor.Visao.TelaModuloSeguranca.codExcluir;
import static gestor.Visao.TelaModuloSeguranca.codGravar;
import static gestor.Visao.TelaModuloSeguranca.codIncluir;
import static gestor.Visao.TelaModuloSeguranca.codUserAcesso;
import static gestor.Visao.TelaModuloSeguranca.codigoUser;
import static gestor.Visao.TelaModuloSeguranca.nomeGrupo;
import static gestor.Visao.TelaModuloSeguranca.nomeTela;
import static gestor.Visao.TelaModuloSeguranca.codAbrir;
import static gestor.Visao.TelaModuloSeguranca.codConsultar;
import static gestor.Visao.TelaModuloSeguranca.codigoUserGroup;
import static gestor.Visao.TelaModuloSeguranca.codigoGrupo;
import static gestor.Visao.TelaModuloSeguranca.telaAplicarRegistroPenalidadeDisciplinas;
import static gestor.Visao.TelaModuloSeguranca.telaAplicarRegistroPenalidadeDisciplinasAutor;
import static gestor.Visao.TelaModuloSeguranca.telaAplicarRegistroPenalidadeDisciplinasOCR;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.ImageIcon;
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
 * @author Ronaldo
 */
public class TelaRegimentoInternoDisciplinar extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    // Aba Manutenção
    RegistroEventosIndisciplinar objRegEvenDisciplinar = new RegistroEventosIndisciplinar();
    ControleRegimentoDisciplinarInterno control = new ControleRegimentoDisciplinarInterno();
    //
    AutoresRegimentoDisciplinar objAutor = new AutoresRegimentoDisciplinar();
    ControleAutorRegimeDisciplinar controle = new ControleAutorRegimeDisciplinar();
    //
    OcorrenciaRegimeDisciplinar objOcrDisc = new OcorrenciaRegimeDisciplinar();
    ControleOcorrenciaDisciplinar controleOcr = new ControleOcorrenciaDisciplinar();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Segurança:Regimento Disciplinar Internos:Manutenção";
    String nomeModuloTela2 = "Segurança:Regimento Disciplinar Internos:Autor";
    String nomeModuloTela3 = "Segurança:Regimento Disciplinar Internos:Ocorrências";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int acao;
    int flag;
    String dataInicial;
    String dataFinal;
    String dataBrasil;
    String observacaoRol = "INTERNO ENCONTRA-SE NO ISOLAMENTO";
    String dataInicio, dataTermino, dataOcorrencia;
    int count = 0;
    int count1 = 0;
    int count2 = 0;
    String idRegAutor, idRegOcorrencia;
    public static int idItemAutor;
    String caminho;
    String utilizaSaida = "Não"; // Variavel que informa a utilização na tabela de retirada do castigo
    String codInternoOcr;
    String codOcorrencia;

    /**
     * Creates new form TelaRegimentoInternoDisciplinar
     */
    public static TelaFotoInternoRegimeDisciplinar telaFotoInterno;
    public static TelaFaltasIndisciplinarFO2 faltasFO2;

    public TelaRegimentoInternoDisciplinar() {
        initComponents();
        formatarCampos();
        corCampos();
    }

    public void mostraTelaFotoCrc() {
        telaFotoInterno = new TelaFotoInternoRegimeDisciplinar(this, true);
        telaFotoInterno.setVisible(true);
    }

    public void mostrarFaltasFO2() {
        faltasFO2 = new TelaFaltasIndisciplinarFO2(this, true);
        faltasFO2.setVisible(true);
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
        jPanel28 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jDataPesqFinal = new com.toedter.calendar.JDateChooser();
        jIdPesqCodigo = new javax.swing.JTextField();
        jBtPesqCodigo = new javax.swing.JButton();
        jBtPesqDatas = new javax.swing.JButton();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTabelaRegistroEventosIndisciplinar = new javax.swing.JTable();
        jPanel39 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDataReg = new com.toedter.calendar.JDateChooser();
        jCodigoReg = new javax.swing.JTextField();
        jStatusReg = new javax.swing.JTextField();
        jColaboradorAutorizador = new javax.swing.JTextField();
        jNaturezaEvento = new javax.swing.JTextField();
        jLocalEvento = new javax.swing.JTextField();
        jHorarioEvento = new javax.swing.JTextField();
        jBtPesqColaborador = new javax.swing.JButton();
        jBtPesqNatureza = new javax.swing.JButton();
        jBtPesqLocalEvento = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jBtFinalizar = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jCodigoInternoReg = new javax.swing.JTextField();
        jMatriculaPenalReg = new javax.swing.JTextField();
        jNomeInternoReg = new javax.swing.JTextField();
        jRG = new javax.swing.JTextField();
        jPavilhaoDestino = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jFotoInternoReg = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jDataIncioDisciplina = new com.toedter.calendar.JDateChooser();
        jDataTerminoDisciplina = new com.toedter.calendar.JDateChooser();
        jBtZoon = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jQtdDias = new javax.swing.JFormattedTextField();
        jBtPesqInternoReg = new javax.swing.JButton();
        jBtPesqPavilhaoDestino = new javax.swing.JButton();
        jComboBoxCelaDestino = new javax.swing.JComboBox();
        jtotalItens = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jAlcunha = new javax.swing.JTextField();
        jBtFichaOcorrencia = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaInternoAutor = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jBtNovoInterno = new javax.swing.JButton();
        jBtAlterarInterno = new javax.swing.JButton();
        jBtExcluirInterno = new javax.swing.JButton();
        jBtSalvarInterno = new javax.swing.JButton();
        jBtCancelarInterno = new javax.swing.JButton();
        jBtAuditoriaInterno = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jCodigoOcorrencia = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextaOcorrecia = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jDataOcorrencia = new com.toedter.calendar.JDateChooser();
        jComboBoxNomeInternoOcorrencia = new javax.swing.JComboBox();
        jBtImpressao = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaOcorrencias = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jBtNovaOcorrencia = new javax.swing.JButton();
        jBtAlterarOcorrencia = new javax.swing.JButton();
        jBtExcluirOcorrencia = new javax.swing.JButton();
        jBtSalvarOcorrencia = new javax.swing.JButton();
        jBtCancelarOcorrencia = new javax.swing.JButton();
        jBtAuditoriaOcorrencia = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Regimento Disciplinar Interno Art. 41 Parágrafo único da LEP :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Código:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Data Inicial:");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Data Final:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataPesqFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jIdPesqCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdPesqCodigo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigo.setContentAreaFilled(false);
        jBtPesqCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoActionPerformed(evt);
            }
        });

        jBtPesqDatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDatas.setContentAreaFilled(false);
        jBtPesqDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDatasActionPerformed(evt);
            }
        });

        jCheckBoxTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Nome do Interno:");

        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jIdPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jCheckBoxTodos))))))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel31)
                    .addComponent(jIdPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCodigo)
                    .addComponent(jCheckBoxTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqDatas)
                    .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeInterno)
                    .addComponent(jLabel23))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaRegistroEventosIndisciplinar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaRegistroEventosIndisciplinar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Status", "Observação"
            }
        ));
        jTabelaRegistroEventosIndisciplinar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaRegistroEventosIndisciplinarMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTabelaRegistroEventosIndisciplinar);
        if (jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumnCount() > 0) {
            jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(3).setMinWidth(320);
            jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(3).setMaxWidth(320);
        }

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel67.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel67))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Colaborador Autorizador");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Tipo de Falta Indisciplinar");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Local do Evento");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 0));
        jLabel7.setText("Horário Evento");

        jDataReg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataReg.setEnabled(false);

        jCodigoReg.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoReg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoReg.setEnabled(false);

        jStatusReg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusReg.setForeground(new java.awt.Color(255, 0, 0));
        jStatusReg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusReg.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jStatusReg.setEnabled(false);

        jColaboradorAutorizador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jColaboradorAutorizador.setEnabled(false);

        jNaturezaEvento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNaturezaEvento.setEnabled(false);

        jLocalEvento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLocalEvento.setEnabled(false);

        jHorarioEvento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioEvento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioEvento.setEnabled(false);

        jBtPesqColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqColaborador.setContentAreaFilled(false);
        jBtPesqColaborador.setEnabled(false);
        jBtPesqColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqColaboradorActionPerformed(evt);
            }
        });

        jBtPesqNatureza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNatureza.setContentAreaFilled(false);
        jBtPesqNatureza.setEnabled(false);
        jBtPesqNatureza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNaturezaActionPerformed(evt);
            }
        });

        jBtPesqLocalEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqLocalEvento.setContentAreaFilled(false);
        jBtPesqLocalEvento.setEnabled(false);
        jBtPesqLocalEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqLocalEventoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLocalEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtPesqLocalEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCodigoReg, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jStatusReg))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jDataReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jColaboradorAutorizador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jNaturezaEvento))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jBtPesqNatureza, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jHorarioEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtPesqColaborador, jBtPesqLocalEvento, jBtPesqNatureza});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jStatusReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCodigoReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataReg, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jColaboradorAutorizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqColaborador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNaturezaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNatureza)
                    .addComponent(jHorarioEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLocalEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqLocalEvento))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtPesqColaborador, jBtPesqLocalEvento, jBtPesqNatureza});

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.setContentAreaFilled(false);
        jBtNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.setContentAreaFilled(false);
        jBtAlterar.setEnabled(false);
        jBtAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setText("Excluir");
        jBtExcluir.setContentAreaFilled(false);
        jBtExcluir.setEnabled(false);
        jBtExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setText("Gravar");
        jBtSalvar.setContentAreaFilled(false);
        jBtSalvar.setEnabled(false);
        jBtSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setText("Cancelar");
        jBtCancelar.setContentAreaFilled(false);
        jBtCancelar.setEnabled(false);
        jBtCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setContentAreaFilled(false);
        jBtSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jBtNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jBtNovo)
                .addComponent(jBtAlterar)
                .addComponent(jBtExcluir)
                .addComponent(jBtSalvar)
                .addComponent(jBtCancelar)
                .addComponent(jBtSair))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtFinalizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtFinalizar.setForeground(new java.awt.Color(204, 0, 51));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/low-security-breach-icone-4155-16.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setToolTipText("Finalizar");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtAuditoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel6.setLayout(null);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Código");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Matricula Penal");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Nome Completo do Interno");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("R.G.");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Alcunha");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 255));
        jLabel14.setText("Pavilhão (Destino)");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("Cela (Destino)");

        jCodigoInternoReg.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoInternoReg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoInternoReg.setEnabled(false);

        jMatriculaPenalReg.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenalReg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenalReg.setEnabled(false);

        jNomeInternoReg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoReg.setEnabled(false);

        jRG.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jRG.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRG.setEnabled(false);

        jPavilhaoDestino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPavilhaoDestino.setEnabled(false);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel8.setLayout(null);
        jPanel8.add(jFotoInternoReg);
        jFotoInternoReg.setBounds(5, 16, 108, 100);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Data Inicial");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Data Termino");

        jDataIncioDisciplina.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataIncioDisciplina.setEnabled(false);

        jDataTerminoDisciplina.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataTerminoDisciplina.setEnabled(false);

        jBtZoon.setForeground(new java.awt.Color(255, 0, 0));
        jBtZoon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/11985_16x16.png"))); // NOI18N
        jBtZoon.setText("Zoom");
        jBtZoon.setToolTipText("Zoom Foto");
        jBtZoon.setEnabled(false);
        jBtZoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtZoonActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Qtd. de Dias");

        jQtdDias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQtdDias.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQtdDias.setEnabled(false);

        jBtPesqInternoReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInternoReg.setContentAreaFilled(false);
        jBtPesqInternoReg.setEnabled(false);
        jBtPesqInternoReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoRegActionPerformed(evt);
            }
        });

        jBtPesqPavilhaoDestino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqPavilhaoDestino.setToolTipText("Pesquisar Pavilhão");
        jBtPesqPavilhaoDestino.setContentAreaFilled(false);
        jBtPesqPavilhaoDestino.setEnabled(false);
        jBtPesqPavilhaoDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqPavilhaoDestinoActionPerformed(evt);
            }
        });

        jComboBoxCelaDestino.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCelaDestino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboBoxCelaDestino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCelaDestino.setEnabled(false);
        jComboBoxCelaDestino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxCelaDestinoMouseClicked(evt);
            }
        });

        jtotalItens.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtotalItens.setForeground(new java.awt.Color(255, 0, 0));
        jtotalItens.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtotalItens.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtotalItens.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jtotalItens.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("T.Reg");

        jAlcunha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlcunha.setEnabled(false);

        jBtFichaOcorrencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtFichaOcorrencia.setToolTipText("Ficha de Ocorrência Individual");
        jBtFichaOcorrencia.setContentAreaFilled(false);
        jBtFichaOcorrencia.setEnabled(false);
        jBtFichaOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFichaOcorrenciaActionPerformed(evt);
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
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jRG, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPavilhaoDestino, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jComboBoxCelaDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBtPesqPavilhaoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jAlcunha, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addGap(104, 104, 104))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(jBtZoon, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(5, 5, 5)))
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jQtdDias)
                                .addGap(8, 8, 8)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jDataIncioDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16)
                            .addComponent(jDataTerminoDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jtotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtFichaOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCodigoInternoReg, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqInternoReg, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jMatriculaPenalReg, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel11)
                            .addComponent(jNomeInternoReg, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jCodigoInternoReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqInternoReg)
                            .addComponent(jMatriculaPenalReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtZoon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(3, 3, 3)
                        .addComponent(jNomeInternoReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAlcunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jPavilhaoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCelaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqPavilhaoDestino))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel10)
                            .addComponent(jLabel16)))
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jQtdDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataIncioDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataTerminoDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtFichaOcorrencia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel7);
        jPanel7.setBounds(10, 10, 440, 260);

        jTabelaInternoAutor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternoAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Item", "Código", "Nome Completo do Interno", "Qtde. Dias", "Data Inicio", "Data Termino", "Cela Destino"
            }
        ));
        jTabelaInternoAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternoAutorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaInternoAutor);
        if (jTabelaInternoAutor.getColumnModel().getColumnCount() > 0) {
            jTabelaInternoAutor.getColumnModel().getColumn(0).setMinWidth(40);
            jTabelaInternoAutor.getColumnModel().getColumn(0).setMaxWidth(40);
            jTabelaInternoAutor.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaInternoAutor.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaInternoAutor.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaInternoAutor.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaInternoAutor.getColumnModel().getColumn(3).setMinWidth(70);
            jTabelaInternoAutor.getColumnModel().getColumn(3).setMaxWidth(70);
            jTabelaInternoAutor.getColumnModel().getColumn(4).setMinWidth(80);
            jTabelaInternoAutor.getColumnModel().getColumn(4).setMaxWidth(80);
            jTabelaInternoAutor.getColumnModel().getColumn(5).setMinWidth(80);
            jTabelaInternoAutor.getColumnModel().getColumn(5).setMaxWidth(80);
            jTabelaInternoAutor.getColumnModel().getColumn(6).setMinWidth(220);
            jTabelaInternoAutor.getColumnModel().getColumn(6).setMaxWidth(220);
        }

        jPanel6.add(jScrollPane2);
        jScrollPane2.setBounds(10, 275, 440, 110);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovoInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoInterno.setText("Novo");
        jBtNovoInterno.setContentAreaFilled(false);
        jBtNovoInterno.setEnabled(false);
        jBtNovoInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoInternoActionPerformed(evt);
            }
        });

        jBtAlterarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jBtAlterarInterno.setText("Alterar");
        jBtAlterarInterno.setContentAreaFilled(false);
        jBtAlterarInterno.setEnabled(false);
        jBtAlterarInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarInternoActionPerformed(evt);
            }
        });

        jBtExcluirInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirInterno.setText("Excluir");
        jBtExcluirInterno.setContentAreaFilled(false);
        jBtExcluirInterno.setEnabled(false);
        jBtExcluirInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirInternoActionPerformed(evt);
            }
        });

        jBtSalvarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarInterno.setText("Gravar");
        jBtSalvarInterno.setContentAreaFilled(false);
        jBtSalvarInterno.setEnabled(false);
        jBtSalvarInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarInternoActionPerformed(evt);
            }
        });

        jBtCancelarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarInterno.setText("Cancelar");
        jBtCancelarInterno.setContentAreaFilled(false);
        jBtCancelarInterno.setEnabled(false);
        jBtCancelarInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarInternoActionPerformed(evt);
            }
        });

        jBtAuditoriaInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaInterno.setToolTipText("Auditoria");
        jBtAuditoriaInterno.setContentAreaFilled(false);
        jBtAuditoriaInterno.setEnabled(false);
        jBtAuditoriaInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jBtNovoInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jBtNovoInterno)
                .addComponent(jBtAlterarInterno)
                .addComponent(jBtExcluirInterno)
                .addComponent(jBtSalvarInterno)
                .addComponent(jBtCancelarInterno))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaInterno)
                .addContainerGap())
        );

        jPanel6.add(jPanel11);
        jPanel11.setBounds(10, 390, 440, 45);

        jTabbedPane1.addTab("Autor (es)", jPanel6);

        jPanel10.setLayout(null);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Ocorrência");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Nome Completo do Interno");

        jCodigoOcorrencia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoOcorrencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoOcorrencia.setEnabled(false);

        jTextaOcorrecia.setColumns(20);
        jTextaOcorrecia.setRows(5);
        jTextaOcorrecia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextaOcorrecia.setEnabled(false);
        jScrollPane3.setViewportView(jTextaOcorrecia);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("Texto da Ocorrência");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Data Ocorrência");

        jDataOcorrencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataOcorrencia.setEnabled(false);

        jComboBoxNomeInternoOcorrencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNomeInternoOcorrencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboBoxNomeInternoOcorrencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNomeInternoOcorrencia.setEnabled(false);

        jBtImpressao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao.setText("Impressão");
        jBtImpressao.setToolTipText("Impressão Ocorrência");
        jBtImpressao.setEnabled(false);
        jBtImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCodigoOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jDataOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtImpressao))))
                    .addComponent(jScrollPane3)
                    .addComponent(jComboBoxNomeInternoOcorrencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCodigoOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtImpressao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(9, 9, 9)
                .addComponent(jComboBoxNomeInternoOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.add(jPanel9);
        jPanel9.setBounds(10, 11, 440, 276);

        jTabelaOcorrencias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaOcorrencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Ocorrência", "Data", "Nome do Interno", "Ocorrência do Interno"
            }
        ));
        jTabelaOcorrencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaOcorrenciasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaOcorrencias);
        if (jTabelaOcorrencias.getColumnModel().getColumnCount() > 0) {
            jTabelaOcorrencias.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaOcorrencias.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaOcorrencias.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaOcorrencias.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaOcorrencias.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaOcorrencias.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaOcorrencias.getColumnModel().getColumn(3).setMinWidth(300);
            jTabelaOcorrencias.getColumnModel().getColumn(3).setMaxWidth(300);
        }

        jPanel10.add(jScrollPane4);
        jScrollPane4.setBounds(10, 293, 440, 91);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovaOcorrencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaOcorrencia.setText("Novo");
        jBtNovaOcorrencia.setContentAreaFilled(false);
        jBtNovaOcorrencia.setEnabled(false);
        jBtNovaOcorrencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovaOcorrencia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovaOcorrencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovaOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaOcorrenciaActionPerformed(evt);
            }
        });

        jBtAlterarOcorrencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jBtAlterarOcorrencia.setText("Alterar");
        jBtAlterarOcorrencia.setContentAreaFilled(false);
        jBtAlterarOcorrencia.setEnabled(false);
        jBtAlterarOcorrencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarOcorrencia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarOcorrencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarOcorrenciaActionPerformed(evt);
            }
        });

        jBtExcluirOcorrencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirOcorrencia.setText("Excluir");
        jBtExcluirOcorrencia.setContentAreaFilled(false);
        jBtExcluirOcorrencia.setEnabled(false);
        jBtExcluirOcorrencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirOcorrencia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirOcorrencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirOcorrenciaActionPerformed(evt);
            }
        });

        jBtSalvarOcorrencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarOcorrencia.setText("Gravar");
        jBtSalvarOcorrencia.setContentAreaFilled(false);
        jBtSalvarOcorrencia.setEnabled(false);
        jBtSalvarOcorrencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarOcorrencia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarOcorrencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarOcorrenciaActionPerformed(evt);
            }
        });

        jBtCancelarOcorrencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarOcorrencia.setText("Cancelar");
        jBtCancelarOcorrencia.setContentAreaFilled(false);
        jBtCancelarOcorrencia.setEnabled(false);
        jBtCancelarOcorrencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarOcorrencia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarOcorrencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarOcorrenciaActionPerformed(evt);
            }
        });

        jBtAuditoriaOcorrencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaOcorrencia.setToolTipText("Auditoria");
        jBtAuditoriaOcorrencia.setContentAreaFilled(false);
        jBtAuditoriaOcorrencia.setEnabled(false);
        jBtAuditoriaOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaOcorrenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jBtNovaOcorrencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarOcorrencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirOcorrencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarOcorrencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarOcorrencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jBtNovaOcorrencia)
                .addComponent(jBtAlterarOcorrencia)
                .addComponent(jBtExcluirOcorrencia)
                .addComponent(jBtSalvarOcorrencia)
                .addComponent(jBtCancelarOcorrencia))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaOcorrencia)
                .addContainerGap())
        );

        jPanel10.add(jPanel12);
        jPanel12.setBounds(10, 390, 440, 45);

        jTabbedPane1.addTab("Ocorrência(s)", jPanel10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 30, 477, 493);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoActionPerformed
        // TODO add your handling code here:
        if (jIdPesqCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            preencherTabelaRegistroEventos("SELECT * FROM REGIMENTO_DISCIPLINAR_INTERNOS "
                    + "INNER JOIN LOCALEVENTOS "
                    + "ON REGIMENTO_DISCIPLINAR_INTERNOS.IdLocal=LOCALEVENTOS.IdLocal "
                    + "INNER JOIN NATUREZAEVENTOS "
                    + "ON REGIMENTO_DISCIPLINAR_INTERNOS.IdNatureza=NATUREZAEVENTOS.IdNatureza "
                    + "INNER JOIN COLABORDOR "
                    + "ON REGIMENTO_DISCIPLINAR_INTERNOS.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE REGIMENTO_DISCIPLINAR_INTERNOS.IdReg='" + jIdPesqCodigo.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqCodigoActionPerformed

    private void jBtPesqDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDatasActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jDataPesqInicial.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
            jDataPesqInicial.requestFocus();
        } else {
            if (jDataPesqFinal.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                jDataPesqFinal.requestFocus();
            } else {
                if (jDataPesqInicial.getDate().after(jDataPesqFinal.getDate())) {
                    JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                } else {
                    SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                    dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                    dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                    preencherTabelaRegistroEventos("SELECT * FROM REGIMENTO_DISCIPLINAR_INTERNOS "
                            + "INNER JOIN LOCALEVENTOS "
                            + "ON REGIMENTO_DISCIPLINAR_INTERNOS.IdLocal=LOCALEVENTOS.IdLocal "
                            + "INNER JOIN NATUREZAEVENTOS "
                            + "ON REGIMENTO_DISCIPLINAR_INTERNOS.IdNatureza=NATUREZAEVENTOS.IdNatureza "
                            + "INNER JOIN COLABORADOR "
                            + "ON REGIMENTO_DISCIPLINAR_INTERNOS.IdFunc=COLABORADOR.IdFunc "
                            + "WHERE REGIMENTO_DISCIPLINAR_INTERNOS.DataReg BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDatasActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaRegistroEventos("SELECT * FROM REGIMENTO_DISCIPLINAR_INTERNOS "
                    + "INNER JOIN LOCALEVENTOS "
                    + "ON REGIMENTO_DISCIPLINAR_INTERNOS.IdLocal=LOCALEVENTOS.IdLocal "
                    + "INNER JOIN NATUREZAEVENTOS "
                    + "ON REGIMENTO_DISCIPLINAR_INTERNOS.IdNatureza=NATUREZAEVENTOS.IdNatureza "
                    + "INNER JOIN COLABORADOR "
                    + "ON REGIMENTO_DISCIPLINAR_INTERNOS.IdFunc=COLABORADOR.IdFunc");
        } else {
            jtotalRegistros.setText("");
            limparTabelaRegistrosEventos();
        }
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged

    private void jTabelaRegistroEventosIndisciplinarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaRegistroEventosIndisciplinarMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1 && evt.getClickCount() == 1) {
            String IdLanc = "" + jTabelaRegistroEventosIndisciplinar.getValueAt(jTabelaRegistroEventosIndisciplinar.getSelectedRow(), 0);
            jIdPesqCodigo.setText(IdLanc);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoInterno.setEnabled(true);
            jBtFichaOcorrencia.setEnabled(!true);
            jBtNovaOcorrencia.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM REGIMENTO_DISCIPLINAR_INTERNOS "
                        + "INNER JOIN NATUREZAEVENTOS "
                        + "ON REGIMENTO_DISCIPLINAR_INTERNOS.IdNatureza=NATUREZAEVENTOS.IdNatureza "
                        + "INNER JOIN LOCALEVENTOS "
                        + "ON REGIMENTO_DISCIPLINAR_INTERNOS.IdLocal=LOCALEVENTOS.IdLocal "
                        + "INNER JOIN COLABORADOR "
                        + "ON REGIMENTO_DISCIPLINAR_INTERNOS.IdFunc=COLABORADOR.IdFunc "
                        + "WHERE IdReg='" + IdLanc + "'");
                conecta.rs.first();
                jCodigoReg.setText(String.valueOf(conecta.rs.getInt("IdReg")));
                jStatusReg.setText(conecta.rs.getString("StatusReg"));
                jColaboradorAutorizador.setText(conecta.rs.getString("NomeFunc"));
                jDataReg.setDate(conecta.rs.getDate("DataReg"));
                jHorarioEvento.setText(conecta.rs.getString("HorarioEvento"));
                jNaturezaEvento.setText(conecta.rs.getString("DescricaoNatureza"));
                jLocalEvento.setText(conecta.rs.getString("DescricaoLocal"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados.\nERRO: " + e);
            }
            preencherTabelaInternos("SELECT * FROM AUTORES_REGIMENTO_DISCIPLINAR "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN REGIMENTO_DISCIPLINAR_INTERNOS "
                    + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdReg=REGIMENTO_DISCIPLINAR_INTERNOS.IdReg "
                    + "INNER JOIN PAVILHAO "
                    + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN CELAS "
                    + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdCela=CELAS.IdCela "
                    + "WHERE AUTORES_REGIMENTO_DISCIPLINAR.IdReg='" + IdLanc + "'");
            preencherTabelaInternosHistorico("SELECT * FROM OCORRENCIA_AUTORES "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON OCORRENCIA_AUTORES.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN REGIMENTO_DISCIPLINAR_INTERNOS "
                    + "ON OCORRENCIA_AUTORES.IdReg=REGIMENTO_DISCIPLINAR_INTERNOS.IdReg "
                    + "WHERE OCORRENCIA_AUTORES.IdReg='" + IdLanc + "'");
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaRegistroEventosIndisciplinarMouseClicked

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jBtPesqColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqColaboradorActionPerformed
        // TODO add your handling code here:        
        TelaPesqColaboradorEventosRegimentoInterno objPesqFuncVitima = new TelaPesqColaboradorEventosRegimentoInterno();
        TelaModuloSeguranca.jPainelSeguranca.add(objPesqFuncVitima);
        objPesqFuncVitima.show();
    }//GEN-LAST:event_jBtPesqColaboradorActionPerformed

    private void jBtPesqNaturezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNaturezaActionPerformed
        // TODO add your handling code here:        
        TelaPesquisarNaturezaEventoRegimentoDisciplinar objPesqNatuEven = new TelaPesquisarNaturezaEventoRegimentoDisciplinar();
        TelaModuloSeguranca.jPainelSeguranca.add(objPesqNatuEven);
        objPesqNatuEven.show();
    }//GEN-LAST:event_jBtPesqNaturezaActionPerformed

    private void jBtPesqLocalEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqLocalEventoActionPerformed
        // TODO add your handling code here:
        TelaPesquisarLocalEventoRegimeDisciplinar objLocalEvento = new TelaPesquisarLocalEventoRegimeDisciplinar();
        TelaModuloSeguranca.jPainelSeguranca.add(objLocalEvento);
        objLocalEvento.show();
    }//GEN-LAST:event_jBtPesqLocalEventoActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        if (codigoUser == codUserAcesso && nomeTela.equals(telaAplicarRegistroPenalidadeDisciplinas) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 1;
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            limparTabelaInternosAutor();
            limparTabelaHistorico();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        if (codigoUser == codUserAcesso && nomeTela.equals(telaAplicarRegistroPenalidadeDisciplinas) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            objRegEvenDisciplinar.setStatusLanc(jStatusReg.getText());
            if (jStatusReg.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                Alterar();
                corCampos();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        if (codigoUser == codUserAcesso && nomeTela.equals(telaAplicarRegistroPenalidadeDisciplinas) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            verificarRegistroInternos();
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            if (jStatusReg.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else if (jCodigoReg.getText().equals(idRegAutor) || jCodigoReg.getText().equals(idRegOcorrencia)) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído até que seja(m)\nexcluído(s) os registro(s) da(s) outra(s) aba(s).");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objRegEvenDisciplinar.setIdLanc(Integer.valueOf(jCodigoReg.getText()));
                    control.excluirRegimentoDisciplinar(objRegEvenDisciplinar);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação               
                    Excluir();
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        if (codigoUser == codUserAcesso && nomeTela.equals(telaAplicarRegistroPenalidadeDisciplinas) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jDataReg.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a datado registro.");
                jDataReg.requestFocus();
                jDataReg.setBackground(Color.red);
            } else if (jColaboradorAutorizador.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe no colaborador autorizador.");
            } else if (jNaturezaEvento.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a natureza do Evento.");
            } else if (jLocalEvento.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o local do evento.");
            } else {
                objRegEvenDisciplinar.setStatusLanc(jStatusReg.getText());
                objRegEvenDisciplinar.setDataLanc(jDataReg.getDate());
                objRegEvenDisciplinar.setNomeColaborador(jColaboradorAutorizador.getText());
                objRegEvenDisciplinar.setDescricaoNatureza(jNaturezaEvento.getText());
                objRegEvenDisciplinar.setHorarioEvento(jHorarioEvento.getText());
                objRegEvenDisciplinar.setDescricaoLocalEvento(jLocalEvento.getText());
                objRegEvenDisciplinar.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objRegEvenDisciplinar.setUsuarioInsert(nameUser);
                    objRegEvenDisciplinar.setDataInsert(dataModFinal);
                    objRegEvenDisciplinar.setHorarioInsert(horaMov);
                    control.incluirRegimentoDisciplinar(objRegEvenDisciplinar);
                    buscarCodigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    objRegEvenDisciplinar.setUsuarioUp(nameUser);
                    objRegEvenDisciplinar.setDataUp(dataModFinal);
                    objRegEvenDisciplinar.setHorarioUp(horaMov);
                    objRegEvenDisciplinar.setIdLanc(Integer.valueOf(jCodigoReg.getText()));
                    control.alterarRegimentoDisciplinar(objRegEvenDisciplinar);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaInternoAutor.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível finalizar esse lançamento, não existe internos relacionados\na esse registro.");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM REGIMENTO_DISCIPLINAR_INTERNOS "
                        + "WHERE IdReg='" + jCodigoReg.getText() + "'");
                conecta.rs.first();
                jStatusReg.setText(conecta.rs.getString("StatusReg"));
                if (jStatusReg.getText().equals("FINALIZADO")) {
                    JOptionPane.showMessageDialog(rootPane, "Registro já foi finalizado");
                } else {
                    Finalizar();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível finalizar esse registro.\nERRO: " + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaRegimeDisciplinar objAudiReg = new TelaAuditoriaRegimeDisciplinar();
        TelaModuloSeguranca.jPainelSeguranca.add(objAudiReg);
        objAudiReg.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtPesqInternoRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoRegActionPerformed
        // TODO add your handling code here:
        TelaPesqInternosEventosAutorRegimeDisciplinar objPesqIntAut = new TelaPesqInternosEventosAutorRegimeDisciplinar();
        TelaModuloSeguranca.jPainelSeguranca.add(objPesqIntAut);
        objPesqIntAut.show();
    }//GEN-LAST:event_jBtPesqInternoRegActionPerformed

    private void jBtPesqPavilhaoDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqPavilhaoDestinoActionPerformed
        // TODO add your handling code here:
        TelaPesqPavilhaoEventoRegimentoDisciplinar objPesqPav = new TelaPesqPavilhaoEventoRegimentoDisciplinar();
        TelaModuloSeguranca.jPainelSeguranca.add(objPesqPav);
        objPesqPav.show();
    }//GEN-LAST:event_jBtPesqPavilhaoDestinoActionPerformed

    private void jTabelaInternoAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternoAutorMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idInterno = "" + jTabelaInternoAutor.getValueAt(jTabelaInternoAutor.getSelectedRow(), 1);
            jCodigoInternoReg.setText(idInterno);
            String nomeInterno = "" + jTabelaInternoAutor.getValueAt(jTabelaInternoAutor.getSelectedRow(), 2);
            jNomeInternoReg.setText(nomeInterno);
            // Habilitar os botões
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(true);
            jBtExcluirInterno.setEnabled(true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(true);
            jBtAuditoriaInterno.setEnabled(true);
            jBtZoon.setEnabled(true);
            jBtFichaOcorrencia.setEnabled(true);
            //
            jComboBoxCelaDestino.removeAllItems();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM AUTORES_REGIMENTO_DISCIPLINAR "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN REGIMENTO_DISCIPLINAR_INTERNOS "
                        + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdReg=REGIMENTO_DISCIPLINAR_INTERNOS.IdReg "
                        + "INNER JOIN CELAS "
                        + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdCela=CELAS.IdCela INNER JOIN PAVILHAO ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "WHERE PRONTUARIOSCRC.NomeInternoCrc='" + jNomeInternoReg.getText() + "' "
                        + "AND AUTORES_REGIMENTO_DISCIPLINAR.IdReg='" + jCodigoReg.getText() + "'");
                conecta.rs.first();
                jCodigoInternoReg.setText(conecta.rs.getString("IdInternoCrc"));
                jMatriculaPenalReg.setText(conecta.rs.getString("MatriculaCrc"));
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon v = new javax.swing.ImageIcon(caminho);
                jFotoInternoReg.setIcon(v);
                jFotoInternoReg.setIcon(new ImageIcon(v.getImage().getScaledInstance(jFotoInternoReg.getWidth(), jFotoInternoReg.getHeight(), Image.SCALE_DEFAULT)));
                jNomeInternoReg.setText(conecta.rs.getString("NomeInternoCrc"));
                jRG.setText(conecta.rs.getString("RgInternoCrc"));
                jAlcunha.setText(conecta.rs.getString("AlcunhaCrc"));
                jPavilhaoDestino.setText(conecta.rs.getString("DescricaoPav"));
                jComboBoxCelaDestino.addItem(conecta.rs.getString("EndCelaPav"));
                jQtdDias.setText(String.valueOf(conecta.rs.getInt("QtdeDias")));
                idItemAutor = conecta.rs.getInt("IdAutor");
                jDataIncioDisciplina.setDate(conecta.rs.getDate("DataInicio"));
                jDataTerminoDisciplina.setDate(conecta.rs.getDate("DataTermino"));
                //
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem exibidos!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaInternoAutorMouseClicked

    private void jBtZoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtZoonActionPerformed
        // TODO add your handling code here:
        mostraTelaFotoCrc();
    }//GEN-LAST:event_jBtZoonActionPerformed

    private void jBtNovoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAplicarRegistroPenalidadeDisciplinasAutor);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaAplicarRegistroPenalidadeDisciplinasAutor) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            objRegEvenDisciplinar.setStatusLanc(jStatusReg.getText());
            if (jStatusReg.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovoInterno();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoInternoActionPerformed

    private void jBtAlterarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAplicarRegistroPenalidadeDisciplinasAutor);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaAplicarRegistroPenalidadeDisciplinasAutor) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            objRegEvenDisciplinar.setStatusLanc(jStatusReg.getText());
            if (jStatusReg.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 4;
                AlterarInterno();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarInternoActionPerformed

    private void jBtExcluirInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAplicarRegistroPenalidadeDisciplinasAutor);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaAplicarRegistroPenalidadeDisciplinasAutor) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            verificarOcorrenciaInterno();
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objRegEvenDisciplinar.setStatusLanc(jStatusReg.getText());
            if (jCodigoInternoReg.getText().equals(codInternoOcr)) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser exluído, existe ocorrência para esse interno.");
            } else {
                if (jStatusReg.getText().equals("FINALIZADO")) {
                    JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        objAutor.setIdAutor(idItemAutor);
                        controle.excluirAutorEventoDisciplinar(objAutor);
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação   
                        ExcluirInterno();
                        preencherTabelaInternos("SELECT * FROM AUTORES_REGIMENTO_DISCIPLINAR "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "INNER JOIN REGIMENTO_DISCIPLINAR_INTERNOS "
                                + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdReg=REGIMENTO_DISCIPLINAR_INTERNOS.IdReg "
                                + "INNER JOIN PAVILHAO "
                                + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdPav=PAVILHAO.IdPav "
                                + "INNER JOIN CELAS "
                                + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdCela=CELAS.IdCela "
                                + "WHERE AUTORES_REGIMENTO_DISCIPLINAR.IdReg='" + jCodigoReg.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirInternoActionPerformed

    private void jBtSalvarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoActionPerformed
        // TODO add your handling code here: 
        buscarAcessoUsuario(telaAplicarRegistroPenalidadeDisciplinasAutor);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaAplicarRegistroPenalidadeDisciplinasAutor) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jNomeInternoReg.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
            } else if (jPavilhaoDestino.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o pavilhão de destino do interno.");
            } else if (jComboBoxCelaDestino.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(rootPane, "Selecione corretamente a cela de destino.");
            } else if (jQtdDias.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a quantidade de dias para disciplina.");
            } else if (jDataIncioDisciplina.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de inicio da disciplina.");
            } else if (jDataTerminoDisciplina.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data de termino da disciplina.");
            } else if (jDataIncioDisciplina.getDate().after(jDataTerminoDisciplina.getDate())) {
                JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
            } else {
                objAutor.setUtilizaSaida(utilizaSaida);
                objAutor.setNomeInternoCrc(jNomeInternoReg.getText());
                objAutor.setDescricaoPavilhao(jPavilhaoDestino.getText());
                objAutor.setDescricaoCela((String) jComboBoxCelaDestino.getSelectedItem());
                objAutor.setQtdeDias(Integer.valueOf(jQtdDias.getText()));
                objAutor.setDataInicio(jDataIncioDisciplina.getDate());
                objAutor.setDataTermino(jDataTerminoDisciplina.getDate());
                if (acao == 3) {
                    objAutor.setUsuarioInsert(nameUser);
                    objAutor.setDataInsert(dataModFinal);
                    objAutor.setHorarioInsert(horaMov);
                    objAutor.setIdReg(Integer.valueOf(jCodigoReg.getText()));
                    controle.incluirAutorEventoDisciplinar(objAutor);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação    
                    SalvarInterno();
                    preencherTabelaInternos("SELECT * FROM AUTORES_REGIMENTO_DISCIPLINAR "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGIMENTO_DISCIPLINAR_INTERNOS "
                            + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdReg=REGIMENTO_DISCIPLINAR_INTERNOS.IdReg "
                            + "INNER JOIN PAVILHAO "
                            + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdPav=PAVILHAO.IdPav "
                            + "INNER JOIN CELAS "
                            + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdCela=CELAS.IdCela "
                            + "WHERE AUTORES_REGIMENTO_DISCIPLINAR.IdReg='" + jCodigoReg.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 4) {
                    objAutor.setUsuarioInsert(nameUser);
                    objAutor.setDataInsert(dataModFinal);
                    objAutor.setHorarioInsert(horaMov);
                    objAutor.setIdReg(Integer.valueOf(jCodigoReg.getText()));
                    objAutor.setIdAutor(idItemAutor);
                    controle.alterarAutorEventoDisciplinar(objAutor);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação     
                    SalvarInterno();
                    preencherTabelaInternos("SELECT * FROM AUTORES_REGIMENTO_DISCIPLINAR "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGIMENTO_DISCIPLINAR_INTERNOS "
                            + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdReg=REGIMENTO_DISCIPLINAR_INTERNOS.IdReg "
                            + "INNER JOIN PAVILHAO "
                            + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdPav=PAVILHAO.IdPav "
                            + "INNER JOIN CELAS "
                            + "ON AUTORES_REGIMENTO_DISCIPLINAR.IdCela=CELAS.IdCela "
                            + "WHERE AUTORES_REGIMENTO_DISCIPLINAR.IdReg='" + jCodigoReg.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarInternoActionPerformed

    private void jBtCancelarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarInternoActionPerformed
        // TODO add your handling code here:
        CancelarInterno();
    }//GEN-LAST:event_jBtCancelarInternoActionPerformed

    private void jBtAuditoriaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaInternoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaRegimeDisciplinarInternos objAudiRegInt = new TelaAuditoriaRegimeDisciplinarInternos();
        TelaModuloSeguranca.jPainelSeguranca.add(objAudiRegInt);
        objAudiRegInt.show();
    }//GEN-LAST:event_jBtAuditoriaInternoActionPerformed

    private void jBtNovaOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaOcorrenciaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAplicarRegistroPenalidadeDisciplinasOCR);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaAplicarRegistroPenalidadeDisciplinasOCR) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            objRegEvenDisciplinar.setStatusLanc(jStatusReg.getText());
            if (jStatusReg.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 5;
                NovaOcorrencia();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                preencherComboBoxInterno();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovaOcorrenciaActionPerformed

    private void jBtAlterarOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarOcorrenciaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAplicarRegistroPenalidadeDisciplinasOCR);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaAplicarRegistroPenalidadeDisciplinasOCR) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            objRegEvenDisciplinar.setStatusLanc(jStatusReg.getText());
            if (jStatusReg.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 6;
                AlterarOcorrencia();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                // preencherComboBoxInterno();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarOcorrenciaActionPerformed

    private void jBtExcluirOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirOcorrenciaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAplicarRegistroPenalidadeDisciplinasOCR);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaAplicarRegistroPenalidadeDisciplinasOCR) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objRegEvenDisciplinar.setStatusLanc(jStatusReg.getText());
            if (jStatusReg.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objOcrDisc.setIdOcr(Integer.valueOf(jCodigoOcorrencia.getText()));
                    controleOcr.excluirOcorrenciaDisciplinar(objOcrDisc);
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação               
                    ExcluirOcorrencia();
                    preencherTabelaInternosHistorico("SELECT * FROM OCORRENCIA_AUTORES "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON OCORRENCIA_AUTORES.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGIMENTO_DISCIPLINAR_INTERNOS "
                            + "ON OCORRENCIA_AUTORES.IdReg=REGIMENTO_DISCIPLINAR_INTERNOS.IdReg "
                            + "WHERE OCORRENCIA_AUTORES.IdReg='" + jCodigoReg.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirOcorrenciaActionPerformed

    private void jBtSalvarOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarOcorrenciaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAplicarRegistroPenalidadeDisciplinasOCR);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaAplicarRegistroPenalidadeDisciplinasOCR) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jDataOcorrencia.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data da ocorrência.");
            } else if (jComboBoxNomeInternoOcorrencia.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(rootPane, "Informe para qual interno será feito a ocorrência.");
            } else if (jTextaOcorrecia.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o texto da ocorrência.");
            } else {
                objOcrDisc.setDataOcr(jDataOcorrencia.getDate());
                objOcrDisc.setNomeInterno((String) jComboBoxNomeInternoOcorrencia.getSelectedItem());
                objOcrDisc.setOcorrencia(jTextaOcorrecia.getText());
                if (acao == 5) {
                    objOcrDisc.setUsuarioInsert(nameUser);
                    objOcrDisc.setDataInsert(dataModFinal);
                    objOcrDisc.setHorarioInsert(horaMov);
                    objOcrDisc.setIdReg(Integer.valueOf(jCodigoReg.getText()));
                    controleOcr.incluirOcorrenciaDisciplinar(objOcrDisc);
                    buscarCodigoOcorrencia();
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                    SalvarOcorrencia();
                    preencherTabelaInternosHistorico("SELECT * FROM OCORRENCIA_AUTORES "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON OCORRENCIA_AUTORES.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGIMENTO_DISCIPLINAR_INTERNOS "
                            + "ON OCORRENCIA_AUTORES.IdReg=REGIMENTO_DISCIPLINAR_INTERNOS.IdReg "
                            + "WHERE OCORRENCIA_AUTORES.IdReg='" + jCodigoReg.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 6) {
                    objOcrDisc.setUsuarioUp(nameUser);
                    objOcrDisc.setDataUp(dataModFinal);
                    objOcrDisc.setHorarioUp(horaMov);
                    objOcrDisc.setIdReg(Integer.valueOf(jCodigoReg.getText()));
                    objOcrDisc.setIdOcr(Integer.valueOf(jCodigoOcorrencia.getText()));
                    controleOcr.alterarOcorrenciaDisciplinar(objOcrDisc);
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                    SalvarOcorrencia();
                    preencherTabelaInternosHistorico("SELECT * FROM OCORRENCIA_AUTORES "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON OCORRENCIA_AUTORES.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGIMENTO_DISCIPLINAR_INTERNOS "
                            + "ON OCORRENCIA_AUTORES.IdReg=REGIMENTO_DISCIPLINAR_INTERNOS.IdReg "
                            + "WHERE OCORRENCIA_AUTORES.IdReg='" + jCodigoReg.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarOcorrenciaActionPerformed

    private void jBtCancelarOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarOcorrenciaActionPerformed
        // TODO add your handling code here:
        CancelarOcorrencia();
    }//GEN-LAST:event_jBtCancelarOcorrenciaActionPerformed

    private void jTabelaOcorrenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaOcorrenciasMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeInternoHistorico = "" + jTabelaOcorrencias.getValueAt(jTabelaOcorrencias.getSelectedRow(), 2);
            jComboBoxNomeInternoOcorrencia.setSelectedItem(nomeInternoHistorico);
            codOcorrencia = "" + jTabelaOcorrencias.getValueAt(jTabelaOcorrencias.getSelectedRow(), 0);
            jCodigoOcorrencia.setText(codOcorrencia);
            // Habilitar os botões
            jBtNovaOcorrencia.setEnabled(!true);
            jBtAlterarOcorrencia.setEnabled(true);
            jBtExcluirOcorrencia.setEnabled(true);
            jBtSalvarOcorrencia.setEnabled(!true);
            jBtCancelarOcorrencia.setEnabled(true);
            jBtAuditoriaOcorrencia.setEnabled(true);
            jBtImpressao.setEnabled(true);
            //
            jComboBoxNomeInternoOcorrencia.removeAllItems();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM OCORRENCIA_AUTORES "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON OCORRENCIA_AUTORES.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN REGIMENTO_DISCIPLINAR_INTERNOS "
                        + "ON OCORRENCIA_AUTORES.IdReg=REGIMENTO_DISCIPLINAR_INTERNOS.IdReg "
                        + "WHERE OCORRENCIA_AUTORES.IdOcr='" + codOcorrencia + "' "
                        + "AND OCORRENCIA_AUTORES.IdReg='" + jCodigoReg.getText() + "'");
                conecta.rs.first();
                jCodigoOcorrencia.setText(conecta.rs.getString("IdOcr"));
                jDataOcorrencia.setDate(conecta.rs.getDate("DataReg"));
                jComboBoxNomeInternoOcorrencia.addItem(conecta.rs.getString("NomeInternoCrc"));
                jTextaOcorrecia.setText(conecta.rs.getString("Ocorrencia"));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem exibidos!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaOcorrenciasMouseClicked

    private void jBtAuditoriaOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaOcorrenciaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEventosInternosOcorrencia objAudiRegOcr = new TelaAuditoriaEventosInternosOcorrencia();
        TelaModuloSeguranca.jPainelSeguranca.add(objAudiRegOcr);
        objAudiRegOcr.show();
    }//GEN-LAST:event_jBtAuditoriaOcorrenciaActionPerformed

    private void jComboBoxCelaDestinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxCelaDestinoMouseClicked
        // TODO add your handling code here:
        jComboBoxCelaDestino.removeAllItems();
        preencherComboBoxCela();
    }//GEN-LAST:event_jComboBoxCelaDestinoMouseClicked

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioOcorrenciaRegimeDisciplinar.jasper";
            conecta.executaSQL("SELECT * FROM OCORRENCIA_AUTORES "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON OCORRENCIA_AUTORES.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN REGIMENTO_DISCIPLINAR_INTERNOS "
                    + "ON OCORRENCIA_AUTORES.IdReg=REGIMENTO_DISCIPLINAR_INTERNOS.IdReg "
                    + "WHERE OCORRENCIA_AUTORES.IdOcr='" + codOcorrencia + "' "
                    + "AND OCORRENCIA_AUTORES.IdReg='" + jCodigoReg.getText() + "'");
            HashMap parametros = new HashMap();
            parametros.put("codOcorrencia", codOcorrencia);
            parametros.put("CodRegistro", jCodigoReg.getText());
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Ocorrência Regime Disciplinar");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jBtImpressaoActionPerformed

    private void jBtFichaOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFichaOcorrenciaActionPerformed
        // TODO add your handling code here:
        if (jCodigoInternoReg.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o interno para preencher a ficha de indisciplina (FALTAS).");
        } else {
            mostrarFaltasFO2();
        }
    }//GEN-LAST:event_jBtFichaOcorrenciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField jAlcunha;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarInterno;
    private javax.swing.JButton jBtAlterarOcorrencia;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaInterno;
    private javax.swing.JButton jBtAuditoriaOcorrencia;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarInterno;
    private javax.swing.JButton jBtCancelarOcorrencia;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirInterno;
    private javax.swing.JButton jBtExcluirOcorrencia;
    private javax.swing.JButton jBtFichaOcorrencia;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtNovaOcorrencia;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoInterno;
    private javax.swing.JButton jBtPesqCodigo;
    private javax.swing.JButton jBtPesqColaborador;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqInternoReg;
    private javax.swing.JButton jBtPesqLocalEvento;
    private javax.swing.JButton jBtPesqNatureza;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtPesqPavilhaoDestino;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarInterno;
    private javax.swing.JButton jBtSalvarOcorrencia;
    public static javax.swing.JButton jBtZoon;
    private javax.swing.JCheckBox jCheckBoxTodos;
    public static javax.swing.JTextField jCodigoInternoReg;
    public static javax.swing.JTextField jCodigoOcorrencia;
    public static javax.swing.JTextField jCodigoReg;
    public static javax.swing.JTextField jColaboradorAutorizador;
    public static javax.swing.JComboBox jComboBoxCelaDestino;
    private javax.swing.JComboBox jComboBoxNomeInternoOcorrencia;
    private com.toedter.calendar.JDateChooser jDataIncioDisciplina;
    private com.toedter.calendar.JDateChooser jDataOcorrencia;
    private com.toedter.calendar.JDateChooser jDataPesqFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    private com.toedter.calendar.JDateChooser jDataReg;
    private com.toedter.calendar.JDateChooser jDataTerminoDisciplina;
    public static javax.swing.JLabel jFotoInternoReg;
    private javax.swing.JTextField jHorarioEvento;
    private javax.swing.JTextField jIdPesqCodigo;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jLocalEvento;
    public static javax.swing.JTextField jMatriculaPenalReg;
    public static javax.swing.JTextField jNaturezaEvento;
    public static javax.swing.JTextField jNomeInternoReg;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JTextField jPavilhaoDestino;
    private javax.swing.JFormattedTextField jQtdDias;
    public static javax.swing.JTextField jRG;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane9;
    public static javax.swing.JTextField jStatusReg;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaInternoAutor;
    private javax.swing.JTable jTabelaOcorrencias;
    private javax.swing.JTable jTabelaRegistroEventosIndisciplinar;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea jTextaOcorrecia;
    private javax.swing.JTextField jtotalItens;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
        //
        jTextaOcorrecia.setLineWrap(true);
        jTextaOcorrecia.setWrapStyleWord(true);
    }

    public void corCampos() {
        jCodigoReg.setBackground(Color.white);
        jStatusReg.setBackground(Color.white);
        jDataReg.setBackground(Color.white);
        jColaboradorAutorizador.setBackground(Color.white);
        jNaturezaEvento.setBackground(Color.white);
        jHorarioEvento.setBackground(Color.white);
        jLocalEvento.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jCodigoInternoReg.setBackground(Color.white);
        jMatriculaPenalReg.setBackground(Color.white);
        jNomeInternoReg.setBackground(Color.white);
        jRG.setBackground(Color.white);
        jAlcunha.setBackground(Color.white);
        jPavilhaoDestino.setBackground(Color.white);
        jComboBoxCelaDestino.setBackground(Color.white);
        jQtdDias.setBackground(Color.white);
        jDataIncioDisciplina.setBackground(Color.white);
        jDataTerminoDisciplina.setBackground(Color.white);
        jtotalItens.setBackground(Color.white);
        //
        jCodigoOcorrencia.setBackground(Color.white);
        jDataOcorrencia.setBackground(Color.white);
        jComboBoxNomeInternoOcorrencia.setBackground(Color.white);
        jTextaOcorrecia.setBackground(Color.white);
    }

    public void Novo() {
        jCodigoReg.setText("");
        jStatusReg.setText("ABERTO");
        jDataReg.setCalendar(Calendar.getInstance());
        jColaboradorAutorizador.setText("");
        jNaturezaEvento.setText("");
        jHorarioEvento.setText("00:00");
        jLocalEvento.setText("");
        jObservacao.setText("");
        //
        jCodigoInternoReg.setText("");
        jMatriculaPenalReg.setText("");
        jFotoInternoReg.setIcon(null);
        jNomeInternoReg.setText("");
        jRG.setText("");
        jAlcunha.setText("");
        jPavilhaoDestino.setText("");
        jComboBoxCelaDestino.setSelectedItem(null);
        jQtdDias.setText("");
        jDataIncioDisciplina.setDate(null);
        jDataTerminoDisciplina.setDate(null);
        jtotalItens.setText("");
        //
        jCodigoOcorrencia.setText("");
        jDataOcorrencia.setDate(null);
        jComboBoxNomeInternoOcorrencia.setSelectedItem("Selecione");
        jTextaOcorrecia.setText("");
        //
        jDataReg.setEnabled(true);
        jHorarioEvento.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtPesqColaborador.setEnabled(true);
        jBtPesqNatureza.setEnabled(true);
        jBtPesqLocalEvento.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //ABA AUTORES    
        jBtPesqInternoReg.setEnabled(!true);
        jBtPesqPavilhaoDestino.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jQtdDias.setEnabled(!true);
        jDataIncioDisciplina.setEnabled(!true);
        jDataTerminoDisciplina.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        jBtFichaOcorrencia.setEnabled(!true);
        // ABA OCORRÊNCIA      
        jDataOcorrencia.setEnabled(!true);
        jComboBoxNomeInternoOcorrencia.setEnabled(!true);
        jTextaOcorrecia.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(!true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void Alterar() {
        // ABA INTERNOS AUTORES
        jCodigoInternoReg.setText("");
        jMatriculaPenalReg.setText("");
        jNomeInternoReg.setText("");
        jRG.setText("");
        jAlcunha.setText("");
        jPavilhaoDestino.setText("");
        jComboBoxCelaDestino.setSelectedItem(null);
        jQtdDias.setText("");
        jDataIncioDisciplina.setDate(null);
        jDataTerminoDisciplina.setDate(null);
        jtotalItens.setText("");
        //
        jCodigoOcorrencia.setText("");
        jDataOcorrencia.setDate(null);
        jComboBoxNomeInternoOcorrencia.setSelectedItem(null);
        jTextaOcorrecia.setText("");
        //
        jDataReg.setEnabled(true);
        jHorarioEvento.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtPesqColaborador.setEnabled(true);
        jBtPesqNatureza.setEnabled(true);
        jBtPesqLocalEvento.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //ABA AUTORES    
        jBtPesqInternoReg.setEnabled(!true);
        jBtPesqPavilhaoDestino.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jQtdDias.setEnabled(!true);
        jDataIncioDisciplina.setEnabled(!true);
        jDataTerminoDisciplina.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // ABA OCORRÊNCIA      
        jDataOcorrencia.setEnabled(!true);
        jComboBoxNomeInternoOcorrencia.setEnabled(!true);
        jTextaOcorrecia.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(!true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void Excluir() {
        jCodigoReg.setText("");
        jStatusReg.setText("");
        jDataReg.setDate(null);
        jColaboradorAutorizador.setText("");
        jNaturezaEvento.setText("");
        jHorarioEvento.setText("00:00");
        jLocalEvento.setText("");
        jObservacao.setText("");
        //
        jCodigoInternoReg.setText("");
        jMatriculaPenalReg.setText("");
        jFotoInternoReg.setIcon(null);
        jNomeInternoReg.setText("");
        jRG.setText("");
        jAlcunha.setText("");
        jPavilhaoDestino.setText("");
        jComboBoxCelaDestino.setSelectedItem(null);
        jQtdDias.setText("");
        jDataIncioDisciplina.setDate(null);
        jDataTerminoDisciplina.setDate(null);
        jtotalItens.setText("");
        //
        jCodigoOcorrencia.setText("");
        jDataOcorrencia.setDate(null);
        jComboBoxNomeInternoOcorrencia.setSelectedItem(null);
        jTextaOcorrecia.setText("");
        //
        jDataReg.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtPesqColaborador.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //ABA AUTORES    
        jBtPesqInternoReg.setEnabled(!true);
        jBtPesqPavilhaoDestino.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jQtdDias.setEnabled(!true);
        jDataIncioDisciplina.setEnabled(!true);
        jDataTerminoDisciplina.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // ABA OCORRÊNCIA      
        jDataOcorrencia.setEnabled(!true);
        jComboBoxNomeInternoOcorrencia.setEnabled(!true);
        jTextaOcorrecia.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(!true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void Salvar() {
        jDataReg.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtPesqColaborador.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //ABA AUTORES    
        jBtPesqInternoReg.setEnabled(!true);
        jBtPesqPavilhaoDestino.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jQtdDias.setEnabled(!true);
        jDataIncioDisciplina.setEnabled(!true);
        jDataTerminoDisciplina.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // ABA OCORRÊNCIA      
        jDataOcorrencia.setEnabled(!true);
        jComboBoxNomeInternoOcorrencia.setEnabled(!true);
        jTextaOcorrecia.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void Cancelar() {
        if (jCodigoReg.getText().equals("")) {
            jStatusReg.setText("");
            jDataReg.setDate(null);
            jColaboradorAutorizador.setText("");
            jNaturezaEvento.setText("");
            jHorarioEvento.setText("00:00");
            jLocalEvento.setText("");
            jObservacao.setText("");
            //
            jDataReg.setEnabled(!true);
            jHorarioEvento.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtPesqColaborador.setEnabled(!true);
            jBtPesqNatureza.setEnabled(!true);
            jBtPesqLocalEvento.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            //ABA AUTORES    
            jBtPesqInternoReg.setEnabled(!true);
            jBtPesqPavilhaoDestino.setEnabled(!true);
            jBtZoon.setEnabled(!true);
            //
            jQtdDias.setEnabled(!true);
            jDataIncioDisciplina.setEnabled(!true);
            jDataTerminoDisciplina.setEnabled(!true);
            //
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(!true);
            jBtExcluirInterno.setEnabled(!true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(!true);
            jBtAuditoriaInterno.setEnabled(!true);
            // ABA OCORRÊNCIA      
            jDataOcorrencia.setEnabled(!true);
            jComboBoxNomeInternoOcorrencia.setEnabled(!true);
            jTextaOcorrecia.setEnabled(!true);
            jBtImpressao.setEnabled(!true);
            //
            jBtNovaOcorrencia.setEnabled(!true);
            jBtAlterarOcorrencia.setEnabled(!true);
            jBtExcluirOcorrencia.setEnabled(!true);
            jBtSalvarOcorrencia.setEnabled(!true);
            jBtCancelarOcorrencia.setEnabled(!true);
            jBtAuditoriaOcorrencia.setEnabled(!true);
        } else {
            jDataReg.setEnabled(!true);
            jHorarioEvento.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtPesqColaborador.setEnabled(!true);
            jBtPesqNatureza.setEnabled(!true);
            jBtPesqLocalEvento.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //ABA AUTORES    
            jBtPesqInternoReg.setEnabled(!true);
            jBtPesqPavilhaoDestino.setEnabled(!true);
            jBtZoon.setEnabled(!true);
            //
            jQtdDias.setEnabled(!true);
            jDataIncioDisciplina.setEnabled(!true);
            jDataTerminoDisciplina.setEnabled(!true);
            //
            jBtNovoInterno.setEnabled(true);
            jBtAlterarInterno.setEnabled(!true);
            jBtExcluirInterno.setEnabled(!true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(!true);
            jBtAuditoriaInterno.setEnabled(!true);
            // ABA OCORRÊNCIA      
            jDataOcorrencia.setEnabled(!true);
            jComboBoxNomeInternoOcorrencia.setEnabled(!true);
            jTextaOcorrecia.setEnabled(!true);
            jBtImpressao.setEnabled(!true);
            //
            jBtNovaOcorrencia.setEnabled(true);
            jBtAlterarOcorrencia.setEnabled(!true);
            jBtExcluirOcorrencia.setEnabled(!true);
            jBtSalvarOcorrencia.setEnabled(!true);
            jBtCancelarOcorrencia.setEnabled(!true);
            jBtAuditoriaOcorrencia.setEnabled(!true);
        }
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusEntrada = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse registro for finalizado, você não poderá\nmais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZAR o registro selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objRegEvenDisciplinar.setStatusLanc(statusEntrada);
            objRegEvenDisciplinar.setIdLanc(Integer.parseInt(jCodigoReg.getText()));
            control.finalizarRegimentoDisciplinar(objRegEvenDisciplinar);
            jStatusReg.setText(statusEntrada);
            finalizarRolInternos();
            //
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
        }
    }

    public void finalizarRolInternos() {

        for (int i = 0; i < jTabelaInternoAutor.getRowCount(); i++) {
            objRegEvenDisciplinar.setStatusLanc(jStatusReg.getText());
            objRegEvenDisciplinar.setObservacao(observacaoRol);
            objRegEvenDisciplinar.setUsuarioUp(nameUser);
            objRegEvenDisciplinar.setDataUp(dataModFinal);
            objRegEvenDisciplinar.setHorarioUp(horaMov);
            objRegEvenDisciplinar.setIdInternoCrc((int) jTabelaInternoAutor.getValueAt(i, 1));
            objRegEvenDisciplinar.setNomeInternoCrc((String) jTabelaInternoAutor.getValueAt(i, 2));
            control.finalizarEventoDisciplinarRol(objRegEvenDisciplinar);
        }
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGIMENTO_DISCIPLINAR_INTERNOS");
            conecta.rs.last();
            jCodigoReg.setText(conecta.rs.getString("IdReg"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void verificarRegistroInternos() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OCORRENCIA_AUTORES WHERE IdReg='" + jCodigoReg.getText() + "'");
            conecta.rs.first();
            idRegOcorrencia = conecta.rs.getString("IdReg");
        } catch (Exception e) {
        }
        //-------------------Tabela AUTOREVENTOS ------------------------------------//
        try {
            conecta.executaSQL("SELECT * FROM AUTORES_REGIMENTO_DISCIPLINAR WHERE IdReg='" + jCodigoReg.getText() + "'");
            conecta.rs.first();
            idRegAutor = conecta.rs.getString("IdReg");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoInterno() {
        jDataReg.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtPesqColaborador.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //ABA AUTORES    
        jBtPesqInternoReg.setEnabled(!true);
        jBtPesqPavilhaoDestino.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jQtdDias.setEnabled(!true);
        jDataIncioDisciplina.setEnabled(!true);
        jDataTerminoDisciplina.setEnabled(!true);
        // ABA INTERNO AUTOR
        jBtPesqInternoReg.setEnabled(true);
        jBtPesqPavilhaoDestino.setEnabled(true);
        // CAMPOS
        jCodigoInternoReg.setText("");
        jMatriculaPenalReg.setText("");
        jFotoInternoReg.setIcon(null);
        jNomeInternoReg.setText("");
        jRG.setText("");
        jAlcunha.setText("");
        jPavilhaoDestino.setText("");
        jComboBoxCelaDestino.setSelectedItem("Selecione");
        jQtdDias.setText("");
        jDataIncioDisciplina.setCalendar(Calendar.getInstance());
        jDataTerminoDisciplina.setCalendar(Calendar.getInstance());
        //
        jComboBoxCelaDestino.setEnabled(true);
        jQtdDias.setEnabled(true);
        jDataIncioDisciplina.setEnabled(true);
        jDataTerminoDisciplina.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtAuditoriaInterno.setEnabled(!true);
        // ABA OCORRÊNCIA      
        jDataOcorrencia.setEnabled(!true);
        jComboBoxNomeInternoOcorrencia.setEnabled(!true);
        jTextaOcorrecia.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(!true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void AlterarInterno() {
        jDataReg.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtPesqColaborador.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //ABA AUTORES    
        jBtPesqInternoReg.setEnabled(!true);
        jBtPesqPavilhaoDestino.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jQtdDias.setEnabled(!true);
        jDataIncioDisciplina.setEnabled(!true);
        jDataTerminoDisciplina.setEnabled(!true);
        // ABA INTERNO AUTOR
        jBtPesqInternoReg.setEnabled(true);
        jBtPesqPavilhaoDestino.setEnabled(true);
        //
        jComboBoxCelaDestino.setEnabled(true);
        jQtdDias.setEnabled(true);
        jDataIncioDisciplina.setEnabled(true);
        jDataTerminoDisciplina.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtAuditoriaInterno.setEnabled(!true);
        // ABA OCORRÊNCIA      
        jDataOcorrencia.setEnabled(!true);
        jComboBoxNomeInternoOcorrencia.setEnabled(!true);
        jTextaOcorrecia.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(!true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void ExcluirInterno() {
        jDataReg.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtPesqColaborador.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //ABA AUTORES    
        jBtPesqInternoReg.setEnabled(!true);
        jBtPesqPavilhaoDestino.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jQtdDias.setEnabled(!true);
        jDataIncioDisciplina.setEnabled(!true);
        jDataTerminoDisciplina.setEnabled(!true);
        // ABA INTERNO AUTOR
        jBtPesqInternoReg.setEnabled(!true);
        jBtPesqPavilhaoDestino.setEnabled(!true);
        // CAMPOS
        jCodigoInternoReg.setText("");
        jMatriculaPenalReg.setText("");
        jFotoInternoReg.setIcon(null);
        jNomeInternoReg.setText("");
        jRG.setText("");
        jAlcunha.setText("");
        jPavilhaoDestino.setText("");
        jComboBoxCelaDestino.setSelectedItem("Selecione");
        jQtdDias.setText("");
        jDataIncioDisciplina.setDate(null);
        jDataTerminoDisciplina.setDate(null);
        //
        jComboBoxCelaDestino.setEnabled(!true);
        jQtdDias.setEnabled(!true);
        jDataIncioDisciplina.setEnabled(!true);
        jDataTerminoDisciplina.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // ABA OCORRÊNCIA      
        jDataOcorrencia.setEnabled(!true);
        jComboBoxNomeInternoOcorrencia.setEnabled(!true);
        jTextaOcorrecia.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void SalvarInterno() {
        acao = 0;
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //ABA AUTORES    
        jBtPesqInternoReg.setEnabled(!true);
        jBtPesqPavilhaoDestino.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jQtdDias.setEnabled(!true);
        jDataIncioDisciplina.setEnabled(!true);
        jDataTerminoDisciplina.setEnabled(!true);
        // ABA INTERNO AUTOR
        jBtPesqInternoReg.setEnabled(!true);
        jBtPesqPavilhaoDestino.setEnabled(!true);
        // CAMPOS
        jCodigoInternoReg.setText("");
        jMatriculaPenalReg.setText("");
        jFotoInternoReg.setIcon(null);
        jNomeInternoReg.setText("");
        jRG.setText("");
        jAlcunha.setText("");
        jPavilhaoDestino.setText("");
        jComboBoxCelaDestino.setSelectedItem("Selecione");
        jQtdDias.setText("");
        jDataIncioDisciplina.setDate(null);
        jDataTerminoDisciplina.setDate(null);
        //
        jComboBoxCelaDestino.setEnabled(!true);
        jQtdDias.setEnabled(!true);
        jDataIncioDisciplina.setEnabled(!true);
        jDataTerminoDisciplina.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        jBtFichaOcorrencia.setEnabled(!true);
        // ABA OCORRÊNCIA      
        jDataOcorrencia.setEnabled(!true);
        jComboBoxNomeInternoOcorrencia.setEnabled(!true);
        jTextaOcorrecia.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void CancelarInterno() {
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //ABA AUTORES    
        jBtPesqInternoReg.setEnabled(!true);
        jBtPesqPavilhaoDestino.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jQtdDias.setEnabled(!true);
        jDataIncioDisciplina.setEnabled(!true);
        jDataTerminoDisciplina.setEnabled(!true);
        // ABA INTERNO AUTOR
        jBtPesqInternoReg.setEnabled(!true);
        jBtPesqPavilhaoDestino.setEnabled(!true);
        // CAMPOS
        jCodigoInternoReg.setText("");
        jMatriculaPenalReg.setText("");
        jFotoInternoReg.setIcon(null);
        jNomeInternoReg.setText("");
        jRG.setText("");
        jAlcunha.setText("");
        jPavilhaoDestino.setText("");
        jComboBoxCelaDestino.removeAllItems();
        jComboBoxCelaDestino.setSelectedItem("Selecione");
        jQtdDias.setText("");
        jDataIncioDisciplina.setDate(null);
        jDataTerminoDisciplina.setDate(null);
        //
        jComboBoxCelaDestino.setEnabled(!true);
        jQtdDias.setEnabled(!true);
        jDataIncioDisciplina.setEnabled(!true);
        jDataTerminoDisciplina.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // ABA OCORRÊNCIA      
        jDataOcorrencia.setEnabled(!true);
        jComboBoxNomeInternoOcorrencia.setEnabled(!true);
        jTextaOcorrecia.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void verificarOcorrenciaInterno() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OCORRENCIA_AUTORES WHERE IdInternoCrc='" + jCodigoInternoReg.getText() + "'");
            conecta.rs.first();
            codInternoOcr = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherComboBoxCela() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CELAS "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE DescricaoPav='" + jPavilhaoDestino.getText() + "'");
            conecta.rs.first();
            do {
                jComboBoxCelaDestino.addItem(conecta.rs.getString("EndCelaPav"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void NovaOcorrencia() {
        // ABA OCORRÊNCIA  
        jCodigoOcorrencia.setText("");
        jDataOcorrencia.setCalendar(Calendar.getInstance());
        jComboBoxNomeInternoOcorrencia.setSelectedItem("Selecione");
        jTextaOcorrecia.setText("");
        //   
        jDataOcorrencia.setEnabled(true);
        jComboBoxNomeInternoOcorrencia.setEnabled(true);
        jTextaOcorrecia.setEnabled(true);
        //
        jBtNovaOcorrencia.setEnabled(!true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(true);
        jBtCancelarOcorrencia.setEnabled(true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        // MANUTENÇÃO
        jDataReg.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtPesqColaborador.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //ABA AUTORES
        //
        jCodigoInternoReg.setText("");
        jMatriculaPenalReg.setText("");
        jFotoInternoReg.setIcon(null);
        jNomeInternoReg.setText("");
        jRG.setText("");
        jAlcunha.setText("");
        jPavilhaoDestino.setText("");
        jComboBoxCelaDestino.setSelectedItem(null);
        jQtdDias.setText("");
        jDataIncioDisciplina.setDate(null);
        jDataTerminoDisciplina.setDate(null);
        //
        jBtPesqInternoReg.setEnabled(!true);
        jBtPesqPavilhaoDestino.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jQtdDias.setEnabled(!true);
        jDataIncioDisciplina.setEnabled(!true);
        jDataTerminoDisciplina.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void AlterarOcorrencia() {
        //   
        jDataOcorrencia.setEnabled(true);
        jComboBoxNomeInternoOcorrencia.setEnabled(true);
        jTextaOcorrecia.setEnabled(true);
        //
        jBtNovaOcorrencia.setEnabled(!true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(true);
        jBtCancelarOcorrencia.setEnabled(true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        // MANUTENÇÃO
        jDataReg.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtPesqColaborador.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //ABA AUTORES        
        jCodigoInternoReg.setText("");
        jMatriculaPenalReg.setText("");
        jFotoInternoReg.setIcon(null);
        jNomeInternoReg.setText("");
        jRG.setText("");
        jAlcunha.setText("");
        jPavilhaoDestino.setText("");
        jComboBoxCelaDestino.setSelectedItem(null);
        jQtdDias.setText("");
        jDataIncioDisciplina.setDate(null);
        jDataTerminoDisciplina.setDate(null);
        //
        jBtPesqInternoReg.setEnabled(!true);
        jBtPesqPavilhaoDestino.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jQtdDias.setEnabled(!true);
        jDataIncioDisciplina.setEnabled(!true);
        jDataTerminoDisciplina.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void ExcluirOcorrencia() {
        // ABA OCORRÊNCIA  
        jCodigoOcorrencia.setText("");
        jDataOcorrencia.setDate(null);
        jComboBoxNomeInternoOcorrencia.setSelectedItem("Selecione");
        jTextaOcorrecia.setText("");
        //   
        jDataOcorrencia.setEnabled(!true);
        jComboBoxNomeInternoOcorrencia.setEnabled(!true);
        jTextaOcorrecia.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        // MANUTENÇÃO
        jDataReg.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtPesqColaborador.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //ABA AUTORES       
        jCodigoInternoReg.setText("");
        jMatriculaPenalReg.setText("");
        jFotoInternoReg.setIcon(null);
        jNomeInternoReg.setText("");
        jRG.setText("");
        jAlcunha.setText("");
        jPavilhaoDestino.setText("");
        jComboBoxCelaDestino.setSelectedItem(null);
        jQtdDias.setText("");
        jDataIncioDisciplina.setDate(null);
        jDataTerminoDisciplina.setDate(null);
        //
        jBtPesqInternoReg.setEnabled(!true);
        jBtPesqPavilhaoDestino.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jQtdDias.setEnabled(!true);
        jDataIncioDisciplina.setEnabled(!true);
        jDataTerminoDisciplina.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void SalvarOcorrencia() {
        jComboBoxNomeInternoOcorrencia.removeAllItems();
        // ABA OCORRÊNCIA  
        jCodigoOcorrencia.setText("");
        jDataOcorrencia.setDate(null);
        jComboBoxNomeInternoOcorrencia.addItem("Selecione");
        jTextaOcorrecia.setText("");
        //   
        jDataOcorrencia.setEnabled(!true);
        jComboBoxNomeInternoOcorrencia.setEnabled(!true);
        jTextaOcorrecia.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        // MANUTENÇÃO
        jDataReg.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtPesqColaborador.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //ABA AUTORES       
        jCodigoInternoReg.setText("");
        jMatriculaPenalReg.setText("");
        jFotoInternoReg.setIcon(null);
        jNomeInternoReg.setText("");
        jRG.setText("");
        jAlcunha.setText("");
        jPavilhaoDestino.setText("");
        jComboBoxCelaDestino.setSelectedItem(null);
        jQtdDias.setText("");
        jDataIncioDisciplina.setDate(null);
        jDataTerminoDisciplina.setDate(null);
        //
        jBtPesqInternoReg.setEnabled(!true);
        jBtPesqPavilhaoDestino.setEnabled(!true);
        jBtZoon.setEnabled(!true);
        //
        jQtdDias.setEnabled(!true);
        jDataIncioDisciplina.setEnabled(!true);
        jDataTerminoDisciplina.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
    }

    public void CancelarOcorrencia() {
        jComboBoxNomeInternoOcorrencia.removeAllItems();
        // ABA OCORRÊNCIA  
        jCodigoOcorrencia.setText("");
        jDataOcorrencia.setDate(null);
        jComboBoxNomeInternoOcorrencia.addItem("Selecione");
        jTextaOcorrecia.setText("");
        //   
        jDataOcorrencia.setEnabled(!true);
        jComboBoxNomeInternoOcorrencia.setEnabled(!true);
        jTextaOcorrecia.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
        jBtImpressao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void buscarCodigoOcorrencia() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OCORRENCIA_AUTORES");
            conecta.rs.last();
            jCodigoOcorrencia.setText(conecta.rs.getString("IdOcr"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void preencherComboBoxInterno() {
        jComboBoxNomeInternoOcorrencia.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN AUTORES_REGIMENTO_DISCIPLINAR "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=AUTORES_REGIMENTO_DISCIPLINAR.IdInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxNomeInternoOcorrencia.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void preencherTabelaRegistroEventos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                dataBrasil = conecta.rs.getString("DataReg");
                String dia = dataBrasil.substring(8, 10);
                String mes = dataBrasil.substring(5, 7);
                String ano = dataBrasil.substring(0, 4);
                dataBrasil = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getInt("IdReg"), dataBrasil, conecta.rs.getString("StatusReg"), conecta.rs.getString("Observacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRegistroEventosIndisciplinar.setModel(modelo);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(3).setPreferredWidth(320);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRegistroEventosIndisciplinar.getTableHeader().setReorderingAllowed(false);
        jTabelaRegistroEventosIndisciplinar.setAutoResizeMode(jTabelaRegistroEventosIndisciplinar.AUTO_RESIZE_OFF);
        jTabelaRegistroEventosIndisciplinar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaRegistroEventos();
        conecta.desconecta();
    }

    public void limparTabelaRegistrosEventos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Observação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaRegistroEventosIndisciplinar.setModel(modelo);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(0).setResizable(false);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(1).setResizable(false);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(2).setResizable(false);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(3).setPreferredWidth(320);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(3).setResizable(false);
        jTabelaRegistroEventosIndisciplinar.getTableHeader().setReorderingAllowed(false);
        jTabelaRegistroEventosIndisciplinar.setAutoResizeMode(jTabelaRegistroEventosIndisciplinar.AUTO_RESIZE_OFF);
        jTabelaRegistroEventosIndisciplinar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaRegistroEventos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaRegistroEventosIndisciplinar.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void preencherTabelaInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome Completo do Interno", "Qtd.Dias", "Data Inicio", "Data Termino", "Cela Destino"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            count1 = 0;
            do {
                count1 = count1 + 1;
                dataInicio = conecta.rs.getString("DataInicio");
                String diai = dataInicio.substring(8, 10);
                String mesi = dataInicio.substring(5, 7);
                String anoi = dataInicio.substring(0, 4);
                dataInicio = diai + "/" + mesi + "/" + anoi;
                //
                dataTermino = conecta.rs.getString("DataTermino");
                String diat = dataTermino.substring(8, 10);
                String mest = dataTermino.substring(5, 7);
                String anot = dataTermino.substring(0, 4);
                dataTermino = diat + "/" + mest + "/" + anot;
                jtotalItens.setText(Integer.toString(count1)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdAutor"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getInt("QtdeDias"), dataInicio, dataTermino, conecta.rs.getString("EndCelaPav")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternoAutor.setModel(modelo);
        jTabelaInternoAutor.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternoAutor.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaInternoAutor.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaInternoAutor.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInternoAutor.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInternoAutor.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaInternoAutor.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(6).setPreferredWidth(220);
        jTabelaInternoAutor.getColumnModel().getColumn(6).setResizable(false);
        jTabelaInternoAutor.getTableHeader().setReorderingAllowed(false);
        jTabelaInternoAutor.setAutoResizeMode(jTabelaInternoAutor.AUTO_RESIZE_OFF);
        jTabelaInternoAutor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaInternoAutor();
        conecta.desconecta();
    }

    public void limparTabelaInternosAutor() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome Completo do Interno", "Qtd.Dias", "Data Inicio", "Data Termino", "Cela Destino"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternoAutor.setModel(modelo);
        jTabelaInternoAutor.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternoAutor.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaInternoAutor.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaInternoAutor.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInternoAutor.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTabelaInternoAutor.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTabelaInternoAutor.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(6).setPreferredWidth(220);
        jTabelaInternoAutor.getColumnModel().getColumn(6).setResizable(false);
        jTabelaInternoAutor.getTableHeader().setReorderingAllowed(false);
        jTabelaInternoAutor.setAutoResizeMode(jTabelaInternoAutor.AUTO_RESIZE_OFF);
        jTabelaInternoAutor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaInternoAutor() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternoAutor.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternoAutor.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaInternoAutor.getColumnModel().getColumn(3).setCellRenderer(direita);
        jTabelaInternoAutor.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaInternoAutor.getColumnModel().getColumn(5).setCellRenderer(centralizado);
    }

    public void preencherTabelaInternosHistorico(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Ocorrência", "Data", "Nome Completo do Interno", "Ocorrência do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dataOcorrencia = conecta.rs.getString("DataOcr");
                String diao = dataOcorrencia.substring(8, 10);
                String meso = dataOcorrencia.substring(5, 7);
                String anoo = dataOcorrencia.substring(0, 4);
                dataOcorrencia = diao + "/" + meso + "/" + anoo;
                dados.add(new Object[]{conecta.rs.getInt("IdOcr"), dataOcorrencia, conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("Ocorrencia")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaOcorrencias.setModel(modelo);
        jTabelaOcorrencias.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaOcorrencias.getColumnModel().getColumn(0).setResizable(false);
        jTabelaOcorrencias.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaOcorrencias.getColumnModel().getColumn(1).setResizable(false);
        jTabelaOcorrencias.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaOcorrencias.getColumnModel().getColumn(2).setResizable(false);
        jTabelaOcorrencias.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTabelaOcorrencias.getColumnModel().getColumn(3).setResizable(false);
        jTabelaOcorrencias.getTableHeader().setReorderingAllowed(false);
        jTabelaOcorrencias.setAutoResizeMode(jTabelaOcorrencias.AUTO_RESIZE_OFF);
        jTabelaOcorrencias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaHistorico();
        conecta.desconecta();
    }

    public void limparTabelaHistorico() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Ocorrência", "Data", "Nome Completo do Interno", "Ocorrência do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaOcorrencias.setModel(modelo);
        jTabelaOcorrencias.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaOcorrencias.getColumnModel().getColumn(0).setResizable(false);
        jTabelaOcorrencias.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaOcorrencias.getColumnModel().getColumn(1).setResizable(false);
        jTabelaOcorrencias.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaOcorrencias.getColumnModel().getColumn(2).setResizable(false);
        jTabelaOcorrencias.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTabelaOcorrencias.getColumnModel().getColumn(3).setResizable(false);
        jTabelaOcorrencias.getTableHeader().setReorderingAllowed(false);
        jTabelaOcorrencias.setAutoResizeMode(jTabelaOcorrencias.AUTO_RESIZE_OFF);
        jTabelaOcorrencias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaHistorico() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaOcorrencias.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoReg.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoReg.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoReg.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaSeguranca) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUser = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUser + "'");
            conecta.rs.first();
            codigoUserGroup = conecta.rs.getInt("IdUsuario");
            codigoGrupo = conecta.rs.getInt("IdGrupo");
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUser + "' "
                    + "AND NomeTela='" + nomeTelaSeguranca + "'");
            conecta.rs.first();
            codUserAcesso = conecta.rs.getInt("IdUsuario");
            codAbrir = conecta.rs.getInt("Abrir");
            codIncluir = conecta.rs.getInt("Incluir");
            codAlterar = conecta.rs.getInt("Alterar");
            codExcluir = conecta.rs.getInt("Excluir");
            codGravar = conecta.rs.getInt("Gravar");
            codConsultar = conecta.rs.getInt("Consultar");
            nomeTela = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
