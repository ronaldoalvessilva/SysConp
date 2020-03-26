/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleApreensoes;
import gestor.Controle.ControleAutorEventos;
import gestor.Controle.ControleEventosIndisciplinar;
import gestor.Controle.ControleFuncTestemunha;
import gestor.Controle.ControleFuncVitima;
import gestor.Controle.ControleHistoricoAutor;
import gestor.Controle.ControleInternosTestemunhas;
import gestor.Controle.ControleInternosVitimas;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.Apreensoes;
import gestor.Modelo.AutorEventos;
import gestor.Modelo.ColaboradorTestemunha;
import gestor.Modelo.ColabordorVitima;
import gestor.Modelo.HistoricoAutor;
import gestor.Modelo.InternosTestemunha;
import gestor.Modelo.InternosVitimas;
import gestor.Modelo.LogSistema;
import gestor.Modelo.RegistroEventosIndisciplinar;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaModuloSeguranca.codAbrir;
import static gestor.Visao.TelaModuloSeguranca.codAlterar;
import static gestor.Visao.TelaModuloSeguranca.codConsultar;
import static gestor.Visao.TelaModuloSeguranca.codExcluir;
import static gestor.Visao.TelaModuloSeguranca.codGravar;
import static gestor.Visao.TelaModuloSeguranca.codIncluir;
import static gestor.Visao.TelaModuloSeguranca.codUserAcesso;
import static gestor.Visao.TelaModuloSeguranca.codigoGrupo;
import static gestor.Visao.TelaModuloSeguranca.codigoUser;
import static gestor.Visao.TelaModuloSeguranca.codigoUserGroup;
import static gestor.Visao.TelaModuloSeguranca.nomeGrupo;
import static gestor.Visao.TelaModuloSeguranca.nomeTela;
import static gestor.Visao.TelaModuloSeguranca.telaRegistroEvendoDisciplinar;
import static gestor.Visao.TelaModuloSeguranca.telaRegistroEvendoDisciplinarAutor;
import static gestor.Visao.TelaModuloSeguranca.telaRegistroEvendoDisciplinarHistorico;
import static gestor.Visao.TelaModuloSeguranca.telaRegistroEvendoDisciplinarObjstos;
import static gestor.Visao.TelaModuloSeguranca.telaRegistroEvendoDisciplinarTestemunha;
import static gestor.Visao.TelaModuloSeguranca.telaRegistroEvendoDisciplinarTestemunhaFunc;
import static gestor.Visao.TelaModuloSeguranca.telaRegistroEvendoDisciplinarVitima;
import static gestor.Visao.TelaModuloSeguranca.telaRegistroEvendoDisciplinarVitimaFunc;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
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
 * @author ronaldo
 */
public class TelaEventoDisciplinar extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    // Aba Manutenção
    RegistroEventosIndisciplinar objRegEvenDisciplinar = new RegistroEventosIndisciplinar();
    ControleEventosIndisciplinar control = new ControleEventosIndisciplinar();
    // Aba Autor(es)
    AutorEventos objAutorEvento = new AutorEventos();
    ControleAutorEventos controle = new ControleAutorEventos();
    // Aba Vitimas - INTERNOS
    InternosVitimas objIntVitima = new InternosVitimas();
    ControleInternosVitimas controleIntVit = new ControleInternosVitimas();
    // Aba Vitimas - COLABORADOR
    ColabordorVitima objFuncVitima = new ColabordorVitima();
    ControleFuncVitima controlFuncVit = new ControleFuncVitima();
    // Aba Testemunhas - INTERNOS
    InternosTestemunha objIntTeste = new InternosTestemunha();
    ControleInternosTestemunhas controleIntTeste = new ControleInternosTestemunhas();
    // Aba Testemunha - COLABORADOR
    ColaboradorTestemunha objFuncTeste = new ColaboradorTestemunha();
    ControleFuncTestemunha controlFuncTeste = new ControleFuncTestemunha();
    // Aba Apreeensoes - INTERNOS
    Apreensoes objApre = new Apreensoes();
    ControleApreensoes controleApre = new ControleApreensoes();
    // Aba Histórico INTERNOS COLABORADORES
    HistoricoAutor objHisto = new HistoricoAutor();
    ControleHistoricoAutor controlHist = new ControleHistoricoAutor();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Segurança:Registro de Eventos Indisciplinar Internos:Manutenção";
    String nomeModuloTela2 = "Segurança:Registro de Eventos Indisciplinar Internos:Autor";
    String nomeModuloTela3 = "Segurança:Registro de Eventos Indisciplinar Internos:Internos Vítimas";
    String nomeModuloTela4 = "Segurança:Registro de Eventos Indisciplinar Internos:Colaboradores Vítima";
    String nomeModuloTela5 = "Segurança:Registro de Eventos Indisciplinar Internos:Internos Testemunha";
    String nomeModuloTela6 = "Segurança:Registro de Eventos Indisciplinar Internos:Colaboradores Testemunha";
    String nomeModuloTela7 = "Segurança:Registro de Eventos Indisciplinar Internos:Apreensões";
    String nomeModuloTela8 = "Segurança:Registro de Eventos Indisciplinar Internos:Históricos";
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
    public static int idItemAutor, idItemIntVi, idItemFuncVi, idItemIntTes, idItemFuncTes, idItemApreende, idItemHist;
    String caminho;
    String codHistoricoInterno, codInternoObjeto, codInternoVitima, codInternoTestemunha;
    String idLancHist, idLancApr, idLancFuncTes, idLancIntTes, idLancFuncVit, idLancIntVit, idLancAut;
    String utilizaSaida = "Não"; // Variavel que informa a utilização na tabela de retirada do castigo
    int count = 0;

    /**
     * Creates new form TelaEventoDisciplinar
     */
    public static TelaFaltasIndisciplinarFO1 faltasFO1;

    public TelaEventoDisciplinar() {
        initComponents();
        formatarCampos();
        corCampos();
    }

    public void mostrarFaltas() {
        faltasFO1 = new TelaFaltasIndisciplinarFO1(this, true);
        faltasFO1.setVisible(true);
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
        jScrollPane9 = new javax.swing.JScrollPane();
        jTabelaRegistroEventosIndisciplinar = new javax.swing.JTable();
        jPanel38 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdLanc = new javax.swing.JTextField();
        jStatusLanc = new javax.swing.JTextField();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDescricaoEvento = new javax.swing.JTextField();
        jDescricaoLocalEvento = new javax.swing.JTextField();
        jBtPesqNatureza = new javax.swing.JButton();
        jBtPesqLocalEvento = new javax.swing.JButton();
        jHorarioEvento = new javax.swing.JFormattedTextField();
        jBtFinalizar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jIdPav = new javax.swing.JTextField();
        jDescricaoPavilhao = new javax.swing.JTextField();
        jIdCela = new javax.swing.JTextField();
        jDescricaoCela = new javax.swing.JTextField();
        jBtPesqPavilhao = new javax.swing.JButton();
        jBtPesqCela = new javax.swing.JButton();
        jBtAjuda = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaInternoAutor = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jIdInternoAutor = new javax.swing.JTextField();
        jNomeInternoAutor = new javax.swing.JTextField();
        jBtPesqInternoAutor = new javax.swing.JButton();
        jMatriculaPenalAutor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jFotoInternoAutor = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCelaDestinoInternoAutor = new javax.swing.JTextField();
        jBtPesqCelaDestinoAutor = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jQtdeDias = new javax.swing.JFormattedTextField();
        jBtFichaFaltas = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jBtNovoInterno = new javax.swing.JButton();
        jBtAlterarInterno = new javax.swing.JButton();
        jBtExcluirInterno = new javax.swing.JButton();
        jBtSalvarInterno = new javax.swing.JButton();
        jBtCancelarInterno = new javax.swing.JButton();
        jBtAuditoriaInterno = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaInternosVitimas = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jBtNovoInternoVitima = new javax.swing.JButton();
        jBtAlterarInternoVitima = new javax.swing.JButton();
        jBtExcluirInternoVitima = new javax.swing.JButton();
        jBtSalvarInternoVitima = new javax.swing.JButton();
        jBtCancelarInternoVitima = new javax.swing.JButton();
        jBtAuditoriaInternoVitima = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jIdInternoCrcVitima = new javax.swing.JTextField();
        jMatriculaVitima = new javax.swing.JTextField();
        jNomeInternoVitima = new javax.swing.JTextField();
        jNomeMaeInternoVitima = new javax.swing.JTextField();
        jBtPesqInternoVitima = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jFotoInternoVitima = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jBtNovoFuncVitima = new javax.swing.JButton();
        jBtAlterarFuncVitima = new javax.swing.JButton();
        jBtExcluirFuncVitima = new javax.swing.JButton();
        jBtSalvarFuncVitima = new javax.swing.JButton();
        jBtCancelarFuncVitima = new javax.swing.JButton();
        jBtAuditoriaFuncVitima = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaColaboradorVitima = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jBtPesqFunc = new javax.swing.JButton();
        jIdFuncVitima = new javax.swing.JTextField();
        jDepartamantoVitima = new javax.swing.JTextField();
        jRGVitima = new javax.swing.JFormattedTextField();
        jNomeColaboradorVitima = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jFotoFuncVitima = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTabelaInternosTestemunha = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jBtNovoInternoTestemunha = new javax.swing.JButton();
        jBtAlterarInternoTestemunha = new javax.swing.JButton();
        jBtExcluirInternoTestemunha = new javax.swing.JButton();
        jBtSalvarInternoTestemunha = new javax.swing.JButton();
        jBtCancelarInternoTestemunha = new javax.swing.JButton();
        jBtAuditoriaInternoTestemunha = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jIdInternoTestemunha = new javax.swing.JTextField();
        jMatriculaInternoTestemunha = new javax.swing.JTextField();
        jNomeInternoTestemunha = new javax.swing.JTextField();
        jNomeMaeInternoTestemunha = new javax.swing.JTextField();
        jBtPesqInternoTestemunha = new javax.swing.JButton();
        jPanel35 = new javax.swing.JPanel();
        jFotoInternoTestemunha = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jBtNovoFuncTestemunha = new javax.swing.JButton();
        jBtAlterarFuncTestemunha = new javax.swing.JButton();
        jBtExcluirFuncTestemunha = new javax.swing.JButton();
        jBtSalvarFuncTestemunha = new javax.swing.JButton();
        jBtCancelarFuncTestemunha = new javax.swing.JButton();
        jBtAuditoriaFuncTestemunha = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTabelaFuncTestemunha = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jBtPesqFuncTestemunha = new javax.swing.JButton();
        jIdFuncTestemunha = new javax.swing.JTextField();
        jNomeDepartamentoTestemunha = new javax.swing.JTextField();
        jRGFuncTestemunha = new javax.swing.JFormattedTextField();
        jNomeFuncTestemunha = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jFotoFuncTestemunha = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel26 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jIdInternoPertence = new javax.swing.JTextField();
        jDescricaoObjeto = new javax.swing.JTextField();
        jBtPesqInternoPertence = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jIdObjeto = new javax.swing.JTextField();
        jNomeInternoPertenceObjeto = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jBtPesqObjeto = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jQtdEncontrado = new javax.swing.JFormattedTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTabelaInternosObjetos = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jBtNovoObjeto = new javax.swing.JButton();
        jBtAlterarObjeto = new javax.swing.JButton();
        jBtExcluirObjeto = new javax.swing.JButton();
        jBtSalvarObjeto = new javax.swing.JButton();
        jBtCancelarObjeto = new javax.swing.JButton();
        jBtAuditoriaObjeto = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jBtNovoHistorico = new javax.swing.JButton();
        jBtAlterarHistorico = new javax.swing.JButton();
        jBtExcluirHistorico = new javax.swing.JButton();
        jBtSalvarHistorico = new javax.swing.JButton();
        jBtCancelarHistorico = new javax.swing.JButton();
        jBtAuditoriaHistorico = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jHistorico = new javax.swing.JTextArea();
        jPanel37 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jIdInternoHistorico = new javax.swing.JTextField();
        jNomeInternoHistorico = new javax.swing.JTextField();
        jBtPesqInternoHistorico = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTabelaHistorico = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Registro de Regime Disciplinar Diferenciado - (RDD) :::...");

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

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqDatas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxTodos))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jIdPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel31)
                    .addComponent(jIdPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxTodos)
                    .addComponent(jBtPesqDatas)
                    .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaRegistroEventosIndisciplinar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaRegistroEventosIndisciplinar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        jIdLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLanc.setEnabled(false);

        jStatusLanc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLanc.setForeground(new java.awt.Color(204, 0, 0));
        jStatusLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLanc.setEnabled(false);

        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Tipo de Falta Indisciplinar");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Local do Evento");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Horário Evento");

        jDescricaoEvento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoEvento.setEnabled(false);

        jDescricaoLocalEvento.setToolTipText("Pátio do Pavilhão");
        jDescricaoLocalEvento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoLocalEvento.setEnabled(false);

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

        jHorarioEvento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioEvento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioEvento.setEnabled(false);

        jBtFinalizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtFinalizar.setForeground(new java.awt.Color(255, 0, 51));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/low-security-breach-icone-4155-16.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setToolTipText("Finalizar");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jStatusLanc))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jDescricaoLocalEvento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqLocalEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jHorarioEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jDescricaoEvento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqNatureza, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtFinalizar)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtPesqLocalEvento, jBtPesqNatureza});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jDataLanc, jHorarioEvento});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDescricaoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNatureza, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtFinalizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDescricaoLocalEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqLocalEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.setToolTipText("Novo");
        jBtNovo.setContentAreaFilled(false);
        jBtNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.setToolTipText("Alterar");
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
        jBtExcluir.setToolTipText("Excluir");
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
        jBtSalvar.setToolTipText("Gravar");
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
        jBtCancelar.setToolTipText("Cancelar");
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
        jBtSair.setToolTipText("Sair");
        jBtSair.setContentAreaFilled(false);
        jBtSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
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
                .addGap(28, 28, 28)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBtSair)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtNovo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtSalvar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBtAlterar)
                                .addComponent(jBtExcluir)))
                        .addComponent(jBtCancelar))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtAuditoria)))
                .addGap(22, 22, 22))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSair, jBtSalvar});

        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pavilhão/Cela - Origem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Código");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Descrição do Pavilhão");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Código");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Descrição da Cela");

        jIdPav.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdPav.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdPav.setEnabled(false);

        jDescricaoPavilhao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoPavilhao.setEnabled(false);

        jIdCela.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdCela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdCela.setEnabled(false);

        jDescricaoCela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoCela.setEnabled(false);

        jBtPesqPavilhao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqPavilhao.setContentAreaFilled(false);
        jBtPesqPavilhao.setEnabled(false);
        jBtPesqPavilhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqPavilhaoActionPerformed(evt);
            }
        });

        jBtPesqCela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCela.setContentAreaFilled(false);
        jBtPesqCela.setEnabled(false);
        jBtPesqCela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCelaActionPerformed(evt);
            }
        });

        jBtAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Ajuda_8446_16x16.png"))); // NOI18N
        jBtAjuda.setToolTipText("Ajuda");
        jBtAjuda.setContentAreaFilled(false);
        jBtAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAjudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jIdCela, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtPesqCela, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jIdPav, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDescricaoCela)
                    .addComponent(jDescricaoPavilhao)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                        .addComponent(jBtAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdCela, jIdPav});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jBtAjuda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdPav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDescricaoPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdCela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCela, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDescricaoCela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDescricaoCela, jDescricaoPavilhao});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jIdCela, jIdPav});

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Pavilhão/Cela", jPanel16);

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Observação", jPanel17);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jTabelaInternoAutor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternoAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Completo do Interno", "Destino", "Qtd. Dias"
            }
        ));
        jTabelaInternoAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternoAutorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaInternoAutor);
        if (jTabelaInternoAutor.getColumnModel().getColumnCount() > 0) {
            jTabelaInternoAutor.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaInternoAutor.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaInternoAutor.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaInternoAutor.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaInternoAutor.getColumnModel().getColumn(2).setMinWidth(180);
            jTabelaInternoAutor.getColumnModel().getColumn(2).setMaxWidth(180);
            jTabelaInternoAutor.getColumnModel().getColumn(3).setMinWidth(80);
            jTabelaInternoAutor.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Código");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Nome Completo do Interno");

        jIdInternoAutor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoAutor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoAutor.setEnabled(false);

        jNomeInternoAutor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoAutor.setEnabled(false);

        jBtPesqInternoAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInternoAutor.setContentAreaFilled(false);
        jBtPesqInternoAutor.setEnabled(false);
        jBtPesqInternoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoAutorActionPerformed(evt);
            }
        });

        jMatriculaPenalAutor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenalAutor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenalAutor.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText(" Matricula Penal");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoAutor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Destino do Interno");

        jCelaDestinoInternoAutor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCelaDestinoInternoAutor.setEnabled(false);

        jBtPesqCelaDestinoAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCelaDestinoAutor.setContentAreaFilled(false);
        jBtPesqCelaDestinoAutor.setEnabled(false);
        jBtPesqCelaDestinoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCelaDestinoAutorActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Qtde. Dias");

        jQtdeDias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQtdeDias.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQtdeDias.setEnabled(false);

        jBtFichaFaltas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtFichaFaltas.setToolTipText("Ficha de Faltas");
        jBtFichaFaltas.setContentAreaFilled(false);
        jBtFichaFaltas.setEnabled(false);
        jBtFichaFaltas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFichaFaltasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jCelaDestinoInternoAutor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqCelaDestinoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jNomeInternoAutor)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jIdInternoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqInternoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jMatriculaPenalAutor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jQtdeDias, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtFichaFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jMatriculaPenalAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jIdInternoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqInternoAutor)
                            .addComponent(jQtdeDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtFichaFaltas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeInternoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jCelaDestinoInternoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqCelaDestinoAutor))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovoInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoInterno.setText("Novo");
        jBtNovoInterno.setToolTipText("Novo");
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

        jBtAlterarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarInterno.setText("Alterar");
        jBtAlterarInterno.setToolTipText("Alterar");
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
        jBtExcluirInterno.setToolTipText("Excluir");
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
        jBtSalvarInterno.setToolTipText("Gravar");
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
        jBtCancelarInterno.setToolTipText("Cancelar");
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
        jBtAuditoriaInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoriaInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoriaInterno)
                    .addComponent(jBtCancelarInterno)
                    .addComponent(jBtSalvarInterno)
                    .addComponent(jBtExcluirInterno)
                    .addComponent(jBtAlterarInterno)
                    .addComponent(jBtNovoInterno))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Autor (es)", jPanel4);

        jTabbedPane3.setForeground(new java.awt.Color(153, 0, 102));
        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTabelaInternosVitimas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternosVitimas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Completo do Interno", "Matricula"
            }
        ));
        jTabelaInternosVitimas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternosVitimasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaInternosVitimas);
        if (jTabelaInternosVitimas.getColumnModel().getColumnCount() > 0) {
            jTabelaInternosVitimas.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaInternosVitimas.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaInternosVitimas.getColumnModel().getColumn(1).setMinWidth(280);
            jTabelaInternosVitimas.getColumnModel().getColumn(1).setMaxWidth(280);
            jTabelaInternosVitimas.getColumnModel().getColumn(2).setMinWidth(120);
            jTabelaInternosVitimas.getColumnModel().getColumn(2).setMaxWidth(120);
        }

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovoInternoVitima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoInternoVitima.setText("Novo");
        jBtNovoInternoVitima.setContentAreaFilled(false);
        jBtNovoInternoVitima.setEnabled(false);
        jBtNovoInternoVitima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoInternoVitima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoInternoVitima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoInternoVitima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoInternoVitimaActionPerformed(evt);
            }
        });

        jBtAlterarInternoVitima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarInternoVitima.setText("Alterar");
        jBtAlterarInternoVitima.setContentAreaFilled(false);
        jBtAlterarInternoVitima.setEnabled(false);
        jBtAlterarInternoVitima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarInternoVitima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarInternoVitima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarInternoVitima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarInternoVitimaActionPerformed(evt);
            }
        });

        jBtExcluirInternoVitima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirInternoVitima.setText("Excluir");
        jBtExcluirInternoVitima.setContentAreaFilled(false);
        jBtExcluirInternoVitima.setEnabled(false);
        jBtExcluirInternoVitima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirInternoVitima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirInternoVitima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirInternoVitima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirInternoVitimaActionPerformed(evt);
            }
        });

        jBtSalvarInternoVitima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarInternoVitima.setText("Gravar");
        jBtSalvarInternoVitima.setContentAreaFilled(false);
        jBtSalvarInternoVitima.setEnabled(false);
        jBtSalvarInternoVitima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarInternoVitima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarInternoVitima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarInternoVitima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarInternoVitimaActionPerformed(evt);
            }
        });

        jBtCancelarInternoVitima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarInternoVitima.setText("Cancelar");
        jBtCancelarInternoVitima.setContentAreaFilled(false);
        jBtCancelarInternoVitima.setEnabled(false);
        jBtCancelarInternoVitima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarInternoVitima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarInternoVitima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarInternoVitima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarInternoVitimaActionPerformed(evt);
            }
        });

        jBtAuditoriaInternoVitima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaInternoVitima.setContentAreaFilled(false);
        jBtAuditoriaInternoVitima.setEnabled(false);
        jBtAuditoriaInternoVitima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoriaInternoVitima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaInternoVitima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaInternoVitima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaInternoVitimaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jBtNovoInternoVitima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarInternoVitima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirInternoVitima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarInternoVitima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarInternoVitima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaInternoVitima, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoriaInternoVitima)
                    .addComponent(jBtCancelarInternoVitima)
                    .addComponent(jBtSalvarInternoVitima)
                    .addComponent(jBtExcluirInternoVitima)
                    .addComponent(jBtAlterarInternoVitima)
                    .addComponent(jBtNovoInternoVitima))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Código");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Nome da Mãe do Interno");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Matricula");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Nome Completo do Interno");

        jIdInternoCrcVitima.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoCrcVitima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoCrcVitima.setEnabled(false);

        jMatriculaVitima.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaVitima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaVitima.setEnabled(false);

        jNomeInternoVitima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoVitima.setEnabled(false);

        jNomeMaeInternoVitima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeMaeInternoVitima.setEnabled(false);

        jBtPesqInternoVitima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInternoVitima.setContentAreaFilled(false);
        jBtPesqInternoVitima.setEnabled(false);
        jBtPesqInternoVitima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoVitimaActionPerformed(evt);
            }
        });

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoVitima, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoVitima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jNomeInternoVitima, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNomeMaeInternoVitima))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jIdInternoCrcVitima, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(jBtPesqInternoVitima, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jMatriculaVitima)
                                .addGap(8, 8, 8)))))
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jMatriculaVitima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqInternoVitima, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jIdInternoCrcVitima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeInternoVitima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeMaeInternoVitima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 158, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane3.addTab("Internos", jPanel18);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovoFuncVitima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoFuncVitima.setText("Novo");
        jBtNovoFuncVitima.setContentAreaFilled(false);
        jBtNovoFuncVitima.setEnabled(false);
        jBtNovoFuncVitima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoFuncVitima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoFuncVitima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoFuncVitima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoFuncVitimaActionPerformed(evt);
            }
        });

        jBtAlterarFuncVitima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarFuncVitima.setText("Alterar");
        jBtAlterarFuncVitima.setContentAreaFilled(false);
        jBtAlterarFuncVitima.setEnabled(false);
        jBtAlterarFuncVitima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarFuncVitima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarFuncVitima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarFuncVitima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarFuncVitimaActionPerformed(evt);
            }
        });

        jBtExcluirFuncVitima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirFuncVitima.setText("Excluir");
        jBtExcluirFuncVitima.setContentAreaFilled(false);
        jBtExcluirFuncVitima.setEnabled(false);
        jBtExcluirFuncVitima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirFuncVitima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirFuncVitima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirFuncVitima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirFuncVitimaActionPerformed(evt);
            }
        });

        jBtSalvarFuncVitima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarFuncVitima.setText("Gravar");
        jBtSalvarFuncVitima.setContentAreaFilled(false);
        jBtSalvarFuncVitima.setEnabled(false);
        jBtSalvarFuncVitima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarFuncVitima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarFuncVitima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarFuncVitima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarFuncVitimaActionPerformed(evt);
            }
        });

        jBtCancelarFuncVitima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarFuncVitima.setText("Cancelar");
        jBtCancelarFuncVitima.setContentAreaFilled(false);
        jBtCancelarFuncVitima.setEnabled(false);
        jBtCancelarFuncVitima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarFuncVitima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarFuncVitima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarFuncVitima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarFuncVitimaActionPerformed(evt);
            }
        });

        jBtAuditoriaFuncVitima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaFuncVitima.setContentAreaFilled(false);
        jBtAuditoriaFuncVitima.setEnabled(false);
        jBtAuditoriaFuncVitima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoriaFuncVitima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaFuncVitima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaFuncVitima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaFuncVitimaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jBtNovoFuncVitima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarFuncVitima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirFuncVitima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarFuncVitima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarFuncVitima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaFuncVitima, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoriaFuncVitima)
                    .addComponent(jBtCancelarFuncVitima)
                    .addComponent(jBtSalvarFuncVitima)
                    .addComponent(jBtExcluirFuncVitima)
                    .addComponent(jBtAlterarFuncVitima)
                    .addComponent(jBtNovoFuncVitima))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabelaColaboradorVitima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaColaboradorVitima.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Completo do Colaborador", "Departamento"
            }
        ));
        jTabelaColaboradorVitima.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaColaboradorVitimaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaColaboradorVitima);
        if (jTabelaColaboradorVitima.getColumnModel().getColumnCount() > 0) {
            jTabelaColaboradorVitima.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaColaboradorVitima.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaColaboradorVitima.getColumnModel().getColumn(1).setMinWidth(280);
            jTabelaColaboradorVitima.getColumnModel().getColumn(1).setMaxWidth(280);
            jTabelaColaboradorVitima.getColumnModel().getColumn(2).setMinWidth(120);
            jTabelaColaboradorVitima.getColumnModel().getColumn(2).setMaxWidth(120);
        }

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Código");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("RG");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Departamento");

        jBtPesqFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqFunc.setContentAreaFilled(false);
        jBtPesqFunc.setEnabled(false);
        jBtPesqFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqFuncActionPerformed(evt);
            }
        });

        jIdFuncVitima.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdFuncVitima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdFuncVitima.setEnabled(false);

        jDepartamantoVitima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDepartamantoVitima.setEnabled(false);

        jRGVitima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRGVitima.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jRGVitima.setEnabled(false);

        jNomeColaboradorVitima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeColaboradorVitima.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Nome do Colaborador");

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoFuncVitima, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoFuncVitima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeColaboradorVitima)
                    .addComponent(jDepartamantoVitima, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel24))
                        .addGap(0, 172, Short.MAX_VALUE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jIdFuncVitima, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jRGVitima))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jIdFuncVitima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRGVitima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeColaboradorVitima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDepartamantoVitima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane3.addTab("Colaboradores", jPanel19);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3))
        );

        jTabbedPane1.addTab("Vítima (s)", jPanel8);

        jTabbedPane4.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane4.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTabelaInternosTestemunha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternosTestemunha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Completo do Interno", "Matricula"
            }
        ));
        jTabelaInternosTestemunha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternosTestemunhaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTabelaInternosTestemunha);
        if (jTabelaInternosTestemunha.getColumnModel().getColumnCount() > 0) {
            jTabelaInternosTestemunha.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaInternosTestemunha.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaInternosTestemunha.getColumnModel().getColumn(1).setMinWidth(280);
            jTabelaInternosTestemunha.getColumnModel().getColumn(1).setMaxWidth(280);
            jTabelaInternosTestemunha.getColumnModel().getColumn(2).setMinWidth(120);
            jTabelaInternosTestemunha.getColumnModel().getColumn(2).setMaxWidth(120);
        }

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovoInternoTestemunha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoInternoTestemunha.setText("Novo");
        jBtNovoInternoTestemunha.setToolTipText("Novo");
        jBtNovoInternoTestemunha.setContentAreaFilled(false);
        jBtNovoInternoTestemunha.setEnabled(false);
        jBtNovoInternoTestemunha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoInternoTestemunha.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoInternoTestemunha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoInternoTestemunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoInternoTestemunhaActionPerformed(evt);
            }
        });

        jBtAlterarInternoTestemunha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarInternoTestemunha.setText("Alterar");
        jBtAlterarInternoTestemunha.setToolTipText("Alterar");
        jBtAlterarInternoTestemunha.setContentAreaFilled(false);
        jBtAlterarInternoTestemunha.setEnabled(false);
        jBtAlterarInternoTestemunha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarInternoTestemunha.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarInternoTestemunha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarInternoTestemunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarInternoTestemunhaActionPerformed(evt);
            }
        });

        jBtExcluirInternoTestemunha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirInternoTestemunha.setText("Excluir");
        jBtExcluirInternoTestemunha.setToolTipText("Excluir");
        jBtExcluirInternoTestemunha.setContentAreaFilled(false);
        jBtExcluirInternoTestemunha.setEnabled(false);
        jBtExcluirInternoTestemunha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirInternoTestemunha.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirInternoTestemunha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirInternoTestemunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirInternoTestemunhaActionPerformed(evt);
            }
        });

        jBtSalvarInternoTestemunha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarInternoTestemunha.setText("Gravar");
        jBtSalvarInternoTestemunha.setToolTipText("Gravar");
        jBtSalvarInternoTestemunha.setContentAreaFilled(false);
        jBtSalvarInternoTestemunha.setEnabled(false);
        jBtSalvarInternoTestemunha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarInternoTestemunha.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarInternoTestemunha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarInternoTestemunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarInternoTestemunhaActionPerformed(evt);
            }
        });

        jBtCancelarInternoTestemunha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarInternoTestemunha.setText("Cancelar");
        jBtCancelarInternoTestemunha.setToolTipText("Cancelar");
        jBtCancelarInternoTestemunha.setContentAreaFilled(false);
        jBtCancelarInternoTestemunha.setEnabled(false);
        jBtCancelarInternoTestemunha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarInternoTestemunha.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarInternoTestemunha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarInternoTestemunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarInternoTestemunhaActionPerformed(evt);
            }
        });

        jBtAuditoriaInternoTestemunha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaInternoTestemunha.setToolTipText("Auditoria");
        jBtAuditoriaInternoTestemunha.setContentAreaFilled(false);
        jBtAuditoriaInternoTestemunha.setEnabled(false);
        jBtAuditoriaInternoTestemunha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoriaInternoTestemunha.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaInternoTestemunha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaInternoTestemunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaInternoTestemunhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jBtNovoInternoTestemunha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarInternoTestemunha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirInternoTestemunha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarInternoTestemunha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarInternoTestemunha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaInternoTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoriaInternoTestemunha)
                    .addComponent(jBtCancelarInternoTestemunha)
                    .addComponent(jBtSalvarInternoTestemunha)
                    .addComponent(jBtExcluirInternoTestemunha)
                    .addComponent(jBtAlterarInternoTestemunha)
                    .addComponent(jBtNovoInternoTestemunha))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Código");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Nome da Mãe do Interno");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Matricula");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Nome Completo do Interno");

        jIdInternoTestemunha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoTestemunha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoTestemunha.setEnabled(false);

        jMatriculaInternoTestemunha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaInternoTestemunha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaInternoTestemunha.setEnabled(false);

        jNomeInternoTestemunha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoTestemunha.setEnabled(false);

        jNomeMaeInternoTestemunha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeMaeInternoTestemunha.setEnabled(false);

        jBtPesqInternoTestemunha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInternoTestemunha.setContentAreaFilled(false);
        jBtPesqInternoTestemunha.setEnabled(false);
        jBtPesqInternoTestemunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoTestemunhaActionPerformed(evt);
            }
        });

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoTestemunha, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoTestemunha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel41))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jNomeInternoTestemunha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNomeMaeInternoTestemunha))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jIdInternoTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(jBtPesqInternoTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addGroup(jPanel34Layout.createSequentialGroup()
                                .addComponent(jMatriculaInternoTestemunha)
                                .addGap(8, 8, 8)))))
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jMatriculaInternoTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqInternoTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jIdInternoTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeInternoTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeMaeInternoTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 158, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane4.addTab("Internos", jPanel23);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovoFuncTestemunha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoFuncTestemunha.setText("Novo");
        jBtNovoFuncTestemunha.setContentAreaFilled(false);
        jBtNovoFuncTestemunha.setEnabled(false);
        jBtNovoFuncTestemunha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoFuncTestemunha.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoFuncTestemunha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoFuncTestemunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoFuncTestemunhaActionPerformed(evt);
            }
        });

        jBtAlterarFuncTestemunha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarFuncTestemunha.setText("Alterar");
        jBtAlterarFuncTestemunha.setContentAreaFilled(false);
        jBtAlterarFuncTestemunha.setEnabled(false);
        jBtAlterarFuncTestemunha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarFuncTestemunha.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarFuncTestemunha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarFuncTestemunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarFuncTestemunhaActionPerformed(evt);
            }
        });

        jBtExcluirFuncTestemunha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirFuncTestemunha.setText("Excluir");
        jBtExcluirFuncTestemunha.setContentAreaFilled(false);
        jBtExcluirFuncTestemunha.setEnabled(false);
        jBtExcluirFuncTestemunha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirFuncTestemunha.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirFuncTestemunha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirFuncTestemunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirFuncTestemunhaActionPerformed(evt);
            }
        });

        jBtSalvarFuncTestemunha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarFuncTestemunha.setText("Gravar");
        jBtSalvarFuncTestemunha.setContentAreaFilled(false);
        jBtSalvarFuncTestemunha.setEnabled(false);
        jBtSalvarFuncTestemunha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarFuncTestemunha.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarFuncTestemunha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarFuncTestemunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarFuncTestemunhaActionPerformed(evt);
            }
        });

        jBtCancelarFuncTestemunha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarFuncTestemunha.setText("Cancelar");
        jBtCancelarFuncTestemunha.setContentAreaFilled(false);
        jBtCancelarFuncTestemunha.setEnabled(false);
        jBtCancelarFuncTestemunha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarFuncTestemunha.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarFuncTestemunha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarFuncTestemunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarFuncTestemunhaActionPerformed(evt);
            }
        });

        jBtAuditoriaFuncTestemunha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaFuncTestemunha.setContentAreaFilled(false);
        jBtAuditoriaFuncTestemunha.setEnabled(false);
        jBtAuditoriaFuncTestemunha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoriaFuncTestemunha.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaFuncTestemunha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaFuncTestemunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaFuncTestemunhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jBtNovoFuncTestemunha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarFuncTestemunha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirFuncTestemunha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarFuncTestemunha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarFuncTestemunha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaFuncTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoriaFuncTestemunha)
                    .addComponent(jBtCancelarFuncTestemunha)
                    .addComponent(jBtSalvarFuncTestemunha)
                    .addComponent(jBtExcluirFuncTestemunha)
                    .addComponent(jBtAlterarFuncTestemunha)
                    .addComponent(jBtNovoFuncTestemunha))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabelaFuncTestemunha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaFuncTestemunha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Completo do Colaborador", "Departamento"
            }
        ));
        jTabelaFuncTestemunha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaFuncTestemunhaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTabelaFuncTestemunha);
        if (jTabelaFuncTestemunha.getColumnModel().getColumnCount() > 0) {
            jTabelaFuncTestemunha.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaFuncTestemunha.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaFuncTestemunha.getColumnModel().getColumn(1).setMinWidth(280);
            jTabelaFuncTestemunha.getColumnModel().getColumn(1).setMaxWidth(280);
            jTabelaFuncTestemunha.getColumnModel().getColumn(2).setMinWidth(120);
            jTabelaFuncTestemunha.getColumnModel().getColumn(2).setMaxWidth(120);
        }

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Código");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("RG");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Departamento");

        jBtPesqFuncTestemunha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqFuncTestemunha.setContentAreaFilled(false);
        jBtPesqFuncTestemunha.setEnabled(false);
        jBtPesqFuncTestemunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqFuncTestemunhaActionPerformed(evt);
            }
        });

        jIdFuncTestemunha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdFuncTestemunha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdFuncTestemunha.setEnabled(false);

        jNomeDepartamentoTestemunha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeDepartamentoTestemunha.setEnabled(false);

        jRGFuncTestemunha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRGFuncTestemunha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jRGFuncTestemunha.setEnabled(false);

        jNomeFuncTestemunha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeFuncTestemunha.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Nome do Colaborador");

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoFuncTestemunha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoFuncTestemunha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeFuncTestemunha)
                    .addComponent(jNomeDepartamentoTestemunha, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel27))
                        .addGap(0, 172, Short.MAX_VALUE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jIdFuncTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqFuncTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jRGFuncTestemunha))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jIdFuncTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqFuncTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRGFuncTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeFuncTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeDepartamentoTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane4.addTab("Colaboradores", jPanel25);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4))
        );

        jTabbedPane1.addTab("Testemunha (s)", jPanel10);

        jTabbedPane5.setForeground(new java.awt.Color(0, 153, 0));
        jTabbedPane5.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Código");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Descrição do Objeto Apreendido");

        jIdInternoPertence.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoPertence.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoPertence.setEnabled(false);

        jDescricaoObjeto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoObjeto.setEnabled(false);

        jBtPesqInternoPertence.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInternoPertence.setContentAreaFilled(false);
        jBtPesqInternoPertence.setEnabled(false);
        jBtPesqInternoPertence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoPertenceActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Código");

        jIdObjeto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdObjeto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdObjeto.setEnabled(false);

        jNomeInternoPertenceObjeto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoPertenceObjeto.setEnabled(false);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Nome Completo do Interno");

        jBtPesqObjeto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqObjeto.setContentAreaFilled(false);
        jBtPesqObjeto.setEnabled(false);
        jBtPesqObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqObjetoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Qtde.");

        jQtdEncontrado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQtdEncontrado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQtdEncontrado.setEnabled(false);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jIdInternoPertence, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqInternoPertence, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jBtPesqObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNomeInternoPertenceObjeto)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel36)
                                    .addComponent(jDescricaoObjeto))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jQtdEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel35))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel33)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel30Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jIdInternoPertence, jIdObjeto});

        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdInternoPertence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqInternoPertence, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInternoPertenceObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(jLabel12))
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDescricaoObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQtdEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel30Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jIdInternoPertence, jIdObjeto});

        jTabelaInternosObjetos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternosObjetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Completo do Interno", "Objeto Encontrado"
            }
        ));
        jTabelaInternosObjetos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternosObjetosMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTabelaInternosObjetos);
        if (jTabelaInternosObjetos.getColumnModel().getColumnCount() > 0) {
            jTabelaInternosObjetos.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaInternosObjetos.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaInternosObjetos.getColumnModel().getColumn(1).setMinWidth(280);
            jTabelaInternosObjetos.getColumnModel().getColumn(1).setMaxWidth(280);
            jTabelaInternosObjetos.getColumnModel().getColumn(2).setMinWidth(140);
            jTabelaInternosObjetos.getColumnModel().getColumn(2).setMaxWidth(140);
        }

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovoObjeto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoObjeto.setText("Novo");
        jBtNovoObjeto.setToolTipText("Novo");
        jBtNovoObjeto.setContentAreaFilled(false);
        jBtNovoObjeto.setEnabled(false);
        jBtNovoObjeto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoObjeto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoObjeto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoObjetoActionPerformed(evt);
            }
        });

        jBtAlterarObjeto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarObjeto.setText("Alterar");
        jBtAlterarObjeto.setToolTipText("Alterar");
        jBtAlterarObjeto.setContentAreaFilled(false);
        jBtAlterarObjeto.setEnabled(false);
        jBtAlterarObjeto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarObjeto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarObjeto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarObjetoActionPerformed(evt);
            }
        });

        jBtExcluirObjeto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirObjeto.setText("Excluir");
        jBtExcluirObjeto.setToolTipText("Excluir");
        jBtExcluirObjeto.setContentAreaFilled(false);
        jBtExcluirObjeto.setEnabled(false);
        jBtExcluirObjeto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirObjeto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirObjeto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirObjetoActionPerformed(evt);
            }
        });

        jBtSalvarObjeto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarObjeto.setText("Gravar");
        jBtSalvarObjeto.setToolTipText("Gravar");
        jBtSalvarObjeto.setContentAreaFilled(false);
        jBtSalvarObjeto.setEnabled(false);
        jBtSalvarObjeto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarObjeto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarObjeto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarObjetoActionPerformed(evt);
            }
        });

        jBtCancelarObjeto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarObjeto.setText("Cancelar");
        jBtCancelarObjeto.setToolTipText("Cancelar");
        jBtCancelarObjeto.setContentAreaFilled(false);
        jBtCancelarObjeto.setEnabled(false);
        jBtCancelarObjeto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarObjeto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarObjeto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarObjetoActionPerformed(evt);
            }
        });

        jBtAuditoriaObjeto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaObjeto.setToolTipText("Auditoria Objetos");
        jBtAuditoriaObjeto.setContentAreaFilled(false);
        jBtAuditoriaObjeto.setEnabled(false);
        jBtAuditoriaObjeto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoriaObjeto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaObjeto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaObjetoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jBtNovoObjeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarObjeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirObjeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarObjeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarObjeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoriaObjeto)
                    .addComponent(jBtCancelarObjeto)
                    .addComponent(jBtSalvarObjeto)
                    .addComponent(jBtExcluirObjeto)
                    .addComponent(jBtAlterarObjeto)
                    .addComponent(jBtNovoObjeto))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7)
                    .addComponent(jPanel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane5.addTab("Apreenssões", jPanel26);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovoHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoHistorico.setText("Novo");
        jBtNovoHistorico.setToolTipText("Novo");
        jBtNovoHistorico.setContentAreaFilled(false);
        jBtNovoHistorico.setEnabled(false);
        jBtNovoHistorico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoHistorico.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoHistorico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoHistoricoActionPerformed(evt);
            }
        });

        jBtAlterarHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarHistorico.setText("Alterar");
        jBtAlterarHistorico.setToolTipText("Alterar");
        jBtAlterarHistorico.setContentAreaFilled(false);
        jBtAlterarHistorico.setEnabled(false);
        jBtAlterarHistorico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarHistorico.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarHistorico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarHistoricoActionPerformed(evt);
            }
        });

        jBtExcluirHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirHistorico.setText("Excluir");
        jBtExcluirHistorico.setToolTipText("Excluir");
        jBtExcluirHistorico.setContentAreaFilled(false);
        jBtExcluirHistorico.setEnabled(false);
        jBtExcluirHistorico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirHistorico.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirHistorico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirHistoricoActionPerformed(evt);
            }
        });

        jBtSalvarHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarHistorico.setText("Gravar");
        jBtSalvarHistorico.setToolTipText("Gravar");
        jBtSalvarHistorico.setContentAreaFilled(false);
        jBtSalvarHistorico.setEnabled(false);
        jBtSalvarHistorico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarHistorico.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarHistorico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarHistoricoActionPerformed(evt);
            }
        });

        jBtCancelarHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarHistorico.setText("Cancelar");
        jBtCancelarHistorico.setToolTipText("Cancelar");
        jBtCancelarHistorico.setContentAreaFilled(false);
        jBtCancelarHistorico.setEnabled(false);
        jBtCancelarHistorico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarHistorico.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarHistorico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarHistoricoActionPerformed(evt);
            }
        });

        jBtAuditoriaHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaHistorico.setToolTipText("Auditoria Histórico");
        jBtAuditoriaHistorico.setContentAreaFilled(false);
        jBtAuditoriaHistorico.setEnabled(false);
        jBtAuditoriaHistorico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAuditoriaHistorico.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaHistorico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAuditoriaHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaHistoricoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jBtNovoHistorico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarHistorico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirHistorico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarHistorico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarHistorico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoriaHistorico)
                    .addComponent(jBtCancelarHistorico)
                    .addComponent(jBtSalvarHistorico)
                    .addComponent(jBtExcluirHistorico)
                    .addComponent(jBtAlterarHistorico)
                    .addComponent(jBtNovoHistorico))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jHistorico.setColumns(20);
        jHistorico.setRows(5);
        jHistorico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHistorico.setEnabled(false);
        jScrollPane8.setViewportView(jHistorico);

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Código");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Nome Completo do Interno");

        jIdInternoHistorico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoHistorico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoHistorico.setEnabled(false);

        jNomeInternoHistorico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoHistorico.setEnabled(false);

        jBtPesqInternoHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInternoHistorico.setContentAreaFilled(false);
        jBtPesqInternoHistorico.setEnabled(false);
        jBtPesqInternoHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoHistoricoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jIdInternoHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqInternoHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jNomeInternoHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jIdInternoHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqInternoHistorico)
                            .addComponent(jNomeInternoHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaHistorico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Completo do Interno", "Histórico do Interno"
            }
        ));
        jTabelaHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaHistoricoMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTabelaHistorico);
        if (jTabelaHistorico.getColumnModel().getColumnCount() > 0) {
            jTabelaHistorico.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaHistorico.getColumnModel().getColumn(1).setMinWidth(280);
            jTabelaHistorico.getColumnModel().getColumn(1).setMaxWidth(280);
            jTabelaHistorico.getColumnModel().getColumn(2).setMinWidth(240);
            jTabelaHistorico.getColumnModel().getColumn(2).setMaxWidth(240);
        }

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane5.addTab("Histórico", jPanel29);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 413, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Objetos", jPanel14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 20, 509, 470);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoActionPerformed
        // TODO add your handling code here:
        if (jIdPesqCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um código para pesquisa.");
        } else {
            preencherTabelaRegistroEventos("SELECT * FROM REGISTROEVENTOS "
                    + "INNER JOIN LOCALEVENTOS "
                    + "ON REGISTROEVENTOS.IdLocal=LOCALEVENTOS.IdLocal "
                    + "INNER JOIN NATUREZAEVENTOS "
                    + "ON REGISTROEVENTOS.IdNatureza=NATUREZAEVENTOS.IdNatureza "
                    + "INNER JOIN PAVILHAO "
                    + "ON REGISTROEVENTOS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN CELAS "
                    + "ON REGISTROEVENTOS.IdCela=CELAS.IdCela "
                    + "WHERE IdLanc='" + jIdPesqCodigo.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqCodigoActionPerformed

    private void jBtPesqDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDatasActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
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
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                        preencherTabelaRegistroEventos("SELECT * FROM REGISTROEVENTOS "
                                + "INNER JOIN LOCALEVENTOS "
                                + "ON REGISTROEVENTOS.IdLocal=LOCALEVENTOS.IdLocal "
                                + "INNER JOIN NATUREZAEVENTOS "
                                + "ON REGISTROEVENTOS.IdNatureza=NATUREZAEVENTOS.IdNatureza "
                                + "INNER JOIN PAVILHAO "
                                + "ON REGISTROEVENTOS.IdPav=PAVILHAO.IdPav "
                                + "INNER JOIN CELAS "
                                + "ON REGISTROEVENTOS.IdCela=CELAS.IdCela "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
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
                        preencherTabelaRegistroEventos("SELECT * FROM REGISTROEVENTOS "
                                + "INNER JOIN LOCALEVENTOS "
                                + "ON REGISTROEVENTOS.IdLocal=LOCALEVENTOS.IdLocal "
                                + "INNER JOIN NATUREZAEVENTOS "
                                + "ON REGISTROEVENTOS.IdNatureza=NATUREZAEVENTOS.IdNatureza "
                                + "INNER JOIN PAVILHAO "
                                + "ON REGISTROEVENTOS.IdPav=PAVILHAO.IdPav "
                                + "INNER JOIN CELAS "
                                + "ON REGISTROEVENTOS.IdCela=CELAS.IdCela "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDatasActionPerformed

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaRegistroEventos("SELECT * FROM REGISTROEVENTOS "
                    + "INNER JOIN LOCALEVENTOS "
                    + "ON REGISTROEVENTOS.IdLocal=LOCALEVENTOS.IdLocal "
                    + "INNER JOIN NATUREZAEVENTOS "
                    + "ON REGISTROEVENTOS.IdNatureza=NATUREZAEVENTOS.IdNatureza "
                    + "INNER JOIN PAVILHAO "
                    + "ON REGISTROEVENTOS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN CELAS "
                    + "ON REGISTROEVENTOS.IdCela=CELAS.IdCela");
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
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovoInterno.setEnabled(true);
            jBtNovoInternoVitima.setEnabled(true);
            jBtNovoFuncVitima.setEnabled(true);
            jBtNovoInternoTestemunha.setEnabled(true);
            jBtNovoFuncTestemunha.setEnabled(true);
            jBtNovoObjeto.setEnabled(true);
            jBtNovoHistorico.setEnabled(true);
            jBtFichaFaltas.setEnabled(!true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM REGISTROEVENTOS "
                        + "INNER JOIN NATUREZAEVENTOS "
                        + "ON REGISTROEVENTOS.IdNatureza=NATUREZAEVENTOS.IdNatureza "
                        + "INNER JOIN LOCALEVENTOS "
                        + "ON REGISTROEVENTOS.IdLocal=LOCALEVENTOS.IdLocal "
                        + "INNER JOIN PAVILHAO "
                        + "ON REGISTROEVENTOS.IdPav=PAVILHAO.IdPav "
                        + "INNER JOIN CELAS "
                        + "ON REGISTROEVENTOS.IdCela=CELAS.IdCela "
                        + "WHERE IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                jHorarioEvento.setText(conecta.rs.getString("HorarioEvento"));
                jDescricaoEvento.setText(conecta.rs.getString("DescricaoNatureza"));
                jDescricaoLocalEvento.setText(conecta.rs.getString("DescricaoLocal"));
                jIdPav.setText(conecta.rs.getString("IdPav"));
                jDescricaoPavilhao.setText(conecta.rs.getString("DescricaoPav"));
                jIdCela.setText(conecta.rs.getString("IdCela"));
                jDescricaoCela.setText(conecta.rs.getString("EndCelaPav"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados.\nERRO: " + e);
            }
            preencherTabelaInternos("SELECT * FROM AUTOREVENTOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON AUTOREVENTOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN REGISTROEVENTOS "
                    + "ON AUTOREVENTOS.IdLanc=REGISTROEVENTOS.IdLanc "
                    + "INNER JOIN CELAS "
                    + "ON AUTOREVENTOS.IdCela=CELAS.IdCela "
                    + "WHERE AUTOREVENTOS.IdLanc='" + IdLanc + "'");
            preencherTabelaInternosVitima("SELECT * FROM INTERNOSVITIMAS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON INTERNOSVITIMAS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN REGISTROEVENTOS "
                    + "ON INTERNOSVITIMAS.IdLanc=REGISTROEVENTOS.IdLanc "
                    + "WHERE INTERNOSVITIMAS.IdLanc='" + IdLanc + "'");
            preencherTabelaColaboradorVitima("SELECT * FROM COLABORADORVITIMA "
                    + "INNER JOIN COLABORADOR "
                    + "ON COLABORADORVITIMA.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN REGISTROEVENTOS "
                    + "ON COLABORADORVITIMA.IdLanc=REGISTROEVENTOS.IdLanc "
                    + "WHERE COLABORADORVITIMA.IdLanc='" + IdLanc + "'");
            preencherTabelaInternosTestemunha("SELECT * FROM INTERNOTESTEMUNHA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON INTERNOTESTEMUNHA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN REGISTROEVENTOS "
                    + "ON INTERNOTESTEMUNHA.IdLanc=REGISTROEVENTOS.IdLanc "
                    + "WHERE INTERNOTESTEMUNHA.IdLanc='" + IdLanc + "'");
            preencherTabelaColaboradorTestemunha("SELECT * FROM COLABORADORTESTEMUNHA "
                    + "INNER JOIN COLABORADOR "
                    + "ON COLABORADORTESTEMUNHA.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN REGISTROEVENTOS "
                    + "ON COLABORADORTESTEMUNHA.IdLanc=REGISTROEVENTOS.IdLanc "
                    + "WHERE COLABORADORTESTEMUNHA.IdLanc='" + IdLanc + "'");
            preencherTabelaInternosObjetos("SELECT * FROM APRENSSOES "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON APRENSSOES.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN OBJETOSPROCEDIMENTOS "
                    + "ON APRENSSOES.IdObjeto=OBJETOSPROCEDIMENTOS.IdObjeto "
                    + "INNER JOIN REGISTROEVENTOS "
                    + "ON APRENSSOES.IdLanc=REGISTROEVENTOS.IdLanc "
                    + "WHERE APRENSSOES.IdLanc='" + IdLanc + "'");
            preencherTabelaInternosHistorico("SELECT * FROM HISTORICOAUTOR "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON HISTORICOAUTOR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN REGISTROEVENTOS "
                    + "ON HISTORICOAUTOR.IdLanc=REGISTROEVENTOS.IdLanc "
                    + "WHERE HISTORICOAUTOR.IdLanc='" + IdLanc + "'");
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaRegistroEventosIndisciplinarMouseClicked

    private void jBtPesqNaturezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNaturezaActionPerformed
        // TODO add your handling code here:
        TelaPesquisarNaturezaEvento objPesqNatuEven = new TelaPesquisarNaturezaEvento();
        TelaModuloSeguranca.jPainelSeguranca.add(objPesqNatuEven);
        objPesqNatuEven.show();
    }//GEN-LAST:event_jBtPesqNaturezaActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaInternoAutor.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível finalizar esse lançamento, não existe internos relacionados\na esse registro.");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM REGISTROEVENTOS WHERE IdLanc='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                if (jStatusLanc.getText().equals("FINALIZADO")) {
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

    private void jBtPesqLocalEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqLocalEventoActionPerformed
        // TODO add your handling code here:
        TelaPesquisarLocalEvento objLocalEvento = new TelaPesquisarLocalEvento();
        TelaModuloSeguranca.jPainelSeguranca.add(objLocalEvento);
        objLocalEvento.show();
    }//GEN-LAST:event_jBtPesqLocalEventoActionPerformed

    private void jBtPesqPavilhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqPavilhaoActionPerformed
        // TODO add your handling code here:
        TelaPesqPavilhaoEventoDisciplinar objPesqPavEven = new TelaPesqPavilhaoEventoDisciplinar();
        TelaModuloSeguranca.jPainelSeguranca.add(objPesqPavEven);
        objPesqPavEven.show();
    }//GEN-LAST:event_jBtPesqPavilhaoActionPerformed

    private void jBtPesqCelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCelaActionPerformed
        // TODO add your handling code here:
        TelaPesqCelasEventoDisciplinar objCelaEvn = new TelaPesqCelasEventoDisciplinar();
        TelaModuloSeguranca.jPainelSeguranca.add(objCelaEvn);
        objCelaEvn.show();
    }//GEN-LAST:event_jBtPesqCelaActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinar);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinar) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            acao = 1;
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            limparTabelaInternosAutor();
            limparTabelaInternoVitima();
            limparTabelaColaboradorVitima();
            limparTabelaInternoTestemunha();
            limparTabelaColaboradorTestemunha();
            limparTabelaInternosObjetos();
            limparTabelaHistorico();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinar);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinar) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            objRegEvenDisciplinar.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
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
        buscarAcessoUsuario(telaRegistroEvendoDisciplinar);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinar) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            verificarTodosRegistros();
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else if (jIdLanc.getText().equals(idLancHist) || jIdLanc.getText().equals(idLancApr) || jIdLanc.getText().equals(idLancFuncTes)
                    || jIdLanc.getText().equals(idLancIntTes) || jIdLanc.getText().equals(idLancFuncVit) || jIdLanc.getText().equals(idLancIntVit)
                    || jIdLanc.getText().equals(idLancAut)) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído até que seja(m)\nexcluído(s) os registro(s) da(s) outra(s) aba(s).");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objRegEvenDisciplinar.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    control.excluirEventoDisciplinar(objRegEvenDisciplinar);
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
        buscarAcessoUsuario(telaRegistroEvendoDisciplinar);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinar) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do registro.");
                jDataLanc.requestFocus();
                jDataLanc.setBackground(Color.red);
            } else if (jDescricaoEvento.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a Natureza do Evento.");
            } else if (jDescricaoLocalEvento.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o Local do Evento.");
            } else if (jIdPav.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o pavilhão de origem.");
            } else if (jDescricaoPavilhao.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o pavilhão de origem.");
            } else if (jIdCela.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a cela de origem.");
            } else if (jDescricaoCela.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a cela de origem.");
            } else {
                objRegEvenDisciplinar.setDataLanc(jDataLanc.getDate());
                objRegEvenDisciplinar.setStatusLanc(jStatusLanc.getText());
                objRegEvenDisciplinar.setDescricaoNatureza(jDescricaoEvento.getText());
                objRegEvenDisciplinar.setDescricaoLocalEvento(jDescricaoLocalEvento.getText());
                objRegEvenDisciplinar.setHorarioEvento(jHorarioEvento.getText());
                objRegEvenDisciplinar.setDescricaoPavilhao(jDescricaoPavilhao.getText());
                objRegEvenDisciplinar.setDescricaoCela(jDescricaoCela.getText());
                objRegEvenDisciplinar.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objRegEvenDisciplinar.setUsuarioInsert(nameUser);
                    objRegEvenDisciplinar.setDataInsert(dataModFinal);
                    objRegEvenDisciplinar.setHorarioInsert(horaMov);
                    control.incluirEventoDisciplinar(objRegEvenDisciplinar);
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
                    objRegEvenDisciplinar.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    control.alterarEventoDisciplinar(objRegEvenDisciplinar);
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

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEventosManutencao objAudiEveManu = new TelaAuditoriaEventosManutencao();
        TelaModuloSeguranca.jPainelSeguranca.add(objAudiEveManu);
        objAudiEveManu.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtPesqInternoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoAutorActionPerformed
        // TODO add your handling code here:
        TelaPesqInternosEventosAutor objInterEvenAutor = new TelaPesqInternosEventosAutor();
        TelaModuloSeguranca.jPainelSeguranca.add(objInterEvenAutor);
        objInterEvenAutor.show();
    }//GEN-LAST:event_jBtPesqInternoAutorActionPerformed

    private void jBtPesqCelaDestinoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCelaDestinoAutorActionPerformed
        // TODO add your handling code here:
        TelaPesqCelasEventoDisciplinarAutor objPesqCelaIntAutor = new TelaPesqCelasEventoDisciplinarAutor();
        TelaModuloSeguranca.jPainelSeguranca.add(objPesqCelaIntAutor);
        objPesqCelaIntAutor.show();
    }//GEN-LAST:event_jBtPesqCelaDestinoAutorActionPerformed

    private void jTabelaInternoAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternoAutorMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeInterno = "" + jTabelaInternoAutor.getValueAt(jTabelaInternoAutor.getSelectedRow(), 1);
            jNomeInternoAutor.setText(nomeInterno);
            String nomeCela = "" + jTabelaInternoAutor.getValueAt(jTabelaInternoAutor.getSelectedRow(), 2);
            jCelaDestinoInternoAutor.setText(nomeCela);
            // Habilitar os botões
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(true); // Desabilitado por não está funcionando corretamente.
            jBtExcluirInterno.setEnabled(true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(true);
            jBtAuditoriaInterno.setEnabled(true);
            jBtFichaFaltas.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM AUTOREVENTOS "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON AUTOREVENTOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN REGISTROEVENTOS "
                        + "ON AUTOREVENTOS.IdLanc=REGISTROEVENTOS.IdLanc "
                        + "INNER JOIN CELAS "
                        + "ON AUTOREVENTOS.IdCela=CELAS.IdCela "
                        + "WHERE PRONTUARIOSCRC.NomeInternoCrc='" + jNomeInternoAutor.getText() + "'AND AUTOREVENTOS.IdLanc='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                jIdInternoAutor.setText(conecta.rs.getString("IdInternoCrc"));
                jMatriculaPenalAutor.setText(conecta.rs.getString("MatriculaCrc"));
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon v = new javax.swing.ImageIcon(caminho);
                    jFotoInternoAutor.setIcon(v);
                    jFotoInternoAutor.setIcon(new ImageIcon(v.getImage().getScaledInstance(jFotoInternoAutor.getWidth(), jFotoInternoAutor.getHeight(), Image.SCALE_SMOOTH)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInternoAutor.getWidth(), jFotoInternoAutor.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInternoAutor.setIcon(icon);
                }
                jNomeInternoAutor.setText(conecta.rs.getString("NomeInternoCrc"));
                jQtdeDias.setText(conecta.rs.getString("QtdeDias"));
                idItemAutor = conecta.rs.getInt("IdAutor");
                jCelaDestinoInternoAutor.setText(conecta.rs.getString("EndCelaPav"));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem exibidos!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaInternoAutorMouseClicked

    private void jBtNovoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarAutor);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarAutor) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovoInternoAutor();
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
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarAutor);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarAutor) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            codHistoricoInterno = ""; // Limpando os campos para poder alterar, caso o interno seja excluído
            codInternoObjeto = ""; // Limpando os campos para poder alterar, caso o interno seja excluído
            codInternoVitima = ""; // Limpando os campos para poder alterar, caso o interno seja excluído
            codInternoTestemunha = ""; // Limpando os campos para poder alterar, caso o interno seja excluído
            verificarInternoHistorico(); // Verificar se o mesmo interno esta cadastrado na tabela HISTORICOAUTOR
            verificarInternoObjeto(); // Verificar se o mesmo interno esta cadastrado na tabela APREENSOES
            verificarInternoTestemunha(); // Verificar se o mesmo interno esta cadastrado na tabela INTERNOTESTEMUNHA
            verificarInternoVitima(); // Verificar se o mesmo interno esta cadastrado na tabela INTERNOSVITIMAS
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else if (jIdInternoAutor.getText().equals(codHistoricoInterno) || jIdInternoAutor.getText().equals(codInternoObjeto)
                    || jIdInternoAutor.getText().equals(codInternoTestemunha) || jIdInternoAutor.getText().equals(codInternoVitima)) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro de interno não poderá ser alterado,\nexiste (m) registro(s) relacionado(s) ao(s) mesmo(s).");
            } else {
                acao = 4;
                AlterarInternoAutor();
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
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarAutor);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarAutor) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            verificarInternoHistorico(); // Verificar se o mesmo interno esta cadastrado na tabela HISTORICOAUTOR
            verificarInternoObjeto(); // Verificar se o mesmo interno esta cadastrado na tabela APREENSOES
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else if (jIdInternoAutor.getText().equals(codHistoricoInterno) || jIdInternoAutor.getText().equals(codInternoObjeto)) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro de interno não poderá ser excluído,\npois, existe registro relacionado ao mesmo.");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objAutorEvento.setIdAutor(idItemAutor);
                    controle.excluirAutorEvento(objAutorEvento);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaInternos("SELECT * FROM AUTOREVENTOS "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON AUTOREVENTOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON AUTOREVENTOS.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "INNER JOIN CELAS "
                            + "ON AUTOREVENTOS.IdCela=CELAS.IdCela "
                            + "WHERE AUTOREVENTOS.IdLanc='" + jIdLanc.getText() + "'");
                    ExcluirInternoAutor();
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirInternoActionPerformed

    private void jBtSalvarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarAutor);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarAutor) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jIdInternoAutor.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe qual é o interno para esse registro.");
            } else if (jQtdeDias.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a quantidade de dias para disciplina.");
            } else if (jCelaDestinoInternoAutor.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o destino para o interno.");
            } else {
                objAutorEvento.setUtilizacaoSaida(utilizaSaida);
                objAutorEvento.setNomeInterno(jNomeInternoAutor.getText());
                objAutorEvento.setDescricaoCela(jCelaDestinoInternoAutor.getText());
                objAutorEvento.setQtdDias(Float.valueOf(jQtdeDias.getText()));
                if (acao == 3) {
                    objAutorEvento.setUsuarioInsert(nameUser);
                    objAutorEvento.setDataInsert(dataModFinal);
                    objAutorEvento.setHorarioInsert(horaMov);
                    //
                    objAutorEvento.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    controle.incluirAutorEvento(objAutorEvento);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                
                    preencherTabelaInternos("SELECT * FROM AUTOREVENTOS "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON AUTOREVENTOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON AUTOREVENTOS.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "INNER JOIN CELAS "
                            + "ON AUTOREVENTOS.IdCela=CELAS.IdCela "
                            + "WHERE AUTOREVENTOS.IdLanc='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    SalvarInternoAutor();
                }
                if (acao == 4) {
                    objAutorEvento.setUsuarioUp(nameUser);
                    objAutorEvento.setDataUp(dataModFinal);
                    objAutorEvento.setHorarioUp(horaMov);
                    //
                    objAutorEvento.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objAutorEvento.setIdAutor(idItemAutor);
                    controle.alterarAutorEvento(objAutorEvento);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação             
                    preencherTabelaInternos("SELECT * FROM AUTOREVENTOS "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON AUTOREVENTOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON AUTOREVENTOS.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "INNER JOIN CELAS "
                            + "ON AUTOREVENTOS.IdCela=CELAS.IdCela "
                            + "WHERE AUTOREVENTOS.IdLanc='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    SalvarInternoAutor();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarInternoActionPerformed

    private void jBtCancelarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarInternoActionPerformed
        // TODO add your handling code here:
        CancelarInternoAutor();
    }//GEN-LAST:event_jBtCancelarInternoActionPerformed

    private void jBtAuditoriaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaInternoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaItensEventosAutor objAudiEvenAutor = new TelaAuditoriaItensEventosAutor();
        TelaModuloSeguranca.jPainelSeguranca.add(objAudiEvenAutor);
        objAudiEvenAutor.show();
    }//GEN-LAST:event_jBtAuditoriaInternoActionPerformed

    private void jBtPesqInternoVitimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoVitimaActionPerformed
        // TODO add your handling code here:
        TelaPesqInternosEventosVitima objIntEvenVit = new TelaPesqInternosEventosVitima();
        TelaModuloSeguranca.jPainelSeguranca.add(objIntEvenVit);
        objIntEvenVit.show();
    }//GEN-LAST:event_jBtPesqInternoVitimaActionPerformed

    private void jTabelaInternosVitimasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosVitimasMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeInterno = "" + jTabelaInternosVitimas.getValueAt(jTabelaInternosVitimas.getSelectedRow(), 1);
            jNomeInternoAutor.setText(nomeInterno);
            // Habilitar os botões
            jBtNovoInternoVitima.setEnabled(!true);
            jBtAlterarInternoVitima.setEnabled(true); // Desabilitado por não está funcionando corretamente.
            jBtExcluirInternoVitima.setEnabled(true);
            jBtSalvarInternoVitima.setEnabled(!true);
            jBtCancelarInternoVitima.setEnabled(true);
            jBtAuditoriaInternoVitima.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM INTERNOSVITIMAS "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON INTERNOSVITIMAS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN REGISTROEVENTOS "
                        + "ON INTERNOSVITIMAS.IdLanc=REGISTROEVENTOS.IdLanc "
                        + "WHERE PRONTUARIOSCRC.NomeInternoCrc='" + jNomeInternoAutor.getText() + "'AND INTERNOSVITIMAS.IdLanc='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                jIdInternoCrcVitima.setText(conecta.rs.getString("IdInternoCrc"));
                jMatriculaVitima.setText(conecta.rs.getString("MatriculaCrc"));
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jFotoInternoVitima.setIcon(i);
                    jFotoInternoVitima.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoVitima.getWidth(), jFotoInternoVitima.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInternoVitima.getWidth(), jFotoInternoVitima.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInternoVitima.setIcon(icon);
                }
                jNomeInternoVitima.setText(conecta.rs.getString("NomeInternoCrc"));
                idItemIntVi = conecta.rs.getInt("IdIntVitima");
                jNomeMaeInternoVitima.setText(conecta.rs.getString("MaeInternoCrc"));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem exibidos!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaInternosVitimasMouseClicked

    private void jBtNovoInternoVitimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoVitimaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarVitima);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarVitima) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 5;
                NovoInternoVitima();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoInternoVitimaActionPerformed

    private void jBtAlterarInternoVitimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarInternoVitimaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarVitima);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarVitima) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 6;
                AlterarInternoVitima();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarInternoVitimaActionPerformed

    private void jBtExcluirInternoVitimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirInternoVitimaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarVitima);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarVitima) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objIntVitima.setIdIntVitima(idItemIntVi);
                    controleIntVit.excluirInternoVitima(objIntVitima);
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaInternosVitima("SELECT * FROM INTERNOSVITIMAS "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON INTERNOSVITIMAS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON INTERNOSVITIMAS.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE INTERNOSVITIMAS.IdLanc='" + jIdLanc.getText() + "'");
                    ExcluirInternoVitima();
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirInternoVitimaActionPerformed

    private void jBtSalvarInternoVitimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoVitimaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarVitima);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarVitima) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jIdInternoCrcVitima.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome da vítima.");
            } else {
                objIntVitima.setNomeInternoVitima(jNomeInternoVitima.getText());
                objIntVitima.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                if (acao == 5) {
                    objIntVitima.setUsuarioInsert(nameUser);
                    objIntVitima.setDataInsert(dataModFinal);
                    objIntVitima.setHorarioInsert(horaMov);
                    //
                    controleIntVit.incluirInternoVitima(objIntVitima);
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                    preencherTabelaInternosVitima("SELECT * FROM INTERNOSVITIMAS "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON INTERNOSVITIMAS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON INTERNOSVITIMAS.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE INTERNOSVITIMAS.IdLanc='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro Gravado com sucesso.");
                    SalvarInternoVitima();
                }
                if (acao == 6) {
                    objIntVitima.setUsuarioUp(nameUser);
                    objIntVitima.setDataUp(dataModFinal);
                    objIntVitima.setHorarioUp(horaMov);
                    //
                    objIntVitima.setIdIntVitima(idItemIntVi);
                    controleIntVit.alterarInternoVitima(objIntVitima);
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                    preencherTabelaInternosVitima("SELECT * FROM INTERNOSVITIMAS "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON INTERNOSVITIMAS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON INTERNOSVITIMAS.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE INTERNOSVITIMAS.IdLanc='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro Gravado com sucesso.");
                    SalvarInternoVitima();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarInternoVitimaActionPerformed

    private void jBtCancelarInternoVitimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarInternoVitimaActionPerformed
        // TODO add your handling code here:
        CancelarInternoVitima();
    }//GEN-LAST:event_jBtCancelarInternoVitimaActionPerformed

    private void jBtAuditoriaInternoVitimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaInternoVitimaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEventosInternosVitima objAudiIntEvenVit = new TelaAuditoriaEventosInternosVitima();
        TelaModuloSeguranca.jPainelSeguranca.add(objAudiIntEvenVit);
        objAudiIntEvenVit.show();
    }//GEN-LAST:event_jBtAuditoriaInternoVitimaActionPerformed

    private void jBtPesqFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqFuncActionPerformed
        // TODO add your handling code here:
        TelaPesqInternosEventosFuncVitima objPesqFuncVitima = new TelaPesqInternosEventosFuncVitima();
        TelaModuloSeguranca.jPainelSeguranca.add(objPesqFuncVitima);
        objPesqFuncVitima.show();
    }//GEN-LAST:event_jBtPesqFuncActionPerformed

    private void jTabelaColaboradorVitimaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaColaboradorVitimaMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeFuncVitima = "" + jTabelaColaboradorVitima.getValueAt(jTabelaColaboradorVitima.getSelectedRow(), 1);
            jNomeColaboradorVitima.setText(nomeFuncVitima);
            // Habilitar os botões
            jBtNovoFuncVitima.setEnabled(!true);
            jBtAlterarFuncVitima.setEnabled(true);
            jBtExcluirFuncVitima.setEnabled(true);
            jBtSalvarFuncVitima.setEnabled(!true);
            jBtCancelarFuncVitima.setEnabled(true);
            jBtAuditoriaFuncVitima.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM COLABORADORVITIMA "
                        + "INNER JOIN COLABORADOR "
                        + "ON COLABORADORVITIMA.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN REGISTROEVENTOS "
                        + "ON COLABORADORVITIMA.IdLanc=REGISTROEVENTOS.IdLanc "
                        + "WHERE COLABORADOR.NomeFunc='" + jNomeColaboradorVitima.getText() + "'AND COLABORADORVITIMA.IdLanc='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                jIdFuncVitima.setText(conecta.rs.getString("IdFunc"));
                jRGVitima.setText(conecta.rs.getString("RgFunc"));
                caminho = conecta.rs.getString("ImagemFunc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jFotoFuncVitima.setIcon(i);
                    jFotoFuncVitima.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoFuncVitima.getWidth(), jFotoFuncVitima.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoFuncVitima.getWidth(), jFotoFuncVitima.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoFuncVitima.setIcon(icon);
                }
                jNomeColaboradorVitima.setText(conecta.rs.getString("NomeFunc"));
                idItemFuncVi = conecta.rs.getInt("IdColaVit");
                jDepartamantoVitima.setText(conecta.rs.getString("NomeDepartamento"));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem exibidos!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaColaboradorVitimaMouseClicked

    private void jBtNovoFuncVitimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoFuncVitimaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarVitimaFunc);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarVitimaFunc) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 7;
                NovoFuncVitima();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoFuncVitimaActionPerformed

    private void jBtAlterarFuncVitimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarFuncVitimaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarVitimaFunc);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarVitimaFunc) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 8;
                AlterarFuncVitima();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarFuncVitimaActionPerformed

    private void jBtExcluirFuncVitimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirFuncVitimaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarVitimaFunc);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarVitimaFunc) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objFuncVitima.setIdColaVit(idItemFuncVi);
                    controlFuncVit.excluirColaboradorVitima(objFuncVitima);
                    objLog4();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaColaboradorVitima("SELECT * FROM COLABORADORVITIMA "
                            + "INNER JOIN COLABORADOR "
                            + "ON COLABORADORVITIMA.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON COLABORADORVITIMA.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE COLABORADORVITIMA.IdLanc='" + jIdLanc.getText() + "'");
                    ExcluirFuncVitima();
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirFuncVitimaActionPerformed

    private void jBtSalvarFuncVitimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarFuncVitimaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarVitimaFunc);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarVitimaFunc) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jIdFuncVitima.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do colaborador.");
            } else if (jRGVitima.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o número do RG do colaborador.");
            } else {
                objFuncVitima.setIdColaVit(Integer.valueOf(jIdFuncVitima.getText()));
                objFuncVitima.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                objFuncVitima.setNomeColaborador(jNomeColaboradorVitima.getText());
                objFuncVitima.setRgColaborador(jRGVitima.getText());
                if (acao == 7) {
                    objFuncVitima.setUsuarioInsert(nameUser);
                    objFuncVitima.setDataInsert(dataModFinal);
                    objFuncVitima.setHorarioInsert(horaMov);
                    //                
                    controlFuncVit.incluirColaboradorVitima(objFuncVitima);
                    objLog4();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                    preencherTabelaColaboradorVitima("SELECT * FROM COLABORADORVITIMA "
                            + "INNER JOIN COLABORADOR "
                            + "ON COLABORADORVITIMA.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON COLABORADORVITIMA.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE COLABORADORVITIMA.IdLanc='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    SalvarFuncVitima();
                }
                if (acao == 8) {
                    objFuncVitima.setUsuarioUp(nameUser);
                    objFuncVitima.setDataUp(dataModFinal);
                    objFuncVitima.setHorarioUp(horaMov);
                    //
                    objFuncVitima.setIdColaVit(idItemFuncVi);
                    controlFuncVit.alterarColaboradorVitima(objFuncVitima);
                    objLog4();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                    preencherTabelaColaboradorVitima("SELECT * FROM COLABORADORVITIMA "
                            + "INNER JOIN COLABORADOR "
                            + "ON COLABORADORVITIMA.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON COLABORADORVITIMA.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE COLABORADORVITIMA.IdLanc='" + jIdLanc.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    SalvarFuncVitima();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarFuncVitimaActionPerformed

    private void jBtCancelarFuncVitimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarFuncVitimaActionPerformed
        // TODO add your handling code here:
        CancelarFuncVitima();
    }//GEN-LAST:event_jBtCancelarFuncVitimaActionPerformed

    private void jBtAuditoriaFuncVitimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaFuncVitimaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaFuncEventoVitima objAudiEvenFunc = new TelaAuditoriaFuncEventoVitima();
        TelaModuloSeguranca.jPainelSeguranca.add(objAudiEvenFunc);
        objAudiEvenFunc.show();
    }//GEN-LAST:event_jBtAuditoriaFuncVitimaActionPerformed

    private void jBtPesqInternoTestemunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoTestemunhaActionPerformed
        // TODO add your handling code here:
        TelaPesqInternosEventosTestemunha objIntEvenTest = new TelaPesqInternosEventosTestemunha();
        TelaModuloSeguranca.jPainelSeguranca.add(objIntEvenTest);
        objIntEvenTest.show();
    }//GEN-LAST:event_jBtPesqInternoTestemunhaActionPerformed

    private void jTabelaInternosTestemunhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosTestemunhaMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeInterno = "" + jTabelaInternosTestemunha.getValueAt(jTabelaInternosTestemunha.getSelectedRow(), 1);
            jNomeInternoTestemunha.setText(nomeInterno);
            // Habilitar os botões
            jBtNovoInternoTestemunha.setEnabled(!true);
            jBtAlterarInternoTestemunha.setEnabled(true);
            jBtExcluirInternoTestemunha.setEnabled(true);
            jBtSalvarInternoTestemunha.setEnabled(!true);
            jBtCancelarInternoTestemunha.setEnabled(true);
            jBtAuditoriaInternoTestemunha.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM INTERNOTESTEMUNHA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON INTERNOTESTEMUNHA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN REGISTROEVENTOS "
                        + "ON INTERNOTESTEMUNHA.IdLanc=REGISTROEVENTOS.IdLanc "
                        + "WHERE PRONTUARIOSCRC.NomeInternoCrc='" + jNomeInternoTestemunha.getText() + "'AND INTERNOTESTEMUNHA.IdLanc='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                jIdInternoTestemunha.setText(conecta.rs.getString("IdInternoCrc"));
                jMatriculaInternoTestemunha.setText(conecta.rs.getString("MatriculaCrc"));
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoTestemunha.setIcon(i);
                jFotoInternoTestemunha.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoTestemunha.getWidth(), jFotoInternoTestemunha.getHeight(), Image.SCALE_DEFAULT)));
                jNomeInternoTestemunha.setText(conecta.rs.getString("NomeInternoCrc"));
                idItemIntTes = conecta.rs.getInt("IdIntTeste");
                jNomeMaeInternoTestemunha.setText(conecta.rs.getString("MaeInternoCrc"));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem exibidos!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaInternosTestemunhaMouseClicked

    private void jBtNovoInternoTestemunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoTestemunhaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarTestemunha);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarTestemunha) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 9;
                NovoInternoTestemunha();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoInternoTestemunhaActionPerformed

    private void jBtAlterarInternoTestemunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarInternoTestemunhaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarTestemunha);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarTestemunha) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 10;
                AlterarInternoTestemunha();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarInternoTestemunhaActionPerformed

    private void jBtExcluirInternoTestemunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirInternoTestemunhaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarTestemunha);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarTestemunha) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objIntTeste.setIdIntTeste(idItemIntTes);
                    controleIntTeste.excluirInternoTestemunha(objIntTeste);
                    objLog5();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaInternosTestemunha("SELECT * FROM INTERNOTESTEMUNHA "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON INTERNOTESTEMUNHA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON INTERNOTESTEMUNHA.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE INTERNOTESTEMUNHA.IdLanc='" + jIdLanc.getText() + "'");
                    ExcluirInternoTestemunha();
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirInternoTestemunhaActionPerformed

    private void jBtSalvarInternoTestemunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoTestemunhaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarTestemunha);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarTestemunha) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jIdInternoTestemunha.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o interno testemunha.");
            } else {
                objIntTeste.setNomeInternoTestemunha(jNomeInternoTestemunha.getText());
                objIntTeste.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                if (acao == 9) {
                    objIntTeste.setUsuarioInsert(nameUser);
                    objIntTeste.setDataInsert(dataModFinal);
                    objIntTeste.setHorarioInsert(horaMov);
                    //
                    controleIntTeste.incluirInternoTestemunha(objIntTeste);
                    objLog5();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                    preencherTabelaInternosTestemunha("SELECT * FROM INTERNOTESTEMUNHA "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON INTERNOTESTEMUNHA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON INTERNOTESTEMUNHA.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE INTERNOTESTEMUNHA.IdLanc='" + jIdLanc.getText() + "'");
                    SalvarInternoTestemunha();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravdo com sucesso.");
                }
                if (acao == 10) {
                    objIntTeste.setUsuarioUp(nameUser);
                    objIntTeste.setDataUp(dataModFinal);
                    objIntTeste.setHorarioUp(horaMov);
                    //
                    objIntTeste.setIdIntTeste(idItemIntTes);
                    controleIntTeste.alterarInternoTestemunha(objIntTeste);
                    objLog5();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                    preencherTabelaInternosTestemunha("SELECT * FROM INTERNOTESTEMUNHA "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON INTERNOTESTEMUNHA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON INTERNOTESTEMUNHA.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE INTERNOTESTEMUNHA.IdLanc='" + jIdLanc.getText() + "'");
                    SalvarInternoTestemunha();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravdo com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarInternoTestemunhaActionPerformed

    private void jBtCancelarInternoTestemunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarInternoTestemunhaActionPerformed
        // TODO add your handling code here:
        CancelarInternoTestemunha();
    }//GEN-LAST:event_jBtCancelarInternoTestemunhaActionPerformed

    private void jBtAuditoriaInternoTestemunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaInternoTestemunhaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaInternosTestemunha objAudiIntTest = new TelaAuditoriaInternosTestemunha();
        TelaModuloSeguranca.jPainelSeguranca.add(objAudiIntTest);
        objAudiIntTest.show();
    }//GEN-LAST:event_jBtAuditoriaInternoTestemunhaActionPerformed

    private void jBtPesqFuncTestemunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqFuncTestemunhaActionPerformed
        // TODO add your handling code here:
        TelaPesqInternosEventosFuncTestemunha objPesqInTeste = new TelaPesqInternosEventosFuncTestemunha();
        TelaModuloSeguranca.jPainelSeguranca.add(objPesqInTeste);
        objPesqInTeste.show();
    }//GEN-LAST:event_jBtPesqFuncTestemunhaActionPerformed

    private void jTabelaFuncTestemunhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaFuncTestemunhaMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeFuncTestemunha = "" + jTabelaFuncTestemunha.getValueAt(jTabelaFuncTestemunha.getSelectedRow(), 1);
            jNomeFuncTestemunha.setText(nomeFuncTestemunha);
            // Habilitar os botões
            jBtNovoFuncTestemunha.setEnabled(!true);
            jBtAlterarFuncTestemunha.setEnabled(true);
            jBtExcluirFuncTestemunha.setEnabled(true);
            jBtSalvarFuncTestemunha.setEnabled(!true);
            jBtCancelarFuncTestemunha.setEnabled(true);
            jBtAuditoriaFuncTestemunha.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM COLABORADORTESTEMUNHA "
                        + "INNER JOIN COLABORADOR "
                        + "ON COLABORADORTESTEMUNHA.IdFunc=COLABORADOR.IdFunc "
                        + "INNER JOIN DEPARTAMENTOS "
                        + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                        + "INNER JOIN REGISTROEVENTOS "
                        + "ON COLABORADORTESTEMUNHA.IdLanc=REGISTROEVENTOS.IdLanc "
                        + "WHERE COLABORADOR.NomeFunc='" + jNomeFuncTestemunha.getText() + "'AND COLABORADORTESTEMUNHA.IdLanc='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                jIdFuncTestemunha.setText(conecta.rs.getString("IdFunc"));
                jRGFuncTestemunha.setText(conecta.rs.getString("RgFuncTeste"));
                caminho = conecta.rs.getString("ImagemFunc");
                javax.swing.ImageIcon f = new javax.swing.ImageIcon(caminho);
                jFotoFuncTestemunha.setIcon(f);
                jFotoFuncTestemunha.setIcon(new ImageIcon(f.getImage().getScaledInstance(jFotoFuncTestemunha.getWidth(), jFotoFuncTestemunha.getHeight(), Image.SCALE_DEFAULT)));
                jNomeFuncTestemunha.setText(conecta.rs.getString("NomeFunc"));
                idItemFuncTes = conecta.rs.getInt("IdColaVit");
                jNomeDepartamentoTestemunha.setText(conecta.rs.getString("NomeDepartamento"));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem exibidos!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaFuncTestemunhaMouseClicked

    private void jBtNovoFuncTestemunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoFuncTestemunhaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarTestemunhaFunc);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarTestemunhaFunc) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 11;
                NovoFuncTestemunha();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoFuncTestemunhaActionPerformed

    private void jBtAlterarFuncTestemunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarFuncTestemunhaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarTestemunhaFunc);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarTestemunhaFunc) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 12;
                AlterarFuncTestemunha();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarFuncTestemunhaActionPerformed

    private void jBtExcluirFuncTestemunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirFuncTestemunhaActionPerformed
        // TODO add your handling code here: 
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarTestemunhaFunc);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarTestemunhaFunc) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objFuncTeste.setIdColaVit(idItemFuncTes);
                    controlFuncTeste.excluirColaboradorVitima(objFuncTeste);
                    objLog6();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaColaboradorTestemunha("SELECT * FROM COLABORADORTESTEMUNHA "
                            + "INNER JOIN COLABORADOR "
                            + "ON COLABORADORTESTEMUNHA.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON COLABORADORTESTEMUNHA.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE COLABORADORTESTEMUNHA.IdLanc='" + jIdLanc.getText() + "'");
                    ExcluirFuncTestemunha();
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirFuncTestemunhaActionPerformed

    private void jBtSalvarFuncTestemunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarFuncTestemunhaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarTestemunhaFunc);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarTestemunhaFunc) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jIdFuncTestemunha.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do colaborador.");
            } else if (jRGFuncTestemunha.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o RG do colaborador.");
            } else {
                objFuncTeste.setNomeColaborador(jNomeFuncTestemunha.getText());
                objFuncTeste.setRgFuncTestemunha(jRGFuncTestemunha.getText());
                objFuncTeste.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                if (acao == 11) {
                    objFuncTeste.setUsuarioInsert(nameUser);
                    objFuncTeste.setDataInsert(dataModFinal);
                    objFuncTeste.setHorarioInsert(horaMov);
                    //
                    controlFuncTeste.incluirColaboradorVitima(objFuncTeste);
                    objLog6();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                    preencherTabelaColaboradorTestemunha("SELECT * FROM COLABORADORTESTEMUNHA "
                            + "INNER JOIN COLABORADOR "
                            + "ON COLABORADORTESTEMUNHA.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON COLABORADORTESTEMUNHA.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE COLABORADORTESTEMUNHA.IdLanc='" + jIdLanc.getText() + "'");
                    SalvarFuncTestemunha();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 12) {
                    objFuncTeste.setUsuarioUp(nameUser);
                    objFuncTeste.setDataUp(dataModFinal);
                    objFuncTeste.setHorarioUp(horaMov);
                    //
                    objFuncTeste.setIdColaVit(idItemFuncTes);
                    controlFuncTeste.alterarColaboradorVitima(objFuncTeste);
                    objLog6();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                    preencherTabelaColaboradorTestemunha("SELECT * FROM COLABORADORTESTEMUNHA "
                            + "INNER JOIN COLABORADOR "
                            + "ON COLABORADORTESTEMUNHA.IdFunc=COLABORADOR.IdFunc "
                            + "INNER JOIN DEPARTAMENTOS "
                            + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON COLABORADORTESTEMUNHA.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE COLABORADORTESTEMUNHA.IdLanc='" + jIdLanc.getText() + "'");
                    SalvarFuncTestemunha();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarFuncTestemunhaActionPerformed

    private void jBtCancelarFuncTestemunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarFuncTestemunhaActionPerformed
        // TODO add your handling code here:
        CancelarFuncTestemunha();
    }//GEN-LAST:event_jBtCancelarFuncTestemunhaActionPerformed

    private void jBtAuditoriaFuncTestemunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaFuncTestemunhaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaFuncTestemunha objAudiFuncTest = new TelaAuditoriaFuncTestemunha();
        TelaModuloSeguranca.jPainelSeguranca.add(objAudiFuncTest);
        objAudiFuncTest.show();
    }//GEN-LAST:event_jBtAuditoriaFuncTestemunhaActionPerformed

    private void jBtPesqInternoPertenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoPertenceActionPerformed
        // TODO add your handling code here:
        TelaPesqInternosEventosObjetos objPesqObjInt = new TelaPesqInternosEventosObjetos();
        TelaModuloSeguranca.jPainelSeguranca.add(objPesqObjInt);
        objPesqObjInt.show();
    }//GEN-LAST:event_jBtPesqInternoPertenceActionPerformed

    private void jBtPesqObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqObjetoActionPerformed
        // TODO add your handling code here:
        TelaPesqObjetosEventosDisciplinar objPesqOjetos = new TelaPesqObjetosEventosDisciplinar();
        TelaModuloSeguranca.jPainelSeguranca.add(objPesqOjetos);
        objPesqOjetos.show();
    }//GEN-LAST:event_jBtPesqObjetoActionPerformed

    private void jTabelaInternosObjetosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosObjetosMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String descricaoObjeto = "" + jTabelaInternosObjetos.getValueAt(jTabelaInternosObjetos.getSelectedRow(), 2);
            jDescricaoObjeto.setText(descricaoObjeto);
            String nomeInternoObjeto = "" + jTabelaInternosObjetos.getValueAt(jTabelaInternosObjetos.getSelectedRow(), 1);
            jNomeInternoPertenceObjeto.setText(nomeInternoObjeto);
            String codInterno = "" + jTabelaInternosObjetos.getValueAt(jTabelaInternosObjetos.getSelectedRow(), 0);
            jIdInternoPertence.setText(codInterno);
            // Habilitar os botões
            jBtNovoObjeto.setEnabled(!true);
            jBtAlterarObjeto.setEnabled(true);
            jBtExcluirObjeto.setEnabled(true);
            jBtSalvarObjeto.setEnabled(!true);
            jBtCancelarObjeto.setEnabled(true);
            jBtAuditoriaObjeto.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM APRENSSOES "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON APRENSSOES.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN OBJETOSPROCEDIMENTOS "
                        + "ON APRENSSOES.IdObjeto=OBJETOSPROCEDIMENTOS.IdObjeto "
                        + "INNER JOIN REGISTROEVENTOS "
                        + "ON APRENSSOES.IdLanc=REGISTROEVENTOS.IdLanc "
                        + "WHERE OBJETOSPROCEDIMENTOS.DescricaoObjeto='" + jDescricaoObjeto.getText() + "'AND APRENSSOES.IdLanc='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                jIdObjeto.setText(conecta.rs.getString("IdObjeto"));
                idItemApreende = conecta.rs.getInt("IdAprende");
                jDescricaoObjeto.setText(conecta.rs.getString("DescricaoObjeto"));
                jQtdEncontrado.setText(conecta.rs.getString("Qtd"));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem exibidos!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaInternosObjetosMouseClicked

    private void jBtNovoObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoObjetoActionPerformed
        // TODO add your handling code here:       
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarObjstos);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarObjstos) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 13;
                NovoObjeto();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoObjetoActionPerformed

    private void jBtAlterarObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarObjetoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarObjstos);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarObjstos) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 14;
                AlterarObjeto();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarObjetoActionPerformed

    private void jBtExcluirObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirObjetoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarObjstos);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarObjstos) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objApre.setIdAprende(idItemApreende);
                    controleApre.excluirApreensoes(objApre);
                    objLog7();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaInternosObjetos("SELECT * FROM APRENSSOES "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON APRENSSOES.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN OBJETOSPROCEDIMENTOS "
                            + "ON APRENSSOES.IdObjeto=OBJETOSPROCEDIMENTOS.IdObjeto "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON APRENSSOES.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE APRENSSOES.IdLanc='" + jIdLanc.getText() + "'");
                    ExcluirObjeto();
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirObjetoActionPerformed

    private void jBtSalvarObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarObjetoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarObjstos);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarObjstos) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jIdInternoPertence.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
            } else if (jIdObjeto.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o objeto encontrado.");
            } else if (jQtdEncontrado.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a quantidade de objetos encontrado.");
            } else {
                objApre.setNomeInternoApreensoes(jNomeInternoPertenceObjeto.getText());
                objApre.setDescricaoObjeto(jDescricaoObjeto.getText());
                objApre.setQtdEncontrada(Float.valueOf(jQtdEncontrado.getText()));
                objApre.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                if (acao == 13) {
                    objApre.setUsuarioInsert(nameUser);
                    objApre.setDataInsert(dataModFinal);
                    objApre.setHorarioInsert(horaMov);
                    //
                    controleApre.incluirApreensoes(objApre);
                    objLog7();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                    preencherTabelaInternosObjetos("SELECT * FROM APRENSSOES "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON APRENSSOES.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN OBJETOSPROCEDIMENTOS "
                            + "ON APRENSSOES.IdObjeto=OBJETOSPROCEDIMENTOS.IdObjeto "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON APRENSSOES.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE APRENSSOES.IdLanc='" + jIdLanc.getText() + "'");
                    SalvarObjeto();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 14) {
                    objApre.setUsuarioUp(nameUser);
                    objApre.setDataUp(dataModFinal);
                    objApre.setHorarioUp(horaMov);
                    //
                    objApre.setIdAprende(idItemApreende);
                    controleApre.alterarApreensoes(objApre);
                    objLog7();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                    preencherTabelaInternosObjetos("SELECT * FROM APRENSSOES "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON APRENSSOES.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN OBJETOSPROCEDIMENTOS "
                            + "ON APRENSSOES.IdObjeto=OBJETOSPROCEDIMENTOS.IdObjeto "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON APRENSSOES.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE APRENSSOES.IdLanc='" + jIdLanc.getText() + "'");
                    SalvarObjeto();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarObjetoActionPerformed

    private void jBtCancelarObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarObjetoActionPerformed
        // TODO add your handling code here:
        CancelarObjeto();
    }//GEN-LAST:event_jBtCancelarObjetoActionPerformed

    private void jBtAuditoriaObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaObjetoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaApreenssoes objAudiApre = new TelaAuditoriaApreenssoes();
        TelaModuloSeguranca.jPainelSeguranca.add(objAudiApre);
        objAudiApre.show();
    }//GEN-LAST:event_jBtAuditoriaObjetoActionPerformed

    private void jBtNovoHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoHistoricoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarHistorico);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarHistorico) && codIncluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 15;
                NovoHistorico();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir registro.");
        }
    }//GEN-LAST:event_jBtNovoHistoricoActionPerformed

    private void jBtAlterarHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarHistoricoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarHistorico);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarHistorico) && codAlterar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser modificado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 16;
                AlterarHistorico();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar registro.");
        }
    }//GEN-LAST:event_jBtAlterarHistoricoActionPerformed

    private void jBtExcluirHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirHistoricoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarHistorico);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarHistorico) && codExcluir == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objRegEvenDisciplinar.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse Registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objHisto.setIdHist(idItemHist);
                    controlHist.excluirHistoricoInterno(objHisto);
                    objLog8();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaInternosHistorico("SELECT * FROM HISTORICOAUTOR "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON HISTORICOAUTOR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON HISTORICOAUTOR.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE HISTORICOAUTOR.IdLanc='" + jIdLanc.getText() + "'");
                    ExcluirHistorico();
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir registro.");
        }
    }//GEN-LAST:event_jBtExcluirHistoricoActionPerformed

    private void jBtSalvarHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarHistoricoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroEvendoDisciplinarHistorico);
        if (codigoUser == codUserAcesso && nomeTela.equals(telaRegistroEvendoDisciplinarHistorico) && codGravar == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES")) {
            if (jHistorico.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nao e permitido gravar histórico vazio.");
            } else if (jIdInternoHistorico.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para o histórico.");
            } else {
                objHisto.setHistorico(jHistorico.getText());
                objHisto.setNomeInternoHistorico(jNomeInternoHistorico.getText());
                objHisto.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                if (acao == 15) {
                    objHisto.setUsuarioInsert(nameUser);
                    objHisto.setDataInsert(dataModFinal);
                    objHisto.setHorarioInsert(horaMov);
                    //
                    controlHist.incluirHistoricoInterno(objHisto);
                    objLog8();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                    preencherTabelaInternosHistorico("SELECT * FROM HISTORICOAUTOR "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON HISTORICOAUTOR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON HISTORICOAUTOR.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE HISTORICOAUTOR.IdLanc='" + jIdLanc.getText() + "'");
                    SalvarHistorico();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 16) {
                    objHisto.setUsuarioUp(nameUser);
                    objHisto.setDataUp(dataModFinal);
                    objHisto.setHorarioUp(horaMov);
                    //
                    objHisto.setIdHist(idItemHist);
                    controlHist.alterarHistoricoInterno(objHisto);
                    objLog8();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaInternosHistorico("SELECT * FROM HISTORICOAUTOR "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON HISTORICOAUTOR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN REGISTROEVENTOS "
                            + "ON HISTORICOAUTOR.IdLanc=REGISTROEVENTOS.IdLanc "
                            + "WHERE HISTORICOAUTOR.IdLanc='" + jIdLanc.getText() + "'");
                    SalvarHistorico();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar registro.");
        }
    }//GEN-LAST:event_jBtSalvarHistoricoActionPerformed

    private void jBtCancelarHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarHistoricoActionPerformed
        // TODO add your handling code here:
        CancelarHistorico();
    }//GEN-LAST:event_jBtCancelarHistoricoActionPerformed

    private void jBtAuditoriaHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaHistoricoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaHistoricoEventos objAudiHistEven = new TelaAuditoriaHistoricoEventos();
        TelaModuloSeguranca.jPainelSeguranca.add(objAudiHistEven);
        objAudiHistEven.show();
    }//GEN-LAST:event_jBtAuditoriaHistoricoActionPerformed

    private void jBtPesqInternoHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoHistoricoActionPerformed
        // TODO add your handling code here:
        TelaPesqInternosEventosAutorHistorico objPesqAutoHist = new TelaPesqInternosEventosAutorHistorico();
        TelaModuloSeguranca.jPainelSeguranca.add(objPesqAutoHist);
        objPesqAutoHist.show();
    }//GEN-LAST:event_jBtPesqInternoHistoricoActionPerformed

    private void jTabelaHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaHistoricoMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String nomeInternoHistorico = "" + jTabelaHistorico.getValueAt(jTabelaHistorico.getSelectedRow(), 1);
            jNomeInternoHistorico.setText(nomeInternoHistorico);
            String codInterno = "" + jTabelaHistorico.getValueAt(jTabelaHistorico.getSelectedRow(), 0);
            jIdInternoHistorico.setText(codInterno);
            // Habilitar os botões
            jBtNovoHistorico.setEnabled(!true);
            jBtAlterarHistorico.setEnabled(true);
            jBtExcluirHistorico.setEnabled(true);
            jBtSalvarHistorico.setEnabled(!true);
            jBtCancelarHistorico.setEnabled(true);
            jBtAuditoriaHistorico.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM HISTORICOAUTOR "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON HISTORICOAUTOR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN REGISTROEVENTOS "
                        + "ON HISTORICOAUTOR.IdLanc=REGISTROEVENTOS.IdLanc "
                        + "WHERE PRONTUARIOSCRC.NomeInternoCrc='" + jNomeInternoHistorico.getText() + "'AND HISTORICOAUTOR.IdLanc='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                jIdInternoHistorico.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoHistorico.setText(conecta.rs.getString("NomeInternoCrc"));
                idItemHist = conecta.rs.getInt("IdHist");
                jHistorico.setText(conecta.rs.getString("Historico"));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem exibidos!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaHistoricoMouseClicked

    private void jBtAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAjudaActionPerformed
        // TODO add your handling code here:
        pdf();
    }//GEN-LAST:event_jBtAjudaActionPerformed

    private void jBtFichaFaltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFichaFaltasActionPerformed
        // TODO add your handling code here:
        if (jIdInternoAutor.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o interno para preencher a ficha de indisciplina (FALTAS).");
        } else {
            mostrarFaltas();
        }
    }//GEN-LAST:event_jBtFichaFaltasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAjuda;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarFuncTestemunha;
    private javax.swing.JButton jBtAlterarFuncVitima;
    private javax.swing.JButton jBtAlterarHistorico;
    private javax.swing.JButton jBtAlterarInterno;
    private javax.swing.JButton jBtAlterarInternoTestemunha;
    private javax.swing.JButton jBtAlterarInternoVitima;
    private javax.swing.JButton jBtAlterarObjeto;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaFuncTestemunha;
    private javax.swing.JButton jBtAuditoriaFuncVitima;
    private javax.swing.JButton jBtAuditoriaHistorico;
    private javax.swing.JButton jBtAuditoriaInterno;
    private javax.swing.JButton jBtAuditoriaInternoTestemunha;
    private javax.swing.JButton jBtAuditoriaInternoVitima;
    private javax.swing.JButton jBtAuditoriaObjeto;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarFuncTestemunha;
    private javax.swing.JButton jBtCancelarFuncVitima;
    private javax.swing.JButton jBtCancelarHistorico;
    private javax.swing.JButton jBtCancelarInterno;
    private javax.swing.JButton jBtCancelarInternoTestemunha;
    private javax.swing.JButton jBtCancelarInternoVitima;
    private javax.swing.JButton jBtCancelarObjeto;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirFuncTestemunha;
    private javax.swing.JButton jBtExcluirFuncVitima;
    private javax.swing.JButton jBtExcluirHistorico;
    private javax.swing.JButton jBtExcluirInterno;
    private javax.swing.JButton jBtExcluirInternoTestemunha;
    private javax.swing.JButton jBtExcluirInternoVitima;
    private javax.swing.JButton jBtExcluirObjeto;
    private javax.swing.JButton jBtFichaFaltas;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoFuncTestemunha;
    private javax.swing.JButton jBtNovoFuncVitima;
    private javax.swing.JButton jBtNovoHistorico;
    private javax.swing.JButton jBtNovoInterno;
    private javax.swing.JButton jBtNovoInternoTestemunha;
    private javax.swing.JButton jBtNovoInternoVitima;
    private javax.swing.JButton jBtNovoObjeto;
    private javax.swing.JButton jBtPesqCela;
    private javax.swing.JButton jBtPesqCelaDestinoAutor;
    private javax.swing.JButton jBtPesqCodigo;
    private javax.swing.JButton jBtPesqDatas;
    private javax.swing.JButton jBtPesqFunc;
    private javax.swing.JButton jBtPesqFuncTestemunha;
    private javax.swing.JButton jBtPesqInternoAutor;
    private javax.swing.JButton jBtPesqInternoHistorico;
    private javax.swing.JButton jBtPesqInternoPertence;
    private javax.swing.JButton jBtPesqInternoTestemunha;
    private javax.swing.JButton jBtPesqInternoVitima;
    private javax.swing.JButton jBtPesqLocalEvento;
    private javax.swing.JButton jBtPesqNatureza;
    private javax.swing.JButton jBtPesqObjeto;
    private javax.swing.JButton jBtPesqPavilhao;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarFuncTestemunha;
    private javax.swing.JButton jBtSalvarFuncVitima;
    private javax.swing.JButton jBtSalvarHistorico;
    private javax.swing.JButton jBtSalvarInterno;
    private javax.swing.JButton jBtSalvarInternoTestemunha;
    private javax.swing.JButton jBtSalvarInternoVitima;
    private javax.swing.JButton jBtSalvarObjeto;
    public static javax.swing.JTextField jCelaDestinoInternoAutor;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private com.toedter.calendar.JDateChooser jDataLanc;
    private com.toedter.calendar.JDateChooser jDataPesqFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static javax.swing.JTextField jDepartamantoVitima;
    public static javax.swing.JTextField jDescricaoCela;
    public static javax.swing.JTextField jDescricaoEvento;
    public static javax.swing.JTextField jDescricaoLocalEvento;
    public static javax.swing.JTextField jDescricaoObjeto;
    public static javax.swing.JTextField jDescricaoPavilhao;
    public static javax.swing.JLabel jFotoFuncTestemunha;
    public static javax.swing.JLabel jFotoFuncVitima;
    public static javax.swing.JLabel jFotoInternoAutor;
    public static javax.swing.JLabel jFotoInternoTestemunha;
    public static javax.swing.JLabel jFotoInternoVitima;
    private javax.swing.JTextArea jHistorico;
    private javax.swing.JFormattedTextField jHorarioEvento;
    public static javax.swing.JTextField jIdCela;
    public static javax.swing.JTextField jIdFuncTestemunha;
    public static javax.swing.JTextField jIdFuncVitima;
    public static javax.swing.JTextField jIdInternoAutor;
    public static javax.swing.JTextField jIdInternoCrcVitima;
    public static javax.swing.JTextField jIdInternoHistorico;
    public static javax.swing.JTextField jIdInternoPertence;
    public static javax.swing.JTextField jIdInternoTestemunha;
    public static javax.swing.JTextField jIdLanc;
    public static javax.swing.JTextField jIdObjeto;
    public static javax.swing.JTextField jIdPav;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jMatriculaInternoTestemunha;
    public static javax.swing.JTextField jMatriculaPenalAutor;
    public static javax.swing.JTextField jMatriculaVitima;
    public static javax.swing.JTextField jNomeColaboradorVitima;
    public static javax.swing.JTextField jNomeDepartamentoTestemunha;
    public static javax.swing.JTextField jNomeFuncTestemunha;
    public static javax.swing.JTextField jNomeInternoAutor;
    public static javax.swing.JTextField jNomeInternoHistorico;
    public static javax.swing.JTextField jNomeInternoPertenceObjeto;
    public static javax.swing.JTextField jNomeInternoTestemunha;
    public static javax.swing.JTextField jNomeInternoVitima;
    public static javax.swing.JTextField jNomeMaeInternoTestemunha;
    public static javax.swing.JTextField jNomeMaeInternoVitima;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JFormattedTextField jQtdEncontrado;
    private javax.swing.JFormattedTextField jQtdeDias;
    public static javax.swing.JFormattedTextField jRGFuncTestemunha;
    public static javax.swing.JFormattedTextField jRGVitima;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public static javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTabelaColaboradorVitima;
    private javax.swing.JTable jTabelaFuncTestemunha;
    private javax.swing.JTable jTabelaHistorico;
    private javax.swing.JTable jTabelaInternoAutor;
    private javax.swing.JTable jTabelaInternosObjetos;
    private javax.swing.JTable jTabelaInternosTestemunha;
    private javax.swing.JTable jTabelaInternosVitimas;
    private javax.swing.JTable jTabelaRegistroEventosIndisciplinar;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
        jHistorico.setLineWrap(true);
        jHistorico.setWrapStyleWord(true);
    }

    public void corCampos() {
        jIdLanc.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        jDescricaoEvento.setBackground(Color.white);
        jDescricaoLocalEvento.setBackground(Color.white);
        jHorarioEvento.setBackground(Color.white);
        jIdPav.setBackground(Color.white);
        jDescricaoPavilhao.setBackground(Color.white);
        jIdCela.setBackground(Color.white);
        jDescricaoCela.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jIdInternoAutor.setBackground(Color.white);
        jMatriculaPenalAutor.setBackground(Color.white);
        jQtdeDias.setBackground(Color.white);
        jNomeInternoAutor.setBackground(Color.white);
        jCelaDestinoInternoAutor.setBackground(Color.white);
        //
        jIdInternoCrcVitima.setBackground(Color.white);
        jMatriculaVitima.setBackground(Color.white);
        jNomeInternoVitima.setBackground(Color.white);
        jNomeMaeInternoVitima.setBackground(Color.white);
        //
        jIdFuncVitima.setBackground(Color.white);
        jRGVitima.setBackground(Color.white);
        jNomeColaboradorVitima.setBackground(Color.white);
        jDepartamantoVitima.setBackground(Color.white);
        //
        jIdInternoTestemunha.setBackground(Color.white);
        jMatriculaInternoTestemunha.setBackground(Color.white);
        jNomeInternoTestemunha.setBackground(Color.white);
        jNomeMaeInternoTestemunha.setBackground(Color.white);
        //
        jIdFuncTestemunha.setBackground(Color.white);
        jRGFuncTestemunha.setBackground(Color.white);
        jNomeFuncTestemunha.setBackground(Color.white);
        jNomeDepartamentoTestemunha.setBackground(Color.white);
        //
        jIdInternoPertence.setBackground(Color.white);
        jNomeInternoPertenceObjeto.setBackground(Color.white);
        jIdObjeto.setBackground(Color.white);
        jDescricaoObjeto.setBackground(Color.white);
        jQtdEncontrado.setBackground(Color.white);
        //
        jHistorico.setBackground(Color.white);
        jIdInternoHistorico.setBackground(Color.white);
        jNomeInternoHistorico.setBackground(Color.white);
    }

    public void verificarTodosRegistros() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM HISTORICOAUTOR WHERE IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            idLancHist = conecta.rs.getString("IdLanc");
        } catch (Exception e) {
        }
        //----------- Tablela de APREENSOES
        try {
            conecta.executaSQL("SELECT * FROM APRENSSOES WHERE IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            idLancApr = conecta.rs.getString("IdLanc");
        } catch (Exception e) {
        }
        // ------------------ Tabela de COLABORADORES TESTEMUNHA
        try {
            conecta.executaSQL("SELECT * FROM COLABORADORTESTEMUNHA WHERE IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            idLancFuncTes = conecta.rs.getString("IdLanc");
        } catch (Exception e) {
        }
        //------------------ Tabela de INTERNOS TESTEMUNHAS
        try {
            conecta.executaSQL("SELECT * FROM INTERNOTESTEMUNHA WHERE IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            idLancIntTes = conecta.rs.getString("IdLanc");
        } catch (Exception e) {
        }
        //--------------------- Tabela de COLABORADORVITIMA
        try {
            conecta.executaSQL("SELECT * FROM COLABORADORVITIMA WHERE IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            idLancFuncVit = conecta.rs.getString("IdLanc");
        } catch (Exception e) {
        }
        //-------------------tabela de INTERNOSVITIMAS
        try {
            conecta.executaSQL("SELECT * FROM INTERNOSVITIMAS WHERE IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            idLancIntVit = conecta.rs.getString("IdLanc");
        } catch (Exception e) {
        }
        //-------------------Tabela AUTOREVENTOS
        try {
            conecta.executaSQL("SELECT * FROM AUTOREVENTOS WHERE IdLanc='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            idLancAut = conecta.rs.getString("IdLanc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void Novo() {
        jIdLanc.setText("");
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
        jDescricaoEvento.setText("");
        jDescricaoLocalEvento.setText("");
        jHorarioEvento.setText("");
        jIdPav.setText("");
        jDescricaoPavilhao.setText("");
        jIdCela.setText("");
        jDescricaoCela.setText("");
        jObservacao.setText("");
        //
        jDataLanc.setEnabled(true);
        jHorarioEvento.setEnabled(true);
        jBtPesqNatureza.setEnabled(true);
        jBtPesqLocalEvento.setEnabled(true);
        jBtPesqPavilhao.setEnabled(true);
        jBtPesqCela.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Aba Internos
        jIdInternoAutor.setText("");
        jFotoInternoAutor.setIcon(null);
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jNomeInternoAutor.setText("");
        jCelaDestinoInternoAutor.setText("");
        // Botões Aba Internos Autores
        jBtPesqInternoAutor.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        jBtFichaFaltas.setEnabled(!true);
        jBtFichaFaltas.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void Alterar() {
        jDataLanc.setEnabled(true);
        jHorarioEvento.setEnabled(true);
        jBtPesqNatureza.setEnabled(true);
        jBtPesqLocalEvento.setEnabled(true);
        jBtPesqPavilhao.setEnabled(true);
        jBtPesqCela.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Aba Internos
        jIdInternoAutor.setText("");
        jFotoInternoAutor.setIcon(null);
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jNomeInternoAutor.setText("");
        jCelaDestinoInternoAutor.setText("");
        // Botões Aba Internos Autores
        jBtPesqInternoAutor.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jRGVitima.setEnabled(!true);
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void Excluir() {
        jIdLanc.setText("");
        jStatusLanc.setText("");
        jDataLanc.setDate(null);
        jDescricaoEvento.setText("");
        jDescricaoLocalEvento.setText("");
        jHorarioEvento.setText("");
        jIdPav.setText("");
        jDescricaoPavilhao.setText("");
        jIdCela.setText("");
        jDescricaoCela.setText("");
        jObservacao.setText("");
        //
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Aba Internos
        jIdInternoAutor.setText("");
        jFotoInternoAutor.setIcon(null);
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jNomeInternoAutor.setText("");
        jCelaDestinoInternoAutor.setText("");
        // Botões Aba Internos Autores
        jBtPesqInternoAutor.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jRGVitima.setEnabled(!true);
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void Salvar() {
        //
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Internos
        jIdInternoAutor.setText("");
        jFotoInternoAutor.setIcon(null);
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jNomeInternoAutor.setText("");
        jCelaDestinoInternoAutor.setText("");
        // Botões Aba Internos Autores
        jBtPesqInternoAutor.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void Cancelar() {
        if (jIdLanc.getText().equals("")) {
            jStatusLanc.setText("");
            jDataLanc.setDate(null);
            jDescricaoEvento.setText("");
            jDescricaoLocalEvento.setText("");
            jHorarioEvento.setText("");
            jIdPav.setText("");
            jDescricaoPavilhao.setText("");
            jIdCela.setText("");
            jDescricaoCela.setText("");
            jObservacao.setText("");
            //
            jDataLanc.setEnabled(!true);
            jHorarioEvento.setEnabled(!true);
            jBtPesqNatureza.setEnabled(!true);
            jBtPesqLocalEvento.setEnabled(!true);
            jBtPesqPavilhao.setEnabled(!true);
            jBtPesqCela.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            // Aba Internos
            jIdInternoAutor.setText("");
            jFotoInternoAutor.setIcon(null);
            jMatriculaPenalAutor.setText("");
            jQtdeDias.setText("");
            jNomeInternoAutor.setText("");
            jCelaDestinoInternoAutor.setText("");
            // Botões Aba Internos Autores
            jBtPesqInternoAutor.setEnabled(!true);
            jBtPesqCelaDestinoAutor.setEnabled(!true);
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(!true);
            jBtExcluirInterno.setEnabled(!true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(!true);
            jBtAuditoriaInterno.setEnabled(!true);
            // Aba Interno Vitima
            jIdInternoCrcVitima.setText("");
            jFotoInternoVitima.setIcon(null);
            jMatriculaVitima.setText("");
            jNomeInternoVitima.setText("");
            jNomeMaeInternoVitima.setText("");
            // Botões Aba Internos Vitimas
            jRGVitima.setEnabled(!true);
            jBtPesqInternoVitima.setEnabled(!true);
            jBtNovoInternoVitima.setEnabled(!true);
            jBtAlterarInternoVitima.setEnabled(!true);
            jBtExcluirInternoVitima.setEnabled(!true);
            jBtSalvarInternoVitima.setEnabled(!true);
            jBtCancelarInternoVitima.setEnabled(!true);
            jBtAuditoriaInternoVitima.setEnabled(!true);
            // Aba Funcionário Vitima
            jIdFuncVitima.setText("");
            jRGVitima.setText("");
            jFotoFuncVitima.setIcon(null);
            jNomeColaboradorVitima.setText("");
            jDepartamantoVitima.setText("");
            // Botões Aba Colaborador Vitima
            jBtPesqFunc.setEnabled(!true);
            jBtNovoFuncVitima.setEnabled(!true);
            jBtAlterarFuncVitima.setEnabled(!true);
            jBtExcluirFuncVitima.setEnabled(!true);
            jBtSalvarFuncVitima.setEnabled(!true);
            jBtCancelarFuncVitima.setEnabled(!true);
            jBtAuditoriaFuncVitima.setEnabled(!true);
            // Aba interno testemunha
            jIdInternoTestemunha.setText("");
            jMatriculaInternoTestemunha.setText("");
            jFotoInternoTestemunha.setIcon(null);
            jNomeInternoTestemunha.setText("");
            jNomeMaeInternoTestemunha.setText("");
            // Botões Aba Interno testemunha
            jBtPesqInternoTestemunha.setEnabled(!true);
            jBtNovoInternoTestemunha.setEnabled(!true);
            jBtNovoInternoTestemunha.setEnabled(!true);
            jBtAlterarInternoTestemunha.setEnabled(!true);
            jBtExcluirInternoTestemunha.setEnabled(!true);
            jBtSalvarInternoTestemunha.setEnabled(!true);
            jBtCancelarInternoTestemunha.setEnabled(!true);
            jBtAuditoriaInternoTestemunha.setEnabled(!true);
            // Aba Funcionário Testemunha
            jIdFuncTestemunha.setText("");
            jRGFuncTestemunha.setText("");
            jFotoFuncTestemunha.setIcon(null);
            jNomeFuncTestemunha.setText("");
            jNomeDepartamentoTestemunha.setText("");
            // Botões Aba Colaborador Testemunha
            jBtPesqFuncTestemunha.setEnabled(!true);
            jBtNovoFuncTestemunha.setEnabled(!true);
            jBtAlterarFuncTestemunha.setEnabled(!true);
            jBtExcluirFuncTestemunha.setEnabled(!true);
            jBtSalvarFuncTestemunha.setEnabled(!true);
            jBtCancelarFuncTestemunha.setEnabled(!true);
            jBtAuditoriaFuncTestemunha.setEnabled(!true);
            // Aba Objeto
            jIdInternoPertence.setText("");
            jNomeInternoPertenceObjeto.setText("");
            jIdObjeto.setText("");
            jDescricaoObjeto.setText("");
            // Botões Aba Objeto
            jBtPesqInternoPertence.setEnabled(!true);
            jBtPesqObjeto.setEnabled(!true);
            jBtNovoObjeto.setEnabled(!true);
            jBtAlterarObjeto.setEnabled(!true);
            jBtExcluirObjeto.setEnabled(!true);
            jBtSalvarObjeto.setEnabled(!true);
            jBtCancelarObjeto.setEnabled(!true);
            jBtAuditoriaObjeto.setEnabled(!true);
            // Aba Histórico
            jIdInternoHistorico.setText("");
            jNomeInternoHistorico.setText("");
            jHistorico.setText("");
            //
            jBtPesqInternoHistorico.setEnabled(!true);
            jHistorico.setEnabled(!true);
            //
            jBtNovoHistorico.setEnabled(!true);
            jBtAlterarHistorico.setEnabled(!true);
            jBtExcluirHistorico.setEnabled(!true);
            jBtSalvarHistorico.setEnabled(!true);
            jBtCancelarHistorico.setEnabled(!true);
            jBtAuditoriaHistorico.setEnabled(!true);
        } else {
            jDataLanc.setEnabled(!true);
            jHorarioEvento.setEnabled(!true);
            jBtPesqNatureza.setEnabled(!true);
            jBtPesqLocalEvento.setEnabled(!true);
            jBtPesqPavilhao.setEnabled(!true);
            jBtPesqCela.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            // Aba Internos
            jIdInternoAutor.setText("");
            jFotoInternoAutor.setIcon(null);
            jMatriculaPenalAutor.setText("");
            jQtdeDias.setText("");
            jNomeInternoAutor.setText("");
            jCelaDestinoInternoAutor.setText("");
            // Botões Aba Internos Autores
            jBtPesqInternoAutor.setEnabled(!true);
            jBtPesqCelaDestinoAutor.setEnabled(!true);
            jBtNovoInterno.setEnabled(true);
            jBtAlterarInterno.setEnabled(!true);
            jBtExcluirInterno.setEnabled(!true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(!true);
            jBtAuditoriaInterno.setEnabled(!true);
            // Aba Interno Vitima
            jIdInternoCrcVitima.setText("");
            jFotoInternoVitima.setIcon(null);
            jMatriculaVitima.setText("");
            jNomeInternoVitima.setText("");
            jNomeMaeInternoVitima.setText("");
            // Botões Aba Internos Vitimas
            jRGVitima.setEnabled(!true);
            jBtPesqInternoVitima.setEnabled(!true);
            jBtNovoInternoVitima.setEnabled(true);
            jBtAlterarInternoVitima.setEnabled(!true);
            jBtExcluirInternoVitima.setEnabled(!true);
            jBtSalvarInternoVitima.setEnabled(!true);
            jBtCancelarInternoVitima.setEnabled(!true);
            jBtAuditoriaInternoVitima.setEnabled(!true);
            // Aba Funcionário Vitima
            jIdFuncVitima.setText("");
            jRGVitima.setText("");
            jFotoFuncVitima.setIcon(null);
            jNomeColaboradorVitima.setText("");
            jDepartamantoVitima.setText("");
            // Botões Aba Colaborador Vitima
            jBtPesqFunc.setEnabled(!true);
            jBtNovoFuncVitima.setEnabled(true);
            jBtAlterarFuncVitima.setEnabled(!true);
            jBtExcluirFuncVitima.setEnabled(!true);
            jBtSalvarFuncVitima.setEnabled(!true);
            jBtCancelarFuncVitima.setEnabled(!true);
            jBtAuditoriaFuncVitima.setEnabled(!true);
            // Aba interno testemunha
            jIdInternoTestemunha.setText("");
            jMatriculaInternoTestemunha.setText("");
            jFotoInternoTestemunha.setIcon(null);
            jNomeInternoTestemunha.setText("");
            jNomeMaeInternoTestemunha.setText("");
            // Botões Aba Interno testemunha
            jBtPesqInternoTestemunha.setEnabled(!true);
            jBtNovoInternoTestemunha.setEnabled(true);
            jBtNovoInternoTestemunha.setEnabled(!true);
            jBtAlterarInternoTestemunha.setEnabled(!true);
            jBtExcluirInternoTestemunha.setEnabled(!true);
            jBtSalvarInternoTestemunha.setEnabled(!true);
            jBtCancelarInternoTestemunha.setEnabled(!true);
            jBtAuditoriaInternoTestemunha.setEnabled(!true);
            // Aba Funcionário Testemunha
            jIdFuncTestemunha.setText("");
            jRGFuncTestemunha.setText("");
            jFotoFuncTestemunha.setIcon(null);
            jNomeFuncTestemunha.setText("");
            jNomeDepartamentoTestemunha.setText("");
            // Botões Aba Colaborador Testemunha
            jBtPesqFuncTestemunha.setEnabled(!true);
            jBtNovoFuncTestemunha.setEnabled(true);
            jBtAlterarFuncTestemunha.setEnabled(!true);
            jBtExcluirFuncTestemunha.setEnabled(!true);
            jBtSalvarFuncTestemunha.setEnabled(!true);
            jBtCancelarFuncTestemunha.setEnabled(!true);
            jBtAuditoriaFuncTestemunha.setEnabled(!true);
            // Aba Objeto
            jIdInternoPertence.setText("");
            jNomeInternoPertenceObjeto.setText("");
            jIdObjeto.setText("");
            jDescricaoObjeto.setText("");
            // Botões Aba Objeto
            jBtPesqInternoPertence.setEnabled(!true);
            jBtPesqObjeto.setEnabled(!true);
            jBtNovoObjeto.setEnabled(true);
            jBtAlterarObjeto.setEnabled(!true);
            jBtExcluirObjeto.setEnabled(!true);
            jBtSalvarObjeto.setEnabled(!true);
            jBtCancelarObjeto.setEnabled(!true);
            jBtAuditoriaObjeto.setEnabled(!true);
            // Aba Histórico
            jIdInternoHistorico.setText("");
            jNomeInternoHistorico.setText("");
            jHistorico.setText("");
            //
            jBtPesqInternoHistorico.setEnabled(!true);
            jHistorico.setEnabled(!true);
            //
            jBtNovoHistorico.setEnabled(true);
            jBtAlterarHistorico.setEnabled(!true);
            jBtExcluirHistorico.setEnabled(!true);
            jBtSalvarHistorico.setEnabled(!true);
            jBtCancelarHistorico.setEnabled(!true);
            jBtAuditoriaHistorico.setEnabled(!true);
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
            objRegEvenDisciplinar.setIdLanc(Integer.parseInt(jIdLanc.getText()));
            control.finalizarEventoDisciplinar(objRegEvenDisciplinar);
            jStatusLanc.setText(statusEntrada);
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

    // Método para finalizar o Rol caso o interno seja alocado no isolamento - impedir visitas ao mesmo.
    public void finalizarRolInternos() {

        for (int i = 0; i < jTabelaInternoAutor.getRowCount(); i++) {
            objRegEvenDisciplinar.setStatusLanc(jStatusLanc.getText());
            objRegEvenDisciplinar.setObservacao(observacaoRol);
            objRegEvenDisciplinar.setUsuarioUp(nameUser);
            objRegEvenDisciplinar.setDataUp(dataModFinal);
            objRegEvenDisciplinar.setHorarioUp(horaMov);
            objRegEvenDisciplinar.setIdInternoCrc((int) jTabelaInternoAutor.getValueAt(i, 0));
            objRegEvenDisciplinar.setNomeInternoCrc((String) jTabelaInternoAutor.getValueAt(i, 1));
            control.finalizarEventoDisciplinarRol(objRegEvenDisciplinar);
        }
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGISTROEVENTOS");
            conecta.rs.last();
            jIdLanc.setText(conecta.rs.getString("IdLanc"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void verificarInternoHistorico() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM HISTORICOAUTOR WHERE IdInternoCrc='" + jIdInternoAutor.getText() + "'");
            conecta.rs.first();
            codHistoricoInterno = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarInternoObjeto() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INTERNOTESTEMUNHA WHERE IdInternoCrc='" + jIdInternoAutor.getText() + "'");
            conecta.rs.first();
            codInternoTestemunha = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarInternoVitima() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INTERNOSVITIMAS WHERE IdInternoCrc='" + jIdInternoAutor.getText() + "'");
            conecta.rs.first();
            codInternoVitima = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarInternoTestemunha() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM APRENSSOES WHERE IdInternoCrc='" + jIdInternoAutor.getText() + "'");
            conecta.rs.first();
            codInternoObjeto = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoInternoAutor() {
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(true);
        jQtdeDias.setEnabled(true);
        jBtPesqCelaDestinoAutor.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jRGVitima.setEnabled(!true);
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void AlterarInternoAutor() {
        jBtPesqInternoAutor.setEnabled(true);
        jQtdeDias.setEnabled(true);
        jBtPesqCelaDestinoAutor.setEnabled(true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jRGVitima.setEnabled(!true);
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void ExcluirInternoAutor() {
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jRGVitima.setEnabled(!true);
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void SalvarInternoAutor() {
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jRGVitima.setEnabled(!true);
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void CancelarInternoAutor() {
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        jBtFichaFaltas.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jRGVitima.setEnabled(!true);
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void NovoInternoVitima() {
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(true);
        jBtCancelarInternoVitima.setEnabled(true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void AlterarInternoVitima() {
        //
        jBtPesqInternoVitima.setEnabled(true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(true);
        jBtCancelarInternoVitima.setEnabled(true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void ExcluirInternoVitima() {
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void SalvarInternoVitima() {
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void CancelarInternoVitima() {
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void NovoFuncVitima() {
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(true);
        jBtPesqFunc.setEnabled(true);
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(true);
        jBtCancelarFuncVitima.setEnabled(true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        //
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void AlterarFuncVitima() {
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(true);
        jBtPesqFunc.setEnabled(true);
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(true);
        jBtCancelarFuncVitima.setEnabled(true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        //
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void ExcluirFuncVitima() {
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        //
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        //
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void SalvarFuncVitima() {
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        //
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        //
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void CancelarFuncVitima() {
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        //
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        //
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void NovoInternoTestemunha() {
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(true);
        jBtCancelarInternoTestemunha.setEnabled(true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        //
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        //
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        //
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void AlterarInternoTestemunha() {
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(true);
        jBtCancelarInternoTestemunha.setEnabled(true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        //
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        //
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        //
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void ExcluirInternoTestemunha() {
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        //
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        //
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        //
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void SalvarInternoTestemunha() {
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        //
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        //
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        //
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void CancelarInternoTestemunha() {
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        //
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        //
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        //
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void NovoFuncTestemunha() {
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(true);
        jRGFuncTestemunha.setEnabled(true);
        //
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(true);
        jBtCancelarFuncTestemunha.setEnabled(true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        //
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        //
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        //
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        //
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void AlterarFuncTestemunha() {
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(true);
        jRGFuncTestemunha.setEnabled(true);
        //
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(true);
        jBtCancelarFuncTestemunha.setEnabled(true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        //
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        //
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        //
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        //
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void ExcluirFuncTestemunha() {
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jRGFuncTestemunha.setEnabled(!true);
        //
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        //
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        //
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        //
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        //
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void SalvarFuncTestemunha() {
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jRGFuncTestemunha.setEnabled(!true);
        //
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        //
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        //
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        //
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        //
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void CancelarFuncTestemunha() {
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jRGFuncTestemunha.setEnabled(!true);
        //
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        //
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        //
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        //
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        //
        jIdInternoCrcVitima.setText("");
        jMatriculaVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        //
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        //
        jIdInternoAutor.setText("");
        jNomeInternoAutor.setText("");
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jFotoInternoAutor.setIcon(null);
        jCelaDestinoInternoAutor.setText("");
        //
        jBtPesqInternoAutor.setEnabled(!true);
        jQtdeDias.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        //
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Manutenção
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void NovoObjeto() {
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        jQtdEncontrado.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(true);
        jBtPesqObjeto.setEnabled(true);
        jQtdEncontrado.setEnabled(true);
        //
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(true);
        jBtCancelarObjeto.setEnabled(true);
        jBtAuditoriaObjeto.setEnabled(!true);
        //
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Aba Internos
        jIdInternoAutor.setText("");
        jFotoInternoAutor.setIcon(null);
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jNomeInternoAutor.setText("");
        jCelaDestinoInternoAutor.setText("");
        // Botões Aba Internos Autores
        jBtPesqInternoAutor.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void AlterarObjeto() {
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(true);
        jBtPesqObjeto.setEnabled(true);
        jQtdEncontrado.setEnabled(true);
        //
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(true);
        jBtCancelarObjeto.setEnabled(true);
        jBtAuditoriaObjeto.setEnabled(!true);
        //
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Aba Internos
        jIdInternoAutor.setText("");
        jFotoInternoAutor.setIcon(null);
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jNomeInternoAutor.setText("");
        jCelaDestinoInternoAutor.setText("");
        // Botões Aba Internos Autores
        jBtPesqInternoAutor.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void ExcluirObjeto() {
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        jQtdEncontrado.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jQtdEncontrado.setEnabled(!true);
        //
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        //
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Internos
        jIdInternoAutor.setText("");
        jFotoInternoAutor.setIcon(null);
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jNomeInternoAutor.setText("");
        jCelaDestinoInternoAutor.setText("");
        // Botões Aba Internos Autores
        jBtPesqInternoAutor.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void SalvarObjeto() {
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        jQtdEncontrado.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jQtdEncontrado.setEnabled(!true);
        //
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        //
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Internos
        jIdInternoAutor.setText("");
        jFotoInternoAutor.setIcon(null);
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jNomeInternoAutor.setText("");
        jCelaDestinoInternoAutor.setText("");
        // Botões Aba Internos Autores
        jBtPesqInternoAutor.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void CancelarObjeto() {
        // Aba Objeto
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        jQtdEncontrado.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jQtdEncontrado.setEnabled(!true);
        //
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        //
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Internos
        jIdInternoAutor.setText("");
        jFotoInternoAutor.setIcon(null);
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jNomeInternoAutor.setText("");
        jCelaDestinoInternoAutor.setText("");
        // Botões Aba Internos Autores
        jBtPesqInternoAutor.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
    }

    public void NovoHistorico() {
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        jBtPesqInternoHistorico.setEnabled(true);
        jHistorico.setEnabled(true);
        //
        jBtNovoHistorico.setEnabled(!true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(true);
        jBtCancelarHistorico.setEnabled(true);
        jBtAuditoriaHistorico.setEnabled(!true);
        //
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        jQtdEncontrado.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jQtdEncontrado.setEnabled(!true);
        //
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        //
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Aba Internos
        jIdInternoAutor.setText("");
        jFotoInternoAutor.setIcon(null);
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jNomeInternoAutor.setText("");
        jCelaDestinoInternoAutor.setText("");
        // Botões Aba Internos Autores
        jBtPesqInternoAutor.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
    }

    public void AlterarHistorico() {

        jBtPesqInternoHistorico.setEnabled(true);
        jHistorico.setEnabled(true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(true);
        jBtCancelarHistorico.setEnabled(true);
        jBtAuditoriaHistorico.setEnabled(!true);
        //
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        jQtdEncontrado.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jQtdEncontrado.setEnabled(!true);
        //
        jBtNovoObjeto.setEnabled(!true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        //
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Aba Internos
        jIdInternoAutor.setText("");
        jFotoInternoAutor.setIcon(null);
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jNomeInternoAutor.setText("");
        jCelaDestinoInternoAutor.setText("");
        // Botões Aba Internos Autores
        jBtPesqInternoAutor.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        jBtNovoInterno.setEnabled(!true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(!true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(!true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(!true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(!true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
    }

    public void ExcluirHistorico() {
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
        //
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        jQtdEncontrado.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jQtdEncontrado.setEnabled(!true);
        //
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        //
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Internos
        jIdInternoAutor.setText("");
        jFotoInternoAutor.setIcon(null);
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jNomeInternoAutor.setText("");
        jCelaDestinoInternoAutor.setText("");
        // Botões Aba Internos Autores
        jBtPesqInternoAutor.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
    }

    public void SalvarHistorico() {
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
        //
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        jQtdEncontrado.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jQtdEncontrado.setEnabled(!true);
        //
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        //
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Internos
        jIdInternoAutor.setText("");
        jFotoInternoAutor.setIcon(null);
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jNomeInternoAutor.setText("");
        jCelaDestinoInternoAutor.setText("");
        // Botões Aba Internos Autores
        jBtPesqInternoAutor.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
    }

    public void CancelarHistorico() {
        // Aba Histórico
        jIdInternoHistorico.setText("");
        jNomeInternoHistorico.setText("");
        jHistorico.setText("");
        //
        jBtPesqInternoHistorico.setEnabled(!true);
        jHistorico.setEnabled(!true);
        //
        jBtNovoHistorico.setEnabled(true);
        jBtAlterarHistorico.setEnabled(!true);
        jBtExcluirHistorico.setEnabled(!true);
        jBtSalvarHistorico.setEnabled(!true);
        jBtCancelarHistorico.setEnabled(!true);
        jBtAuditoriaHistorico.setEnabled(!true);
        //
        jIdInternoPertence.setText("");
        jNomeInternoPertenceObjeto.setText("");
        jIdObjeto.setText("");
        jDescricaoObjeto.setText("");
        jQtdEncontrado.setText("");
        // Botões Aba Objeto
        jBtPesqInternoPertence.setEnabled(!true);
        jBtPesqObjeto.setEnabled(!true);
        jQtdEncontrado.setEnabled(!true);
        //
        jBtNovoObjeto.setEnabled(true);
        jBtAlterarObjeto.setEnabled(!true);
        jBtExcluirObjeto.setEnabled(!true);
        jBtSalvarObjeto.setEnabled(!true);
        jBtCancelarObjeto.setEnabled(!true);
        jBtAuditoriaObjeto.setEnabled(!true);
        //
        jDataLanc.setEnabled(!true);
        jHorarioEvento.setEnabled(!true);
        jBtPesqNatureza.setEnabled(!true);
        jBtPesqLocalEvento.setEnabled(!true);
        jBtPesqPavilhao.setEnabled(!true);
        jBtPesqCela.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Aba Internos
        jIdInternoAutor.setText("");
        jFotoInternoAutor.setIcon(null);
        jMatriculaPenalAutor.setText("");
        jQtdeDias.setText("");
        jNomeInternoAutor.setText("");
        jCelaDestinoInternoAutor.setText("");
        // Botões Aba Internos Autores
        jBtPesqInternoAutor.setEnabled(!true);
        jBtPesqCelaDestinoAutor.setEnabled(!true);
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaInterno.setEnabled(!true);
        // Aba Interno Vitima
        jIdInternoCrcVitima.setText("");
        jFotoInternoVitima.setIcon(null);
        jMatriculaVitima.setText("");
        jNomeInternoVitima.setText("");
        jNomeMaeInternoVitima.setText("");
        // Botões Aba Internos Vitimas
        jBtPesqInternoVitima.setEnabled(!true);
        jBtNovoInternoVitima.setEnabled(true);
        jBtAlterarInternoVitima.setEnabled(!true);
        jBtExcluirInternoVitima.setEnabled(!true);
        jBtSalvarInternoVitima.setEnabled(!true);
        jBtCancelarInternoVitima.setEnabled(!true);
        jBtAuditoriaInternoVitima.setEnabled(!true);
        // Aba Funcionário Vitima
        jIdFuncVitima.setText("");
        jRGVitima.setText("");
        jFotoFuncVitima.setIcon(null);
        jNomeColaboradorVitima.setText("");
        jDepartamantoVitima.setText("");
        // Botões Aba Colaborador Vitima
        jRGVitima.setEnabled(!true);
        jBtPesqFunc.setEnabled(!true);
        jBtNovoFuncVitima.setEnabled(true);
        jBtAlterarFuncVitima.setEnabled(!true);
        jBtExcluirFuncVitima.setEnabled(!true);
        jBtSalvarFuncVitima.setEnabled(!true);
        jBtCancelarFuncVitima.setEnabled(!true);
        jBtAuditoriaFuncVitima.setEnabled(!true);
        // Aba interno testemunha
        jIdInternoTestemunha.setText("");
        jMatriculaInternoTestemunha.setText("");
        jFotoInternoTestemunha.setIcon(null);
        jNomeInternoTestemunha.setText("");
        jNomeMaeInternoTestemunha.setText("");
        // Botões Aba Interno testemunha
        jBtPesqInternoTestemunha.setEnabled(!true);
        jBtNovoInternoTestemunha.setEnabled(true);
        jBtAlterarInternoTestemunha.setEnabled(!true);
        jBtExcluirInternoTestemunha.setEnabled(!true);
        jBtSalvarInternoTestemunha.setEnabled(!true);
        jBtCancelarInternoTestemunha.setEnabled(!true);
        jBtAuditoriaInternoTestemunha.setEnabled(!true);
        // Aba Funcionário Testemunha
        jIdFuncTestemunha.setText("");
        jRGFuncTestemunha.setText("");
        jFotoFuncTestemunha.setIcon(null);
        jNomeFuncTestemunha.setText("");
        jNomeDepartamentoTestemunha.setText("");
        // Botões Aba Colaborador Testemunha
        jBtPesqFuncTestemunha.setEnabled(!true);
        jBtNovoFuncTestemunha.setEnabled(true);
        jBtAlterarFuncTestemunha.setEnabled(!true);
        jBtExcluirFuncTestemunha.setEnabled(!true);
        jBtSalvarFuncTestemunha.setEnabled(!true);
        jBtCancelarFuncTestemunha.setEnabled(!true);
        jBtAuditoriaFuncTestemunha.setEnabled(!true);
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
                dataBrasil = conecta.rs.getString("DataLanc");
                String dia = dataBrasil.substring(8, 10);
                String mes = dataBrasil.substring(5, 7);
                String ano = dataBrasil.substring(0, 4);
                dataBrasil = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela 
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataBrasil, conecta.rs.getString("StatusLanc"), conecta.rs.getString("Observacao")});
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
        String[] Colunas = new String[]{"Código", "Nome Completo do Interno", "Destino", "Qtd.Dias"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("EndCelaPav"), conecta.rs.getInt("QtdeDias")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternoAutor.setModel(modelo);
        jTabelaInternoAutor.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternoAutor.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaInternoAutor.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(2).setPreferredWidth(180);
        jTabelaInternoAutor.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInternoAutor.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternoAutor.getTableHeader().setReorderingAllowed(false);
        jTabelaInternoAutor.setAutoResizeMode(jTabelaInternoAutor.AUTO_RESIZE_OFF);
        jTabelaInternoAutor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaInternoAutor();
        conecta.desconecta();
    }

    public void limparTabelaInternosAutor() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Completo do Interno", "Destino", "Qtd.Dias"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternoAutor.setModel(modelo);
        jTabelaInternoAutor.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternoAutor.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaInternoAutor.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(2).setPreferredWidth(180);
        jTabelaInternoAutor.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternoAutor.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaInternoAutor.getColumnModel().getColumn(3).setResizable(false);
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
        jTabelaInternoAutor.getColumnModel().getColumn(3).setCellRenderer(direita);
    }

    public void preencherTabelaInternosVitima(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Completo do Interno", "Matricula"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("MatriculaCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternosVitimas.setModel(modelo);
        jTabelaInternosVitimas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternosVitimas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternosVitimas.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaInternosVitimas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternosVitimas.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTabelaInternosVitimas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternosVitimas.getTableHeader().setReorderingAllowed(false);
        jTabelaInternosVitimas.setAutoResizeMode(jTabelaInternosVitimas.AUTO_RESIZE_OFF);
        jTabelaInternosVitimas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaInternoVitima();
        conecta.desconecta();
    }

    public void limparTabelaInternoVitima() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Completo do Interno", "Matricula"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternosVitimas.setModel(modelo);
        jTabelaInternosVitimas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternosVitimas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternosVitimas.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaInternosVitimas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternosVitimas.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTabelaInternosVitimas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternosVitimas.getTableHeader().setReorderingAllowed(false);
        jTabelaInternosVitimas.setAutoResizeMode(jTabelaInternosVitimas.AUTO_RESIZE_OFF);
        jTabelaInternosVitimas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaInternoVitima() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternosVitimas.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternosVitimas.getColumnModel().getColumn(2).setCellRenderer(direita);
    }

    public void preencherTabelaColaboradorVitima(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Completo do Colaborador", "Departamento"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdFunc"), conecta.rs.getString("NomeFunc"), conecta.rs.getString("NomeDepartamento")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaColaboradorVitima.setModel(modelo);
        jTabelaColaboradorVitima.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaColaboradorVitima.getColumnModel().getColumn(0).setResizable(false);
        jTabelaColaboradorVitima.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaColaboradorVitima.getColumnModel().getColumn(1).setResizable(false);
        jTabelaColaboradorVitima.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTabelaColaboradorVitima.getColumnModel().getColumn(2).setResizable(false);
        jTabelaColaboradorVitima.getTableHeader().setReorderingAllowed(false);
        jTabelaColaboradorVitima.setAutoResizeMode(jTabelaColaboradorVitima.AUTO_RESIZE_OFF);
        jTabelaColaboradorVitima.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaColaboradorVitima();
        conecta.desconecta();
    }

    public void limparTabelaColaboradorVitima() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Completo do Colaborador", "Departamento"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaColaboradorVitima.setModel(modelo);
        jTabelaColaboradorVitima.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaColaboradorVitima.getColumnModel().getColumn(0).setResizable(false);
        jTabelaColaboradorVitima.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaColaboradorVitima.getColumnModel().getColumn(1).setResizable(false);
        jTabelaColaboradorVitima.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTabelaColaboradorVitima.getColumnModel().getColumn(2).setResizable(false);
        jTabelaColaboradorVitima.getTableHeader().setReorderingAllowed(false);
        jTabelaColaboradorVitima.setAutoResizeMode(jTabelaColaboradorVitima.AUTO_RESIZE_OFF);
        jTabelaColaboradorVitima.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaColaboradorVitima() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaColaboradorVitima.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }

    public void preencherTabelaInternosTestemunha(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Completo do Interno", "Matricula"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("MatriculaCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternosTestemunha.setModel(modelo);
        jTabelaInternosTestemunha.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternosTestemunha.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternosTestemunha.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaInternosTestemunha.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternosTestemunha.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTabelaInternosTestemunha.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternosTestemunha.getTableHeader().setReorderingAllowed(false);
        jTabelaInternosTestemunha.setAutoResizeMode(jTabelaInternosTestemunha.AUTO_RESIZE_OFF);
        jTabelaInternosTestemunha.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaInternoTestemunha();
        conecta.desconecta();
    }

    public void limparTabelaInternoTestemunha() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Completo do Interno", "Matricula"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternosTestemunha.setModel(modelo);
        jTabelaInternosTestemunha.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternosTestemunha.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternosTestemunha.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaInternosTestemunha.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternosTestemunha.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTabelaInternosTestemunha.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternosTestemunha.getTableHeader().setReorderingAllowed(false);
        jTabelaInternosTestemunha.setAutoResizeMode(jTabelaInternosTestemunha.AUTO_RESIZE_OFF);
        jTabelaInternosTestemunha.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaInternoTestemunha() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternosTestemunha.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternosTestemunha.getColumnModel().getColumn(2).setCellRenderer(direita);
    }

    public void preencherTabelaColaboradorTestemunha(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Completo do Colaborador", "Departamento"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdFunc"), conecta.rs.getString("NomeFunc"), conecta.rs.getString("NomeDepartamento")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaFuncTestemunha.setModel(modelo);
        jTabelaFuncTestemunha.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaFuncTestemunha.getColumnModel().getColumn(0).setResizable(false);
        jTabelaFuncTestemunha.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaFuncTestemunha.getColumnModel().getColumn(1).setResizable(false);
        jTabelaFuncTestemunha.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTabelaFuncTestemunha.getColumnModel().getColumn(2).setResizable(false);
        jTabelaFuncTestemunha.getTableHeader().setReorderingAllowed(false);
        jTabelaFuncTestemunha.setAutoResizeMode(jTabelaFuncTestemunha.AUTO_RESIZE_OFF);
        jTabelaFuncTestemunha.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaColaboradorTestemunha();
        conecta.desconecta();
    }

    public void limparTabelaColaboradorTestemunha() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Completo do Colaborador", "Departamento"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaFuncTestemunha.setModel(modelo);
        jTabelaFuncTestemunha.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaFuncTestemunha.getColumnModel().getColumn(0).setResizable(false);
        jTabelaFuncTestemunha.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaFuncTestemunha.getColumnModel().getColumn(1).setResizable(false);
        jTabelaFuncTestemunha.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTabelaFuncTestemunha.getColumnModel().getColumn(2).setResizable(false);
        jTabelaFuncTestemunha.getTableHeader().setReorderingAllowed(false);
        jTabelaFuncTestemunha.setAutoResizeMode(jTabelaFuncTestemunha.AUTO_RESIZE_OFF);
        jTabelaFuncTestemunha.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaColaboradorTestemunha() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaFuncTestemunha.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }

    public void preencherTabelaInternosObjetos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Completo do Interno", "Objeto Encontrado"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("DescricaoObjeto")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternosObjetos.setModel(modelo);
        jTabelaInternosObjetos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternosObjetos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternosObjetos.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaInternosObjetos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternosObjetos.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTabelaInternosObjetos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternosObjetos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternosObjetos.setAutoResizeMode(jTabelaInternosObjetos.AUTO_RESIZE_OFF);
        jTabelaInternosObjetos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaInternosObjetos();
        conecta.desconecta();
    }

    public void limparTabelaInternosObjetos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Completo do Interno", "Objeto Encontrado"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternosObjetos.setModel(modelo);
        jTabelaInternosObjetos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInternosObjetos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternosObjetos.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaInternosObjetos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternosObjetos.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTabelaInternosObjetos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternosObjetos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternosObjetos.setAutoResizeMode(jTabelaInternosObjetos.AUTO_RESIZE_OFF);
        jTabelaInternosObjetos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaInternosObjetos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternosObjetos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }

    public void preencherTabelaInternosHistorico(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Completo do Interno", "Histórico do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("Historico")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaHistorico.setModel(modelo);
        jTabelaHistorico.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaHistorico.getColumnModel().getColumn(0).setResizable(false);
        jTabelaHistorico.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaHistorico.getColumnModel().getColumn(1).setResizable(false);
        jTabelaHistorico.getColumnModel().getColumn(2).setPreferredWidth(240);
        jTabelaHistorico.getColumnModel().getColumn(2).setResizable(false);
        jTabelaHistorico.getTableHeader().setReorderingAllowed(false);
        jTabelaHistorico.setAutoResizeMode(jTabelaHistorico.AUTO_RESIZE_OFF);
        jTabelaHistorico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaHistorico();
        conecta.desconecta();
    }

    public void limparTabelaHistorico() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome Completo do Interno", "Histórico do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaHistorico.setModel(modelo);
        jTabelaHistorico.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaHistorico.getColumnModel().getColumn(0).setResizable(false);
        jTabelaHistorico.getColumnModel().getColumn(1).setPreferredWidth(280);
        jTabelaHistorico.getColumnModel().getColumn(1).setResizable(false);
        jTabelaHistorico.getColumnModel().getColumn(2).setPreferredWidth(240);
        jTabelaHistorico.getColumnModel().getColumn(2).setResizable(false);
        jTabelaHistorico.getTableHeader().setReorderingAllowed(false);
        jTabelaHistorico.setAutoResizeMode(jTabelaHistorico.AUTO_RESIZE_OFF);
        jTabelaHistorico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaHistorico.getColumnModel().getColumn(0).setCellRenderer(centralizado);
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

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog4() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela4);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog5() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela5);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog6() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela6);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog7() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela7);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog8() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela8);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    // Abrir arquivo de ajuda no formato PDF
    public void pdf() {
        File AjudaEventosPDF = new File("C://SysConp//Manuais//ApoioRegistroEventos.pdf");
        try {
            //import java.awt.Desktop;
            if (AjudaEventosPDF.exists()) {
                Desktop.getDesktop().open(AjudaEventosPDF);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Arquivo ou Diretorio não existe.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
