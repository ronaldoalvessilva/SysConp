/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.converterDataStringDataDate;
import static gestor.Controle.converterDataStringDataDate.dataSisConvert;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
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
import static gestor.Visao.TelaModuloDiretoria.jPainelDiretoria;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
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
import java.io.IOException;
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
public class TelaModuloDiretoria extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();
    //   
    private TelaRecadosDiretoria objRecaSegu = null;
    private TelaMovHistoricoTecDiretoria objHistMovSeg = null;
    private TelaConsultaLocalInternoPortaria objLocalInter = null;
    private TelaConsultaListaPassagemInternosSeg oblConListaPass = null;
    private TelaMovimentacaoCrcDiretoria objHistCrc = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private BusinessIntelligence objBI = null;
    private TelaConsultaProntuarioInternoCrc objConsProntInt = null;
    private TelaConsultaOcorrenciaPortariaServicoSocial objOcorIndVisita = null;
    private TelaOcorrenciaSegurancaDir objOcrSegDir = null;
    private TelaOcorrenciaPortariaDir objOcrPortDir = null;
    private TelaOcorrenciaBaseDoisDir objOcrBaseDir = null;
    private TelaOcorrenciaBaseUmDir objOcorBaseI = null;
    private TelaOcorrenciaPortariaExternaDir objOcrPortExtDir = null;
    // 
    String pathFoto;
    String dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente";
    //
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado. 
    //
    String tipoEmpresa = "Interna";
    String tipoEmpresaExt = "Externa";
    String statusInterno = "Ativo";
    int count = 0;
    // VARIÁVEIS PARA AGENDA DE COMPROMISSO.
    String dataAgenda;
    String nomeUsuarioCompromisso; // USUÁRIO DA AGENDA DE COMPROMISSO.
    String horaLembrete;
    String usuarioAgenda;
    String codigoAgendaComp;
    // RELATÓRIOS CRC
    String situacaoEnt = "ENTRADA NA UNIDADE"; // Todas as Entradas
    String situacaoRet = "RETORNO A UNIDADE"; // Todos os Retornos
    String situacaoTran = "TRANSFERENCIA"; // Todas as Transferencias
    String situacaoNull = ""; // Cadastrado mas não foi feito entrada
    String situacaoSai = "SAIDA TEMPORARIA";
    String statusEntrada = "ENTRADA NA UNIDADE";
    String statusRetorno = "RETORNO A UNIDADE";
    // RELATÓRIOS ADMINISTRAÇÃO PESSOAL
    String statusFunc = "Ativo"; // STATUS DO COLABORADOR PARA O RELATÓRIO
    // SERVIÇO SOCIAL
    String statusRol = "ABERTO";
    // FARMÁCIA
    String modulo = "F";

    /**
     * Creates new form TelaSeguranca
     */
    public TelaModuloDiretoria() {
        initComponents();
        this.setSize(840, 640); // Tamanho da tela 
        threadMensagem(); // A cada 5 minutos verifica mensagem 
        // ABRIR A TELA DE CONSULTA GERENCIAL QUANDO ACESSAR O MÓDULO
        consultaGerencial();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPainelDiretoria = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Cadastro = new javax.swing.JMenu();
        AgendaCompromisso = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        SairTelaSeguranca = new javax.swing.JMenuItem();
        Consultas = new javax.swing.JMenu();
        jConsultaGerencial = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        LocalInternos = new javax.swing.JMenuItem();
        jProntuarioInternos = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        ListaPassagem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        HistoricosInternos = new javax.swing.JMenu();
        HistoricoCrc = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        jOcorrenciaPortaria = new javax.swing.JMenuItem();
        jOcorrenciaPortariaExterna = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jOcorrenciaSeguranca = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        jOcorrenciaBaseUm = new javax.swing.JMenuItem();
        jOcorrenciaBaseDois = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        RelatoriosSeguranca = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        RelatorioGeralPavilhaoCelas = new javax.swing.JMenuItem();
        ListagemConfere = new javax.swing.JMenuItem();
        MapaConfere = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        RelatorioProntuarios = new javax.swing.JMenu();
        jProntuarioIndividualInterno = new javax.swing.JMenuItem();
        ListagemGeralProntuarios = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        ListagemInternosUnidadeEntrada = new javax.swing.JMenuItem();
        RelatorioPrevisaoSaida = new javax.swing.JMenuItem();
        RelatorioPrevisaoSaidaIntNaoReal = new javax.swing.JMenuItem();
        jMenu16 = new javax.swing.JMenu();
        ListagemSaidasTemporaria = new javax.swing.JMenuItem();
        RelatorioSaidaInternosPortaria = new javax.swing.JMenuItem();
        jRelatorioEvadidos = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        RelatorioPopulacaoInternosNominal = new javax.swing.JMenuItem();
        RelatorioMudancaRegime = new javax.swing.JMenu();
        RelProgressao = new javax.swing.JMenuItem();
        RelRegressao = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        ListagemCadastroInternos = new javax.swing.JMenuItem();
        RelatorioInternos = new javax.swing.JMenu();
        RelatorioNaturalidade = new javax.swing.JMenuItem();
        RellatorioIdade = new javax.swing.JMenuItem();
        RelatorioEscolaridade = new javax.swing.JMenuItem();
        RelatorioArtigo = new javax.swing.JMenuItem();
        RelatorioTempoPena = new javax.swing.JMenuItem();
        RelatorioEstadoCivil = new javax.swing.JMenuItem();
        RelatorioUnidadePenal = new javax.swing.JMenuItem();
        RelatorioRegimePenal = new javax.swing.JMenuItem();
        RelatorioPorCidade = new javax.swing.JMenuItem();
        RelatorioPorBairro = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        jListagemUnidadePenal = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        RelatorioIndisciplinarVisitasPortaria = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        jMenu17 = new javax.swing.JMenu();
        RelatorioEntradaSaidaFuncDepto = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaColaboradores = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        RelatorioEntradaSaidaVisitas = new javax.swing.JMenuItem();
        RelatorioVisitasDiversas1 = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaVisitas1 = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        jMenu18 = new javax.swing.JMenu();
        RelatorioVeiculosUnidade = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaVeiculosCargas = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaVeiculosTerceiros = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        RelatorioCadastroColaboradores = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        ListaPassagemInterna = new javax.swing.JMenuItem();
        ListaPassagemExterna = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        RelatorioRolVisitas = new javax.swing.JMenuItem();
        RelatorioEntradaSaidaVistasInternos = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        RelatorioCadastroProdutos = new javax.swing.JMenuItem();
        RelatorioProdutosConsumoAvulso = new javax.swing.JMenuItem();
        RelatorioEstoqueProdutos = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenu13 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        ExtratoValores = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        RelatorioAtividadeEducacional = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenu12 = new javax.swing.JMenu();
        jMenu19 = new javax.swing.JMenu();
        RelatorioProdutosConsumoInternos = new javax.swing.JMenuItem();
        RelatorioConsumoProduto = new javax.swing.JMenuItem();
        RelatorioProdutosConsumoAvulso1 = new javax.swing.JMenuItem();
        RelatorioAvulsoPorDepartamento = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JPopupMenu.Separator();
        RelatorioEstoqueProdutos1 = new javax.swing.JMenuItem();
        jUtilitaria = new javax.swing.JMenu();
        jCalculadoraPena = new javax.swing.JMenuItem();
        jCalculadoraWindows = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("..::: Diretoria :::...");

        jPainelDiretoria.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BrasaoFundo500Prata2.png"))); // NOI18N

        jPainelDiretoria.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelDiretoriaLayout = new javax.swing.GroupLayout(jPainelDiretoria);
        jPainelDiretoria.setLayout(jPainelDiretoriaLayout);
        jPainelDiretoriaLayout.setHorizontalGroup(
            jPainelDiretoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPainelDiretoriaLayout.setVerticalGroup(
            jPainelDiretoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );

        Cadastro.setText("Cadastro");

        AgendaCompromisso.setText("Agenda de Compromissos Pessoal");
        AgendaCompromisso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaCompromissoActionPerformed(evt);
            }
        });
        Cadastro.add(AgendaCompromisso);

        AgendaRecados.setText("Agenda de Recados");
        AgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaRecadosActionPerformed(evt);
            }
        });
        Cadastro.add(AgendaRecados);
        Cadastro.add(jSeparator12);

        SairTelaSeguranca.setText("Sair");
        SairTelaSeguranca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairTelaSegurancaActionPerformed(evt);
            }
        });
        Cadastro.add(SairTelaSeguranca);

        jMenuBar1.add(Cadastro);

        Consultas.setText("Consultas Diversas");

        jConsultaGerencial.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jConsultaGerencial.setForeground(new java.awt.Color(255, 0, 0));
        jConsultaGerencial.setText("Consulta Gerencial");
        jConsultaGerencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultaGerencialActionPerformed(evt);
            }
        });
        Consultas.add(jConsultaGerencial);
        Consultas.add(jSeparator3);

        LocalInternos.setText("Localização de Internos");
        LocalInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalInternosActionPerformed(evt);
            }
        });
        Consultas.add(LocalInternos);

        jProntuarioInternos.setText("Prontuário de Internos");
        jProntuarioInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProntuarioInternosActionPerformed(evt);
            }
        });
        Consultas.add(jProntuarioInternos);
        Consultas.add(jSeparator6);

        ListaPassagem.setText("Lista de Passagem Laborativa");
        ListaPassagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaPassagemActionPerformed(evt);
            }
        });
        Consultas.add(ListaPassagem);
        Consultas.add(jSeparator2);

        HistoricosInternos.setText("Históricos de Movimentação de Internos");

        HistoricoCrc.setText("Histórico de Entrada/Saida na Unidade Penal");
        HistoricoCrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoricoCrcActionPerformed(evt);
            }
        });
        HistoricosInternos.add(HistoricoCrc);

        jMenuItem3.setText("Histórico Movimentação de Internos no Corpo Técnico");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        HistoricosInternos.add(jMenuItem3);

        Consultas.add(HistoricosInternos);
        Consultas.add(jSeparator1);

        jMenu1.setText("Ocorrências");

        jOcorrenciaPortaria.setText("Portaria Interna");
        jOcorrenciaPortaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOcorrenciaPortariaActionPerformed(evt);
            }
        });
        jMenu1.add(jOcorrenciaPortaria);

        jOcorrenciaPortariaExterna.setText("Portaria Externa");
        jOcorrenciaPortariaExterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOcorrenciaPortariaExternaActionPerformed(evt);
            }
        });
        jMenu1.add(jOcorrenciaPortariaExterna);
        jMenu1.add(jSeparator4);

        jOcorrenciaSeguranca.setText("Segurança");
        jOcorrenciaSeguranca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOcorrenciaSegurancaActionPerformed(evt);
            }
        });
        jMenu1.add(jOcorrenciaSeguranca);
        jMenu1.add(jSeparator21);

        jOcorrenciaBaseUm.setText("Base do Pavilhão I");
        jOcorrenciaBaseUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOcorrenciaBaseUmActionPerformed(evt);
            }
        });
        jMenu1.add(jOcorrenciaBaseUm);

        jOcorrenciaBaseDois.setText("Base do Pavilhao II");
        jOcorrenciaBaseDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOcorrenciaBaseDoisActionPerformed(evt);
            }
        });
        jMenu1.add(jOcorrenciaBaseDois);

        Consultas.add(jMenu1);
        Consultas.add(jSeparator5);

        jMenuItem7.setText("Ocorrências Indiscipliar Portaria");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        Consultas.add(jMenuItem7);

        jMenuBar1.add(Consultas);

        RelatoriosSeguranca.setText("Relatórios");

        jMenu7.setText("Segurança");

        RelatorioGeralPavilhaoCelas.setText("Relatório Geral de Internos no Pavilhão/Celas");
        RelatorioGeralPavilhaoCelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioGeralPavilhaoCelasActionPerformed(evt);
            }
        });
        jMenu7.add(RelatorioGeralPavilhaoCelas);

        ListagemConfere.setText("Listagem de Confere");
        ListagemConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemConfereActionPerformed(evt);
            }
        });
        jMenu7.add(ListagemConfere);

        MapaConfere.setText("Mapa de Confere");
        MapaConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MapaConfereActionPerformed(evt);
            }
        });
        jMenu7.add(MapaConfere);

        RelatoriosSeguranca.add(jMenu7);
        RelatoriosSeguranca.add(jSeparator11);

        jMenu3.setText("CRC");

        RelatorioProntuarios.setText("Relatórios de Prontuários");
        RelatorioProntuarios.setBorderPainted(true);

        jProntuarioIndividualInterno.setText("Prontuário Individual do Interno");
        jProntuarioIndividualInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProntuarioIndividualInternoActionPerformed(evt);
            }
        });
        RelatorioProntuarios.add(jProntuarioIndividualInterno);

        ListagemGeralProntuarios.setText("Prontuários de Internos - Geral");
        ListagemGeralProntuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemGeralProntuariosActionPerformed(evt);
            }
        });
        RelatorioProntuarios.add(ListagemGeralProntuarios);

        jMenuItem5.setText("Prontuários de Internos na Unidade");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        RelatorioProntuarios.add(jMenuItem5);

        jMenu3.add(RelatorioProntuarios);
        jMenu3.add(jSeparator15);

        ListagemInternosUnidadeEntrada.setText("Listagem de Entradas de Internos na Unidade");
        ListagemInternosUnidadeEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemInternosUnidadeEntradaActionPerformed(evt);
            }
        });
        jMenu3.add(ListagemInternosUnidadeEntrada);

        RelatorioPrevisaoSaida.setText("Relatório Geral de Previsão de Saída");
        RelatorioPrevisaoSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPrevisaoSaidaActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioPrevisaoSaida);

        RelatorioPrevisaoSaidaIntNaoReal.setText("Relatórios de Previsão de Saída de Internos Realizadas");
        RelatorioPrevisaoSaidaIntNaoReal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPrevisaoSaidaIntNaoRealActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioPrevisaoSaidaIntNaoReal);

        jMenu16.setText("Relatórios de Saída de Internos da Unidade");

        ListagemSaidasTemporaria.setText("Relatório de Saídas Por Beneficio");
        ListagemSaidasTemporaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemSaidasTemporariaActionPerformed(evt);
            }
        });
        jMenu16.add(ListagemSaidasTemporaria);

        RelatorioSaidaInternosPortaria.setText("Relatório de Saída de Internos na Portaria");
        RelatorioSaidaInternosPortaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioSaidaInternosPortariaActionPerformed(evt);
            }
        });
        jMenu16.add(RelatorioSaidaInternosPortaria);

        jMenu3.add(jMenu16);

        jRelatorioEvadidos.setText("Listagem de Internos Evadidos");
        jRelatorioEvadidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioEvadidosActionPerformed(evt);
            }
        });
        jMenu3.add(jRelatorioEvadidos);
        jMenu3.add(jSeparator13);

        RelatorioPopulacaoInternosNominal.setText("Relatório de População de Internos Nominal");
        RelatorioPopulacaoInternosNominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPopulacaoInternosNominalActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioPopulacaoInternosNominal);

        RelatorioMudancaRegime.setText("Relatório de Mudança de Regime");

        RelProgressao.setText("Relatório de Progressão de Regime Penal");
        RelProgressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelProgressaoActionPerformed(evt);
            }
        });
        RelatorioMudancaRegime.add(RelProgressao);

        RelRegressao.setText("Relatório de Regressão de Regime Penal");
        RelRegressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelRegressaoActionPerformed(evt);
            }
        });
        RelatorioMudancaRegime.add(RelRegressao);

        jMenu3.add(RelatorioMudancaRegime);
        jMenu3.add(jSeparator14);

        ListagemCadastroInternos.setText("Listagem de Cadastro de Prontuários");
        ListagemCadastroInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemCadastroInternosActionPerformed(evt);
            }
        });
        jMenu3.add(ListagemCadastroInternos);

        RelatorioInternos.setText("Relatórios de Internos");

        RelatorioNaturalidade.setText("Por Naturalidade");
        RelatorioNaturalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioNaturalidadeActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioNaturalidade);

        RellatorioIdade.setText("Por Idade");
        RellatorioIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RellatorioIdadeActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RellatorioIdade);

        RelatorioEscolaridade.setText("Por Escolaridade");
        RelatorioEscolaridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEscolaridadeActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioEscolaridade);

        RelatorioArtigo.setText("Por Artigo");
        RelatorioArtigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioArtigoActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioArtigo);

        RelatorioTempoPena.setText("Por Tempo de Pena");
        RelatorioTempoPena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioTempoPenaActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioTempoPena);

        RelatorioEstadoCivil.setText("Por Estado Civil");
        RelatorioEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEstadoCivilActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioEstadoCivil);

        RelatorioUnidadePenal.setText("Por Unidade Penal");
        RelatorioUnidadePenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioUnidadePenalActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioUnidadePenal);

        RelatorioRegimePenal.setText("Por Regime Penal");
        RelatorioRegimePenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioRegimePenalActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioRegimePenal);

        RelatorioPorCidade.setText("Por Cidade");
        RelatorioPorCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPorCidadeActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioPorCidade);

        RelatorioPorBairro.setText("Por Bairro");
        RelatorioPorBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPorBairroActionPerformed(evt);
            }
        });
        RelatorioInternos.add(RelatorioPorBairro);

        jMenu3.add(RelatorioInternos);
        jMenu3.add(jSeparator16);

        jListagemUnidadePenal.setText("Listagem de Unidade Penal/Delegacias");
        jListagemUnidadePenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListagemUnidadePenalActionPerformed(evt);
            }
        });
        jMenu3.add(jListagemUnidadePenal);

        RelatoriosSeguranca.add(jMenu3);

        jMenu4.setText("Portaria");

        RelatorioIndisciplinarVisitasPortaria.setText("Relatório de Ocorrência Indisciplinar de Visitas na Portaria");
        RelatorioIndisciplinarVisitasPortaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioIndisciplinarVisitasPortariaActionPerformed(evt);
            }
        });
        jMenu4.add(RelatorioIndisciplinarVisitasPortaria);
        jMenu4.add(jSeparator19);

        jMenu17.setText("Relatórios de frequência de Colaboradores na Unidade Penal");

        RelatorioEntradaSaidaFuncDepto.setText("Relatório Entrada/Saída Colaborador Por Departamento");
        RelatorioEntradaSaidaFuncDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaFuncDeptoActionPerformed(evt);
            }
        });
        jMenu17.add(RelatorioEntradaSaidaFuncDepto);

        RelatorioEntradaSaidaColaboradores.setText("Relatório de Entrada/Saída de Colaboradores");
        RelatorioEntradaSaidaColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaColaboradoresActionPerformed(evt);
            }
        });
        jMenu17.add(RelatorioEntradaSaidaColaboradores);

        jMenu4.add(jMenu17);
        jMenu4.add(jSeparator17);

        RelatorioEntradaSaidaVisitas.setText("Relatório de Registro de Entrada/Saída Geral de Visitas por Departamento");
        RelatorioEntradaSaidaVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaVisitasActionPerformed(evt);
            }
        });
        jMenu4.add(RelatorioEntradaSaidaVisitas);

        RelatorioVisitasDiversas1.setText("Relatório de Visitas Diversas por Departamento/Motivo Visita");
        RelatorioVisitasDiversas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioVisitasDiversas1ActionPerformed(evt);
            }
        });
        jMenu4.add(RelatorioVisitasDiversas1);

        RelatorioEntradaSaidaVisitas1.setText("Relatório de Registro de Entrada/Saída Geral de Visitas por Departamento");
        RelatorioEntradaSaidaVisitas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaVisitas1ActionPerformed(evt);
            }
        });
        jMenu4.add(RelatorioEntradaSaidaVisitas1);
        jMenu4.add(jSeparator18);

        jMenu18.setText("Relatório de Entrada/Saída de  Veículos na Unidade Penal");

        RelatorioVeiculosUnidade.setText("Veículos da Unidade");
        RelatorioVeiculosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioVeiculosUnidadeActionPerformed(evt);
            }
        });
        jMenu18.add(RelatorioVeiculosUnidade);

        RelatorioEntradaSaidaVeiculosCargas.setText("Veículos de Cargas");
        RelatorioEntradaSaidaVeiculosCargas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaVeiculosCargasActionPerformed(evt);
            }
        });
        jMenu18.add(RelatorioEntradaSaidaVeiculosCargas);

        RelatorioEntradaSaidaVeiculosTerceiros.setText("Veículos de Terceiros");
        RelatorioEntradaSaidaVeiculosTerceiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaVeiculosTerceirosActionPerformed(evt);
            }
        });
        jMenu18.add(RelatorioEntradaSaidaVeiculosTerceiros);

        jMenu4.add(jMenu18);

        RelatoriosSeguranca.add(jMenu4);
        RelatoriosSeguranca.add(jSeparator9);

        jMenu5.setText("Administração Pessoal");

        RelatorioCadastroColaboradores.setText("Listagem de Colaboradores");
        RelatorioCadastroColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioCadastroColaboradoresActionPerformed(evt);
            }
        });
        jMenu5.add(RelatorioCadastroColaboradores);

        RelatoriosSeguranca.add(jMenu5);
        RelatoriosSeguranca.add(jSeparator7);

        jMenu2.setText("Terapia Ocupacional");

        ListaPassagemInterna.setText("Relatório de Lista de Passagem Interna");
        ListaPassagemInterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaPassagemInternaActionPerformed(evt);
            }
        });
        jMenu2.add(ListaPassagemInterna);

        ListaPassagemExterna.setText("Relatório de Lista de Passagem Externa");
        ListaPassagemExterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaPassagemExternaActionPerformed(evt);
            }
        });
        jMenu2.add(ListaPassagemExterna);

        RelatoriosSeguranca.add(jMenu2);

        jMenu6.setText("Serviço Social");

        RelatorioRolVisitas.setText("Rol de Visitas");
        RelatorioRolVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioRolVisitasActionPerformed(evt);
            }
        });
        jMenu6.add(RelatorioRolVisitas);

        RelatorioEntradaSaidaVistasInternos.setText("Relatório de Visitas de Internos");
        RelatorioEntradaSaidaVistasInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaSaidaVistasInternosActionPerformed(evt);
            }
        });
        jMenu6.add(RelatorioEntradaSaidaVistasInternos);

        RelatoriosSeguranca.add(jMenu6);

        jMenu8.setText("Enfermaria");
        jMenu8.setEnabled(false);
        RelatoriosSeguranca.add(jMenu8);

        jMenu9.setText("Odontologia");
        jMenu9.setEnabled(false);
        RelatoriosSeguranca.add(jMenu9);

        jMenu10.setText("Psicologia");
        jMenu10.setEnabled(false);
        RelatoriosSeguranca.add(jMenu10);

        jMenu11.setText("Farmácia");

        RelatorioCadastroProdutos.setText("Relatórios de Cadastro de Produtos");
        RelatorioCadastroProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioCadastroProdutosActionPerformed(evt);
            }
        });
        jMenu11.add(RelatorioCadastroProdutos);

        RelatorioProdutosConsumoAvulso.setText("Relatório de Produtos Consumo Aulso");
        RelatorioProdutosConsumoAvulso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioProdutosConsumoAvulsoActionPerformed(evt);
            }
        });
        jMenu11.add(RelatorioProdutosConsumoAvulso);

        RelatorioEstoqueProdutos.setText("Relatório de Estoque de Produtos");
        RelatorioEstoqueProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEstoqueProdutosActionPerformed(evt);
            }
        });
        jMenu11.add(RelatorioEstoqueProdutos);

        jMenuItem4.setText("Relatório de Transferência de Produtos/Medicamentos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem4);

        RelatoriosSeguranca.add(jMenu11);
        RelatoriosSeguranca.add(jSeparator10);

        jMenu13.setText("Juridico");
        jMenu13.setEnabled(false);
        RelatoriosSeguranca.add(jMenu13);

        jMenu14.setText("Financeiro");

        ExtratoValores.setText("Extrato Geral de Valores");
        ExtratoValores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtratoValoresActionPerformed(evt);
            }
        });
        jMenu14.add(ExtratoValores);

        RelatoriosSeguranca.add(jMenu14);

        jMenu15.setText("Pedagogia");

        RelatorioAtividadeEducacional.setText("Relatório Quantitativo de Atividade Educacional");
        RelatorioAtividadeEducacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioAtividadeEducacionalActionPerformed(evt);
            }
        });
        jMenu15.add(RelatorioAtividadeEducacional);

        RelatoriosSeguranca.add(jMenu15);
        RelatoriosSeguranca.add(jSeparator8);

        jMenu12.setText("Almoxarifado");

        jMenu19.setText("Relatório de Produtos Consumido por Internos");

        RelatorioProdutosConsumoInternos.setText("Relatório de Produtos Consumido por Data");
        RelatorioProdutosConsumoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioProdutosConsumoInternosActionPerformed(evt);
            }
        });
        jMenu19.add(RelatorioProdutosConsumoInternos);

        RelatorioConsumoProduto.setText("Relatório de Consumo por Produto");
        RelatorioConsumoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioConsumoProdutoActionPerformed(evt);
            }
        });
        jMenu19.add(RelatorioConsumoProduto);

        jMenu12.add(jMenu19);

        RelatorioProdutosConsumoAvulso1.setText("Relatório de Produtos Consumo Aulso");
        RelatorioProdutosConsumoAvulso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioProdutosConsumoAvulso1ActionPerformed(evt);
            }
        });
        jMenu12.add(RelatorioProdutosConsumoAvulso1);

        RelatorioAvulsoPorDepartamento.setText("Relatório de Produtos Consumo Avuslo por Departamento");
        RelatorioAvulsoPorDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioAvulsoPorDepartamentoActionPerformed(evt);
            }
        });
        jMenu12.add(RelatorioAvulsoPorDepartamento);
        jMenu12.add(jSeparator20);

        RelatorioEstoqueProdutos1.setText("Relatório de Estoque de Produtos");
        RelatorioEstoqueProdutos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEstoqueProdutos1ActionPerformed(evt);
            }
        });
        jMenu12.add(RelatorioEstoqueProdutos1);

        RelatoriosSeguranca.add(jMenu12);

        jMenuBar1.add(RelatoriosSeguranca);

        jUtilitaria.setText("Utilitários");

        jCalculadoraPena.setText("Calculadora de Pena");
        jCalculadoraPena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCalculadoraPenaActionPerformed(evt);
            }
        });
        jUtilitaria.add(jCalculadoraPena);

        jCalculadoraWindows.setText("Calculadora do Windows");
        jCalculadoraWindows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCalculadoraWindowsActionPerformed(evt);
            }
        });
        jUtilitaria.add(jCalculadoraWindows);

        jMenuBar1.add(jUtilitaria);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelDiretoria)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelDiretoria)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairTelaSegurancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairTelaSegurancaActionPerformed
        // TODO add your handling code here:        
        dispose();
    }//GEN-LAST:event_SairTelaSegurancaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if (objHistMovSeg == null || objHistMovSeg.isClosed()) {
            objHistMovSeg = new TelaMovHistoricoTecDiretoria();
            jPainelDiretoria.add(objHistMovSeg);
            objHistMovSeg.setVisible(true);
        } else {
            if (objHistMovSeg.isVisible()) {
                if (objHistMovSeg.isIcon()) { // Se esta minimizado
                    try {
                        objHistMovSeg.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objHistMovSeg.toFront(); // traz para frente
                    objHistMovSeg.pack();//volta frame 
                }
            } else {
                objHistMovSeg = new TelaMovHistoricoTecDiretoria();
                TelaModuloDiretoria.jPainelDiretoria.add(objHistMovSeg);//adicona frame ao JDesktopPane  
                objHistMovSeg.setVisible(true);
            }
        }
        try {
            objHistMovSeg.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void LocalInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalInternosActionPerformed
        // TODO add your handling code here:
        if (objLocalInter == null || objLocalInter.isClosed()) {
            objLocalInter = new TelaConsultaLocalInternoPortaria();
            jPainelDiretoria.add(objLocalInter);
            objLocalInter.setVisible(true);
        } else {
            if (objLocalInter.isVisible()) {
                if (objLocalInter.isIcon()) { // Se esta minimizado
                    try {
                        objLocalInter.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objLocalInter.toFront(); // traz para frente
                    objLocalInter.pack();//volta frame 
                }
            } else {
                objLocalInter = new TelaConsultaLocalInternoPortaria();
                TelaModuloDiretoria.jPainelDiretoria.add(objLocalInter);//adicona frame ao JDesktopPane  
                objLocalInter.setVisible(true);
            }
        }
        try {
            objLocalInter.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_LocalInternosActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:
        if (objRecaSegu == null || objRecaSegu.isClosed()) {
            objRecaSegu = new TelaRecadosDiretoria();
            jPainelDiretoria.add(objRecaSegu);
            objRecaSegu.setVisible(true);
        } else {
            if (objRecaSegu.isVisible()) {
                if (objRecaSegu.isIcon()) { // Se esta minimizado
                    try {
                        objRecaSegu.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecaSegu.toFront(); // traz para frente
                    objRecaSegu.pack();//volta frame 
                }
            } else {
                objRecaSegu = new TelaRecadosDiretoria();
                TelaModuloDiretoria.jPainelDiretoria.add(objRecaSegu);//adicona frame ao JDesktopPane  
                objRecaSegu.setVisible(true);
            }
        }
        try {
            objRecaSegu.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaRecadosActionPerformed

    private void ListaPassagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaPassagemActionPerformed
        // TODO add your handling code here:
        if (oblConListaPass == null || oblConListaPass.isClosed()) {
            oblConListaPass = new TelaConsultaListaPassagemInternosSeg();
            jPainelDiretoria.add(oblConListaPass);
            oblConListaPass.setVisible(true);
        } else {
            if (oblConListaPass.isVisible()) {
                if (oblConListaPass.isIcon()) { // Se esta minimizado
                    try {
                        oblConListaPass.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    oblConListaPass.toFront(); // traz para frente
                    oblConListaPass.pack();//volta frame 
                }
            } else {
                oblConListaPass = new TelaConsultaListaPassagemInternosSeg();
                TelaModuloDiretoria.jPainelDiretoria.add(oblConListaPass);//adicona frame ao JDesktopPane  
                oblConListaPass.setVisible(true);
            }
        }
        try {
            oblConListaPass.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ListaPassagemActionPerformed

    private void RelatorioGeralPavilhaoCelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioGeralPavilhaoCelasActionPerformed
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
                    + "ON CELAS.IdPav=PAVILHAO.IdPav ORDER BY DescricaoPav,PRONTUARIOSCRC.NomeInternoCrc,CELAS.EndCelaPav");
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
    }//GEN-LAST:event_RelatorioGeralPavilhaoCelasActionPerformed

    private void ListagemConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemConfereActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConfere objRelConfere = new TelaRelatorioConfere();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelConfere);
        objRelConfere.show();
    }//GEN-LAST:event_ListagemConfereActionPerformed

    private void ListaPassagemInternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaPassagemInternaActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioListaPassagemInterna.jasper";
            conecta.executaSQL("SELECT * FROM ITENSAGENDALABORATIVA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSAGENDALABORATIVA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN EMPRESALAB "
                    + "ON ITENSAGENDALABORATIVA.IdEmp=EMPRESALAB.IdEmp "
                    + "WHERE ITENSAGENDALABORATIVA.TipoEmpresa='" + tipoEmpresa + "'AND StatusInterno='" + statusInterno + "'ORDER BY RazaoSocial,NomeInternoCrc");
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
    }//GEN-LAST:event_ListaPassagemInternaActionPerformed

    private void ListaPassagemExternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaPassagemExternaActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioListaPassagemExterna.jasper";
            conecta.executaSQL("SELECT * FROM ITENSAGENDALABORATIVA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSAGENDALABORATIVA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN EMPRESALAB "
                    + "ON ITENSAGENDALABORATIVA.IdEmp=EMPRESALAB.IdEmp "
                    + "WHERE ITENSAGENDALABORATIVA.TipoEmpresa='" + tipoEmpresaExt + "'AND StatusInterno='" + statusInterno + "'ORDER BY RazaoSocial,NomeInternoCrc");
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
    }//GEN-LAST:event_ListaPassagemExternaActionPerformed

    private void HistoricoCrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoricoCrcActionPerformed
        // TODO add your handling code here:
        if (objHistCrc == null || objHistCrc.isClosed()) {
            objHistCrc = new TelaMovimentacaoCrcDiretoria();
            jPainelDiretoria.add(objHistCrc);
            objHistCrc.setVisible(true);
        } else {
            if (objHistCrc.isVisible()) {
                if (objHistCrc.isIcon()) { // Se esta minimizado
                    try {
                        objHistCrc.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objHistCrc.toFront(); // traz para frente
                    objHistCrc.pack();//volta frame 
                }
            } else {
                objHistCrc = new TelaMovimentacaoCrcDiretoria();
                TelaModuloDiretoria.jPainelDiretoria.add(objHistCrc);//adicona frame ao JDesktopPane  
                objHistCrc.setVisible(true);
            }
        }
        try {
            objHistCrc.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_HistoricoCrcActionPerformed

    private void MapaConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MapaConfereActionPerformed
        // TODO add your handling code here:
        TelaRelMapaConfereSeguranca mapop = new TelaRelMapaConfereSeguranca();
        TelaModuloDiretoria.jPainelDiretoria.add(mapop);
        mapop.show();
    }//GEN-LAST:event_MapaConfereActionPerformed

    private void AgendaCompromissoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissoActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelDiretoria.add(objAgEventos);
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
                TelaModuloDiretoria.jPainelDiretoria.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissoActionPerformed

    private void jConsultaGerencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultaGerencialActionPerformed
        // TODO add your handling code here:
        if (objBI == null || objBI.isClosed()) {
            objBI = new BusinessIntelligence();
            jPainelDiretoria.add(objBI);
            objBI.setVisible(true);
        } else {
            if (objBI.isVisible()) {
                if (objBI.isIcon()) { // Se esta minimizado
                    try {
                        objBI.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objBI.toFront(); // traz para frente
                    objBI.pack();//volta frame 
                }
            } else {
                objBI = new BusinessIntelligence();
                TelaModuloDiretoria.jPainelDiretoria.add(objBI);//adicona frame ao JDesktopPane  
                objBI.setVisible(true);
            }
        }
        try {
            objBI.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jConsultaGerencialActionPerformed

    private void jProntuarioInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProntuarioInternosActionPerformed
        // TODO add your handling code here:
        if (objConsProntInt == null || objConsProntInt.isClosed()) {
            objConsProntInt = new TelaConsultaProntuarioInternoCrc();
            jPainelDiretoria.add(objConsProntInt);
            objConsProntInt.setVisible(true);
        } else {
            if (objConsProntInt.isVisible()) {
                if (objConsProntInt.isIcon()) { // Se esta minimizado
                    try {
                        objConsProntInt.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsProntInt.toFront(); // traz para frente
                    objConsProntInt.pack();//volta frame 
                }
            } else {
                objConsProntInt = new TelaConsultaProntuarioInternoCrc();
                TelaModuloDiretoria.jPainelDiretoria.add(objConsProntInt);//adicona frame ao JDesktopPane  
                objConsProntInt.setVisible(true);
            }
        }
        try {
            objConsProntInt.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jProntuarioInternosActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        if (objOcorIndVisita == null || objOcorIndVisita.isClosed()) {
            objOcorIndVisita = new TelaConsultaOcorrenciaPortariaServicoSocial();
            jPainelDiretoria.add(objOcorIndVisita);
            objOcorIndVisita.setVisible(true);
        } else {
            if (objOcorIndVisita.isVisible()) {
                if (objOcorIndVisita.isIcon()) { // Se esta minimizado
                    try {
                        objOcorIndVisita.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objOcorIndVisita.toFront(); // traz para frente
                    objOcorIndVisita.pack();//volta frame 
                }
            } else {
                objOcorIndVisita = new TelaConsultaOcorrenciaPortariaServicoSocial();
                TelaModuloDiretoria.jPainelDiretoria.add(objOcorIndVisita);//adicona frame ao JDesktopPane  
                objOcorIndVisita.setVisible(true);
            }
        }
        try {
            objOcorIndVisita.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jOcorrenciaPortariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOcorrenciaPortariaActionPerformed
        // TODO add your handling code here:
        if (objOcrPortDir == null || objOcrPortDir.isClosed()) {
            objOcrPortDir = new TelaOcorrenciaPortariaDir();
            jPainelDiretoria.add(objOcrPortDir);
            objOcrPortDir.setVisible(true);
        } else {
            if (objOcrPortDir.isVisible()) {
                if (objOcrPortDir.isIcon()) { // Se esta minimizado
                    try {
                        objOcrPortDir.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objOcrPortDir.toFront(); // traz para frente
                    objOcrPortDir.pack();//volta frame 
                }
            } else {
                objOcrPortDir = new TelaOcorrenciaPortariaDir();
                TelaModuloDiretoria.jPainelDiretoria.add(objOcrPortDir);//adicona frame ao JDesktopPane  
                objOcrPortDir.setVisible(true);
            }
        }
        try {
            objOcrPortDir.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jOcorrenciaPortariaActionPerformed

    private void jOcorrenciaSegurancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOcorrenciaSegurancaActionPerformed
        // TODO add your handling code here:
        if (objOcrSegDir == null || objOcrSegDir.isClosed()) {
            objOcrSegDir = new TelaOcorrenciaSegurancaDir();
            jPainelDiretoria.add(objOcrSegDir);
            objOcrSegDir.setVisible(true);
        } else {
            if (objOcrSegDir.isVisible()) {
                if (objOcrSegDir.isIcon()) { // Se esta minimizado
                    try {
                        objOcrSegDir.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objOcrSegDir.toFront(); // traz para frente
                    objOcrSegDir.pack();//volta frame 
                }
            } else {
                objOcrSegDir = new TelaOcorrenciaSegurancaDir();
                TelaModuloDiretoria.jPainelDiretoria.add(objOcrSegDir);//adicona frame ao JDesktopPane  
                objOcrSegDir.setVisible(true);
            }
        }
        try {
            objOcrSegDir.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jOcorrenciaSegurancaActionPerformed

    private void jOcorrenciaBaseUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOcorrenciaBaseUmActionPerformed
        // TODO add your handling code here:
        if (objOcorBaseI == null || objOcorBaseI.isClosed()) {
            objOcorBaseI = new TelaOcorrenciaBaseUmDir();
            jPainelDiretoria.add(objOcorBaseI);
            objOcorBaseI.setVisible(true);
        } else {
            if (objOcorBaseI.isVisible()) {
                if (objOcorBaseI.isIcon()) { // Se esta minimizado
                    try {
                        objOcorBaseI.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objOcorBaseI.toFront(); // traz para frente
                    objOcorBaseI.pack();//volta frame 
                }
            } else {
                objOcorBaseI = new TelaOcorrenciaBaseUmDir();
                TelaModuloDiretoria.jPainelDiretoria.add(objOcorBaseI);//adicona frame ao JDesktopPane  
                objOcorBaseI.setVisible(true);
            }
        }
        try {
            objOcorBaseI.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
//        private TelaOcorrenciaBaseUmDir objOcorBaseII = null;
    }//GEN-LAST:event_jOcorrenciaBaseUmActionPerformed

    private void jCalculadoraPenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCalculadoraPenaActionPerformed
        // TODO add your handling code here:
        calcPena();
    }//GEN-LAST:event_jCalculadoraPenaActionPerformed

    private void jCalculadoraWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCalculadoraWindowsActionPerformed
        // TODO add your handling code here:
        CalcWindows();
    }//GEN-LAST:event_jCalculadoraWindowsActionPerformed

    private void RelatorioPrevisaoSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPrevisaoSaidaActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPrevisaoSaidaCrc objRelPrevSai = new TelaRelatorioPrevisaoSaidaCrc();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelPrevSai);
        objRelPrevSai.show();
    }//GEN-LAST:event_RelatorioPrevisaoSaidaActionPerformed

    private void RelatorioPrevisaoSaidaIntNaoRealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPrevisaoSaidaIntNaoRealActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPrevisaoSaidaDivCrc objRelPrevSaiIntDiv = new TelaRelatorioPrevisaoSaidaDivCrc();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelPrevSaiIntDiv);
        objRelPrevSaiIntDiv.show();
    }//GEN-LAST:event_RelatorioPrevisaoSaidaIntNaoRealActionPerformed

    private void ListagemSaidasTemporariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemSaidasTemporariaActionPerformed
        // TODO add your handling code here:
        TelaRelatorioSaidas objRelaSaidas = new TelaRelatorioSaidas();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelaSaidas);
        objRelaSaidas.show();
    }//GEN-LAST:event_ListagemSaidasTemporariaActionPerformed

    private void RelatorioSaidaInternosPortariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioSaidaInternosPortariaActionPerformed
        // TODO add your handling code here:
        TelaRelatorioSaidaInternosPorData objRelaSaidaPort = new TelaRelatorioSaidaInternosPorData();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelaSaidaPort);
        objRelaSaidaPort.show();
    }//GEN-LAST:event_RelatorioSaidaInternosPortariaActionPerformed

    private void jRelatorioEvadidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioEvadidosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioDataEvasao objRelIntEvadidos = new TelaRelatorioDataEvasao();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelIntEvadidos);
        objRelIntEvadidos.show();
    }//GEN-LAST:event_jRelatorioEvadidosActionPerformed

    private void RelatorioPopulacaoInternosNominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPopulacaoInternosNominalActionPerformed
        // TODO add your handling code here:
        TelaRelPopulacaoInternosNominal objRelPop = new TelaRelPopulacaoInternosNominal();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelPop);
        objRelPop.show();
    }//GEN-LAST:event_RelatorioPopulacaoInternosNominalActionPerformed

    private void RelProgressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelProgressaoActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioMudancaRegimeProgressao.jasper";
            conecta.executaSQL("SELECT * FROM SENTENCAS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON SENTENCAS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSPROGRESSAOREGIME "
                    + "ON SENTENCAS.IdInternoCrc=ITENSPROGRESSAOREGIME.IdInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Mudança de Regime Prisional de Internos - PROGRESSÃO");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
        conecta.desconecta();
    }//GEN-LAST:event_RelProgressaoActionPerformed

    private void RelRegressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelRegressaoActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioMudancaRegimeRegressao.jasper";
            conecta.executaSQL("SELECT * FROM SENTENCAS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON SENTENCAS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSREGRESSAOREGIME "
                    + "ON SENTENCAS.IdInternoCrc=ITENSREGRESSAOREGIME.IdInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Mudança de Regime Prisional de Internos - REGRESSÃO");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
        conecta.desconecta();
    }//GEN-LAST:event_RelRegressaoActionPerformed

    private void ListagemCadastroInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemCadastroInternosActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ListagemCadastroPronturarioInternos.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "ORDER BY NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Cadastro de Internos na Unidade");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_ListagemCadastroInternosActionPerformed

    private void RelatorioNaturalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioNaturalidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioNaturalidade objRelNat = new TelaRelatorioNaturalidade();
        TelaModuloCRC.jPainelCRC.add(objRelNat);
        objRelNat.show();
    }//GEN-LAST:event_RelatorioNaturalidadeActionPerformed

    private void RellatorioIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RellatorioIdadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPorIdade objIdade = new TelaRelatorioPorIdade();
        TelaModuloDiretoria.jPainelDiretoria.add(objIdade);
        objIdade.show();
    }//GEN-LAST:event_RellatorioIdadeActionPerformed

    private void RelatorioEscolaridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEscolaridadeActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioInternosEscolaridade.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "ORDER BY NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Internos por Escolaridade");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioEscolaridadeActionPerformed

    private void RelatorioArtigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioArtigoActionPerformed
        // TODO add your handling code here:
        RelatorioArtigo objRelTempPena = new RelatorioArtigo();
        TelaModuloDiretoria.jPainelDiretoria.add((objRelTempPena));
        objRelTempPena.show();
    }//GEN-LAST:event_RelatorioArtigoActionPerformed

    private void RelatorioTempoPenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioTempoPenaActionPerformed
        // TODO add your handling code here:
        RelatorioTempoPena objRelTempoPena = new RelatorioTempoPena();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelTempoPena);
        objRelTempoPena.show();
    }//GEN-LAST:event_RelatorioTempoPenaActionPerformed

    private void RelatorioEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEstadoCivilActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ListagemPronturarioInternosEstadoCivil.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "ORDER BY NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Internos Por Estado Civil");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioEstadoCivilActionPerformed

    private void RelatorioUnidadePenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioUnidadePenalActionPerformed
        // TODO add your handling code here:
        RelatorioUnidadePenal objRelUnidade = new RelatorioUnidadePenal();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelUnidade);
        objRelUnidade.show();
    }//GEN-LAST:event_RelatorioUnidadePenalActionPerformed

    private void RelatorioRegimePenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioRegimePenalActionPerformed
        // TODO add your handling code here:
        // Remodelar esse relatório com o regime e sexo dos internos. (Feito em 26/11/2014)
        try {
            conecta.abrirConexao();
            String path = "reports/ListagemPronturarioInternosRegime.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE SituacaoCrc='" + situacaoEnt + "'OR SituacaoCrc='" + situacaoRet + "'OR SituacaoCrc='" + situacaoSai + "'ORDER BY NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("situacaoEntrada", situacaoEnt);
            parametros.put("situacaoRetorno", situacaoRet);
            parametros.put("situacaoSaida", situacaoSai);
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Internos Por Regime Penal");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioRegimePenalActionPerformed

    private void RelatorioPorCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPorCidadeActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioInternosPorCidade.jasper";
            conecta.executaSQL("SELECT MatriculaCrc, NomeInternoCrc, CidadeCrc FROM PRONTUARIOSCRC WHERE SituacaoCrc='" + statusEntrada + "'OR SituacaoCrc='" + statusRetorno + "'ORDER BY CidadeCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            parametros.put("statusEntrada", statusEntrada);
            parametros.put("statusSaida", statusRetorno);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Internos por Cidade");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioPorCidadeActionPerformed

    private void RelatorioPorBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPorBairroActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioInternosPorBairro.jasper";
            conecta.executaSQL("SELECT MatriculaCrc, NomeInternoCrc, CidadeCrc,BairroCrc FROM PRONTUARIOSCRC WHERE SituacaoCrc='" + statusEntrada + "'OR SituacaoCrc='" + statusRetorno + "'ORDER BY CidadeCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            parametros.put("statusEntrada", statusEntrada);
            parametros.put("statusSaida", statusRetorno);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Internos por Cidade e Bairro");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioPorBairroActionPerformed

    private void ListagemGeralProntuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemGeralProntuariosActionPerformed
        // TODO add your handling code here:   r
        //        TelaGerarRelatorio gr = new TelaGerarRelatorio();
        //        TelaModuloCRC.jPainelCRC.add(gr);
        //        gr.show();
        try {
            conecta.abrirConexao();
            String path = "reports/ProntuariosInternosCrc.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSFISICOSINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                    + "INNER JOIN PAISES "
                    + "ON PRONTUARIOSCRC.IdPais=PAISES.IdPais "
                    + "INNER JOIN CIDADES ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN UNIDADE "
                    + "ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmho do relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Prontuário de Internos"); // Titulo do relatório
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_ListagemGeralProntuariosActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ProntuariosInternosUnidadePenalCRC.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSFISICOSINTERNOS ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                    + "INNER JOIN PAISES ON PRONTUARIOSCRC.IdPais=PAISES.IdPais INNER JOIN CIDADES ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                    + "INNER JOIN DADOSPENAISINTERNOS ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN UNIDADE ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid WHERE SituacaoCrc='" + situacaoEnt + "'OR SituacaoCrc='" + situacaoRet + "'ORDER BY NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            parametros.put("situacaoEntrada", situacaoEnt);
            parametros.put("situacaoRetorno", situacaoRet);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Prontuário de Internos na Unidade"); // Titulo do relatório
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jListagemUnidadePenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jListagemUnidadePenalActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioUnidadePenal.jasper";
            conecta.executaSQL("SELECT * FROM UNIDADE ORDER BY DescricaoUnid");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de Unidade Penal");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jListagemUnidadePenalActionPerformed

    private void ListagemInternosUnidadeEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemInternosUnidadeEntradaActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntrada = new TelaRelatorioEntradas();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelEntrada);
        objRelEntrada.show();
    }//GEN-LAST:event_ListagemInternosUnidadeEntradaActionPerformed

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

    private void RelatorioEntradaSaidaVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaVisitasActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaVisitasPortariaGeral objRelEntSai = new TelaRelatorioEntradaSaidaVisitasPortariaGeral();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelEntSai);
        objRelEntSai.show();
    }//GEN-LAST:event_RelatorioEntradaSaidaVisitasActionPerformed

    private void RelatorioIndisciplinarVisitasPortariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioIndisciplinarVisitasPortariaActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioGeralOcorrenciaIndisciplinarVisitasPortaria.jasper";
            conecta.executaSQL("SELECT * FROM REGISTRO_INDISCIPLINA_PORTARIA "
                    + "INNER JOIN OCORRENCIA_INDISCIPLINA_PORTARIA "
                    + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdReg=OCORRENCIA_INDISCIPLINA_PORTARIA.IdReg "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON OCORRENCIA_INDISCIPLINA_PORTARIA.IdVisita=VISITASINTERNO.IdVisita");
            HashMap parametros = new HashMap();
            parametros.put("nameUser", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Ocorrências Indisciplinar de Visitas - Portaria"); // Titulo do relatório
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioIndisciplinarVisitasPortariaActionPerformed

    private void RelatorioEntradaSaidaFuncDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaFuncDeptoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaColaboradorPorDepartamento objRelFuncDepto = new TelaRelatorioEntradaSaidaColaboradorPorDepartamento();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelFuncDepto);
        objRelFuncDepto.show();
    }//GEN-LAST:event_RelatorioEntradaSaidaFuncDeptoActionPerformed

    private void RelatorioEntradaSaidaColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaColaboradoresActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaColaboradoresPortaria objRelFuncPort = new TelaRelatorioEntradaSaidaColaboradoresPortaria();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelFuncPort);
        objRelFuncPort.show();
    }//GEN-LAST:event_RelatorioEntradaSaidaColaboradoresActionPerformed

    private void RelatorioVisitasDiversas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioVisitasDiversas1ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaVisitasPortariaMotivoDepartamento objRelVisitasMot = new TelaRelatorioEntradaSaidaVisitasPortariaMotivoDepartamento();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelVisitasMot);
        objRelVisitasMot.show();
    }//GEN-LAST:event_RelatorioVisitasDiversas1ActionPerformed

    private void RelatorioEntradaSaidaVisitas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaSaidaVisitas1ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaVisitasPortariaGeral objRelEntSai = new TelaRelatorioEntradaSaidaVisitasPortariaGeral();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelEntSai);
        objRelEntSai.show();
    }//GEN-LAST:event_RelatorioEntradaSaidaVisitas1ActionPerformed

    private void RelatorioVeiculosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioVeiculosUnidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradaSaidaVeiculosUnidadePenal objRelVeicUni = new TelaRelatorioEntradaSaidaVeiculosUnidadePenal();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelVeicUni);
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
        TelaModuloDiretoria.jPainelDiretoria.add(objRelVisitasInt);
        objRelVisitasInt.show();
    }//GEN-LAST:event_RelatorioEntradaSaidaVistasInternosActionPerformed

    private void RelatorioCadastroProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioCadastroProdutosActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioProdutosCadastradosPorGrupoFAR.jasper";
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC "
                    + "INNER JOIN GRUPO_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdGrupo=GRUPO_PRODUTOS_AC.IdGrupo WHERE PRODUTOS_AC.Modulo='" + modulo + "' "
                    + "ORDER BY GRUPO_PRODUTOS_AC.NomeGrupo,PRODUTOS_AC.DescricaoProd");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            parametros.put("modulo", modulo);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Produtos Cadastrados Por Grupo");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioCadastroProdutosActionPerformed

    private void RelatorioProdutosConsumoAvulsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioProdutosConsumoAvulsoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConsumoProdutosAvulsoFAR objRelConsuProdAvul = new TelaRelatorioConsumoProdutosAvulsoFAR();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelConsuProdAvul);
        objRelConsuProdAvul.show();
    }//GEN-LAST:event_RelatorioProdutosConsumoAvulsoActionPerformed

    private void RelatorioEstoqueProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEstoqueProdutosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEstoqueProdutosFAR objRelEstProd = new TelaRelatorioEstoqueProdutosFAR();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelEstProd);
        objRelEstProd.show();
    }//GEN-LAST:event_RelatorioEstoqueProdutosActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioTransferenciaEntreLocais objRelTranf = new TelaRelatorioTransferenciaEntreLocais();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelTranf);
        objRelTranf.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void ExtratoValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtratoValoresActionPerformed
        // TODO add your handling code here:
        TelaPesqDataRelExtrato objRelExtrato = new TelaPesqDataRelExtrato();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelExtrato);
        objRelExtrato.show();
    }//GEN-LAST:event_ExtratoValoresActionPerformed

    private void RelatorioAtividadeEducacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioAtividadeEducacionalActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioAtividadesEducacional.jasper";
            conecta.executaSQL("SELECT * FROM ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA "
                    + "INNER JOIN FREQUENCIA_PEDAGOGIA_EXTERNA "
                    + "ON ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA.IdFreqLab=FREQUENCIA_PEDAGOGIA_EXTERNA.IdFreqLab "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "ORDER BY PRONTUARIOSCRC.IdInternoCrc, ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA.IdItem, ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA.AnoReferencia");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório Quantitativo Atividade Educacional de Interno");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioAtividadeEducacionalActionPerformed

    private void RelatorioProdutosConsumoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioProdutosConsumoInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConsumoProdutosInternoPorData objPesqConsuProdData = new TelaRelatorioConsumoProdutosInternoPorData();
        TelaModuloDiretoria.jPainelDiretoria.add(objPesqConsuProdData);
        objPesqConsuProdData.show();
    }//GEN-LAST:event_RelatorioProdutosConsumoInternosActionPerformed

    private void RelatorioConsumoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioConsumoProdutoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConsumoProdutosInterno objPesqConsuProd = new TelaRelatorioConsumoProdutosInterno();
        TelaModuloDiretoria.jPainelDiretoria.add(objPesqConsuProd);
        objPesqConsuProd.show();
    }//GEN-LAST:event_RelatorioConsumoProdutoActionPerformed

    private void RelatorioProdutosConsumoAvulso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioProdutosConsumoAvulso1ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConsumoProdutosAvulso objRelConsuProdAvul = new TelaRelatorioConsumoProdutosAvulso();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objRelConsuProdAvul);
        objRelConsuProdAvul.show();
    }//GEN-LAST:event_RelatorioProdutosConsumoAvulso1ActionPerformed

    private void RelatorioAvulsoPorDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioAvulsoPorDepartamentoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConsumoProdutosAvulsoDepartamento objRelConsProdAvDepto = new TelaRelatorioConsumoProdutosAvulsoDepartamento();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelConsProdAvDepto);
        objRelConsProdAvDepto.show();
    }//GEN-LAST:event_RelatorioAvulsoPorDepartamentoActionPerformed

    private void RelatorioEstoqueProdutos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEstoqueProdutos1ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEstoqueProdutosAC objRelEstProd = new TelaRelatorioEstoqueProdutosAC();
        TelaModuloDiretoria.jPainelDiretoria.add(objRelEstProd);
        objRelEstProd.show();
    }//GEN-LAST:event_RelatorioEstoqueProdutos1ActionPerformed

    private void jProntuarioIndividualInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProntuarioIndividualInternoActionPerformed
        // TODO add your handling code here:
        TelaImpressaoIndividualProntuario objProntInd = new TelaImpressaoIndividualProntuario();
        TelaModuloDiretoria.jPainelDiretoria.add(objProntInd);
        objProntInd.show();
    }//GEN-LAST:event_jProntuarioIndividualInternoActionPerformed

    private void jOcorrenciaBaseDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOcorrenciaBaseDoisActionPerformed
        // TODO add your handling code here:
        if (objOcrBaseDir == null || objOcrBaseDir.isClosed()) {
            objOcrBaseDir = new TelaOcorrenciaBaseDoisDir();
            jPainelDiretoria.add(objOcrBaseDir);
            objOcrBaseDir.setVisible(true);
        } else {
            if (objOcrBaseDir.isVisible()) {
                if (objOcrBaseDir.isIcon()) { // Se esta minimizado
                    try {
                        objOcrBaseDir.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objOcrBaseDir.toFront(); // traz para frente
                    objOcrBaseDir.pack();//volta frame 
                }
            } else {
                objOcrBaseDir = new TelaOcorrenciaBaseDoisDir();
                TelaModuloDiretoria.jPainelDiretoria.add(objOcrBaseDir);//adicona frame ao JDesktopPane  
                objOcrBaseDir.setVisible(true);
            }
        }
        try {
            objOcrBaseDir.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jOcorrenciaBaseDoisActionPerformed

    private void jOcorrenciaPortariaExternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOcorrenciaPortariaExternaActionPerformed
        // TODO add your handling code here:
        if (objOcrPortExtDir == null || objOcrPortExtDir.isClosed()) {
            objOcrPortExtDir = new TelaOcorrenciaPortariaExternaDir();
            jPainelDiretoria.add(objOcrPortExtDir);
            objOcrPortExtDir.setVisible(true);
        } else {
            if (objOcrPortExtDir.isVisible()) {
                if (objOcrPortExtDir.isIcon()) { // Se esta minimizado
                    try {
                        objOcrPortExtDir.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objOcrPortExtDir.toFront(); // traz para frente
                    objOcrPortExtDir.pack();//volta frame 
                }
            } else {
                objOcrPortExtDir = new TelaOcorrenciaPortariaExternaDir();
                TelaModuloDiretoria.jPainelDiretoria.add(objOcrPortExtDir);//adicona frame ao JDesktopPane  
                objOcrPortExtDir.setVisible(true);
            }
        }
        try {
            objOcrPortExtDir.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jOcorrenciaPortariaExternaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaCompromisso;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenu Cadastro;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenuItem ExtratoValores;
    private javax.swing.JMenuItem HistoricoCrc;
    private javax.swing.JMenu HistoricosInternos;
    private javax.swing.JMenuItem ListaPassagem;
    private javax.swing.JMenuItem ListaPassagemExterna;
    private javax.swing.JMenuItem ListaPassagemInterna;
    private javax.swing.JMenuItem ListagemCadastroInternos;
    private javax.swing.JMenuItem ListagemConfere;
    private javax.swing.JMenuItem ListagemGeralProntuarios;
    private javax.swing.JMenuItem ListagemInternosUnidadeEntrada;
    private javax.swing.JMenuItem ListagemSaidasTemporaria;
    private javax.swing.JMenuItem LocalInternos;
    private javax.swing.JMenuItem MapaConfere;
    private javax.swing.JMenuItem RelProgressao;
    private javax.swing.JMenuItem RelRegressao;
    private javax.swing.JMenuItem RelatorioArtigo;
    private javax.swing.JMenuItem RelatorioAtividadeEducacional;
    private javax.swing.JMenuItem RelatorioAvulsoPorDepartamento;
    private javax.swing.JMenuItem RelatorioCadastroColaboradores;
    private javax.swing.JMenuItem RelatorioCadastroProdutos;
    private javax.swing.JMenuItem RelatorioConsumoProduto;
    private javax.swing.JMenuItem RelatorioEntradaSaidaColaboradores;
    private javax.swing.JMenuItem RelatorioEntradaSaidaFuncDepto;
    private javax.swing.JMenuItem RelatorioEntradaSaidaVeiculosCargas;
    private javax.swing.JMenuItem RelatorioEntradaSaidaVeiculosTerceiros;
    private javax.swing.JMenuItem RelatorioEntradaSaidaVisitas;
    private javax.swing.JMenuItem RelatorioEntradaSaidaVisitas1;
    private javax.swing.JMenuItem RelatorioEntradaSaidaVistasInternos;
    private javax.swing.JMenuItem RelatorioEscolaridade;
    private javax.swing.JMenuItem RelatorioEstadoCivil;
    private javax.swing.JMenuItem RelatorioEstoqueProdutos;
    private javax.swing.JMenuItem RelatorioEstoqueProdutos1;
    private javax.swing.JMenuItem RelatorioGeralPavilhaoCelas;
    private javax.swing.JMenuItem RelatorioIndisciplinarVisitasPortaria;
    private javax.swing.JMenu RelatorioInternos;
    private javax.swing.JMenu RelatorioMudancaRegime;
    private javax.swing.JMenuItem RelatorioNaturalidade;
    private javax.swing.JMenuItem RelatorioPopulacaoInternosNominal;
    private javax.swing.JMenuItem RelatorioPorBairro;
    private javax.swing.JMenuItem RelatorioPorCidade;
    private javax.swing.JMenuItem RelatorioPrevisaoSaida;
    private javax.swing.JMenuItem RelatorioPrevisaoSaidaIntNaoReal;
    private javax.swing.JMenuItem RelatorioProdutosConsumoAvulso;
    private javax.swing.JMenuItem RelatorioProdutosConsumoAvulso1;
    private javax.swing.JMenuItem RelatorioProdutosConsumoInternos;
    private javax.swing.JMenu RelatorioProntuarios;
    private javax.swing.JMenuItem RelatorioRegimePenal;
    private javax.swing.JMenuItem RelatorioRolVisitas;
    private javax.swing.JMenuItem RelatorioSaidaInternosPortaria;
    private javax.swing.JMenuItem RelatorioTempoPena;
    private javax.swing.JMenuItem RelatorioUnidadePenal;
    private javax.swing.JMenuItem RelatorioVeiculosUnidade;
    private javax.swing.JMenuItem RelatorioVisitasDiversas1;
    private javax.swing.JMenu RelatoriosSeguranca;
    private javax.swing.JMenuItem RellatorioIdade;
    private javax.swing.JMenuItem SairTelaSeguranca;
    private javax.swing.JMenuItem jCalculadoraPena;
    private javax.swing.JMenuItem jCalculadoraWindows;
    private javax.swing.JMenuItem jConsultaGerencial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jListagemUnidadePenal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jOcorrenciaBaseDois;
    private javax.swing.JMenuItem jOcorrenciaBaseUm;
    private javax.swing.JMenuItem jOcorrenciaPortaria;
    private javax.swing.JMenuItem jOcorrenciaPortariaExterna;
    private javax.swing.JMenuItem jOcorrenciaSeguranca;
    public static javax.swing.JDesktopPane jPainelDiretoria;
    private javax.swing.JMenuItem jProntuarioIndividualInterno;
    private javax.swing.JMenuItem jProntuarioInternos;
    private javax.swing.JMenuItem jRelatorioEvadidos;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator19;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator20;
    private javax.swing.JPopupMenu.Separator jSeparator21;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenu jUtilitaria;
    // End of variables declaration//GEN-END:variables

    // Verificar a cada 5 minutos se o recado foi lido (10/01/2015)
    public void threadMensagem() {
        final Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                verificarRecado(); // Verificar recados a cada 5 minutos   
                verificarAgendaCompromisso();
            }
        }, periodo, tempo);
    }

    public void calcPena() {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start calcpena.exe");
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
// Calculadora do Windows

    public void CalcWindows() {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start calc.exe");
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void verificarRecado() {
        buscarUsuario(nameUser);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDARECADOS "
                    + "WHERE IdUsuario='" + codUsuario + "'AND StatusAgenda='" + statusAgenda + "'");
            conecta.rs.first();
            if (codUsuario == conecta.rs.getInt("IdUsuario")) {
                TelaRecadosCrc objRecados = new TelaRecadosCrc();
                TelaModuloDiretoria.jPainelDiretoria.add(objRecados);
                objRecados.show();
                flag = 1;
                preencherTabelaTodosRecados("SELECT * FROM AGENDARECADOS "
                        + "INNER JOIN USUARIOS "
                        + "ON AGENDARECADOS.IdUsuario=USUARIOS.IdUsuario "
                        + "WHERE NomeUsuario='" + nameUser + "' "
                        + "AND StatusAgenda='" + statusAgenda + "'");
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
                    TelaModuloDiretoria.jPainelDiretoria.add(objAgendaComp);
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
                    TelaModuloDiretoria.jPainelDiretoria.add(objAgendaComp);
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

    public void consultaGerencial() {
        if (objBI == null || objBI.isClosed()) {
            objBI = new BusinessIntelligence();
            jPainelDiretoria.add(objBI);
            objBI.setVisible(true);
        } else {
            if (objBI.isVisible()) {
                if (objBI.isIcon()) { // Se esta minimizado
                    try {
                        objBI.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objBI.toFront(); // traz para frente
                    objBI.pack();//volta frame 
                }
            } else {
                objBI = new BusinessIntelligence();
                TelaModuloDiretoria.jPainelDiretoria.add(objBI);//adicona frame ao JDesktopPane  
                objBI.setVisible(true);
            }
        }
        try {
            objBI.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }
}
