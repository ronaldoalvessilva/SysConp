/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleTelasSistema;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.CadastroTelasSistema;
import static gestor.Visao.TelaAgendaCompromissos.jAssunto;
import static gestor.Visao.TelaAgendaCompromissos.jBtAlterarComp;
import static gestor.Visao.TelaAgendaCompromissos.jBtCancelarComp;
import static gestor.Visao.TelaAgendaCompromissos.jBtConfirmarCompromisso;
import static gestor.Visao.TelaAgendaCompromissos.jBtExcluirComp;
import static gestor.Visao.TelaAgendaCompromissos.jBtNovoComp;
import static gestor.Visao.TelaAgendaCompromissos.jBtSalvarComp;
import static gestor.Visao.TelaAgendaCompromissos.jCodigoAgendaComp;
import static gestor.Visao.TelaAgendaCompromissos.jComboBoxConclusao;
import static gestor.Visao.TelaAgendaCompromissos.jComboBoxPrioridade;
import static gestor.Visao.TelaAgendaCompromissos.jComboBoxStatusComp;
import static gestor.Visao.TelaAgendaCompromissos.jComboBoxTipoEvento;
import static gestor.Visao.TelaAgendaCompromissos.jDataEvento;
import static gestor.Visao.TelaAgendaCompromissos.jDataInicio;
import static gestor.Visao.TelaAgendaCompromissos.jDataLembrete;
import static gestor.Visao.TelaAgendaCompromissos.jDataTermino;
import static gestor.Visao.TelaAgendaCompromissos.jHoraInicio;
import static gestor.Visao.TelaAgendaCompromissos.jHoraLembrete;
import static gestor.Visao.TelaAgendaCompromissos.jHoraTermino;
import static gestor.Visao.TelaAgendaCompromissos.jNomeUsuarioAgenda;
import static gestor.Visao.TelaAgendaCompromissos.jTabelaAgendaEventos;
import static gestor.Visao.TelaAgendaCompromissos.jTextoEvento;
import static gestor.Visao.TelaAgendaCompromissos.jtotalRegistros;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.idUserAcesso;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaRecadosCrc.jBtAlterar;
import static gestor.Visao.TelaRecadosCrc.jBtCancelar;
import static gestor.Visao.TelaRecadosCrc.jBtConfirmar;
import static gestor.Visao.TelaRecadosCrc.jBtExcluir;
import static gestor.Visao.TelaRecadosCrc.jBtNovo;
import static gestor.Visao.TelaRecadosCrc.jBtResponder;
import static gestor.Visao.TelaRecadosCrc.jBtSalvar;
import static gestor.Visao.TelaRecadosCrc.jComboBoxStatus;
import static gestor.Visao.TelaRecadosCrc.jDataLanc;
import static gestor.Visao.TelaRecadosCrc.jHoraRecado;
import static gestor.Visao.TelaRecadosCrc.jIDLanc;
import static gestor.Visao.TelaRecadosCrc.jNomeDestinatario;
import static gestor.Visao.TelaRecadosCrc.jNomeRementente;
import static gestor.Visao.TelaRecadosCrc.jRecado;
import static gestor.Visao.TelaRecadosCrc.jTabelaTodosRecados;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
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
public class TelaModuloFinanceiro extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
    //
    private TelaDepositoBancario objDepBanc = null;
    private TelaSaqueBancario objSaqBanc = null;
    private TelaConsultaSaldoFin objConsultaSaldoFin = null;
    private TelaRecadosFinanceiro objRecadoFin = null;
    private TelaConsultaLocalInternoFinanceiro objConsultaLocalInt = null;
    private TelaConsultaProntuarioInternoCrcBKP objConsuProntuario = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaRolVisitasPortaria objConsRol = null;
    private TelaDepositoBancarioInativos objDepBancInat = null;
    private TelaSaqueBancarioInativos objSaqBancIna = null;
    private TelaTransferenciaValoresInternos objTransValor = null;
    private TelaLiberadoresFinanceiro objLibe = null;
    private TelaEstornoDepositoSaqueAtivosInativos objEstornoDep = null;
    //
    String dataLanc;
    int codUsuario;
    int flag;
    //
    String statusAgenda = "Pendente";
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado.  
    //
    String dataInicial, dataFinal;
    String situacaoEnt = "ENTRADA NA UNIDADE";
    String situacaoRet = "RETORNO A UNIDADE";
    //
    String tipoEmpresa = "Interna";
    String statusInterno = "Ativo";
    int count = 0;
    // VARIÁVEIS PARA AGENDA DE COMPROMISSO.
    String dataAgenda;
    String nomeUsuarioCompromisso; // USUÁRIO DA AGENDA DE COMPROMISSO.
    String horaLembrete;
    String usuarioAgenda;
    String codigoAgendaComp;
    // LIBERADORES
    int idGrupo;
    int idModulo;
    int idGrupoModulo;
    // VARIAVEIS PARA PERMISSÃO DE USUÁRIOS NOS MÓDULOS
    String loginUsusario = "ADMINISTRADOR DO SISTEMA";
    String nomeUsuario = "";
//    String nomeGrupo = "";
    //GRUPO DE ADMINISTRADORES E DIRETORORES
    public static String grupoAdministrador = "ADMINISTRADORES";
    public static String grupoDiretores = "DIRETORES"; // AINDA NÃO FOI CRIADO A FUNCIONALIDADE (16/07/2016)
    String nomeModulo = "";
    String permissaoModulo = "";
    //
    // TELAS DE ACESSOS AO MÓDULO FINANCEIRO
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO
    public static String nomeModuloBV = "FINANCEIRO";
    // MENU CADASTRO    
    public static String telaLiberadoresFinanceiro = "Cadastro:Controle Valores:Liberação Valores:Manutenção";
    public static String telaDepositoAtivo = "Movimentação:Controle Valores:Depósito Contas Ativas:Manutenção";
    public static String telaSaqueAtivo = "Movimentação:Controle Valores:Saque Contas Ativas:Manutenção";
    public static String telaTransferenciaValores = "Movimentação:Controle Valores:Transferencia Valores:Manutenção";
    public static String telaDepositoInativo = "Movimentação:Controle Valores:Depósito Contas Inativos:Manutenção";
    public static String telaSaqueInativo = "Movimentação:Controle Valores:Saque Contas Inativos:Manutenção";
    public static String telaEstornoValores = "Movimentação:Controle Valores:Estorno:Manutenção";
    // VARIÁVEIS PARA CONTROLE DE CADASTRO DAS TELAS NA TABELA TELAS.
    // MENU CADASTRO
    String pNomeCVL = "";
    // MOVIMENTAÇÃO
    String pNomeLF = "";
    String pNomeDA = "";
    String pNomeSA = "";
    String pNomeTV = "";
    String pNomeDI = "";
    String pNomeSI = "";
    String pNomeEV = "";
    //
    public static int codigoUser = 0;
    public static int codUserAcesso = 0;
    public static int codigoUserGroup = 0;
    public static int codAbrir = 0;
    public static int codIncluir = 0;
    public static int codAlterar = 0;
    public static int codExcluir = 0;
    public static int codGravar = 0;
    public static int codConcultar = 0;
    public static int codigoGrupo = 0;
    public static String nomeGrupo = "";
    public static String nomeTela = "";

    /**
     * Creates new form TelaFinanceiro
     */
    public TelaModuloFinanceiro() {
        initComponents();
        this.setSize(840, 640); // Tamanho da tela 
        pesquisarTelasAcessos();
        // verificarRecado();
        threadMensagem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPainelFinanceiro = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Cadastros = new javax.swing.JMenu();
        LiberadoresFinanceiro = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromisso = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        Sair = new javax.swing.JMenuItem();
        Consultas = new javax.swing.JMenu();
        LocalizacaoInternos = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        ConsultaSaldos = new javax.swing.JMenuItem();
        Movimentacao = new javax.swing.JMenu();
        DepositoInterno = new javax.swing.JMenuItem();
        SaqueValores = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        TransferenciaValores = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        ContasInativas = new javax.swing.JMenu();
        DepositoInativos = new javax.swing.JMenuItem();
        SaqueInativos = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jEstornoDepositoSaqueAtivosInativos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        ExtratoValores = new javax.swing.JMenuItem();
        RelacaoSaldoInternosAtivos = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jExtratoGeralInternosInativos = new javax.swing.JMenuItem();
        RelacaoSaldoInternosInativos = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        RelatorioInternosUnidade = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        RelatorioListaPassagem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        RelatorioPrevisaoSaida = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        RelatorioValoresRegistradosGeral = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("...::: BANCO VIRTUAL - Controle de Valores :::...");

        jPainelFinanceiro.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/SISCONP 2.gif"))); // NOI18N

        jPainelFinanceiro.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelFinanceiroLayout = new javax.swing.GroupLayout(jPainelFinanceiro);
        jPainelFinanceiro.setLayout(jPainelFinanceiroLayout);
        jPainelFinanceiroLayout.setHorizontalGroup(
            jPainelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelFinanceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE))
        );
        jPainelFinanceiroLayout.setVerticalGroup(
            jPainelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelFinanceiroLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        Cadastros.setText("Cadastros");

        LiberadoresFinanceiro.setText("Liberadores Financeiro");
        LiberadoresFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LiberadoresFinanceiroActionPerformed(evt);
            }
        });
        Cadastros.add(LiberadoresFinanceiro);
        Cadastros.add(jSeparator10);

        AgendaCompromisso.setText("Agenda de Compromissos Pessoal");
        AgendaCompromisso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaCompromissoActionPerformed(evt);
            }
        });
        Cadastros.add(AgendaCompromisso);

        AgendaRecados.setText("Agenda de Recados");
        AgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaRecadosActionPerformed(evt);
            }
        });
        Cadastros.add(AgendaRecados);
        Cadastros.add(jSeparator11);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        Cadastros.add(Sair);

        jMenuBar1.add(Cadastros);

        Consultas.setText("Consultas");

        LocalizacaoInternos.setText("Localização dos Internos");
        LocalizacaoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalizacaoInternosActionPerformed(evt);
            }
        });
        Consultas.add(LocalizacaoInternos);

        jMenuItem3.setText("Prontuario de Internos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Consultas.add(jMenuItem3);
        Consultas.add(jSeparator3);

        jMenuItem4.setText("Rol de Visitas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        Consultas.add(jMenuItem4);
        Consultas.add(jSeparator2);

        ConsultaSaldos.setText("Consulta Saldo de Valores");
        ConsultaSaldos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaSaldosActionPerformed(evt);
            }
        });
        Consultas.add(ConsultaSaldos);

        jMenuBar1.add(Consultas);

        Movimentacao.setText("Movimentação");

        DepositoInterno.setText("Depósito de Valores dos Internos");
        DepositoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepositoInternoActionPerformed(evt);
            }
        });
        Movimentacao.add(DepositoInterno);

        SaqueValores.setText("Saque de Valores dos Internos");
        SaqueValores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaqueValoresActionPerformed(evt);
            }
        });
        Movimentacao.add(SaqueValores);
        Movimentacao.add(jSeparator7);

        TransferenciaValores.setForeground(new java.awt.Color(204, 0, 0));
        TransferenciaValores.setText("Transferências Valores Ativo/Inativo");
        TransferenciaValores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferenciaValoresActionPerformed(evt);
            }
        });
        Movimentacao.add(TransferenciaValores);
        Movimentacao.add(jSeparator9);

        ContasInativas.setForeground(new java.awt.Color(0, 102, 0));
        ContasInativas.setText("Contas de Inativos");

        DepositoInativos.setText("Depósito Inativo");
        DepositoInativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepositoInativosActionPerformed(evt);
            }
        });
        ContasInativas.add(DepositoInativos);

        SaqueInativos.setText("Saque Inativo");
        SaqueInativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaqueInativosActionPerformed(evt);
            }
        });
        ContasInativas.add(SaqueInativos);

        Movimentacao.add(ContasInativas);
        Movimentacao.add(jSeparator12);

        jEstornoDepositoSaqueAtivosInativos.setForeground(new java.awt.Color(0, 0, 255));
        jEstornoDepositoSaqueAtivosInativos.setText("Estorno de Depósito/Saque - Ativos e Inativos");
        jEstornoDepositoSaqueAtivosInativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEstornoDepositoSaqueAtivosInativosActionPerformed(evt);
            }
        });
        Movimentacao.add(jEstornoDepositoSaqueAtivosInativos);

        jMenuBar1.add(Movimentacao);

        jMenu3.setText("Relatórios");

        ExtratoValores.setForeground(new java.awt.Color(0, 0, 255));
        ExtratoValores.setText("Extrato Geral de Valores de Internos Ativos");
        ExtratoValores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtratoValoresActionPerformed(evt);
            }
        });
        jMenu3.add(ExtratoValores);

        RelacaoSaldoInternosAtivos.setForeground(new java.awt.Color(0, 153, 0));
        RelacaoSaldoInternosAtivos.setText("Relação de Saldo de Internos - Ativos");
        RelacaoSaldoInternosAtivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelacaoSaldoInternosAtivosActionPerformed(evt);
            }
        });
        jMenu3.add(RelacaoSaldoInternosAtivos);
        jMenu3.add(jSeparator8);

        jExtratoGeralInternosInativos.setForeground(new java.awt.Color(204, 0, 0));
        jExtratoGeralInternosInativos.setText("Extrato Geral de Valores Internos Inativos");
        jExtratoGeralInternosInativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExtratoGeralInternosInativosActionPerformed(evt);
            }
        });
        jMenu3.add(jExtratoGeralInternosInativos);

        RelacaoSaldoInternosInativos.setForeground(new java.awt.Color(102, 0, 102));
        RelacaoSaldoInternosInativos.setText("Relação de Saldo de Internos - Inativos");
        RelacaoSaldoInternosInativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelacaoSaldoInternosInativosActionPerformed(evt);
            }
        });
        jMenu3.add(RelacaoSaldoInternosInativos);
        jMenu3.add(jSeparator6);

        RelatorioInternosUnidade.setText("Relatório de Internos na Unidade");
        RelatorioInternosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioInternosUnidadeActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioInternosUnidade);

        jMenu1.setText("Relatório de Localização de Internos");

        jMenuItem1.setText("Relatório Geral de Localização de Internos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Listagem de Confere");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenu3.add(jMenu1);
        jMenu3.add(jSeparator5);

        RelatorioListaPassagem.setText("Relatório de Lista de Passagem");
        RelatorioListaPassagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioListaPassagemActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioListaPassagem);
        jMenu3.add(jSeparator4);

        RelatorioPrevisaoSaida.setText("Relatório de Previsão de Saidas de Internos");
        RelatorioPrevisaoSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPrevisaoSaidaActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioPrevisaoSaida);
        jMenu3.add(jSeparator1);

        RelatorioValoresRegistradosGeral.setText("Relatório de Registros de Depósitos de Valores de Internos");
        RelatorioValoresRegistradosGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioValoresRegistradosGeralActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioValoresRegistradosGeral);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelFinanceiro)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelFinanceiro)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void LocalizacaoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalizacaoInternosActionPerformed
        // TODO add your handling code here:
        if (objConsultaLocalInt == null || objConsultaLocalInt.isClosed()) {
            objConsultaLocalInt = new TelaConsultaLocalInternoFinanceiro();
            jPainelFinanceiro.add(objConsultaLocalInt);
            objConsultaLocalInt.setVisible(true);
        } else {
            if (objConsultaLocalInt.isVisible()) {
                if (objConsultaLocalInt.isIcon()) { // Se esta minimizado
                    try {
                        objConsultaLocalInt.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsultaLocalInt.toFront(); // traz para frente
                    objConsultaLocalInt.pack();//volta frame 
                }
            } else {
                objConsultaLocalInt = new TelaConsultaLocalInternoFinanceiro();
                TelaModuloFinanceiro.jPainelFinanceiro.add(objConsultaLocalInt);//adicona frame ao JDesktopPane  
                objConsultaLocalInt.setVisible(true);
            }
        }
        try {
            objConsultaLocalInt.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_LocalizacaoInternosActionPerformed

    private void ConsultaSaldosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaSaldosActionPerformed
        // TODO add your handling code here:
        if (objConsultaSaldoFin == null || objConsultaSaldoFin.isClosed()) {
            objConsultaSaldoFin = new TelaConsultaSaldoFin();
            jPainelFinanceiro.add(objConsultaSaldoFin);
            objConsultaSaldoFin.setVisible(true);
        } else {
            if (objConsultaSaldoFin.isVisible()) {
                if (objConsultaSaldoFin.isIcon()) { // Se esta minimizado
                    try {
                        objConsultaSaldoFin.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsultaSaldoFin.toFront(); // traz para frente
                    objConsultaSaldoFin.pack();//volta frame 
                }
            } else {
                objConsultaSaldoFin = new TelaConsultaSaldoFin();
                TelaModuloFinanceiro.jPainelFinanceiro.add(objConsultaSaldoFin);//adicona frame ao JDesktopPane  
                objConsultaSaldoFin.setVisible(true);
            }
        }
        try {
            objConsultaSaldoFin.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaSaldosActionPerformed

    private void DepositoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepositoInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaDepositoAtivo);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaDepositoAtivo) && codAbrir == 1) {
            if (objDepBanc == null || objDepBanc.isClosed()) {
                objDepBanc = new TelaDepositoBancario();
                jPainelFinanceiro.add(objDepBanc);
                objDepBanc.setVisible(true);
            } else {
                if (objDepBanc.isVisible()) {
                    if (objDepBanc.isIcon()) { // Se esta minimizado
                        try {
                            objDepBanc.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objDepBanc.toFront(); // traz para frente
                        objDepBanc.pack();//volta frame 
                    }
                } else {
                    objDepBanc = new TelaDepositoBancario();
                    TelaModuloFinanceiro.jPainelFinanceiro.add(objDepBanc);//adicona frame ao JDesktopPane  
                    objDepBanc.setVisible(true);
                }
            }
            try {
                objDepBanc.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_DepositoInternoActionPerformed

    private void SaqueValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaqueValoresActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSaqueAtivo);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaSaqueAtivo) && codAbrir == 1) {
            if (objSaqBanc == null || objSaqBanc.isClosed()) {
                objSaqBanc = new TelaSaqueBancario();
                jPainelFinanceiro.add(objSaqBanc);
                objSaqBanc.setVisible(true);
            } else {
                if (objSaqBanc.isVisible()) {
                    if (objSaqBanc.isIcon()) { // Se esta minimizado
                        try {
                            objSaqBanc.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objSaqBanc.toFront(); // traz para frente
                        objSaqBanc.pack();//volta frame 
                    }
                } else {
                    objSaqBanc = new TelaSaqueBancario();
                    TelaModuloFinanceiro.jPainelFinanceiro.add(objSaqBanc);//adicona frame ao JDesktopPane  
                    objSaqBanc.setVisible(true);
                }
            }
            try {
                objSaqBanc.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_SaqueValoresActionPerformed

    private void ExtratoValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtratoValoresActionPerformed
        // TODO add your handling code here:
        TelaPesqDataRelExtrato objRelExtrato = new TelaPesqDataRelExtrato();
        TelaModuloFinanceiro.jPainelFinanceiro.add(objRelExtrato);
        objRelExtrato.show();
    }//GEN-LAST:event_ExtratoValoresActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:
        if (objRecadoFin == null || objRecadoFin.isClosed()) {
            objRecadoFin = new TelaRecadosFinanceiro();
            jPainelFinanceiro.add(objRecadoFin);
            objRecadoFin.setVisible(true);
        } else {
            if (objRecadoFin.isVisible()) {
                if (objRecadoFin.isIcon()) { // Se esta minimizado
                    try {
                        objRecadoFin.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecadoFin.toFront(); // traz para frente
                    objRecadoFin.pack();//volta frame 
                }
            } else {
                objRecadoFin = new TelaRecadosFinanceiro();
                TelaModuloFinanceiro.jPainelFinanceiro.add(objRecadoFin);//adicona frame ao JDesktopPane  
                objRecadoFin.setVisible(true);
            }
        }
        try {
            objRecadoFin.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaRecadosActionPerformed

    private void RelatorioInternosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioInternosUnidadeActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ListagemGeralInternosLocal.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE SituacaoCrc='" + situacaoEnt + "'OR SituacaoCrc='" + situacaoRet + "'");
            HashMap parametros = new HashMap();
            parametros.put("situacaoEntrada", situacaoEnt);
            parametros.put("situacaoRetorno", situacaoRet);
            parametros.put("usuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Internos na Unidade");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO: " + e);
        }
    }//GEN-LAST:event_RelatorioInternosUnidadeActionPerformed

    private void RelatorioPrevisaoSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPrevisaoSaidaActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPrevisaoSaidaDiversas objRelPrevSaidDi = new TelaRelatorioPrevisaoSaidaDiversas();
        TelaModuloFinanceiro.jPainelFinanceiro.add(objRelPrevSaidDi);
        objRelPrevSaidDi.show();
    }//GEN-LAST:event_RelatorioPrevisaoSaidaActionPerformed

    private void RelatorioListaPassagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioListaPassagemActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioListaPassagemInterna.jasper";
            conecta.executaSQL("SELECT * FROM ITENSAGENDALABORATIVA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSAGENDALABORATIVA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN EMPRESALAB "
                    + "ON ITENSAGENDALABORATIVA.IdEmp=EMPRESALAB.IdEmp "
                    + "WHERE TipoEmpresa='" + tipoEmpresa + "' "
                    + "AND StatusInterno='" + statusInterno + "'ORDER BY RazaoSocial,NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("tipoEmpresa", tipoEmpresa);
            parametros.put("statusEmpresa", statusInterno);
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Lista de Passagem de Internos na Unidade Penal");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioListaPassagemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ListagemGeralConfere.jasper";
            conecta.executaSQL("SELECT * FROM ITENSLOCACAOINTERNO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSLOCACAOINTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "ORDER BY DescricaoPav,PRONTUARIOSCRC.NomeInternoCrc,CELAS.EndCelaPav");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem Geral de Confere");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConfere objRelConfere = new TelaRelatorioConfere();
        TelaModuloFinanceiro.jPainelFinanceiro.add(objRelConfere);
        objRelConfere.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if (objConsuProntuario == null || objConsuProntuario.isClosed()) {
            objConsuProntuario = new TelaConsultaProntuarioInternoCrcBKP();
            jPainelFinanceiro.add(objConsuProntuario);
            objConsuProntuario.setVisible(true);
        } else {
            if (objConsuProntuario.isVisible()) {
                if (objConsuProntuario.isIcon()) { // Se esta minimizado
                    try {
                        objConsuProntuario.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsuProntuario.toFront(); // traz para frente
                    objConsuProntuario.pack();//volta frame 
                }
            } else {
                objConsuProntuario = new TelaConsultaProntuarioInternoCrcBKP();
                TelaModuloFinanceiro.jPainelFinanceiro.add(objConsuProntuario);//adicona frame ao JDesktopPane  
                objConsuProntuario.setVisible(true);
            }
        }
        try {
            objConsuProntuario.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void RelatorioValoresRegistradosGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioValoresRegistradosGeralActionPerformed
        // TODO add your handling code here:
        TelaRegistrosValoresGeral objRelGeralValores = new TelaRegistrosValoresGeral();
        TelaModuloFinanceiro.jPainelFinanceiro.add(objRelGeralValores);
        objRelGeralValores.show();
    }//GEN-LAST:event_RelatorioValoresRegistradosGeralActionPerformed

    private void AgendaCompromissoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissoActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelFinanceiro.add(objAgEventos);
            objAgEventos.setVisible(true);
        } else {
            if (objAgEventos.isVisible()) {
                if (objAgEventos.isIcon()) { // Se esta minimizado
                    try {
                        objAgEventos.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objAgEventos.toFront(); // traz para frente
                    objAgEventos.pack();//volta frame 
                }
            } else {
                objAgEventos = new TelaAgendaCompromissos();
                TelaModuloFinanceiro.jPainelFinanceiro.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissoActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        if (objConsRol == null || objConsRol.isClosed()) {
            objConsRol = new TelaRolVisitasPortaria();
            jPainelFinanceiro.add(objConsRol);
            objConsRol.setVisible(true);
        } else {
            if (objConsRol.isVisible()) {
                if (objConsRol.isIcon()) { // Se esta minimizado
                    try {
                        objConsRol.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsRol.toFront(); // traz para frente
                    objConsRol.pack();//volta frame 
                }
            } else {
                objConsRol = new TelaRolVisitasPortaria();
                TelaModuloFinanceiro.jPainelFinanceiro.add(objConsRol);//adicona frame ao JDesktopPane  
                objConsRol.setVisible(true);
            }
        }
        try {
            objConsRol.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void TransferenciaValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransferenciaValoresActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaTransferenciaValores);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaTransferenciaValores) && codAbrir == 1) {
            if (objTransValor == null || objTransValor.isClosed()) {
                objTransValor = new TelaTransferenciaValoresInternos();
                jPainelFinanceiro.add(objTransValor);
                objTransValor.setVisible(true);
            } else {
                if (objTransValor.isVisible()) {
                    if (objTransValor.isIcon()) { // Se esta minimizado
                        try {
                            objTransValor.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objTransValor.toFront(); // traz para frente
                        objTransValor.pack();//volta frame 
                    }
                } else {
                    objTransValor = new TelaTransferenciaValoresInternos();
                    TelaModuloFinanceiro.jPainelFinanceiro.add(objTransValor);//adicona frame ao JDesktopPane  
                    objTransValor.setVisible(true);
                }
            }
            try {
                objTransValor.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_TransferenciaValoresActionPerformed

    private void DepositoInativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepositoInativosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaDepositoInativo);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaDepositoInativo) && codAbrir == 1) {
            if (objDepBancInat == null || objDepBancInat.isClosed()) {
                objDepBancInat = new TelaDepositoBancarioInativos();
                jPainelFinanceiro.add(objDepBancInat);
                objDepBancInat.setVisible(true);
            } else {
                if (objDepBancInat.isVisible()) {
                    if (objDepBancInat.isIcon()) { // Se esta minimizado
                        try {
                            objDepBancInat.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objDepBancInat.toFront(); // traz para frente
                        objDepBancInat.pack();//volta frame 
                    }
                } else {
                    objDepBancInat = new TelaDepositoBancarioInativos();
                    TelaModuloFinanceiro.jPainelFinanceiro.add(objDepBancInat);//adicona frame ao JDesktopPane  
                    objDepBancInat.setVisible(true);
                }
            }
            try {
                objDepBancInat.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_DepositoInativosActionPerformed

    private void SaqueInativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaqueInativosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSaqueInativo);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaSaqueInativo) && codAbrir == 1) {
            if (objSaqBancIna == null || objSaqBancIna.isClosed()) {
                objSaqBancIna = new TelaSaqueBancarioInativos();
                jPainelFinanceiro.add(objSaqBancIna);
                objSaqBancIna.setVisible(true);
            } else {
                if (objSaqBancIna.isVisible()) {
                    if (objSaqBancIna.isIcon()) { // Se esta minimizado
                        try {
                            objSaqBancIna.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objSaqBancIna.toFront(); // traz para frente
                        objSaqBancIna.pack();//volta frame 
                    }
                } else {
                    objSaqBancIna = new TelaSaqueBancarioInativos();
                    TelaModuloFinanceiro.jPainelFinanceiro.add(objSaqBancIna);//adicona frame ao JDesktopPane  
                    objSaqBancIna.setVisible(true);
                }
            }
            try {
                objSaqBancIna.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_SaqueInativosActionPerformed

    private void jExtratoGeralInternosInativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExtratoGeralInternosInativosActionPerformed
        // TODO add your handling code here:
        TelaPesqDataRelExtratoInativos objRelExtratoIna = new TelaPesqDataRelExtratoInativos();
        TelaModuloFinanceiro.jPainelFinanceiro.add(objRelExtratoIna);
        objRelExtratoIna.show();
    }//GEN-LAST:event_jExtratoGeralInternosInativosActionPerformed

    private void LiberadoresFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LiberadoresFinanceiroActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaLiberadoresFinanceiro);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaLiberadoresFinanceiro) && codAbrir == 1) {
            if (objLibe == null || objLibe.isClosed()) {
                objLibe = new TelaLiberadoresFinanceiro();
                jPainelFinanceiro.add(objLibe);
                objLibe.setVisible(true);
            } else {
                if (objLibe.isVisible()) {
                    if (objLibe.isIcon()) { // Se esta minimizado
                        try {
                            objLibe.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objLibe.toFront(); // traz para frente
                        objLibe.pack();//volta frame 
                    }
                } else {
                    objLibe = new TelaLiberadoresFinanceiro();
                    TelaModuloFinanceiro.jPainelFinanceiro.add(objLibe);//adicona frame ao JDesktopPane  
                    objLibe.setVisible(true);
                }
            }
            try {
                objLibe.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_LiberadoresFinanceiroActionPerformed

    private void jEstornoDepositoSaqueAtivosInativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEstornoDepositoSaqueAtivosInativosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEstornoValores);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupo.equals("ADMINISTRADORES") || codigoUser == codUserAcesso && nomeTela.equals(telaEstornoValores) && codAbrir == 1) {
            if (objEstornoDep == null || objEstornoDep.isClosed()) {
                objEstornoDep = new TelaEstornoDepositoSaqueAtivosInativos();
                jPainelFinanceiro.add(objEstornoDep);
                objEstornoDep.setVisible(true);
            } else {
                if (objEstornoDep.isVisible()) {
                    if (objEstornoDep.isIcon()) { // Se esta minimizado
                        try {
                            objEstornoDep.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEstornoDep.toFront(); // traz para frente
                        objEstornoDep.pack();//volta frame 
                    }
                } else {
                    objEstornoDep = new TelaEstornoDepositoSaqueAtivosInativos();
                    TelaModuloFinanceiro.jPainelFinanceiro.add(objEstornoDep);//adicona frame ao JDesktopPane  
                    objEstornoDep.setVisible(true);
                }
            }
            try {
                objEstornoDep.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jEstornoDepositoSaqueAtivosInativosActionPerformed

    private void RelacaoSaldoInternosAtivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelacaoSaldoInternosAtivosActionPerformed
        // TODO add your handling code here:        
        try {
            conecta.abrirConexao();
            String path = "reports/RelacaoSaldoInternosAtivos.jasper";
            conecta.executaSQL("SELECT * FROM SALDOVALORES "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON SALDOVALORES.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + situacaoEnt + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + situacaoRet + "'"
                    + "ORDER BY NomeInternoCrc,DataMov DESC");
            HashMap parametros = new HashMap();
            parametros.put("descricaoUnidade", descricaoUnidade);
            parametros.put("usuario", nameUser);
            parametros.put("situacaoEnt", situacaoEnt);
            parametros.put("situacaoRet", situacaoRet);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Saldo de Internos - Ativos");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório.\n\nERRO: " + e);
        }
    }//GEN-LAST:event_RelacaoSaldoInternosAtivosActionPerformed

    private void RelacaoSaldoInternosInativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelacaoSaldoInternosInativosActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelacaoSaldoInternosInativos.jasper";
            conecta.executaSQL("SELECT * FROM SALDO_VALORES_INATIVOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON SALDO_VALORES_INATIVOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "ORDER BY NomeInternoCrc,DataMov DESC");
            HashMap parametros = new HashMap();
            parametros.put("descricaoUnidade", descricaoUnidade);
            parametros.put("usuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Saldo de Internos - Inativos");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório.\n\nERRO: " + e);
        }
    }//GEN-LAST:event_RelacaoSaldoInternosInativosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaCompromisso;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenu Cadastros;
    private javax.swing.JMenuItem ConsultaSaldos;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenu ContasInativas;
    private javax.swing.JMenuItem DepositoInativos;
    private javax.swing.JMenuItem DepositoInterno;
    private javax.swing.JMenuItem ExtratoValores;
    private javax.swing.JMenuItem LiberadoresFinanceiro;
    private javax.swing.JMenuItem LocalizacaoInternos;
    private javax.swing.JMenu Movimentacao;
    private javax.swing.JMenuItem RelacaoSaldoInternosAtivos;
    private javax.swing.JMenuItem RelacaoSaldoInternosInativos;
    private javax.swing.JMenuItem RelatorioInternosUnidade;
    private javax.swing.JMenuItem RelatorioListaPassagem;
    private javax.swing.JMenuItem RelatorioPrevisaoSaida;
    private javax.swing.JMenuItem RelatorioValoresRegistradosGeral;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JMenuItem SaqueInativos;
    private javax.swing.JMenuItem SaqueValores;
    private javax.swing.JMenuItem TransferenciaValores;
    private javax.swing.JMenuItem jEstornoDepositoSaqueAtivosInativos;
    private javax.swing.JMenuItem jExtratoGeralInternosInativos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    public static javax.swing.JDesktopPane jPainelFinanceiro;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    // End of variables declaration//GEN-END:variables

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
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
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcesso = conecta.rs.getInt("IdUsuario");
            codAbrir = conecta.rs.getInt("Abrir");
            codIncluir = conecta.rs.getInt("Incluir");
            codAlterar = conecta.rs.getInt("Alterar");
            codExcluir = conecta.rs.getInt("Excluir");
            codGravar = conecta.rs.getInt("Gravar");
            codConcultar = conecta.rs.getInt("Consultar");
            nomeTela = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    // Verificar a cada 5 minutos se o recado foi lido (10/01/2015)
    public void threadMensagem() {
        final Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                verificarRecado();
                verificarAgendaCompromisso();
            }
        }, periodo, tempo);
    }

    public void verificarRecado() {
        buscarUsuario(nameUser);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDARECADOS WHERE IdUsuario='" + codUsuario + "'AND StatusAgenda='" + statusAgenda + "'");
            conecta.rs.first();
            if (codUsuario == conecta.rs.getInt("IdUsuario")) {
                TelaRecadosCrc objRecados = new TelaRecadosCrc();
                TelaModuloFinanceiro.jPainelFinanceiro.add(objRecados);
                objRecados.show();
                flag = 1;
                preencherTabelaTodosRecados("SELECT * FROM AGENDARECADOS "
                        + "INNER JOIN USUARIOS "
                        + "ON AGENDARECADOS.IdUsuario=USUARIOS.IdUsuario "
                        + "WHERE NomeUsuario='" + nameUser + "'AND StatusAgenda='" + statusAgenda + "'");
                if (flag == 1) {
                    jBtNovo.setEnabled(true);
                    jBtAlterar.setEnabled(true);
                    jBtExcluir.setEnabled(true);
                    jBtSalvar.setEnabled(!true);
                    jBtCancelar.setEnabled(true);
                    jBtResponder.setEnabled(true);
                    jBtConfirmar.setEnabled(true);
                    conecta.abrirConexao();
                    try {
                        conecta.executaSQL("SELECT * FROM AGENDARECADOS "
                                + "INNER JOIN USUARIOS "
                                + "ON AGENDARECADOS.IdUsuario=USUARIOS.IdUsuario "
                                + "WHERE NomeUsuario='" + nameUser + "'AND StatusAgenda='" + statusAgenda + "'");
                        conecta.rs.last();
                        jIDLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                        jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                        jHoraRecado.setText(conecta.rs.getString("Horario"));
                        jComboBoxStatus.setSelectedItem(conecta.rs.getString("StatusAgenda"));
                        jNomeRementente.setText(conecta.rs.getString("NomeUsuarioLogado"));
                        jNomeDestinatario.setText(conecta.rs.getString("NomeUsuario"));
                        jRecado.setText(conecta.rs.getString("Recados"));
                        conecta.desconecta();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados...\nERRO: " + e);
                    }
                    conecta.desconecta();
                }
            }
        } catch (SQLException ex) {
            //  JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar mensagem.\nERRO:" + ex);
        }
    }

    public void buscarUsuario(String nomeUser) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS WHERE NomeUsuario='" + nomeUser + "'");
            conecta.rs.first();
            codUsuario = conecta.rs.getInt("IdUsuario");
            nomeUsuarioCompromisso = conecta.rs.getString("NomeUsuario");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível encontrar o usuário.\nERRO: " + ex);
        }
    }

    public void preencherTabelaTodosRecados(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{" ID", " Data", " Remetente", " Destinatário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.last();
            do {
                // Formatar a data Entrada
                dataLanc = conecta.rs.getString("DataLanc");
                String dia = dataLanc.substring(8, 10);
                String mes = dataLanc.substring(5, 7);
                String ano = dataLanc.substring(0, 4);
                dataLanc = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataLanc, conecta.rs.getString("NomeUsuarioLogado"), conecta.rs.getString("NomeUsuario")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe dados a ser exibido!!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaTodosRecados.setModel(modelo);
        jTabelaTodosRecados.getColumnModel().getColumn(0).setPreferredWidth(52);
        jTabelaTodosRecados.getColumnModel().getColumn(0).setResizable(false);
        jTabelaTodosRecados.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaTodosRecados.getColumnModel().getColumn(1).setResizable(false);
        jTabelaTodosRecados.getColumnModel().getColumn(2).setPreferredWidth(280);
        jTabelaTodosRecados.getColumnModel().getColumn(2).setResizable(false);
        jTabelaTodosRecados.getColumnModel().getColumn(3).setPreferredWidth(280);
        jTabelaTodosRecados.getColumnModel().getColumn(3).setResizable(false);
        jTabelaTodosRecados.getTableHeader().setReorderingAllowed(false);
        jTabelaTodosRecados.setAutoResizeMode(jTabelaTodosRecados.AUTO_RESIZE_OFF);
        jTabelaTodosRecados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }

    public void verificarAgendaCompromisso() {
        buscarUsuario(nameUser);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDA_COMPROMISSOS WHERE UsuarioAgenda='" + nameUser + "' "
                    + "AND StatusAgenda='" + statusAgenda + "' "
                    + "AND DataLembrete='" + jDataSistema.getText() + "' "
                    + "AND HoraLembrete<='" + jHoraSistema.getText().toString() + "'");
            conecta.rs.first();
            horaLembrete = conecta.rs.getString("HoraLembrete");
            usuarioAgenda = conecta.rs.getString("UsuarioAgenda");
            codigoAgendaComp = conecta.rs.getString("IdAgenda");
            //
            if (nomeUsuarioCompromisso.equals(usuarioAgenda)) {
                TelaAgendaCompromissos objAgendaComp = new TelaAgendaCompromissos();
                TelaModuloFinanceiro.jPainelFinanceiro.add(objAgendaComp);
                objAgendaComp.show();
                flag = 1;
                preencherTabelaAgendaCompromisso("SELECT * FROM AGENDA_COMPROMISSOS "
                        + "WHERE AGENDA_COMPROMISSOS.UsuarioAgenda='" + nameUser + "' "
                        + "AND AGENDA_COMPROMISSOS.StatusAgenda='" + statusAgenda + "' "
                        + "AND DataLembrete='" + jDataSistema.getText() + "' "
                        + "AND HoraLembrete<='" + jHoraSistema.getText().toString() + "' "
                        + "AND IdAgenda='" + codigoAgendaComp + "'");
                if (flag == 1) {
                    jBtNovoComp.setEnabled(true);
                    jBtAlterarComp.setEnabled(true);
                    jBtExcluirComp.setEnabled(true);
                    jBtSalvarComp.setEnabled(!true);
                    jBtCancelarComp.setEnabled(true);
                    jBtConfirmarCompromisso.setEnabled(true);
                    conecta.abrirConexao();
                    try {
                        conecta.executaSQL("SELECT * FROM AGENDA_COMPROMISSOS "
                                + "WHERE AGENDA_COMPROMISSOS.UsuarioAgenda='" + nomeUsuarioCompromisso + "'AND AGENDA_COMPROMISSOS.StatusAgenda='" + statusAgenda + "'AND HoraLembrete<='" + jHoraSistema.getText().toString() + "'AND IdAgenda='" + codigoAgendaComp + "'");
                        conecta.rs.first();
                        jCodigoAgendaComp.setText(String.valueOf(conecta.rs.getInt("IdAgenda")));
                        jComboBoxStatusComp.setSelectedItem(conecta.rs.getString("StatusAgenda"));
                        jComboBoxTipoEvento.setSelectedItem(conecta.rs.getString("TipoEvento"));
                        jDataEvento.setDate(conecta.rs.getDate("DataAgenda"));
                        jAssunto.setText(conecta.rs.getString("Assunto"));
                        jComboBoxPrioridade.setSelectedItem(conecta.rs.getString("Prioridade"));
                        jComboBoxConclusao.setSelectedItem(conecta.rs.getString("Conclusao"));
                        jDataInicio.setDate(conecta.rs.getDate("DataInicio"));
                        jDataTermino.setDate(conecta.rs.getDate("DataTermino"));
                        jHoraInicio.setText(conecta.rs.getString("HoraInicio"));
                        jHoraTermino.setText(conecta.rs.getString("HoraTermino"));
                        jDataLembrete.setDate(conecta.rs.getDate("DataLembrete"));
                        jHoraLembrete.setText(conecta.rs.getString("HoraLembrete"));
                        jTextoEvento.setText(conecta.rs.getString("Texto"));
                        jNomeUsuarioAgenda.setText(conecta.rs.getString("UsuarioAgenda"));
                        conecta.desconecta();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados...\nERRO: " + e);
                    }
                    conecta.desconecta();
                }
            }
        } catch (SQLException ex) {
        }
    }

    public void preencherTabelaAgendaCompromisso(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código ", "Data", "Status", "Assunto", "Usuário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataAgenda = conecta.rs.getString("DataAgenda");
                String dia = dataAgenda.substring(8, 10);
                String mes = dataAgenda.substring(5, 7);
                String ano = dataAgenda.substring(0, 4);
                dataAgenda = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count));
                dados.add(new Object[]{conecta.rs.getInt("IdAgenda"), dataAgenda, conecta.rs.getString("StatusAgenda"), conecta.rs.getString("Assunto"), conecta.rs.getString("UsuarioAgenda")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS!!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAgendaEventos.setModel(modelo);
        jTabelaAgendaEventos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAgendaEventos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAgendaEventos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAgendaEventos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAgendaEventos.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaAgendaEventos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAgendaEventos.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaAgendaEventos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAgendaEventos.getColumnModel().getColumn(4).setPreferredWidth(300);
        jTabelaAgendaEventos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAgendaEventos.setAutoResizeMode(jTabelaAgendaEventos.AUTO_RESIZE_OFF);
        jTabelaAgendaEventos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaAgendaEventos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAgendaEventos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaAgendaEventos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    // PESQUISA E CADASTRO DAS TELAS DO MÓDULO ENFERMARIA PARA CONTROLE DE ACESSO DE USUÁRIOS.
    public void pesquisarTelasAcessos() {
        conecta.abrirConexao();
         try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaLiberadoresFinanceiro + "'");
            conecta.rs.first();
            pNomeLF = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaDepositoAtivo + "'");
            conecta.rs.first();
            pNomeDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSaqueAtivo + "'");
            conecta.rs.first();
            pNomeSA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaTransferenciaValores + "'");
            conecta.rs.first();
            pNomeTV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaDepositoInativo + "'");
            conecta.rs.first();
            pNomeDI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSaqueInativo + "'");
            conecta.rs.first();
            pNomeSI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEstornoValores + "'");
            conecta.rs.first();
            pNomeEV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // INICIO DA COMPARAÇÃO
        if (!pNomeLF.equals(telaLiberadoresFinanceiro) || pNomeLF == null || pNomeLF.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaLiberadoresFinanceiro);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeDA.equals(telaDepositoAtivo) || pNomeDA == null || pNomeDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaDepositoAtivo);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSA.equals(telaSaqueAtivo) || pNomeSA == null || pNomeSA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSaqueAtivo);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeTV.equals(telaTransferenciaValores) || pNomeTV == null || pNomeTV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaTransferenciaValores);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeDI.equals(telaDepositoInativo) || pNomeDI == null || pNomeDI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaDepositoInativo);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeSI.equals(telaSaqueInativo) || pNomeSI == null || pNomeSI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSaqueInativo);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEV.equals(telaEstornoValores) || pNomeEV == null || pNomeEV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEstornoValores);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        JOptionPane.showMessageDialog(rootPane, "Telas cadastrada com sucesso, solicite ao administrador do sistema para configurar o seu pérfil.");
    }

    // MÉTODO PARA BUSCAR O CÓDIGO DO MÓDULO, CASO NÃO TENHA SIDO CADASTRADO.
    public void buscarCodigoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + nomeModuloBV + "'");
            conecta.rs.first();
            pCodModulo = conecta.rs.getInt("IdModulo");
        } catch (SQLException ex) {
        }
    }
}
