/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAdmissaoMedica;
import gestor.Controle.ControleAtestadoMedicoPsiquiatrico;
import gestor.Controle.ControleConfirmacaoAtendimento;
import gestor.Controle.ControleDietaMedicaPsiquiatrica;
import gestor.Controle.ControleEvolucaoPsiquiatrica;
import gestor.Controle.ControleEvolucaoMedica;
import gestor.Controle.ControleItensDoenca;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovAtestadoMedicoPsiquiatrico;
import gestor.Controle.ControleMovDiagnosticoMedico;
import gestor.Controle.ControleMovDietaMedicaPsiquiatrica;
import gestor.Controle.ControleMovEvolucaoMedica;
import gestor.Controle.ControleMovMedico;
import gestor.Controle.ControleMovPrescricaoMedicaPsiquiatrica;
import gestor.Controle.ControlePrescricaoMedicaPsiquiatrica;
import gestor.Controle.ControleRegistroAtendimentoInternoBio;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.LimiteDigitos;
import gestor.Dao.LimiteDigitosAlfa;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.AdmissaoMedica;
import gestor.Modelo.AtestadoMedicoPsiquiatrico;
import gestor.Modelo.DietaMedica;
import gestor.Modelo.EvolucaoPsiquiatrica;
import gestor.Modelo.EvolucaoMedica;
import gestor.Modelo.ItensDoencas;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PrescricaoMedicaPsiquiatrica;
import gestor.Modelo.RegistroAtendimentoInternos;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloEnfermaria.codAlterarENF;
import static gestor.Visao.TelaModuloEnfermaria.codExcluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codGravarENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeTelaENF;
import static gestor.Visao.TelaModuloEnfermaria.telaAcessoProntuarioMedicoENF;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import static gestor.Visao.TelaModuloEnfermaria.codConsultarENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserENF;
import static gestor.Visao.TelaModuloEnfermaria.codUserAcessoENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserGroupENF;
import static gestor.Visao.TelaModuloEnfermaria.codAbrirENF;
import static gestor.Visao.TelaModuloEnfermaria.codIncluirENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeModuloENFER;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;

/**
 *
 * @author user
 */
public class TelaAdmissaoMedica extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoMedica objAdmMedico = new AdmissaoMedica();
    ControleAdmissaoMedica control = new ControleAdmissaoMedica();
    ControleMovMedico controle = new ControleMovMedico();
    ItensDoencas objItensDoenca = new ItensDoencas();
    ControleItensDoenca controlePat = new ControleItensDoenca();
    //
    EvolucaoPsiquiatrica objEvolPsiquiatrica = new EvolucaoPsiquiatrica();
    ControleEvolucaoPsiquiatrica controlEvolPsiquiatrica = new ControleEvolucaoPsiquiatrica();
    ControleMovDiagnosticoMedico controlMovDiag = new ControleMovDiagnosticoMedico();
    //
    EvolucaoMedica objEvolMedica = new EvolucaoMedica();
    ControleEvolucaoMedica controleEvoluMed = new ControleEvolucaoMedica(); // Controle Evolução Médica
    ControleMovEvolucaoMedica controleMovEvolu = new ControleMovEvolucaoMedica(); // Controle Movimentação Histórico Evolução
    //
    PrescricaoMedicaPsiquiatrica objPrescricao = new PrescricaoMedicaPsiquiatrica();
    ControlePrescricaoMedicaPsiquiatrica controlePrescricao = new ControlePrescricaoMedicaPsiquiatrica();
    ControleMovPrescricaoMedicaPsiquiatrica controleMovPrescricao = new ControleMovPrescricaoMedicaPsiquiatrica();
    // 
    AtestadoMedicoPsiquiatrico objAtestado = new AtestadoMedicoPsiquiatrico();
    ControleAtestadoMedicoPsiquiatrico controleAtestado = new ControleAtestadoMedicoPsiquiatrico();
    ControleMovAtestadoMedicoPsiquiatrico controleMovAtestado = new ControleMovAtestadoMedicoPsiquiatrico();
    //
    DietaMedica objDietaMedica = new DietaMedica();
    ControleDietaMedicaPsiquiatrica controlDieta = new ControleDietaMedicaPsiquiatrica();
    ControleMovDietaMedicaPsiquiatrica controleMovDieta = new ControleMovDietaMedicaPsiquiatrica();
    //
    RegistroAtendimentoInternos objRegAtend = new RegistroAtendimentoInternos();
    ControleRegistroAtendimentoInternoBio controlRegAtend = new ControleRegistroAtendimentoInternoBio();
    // PARA O ATENDIMENTO NA TV
    ControleConfirmacaoAtendimento control_ATENDE = new ControleConfirmacaoAtendimento();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Movimentação:Admissão Médica de Internos:Manutenção";
    String nomeModuloTela2 = "Movimentação:Admissão Médica de Internos:Evolução Psiquiatrica";
    String nomeModuloTela3 = "Movimentação:Admissão Médica de Internos:Evolução Médica";
    String nomeModuloTela4 = "Movimentação:Admissão Médica de Internos:Prescrição Médica/Psiquiatrica";
    String nomeModuloTela5 = "Movimentação:Admissão Médica de Internos:Atestado Médico/Psiquiatrico";
    String nomeModuloTela6 = "Movimentação:Admissão Médica de Internos:Dieta Médica/Psiquiatrica";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int acao, flag, idItem;
    int count = 0;
    int countp = 0;
    int countm = 0;
    int countpm = 0;
    int counta = 0;
    int countd = 0;
    int idItemEvolPsiquiatrico, idItemEvol, idItemPrescricao, idItemAtestado, idItemDieta;
    //
    String dataInicial, dataFinal, dataEntrada, dataEvolPsiquiatrica, dataEvolu, dataPrescricao, dataAtestado;
    String deptoTecnico = "ENFERMARIA";
    String caminho;
    String codAdm, codPsiquiatrico, codMedico, codPrescricao, codAtestado, codDieta;
    String codInterno; // VARIÁVEL QUE IMPEDI MUDAR O REGISTRO DE ADMISSÃO, CASO JÁ EXISTA ANAMNESES, PRESCRIÇÃO, ATEDTADO OU DIETA.
    //   
    String codDoenca; //CÓDIGO DA DOENCA PARA UTILIZAR NA ALTERAÇÃO,
    String modeloAtestadoA, modeloAtestadoB, modeloAtestadoC, modeloAtestadoAleatorio;
    String nomeUserRegistro;
    int tipoModelo;
    String descricaoModelo;
    int tipoPrescricao;
    int tipoPM = 0;
    int tipoPP = 1;
    String codInternoCrc = ""; // CÓDIGO DO INTERNO PARA BLOQUEAR DUPLICIDADE
    String atendido = "Sim";
    String nomeInternoAnterior = "";
    //    
    String codigoAtend = "";
    String dataReg = "";
    Date dataRegistro = null;
    String codigoEvol = "";
    String codigoInternoAtend = "";
    String atendeEvol = "Não";
    String opcao = "Não";
    //
    public static int codigoDepartamentoENF = 0;
    String tipoAtendimentoAdm = "Admissão Médica/Psiquiatrica";
    String tipoAtendimentoEvolME = "Evolução Médica";
    String tipoAtendimentoEvolPS = "Evolução Psiquiatrica";
    //
    String pHabilitaMedico = "";
    //
    int tipoDiagnosticoMed;
    String admEvolucao = "Sim";
    int pQUANTIDADE_ATENDIDA = 1;
    //ATENDIMENTO MOSTRADO NA TV
    String pATENDIMENTO_CONCLUIDO = "Sim";
    String status_ATENDIMENTO = "Atendimento Concluido";

    /**
     * Creates new form TelaAdmissaoMedica
     */
    public static TelaPatologiasEvolucaoMedicaPsiquiatrica telaPatologiaPsquiatrica;
    public static TelaPatologiasEvolucaoMedica telaPatologiaMedica;
    public static TelaConsultaExamesSolicitados telaConsultaExames;
    public static TelaConsultaVacinasInternos telaConsultaVacinas;
    public static TelaConsultaEncaminhamentosMedico telaEncaminhamentoMedico;
    public static TelaPrescricaoMedicaEnfermaria prescricaoMedica;

    public TelaAdmissaoMedica() {
        super();
        initComponents();
        setResizable(false);
        formatarCampos();
        corCampos();
        tabelaPatologias();
    }

    public void mostrarTelaPatologiaPsiqui() {
        telaPatologiaPsquiatrica = new TelaPatologiasEvolucaoMedicaPsiquiatrica(this, true);
        telaPatologiaPsquiatrica.setVisible(true);
    }

    public void mostrarTelaPatologiaMedica() {
        telaPatologiaMedica = new TelaPatologiasEvolucaoMedica(this, true);
        telaPatologiaMedica.setVisible(true);
    }

    public void mostrarTelaConsultaExamesPsi() {
        telaConsultaExames = new TelaConsultaExamesSolicitados(this, true);
        telaConsultaExames.setVisible(true);
    }

    public void mostrarTelaConsultaVacinasInternos() {
        telaConsultaVacinas = new TelaConsultaVacinasInternos(this, true);
        telaConsultaVacinas.setVisible(true);
    }

    public void mostrarTelaEncaminhamentoMedico() {
        telaEncaminhamentoMedico = new TelaConsultaEncaminhamentosMedico(this, true);
        telaEncaminhamentoMedico.setVisible(true);
    }

    public void mostrarTelaPrescricaoMedica() {
        prescricaoMedica = new TelaPrescricaoMedicaEnfermaria(this, true);
        prescricaoMedica.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        buttonGroupModelo = new javax.swing.ButtonGroup();
        buttonGroupPrescricao = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Listagem = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPesqNomeInternoOdonto = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jIDPesqAtend = new javax.swing.JTextField();
        jBtIdPesqAtend = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel49 = new javax.swing.JLabel();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqData = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaMedico = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        Manutencao = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jNomeInternoAdm = new javax.swing.JTextField();
        jIdInternoAdm = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jSexo = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jDataNascAdm = new com.toedter.calendar.JDateChooser();
        jBtPesqInternoAdm = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jMatriculaPenal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jNomeMaeInterno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jIdAdm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jStatusLanc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jDataAdm = new com.toedter.calendar.JDateChooser();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        Exames = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jABD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jAR = new javax.swing.JTextField();
        jAGU = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jEXT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jACV = new javax.swing.JTextField();
        jCABPESC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxAR = new javax.swing.JComboBox();
        jComboBoxAGU = new javax.swing.JComboBox();
        jComboBoxEXT = new javax.swing.JComboBox();
        jComboBoxACV = new javax.swing.JComboBox();
        jComboBoxCAB = new javax.swing.JComboBox();
        jComboBoxABD = new javax.swing.JComboBox();
        Patologias = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jIdItem = new javax.swing.JTextField();
        jDescricaoPatologia = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCid = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaPatologia = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jBtBuscar = new javax.swing.JButton();
        jBtAdicionarPatologia = new javax.swing.JButton();
        jBtExcluirPatologia = new javax.swing.JButton();
        Cirurgias = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jComboBoxIgnoradoAtualizado = new javax.swing.JComboBox();
        jLabel39 = new javax.swing.JLabel();
        jCirurgiasPrevisas = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTratamentoCurso = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxVacinas = new javax.swing.JComboBox();
        jLabel64 = new javax.swing.JLabel();
        jComboBoxAlergias = new javax.swing.JComboBox();
        jLabel65 = new javax.swing.JLabel();
        jQuaisAlergias = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jComboBoxUsaMedicamento = new javax.swing.JComboBox();
        jLabel53 = new javax.swing.JLabel();
        jQualMedicacaoUsa = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jComboBoxOutrasAlergias = new javax.swing.JComboBox();
        jQuaisOutrasAlergias = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        OutrasInformacoes = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jComboBoxDrogas = new javax.swing.JComboBox();
        jLabel42 = new javax.swing.JLabel();
        jQualDrogas = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jComboBoxEtilismo = new javax.swing.JComboBox();
        jLabel44 = new javax.swing.JLabel();
        jQualEtilismo = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jComboBoxTabagismo = new javax.swing.JComboBox();
        jLabel46 = new javax.swing.JLabel();
        jQuantoTempoTabagismo = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jComboBoxDrogasInjetavel = new javax.swing.JComboBox();
        jLabel57 = new javax.swing.JLabel();
        jQualTipoDrograInjet = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jComboBoxSexualidade = new javax.swing.JComboBox();
        jLabel59 = new javax.swing.JLabel();
        jComboBoxNumeroParceiro = new javax.swing.JComboBox();
        jLabel60 = new javax.swing.JLabel();
        jComboBoxUsaPreserva = new javax.swing.JComboBox();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jComboBoxTipoSanguineo = new javax.swing.JComboBox();
        jComboBoxFatorRH = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jDiagnosticoInicial = new javax.swing.JTextArea();
        jLabel78 = new javax.swing.JLabel();
        jComboBoxTipoDiagnostico = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        jFotoInternoAdm = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtFinalizar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAuditoria = new javax.swing.JButton();
        AnaPsiquiatrica = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextoEvolucaoPsiquiatrica = new javax.swing.JTextArea();
        jPanel20 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jIdEvolucaoPsiquiatrica = new javax.swing.JTextField();
        jNomeCompletoInternoDiagnosticos = new javax.swing.JTextField();
        jDataEvolPsiquiatrica = new com.toedter.calendar.JDateChooser();
        jLabel73 = new javax.swing.JLabel();
        jComboBoxPatologiaAdquirida = new javax.swing.JComboBox();
        jLabel74 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jBtNovaEvolPsiquiatrica = new javax.swing.JButton();
        jBtAlterarEvolPsiquiatrica = new javax.swing.JButton();
        jBtExcluirEvolPsiquiatrica = new javax.swing.JButton();
        jBtSalvarEvolPsiquiatrica = new javax.swing.JButton();
        jBtCancelarEvolPsiquiatrica = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTabelaEvolPsiquiatrica = new javax.swing.JTable();
        jLabel67 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jExamesSolicitadosPsiq = new javax.swing.JTextArea();
        jScrollPane14 = new javax.swing.JScrollPane();
        jHipotesesDiagnosticoPsi = new javax.swing.JTextArea();
        jLabel68 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jBtPatologias = new javax.swing.JButton();
        jBtExames = new javax.swing.JButton();
        jBtPesquisaEvolucaoPsi = new javax.swing.JButton();
        jBtAuditoriaEvolPsiquiatrica = new javax.swing.JButton();
        jTotalRegistrosPsi = new javax.swing.JLabel();
        jBtVacinas = new javax.swing.JButton();
        jBtEncaminhamentoPsi = new javax.swing.JButton();
        jBtImpressaoEvolucao1 = new javax.swing.JButton();
        jBtPrescricaMedica = new javax.swing.JButton();
        jBtAtestadoMedico = new javax.swing.JButton();
        jBtDietaMedica = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        AnaMedica = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jIdEvolucaoMedica = new javax.swing.JTextField();
        jNomeCompletoInternoEvolucaoMedica = new javax.swing.JTextField();
        jDataEvolucao = new com.toedter.calendar.JDateChooser();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jComboBoxPatologiaAdquiridaMedica = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextoEvolucaoMedica = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jBtNovaEvolucao = new javax.swing.JButton();
        jBtAlterarEvolucao = new javax.swing.JButton();
        jBtExcluirEvolucao = new javax.swing.JButton();
        jBtSalvarEvolucao = new javax.swing.JButton();
        jBtCancelarEvolucao = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jBtPatologiasClinica = new javax.swing.JButton();
        jBtExamesClinicos = new javax.swing.JButton();
        jBtEncaminhamentoClinico = new javax.swing.JButton();
        jBtAuditoriaEvolucao = new javax.swing.JButton();
        jBtPesquisaEvolucaoMedica = new javax.swing.JButton();
        jTotalRegistrosMed = new javax.swing.JLabel();
        jBtVacinasClinicas = new javax.swing.JButton();
        jBtImpressaoEvolucao = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaEvolucaoMedica = new javax.swing.JTable();
        jLabel69 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jExamesSolcitadosMedicos = new javax.swing.JTextArea();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jHipotestesDiagnosticosMedico = new javax.swing.JTextArea();
        jPanel18 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        PrescricaoMedica = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jIdPrescricaoMedica = new javax.swing.JTextField();
        jNomeInternoCrcPM = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jDataPM = new com.toedter.calendar.JDateChooser();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTabelaPrescricaoMedica = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jBtNovaPrescicao = new javax.swing.JButton();
        jBtAlterarPrescicao = new javax.swing.JButton();
        jBtExcluirPrescicao = new javax.swing.JButton();
        jBtSalvarPrescicao = new javax.swing.JButton();
        jBtCancelarPrescicao = new javax.swing.JButton();
        jBtImpressaoPrescricao = new javax.swing.JButton();
        jBtAuditoriaPrescicao = new javax.swing.JButton();
        jRBPrescricaoMedica = new javax.swing.JRadioButton();
        jRBPrescricaoPsiquiatrica = new javax.swing.JRadioButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextoPrescricaoMedica = new javax.swing.JTextArea();
        Atestado = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTabelaAtestado = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jIdAtestado = new javax.swing.JTextField();
        jNomeInternoAtestado = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jDataAtestado = new com.toedter.calendar.JDateChooser();
        jPanel27 = new javax.swing.JPanel();
        jBtNovoAtestado = new javax.swing.JButton();
        jBtAlterarAtestado = new javax.swing.JButton();
        jBtExcluirAtestado = new javax.swing.JButton();
        jBtImprimirAtestado = new javax.swing.JButton();
        jBtSalvarAtestado = new javax.swing.JButton();
        jBtCancelarAtestado = new javax.swing.JButton();
        jBtAuditoriaAtestado = new javax.swing.JButton();
        jRadioBtModeloA = new javax.swing.JRadioButton();
        jRadioBtModeloB = new javax.swing.JRadioButton();
        jRadioBtModeloC = new javax.swing.JRadioButton();
        jRadioBtModeloAleatorio = new javax.swing.JRadioButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextoAtestado = new javax.swing.JTextArea();
        DietaMedica = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jIdDieta = new javax.swing.JTextField();
        jNomeInternoDieta = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jDataDieta = new com.toedter.calendar.JDateChooser();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTablaDieta = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jBtNovaDieta = new javax.swing.JButton();
        jBtAlterarDieta = new javax.swing.JButton();
        jBtExcluirDieta = new javax.swing.JButton();
        jBtSalvarDieta = new javax.swing.JButton();
        jBtCancelarDieta = new javax.swing.JButton();
        jBtImprimirDieta = new javax.swing.JButton();
        jBtAuditoriaDieta = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextoDieta = new javax.swing.JTextArea();
        jLabel71 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel23.setText("jLabel23");

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Ficha de Admissão/Evolução Médica/Psiquiatrica {DM} :::...");

        jTabbedPane1.setToolTipText("Anotação/Evolução Psiquiatrica/Clinica");
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Nome :");

        jPesqNomeInternoOdonto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Código:");

        jIDPesqAtend.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqAtend.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtIdPesqAtend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtIdPesqAtend.setContentAreaFilled(false);
        jBtIdPesqAtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIdPesqAtendActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("Data Inicial:");

        jDataInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Data Final:");

        jDataFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jIDPesqAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtIdPesqAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jPesqNomeInternoOdonto, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtIdPesqAtend)
                    .addComponent(jIDPesqAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel48)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqNomeInternoOdonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jBtPesqNomeInterno)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaMedico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Nome Completo do Interno", "Situação"
            }
        ));
        jTabelaMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaMedicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaMedico);
        if (jTabelaMedico.getColumnModel().getColumnCount() > 0) {
            jTabelaMedico.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaMedico.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaMedico.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaMedico.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaMedico.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaMedico.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaMedico.getColumnModel().getColumn(3).setMinWidth(300);
            jTabelaMedico.getColumnModel().getColumn(3).setMaxWidth(300);
            jTabelaMedico.getColumnModel().getColumn(4).setMinWidth(330);
            jTabelaMedico.getColumnModel().getColumn(4).setMaxWidth(330);
        }
        jTabelaMedico.getAccessibleContext().setAccessibleName("");

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

        javax.swing.GroupLayout ListagemLayout = new javax.swing.GroupLayout(Listagem);
        Listagem.setLayout(ListagemLayout);
        ListagemLayout.setHorizontalGroup(
            ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ListagemLayout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ListagemLayout.setVerticalGroup(
            ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", null, Listagem, "Pesquisas de Admissão");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Cadastrais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jNomeInternoAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoAdm.setEnabled(false);

        jIdInternoAdm.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoAdm.setEnabled(false);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Sexo");

        jSexo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSexo.setEnabled(false);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Dt. Nascimento");

        jDataNascAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascAdm.setEnabled(false);

        jBtPesqInternoAdm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqInternoAdm.setContentAreaFilled(false);
        jBtPesqInternoAdm.setEnabled(false);
        jBtPesqInternoAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqInternoAdmActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Código");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Nome Completo do Interno");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Matricula Penal");

        jMatriculaPenal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenal.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Nome da Mãe");

        jNomeMaeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeMaeInterno.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeMaeInterno)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdInternoAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jNomeInternoAdm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqInternoAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel18)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jMatriculaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(0, 143, Short.MAX_VALUE))
                            .addComponent(jSexo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jDataNascAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdInternoAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInternoAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqInternoAdm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jNomeMaeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMatriculaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataNascAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código:");

        jIdAdm.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdAdm.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status:");

        jStatusLanc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLanc.setForeground(new java.awt.Color(255, 0, 0));
        jStatusLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLanc.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jStatusLanc.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data Admissão:");

        jDataAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAdm.setEnabled(false);

        jTabbedPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("ABD:");

        jABD.setToolTipText("Exame Abdominal");
        jABD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jABD.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("AR:");

        jAR.setToolTipText("Avaliação Respiratória");
        jAR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAR.setEnabled(false);

        jAGU.setToolTipText("Aparelho Genito Urinário");
        jAGU.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAGU.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("AGU:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("EXT:");

        jEXT.setToolTipText("Avaliação das Extremidades");
        jEXT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEXT.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("ACV:");

        jACV.setToolTipText("Avaliação Cardio Vascular");
        jACV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jACV.setEnabled(false);

        jCABPESC.setToolTipText("Exame de Cabeça e Pescoço");
        jCABPESC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCABPESC.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("CAB/PESC:");

        jComboBoxAR.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "NDN" }));
        jComboBoxAR.setToolTipText("Não, Sim, NDN");
        jComboBoxAR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAR.setEnabled(false);

        jComboBoxAGU.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAGU.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "NDN" }));
        jComboBoxAGU.setToolTipText("Não, Sim, NDN");
        jComboBoxAGU.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAGU.setEnabled(false);

        jComboBoxEXT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEXT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "NDN" }));
        jComboBoxEXT.setToolTipText("Não, Sim, NDN");
        jComboBoxEXT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEXT.setEnabled(false);

        jComboBoxACV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxACV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "NDN" }));
        jComboBoxACV.setToolTipText("Não, Sim, NDN");
        jComboBoxACV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxACV.setEnabled(false);

        jComboBoxCAB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCAB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "NDN" }));
        jComboBoxCAB.setToolTipText("Não, Sim, NDN");
        jComboBoxCAB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCAB.setEnabled(false);

        jComboBoxABD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxABD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "NDN" }));
        jComboBoxABD.setToolTipText("Não, Sim, NDN");
        jComboBoxABD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxABD.setEnabled(false);

        javax.swing.GroupLayout ExamesLayout = new javax.swing.GroupLayout(Exames);
        Exames.setLayout(ExamesLayout);
        ExamesLayout.setHorizontalGroup(
            ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExamesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAGU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxACV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCAB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxABD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jEXT, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                    .addComponent(jACV)
                    .addComponent(jCABPESC)
                    .addComponent(jABD)
                    .addComponent(jAR, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAGU, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        ExamesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jABD, jACV, jAGU, jAR, jCABPESC, jEXT});

        ExamesLayout.setVerticalGroup(
            ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExamesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAR, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jAGU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAGU, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jACV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxACV, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jCABPESC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCAB, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jABD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxABD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Exames Fisícos", Exames);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Código");

        jIdItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdItem.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdItem.setEnabled(false);

        jDescricaoPatologia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoPatologia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDescricaoPatologia.setEnabled(false);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Descrição da Patologia");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("CID");

        jCid.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCid.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCid.setEnabled(false);

        jTabelaPatologia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPatologia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição da Patologia", "CID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaPatologia.setEnabled(false);
        jTabelaPatologia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPatologiaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaPatologia);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtBuscar.setText("Buscar");
        jBtBuscar.setEnabled(false);
        jBtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarActionPerformed(evt);
            }
        });

        jBtAdicionarPatologia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtAdicionarPatologia.setText("Incluir");
        jBtAdicionarPatologia.setEnabled(false);
        jBtAdicionarPatologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdicionarPatologiaActionPerformed(evt);
            }
        });

        jBtExcluirPatologia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirPatologia.setText("Excluir");
        jBtExcluirPatologia.setEnabled(false);
        jBtExcluirPatologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirPatologiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBtExcluirPatologia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtAdicionarPatologia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jBtBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAdicionarPatologia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirPatologia)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAdicionarPatologia, jBtExcluirPatologia});

        javax.swing.GroupLayout PatologiasLayout = new javax.swing.GroupLayout(Patologias);
        Patologias.setLayout(PatologiasLayout);
        PatologiasLayout.setHorizontalGroup(
            PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatologiasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatologiasLayout.createSequentialGroup()
                        .addGroup(PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatologiasLayout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel38))
                            .addGroup(PatologiasLayout.createSequentialGroup()
                                .addComponent(jIdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDescricaoPatologia)))
                        .addGap(10, 10, 10)
                        .addGroup(PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jCid, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PatologiasLayout.setVerticalGroup(
            PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatologiasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PatologiasLayout.createSequentialGroup()
                        .addGroup(PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel35)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatologiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jDescricaoPatologia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jIdItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Patologias", Patologias);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jComboBoxIgnoradoAtualizado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIgnoradoAtualizado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Atualizada", "Ignorada" }));
        jComboBoxIgnoradoAtualizado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIgnoradoAtualizado.setEnabled(false);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Cirúrgias prévias? Qual?");

        jCirurgiasPrevisas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCirurgiasPrevisas.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Trat. em Curso? Qual?");

        jTratamentoCurso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTratamentoCurso.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Vacinas");

        jComboBoxVacinas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxVacinas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", " " }));
        jComboBoxVacinas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxVacinas.setEnabled(false);

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setText("Alergias?");

        jComboBoxAlergias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAlergias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAlergias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAlergias.setEnabled(false);

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("Quais?");

        jQuaisAlergias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisAlergias.setEnabled(false);

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Usa Medi.");

        jComboBoxUsaMedicamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUsaMedicamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", " " }));
        jComboBoxUsaMedicamento.setToolTipText("Usa Medicação");
        jComboBoxUsaMedicamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUsaMedicamento.setEnabled(false);

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Qual?");

        jQualMedicacaoUsa.setToolTipText("Qual Medicação");
        jQualMedicacaoUsa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualMedicacaoUsa.setEnabled(false);

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("O. Alergias");

        jComboBoxOutrasAlergias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOutrasAlergias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxOutrasAlergias.setToolTipText("Outras Alergias");
        jComboBoxOutrasAlergias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOutrasAlergias.setEnabled(false);

        jQuaisOutrasAlergias.setToolTipText("Quais Outras Alergias");
        jQuaisOutrasAlergias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisOutrasAlergias.setEnabled(false);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Quais Outras Alergias?");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setText("Status Vacina");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCirurgiasPrevisas, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jTratamentoCurso)
                                .addContainerGap())))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel52)
                            .addComponent(jComboBoxOutrasAlergias, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxUsaMedicamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel53))
                                .addGap(74, 74, 74))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jQuaisOutrasAlergias, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jQualMedicacaoUsa))
                                .addGap(7, 7, 7)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxVacinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel66)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jComboBoxIgnoradoAtualizado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel65)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jQuaisAlergias))
                                .addContainerGap())))))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxAlergias, jComboBoxVacinas});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jCirurgiasPrevisas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTratamentoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52)
                            .addComponent(jLabel65))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jQuaisAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jQualMedicacaoUsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxUsaMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel54))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel66))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jComboBoxOutrasAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jQuaisOutrasAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxVacinas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxIgnoradoAtualizado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel64)
                            .addComponent(jLabel53))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCirurgiasPrevisas, jTratamentoCurso});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxOutrasAlergias, jComboBoxUsaMedicamento});

        javax.swing.GroupLayout CirurgiasLayout = new javax.swing.GroupLayout(Cirurgias);
        Cirurgias.setLayout(CirurgiasLayout);
        CirurgiasLayout.setHorizontalGroup(
            CirurgiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CirurgiasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        CirurgiasLayout.setVerticalGroup(
            CirurgiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CirurgiasLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Inf. Diversas", Cirurgias);

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Drogas:");

        jComboBoxDrogas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDrogas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDrogas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDrogas.setEnabled(false);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Qual?:");

        jQualDrogas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualDrogas.setEnabled(false);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Etilismo:");

        jComboBoxEtilismo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEtilismo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxEtilismo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEtilismo.setEnabled(false);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Qual e Quanto?:");

        jQualEtilismo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualEtilismo.setEnabled(false);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Tabagismo:");

        jComboBoxTabagismo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTabagismo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTabagismo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTabagismo.setEnabled(false);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Qto e por qto tempo?:");

        jQuantoTempoTabagismo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantoTempoTabagismo.setEnabled(false);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Droga Injetável:");

        jComboBoxDrogasInjetavel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDrogasInjetavel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDrogasInjetavel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDrogasInjetavel.setEnabled(false);

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("Qual Tipo?:");

        jQualTipoDrograInjet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualTipoDrograInjet.setEnabled(false);

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Sexualidade:");

        jComboBoxSexualidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSexualidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Heterosssexual", "Bissexual", "Homossexual" }));
        jComboBoxSexualidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSexualidade.setEnabled(false);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("Número de Parceiros por Ano:");

        jComboBoxNumeroParceiro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNumeroParceiro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Um", "Dois", "Três", "Mais" }));
        jComboBoxNumeroParceiro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNumeroParceiro.setEnabled(false);

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("Usa Preservativos:");

        jComboBoxUsaPreserva.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUsaPreserva.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nunca", "Sempre", "Algumas vezes" }));
        jComboBoxUsaPreserva.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUsaPreserva.setEnabled(false);

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setText("Tipo Sanguíneo:");

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setText("Fator RH:");

        jComboBoxTipoSanguineo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoSanguineo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "O", "A", "B", "AB" }));
        jComboBoxTipoSanguineo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoSanguineo.setEnabled(false);

        jComboBoxFatorRH.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFatorRH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Negativo", "Positivo" }));
        jComboBoxFatorRH.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFatorRH.setEnabled(false);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel60)
                    .addComponent(jLabel43)
                    .addComponent(jLabel56)
                    .addComponent(jLabel41)
                    .addComponent(jLabel45)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jComboBoxDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualDrogas))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jComboBoxEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQualEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jComboBoxTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel46))
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jQuantoTempoTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel19Layout.createSequentialGroup()
                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBoxUsaPreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxSexualidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(32, 32, 32)
                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel59)
                                        .addGroup(jPanel19Layout.createSequentialGroup()
                                            .addComponent(jLabel61)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxTipoSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel62)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBoxNumeroParceiro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBoxFatorRH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jComboBoxDrogasInjetavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQualTipoDrograInjet, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jQualDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jComboBoxDrogasInjetavel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57)
                    .addComponent(jQualTipoDrograInjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel43)
                    .addComponent(jComboBoxEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(jQualEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel45)
                    .addComponent(jComboBoxTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel46)
                        .addComponent(jQuantoTempoTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jComboBoxSexualidade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59)
                    .addComponent(jComboBoxNumeroParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(jComboBoxUsaPreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62)
                    .addComponent(jComboBoxTipoSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFatorRH, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout OutrasInformacoesLayout = new javax.swing.GroupLayout(OutrasInformacoes);
        OutrasInformacoes.setLayout(OutrasInformacoesLayout);
        OutrasInformacoesLayout.setHorizontalGroup(
            OutrasInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OutrasInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        OutrasInformacoesLayout.setVerticalGroup(
            OutrasInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Outras Informações", OutrasInformacoes);

        jDiagnosticoInicial.setColumns(20);
        jDiagnosticoInicial.setRows(5);
        jDiagnosticoInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDiagnosticoInicial.setEnabled(false);
        jScrollPane17.setViewportView(jDiagnosticoInicial);

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(204, 0, 0));
        jLabel78.setText("Tipo de Diagnóstico:");

        jComboBoxTipoDiagnostico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoDiagnostico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Diagnóstico Clínico", "Diagnóstico Psiquiatrico" }));
        jComboBoxTipoDiagnostico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoDiagnostico.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTipoDiagnostico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel78)
                    .addComponent(jComboBoxTipoDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Diagnóstico Inicial", jPanel2);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoAdm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

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

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
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

        jBtFinalizar.setForeground(new java.awt.Color(255, 0, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setContentAreaFilled(false);
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtFinalizar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtFinalizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
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

        jBtAuditoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtAuditoria.setForeground(new java.awt.Color(0, 0, 255));
        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
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
                .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtFinalizar)
                .addGap(2, 2, 2)
                .addComponent(jBtSair)
                .addGap(28, 28, 28)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtNovo)
                .addComponent(jBtAlterar)
                .addComponent(jBtExcluir)
                .addComponent(jBtSalvar)
                .addComponent(jBtCancelar)
                .addComponent(jBtFinalizar)
                .addComponent(jBtSair)
                .addComponent(jBtAuditoria))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtFinalizar, jBtNovo, jBtSair, jBtSalvar});

        javax.swing.GroupLayout ManutencaoLayout = new javax.swing.GroupLayout(Manutencao);
        Manutencao.setLayout(ManutencaoLayout);
        ManutencaoLayout.setHorizontalGroup(
            ManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManutencaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addGroup(ManutencaoLayout.createSequentialGroup()
                        .addGroup(ManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ManutencaoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jIdAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jStatusLanc)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ManutencaoLayout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ManutencaoLayout.setVerticalGroup(
            ManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManutencaoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(ManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jIdAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jDataAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jTabbedPane1.addTab("Admissão", null, Manutencao, "Admissão Médica/Psiquiatrica");

        AnaPsiquiatrica.setToolTipText("Anotação/Evolução Psiquiatrica");

        jTextoEvolucaoPsiquiatrica.setColumns(20);
        jTextoEvolucaoPsiquiatrica.setRows(5);
        jTextoEvolucaoPsiquiatrica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoEvolucaoPsiquiatrica.setEnabled(false);
        jScrollPane3.setViewportView(jTextoEvolucaoPsiquiatrica);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Código");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Nome Completo do Interno");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Data");

        jIdEvolucaoPsiquiatrica.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdEvolucaoPsiquiatrica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdEvolucaoPsiquiatrica.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdEvolucaoPsiquiatrica.setEnabled(false);

        jNomeCompletoInternoDiagnosticos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeCompletoInternoDiagnosticos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeCompletoInternoDiagnosticos.setEnabled(false);

        jDataEvolPsiquiatrica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEvolPsiquiatrica.setEnabled(false);

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setText("PA");

        jComboBoxPatologiaAdquirida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPatologiaAdquirida.setForeground(new java.awt.Color(255, 0, 0));
        jComboBoxPatologiaAdquirida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Sanada" }));
        jComboBoxPatologiaAdquirida.setToolTipText("Patologia Adiquirida");
        jComboBoxPatologiaAdquirida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPatologiaAdquirida.setEnabled(false);

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 0, 0));
        jLabel74.setText("*");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdEvolucaoPsiquiatrica, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataEvolPsiquiatrica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel74))
                    .addComponent(jComboBoxPatologiaAdquirida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeCompletoInternoDiagnosticos)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel73)
                    .addComponent(jLabel74))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdEvolucaoPsiquiatrica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEvolPsiquiatrica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPatologiaAdquirida, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeCompletoInternoDiagnosticos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDataEvolPsiquiatrica, jIdEvolucaoPsiquiatrica, jNomeCompletoInternoDiagnosticos});

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Dados Psiquiatricos Resumidos - (Anotação/Evolução Psiquiatrica)");

        jBtNovaEvolPsiquiatrica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaEvolPsiquiatrica.setText("Novo");
        jBtNovaEvolPsiquiatrica.setEnabled(false);
        jBtNovaEvolPsiquiatrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaEvolPsiquiatricaActionPerformed(evt);
            }
        });

        jBtAlterarEvolPsiquiatrica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarEvolPsiquiatrica.setText("Alterar");
        jBtAlterarEvolPsiquiatrica.setEnabled(false);
        jBtAlterarEvolPsiquiatrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarEvolPsiquiatricaActionPerformed(evt);
            }
        });

        jBtExcluirEvolPsiquiatrica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirEvolPsiquiatrica.setText("Excluir");
        jBtExcluirEvolPsiquiatrica.setEnabled(false);
        jBtExcluirEvolPsiquiatrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEvolPsiquiatricaActionPerformed(evt);
            }
        });

        jBtSalvarEvolPsiquiatrica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarEvolPsiquiatrica.setText("Gravar");
        jBtSalvarEvolPsiquiatrica.setEnabled(false);
        jBtSalvarEvolPsiquiatrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEvolPsiquiatricaActionPerformed(evt);
            }
        });

        jBtCancelarEvolPsiquiatrica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEvolPsiquiatrica.setText("Cancelar");
        jBtCancelarEvolPsiquiatrica.setEnabled(false);
        jBtCancelarEvolPsiquiatrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarEvolPsiquiatricaActionPerformed(evt);
            }
        });

        jTabelaEvolPsiquiatrica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEvolPsiquiatrica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "PA", "Anotação/Evolução Psiquiatrica"
            }
        ));
        jTabelaEvolPsiquiatrica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEvolPsiquiatricaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTabelaEvolPsiquiatrica);
        if (jTabelaEvolPsiquiatrica.getColumnModel().getColumnCount() > 0) {
            jTabelaEvolPsiquiatrica.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaEvolPsiquiatrica.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaEvolPsiquiatrica.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaEvolPsiquiatrica.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaEvolPsiquiatrica.getColumnModel().getColumn(2).setMinWidth(40);
            jTabelaEvolPsiquiatrica.getColumnModel().getColumn(2).setMaxWidth(40);
            jTabelaEvolPsiquiatrica.getColumnModel().getColumn(3).setMinWidth(400);
            jTabelaEvolPsiquiatrica.getColumnModel().getColumn(3).setMaxWidth(400);
        }

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel67.setText("Resultado de Exames");

        jExamesSolicitadosPsiq.setColumns(20);
        jExamesSolicitadosPsiq.setRows(5);
        jExamesSolicitadosPsiq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jExamesSolicitadosPsiq.setEnabled(false);
        jScrollPane13.setViewportView(jExamesSolicitadosPsiq);

        jHipotesesDiagnosticoPsi.setColumns(20);
        jHipotesesDiagnosticoPsi.setRows(5);
        jHipotesesDiagnosticoPsi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHipotesesDiagnosticoPsi.setEnabled(false);
        jScrollPane14.setViewportView(jHipotesesDiagnosticoPsi);

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setText("Hipóteses Diagnósticas");

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtPatologias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtPatologias.setForeground(new java.awt.Color(0, 153, 0));
        jBtPatologias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtPatologias.setToolTipText("Cadastrar Patologias");
        jBtPatologias.setEnabled(false);
        jBtPatologias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtPatologias.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtPatologias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtPatologias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPatologiasActionPerformed(evt);
            }
        });

        jBtExames.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtExames.setForeground(new java.awt.Color(255, 0, 0));
        jBtExames.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtExames.setToolTipText("Solicitar Exames");
        jBtExames.setEnabled(false);
        jBtExames.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExames.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExames.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExamesActionPerformed(evt);
            }
        });

        jBtPesquisaEvolucaoPsi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaEvolucaoPsi.setContentAreaFilled(false);
        jBtPesquisaEvolucaoPsi.setEnabled(false);
        jBtPesquisaEvolucaoPsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaEvolucaoPsiActionPerformed(evt);
            }
        });

        jBtAuditoriaEvolPsiquiatrica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaEvolPsiquiatrica.setContentAreaFilled(false);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(false);
        jBtAuditoriaEvolPsiquiatrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaEvolPsiquiatricaActionPerformed(evt);
            }
        });

        jTotalRegistrosPsi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTotalRegistrosPsi.setForeground(new java.awt.Color(255, 0, 0));
        jTotalRegistrosPsi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTotalRegistrosPsi.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtVacinas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtVacinas.setForeground(new java.awt.Color(0, 0, 255));
        jBtVacinas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/viruskiller-icone-5641-16.png"))); // NOI18N
        jBtVacinas.setToolTipText("Consulta de Vacinas");
        jBtVacinas.setEnabled(false);
        jBtVacinas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtVacinas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtVacinas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtVacinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVacinasActionPerformed(evt);
            }
        });

        jBtEncaminhamentoPsi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtEncaminhamentoPsi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/high-security-icone-8352-16.png"))); // NOI18N
        jBtEncaminhamentoPsi.setToolTipText("Encaminhamentos");
        jBtEncaminhamentoPsi.setEnabled(false);
        jBtEncaminhamentoPsi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtEncaminhamentoPsi.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtEncaminhamentoPsi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtEncaminhamentoPsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEncaminhamentoPsiActionPerformed(evt);
            }
        });

        jBtImpressaoEvolucao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressaoEvolucao1.setToolTipText("Impressão de Evolução");
        jBtImpressaoEvolucao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoEvolucao1ActionPerformed(evt);
            }
        });

        jBtPrescricaMedica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/061218140238_16.png"))); // NOI18N
        jBtPrescricaMedica.setText("P. Médica");
        jBtPrescricaMedica.setToolTipText("Prescrição Médica");
        jBtPrescricaMedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPrescricaMedicaActionPerformed(evt);
            }
        });

        jBtAtestadoMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Triagem2-18.png"))); // NOI18N
        jBtAtestadoMedico.setText("A.Médico");
        jBtAtestadoMedico.setToolTipText("Atestado Médico");

        jBtDietaMedica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Nutricao18.png"))); // NOI18N
        jBtDietaMedica.setText("D.Médica");
        jBtDietaMedica.setToolTipText("Dieta Médica");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jTotalRegistrosPsi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jBtPesquisaEvolucaoPsi, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jBtAuditoriaEvolPsiquiatrica, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtImpressaoEvolucao1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtPrescricaMedica)
                            .addComponent(jBtAtestadoMedico)
                            .addComponent(jBtDietaMedica)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jBtPatologias, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtExames, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jBtVacinas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtEncaminhamentoPsi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtEncaminhamentoPsi, jBtExames, jBtPatologias, jBtVacinas});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtPatologias)
                    .addComponent(jBtExames))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtVacinas)
                    .addComponent(jBtEncaminhamentoPsi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPrescricaMedica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAtestadoMedico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtDietaMedica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtPesquisaEvolucaoPsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtAuditoriaEvolPsiquiatrica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtImpressaoEvolucao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTotalRegistrosPsi, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtEncaminhamentoPsi, jBtExames, jBtPatologias, jBtVacinas});

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/can-stock-photo_csp15011851.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
        );

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 0, 0));
        jLabel72.setText("*(PA - Patologia Adquirida)");

        javax.swing.GroupLayout AnaPsiquiatricaLayout = new javax.swing.GroupLayout(AnaPsiquiatrica);
        AnaPsiquiatrica.setLayout(AnaPsiquiatricaLayout);
        AnaPsiquiatricaLayout.setHorizontalGroup(
            AnaPsiquiatricaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnaPsiquiatricaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(AnaPsiquiatricaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AnaPsiquiatricaLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(AnaPsiquiatricaLayout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel72))
                    .addGroup(AnaPsiquiatricaLayout.createSequentialGroup()
                        .addGroup(AnaPsiquiatricaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AnaPsiquiatricaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                                .addComponent(jScrollPane13)
                                .addComponent(jScrollPane14))
                            .addGroup(AnaPsiquiatricaLayout.createSequentialGroup()
                                .addComponent(jBtNovaEvolPsiquiatrica, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jBtAlterarEvolPsiquiatrica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtExcluirEvolPsiquiatrica)
                                .addGap(6, 6, 6)
                                .addComponent(jBtSalvarEvolPsiquiatrica)
                                .addGap(6, 6, 6)
                                .addComponent(jBtCancelarEvolPsiquiatrica))
                            .addComponent(jLabel68)
                            .addComponent(jLabel67))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        AnaPsiquiatricaLayout.setVerticalGroup(
            AnaPsiquiatricaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnaPsiquiatricaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(AnaPsiquiatricaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(AnaPsiquiatricaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel72))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AnaPsiquiatricaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AnaPsiquiatricaLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AnaPsiquiatricaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jBtNovaEvolPsiquiatrica)
                            .addComponent(jBtSalvarEvolPsiquiatrica)
                            .addComponent(jBtCancelarEvolPsiquiatrica)
                            .addComponent(jBtAlterarEvolPsiquiatrica)
                            .addComponent(jBtExcluirEvolPsiquiatrica)))
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Anota./Evolu. Psiquiatrica", null, AnaPsiquiatrica, "Evolução Psiquiatrica");

        AnaMedica.setToolTipText("Anotação/Evolução Clinica");

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Código");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Nome Completo do Interno");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Data");

        jIdEvolucaoMedica.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdEvolucaoMedica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdEvolucaoMedica.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdEvolucaoMedica.setEnabled(false);

        jNomeCompletoInternoEvolucaoMedica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeCompletoInternoEvolucaoMedica.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeCompletoInternoEvolucaoMedica.setEnabled(false);

        jDataEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEvolucao.setEnabled(false);

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setText("PA");

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 0, 0));
        jLabel76.setText("*");

        jComboBoxPatologiaAdquiridaMedica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPatologiaAdquiridaMedica.setForeground(new java.awt.Color(255, 0, 0));
        jComboBoxPatologiaAdquiridaMedica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim", "Sanado" }));
        jComboBoxPatologiaAdquiridaMedica.setToolTipText("Patologia Adiquirida");
        jComboBoxPatologiaAdquiridaMedica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPatologiaAdquiridaMedica.setEnabled(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdEvolucaoMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jDataEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel76))
                    .addComponent(jComboBoxPatologiaAdquiridaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeCompletoInternoEvolucaoMedica)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(jLabel76)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxPatologiaAdquiridaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jIdEvolucaoMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNomeCompletoInternoEvolucaoMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDataEvolucao, jIdEvolucaoMedica, jNomeCompletoInternoEvolucaoMedica});

        jTextoEvolucaoMedica.setColumns(20);
        jTextoEvolucaoMedica.setRows(5);
        jTextoEvolucaoMedica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoEvolucaoMedica.setEnabled(false);
        jScrollPane5.setViewportView(jTextoEvolucaoMedica);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Dados Clinicos Resumidos - (Anotação/Evolução Médica)");

        jBtNovaEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaEvolucao.setText("Novo");
        jBtNovaEvolucao.setEnabled(false);
        jBtNovaEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaEvolucaoActionPerformed(evt);
            }
        });

        jBtAlterarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarEvolucao.setText("Alterar");
        jBtAlterarEvolucao.setEnabled(false);
        jBtAlterarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarEvolucaoActionPerformed(evt);
            }
        });

        jBtExcluirEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirEvolucao.setText("Excluir");
        jBtExcluirEvolucao.setEnabled(false);
        jBtExcluirEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEvolucaoActionPerformed(evt);
            }
        });

        jBtSalvarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarEvolucao.setText("Gravar");
        jBtSalvarEvolucao.setEnabled(false);
        jBtSalvarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEvolucaoActionPerformed(evt);
            }
        });

        jBtCancelarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEvolucao.setText("Cancelar");
        jBtCancelarEvolucao.setEnabled(false);
        jBtCancelarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarEvolucaoActionPerformed(evt);
            }
        });

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtPatologiasClinica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtPatologiasClinica.setForeground(new java.awt.Color(255, 0, 0));
        jBtPatologiasClinica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtPatologiasClinica.setText("Patologias");
        jBtPatologiasClinica.setToolTipText("Cadastrar Patologias");
        jBtPatologiasClinica.setEnabled(false);
        jBtPatologiasClinica.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtPatologiasClinica.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtPatologiasClinica.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtPatologiasClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPatologiasClinicaActionPerformed(evt);
            }
        });

        jBtExamesClinicos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtExamesClinicos.setForeground(new java.awt.Color(51, 153, 0));
        jBtExamesClinicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtExamesClinicos.setText("Exames");
        jBtExamesClinicos.setToolTipText("Solicitar Exames");
        jBtExamesClinicos.setEnabled(false);
        jBtExamesClinicos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExamesClinicos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExamesClinicos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExamesClinicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExamesClinicosActionPerformed(evt);
            }
        });

        jBtEncaminhamentoClinico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtEncaminhamentoClinico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/high-security-icone-8352-16.png"))); // NOI18N
        jBtEncaminhamentoClinico.setText("Encamin.");
        jBtEncaminhamentoClinico.setToolTipText("Encaminhamentos");
        jBtEncaminhamentoClinico.setEnabled(false);
        jBtEncaminhamentoClinico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtEncaminhamentoClinico.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtEncaminhamentoClinico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtEncaminhamentoClinico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEncaminhamentoClinicoActionPerformed(evt);
            }
        });

        jBtAuditoriaEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaEvolucao.setContentAreaFilled(false);
        jBtAuditoriaEvolucao.setEnabled(false);
        jBtAuditoriaEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaEvolucaoActionPerformed(evt);
            }
        });

        jBtPesquisaEvolucaoMedica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaEvolucaoMedica.setContentAreaFilled(false);
        jBtPesquisaEvolucaoMedica.setEnabled(false);
        jBtPesquisaEvolucaoMedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaEvolucaoMedicaActionPerformed(evt);
            }
        });

        jTotalRegistrosMed.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTotalRegistrosMed.setForeground(new java.awt.Color(255, 0, 0));
        jTotalRegistrosMed.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTotalRegistrosMed.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtVacinasClinicas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtVacinasClinicas.setForeground(new java.awt.Color(0, 0, 255));
        jBtVacinasClinicas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/viruskiller-icone-5641-16.png"))); // NOI18N
        jBtVacinasClinicas.setText("Vacinas");
        jBtVacinasClinicas.setToolTipText("Consulta de Vacinas");
        jBtVacinasClinicas.setEnabled(false);
        jBtVacinasClinicas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtVacinasClinicas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtVacinasClinicas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtVacinasClinicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVacinasClinicasActionPerformed(evt);
            }
        });

        jBtImpressaoEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressaoEvolucao.setToolTipText("Impressão de Evolução");
        jBtImpressaoEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoEvolucaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTotalRegistrosMed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtVacinasClinicas, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jBtPesquisaEvolucaoMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAuditoriaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtImpressaoEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtEncaminhamentoClinico, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExamesClinicos, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPatologiasClinica))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtEncaminhamentoClinico, jBtExamesClinicos, jBtPatologiasClinica});

        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtPatologiasClinica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExamesClinicos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtVacinasClinicas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtEncaminhamentoClinico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBtAuditoriaEvolucao, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBtPesquisaEvolucaoMedica, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jBtImpressaoEvolucao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTotalRegistrosMed, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabelaEvolucaoMedica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEvolucaoMedica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "PA", "Anotação/Evolução Médica"
            }
        ));
        jTabelaEvolucaoMedica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEvolucaoMedicaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaEvolucaoMedica);
        if (jTabelaEvolucaoMedica.getColumnModel().getColumnCount() > 0) {
            jTabelaEvolucaoMedica.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaEvolucaoMedica.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaEvolucaoMedica.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaEvolucaoMedica.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaEvolucaoMedica.getColumnModel().getColumn(2).setMinWidth(60);
            jTabelaEvolucaoMedica.getColumnModel().getColumn(2).setMaxWidth(60);
            jTabelaEvolucaoMedica.getColumnModel().getColumn(3).setMinWidth(400);
            jTabelaEvolucaoMedica.getColumnModel().getColumn(3).setMaxWidth(400);
        }

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel69.setText("Hipóteses Diagnósticas");

        jExamesSolcitadosMedicos.setColumns(20);
        jExamesSolcitadosMedicos.setRows(5);
        jExamesSolcitadosMedicos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jExamesSolcitadosMedicos.setEnabled(false);
        jScrollPane15.setViewportView(jExamesSolcitadosMedicos);

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Resultado de Exames");

        jHipotestesDiagnosticosMedico.setColumns(20);
        jHipotestesDiagnosticosMedico.setRows(5);
        jHipotestesDiagnosticosMedico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHipotestesDiagnosticosMedico.setEnabled(false);
        jScrollPane16.setViewportView(jHipotestesDiagnosticosMedico);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/nurse.png"))); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 0, 0));
        jLabel77.setText("*(PA - Patologia Adquirida)");

        javax.swing.GroupLayout AnaMedicaLayout = new javax.swing.GroupLayout(AnaMedica);
        AnaMedica.setLayout(AnaMedicaLayout);
        AnaMedicaLayout.setHorizontalGroup(
            AnaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnaMedicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AnaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AnaMedicaLayout.createSequentialGroup()
                        .addGroup(AnaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AnaMedicaLayout.createSequentialGroup()
                                .addComponent(jBtNovaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtAlterarEvolucao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtExcluirEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtSalvarEvolucao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtCancelarEvolucao))
                            .addComponent(jLabel69)
                            .addComponent(jLabel51))
                        .addGap(138, 157, Short.MAX_VALUE))
                    .addGroup(AnaMedicaLayout.createSequentialGroup()
                        .addGroup(AnaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AnaMedicaLayout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(122, 122, 122)
                                .addComponent(jLabel77))
                            .addGroup(AnaMedicaLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AnaMedicaLayout.createSequentialGroup()
                                .addGroup(AnaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        AnaMedicaLayout.setVerticalGroup(
            AnaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnaMedicaLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(AnaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(AnaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel77))
                .addGap(6, 6, 6)
                .addGroup(AnaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AnaMedicaLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AnaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jBtNovaEvolucao)
                            .addComponent(jBtCancelarEvolucao)
                            .addComponent(jBtSalvarEvolucao)
                            .addComponent(jBtExcluirEvolucao)
                            .addComponent(jBtAlterarEvolucao)))
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        jTabbedPane1.addTab("Anota./Evolu. Médica", null, AnaMedica, "Evolução Médica");

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Código");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Nome Completo do Interno");

        jIdPrescricaoMedica.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdPrescricaoMedica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdPrescricaoMedica.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdPrescricaoMedica.setEnabled(false);

        jNomeInternoCrcPM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoCrcPM.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeInternoCrcPM.setEnabled(false);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Data");

        jDataPM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPM.setEnabled(false);

        jTabelaPrescricaoMedica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPrescricaoMedica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Prescrição Médica/Psquiatrica"
            }
        ));
        jTabelaPrescricaoMedica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPrescricaoMedicaMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTabelaPrescricaoMedica);
        if (jTabelaPrescricaoMedica.getColumnModel().getColumnCount() > 0) {
            jTabelaPrescricaoMedica.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaPrescricaoMedica.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaPrescricaoMedica.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaPrescricaoMedica.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaPrescricaoMedica.getColumnModel().getColumn(2).setMinWidth(400);
            jTabelaPrescricaoMedica.getColumnModel().getColumn(2).setMaxWidth(400);
        }

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovaPrescicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaPrescicao.setText("Novo");
        jBtNovaPrescicao.setEnabled(false);
        jBtNovaPrescicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaPrescicaoActionPerformed(evt);
            }
        });

        jBtAlterarPrescicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarPrescicao.setText("Alterar");
        jBtAlterarPrescicao.setEnabled(false);
        jBtAlterarPrescicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarPrescicaoActionPerformed(evt);
            }
        });

        jBtExcluirPrescicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirPrescicao.setText("Excluir");
        jBtExcluirPrescicao.setEnabled(false);
        jBtExcluirPrescicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirPrescicaoActionPerformed(evt);
            }
        });

        jBtSalvarPrescicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarPrescicao.setText("Gravar");
        jBtSalvarPrescicao.setEnabled(false);
        jBtSalvarPrescicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarPrescicaoActionPerformed(evt);
            }
        });

        jBtCancelarPrescicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarPrescicao.setText("Cancelar");
        jBtCancelarPrescicao.setEnabled(false);
        jBtCancelarPrescicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarPrescicaoActionPerformed(evt);
            }
        });

        jBtImpressaoPrescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressaoPrescricao.setEnabled(false);
        jBtImpressaoPrescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoPrescricaoActionPerformed(evt);
            }
        });

        jBtAuditoriaPrescicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaPrescicao.setContentAreaFilled(false);
        jBtAuditoriaPrescicao.setEnabled(false);
        jBtAuditoriaPrescicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaPrescicaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jBtExcluirPrescicao, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtImpressaoPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtAuditoriaPrescicao, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jBtNovaPrescicao, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtSalvarPrescicao))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jBtAlterarPrescicao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtCancelarPrescicao)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarPrescicao, jBtCancelarPrescicao, jBtExcluirPrescicao, jBtNovaPrescicao, jBtSalvarPrescicao});

        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtNovaPrescicao)
                    .addComponent(jBtSalvarPrescicao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtAlterarPrescicao)
                    .addComponent(jBtCancelarPrescicao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtExcluirPrescicao)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jBtImpressaoPrescricao)
                        .addComponent(jBtAuditoriaPrescicao, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonGroupPrescricao.add(jRBPrescricaoMedica);
        jRBPrescricaoMedica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBPrescricaoMedica.setForeground(new java.awt.Color(255, 0, 0));
        jRBPrescricaoMedica.setSelected(true);
        jRBPrescricaoMedica.setText("Prescrição Médica");
        jRBPrescricaoMedica.setEnabled(false);

        buttonGroupPrescricao.add(jRBPrescricaoPsiquiatrica);
        jRBPrescricaoPsiquiatrica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBPrescricaoPsiquiatrica.setForeground(new java.awt.Color(0, 0, 255));
        jRBPrescricaoPsiquiatrica.setText("Prescrição Psiquiatrica");
        jRBPrescricaoPsiquiatrica.setEnabled(false);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jIdPrescricaoMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jNomeInternoCrcPM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jDataPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addComponent(jRBPrescricaoMedica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRBPrescricaoPsiquiatrica)
                .addGap(119, 119, 119))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPM, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jIdPrescricaoMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNomeInternoCrcPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBPrescricaoMedica)
                    .addComponent(jRBPrescricaoPsiquiatrica))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel23Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDataPM, jIdPrescricaoMedica, jNomeInternoCrcPM});

        jTextoPrescricaoMedica.setColumns(20);
        jTextoPrescricaoMedica.setRows(5);
        jTextoPrescricaoMedica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoPrescricaoMedica.setEnabled(false);
        jScrollPane7.setViewportView(jTextoPrescricaoMedica);

        javax.swing.GroupLayout PrescricaoMedicaLayout = new javax.swing.GroupLayout(PrescricaoMedica);
        PrescricaoMedica.setLayout(PrescricaoMedicaLayout);
        PrescricaoMedicaLayout.setHorizontalGroup(
            PrescricaoMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrescricaoMedicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PrescricaoMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7))
                .addContainerGap())
        );
        PrescricaoMedicaLayout.setVerticalGroup(
            PrescricaoMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrescricaoMedicaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pre. Médica", null, PrescricaoMedica, "Prescrição Médica");

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTabelaAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAtestado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Modelo"
            }
        ));
        jTabelaAtestado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAtestadoMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTabelaAtestado);
        if (jTabelaAtestado.getColumnModel().getColumnCount() > 0) {
            jTabelaAtestado.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaAtestado.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaAtestado.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaAtestado.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaAtestado.getColumnModel().getColumn(2).setMinWidth(220);
            jTabelaAtestado.getColumnModel().getColumn(2).setMaxWidth(220);
        }

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Código");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Nome Completo do Interno");

        jIdAtestado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdAtestado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdAtestado.setEnabled(false);

        jNomeInternoAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoAtestado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeInternoAtestado.setEnabled(false);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Data");

        jDataAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAtestado.setEnabled(false);

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovoAtestado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoAtestado.setText("Novo");
        jBtNovoAtestado.setEnabled(false);
        jBtNovoAtestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoAtestadoActionPerformed(evt);
            }
        });

        jBtAlterarAtestado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarAtestado.setText("Alterar");
        jBtAlterarAtestado.setEnabled(false);
        jBtAlterarAtestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarAtestadoActionPerformed(evt);
            }
        });

        jBtExcluirAtestado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirAtestado.setText("Excluir");
        jBtExcluirAtestado.setEnabled(false);
        jBtExcluirAtestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirAtestadoActionPerformed(evt);
            }
        });

        jBtImprimirAtestado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImprimirAtestado.setToolTipText("Imprimir");
        jBtImprimirAtestado.setEnabled(false);
        jBtImprimirAtestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImprimirAtestadoActionPerformed(evt);
            }
        });

        jBtSalvarAtestado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarAtestado.setText("Gravar");
        jBtSalvarAtestado.setEnabled(false);
        jBtSalvarAtestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarAtestadoActionPerformed(evt);
            }
        });

        jBtCancelarAtestado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarAtestado.setText("Cancelar");
        jBtCancelarAtestado.setEnabled(false);
        jBtCancelarAtestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarAtestadoActionPerformed(evt);
            }
        });

        jBtAuditoriaAtestado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaAtestado.setToolTipText("Auditoria");
        jBtAuditoriaAtestado.setContentAreaFilled(false);
        jBtAuditoriaAtestado.setEnabled(false);
        jBtAuditoriaAtestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaAtestadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtExcluirAtestado)
                            .addComponent(jBtAlterarAtestado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtSalvarAtestado)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jBtImprimirAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtAuditoriaAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jBtNovoAtestado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelarAtestado)))
                .addContainerGap())
        );

        jPanel27Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarAtestado, jBtCancelarAtestado, jBtExcluirAtestado, jBtNovoAtestado, jBtSalvarAtestado});

        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtNovoAtestado)
                    .addComponent(jBtCancelarAtestado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtAlterarAtestado)
                    .addComponent(jBtSalvarAtestado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtImprimirAtestado)
                    .addComponent(jBtExcluirAtestado)
                    .addComponent(jBtAuditoriaAtestado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel27Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarAtestado, jBtCancelarAtestado, jBtExcluirAtestado, jBtImprimirAtestado, jBtNovoAtestado, jBtSalvarAtestado});

        buttonGroupModelo.add(jRadioBtModeloA);
        jRadioBtModeloA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtModeloA.setForeground(new java.awt.Color(255, 0, 0));
        jRadioBtModeloA.setText("Modelo A");
        jRadioBtModeloA.setEnabled(false);
        jRadioBtModeloA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioBtModeloAMouseClicked(evt);
            }
        });

        buttonGroupModelo.add(jRadioBtModeloB);
        jRadioBtModeloB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtModeloB.setForeground(new java.awt.Color(0, 0, 255));
        jRadioBtModeloB.setText("Modelo B");
        jRadioBtModeloB.setEnabled(false);
        jRadioBtModeloB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioBtModeloBMouseClicked(evt);
            }
        });

        buttonGroupModelo.add(jRadioBtModeloC);
        jRadioBtModeloC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtModeloC.setForeground(new java.awt.Color(0, 153, 0));
        jRadioBtModeloC.setText("Modelo C");
        jRadioBtModeloC.setEnabled(false);
        jRadioBtModeloC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioBtModeloCMouseClicked(evt);
            }
        });

        buttonGroupModelo.add(jRadioBtModeloAleatorio);
        jRadioBtModeloAleatorio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioBtModeloAleatorio.setForeground(new java.awt.Color(153, 0, 102));
        jRadioBtModeloAleatorio.setSelected(true);
        jRadioBtModeloAleatorio.setText("Modelo Aleatório");
        jRadioBtModeloAleatorio.setEnabled(false);
        jRadioBtModeloAleatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioBtModeloAleatorioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jIdAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jNomeInternoAtestado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jDataAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jRadioBtModeloA)
                .addGap(18, 18, 18)
                .addComponent(jRadioBtModeloB)
                .addGap(18, 18, 18)
                .addComponent(jRadioBtModeloC)
                .addGap(18, 18, 18)
                .addComponent(jRadioBtModeloAleatorio)
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel29))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jIdAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNomeInternoAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jDataAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRadioBtModeloA)
                    .addComponent(jRadioBtModeloB)
                    .addComponent(jRadioBtModeloC)
                    .addComponent(jRadioBtModeloAleatorio))
                .addGap(235, 235, 235))
        );

        jPanel26Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel27, jScrollPane10});

        jTextoAtestado.setColumns(20);
        jTextoAtestado.setRows(5);
        jTextoAtestado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoAtestado.setEnabled(false);
        jScrollPane9.setViewportView(jTextoAtestado);

        javax.swing.GroupLayout AtestadoLayout = new javax.swing.GroupLayout(Atestado);
        Atestado.setLayout(AtestadoLayout);
        AtestadoLayout.setHorizontalGroup(
            AtestadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AtestadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AtestadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9))
                .addContainerGap())
        );
        AtestadoLayout.setVerticalGroup(
            AtestadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AtestadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Atestado", null, Atestado, "Atestado Médico/Psiquiatrico");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Código");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Nome Completo do Interno");

        jIdDieta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdDieta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdDieta.setEnabled(false);

        jNomeInternoDieta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoDieta.setEnabled(false);

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Data");

        jDataDieta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataDieta.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jIdDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeInternoDieta)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(0, 259, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInternoDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDataDieta, jIdDieta, jNomeInternoDieta});

        jTablaDieta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTablaDieta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Descrição da Dieta Médica"
            }
        ));
        jTablaDieta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaDietaMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTablaDieta);
        if (jTablaDieta.getColumnModel().getColumnCount() > 0) {
            jTablaDieta.getColumnModel().getColumn(0).setMinWidth(50);
            jTablaDieta.getColumnModel().getColumn(0).setMaxWidth(50);
            jTablaDieta.getColumnModel().getColumn(1).setMinWidth(80);
            jTablaDieta.getColumnModel().getColumn(1).setMaxWidth(80);
            jTablaDieta.getColumnModel().getColumn(2).setMinWidth(400);
            jTablaDieta.getColumnModel().getColumn(2).setMaxWidth(400);
        }

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovaDieta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaDieta.setText("Novo");
        jBtNovaDieta.setEnabled(false);
        jBtNovaDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaDietaActionPerformed(evt);
            }
        });

        jBtAlterarDieta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarDieta.setText("Alterar");
        jBtAlterarDieta.setEnabled(false);
        jBtAlterarDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarDietaActionPerformed(evt);
            }
        });

        jBtExcluirDieta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirDieta.setText("Excluir");
        jBtExcluirDieta.setEnabled(false);
        jBtExcluirDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirDietaActionPerformed(evt);
            }
        });

        jBtSalvarDieta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarDieta.setText("Gravar");
        jBtSalvarDieta.setEnabled(false);
        jBtSalvarDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarDietaActionPerformed(evt);
            }
        });

        jBtCancelarDieta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarDieta.setText("Cancelar");
        jBtCancelarDieta.setEnabled(false);
        jBtCancelarDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarDietaActionPerformed(evt);
            }
        });

        jBtImprimirDieta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImprimirDieta.setToolTipText("Imprimir Dieta");
        jBtImprimirDieta.setContentAreaFilled(false);
        jBtImprimirDieta.setEnabled(false);
        jBtImprimirDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImprimirDietaActionPerformed(evt);
            }
        });

        jBtAuditoriaDieta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaDieta.setToolTipText("Auditoria");
        jBtAuditoriaDieta.setContentAreaFilled(false);
        jBtAuditoriaDieta.setEnabled(false);
        jBtAuditoriaDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaDietaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtNovaDieta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtAlterarDieta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtExcluirDieta))
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtCancelarDieta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtSalvarDieta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jBtImprimirDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAuditoriaDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarDieta, jBtCancelarDieta, jBtExcluirDieta, jBtNovaDieta, jBtSalvarDieta});

        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtNovaDieta)
                    .addComponent(jBtSalvarDieta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtAlterarDieta)
                    .addComponent(jBtCancelarDieta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtExcluirDieta)
                    .addComponent(jBtImprimirDieta)
                    .addComponent(jBtAuditoriaDieta))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextoDieta.setColumns(20);
        jTextoDieta.setRows(5);
        jTextoDieta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoDieta.setEnabled(false);
        jScrollPane12.setViewportView(jTextoDieta);

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel71.setText("Texto da Dieta");

        javax.swing.GroupLayout DietaMedicaLayout = new javax.swing.GroupLayout(DietaMedica);
        DietaMedica.setLayout(DietaMedicaLayout);
        DietaMedicaLayout.setHorizontalGroup(
            DietaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DietaMedicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DietaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane12)
                    .addGroup(DietaMedicaLayout.createSequentialGroup()
                        .addComponent(jLabel71)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(DietaMedicaLayout.createSequentialGroup()
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        DietaMedicaLayout.setVerticalGroup(
            DietaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DietaMedicaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DietaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel71)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dieta", null, DietaMedica, "Dieta Médica");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        setBounds(300, 10, 643, 529);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        jTabelaMedico.setVisible(true);
        preencherAdmissaoMedica("SELECT * FROM ADMISSAOMEDICA "
                + "INNER JOIN PRONTUARIOSCRC "
                + "ON ADMISSAOMEDICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                + "WHERE NomeInternoCrc LIKE'" + jPesqNomeInternoOdonto.getText() + "%'");
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jBtIdPesqAtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIdPesqAtendActionPerformed
        // TODO add your handling code here:
        flag = 1;
        jTabelaMedico.setVisible(true);
        preencherAdmissaoMedica("SELECT * FROM ADMISSAOMEDICA "
                + "INNER JOIN PRONTUARIOSCRC "
                + "ON ADMISSAOMEDICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                + "WHERE IdLanc='" + jIDPesqAtend.getText() + "'");
    }//GEN-LAST:event_jBtIdPesqAtendActionPerformed

    private void jBtPesqDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            if (jDataInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataInicial.requestFocus();
            } else {
                if (jDataFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataFinal.requestFocus();
                } else {
                    if (jDataInicial.getDate().after(jDataFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataFinal.getDate().getTime());
                        jTabelaMedico.setVisible(true);
                        preencherAdmissaoMedica("SELECT * FROM ADMISSAOMEDICA "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ADMISSAOMEDICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            if (jDataInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataInicial.requestFocus();
            } else {
                if (jDataFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataFinal.requestFocus();
                } else {
                    if (jDataInicial.getDate().after(jDataFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jDataInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataFinal.getDate().getTime());
                        jTabelaMedico.setVisible(true);
                        preencherAdmissaoMedica("SELECT * FROM ADMISSAOMEDICA "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON ADMISSAOMEDICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                                + "AND '" + dataFinal + "'");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        //telaAcessoProntuarioMedicoENF = "Movimentação:Admissão Médica de Internos:Manutenção";        
        buscarAcessoUsuario(telaAcessoProntuarioMedicoENF);
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAcessoProntuarioMedicoENF) && codIncluirENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            Novo();
            corCampos();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            limpaTabelaDoencas();
            limparTabelaEvolucaoMedica();
            limparTabelaEvolucaoPsiquiatrica();
            limparTabelaPrescricaoMedica();
            limparTabelaAtestadoMedica();
            limparTabelaDietaMedica();
            acao = 1;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir prontuário médico.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAcessoProntuarioMedicoENF);
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAcessoProntuarioMedicoENF) && codAlterarENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            objAdmMedico.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse atendimento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                Alterar();
                corCampos();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a modificar prontuário médico.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAcessoProntuarioMedicoENF);
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAcessoProntuarioMedicoENF) && codExcluirENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            atendido = "Não";
            verificarEvolucaoPsiquiatrica(); // VERIFICAR SE EXISTE EVOLUÇÃO PSICOLOGICA ANTES DE EXCLUIR
            verificarEvolucaoMedica(); // VERIFICAR SE EXISTE EVOLUÇÃO MÉDICA ANTES DE EXCLUIR
            verificarPrescricaoMedica(); // VERIFICAR SE EXISTE PRESCRIÇÃO MÉDICA/PSICOLOGICA ANTES DE EXCLUIR
            verificarAtestadoMedico(); // VERIFICAR SE EXISTE ATESTADO
            verificarDietaMedica(); // VERIFICAR SE EXISTE DIETA MÉDICA
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objAdmMedico.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse atendimento não poderá ser excluido, o mesmo encontra-se FINALIZADO");
            } else {
                if (jIdAdm.getText().equals(codPsiquiatrico)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, existe uma Anamnese Psiquiatrica para o interno.");
                } else if (jIdAdm.getText().equals(codMedico)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, existe uma Anamnese Médica para o interno.");
                } else if (jIdAdm.getText().equals(codPrescricao)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, existe uma Prescrição Médica para o interno.");
                } else if (jIdAdm.getText().equals(codAtestado)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, existe um Atestado Médico para o interno.");
                } else if (jIdAdm.getText().equals(codDieta)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, existe uma Dieta Médica para o interno.");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o ATENDIMENTO selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        objItensDoenca.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                        controlePat.excluirDoencas(objItensDoenca);
                        //
                        objAdmMedico.setIdLanc(Integer.parseInt(jIdAdm.getText()));
                        control.excluirAdmissaoMedica(objAdmMedico);
                        //
                        objAdmMedico.setIdLanc(Integer.parseInt(jIdAdm.getText()));
                        controle.excluirMovTec(objAdmMedico);
                        // MODIFICAR A SITUAÇÃO DO ATENDIMENTO DEIXANDO COMO "Não" FOI ATENDIDO.
                        objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                        objRegAtend.setNomeInternoCrc(jNomeInternoAdm.getText());
                        objRegAtend.setAtendido(atendido);
                        objRegAtend.setDataAtendimento(jDataAdm.getDate());
                        //
                        objRegAtend.setUsuarioUp(nameUser);
                        objRegAtend.setDataUp(dataModFinal);
                        objRegAtend.setHorarioUp(horaMov);
                        controlRegAtend.alterarRegAtend(objRegAtend);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                        Excluir();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir prontuário médico.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:  
        buscarAcessoUsuario(telaAcessoProntuarioMedicoENF);
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(telaAcessoProntuarioMedicoENF) && codGravarENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            Integer rows = jTabelaPatologia.getModel().getRowCount();
            verificarDoencas();
            if (jDataAdm.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data para admissão.");
                jDataAdm.requestFocus();
                jDataAdm.setBackground(Color.red);
            } else if (jNomeInternoAdm.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe qual é o interno para o atendimento.");
            } else if (rows == 0) {
                JOptionPane.showMessageDialog(rootPane, "Informe pelo menos um tipo de patologia.");
            } else if (jComboBoxTipoDiagnostico.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Selecione um tipo de diagnóstico.");
            } else {
                objAdmMedico.setStatusLanc(jStatusLanc.getText());
                objAdmMedico.setDataLanc(jDataAdm.getDate());
                objAdmMedico.setAr(jAR.getText());
                objAdmMedico.setAcv(jACV.getText());
                objAdmMedico.setAgu(jAGU.getText());
                objAdmMedico.setCabPesc(jCABPESC.getText());
                objAdmMedico.setExt(jEXT.getText());
                objAdmMedico.setAbd(jABD.getText());
                objAdmMedico.setDiagnostico(jTextoEvolucaoPsiquiatrica.getText());
                objAdmMedico.setCirurgiasPrevisas(jCirurgiasPrevisas.getText());
                objAdmMedico.setTratamentoCurso(jTratamentoCurso.getText());
                objAdmMedico.setDrogas((String) jComboBoxDrogas.getSelectedItem());
                objAdmMedico.setQualDrogas(jQualDrogas.getText());
                objAdmMedico.setEtilismo((String) jComboBoxEtilismo.getSelectedItem());
                objAdmMedico.setQualEtilismo(jQualEtilismo.getText());
                objAdmMedico.setTabagismo((String) jComboBoxTabagismo.getSelectedItem());
                objAdmMedico.setQuantoTempoTabagismo(jQuantoTempoTabagismo.getText());
                objAdmMedico.setVacinas((String) jComboBoxVacinas.getSelectedItem());
                objAdmMedico.setAtualizadaIgnorada((String) jComboBoxIgnoradoAtualizado.getSelectedItem());
                // INCLUSÃO DE NOVOS CAMPOS NA ADMISSÃO EM 15/06/2016
                objAdmMedico.setComboBoxAR((String) jComboBoxAR.getSelectedItem());
                objAdmMedico.setComboBoxACV((String) jComboBoxACV.getSelectedItem());
                objAdmMedico.setComboBoxAGU((String) jComboBoxAGU.getSelectedItem());
                objAdmMedico.setComboBoxCAB((String) jComboBoxCAB.getSelectedItem());
                objAdmMedico.setComboBoxEXT((String) jComboBoxEXT.getSelectedItem());
                objAdmMedico.setComboBoxABD((String) jComboBoxABD.getSelectedItem());
                objAdmMedico.setAlergia((String) jComboBoxAlergias.getSelectedItem());
                objAdmMedico.setQuaisAlergias(jQuaisAlergias.getText());
                objAdmMedico.setDrogasInjetavel((String) jComboBoxDrogasInjetavel.getSelectedItem());
                objAdmMedico.setQualTipoDrograInjet(jQualTipoDrograInjet.getText());
                objAdmMedico.setSexualidade((String) jComboBoxSexualidade.getSelectedItem());
                objAdmMedico.setNumeroParceiros((String) jComboBoxNumeroParceiro.getSelectedItem());
                objAdmMedico.setUsoPreservativos((String) jComboBoxUsaPreserva.getSelectedItem());
                objAdmMedico.setTipoSanguineo((String) jComboBoxTipoSanguineo.getSelectedItem());
                objAdmMedico.setFatorRH((String) jComboBoxFatorRH.getSelectedItem());
                objAdmMedico.setUsaMedicamentos((String) jComboBoxUsaMedicamento.getSelectedItem());
                objAdmMedico.setQualMedicacaoUsa(jQualMedicacaoUsa.getText());
                objAdmMedico.setOutrasAlergias((String) jComboBoxOutrasAlergias.getSelectedItem());
                objAdmMedico.setQuaisOutrasAlergias(jQuaisOutrasAlergias.getText());
                objAdmMedico.setDiagnostico(jDiagnosticoInicial.getText());
                objAdmMedico.setAdmEvo(admEvolucao);
                if (jComboBoxTipoDiagnostico.getSelectedItem().equals("Diagnóstico Clínico")) {
                    tipoDiagnosticoMed = 0;
                } else if (jComboBoxTipoDiagnostico.getSelectedItem().equals("Diagnóstico Psiquiatrico")) {
                    tipoDiagnosticoMed = 1;
                }
                objAdmMedico.setTipoDiagnostico(tipoDiagnosticoMed);
                if (acao == 1) {
                    // log de usuario
                    objAdmMedico.setUsuarioInsert(nameUser);
                    objAdmMedico.setDataInsert(dataModFinal);
                    objAdmMedico.setHoraInsert(horaMov);
                    objAdmMedico.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objAdmMedico.setNomeInterno(jNomeInternoAdm.getText());
                    control.incluirAdmissaoMedica(objAdmMedico);
                    buscarID();
                    objAdmMedico.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objAdmMedico.setNomeInterno(jNomeInternoAdm.getText());
                    objAdmMedico.setDeptoMedico(deptoTecnico);
                    controle.incluirMovTec(objAdmMedico);
                    // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO  
                    atendido = "Sim";
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoAdm.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoENF);
                    objRegAtend.setNomeDepartamento(nomeModuloENFER);
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                    objRegAtend.setAtendido(atendido);
                    objRegAtend.setDataAtendimento(jDataAdm.getDate());
                    objRegAtend.setIdAtend(Integer.valueOf(jIdAdm.getText()));
                    objRegAtend.setQtdAtend(pQUANTIDADE_ATENDIDA);
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegAtend(objRegAtend);
                    //
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                    
                    incluirItensDoencas();
                    if (jComboBoxTipoDiagnostico.getSelectedItem().equals("Diagnóstico Clínico")) {
                        objEvolMedica.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                        objEvolMedica.setDataEvolu(jDataAdm.getDate());
                        objEvolMedica.setTextoEvolucao(jDiagnosticoInicial.getText());
                        objEvolMedica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                        objEvolMedica.setNomeInternoEvoluMedica(jNomeInternoAdm.getText());
                        // log de usuario
                        objEvolMedica.setUsuarioInsert(nameUser);
                        objEvolMedica.setDataInsert(dataModFinal);
                        objEvolMedica.setHoraInsert(horaMov);
                        objEvolMedica.setAdmEvo(admEvolucao);
                        controleEvoluMed.incluirEvolucaoMedica(objEvolMedica);
                        //
                        buscarEvolucao();
                        preencherTabelaEvolucaoMedica("SELECT * FROM EVOLUCAOMEDICA "
                                + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    } else if (jComboBoxTipoDiagnostico.getSelectedItem().equals("Diagnóstico Psiquiatrico")) {
                        objEvolPsiquiatrica.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                        objEvolPsiquiatrica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                        objEvolPsiquiatrica.setDataDiag(jDataAdm.getDate());
                        objEvolPsiquiatrica.setEvolucaoPsiquiatrica(jDiagnosticoInicial.getText());
                        //
                        objEvolPsiquiatrica.setUsuarioInsert(nameUser);
                        objEvolPsiquiatrica.setDataInsert(dataModFinal);
                        objEvolPsiquiatrica.setHorarioInsert(horaMov);
                        objEvolMedica.setAdmEvo(admEvolucao);
                        controlEvolPsiquiatrica.incluirEvolucaoPsiquiatrica(objEvolPsiquiatrica);
                        //
                        buscarCodEvolPsiquiatrica();
                        preencherTabelaEvolucaoPsiquiatrica("SELECT * FROM EVOLUCAO_PSIQUIATRICA "
                                + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    }
                    //GRAVAR NA TABELA DE ATENDIMENTO ATENDIMENTO_PSP_INTERNO_TV    
                    objRegAtend.setStatusAtendimento(status_ATENDIMENTO);
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoAdm.getText());
                    objRegAtend.setNomeDepartamento(nomeModuloENFER);
                    objRegAtend.setConcluido(pATENDIMENTO_CONCLUIDO);
                    objRegAtend.setHorarioUp(horaMov);
                    objRegAtend.setIdAtend(Integer.valueOf(jIdAdm.getText()));
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoAdm);
                    control_ATENDE.confirmarAtendimento(objRegAtend);
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
                }
                if (acao == 2) {
                    // log de usuario
                    objAdmMedico.setUsuarioUp(nameUser);
                    objAdmMedico.setDataUp(dataModFinal);
                    objAdmMedico.setHoraUp(horaMov);
                    //
                    objAdmMedico.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objAdmMedico.setNomeInterno(jNomeInternoAdm.getText());
                    objAdmMedico.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    control.alterarAdmissaoMedica(objAdmMedico);
                    objAdmMedico.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objAdmMedico.setNomeInterno(jNomeInternoAdm.getText());
                    objAdmMedico.setDeptoMedico(deptoTecnico);
                    controle.alterarMovTec(objAdmMedico);
                    //
                    objItensDoenca.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    controlePat.excluirDoencas(objItensDoenca);
                    incluirItensDoencas();
                    // SE O INTERNO FOR MODIFICADO
                    if (!jIdInternoAdm.getText().equals(codInterno)) {
                        atendido = "Não";
                        objRegAtend.setIdInternoCrc(Integer.valueOf(codInterno));
                        objRegAtend.setNomeInternoCrc(nomeInternoAnterior);
                        objRegAtend.setAtendido(atendido);
                        objRegAtend.setDataAtendimento(jDataAdm.getDate());
                        //
                        objRegAtend.setUsuarioUp(nameUser);
                        objRegAtend.setDataUp(dataModFinal);
                        objRegAtend.setHorarioUp(horaMov);
                        controlRegAtend.alterarRegAtend(objRegAtend);
                    }
                    // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO   
                    atendido = "Sim";
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoAdm.getText());
                    objRegAtend.setAtendido(atendido);
                    objRegAtend.setDataAtendimento(jDataAdm.getDate());
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegAtend(objRegAtend);
                    if (jComboBoxTipoDiagnostico.getSelectedItem().equals("Diagnóstico Clínico")) {
                        objEvolMedica.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                        objEvolMedica.setDataEvolu(jDataAdm.getDate());
                        objEvolMedica.setTextoEvolucao(jDiagnosticoInicial.getText());
                        objEvolMedica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                        objEvolMedica.setNomeInternoEvoluMedica(jNomeInternoAdm.getText());
                        // log de usuario
                        objEvolMedica.setUsuarioInsert(nameUser);
                        objEvolMedica.setDataInsert(dataModFinal);
                        objEvolMedica.setHoraInsert(horaMov);
                        objEvolMedica.setIdItem(idItemEvol);
                        controleEvoluMed.alterarEvolucaoMedica(objEvolMedica);
                        //                        
                        preencherTabelaEvolucaoMedica("SELECT * FROM EVOLUCAOMEDICA "
                                + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    } else if (jComboBoxTipoDiagnostico.getSelectedItem().equals("Diagnóstico Psiquiatrico")) {
                        objEvolPsiquiatrica.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                        objEvolPsiquiatrica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                        objEvolPsiquiatrica.setDataDiag(jDataAdm.getDate());
                        objEvolPsiquiatrica.setEvolucaoPsiquiatrica(jDiagnosticoInicial.getText());
                        //
                        objEvolPsiquiatrica.setUsuarioInsert(nameUser);
                        objEvolPsiquiatrica.setDataInsert(dataModFinal);
                        objEvolPsiquiatrica.setHorarioInsert(horaMov);
                        objEvolPsiquiatrica.setIdItem(idItemEvolPsiquiatrico);
                        controlEvolPsiquiatrica.alterarEvolucaoPsiquiatrica(objEvolPsiquiatrica);
                        //                        
                        preencherTabelaEvolucaoPsiquiatrica("SELECT * FROM EVOLUCAO_PSIQUIATRICA "
                                + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    }
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
                    acao = 0;
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar no prontuário médico.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        acao = 0;
        Cancelar();
        //EXCLUIR O REGISTRO DA TABELA ATENDIMENTO_PSP_INTERNO_TV CASO O ATENDENTE NÃO CONFIRMOU O ATENDIMENTO
//        if (jIdAdm.getText().equals("")) {
//            objRegAtend.setIdAPIT(CODIGO_ATENDIMENTO_TV_ADM);
//            control_ATENDE.excluirAtendimento(objRegAtend);
//        }
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOMEDICA WHERE IdLanc='" + jIdAdm.getText() + "'");
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

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        //EXCLUIR O REGISTRO DA TABELA ATENDIMENTO_PSP_INTERNO_TV CASO O ATENDENTE NÃO CONFIRMOU O ATENDIMENTO
//        if (jIdAdm.getText().equals("")) {
//            objRegAtend.setIdAPIT(CODIGO_ATENDIMENTO_TV_ADM);
//            control_ATENDE.excluirAtendimento(objRegAtend);
//        }
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaMedicoMouseClicked
        // TODO add your handling code here:         
        countp = 0;
        countm = 0;
        countpm = 0;
        counta = 0;
        countd = 0;
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaMedico.getValueAt(jTabelaMedico.getSelectedRow(), 0);
            jIDPesqAtend.setText(IdLanc);
            //  
            jBtNovo.setEnabled(!true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtNovaEvolPsiquiatrica.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
            jBtPesquisaEvolucaoPsi.setEnabled(true);
            jBtPesquisaEvolucaoMedica.setEnabled(true);
            //
            jBtPatologias.setEnabled(true);
            jBtExames.setEnabled(true);
            jBtVacinas.setEnabled(true);
            jBtEncaminhamentoPsi.setEnabled(true);
            jBtEncaminhamentoClinico.setEnabled(true);
            //
            jBtPatologiasClinica.setEnabled(true);
            jBtExamesClinicos.setEnabled(true);
            jBtVacinasClinicas.setEnabled(true);
            jBtEncaminhamentoClinico.setEnabled(true);
            //
            jBtNovaPrescicao.setEnabled(true);
            //
            jBtNovoAtestado.setEnabled(true);
            jDataAtestado.setEnabled(!true);
            jRadioBtModeloA.setEnabled(!true);
            jRadioBtModeloB.setEnabled(!true);
            jRadioBtModeloC.setEnabled(!true);
            jRadioBtModeloAleatorio.setEnabled(!true);
            //
            jBtNovaDieta.setEnabled(true);
            //
            limparCampos();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ADMISSAOMEDICA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ADMISSAOMEDICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                jIdAdm.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                jDataAdm.setDate(conecta.rs.getDate("DataLanc"));
                // VARIÁVEL QUE NÃO DEIXA MUDAR O INTERNO SE EXISTIR ANAMNESES OU ATESTADO, DIETA E OUTROS.
                codInterno = conecta.rs.getString("IdInternoCrc");
                nomeInternoAnterior = conecta.rs.getString("NomeInternoCrc");
                jIdInternoAdm.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoAdm.setText(conecta.rs.getString("NomeInternoCrc"));
                jDataNascAdm.setDate(conecta.rs.getDate("DataNasciCrc"));
                jSexo.setText(conecta.rs.getString("SexoCrc"));
                jNomeMaeInterno.setText(conecta.rs.getString("MaeInternoCrc"));
                jMatriculaPenal.setText(conecta.rs.getString("MatriculaCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoAdm.setIcon(i);
                jFotoInternoAdm.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoAdm.getWidth(), jFotoInternoAdm.getHeight(), Image.SCALE_DEFAULT)));
                //
                jAR.setText(conecta.rs.getString("AR"));
                jACV.setText(conecta.rs.getString("ACV"));
                jAGU.setText(conecta.rs.getString("AGU"));
                jCABPESC.setText(conecta.rs.getString("CABPESC"));
                jEXT.setText(conecta.rs.getString("EXT"));
                jABD.setText(conecta.rs.getString("ABD"));
                //jDiagnostico.setText("Diagnostico");
                jCirurgiasPrevisas.setText(conecta.rs.getString("CirurgiasPrevisas"));
                jTratamentoCurso.setText(conecta.rs.getString("TratamentoCurso"));
                jQualDrogas.setText(conecta.rs.getString("QualDrogas"));
                jQualEtilismo.setText(conecta.rs.getString("QualEtilismo"));
                jQuantoTempoTabagismo.setText(conecta.rs.getString("QuantoTempoTabagismo"));
                jComboBoxDrogas.setSelectedItem(conecta.rs.getString("Drogas"));
                jComboBoxEtilismo.setSelectedItem(conecta.rs.getString("Etilismo"));
                jComboBoxTabagismo.setSelectedItem(conecta.rs.getString("Tabagismo"));
                jComboBoxVacinas.setSelectedItem(conecta.rs.getString("Vacinas"));
                jComboBoxIgnoradoAtualizado.setSelectedItem(conecta.rs.getString("AtualizaIgnora"));
                // ATUALIZAÇÃO DE CAMPOS EM 15/06/2016
                jComboBoxAR.setSelectedItem(conecta.rs.getString("CombBoxAR"));
                jComboBoxACV.setSelectedItem(conecta.rs.getString("CombBoxACV"));
                jComboBoxAGU.setSelectedItem(conecta.rs.getString("CombBoxAGU"));
                jComboBoxCAB.setSelectedItem(conecta.rs.getString("CombBoxCABPESC"));
                jComboBoxEXT.setSelectedItem(conecta.rs.getString("CombBoxEXT"));
                jComboBoxABD.setSelectedItem(conecta.rs.getString("CombBoxABD"));
                jComboBoxAlergias.setSelectedItem(conecta.rs.getString("Alergia"));
                jQuaisAlergias.setText(conecta.rs.getString("QuaisAlergias"));
                jComboBoxDrogasInjetavel.setSelectedItem(conecta.rs.getString("DrogaInjetavel"));
                jQualTipoDrograInjet.setText(conecta.rs.getString("QualTipoDrogaInjet"));
                jComboBoxSexualidade.setSelectedItem(conecta.rs.getString("Sexualidade"));
                jComboBoxNumeroParceiro.setSelectedItem(conecta.rs.getString("NumeroPareceiro"));
                jComboBoxUsaPreserva.setSelectedItem(conecta.rs.getString("UsaPreserva"));
                jComboBoxTipoSanguineo.setSelectedItem(conecta.rs.getString("TipoSangue"));
                jComboBoxFatorRH.setSelectedItem(conecta.rs.getString("FatorRh"));
                jComboBoxUsaMedicamento.setSelectedItem(conecta.rs.getString("UsaMedicamento"));
                jQualMedicacaoUsa.setText(conecta.rs.getString("QualMedicamento"));
                jComboBoxOutrasAlergias.setSelectedItem(conecta.rs.getString("OutrasAlergias"));
                jQuaisOutrasAlergias.setText(conecta.rs.getString("QuaisOutrasAlergias"));
                jDiagnosticoInicial.setText(conecta.rs.getString("DiagnosticoInicial"));
                tipoDiagnosticoMed = conecta.rs.getInt("TipoDiag");
                if (tipoDiagnosticoMed == 0) {
                    jComboBoxTipoDiagnostico.setSelectedItem("Diagnóstico Clínico");
                } else if (tipoDiagnosticoMed == 1) {
                    jComboBoxTipoDiagnostico.setSelectedItem("Diagnóstico Psiquiatrico");
                }
                //           
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa..." + e);
            }
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ITENSADMISSAODOENCAS "
                        + "INNER JOIN DOENCAS "
                        + "ON ITENSADMISSAODOENCAS.IdDoenca=DOENCAS.IdDoenca "
                        + "WHERE IdLanc='" + IdLanc + "'");
                conecta.rs.first();
                idItem = conecta.rs.getInt("IdItem");
                DefaultTableModel dtmDoencas = (DefaultTableModel) jTabelaPatologia.getModel();
                dtmDoencas.getDataVector().clear(); // limpa a tabela 
                do {
                    dtmDoencas.addRow(new Object[]{conecta.rs.getInt("IdDoenca"), conecta.rs.getString("Descricao"), conecta.rs.getString("Cid")});
                } while (conecta.rs.next());

            } catch (SQLException ex) {
            }
            conecta.desconecta();
            // TABELA DE EVOLUÇÃO PSIQUIATRICA
            preencherTabelaEvolucaoPsiquiatrica("SELECT * FROM EVOLUCAO_PSIQUIATRICA WHERE IdLanc='" + jIdAdm.getText() + "'");
            // TABELA DE EVOLUÇÃO MÉDICA
            preencherTabelaEvolucaoMedica("SELECT * FROM EVOLUCAOMEDICA "
                    + "WHERE IdLanc='" + jIdAdm.getText() + "'");
            // TABELA DE PRESCRIÇÃO MÉDICA/PSIQUIATRICA
            pesquisarPrescricao();
            if (tipoPrescricao == 0 || tipoPrescricao == 1) {
                preencherTabelaPrescricaoMedica("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA "
                        + "WHERE IdLanc='" + jIdAdm.getText() + "' "
                        + "AND TipoP='" + tipoPM + "' "
                        + "OR IdLanc='" + jIdAdm.getText() + "' "
                        + "AND TipoP='" + tipoPP + "'");
            }
            // TABELA DE ATESTADO MÉDICO
            preencherTabelaAtestadoMedica("SELECT * FROM ATESTADO_MEDICO_PSIQUIATRICO "
                    + "WHERE IdLanc='" + jIdAdm.getText() + "'");
            // TABELA DE DIETA MÉDICA
            preencherTabelaDietaMedica("SELECT * FROM DIETA_MEDICA_PSIQUIATRICA "
                    + "WHERE IdLanc='" + jIdAdm.getText() + "'");
        }
    }//GEN-LAST:event_jTabelaMedicoMouseClicked

    private void jBtPesqInternoAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqInternoAdmActionPerformed
        // TODO add your handling code here:     
        verificarRegistroBiometria();
        if (pHabilitaMedico.equals("Não")) {
            TelaPesqInternoADMedicoSB objPesqAdmMedico = new TelaPesqInternoADMedicoSB();
            TelaModuloEnfermaria.jPainelMedico.add(objPesqAdmMedico);
            objPesqAdmMedico.show();
        } else {
            TelaPesqInternoAdmMedico objPesqAdmMedico = new TelaPesqInternoAdmMedico();
            TelaModuloEnfermaria.jPainelMedico.add(objPesqAdmMedico);
            objPesqAdmMedico.show();
        }
    }//GEN-LAST:event_jBtPesqInternoAdmActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherAdmissaoMedica("SELECT * FROM ADMISSAOMEDICA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ADMISSAOMEDICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc");
        } else {
            count = 0;
            jtotalRegistros.setText("");
            limparTabelaAdmissao();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAdmissaoMedica objAudMed = new TelaAuditoriaAdmissaoMedica();
        TelaModuloEnfermaria.jPainelMedico.add(objAudMed);
        objAudMed.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtNovaEvolPsiquiatricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaEvolPsiquiatricaActionPerformed
        // TODO add your handling code here:              
        buscarAcessoUsuarioPsiquiatra();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela2) && codIncluirENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            verificarInternoRegistradoAdm();
            if (atendido == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
            } else if (atendido.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
            } else if (atendido.equals("Sim")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
            } else if (atendido.equals("Não")) {
                acao = 3;
                NovaEvolPsiquiatrica();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir prontuário médico.");
        }
    }//GEN-LAST:event_jBtNovaEvolPsiquiatricaActionPerformed

    private void jBtAlterarEvolPsiquiatricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEvolPsiquiatricaActionPerformed
        // TODO add your handling code here: 
        buscarAcessoUsuarioPsiquiatra();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela2) && codAlterarENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EVOLUCAO_PSIQUIATRICA "
                        + "WHERE IdItem='" + jIdEvolucaoPsiquiatrica.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                acao = 4;
                AlterarEvolPsiquiatrica();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar prontuário médico.");
        }
    }//GEN-LAST:event_jBtAlterarEvolPsiquiatricaActionPerformed

    private void jBtExcluirEvolPsiquiatricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEvolPsiquiatricaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioPsiquiatra();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela2) && codExcluirENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EVOLUCAO_PSIQUIATRICA "
                        + "WHERE IdItem='" + jIdEvolucaoPsiquiatrica.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                objAdmMedico.setStatusLanc(jStatusLanc.getText());
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o diagnóstico selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objEvolPsiquiatrica.setIdItem(Integer.valueOf(idItemEvolPsiquiatrico));
                    controlEvolPsiquiatrica.excluirEvolucaoPsiquiatrica(objEvolPsiquiatrica);
                    //
                    objEvolPsiquiatrica.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objEvolPsiquiatrica.setIdItem(idItemEvolPsiquiatrico);
                    objEvolPsiquiatrica.setDeptoMedicoPsiq(deptoTecnico);
                    controlMovDiag.excluirMovTecDiag(objEvolPsiquiatrica); // Excluir Movimetação do Histórico.                   
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegAtend(objRegAtend);
                    //
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaEvolucaoPsiquiatrica("SELECT * FROM EVOLUCAO_PSIQUIATRICA "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    ExcluirEvolPsiquiatrica();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir prontuário médico.");
        }
    }//GEN-LAST:event_jBtExcluirEvolPsiquiatricaActionPerformed

    private void jBtSalvarEvolPsiquiatricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEvolPsiquiatricaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioPsiquiatra();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela2) && codGravarENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            if (jDataEvolPsiquiatrica.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do diagnóstico.");
                jDataEvolPsiquiatrica.requestFocus();
                jDataEvolPsiquiatrica.setBackground(Color.red);
            } else {
                objEvolPsiquiatrica.setDataDiag(jDataEvolPsiquiatrica.getDate());
                objEvolPsiquiatrica.setEvolucaoPsiquiatrica(jTextoEvolucaoPsiquiatrica.getText());
                objEvolPsiquiatrica.setStatusLanc(jStatusLanc.getText());
                objEvolPsiquiatrica.setHipoteseDiagnostica(jHipotesesDiagnosticoPsi.getText());
                objEvolPsiquiatrica.setExamesSolicitados(jExamesSolicitadosPsiq.getText());
                objEvolPsiquiatrica.setPatologiaAdquidida((String) jComboBoxPatologiaAdquirida.getSelectedItem());
                if (acao == 3) {
                    objEvolPsiquiatrica.setUsuarioInsert(nameUser);
                    objEvolPsiquiatrica.setDataInsert(dataModFinal);
                    objEvolPsiquiatrica.setHorarioInsert(horaMov);
                    objEvolPsiquiatrica.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objEvolPsiquiatrica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    controlEvolPsiquiatrica.incluirEvolucaoPsiquiatrica(objEvolPsiquiatrica);
                    //
                    buscarCodEvolPsiquiatrica();
                    objEvolPsiquiatrica.setDeptoMedicoPsiq(deptoTecnico);
                    objEvolPsiquiatrica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objEvolPsiquiatrica.setIdLanc(Integer.valueOf(jIdEvolucaoPsiquiatrica.getText()));
                    controlMovDiag.incluirMovTecDiag(objEvolPsiquiatrica); // Histório de Movimentação de Diagnóstico                 
                    // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO     
                    atendido = "Sim";
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoAdm.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoENF);
                    objRegAtend.setNomeDepartamento(nomeModuloENFER);
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoEvolPS);
                    objRegAtend.setAtendido(atendido);
                    objRegAtend.setDataAtendimento(jDataEvolPsiquiatrica.getDate());
                    objRegAtend.setIdAtend(Integer.valueOf(jIdAdm.getText()));
                    objRegAtend.setIdEvol(Integer.valueOf(jIdEvolucaoPsiquiatrica.getText()));
                    objRegAtend.setAtendeEvol(atendido);
                    objRegAtend.setQtdAtend(pQUANTIDADE_ATENDIDA);
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegEvol(objRegAtend);
                    //GRAVAR NA TABELA DE ATENDIMENTO ATENDIMENTO_PSP_INTERNO_TV         
                    objRegAtend.setStatusAtendimento(status_ATENDIMENTO);
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoAdm.getText());
                    objRegAtend.setNomeDepartamento(nomeModuloENFER);
                    objRegAtend.setConcluido(pATENDIMENTO_CONCLUIDO);
                    objRegAtend.setHorarioUp(horaMov);
                    objRegAtend.setIdAtend(Integer.valueOf(jIdEvolucaoPsiquiatrica.getText()));
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoEvolPS);
                    control_ATENDE.confirmarAtendimento(objRegAtend);
                    // Log
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação   
                    preencherTabelaEvolucaoPsiquiatrica("SELECT * FROM EVOLUCAO_PSIQUIATRICA "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    SalvarEvolPsiquiatrica();
                }
                if (acao == 4) {
                    objEvolPsiquiatrica.setUsuarioUp(nameUser);
                    objEvolPsiquiatrica.setDataUp(dataModFinal);
                    objEvolPsiquiatrica.setHorarioUp(horaMov);
                    objEvolPsiquiatrica.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objEvolPsiquiatrica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objEvolPsiquiatrica.setIdItem(idItemEvolPsiquiatrico);
                    controlEvolPsiquiatrica.alterarEvolucaoPsiquiatrica(objEvolPsiquiatrica);
                    //                 
                    objEvolPsiquiatrica.setDeptoMedicoPsiq(deptoTecnico);
                    objEvolPsiquiatrica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objEvolPsiquiatrica.setIdLanc(Integer.valueOf(jIdEvolucaoPsiquiatrica.getText()));
                    controlMovDiag.alterarMovTecDiag(objEvolPsiquiatrica);// Histório de Movimentação de Diagnóstico
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação   
                    preencherTabelaEvolucaoPsiquiatrica("SELECT * FROM EVOLUCAO_PSIQUIATRICA "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    SalvarEvolPsiquiatrica();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar no prontuário médico.");
        }
    }//GEN-LAST:event_jBtSalvarEvolPsiquiatricaActionPerformed

    private void jBtCancelarEvolPsiquiatricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEvolPsiquiatricaActionPerformed
        // TODO add your handling code here:
        CancelarEvolPsiquiatrica();
    }//GEN-LAST:event_jBtCancelarEvolPsiquiatricaActionPerformed

    private void jBtAuditoriaEvolPsiquiatricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEvolPsiquiatricaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEvolucaoPsiquiatrica objAuditoriaDiagnos = new TelaAuditoriaEvolucaoPsiquiatrica();
        TelaModuloEnfermaria.jPainelMedico.add(objAuditoriaDiagnos);
        objAuditoriaDiagnos.show();
    }//GEN-LAST:event_jBtAuditoriaEvolPsiquiatricaActionPerformed

    private void jTabelaEvolPsiquiatricaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEvolPsiquiatricaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idItem = "" + jTabelaEvolPsiquiatrica.getValueAt(jTabelaEvolPsiquiatrica.getSelectedRow(), 0);
            jIdEvolucaoPsiquiatrica.setText(idItem);
            // Habilitar os botões
            jBtNovaEvolPsiquiatrica.setEnabled(!true);
            jBtAlterarEvolPsiquiatrica.setEnabled(true);
            jBtExcluirEvolPsiquiatrica.setEnabled(true);
            jBtSalvarEvolPsiquiatrica.setEnabled(!true);
            jBtCancelarEvolPsiquiatrica.setEnabled(true);
            jBtAuditoriaEvolPsiquiatrica.setEnabled(true);
            //
            jBtPatologias.setEnabled(true);
            jBtExames.setEnabled(true);
            jBtVacinas.setEnabled(true);
            jBtEncaminhamentoPsi.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EVOLUCAO_PSIQUIATRICA "
                        + "WHERE IdLanc='" + jIdAdm.getText() + "'AND IdItem='" + idItem + "'");
                conecta.rs.first();
                jIdEvolucaoPsiquiatrica.setText(conecta.rs.getString("IdItem")); //Coluna 0               
                idItemEvolPsiquiatrico = conecta.rs.getInt("IdItem"); // Coluna 2
                jNomeCompletoInternoDiagnosticos.setText(jNomeInternoAdm.getText());
                jDataEvolPsiquiatrica.setDate(conecta.rs.getDate("DataEvol"));
                jComboBoxPatologiaAdquirida.setSelectedItem(conecta.rs.getString("Patologia"));
                jTextoEvolucaoPsiquiatrica.setText(conecta.rs.getString("EvolucaoPsiquiatrica"));
                jHipotesesDiagnosticoPsi.setText(conecta.rs.getString("HipoteseDiagnostica"));
                jExamesSolicitadosPsiq.setText(conecta.rs.getString("ExamesSolicitados"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaEvolPsiquiatricaMouseClicked

    private void jBtNovaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaEvolucaoActionPerformed
        // TODO add your handling code here:          
        buscarAcessoUsuarioMedicoClinico();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela3) && codIncluirENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            verificarInternoRegistradoAdm();
            if (atendido == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
            } else if (atendido.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
            } else if (atendido.equals("Sim")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário fazer o registro do interno para ser atendido.");
            } else if (atendido.equals("Não")) {
                acao = 5;
                NovaEvolucao();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir prontuário médico.");
        }
    }//GEN-LAST:event_jBtNovaEvolucaoActionPerformed

    private void jBtAlterarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioMedicoClinico();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela3) && codAlterarENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            verificarEvolucaoAdmissao();
            if (admEvolucao == null) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM EVOLUCAOMEDICA "
                            + "WHERE IdItem='" + jIdEvolucaoMedica.getText() + "'");
                    conecta.rs.first();
                    nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
                }
                if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                    acao = 6;
                    AlterarEvolucao();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                    conecta.desconecta();
                }
            } else if (admEvolucao.equals("")) {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM EVOLUCAOMEDICA "
                            + "WHERE IdItem='" + jIdEvolucaoMedica.getText() + "'");
                    conecta.rs.first();
                    nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
                }
                if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                    acao = 6;
                    AlterarEvolucao();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                    conecta.desconecta();
                }
            } else if (admEvolucao.equals("Sim")) {
                JOptionPane.showMessageDialog(rootPane, "Essa evolução não poderá ser alterada nessa tela, será necessário alterar na admissão.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar prontuário médico.");
        }
    }//GEN-LAST:event_jBtAlterarEvolucaoActionPerformed

    private void jBtExcluirEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioMedicoClinico();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela3) && codExcluirENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EVOLUCAOMEDICA "
                        + "WHERE IdItem='" + jIdEvolucaoMedica.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                objAdmMedico.setStatusLanc(jStatusLanc.getText());
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir a evolução selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objEvolMedica.setIdItem(Integer.parseInt(jIdEvolucaoMedica.getText()));
                    objEvolMedica.setIdLanc(Integer.parseInt(jIdAdm.getText()));
                    controleEvoluMed.excluirEvolucaoMedica(objEvolMedica);
                    //
                    objEvolMedica.setIdLanc(Integer.parseInt(jIdAdm.getText()));
                    objEvolMedica.setIdItem(Integer.parseInt(jIdEvolucaoMedica.getText()));
                    objEvolMedica.setDeptoMedico(deptoTecnico);
                    controleMovEvolu.excluirMovTec(objEvolMedica); // Excluir movimento histórico.
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaEvolucaoMedica("SELECT * FROM EVOLUCAOMEDICA "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                    ExcluirEvolucao();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir prontuário médico.");
        }
    }//GEN-LAST:event_jBtExcluirEvolucaoActionPerformed

    private void jBtSalvarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEvolucaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioMedicoClinico();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela3) && codGravarENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            if (jDataEvolucao.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data da evolução do interno.");
                jDataEvolucao.requestFocus();
                jDataEvolucao.setBackground(Color.red);
            } else {
                objEvolMedica.setNomeInternoEvoluMedica(jNomeCompletoInternoEvolucaoMedica.getText());
                objEvolMedica.setDataEvolu(jDataEvolucao.getDate());
                objEvolMedica.setTextoEvolucao(jTextoEvolucaoMedica.getText());
                objEvolMedica.setStatusLanc(jStatusLanc.getText());
                objEvolMedica.setHipoteseDiagnostica(jHipotestesDiagnosticosMedico.getText());
                objEvolMedica.setExamesSolicitados(jExamesSolcitadosMedicos.getText());
                objEvolMedica.setPatologiaAdquiridaMedica((String) jComboBoxPatologiaAdquiridaMedica.getSelectedItem());
                if (acao == 5) {
                    // log de usuario
                    objEvolMedica.setUsuarioInsert(nameUser);
                    objEvolMedica.setDataInsert(dataModFinal);
                    objEvolMedica.setHoraInsert(horaMov);
                    objEvolMedica.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objEvolMedica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    controleEvoluMed.incluirEvolucaoMedica(objEvolMedica);
                    //
                    buscarEvolucao();
                    objEvolMedica.setDeptoMedico(deptoTecnico);
                    objEvolMedica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objEvolMedica.setIdLanc(Integer.valueOf(jIdEvolucaoMedica.getText()));
                    objEvolMedica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    controleMovEvolu.incluirMovTec(objEvolMedica); // Histórico de Movimento Técnico
                    // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO     
                    atendido = "Sim";
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoAdm.getText());
                    objRegAtend.setIdDepartamento(codigoDepartamentoENF);
                    objRegAtend.setNomeDepartamento(nomeModuloENFER);
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoEvolME);
                    objRegAtend.setAtendido(atendido);
                    objRegAtend.setDataAtendimento(jDataEvolucao.getDate());
                    objRegAtend.setIdAtend(Integer.valueOf(jIdAdm.getText()));
                    objRegAtend.setIdEvol(Integer.valueOf(jIdEvolucaoMedica.getText()));
                    objRegAtend.setAtendeEvol(atendido);
                    objRegAtend.setQtdAtend(pQUANTIDADE_ATENDIDA);
                    //
                    objRegAtend.setUsuarioUp(nameUser);
                    objRegAtend.setDataUp(dataModFinal);
                    objRegAtend.setHorarioUp(horaMov);
                    controlRegAtend.alterarRegEvol(objRegAtend);
                    //GRAVAR NA TABELA DE ATENDIMENTO ATENDIMENTO_PSP_INTERNO_TV    
                    objRegAtend.setStatusAtendimento(status_ATENDIMENTO);
                    objRegAtend.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objRegAtend.setNomeInternoCrc(jNomeInternoAdm.getText());
                    objRegAtend.setNomeDepartamento(nomeModuloENFER);
                    objRegAtend.setConcluido(pATENDIMENTO_CONCLUIDO);
                    objRegAtend.setHorarioUp(horaMov);
                    objRegAtend.setIdAtend(Integer.valueOf(jIdEvolucaoMedica.getText()));
                    objRegAtend.setTipoAtemdimento(tipoAtendimentoEvolME);
                    control_ATENDE.confirmarAtendimento(objRegAtend);
                    preencherTabelaEvolucaoMedica("SELECT * FROM EVOLUCAOMEDICA "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    SalvarEvolucao();
                }
                if (acao == 6) {
                    // log de usuario
                    objEvolMedica.setUsuarioUp(nameUser);
                    objEvolMedica.setDataUp(dataModFinal);
                    objEvolMedica.setHoraUp(horaMov);
                    objEvolMedica.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objEvolMedica.setIdItem(idItemEvol);
                    controleEvoluMed.alterarEvolucaoMedica(objEvolMedica);
                    //
                    objEvolMedica.setDeptoMedico(deptoTecnico);
                    objEvolMedica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objEvolMedica.setIdLanc(Integer.valueOf(jIdEvolucaoMedica.getText()));
                    controleMovEvolu.alterarMovTec(objEvolMedica);
                    preencherTabelaEvolucaoMedica("SELECT * FROM EVOLUCAOMEDICA "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    SalvarEvolucao();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar no prontuário médico.");
        }
    }//GEN-LAST:event_jBtSalvarEvolucaoActionPerformed

    private void jBtCancelarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEvolucaoActionPerformed
        // TODO add your handling code here:
        CancelarEvolucao();
    }//GEN-LAST:event_jBtCancelarEvolucaoActionPerformed

    private void jBtAuditoriaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEvolucaoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaEvolucaoMedica objAudiEvolMed = new TelaAuditoriaEvolucaoMedica();
        TelaModuloEnfermaria.jPainelMedico.add(objAudiEvolMed);
        objAudiEvolMed.show();
    }//GEN-LAST:event_jBtAuditoriaEvolucaoActionPerformed

    private void jTabelaEvolucaoMedicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEvolucaoMedicaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idItem = "" + jTabelaEvolucaoMedica.getValueAt(jTabelaEvolucaoMedica.getSelectedRow(), 0);
            // Habilitar os botões
            jBtNovaEvolucao.setEnabled(!true);
            jBtAlterarEvolucao.setEnabled(true);
            jBtExcluirEvolucao.setEnabled(true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(true);
            jBtAuditoriaEvolucao.setEnabled(true);
            //
            jBtPatologiasClinica.setEnabled(true);
            jBtExamesClinicos.setEnabled(true);
            jBtVacinasClinicas.setEnabled(true);
            jBtEncaminhamentoClinico.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EVOLUCAOMEDICA "
                        + "WHERE IdLanc='" + jIdAdm.getText() + "' "
                        + "AND IdItem='" + idItem + "'");
                conecta.rs.first();
                jIdEvolucaoMedica.setText(conecta.rs.getString("IdItem")); //Coluna 0               
                idItemEvol = conecta.rs.getInt("IdItem"); // Coluna 2
                jNomeCompletoInternoEvolucaoMedica.setText(jNomeInternoAdm.getText());
                jDataEvolucao.setDate(conecta.rs.getDate("DataEvolu"));
                jComboBoxPatologiaAdquiridaMedica.setSelectedItem(conecta.rs.getString("Patologia"));
                jTextoEvolucaoMedica.setText(conecta.rs.getString("TextoEvolucao"));
                jHipotestesDiagnosticosMedico.setText(conecta.rs.getString("HipoteseDiagnostica"));
                jExamesSolcitadosMedicos.setText(conecta.rs.getString("ExamesSolicitados"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaEvolucaoMedicaMouseClicked

    private void jBtNovaPrescicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaPrescicaoActionPerformed
        // TODO add your handling code here:
        nomeModuloTela4 = "Movimentação:Admissão Médica de Internos:Prescrição Médica/Psiquiatrica";
        buscarAcessoUsuarioPrescricao();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela4) && codIncluirENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            acao = 7;
            NovaPrescricao();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir prontuário médico.");
        }
    }//GEN-LAST:event_jBtNovaPrescicaoActionPerformed

    private void jBtAlterarPrescicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarPrescicaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioPrescricao();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela4) && codAlterarENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA "
                        + "WHERE IdItem='" + jIdPrescricaoMedica.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                acao = 8;
                AlterarPrescricao();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar o prontuário médico.");
        }
    }//GEN-LAST:event_jBtAlterarPrescicaoActionPerformed

    private void jBtExcluirPrescicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirPrescicaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioPrescricao();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela4) && codExcluirENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA "
                        + "WHERE IdItem='" + jIdPrescricaoMedica.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                objAdmMedico.setStatusLanc(jStatusLanc.getText());
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir a prescrição selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objPrescricao.setIdItem(Integer.parseInt(jIdPrescricaoMedica.getText()));
                    objPrescricao.setIdLanc(Integer.parseInt(jIdAdm.getText()));
                    controlePrescricao.excluirPrescricaoMedica(objPrescricao);
                    //
                    objPrescricao.setIdLanc(Integer.parseInt(jIdAdm.getText()));
                    objPrescricao.setIdItem(Integer.parseInt(jIdPrescricaoMedica.getText()));
                    objPrescricao.setDeptoMedico(deptoTecnico);
                    controleMovPrescricao.excluirMovTecPrescricao(objPrescricao); // Excluir movimento histórico.
                    objLog4();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaPrescricaoMedica("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    ExcluirPrescricao();
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir o prontuário médico.");
        }
    }//GEN-LAST:event_jBtExcluirPrescicaoActionPerformed

    private void jBtSalvarPrescicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarPrescicaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioPrescricao();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela4) && codGravarENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            if (jDataPM.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data da Prescrição médica/psiquiatrica do interno.");
                jDataPM.requestFocus();
                jDataPM.setBackground(Color.red);
            } else if (jTextoPrescricaoMedica.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o texto da prescrição Médica/Psiquiatrica");
            } else {
                if (jRBPrescricaoMedica.isSelected()) {
                    tipoPrescricao = 0;
                } else if (jRBPrescricaoPsiquiatrica.isSelected()) {
                    tipoPrescricao = 1;
                }
                objPrescricao.setDataPrescricao(jDataPM.getDate());
                objPrescricao.setTipoPrescricaoMedica(tipoPrescricao);
                objPrescricao.setTextoPrescricao(jTextoPrescricaoMedica.getText());
                objPrescricao.setStatusLanc(jStatusLanc.getText());
                if (acao == 7) {
                    // log de usuario
                    objPrescricao.setUsuarioInsert(nameUser);
                    objPrescricao.setDataInsert(dataModFinal);
                    objPrescricao.setHoraInsert(horaMov);
                    objPrescricao.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objPrescricao.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    controlePrescricao.incluirPrescricaoMedica(objPrescricao);
                    //
                    buscarprescricaoMedica();
                    objPrescricao.setDeptoMedico(deptoTecnico);
                    objPrescricao.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objPrescricao.setIdLanc(Integer.valueOf(jIdPrescricaoMedica.getText()));
                    controleMovPrescricao.incluirMovTecPrescricao(objPrescricao); // Histórico de Movimento Técnico                                     
                    //
                    objLog4();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaPrescricaoMedica("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    SalvarPrescricao();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 8) {
                    // log de usuario
                    objPrescricao.setUsuarioUp(nameUser);
                    objPrescricao.setDataUp(dataModFinal);
                    objPrescricao.setHoraUp(horaMov);
                    objPrescricao.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objPrescricao.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objPrescricao.setIdItem(idItemPrescricao);
                    controlePrescricao.alterarPrescricaoMedica(objPrescricao);
                    //
                    objPrescricao.setDeptoMedico(deptoTecnico);
                    objPrescricao.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objPrescricao.setIdLanc(Integer.valueOf(jIdPrescricaoMedica.getText()));
                    controleMovPrescricao.alterarMovTecPrescricao(objPrescricao);
                    //
                    objLog4();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaPrescricaoMedica("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    SalvarPrescricao();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar no prontuário médico.");
        }
    }//GEN-LAST:event_jBtSalvarPrescicaoActionPerformed

    private void jBtCancelarPrescicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarPrescicaoActionPerformed
        // TODO add your handling code here:
        CancelarPrescricao();
    }//GEN-LAST:event_jBtCancelarPrescicaoActionPerformed

    private void jBtAuditoriaPrescicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaPrescicaoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaPrescricaMedica objAudiPresMed = new TelaAuditoriaPrescricaMedica();
        TelaModuloEnfermaria.jPainelMedico.add(objAudiPresMed);
        objAudiPresMed.show();
    }//GEN-LAST:event_jBtAuditoriaPrescicaoActionPerformed

    private void jTabelaPrescricaoMedicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPrescricaoMedicaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idItemPresq = "" + jTabelaPrescricaoMedica.getValueAt(jTabelaPrescricaoMedica.getSelectedRow(), 0);
            // Habilitar os botões
            jBtNovaPrescicao.setEnabled(!true);
            jBtAlterarPrescicao.setEnabled(true);
            jBtExcluirPrescicao.setEnabled(true);
            jBtSalvarPrescicao.setEnabled(!true);
            jBtCancelarPrescicao.setEnabled(true);
            jBtAuditoriaPrescicao.setEnabled(true);
            jBtImpressaoPrescricao.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA "
                        + "WHERE IdLanc='" + jIdAdm.getText() + "' "
                        + "AND IdItem='" + idItemPresq + "'");
                conecta.rs.first();
                jIdPrescricaoMedica.setText(conecta.rs.getString("IdItem")); //Coluna 0               
                idItemPrescricao = conecta.rs.getInt("IdItem"); // Coluna 2
                jNomeInternoCrcPM.setText(jNomeInternoAdm.getText());
                jDataPM.setDate(conecta.rs.getDate("DataPres"));
                tipoPrescricao = conecta.rs.getInt("TipoP");
                if (tipoPrescricao == 0) {
                    jRBPrescricaoMedica.setSelected(true);
                } else if (tipoPrescricao == 1) {
                    jRBPrescricaoPsiquiatrica.setSelected(true);
                }
                jTextoPrescricaoMedica.setText(conecta.rs.getString("TextoPrescricao"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaPrescricaoMedicaMouseClicked

    private void jBtImpressaoPrescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoPrescricaoActionPerformed
        // TODO add your handling code here:
        if (jIdPrescricaoMedica.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível imprimir prescrição médica.");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/RelatorioPrescricaoMedica.jasper";
                conecta.executaSQL("SELECT * FROM ADMISSAOMEDICA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ADMISSAOMEDICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN PRESCRICAO_MEDICA_PSIQUIATRICA "
                        + "ON ADMISSAOMEDICA.IdLanc=PRESCRICAO_MEDICA_PSIQUIATRICA.IdLanc "
                        + "WHERE PRESCRICAO_MEDICA_PSIQUIATRICA.IdLanc='" + jIdAdm.getText() + "' "
                        + "AND PRESCRICAO_MEDICA_PSIQUIATRICA.IdItem='" + jIdPrescricaoMedica.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("codigoAdm", jIdAdm.getText());
                parametros.put("codigoPrescricao", jIdPrescricaoMedica.getText());
                parametros.put("nomeUsuario", nameUser);
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Prescrição Médica/Psiquiatrica");
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        }
    }//GEN-LAST:event_jBtImpressaoPrescricaoActionPerformed

    private void jBtNovoAtestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoAtestadoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioAtestado();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela5) && codIncluirENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            acao = 9;
            NovoAtestado();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir prontuário médico.");
        }
    }//GEN-LAST:event_jBtNovoAtestadoActionPerformed

    private void jBtAlterarAtestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarAtestadoActionPerformed
        // TODO add your handling code here: 
        buscarAcessoUsuarioAtestado();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela5) && codAlterarENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ATESTADO_MEDICO_PSIQUIATRICO "
                        + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                acao = 10;
                AlterarAtestado();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar prontuário médico.");
        }
    }//GEN-LAST:event_jBtAlterarAtestadoActionPerformed

    private void jBtExcluirAtestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirAtestadoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioAtestado();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela5) && codExcluirENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ATESTADO_MEDICO_PSIQUIATRICO "
                        + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                objAdmMedico.setStatusLanc(jStatusLanc.getText());
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir a prescrição selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objAtestado.setIdItem(Integer.parseInt(jIdPrescricaoMedica.getText()));
                    objAtestado.setIdLanc(Integer.parseInt(jIdAdm.getText()));
                    controleAtestado.excluirAtestadoMedicoPsiquiatrico(objAtestado);
                    //
                    objAtestado.setIdLanc(Integer.parseInt(jIdAdm.getText()));
                    objAtestado.setIdItem(Integer.parseInt(jIdPrescricaoMedica.getText()));
                    objAtestado.setDeptoMedico(deptoTecnico);
                    controleMovAtestado.excluirMovTecAtestado(objAtestado); // Excluir movimento histórico.
                    objLog5();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    ExcluirAtestado();
                    preencherTabelaAtestadoMedica("SELECT * FROM ATESTADO_MEDICO_PSIQUIATRICO "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir prontuário médico.");
        }
    }//GEN-LAST:event_jBtExcluirAtestadoActionPerformed

    private void jBtSalvarAtestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarAtestadoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioAtestado();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela5) && codGravarENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            if (jDataAtestado.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do Atestado.");
            } else if (jTextoAtestado.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe um texto para o Atestado.");
            } else {
                objAtestado.setDataAtesta(jDataAtestado.getDate());
                if (jRadioBtModeloA.isSelected()) {
                    tipoModelo = 0;
                } else if (jRadioBtModeloB.isSelected()) {
                    tipoModelo = 1;
                } else if (jRadioBtModeloC.isSelected()) {
                    tipoModelo = 2;
                } else if (jRadioBtModeloAleatorio.isSelected()) {
                    tipoModelo = 3;
                }
                objAtestado.setModeloAtestado(tipoModelo);
                objAtestado.setTextoAtestado(jTextoAtestado.getText());
                objAtestado.setStatusLanc(jStatusLanc.getText());
                if (acao == 9) {
                    objAtestado.setUsuarioInsert(nameUser);
                    objAtestado.setDataInsert(dataModFinal);
                    objAtestado.setHorarioInsert(horaMov);
                    objAtestado.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objAtestado.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    controleAtestado.incluirAtestadoMedicoPsiquiatrico(objAtestado);
                    buscarAtestado();
                    objAtestado.setDeptoMedico(deptoTecnico);
                    objAtestado.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objAtestado.setIdLanc(Integer.valueOf(jIdAtestado.getText()));
                    controleMovAtestado.incluirMovTecAtestado(objAtestado); // Histórico de Movimento Técnico                    
                    //
                    objLog5();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarAtestado();
                    preencherTabelaAtestadoMedica("SELECT * FROM ATESTADO_MEDICO_PSIQUIATRICO "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 10) {
                    objAtestado.setUsuarioUp(nameUser);
                    objAtestado.setDataUp(dataModFinal);
                    objAtestado.setHorarioUp(horaMov);
                    objAtestado.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objAtestado.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objAtestado.setIdItem(idItemAtestado);
                    controleAtestado.alterarAtestadoMedicoPsiquiatrico(objAtestado);
                    //
                    objAtestado.setDeptoMedico(deptoTecnico);
                    objAtestado.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objAtestado.setIdLanc(Integer.valueOf(jIdAtestado.getText()));
                    controleMovAtestado.alterarMovTecAtestado(objAtestado);
                    //
                    objLog5();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarAtestado();
                    preencherTabelaAtestadoMedica("SELECT * FROM ATESTADO_MEDICO_PSIQUIATRICO "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar prontuário médico.");
        }
    }//GEN-LAST:event_jBtSalvarAtestadoActionPerformed

    private void jBtCancelarAtestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarAtestadoActionPerformed
        // TODO add your handling code here:
        CancelarAtestado();
    }//GEN-LAST:event_jBtCancelarAtestadoActionPerformed

    private void jBtImprimirAtestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImprimirAtestadoActionPerformed
        // TODO add your handling code here:
        if (jIdAtestado.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível imprimir atestado médico.");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/RelatorioAtestadoMedico.jasper";
                conecta.executaSQL("SELECT * FROM ADMISSAOMEDICA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ADMISSAOMEDICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN ATESTADO_MEDICO_PSIQUIATRICO "
                        + "ON ADMISSAOMEDICA.IdLanc=ATESTADO_MEDICO_PSIQUIATRICO.IdLanc "
                        + "WHERE ATESTADO_MEDICO_PSIQUIATRICO.IdLanc='" + jIdAdm.getText() + "' "
                        + "AND ATESTADO_MEDICO_PSIQUIATRICO.IdItem='" + jIdAtestado.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("codigoAdm", jIdAdm.getText());
                parametros.put("codigoAtestado", jIdAtestado.getText());
                parametros.put("nomeUsuario", nameUser);
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Atestado Médico/Psiquiatrico");
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        }
    }//GEN-LAST:event_jBtImprimirAtestadoActionPerformed

    private void jTabelaAtestadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAtestadoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idItem = "" + jTabelaAtestado.getValueAt(jTabelaAtestado.getSelectedRow(), 0);
            // Habilitar os botões
            jBtNovoAtestado.setEnabled(!true);
            jBtAlterarAtestado.setEnabled(true);
            jBtExcluirAtestado.setEnabled(true);
            jBtSalvarAtestado.setEnabled(!true);
            jBtCancelarAtestado.setEnabled(true);
            jBtAuditoriaAtestado.setEnabled(true);
            jBtImprimirAtestado.setEnabled(true);
            jRadioBtModeloA.setEnabled(!true);
            jRadioBtModeloB.setEnabled(!true);
            jRadioBtModeloC.setEnabled(!true);
            jRadioBtModeloAleatorio.setEnabled(!true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ATESTADO_MEDICO_PSIQUIATRICO "
                        + "WHERE IdLanc='" + jIdAdm.getText() + "'AND IdItem='" + idItem + "'");
                conecta.rs.first();
                jIdAtestado.setText(conecta.rs.getString("IdItem")); //Coluna 0               
                idItemAtestado = conecta.rs.getInt("IdItem"); // Coluna 2
                jNomeInternoAtestado.setText(jNomeInternoAdm.getText());
                jDataAtestado.setDate(conecta.rs.getDate("DataAtesta"));
                tipoModelo = conecta.rs.getInt("ModeloAtestado");
                if (tipoModelo == 0) {
                    jRadioBtModeloA.setSelected(true);
                } else if (tipoModelo == 1) {
                    jRadioBtModeloB.setSelected(true);
                } else if (tipoModelo == 2) {
                    jRadioBtModeloC.setSelected(true);
                } else if (tipoModelo == 3) {
                    jRadioBtModeloAleatorio.setSelected(true);
                }
                jTextoAtestado.setText(conecta.rs.getString("TextoAtestado"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaAtestadoMouseClicked

    private void jRadioBtModeloAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioBtModeloAMouseClicked
        // TODO add your handling code here:
        if (!jIdAtestado.getText().equals("") && tipoModelo == 0 && jIdAtestado.getText().equals(tipoModelo)) {
            jTextoAtestado.setText(modeloAtestadoA);
        } else if (acao == 9) {
            jTextoAtestado.setText(modeloAtestadoA);
        }
    }//GEN-LAST:event_jRadioBtModeloAMouseClicked

    private void jRadioBtModeloBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioBtModeloBMouseClicked
        // TODO add your handling code here:
        if (!jIdAtestado.getText().equals("") && tipoModelo == 1 && jIdAtestado.getText().equals(tipoModelo) && acao == 10) {
            jTextoAtestado.setText(modeloAtestadoB);
        } else if (acao == 9) {
            jTextoAtestado.setText(modeloAtestadoB);
        }
    }//GEN-LAST:event_jRadioBtModeloBMouseClicked

    private void jRadioBtModeloCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioBtModeloCMouseClicked
        // TODO add your handling code here:
        if (!jIdAtestado.getText().equals("") && tipoModelo == 2 && jIdAtestado.getText().equals(tipoModelo)) {
            jTextoAtestado.setText(modeloAtestadoC);
        } else if (acao == 9) {
            jTextoAtestado.setText(modeloAtestadoC);
        }
    }//GEN-LAST:event_jRadioBtModeloCMouseClicked

    private void jRadioBtModeloAleatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioBtModeloAleatorioMouseClicked
        // TODO add your handling code here:
        if (!jIdAtestado.getText().equals("") && tipoModelo == 3 && jIdAtestado.getText().equals(tipoModelo)) {
            jTextoAtestado.setText(modeloAtestadoAleatorio);
        } else if (acao == 9) {
            jTextoAtestado.setText(modeloAtestadoAleatorio);
        }
    }//GEN-LAST:event_jRadioBtModeloAleatorioMouseClicked

    private void jBtAuditoriaAtestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaAtestadoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaAtestadoMedico objAudiAtes = new TelaAuditoriaAtestadoMedico();
        TelaModuloEnfermaria.jPainelMedico.add(objAudiAtes);
        objAudiAtes.show();
    }//GEN-LAST:event_jBtAuditoriaAtestadoActionPerformed

    private void jBtNovaDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaDietaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioDieta();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela6) && codIncluirENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            acao = 11;
            NovaDieta();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir prontuário médico.");
        }
    }//GEN-LAST:event_jBtNovaDietaActionPerformed

    private void jBtAlterarDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarDietaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioDieta();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela6) && codAlterarENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM DIETA_MEDICA_PSIQUIATRICA "
                        + "WHERE IdItem='" + jIdDieta.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                acao = 12;
                AlterarDieta();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar prontuário médico.");
        }
        conecta.abrirConexao();
    }//GEN-LAST:event_jBtAlterarDietaActionPerformed

    private void jBtExcluirDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirDietaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioDieta();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela6) && codExcluirENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM DIETA_MEDICA_PSIQUIATRICA "
                        + "WHERE IdItem='" + jIdDieta.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                objAdmMedico.setStatusLanc(jStatusLanc.getText());
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir a prescrição selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objDietaMedica.setIdItem(Integer.parseInt(jIdDieta.getText()));
                    objDietaMedica.setIdLanc(Integer.parseInt(jIdAdm.getText()));
                    controlDieta.excluirDietaMedicaPsiquiatrica(objDietaMedica);
                    //
                    objDietaMedica.setIdLanc(Integer.parseInt(jIdAdm.getText()));
                    objDietaMedica.setIdItem(Integer.parseInt(jIdDieta.getText()));
                    objDietaMedica.setDeptoMedico(deptoTecnico);
                    controleMovDieta.excluirMovTecDieta(objDietaMedica); // Excluir movimento histórico.
                    objLog6();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    ExcluirDieta();
                    preencherTabelaDietaMedica("SELECT * FROM DIETA_MEDICA_PSIQUIATRICA "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir prontuário médico.");
        }
    }//GEN-LAST:event_jBtExcluirDietaActionPerformed

    private void jBtSalvarDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarDietaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioDieta();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela6) && codGravarENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            if (jDataDieta.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data da Dieta.");
            } else if (jTextoDieta.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o texto da Dieta.");
            } else {
                objDietaMedica.setDataDieta(jDataDieta.getDate());
                objDietaMedica.setTextoDieta(jTextoDieta.getText());
                objDietaMedica.setStatusLanc(jStatusLanc.getText());
                if (acao == 11) {
                    objDietaMedica.setUsuarioInsert(nameUser);
                    objDietaMedica.setDataInsert(dataModFinal);
                    objDietaMedica.setHorarioInsert(horaMov);
                    objDietaMedica.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objDietaMedica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    controlDieta.incluirDietaMedicaPsiquiatrica(objDietaMedica);
                    buscarCodDieta();
                    objDietaMedica.setDeptoMedico(deptoTecnico);
                    objDietaMedica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objDietaMedica.setIdLanc(Integer.valueOf(jIdDieta.getText()));
                    controleMovDieta.incluirMovTecDieta(objDietaMedica); // Histórico de Movimento Técnico                    
                    //
                    objLog6();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaDietaMedica("SELECT * FROM DIETA_MEDICA_PSIQUIATRICA "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    SalvarDieta();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 12) {
                    objDietaMedica.setUsuarioUp(nameUser);
                    objDietaMedica.setDataUp(dataModFinal);
                    objDietaMedica.setHorarioUp(horaMov);
                    objDietaMedica.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objDietaMedica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objDietaMedica.setIdItem(idItemDieta);
                    controlDieta.alterarDietaMedicaPsiquiatrica(objDietaMedica);
                    //
                    objDietaMedica.setDeptoMedico(deptoTecnico);
                    objDietaMedica.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objDietaMedica.setIdLanc(Integer.valueOf(jIdDieta.getText()));
                    controleMovDieta.alterarMovTecDieta(objDietaMedica);
                    //
                    objLog6();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaDietaMedica("SELECT * FROM DIETA_MEDICA_PSIQUIATRICA "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    SalvarDieta();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar no prontuário médico.");
        }
    }//GEN-LAST:event_jBtSalvarDietaActionPerformed

    private void jBtCancelarDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarDietaActionPerformed
        // TODO add your handling code here:
        CancelarDieta();
    }//GEN-LAST:event_jBtCancelarDietaActionPerformed

    private void jBtAuditoriaDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaDietaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaDietaMedica objAudiDie = new TelaAuditoriaDietaMedica();
        TelaModuloEnfermaria.jPainelMedico.add(objAudiDie);
        objAudiDie.show();
    }//GEN-LAST:event_jBtAuditoriaDietaActionPerformed

    private void jTablaDietaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaDietaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idItem = "" + jTablaDieta.getValueAt(jTablaDieta.getSelectedRow(), 0);
            // Habilitar os botões
            jBtNovaDieta.setEnabled(!true);
            jBtAlterarDieta.setEnabled(true);
            jBtExcluirDieta.setEnabled(true);
            jBtSalvarDieta.setEnabled(!true);
            jBtCancelarDieta.setEnabled(true);
            jBtAuditoriaDieta.setEnabled(true);
            jBtImprimirDieta.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM DIETA_MEDICA_PSIQUIATRICA "
                        + "WHERE IdLanc='" + jIdAdm.getText() + "' "
                        + "AND IdItem='" + idItem + "'");
                conecta.rs.first();
                jIdDieta.setText(conecta.rs.getString("IdItem")); //Coluna 0               
                idItemDieta = conecta.rs.getInt("IdItem"); // Coluna 2
                jNomeInternoDieta.setText(jNomeInternoAdm.getText());
                jDataDieta.setDate(conecta.rs.getDate("DataDieta"));
                jTextoDieta.setText(conecta.rs.getString("TextoDieta"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTablaDietaMouseClicked

    private void jBtImprimirDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImprimirDietaActionPerformed
        // TODO add your handling code here:
        if (jIdDieta.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível imprimir dieta médica.");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/RelatorioDietaMedica.jasper";
                conecta.executaSQL("SELECT * FROM ADMISSAOMEDICA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ADMISSAOMEDICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN DIETA_MEDICA_PSIQUIATRICA "
                        + "ON ADMISSAOMEDICA.IdLanc=DIETA_MEDICA_PSIQUIATRICA.IdLanc "
                        + "WHERE DIETA_MEDICA_PSIQUIATRICA.IdLanc='" + jIdAdm.getText() + "' "
                        + "AND DIETA_MEDICA_PSIQUIATRICA.IdItem='" + jIdDieta.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("codigoAdm", jIdAdm.getText());
                parametros.put("codigoDieta", jIdDieta.getText());
                parametros.put("nomeUsuario", nameUser);
                parametros.put("descricaoUnidade", descricaoUnidade);
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Dieta Médica/Psiquiatrica");
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        }
    }//GEN-LAST:event_jBtImprimirDietaActionPerformed

    private void jBtPesquisaEvolucaoPsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaEvolucaoPsiActionPerformed
        // TODO add your handling code here:
        TelaPesqAnamenesiaPsiquiatrica objPesEvolData = new TelaPesqAnamenesiaPsiquiatrica();
        TelaModuloEnfermaria.jPainelMedico.add(objPesEvolData);
        objPesEvolData.show();
    }//GEN-LAST:event_jBtPesquisaEvolucaoPsiActionPerformed

    private void jBtPesquisaEvolucaoMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaEvolucaoMedicaActionPerformed
        // TODO add your handling code here:
        TelaPesqAnamenesiaMedica objPesqEvolMed = new TelaPesqAnamenesiaMedica();
        TelaModuloEnfermaria.jPainelMedico.add(objPesqEvolMed);
        objPesqEvolMed.show();
    }//GEN-LAST:event_jBtPesquisaEvolucaoMedicaActionPerformed

    private void jBtExcluirPatologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirPatologiaActionPerformed
        // TODO add your handling code here:
        if (jTabelaPatologia.getSelectedRow() != -1) {
            DefaultTableModel dtm = (DefaultTableModel) jTabelaPatologia.getModel();
            dtm.removeRow(jTabelaPatologia.getSelectedRow());
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o item selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objItensDoenca.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                objItensDoenca.setIdItem(Integer.valueOf(jIdItem.getText()));
                controlePat.excluirDoencas(objItensDoenca);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione o registro que deseja excluir.");
        }
    }//GEN-LAST:event_jBtExcluirPatologiaActionPerformed

    private void jBtAdicionarPatologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdicionarPatologiaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtmDoencas = (DefaultTableModel) jTabelaPatologia.getModel();
        // dtmDoencas.addRow(new Object [] {jIdPato.getText(),jDescricaoPato.getText()});
        objItensDoenca.setIdDoenca(Integer.valueOf(jIdItem.getText()));
        objItensDoenca.setDescricaoDoenca(jDescricaoPatologia.getText());
        Object campos[] = {objItensDoenca.getIdDoenca(), objItensDoenca.getDescricaoDoenca(), jCid.getText()};
        dtmDoencas.addRow(campos);
        jIdItem.setText("");
        jDescricaoPatologia.setText("");
        jCid.setText("");
    }//GEN-LAST:event_jBtAdicionarPatologiaActionPerformed

    private void jBtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarActionPerformed
        // TODO add your handling code here:
        TelaBuscarDoencas objDoenca = new TelaBuscarDoencas();
        TelaModuloEnfermaria.jPainelMedico.add(objDoenca);
        objDoenca.show();
    }//GEN-LAST:event_jBtBuscarActionPerformed

    private void jTabelaPatologiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPatologiaMouseClicked
        // TODO add your handling code here:
        if (acao == 1 || acao == 2) {
            jBtBuscar.setEnabled(true);
            jBtExcluirPatologia.setEnabled(true);
            if (flag == 1) {
                String codItem = "" + jTabelaPatologia.getValueAt(jTabelaPatologia.getSelectedRow(), 0);
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM ITENSADMISSAODOENCAS "
                            + "INNER JOIN DOENCAS "
                            + "ON ITENSADMISSAODOENCAS.IdDoenca=DOENCAS.IdDoenca "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "' "
                            + "AND ITENSADMISSAODOENCAS.IdDoenca='" + codItem + "'");
                    conecta.rs.first();
                    jIdItem.setText(conecta.rs.getString("IdDoenca")); //Coluna 0
                    jDescricaoPatologia.setText(conecta.rs.getString("Descricao"));
                    jCid.setText(conecta.rs.getString("Cid"));
                    conecta.desconecta();
                } catch (SQLException ex) {
                }
            }
        }
    }//GEN-LAST:event_jTabelaPatologiaMouseClicked

    private void jBtPatologiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPatologiasActionPerformed
        // TODO add your handling code here:
        if (jIdEvolucaoPsiquiatrica.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um anamnese para cadastrar a(s) patologia(s).");
        } else if (jComboBoxPatologiaAdquirida.getSelectedItem().equals("Não")) {
            JOptionPane.showMessageDialog(rootPane, "A opção de Patologia Adquirida está selecionada com NÃO.");
        } else if (jComboBoxPatologiaAdquirida.getSelectedItem().equals("Sanado")) {
            JOptionPane.showMessageDialog(rootPane, "A opção de Patologia Adquirida está selecionada como SANADA.");
        } else {
            mostrarTelaPatologiaPsiqui();
        }
    }//GEN-LAST:event_jBtPatologiasActionPerformed

    private void jBtExamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExamesActionPerformed
        // TODO add your handling code here:
        if (jIdInternoAdm.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um interno para consultar o(s) exame(s).");
        } else {
            mostrarTelaConsultaExamesPsi();
        }
    }//GEN-LAST:event_jBtExamesActionPerformed

    private void jBtVacinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVacinasActionPerformed
        // TODO add your handling code here:
        if (jIdInternoAdm.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um interno para consultar a(s) vacina(s).");
        } else {
            mostrarTelaConsultaVacinasInternos();
        }
    }//GEN-LAST:event_jBtVacinasActionPerformed

    private void jBtEncaminhamentoPsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEncaminhamentoPsiActionPerformed
        // TODO add your handling code here:
        if (jIdInternoAdm.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um interno para consultar o(s) encaminhamentos(s).");
        } else {
            mostrarTelaEncaminhamentoMedico();
        }
    }//GEN-LAST:event_jBtEncaminhamentoPsiActionPerformed

    private void jBtPatologiasClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPatologiasClinicaActionPerformed
        // TODO add your handling code here:
        if (jIdEvolucaoMedica.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um anamnese para cadastrar a(s) patologia(s).");
        } else if (jComboBoxPatologiaAdquiridaMedica.getSelectedItem().equals("Não")) {
            JOptionPane.showMessageDialog(rootPane, "A opção de Patologia Adquirida está selecionada com NÃO.");
        } else if (jComboBoxPatologiaAdquiridaMedica.getSelectedItem().equals("Sanado")) {
            JOptionPane.showMessageDialog(rootPane, "A opção de Patologia Adquirida está selecionada como SANADA.");
        } else {
            mostrarTelaPatologiaMedica();
        }
    }//GEN-LAST:event_jBtPatologiasClinicaActionPerformed

    private void jBtExamesClinicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExamesClinicosActionPerformed
        // TODO add your handling code here:
        if (jIdInternoAdm.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma anamnese para consultar o(s) exame(s).");
        } else {
            mostrarTelaConsultaExamesPsi();
        }
    }//GEN-LAST:event_jBtExamesClinicosActionPerformed

    private void jBtVacinasClinicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVacinasClinicasActionPerformed
        // TODO add your handling code here:
        if (jIdInternoAdm.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma anamnese para consultar a(s) vacina(s).");
        } else {
            mostrarTelaConsultaVacinasInternos();
        }
    }//GEN-LAST:event_jBtVacinasClinicasActionPerformed

    private void jBtEncaminhamentoClinicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEncaminhamentoClinicoActionPerformed
        // TODO add your handling code here:
        if (jIdInternoAdm.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma anamnese para consultar o(s) encaminhamentos(s).");
        } else {
            mostrarTelaEncaminhamentoMedico();
        }
    }//GEN-LAST:event_jBtEncaminhamentoClinicoActionPerformed

    private void jBtImpressaoEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoEvolucaoActionPerformed
        // TODO add your handling code here:
        if (jTextoEvolucaoMedica.getText().equals("") && jIdEvolucaoMedica.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione primeiro a evolução que deseja imprimir.");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/EvolucaoMedica.jasper";
                conecta.executaSQL("SELECT * FROM EVOLUCAOMEDICA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON EVOLUCAOMEDICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE EVOLUCAOMEDICA.IdLanc='" + jIdAdm.getText() + "' "
                        + "AND EVOLUCAOMEDICA.IdItem='" + jIdEvolucaoMedica.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("codigoEvolucao", jIdAdm.getText());
                parametros.put("idEvolucao", jIdEvolucaoMedica.getText());
                parametros.put("nomeUsuario", nameUser);
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Evolução Médica");
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        }
    }//GEN-LAST:event_jBtImpressaoEvolucaoActionPerformed

    private void jBtImpressaoEvolucao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoEvolucao1ActionPerformed
        // TODO add your handling code here:
        if (jIdEvolucaoPsiquiatrica.getText().equals("") && jIdEvolucaoPsiquiatrica.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione primeiro a evolução que deseja imprimir.");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/EvolucaoPsiquiatrica.jasper";
                conecta.executaSQL("SELECT * FROM EVOLUCAO_PSIQUIATRICA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON EVOLUCAO_PSIQUIATRICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE EVOLUCAO_PSIQUIATRICA.IdLanc='" + jIdAdm.getText() + "' "
                        + "AND EVOLUCAO_PSIQUIATRICA.IdItem='" + jIdEvolucaoPsiquiatrica.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("codigoEvolucao", jIdAdm.getText());
                parametros.put("idEvolucao", jIdEvolucaoPsiquiatrica.getText());
                parametros.put("nomeUsuario", nameUser);
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Evolução Médica");
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        }
    }//GEN-LAST:event_jBtImpressaoEvolucao1ActionPerformed

    private void jBtPrescricaMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPrescricaMedicaActionPerformed
        // TODO add your handling code here:
        mostrarTelaPrescricaoMedica();
    }//GEN-LAST:event_jBtPrescricaMedicaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AnaMedica;
    private javax.swing.JPanel AnaPsiquiatrica;
    private javax.swing.JPanel Atestado;
    private javax.swing.JPanel Cirurgias;
    private javax.swing.JPanel DietaMedica;
    private javax.swing.JPanel Exames;
    private javax.swing.JPanel Listagem;
    private javax.swing.JPanel Manutencao;
    private javax.swing.JPanel OutrasInformacoes;
    private javax.swing.JPanel Patologias;
    private javax.swing.JPanel PrescricaoMedica;
    private javax.swing.ButtonGroup buttonGroupModelo;
    private javax.swing.ButtonGroup buttonGroupPrescricao;
    private javax.swing.JTextField jABD;
    private javax.swing.JTextField jACV;
    private javax.swing.JTextField jAGU;
    private javax.swing.JTextField jAR;
    public static javax.swing.JButton jBtAdicionarPatologia;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarAtestado;
    private javax.swing.JButton jBtAlterarDieta;
    public static javax.swing.JButton jBtAlterarEvolPsiquiatrica;
    public static javax.swing.JButton jBtAlterarEvolucao;
    private javax.swing.JButton jBtAlterarPrescicao;
    private javax.swing.JButton jBtAtestadoMedico;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaAtestado;
    private javax.swing.JButton jBtAuditoriaDieta;
    public static javax.swing.JButton jBtAuditoriaEvolPsiquiatrica;
    public static javax.swing.JButton jBtAuditoriaEvolucao;
    private javax.swing.JButton jBtAuditoriaPrescicao;
    private javax.swing.JButton jBtBuscar;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarAtestado;
    private javax.swing.JButton jBtCancelarDieta;
    public static javax.swing.JButton jBtCancelarEvolPsiquiatrica;
    public static javax.swing.JButton jBtCancelarEvolucao;
    private javax.swing.JButton jBtCancelarPrescicao;
    private javax.swing.JButton jBtDietaMedica;
    private javax.swing.JButton jBtEncaminhamentoClinico;
    private javax.swing.JButton jBtEncaminhamentoPsi;
    private javax.swing.JButton jBtExames;
    private javax.swing.JButton jBtExamesClinicos;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirAtestado;
    private javax.swing.JButton jBtExcluirDieta;
    public static javax.swing.JButton jBtExcluirEvolPsiquiatrica;
    public static javax.swing.JButton jBtExcluirEvolucao;
    private javax.swing.JButton jBtExcluirPatologia;
    private javax.swing.JButton jBtExcluirPrescicao;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtIdPesqAtend;
    private javax.swing.JButton jBtImpressaoEvolucao;
    private javax.swing.JButton jBtImpressaoEvolucao1;
    private javax.swing.JButton jBtImpressaoPrescricao;
    private javax.swing.JButton jBtImprimirAtestado;
    private javax.swing.JButton jBtImprimirDieta;
    private javax.swing.JButton jBtNovaDieta;
    public static javax.swing.JButton jBtNovaEvolPsiquiatrica;
    public static javax.swing.JButton jBtNovaEvolucao;
    private javax.swing.JButton jBtNovaPrescicao;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoAtestado;
    private javax.swing.JButton jBtPatologias;
    private javax.swing.JButton jBtPatologiasClinica;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqInternoAdm;
    private javax.swing.JButton jBtPesqNomeInterno;
    public static javax.swing.JButton jBtPesquisaEvolucaoMedica;
    public static javax.swing.JButton jBtPesquisaEvolucaoPsi;
    private javax.swing.JButton jBtPrescricaMedica;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarAtestado;
    private javax.swing.JButton jBtSalvarDieta;
    public static javax.swing.JButton jBtSalvarEvolPsiquiatrica;
    public static javax.swing.JButton jBtSalvarEvolucao;
    private javax.swing.JButton jBtSalvarPrescicao;
    private javax.swing.JButton jBtVacinas;
    private javax.swing.JButton jBtVacinasClinicas;
    private javax.swing.JTextField jCABPESC;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JTextField jCid;
    private javax.swing.JTextField jCirurgiasPrevisas;
    private javax.swing.JComboBox jComboBoxABD;
    private javax.swing.JComboBox jComboBoxACV;
    private javax.swing.JComboBox jComboBoxAGU;
    private javax.swing.JComboBox jComboBoxAR;
    private javax.swing.JComboBox jComboBoxAlergias;
    private javax.swing.JComboBox jComboBoxCAB;
    private javax.swing.JComboBox jComboBoxDrogas;
    private javax.swing.JComboBox jComboBoxDrogasInjetavel;
    private javax.swing.JComboBox jComboBoxEXT;
    private javax.swing.JComboBox jComboBoxEtilismo;
    private javax.swing.JComboBox jComboBoxFatorRH;
    private javax.swing.JComboBox jComboBoxIgnoradoAtualizado;
    private javax.swing.JComboBox jComboBoxNumeroParceiro;
    private javax.swing.JComboBox jComboBoxOutrasAlergias;
    public static javax.swing.JComboBox jComboBoxPatologiaAdquirida;
    public static javax.swing.JComboBox jComboBoxPatologiaAdquiridaMedica;
    private javax.swing.JComboBox jComboBoxSexualidade;
    private javax.swing.JComboBox jComboBoxTabagismo;
    private javax.swing.JComboBox<String> jComboBoxTipoDiagnostico;
    private javax.swing.JComboBox jComboBoxTipoSanguineo;
    private javax.swing.JComboBox jComboBoxUsaMedicamento;
    private javax.swing.JComboBox jComboBoxUsaPreserva;
    private javax.swing.JComboBox jComboBoxVacinas;
    private com.toedter.calendar.JDateChooser jDataAdm;
    private com.toedter.calendar.JDateChooser jDataAtestado;
    private com.toedter.calendar.JDateChooser jDataDieta;
    public static com.toedter.calendar.JDateChooser jDataEvolPsiquiatrica;
    public static com.toedter.calendar.JDateChooser jDataEvolucao;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    public static com.toedter.calendar.JDateChooser jDataNascAdm;
    private com.toedter.calendar.JDateChooser jDataPM;
    public static javax.swing.JTextField jDescricaoPatologia;
    private javax.swing.JTextArea jDiagnosticoInicial;
    private javax.swing.JTextField jEXT;
    private javax.swing.JTextArea jExamesSolcitadosMedicos;
    private javax.swing.JTextArea jExamesSolicitadosPsiq;
    public static javax.swing.JLabel jFotoInternoAdm;
    private javax.swing.JTextArea jHipotesesDiagnosticoPsi;
    private javax.swing.JTextArea jHipotestesDiagnosticosMedico;
    private javax.swing.JTextField jIDPesqAtend;
    public static javax.swing.JTextField jIdAdm;
    public static javax.swing.JTextField jIdAtestado;
    public static javax.swing.JTextField jIdDieta;
    public static javax.swing.JTextField jIdEvolucaoMedica;
    public static javax.swing.JTextField jIdEvolucaoPsiquiatrica;
    public static javax.swing.JTextField jIdInternoAdm;
    public static javax.swing.JTextField jIdItem;
    public static javax.swing.JTextField jIdPrescricaoMedica;
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
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jMatriculaPenal;
    public static javax.swing.JTextField jNomeCompletoInternoDiagnosticos;
    public static javax.swing.JTextField jNomeCompletoInternoEvolucaoMedica;
    public static javax.swing.JTextField jNomeInternoAdm;
    private javax.swing.JTextField jNomeInternoAtestado;
    private javax.swing.JTextField jNomeInternoCrcPM;
    private javax.swing.JTextField jNomeInternoDieta;
    public static javax.swing.JTextField jNomeMaeInterno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jPesqNomeInternoOdonto;
    private javax.swing.JTextField jQuaisAlergias;
    private javax.swing.JTextField jQuaisOutrasAlergias;
    private javax.swing.JTextField jQualDrogas;
    private javax.swing.JTextField jQualEtilismo;
    private javax.swing.JTextField jQualMedicacaoUsa;
    private javax.swing.JTextField jQualTipoDrograInjet;
    private javax.swing.JTextField jQuantoTempoTabagismo;
    private javax.swing.JRadioButton jRBPrescricaoMedica;
    private javax.swing.JRadioButton jRBPrescricaoPsiquiatrica;
    private javax.swing.JRadioButton jRadioBtModeloA;
    private javax.swing.JRadioButton jRadioBtModeloAleatorio;
    private javax.swing.JRadioButton jRadioBtModeloB;
    private javax.swing.JRadioButton jRadioBtModeloC;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public static javax.swing.JTextField jSexo;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaAtestado;
    private javax.swing.JTable jTabelaEvolPsiquiatrica;
    private javax.swing.JTable jTabelaEvolucaoMedica;
    private javax.swing.JTable jTabelaMedico;
    private javax.swing.JTable jTabelaPatologia;
    public static javax.swing.JTable jTabelaPrescricaoMedica;
    private javax.swing.JTable jTablaDieta;
    private javax.swing.JTextArea jTextoAtestado;
    private javax.swing.JTextArea jTextoDieta;
    public static javax.swing.JTextArea jTextoEvolucaoMedica;
    public static javax.swing.JTextArea jTextoEvolucaoPsiquiatrica;
    private javax.swing.JTextArea jTextoPrescricaoMedica;
    private javax.swing.JLabel jTotalRegistrosMed;
    private javax.swing.JLabel jTotalRegistrosPsi;
    private javax.swing.JTextField jTratamentoCurso;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void limparCampos() {
        //EVOLUÇÃO P´SIQUIATRICA
        jIdEvolucaoPsiquiatrica.setText("");
        jDataEvolPsiquiatrica.setDate(null);
        jNomeCompletoInternoDiagnosticos.setText("");
        jTextoEvolucaoPsiquiatrica.setText("");
        jHipotesesDiagnosticoPsi.setText("");
        jExamesSolicitadosPsiq.setText("");
        // EVOLUÇÃO MÉDICA
        jIdEvolucaoMedica.setText("");
        jDataEvolucao.setDate(null);
        jNomeCompletoInternoEvolucaoMedica.setText("");
        jTextoEvolucaoMedica.setText("");
        jHipotestesDiagnosticosMedico.setText("");
        jExamesSolcitadosMedicos.setText("");
        //
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText("");
        jDataPM.setDate(null);
        jTextoPrescricaoMedica.setText("");
        //
        jIdAtestado.setText("");
        jNomeInternoAtestado.setText("");
        jDataAtestado.setDate(null);
        jTextoAtestado.setText("");
        //
        jIdDieta.setText("");
        jNomeInternoDieta.setText("");
        jDataDieta.setDate(null);
        jTextoDieta.setText("");
        //
        jIdItem.setText("");
        jDescricaoPatologia.setText("");
        jCid.setText("");
    }

    public void tabelaPatologias() {

        jTabelaPatologia.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPatologia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPatologia.getColumnModel().getColumn(1).setPreferredWidth(320);
        jTabelaPatologia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPatologia.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPatologia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPatologia.getTableHeader().setReorderingAllowed(false);
        jTabelaPatologia.setAutoResizeMode(jTabelaPatologia.AUTO_RESIZE_OFF);
        jTabelaPatologia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaPatologia();
    }

    public void alinharCamposTabelaPatologia() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaPatologia.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }

    public void formatarCampos() {
        jPesqNomeInternoOdonto.setDocument(new LimiteDigitos(70));
        jAR.setDocument(new LimiteDigitosAlfa(70));
        jACV.setDocument(new LimiteDigitosAlfa(70));
        jAGU.setDocument(new LimiteDigitosAlfa(70));
        jCABPESC.setDocument(new LimiteDigitosAlfa(70));
        jEXT.setDocument(new LimiteDigitosAlfa(70));
        jABD.setDocument(new LimiteDigitosAlfa(70));
        jCirurgiasPrevisas.setDocument(new LimiteDigitosAlfa(70));
        jTratamentoCurso.setDocument(new LimiteDigitosAlfa(70));
        jQualDrogas.setDocument(new LimiteDigitosAlfa(70));
        jQualEtilismo.setDocument(new LimiteDigitosAlfa(70));
        jQuantoTempoTabagismo.setDocument(new LimiteDigitosAlfa(70));
        //
        jQualMedicacaoUsa.setDocument(new LimiteDigitosAlfa(31));
        jQuaisOutrasAlergias.setDocument(new LimiteDigitosAlfa(31));
        jQualDrogas.setDocument(new LimiteDigitosAlfa(52));
        jQualTipoDrograInjet.setDocument(new LimiteDigitosAlfa(48));
        jQualEtilismo.setDocument(new LimiteDigitosAlfa(44));
        jQuantoTempoTabagismo.setDocument(new LimiteDigitosAlfa(37));
        //
        jTextoEvolucaoPsiquiatrica.setLineWrap(true);
        jTextoEvolucaoPsiquiatrica.setWrapStyleWord(true);
        jHipotesesDiagnosticoPsi.setLineWrap(true);
        jHipotesesDiagnosticoPsi.setWrapStyleWord(true);
        jExamesSolicitadosPsiq.setLineWrap(true);
        jExamesSolicitadosPsiq.setWrapStyleWord(true);
        //
        jTextoEvolucaoMedica.setLineWrap(true);
        jTextoEvolucaoMedica.setWrapStyleWord(true);
        jHipotestesDiagnosticosMedico.setLineWrap(true);
        jHipotestesDiagnosticosMedico.setWrapStyleWord(true);
        jExamesSolcitadosMedicos.setLineWrap(true);
        jExamesSolcitadosMedicos.setWrapStyleWord(true);
        //
        jTextoPrescricaoMedica.setLineWrap(true);
        jTextoPrescricaoMedica.setWrapStyleWord(true);
        //
        jTextoDieta.setLineWrap(true);
        jTextoDieta.setWrapStyleWord(true);
        //
        jDiagnosticoInicial.setLineWrap(true);
        jDiagnosticoInicial.setWrapStyleWord(true);
        //
        modeloAtestadoA = "            ATESTADO MÉDICO \n\n\n "
                + "Declaro para os devidos fins que o Sr. (nome), (nacionalidade), (estado civil), "
                + "(profissão), inscrito no CPF sob o nº (informar) e no RG nº (informar), paciente sob "
                + "meus cuidados, não se encontra em condições para o trabalho, devendo se "
                + "afastar de suas atividades profissionais e permanecer em repouso de (data de "
                + "início) à (data de liberação). "
                + "\n\n(localidade), (dia) de (mês) de (ano).";
        modeloAtestadoB = "            ATESTADO MÉDICO \n\n\n\n "
                + "Atesto para os devidos fins a pedido do interessado que o Sr. FULAO DE TAL, portador de "
                + "RG XXXXXXXXX foi submetido a consulta médica nesta data, no horário das 15:00 hs, sendo "
                + "portador de afecção CID XXXXX. "
                + "Salvador, 18 de Dezembro de 2015 "
                + "___________________________ \n"
                + "AUTORIZAÇÃO "
                + "Eu FULANO DE TAL autorizo o Dr. FULANO DE TAL, a regstrar o diagnóstico CID "
                + "neste atestado médico\n\n\n "
                + "________________________________";
        modeloAtestadoC = "             ATESTADO MÉDICO \n\n\n "
                + "Atesto que o(a) Sr.(a) FULANO DE TAL portador(a)da Carteira de Identidade nº XXXXX, "
                + "encontra-se em boas condições de saúde, estando apto  para  realizar  o "
                + "exame  de  aptidão  física  previsto  no  Edital  nº  55/2014  –  DGP/DPF,"
                + "de  25  de setembro  de  2014,  do  concurso  público  para  provimento  de "
                + "vagas  no  cargo  de  Agente Penitenciario";
        modeloAtestadoAleatorio = "     ATESTADO MÉDICO \n\n\n ";
        jTextoAtestado.setLineWrap(true);
        jTextoAtestado.setWrapStyleWord(true);
        //
        jTextoDieta.setLineWrap(true);
        jTextoDieta.setWrapStyleWord(true);
        //
//        jTextoEvolucaoPsicologica.setLineWrap(true);
//        jTextoEvolucaoPsicologica.setWrapStyleWord(true);
//        //
//        jTextoEvolucaoTerapeuta.setLineWrap(true);
//        jTextoEvolucaoTerapeuta.setWrapStyleWord(true);
    }

    public void corCampos() {
        // TELA DE ADMISSÃO MÉDICA/PSIQUIATRICA
        jIdAdm.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jDataAdm.setBackground(Color.white);
        jIdInternoAdm.setBackground(Color.white);
        jNomeInternoAdm.setBackground(Color.white);
        jDataNascAdm.setBackground(Color.white);
        jSexo.setBackground(Color.white);
        jMatriculaPenal.setBackground(Color.white);
        jNomeMaeInterno.setBackground(Color.white);
        jFotoInternoAdm.setBackground(Color.white);
        jComboBoxAR.setBackground(Color.white);
        jComboBoxACV.setBackground(Color.white);
        jComboBoxAGU.setBackground(Color.white);
        jComboBoxCAB.setBackground(Color.white);
        jComboBoxEXT.setBackground(Color.white);
        jComboBoxABD.setBackground(Color.white);
        jAR.setBackground(Color.white);
        jACV.setBackground(Color.white);
        jAGU.setBackground(Color.white);
        jCABPESC.setBackground(Color.white);
        jEXT.setBackground(Color.white);
        jABD.setBackground(Color.white);
        jCirurgiasPrevisas.setBackground(Color.white);
        jTratamentoCurso.setBackground(Color.white);
        jQualDrogas.setBackground(Color.white);
        jComboBoxDrogasInjetavel.setBackground(Color.white);
        jQualTipoDrograInjet.setBackground(Color.white);
        jQualEtilismo.setBackground(Color.white);
        jComboBoxDrogas.setBackground(Color.white);
        jComboBoxEtilismo.setBackground(Color.white);
        jComboBoxTabagismo.setBackground(Color.white);
        jQuantoTempoTabagismo.setBackground(Color.white);
        jComboBoxSexualidade.setBackground(Color.white);
        jComboBoxNumeroParceiro.setBackground(Color.white);
        jComboBoxUsaPreserva.setBackground(Color.white);
        jComboBoxTipoSanguineo.setBackground(Color.white);
        jComboBoxFatorRH.setBackground(Color.white);
        jComboBoxVacinas.setBackground(Color.white);
        jComboBoxIgnoradoAtualizado.setBackground(Color.white);
        jComboBoxAlergias.setBackground(Color.white);
        jQuaisAlergias.setBackground(Color.white);
        jIdItem.setBackground(Color.white);
        jDescricaoPatologia.setBackground(Color.white);
        jCid.setBackground(Color.white);
        jQualMedicacaoUsa.setBackground(Color.white);
        jQuaisOutrasAlergias.setBackground(Color.white);
        // TELA EVOLUÇAO PSIQUIATRICA
        jIdEvolucaoPsiquiatrica.setBackground(Color.white);
        jNomeCompletoInternoDiagnosticos.setBackground(Color.white);
        jDataEvolPsiquiatrica.setBackground(Color.white);
        jTextoEvolucaoPsiquiatrica.setBackground(Color.white);
        // TELA DE EVOLUÇÃO MÉDICA
        jIdEvolucaoMedica.setBackground(Color.white);
        jNomeCompletoInternoEvolucaoMedica.setBackground(Color.white);
        jDataEvolucao.setBackground(Color.white);
        // TELA PRESCRIÇÃO MÉDICA/PSIQUIATRICA
        jIdPrescricaoMedica.setBackground(Color.white);
        jNomeInternoCrcPM.setBackground(Color.white);
        jDataPM.setBackground(Color.white);
        jTextoPrescricaoMedica.setBackground(Color.white);
        // TELA DE ATESTADO MÉDICO/PSIQUIATRICO
        jIdAtestado.setBackground(Color.white);
        jNomeInternoAtestado.setBackground(Color.white);
        jDataAtestado.setBackground(Color.white);
        jTextoAtestado.setBackground(Color.white);
        // TELA DE DIETA MÉDICA
        jIdDieta.setBackground(Color.white);
        jNomeInternoDieta.setBackground(Color.white);
        jDataDieta.setBackground(Color.white);
        jTextoDieta.setBackground(Color.white);
    }

    public void Novo() {
        //Limpar Campos para inclusão
        jIdAdm.setText("");
        jStatusLanc.setText("ABERTO");
        jDataAdm.setCalendar(Calendar.getInstance());
        jIdInternoAdm.setText("");
        jNomeInternoAdm.setText("");
        jDataNascAdm.setDate(null);
        jSexo.setText("");
        jMatriculaPenal.setText("");
        jNomeMaeInterno.setText("");
        jFotoInternoAdm.setIcon(null);
        jComboBoxAR.setSelectedItem("Não");
        jComboBoxACV.setSelectedItem("Não");
        jComboBoxAGU.setSelectedItem("Não");
        jComboBoxCAB.setSelectedItem("Não");
        jComboBoxEXT.setSelectedItem("Não");
        jComboBoxABD.setSelectedItem("Não");
        jAR.setText("");
        jACV.setText("");
        jAGU.setText("");
        jCABPESC.setText("");
        jEXT.setText("");
        jABD.setText("");
        jCirurgiasPrevisas.setText("");
        jTratamentoCurso.setText("");
        jQualDrogas.setText("");
        jComboBoxDrogasInjetavel.setSelectedItem("Não");
        jQualTipoDrograInjet.setText("");
        jQualEtilismo.setText("");
        jComboBoxDrogas.setSelectedItem("Não");
        jComboBoxEtilismo.setSelectedItem("Não");
        jComboBoxTabagismo.setSelectedItem("Não");
        jQuantoTempoTabagismo.setText("");
        jComboBoxSexualidade.setSelectedItem("Heterosssexual");
        jComboBoxNumeroParceiro.setSelectedItem("Um");
        jComboBoxUsaPreserva.setSelectedItem("Nunca");
        jComboBoxTipoSanguineo.setSelectedItem("O");
        jComboBoxFatorRH.setSelectedItem("Negativo");
        jComboBoxVacinas.setSelectedItem("Não");
        jComboBoxIgnoradoAtualizado.setSelectedItem("Atualizado");
        jComboBoxAlergias.setSelectedItem("Não");
        jQuaisAlergias.setText("");
        jComboBoxUsaMedicamento.setSelectedItem("Não");
        jQualMedicacaoUsa.setText("");
        jComboBoxOutrasAlergias.setSelectedItem("Não");
        jQuaisOutrasAlergias.setText("");
        jDiagnosticoInicial.setText("");
        jComboBoxTipoDiagnostico.setSelectedItem("Selecione...");
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //Habilitar/Desabilitar Campos
        jDataAdm.setEnabled(true);
        jBtPesqInternoAdm.setEnabled(true);
        jComboBoxAR.setEnabled(true);
        jComboBoxACV.setEnabled(true);
        jComboBoxAGU.setEnabled(true);
        jComboBoxCAB.setEnabled(true);
        jComboBoxEXT.setEnabled(true);
        jComboBoxABD.setEnabled(true);
        jAR.setEnabled(true);
        jACV.setEnabled(true);
        jAGU.setEnabled(true);
        jCABPESC.setEnabled(true);
        jEXT.setEnabled(true);
        jABD.setEnabled(true);
        jCirurgiasPrevisas.setEnabled(true);
        jTratamentoCurso.setEnabled(true);
        jQualDrogas.setEnabled(true);
        jComboBoxDrogasInjetavel.setEnabled(true);
        jQualTipoDrograInjet.setEnabled(true);
        jQualEtilismo.setEnabled(true);
        jComboBoxDrogas.setEnabled(true);
        jComboBoxEtilismo.setEnabled(true);
        jComboBoxTabagismo.setEnabled(true);
        jQuantoTempoTabagismo.setEnabled(true);
        jComboBoxSexualidade.setEnabled(true);
        jComboBoxNumeroParceiro.setEnabled(true);
        jComboBoxUsaPreserva.setEnabled(true);
        jComboBoxTipoSanguineo.setEnabled(true);
        jComboBoxFatorRH.setEnabled(true);
        jComboBoxVacinas.setEnabled(true);
        jComboBoxIgnoradoAtualizado.setEnabled(true);
        jComboBoxAlergias.setEnabled(true);
        jQuaisAlergias.setEnabled(true);
        jComboBoxUsaMedicamento.setEnabled(true);
        jQualMedicacaoUsa.setEnabled(true);
        jComboBoxOutrasAlergias.setEnabled(true);
        jQuaisOutrasAlergias.setEnabled(true);
        jDiagnosticoInicial.setEnabled(true);
        jComboBoxTipoDiagnostico.setEnabled(true);
        //
        jIdItem.setText("");
        jDescricaoPatologia.setText("");
        jCid.setText("");
        jBtBuscar.setEnabled(true);
        jBtAdicionarPatologia.setEnabled(!true);
        jBtExcluirPatologia.setEnabled(!true);
        // EVOLUÇÃO PSIQUIATRICA
        jIdEvolucaoPsiquiatrica.setText("");
        jNomeCompletoInternoDiagnosticos.setText("");
        jDataEvolPsiquiatrica.setDate(null);
        jTextoEvolucaoPsiquiatrica.setText("");
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        //
        jBtNovaEvolPsiquiatrica.setEnabled(!true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtPesquisaEvolucaoPsi.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // EVOLUÇÃO MÉDICA
        jIdEvolucaoMedica.setText("");
        jNomeCompletoInternoEvolucaoMedica.setText("");
        jDataEvolucao.setDate(null);
        jTextoEvolucaoMedica.setText("");
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtPesquisaEvolucaoMedica.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText("");
        jDataPM.setDate(null);
        jTextoPrescricaoMedica.setText("");
        //
        jBtNovaPrescicao.setEnabled(!true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        // ATESTADO MÉDICO
        jIdAtestado.setText("");
        jNomeInternoAtestado.setText("");
        jDataAtestado.setDate(null);
        jTextoAtestado.setText("");
        //
        jBtNovoAtestado.setEnabled(!true);
        jBtAlterarAtestado.setEnabled(!true);
        jBtExcluirAtestado.setEnabled(!true);
        jBtCancelarAtestado.setEnabled(!true);
        jBtSalvarAtestado.setEnabled(!true);
        jBtImprimirAtestado.setEnabled(!true);
        jBtAuditoriaAtestado.setEnabled(!true);
        jRadioBtModeloA.setEnabled(!true);
        jRadioBtModeloB.setEnabled(!true);
        jRadioBtModeloC.setEnabled(!true);
        jRadioBtModeloAleatorio.setEnabled(!true);
        // DIETA MÉDICA
        jIdDieta.setText("");
        jNomeInternoDieta.setText("");
        jDataDieta.setDate(null);
        jTextoDieta.setText("");
        //
        jBtNovaDieta.setEnabled(!true);
        jBtAlterarDieta.setEnabled(!true);
        jBtExcluirDieta.setEnabled(!true);
        jBtSalvarDieta.setEnabled(!true);
        jBtCancelarDieta.setEnabled(!true);
        jBtImprimirDieta.setEnabled(!true);
        jBtAuditoriaDieta.setEnabled(!true);
    }

    public void Alterar() {
        //Habilitar/Desabilitar Campos
        jDataAdm.setEnabled(true);
        jBtPesqInternoAdm.setEnabled(!true);
        jComboBoxAR.setEnabled(true);
        jComboBoxACV.setEnabled(true);
        jComboBoxAGU.setEnabled(true);
        jComboBoxCAB.setEnabled(true);
        jComboBoxEXT.setEnabled(true);
        jComboBoxABD.setEnabled(true);
        jAR.setEnabled(true);
        jACV.setEnabled(true);
        jAGU.setEnabled(true);
        jCABPESC.setEnabled(true);
        jEXT.setEnabled(true);
        jABD.setEnabled(true);
        jCirurgiasPrevisas.setEnabled(true);
        jTratamentoCurso.setEnabled(true);
        jQualDrogas.setEnabled(true);
        jComboBoxDrogasInjetavel.setEnabled(true);
        jQualTipoDrograInjet.setEnabled(true);
        jQualEtilismo.setEnabled(true);
        jComboBoxDrogas.setEnabled(true);
        jComboBoxEtilismo.setEnabled(true);
        jComboBoxTabagismo.setEnabled(true);
        jQuantoTempoTabagismo.setEnabled(true);
        jComboBoxSexualidade.setEnabled(true);
        jComboBoxNumeroParceiro.setEnabled(true);
        jComboBoxUsaPreserva.setEnabled(true);
        jComboBoxTipoSanguineo.setEnabled(true);
        jComboBoxFatorRH.setEnabled(true);
        jComboBoxVacinas.setEnabled(true);
        jComboBoxIgnoradoAtualizado.setEnabled(true);
        jComboBoxAlergias.setEnabled(true);
        jQuaisAlergias.setEnabled(true);
        jComboBoxUsaMedicamento.setEnabled(true);
        jQualMedicacaoUsa.setEnabled(true);
        jComboBoxOutrasAlergias.setEnabled(true);
        jQuaisOutrasAlergias.setEnabled(true);
        jDiagnosticoInicial.setEnabled(true);
        jComboBoxTipoDiagnostico.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jBtBuscar.setEnabled(true);
        jBtAdicionarPatologia.setEnabled(!true);
        jBtExcluirPatologia.setEnabled(!true);
        jTabelaPatologia.setEnabled(true);
        // EVOLUÇÃO PSIQUIATRICA        
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jBtNovaEvolPsiquiatrica.setEnabled(!true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtPesquisaEvolucaoPsi.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // EVOLUÇÃO MÉDICA        
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtPesquisaEvolucaoMedica.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA        
        jBtNovaPrescicao.setEnabled(!true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        // ATESTADO MÉDICO       
        jBtNovoAtestado.setEnabled(!true);
        jBtAlterarAtestado.setEnabled(!true);
        jBtExcluirAtestado.setEnabled(!true);
        jBtCancelarAtestado.setEnabled(!true);
        jBtSalvarAtestado.setEnabled(!true);
        jBtImprimirAtestado.setEnabled(!true);
        jBtAuditoriaAtestado.setEnabled(!true);
        jRadioBtModeloA.setEnabled(!true);
        jRadioBtModeloB.setEnabled(!true);
        jRadioBtModeloC.setEnabled(!true);
        jRadioBtModeloAleatorio.setEnabled(!true);
        // DIETA MÉDICA        
        jBtNovaDieta.setEnabled(!true);
        jBtAlterarDieta.setEnabled(!true);
        jBtExcluirDieta.setEnabled(!true);
        jBtSalvarDieta.setEnabled(!true);
        jBtCancelarDieta.setEnabled(!true);
        jBtImprimirDieta.setEnabled(!true);
        jBtAuditoriaDieta.setEnabled(!true);
    }

    public void Excluir() {
        //Limpar Campos para inclusão
        jIdAdm.setText("");
        jStatusLanc.setText("");
        jDataAdm.setDate(null);
        jIdInternoAdm.setText("");
        jNomeInternoAdm.setText("");
        jDataNascAdm.setDate(null);
        jSexo.setText("");
        jMatriculaPenal.setText("");
        jNomeMaeInterno.setText("");
        jFotoInternoAdm.setIcon(null);
        jComboBoxAR.setSelectedItem("Não");
        jComboBoxACV.setSelectedItem("Não");
        jComboBoxAGU.setSelectedItem("Não");
        jComboBoxCAB.setSelectedItem("Não");
        jComboBoxEXT.setSelectedItem("Não");
        jComboBoxABD.setSelectedItem("Não");
        jAR.setText("");
        jACV.setText("");
        jAGU.setText("");
        jCABPESC.setText("");
        jEXT.setText("");
        jABD.setText("");
        jCirurgiasPrevisas.setText("");
        jTratamentoCurso.setText("");
        jQualDrogas.setText("");
        jComboBoxDrogasInjetavel.setSelectedItem("Não");
        jQualTipoDrograInjet.setText("");
        jQualEtilismo.setText("");
        jComboBoxDrogas.setSelectedItem("Não");
        jComboBoxEtilismo.setSelectedItem("Não");
        jComboBoxTabagismo.setSelectedItem("Não");
        jQuantoTempoTabagismo.setText("");
        jComboBoxSexualidade.setSelectedItem("Heterosssexual");
        jComboBoxNumeroParceiro.setSelectedItem("Um");
        jComboBoxUsaPreserva.setSelectedItem("Nunca");
        jComboBoxTipoSanguineo.setSelectedItem("O");
        jComboBoxFatorRH.setSelectedItem("Negativo");
        jComboBoxVacinas.setSelectedItem("Não");
        jComboBoxIgnoradoAtualizado.setSelectedItem("Atualizado");
        jComboBoxAlergias.setSelectedItem("Não");
        jQuaisAlergias.setText("");
        jComboBoxUsaMedicamento.setSelectedItem("Não");
        jQualMedicacaoUsa.setText("");
        jComboBoxOutrasAlergias.setSelectedItem("Não");
        jQuaisOutrasAlergias.setText("");
        jDiagnosticoInicial.setText("");
        jComboBoxTipoDiagnostico.setSelectedItem("Selecione...");
        //Habilitar/Desabilitar Campos
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jComboBoxAR.setEnabled(!true);
        jComboBoxACV.setEnabled(!true);
        jComboBoxAGU.setEnabled(!true);
        jComboBoxCAB.setEnabled(!true);
        jComboBoxEXT.setEnabled(!true);
        jComboBoxABD.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jComboBoxDrogasInjetavel.setEnabled(!true);
        jQualTipoDrograInjet.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxSexualidade.setEnabled(!true);
        jComboBoxNumeroParceiro.setEnabled(!true);
        jComboBoxUsaPreserva.setEnabled(!true);
        jComboBoxTipoSanguineo.setEnabled(!true);
        jComboBoxFatorRH.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        jComboBoxAlergias.setEnabled(!true);
        jQuaisAlergias.setEnabled(!true);
        jComboBoxUsaMedicamento.setEnabled(!true);
        jQualMedicacaoUsa.setEnabled(!true);
        jComboBoxOutrasAlergias.setEnabled(!true);
        jQuaisOutrasAlergias.setEnabled(!true);
        jDiagnosticoInicial.setEnabled(!true);
        jComboBoxTipoDiagnostico.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jBtBuscar.setEnabled(!true);
        jBtAdicionarPatologia.setEnabled(!true);
        jBtExcluirPatologia.setEnabled(!true);
        // EVOLUÇÃO PSIQUIATRICA
        jIdEvolucaoPsiquiatrica.setText("");
        jNomeCompletoInternoDiagnosticos.setText("");
        jDataEvolPsiquiatrica.setDate(null);
        jTextoEvolucaoPsiquiatrica.setText("");
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        //
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtPesquisaEvolucaoPsi.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // EVOLUÇÃO MÉDICA
        jIdEvolucaoMedica.setText("");
        jNomeCompletoInternoEvolucaoMedica.setText("");
        jDataEvolucao.setDate(null);
        jTextoEvolucaoMedica.setText("");
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtPesquisaEvolucaoMedica.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText("");
        jDataPM.setDate(null);
        jTextoPrescricaoMedica.setText("");
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        // ATESTADO MÉDICO
        jIdAtestado.setText("");
        jNomeInternoAtestado.setText("");
        jDataAtestado.setDate(null);
        jTextoAtestado.setText("");
        //
        jBtNovoAtestado.setEnabled(true);
        jBtAlterarAtestado.setEnabled(!true);
        jBtExcluirAtestado.setEnabled(!true);
        jBtCancelarAtestado.setEnabled(!true);
        jBtSalvarAtestado.setEnabled(!true);
        jBtImprimirAtestado.setEnabled(!true);
        jBtAuditoriaAtestado.setEnabled(!true);
        jRadioBtModeloA.setEnabled(!true);
        jRadioBtModeloB.setEnabled(!true);
        jRadioBtModeloC.setEnabled(!true);
        jRadioBtModeloAleatorio.setEnabled(!true);
        // DIETA MÉDICA
        jIdDieta.setText("");
        jNomeInternoDieta.setText("");
        jDataDieta.setDate(null);
        jTextoDieta.setText("");
        //
        jBtNovaDieta.setEnabled(true);
        jBtAlterarDieta.setEnabled(!true);
        jBtExcluirDieta.setEnabled(!true);
        jBtSalvarDieta.setEnabled(!true);
        jBtCancelarDieta.setEnabled(!true);
        jBtImprimirDieta.setEnabled(!true);
        jBtAuditoriaDieta.setEnabled(!true);
    }

    public void Salvar() {
        //Habilitar/Desabilitar Campos
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jComboBoxAR.setEnabled(!true);
        jComboBoxACV.setEnabled(!true);
        jComboBoxAGU.setEnabled(!true);
        jComboBoxCAB.setEnabled(!true);
        jComboBoxEXT.setEnabled(!true);
        jComboBoxABD.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jComboBoxDrogasInjetavel.setEnabled(!true);
        jQualTipoDrograInjet.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxSexualidade.setEnabled(!true);
        jComboBoxNumeroParceiro.setEnabled(!true);
        jComboBoxUsaPreserva.setEnabled(!true);
        jComboBoxTipoSanguineo.setEnabled(!true);
        jComboBoxFatorRH.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        jComboBoxAlergias.setEnabled(!true);
        jQuaisAlergias.setEnabled(!true);
        jComboBoxUsaMedicamento.setEnabled(!true);
        jQualMedicacaoUsa.setEnabled(!true);
        jComboBoxOutrasAlergias.setEnabled(!true);
        jQuaisOutrasAlergias.setEnabled(!true);
        jDiagnosticoInicial.setEnabled(!true);
        jComboBoxTipoDiagnostico.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jBtBuscar.setEnabled(!true);
        jBtAdicionarPatologia.setEnabled(!true);
        jBtExcluirPatologia.setEnabled(!true);
        // EVOLUÇÃO PSIQUIATRICA        
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtPesquisaEvolucaoPsi.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // EVOLUÇÃO MÉDICA       
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtPesquisaEvolucaoMedica.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA        
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        // ATESTADO MÉDICO        
        jBtNovoAtestado.setEnabled(true);
        jBtAlterarAtestado.setEnabled(!true);
        jBtExcluirAtestado.setEnabled(!true);
        jBtCancelarAtestado.setEnabled(!true);
        jBtSalvarAtestado.setEnabled(!true);
        jBtImprimirAtestado.setEnabled(!true);
        jBtAuditoriaAtestado.setEnabled(!true);
        jRadioBtModeloA.setEnabled(!true);
        jRadioBtModeloB.setEnabled(!true);
        jRadioBtModeloC.setEnabled(!true);
        jRadioBtModeloAleatorio.setEnabled(!true);
        // DIETA MÉDICA       
        jBtNovaDieta.setEnabled(true);
        jBtAlterarDieta.setEnabled(!true);
        jBtExcluirDieta.setEnabled(!true);
        jBtSalvarDieta.setEnabled(!true);
        jBtCancelarDieta.setEnabled(!true);
        jBtImprimirDieta.setEnabled(!true);
        jBtAuditoriaDieta.setEnabled(!true);
    }

    public void Cancelar() {
        if (jIdAdm.getText().equals("")) {
            jIdAdm.setText("");
            jStatusLanc.setText("");
            jDataAdm.setDate(null);
            jIdInternoAdm.setText("");
            jNomeInternoAdm.setText("");
            jDataNascAdm.setDate(null);
            jSexo.setText("");
            jMatriculaPenal.setText("");
            jNomeMaeInterno.setText("");
            jFotoInternoAdm.setIcon(null);
            jComboBoxAR.setSelectedItem("Não");
            jComboBoxACV.setSelectedItem("Não");
            jComboBoxAGU.setSelectedItem("Não");
            jComboBoxCAB.setSelectedItem("Não");
            jComboBoxEXT.setSelectedItem("Não");
            jComboBoxABD.setSelectedItem("Não");
            jAR.setText("");
            jACV.setText("");
            jAGU.setText("");
            jCABPESC.setText("");
            jEXT.setText("");
            jABD.setText("");
            jCirurgiasPrevisas.setText("");
            jTratamentoCurso.setText("");
            jQualDrogas.setText("");
            jComboBoxDrogasInjetavel.setSelectedItem("Não");
            jQualTipoDrograInjet.setText("");
            jQualEtilismo.setText("");
            jComboBoxDrogas.setSelectedItem("Não");
            jComboBoxEtilismo.setSelectedItem("Não");
            jComboBoxTabagismo.setSelectedItem("Não");
            jQuantoTempoTabagismo.setText("");
            jComboBoxSexualidade.setSelectedItem("Heterosssexual");
            jComboBoxNumeroParceiro.setSelectedItem("Um");
            jComboBoxUsaPreserva.setSelectedItem("Nunca");
            jComboBoxTipoSanguineo.setSelectedItem("O");
            jComboBoxFatorRH.setSelectedItem("Negativo");
            jComboBoxVacinas.setSelectedItem("Não");
            jComboBoxIgnoradoAtualizado.setSelectedItem("Atualizado");
            jComboBoxAlergias.setSelectedItem("Não");
            jQuaisAlergias.setText("");
            jComboBoxUsaMedicamento.setSelectedItem("Não");
            jQualMedicacaoUsa.setText("");
            jComboBoxOutrasAlergias.setSelectedItem("Não");
            jQuaisOutrasAlergias.setText("");
            jDiagnosticoInicial.setText("");
            jComboBoxTipoDiagnostico.setSelectedItem("Selecione...");
            //
            jDataAdm.setEnabled(!true);
            jBtPesqInternoAdm.setEnabled(!true);
            jComboBoxAR.setEnabled(!true);
            jComboBoxACV.setEnabled(!true);
            jComboBoxAGU.setEnabled(!true);
            jComboBoxCAB.setEnabled(!true);
            jComboBoxEXT.setEnabled(!true);
            jComboBoxABD.setEnabled(!true);
            jAR.setEnabled(!true);
            jACV.setEnabled(!true);
            jAGU.setEnabled(!true);
            jCABPESC.setEnabled(!true);
            jEXT.setEnabled(!true);
            jABD.setEnabled(!true);
            jCirurgiasPrevisas.setEnabled(!true);
            jTratamentoCurso.setEnabled(!true);
            jQualDrogas.setEnabled(!true);
            jComboBoxDrogasInjetavel.setEnabled(!true);
            jQualTipoDrograInjet.setEnabled(!true);
            jQualEtilismo.setEnabled(!true);
            jComboBoxDrogas.setEnabled(!true);
            jComboBoxEtilismo.setEnabled(!true);
            jComboBoxTabagismo.setEnabled(!true);
            jQuantoTempoTabagismo.setEnabled(!true);
            jComboBoxSexualidade.setEnabled(!true);
            jComboBoxNumeroParceiro.setEnabled(!true);
            jComboBoxUsaPreserva.setEnabled(!true);
            jComboBoxTipoSanguineo.setEnabled(!true);
            jComboBoxFatorRH.setEnabled(!true);
            jComboBoxVacinas.setEnabled(!true);
            jComboBoxIgnoradoAtualizado.setEnabled(!true);
            jComboBoxAlergias.setEnabled(!true);
            jQuaisAlergias.setEnabled(!true);
            jComboBoxUsaMedicamento.setEnabled(!true);
            jQualMedicacaoUsa.setEnabled(!true);
            jComboBoxOutrasAlergias.setEnabled(!true);
            jQuaisOutrasAlergias.setEnabled(!true);
            jDiagnosticoInicial.setEnabled(!true);
            jComboBoxTipoDiagnostico.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
            //
            jIdItem.setText("");
            jDescricaoPatologia.setText("");
            jCid.setText("");
            jBtBuscar.setEnabled(!true);
            // PRESCRIÇÃO MÉDICA       
            jDataPM.setEnabled(!true);
            jRBPrescricaoMedica.setEnabled(!true);
            jRBPrescricaoPsiquiatrica.setEnabled(!true);
            jTextoPrescricaoMedica.setEnabled(!true);
            //
            jBtNovaPrescicao.setEnabled(!true);
            jBtAlterarPrescicao.setEnabled(!true);
            jBtExcluirPrescicao.setEnabled(!true);
            jBtSalvarPrescicao.setEnabled(!true);
            jBtCancelarPrescicao.setEnabled(!true);
            jBtAuditoriaPrescicao.setEnabled(!true);
            jRBPrescricaoMedica.setEnabled(!true);
            //  EVOLUÇÃO PSIQUIATRICA
            jRBPrescricaoPsiquiatrica.setEnabled(!true);
        } else {
            //Habilitar/Desabilitar Campos
            jDataAdm.setEnabled(!true);
            jBtPesqInternoAdm.setEnabled(!true);
            jComboBoxAR.setEnabled(!true);
            jComboBoxACV.setEnabled(!true);
            jComboBoxAGU.setEnabled(!true);
            jComboBoxCAB.setEnabled(!true);
            jComboBoxEXT.setEnabled(!true);
            jComboBoxABD.setEnabled(!true);
            jAR.setEnabled(!true);
            jACV.setEnabled(!true);
            jAGU.setEnabled(!true);
            jCABPESC.setEnabled(!true);
            jEXT.setEnabled(!true);
            jABD.setEnabled(!true);
            jCirurgiasPrevisas.setEnabled(!true);
            jTratamentoCurso.setEnabled(!true);
            jQualDrogas.setEnabled(!true);
            jComboBoxDrogasInjetavel.setEnabled(!true);
            jQualTipoDrograInjet.setEnabled(!true);
            jQualEtilismo.setEnabled(!true);
            jComboBoxDrogas.setEnabled(!true);
            jComboBoxEtilismo.setEnabled(!true);
            jComboBoxTabagismo.setEnabled(!true);
            jQuantoTempoTabagismo.setEnabled(!true);
            jComboBoxSexualidade.setEnabled(!true);
            jComboBoxNumeroParceiro.setEnabled(!true);
            jComboBoxUsaPreserva.setEnabled(!true);
            jComboBoxTipoSanguineo.setEnabled(!true);
            jComboBoxFatorRH.setEnabled(!true);
            jComboBoxVacinas.setEnabled(!true);
            jComboBoxIgnoradoAtualizado.setEnabled(!true);
            jComboBoxAlergias.setEnabled(!true);
            jQuaisAlergias.setEnabled(!true);
            jComboBoxUsaMedicamento.setEnabled(!true);
            jQualMedicacaoUsa.setEnabled(!true);
            jComboBoxOutrasAlergias.setEnabled(!true);
            jQuaisOutrasAlergias.setEnabled(!true);
            jDiagnosticoInicial.setEnabled(!true);
            jComboBoxTipoDiagnostico.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //
            jBtBuscar.setEnabled(!true);
            jBtAdicionarPatologia.setEnabled(!true);
            jBtExcluirPatologia.setEnabled(!true);
            jIdItem.setText("");
            jDescricaoPatologia.setText("");
            jCid.setText("");
            // PRESCRIÇÃO MÉDICA
            jIdPrescricaoMedica.setText("");
            jNomeInternoCrcPM.setText("");
            jDataPM.setDate(null);
            jTextoPrescricaoMedica.setText("");
            //
            jBtNovaPrescicao.setEnabled(true);
            jBtAlterarPrescicao.setEnabled(!true);
            jBtExcluirPrescicao.setEnabled(!true);
            jBtSalvarPrescicao.setEnabled(!true);
            jBtCancelarPrescicao.setEnabled(!true);
            jBtImpressaoPrescricao.setEnabled(!true);
            jBtAuditoriaPrescicao.setEnabled(!true);
            jRBPrescricaoMedica.setEnabled(!true);
            jRBPrescricaoPsiquiatrica.setEnabled(!true);
            // EVOLUÇÃO PSIQUIATRICA
            jBtNovaEvolPsiquiatrica.setEnabled(true);
        }
    }

    public void Finalizar() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusAtend = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse atendimento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente FINALIZA o ATENDIMENTO selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objAdmMedico.setStatusLanc(statusAtend);
            objAdmMedico.setIdLanc(Integer.parseInt(jIdAdm.getText()));
            control.finalizarAdmissaoMedica(objAdmMedico);
            objAdmMedico.setIdLanc(Integer.valueOf(jIdAdm.getText()));
            controle.finalizarMovTec(objAdmMedico);
            jStatusLanc.setText(statusAtend);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            //Habilitar/Desabilitar Campos
            jDataAdm.setEnabled(!true);
            jBtPesqInternoAdm.setEnabled(!true);
            jAR.setEnabled(!true);
            jACV.setEnabled(!true);
            jAGU.setEnabled(!true);
            jCABPESC.setEnabled(!true);
            jEXT.setEnabled(!true);
            jABD.setEnabled(!true);
            jCirurgiasPrevisas.setEnabled(!true);
            jTratamentoCurso.setEnabled(!true);
            jQualDrogas.setEnabled(!true);
            jQualEtilismo.setEnabled(!true);
            jQuantoTempoTabagismo.setEnabled(!true);
            jComboBoxDrogas.setEnabled(!true);
            jComboBoxEtilismo.setEnabled(!true);
            jComboBoxTabagismo.setEnabled(!true);
            jComboBoxVacinas.setEnabled(!true);
            jComboBoxIgnoradoAtualizado.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
        }
    }

    public void buscarID() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOMEDICA");
            conecta.rs.last();
            jIdAdm.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar ATENDIMENTO \nERRO: " + ex);
        }
    }

    public void NovaEvolPsiquiatrica() {
        jIdEvolucaoPsiquiatrica.setText("");
        jNomeCompletoInternoDiagnosticos.setText(jNomeInternoAdm.getText());
        jDataEvolPsiquiatrica.setCalendar(Calendar.getInstance());
        jComboBoxPatologiaAdquirida.setSelectedItem("Não");
        jTextoEvolucaoPsiquiatrica.setText("");
        jHipotesesDiagnosticoPsi.setText("");
        jExamesSolicitadosPsiq.setText("");
        //
        jDataEvolPsiquiatrica.setEnabled(true);
        jComboBoxPatologiaAdquirida.setEnabled(true);
        jTextoEvolucaoPsiquiatrica.setEnabled(true);
        jHipotesesDiagnosticoPsi.setEnabled(true);
        jExamesSolicitadosPsiq.setEnabled(true);
        //
        jBtPatologias.setEnabled(!true);
        jBtExames.setEnabled(!true);
        jBtVacinas.setEnabled(!true);
        jBtEncaminhamentoPsi.setEnabled(!true);
        //
        jBtNovaEvolPsiquiatrica.setEnabled(!true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(true);
        jBtCancelarEvolPsiquiatrica.setEnabled(true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jDataEvolucao.setEnabled(!true);
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText("");
        jDataPM.setDate(null);
        jTextoPrescricaoMedica.setText("");
        //
        jBtNovaPrescicao.setEnabled(!true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
    }

    public void AlterarEvolPsiquiatrica() {
        //
        jDataEvolPsiquiatrica.setEnabled(true);
        jComboBoxPatologiaAdquirida.setEnabled(true);
        jTextoEvolucaoPsiquiatrica.setEnabled(true);
        jHipotesesDiagnosticoPsi.setEnabled(true);
        jExamesSolicitadosPsiq.setEnabled(true);
        //
        jBtPatologias.setEnabled(!true);
        jBtExames.setEnabled(!true);
        jBtVacinas.setEnabled(!true);
        jBtEncaminhamentoPsi.setEnabled(!true);
        //
        jBtNovaEvolPsiquiatrica.setEnabled(!true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(true);
        jBtCancelarEvolPsiquiatrica.setEnabled(true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jDataEvolucao.setEnabled(!true);
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText("");
        jDataPM.setDate(null);
        jTextoPrescricaoMedica.setText("");
        //
        jBtNovaPrescicao.setEnabled(!true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
    }

    public void ExcluirEvolPsiquiatrica() {
        jIdEvolucaoPsiquiatrica.setText("");
        jNomeCompletoInternoDiagnosticos.setText("");
        jDataEvolPsiquiatrica.setDate(null);
        jTextoEvolucaoPsiquiatrica.setText("");
        jHipotesesDiagnosticoPsi.setText("");
        jExamesSolicitadosPsiq.setText("");
        //
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
        //
        jBtPatologias.setEnabled(!true);
        jBtExames.setEnabled(!true);
        jBtVacinas.setEnabled(!true);
        jBtEncaminhamentoPsi.setEnabled(!true);
        //
        jBtNovaEvolPsiquiatrica.setEnabled(!true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jDataEvolucao.setEnabled(!true);
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText("");
        jDataPM.setDate(null);
        jTextoPrescricaoMedica.setText("");
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
    }

    public void SalvarEvolPsiquiatrica() {
        //
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
        //
        jBtPatologias.setEnabled(true);
        jBtExames.setEnabled(true);
        jBtVacinas.setEnabled(true);
        jBtEncaminhamentoPsi.setEnabled(true);
        //
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //              
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText("");
        jDataPM.setDate(null);
        jTextoPrescricaoMedica.setText("");
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
    }

    public void CancelarEvolPsiquiatrica() {
        jIdEvolucaoPsiquiatrica.setText("");
        jNomeCompletoInternoDiagnosticos.setText("");
        jDataEvolPsiquiatrica.setDate(null);
        jTextoEvolucaoPsiquiatrica.setText("");
        jHipotesesDiagnosticoPsi.setText("");
        jExamesSolicitadosPsiq.setText("");
        //
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
        // PATOLOGIAS PSIQUIATRICAS
        jBtPatologias.setEnabled(true);
        jBtExames.setEnabled(true);
        jBtVacinas.setEnabled(true);
        jBtEncaminhamentoPsi.setEnabled(true);
        //
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jDataEvolucao.setEnabled(!true);
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA       
        jDataPM.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        // PATOLOGIAS MÉDICA
        jBtPatologiasClinica.setEnabled(true);
        jBtExamesClinicos.setEnabled(true);
        jBtVacinasClinicas.setEnabled(true);
        jBtEncaminhamentoClinico.setEnabled(true);
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
    }

    public void NovaEvolucao() {
        jIdEvolucaoMedica.setText("");
        jNomeCompletoInternoEvolucaoMedica.setText(jNomeInternoAdm.getText());
        jDataEvolucao.setCalendar(Calendar.getInstance());
        jTextoEvolucaoMedica.setText("");
        jHipotestesDiagnosticosMedico.setText("");
        jExamesSolcitadosMedicos.setText("");
        //        
        jDataEvolucao.setEnabled(true);
        jTextoEvolucaoMedica.setEnabled(true);
        jHipotestesDiagnosticosMedico.setEnabled(true);
        jExamesSolcitadosMedicos.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        jBtPesquisaEvolucaoMedica.setEnabled(!true);
        //
        jBtPatologiasClinica.setEnabled(!true);
        jBtExamesClinicos.setEnabled(!true);
        jBtVacinasClinicas.setEnabled(!true);
        jBtEncaminhamentoClinico.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // PSIQUIATRIA
        jBtNovaEvolPsiquiatrica.setEnabled(!true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // CAMPOS PSIQUIATRIA
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA       
        jDataPM.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquiridaMedica.setEnabled(true);
        jTextoPrescricaoMedica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(!true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
    }

    public void AlterarEvolucao() {
        //        
        jDataEvolucao.setEnabled(true);
        jTextoEvolucaoMedica.setEnabled(true);
        jComboBoxPatologiaAdquiridaMedica.setEnabled(true);
        jHipotestesDiagnosticosMedico.setEnabled(true);
        jExamesSolcitadosMedicos.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        jBtPesquisaEvolucaoMedica.setEnabled(!true);
        //
        jBtPatologiasClinica.setEnabled(!true);
        jBtExamesClinicos.setEnabled(!true);
        jBtVacinasClinicas.setEnabled(!true);
        jBtEncaminhamentoClinico.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        // Botões de psiquiatria
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jBtNovaEvolPsiquiatrica.setEnabled(!true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // Campos da psiquiatria
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA       
        jDataPM.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(!true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
    }

    public void ExcluirEvolucao() {
        jIdEvolucaoMedica.setText("");
        jNomeCompletoInternoEvolucaoMedica.setText("");
        jDataEvolucao.setDate(null);
        jTextoEvolucaoMedica.setText("");
        jHipotestesDiagnosticosMedico.setText("");
        jExamesSolcitadosMedicos.setText("");
        //        
        jDataEvolucao.setEnabled(!true);
        jComboBoxPatologiaAdquiridaMedica.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        //
        jBtPatologiasClinica.setEnabled(!true);
        jBtExamesClinicos.setEnabled(!true);
        jBtVacinasClinicas.setEnabled(!true);
        jBtEncaminhamentoClinico.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtPesquisaEvolucaoMedica.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Botões de Diagnósticos
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // Campos do diagnóstico
        jDataEvolPsiquiatrica.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA       
        jDataPM.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
    }

    public void SalvarEvolucao() {
        jDataEvolucao.setEnabled(!true);
        jComboBoxPatologiaAdquiridaMedica.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        jBtPesquisaEvolucaoMedica.setEnabled(!true);
        //
        jBtPatologiasClinica.setEnabled(true);
        jBtExamesClinicos.setEnabled(true);
        jBtVacinasClinicas.setEnabled(true);
        jBtEncaminhamentoClinico.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // Botões de Diagnósticos
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // Campos do diagnóstico
        jDataEvolPsiquiatrica.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA       
        jDataPM.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
    }

    public void CancelarEvolucao() {
        jIdEvolucaoMedica.setText("");
        jNomeCompletoInternoEvolucaoMedica.setText("");
        jDataEvolucao.setDate(null);
        jTextoEvolucaoMedica.setText("");
        jHipotestesDiagnosticosMedico.setText("");
        jExamesSolcitadosMedicos.setText("");
        //        
        jDataEvolucao.setEnabled(!true);
        jComboBoxPatologiaAdquiridaMedica.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        // PATOLOGIAS E EXAMES
        jBtPatologiasClinica.setEnabled(true);
        jBtExamesClinicos.setEnabled(true);
        jBtVacinasClinicas.setEnabled(true);
        jBtEncaminhamentoClinico.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        jBtPesquisaEvolucaoMedica.setEnabled(!true);
        // ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        // PSIQUIATRIA
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // EVOLUÇÃO PSIQUIATRICA
        jDataEvolPsiquiatrica.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
        // ADMISSÃO
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA       
        jDataPM.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
    }

    public void NovaPrescricao() {
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText(jNomeInternoAdm.getText());
        jDataPM.setCalendar(Calendar.getInstance());
        jTextoPrescricaoMedica.setText("");
        //        
        jDataPM.setEnabled(true);
        jRBPrescricaoMedica.setEnabled(true);
        jRBPrescricaoPsiquiatrica.setEnabled(true);
        jTextoPrescricaoMedica.setEnabled(true);
        //
        jBtNovaPrescicao.setEnabled(!true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(true);
        jBtCancelarPrescicao.setEnabled(true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(true);
        jRBPrescricaoPsiquiatrica.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(!true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // Campos do diagnóstico
        jHipotesesDiagnosticoPsi.setText("");
        jExamesSolicitadosPsiq.setText("");
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
    }

    public void AlterarPrescricao() {
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(true);
        jRBPrescricaoMedica.setEnabled(true);
        jRBPrescricaoPsiquiatrica.setEnabled(true);
        jTextoPrescricaoMedica.setEnabled(true);
        //
        jBtNovaPrescicao.setEnabled(!true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(true);
        jBtCancelarPrescicao.setEnabled(true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(!true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // Campos do diagnóstico
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
    }

    public void ExcluirPrescricao() {
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText(jNomeInternoAdm.getText());
        jDataPM.setCalendar(Calendar.getInstance());
        jTextoPrescricaoMedica.setText("");
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        //        
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // Campos do diagnóstico
        jDataEvolPsiquiatrica.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
    }

    public void SalvarPrescricao() {
        jDataPM.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        // Campos do diagnóstico
        jDataEvolPsiquiatrica.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
    }

    public void CancelarPrescricao() {
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText("");
        jDataPM.setDate(null);
        jTextoPrescricaoMedica.setText("");
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // Campos do diagnóstico
        jDataEvolPsiquiatrica.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
    }

    public void NovoAtestado() {
        jIdAtestado.setText("");
        jNomeInternoAtestado.setText(jNomeInternoAdm.getText());
        jDataAtestado.setCalendar(Calendar.getInstance());
        jTextoAtestado.setText("");
        //
        jDataAtestado.setEnabled(true);
        jRadioBtModeloA.setEnabled(true);
        jRadioBtModeloB.setEnabled(true);
        jRadioBtModeloC.setEnabled(true);
        jRadioBtModeloAleatorio.setEnabled(true);
        jTextoAtestado.setEnabled(true);
        //
        jBtNovoAtestado.setEnabled(!true);
        jBtAlterarAtestado.setEnabled(!true);
        jBtExcluirAtestado.setEnabled(!true);
        jBtSalvarAtestado.setEnabled(true);
        jBtCancelarAtestado.setEnabled(true);
        jBtAuditoria.setEnabled(!true);
        jBtImprimirAtestado.setEnabled(!true);
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(!true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(!true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // Campos do diagnóstico
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
    }

    public void AlterarAtestado() {
        //
        jDataAtestado.setEnabled(true);
        jRadioBtModeloA.setEnabled(true);
        jRadioBtModeloB.setEnabled(true);
        jRadioBtModeloC.setEnabled(true);
        jRadioBtModeloAleatorio.setEnabled(true);
        jTextoAtestado.setEnabled(true);
        //
        jBtNovoAtestado.setEnabled(!true);
        jBtAlterarAtestado.setEnabled(!true);
        jBtExcluirAtestado.setEnabled(!true);
        jBtSalvarAtestado.setEnabled(true);
        jBtCancelarAtestado.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImprimirAtestado.setEnabled(!true);
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(!true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(!true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // Campos do diagnóstico
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
    }

    public void ExcluirAtestado() {
        jIdAtestado.setText("");
        jNomeInternoAtestado.setText("");
        jDataAtestado.setDate(null);
        jRadioBtModeloA.setSelected(true);
        jTextoAtestado.setText("");
        //
        jDataAtestado.setEnabled(!true);
        jRadioBtModeloA.setEnabled(!true);
        jRadioBtModeloB.setEnabled(!true);
        jRadioBtModeloC.setEnabled(!true);
        jRadioBtModeloAleatorio.setEnabled(!true);
        jTextoAtestado.setEnabled(!true);
        //
        jBtNovoAtestado.setEnabled(true);
        jBtAlterarAtestado.setEnabled(!true);
        jBtExcluirAtestado.setEnabled(!true);
        jBtSalvarAtestado.setEnabled(!true);
        jBtCancelarAtestado.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImprimirAtestado.setEnabled(!true);
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // Campos do diagnóstico
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
    }

    public void SalvarAtestado() {
        jDataAtestado.setEnabled(!true);
        jRadioBtModeloA.setEnabled(!true);
        jRadioBtModeloB.setEnabled(!true);
        jRadioBtModeloC.setEnabled(!true);
        jRadioBtModeloAleatorio.setEnabled(!true);
        jTextoAtestado.setEnabled(!true);
        //
        jBtNovoAtestado.setEnabled(true);
        jBtAlterarAtestado.setEnabled(!true);
        jBtExcluirAtestado.setEnabled(!true);
        jBtSalvarAtestado.setEnabled(!true);
        jBtCancelarAtestado.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImprimirAtestado.setEnabled(!true);
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // CAMPOS DE EVOLUÇÃO PSIQUIATRICA
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText("");
        jDataPM.setDate(null);
        jTextoPrescricaoMedica.setText("");
    }

    public void CancelarAtestado() {
        jIdAtestado.setText("");
        jNomeInternoAtestado.setText("");
        jDataAtestado.setDate(null);
        jTextoAtestado.setText("");
        //
        jDataAtestado.setEnabled(!true);
        jRadioBtModeloA.setEnabled(!true);
        jRadioBtModeloB.setEnabled(!true);
        jRadioBtModeloC.setEnabled(!true);
        jRadioBtModeloAleatorio.setEnabled(!true);
        jTextoAtestado.setEnabled(!true);
        //
        jBtNovoAtestado.setEnabled(true);
        jBtAlterarAtestado.setEnabled(!true);
        jBtExcluirAtestado.setEnabled(!true);
        jBtSalvarAtestado.setEnabled(!true);
        jBtCancelarAtestado.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImprimirAtestado.setEnabled(!true);
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // CAMPOS DE EVOLUÇÃO PSIQUIATRICA
        jDataEvolPsiquiatrica.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText("");
        jDataPM.setDate(null);
        jTextoPrescricaoMedica.setText("");
        //
        jBtNovaPrescicao.setEnabled(!true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
    }

    public void NovaDieta() {
        // TELA DIETA
        jIdDieta.setText("");
        jNomeInternoDieta.setText(jNomeInternoAdm.getText());
        jDataDieta.setCalendar(Calendar.getInstance());
        jTextoDieta.setText("");
        //
        jDataDieta.setEnabled(true);
        jTextoDieta.setEnabled(true);
        //
        jBtNovaDieta.setEnabled(!true);
        jBtAlterarDieta.setEnabled(!true);
        jBtExcluirDieta.setEnabled(!true);
        jBtSalvarDieta.setEnabled(true);
        jBtCancelarDieta.setEnabled(true);
        jBtAuditoriaDieta.setEnabled(!true);
        jBtImprimirDieta.setEnabled(!true);
        // TELA ATESTADO
        jDataAtestado.setEnabled(!true);
        jRadioBtModeloA.setEnabled(!true);
        jRadioBtModeloB.setEnabled(!true);
        jRadioBtModeloC.setEnabled(!true);
        jRadioBtModeloAleatorio.setEnabled(!true);
        jTextoAtestado.setEnabled(!true);
        //
        jBtNovoAtestado.setEnabled(!true);
        jBtAlterarAtestado.setEnabled(!true);
        jBtExcluirAtestado.setEnabled(!true);
        jBtSalvarAtestado.setEnabled(!true);
        jBtCancelarAtestado.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImprimirAtestado.setEnabled(!true);
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(!true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        // TELA ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(!true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // CAMPOS DE EVOLUÇÃO PSIQUIATRICA
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText("");
        jDataPM.setDate(null);
        jTextoPrescricaoMedica.setText("");
        //
        jBtNovaPrescicao.setEnabled(!true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
    }

    public void AlterarDieta() {
        jDataDieta.setEnabled(true);
        jTextoDieta.setEnabled(true);
        //
        jBtNovaDieta.setEnabled(!true);
        jBtAlterarDieta.setEnabled(!true);
        jBtExcluirDieta.setEnabled(!true);
        jBtSalvarDieta.setEnabled(true);
        jBtCancelarDieta.setEnabled(true);
        jBtAuditoriaDieta.setEnabled(!true);
        jBtImprimirDieta.setEnabled(!true);
        // TELA ATESTADO
        jDataAtestado.setEnabled(!true);
        jRadioBtModeloA.setEnabled(!true);
        jRadioBtModeloB.setEnabled(!true);
        jRadioBtModeloC.setEnabled(!true);
        jRadioBtModeloAleatorio.setEnabled(!true);
        jTextoAtestado.setEnabled(!true);
        //
        jBtNovoAtestado.setEnabled(!true);
        jBtAlterarAtestado.setEnabled(!true);
        jBtExcluirAtestado.setEnabled(!true);
        jBtSalvarAtestado.setEnabled(!true);
        jBtCancelarAtestado.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImprimirAtestado.setEnabled(!true);
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(!true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        // TELA ADMISSÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(!true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // CAMPOS DE EVOLUÇÃO PSIQUIATRICA
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText("");
        jDataPM.setDate(null);
        jTextoPrescricaoMedica.setText("");
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
    }

    public void ExcluirDieta() {
        // TELA DIETA
        jIdDieta.setText("");
        jNomeInternoDieta.setText("");
        jDataDieta.setDate(null);
        jTextoDieta.setText("");
        //
        jDataDieta.setEnabled(!true);
        jTextoDieta.setEnabled(!true);
        //
        jBtNovaDieta.setEnabled(true);
        jBtAlterarDieta.setEnabled(!true);
        jBtExcluirDieta.setEnabled(!true);
        jBtSalvarDieta.setEnabled(!true);
        jBtCancelarDieta.setEnabled(!true);
        jBtAuditoriaDieta.setEnabled(!true);
        jBtImprimirDieta.setEnabled(!true);
        // TELA ATESTADO
        jDataAtestado.setEnabled(!true);
        jRadioBtModeloA.setEnabled(!true);
        jRadioBtModeloB.setEnabled(!true);
        jRadioBtModeloC.setEnabled(!true);
        jRadioBtModeloAleatorio.setEnabled(!true);
        jTextoAtestado.setEnabled(!true);
        //
        jBtNovoAtestado.setEnabled(true);
        jBtAlterarAtestado.setEnabled(!true);
        jBtExcluirAtestado.setEnabled(!true);
        jBtSalvarAtestado.setEnabled(!true);
        jBtCancelarAtestado.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImprimirAtestado.setEnabled(!true);
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        // TELA ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // CAMPOS DE EVOLUÇÃO PSIQUIATRICA
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText("");
        jDataPM.setDate(null);
        jTextoPrescricaoMedica.setText("");
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
    }

    public void SalvarDieta() {
        jDataDieta.setEnabled(!true);
        jTextoDieta.setEnabled(!true);
        //
        jBtNovaDieta.setEnabled(true);
        jBtAlterarDieta.setEnabled(!true);
        jBtExcluirDieta.setEnabled(!true);
        jBtSalvarDieta.setEnabled(!true);
        jBtCancelarDieta.setEnabled(true);
        jBtAuditoriaDieta.setEnabled(!true);
        jBtImprimirDieta.setEnabled(!true);
        // TELA ATESTADO
        jDataAtestado.setEnabled(!true);
        jRadioBtModeloA.setEnabled(!true);
        jRadioBtModeloB.setEnabled(!true);
        jRadioBtModeloC.setEnabled(!true);
        jRadioBtModeloAleatorio.setEnabled(!true);
        jTextoAtestado.setEnabled(!true);
        //
        jBtNovoAtestado.setEnabled(true);
        jBtAlterarAtestado.setEnabled(!true);
        jBtExcluirAtestado.setEnabled(!true);
        jBtSalvarAtestado.setEnabled(!true);
        jBtCancelarAtestado.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImprimirAtestado.setEnabled(!true);
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        // PRESCRIÇÃO MÉDICA
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText("");
        jDataPM.setDate(null);
        jTextoPrescricaoMedica.setText("");
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        // TELA ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // CAMPOS DE EVOLUÇÃO PSIQUIATRICA
        jDataEvolPsiquiatrica.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
    }

    public void CancelarDieta() {
        // TELA DIETA
        jIdDieta.setText("");
        jNomeInternoDieta.setText("");
        jDataDieta.setDate(null);
        jTextoDieta.setText("");
        //
        jDataDieta.setEnabled(!true);
        jTextoDieta.setEnabled(!true);
        //
        jBtNovaDieta.setEnabled(true);
        jBtAlterarDieta.setEnabled(!true);
        jBtExcluirDieta.setEnabled(!true);
        jBtSalvarDieta.setEnabled(!true);
        jBtCancelarDieta.setEnabled(true);
        jBtAuditoriaDieta.setEnabled(!true);
        jBtImprimirDieta.setEnabled(!true);
        // TELA ATESTADO
        jDataAtestado.setEnabled(!true);
        jRadioBtModeloA.setEnabled(!true);
        jRadioBtModeloB.setEnabled(!true);
        jRadioBtModeloC.setEnabled(!true);
        jRadioBtModeloAleatorio.setEnabled(!true);
        jTextoAtestado.setEnabled(!true);
        //
        jBtNovoAtestado.setEnabled(true);
        jBtAlterarAtestado.setEnabled(!true);
        jBtExcluirAtestado.setEnabled(!true);
        jBtSalvarAtestado.setEnabled(!true);
        jBtCancelarAtestado.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
        jBtImprimirAtestado.setEnabled(!true);
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        // TELA ADMISSÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //
        jDataAdm.setEnabled(!true);
        jBtPesqInternoAdm.setEnabled(!true);
        jAR.setEnabled(!true);
        jACV.setEnabled(!true);
        jAGU.setEnabled(!true);
        jCABPESC.setEnabled(!true);
        jEXT.setEnabled(!true);
        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jCirurgiasPrevisas.setEnabled(!true);
        jTratamentoCurso.setEnabled(!true);
        jQualDrogas.setEnabled(!true);
        jQualEtilismo.setEnabled(!true);
        jQuantoTempoTabagismo.setEnabled(!true);
        jComboBoxDrogas.setEnabled(!true);
        jComboBoxEtilismo.setEnabled(!true);
        jComboBoxTabagismo.setEnabled(!true);
        jComboBoxVacinas.setEnabled(!true);
        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        jHipotestesDiagnosticosMedico.setEnabled(!true);
        jExamesSolcitadosMedicos.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // CAMPOS DE EVOLUÇÃO PSIQUIATRICA
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
        jHipotesesDiagnosticoPsi.setEnabled(!true);
        jExamesSolicitadosPsiq.setEnabled(!true);
    }

    public void buscarCodDieta() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DIETA_MEDICA_PSIQUIATRICA");
            conecta.rs.last();
            jIdDieta.setText(conecta.rs.getString("IdItem"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código da Dieta.");
        }
        conecta.desconecta();
    }

    public void pesquisarPrescricao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA "
                    + "WHERE IdLanc='" + jIdAdm.getText() + "'AND IdInternoCrc='" + jIdInternoAdm.getText() + "'");
            conecta.rs.first();
            tipoPrescricao = conecta.rs.getInt("TipoP");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherAdmissaoMedica(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome Completo do Interno", "Situação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataLanc");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataEntrada, conecta.rs.getString("StatusLanc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("SituacaoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaMedico.setModel(modelo);
        jTabelaMedico.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaMedico.getColumnModel().getColumn(0).setResizable(false);
        jTabelaMedico.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaMedico.getColumnModel().getColumn(1).setResizable(false);
        jTabelaMedico.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaMedico.getColumnModel().getColumn(2).setResizable(false);
        jTabelaMedico.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTabelaMedico.getColumnModel().getColumn(3).setResizable(false);
        jTabelaMedico.getColumnModel().getColumn(4).setPreferredWidth(330);
        jTabelaMedico.getColumnModel().getColumn(4).setResizable(false);
        jTabelaMedico.getTableHeader().setReorderingAllowed(false);
        jTabelaMedico.setAutoResizeMode(jTabelaMedico.AUTO_RESIZE_OFF);
        jTabelaMedico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaAdmissao();
        conecta.desconecta();
    }

    public void preencherTabelaEvolucaoPsiquiatrica(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "PA", "Anotação/Evolução Psiquiatrica"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            countp = 0;
            do {
                idItemEvolPsiquiatrico = conecta.rs.getInt("IdItem");
                countp = countp + 1;
                dataEvolPsiquiatrica = conecta.rs.getString("DataEvol");
                String diag = dataEvolPsiquiatrica.substring(8, 10);
                String mesg = dataEvolPsiquiatrica.substring(5, 7);
                String anog = dataEvolPsiquiatrica.substring(0, 4);
                dataEvolPsiquiatrica = diag + "/" + mesg + "/" + anog;
                jTotalRegistrosPsi.setText(Integer.toString(countp)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), dataEvolPsiquiatrica, conecta.rs.getString("Patologia"), conecta.rs.getString("EvolucaoPsiquiatrica")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolPsiquiatrica.setModel(modelo);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(2).setPreferredWidth(40);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(3).setPreferredWidth(400);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEvolPsiquiatrica.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolPsiquiatrica.setAutoResizeMode(jTabelaEvolPsiquiatrica.AUTO_RESIZE_OFF);
        jTabelaEvolPsiquiatrica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaEvolucaoPsiquiatrica();
        conecta.desconecta();
    }

    public void preencherTabelaEvolucaoMedica(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "PA", "Anotação/Evolução Médica"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            countm = 0;
            do {
                idItemEvol = conecta.rs.getInt("IdItem");
                countm = countm + 1;
                dataEvolu = conecta.rs.getString("DataEvolu");
                String diav = dataEvolu.substring(8, 10);
                String mesv = dataEvolu.substring(5, 7);
                String anov = dataEvolu.substring(0, 4);
                dataEvolu = diav + "/" + mesv + "/" + anov;
                jTotalRegistrosMed.setText(Integer.toString(countm)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), dataEvolu, conecta.rs.getString("Patologia"), conecta.rs.getString("TextoEvolucao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoMedica.setModel(modelo);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(3).setPreferredWidth(400);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEvolucaoMedica.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoMedica.setAutoResizeMode(jTabelaEvolucaoMedica.AUTO_RESIZE_OFF);
        jTabelaEvolucaoMedica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaEvolucaoMedica();
        conecta.desconecta();
    }

    public void preencherTabelaPrescricaoMedica(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Prescrição Médica/Psquiatrica"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dataPrescricao = conecta.rs.getString("DataPres");
                String diap = dataPrescricao.substring(8, 10);
                String mesp = dataPrescricao.substring(5, 7);
                String anop = dataPrescricao.substring(0, 4);
                dataPrescricao = diap + "/" + mesp + "/" + anop;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), dataPrescricao, conecta.rs.getString("TextoPrescricao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPrescricaoMedica.setModel(modelo);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(2).setPreferredWidth(400);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPrescricaoMedica.getTableHeader().setReorderingAllowed(false);
        jTabelaPrescricaoMedica.setAutoResizeMode(jTabelaPrescricaoMedica.AUTO_RESIZE_OFF);
        jTabelaPrescricaoMedica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaPrescricaoMedica();
        conecta.desconecta();
    }

    public void preencherTabelaAtestadoMedica(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Modelo"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dataAtestado = conecta.rs.getString("DataAtesta");
                String diaat = dataAtestado.substring(8, 10);
                String mesat = dataAtestado.substring(5, 7);
                String anoat = dataAtestado.substring(0, 4);
                dataAtestado = diaat + "/" + mesat + "/" + anoat;
                tipoModelo = conecta.rs.getInt("ModeloAtestado");
                if (tipoModelo == 0) {
                    descricaoModelo = "Modelo A";
                } else if (tipoModelo == 1) {
                    descricaoModelo = "Modelo B";
                } else if (tipoModelo == 2) {
                    descricaoModelo = "Modelo C";
                } else if (tipoModelo == 3) {
                    descricaoModelo = "Modelo Aleatório";
                }
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), dataAtestado, descricaoModelo});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtestado.setModel(modelo);
        jTabelaAtestado.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAtestado.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtestado.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaAtestado.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtestado.getColumnModel().getColumn(2).setPreferredWidth(220);
        jTabelaAtestado.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtestado.getTableHeader().setReorderingAllowed(false);
        jTabelaAtestado.setAutoResizeMode(jTabelaAtestado.AUTO_RESIZE_OFF);
        jTabelaAtestado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaAtestadoMedico();
        conecta.desconecta();
    }

    public void preencherTabelaDietaMedica(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Descrição da Dieta Médica"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dataAtestado = conecta.rs.getString("DataDieta");
                String diaat = dataAtestado.substring(8, 10);
                String mesat = dataAtestado.substring(5, 7);
                String anoat = dataAtestado.substring(0, 4);
                dataAtestado = diaat + "/" + mesat + "/" + anoat;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), dataAtestado, conecta.rs.getString("TextoDieta")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTablaDieta.setModel(modelo);
        jTablaDieta.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTablaDieta.getColumnModel().getColumn(0).setResizable(false);
        jTablaDieta.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTablaDieta.getColumnModel().getColumn(1).setResizable(false);
        jTablaDieta.getColumnModel().getColumn(2).setPreferredWidth(400);
        jTablaDieta.getColumnModel().getColumn(2).setResizable(false);
        jTablaDieta.getTableHeader().setReorderingAllowed(false);
        jTablaDieta.setAutoResizeMode(jTablaDieta.AUTO_RESIZE_OFF);
        jTablaDieta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaDietaMedica();
        conecta.desconecta();
    }

    public void limparTabelaAdmissao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome Completo do Interno", "Situação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaMedico.setModel(modelo);
        jTabelaMedico.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaMedico.getColumnModel().getColumn(0).setResizable(false);
        jTabelaMedico.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaMedico.getColumnModel().getColumn(1).setResizable(false);
        jTabelaMedico.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaMedico.getColumnModel().getColumn(2).setResizable(false);
        jTabelaMedico.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTabelaMedico.getColumnModel().getColumn(3).setResizable(false);
        jTabelaMedico.getColumnModel().getColumn(4).setPreferredWidth(330);
        jTabelaMedico.getColumnModel().getColumn(4).setResizable(false);
        jTabelaMedico.getTableHeader().setReorderingAllowed(false);
        jTabelaMedico.setAutoResizeMode(jTabelaMedico.AUTO_RESIZE_OFF);
        jTabelaMedico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaAdmissao() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaMedico.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaMedico.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaMedico.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limpaTabelaDoencas() {

        while (jTabelaPatologia.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaPatologia.getModel()).removeRow(0);
        }
    }

    public void limparTabelaEvolucaoMedica() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "PA", "Anotação/Evolução Médica"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoMedica.setModel(modelo);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(3).setPreferredWidth(400);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEvolucaoMedica.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoMedica.setAutoResizeMode(jTabelaEvolucaoMedica.AUTO_RESIZE_OFF);
        jTabelaEvolucaoMedica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaEvolucaoMedica() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEvolucaoMedica.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaEvolucaoMedica.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaEvolucaoPsiquiatrica() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "PA", "Anotação/Evolução Psiquiatrica"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(2).setPreferredWidth(40);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(3).setPreferredWidth(400);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaEvolPsiquiatrica.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolPsiquiatrica.setAutoResizeMode(jTabelaEvolPsiquiatrica.AUTO_RESIZE_OFF);
        jTabelaEvolPsiquiatrica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaEvolucaoPsiquiatrica() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaEvolPsiquiatrica.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaPrescricaoMedica() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Prescrição Médica/Psquiatrica"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPrescricaoMedica.setModel(modelo);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(2).setPreferredWidth(400);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPrescricaoMedica.getTableHeader().setReorderingAllowed(false);
        jTabelaPrescricaoMedica.setAutoResizeMode(jTabelaPrescricaoMedica.AUTO_RESIZE_OFF);
        jTabelaPrescricaoMedica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaPrescricaoMedica() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaPrescricaoMedica.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void limparTabelaAtestadoMedica() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Modelo"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtestado.setModel(modelo);
        jTabelaAtestado.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAtestado.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtestado.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaAtestado.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtestado.getColumnModel().getColumn(2).setPreferredWidth(220);
        jTabelaAtestado.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtestado.getTableHeader().setReorderingAllowed(false);
        jTabelaAtestado.setAutoResizeMode(jTabelaAtestado.AUTO_RESIZE_OFF);
        jTabelaAtestado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaAtestadoMedico() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaAtestado.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAtestado.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void limparTabelaDietaMedica() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Descrição da Dieta Médica"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTablaDieta.setModel(modelo);
        jTablaDieta.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTablaDieta.getColumnModel().getColumn(0).setResizable(false);
        jTablaDieta.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTablaDieta.getColumnModel().getColumn(1).setResizable(false);
        jTablaDieta.getColumnModel().getColumn(2).setPreferredWidth(400);
        jTablaDieta.getColumnModel().getColumn(2).setResizable(false);
        jTablaDieta.getTableHeader().setReorderingAllowed(false);
        jTablaDieta.setAutoResizeMode(jTablaDieta.AUTO_RESIZE_OFF);
        jTablaDieta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaDietaMedica() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTablaDieta.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTablaDieta.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAdm.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAdm.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAdm.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog4() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela4);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAdm.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog5() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela5);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAdm.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog6() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela6);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAdm.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void incluirItensDoencas() {
        // Grava os dados do arrayList na tabela
        for (int i = 0; i < jTabelaPatologia.getRowCount(); i++) {
            objItensDoenca.setIdLanc(Integer.valueOf(jIdAdm.getText()));
            objItensDoenca.setDataLanc(jDataAdm.getDate());
            objItensDoenca.setIdDoenca((int) jTabelaPatologia.getValueAt(i, 0));
            objItensDoenca.setDescricaoDoenca((String) jTabelaPatologia.getValueAt(i, 1));
            objItensDoenca.getDescricaoDoenca();
            controlePat.incluirDoencas(objItensDoenca);
        }
    }

    public void alterarItensDoencas() {
        // Grava os dados do arrayList na tabela
        for (int i = 0; i < jTabelaPatologia.getRowCount(); i++) {
            verificarDoencas();
            if (jIdAdm.getText().equals(codAdm) && jTabelaPatologia.getValueAt(i, 0) != codDoenca) {
                objAdmMedico.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                objAdmMedico.setNomeInterno(jNomeInternoAdm.getText());
                objAdmMedico.setDeptoMedico(deptoTecnico);
                incluirItensDoencas();

            } else {
                objItensDoenca.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                objItensDoenca.setDataLanc(jDataAdm.getDate());
                objItensDoenca.setIdDoenca((int) jTabelaPatologia.getValueAt(i, 0));
                objItensDoenca.setDescricaoDoenca((String) jTabelaPatologia.getValueAt(i, 1));
                objItensDoenca.getDescricaoDoenca();
                controlePat.alterarDoencas(objItensDoenca);
            }
        }
    }

    public void verificarEvolucaoPsiquiatrica() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAO_PSIQUIATRICA "
                    + "WHERE IdLanc='" + jIdAdm.getText() + "'");
            conecta.rs.first();
            codPsiquiatrico = conecta.rs.getString("IdLanc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarEvolucaoMedica() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAOMEDICA "
                    + "WHERE IdLanc='" + jIdAdm.getText() + "'");
            conecta.rs.first();
            codMedico = conecta.rs.getString("IdLanc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarPrescricaoMedica() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA "
                    + "WHERE IdLanc='" + jIdAdm.getText() + "'");
            conecta.rs.first();
            codPrescricao = conecta.rs.getString("IdLanc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarAtestadoMedico() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ATESTADO_MEDICO_PSIQUIATRICO "
                    + "WHERE IdLanc='" + jIdAdm.getText() + "'");
            conecta.rs.first();
            codAtestado = conecta.rs.getString("IdLanc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarDietaMedica() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DIETA_MEDICA_PSIQUIATRICA "
                    + "WHERE IdLanc='" + jIdAdm.getText() + "'");
            conecta.rs.first();
            codDieta = conecta.rs.getString("IdLanc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarDoencas() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSADMISSAODOENCAS "
                    + "WHERE IdLanc='" + jIdAdm.getText() + "'");
            conecta.rs.first();
            codAdm = conecta.rs.getString("IdLanc");
            codDoenca = conecta.rs.getString("IdDoenca");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarInterno() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADMISSAOMEDICA "
                    + "WHERE IdInternoCrc='" + jIdInternoAdm.getText() + "'");
            conecta.rs.first();
            codInternoCrc = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodEvolPsiquiatrica() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAO_PSIQUIATRICA");
            conecta.rs.last();
            jIdEvolucaoPsiquiatrica.setText(conecta.rs.getString("IdItem"));
            idItemEvolPsiquiatrico = conecta.rs.getInt("IdItem");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarEvolucao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAOMEDICA");
            conecta.rs.last();
            jIdEvolucaoMedica.setText(conecta.rs.getString("IdItem"));
            idItemEvol = conecta.rs.getInt("IdItem");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarprescricaoMedica() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA");
            conecta.rs.last();
            jIdPrescricaoMedica.setText(conecta.rs.getString("IdItem"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarAtestado() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ATESTADO_MEDICO_PSIQUIATRICO");
            conecta.rs.last();
            jIdAtestado.setText(conecta.rs.getString("IdItem"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarAcessoUsuarioPsiquiatra() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserENF = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserENF + "'");
            conecta.rs.first();
            codigoUserGroupENF = conecta.rs.getInt("IdUsuario");
            codigoGrupoENF = conecta.rs.getInt("IdGrupo");
            nomeGrupoENF = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserENF + "' "
                    + "AND NomeTela='" + nomeModuloTela2 + "'");
            conecta.rs.first();
            codUserAcessoENF = conecta.rs.getInt("IdUsuario");
            codAbrirENF = conecta.rs.getInt("Abrir");
            codIncluirENF = conecta.rs.getInt("Incluir");
            codAlterarENF = conecta.rs.getInt("Alterar");
            codExcluirENF = conecta.rs.getInt("Excluir");
            codGravarENF = conecta.rs.getInt("Gravar");
            codConsultarENF = conecta.rs.getInt("Consultar");
            nomeTelaENF = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarAcessoUsuarioMedicoClinico() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserENF = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserENF + "'");
            conecta.rs.first();
            codigoUserGroupENF = conecta.rs.getInt("IdUsuario");
            codigoGrupoENF = conecta.rs.getInt("IdGrupo");
            nomeGrupoENF = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserENF + "' "
                    + "AND NomeTela='" + nomeModuloTela3 + "'");
            conecta.rs.first();
            codUserAcessoENF = conecta.rs.getInt("IdUsuario");
            codAbrirENF = conecta.rs.getInt("Abrir");
            codIncluirENF = conecta.rs.getInt("Incluir");
            codAlterarENF = conecta.rs.getInt("Alterar");
            codExcluirENF = conecta.rs.getInt("Excluir");
            codGravarENF = conecta.rs.getInt("Gravar");
            codConsultarENF = conecta.rs.getInt("Consultar");
            nomeTelaENF = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarAcessoUsuarioPrescricao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserENF = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserENF + "'");
            conecta.rs.first();
            codigoUserGroupENF = conecta.rs.getInt("IdUsuario");
            codigoGrupoENF = conecta.rs.getInt("IdGrupo");
            nomeGrupoENF = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        //TELA DE PRESCRIÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserENF + "' "
                    + "AND NomeTela='" + nomeModuloTela4 + "'");
            conecta.rs.first();
            codUserAcessoENF = conecta.rs.getInt("IdUsuario");
            codAbrirENF = conecta.rs.getInt("Abrir");
            codIncluirENF = conecta.rs.getInt("Incluir");
            codAlterarENF = conecta.rs.getInt("Alterar");
            codExcluirENF = conecta.rs.getInt("Excluir");
            codGravarENF = conecta.rs.getInt("Gravar");
            codConsultarENF = conecta.rs.getInt("Consultar");
            nomeTelaENF = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarAcessoUsuarioAtestado() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserENF = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserENF + "'");
            conecta.rs.first();
            codigoUserGroupENF = conecta.rs.getInt("IdUsuario");
            codigoGrupoENF = conecta.rs.getInt("IdGrupo");
            nomeGrupoENF = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        //TELA DE PRESCRIÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserENF + "' "
                    + "AND NomeTela='" + nomeModuloTela5 + "'");
            conecta.rs.first();
            codUserAcessoENF = conecta.rs.getInt("IdUsuario");
            codAbrirENF = conecta.rs.getInt("Abrir");
            codIncluirENF = conecta.rs.getInt("Incluir");
            codAlterarENF = conecta.rs.getInt("Alterar");
            codExcluirENF = conecta.rs.getInt("Excluir");
            codGravarENF = conecta.rs.getInt("Gravar");
            codConsultarENF = conecta.rs.getInt("Consultar");
            nomeTelaENF = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarAcessoUsuarioDieta() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserENF = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserENF + "'");
            conecta.rs.first();
            codigoUserGroupENF = conecta.rs.getInt("IdUsuario");
            codigoGrupoENF = conecta.rs.getInt("IdGrupo");
            nomeGrupoENF = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        //TELA DE PRESCRIÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserENF + "' "
                    + "AND NomeTela='" + nomeModuloTela6 + "'");
            conecta.rs.first();
            codUserAcessoENF = conecta.rs.getInt("IdUsuario");
            codAbrirENF = conecta.rs.getInt("Abrir");
            codIncluirENF = conecta.rs.getInt("Incluir");
            codAlterarENF = conecta.rs.getInt("Alterar");
            codExcluirENF = conecta.rs.getInt("Excluir");
            codGravarENF = conecta.rs.getInt("Gravar");
            codConsultarENF = conecta.rs.getInt("Consultar");
            nomeTelaENF = conecta.rs.getString("NomeTela");
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
            codigoUserENF = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserENF + "'");
            conecta.rs.first();
            codigoUserGroupENF = conecta.rs.getInt("IdUsuario");
            codigoGrupoENF = conecta.rs.getInt("IdGrupo");
            nomeGrupoENF = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserENF + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoENF = conecta.rs.getInt("IdUsuario");
            codAbrirENF = conecta.rs.getInt("Abrir");
            codIncluirENF = conecta.rs.getInt("Incluir");
            codAlterarENF = conecta.rs.getInt("Alterar");
            codExcluirENF = conecta.rs.getInt("Excluir");
            codGravarENF = conecta.rs.getInt("Gravar");
            codConsultarENF = conecta.rs.getInt("Consultar");
            nomeTelaENF = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarInternoRegistradoAdm() {
        conecta.abrirConexao();
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        dataReg = formatoAmerica.format(jDataAdm.getDate().getTime());
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "WHERE IdInternoCrc='" + jIdInternoAdm.getText() + "' "
                    + "AND Atendido='" + opcao + "'");
            conecta.rs.first();
            codigoInternoAtend = conecta.rs.getString("IdInternoCrc");
            codigoDepartamentoENF = conecta.rs.getInt("IdDepartamento");
            atendido = conecta.rs.getString("Atendido");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarRegistroBiometria() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            pHabilitaMedico = conecta.rs.getString("BiometriaMedicos");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    // VERIFICAR SE A EVOLUÇÃO FAZ PARTE DA ADMISSÃO, OU SEJA, QUANDO É FEITA A ADMISSÃO DO INTERNO
    // É GRAVADO AUTOMÁTICAMETE UMA EVOLUÇÃO PARA O INTERNO.
    public void verificarEvolucaoAdmissao() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAOMEDICA "
                    + "WHERE IdLanc='" + jIdAdm.getText() + "' "
                    + "AND IdItem='" + jIdEvolucaoMedica.getText() + "'");
            conecta.rs.first();
            admEvolucao = conecta.rs.getString("AdmEvo");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
