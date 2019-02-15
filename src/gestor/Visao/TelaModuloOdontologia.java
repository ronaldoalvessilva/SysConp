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
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaRecadosOdontologia.jBtAlterar;
import static gestor.Visao.TelaRecadosOdontologia.jBtCancelar;
import static gestor.Visao.TelaRecadosOdontologia.jBtConfirmar;
import static gestor.Visao.TelaRecadosOdontologia.jBtExcluir;
import static gestor.Visao.TelaRecadosOdontologia.jBtNovo;
import static gestor.Visao.TelaRecadosOdontologia.jBtResponder;
import static gestor.Visao.TelaRecadosOdontologia.jBtSalvar;
import static gestor.Visao.TelaRecadosOdontologia.jComboBoxStatus;
import static gestor.Visao.TelaRecadosOdontologia.jDataLanc;
import static gestor.Visao.TelaRecadosOdontologia.jHoraRecado;
import static gestor.Visao.TelaRecadosOdontologia.jIDLanc;
import static gestor.Visao.TelaRecadosOdontologia.jNomeDestinatario;
import static gestor.Visao.TelaRecadosOdontologia.jNomeRementente;
import static gestor.Visao.TelaRecadosOdontologia.jRecado;
import static gestor.Visao.TelaRecadosOdontologia.jTabelaTodosRecados;
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
public class TelaModuloOdontologia extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();
    //
    private TelaConsultaLocalInternoOdontologia objLocalIntOdonto = null;
    private TelaConsultaProntuarioInternoCrc objProntInt = null;
    private TelaMovHistoricoTecOdontologia objConHistMov = null;
    private TelaAtendimentoOdontologico objAtendOdon = null;
//    private TelaAtendimentoOdontologicoTESTE objAtendOdon = null;
    private TelaRecadosOdontologia objRecOdontologia = null;
    private TelaOcorrenciaOdontologia objCorr = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaConsultaEstoqueOdontologia objConsEstoMedi = null;
    private TelaTiposProcedimentos objTipoProc = null;
    private TelaRegistroInternosAtendimentoODONTO objRegiAtendBio = null;
    private TelaRegistroInternosAtendimentoImpressoODON objRegAtendImp = null;
    //
    String dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente";
    //
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado. 
    //
    //
    int count = 0;
    // VARIÁVEIS PARA AGENDA DE COMPROMISSO.
    String dataAgenda;
    String nomeUsuarioCompromisso; // USUÁRIO DA AGENDA DE COMPROMISSO.
    String horaLembrete;
    String usuarioAgenda;
    String codigoAgendaComp;
    //
    public static int codigoUserODON = 0;
    public static int codUserAcessoODON = 0;
    public static int codigoUserGroupODON = 0;
    public static int codAbrirODON = 0;
    public static int codIncluirODON = 0;
    public static int codAlterarODON = 0;
    public static int codExcluirODON = 0;
    public static int codGravarODON = 0;
    public static int codConsultarODON = 0;
    public static int codigoGrupoODON = 0;
    public static String nomeGrupoODON = "";
    public static String nomeTelaODON = "";
    //
    public static String nomeModuloODONTOLOGIA = "ODONTOLOGIA";
    //
    public static String telaTiposProcedimentoManu_ODON = "Cadastro:Tipos de Procedimento:Manutenção";
    // ASSINATURA  INTERNO
    public static String telaRegistroBiometriaODON = "Cadastro:Registro Interno para Atendimento - Juridico:Manutenção";
    public static String telaRegistroBiometriaInciarLeitorODON = "Cadastro:Registro Interno para Atendimento - Juridico:Iniciar Leitor";
    // REGISTRO DE INTERNO IMPRESSO
    public static String telaRegistroAtenImpODON = "Cadastro:Registro de Atendimento de Internos Impresso - Juridico";
    public static String telaRegistroLibAtenImpODON = "Cadastro:Registro de Atendimento de Internos Impresso - Juridico:Liberação";
    //
    public static String telaAtendimentoInternoManu_ODON = "Movimentação:Atendimento de Internos ODONTO:Manutenção";
    public static String telaAtendimentoInternoEvolucao_ODON = "Movimentação:Evolução de Internos ODONTO:Internos";
    public static String telaAtendimentoInternosPrescricao_ODON = "Movimentação:Prescrição de Medicamentos Internos ODONTO:Prescrição";
    //
    public static String telaOcorrenciaOdontoManu = "Movimentação:Ocorrências Diárias Odontologia:Manutenção";
    //
    String pNomeTPM_ODON = "";
    // REGISTRO DE BIOMETRIA DO INTERNO - ASSINATURA DO INTERNO
    String pNomeRB_ODON = "";
    String pNomeRBIL_ODON = "";
    // REGISTRO DE ATENDIMENTO BIOMETRIA DE LIBERAÇÃO DO COLABORADOR
    String pNomeRAI_ODON = "";
    String pNomeRLAI_ODON = "";
    //
    String pNomeAIM_ODON = "";
    String pNomeAIE_ODON = "";
    String pNomeAIP_ODON = "";
    //
    String pNomeOCR_ODON = "";
    //
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO

    /**
     * Creates new form TelaOdontologia
     */
    public TelaModuloOdontologia() {
        initComponents();
        this.setSize(840, 640); // Tamanho da tela 
        pesquisarTelasAcessos();
        threadMensagem(); // A cada 5 minutos verifica mensagem 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPainelOdontologia = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jTiposProcedimentos = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        RegistroAtendimentoBiometria = new javax.swing.JMenuItem();
        RegistroAtendimentoImpresso = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromissos = new javax.swing.JMenuItem();
        AgenaRecados = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Sair = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        ConsultaInternos = new javax.swing.JMenuItem();
        LocailizacaoInternos = new javax.swing.JMenuItem();
        HistoricoMovimentacao = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        ConsultaMedicamentos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        AtendimentoOdontologico = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        Ocorrencias = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        RelatorioConfere = new javax.swing.JMenu();
        RelatorioGeralConfere = new javax.swing.JMenuItem();
        ListagemConfere = new javax.swing.JMenuItem();
        RelatorioEntradaInternosUnidade = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("...::: Odontologia :::...");

        jPainelOdontologia.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BrasaoFundo500Prata2.png"))); // NOI18N

        jPainelOdontologia.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelOdontologiaLayout = new javax.swing.GroupLayout(jPainelOdontologia);
        jPainelOdontologia.setLayout(jPainelOdontologiaLayout);
        jPainelOdontologiaLayout.setHorizontalGroup(
            jPainelOdontologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPainelOdontologiaLayout.setVerticalGroup(
            jPainelOdontologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelOdontologiaLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );

        jMenu1.setText("Cadastro");

        jTiposProcedimentos.setText("Tipos de Procedimentos");
        jTiposProcedimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTiposProcedimentosActionPerformed(evt);
            }
        });
        jMenu1.add(jTiposProcedimentos);
        jMenu1.add(jSeparator4);

        jMenu5.setForeground(new java.awt.Color(0, 102, 0));
        jMenu5.setText("Registro de Atendimento de Internos - (Biometria ou Impressão)");

        RegistroAtendimentoBiometria.setForeground(new java.awt.Color(204, 0, 0));
        RegistroAtendimentoBiometria.setText("Registrar  Atendimento por Biometria");
        RegistroAtendimentoBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroAtendimentoBiometriaActionPerformed(evt);
            }
        });
        jMenu5.add(RegistroAtendimentoBiometria);

        RegistroAtendimentoImpresso.setForeground(new java.awt.Color(0, 0, 204));
        RegistroAtendimentoImpresso.setText("Registro Atendimento por Impressão");
        RegistroAtendimentoImpresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroAtendimentoImpressoActionPerformed(evt);
            }
        });
        jMenu5.add(RegistroAtendimentoImpresso);

        jMenu1.add(jMenu5);
        jMenu1.add(jSeparator6);

        AgendaCompromissos.setText("Agenda de Compromissos Pessoal");
        AgendaCompromissos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaCompromissosActionPerformed(evt);
            }
        });
        jMenu1.add(AgendaCompromissos);

        AgenaRecados.setText("Agenda de Recados");
        AgenaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgenaRecadosActionPerformed(evt);
            }
        });
        jMenu1.add(AgenaRecados);
        jMenu1.add(jSeparator1);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        jMenu1.add(Sair);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Consultas");

        ConsultaInternos.setText("Prontuários de Internos");
        ConsultaInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaInternosActionPerformed(evt);
            }
        });
        jMenu4.add(ConsultaInternos);

        LocailizacaoInternos.setText("Localização de Internos");
        LocailizacaoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocailizacaoInternosActionPerformed(evt);
            }
        });
        jMenu4.add(LocailizacaoInternos);

        HistoricoMovimentacao.setText("Histórico de Movimentação de Internos");
        HistoricoMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoricoMovimentacaoActionPerformed(evt);
            }
        });
        jMenu4.add(HistoricoMovimentacao);
        jMenu4.add(jSeparator2);

        ConsultaMedicamentos.setText("Consulta de Estoque de Medicamentos");
        ConsultaMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaMedicamentosActionPerformed(evt);
            }
        });
        jMenu4.add(ConsultaMedicamentos);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Movimentação");

        AtendimentoOdontologico.setText("Admissão/Evolução Odontologica");
        AtendimentoOdontologico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtendimentoOdontologicoActionPerformed(evt);
            }
        });
        jMenu2.add(AtendimentoOdontologico);
        jMenu2.add(jSeparator3);

        Ocorrencias.setText("Livro de Ocorrências");
        Ocorrencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OcorrenciasActionPerformed(evt);
            }
        });
        jMenu2.add(Ocorrencias);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatórios");

        RelatorioConfere.setText("Relatório de Confere");

        RelatorioGeralConfere.setText("Relatório Geral de Internos no Pavilhão/Celas");
        RelatorioGeralConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioGeralConfereActionPerformed(evt);
            }
        });
        RelatorioConfere.add(RelatorioGeralConfere);

        ListagemConfere.setText("Listagem de Confere");
        ListagemConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemConfereActionPerformed(evt);
            }
        });
        RelatorioConfere.add(ListagemConfere);

        jMenu3.add(RelatorioConfere);

        RelatorioEntradaInternosUnidade.setText("Relatório de Entrada de Internos na Unidade");
        RelatorioEntradaInternosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaInternosUnidadeActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioEntradaInternosUnidade);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelOdontologia)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelOdontologia)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void LocailizacaoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocailizacaoInternosActionPerformed
        // TODO add your handling code here:
        if (objLocalIntOdonto == null || objLocalIntOdonto.isClosed()) {
            objLocalIntOdonto = new TelaConsultaLocalInternoOdontologia();
            jPainelOdontologia.add(objLocalIntOdonto);
            objLocalIntOdonto.setVisible(true);
        } else {
            if (objLocalIntOdonto.isVisible()) {
                if (objLocalIntOdonto.isIcon()) { // Se esta minimizado
                    try {
                        objLocalIntOdonto.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objLocalIntOdonto.toFront(); // traz para frente
                    objLocalIntOdonto.pack();//volta frame 
                }
            } else {
                objLocalIntOdonto = new TelaConsultaLocalInternoOdontologia();
                TelaModuloOdontologia.jPainelOdontologia.add(objLocalIntOdonto);//adicona frame ao JDesktopPane  
                objLocalIntOdonto.setVisible(true);
            }
        }
        try {
            objLocalIntOdonto.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_LocailizacaoInternosActionPerformed

    private void ConsultaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaInternosActionPerformed
        // TODO add your handling code here:
        if (objProntInt == null || objProntInt.isClosed()) {
            objProntInt = new TelaConsultaProntuarioInternoCrc();
            jPainelOdontologia.add(objProntInt);
            objProntInt.setVisible(true);
        } else {
            if (objProntInt.isVisible()) {
                if (objProntInt.isIcon()) { // Se esta minimizado
                    try {
                        objProntInt.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objProntInt.toFront(); // traz para frente
                    objProntInt.pack();//volta frame 
                }
            } else {
                objProntInt = new TelaConsultaProntuarioInternoCrc();
                TelaModuloOdontologia.jPainelOdontologia.add(objProntInt);//adicona frame ao JDesktopPane  
                objProntInt.setVisible(true);
            }
        }
        try {
            objProntInt.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaInternosActionPerformed

    private void HistoricoMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoricoMovimentacaoActionPerformed
        // TODO add your handling code here:
        if (objConHistMov == null || objConHistMov.isClosed()) {
            objConHistMov = new TelaMovHistoricoTecOdontologia();
            jPainelOdontologia.add(objConHistMov);
            objConHistMov.setVisible(true);
        } else {
            if (objConHistMov.isVisible()) {
                if (objConHistMov.isIcon()) { // Se esta minimizado
                    try {
                        objConHistMov.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConHistMov.toFront(); // traz para frente
                    objConHistMov.pack();//volta frame 
                }
            } else {
                objConHistMov = new TelaMovHistoricoTecOdontologia();
                TelaModuloOdontologia.jPainelOdontologia.add(objConHistMov);//adicona frame ao JDesktopPane  
                objConHistMov.setVisible(true);
            }
        }
        try {
            objConHistMov.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_HistoricoMovimentacaoActionPerformed

    private void AtendimentoOdontologicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtendimentoOdontologicoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoInternoManu_ODON);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaAtendimentoInternoManu_ODON) && codAbrirODON == 1) {
            if (objAtendOdon == null || objAtendOdon.isClosed()) {
                objAtendOdon = new TelaAtendimentoOdontologico();
//            objAtendOdon = new TelaAtendimentoOdontologicoTESTE(); // EM CONSTRUÇÃO, PARADO PARA IMPLANTAÇÃO SDR BAR (27/09/2017)
                jPainelOdontologia.add(objAtendOdon);
                objAtendOdon.setVisible(true);
            } else {
                if (objAtendOdon.isVisible()) {
                    if (objAtendOdon.isIcon()) { // Se esta minimizado
                        try {
                            objAtendOdon.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtendOdon.toFront(); // traz para frente
                        objAtendOdon.pack();//volta frame 
                    }
                } else {
                    objAtendOdon = new TelaAtendimentoOdontologico();
//                objAtendOdon = new TelaAtendimentoOdontologicoTESTE();
                    TelaModuloOdontologia.jPainelOdontologia.add(objAtendOdon);//adicona frame ao JDesktopPane  
                    objAtendOdon.setVisible(true);
                }
            }
            try {
                objAtendOdon.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AtendimentoOdontologicoActionPerformed

    private void AgenaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgenaRecadosActionPerformed
        // TODO add your handling code here:
        if (objRecOdontologia == null || objRecOdontologia.isClosed()) {
            objRecOdontologia = new TelaRecadosOdontologia();
            jPainelOdontologia.add(objRecOdontologia);
            objRecOdontologia.setVisible(true);
        } else {
            if (objRecOdontologia.isVisible()) {
                if (objRecOdontologia.isIcon()) { // Se esta minimizado
                    try {
                        objRecOdontologia.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecOdontologia.toFront(); // traz para frente
                    objRecOdontologia.pack();//volta frame 
                }
            } else {
                objRecOdontologia = new TelaRecadosOdontologia();
                TelaModuloOdontologia.jPainelOdontologia.add(objRecOdontologia);//adicona frame ao JDesktopPane  
                objRecOdontologia.setVisible(true);
            }
        }
        try {
            objRecOdontologia.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgenaRecadosActionPerformed

    private void RelatorioGeralConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioGeralConfereActionPerformed
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
    }//GEN-LAST:event_RelatorioGeralConfereActionPerformed

    private void ListagemConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemConfereActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConfere objRelConfere = new TelaRelatorioConfere();
        TelaModuloOdontologia.jPainelOdontologia.add(objRelConfere);
        objRelConfere.show();
    }//GEN-LAST:event_ListagemConfereActionPerformed

    private void OcorrenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OcorrenciasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaOdontoManu);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaOcorrenciaOdontoManu) && codAbrirODON == 1) {
            if (objCorr == null || objCorr.isClosed()) {
                objCorr = new TelaOcorrenciaOdontologia();
                jPainelOdontologia.add(objCorr);
                objCorr.setVisible(true);
            } else {
                if (objCorr.isVisible()) {
                    if (objCorr.isIcon()) { // Se esta minimizado
                        try {
                            objCorr.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objCorr.toFront(); // traz para frente
                        objCorr.pack();//volta frame 
                    }
                } else {
                    objCorr = new TelaOcorrenciaOdontologia();
                    TelaModuloOdontologia.jPainelOdontologia.add(objCorr);//adicona frame ao JDesktopPane  
                    objCorr.setVisible(true);
                }
            }
            try {
                objCorr.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_OcorrenciasActionPerformed

    private void AgendaCompromissosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissosActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelOdontologia.add(objAgEventos);
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
                TelaModuloOdontologia.jPainelOdontologia.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
//        private TelaAgendaCompromissos objAgEventos = null;
    }//GEN-LAST:event_AgendaCompromissosActionPerformed

    private void ConsultaMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaMedicamentosActionPerformed
        // TODO add your handling code here:
        if (objConsEstoMedi == null || objConsEstoMedi.isClosed()) {
            objConsEstoMedi = new TelaConsultaEstoqueOdontologia();
            jPainelOdontologia.add(objConsEstoMedi);
            objConsEstoMedi.setVisible(true);
        } else {
            if (objConsEstoMedi.isVisible()) {
                if (objConsEstoMedi.isIcon()) { // Se esta minimizado
                    try {
                        objConsEstoMedi.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsEstoMedi.toFront(); // traz para frente
                    objConsEstoMedi.pack();//volta frame 
                }
            } else {
                objConsEstoMedi = new TelaConsultaEstoqueOdontologia();
                TelaModuloOdontologia.jPainelOdontologia.add(objConsEstoMedi);//adicona frame ao JDesktopPane  
                objConsEstoMedi.setVisible(true);
            }
        }
        try {
            objConsEstoMedi.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaMedicamentosActionPerformed

    private void jTiposProcedimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTiposProcedimentosActionPerformed
        // TODO add your handling code here:telaTiposProcedimentoManu_ODON
        buscarAcessoUsuario(telaTiposProcedimentoManu_ODON);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaTiposProcedimentoManu_ODON) && codAbrirODON == 1) {
            if (objTipoProc == null || objTipoProc.isClosed()) {
                objTipoProc = new TelaTiposProcedimentos();
                jPainelOdontologia.add(objTipoProc);
                objTipoProc.setVisible(true);
            } else {
                if (objTipoProc.isVisible()) {
                    if (objTipoProc.isIcon()) { // Se esta minimizado
                        try {
                            objTipoProc.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objTipoProc.toFront(); // traz para frente
                        objTipoProc.pack();//volta frame 
                    }
                } else {
                    objTipoProc = new TelaTiposProcedimentos();
                    TelaModuloOdontologia.jPainelOdontologia.add(objTipoProc);//adicona frame ao JDesktopPane  
                    objTipoProc.setVisible(true);
                }
            }
            try {
                objTipoProc.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jTiposProcedimentosActionPerformed

    private void RelatorioEntradaInternosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaInternosUnidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntradaInter = new TelaRelatorioEntradas();
        TelaModuloOdontologia.jPainelOdontologia.add(objRelEntradaInter);
        objRelEntradaInter.show();
    }//GEN-LAST:event_RelatorioEntradaInternosUnidadeActionPerformed

    private void RegistroAtendimentoBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroAtendimentoBiometriaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroBiometriaODON);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaRegistroBiometriaODON) && codAbrirODON == 1) {
            if (objRegiAtendBio == null || objRegiAtendBio.isClosed()) {
                objRegiAtendBio = new TelaRegistroInternosAtendimentoODONTO();
                jPainelOdontologia.add(objRegiAtendBio);
                objRegiAtendBio.setVisible(true);
            } else {
                if (objRegiAtendBio.isVisible()) {
                    if (objRegiAtendBio.isIcon()) { // Se esta minimizado
                        try {
                            objRegiAtendBio.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegiAtendBio.toFront(); // traz para frente
                        objRegiAtendBio.pack();//volta frame 
                    }
                } else {
                    objRegiAtendBio = new TelaRegistroInternosAtendimentoODONTO();
                    TelaModuloOdontologia.jPainelOdontologia.add(objRegiAtendBio);//adicona frame ao JDesktopPane  
                    objRegiAtendBio.setVisible(true);
                }
            }
            try {
                objRegiAtendBio.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RegistroAtendimentoBiometriaActionPerformed

    private void RegistroAtendimentoImpressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroAtendimentoImpressoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroAtenImpODON);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoODON.equals("ADMINISTRADORES") || codigoUserODON == codUserAcessoODON && nomeTelaODON.equals(telaRegistroAtenImpODON) && codAbrirODON == 1) {
            if (objRegAtendImp == null || objRegAtendImp.isClosed()) {
                objRegAtendImp = new TelaRegistroInternosAtendimentoImpressoODON();
                jPainelOdontologia.add(objRegAtendImp);
                objRegAtendImp.setVisible(true);
            } else {
                if (objRegAtendImp.isVisible()) {
                    if (objRegAtendImp.isIcon()) { // Se esta minimizado
                        try {
                            objRegAtendImp.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegAtendImp.toFront(); // traz para frente
                        objRegAtendImp.pack();//volta frame 
                    }
                } else {
                    objRegAtendImp = new TelaRegistroInternosAtendimentoImpressoODON();
                    TelaModuloOdontologia.jPainelOdontologia.add(objRegAtendImp);//adicona frame ao JDesktopPane  
                    objRegAtendImp.setVisible(true);
                }
            }
            try {
                objRegAtendImp.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_RegistroAtendimentoImpressoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgenaRecados;
    private javax.swing.JMenuItem AgendaCompromissos;
    private javax.swing.JMenuItem AtendimentoOdontologico;
    private javax.swing.JMenuItem ConsultaInternos;
    private javax.swing.JMenuItem ConsultaMedicamentos;
    private javax.swing.JMenuItem HistoricoMovimentacao;
    private javax.swing.JMenuItem ListagemConfere;
    private javax.swing.JMenuItem LocailizacaoInternos;
    private javax.swing.JMenuItem Ocorrencias;
    private javax.swing.JMenuItem RegistroAtendimentoBiometria;
    private javax.swing.JMenuItem RegistroAtendimentoImpresso;
    private javax.swing.JMenu RelatorioConfere;
    private javax.swing.JMenuItem RelatorioEntradaInternosUnidade;
    private javax.swing.JMenuItem RelatorioGeralConfere;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JDesktopPane jPainelOdontologia;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JMenuItem jTiposProcedimentos;
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

    public void verificarRecado() {
        buscarUsuario(nameUser);
        convertedata.converter(jDataSistema.getText());
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM AGENDARECADOS WHERE IdUsuario='" + codUsuario + "' "
                        + "AND StatusAgenda='" + statusAgenda + "'");
                conecta.rs.first();
                if (codUsuario == conecta.rs.getInt("IdUsuario")) {
                    TelaRecadosCrc objRecados = new TelaRecadosCrc();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objRecados);
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
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM AGENDARECADOS WHERE IdUsuario='" + codUsuario + "' "
                        + "AND StatusAgenda='" + statusAgenda + "'");
                conecta.rs.first();
                if (codUsuario == conecta.rs.getInt("IdUsuario")) {
                    TelaRecadosCrc objRecados = new TelaRecadosCrc();
                    TelaModuloServicoSocial.jPainelServicoSocial.add(objRecados);
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
        // MENU CADASTRO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaTiposProcedimentoManu_ODON + "'");
            conecta.rs.first();
            pNomeTPM_ODON = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroBiometriaODON + "'");
            conecta.rs.first();
            pNomeRB_ODON = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroBiometriaInciarLeitorODON + "'");
            conecta.rs.first();
            pNomeRBIL_ODON = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroAtenImpODON + "'");
            conecta.rs.first();
            pNomeRAI_ODON = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroLibAtenImpODON + "'");
            conecta.rs.first();
            pNomeRLAI_ODON = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //MOVIMENTAÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendimentoInternoManu_ODON + "'");
            conecta.rs.first();
            pNomeAIM_ODON = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendimentoInternoEvolucao_ODON + "'");
            conecta.rs.first();
            pNomeAIE_ODON = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtendimentoInternosPrescricao_ODON + "'");
            conecta.rs.first();
            pNomeAIP_ODON = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaOcorrenciaOdontoManu + "'");
            conecta.rs.first();
            pNomeOCR_ODON = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // MENU CADASTRO
        if (!pNomeTPM_ODON.equals(telaTiposProcedimentoManu_ODON) || pNomeTPM_ODON == null || pNomeTPM_ODON.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaTiposProcedimentoManu_ODON);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRB_ODON.equals(telaRegistroBiometriaODON) || pNomeRB_ODON == null || pNomeRB_ODON.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroBiometriaODON);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRBIL_ODON.equals(telaRegistroBiometriaInciarLeitorODON) || pNomeRBIL_ODON == null || pNomeRBIL_ODON.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroBiometriaInciarLeitorODON);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRAI_ODON.equals(telaRegistroAtenImpODON) || pNomeRAI_ODON == null || pNomeRAI_ODON.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroAtenImpODON);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRLAI_ODON.equals(telaRegistroLibAtenImpODON) || pNomeRLAI_ODON == null || pNomeRLAI_ODON.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroLibAtenImpODON);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //MOVIMENTAÇÃO
        if (!pNomeAIM_ODON.equals(telaAtendimentoInternoManu_ODON) || pNomeAIM_ODON == null || pNomeAIM_ODON.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendimentoInternoManu_ODON);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAIE_ODON.equals(telaAtendimentoInternoEvolucao_ODON) || pNomeAIE_ODON == null || pNomeAIE_ODON.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendimentoInternoEvolucao_ODON);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAIP_ODON.equals(telaAtendimentoInternosPrescricao_ODON) || pNomeAIP_ODON == null || pNomeAIP_ODON.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtendimentoInternosPrescricao_ODON);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeOCR_ODON.equals(telaOcorrenciaOdontoManu) || pNomeOCR_ODON == null || pNomeOCR_ODON.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaOcorrenciaOdontoManu);
            controle.incluirTelaAcesso(objCadastroTela);
        }
    }

    // MÉTODO PARA BUSCAR O CÓDIGO DO MÓDULO, CASO NÃO TENHA SIDO CADASTRADO.
    public void buscarCodigoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + nomeModuloODONTOLOGIA + "'");
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
            codigoUserODON = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserODON + "'");
            conecta.rs.first();
            codigoUserGroupODON = conecta.rs.getInt("IdUsuario");
            codigoGrupoODON = conecta.rs.getInt("IdGrupo");
            nomeGrupoODON = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserODON + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoODON = conecta.rs.getInt("IdUsuario");
            codAbrirODON = conecta.rs.getInt("Abrir");
            codIncluirODON = conecta.rs.getInt("Incluir");
            codAlterarODON = conecta.rs.getInt("Alterar");
            codExcluirODON = conecta.rs.getInt("Excluir");
            codGravarODON = conecta.rs.getInt("Gravar");
            codConsultarODON = conecta.rs.getInt("Consultar");
            nomeTelaODON = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
