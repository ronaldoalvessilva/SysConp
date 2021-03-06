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
import gestor.Controle.ControleImplementacoes;
import gestor.Modelo.CadastroTelasSistema;
import gestor.Modelo.ParametrosCrc;
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
    CadastroTelasSistema objCadastroTela = new CadastroTelasSistema();
    ControleTelasSistema controle = new ControleTelasSistema();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();
    //
    ParametrosCrc objParCrc = new ParametrosCrc();
    ControleImplementacoes controlImp = new ControleImplementacoes();
    //
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
    private TelaRegistroInternosAtendimentoPEDA objRegistroAtendBio = null;
    private TelaRegistroInternosAtendimentoImpressoPEDA objRegistroImpBio = null;
//    private TelaIndicadoresAcompanhamento objIndAcomp = null;
    private TelaRegistroLivroResenhaInterno objRegistroResenha = null;
    private TelaAtualizarMatriculaPedagogia objAtualizarMat = null;
    private TelaMovHistoricoTecPedagogia objConHistMov = null;
    private TelaCancelamentoAtendimentoPSP objCancelaAtend = null;
    private TelaCCAC_TPS objCCAC_TPS = null;
    private TelaControleFrequenciaCursosAC_PEDAGOGIA objControleCAC = null;
    private TelaAtendimentoGrupoPE objAtendPed = null;
    private TelaAtividadesEducacaoFisica objAtividadePlan = null;
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
    //
    public static int codigoUserPEDA = 0;
    public static int codUserAcessoPEDA = 0;
    public static int codigoUserGroupPEDA = 0;
    public static int codAbrirPEDA = 0;
    public static int codIncluirPEDA = 0;
    public static int codAlterarPEDA = 0;
    public static int codExcluirPEDA = 0;
    public static int codGravarPEDA = 0;
    public static int codConsultarPEDA = 0;
    public static int codigoGrupoPEDA = 0;
    public static String nomeGrupoPEDA = "";
    public static String nomeTelaPEDA = "";
    // TELAS DE ACESSOS AO MÓDULO PEDAGOGIA
    public static String nomeModuloPEDA = "PEDAGOGIA";
    // MENU CADASTRO   
    //INSTITUIÇÃO DE ENSINO
    public static String telaInstituicaoEnsinoManu_PEDA = "Cadastro:Instituição de Ensino:Manutenção";
    //SALA DE AULA
    public static String telaSalaAulaManu_PEDA = "Cadastro:Sala de Aula:Manutenção";
    //DISCIPLINA
    public static String telaDisciplinasManu_PEDA = "Cadastro:Disciplinas:Manutenção";
    //PROFESSORES
    public static String telaProfessoresManu_PEDA = "Cadastro:Professores:Manutenção";
    public static String telaProfessoresDD_PEDA = "Cadastro:Professores:Dados da Disciplinas";
    //CURSOS DIVERSOS
    public static String telaCursosDiversosManu_PEDA = "Cadastro:Cursos Diversos:Manutenção";
    //TAREFAS EDUCATIVAS
    public static String telaTarefasEducativasManu_PEDA = "Cadastro:Tarefas Educativas:Manutenção";
    //TURNOS DE AULAS
    public static String telaTurnosAulaManu_PEDA = "Cadastro:Turnos das Aulas:Manutenção";
    //CARGA HORÁRIA
    public static String telaCargaHorariaManu_PEDA = "Cadastro:Carga Horária:Manutenção";
    //TEMPO FORMATIVO
    public static String telaTempoFormativoManu_PEDA = "Cadastro:Tempo Formativo:Manutenção";
    public static String telaTempoFormativoDisc_PEDA = "Cadastro:Tempo Formativo:Disciplina";
    //AGENDA DE ATENDIMENTO AOS INTERNOS
    public static String telaAgendamentoAtendimentoInternos_PEDA = "Cadastro:Agendamento Atendimento a Internos:Manutenção";
    //ATENDIMENTO BIOMETRIA DE INTERNOS
    public static String telaRegistroAtendimentoBio_PEDA = "Cadastro:Registro de Atendimento Internos Biometria Pedagogia:Manutenção";
    public static String telaRegistroAtendimentoImpressaoBio_PEDA = "Cadastro:Registro de Autorização Impressa Pedagogia:Liberação";
    public static String telaCancelAtendInterno_PEDA = "Cadastro:Cancelamento Assinatura Interno/Impressão - PED:Manutenção";
    //PLANEJAMENTO EM GRUPO
    public static String telaPlanejamentoAtividadesManu_PEDA = "Cadastro:Planejamento Atividades em Grupo - PE:Manutenção";
    //ACERVO DA BIBLIOTECA
    //EDITORA
    public static String telaEditoraManu_PEDA = "Acervo:Editora e Instituições:Manutenção";
    //CATEGORIA
    public static String telaCategoriaManu_PEDA = "Acervo:Categoria:Manuteção";
    //AUTORES
    public static String telaAutoresManu_PEDA = "Acervo:Autores:Manutenção";
    //LOCAL DE ARMAZENAMENTO
    public static String telaLocalArmazenaManu_PEDA = "Acervo:Local de Armazenamento:Manutenção";
    //LIVROS E REVISTAS
    public static String telaLivrosRevistaManu_PEDA = "Acervo:Livros e Revistas:Manutenção";
    public static String telaLivrosRevistaImag_PEDA = "Acervo:Livros e Revistas:Imagens";
    public static String telaLivrosRevistaAuto_PEDA = "Acervo:Livros e Revistas:Autores";
    //INVENTARIO
    public static String telaInventarioManu_PEDA = "Acervo:Inventário de Estoque:Manutenção";
    public static String telaInventarioCont_PEDA = "Acervo:Inventário de Estoque:Contagem";
    public static String telaInventarioEfe_PEDA = "Acervo:Inventário de Estoque:Efetivar Inventário";
    //FORNECEDORES
    public static String telaFornecedoresManu_PEDA = "Acervo:Fornecedores de Livros e Revistas";
    //COMPRAS
    public static String telaComprasManu_PEDA = "Acervo:Compras de Livros e Revistas:Manutenção";
    public static String telaComprasProd_PEDA = "Acervo:Compras de Livros e Revistas:Produtos";
    //RESERVAS
    public static String telaReservasManu_PEDA = "Acervo:Reserva de Livros e Revistas:Manutenção";
    public static String telaReservasProd_PEDA = "Acervo:Reserva de Livros e Revistas:Produtos";
    //EMPRESTIMOS
    public static String telaEmprestimosManu_PEDA = "Acervo:Emprestimo de Livros e Revistas:Manutenção";
    public static String telaEmprestimosProd_PEDA = "Acervo:Emprestimo de Livros e Revistas:Produtos";
    //DEVOLUÇÃO
    public static String telaDevolucaoManu_PEDA = "Acervo:Devolução de Livros e Revistas:Manutenção";
    public static String telaDevolucaoProd_PEDA = "Acervo:Devolução de Livros e Revistas:Produtos";
    //MOVIMENTAÇÃO
    //ADMISSÃO E EVOLUÇÃO
    public static String telaAdmissaoManu_PEDA = "Movimentação:Admissão Pedagogica:Manutenção";
    public static String telaAdmissaoFami_PEDA = "Movimentação:Admissão Pedagogica:Familia";
    public static String telaAdmissaoSoci_PEDA = "Movimentação:Admissão Pedagogica:Socializaçao";
    public static String telaAdmissaoFemi_PEDA = "Movimentação:Admissão Pedagogica:Feminino";
    public static String telaEvolucao_PEDA = "Movimentação:Admissão Pedagogica:Evolução";
    //CONTROLE DE MATRICULAS
    public static String telaControleMatriculaManu_PEDA = "Movimentação:Controle de Matriculas Pedagogica:Manutenção";
    public static String telaControleMatriculaInte_PEDA = "Movimentação:Controle de Matriculas Pedagogica:Internos";
    //CONTROLE DE FREQUENCIA
    public static String telaControleFrequenciaManu_PEDA = "Movimentação:Controle de Frequencia Pedagogica:Manutenção";
    public static String telaControleFrequenciaInte_PEDA = "Movimentação:Controle de Frequencia Pedagogica:Internos";
    public static String telaControleFrequenciaPrin_PEDA = "Movimentação:Controle de Frequencia Pedagogica:Impressão";
    //BAIXA DE ALUNOS(INTERNOS)
    public static String telaBaixaAlunosManu_PEDA = "Movimentação:Baixa de Alunos:Manutenção";
    public static String telaBaixaAlunosInte_PEDA = "Movimentação:Baixa de Alunos:Internos";
    //ATUALIZAÇÃO DE ESCOLARIDADE
    public static String telaAtualizacaoEscolaridadeManu_PEDA = "Movimentação:Atualização de Escolaridade:Manutenção";
    //FREQUENCIA DIARIA E MENSAL DE ESCOLARIDADE
    public static String telaControleDiasManu_PEDA = "Movimentação:Frequência Mensal Externa de Internos - Pedagogia:Manutenção";
    public static String telaControleDiasOInte_PEDA = "Movimentação:Frequência Mensal Externa de Internos - Pedagogia:Internos";
    //ASSISTENCIA EDUCACIONAL EXTERNA
    public static String telaAssistenciaEducaManu_PEDA = "Movimentação:Assistência Educacional Externa:Manutenção";
    public static String telaAssistenciaEducaInte_PEDA = "Movimentação:Assistência Educacional Externa:Internos";
    //LIVRO DE OCORRÊNCIAS
    public static String telaLivroOcorrenciaManu_PEDA = "Movimentação:Livro de Ocorrência - Pedagogia:Manutenção";
    //
    public static String telaIndAcompanhaManuPEDA = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/PE:Manutenção";
    public static String telaIndAcompanhaAbaEPEDA = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/PE:Enfermaria";
    public static String telaIndAcompanhaAbaPPEDA = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/PE:Pedagogia";
    public static String telaIndAcompanhaAbaCPEDA = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/PE:Juridico/CRC";
    public static String telaIndAcompanhaAbaTPEDA = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/PE:TO";
    public static String telaIndAcompanhaAbaPSIPEDA = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/PE:Psicologia";
    public static String telaIndAcompanhaAbaSPEDA = "Movimentação:Programa de Indicadores de Acompanhamento - PRORES/PE:Serviço Social";
    //
    public static String telaRegistroResenhaPEDA = "Movimentação:Registro de Leitura de Livros e Resenha de Internos:";
    //
    public static String telaAtualizarMaticuliaPEDA = "Movimentação:Controle de Matricula:Concluir Matricula";
    //CONTROLE DE CURSOS E ATIVIDADES COMPLEMENTARES (FREQUENCIAS)
    public static String telaCCAC_TPS_ManuPEDA = "Movimentação:Controle de Cursos e Atividades Complementares-PE:Manutenção";
    public static String telaCCAC_TPS_partPEDA = "Movimentação:Controle de Cursos e Atividades Complementares-PE:Participantes";
    //
    public static String telaFCCAC_TPS_ManuPEDA = "Movimentação:Controle de Frequência de Cursos e Atividades Complementares:Manutenção";
    public static String telaFCCAC_TPS_partPEDA = "Movimentação:Controle de Frequência de Cursos e Atividades Complementares:Participantes";
    //
    public static String telaIndAtendimentoGrupoPE_Manu = "Movimentação:Atendimento Internos em Grupo - PE:Mamnutenção";
    public static String telaIndAtendimentoGrupoPE_Plan = "Movimentação:Atendimento Internos em Grupo - PE:Planejamento";
    public static String telaIndAtendimentoGrupoPE_Inte = "Movimentação:Atendimento Internos em Grupo - PE:Internos";
    public static String telaIndAtendimentoGrupoPE_AVG = "Movimentação:Atendimento Internos em Grupo - PE:Avaliação em Grupo";
    public static String telaIndAtendimentoGrupoPE_AVI = "Movimentação:Atendimento Internos em Grupo - PE:Avaliação Individual";
    public static String botaoEncerrar_PE = "Movimentação:Atendimento Internos em Grupo - PE:Botao Encerrar";
    public static String botaoLiberar_PE = "Movimentação:Atendimento Internos em Grupo - PE:Botão Liberar";
    //
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO
    // VARIÁVEIS PARA CONTROLE DE CADASTRO DAS TELAS NA TABELA TELAS.
    // MENU CADASTRO
    //INSTITUIÇÃO DE ENSINO
    String pNomeIEM_PEDA = "";
    //SALA DE AULA
    String pNomeSAM_PEDA = "";
    //DISCIPLINA
    String pNomeDISM_PEDA = "";
    //PROFESSORES
    String pNomePROFM_PEDA = "";
    String pNomePFDD_PEDA = "";
    //CURSOS DIVERSOS
    String pNomeCDM_PEDA = "";
    //TAREFAS EDUCATIVAS
    String pNomeTEM_PEDA = "";
    //TURNOS DE AULAS
    String pNomeTAM_PEDA = "";
    //CARGA HORÁRIA
    String pNomeCHM_PEDA = "";
    //TEMPO FORMATIVO
    String pNomeTFM_PEDA = "";
    String pNomeTFD_PEDA = "";
    // BIOMETRIA INTERNOS
    String pNomeRAB_PEDA = "";
    String pNomeRAIB_PEDA = "";
    String pNomeCAII = "";
    //PLANEJAMENTO ATIVIDADES EM GRUPO
    String pNomePAG_PE = "";
    //ACERVO DA BIBLIOTECA
    //EDITORA
    String pNomeEDM_PEDA = "";
    //CATEGORIA
    String pNomeCATM_PEDA = "";
    //AUTORES
    String pNomeAUTM_PEDA = "";
    //LOCAL DE ARMAZENAMENTO
    String pNomeLAM_PEDA = "";
    //LIVROS E REVISTAS
    String pNomeLRM_PEDA = "";
    String pNomeLRI_PEDA = "";
    String pNomeLRA_PEDA = "";
    //INVENTÁRIO
    String pNomeINVM_PEDA = "";
    String pNomeINVC_PEDA = "";
    String pNomeINVE_PEDA = "";
    //FORNECEDOR
    String pNomeFORM_PEDA = "";
    //COMPRAS
    String pNomeCOMPM_PEDA = "";
    String pNomeCOMPP_PEDA = "";
    //RESERVA
    String pNomeRESM_PEDA = "";
    String pNomeRESP_PEDA = "";
    //EMPRESTIMO
    String pNomeEM_PEDA = "";
    String pNomeEP_PEDA = "";
    //DEVOLUÇÃO
    String pNomeDM_PEDA = "";
    String pNomeDP_PEDA = "";
    //MOVIMENTAÇÃO
    //ADMISSÃO/EVOLUÇÃO
    String pNomeAPM_PEDA = "";
    String pNomeAPFA_PEDA = "";
    String pNomeAPS_PEDA = "";
    String pNomeAPFI_PEDA = "";
    String pNomeEPM_PEDA = "";
    //CONTROLE DE MATRICULAS
    String pNomeCMM_PEDA = "";
    String pNomeCMI_PEDA = "";
    //CONTROLE DE FREQUENCIAS
    String pNomeCFM_PEDA = "";
    String pNomeCFI_PEDA = "";
    String pNomeCFP_PEDA = "";
    //BAIXAS 
    String pNomeBAM_PEDA = "";
    String pNomeBAI_PEDA = "";
    //ATUALIZAÇÃO DE ESCOLARIDADE
    String pNomeAEM_PEDA = "";
    //FREQUENCIA EXTERNA
    String pNomeCDTM_PEDA = "";
    String pNomeCDTI_PEDA = "";
    //ASSISTENCIA EDUCACIONAL
    String pNomeASEM_PEDA = "";
    String pNomeASEI_PEDA = "";
    //LIVRO DE OCORRENCIA
    String pNomeLO_PEDA = "";
    //PRORES
    String pNomeIAM = "";
    String pNomeIAE = "";
    String pNomeIAP = "";
    String pNomeIAC = "";
    String pNomeIAT = "";
    String pNomeIAPS = "";
    String pNomeIAS = "";
    //
    String pNomeRLRI = "";
    //
    String pNomeATM = "";
    //
    String pNomeCCAC_TPS_M = "";
    String pNomeCCAC_TPS_P = "";
    //
    String pNomeCCAC_FTPS_M = "";
    String pNomeCCAC_FTPS_P = "";
    // ATIVIDADES EM GRUPO
    String pNomeAGM = "";
    String pNomePLA = "";
    String pNomeAGI = "";
    String pNomeAVG = "";
    String pNomeAVI = "";
    //
    public static int pQUANTIDADE_ATENDIDA = 1;

    /**
     * Creates new form TelaPedagogia
     */
    public TelaModuloPedagogia() {
        initComponents();
        this.setSize(840, 640); // Tamanho da tela 
        pesquisarTelasAcessos();
        PESQUISAR_LIBERACAO_implementacao();
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
        jSeparator26 = new javax.swing.JPopupMenu.Separator();
        CursosDiversos = new javax.swing.JMenuItem();
        jTarefasEducativas = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        TurmasAulas = new javax.swing.JMenuItem();
        CargaHoraria = new javax.swing.JMenuItem();
        jTempoFormativo = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jAgendaAtendimentoInternos = new javax.swing.JMenuItem();
        jSeparator27 = new javax.swing.JPopupMenu.Separator();
        jPlanejamentoAtividades = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        jRegistraAtendimentoBiometria = new javax.swing.JMenuItem();
        jRegistroAtendimentoImpresso = new javax.swing.JMenuItem();
        jSeparator24 = new javax.swing.JPopupMenu.Separator();
        jCancelarRegistroAtendimentoInterno = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromissoPessoal = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        Sair = new javax.swing.JMenuItem();
        Acervo = new javax.swing.JMenu();
        EditorasInstituicoes = new javax.swing.JMenuItem();
        CategoriasLivros = new javax.swing.JMenuItem();
        Autores = new javax.swing.JMenuItem();
        LocalArmazenamento = new javax.swing.JMenuItem();
        Livros = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        FornecedorAcervo = new javax.swing.JMenuItem();
        InventarioAcervo = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
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
        jHistoricoMovimentacao = new javax.swing.JMenuItem();
        Movimentacao = new javax.swing.JMenu();
        AdmissaoEvolucaoPedagogica = new javax.swing.JMenuItem();
        jAtendimentoGrupo = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        Matriculas = new javax.swing.JMenuItem();
        jConcluirMatricula = new javax.swing.JMenuItem();
        jSeparator23 = new javax.swing.JPopupMenu.Separator();
        ControleFrequencia = new javax.swing.JMenuItem();
        BaixaAlunos = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JPopupMenu.Separator();
        jControleFrequenciaCursosAtividadesComplementares = new javax.swing.JMenu();
        jControleCursosAtividades = new javax.swing.JMenuItem();
        jFrequenciaCursos = new javax.swing.JMenuItem();
        jSeparator25 = new javax.swing.JPopupMenu.Separator();
        jRegistroLeituraResenhaInternos = new javax.swing.JMenuItem();
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
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        jRelatorioAtendimentoInternos = new javax.swing.JMenuItem();
        jSeparator22 = new javax.swing.JPopupMenu.Separator();
        jRelatorioAcompanhamentoPedagogico = new javax.swing.JMenuItem();

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );

        Cadastros.setMnemonic('C');
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
        Cadastros.add(jSeparator26);

        CursosDiversos.setText("Cursos Diversos - Atividades Complementares");
        CursosDiversos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CursosDiversosActionPerformed(evt);
            }
        });
        Cadastros.add(CursosDiversos);

        jTarefasEducativas.setText("Atividades Educativas");
        jTarefasEducativas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTarefasEducativasActionPerformed(evt);
            }
        });
        Cadastros.add(jTarefasEducativas);
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

        jTempoFormativo.setText("Tempo Formativo/Eixo - Série/Ano");
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
        Cadastros.add(jSeparator27);

        jPlanejamentoAtividades.setText("Planejamento de Atividades em Grupo");
        jPlanejamentoAtividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPlanejamentoAtividadesActionPerformed(evt);
            }
        });
        Cadastros.add(jPlanejamentoAtividades);
        Cadastros.add(jSeparator14);

        jMenu3.setForeground(new java.awt.Color(0, 102, 0));
        jMenu3.setText("Registro de Atendimento de Internos - (Biometria ou Impressão)");

        jRegistraAtendimentoBiometria.setForeground(new java.awt.Color(0, 102, 0));
        jRegistraAtendimentoBiometria.setText("Registra Atendimento por Biometria");
        jRegistraAtendimentoBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegistraAtendimentoBiometriaActionPerformed(evt);
            }
        });
        jMenu3.add(jRegistraAtendimentoBiometria);

        jRegistroAtendimentoImpresso.setForeground(new java.awt.Color(0, 0, 204));
        jRegistroAtendimentoImpresso.setText("Registro Atendimento por Impressão");
        jRegistroAtendimentoImpresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegistroAtendimentoImpressoActionPerformed(evt);
            }
        });
        jMenu3.add(jRegistroAtendimentoImpresso);
        jMenu3.add(jSeparator24);

        jCancelarRegistroAtendimentoInterno.setText("Cancelar  Registro de Atendimento de Interno");
        jCancelarRegistroAtendimentoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelarRegistroAtendimentoInternoActionPerformed(evt);
            }
        });
        jMenu3.add(jCancelarRegistroAtendimentoInterno);

        Cadastros.add(jMenu3);
        Cadastros.add(jSeparator18);

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
        Cadastros.add(jSeparator19);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        Cadastros.add(Sair);

        jMenuBar1.add(Cadastros);

        Acervo.setMnemonic('A');
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

        FornecedorAcervo.setText("Fornecedores de Acervo");
        FornecedorAcervo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FornecedorAcervoActionPerformed(evt);
            }
        });
        Acervo.add(FornecedorAcervo);

        InventarioAcervo.setText("Inventário de Acervos");
        InventarioAcervo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventarioAcervoActionPerformed(evt);
            }
        });
        Acervo.add(InventarioAcervo);
        Acervo.add(jSeparator6);

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

        Consultas.setMnemonic('O');
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

        jHistoricoMovimentacao.setText("Histórico de Movimentação de Internos");
        jHistoricoMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHistoricoMovimentacaoActionPerformed(evt);
            }
        });
        Consultas.add(jHistoricoMovimentacao);

        jMenuBar1.add(Consultas);

        Movimentacao.setMnemonic('M');
        Movimentacao.setText("Movimentação");

        AdmissaoEvolucaoPedagogica.setText("Admissão/Evolução Pedagógica");
        AdmissaoEvolucaoPedagogica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmissaoEvolucaoPedagogicaActionPerformed(evt);
            }
        });
        Movimentacao.add(AdmissaoEvolucaoPedagogica);

        jAtendimentoGrupo.setText("Atendimento em Grupo");
        jAtendimentoGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAtendimentoGrupoActionPerformed(evt);
            }
        });
        Movimentacao.add(jAtendimentoGrupo);
        Movimentacao.add(jSeparator13);

        jMenu4.setText("Controle de Matriculas");

        Matriculas.setText("Matriculas de Internos");
        Matriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatriculasActionPerformed(evt);
            }
        });
        jMenu4.add(Matriculas);

        jConcluirMatricula.setText("Concluir Matriculas");
        jConcluirMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConcluirMatriculaActionPerformed(evt);
            }
        });
        jMenu4.add(jConcluirMatricula);

        Movimentacao.add(jMenu4);
        Movimentacao.add(jSeparator23);

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
        Movimentacao.add(jSeparator20);

        jControleFrequenciaCursosAtividadesComplementares.setText("Controle e Frequência Cursos e Atividades Complementares");

        jControleCursosAtividades.setText("Controle de Cursos/Atividades Complementares");
        jControleCursosAtividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jControleCursosAtividadesActionPerformed(evt);
            }
        });
        jControleFrequenciaCursosAtividadesComplementares.add(jControleCursosAtividades);

        jFrequenciaCursos.setText("Controle de Frequência dos Cursos/Atividades Complementares");
        jFrequenciaCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFrequenciaCursosActionPerformed(evt);
            }
        });
        jControleFrequenciaCursosAtividadesComplementares.add(jFrequenciaCursos);

        Movimentacao.add(jControleFrequenciaCursosAtividadesComplementares);
        Movimentacao.add(jSeparator25);

        jRegistroLeituraResenhaInternos.setText("Remissão pela Educação/Leitura");
        jRegistroLeituraResenhaInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegistroLeituraResenhaInternosActionPerformed(evt);
            }
        });
        Movimentacao.add(jRegistroLeituraResenhaInternos);
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

        Relatorios.setMnemonic('R');
        Relatorios.setText("Relatórios");

        jMenu1.setText("Relatórios de Acervos");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
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
        Relatorios.add(jSeparator21);

        jRelatorioAtendimentoInternos.setForeground(new java.awt.Color(0, 102, 51));
        jRelatorioAtendimentoInternos.setText("Relatório de Atendimento de Internos");
        jRelatorioAtendimentoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioAtendimentoInternosActionPerformed(evt);
            }
        });
        Relatorios.add(jRelatorioAtendimentoInternos);
        Relatorios.add(jSeparator22);

        jRelatorioAcompanhamentoPedagogico.setForeground(new java.awt.Color(153, 0, 0));
        jRelatorioAcompanhamentoPedagogico.setText("Relatório de Acompanhamento Pedagogico");
        jRelatorioAcompanhamentoPedagogico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioAcompanhamentoPedagogicoActionPerformed(evt);
            }
        });
        Relatorios.add(jRelatorioAcompanhamentoPedagogico);

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
        buscarAcessoUsuario(telaLivroOcorrenciaManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaLivroOcorrenciaManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_LivroOcorrenciasActionPerformed

    private void jTempoFormativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTempoFormativoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaTempoFormativoManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaTempoFormativoManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jTempoFormativoActionPerformed

    private void InstituicaoEnsinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstituicaoEnsinoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaInstituicaoEnsinoManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaInstituicaoEnsinoManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_InstituicaoEnsinoActionPerformed

    private void SalaAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaAulaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaSalaAulaManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaSalaAulaManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_SalaAulaActionPerformed

    private void ProfessoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfessoresActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaProfessoresManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaProfessoresManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ProfessoresActionPerformed

    private void DisciplinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisciplinasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaDisciplinasManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaDisciplinasManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_DisciplinasActionPerformed

    private void CursosDiversosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CursosDiversosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCursosDiversosManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaCursosDiversosManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_CursosDiversosActionPerformed

    private void jTarefasEducativasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTarefasEducativasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaTarefasEducativasManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaTarefasEducativasManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jTarefasEducativasActionPerformed

    private void TurmasAulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TurmasAulasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaTurnosAulaManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaTurnosAulaManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_TurmasAulasActionPerformed

    private void CargaHorariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargaHorariaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCargaHorariaManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaCargaHorariaManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_CargaHorariaActionPerformed

    private void MatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatriculasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaControleMatriculaManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaControleMatriculaManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_MatriculasActionPerformed

    private void ControleFrequenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControleFrequenciaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaControleFrequenciaManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaControleFrequenciaManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
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
        buscarAcessoUsuario(telaBaixaAlunosManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaBaixaAlunosManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_BaixaAlunosActionPerformed

    private void AssistenciaEducacionalExternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssistenciaEducacionalExternaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAssistenciaEducaManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaAssistenciaEducaManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AssistenciaEducacionalExternaActionPerformed

    private void EditorasInstituicoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditorasInstituicoesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEditoraManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaEditoraManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EditorasInstituicoesActionPerformed

    private void CategoriasLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriasLivrosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCategoriaManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaCategoriaManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_CategoriasLivrosActionPerformed

    private void AutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutoresActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAutoresManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaAutoresManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AutoresActionPerformed

    private void LivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LivrosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaLivrosRevistaManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaLivrosRevistaManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_LivrosActionPerformed

    private void LocalArmazenamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalArmazenamentoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaLocalArmazenaManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaLocalArmazenaManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_LocalArmazenamentoActionPerformed

    private void InventarioAcervoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventarioAcervoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaInventarioManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaInventarioManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_InventarioAcervoActionPerformed

    private void ComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprasActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaComprasManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaComprasManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ComprasActionPerformed

    private void FornecedorAcervoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FornecedorAcervoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaFornecedoresManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaFornecedoresManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_FornecedorAcervoActionPerformed

    private void ReservaLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservaLivrosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaReservasManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaReservasManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_ReservaLivrosActionPerformed

    private void EmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmprestimosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEmprestimosManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaEmprestimosManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_EmprestimosActionPerformed

    private void DevolucoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DevolucoesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaDevolucaoManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaDevolucaoManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
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
        buscarAcessoUsuario(telaControleDiasManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaControleDiasManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
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
            String path = "reports/Pedagogia/RelatorioAtividadesEducacional.jasper";
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
        buscarAcessoUsuario(telaAdmissaoManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaAdmissaoManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_AdmissaoEvolucaoPedagogicaActionPerformed

    private void jAgendaAtendimentoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgendaAtendimentoInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAdmissaoManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaAdmissaoManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
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
        buscarAcessoUsuario(telaAtualizacaoEscolaridadeManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaAtualizacaoEscolaridadeManu_PEDA) && codAbrirPEDA == 1) {
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
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
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
            String path = "reports/GerenciaOperacional/ListagemGeralConfere.jasper";
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

    private void jRegistraAtendimentoBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegistraAtendimentoBiometriaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroAtendimentoBio_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaRegistroAtendimentoBio_PEDA) && codAbrirPEDA == 1) {
            if (objRegistroAtendBio == null || objRegistroAtendBio.isClosed()) {
                objRegistroAtendBio = new TelaRegistroInternosAtendimentoPEDA();
                jPainelPedagogia.add(objRegistroAtendBio);
                objRegistroAtendBio.setVisible(true);
            } else {
                if (objRegistroAtendBio.isVisible()) {
                    if (objRegistroAtendBio.isIcon()) { // Se esta minimizado
                        try {
                            objRegistroAtendBio.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegistroAtendBio.toFront(); // traz para frente
                        objRegistroAtendBio.pack();//volta frame 
                    }
                } else {
                    objRegistroAtendBio = new TelaRegistroInternosAtendimentoPEDA();
                    TelaModuloPedagogia.jPainelPedagogia.add(objRegistroAtendBio);//adicona frame ao JDesktopPane  
                    objRegistroAtendBio.setVisible(true);
                }
            }
            try {
                objRegistroAtendBio.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jRegistraAtendimentoBiometriaActionPerformed

    private void jRegistroAtendimentoImpressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegistroAtendimentoImpressoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroAtendimentoImpressaoBio_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaRegistroAtendimentoImpressaoBio_PEDA) && codAbrirPEDA == 1) {
            if (objRegistroImpBio == null || objRegistroImpBio.isClosed()) {
                objRegistroImpBio = new TelaRegistroInternosAtendimentoImpressoPEDA();
                jPainelPedagogia.add(objRegistroImpBio);
                objRegistroImpBio.setVisible(true);
            } else {
                if (objRegistroImpBio.isVisible()) {
                    if (objRegistroImpBio.isIcon()) { // Se esta minimizado
                        try {
                            objRegistroImpBio.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegistroImpBio.toFront(); // traz para frente
                        objRegistroImpBio.pack();//volta frame 
                    }
                } else {
                    objRegistroImpBio = new TelaRegistroInternosAtendimentoImpressoPEDA();
                    TelaModuloPedagogia.jPainelPedagogia.add(objRegistroImpBio);//adicona frame ao JDesktopPane  
                    objRegistroImpBio.setVisible(true);
                }
            }
            try {
                objRegistroImpBio.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jRegistroAtendimentoImpressoActionPerformed

    private void jRegistroLeituraResenhaInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegistroLeituraResenhaInternosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaRegistroResenhaPEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaRegistroResenhaPEDA) && codAbrirPEDA == 1) {
            if (objRegistroResenha == null || objRegistroResenha.isClosed()) {
                objRegistroResenha = new TelaRegistroLivroResenhaInterno();
                jPainelPedagogia.add(objRegistroResenha);
                objRegistroResenha.setVisible(true);
            } else {
                if (objRegistroResenha.isVisible()) {
                    if (objRegistroResenha.isIcon()) { // Se esta minimizado
                        try {
                            objRegistroResenha.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objRegistroResenha.toFront(); // traz para frente
                        objRegistroResenha.pack();//volta frame 
                    }
                } else {
                    objRegistroResenha = new TelaRegistroLivroResenhaInterno();
                    TelaModuloPedagogia.jPainelPedagogia.add(objRegistroResenha);//adicona frame ao JDesktopPane  
                    objRegistroImpBio.setVisible(true);
                }
            }
            try {
                objRegistroResenha.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jRegistroLeituraResenhaInternosActionPerformed

    private void jRelatorioAtendimentoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioAtendimentoInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioProducaoPedagogia objRelProdPe = new TelaRelatorioProducaoPedagogia();
        TelaModuloPedagogia.jPainelPedagogia.add(objRelProdPe);
        objRelProdPe.show();
    }//GEN-LAST:event_jRelatorioAtendimentoInternosActionPerformed

    private void jRelatorioAcompanhamentoPedagogicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioAcompanhamentoPedagogicoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioIndicadoresDeAcompanhamentoPedagogicoII objRelIndAcompPE = new TelaRelatorioIndicadoresDeAcompanhamentoPedagogicoII();
        TelaModuloPedagogia.jPainelPedagogia.add(objRelIndAcompPE);
        objRelIndAcompPE.show();
    }//GEN-LAST:event_jRelatorioAcompanhamentoPedagogicoActionPerformed

    private void jConcluirMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConcluirMatriculaActionPerformed
        // TODO add your handling code here:       
        buscarAcessoUsuario(telaAtualizarMaticuliaPEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaAtualizarMaticuliaPEDA) && codAbrirPEDA == 1) {
            if (objAtualizarMat == null || objAtualizarMat.isClosed()) {
                objAtualizarMat = new TelaAtualizarMatriculaPedagogia();
                jPainelPedagogia.add(objAtualizarMat);
                objAtualizarMat.setVisible(true);
            } else {
                if (objAtualizarMat.isVisible()) {
                    if (objAtualizarMat.isIcon()) { // Se esta minimizado
                        try {
                            objAtualizarMat.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtualizarMat.toFront(); // traz para frente
                        objAtualizarMat.pack();//volta frame 
                    }
                } else {
                    objAtualizarMat = new TelaAtualizarMatriculaPedagogia();
                    TelaModuloPedagogia.jPainelPedagogia.add(objAtualizarMat);//adicona frame ao JDesktopPane  
                    objAtualizarMat.setVisible(true);
                }
            }
            try {
                objAtualizarMat.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jConcluirMatriculaActionPerformed

    private void jHistoricoMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHistoricoMovimentacaoActionPerformed
        // TODO add your handling code here:
        if (objConHistMov == null || objConHistMov.isClosed()) {
            objConHistMov = new TelaMovHistoricoTecPedagogia();
            jPainelPedagogia.add(objConHistMov);
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
                objConHistMov = new TelaMovHistoricoTecPedagogia();
                TelaModuloPedagogia.jPainelPedagogia.add(objConHistMov);//adicona frame ao JDesktopPane  
                objConHistMov.setVisible(true);
            }
        }
        try {
            objConHistMov.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jHistoricoMovimentacaoActionPerformed

    private void jCancelarRegistroAtendimentoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelarRegistroAtendimentoInternoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCancelAtendInterno_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaCancelAtendInterno_PEDA) && codAbrirPEDA == 1) {
            if (objCancelaAtend == null || objCancelaAtend.isClosed()) {
                objCancelaAtend = new TelaCancelamentoAtendimentoPSP();
                jPainelPedagogia.add(objCancelaAtend);
                objCancelaAtend.setVisible(true);
            } else {
                if (objCancelaAtend.isVisible()) {
                    if (objCancelaAtend.isIcon()) { // Se esta minimizado
                        try {
                            objCancelaAtend.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objCancelaAtend.toFront(); // traz para frente
                        objCancelaAtend.pack();//volta frame 
                    }
                } else {
                    objCancelaAtend = new TelaCancelamentoAtendimentoPSP();
                    TelaModuloPedagogia.jPainelPedagogia.add(objCancelaAtend);//adicona frame ao JDesktopPane  
                    objCancelaAtend.setVisible(true);
                }
            }
            try {
                objCancelaAtend.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jCancelarRegistroAtendimentoInternoActionPerformed

    private void jControleCursosAtividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jControleCursosAtividadesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaCCAC_TPS_ManuPEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaCCAC_TPS_ManuPEDA) && codAbrirPEDA == 1) {
            if (objCCAC_TPS == null || objCCAC_TPS.isClosed()) {
                objCCAC_TPS = new TelaCCAC_TPS();
                jPainelPedagogia.add(objCCAC_TPS);
                objCCAC_TPS.setVisible(true);
            } else {
                if (objCCAC_TPS.isVisible()) {
                    if (objCCAC_TPS.isIcon()) { // Se esta minimizado
                        try {
                            objCCAC_TPS.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objCCAC_TPS.toFront(); // traz para frente
                        objCCAC_TPS.pack();//volta frame 
                    }
                } else {
                    objCCAC_TPS = new TelaCCAC_TPS();
                    TelaModuloPedagogia.jPainelPedagogia.add(objCCAC_TPS);//adicona frame ao JDesktopPane  
                    objCCAC_TPS.setVisible(true);
                }
            }
            try {
                objCCAC_TPS.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jControleCursosAtividadesActionPerformed

    private void jFrequenciaCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFrequenciaCursosActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaFCCAC_TPS_ManuPEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaFCCAC_TPS_ManuPEDA) && codAbrirPEDA == 1) {
            if (objControleCAC == null || objControleCAC.isClosed()) {
                objControleCAC = new TelaControleFrequenciaCursosAC_PEDAGOGIA();
                jPainelPedagogia.add(objControleCAC);
                objControleCAC.setVisible(true);
            } else {
                if (objControleCAC.isVisible()) {
                    if (objControleCAC.isIcon()) { // Se esta minimizado
                        try {
                            objControleCAC.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objControleCAC.toFront(); // traz para frente
                        objControleCAC.pack();//volta frame 
                    }
                } else {
                    objControleCAC = new TelaControleFrequenciaCursosAC_PEDAGOGIA();
                    TelaModuloPedagogia.jPainelPedagogia.add(objControleCAC);//adicona frame ao JDesktopPane  
                    objControleCAC.setVisible(true);
                }
            }
            try {
                objControleCAC.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jFrequenciaCursosActionPerformed

    private void jAtendimentoGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAtendimentoGrupoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaIndAtendimentoGrupoPE_Manu);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaIndAtendimentoGrupoPE_Manu) && codAbrirPEDA == 1) {
            if (objAtendPed == null || objAtendPed.isClosed()) {
                objAtendPed = new TelaAtendimentoGrupoPE();
                jPainelPedagogia.add(objAtendPed);
                objAtendPed.setVisible(true);
            } else {
                if (objAtendPed.isVisible()) {
                    if (objAtendPed.isIcon()) { // Se esta minimizado
                        try {
                            objAtendPed.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtendPed.toFront(); // traz para frente
                        objAtendPed.pack();//volta frame 
                    }
                } else {
                    objAtendPed = new TelaAtendimentoGrupoPE();
                    TelaModuloPedagogia.jPainelPedagogia.add(objAtendPed);//adicona frame ao JDesktopPane  
                    objAtendPed.setVisible(true);
                }
            }
            try {
                objAtendPed.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jAtendimentoGrupoActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jPlanejamentoAtividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPlanejamentoAtividadesActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaPlanejamentoAtividadesManu_PEDA);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoPEDA.equals("ADMINISTRADORES") || codigoUserPEDA == codUserAcessoPEDA && nomeTelaPEDA.equals(telaPlanejamentoAtividadesManu_PEDA) && codAbrirPEDA == 1) {
            if (objAtividadePlan == null || objAtividadePlan.isClosed()) {
                objAtividadePlan = new TelaAtividadesEducacaoFisica();
                jPainelPedagogia.add(objAtividadePlan);
                objAtividadePlan.setVisible(true);
            } else {
                if (objAtividadePlan.isVisible()) {
                    if (objAtividadePlan.isIcon()) { // Se esta minimizado
                        try {
                            objAtividadePlan.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objAtividadePlan.toFront(); // traz para frente
                        objAtividadePlan.pack();//volta frame 
                    }
                } else {
                    objAtividadePlan = new TelaAtividadesEducacaoFisica();
                    TelaModuloPedagogia.jPainelPedagogia.add(objAtividadePlan);//adicona frame ao JDesktopPane  
                    objAtividadePlan.setVisible(true);
                }
            }
            try {
                objAtividadePlan.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jPlanejamentoAtividadesActionPerformed


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
    private javax.swing.JMenuItem jAtendimentoGrupo;
    private javax.swing.JMenuItem jCancelarRegistroAtendimentoInterno;
    private javax.swing.JMenuItem jConcluirMatricula;
    private javax.swing.JMenuItem jControleCursosAtividades;
    private javax.swing.JMenu jControleFrequenciaCursosAtividadesComplementares;
    private javax.swing.JMenuItem jFrequenciaCursos;
    private javax.swing.JMenuItem jHistoricoMovimentacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    public static javax.swing.JDesktopPane jPainelPedagogia;
    private javax.swing.JMenuItem jPlanejamentoAtividades;
    private javax.swing.JMenuItem jRegistraAtendimentoBiometria;
    private javax.swing.JMenuItem jRegistroAtendimentoImpresso;
    private javax.swing.JMenuItem jRegistroLeituraResenhaInternos;
    private javax.swing.JMenuItem jRelatorioAcompanhamentoPedagogico;
    private javax.swing.JMenuItem jRelatorioAtendimentoInternos;
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
    private javax.swing.JPopupMenu.Separator jSeparator22;
    private javax.swing.JPopupMenu.Separator jSeparator23;
    private javax.swing.JPopupMenu.Separator jSeparator24;
    private javax.swing.JPopupMenu.Separator jSeparator25;
    private javax.swing.JPopupMenu.Separator jSeparator26;
    private javax.swing.JPopupMenu.Separator jSeparator27;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuItem jTarefasEducativas;
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
            conecta.executaSQL("SELECT * FROM AGENDARECADOS "
                    + "WHERE IdUsuario='" + codUsuario + "' "
                    + "AND StatusAgenda='" + statusAgenda + "'");
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

    // PESQUISA E CADASTRO DAS TELAS DO MÓDULO PEDAGOGIA PARA CONTROLE DE ACESSO DE USUÁRIOS.
    public void pesquisarTelasAcessos() {
        //INSTITUIÇÃO DE ENSINO
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaInstituicaoEnsinoManu_PEDA + "'");
            conecta.rs.first();
            pNomeIEM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //SALA DE AULA
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaSalaAulaManu_PEDA + "'");
            conecta.rs.first();
            pNomeSAM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //DISCIPLINA   
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaDisciplinasManu_PEDA + "'");
            conecta.rs.first();
            pNomeDISM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //PROFESSORES   
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaProfessoresManu_PEDA + "'");
            conecta.rs.first();
            pNomePROFM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaProfessoresDD_PEDA + "'");
            conecta.rs.first();
            pNomePFDD_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //CURSOS DIVERSOS  
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCursosDiversosManu_PEDA + "'");
            conecta.rs.first();
            pNomeCDM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //TAREFAS EDUCATIVAS   
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaTarefasEducativasManu_PEDA + "'");
            conecta.rs.first();
            pNomeTEM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //TURNOS DE AULAS    
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaTurnosAulaManu_PEDA + "'");
            conecta.rs.first();
            pNomeTAM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //CARGA HORÁRIA  
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCargaHorariaManu_PEDA + "'");
            conecta.rs.first();
            pNomeCHM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //TEMPO FORMATIVO    
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaTempoFormativoManu_PEDA + "'");
            conecta.rs.first();
            pNomeTFM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaTempoFormativoDisc_PEDA + "'");
            conecta.rs.first();
            pNomeTFD_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //ASSINATURA BIOMETRICA
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroAtendimentoBio_PEDA + "'");
            conecta.rs.first();
            pNomeRAB_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaRegistroAtendimentoImpressaoBio_PEDA + "'");
            conecta.rs.first();
            pNomeRAIB_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCancelAtendInterno_PEDA + "'");
            conecta.rs.first();
            pNomeCAII = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //PLANEJAMENTO DE ATIVIDADES EM GRUPO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaPlanejamentoAtividadesManu_PEDA + "'");
            conecta.rs.first();
            pNomePAG_PE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //ACERVO
        //EDITORA
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEditoraManu_PEDA + "'");
            conecta.rs.first();
            pNomeEDM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //CATEGORIA  
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCategoriaManu_PEDA + "'");
            conecta.rs.first();
            pNomeCATM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //AUTORES
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAutoresManu_PEDA + "'");
            conecta.rs.first();
            pNomeAUTM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //LOCAL DE ARMAZENAMENTO   
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaLocalArmazenaManu_PEDA + "'");
            conecta.rs.first();
            pNomeLAM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //LIVROS E REVISTAS
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaLivrosRevistaManu_PEDA + "'");
            conecta.rs.first();
            pNomeLRM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaLivrosRevistaImag_PEDA + "'");
            conecta.rs.first();
            pNomeLRI_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaLivrosRevistaAuto_PEDA + "'");
            conecta.rs.first();
            pNomeLRA_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //INVENTARIO 
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaInventarioManu_PEDA + "'");
            conecta.rs.first();
            pNomeINVM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaInventarioCont_PEDA + "'");
            conecta.rs.first();
            pNomeINVC_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaInventarioEfe_PEDA + "'");
            conecta.rs.first();
            pNomeINVE_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //FORNECEDORES
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaFornecedoresManu_PEDA + "'");
            conecta.rs.first();
            pNomeFORM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //COMPRAS
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaComprasManu_PEDA + "'");
            conecta.rs.first();
            pNomeCOMPM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaComprasProd_PEDA + "'");
            conecta.rs.first();
            pNomeCOMPP_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //RESERVAS
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaReservasManu_PEDA + "'");
            conecta.rs.first();
            pNomeRESM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaReservasProd_PEDA + "'");
            conecta.rs.first();
            pNomeRESP_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //EMPRESTIMOS
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEmprestimosManu_PEDA + "'");
            conecta.rs.first();
            pNomeEM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEmprestimosProd_PEDA + "'");
            conecta.rs.first();
            pNomeEP_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //DEVOLUÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaDevolucaoManu_PEDA + "'");
            conecta.rs.first();
            pNomeDM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaDevolucaoProd_PEDA + "'");
            conecta.rs.first();
            pNomeDP_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //MOVIMENTAÇÃO
        //ADMISSÃO E EVOLUÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAdmissaoManu_PEDA + "'");
            conecta.rs.first();
            pNomeAPM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAdmissaoFami_PEDA + "'");
            conecta.rs.first();
            pNomeAPFA_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAdmissaoSoci_PEDA + "'");
            conecta.rs.first();
            pNomeAPS_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAdmissaoFemi_PEDA + "'");
            conecta.rs.first();
            pNomeAPFI_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //EVOLUÇÃO PEDAGOGICA
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaEvolucao_PEDA + "'");
            conecta.rs.first();
            pNomeEPM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //CONTROLE DE MATRICULAS   
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaControleMatriculaManu_PEDA + "'");
            conecta.rs.first();
            pNomeCMM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaControleMatriculaInte_PEDA + "'");
            conecta.rs.first();
            pNomeCMI_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //CONTROLE DE FREQUENCIA  
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaControleFrequenciaManu_PEDA + "'");
            conecta.rs.first();
            pNomeCFM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaControleFrequenciaInte_PEDA + "'");
            conecta.rs.first();
            pNomeCFI_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaControleFrequenciaPrin_PEDA + "'");
            conecta.rs.first();
            pNomeCFP_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //BAIXA DE ALUNOS(INTERNOS)       
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaBaixaAlunosManu_PEDA + "'");
            conecta.rs.first();
            pNomeBAM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaBaixaAlunosInte_PEDA + "'");
            conecta.rs.first();
            pNomeBAI_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //ATUALIZAÇÃO DE ESCOLARIDADE 
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtualizacaoEscolaridadeManu_PEDA + "'");
            conecta.rs.first();
            pNomeAEM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //FREQUENCIA DIARIA E MENSAL DE ESCOLARIDADE    
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaControleDiasManu_PEDA + "'");
            conecta.rs.first();
            pNomeCDTM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaControleDiasOInte_PEDA + "'");
            conecta.rs.first();
            pNomeCDTI_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //ASSISTENCIA EDUCACIONAL EXTERNA  
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAssistenciaEducaManu_PEDA + "'");
            conecta.rs.first();
            pNomeASEM_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAssistenciaEducaInte_PEDA + "'");
            conecta.rs.first();
            pNomeASEI_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //LIVRO DE OCORRÊNCIAS
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaLivroOcorrenciaManu_PEDA + "'");
            conecta.rs.first();
            pNomeLO_PEDA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //PRORES
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaManuPEDA + "'");
            conecta.rs.first();
            pNomeIAM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaEPEDA + "'");
            conecta.rs.first();
            pNomeIAE = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaPPEDA + "'");
            conecta.rs.first();
            pNomeIAP = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaCPEDA + "'");
            conecta.rs.first();
            pNomeIAC = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaTPEDA + "'");
            conecta.rs.first();
            pNomeIAT = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaPSIPEDA + "'");
            conecta.rs.first();
            pNomeIAPS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAcompanhaAbaSPEDA + "'");
            conecta.rs.first();
            pNomeIAS = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaAtualizarMaticuliaPEDA + "'");
            conecta.rs.first();
            pNomeATM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCCAC_TPS_ManuPEDA + "'");
            conecta.rs.first();
            pNomeCCAC_TPS_M = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaCCAC_TPS_partPEDA + "'");
            conecta.rs.first();
            pNomeCCAC_TPS_P = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaFCCAC_TPS_ManuPEDA + "'");
            conecta.rs.first();
            pNomeCCAC_FTPS_M = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaFCCAC_TPS_partPEDA + "'");
            conecta.rs.first();
            pNomeCCAC_FTPS_P = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        //ATIVIDADE EM GRUPO
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAtendimentoGrupoPE_Manu + "'");
            conecta.rs.first();
            pNomeAGM = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAtendimentoGrupoPE_Inte + "'");
            conecta.rs.first();
            pNomeAGI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAtendimentoGrupoPE_Plan + "'");
            conecta.rs.first();
            pNomePLA = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAtendimentoGrupoPE_AVG + "'");
            conecta.rs.first();
            pNomeAVG = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE NomeTela='" + telaIndAtendimentoGrupoPE_AVI + "'");
            conecta.rs.first();
            pNomeAVI = conecta.rs.getString("NomeTela");
        } catch (SQLException ex) {
        }
        // INICIO DA COMPARAÇÃO
        //INSTITUIÇÃO DE ENSINO   
        if (!pNomeIEM_PEDA.equals(telaInstituicaoEnsinoManu_PEDA) || pNomeIEM_PEDA == null || pNomeIEM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaInstituicaoEnsinoManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //SALA DE AULA 
        if (!pNomeSAM_PEDA.equals(telaSalaAulaManu_PEDA) || pNomeSAM_PEDA == null || pNomeSAM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaSalaAulaManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //DISCIPLINA
        if (!pNomeDISM_PEDA.equals(telaDisciplinasManu_PEDA) || pNomeDISM_PEDA == null || pNomeDISM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaDisciplinasManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //PROFESSORES  
        if (!pNomePROFM_PEDA.equals(telaProfessoresManu_PEDA) || pNomePROFM_PEDA == null || pNomePROFM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaProfessoresManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePFDD_PEDA.equals(telaProfessoresDD_PEDA) || pNomePFDD_PEDA == null || pNomePFDD_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaProfessoresDD_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //CURSOS DIVERSOS   
        if (!pNomeCDM_PEDA.equals(telaCursosDiversosManu_PEDA) || pNomeCDM_PEDA == null || pNomeCDM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCursosDiversosManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //TAREFAS EDUCATIVAS  
        if (!pNomeTEM_PEDA.equals(telaTarefasEducativasManu_PEDA) || pNomeTEM_PEDA == null || pNomeTEM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaTarefasEducativasManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //TURNOS DE AULAS    
        if (!pNomeTAM_PEDA.equals(telaTurnosAulaManu_PEDA) || pNomeTAM_PEDA == null || pNomeTAM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaTurnosAulaManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //CARGA HORÁRIA
        if (!pNomeCHM_PEDA.equals(telaCargaHorariaManu_PEDA) || pNomeCHM_PEDA == null || pNomeCHM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCargaHorariaManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //TEMPO FORMATIVO  
        if (!pNomeTFM_PEDA.equals(telaTempoFormativoManu_PEDA) || pNomeTFM_PEDA == null || pNomeTFM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaTempoFormativoManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeTFD_PEDA.equals(telaTempoFormativoDisc_PEDA) || pNomeTFD_PEDA == null || pNomeTFD_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaTempoFormativoDisc_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCAII.equals(telaCancelAtendInterno_PEDA) || pNomeCAII == null || pNomeCAII.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCancelAtendInterno_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //PLANEJAMENTO DE ATIVIDADES EM GRUPO
        if (!pNomePAG_PE.equals(telaPlanejamentoAtividadesManu_PEDA) || pNomePAG_PE == null || pNomePAG_PE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaPlanejamentoAtividadesManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //ACERVO
        //EDITORA
        if (!pNomeEDM_PEDA.equals(telaEditoraManu_PEDA) || pNomeEDM_PEDA == null || pNomeEDM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEditoraManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //CATEGORIA   
        if (!pNomeCATM_PEDA.equals(telaCategoriaManu_PEDA) || pNomeCATM_PEDA == null || pNomeCATM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCategoriaManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //AUTORES 
        if (!pNomeAUTM_PEDA.equals(telaAutoresManu_PEDA) || pNomeAUTM_PEDA == null || pNomeAUTM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAutoresManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //LOCAL DE ARMAZENAMENTO
        if (!pNomeLAM_PEDA.equals(telaLocalArmazenaManu_PEDA) || pNomeLAM_PEDA == null || pNomeLAM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaLocalArmazenaManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //LIVROS E REVISTAS
        if (!pNomeLRM_PEDA.equals(telaLivrosRevistaManu_PEDA) || pNomeLRM_PEDA == null || pNomeLRM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaLivrosRevistaManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLRI_PEDA.equals(telaLivrosRevistaImag_PEDA) || pNomeLRI_PEDA == null || pNomeLRI_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaLivrosRevistaImag_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeLRA_PEDA.equals(telaLivrosRevistaAuto_PEDA) || pNomeLRA_PEDA == null || pNomeLRA_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaLivrosRevistaAuto_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //INVENTARIO
        if (!pNomeINVM_PEDA.equals(telaInventarioManu_PEDA) || pNomeINVM_PEDA == null || pNomeINVM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaInventarioManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeINVC_PEDA.equals(telaInventarioCont_PEDA) || pNomeINVC_PEDA == null || pNomeINVC_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaInventarioCont_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeINVE_PEDA.equals(telaInventarioEfe_PEDA) || pNomeINVE_PEDA == null || pNomeINVE_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaInventarioEfe_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //FORNECEDORES
        if (!pNomeFORM_PEDA.equals(telaFornecedoresManu_PEDA) || pNomeFORM_PEDA == null || pNomeFORM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaFornecedoresManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //COMPRAS
        if (!pNomeCOMPM_PEDA.equals(telaComprasManu_PEDA) || pNomeCOMPM_PEDA == null || pNomeCOMPM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaComprasManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCOMPP_PEDA.equals(telaComprasProd_PEDA) || pNomeCOMPP_PEDA == null || pNomeCOMPP_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaComprasProd_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //RESERVAS
        if (!pNomeRESM_PEDA.equals(telaReservasManu_PEDA) || pNomeRESM_PEDA == null || pNomeRESM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaReservasManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRESP_PEDA.equals(telaReservasProd_PEDA) || pNomeRESP_PEDA == null || pNomeRESP_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaReservasProd_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //EMPRESTIMOS
        if (!pNomeEM_PEDA.equals(telaEmprestimosManu_PEDA) || pNomeEM_PEDA == null || pNomeEM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEmprestimosManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeEP_PEDA.equals(telaEmprestimosProd_PEDA) || pNomeEP_PEDA == null || pNomeEP_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEmprestimosProd_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //DEVOLUÇÃO
        if (!pNomeDM_PEDA.equals(telaDevolucaoManu_PEDA) || pNomeDM_PEDA == null || pNomeDM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaDevolucaoManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeDP_PEDA.equals(telaDevolucaoProd_PEDA) || pNomeDP_PEDA == null || pNomeDP_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaDevolucaoProd_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //ASSINATURA BIOMETRICA
        if (!pNomeRAB_PEDA.equals(telaRegistroAtendimentoBio_PEDA) || pNomeRAB_PEDA == null || pNomeRAB_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroAtendimentoBio_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeRAIB_PEDA.equals(telaRegistroAtendimentoImpressaoBio_PEDA) || pNomeRAIB_PEDA == null || pNomeRAIB_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaRegistroAtendimentoImpressaoBio_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //MOVIMENTAÇÃO
        //ADMISSÃO E EVOLUÇÃO
        if (!pNomeAPM_PEDA.equals(telaAdmissaoManu_PEDA) || pNomeAPM_PEDA == null || pNomeAPM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAdmissaoManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAPFA_PEDA.equals(telaAdmissaoFami_PEDA) || pNomeAPFA_PEDA == null || pNomeAPFA_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAdmissaoFami_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAPS_PEDA.equals(telaAdmissaoSoci_PEDA) || pNomeAPS_PEDA == null || pNomeAPS_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAdmissaoSoci_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAPFI_PEDA.equals(telaAdmissaoFemi_PEDA) || pNomeAPFI_PEDA == null || pNomeAPFI_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAdmissaoFemi_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //EVOLUÇÃO PEDAGOGICA
        if (!pNomeEPM_PEDA.equals(telaEvolucao_PEDA) || pNomeEPM_PEDA == null || pNomeEPM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaEvolucao_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //CONTROLE DE MATRICULAS  
        if (!pNomeCMM_PEDA.equals(telaControleMatriculaManu_PEDA) || pNomeCMM_PEDA == null || pNomeCMM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaControleMatriculaManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCMI_PEDA.equals(telaControleMatriculaInte_PEDA) || pNomeCMI_PEDA == null || pNomeCMI_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaControleMatriculaInte_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //CONTROLE DE FREQUENCIA   
        if (!pNomeCFM_PEDA.equals(telaControleFrequenciaManu_PEDA) || pNomeCFM_PEDA == null || pNomeCFM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaControleFrequenciaManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCFI_PEDA.equals(telaControleFrequenciaInte_PEDA) || pNomeCFI_PEDA == null || pNomeCFI_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaControleFrequenciaInte_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCFP_PEDA.equals(telaControleFrequenciaPrin_PEDA) || pNomeCFP_PEDA == null || pNomeCFP_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaControleFrequenciaPrin_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //BAIXA DE ALUNOS(INTERNOS)      
        if (!pNomeBAM_PEDA.equals(telaBaixaAlunosManu_PEDA) || pNomeBAM_PEDA == null || pNomeBAM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaBaixaAlunosManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeBAI_PEDA.equals(telaBaixaAlunosInte_PEDA) || pNomeBAI_PEDA == null || pNomeBAI_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaBaixaAlunosInte_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //ATUALIZAÇÃO DE ESCOLARIDADE    
        if (!pNomeAEM_PEDA.equals(telaAtualizacaoEscolaridadeManu_PEDA) || pNomeAEM_PEDA == null || pNomeAEM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtualizacaoEscolaridadeManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //FREQUENCIA DIARIA E MENSAL DE ESCOLARIDADE   
        if (!pNomeCDTM_PEDA.equals(telaControleDiasManu_PEDA) || pNomeCDTM_PEDA == null || pNomeCDTM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaControleDiasManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCDTI_PEDA.equals(telaControleDiasOInte_PEDA) || pNomeCDTI_PEDA == null || pNomeCDTI_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaControleDiasOInte_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //ASSISTENCIA EDUCACIONAL EXTERNA   
        if (!pNomeASEM_PEDA.equals(telaAssistenciaEducaManu_PEDA) || pNomeASEM_PEDA == null || pNomeASEM_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAssistenciaEducaManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeASEI_PEDA.equals(telaAssistenciaEducaInte_PEDA) || pNomeASEI_PEDA == null || pNomeASEI_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAssistenciaEducaInte_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //LIVRO DE OCORRÊNCIAS    
        if (!pNomeLO_PEDA.equals(telaLivroOcorrenciaManu_PEDA) || pNomeLO_PEDA == null || pNomeLO_PEDA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaLivroOcorrenciaManu_PEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //PRORES
        if (!pNomeIAM.equals(telaIndAcompanhaManuPEDA) || pNomeIAM == null || pNomeIAM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaManuPEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAE.equals(telaIndAcompanhaAbaEPEDA) || pNomeIAE == null || pNomeIAE.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaEPEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAP.equals(telaIndAcompanhaAbaPPEDA) || pNomeIAP == null || pNomeIAP.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaPPEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAC.equals(telaIndAcompanhaAbaCPEDA) || pNomeIAC == null || pNomeIAC.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaCPEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAT.equals(telaIndAcompanhaAbaTPEDA) || pNomeIAT == null || pNomeIAT.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaTPEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAPS.equals(telaIndAcompanhaAbaPSIPEDA) || pNomeIAPS == null || pNomeIAPS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaPSIPEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeIAS.equals(telaIndAcompanhaAbaSPEDA) || pNomeIAS == null || pNomeIAS.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAcompanhaAbaSPEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeATM.equals(telaAtualizarMaticuliaPEDA) || pNomeATM == null || pNomeATM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaAtualizarMaticuliaPEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCCAC_TPS_M.equals(telaCCAC_TPS_ManuPEDA) || pNomeCCAC_TPS_M == null || pNomeCCAC_TPS_M.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCCAC_TPS_ManuPEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCCAC_TPS_P.equals(telaCCAC_TPS_partPEDA) || pNomeCCAC_TPS_P == null || pNomeCCAC_TPS_P.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaCCAC_TPS_partPEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCCAC_FTPS_M.equals(telaFCCAC_TPS_ManuPEDA) || pNomeCCAC_FTPS_M == null || pNomeCCAC_FTPS_M.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaFCCAC_TPS_ManuPEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeCCAC_FTPS_P.equals(telaFCCAC_TPS_partPEDA) || pNomeCCAC_FTPS_P == null || pNomeCCAC_FTPS_P.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaFCCAC_TPS_partPEDA);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        //ATIVIDADES EM GRUPO
        if (!pNomeAGM.equals(telaIndAtendimentoGrupoPE_Manu) || pNomeAGM == null || pNomeAGM.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAtendimentoGrupoPE_Manu);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAGI.equals(telaIndAtendimentoGrupoPE_Inte) || pNomeAGI == null || pNomeAGI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAtendimentoGrupoPE_Inte);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomePLA.equals(telaIndAtendimentoGrupoPE_Plan) || pNomePLA == null || pNomePLA.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAtendimentoGrupoPE_Plan);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAVG.equals(telaIndAtendimentoGrupoPE_AVG) || pNomeAVG == null || pNomeAVG.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAtendimentoGrupoPE_AVG);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        if (!pNomeAVI.equals(telaIndAtendimentoGrupoPE_AVI) || pNomeAVI == null || pNomeAVI.equals("")) {
            buscarCodigoModulo();
            objCadastroTela.setIdModulo(pCodModulo);
            objCadastroTela.setNomeTela(telaIndAtendimentoGrupoPE_AVI);
            controle.incluirTelaAcesso(objCadastroTela);
        }
        conecta.desconecta();
    }

    // MÉTODO PARA BUSCAR O CÓDIGO DO MÓDULO, CASO NÃO TENHA SIDO CADASTRADO.
    public void buscarCodigoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE NomeModulo='" + nomeModuloPEDA + "'");
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
            codigoUserPEDA = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserPEDA + "'");
            conecta.rs.first();
            codigoUserGroupPEDA = conecta.rs.getInt("IdUsuario");
            codigoGrupoPEDA = conecta.rs.getInt("IdGrupo");
            nomeGrupoPEDA = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserPEDA + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoPEDA = conecta.rs.getInt("IdUsuario");
            codAbrirPEDA = conecta.rs.getInt("Abrir");
            codIncluirPEDA = conecta.rs.getInt("Incluir");
            codAlterarPEDA = conecta.rs.getInt("Alterar");
            codExcluirPEDA = conecta.rs.getInt("Excluir");
            codGravarPEDA = conecta.rs.getInt("Gravar");
            codConsultarPEDA = conecta.rs.getInt("Consultar");
            nomeTelaPEDA = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void PESQUISAR_LIBERACAO_implementacao() {
        PESQUISAR_IMPLEMENTA_PEDA_001(telaPlanejamentoAtividadesManu_PEDA);
        PESQUISAR_IMPLEMENTA_PEDA_002(telaAgendamentoAtendimentoInternos_PEDA);
        PESQUISAR_IMPLEMENTA_PEDA_003(telaCCAC_TPS_ManuPEDA);
    }

    public void PESQUISAR_IMPLEMENTA_PEDA_001(String pNOME_tela) {
        objParCrc.setNomeTela(pNOME_tela);
        controlImp.pPESQUISAR_CODIGO_TELA(objParCrc);
        controlImp.pPESQUISAR_liberacao(objParCrc);
        if (objParCrc.getHabilitarImp() != null && objParCrc.getHabilitarImp().equals("Não") && !nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jAgendaAtendimentoInternos.setVisible(!true);
            jSeparator27.setVisible(!true);
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jAgendaAtendimentoInternos.setVisible(true);
            jSeparator27.setVisible(true);
        } else if (objParCrc.getHabilitarImp() != null && objParCrc.getHabilitarImp().equals("Sim") && !nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jAgendaAtendimentoInternos.setVisible(true);
            jSeparator27.setVisible(true);
        } else if (objParCrc.getHabilitarImp() == null) {
            jAgendaAtendimentoInternos.setVisible(!true);
            jSeparator27.setVisible(!true);
        } else if (objParCrc.getHabilitarImp().equals("")) {
            jAgendaAtendimentoInternos.setVisible(!true);
            jSeparator27.setVisible(!true);
        } else {
            jAgendaAtendimentoInternos.setVisible(true);
            jSeparator27.setVisible(true);
        }
    }

    public void PESQUISAR_IMPLEMENTA_PEDA_002(String pNOME_tela) {
        objParCrc.setNomeTela(pNOME_tela);
        controlImp.pPESQUISAR_CODIGO_TELA(objParCrc);
        controlImp.pPESQUISAR_liberacao(objParCrc);
        if (objParCrc.getHabilitarImp() != null && objParCrc.getHabilitarImp().equals("Não") && !nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jAtendimentoGrupo.setVisible(!true);
            jSeparator13.setVisible(!true);
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jAtendimentoGrupo.setVisible(true);
            jSeparator13.setVisible(true);
        } else if (objParCrc.getHabilitarImp() != null && objParCrc.getHabilitarImp().equals("Sim") && !nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jAtendimentoGrupo.setVisible(true);
            jSeparator13.setVisible(true);
        } else if (objParCrc.getHabilitarImp() == null) {
            jAtendimentoGrupo.setVisible(!true);
            jSeparator13.setVisible(!true);
        } else if (objParCrc.getHabilitarImp().equals("")) {
            jAtendimentoGrupo.setVisible(!true);
            jSeparator13.setVisible(!true);
        } else {
            jAtendimentoGrupo.setVisible(true);
            jSeparator13.setVisible(true);
        }
    }

    public void PESQUISAR_IMPLEMENTA_PEDA_003(String pNOME_tela) {
        objParCrc.setNomeTela(pNOME_tela);
        controlImp.pPESQUISAR_CODIGO_TELA(objParCrc);
        controlImp.pPESQUISAR_liberacao(objParCrc);
        if (objParCrc.getHabilitarImp() != null && objParCrc.getHabilitarImp().equals("Não") && !nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jControleFrequenciaCursosAtividadesComplementares.setVisible(!true);
            jSeparator25.setVisible(!true);
        } else if (nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jControleFrequenciaCursosAtividadesComplementares.setVisible(true);
            jSeparator25.setVisible(true);
        } else if (objParCrc.getHabilitarImp() != null && objParCrc.getHabilitarImp().equals("Sim") && !nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            jControleFrequenciaCursosAtividadesComplementares.setVisible(true);
            jSeparator25.setVisible(true);
        } else if (objParCrc.getHabilitarImp() == null) {
            jControleFrequenciaCursosAtividadesComplementares.setVisible(!true);
            jSeparator25.setVisible(!true);
        } else if (objParCrc.getHabilitarImp().equals("")) {
            jControleFrequenciaCursosAtividadesComplementares.setVisible(!true);
            jSeparator25.setVisible(!true);
        } else {
            jControleFrequenciaCursosAtividadesComplementares.setVisible(true);
            jSeparator25.setVisible(!true);
        }
    }
}
