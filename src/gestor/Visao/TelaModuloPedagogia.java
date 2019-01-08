/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

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
import static gestor.Visao.TelaRecadosProfessores.jBtAlterar;
import static gestor.Visao.TelaRecadosProfessores.jBtCancelar;
import static gestor.Visao.TelaRecadosProfessores.jBtConfirmar;
import static gestor.Visao.TelaRecadosProfessores.jBtExcluir;
import static gestor.Visao.TelaRecadosProfessores.jBtNovo;
import static gestor.Visao.TelaRecadosProfessores.jBtResponder;
import static gestor.Visao.TelaRecadosProfessores.jBtSalvar;
import static gestor.Visao.TelaRecadosProfessores.jComboBoxStatus;
import static gestor.Visao.TelaRecadosProfessores.jDataLanc;
import static gestor.Visao.TelaRecadosProfessores.jHoraRecado;
import static gestor.Visao.TelaRecadosProfessores.jIDLanc;
import static gestor.Visao.TelaRecadosProfessores.jNomeDestinatario;
import static gestor.Visao.TelaRecadosProfessores.jNomeRementente;
import static gestor.Visao.TelaRecadosProfessores.jRecado;
import static gestor.Visao.TelaRecadosProfessores.jTabelaTodosRecados;
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
public class TelaModuloPedagogia extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    private TelaRecadosProfessores objRecados = null;
    private TelaConsultaLocalInternoProfessores objConsultaLocalInterProf = null;
    private TelaConsultaProntuarioInternoCrc objConsultaInterProf = null;
    private TelaInstituicaoEnsino objInst = null;
    private TelaSalaAula objSalaAula = null;
    private TelaProfessores objProf = null;
    private TelaDisciplina objDisciplia = null;
    private TelaCursosDiversos objCursos = null;
    private TelaTarefasEducativas objTarefasDiv = null;
    private TelaTurnosAula objTurnos = null;
    private TelaCargaHoraria objCHora = null;
    private TelaTempoFormativo objTempo = null;
    private TelaOcorrenciaPedagogia objOcorr = null;
    private TelaMatriculaPedagogica objMat = null;
    private TelaControleFrequencia objFreq = null;
    private TelaBaixaAlunos objBaixaAlunos = null;
    private TelaAssistenciaEducacionalExterna objAssiEduExt = null;
    private TelaEditorasInstituicao objEditorIns = null;
    private TelaCategoriaLivros objCatLivros = null;
    private TelaAutoresLivros objAutor = null;
    private TelaLivrosRevistasJornais objLivros = null;
    private TelaLocalEstoqueAcervo objEstoqueAcervo = null;
    private TelaInventarioLivrosAcervo objInventAcervo = null;
    private TelaCompraLivros objCompLivro = null;
    private TelaFornecedorAcervo objFornAcervo = null;
    private TelaReservaAcervo objReservaAcervo = null;
    private TelaEmprestimoAcervo objEmprestimoAcer = null;
    private TelaDevolucaoAcervo objDevolucaoAcervo = null;
    private TelaConsultaAcervo objConsultaAcervo = null;
    private TelaFrequenciaMensalInternosEducacao objFreqEduca = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private AdmissaoEvolucaoPedagogica objAdmEvoPedagoga = null;
    private TelaAgendamentoAtendimentoInternosPedagogia objAgendaAtendIntPED = null;
    private TelaAtualizacaoDocumentosPedagogia objAtualizaEsco = null;
    //
    int flag;
    int codUsuario;
    String statusAgenda = "Pendente";
    String dataLanc;
    //
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado.  
    int count = 0;
    // VARIÁVEIS PARA AGENDA DE COMPROMISSO.
    String dataAgenda;
    String nomeUsuarioCompromisso; // USUÁRIO DA AGENDA DE COMPROMISSO.
    String horaLembrete;
    String usuarioAgenda;
    String codigoAgendaComp;

    /**
     * Creates new form TelaPedagogia
     */
    public TelaModuloPedagogia() {
        initComponents();
        this.setSize(840, 640); // Tamanho da tela 
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

        jPainelPedagogia = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Cadastros = new javax.swing.JMenu();
        InstituicaoEnsino = new javax.swing.JMenuItem();
        SalaAula = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        Disciplinas = new javax.swing.JMenuItem();
        Professores = new javax.swing.JMenuItem();
        CursosDiversos = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        TurmasAulas = new javax.swing.JMenuItem();
        CargaHoraria = new javax.swing.JMenuItem();
        jTempoFormativo = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jAgendaAtendimentoInternos = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromissoPessoal = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        Sair = new javax.swing.JMenuItem();
        Acervo = new javax.swing.JMenu();
        EditorasInstituicoes = new javax.swing.JMenuItem();
        CategoriasLivros = new javax.swing.JMenuItem();
        Autores = new javax.swing.JMenuItem();
        LocalArmazenamento = new javax.swing.JMenuItem();
        Livros = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        InventarioAcervo = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        FornecedorAcervo = new javax.swing.JMenuItem();
        Compras = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MovimentacaoAcervo = new javax.swing.JMenu();
        ReservaLivros = new javax.swing.JMenuItem();
        Emprestimos = new javax.swing.JMenuItem();
        Devolucoes = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        ConsultaAcervos = new javax.swing.JMenuItem();
        Consultas = new javax.swing.JMenu();
        ProntuariosInternos = new javax.swing.JMenuItem();
        LocalizacaoInternos = new javax.swing.JMenuItem();
        Movimentacao = new javax.swing.JMenu();
        AdmissaoEvolucaoPedagogica = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        Matriculas = new javax.swing.JMenuItem();
        ControleFrequencia = new javax.swing.JMenuItem();
        BaixaAlunos = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        AtualizarEscolaridadeInterno = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        ControleDiasHoras = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        AssistenciaEducacionalExterna = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        LivroOcorrencias = new javax.swing.JMenuItem();
        Relatorios = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        RelatorioInternosMatriculados = new javax.swing.JMenuItem();
        RelatorioFrequenciaInternos = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        RelatorioPrevisaoSaidaInternos = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        RelatorioAtividadeEducacional = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        RelatorioEntradaInternosUnidade = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        RelatorioConfere = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("...::: Controle Pedagogia :::...");

        jPainelPedagogia.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BrasaoFundo500Prata2.png"))); // NOI18N

        jPainelPedagogia.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelPedagogiaLayout = new javax.swing.GroupLayout(jPainelPedagogia);
        jPainelPedagogia.setLayout(jPainelPedagogiaLayout);
        jPainelPedagogiaLayout.setHorizontalGroup(
            jPainelPedagogiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPainelPedagogiaLayout.setVerticalGroup(
            jPainelPedagogiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelPedagogiaLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 61, Short.MAX_VALUE))
        );

        Cadastros.setText("Cadastro");

        InstituicaoEnsino.setText("Instituição de Ensino");
        InstituicaoEnsino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstituicaoEnsinoActionPerformed(evt);
            }
        });
        Cadastros.add(InstituicaoEnsino);

        SalaAula.setText("Salas de Aula");
        SalaAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaAulaActionPerformed(evt);
            }
        });
        Cadastros.add(SalaAula);
        Cadastros.add(jSeparator2);

        Disciplinas.setText("Disciplinas");
        Disciplinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisciplinasActionPerformed(evt);
            }
        });
        Cadastros.add(Disciplinas);

        Professores.setText("Professores");
        Professores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfessoresActionPerformed(evt);
            }
        });
        Cadastros.add(Professores);

        CursosDiversos.setText("Cursos Diversos");
        CursosDiversos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CursosDiversosActionPerformed(evt);
            }
        });
        Cadastros.add(CursosDiversos);

        jMenuItem3.setText("Tarefas Educativa");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Cadastros.add(jMenuItem3);
        Cadastros.add(jSeparator3);

        TurmasAulas.setText("Turnos de Aulas");
        TurmasAulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TurmasAulasActionPerformed(evt);
            }
        });
        Cadastros.add(TurmasAulas);

        CargaHoraria.setText("Carga Horária");
        CargaHoraria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargaHorariaActionPerformed(evt);
            }
        });
        Cadastros.add(CargaHoraria);

        jTempoFormativo.setText("Tempo Formativo - Série/Ano");
        jTempoFormativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTempoFormativoActionPerformed(evt);
            }
        });
        Cadastros.add(jTempoFormativo);
        Cadastros.add(jSeparator4);

        jAgendaAtendimentoInternos.setText("Agenda de Atendimento de Internos");
        jAgendaAtendimentoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgendaAtendimentoInternosActionPerformed(evt);
            }
        });
        Cadastros.add(jAgendaAtendimentoInternos);
        Cadastros.add(jSeparator14);

        AgendaCompromissoPessoal.setText("Agenda de Compromissos Pessoal");
        AgendaCompromissoPessoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaCompromissoPessoalActionPerformed(evt);
            }
        });
        Cadastros.add(AgendaCompromissoPessoal);

        AgendaRecados.setText("Agenda de Recados");
        AgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaRecadosActionPerformed(evt);
            }
        });
        Cadastros.add(AgendaRecados);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        Cadastros.add(Sair);

        jMenuBar1.add(Cadastros);

        Acervo.setText("Acervo da Biblioteca");

        EditorasInstituicoes.setText("Editoras e Instituições");
        EditorasInstituicoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditorasInstituicoesActionPerformed(evt);
            }
        });
        Acervo.add(EditorasInstituicoes);

        CategoriasLivros.setText("Categoria de Livros/Revistas/Jonais/Filmes/Música");
        CategoriasLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriasLivrosActionPerformed(evt);
            }
        });
        Acervo.add(CategoriasLivros);

        Autores.setText("Autores");
        Autores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutoresActionPerformed(evt);
            }
        });
        Acervo.add(Autores);

        LocalArmazenamento.setText("Local de Armazenamento - Prateleiras");
        LocalArmazenamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalArmazenamentoActionPerformed(evt);
            }
        });
        Acervo.add(LocalArmazenamento);

        Livros.setText("Livros/Revistas/Jornais/Filmes/Músicas");
        Livros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LivrosActionPerformed(evt);
            }
        });
        Acervo.add(Livros);
        Acervo.add(jSeparator5);

        InventarioAcervo.setText("Inventário de Acervos");
        InventarioAcervo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventarioAcervoActionPerformed(evt);
            }
        });
        Acervo.add(InventarioAcervo);
        Acervo.add(jSeparator6);

        FornecedorAcervo.setText("Fornecedores de Acervo");
        FornecedorAcervo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FornecedorAcervoActionPerformed(evt);
            }
        });
        Acervo.add(FornecedorAcervo);

        Compras.setText("Compras/Doação de Livros/Revistas/Jornais e Outros");
        Compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprasActionPerformed(evt);
            }
        });
        Acervo.add(Compras);
        Acervo.add(jSeparator1);

        MovimentacaoAcervo.setText("Movimentação");

        ReservaLivros.setText("Reserva de Acervos");
        ReservaLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservaLivrosActionPerformed(evt);
            }
        });
        MovimentacaoAcervo.add(ReservaLivros);

        Emprestimos.setText("Empréstimos de Acervos");
        Emprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmprestimosActionPerformed(evt);
            }
        });
        MovimentacaoAcervo.add(Emprestimos);

        Devolucoes.setText("Devoluções de Acervos");
        Devolucoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DevolucoesActionPerformed(evt);
            }
        });
        MovimentacaoAcervo.add(Devolucoes);

        Acervo.add(MovimentacaoAcervo);
        Acervo.add(jSeparator9);

        ConsultaAcervos.setText("Consulta de Estoque de Acervos");
        ConsultaAcervos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaAcervosActionPerformed(evt);
            }
        });
        Acervo.add(ConsultaAcervos);

        jMenuBar1.add(Acervo);

        Consultas.setText("Consultas");

        ProntuariosInternos.setText("Prontuários de Internos");
        ProntuariosInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProntuariosInternosActionPerformed(evt);
            }
        });
        Consultas.add(ProntuariosInternos);

        LocalizacaoInternos.setText("Localização dos Internos");
        LocalizacaoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalizacaoInternosActionPerformed(evt);
            }
        });
        Consultas.add(LocalizacaoInternos);

        jMenuBar1.add(Consultas);

        Movimentacao.setText("Movimentação");

        AdmissaoEvolucaoPedagogica.setText("Admissão/Evolução Pedagógica");
        AdmissaoEvolucaoPedagogica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmissaoEvolucaoPedagogicaActionPerformed(evt);
            }
        });
        Movimentacao.add(AdmissaoEvolucaoPedagogica);
        Movimentacao.add(jSeparator13);

        Matriculas.setText("Controle de Matriculas");
        Matriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatriculasActionPerformed(evt);
            }
        });
        Movimentacao.add(Matriculas);

        ControleFrequencia.setText("Controle de Frequências");
        ControleFrequencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControleFrequenciaActionPerformed(evt);
            }
        });
        Movimentacao.add(ControleFrequencia);

        BaixaAlunos.setText("Baixa de Alunos - (Internos)");
        BaixaAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaixaAlunosActionPerformed(evt);
            }
        });
        Movimentacao.add(BaixaAlunos);
        Movimentacao.add(jSeparator16);

        AtualizarEscolaridadeInterno.setText("Atualizar Escolaridade de Interno");
        AtualizarEscolaridadeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarEscolaridadeInternoActionPerformed(evt);
            }
        });
        Movimentacao.add(AtualizarEscolaridadeInterno);
        Movimentacao.add(jSeparator10);

        ControleDiasHoras.setText("Controle de Dias/Horas Educação Internos");
        ControleDiasHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControleDiasHorasActionPerformed(evt);
            }
        });
        Movimentacao.add(ControleDiasHoras);
        Movimentacao.add(jSeparator8);

        AssistenciaEducacionalExterna.setText("Assistência Educacional Externa");
        AssistenciaEducacionalExterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssistenciaEducacionalExternaActionPerformed(evt);
            }
        });
        Movimentacao.add(AssistenciaEducacionalExterna);
        Movimentacao.add(jSeparator7);

        LivroOcorrencias.setText("Livro de Ocorrências");
        LivroOcorrencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LivroOcorrenciasActionPerformed(evt);
            }
        });
        Movimentacao.add(LivroOcorrencias);

        jMenuBar1.add(Movimentacao);

        Relatorios.setText("Relatórios");

        jMenu1.setText("Relatórios de Acervos");
        Relatorios.add(jMenu1);

        RelatorioInternosMatriculados.setText("Relatório de Internos Matriculados");
        Relatorios.add(RelatorioInternosMatriculados);

        RelatorioFrequenciaInternos.setText("Relatório de Frequências de Internos - SINALE");
        Relatorios.add(RelatorioFrequenciaInternos);
        Relatorios.add(jSeparator12);

        jMenuItem1.setText("Relatório Saída de Internos por Beneficio");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Relatorios.add(jMenuItem1);

        RelatorioPrevisaoSaidaInternos.setText("Relatório de Previsão de Saída de Internos");
        RelatorioPrevisaoSaidaInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioPrevisaoSaidaInternosActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioPrevisaoSaidaInternos);
        Relatorios.add(jSeparator11);

        RelatorioAtividadeEducacional.setText("Relatório Quantitativo de Atividade Educacional");
        RelatorioAtividadeEducacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioAtividadeEducacionalActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioAtividadeEducacional);
        Relatorios.add(jSeparator15);

        RelatorioEntradaInternosUnidade.setText("Relatório de Entrada de Internos na Unidade");
        RelatorioEntradaInternosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaInternosUnidadeActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioEntradaInternosUnidade);
        Relatorios.add(jSeparator17);

        jMenu2.setText("Relatorios de Confere");

        jMenuItem2.setText("Relatório Geral de Internos no Pavilhão/Celas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        RelatorioConfere.setText("Relatório de Confere");
        RelatorioConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioConfereActionPerformed(evt);
            }
        });
        jMenu2.add(RelatorioConfere);

        Relatorios.add(jMenu2);

        jMenuBar1.add(Relatorios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelPedagogia)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelPedagogia)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void ProntuariosInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProntuariosInternosActionPerformed
        // TODO add your handling code here:
        if (objConsultaInterProf == null || objConsultaInterProf.isClosed()) {
            objConsultaInterProf = new TelaConsultaProntuarioInternoCrc();
            TelaModuloPedagogia.jPainelPedagogia.add(objConsultaInterProf);
            objConsultaInterProf.setVisible(true);
        } else {
            if (objConsultaInterProf.isVisible()) {
                if (objConsultaInterProf.isIcon()) { // Se esta minimizado
                    try {
                        objConsultaInterProf.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsultaInterProf.toFront(); // traz para frente
                    objConsultaInterProf.pack();//volta frame 
                }
            } else {
                objConsultaInterProf = new TelaConsultaProntuarioInternoCrc();
                TelaModuloPedagogia.jPainelPedagogia.add(objConsultaInterProf);//adicona frame ao JDesktopPane  
                objConsultaInterProf.setVisible(true);
            }
        }
        try {
            objConsultaInterProf.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ProntuariosInternosActionPerformed

    private void LocalizacaoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalizacaoInternosActionPerformed
        // TODO add your handling code here:
        if (objConsultaLocalInterProf == null || objConsultaLocalInterProf.isClosed()) {
            objConsultaLocalInterProf = new TelaConsultaLocalInternoProfessores();
            TelaModuloPedagogia.jPainelPedagogia.add(objConsultaLocalInterProf);
            objConsultaLocalInterProf.setVisible(true);
        } else {
            if (objConsultaLocalInterProf.isVisible()) {
                if (objConsultaLocalInterProf.isIcon()) { // Se esta minimizado
                    try {
                        objConsultaLocalInterProf.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsultaLocalInterProf.toFront(); // traz para frente
                    objConsultaLocalInterProf.pack();//volta frame 
                }
            } else {
                objConsultaLocalInterProf = new TelaConsultaLocalInternoProfessores();
                TelaModuloPedagogia.jPainelPedagogia.add(objConsultaLocalInterProf);//adicona frame ao JDesktopPane  
                objConsultaLocalInterProf.setVisible(true);
            }
        }
        try {
            objConsultaLocalInterProf.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_LocalizacaoInternosActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:       
        if (objRecados == null || objRecados.isClosed()) {
            objRecados = new TelaRecadosProfessores();
            TelaModuloPedagogia.jPainelPedagogia.add(objRecados);
            objRecados.setVisible(true);
        } else {
            if (objRecados.isVisible()) {
                if (objRecados.isIcon()) { // Se esta minimizado
                    try {
                        objRecados.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecados.toFront(); // traz para frente
                    objRecados.pack();//volta frame 
                }
            } else {
                objRecados = new TelaRecadosProfessores();
                TelaModuloPedagogia.jPainelPedagogia.add(objRecados);//adicona frame ao JDesktopPane  
                objRecados.setVisible(true);
            }
        }
        try {
            objRecados.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaRecadosActionPerformed

    private void LivroOcorrenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LivroOcorrenciasActionPerformed
        // TODO add your handling code here:
        if (objOcorr == null || objOcorr.isClosed()) {
            objOcorr = new TelaOcorrenciaPedagogia();
            TelaModuloPedagogia.jPainelPedagogia.add(objOcorr);
            objOcorr.setVisible(true);
        } else {
            if (objOcorr.isVisible()) {
                if (objOcorr.isIcon()) { // Se esta minimizado
                    try {
                        objOcorr.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objOcorr.toFront(); // traz para frente
                    objOcorr.pack();//volta frame 
                }
            } else {
                objOcorr = new TelaOcorrenciaPedagogia();
                TelaModuloPedagogia.jPainelPedagogia.add(objOcorr);//adicona frame ao JDesktopPane  
                objOcorr.setVisible(true);
            }
        }
        try {
            objOcorr.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_LivroOcorrenciasActionPerformed

    private void jTempoFormativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTempoFormativoActionPerformed
        // TODO add your handling code here:
        if (objTempo == null || objTempo.isClosed()) {
            objTempo = new TelaTempoFormativo();
            TelaModuloPedagogia.jPainelPedagogia.add(objTempo);
            objTempo.setVisible(true);
        } else {
            if (objTempo.isVisible()) {
                if (objTempo.isIcon()) { // Se esta minimizado
                    try {
                        objTempo.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objTempo.toFront(); // traz para frente
                    objTempo.pack();//volta frame 
                }
            } else {
                objTempo = new TelaTempoFormativo();
                TelaModuloPedagogia.jPainelPedagogia.add(objTempo);//adicona frame ao JDesktopPane  
                objTempo.setVisible(true);
            }
        }
        try {
            objTempo.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jTempoFormativoActionPerformed

    private void InstituicaoEnsinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstituicaoEnsinoActionPerformed
        // TODO add your handling code here:
        if (objInst == null || objInst.isClosed()) {
            objInst = new TelaInstituicaoEnsino();
            TelaModuloPedagogia.jPainelPedagogia.add(objInst);
            objInst.setVisible(true);
        } else {
            if (objInst.isVisible()) {
                if (objInst.isIcon()) { // Se esta minimizado
                    try {
                        objInst.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objInst.toFront(); // traz para frente
                    objInst.pack();//volta frame 
                }
            } else {
                objInst = new TelaInstituicaoEnsino();
                TelaModuloPedagogia.jPainelPedagogia.add(objInst);//adicona frame ao JDesktopPane  
                objInst.setVisible(true);
            }
        }
        try {
            objInst.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_InstituicaoEnsinoActionPerformed

    private void SalaAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaAulaActionPerformed
        // TODO add your handling code here:
        if (objSalaAula == null || objSalaAula.isClosed()) {
            objSalaAula = new TelaSalaAula();
            TelaModuloPedagogia.jPainelPedagogia.add(objSalaAula);
            objSalaAula.setVisible(true);
        } else {
            if (objSalaAula.isVisible()) {
                if (objSalaAula.isIcon()) { // Se esta minimizado
                    try {
                        objSalaAula.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objSalaAula.toFront(); // traz para frente
                    objSalaAula.pack();//volta frame 
                }
            } else {
                objSalaAula = new TelaSalaAula();
                TelaModuloPedagogia.jPainelPedagogia.add(objSalaAula);//adicona frame ao JDesktopPane  
                objSalaAula.setVisible(true);
            }
        }
        try {
            objSalaAula.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_SalaAulaActionPerformed

    private void ProfessoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfessoresActionPerformed
        // TODO add your handling code here:
        if (objProf == null || objProf.isClosed()) {
            objProf = new TelaProfessores();
            TelaModuloPedagogia.jPainelPedagogia.add(objProf);
            objProf.setVisible(true);
        } else {
            if (objProf.isVisible()) {
                if (objProf.isIcon()) { // Se esta minimizado
                    try {
                        objProf.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objProf.toFront(); // traz para frente
                    objProf.pack();//volta frame 
                }
            } else {
                objProf = new TelaProfessores();
                TelaModuloPedagogia.jPainelPedagogia.add(objProf);//adicona frame ao JDesktopPane  
                objProf.setVisible(true);
            }
        }
        try {
            objProf.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ProfessoresActionPerformed

    private void DisciplinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisciplinasActionPerformed
        // TODO add your handling code here:
        if (objDisciplia == null || objDisciplia.isClosed()) {
            objDisciplia = new TelaDisciplina();
            TelaModuloPedagogia.jPainelPedagogia.add(objDisciplia);
            objDisciplia.setVisible(true);
        } else {
            if (objDisciplia.isVisible()) {
                if (objDisciplia.isIcon()) { // Se esta minimizado
                    try {
                        objDisciplia.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objDisciplia.toFront(); // traz para frente
                    objDisciplia.pack();//volta frame 
                }
            } else {
                objDisciplia = new TelaDisciplina();
                TelaModuloPedagogia.jPainelPedagogia.add(objDisciplia);//adicona frame ao JDesktopPane  
                objDisciplia.setVisible(true);
            }
        }
        try {
            objDisciplia.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_DisciplinasActionPerformed

    private void CursosDiversosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CursosDiversosActionPerformed
        // TODO add your handling code here:
        if (objCursos == null || objCursos.isClosed()) {
            objCursos = new TelaCursosDiversos();
            TelaModuloPedagogia.jPainelPedagogia.add(objCursos);
            objCursos.setVisible(true);
        } else {
            if (objCursos.isVisible()) {
                if (objCursos.isIcon()) { // Se esta minimizado
                    try {
                        objCursos.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objCursos.toFront(); // traz para frente
                    objCursos.pack();//volta frame 
                }
            } else {
                objCursos = new TelaCursosDiversos();
                TelaModuloPedagogia.jPainelPedagogia.add(objCursos);//adicona frame ao JDesktopPane  
                objCursos.setVisible(true);
            }
        }
        try {
            objCursos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_CursosDiversosActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if (objTarefasDiv == null || objTarefasDiv.isClosed()) {
            objTarefasDiv = new TelaTarefasEducativas();
            TelaModuloPedagogia.jPainelPedagogia.add(objTarefasDiv);
            objTarefasDiv.setVisible(true);
        } else {
            if (objTarefasDiv.isVisible()) {
                if (objTarefasDiv.isIcon()) { // Se esta minimizado
                    try {
                        objTarefasDiv.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objTarefasDiv.toFront(); // traz para frente
                    objTarefasDiv.pack();//volta frame 
                }
            } else {
                objTarefasDiv = new TelaTarefasEducativas();
                TelaModuloPedagogia.jPainelPedagogia.add(objTarefasDiv);//adicona frame ao JDesktopPane  
                objTarefasDiv.setVisible(true);
            }
        }
        try {
            objTarefasDiv.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void TurmasAulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TurmasAulasActionPerformed
        // TODO add your handling code here:
        if (objTurnos == null || objTurnos.isClosed()) {
            objTurnos = new TelaTurnosAula();
            TelaModuloPedagogia.jPainelPedagogia.add(objTurnos);
            objTurnos.setVisible(true);
        } else {
            if (objTurnos.isVisible()) {
                if (objTurnos.isIcon()) { // Se esta minimizado
                    try {
                        objTurnos.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objTurnos.toFront(); // traz para frente
                    objTurnos.pack();//volta frame 
                }
            } else {
                objTurnos = new TelaTurnosAula();
                TelaModuloPedagogia.jPainelPedagogia.add(objTurnos);//adicona frame ao JDesktopPane  
                objTurnos.setVisible(true);
            }
        }
        try {
            objTurnos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_TurmasAulasActionPerformed

    private void CargaHorariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargaHorariaActionPerformed
        // TODO add your handling code here:
        if (objCHora == null || objCHora.isClosed()) {
            objCHora = new TelaCargaHoraria();
            TelaModuloPedagogia.jPainelPedagogia.add(objCHora);
            objCHora.setVisible(true);
        } else {
            if (objCHora.isVisible()) {
                if (objCHora.isIcon()) { // Se esta minimizado
                    try {
                        objCHora.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objCHora.toFront(); // traz para frente
                    objCHora.pack();//volta frame 
                }
            } else {
                objCHora = new TelaCargaHoraria();
                TelaModuloPedagogia.jPainelPedagogia.add(objCHora);//adicona frame ao JDesktopPane  
                objCHora.setVisible(true);
            }
        }
        try {
            objCHora.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_CargaHorariaActionPerformed

    private void MatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatriculasActionPerformed
        // TODO add your handling code here:
        if (objMat == null || objMat.isClosed()) {
            objMat = new TelaMatriculaPedagogica();
            TelaModuloPedagogia.jPainelPedagogia.add(objMat);
            objMat.setVisible(true);
        } else {
            if (objMat.isVisible()) {
                if (objMat.isIcon()) { // Se esta minimizado
                    try {
                        objMat.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objMat.toFront(); // traz para frente
                    objMat.pack();//volta frame 
                }
            } else {
                objMat = new TelaMatriculaPedagogica();
                TelaModuloPedagogia.jPainelPedagogia.add(objMat);//adicona frame ao JDesktopPane  
                objMat.setVisible(true);
            }
        }
        try {
            objMat.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_MatriculasActionPerformed

    private void ControleFrequenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControleFrequenciaActionPerformed
        // TODO add your handling code here:
        if (objFreq == null || objFreq.isClosed()) {
            objFreq = new TelaControleFrequencia();
            TelaModuloPedagogia.jPainelPedagogia.add(objFreq);
            objFreq.setVisible(true);
        } else {
            if (objFreq.isVisible()) {
                if (objFreq.isIcon()) { // Se esta minimizado
                    try {
                        objFreq.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objFreq.toFront(); // traz para frente
                    objFreq.pack();//volta frame 
                }
            } else {
                objFreq = new TelaControleFrequencia();
                TelaModuloPedagogia.jPainelPedagogia.add(objFreq);//adicona frame ao JDesktopPane  
                objFreq.setVisible(true);
            }
        }
        try {
            objFreq.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ControleFrequenciaActionPerformed

    private void RelatorioPrevisaoSaidaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioPrevisaoSaidaInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPrevisaoSaidaDiversasTerapia objRelPrevSaiInt = new TelaRelatorioPrevisaoSaidaDiversasTerapia();
        TelaModuloPedagogia.jPainelPedagogia.add(objRelPrevSaiInt);
        objRelPrevSaiInt.show();
    }//GEN-LAST:event_RelatorioPrevisaoSaidaInternosActionPerformed

    private void BaixaAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaixaAlunosActionPerformed
        // TODO add your handling code here:
        if (objBaixaAlunos == null || objBaixaAlunos.isClosed()) {
            objBaixaAlunos = new TelaBaixaAlunos();
            TelaModuloPedagogia.jPainelPedagogia.add(objBaixaAlunos);
            objBaixaAlunos.setVisible(true);
        } else {
            if (objBaixaAlunos.isVisible()) {
                if (objBaixaAlunos.isIcon()) { // Se esta minimizado
                    try {
                        objBaixaAlunos.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objBaixaAlunos.toFront(); // traz para frente
                    objBaixaAlunos.pack();//volta frame 
                }
            } else {
                objBaixaAlunos = new TelaBaixaAlunos();
                TelaModuloPedagogia.jPainelPedagogia.add(objBaixaAlunos);//adicona frame ao JDesktopPane  
                objBaixaAlunos.setVisible(true);
            }
        }
        try {
            objBaixaAlunos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_BaixaAlunosActionPerformed

    private void AssistenciaEducacionalExternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssistenciaEducacionalExternaActionPerformed
        // TODO add your handling code here:
        if (objAssiEduExt == null || objAssiEduExt.isClosed()) {
            objAssiEduExt = new TelaAssistenciaEducacionalExterna();
            TelaModuloPedagogia.jPainelPedagogia.add(objAssiEduExt);
            objAssiEduExt.setVisible(true);
        } else {
            if (objAssiEduExt.isVisible()) {
                if (objAssiEduExt.isIcon()) { // Se esta minimizado
                    try {
                        objAssiEduExt.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objAssiEduExt.toFront(); // traz para frente
                    objAssiEduExt.pack();//volta frame 
                }
            } else {
                objAssiEduExt = new TelaAssistenciaEducacionalExterna();
                TelaModuloPedagogia.jPainelPedagogia.add(objAssiEduExt);//adicona frame ao JDesktopPane  
                objAssiEduExt.setVisible(true);
            }
        }
        try {
            objAssiEduExt.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AssistenciaEducacionalExternaActionPerformed

    private void EditorasInstituicoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditorasInstituicoesActionPerformed
        // TODO add your handling code here:
        if (objEditorIns == null || objEditorIns.isClosed()) {
            objEditorIns = new TelaEditorasInstituicao();
            TelaModuloPedagogia.jPainelPedagogia.add(objEditorIns);
            objEditorIns.setVisible(true);
        } else {
            if (objEditorIns.isVisible()) {
                if (objEditorIns.isIcon()) { // Se esta minimizado
                    try {
                        objEditorIns.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objEditorIns.toFront(); // traz para frente
                    objEditorIns.pack();//volta frame 
                }
            } else {
                objEditorIns = new TelaEditorasInstituicao();
                TelaModuloPedagogia.jPainelPedagogia.add(objEditorIns);//adicona frame ao JDesktopPane  
                objEditorIns.setVisible(true);
            }
        }
        try {
            objEditorIns.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_EditorasInstituicoesActionPerformed

    private void CategoriasLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriasLivrosActionPerformed
        // TODO add your handling code here:
        if (objCatLivros == null || objCatLivros.isClosed()) {
            objCatLivros = new TelaCategoriaLivros();
            TelaModuloPedagogia.jPainelPedagogia.add(objCatLivros);
            objCatLivros.setVisible(true);
        } else {
            if (objCatLivros.isVisible()) {
                if (objCatLivros.isIcon()) { // Se esta minimizado
                    try {
                        objCatLivros.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objCatLivros.toFront(); // traz para frente
                    objCatLivros.pack();//volta frame 
                }
            } else {
                objCatLivros = new TelaCategoriaLivros();
                TelaModuloPedagogia.jPainelPedagogia.add(objCatLivros);//adicona frame ao JDesktopPane  
                objCatLivros.setVisible(true);
            }
        }
        try {
            objCatLivros.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_CategoriasLivrosActionPerformed

    private void AutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutoresActionPerformed
        // TODO add your handling code here:
        if (objAutor == null || objAutor.isClosed()) {
            objAutor = new TelaAutoresLivros();
            TelaModuloPedagogia.jPainelPedagogia.add(objAutor);
            objAutor.setVisible(true);
        } else {
            if (objAutor.isVisible()) {
                if (objAutor.isIcon()) { // Se esta minimizado
                    try {
                        objAutor.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objAutor.toFront(); // traz para frente
                    objAutor.pack();//volta frame 
                }
            } else {
                objAutor = new TelaAutoresLivros();
                TelaModuloPedagogia.jPainelPedagogia.add(objAutor);//adicona frame ao JDesktopPane  
                objAutor.setVisible(true);
            }
        }
        try {
            objAutor.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AutoresActionPerformed

    private void LivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LivrosActionPerformed
        // TODO add your handling code here:
        if (objLivros == null || objLivros.isClosed()) {
            objLivros = new TelaLivrosRevistasJornais();
            TelaModuloPedagogia.jPainelPedagogia.add(objLivros);
            objLivros.setVisible(true);
        } else {
            if (objLivros.isVisible()) {
                if (objLivros.isIcon()) { // Se esta minimizado
                    try {
                        objLivros.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objLivros.toFront(); // traz para frente
                    objLivros.pack();//volta frame 
                }
            } else {
                objLivros = new TelaLivrosRevistasJornais();
                TelaModuloPedagogia.jPainelPedagogia.add(objLivros);//adicona frame ao JDesktopPane  
                objLivros.setVisible(true);
            }
        }
        try {
            objLivros.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_LivrosActionPerformed

    private void LocalArmazenamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalArmazenamentoActionPerformed
        // TODO add your handling code here:
        if (objEstoqueAcervo == null || objEstoqueAcervo.isClosed()) {
            objEstoqueAcervo = new TelaLocalEstoqueAcervo();
            TelaModuloPedagogia.jPainelPedagogia.add(objEstoqueAcervo);
            objEstoqueAcervo.setVisible(true);
        } else {
            if (objEstoqueAcervo.isVisible()) {
                if (objEstoqueAcervo.isIcon()) { // Se esta minimizado
                    try {
                        objEstoqueAcervo.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objEstoqueAcervo.toFront(); // traz para frente
                    objEstoqueAcervo.pack();//volta frame 
                }
            } else {
                objEstoqueAcervo = new TelaLocalEstoqueAcervo();
                TelaModuloPedagogia.jPainelPedagogia.add(objEstoqueAcervo);//adicona frame ao JDesktopPane  
                objEstoqueAcervo.setVisible(true);
            }
        }
        try {
            objEstoqueAcervo.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_LocalArmazenamentoActionPerformed

    private void InventarioAcervoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventarioAcervoActionPerformed
        // TODO add your handling code here:
        if (objInventAcervo == null || objInventAcervo.isClosed()) {
            objInventAcervo = new TelaInventarioLivrosAcervo();
            TelaModuloPedagogia.jPainelPedagogia.add(objInventAcervo);
            objInventAcervo.setVisible(true);
        } else {
            if (objInventAcervo.isVisible()) {
                if (objInventAcervo.isIcon()) { // Se esta minimizado
                    try {
                        objInventAcervo.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objInventAcervo.toFront(); // traz para frente
                    objInventAcervo.pack();//volta frame 
                }
            } else {
                objInventAcervo = new TelaInventarioLivrosAcervo();
                TelaModuloPedagogia.jPainelPedagogia.add(objInventAcervo);//adicona frame ao JDesktopPane  
                objInventAcervo.setVisible(true);
            }
        }
        try {
            objInventAcervo.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_InventarioAcervoActionPerformed

    private void ComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprasActionPerformed
        // TODO add your handling code here:
        if (objCompLivro == null || objCompLivro.isClosed()) {
            objCompLivro = new TelaCompraLivros();
            TelaModuloPedagogia.jPainelPedagogia.add(objCompLivro);
            objCompLivro.setVisible(true);
        } else {
            if (objCompLivro.isVisible()) {
                if (objCompLivro.isIcon()) { // Se esta minimizado
                    try {
                        objCompLivro.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objCompLivro.toFront(); // traz para frente
                    objCompLivro.pack();//volta frame 
                }
            } else {
                objCompLivro = new TelaCompraLivros();
                TelaModuloPedagogia.jPainelPedagogia.add(objCompLivro);//adicona frame ao JDesktopPane  
                objCompLivro.setVisible(true);
            }
        }
        try {
            objCompLivro.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ComprasActionPerformed

    private void FornecedorAcervoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FornecedorAcervoActionPerformed
        // TODO add your handling code here:
        if (objFornAcervo == null || objFornAcervo.isClosed()) {
            objFornAcervo = new TelaFornecedorAcervo();
            TelaModuloPedagogia.jPainelPedagogia.add(objFornAcervo);
            objFornAcervo.setVisible(true);
        } else {
            if (objFornAcervo.isVisible()) {
                if (objFornAcervo.isIcon()) { // Se esta minimizado
                    try {
                        objFornAcervo.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objFornAcervo.toFront(); // traz para frente
                    objFornAcervo.pack();//volta frame 
                }
            } else {
                objFornAcervo = new TelaFornecedorAcervo();
                TelaModuloPedagogia.jPainelPedagogia.add(objFornAcervo);//adicona frame ao JDesktopPane  
                objFornAcervo.setVisible(true);
            }
        }
        try {
            objFornAcervo.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_FornecedorAcervoActionPerformed

    private void ReservaLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservaLivrosActionPerformed
        // TODO add your handling code here:
        if (objReservaAcervo == null || objReservaAcervo.isClosed()) {
            objReservaAcervo = new TelaReservaAcervo();
            TelaModuloPedagogia.jPainelPedagogia.add(objReservaAcervo);
            objReservaAcervo.setVisible(true);
        } else {
            if (objReservaAcervo.isVisible()) {
                if (objReservaAcervo.isIcon()) { // Se esta minimizado
                    try {
                        objReservaAcervo.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objReservaAcervo.toFront(); // traz para frente
                    objReservaAcervo.pack();//volta frame 
                }
            } else {
                objReservaAcervo = new TelaReservaAcervo();
                TelaModuloPedagogia.jPainelPedagogia.add(objReservaAcervo);//adicona frame ao JDesktopPane  
                objReservaAcervo.setVisible(true);
            }
        }
        try {
            objReservaAcervo.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ReservaLivrosActionPerformed

    private void EmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmprestimosActionPerformed
        // TODO add your handling code here:
        if (objEmprestimoAcer == null || objEmprestimoAcer.isClosed()) {
            objEmprestimoAcer = new TelaEmprestimoAcervo();
            TelaModuloPedagogia.jPainelPedagogia.add(objEmprestimoAcer);
            objEmprestimoAcer.setVisible(true);
        } else {
            if (objEmprestimoAcer.isVisible()) {
                if (objEmprestimoAcer.isIcon()) { // Se esta minimizado
                    try {
                        objEmprestimoAcer.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objEmprestimoAcer.toFront(); // traz para frente
                    objEmprestimoAcer.pack();//volta frame 
                }
            } else {
                objEmprestimoAcer = new TelaEmprestimoAcervo();
                TelaModuloPedagogia.jPainelPedagogia.add(objEmprestimoAcer);//adicona frame ao JDesktopPane  
                objEmprestimoAcer.setVisible(true);
            }
        }
        try {
            objEmprestimoAcer.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_EmprestimosActionPerformed

    private void DevolucoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DevolucoesActionPerformed
        // TODO add your handling code here:
        if (objDevolucaoAcervo == null || objDevolucaoAcervo.isClosed()) {
            objDevolucaoAcervo = new TelaDevolucaoAcervo();
            TelaModuloPedagogia.jPainelPedagogia.add(objDevolucaoAcervo);
            objDevolucaoAcervo.setVisible(true);
        } else {
            if (objDevolucaoAcervo.isVisible()) {
                if (objDevolucaoAcervo.isIcon()) { // Se esta minimizado
                    try {
                        objDevolucaoAcervo.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objDevolucaoAcervo.toFront(); // traz para frente
                    objDevolucaoAcervo.pack();//volta frame 
                }
            } else {
                objDevolucaoAcervo = new TelaDevolucaoAcervo();
                TelaModuloPedagogia.jPainelPedagogia.add(objDevolucaoAcervo);//adicona frame ao JDesktopPane  
                objDevolucaoAcervo.setVisible(true);
            }
        }
        try {
            objDevolucaoAcervo.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_DevolucoesActionPerformed

    private void ConsultaAcervosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaAcervosActionPerformed
        // TODO add your handling code here:
        if (objConsultaAcervo == null || objConsultaAcervo.isClosed()) {
            objConsultaAcervo = new TelaConsultaAcervo();
            TelaModuloPedagogia.jPainelPedagogia.add(objConsultaAcervo);
            objConsultaAcervo.setVisible(true);
        } else {
            if (objConsultaAcervo.isVisible()) {
                if (objConsultaAcervo.isIcon()) { // Se esta minimizado
                    try {
                        objConsultaAcervo.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsultaAcervo.toFront(); // traz para frente
                    objConsultaAcervo.pack();//volta frame 
                }
            } else {
                objConsultaAcervo = new TelaConsultaAcervo();
                TelaModuloPedagogia.jPainelPedagogia.add(objConsultaAcervo);//adicona frame ao JDesktopPane  
                objConsultaAcervo.setVisible(true);
            }
        }
        try {
            objConsultaAcervo.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaAcervosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:       
        TelaRelatorioSaidaInternosPorData objRelaSaidaPort = new TelaRelatorioSaidaInternosPorData();
        TelaModuloPedagogia.jPainelPedagogia.add(objRelaSaidaPort);
        objRelaSaidaPort.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void ControleDiasHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControleDiasHorasActionPerformed
        // TODO add your handling code here:
        if (objFreqEduca == null || objFreqEduca.isClosed()) {
            objFreqEduca = new TelaFrequenciaMensalInternosEducacao();
            TelaModuloPedagogia.jPainelPedagogia.add(objFreqEduca);
            objFreqEduca.setVisible(true);
        } else {
            if (objFreqEduca.isVisible()) {
                if (objFreqEduca.isIcon()) { // Se esta minimizado
                    try {
                        objFreqEduca.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objFreqEduca.toFront(); // traz para frente
                    objFreqEduca.pack();//volta frame 
                }
            } else {
                objFreqEduca = new TelaFrequenciaMensalInternosEducacao();
                TelaModuloPedagogia.jPainelPedagogia.add(objFreqEduca);//adicona frame ao JDesktopPane  
                objFreqEduca.setVisible(true);
            }
        }
        try {
            objFreqEduca.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
//        private TelaFrequenciaMensalInternosEducacao objFreqEduca = null;
    }//GEN-LAST:event_ControleDiasHorasActionPerformed

    private void AgendaCompromissoPessoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissoPessoalActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelPedagogia.add(objAgEventos);
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
                TelaModuloPedagogia.jPainelPedagogia.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissoPessoalActionPerformed

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

    private void AdmissaoEvolucaoPedagogicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmissaoEvolucaoPedagogicaActionPerformed
        // TODO add your handling code here:
        if (objAdmEvoPedagoga == null || objAdmEvoPedagoga.isClosed()) {
            objAdmEvoPedagoga = new AdmissaoEvolucaoPedagogica();
            jPainelPedagogia.add(objAdmEvoPedagoga);
            objAdmEvoPedagoga.setVisible(true);
        } else {
            if (objAdmEvoPedagoga.isVisible()) {
                if (objAdmEvoPedagoga.isIcon()) { // Se esta minimizado
                    try {
                        objAdmEvoPedagoga.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objAdmEvoPedagoga.toFront(); // traz para frente
                    objAdmEvoPedagoga.pack();//volta frame 
                }
            } else {
                objAdmEvoPedagoga = new AdmissaoEvolucaoPedagogica();
                TelaModuloPedagogia.jPainelPedagogia.add(objAdmEvoPedagoga);//adicona frame ao JDesktopPane  
                objAdmEvoPedagoga.setVisible(true);
            }
        }
        try {
            objAdmEvoPedagoga.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AdmissaoEvolucaoPedagogicaActionPerformed

    private void jAgendaAtendimentoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgendaAtendimentoInternosActionPerformed
        // TODO add your handling code here:
        if (objAgendaAtendIntPED == null || objAgendaAtendIntPED.isClosed()) {
            objAgendaAtendIntPED = new TelaAgendamentoAtendimentoInternosPedagogia();
            jPainelPedagogia.add(objAgendaAtendIntPED);
            objAgendaAtendIntPED.setVisible(true);
        } else {
            if (objAgendaAtendIntPED.isVisible()) {
                if (objAgendaAtendIntPED.isIcon()) { // Se esta minimizado
                    try {
                        objAgendaAtendIntPED.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objAgendaAtendIntPED.toFront(); // traz para frente
                    objAgendaAtendIntPED.pack();//volta frame 
                }
            } else {
                objAgendaAtendIntPED = new TelaAgendamentoAtendimentoInternosPedagogia();
                TelaModuloPedagogia.jPainelPedagogia.add(objAgendaAtendIntPED);//adicona frame ao JDesktopPane  
                objAgendaAtendIntPED.setVisible(true);
            }
        }
        try {
            objAgendaAtendIntPED.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jAgendaAtendimentoInternosActionPerformed

    private void RelatorioEntradaInternosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaInternosUnidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntradaInter = new TelaRelatorioEntradas();
        TelaModuloPedagogia.jPainelPedagogia.add(objRelEntradaInter);
        objRelEntradaInter.show();
    }//GEN-LAST:event_RelatorioEntradaInternosUnidadeActionPerformed

    private void AtualizarEscolaridadeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarEscolaridadeInternoActionPerformed
        // TODO add your handling code here:
        if (objAtualizaEsco == null || objAtualizaEsco.isClosed()) {
            objAtualizaEsco = new TelaAtualizacaoDocumentosPedagogia();
            jPainelPedagogia.add(objAtualizaEsco);
            objAtualizaEsco.setVisible(true);
        } else {
            if (objAtualizaEsco.isVisible()) {
                if (objAtualizaEsco.isIcon()) { // Se esta minimizado
                    try {
                        objAtualizaEsco.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objAtualizaEsco.toFront(); // traz para frente
                    objAtualizaEsco.pack();//volta frame 
                }
            } else {
                objAtualizaEsco = new TelaAtualizacaoDocumentosPedagogia();
                TelaModuloPedagogia.jPainelPedagogia.add(objAtualizaEsco);//adicona frame ao JDesktopPane  
                objAtualizaEsco.setVisible(true);
            }
        }
        try {
            objAtualizaEsco.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AtualizarEscolaridadeInternoActionPerformed

    private void RelatorioConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioConfereActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConfere objRelConfPeda = new TelaRelatorioConfere();
        TelaModuloPedagogia.jPainelPedagogia.add(objRelConfPeda);
        objRelConfPeda.show();
    }//GEN-LAST:event_RelatorioConfereActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
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
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Acervo;
    private javax.swing.JMenuItem AdmissaoEvolucaoPedagogica;
    private javax.swing.JMenuItem AgendaCompromissoPessoal;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenuItem AssistenciaEducacionalExterna;
    private javax.swing.JMenuItem AtualizarEscolaridadeInterno;
    private javax.swing.JMenuItem Autores;
    private javax.swing.JMenuItem BaixaAlunos;
    private javax.swing.JMenu Cadastros;
    private javax.swing.JMenuItem CargaHoraria;
    private javax.swing.JMenuItem CategoriasLivros;
    private javax.swing.JMenuItem Compras;
    private javax.swing.JMenuItem ConsultaAcervos;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenuItem ControleDiasHoras;
    private javax.swing.JMenuItem ControleFrequencia;
    private javax.swing.JMenuItem CursosDiversos;
    private javax.swing.JMenuItem Devolucoes;
    private javax.swing.JMenuItem Disciplinas;
    private javax.swing.JMenuItem EditorasInstituicoes;
    private javax.swing.JMenuItem Emprestimos;
    private javax.swing.JMenuItem FornecedorAcervo;
    private javax.swing.JMenuItem InstituicaoEnsino;
    private javax.swing.JMenuItem InventarioAcervo;
    private javax.swing.JMenuItem LivroOcorrencias;
    private javax.swing.JMenuItem Livros;
    private javax.swing.JMenuItem LocalArmazenamento;
    private javax.swing.JMenuItem LocalizacaoInternos;
    private javax.swing.JMenuItem Matriculas;
    private javax.swing.JMenu Movimentacao;
    private javax.swing.JMenu MovimentacaoAcervo;
    private javax.swing.JMenuItem Professores;
    private javax.swing.JMenuItem ProntuariosInternos;
    private javax.swing.JMenuItem RelatorioAtividadeEducacional;
    private javax.swing.JMenuItem RelatorioConfere;
    private javax.swing.JMenuItem RelatorioEntradaInternosUnidade;
    private javax.swing.JMenuItem RelatorioFrequenciaInternos;
    private javax.swing.JMenuItem RelatorioInternosMatriculados;
    private javax.swing.JMenuItem RelatorioPrevisaoSaidaInternos;
    private javax.swing.JMenu Relatorios;
    private javax.swing.JMenuItem ReservaLivros;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JMenuItem SalaAula;
    private javax.swing.JMenuItem TurmasAulas;
    private javax.swing.JMenuItem jAgendaAtendimentoInternos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    public static javax.swing.JDesktopPane jPainelPedagogia;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuItem jTempoFormativo;
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
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDARECADOS WHERE IdUsuario='" + codUsuario + "'AND StatusAgenda='" + statusAgenda + "'");
            conecta.rs.first();
            if (codUsuario == conecta.rs.getInt("IdUsuario")) {
                // Abrir uma úica tela, funcionando
                if (objRecados == null || objRecados.isClosed()) {
                    objRecados = new TelaRecadosProfessores();
                    TelaModuloPedagogia.jPainelPedagogia.add(objRecados);
                    objRecados.setVisible(true);
                } else {
                    if (objRecados.isVisible()) {
                        if (objRecados.isIcon()) { // Se esta minimizado
                            try {
                                objRecados.setIcon(false); // maximiniza
                            } catch (PropertyVetoException ex) {
                            }
                        } else {
                            objRecados.toFront(); // traz para frente
                            objRecados.pack();//volta frame 
                        }
                    } else {
                        objRecados = new TelaRecadosProfessores();
                        TelaModuloPedagogia.jPainelPedagogia.add(objRecados);//adicona frame ao JDesktopPane  
                        objRecados.setVisible(true);
                    }
                }
                try {
                    objRecados.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                }
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
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDA_COMPROMISSOS WHERE UsuarioAgenda='" + nameUser + "'AND StatusAgenda='" + statusAgenda + "'AND DataLembrete='" + jDataSistema.getText() + "'AND HoraLembrete<='" + jHoraSistema.getText().toString() + "'");
            conecta.rs.first();
            horaLembrete = conecta.rs.getString("HoraLembrete");
            usuarioAgenda = conecta.rs.getString("UsuarioAgenda");
            codigoAgendaComp = conecta.rs.getString("IdAgenda");
            //
            if (nomeUsuarioCompromisso.equals(usuarioAgenda)) {
                TelaAgendaCompromissos objAgendaComp = new TelaAgendaCompromissos();
                TelaModuloPedagogia.jPainelPedagogia.add(objAgendaComp);
                objAgendaComp.show();
                flag = 1;
                preencherTabelaAgendaCompromisso("SELECT * FROM AGENDA_COMPROMISSOS "
                        + "WHERE AGENDA_COMPROMISSOS.UsuarioAgenda='" + nameUser + "'AND AGENDA_COMPROMISSOS.StatusAgenda='" + statusAgenda + "'AND DataLembrete='" + jDataSistema.getText() + "'AND HoraLembrete<='" + jHoraSistema.getText().toString() + "'AND IdAgenda='" + codigoAgendaComp + "'");
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
}
