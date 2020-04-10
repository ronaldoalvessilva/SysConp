/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleTelasSistema;
import gestor.Controle.converterDataStringDataDate;
import static gestor.Controle.converterDataStringDataDate.dataSisConvert;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
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
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaRecadosPortariaExterna.jBtAlterar;
import static gestor.Visao.TelaRecadosPortariaExterna.jBtCancelar;
import static gestor.Visao.TelaRecadosPortariaExterna.jBtConfirmar;
import static gestor.Visao.TelaRecadosPortariaExterna.jBtExcluir;
import static gestor.Visao.TelaRecadosPortariaExterna.jBtNovo;
import static gestor.Visao.TelaRecadosPortariaExterna.jBtResponder;
import static gestor.Visao.TelaRecadosPortariaExterna.jBtSalvar;
import static gestor.Visao.TelaRecadosPortariaExterna.jComboBoxStatus;
import static gestor.Visao.TelaRecadosPortariaExterna.jDataLanc;
import static gestor.Visao.TelaRecadosPortariaExterna.jHoraRecado;
import static gestor.Visao.TelaRecadosPortariaExterna.jIDLanc;
import static gestor.Visao.TelaRecadosPortariaExterna.jNomeDestinatario;
import static gestor.Visao.TelaRecadosPortariaExterna.jNomeRementente;
import static gestor.Visao.TelaRecadosPortariaExterna.jRecado;
import static gestor.Visao.TelaRecadosPortariaExterna.jTabelaTodosRecados;
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
public class TelaModuloPortariaExterna extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();
    //
    private TelaEntradaSaidaAdvogadosExterna objEntSaiAd = null; // Para abrir uma tela uma unica vez
    private TelaEntradaSaidaVisitasDiversasExterna objEntSaiVisiDiv = null;
    private TelaEntradaSaidaColaboradorExterna objEntSaiCola = null;
    private TelaRecadosPortariaExterna objRecadosPort = null;
    private TelaEntradaSaidaVeiculosUnidadeExterna objEntSaiVeiUni = null;
    private TelaVeiculosExterna objVeic = null;
    private TelaEntradaSaidaVeiculosCargasExterna objEntSaiVeiCarga = null;
    private TelaEntradaSaidaVeiculosTerceirosExterna objEntSaiVeiTer = null;
    private TelaAdvogadosExterna objAd = null;
    private TelaVisitasDiversasExterna objVisDi = null;
    private TelaFuncionariosPortarias objFunPort = null;
    private TelaConsultaVisitaSocial objViSoPort = null;
    private TelaRolVisitasPortaria objRolViPor = null;
    private TelaOcorrenciaPortariaExterna objTexto = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaOficialJusticaExterna objOficialExt = null;
    private TelaEntradaSaidaOficialJusticaExterna objEntraSaiOficialExt = null;
    private TelaInstituicaoReligiosaPortarias objInstRel = null;
    private TelaConsultaVisitaSocialReligiosa objConVisRel = null;
    private TelaConsultaRolVisitasReligiosas objConRolRel = null;
    private TelaRegistroChegadaVisitasInternosPortariaExterna objRegChega = null;
    //
    String dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente";
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado.  
    String statusRol = "ABERTO";
    String situacaoEnt = "ENTRADA NA UNIDADE"; // Todas as Entradas
    String situacaoRet = "RETORNO A UNIDADE"; // Todos os Retornos
    String situacaoTran = "TRANSFERENCIA"; // Todas as Transferencias   
    String situacaoSai = "SAIDA TEMPORARIA";
    int count = 0;
    // VARIÁVEIS PARA AGENDA DE COMPROMISSO.
    String dataAgenda;
    String nomeUsuarioCompromisso; // USUÁRIO DA AGENDA DE COMPROMISSO.
    String horaLembrete;
    String usuarioAgenda;
    String codigoAgendaComp;
    String statusFunc = "Ativo"; // STATUS DO COLABORADOR PARA O RELATÓRIO
    //
    public static int codigoUserP1E = 0;
    public static int codUserAcessoP1E = 0;
    public static int codigoUserGroupP1E = 0;
    public static int codAbrirP1E = 0;
    public static int codIncluirP1E = 0;
    public static int codAlterarP1E = 0;
    public static int codExcluirP1E = 0;
    public static int codGravarP1E = 0;
    public static int codConsultarP1E = 0;
    public static int codigoGrupoP1E = 0;
    public static String nomeGrupoP1E = "";
    public static String nomeTelaP1E = "";
    // TELAS DE ACESSOS AO MÓDULO CRC
    public static String nomeModuloP1E = "PORTARIA EXTERNA";
    // MENU CADASTRO    
    public static String telaCadastroVeiculosManuP1E = "Cadastro:Veiculos - P1E:Manutenção";
    public static String telaCadastroAdvogadosManuP1E = "Cadastro:Advogados - P1E:Manutenção";
    public static String telaCadastroVisitasDiversasManuP1E = "Cadastro:Advogados - P1E:Manutenção";
    public static String telaCadastroOficialManuP1E = "Cadastro:Oficial Justiça - P1E:Manutenção";
    // MOVIMENTAÇÃO
    public static String telaEntradaSaidaAdDEPManuP1E = "Movimentação:Entrada e Saida de Advogados Departamento - P1E:Manutenção";
    public static String telaEntradaSaidaAdDEPADVP1E = "Movimentação:Entrada e Saida de Advogados Departamento - P1E:Advogados";
    //
    public static String telaEntradaSaidaOJManuP1E = "Movimentação:Entrada e Saida de Oficial de Justiça Departamento - P1E:Manutenção";
    public static String telaEntradaSaidaOJDepP1E = "Movimentação:Entrada e Saida de Oficial de Justiça Departamento - P1E:Oficial de Justiça";
    //
    public static String telaEntradaSaidaVDManuP1E = "Movimentação:Entrada e Saida de Visitas Diversas - P1E:Manutenção";
    public static String telaEntradaSaidaVDVDP1E = "Movimentação:Entrada e Saida de Visitas Diversas - P1E:Visitas Diversas";
    //
    public static String telaEntradaSaidaCOLManuP1E = "Movimentação:Entrada e Saida de Colaborador - P1E:Manutenção";
    public static String telaEntradaSaidaCOLcolP1E = "Movimentação:Entrada e Saida de Colaborador - P1E:Colaborador";
    public static String telaEntradaSaidaCOLBioP1E = "Movimentação:Entrada e Saida de Colaborador - P1E:Biometria";
    //
    public static String telaEntradaSaidaVUManuP1E = "Movimentação:Entrada e Saida Veiculos Unidade - P1E:Manutenção";
    public static String telaEntradaSaidaVUVP1E = "Movimentação:Entrada e Saida Veiculos Unidade - P1E:Veiculos";
    //
    public static String telaEntradaSaidaESVCManuP1E = "Movimentação:Entrada e Saida Veiculos Cargas - P1E:Manutenção";
    public static String telaEntradaSaidaESVCVP1E = "Movimentação:Entrada e Saida Veiculos Cargas - P1E:Veiculos";
    //
    public static String telaEntradaSaidaESVTManuP1E = "Movimentação:Entrada e Saida de Veiculos de Terceiro - P1E:Manutenção";
    public static String telaEntradaSaidaESVTVP1E = "Movimentação:Entrada e Saida de Veiculos de Terceiro - P1E:Veiculos e Visitantes";
    //
    public static String telaOcorrenciaManuP1E = "Movimentação:Ocorrências Diárias - P1E:Manutenção";
    //
    public static String telaRegistroChegadaPortExtManuP1E = "Movimentação:Registro Chegada Visita Portaria Externa - P1E:Manutenção";
    public static String telaRegistroChegadaPortExtPesqP1E = "Movimentação:Registro Chegada Visita Portaria Externa - P1E:Pesquisar Visita";
    public static String telaRegistroChegadaPortExtBioP1E = "Movimentação:Registro Chegada Visita Portaria Externa - P1E:Biometria";
    public static String telaRegistroChegadaPortExtRelP1E = "Movimentação:Registro Chegada Visita Portaria Externa - P1E:Relatório";
    //
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO
    // VARIÁVEIS PARA CONTROLE DE CADASTRO DAS TELAS NA TABELA TELAS.
    // MENU CADASTRO
    String pNomeCVPM = "";
    String pNomeCAM = "";
    String pNomeCVDM = "";
    String pNomeCOM = "";
    //
    String pNomeESADM = "";
    String pNomeESADMA = "";
    //
    String pNomeESOJMP1 = "";
    String pNomeESOJDP1 = "";
    //
    String pNomeESVDM = "";
    String pNomeESVDV = "";
    //
    String pNomeESCM = "";
    String pNomeESCC = "";
    String pNomeESCB = "";
    //telaEntradaSaidaCOLBioP1
    //
    String pNomeESVUM = "";
    String pNomeESVUV = "";
    //
    String pNomeESVCP1 = "";
    String pNomeESVCVP1 = "";
    //
    String pNomeESVT = "";
    String pNomeESVTV = "";
    //
    String pNomeOCR = "";
    //
    String pNomeRCVP = "";
    //
    String pNomeRCPEP = "";
    String pNomeRCPEB = "";
    String pNomeRCPER = "";
   

    /**
     * Creates new form TelaPortarias
     */
    public TelaModuloPortariaExterna() {
        initComponents();
        this.setSize(840, 640); // Tamanho da tela  
        pesquisarTelasAcessos();
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jPainelPortariaExterna = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        Cadastros = new javax.swing.JMenu();
        CadastroVeiculos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        VisitantesDiversos = new javax.swing.JMenuItem();
        jCadastroAdvogados = new javax.swing.JMenuItem();
        jOficialJustica = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromissos = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        Sair = new javax.swing.JMenuItem();
        Consultas = new javax.swing.JMenu();
        ConsultaFamiliaresInternos = new javax.swing.JMenuItem();
        ConsultaRolVisitas = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        InstituicaoReligiosa = new javax.swing.JMenuItem();
        VisitantesReligiosos = new javax.swing.JMenuItem();
        RolVistasReligiosas = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JPopupMenu.Separator();
        ConsultaColaboradores = new javax.swing.JMenuItem();
        Movimentacao = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        EnSaiVisitasDiversas = new javax.swing.JMenuItem();
        jColaboradores = new javax.swing.JMenuItem();
        jAdvogados = new javax.swing.JMenuItem();
        OficialJusticaDepartamento = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        VeiculosUnidade = new javax.swing.JMenuItem();
        VeiculosTerceiros = new javax.swing.JMenuItem();
        VeiculosCargasDescargas = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        LivroOcorrencias = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        RegistroChegadaVisitasInterno = new javax.swing.JMenuItem();
        Relatorios = new javax.swing.JMenu();
        RelatorioRolVisitas = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaVistasInternos = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        jMenu9 = new javax.swing.JMenu();
        RelatorioVeiculosUnidade = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaVeiculosCargas = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaVeiculosTerceiros = new javax.swing.JMenuItem();
        RelatorioCadastroVeiculos = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        RelatorioVisitasDiversas = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaVisitas = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        RelatorioEntradaSaidaFuncDepto = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaColaboradores = new javax.swing.JMenuItem();
        RelatorioCadastroColaboradores = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        jMenu11 = new javax.swing.JMenu();
        RelatorioEntradaSaidaAdvogadosInternos = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaAdvogadosDepartamento = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenuItem13.setText("jMenuItem13");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("...::: Controle de Portaria Externa :::...");

        jPainelPortariaExterna.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BrasaoFundo500Prata2.png"))); // NOI18N

        jPainelPortariaExterna.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelPortariaExternaLayout = new javax.swing.GroupLayout(jPainelPortariaExterna);
        jPainelPortariaExterna.setLayout(jPainelPortariaExternaLayout);
        jPainelPortariaExternaLayout.setHorizontalGroup(
            jPainelPortariaExternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPainelPortariaExternaLayout.setVerticalGroup(
            jPainelPortariaExternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );

        Cadastros.setText("Cadastro");

        CadastroVeiculos.setText("Veiculos");
        CadastroVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroVeiculosActionPerformed(evt);
            }
        });
        Cadastros.add(CadastroVeiculos);
        Cadastros.add(jSeparator1);

        VisitantesDiversos.setText("Visitantes Diversos");
        VisitantesDiversos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisitantesDiversosActionPerformed(evt);
            }
        });
        Cadastros.add(VisitantesDiversos);

        jCadastroAdvogados.setText("Advogados");
        jCadastroAdvogados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCadastroAdvogadosActionPerformed(evt);
            }
        });
        Cadastros.add(jCadastroAdvogados);

        jOficialJustica.setText("Oficial de Justiça");
        jOficialJustica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOficialJusticaActionPerformed(evt);
            }
        });
        Cadastros.add(jOficialJustica);
        Cadastros.add(jSeparator4);

        AgendaCompromissos.setText("Agenda de Compromissos Pessoal");
        AgendaCompromissos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaCompromissosActionPerformed(evt);
            }
        });
        Cadastros.add(AgendaCompromissos);

        AgendaRecados.setText("Agenda de Recados");
        AgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaRecadosActionPerformed(evt);
            }
        });
        Cadastros.add(AgendaRecados);
        Cadastros.add(jSeparator2);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        Cadastros.add(Sair);

        jMenuBar2.add(Cadastros);

        Consultas.setText("Consultas");

        ConsultaFamiliaresInternos.setText("Visitantes de Internos");
        ConsultaFamiliaresInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaFamiliaresInternosActionPerformed(evt);
            }
        });
        Consultas.add(ConsultaFamiliaresInternos);

        ConsultaRolVisitas.setText("Rol de Visitas");
        ConsultaRolVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaRolVisitasActionPerformed(evt);
            }
        });
        Consultas.add(ConsultaRolVisitas);
        Consultas.add(jSeparator5);

        InstituicaoReligiosa.setText("Instituição Religiosa");
        InstituicaoReligiosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstituicaoReligiosaActionPerformed(evt);
            }
        });
        Consultas.add(InstituicaoReligiosa);

        VisitantesReligiosos.setText("Visitantes Religiosos");
        VisitantesReligiosos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisitantesReligiososActionPerformed(evt);
            }
        });
        Consultas.add(VisitantesReligiosos);

        RolVistasReligiosas.setText("Rol de Visitas Religiosas");
        RolVistasReligiosas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RolVistasReligiosasActionPerformed(evt);
            }
        });
        Consultas.add(RolVistasReligiosas);
        Consultas.add(jSeparator20);

        ConsultaColaboradores.setText("Colaboradores");
        ConsultaColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaColaboradoresActionPerformed(evt);
            }
        });
        Consultas.add(ConsultaColaboradores);

        jMenuBar2.add(Consultas);

        Movimentacao.setText("Movimentação");

        jMenu5.setText("Controle de Acessos de Pessoas");

        EnSaiVisitasDiversas.setText("Visitas Diversas");
        EnSaiVisitasDiversas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnSaiVisitasDiversasActionPerformed(evt);
            }
        });
        jMenu5.add(EnSaiVisitasDiversas);

        jColaboradores.setText("Colaboradores");
        jColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jColaboradoresActionPerformed(evt);
            }
        });
        jMenu5.add(jColaboradores);

        jAdvogados.setText("Advogados nos Departamentos da Unidade");
        jAdvogados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdvogadosActionPerformed(evt);
            }
        });
        jMenu5.add(jAdvogados);

        OficialJusticaDepartamento.setText("Oficiais de Justiça nos Departamentos da Unidade");
        OficialJusticaDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OficialJusticaDepartamentoActionPerformed(evt);
            }
        });
        jMenu5.add(OficialJusticaDepartamento);

        Movimentacao.add(jMenu5);
        Movimentacao.add(jSeparator9);

        jMenu4.setText("Controle de Acessos de Veiculos");

        VeiculosUnidade.setText("Veiculos da Unidade");
        VeiculosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VeiculosUnidadeActionPerformed(evt);
            }
        });
        jMenu4.add(VeiculosUnidade);

        VeiculosTerceiros.setText("Veiculos de Terceiros");
        VeiculosTerceiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VeiculosTerceirosActionPerformed(evt);
            }
        });
        jMenu4.add(VeiculosTerceiros);

        VeiculosCargasDescargas.setText("Veiculos de Cargas/Descargas  com Ajudante");
        VeiculosCargasDescargas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VeiculosCargasDescargasActionPerformed(evt);
            }
        });
        jMenu4.add(VeiculosCargasDescargas);

        Movimentacao.add(jMenu4);
        Movimentacao.add(jSeparator3);

        LivroOcorrencias.setText("Livro de Ocorrências");
        LivroOcorrencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LivroOcorrenciasActionPerformed(evt);
            }
        });
        Movimentacao.add(LivroOcorrencias);
        Movimentacao.add(jSeparator6);

        RegistroChegadaVisitasInterno.setForeground(new java.awt.Color(204, 0, 0));
        RegistroChegadaVisitasInterno.setText("Registro Chegada de Visitas de Internos");
        RegistroChegadaVisitasInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroChegadaVisitasInternoActionPerformed(evt);
            }
        });
        Movimentacao.add(RegistroChegadaVisitasInterno);

        jMenuBar2.add(Movimentacao);

        Relatorios.setText("Relatórios");

        RelatorioRolVisitas.setText("Rol de Visitas");
        RelatorioRolVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioRolVisitasActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioRolVisitas);

        RelatorioEntradaSaidaVistasInternos.setText("Relatório de Visitas de Internos");
        RelatorioEntradaSaidaVistasInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaVistasInternosActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioEntradaSaidaVistasInternos);
        Relatorios.add(jSeparator18);

        jMenu9.setText("Relatório de Entrada/Saída de  Veículos na Unidade Penal");

        RelatorioVeiculosUnidade.setText("Veículos da Unidade");
        RelatorioVeiculosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioVeiculosUnidadeActionPerformed(evt);
            }
        });
        jMenu9.add(RelatorioVeiculosUnidade);

        RelatorioEntradaSaidaVeiculosCargas.setText("Veículos de Cargas");
        RelatorioEntradaSaidaVeiculosCargas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaVeiculosCargasActionPerformed(evt);
            }
        });
        jMenu9.add(RelatorioEntradaSaidaVeiculosCargas);

        RelatorioEntradaSaidaVeiculosTerceiros.setText("Veículos de Terceiros");
        RelatorioEntradaSaidaVeiculosTerceiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaVeiculosTerceirosActionPerformed(evt);
            }
        });
        jMenu9.add(RelatorioEntradaSaidaVeiculosTerceiros);

        Relatorios.add(jMenu9);

        RelatorioCadastroVeiculos.setText("Listagem de Cadastro de Veículos");
        RelatorioCadastroVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioCadastroVeiculosActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioCadastroVeiculos);
        Relatorios.add(jSeparator13);

        RelatorioVisitasDiversas.setText("Relatório de Visitas Diversas por Departamento/Motivo Visita");
        RelatorioVisitasDiversas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioVisitasDiversasActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioVisitasDiversas);

        RelatorioEntradaSaidaVisitas.setText("Relatório de Registro de Entrada/Saída Geral de Visitas por Departamento");
        RelatorioEntradaSaidaVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaVisitasActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioEntradaSaidaVisitas);
        Relatorios.add(jSeparator15);

        jMenu3.setText("Relatórios de frequência de Colaboradores na Unidade Penal");

        RelatorioEntradaSaidaFuncDepto.setText("Relatório Entrada/Saída Colaborador Por Departamento");
        RelatorioEntradaSaidaFuncDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaFuncDeptoActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioEntradaSaidaFuncDepto);

        RelatorioEntradaSaidaColaboradores.setText("Relatório de Entrada/Saída de Colaboradores");
        RelatorioEntradaSaidaColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaColaboradoresActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioEntradaSaidaColaboradores);

        Relatorios.add(jMenu3);

        RelatorioCadastroColaboradores.setText("Listagem de Colaboradores");
        RelatorioCadastroColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioCadastroColaboradoresActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioCadastroColaboradores);
        Relatorios.add(jSeparator16);

        jMenu11.setText("Relatório de Entrada/Saída de Advogados");

        RelatorioEntradaSaidaAdvogadosInternos.setText("Visitas a Internos");
        RelatorioEntradaSaidaAdvogadosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaAdvogadosInternosActionPerformed(evt);
            }
        });
        jMenu11.add(RelatorioEntradaSaidaAdvogadosInternos);

        RelatorioEntradaSaidaAdvogadosDepartamento.setText("A Departamentos");
        RelatorioEntradaSaidaAdvogadosDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaAdvogadosDepartamentoActionPerformed(evt);
            }
        });
        jMenu11.add(RelatorioEntradaSaidaAdvogadosDepartamento);

        Relatorios.add(jMenu11);

        jMenuBar2.add(Relatorios);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelPortariaExterna)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelPortariaExterna)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void CadastroVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroVeiculosActionPerformed
        // TODO add your handling code here:    
        buscarAcessoUsuario(telaCadastroVeiculosManuP1E);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaCadastroVeiculosManuP1E) && codAbrirP1E == 1) {
            if (objVeic == null || objVeic.isClosed()) {
                objVeic = new TelaVeiculosExterna();
                jPainelPortariaExterna.add(objVeic);
                objVeic.setVisible(true);
            } else {
                if (objVeic.isVisible()) {
                    if (objVeic.isIcon()) { // Se esta minimizado
                        try {
                            objVeic.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objVeic.toFront(); // traz para frente
                        objVeic.pack();//volta frame 
                    }
                } else {
                    objVeic = new TelaVeiculosExterna();
                    TelaModuloPortariaExterna.jPainelPortariaExterna.add(objVeic);//adicona frame ao JDesktopPane  
                    objVeic.setVisible(true);
                }
            }
            try {
                objVeic.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_CadastroVeiculosActionPerformed

    private void VisitantesDiversosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisitantesDiversosActionPerformed
        // TODO add your handling code here:  
        buscarAcessoUsuario(telaCadastroVisitasDiversasManuP1E);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaCadastroVisitasDiversasManuP1E) && codAbrirP1E == 1) {
            if (objVisDi == null || objVisDi.isClosed()) {
                objVisDi = new TelaVisitasDiversasExterna();
                jPainelPortariaExterna.add(objVisDi);
                objVisDi.setVisible(true);
            } else {
                if (objVisDi.isVisible()) {
                    if (objVisDi.isIcon()) { // Se esta minimizado
                        try {
                            objVisDi.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objVisDi.toFront(); // traz para frente
                        objVisDi.pack();//volta frame 
                    }
                } else {
                    objVisDi = new TelaVisitasDiversasExterna();
                    TelaModuloPortariaExterna.jPainelPortariaExterna.add(objVisDi);//adicona frame ao JDesktopPane  
                    objVisDi.setVisible(true);
                }
            }
            try {
                objVisDi.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_VisitantesDiversosActionPerformed

    private void ConsultaColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaColaboradoresActionPerformed
        // TODO add your handling code here:
        // Abrir uma única tela, funcionando
        if (objFunPort == null || objFunPort.isClosed()) {
            objFunPort = new TelaFuncionariosPortarias();
            jPainelPortariaExterna.add(objFunPort);
            objFunPort.setVisible(true);
        } else {
            if (objFunPort.isVisible()) {
                if (objFunPort.isIcon()) { // Se esta minimizado
                    try {
                        objFunPort.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objFunPort.toFront(); // traz para frente
                    objFunPort.pack();//volta frame 
                }
            } else {
                objFunPort = new TelaFuncionariosPortarias();
                TelaModuloPortariaExterna.jPainelPortariaExterna.add(objFunPort);//adicona frame ao JDesktopPane  
                objFunPort.setVisible(true);
            }
        }
        try {
            objFunPort.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaColaboradoresActionPerformed

    private void ConsultaFamiliaresInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaFamiliaresInternosActionPerformed
        // TODO add your handling code here:
        // Abrir uma única tela, funcionando
        if (objViSoPort == null || objViSoPort.isClosed()) {
            objViSoPort = new TelaConsultaVisitaSocial();
            jPainelPortariaExterna.add(objViSoPort);
            objViSoPort.setVisible(true);
        } else {
            if (objViSoPort.isVisible()) {
                if (objViSoPort.isIcon()) { // Se esta minimizado
                    try {
                        objViSoPort.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objViSoPort.toFront(); // traz para frente
                    objViSoPort.pack();//volta frame 
                }
            } else {
                objViSoPort = new TelaConsultaVisitaSocial();
                TelaModuloPortariaExterna.jPainelPortariaExterna.add(objViSoPort);//adicona frame ao JDesktopPane  
                objViSoPort.setVisible(true);
            }
        }
        try {
            objViSoPort.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaFamiliaresInternosActionPerformed

    private void ConsultaRolVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaRolVisitasActionPerformed
        // TODO add your handling code here:
        // Abrir uma única tela, funcionando
        if (objRolViPor == null || objRolViPor.isClosed()) {
            objRolViPor = new TelaRolVisitasPortaria();
            jPainelPortariaExterna.add(objRolViPor);
            objRolViPor.setVisible(true);
        } else {
            if (objRolViPor.isVisible()) {
                if (objRolViPor.isIcon()) { // Se esta minimizado
                    try {
                        objRolViPor.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRolViPor.toFront(); // traz para frente
                    objRolViPor.pack();//volta frame 
                }
            } else {
                objRolViPor = new TelaRolVisitasPortaria();
                TelaModuloPortariaExterna.jPainelPortariaExterna.add(objRolViPor);//adicona frame ao JDesktopPane  
                objRolViPor.setVisible(true);
            }
        }
        try {
            objRolViPor.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaRolVisitasActionPerformed

    private void EnSaiVisitasDiversasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnSaiVisitasDiversasActionPerformed
        // TODO add your handling code here: 
        buscarAcessoUsuario(telaEntradaSaidaVDManuP1E);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaEntradaSaidaVDManuP1E) && codAbrirP1E == 1) {
            if (objEntSaiVisiDiv == null || objEntSaiVisiDiv.isClosed()) {
                objEntSaiVisiDiv = new TelaEntradaSaidaVisitasDiversasExterna();
                jPainelPortariaExterna.add(objEntSaiVisiDiv);
                objEntSaiVisiDiv.setVisible(true);
            } else {
                if (objEntSaiVisiDiv.isVisible()) {
                    if (objEntSaiVisiDiv.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiVisiDiv.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiVisiDiv.toFront(); // traz para frente
                        objEntSaiVisiDiv.pack();//volta frame 
                    }
                } else {
                    objEntSaiVisiDiv = new TelaEntradaSaidaVisitasDiversasExterna();
                    TelaModuloPortariaExterna.jPainelPortariaExterna.add(objEntSaiVisiDiv);//adicona frame ao JDesktopPane  
                    objEntSaiVisiDiv.setVisible(true);
                }
            }
            try {
                objEntSaiVisiDiv.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EnSaiVisitasDiversasActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:        
        // Abrir uma única tela, funcionando
        if (objRecadosPort == null || objRecadosPort.isClosed()) {
            objRecadosPort = new TelaRecadosPortariaExterna();
            jPainelPortariaExterna.add(objRecadosPort);
            objRecadosPort.setVisible(true);
        } else {
            if (objRecadosPort.isVisible()) {
                if (objRecadosPort.isIcon()) { // Se esta minimizado
                    try {
                        objRecadosPort.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecadosPort.toFront(); // traz para frente
                    objRecadosPort.pack();//volta frame 
                }
            } else {
                objRecadosPort = new TelaRecadosPortariaExterna();
                TelaModuloPortariaExterna.jPainelPortariaExterna.add(objRecadosPort);//adicona frame ao JDesktopPane  
                objRecadosPort.setVisible(true);
            }
        }
        try {
            objRecadosPort.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaRecadosActionPerformed

    private void LivroOcorrenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LivroOcorrenciasActionPerformed
        // TODO add your handling code here:     
        buscarAcessoUsuario(telaOcorrenciaManuP1E);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaOcorrenciaManuP1E) && codAbrirP1E == 1) {
            if (objTexto == null || objTexto.isClosed()) {
                objTexto = new TelaOcorrenciaPortariaExterna();
                jPainelPortariaExterna.add(objTexto);
                objTexto.setVisible(true);
            } else {
                if (objTexto.isVisible()) {
                    if (objTexto.isIcon()) { // Se esta minimizado
                        try {
                            objTexto.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objTexto.toFront(); // traz para frente
                        objTexto.pack();//volta frame 
                    }
                } else {
                    objTexto = new TelaOcorrenciaPortariaExterna();
                    TelaModuloPortariaExterna.jPainelPortariaExterna.add(objTexto);//adicona frame ao JDesktopPane  
                    objTexto.setVisible(true);
                }
            }
            try {
                objTexto.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_LivroOcorrenciasActionPerformed

    private void RelatorioRolVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioRolVisitasActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RolVisitas.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN ROLVISITAS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ROLVISITAS.IdInternoCrc "
                    + "INNER JOIN ITENSROL "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSROL.IdInternoCrc "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON ITENSROL.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE StatusRol='" + statusRol + "'");
            HashMap parametros = new HashMap();
            parametros.put("statusRol", statusRol);
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Rol de Visitas"); // Titulo do relatório
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioRolVisitasActionPerformed

    private void RelatorioEntradaSaidaVistasInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaVistasInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaVisitasInternos objRelVisitasInt = new TelaRelatorioEntradaSaidaVisitasInternos();
        TelaModuloPortariaExterna.jPainelPortariaExterna.add(objRelVisitasInt);
        objRelVisitasInt.show();
    }//GEN-LAST:event_RelatorioEntradaSaidaVistasInternosActionPerformed

    private void RelatorioVeiculosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioVeiculosUnidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaVeiculosUnidadePenal objRelVeicUni = new TelaRelatorioEntradaSaidaVeiculosUnidadePenal();
        TelaModuloPortariaExterna.jPainelPortariaExterna.add(objRelVeicUni);
        objRelVeicUni.show();
    }//GEN-LAST:event_RelatorioVeiculosUnidadeActionPerformed

    private void RelatorioEntradaSaidaVeiculosCargasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaVeiculosCargasActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Em Construção");
    }//GEN-LAST:event_RelatorioEntradaSaidaVeiculosCargasActionPerformed

    private void RelatorioEntradaSaidaVeiculosTerceirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaVeiculosTerceirosActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Em Construção");
    }//GEN-LAST:event_RelatorioEntradaSaidaVeiculosTerceirosActionPerformed

    private void RelatorioCadastroVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioCadastroVeiculosActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Em Construção");
    }//GEN-LAST:event_RelatorioCadastroVeiculosActionPerformed

    private void RelatorioVisitasDiversasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioVisitasDiversasActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaVisitasPortariaMotivoDepartamento objRelVisitasMot = new TelaRelatorioEntradaSaidaVisitasPortariaMotivoDepartamento();
        TelaModuloPortariaExterna.jPainelPortariaExterna.add(objRelVisitasMot);
        objRelVisitasMot.show();
    }//GEN-LAST:event_RelatorioVisitasDiversasActionPerformed

    private void RelatorioEntradaSaidaColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaColaboradoresActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaColaboradoresPortaria objRelFuncPort = new TelaRelatorioEntradaSaidaColaboradoresPortaria();
        TelaModuloPortariaExterna.jPainelPortariaExterna.add(objRelFuncPort);
        objRelFuncPort.show();
    }//GEN-LAST:event_RelatorioEntradaSaidaColaboradoresActionPerformed

    private void RelatorioCadastroColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioCadastroColaboradoresActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioGeralColaboradores.jasper";
            conecta.executaSQL("SELECT * FROM COLABORADOR "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN CARGOS "
                    + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                    + "WHERE StatusFunc='" + statusFunc + "' "
                    + "ORDER BY NomeDepartamento,NomeFunc");
            HashMap parametros = new HashMap();
            parametros.put("statusFunc", statusFunc);
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Colaboradores por Departamento");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioCadastroColaboradoresActionPerformed

    private void RelatorioEntradaSaidaAdvogadosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaAdvogadosInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaAdvogadosInternos objRelAdv = new TelaRelatorioEntradaSaidaAdvogadosInternos();
        TelaModuloPortariaExterna.jPainelPortariaExterna.add(objRelAdv);
        objRelAdv.show();
    }//GEN-LAST:event_RelatorioEntradaSaidaAdvogadosInternosActionPerformed

    private void RelatorioEntradaSaidaAdvogadosDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaAdvogadosDepartamentoActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Em Construção");
    }//GEN-LAST:event_RelatorioEntradaSaidaAdvogadosDepartamentoActionPerformed

    private void AgendaCompromissosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissosActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelPortariaExterna.add(objAgEventos);
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
                TelaModuloPortariaExterna.jPainelPortariaExterna.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissosActionPerformed

    private void RelatorioEntradaSaidaVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaVisitasActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaVisitasPortariaGeral objRelEntSai = new TelaRelatorioEntradaSaidaVisitasPortariaGeral();
        TelaModuloPortariaExterna.jPainelPortariaExterna.add(objRelEntSai);
        objRelEntSai.show();
    }//GEN-LAST:event_RelatorioEntradaSaidaVisitasActionPerformed

    private void RelatorioEntradaSaidaFuncDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaFuncDeptoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaColaboradorPorDepartamento objRelFuncDepto = new TelaRelatorioEntradaSaidaColaboradorPorDepartamento();
        TelaModuloPortariaExterna.jPainelPortariaExterna.add(objRelFuncDepto);
        objRelFuncDepto.show();
    }//GEN-LAST:event_RelatorioEntradaSaidaFuncDeptoActionPerformed

    private void VeiculosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VeiculosUnidadeActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaVUManuP1E);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaEntradaSaidaVUManuP1E) && codAbrirP1E == 1) {
            if (objEntSaiVeiUni == null || objEntSaiVeiUni.isClosed()) {
                objEntSaiVeiUni = new TelaEntradaSaidaVeiculosUnidadeExterna();
                jPainelPortariaExterna.add(objEntSaiVeiUni);
                objEntSaiVeiUni.setVisible(true);
            } else {
                if (objEntSaiVeiUni.isVisible()) {
                    if (objEntSaiVeiUni.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiVeiUni.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiVeiUni.toFront(); // traz para frente
                        objEntSaiVeiUni.pack();//volta frame 
                    }
                } else {
                    objEntSaiVeiUni = new TelaEntradaSaidaVeiculosUnidadeExterna();
                    TelaModuloPortariaExterna.jPainelPortariaExterna.add(objEntSaiVeiUni);//adicona frame ao JDesktopPane  
                    objEntSaiVeiUni.setVisible(true);
                }
            }
            try {
                objEntSaiVeiUni.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_VeiculosUnidadeActionPerformed

    private void VeiculosTerceirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VeiculosTerceirosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaESVTManuP1E);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaEntradaSaidaESVTManuP1E) && codAbrirP1E == 1) {
            if (objEntSaiVeiTer == null || objEntSaiVeiTer.isClosed()) {
                objEntSaiVeiTer = new TelaEntradaSaidaVeiculosTerceirosExterna();
                jPainelPortariaExterna.add(objEntSaiVeiTer);
                objEntSaiVeiTer.setVisible(true);
            } else {
                if (objEntSaiVeiTer.isVisible()) {
                    if (objEntSaiVeiTer.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiVeiTer.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiVeiTer.toFront(); // traz para frente
                        objEntSaiVeiTer.pack();//volta frame 
                    }
                } else {
                    objEntSaiVeiTer = new TelaEntradaSaidaVeiculosTerceirosExterna();
                    TelaModuloPortariaExterna.jPainelPortariaExterna.add(objEntSaiVeiTer);//adicona frame ao JDesktopPane  
                    objEntSaiVeiTer.setVisible(true);
                }
            }
            try {
                objEntSaiVeiTer.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_VeiculosTerceirosActionPerformed

    private void VeiculosCargasDescargasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VeiculosCargasDescargasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaESVCManuP1E);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaEntradaSaidaESVCManuP1E) && codAbrirP1E == 1) {
            if (objEntSaiVeiCarga == null || objEntSaiVeiCarga.isClosed()) {
                objEntSaiVeiCarga = new TelaEntradaSaidaVeiculosCargasExterna();
                jPainelPortariaExterna.add(objEntSaiVeiCarga);
                objEntSaiVeiCarga.setVisible(true);
            } else {
                if (objEntSaiVeiCarga.isVisible()) {
                    if (objEntSaiVeiCarga.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiVeiCarga.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiVeiCarga.toFront(); // traz para frente
                        objEntSaiVeiCarga.pack();//volta frame 
                    }
                } else {
                    objEntSaiVeiCarga = new TelaEntradaSaidaVeiculosCargasExterna();
                    TelaModuloPortariaExterna.jPainelPortariaExterna.add(objEntSaiVeiCarga);//adicona frame ao JDesktopPane  
                    objEntSaiVeiCarga.setVisible(true);
                }
            }
            try {
                objEntSaiVeiCarga.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_VeiculosCargasDescargasActionPerformed

    private void jColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jColaboradoresActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaCOLManuP1E);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaEntradaSaidaCOLManuP1E) && codAbrirP1E == 1) {
            if (objEntSaiCola == null || objEntSaiCola.isClosed()) {
                objEntSaiCola = new TelaEntradaSaidaColaboradorExterna();
                jPainelPortariaExterna.add(objEntSaiCola);
                objEntSaiCola.setVisible(true);
            } else {
                if (objEntSaiCola.isVisible()) {
                    if (objEntSaiCola.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiCola.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiCola.toFront(); // traz para frente
                        objEntSaiCola.pack();//volta frame 
                    }
                } else {
                    objEntSaiCola = new TelaEntradaSaidaColaboradorExterna();
                    TelaModuloPortariaExterna.jPainelPortariaExterna.add(objEntSaiCola);//adicona frame ao JDesktopPane  
                    objEntSaiCola.setVisible(true);
                }
            }
            try {
                objEntSaiCola.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jColaboradoresActionPerformed

    private void jAdvogadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdvogadosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaAdDEPManuP1E);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaEntradaSaidaAdDEPManuP1E) && codAbrirP1E == 1) {
            if (objEntSaiAd == null || objEntSaiAd.isClosed()) {
                objEntSaiAd = new TelaEntradaSaidaAdvogadosExterna();
                jPainelPortariaExterna.add(objEntSaiAd);
                objEntSaiAd.setVisible(true);
            } else {
                if (objEntSaiAd.isVisible()) {
                    if (objEntSaiAd.isIcon()) { // Se esta minimizado
                        try {
                            objEntSaiAd.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntSaiAd.toFront(); // traz para frente
                        objEntSaiAd.pack();//volta frame 
                    }
                } else {
                    objEntSaiAd = new TelaEntradaSaidaAdvogadosExterna();
                    TelaModuloPortariaExterna.jPainelPortariaExterna.add(objEntSaiAd);//adicona frame ao JDesktopPane  
                    objEntSaiAd.setVisible(true);
                }
            }
            try {
                objEntSaiAd.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jAdvogadosActionPerformed

    private void jCadastroAdvogadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadastroAdvogadosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroAdvogadosManuP1E);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaCadastroAdvogadosManuP1E) && codAbrirP1E == 1) {
            if (objAd == null || objAd.isClosed()) {
                objAd = new TelaAdvogadosExterna();
                jPainelPortariaExterna.add(objAd);
                objAd.setVisible(true);
            } else {
                if (objAd.isVisible()) {
                    if (objAd.isIcon()) { // Se esta minimizado
                        try {
                            objAd.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAd.toFront(); // traz para frente
                        objAd.pack();//volta frame 
                    }
                } else {
                    objAd = new TelaAdvogadosExterna();
                    TelaModuloPortariaExterna.jPainelPortariaExterna.add(objAd);//adicona frame ao JDesktopPane  
                    objAd.setVisible(true);
                }
            }
            try {
                objAd.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jCadastroAdvogadosActionPerformed

    private void jOficialJusticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOficialJusticaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCadastroOficialManuP1E);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaCadastroOficialManuP1E) && codAbrirP1E == 1) {
            if (objOficialExt == null || objOficialExt.isClosed()) {
                objOficialExt = new TelaOficialJusticaExterna();
                jPainelPortariaExterna.add(objOficialExt);
                objOficialExt.setVisible(true);
            } else {
                if (objOficialExt.isVisible()) {
                    if (objOficialExt.isIcon()) { // Se esta minimizado
                        try {
                            objOficialExt.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objOficialExt.toFront(); // traz para frente
                        objOficialExt.pack();//volta frame 
                    }
                } else {
                    objOficialExt = new TelaOficialJusticaExterna();
                    TelaModuloPortariaExterna.jPainelPortariaExterna.add(objOficialExt);//adicona frame ao JDesktopPane  
                    objOficialExt.setVisible(true);
                }
            }
            try {
                objOficialExt.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jOficialJusticaActionPerformed

    private void OficialJusticaDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OficialJusticaDepartamentoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntradaSaidaOJManuP1E);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaEntradaSaidaOJManuP1E) && codAbrirP1E == 1) {
            if (objEntraSaiOficialExt == null || objEntraSaiOficialExt.isClosed()) {
                objEntraSaiOficialExt = new TelaEntradaSaidaOficialJusticaExterna();
                jPainelPortariaExterna.add(objEntraSaiOficialExt);
                objEntraSaiOficialExt.setVisible(true);
            } else {
                if (objEntraSaiOficialExt.isVisible()) {
                    if (objEntraSaiOficialExt.isIcon()) { // Se esta minimizado
                        try {
                            objEntraSaiOficialExt.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objEntraSaiOficialExt.toFront(); // traz para frente
                        objEntraSaiOficialExt.pack();//volta frame 
                    }
                } else {
                    objEntraSaiOficialExt = new TelaEntradaSaidaOficialJusticaExterna();
                    TelaModuloPortariaExterna.jPainelPortariaExterna.add(objEntraSaiOficialExt);//adicona frame ao JDesktopPane  
                    objEntraSaiOficialExt.setVisible(true);
                }
            }
            try {
                objEntraSaiOficialExt.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_OficialJusticaDepartamentoActionPerformed

    private void VisitantesReligiososActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisitantesReligiososActionPerformed
        // TODO add your handling code here:
        if (objConVisRel == null || objConVisRel.isClosed()) {
            objConVisRel = new TelaConsultaVisitaSocialReligiosa();
            jPainelPortariaExterna.add(objConVisRel);
            objConVisRel.setVisible(true);
        } else {
            if (objConVisRel.isVisible()) {
                if (objConVisRel.isIcon()) { // Se esta minimizado
                    try {
                        objConVisRel.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConVisRel.toFront(); // traz para frente
                    objConVisRel.pack();//volta frame
                }
            } else {
                objConVisRel = new TelaConsultaVisitaSocialReligiosa();
                TelaModuloPortariaExterna.jPainelPortariaExterna.add(objConVisRel);//adicona frame ao JDesktopPane
                objConVisRel.setVisible(true);
            }
        }
        try {
            objConVisRel.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_VisitantesReligiososActionPerformed

    private void RolVistasReligiosasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RolVistasReligiosasActionPerformed
        // TODO add your handling code here:
        if (objConRolRel == null || objConRolRel.isClosed()) {
            objConRolRel = new TelaConsultaRolVisitasReligiosas();
            jPainelPortariaExterna.add(objConRolRel);
            objConRolRel.setVisible(true);
        } else {
            if (objConRolRel.isVisible()) {
                if (objConRolRel.isIcon()) { // Se esta minimizado
                    try {
                        objConRolRel.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConRolRel.toFront(); // traz para frente
                    objConRolRel.pack();//volta frame
                }
            } else {
                objConRolRel = new TelaConsultaRolVisitasReligiosas();
                TelaModuloPortariaExterna.jPainelPortariaExterna.add(objConRolRel);//adicona frame ao JDesktopPane
                objConRolRel.setVisible(true);
            }
        }
        try {
            objConRolRel.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RolVistasReligiosasActionPerformed

    private void InstituicaoReligiosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstituicaoReligiosaActionPerformed
        // TODO add your handling code here:
        if (objInstRel == null || objInstRel.isClosed()) {
            objInstRel = new TelaInstituicaoReligiosaPortarias();
            jPainelPortariaExterna.add(objInstRel);
            objInstRel.setVisible(true);
        } else {
            if (objInstRel.isVisible()) {
                if (objInstRel.isIcon()) { // Se esta minimizado
                    try {
                        objInstRel.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objInstRel.toFront(); // traz para frente
                    objInstRel.pack();//volta frame
                }
            } else {
                objInstRel = new TelaInstituicaoReligiosaPortarias();
                TelaModuloPortariaExterna.jPainelPortariaExterna.add(objInstRel);//adicona frame ao JDesktopPane
                objInstRel.setVisible(true);
            }
        }
        try {
            objInstRel.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_InstituicaoReligiosaActionPerformed

    private void RegistroChegadaVisitasInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroChegadaVisitasInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroChegadaPortExtManuP1E);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1E.equals("ADMINISTRADORES") || codigoUserP1E == codUserAcessoP1E && nomeTelaP1E.equals(telaRegistroChegadaPortExtManuP1E) && codAbrirP1E == 1) {
            if (objRegChega == null || objRegChega.isClosed()) {
                objRegChega = new TelaRegistroChegadaVisitasInternosPortariaExterna();
                jPainelPortariaExterna.add(objRegChega);
                objRegChega.setVisible(true);
            } else {
                if (objRegChega.isVisible()) {
                    if (objRegChega.isIcon()) { // Se esta minimizado
                        try {
                            objRegChega.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegChega.toFront(); // traz para frente
                        objRegChega.pack();//volta frame
                    }
                } else {
                    objRegChega = new TelaRegistroChegadaVisitasInternosPortariaExterna();
                    TelaModuloPortariaExterna.jPainelPortariaExterna.add(objRegChega);//adicona frame ao JDesktopPane
                    objRegChega.setVisible(true);
                }
            }
            try {
                objRegChega.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RegistroChegadaVisitasInternoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaCompromissos;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenuItem CadastroVeiculos;
    private javax.swing.JMenu Cadastros;
    private javax.swing.JMenuItem ConsultaColaboradores;
    private javax.swing.JMenuItem ConsultaFamiliaresInternos;
    private javax.swing.JMenuItem ConsultaRolVisitas;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenuItem EnSaiVisitasDiversas;
    private javax.swing.JMenuItem InstituicaoReligiosa;
    private javax.swing.JMenuItem LivroOcorrencias;
    private javax.swing.JMenu Movimentacao;
    private javax.swing.JMenuItem OficialJusticaDepartamento;
    private javax.swing.JMenuItem RegistroChegadaVisitasInterno;
    private javax.swing.JMenuItem RelatorioCadastroColaboradores;
    private javax.swing.JMenuItem RelatorioCadastroVeiculos;
    private javax.swing.JMenuItem RelatorioEntradaSaidaAdvogadosDepartamento;
    private javax.swing.JMenuItem RelatorioEntradaSaidaAdvogadosInternos;
    private javax.swing.JMenuItem RelatorioEntradaSaidaColaboradores;
    private javax.swing.JMenuItem RelatorioEntradaSaidaFuncDepto;
    private javax.swing.JMenuItem RelatorioEntradaSaidaVeiculosCargas;
    private javax.swing.JMenuItem RelatorioEntradaSaidaVeiculosTerceiros;
    private javax.swing.JMenuItem RelatorioEntradaSaidaVisitas;
    private javax.swing.JMenuItem RelatorioEntradaSaidaVistasInternos;
    private javax.swing.JMenuItem RelatorioRolVisitas;
    private javax.swing.JMenuItem RelatorioVeiculosUnidade;
    private javax.swing.JMenuItem RelatorioVisitasDiversas;
    private javax.swing.JMenu Relatorios;
    private javax.swing.JMenuItem RolVistasReligiosas;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JMenuItem VeiculosCargasDescargas;
    private javax.swing.JMenuItem VeiculosTerceiros;
    private javax.swing.JMenuItem VeiculosUnidade;
    private javax.swing.JMenuItem VisitantesDiversos;
    private javax.swing.JMenuItem VisitantesReligiosos;
    private javax.swing.JMenuItem jAdvogados;
    private javax.swing.JMenuItem jCadastroAdvogados;
    private javax.swing.JMenuItem jColaboradores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jOficialJustica;
    public static javax.swing.JDesktopPane jPainelPortariaExterna;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator20;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    // End of variables declaration//GEN-END:variables

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

    // Executar programa externo da webcam
    public void webCam() {
        try {
            Process p = Runtime.getRuntime().exec("C:\\SysConp\\MyCam/MyCam.exe");
            if (p.exitValue() == 0) {
                System.out.println("Programa terminou normalmente");
            }
        } catch (Exception e) {
        }
    }

    public void verificarRecado() {
        buscarUsuario(nameUser);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDARECADOS "
                    + "WHERE IdUsuario='" + codUsuario + "' "
                    + "AND StatusAgenda='" + statusAgenda + "'");
            conecta.rs.first();
            if (codUsuario == conecta.rs.getInt("IdUsuario")) {
                // Abrir uma única tela, Tela de Recados Portaria
                if (objRecadosPort == null || objRecadosPort.isClosed()) {
                    objRecadosPort = new TelaRecadosPortariaExterna();
                    jPainelPortariaExterna.add(objRecadosPort);
                    objRecadosPort.setVisible(true);
                } else {
                    if (objRecadosPort.isVisible()) {
                        if (objRecadosPort.isIcon()) { // Se esta minimizado
                            try {
                                objRecadosPort.setIcon(false); // maximiniza
                            } catch (PropertyVetoException ex) {
                            }
                        } else {
                            objRecadosPort.toFront(); // traz para frente
                            objRecadosPort.pack();//volta frame 
                        }
                    } else {
                        objRecadosPort = new TelaRecadosPortariaExterna();
                        TelaModuloPortariaExterna.jPainelPortariaExterna.add(objRecadosPort);//adicona frame ao JDesktopPane  
                        objRecadosPort.setVisible(true);
                    }
                }
                try {
                    objRecadosPort.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                }
                flag = 1;
                preencherTabelaTodosRecados("SELECT * FROM AGENDARECADOS "
                        + "INNER JOIN USUARIOS "
                        + "ON AGENDARECADOS.IdUsuario=USUARIOS.IdUsuario "
                        + "WHERE USUARIOS.NomeUsuario='" + nameUser + "' "
                        + "AND AGENDARECADOS.StatusAgenda='" + statusAgenda + "'");
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
                                + "WHERE NomeUsuario='" + nameUser + "' "
                                + "AND StatusAgenda='" + statusAgenda + "'");
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
                        JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados.(AGENDA RECADOS)\nERRO: " + e);
                    }
                    conecta.desconecta();
                }
            }
        } catch (SQLException ex) {
        }
    }

    public void buscarUsuario(String nomeUser) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nomeUser + "'");
            conecta.rs.first();
            codUsuario = conecta.rs.getInt("IdUsuario");
            nomeUsuarioCompromisso = conecta.rs.getString("NomeUsuario");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível encontrar o usuário.\nERRO: " + ex);
        }
    }

    public void preencherTabelaTodosRecados(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", " Data", " Remetente", " Destinatário"};
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
        convertedata.converter(jDataSistema.getText());
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM AGENDA_COMPROMISSOS "
                        + "WHERE UsuarioAgenda='" + nameUser + "' "
                        + "AND StatusAgenda='" + statusAgenda + "' "
                        + "AND DataLembrete='" + dataSisConvert + "' "
                        + "AND HoraLembrete<='" + jHoraSistema.getText().toString() + "'");
                conecta.rs.first();
                horaLembrete = conecta.rs.getString("HoraLembrete");
                usuarioAgenda = conecta.rs.getString("UsuarioAgenda");
                codigoAgendaComp = conecta.rs.getString("IdAgenda");
                //
                if (nomeUsuarioCompromisso.equals(usuarioAgenda)) {
                    TelaAgendaCompromissos objAgendaComp = new TelaAgendaCompromissos();
                    TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAgendaComp);
                    objAgendaComp.show();
                    flag = 1;
                    preencherTabelaAgendaCompromisso("SELECT * FROM AGENDA_COMPROMISSOS "
                            + "WHERE AGENDA_COMPROMISSOS.UsuarioAgenda='" + nameUser + "' "
                            + "AND AGENDA_COMPROMISSOS.StatusAgenda='" + statusAgenda + "' "
                            + "AND DataLembrete='" + dataSisConvert + "' "
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
                                    + "WHERE AGENDA_COMPROMISSOS.UsuarioAgenda='" + nomeUsuarioCompromisso + "' "
                                    + "AND AGENDA_COMPROMISSOS.StatusAgenda='" + statusAgenda + "' "
                                    + "AND HoraLembrete<='" + jHoraSistema.getText().toString() + "' "
                                    + "AND IdAgenda='" + codigoAgendaComp + "'");
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
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM AGENDA_COMPROMISSOS "
                        + "WHERE UsuarioAgenda='" + nameUser + "' "
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
                    TelaModuloAdmPessoal.jPainelAdmPessoal.add(objAgendaComp);
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
                                    + "WHERE AGENDA_COMPROMISSOS.UsuarioAgenda='" + nomeUsuarioCompromisso + "' "
                                    + "AND AGENDA_COMPROMISSOS.StatusAgenda='" + statusAgenda + "' "
                                    + "AND HoraLembrete<='" + jHoraSistema.getText().toString() + "' "
                                    + "AND IdAgenda='" + codigoAgendaComp + "'");
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

    public void pesquisarTelasAcessos() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroVeiculosManuP1E + "'");
            conecta.rs.first();
            pNomeCVPM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroAdvogadosManuP1E + "'");
            conecta.rs.first();
            pNomeCAM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroVisitasDiversasManuP1E + "'");
            conecta.rs.first();
            pNomeCVDM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCadastroOficialManuP1E + "'");
            conecta.rs.first();
            pNomeCOM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MOVIMENTAÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaAdDEPManuP1E + "'");
            conecta.rs.first();
            pNomeESADM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaAdDEPADVP1E + "'");
            conecta.rs.first();
            pNomeESADMA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaOJManuP1E + "'");
            conecta.rs.first();
            pNomeESOJMP1 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaOJDepP1E + "'");
            conecta.rs.first();
            pNomeESOJDP1 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaVDManuP1E + "'");
            conecta.rs.first();
            pNomeESVDM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaVDVDP1E + "'");
            conecta.rs.first();
            pNomeESVDV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaCOLManuP1E + "'");
            conecta.rs.first();
            pNomeESCM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaCOLcolP1E + "'");
            conecta.rs.first();
            pNomeESCC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaCOLBioP1E + "'");
            conecta.rs.first();
            pNomeESCB = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaVUManuP1E + "'");
            conecta.rs.first();
            pNomeESVUM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaVUVP1E + "'");
            conecta.rs.first();
            pNomeESVUV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaESVCManuP1E + "'");
            conecta.rs.first();
            pNomeESVCP1 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaESVCVP1E + "'");
            conecta.rs.first();
            pNomeESVCVP1 = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaESVTManuP1E + "'");
            conecta.rs.first();
            pNomeESVT = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEntradaSaidaESVTVP1E + "'");
            conecta.rs.first();
            pNomeESVTV = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaOcorrenciaManuP1E + "'");
            conecta.rs.first();
            pNomeOCR = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroChegadaPortExtManuP1E + "'");
            conecta.rs.first();
            pNomeRCVP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroChegadaPortExtPesqP1E + "'");
            conecta.rs.first();
            pNomeRCPEP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroChegadaPortExtBioP1E + "'");
            conecta.rs.first();
            pNomeRCPEB = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroChegadaPortExtRelP1E + "'");
            conecta.rs.first();
            pNomeRCPER = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //CADASTRO
        if (!pNomeCVPM.equals(telaCadastroVeiculosManuP1E) || pNomeCVPM == null || pNomeCVPM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroVeiculosManuP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCAM.equals(telaCadastroAdvogadosManuP1E) || pNomeCAM == null || pNomeCAM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroAdvogadosManuP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCAM.equals(telaCadastroVisitasDiversasManuP1E) || pNomeCAM == null || pNomeCAM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroVisitasDiversasManuP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCOM.equals(telaCadastroOficialManuP1E) || pNomeCOM == null || pNomeCOM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCadastroOficialManuP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //MOVIMENTAÇÃO
        //ADVOGADO DEPARTAMENTO
        if (!pNomeESADM.equals(telaEntradaSaidaAdDEPManuP1E) || pNomeESADM == null || pNomeESADM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaAdDEPManuP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESADMA.equals(telaEntradaSaidaAdDEPADVP1E) || pNomeESADMA == null || pNomeESADMA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaAdDEPADVP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // OFICIAL DEPARTAMENTO
        if (!pNomeESOJMP1.equals(telaEntradaSaidaOJManuP1E) || pNomeESOJMP1 == null || pNomeESOJMP1.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaOJManuP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESOJDP1.equals(telaEntradaSaidaOJDepP1E) || pNomeESOJDP1 == null || pNomeESOJDP1.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaOJDepP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        // OFICIAL VISITAS DIVERSAS
        if (!pNomeESVDM.equals(telaEntradaSaidaVDManuP1E) || pNomeESVDM == null || pNomeESVDM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaVDManuP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVDV.equals(telaEntradaSaidaVDVDP1E) || pNomeESVDV == null || pNomeESVDV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaVDVDP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //COLABORADOR
        if (!pNomeESCM.equals(telaEntradaSaidaCOLManuP1E) || pNomeESCM == null || pNomeESCM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaCOLManuP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESCC.equals(telaEntradaSaidaCOLcolP1E) || pNomeESCC == null || pNomeESCC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaCOLcolP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESCB.equals(telaEntradaSaidaCOLBioP1E) || pNomeESCB == null || pNomeESCB.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaCOLBioP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVUM.equals(telaEntradaSaidaVUManuP1E) || pNomeESVUM == null || pNomeESVUM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaVUManuP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVUV.equals(telaEntradaSaidaVUVP1E) || pNomeESVUV == null || pNomeESVUV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaVUVP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVCP1.equals(telaEntradaSaidaESVCManuP1E) || pNomeESVCP1 == null || pNomeESVCP1.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaESVCManuP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVCVP1.equals(telaEntradaSaidaESVCVP1E) || pNomeESVCVP1 == null || pNomeESVCVP1.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaESVCVP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVT.equals(telaEntradaSaidaESVTManuP1E) || pNomeESVT == null || pNomeESVT.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaESVTManuP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeESVTV.equals(telaEntradaSaidaESVTVP1E) || pNomeESVTV == null || pNomeESVTV.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEntradaSaidaESVTVP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeOCR.equals(telaOcorrenciaManuP1E) || pNomeOCR == null || pNomeOCR.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaOcorrenciaManuP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRCVP.equals(telaRegistroChegadaPortExtManuP1E) || pNomeRCVP == null || pNomeRCVP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroChegadaPortExtManuP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRCPEP.equals(telaRegistroChegadaPortExtPesqP1E) || pNomeRCPEP == null || pNomeRCPEP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroChegadaPortExtPesqP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRCPEB.equals(telaRegistroChegadaPortExtBioP1E) || pNomeRCPEB == null || pNomeRCPEB.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroChegadaPortExtBioP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRCPER.equals(telaRegistroChegadaPortExtRelP1E) || pNomeRCPER == null || pNomeRCPER.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroChegadaPortExtRelP1E);
            controle.incluirTelaAcesso(objCadastroTela);
        }
    }
    // MÉTODO PARA BUSCAR O CÓDIGO DO MÓDULO, CASO NÃO TENHA SIDO CADASTRADO.

    public void buscarCodigoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + nomeModuloP1E + "'");
            conecta.rs.first();
            pCodModulo = conecta.rs.getInt("IdModulo");
        } catch (SQLException ex) {
        }
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserP1E = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserP1E + "'");
            conecta.rs.first();
            codigoUserGroupP1E = conecta.rs.getInt("IdUsuario");
            codigoGrupoP1E = conecta.rs.getInt("IdGrupo");
            nomeGrupoP1E = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserP1E + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoP1E = conecta.rs.getInt("IdUsuario");
            codAbrirP1E = conecta.rs.getInt("Abrir");
            codIncluirP1E = conecta.rs.getInt("Incluir");
            codAlterarP1E = conecta.rs.getInt("Alterar");
            codExcluirP1E = conecta.rs.getInt("Excluir");
            codGravarP1E = conecta.rs.getInt("Gravar");
            codConsultarP1E = conecta.rs.getInt("Consultar");
            nomeTelaP1E = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
    // T4ela de Consulta de internos portaria
    //TelaConsultaSaidaInternos();
}
