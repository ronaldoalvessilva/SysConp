/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleEapiCrcPaiPsicoSocial;
import gestor.Controle.ControleEvolucaoPAI;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControlePAI;
import gestor.Controle.ControlePsicologiaMedicoPaiPsicoSocial;
import gestor.Controle.ControlePsicologiaPaiPsicoSocial;
import gestor.Controle.ControleSS3;
import gestor.Controle.ControleSocial1Psicosocial;
import gestor.Controle.ControleSocial2PsicoSocial;
import gestor.Controle.ControleSocial2VisitaIntimaPsicosocial;
import gestor.Controle.ControleSocial2VisitaPsicosocial;
import gestor.Controle.ControleTerapiaPedagogiaPsicoSocialPAI;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.LimiteDigitosNum;
import Utilitarios.LimiteDigitosSoNum;
import Utilitarios.ModeloTabela;
import gestor.Modelo.EapiCrcPaiPsicoSocial;
import gestor.Modelo.EvolucaoPAI;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PaiPsicoSocial;
import gestor.Modelo.PsicologiaMedicoPaiPsicosocial;
import gestor.Modelo.PsicologiaPaiPsicoSocial;
import gestor.Modelo.SS3PaiPsicoSocial;
import gestor.Modelo.Social1PaiPsicosocial;
import gestor.Modelo.Social2FamiliarPsicosocial;
import gestor.Modelo.Social2PaiPsicoSocial;
import gestor.Modelo.TerapiaPedagogiaPsicosocial;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ronaldo
 */
public class TelaPaiPsicologia extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PaiPsicoSocial objPaiPsico = new PaiPsicoSocial();
    ControlePAI control = new ControlePAI();
    //
    Social1PaiPsicosocial objSocial1Pai = new Social1PaiPsicosocial();
    ControleSocial1Psicosocial controle = new ControleSocial1Psicosocial();
    //
    Social2PaiPsicoSocial objSocial2Pai = new Social2PaiPsicoSocial();
    ControleSocial2PsicoSocial controle2 = new ControleSocial2PsicoSocial();
    //
    Social2FamiliarPsicosocial objSocial2Vista = new Social2FamiliarPsicosocial();
    ControleSocial2VisitaPsicosocial controlVisita = new ControleSocial2VisitaPsicosocial();
    //
    ControleSocial2VisitaIntimaPsicosocial controlVisitaIntima = new ControleSocial2VisitaIntimaPsicosocial();
    //
    TerapiaPedagogiaPsicosocial objTeraPed = new TerapiaPedagogiaPsicosocial();
    ControleTerapiaPedagogiaPsicoSocialPAI controlTeraPed = new ControleTerapiaPedagogiaPsicoSocialPAI();
    //
    PsicologiaPaiPsicoSocial objPsicoPaiSocial = new PsicologiaPaiPsicoSocial();
    ControlePsicologiaPaiPsicoSocial controlPSI = new ControlePsicologiaPaiPsicoSocial();
    //
    PsicologiaMedicoPaiPsicosocial objPsiMed = new PsicologiaMedicoPaiPsicosocial();
    ControlePsicologiaMedicoPaiPsicoSocial controlPsiMed = new ControlePsicologiaMedicoPaiPsicoSocial();
    //
    EapiCrcPaiPsicoSocial objEapi = new EapiCrcPaiPsicoSocial();
    ControleEapiCrcPaiPsicoSocial controlEapi = new ControleEapiCrcPaiPsicoSocial();
    //
    SS3PaiPsicoSocial objSS3 = new SS3PaiPsicoSocial();
    ControleSS3 controlSS3 = new ControleSS3();
    //
    EvolucaoPAI objEvolucaoPAI = new EvolucaoPAI();
    ControleEvolucaoPAI controlePAI = new ControleEvolucaoPAI();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Psicologia:P.A.I.:Manutenção";
    String nomeModuloTela1 = "Psicologia:P.A.I.:S.S.1";
    String nomeModuloTela2 = "Psicologia:P.A.I.:S.S.2 - Familiar";
    String nomeModuloTela3 = "Psicologia:P.A.I.:S.S.2 - Visitas";
    String nomeModuloTela4 = "Psicologia:P.A.I.:S.S.2 - Visitas Intimas";
    String nomeModuloTela5 = "Psicologia:P.A.I.:TO/Ped.";
    String nomeModuloTela6 = "Psicologia:P.A.I.:PSI.";
    String nomeModuloTela7 = "Psicologia:P.A.I.:P.M.";
    String nomeModuloTela8 = "Psicologia:P.A.I.:EAPI";
    String nomeModuloTela9 = "Psicologia:P.A.I.:SS3";
    String nomeModuloTela10 = "Psicologia:P.A.I.:E-PAI";
    //
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int acao;
    int flag;
    int count = 0;
    String dataInicial;
    String dataFinal, dataPAI;
    String caminho;
    int cumpimentoFamiliaPena;
    // S.S.1
    int codigoSS1; // CÓDIGO SS1 PARA PODER ALTERAR O REGISTRO JA INCLUÍDO.
    String codigoPaiSS1; // CÓDIGO PARA VERIFICAR SE JÁ FOI INCLUÍDO O REGISTRO SS1, NÃO PERMITIR CADASTRAR MAIS DE UM
    String codigoInternoSS1; // CÓDIGO DO INTERNO PARA VERIFICAR SE JÁ FOI INCLUÍDO NO SS1
    String codigoInternoPAI; // VERIFICAR SE O INTERNO JÁ FOI INCLUÍDO NO PAI. SÓ É PERMITIDO UM P.A.I. POR INTERNO.
    String nomeMaeInterno; // NOME DA MÃE DO INTERNO PARA NEGAR DUPLICIDADE DE INTERNO NO P.A.I
    //
    int idSol2Visita, idSol2VisitaIntima;
    int codInstrucao;
    // TOPED
    int codTeraPed;
    String codigoPaiTOPED;
    String codigoInternoTOPED;
    // PSI
    int codigoPSI; // CÓDIGO PARA VERIFICAR SE JÁ FOI INCLUÍDO O REGISTRO PSI, NÃO PERMITIR CADASTRAR MAIS DE UM
    String codigoPaiPSI;
    String codigoInternoPSI;
    // PM
    int codigoPM;
    String codigoPaiPM;
    String codigoInternoPM;
    //
    int consultaPSI;
    int acompanhaPSI;
    int hipertensao;
    int diabetes;
    int tuberculose;
    int dst;
    int hepatite;
    int hanseniase;
    int outrasDoencas;
    // EAPI/CRC
    int codigoEAPI;
    String codigoPaiEAPI;
    String codigoInternoEAPI;
    // SS3
    int codigoSS3;
    String codigoPaiSS3;
    String codigoInternoSS3;
    //
    String idPaiSS1;
    String idPaiSS2;
    String idPaiSS2f;
    String idPaiSS2v;
    String idPaiSS2vi;
    String idPaiTera;
    String idPaiPsico;
    String idPaiPsicoMed;
    String idPaiEapi;
    String idPaiSS3;
    // EVOLUÇÃO PAI    
    String dataEvolucaoPAI;
    String nomeUserRegistro;

    /**
     * Creates new form TelaPai
     */
    public TelaPaiPsicologia() {
        initComponents();
        formatarCampos();
        corCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel58 = new javax.swing.JLabel();
        buttonGroupParticipaCumprePena = new javax.swing.ButtonGroup();
        buttonGroupEscolaridade = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Listagem = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jCodigoPesqPAI = new javax.swing.JTextField();
        jBtPesqCodigo = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jBtPesqDataPAI = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jNomeInternoPesquisa = new javax.swing.JTextField();
        jBtPesqNomeInternoPAI = new javax.swing.JButton();
        jCheckBoxTodosRegistros = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaPAI = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        Manutencao = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCodigoPAI = new javax.swing.JTextField();
        jComboBoxStatusPAI = new javax.swing.JComboBox();
        jDataPAI = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jNomeInternoPAI = new javax.swing.JTextField();
        jNomeMaeInternoPAI = new javax.swing.JTextField();
        jNomePaiInternoPAI = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jBtPesquisarInternoPAI = new javax.swing.JButton();
        jDataNascimentoPAI = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jDataEntradaInternoPAI = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jEstadoCivilInternoPAI = new javax.swing.JTextField();
        JRGInternoPAI = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jCPFInternoPAI = new javax.swing.JTextField();
        jOrientacaoSexual = new javax.swing.JTextField();
        jCartaoSUSPAI = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jCorEtiniaInternoPAI = new javax.swing.JTextField();
        jSexoInternoPAI = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jNaturalidadeInternoPAI = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jIdInternoPAI = new javax.swing.JTextField();
        jIdadeInterno = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jBtAuditoria = new javax.swing.JButton();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEnderecoResidencial = new javax.swing.JTextArea();
        ServicoSocial = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jComboBoxCertidaoNasc = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jComboBoxRG = new javax.swing.JComboBox();
        jComboBoxCPF = new javax.swing.JComboBox();
        jComboBoxCTPS = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jOutrosDocumentos = new javax.swing.JTextField();
        jComboBoxRegulaDocumento = new javax.swing.JComboBox();
        jPanel12 = new javax.swing.JPanel();
        jBtAuditoriaSS = new javax.swing.JButton();
        jBtNovoSS = new javax.swing.JButton();
        jBtAlterarSS = new javax.swing.JButton();
        jBtExcluirSS = new javax.swing.JButton();
        jBtSalvarSS = new javax.swing.JButton();
        jBtCancelarSS = new javax.swing.JButton();
        jBtSairSS = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jComboBoxFilhosSemRegistros = new javax.swing.JComboBox();
        jQuantosFilhosMaiores21 = new javax.swing.JTextField();
        jQuantosFilhosSemRegistros = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jQuantosFilhosMenores21 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jObservacaoFilhos = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jComboBoxVulnerabilidadeSocial = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        jComboBoxAtendeCondiPrevistas = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        jComboBoxProgramaSocial = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        jQualProgramaSocial = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jRadioButtonNula = new javax.swing.JRadioButton();
        jRadioButtonInsuficiente = new javax.swing.JRadioButton();
        jRadioButtonRazoavel = new javax.swing.JRadioButton();
        jRadioButtonMuitoBoa = new javax.swing.JRadioButton();
        jLabel34 = new javax.swing.JLabel();
        jComboBoxIntervencaoPrograma = new javax.swing.JComboBox();
        jComboBoxLocalizacaoFamiliares = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        jObservacaoParticipacaoFamilia = new javax.swing.JTextField();
        Familiares = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTabelaFamiliarPAI = new javax.swing.JTable();
        jBtAuditoriaFamiliar = new javax.swing.JButton();
        jBtNovoFamiliar = new javax.swing.JButton();
        jBtAlterarFamiliar = new javax.swing.JButton();
        jBtExcluirFamiliar = new javax.swing.JButton();
        jBtSalvarFamiliar = new javax.swing.JButton();
        jBtCancelarFamiliar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel128 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jIdFamiliarPAI = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        jNomeFamiliarPAI = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        jIdadeFamiliarPAI = new javax.swing.JTextField();
        jComboBoxVinculoPAI = new javax.swing.JComboBox();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jOcupacaoFamiliarPAI = new javax.swing.JTextField();
        jEnderecoTelefonePAI = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jIdadeVisita = new javax.swing.JTextField();
        jBtPesqVisita = new javax.swing.JButton();
        jLabel131 = new javax.swing.JLabel();
        jOcupacaoVisita = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTabelaVisitas = new javax.swing.JTable();
        jBtAuditoriaVisita = new javax.swing.JButton();
        jBtNovaVisita = new javax.swing.JButton();
        jBtAlterarVisita = new javax.swing.JButton();
        jBtExcluirVisita = new javax.swing.JButton();
        jBtSalvarVisita = new javax.swing.JButton();
        jBtCancelarVisita = new javax.swing.JButton();
        jLabel129 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jIdVisitaPAI = new javax.swing.JTextField();
        jNomeVisitaPAI = new javax.swing.JTextField();
        jParentescoPAI = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jIdadeVisitaIntima = new javax.swing.JTextField();
        jBtPesqVisitaIntima = new javax.swing.JButton();
        jLabel132 = new javax.swing.JLabel();
        jOcupacaoVisitaIntima = new javax.swing.JTextField();
        jBtSalvarVisitaIntima = new javax.swing.JButton();
        jBtCancelarVisitaIntima = new javax.swing.JButton();
        jBtAuditoriaVisitaIntima = new javax.swing.JButton();
        jBtNovaVisitaIntima = new javax.swing.JButton();
        jBtAlterarVisitaIntima = new javax.swing.JButton();
        jBtExcluirVisitaIntima = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTabelaVisitasIntimas = new javax.swing.JTable();
        jNomeVisitaIntima = new javax.swing.JTextField();
        jIdVisitaIntima = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jParentescoVisitaIntima = new javax.swing.JTextField();
        Terapia = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jQualEscola = new javax.swing.JTextField();
        jComboBoxFrequentaEscola = new javax.swing.JComboBox();
        jComboBoxDemandaEscolar = new javax.swing.JComboBox();
        jEscolaridadeInternoPAI = new javax.swing.JTextField();
        jRadioButtonAnalfabeto = new javax.swing.JRadioButton();
        jRadioButtonFundamental1 = new javax.swing.JRadioButton();
        jRadioButtonFundamental2 = new javax.swing.JRadioButton();
        jRadioButtonEnsinoMedio = new javax.swing.JRadioButton();
        jRadioButtonSuperiorIncompleto = new javax.swing.JRadioButton();
        jRadioButtonSuperiorCompleto = new javax.swing.JRadioButton();
        jLabel40 = new javax.swing.JLabel();
        jObservacaoEstudos = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jProfissaoInternoPAI = new javax.swing.JTextField();
        jComboBoxParticipaAtividadeLab = new javax.swing.JComboBox();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jQualAtividadeLab = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jObservacaoLaborativa = new javax.swing.JTextField();
        jComboBoxPartAtivEsporte = new javax.swing.JComboBox();
        jHabilidades = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jQualAtividadeEsporte = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jComboBoxDemandaQualiProf = new javax.swing.JComboBox();
        jLabel52 = new javax.swing.JLabel();
        jComboBoxDemandaEsporte = new javax.swing.JComboBox();
        jLabel46 = new javax.swing.JLabel();
        jQualQualificacaoProf = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jComboBoxExperienciaTrab = new javax.swing.JComboBox();
        jLabel48 = new javax.swing.JLabel();
        jQualExperiencia = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jComboBoxEsporte = new javax.swing.JComboBox();
        jLabel55 = new javax.swing.JLabel();
        jQualEsporte = new javax.swing.JTextField();
        jComboBoxLazer = new javax.swing.JComboBox();
        jLabel56 = new javax.swing.JLabel();
        jQualLazer = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jComboBoxCultura = new javax.swing.JComboBox();
        jQualCultura = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jBtAuditoriaTO = new javax.swing.JButton();
        jBtNovoTO = new javax.swing.JButton();
        jBtAlterarTO = new javax.swing.JButton();
        jBtExcluirTO = new javax.swing.JButton();
        jBtSalvarTO = new javax.swing.JButton();
        jBtCancelarTO = new javax.swing.JButton();
        jBtSairTO = new javax.swing.JButton();
        Psicologia = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jComboBoxTranstornoMental = new javax.swing.JComboBox();
        jLabel66 = new javax.swing.JLabel();
        jComboBoxTratamentoAnterior = new javax.swing.JComboBox();
        jLabel68 = new javax.swing.JLabel();
        jComboBoxQuaisTratamentosMentais = new javax.swing.JComboBox();
        jLabel69 = new javax.swing.JLabel();
        jOutrosTratamento = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jComboBoxFoiInternado = new javax.swing.JComboBox();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jMedicacoesUtilizadas = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        jEspecificarFrequenciasLocais = new javax.swing.JTextArea();
        jPanel20 = new javax.swing.JPanel();
        jBtAuditoriaPSI = new javax.swing.JButton();
        jBtNovoPSI = new javax.swing.JButton();
        jBtAlterarPSI = new javax.swing.JButton();
        jBtExcluirPSI = new javax.swing.JButton();
        jBtSalvarPSI = new javax.swing.JButton();
        jBtCancelarPSI = new javax.swing.JButton();
        jBtSairPSI = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jObservacaoComportamentoViolento = new javax.swing.JTextField();
        jObservacaoTentativaSuicidio = new javax.swing.JTextField();
        jObservacaoUsoMedicacoPsiquiatrica = new javax.swing.JTextField();
        jObservacaoEnvolveJustica = new javax.swing.JTextField();
        jComboBoxTentativaSuicidio = new javax.swing.JComboBox();
        jComboBoxComportamentoViolento = new javax.swing.JComboBox();
        jComboBoxEpisodioDepressivo = new javax.swing.JComboBox();
        jComboBoxSurtoPsicotico = new javax.swing.JComboBox();
        jLabel78 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jObservacaoSurto = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jObservacaoDepressivo = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jComboBoxUsoMedicaPsiquia = new javax.swing.JComboBox();
        jLabel74 = new javax.swing.JLabel();
        jComboBoxEnvolveJustica = new javax.swing.JComboBox();
        Medico = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jComboBoxFamiliaTranstornoMental = new javax.swing.JComboBox();
        jLabel80 = new javax.swing.JLabel();
        jQuemTranstornoMental = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jQualTranstornoMental = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jComboBoxNecessidadePSI = new javax.swing.JComboBox();
        jCheckBoxConsultaPSI = new javax.swing.JCheckBox();
        jCheckBoxAcompanhaPSI = new javax.swing.JCheckBox();
        jLabel83 = new javax.swing.JLabel();
        jComboBoxFazUsoDroga = new javax.swing.JComboBox();
        jLabel84 = new javax.swing.JLabel();
        jQuaisDrogas = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jComboBoxCompartilhaDrogas = new javax.swing.JComboBox();
        jLabel87 = new javax.swing.JLabel();
        jComboBoxReducaoDanos = new javax.swing.JComboBox();
        jLabel88 = new javax.swing.JLabel();
        jPorqueReduzDanos = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jComboBoxAceitaProgramasDanos = new javax.swing.JComboBox();
        jLabel90 = new javax.swing.JLabel();
        jPorqueAceitaProgroReduDanos = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jBtAuditoriaPM = new javax.swing.JButton();
        jBtNovoPM = new javax.swing.JButton();
        jBtAlterarPM = new javax.swing.JButton();
        jBtExcluirPM = new javax.swing.JButton();
        jBtSalvarPM = new javax.swing.JButton();
        jBtCancelarPM = new javax.swing.JButton();
        jBtSairPM = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jComboBoxQueixaProbSaude = new javax.swing.JComboBox();
        jCheckBoxDiabetes = new javax.swing.JCheckBox();
        jCheckBoxTuberculose = new javax.swing.JCheckBox();
        jCheckBoxDST = new javax.swing.JCheckBox();
        jCheckBoxHepatite = new javax.swing.JCheckBox();
        jCheckBoxHanseniase = new javax.swing.JCheckBox();
        jCheckBoxHipertensao = new javax.swing.JCheckBox();
        jCheckBoxOutrasDoencas = new javax.swing.JCheckBox();
        jLabel92 = new javax.swing.JLabel();
        jQuaisOutrasDoencas = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jComboBoxProblemasSaudeBucal = new javax.swing.JComboBox();
        jLabel94 = new javax.swing.JLabel();
        jComboBoxFazTratamentoBucal = new javax.swing.JComboBox();
        jLabel95 = new javax.swing.JLabel();
        jQuaisTratamentoBucal = new javax.swing.JTextField();
        CRC = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jDescricaoUnidadePenal = new javax.swing.JTextField();
        jBtPesquisarUnidade = new javax.swing.JButton();
        jMatriculaPenal = new javax.swing.JTextField();
        jPavilhão = new javax.swing.JTextField();
        jCela = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jAlcunha = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        jRegimePenal = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jArtigo = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jTempPenaSentenca = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jTempoPenaCumprida = new javax.swing.JTextField();
        jTempoPenaACumprir = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jSituacaoJuridica = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jDataEntradaSistemaPenal = new com.toedter.calendar.JDateChooser();
        jLabel108 = new javax.swing.JLabel();
        jComboBoxReintegraSistemaPenal = new javax.swing.JComboBox();
        jLabel109 = new javax.swing.JLabel();
        jComboBoxAssistenciaJuridica = new javax.swing.JComboBox();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jComboBoxDefensorPublico = new javax.swing.JComboBox();
        jComboBoxOutroDefensor = new javax.swing.JComboBox();
        jLabel112 = new javax.swing.JLabel();
        jQualDefensor = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        jBtAuditoriaCRC = new javax.swing.JButton();
        jBtNovoCRC = new javax.swing.JButton();
        jBtAlterarCRC = new javax.swing.JButton();
        jBtExcluirCRC = new javax.swing.JButton();
        jBtSalvarCRC = new javax.swing.JButton();
        jBtCancelarCRC = new javax.swing.JButton();
        jBtSairCRC = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextoPSP = new javax.swing.JTextArea();
        ServicoSocial2 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextoCEDEGEP = new javax.swing.JTextArea();
        jPanel36 = new javax.swing.JPanel();
        jBtAuditoriaSS3 = new javax.swing.JButton();
        jBtNovoSS3 = new javax.swing.JButton();
        jBtAlterarSS3 = new javax.swing.JButton();
        jBtExcluirSS3 = new javax.swing.JButton();
        jBtSalvarSS3 = new javax.swing.JButton();
        jBtCancelarSS3 = new javax.swing.JButton();
        jBtSairSS3 = new javax.swing.JButton();
        jPanel37 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextoCRASCREAS = new javax.swing.JTextArea();
        jPanel38 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextoASSISTENCIA = new javax.swing.JTextArea();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextoDOCUMENTOCIVIL = new javax.swing.JTextArea();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jDataInclusaoPAI = new com.toedter.calendar.JDateChooser();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jTecnicoServicoSocial = new javax.swing.JTextField();
        jTecnicoPsicologico = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTabelaEvolucaoPAI = new javax.swing.JTable();
        jBtCancelarEvolucao = new javax.swing.JButton();
        jBtAuditoriaEvolucao = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextoEvolucao = new javax.swing.JTextArea();
        jBtNovaEvolucao = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel137 = new javax.swing.JLabel();
        jNomeInternoEvolucaoPAI = new javax.swing.JTextField();
        jLabel139 = new javax.swing.JLabel();
        jIdEvolucao = new javax.swing.JTextField();
        jLabel140 = new javax.swing.JLabel();
        jDataEvolucao = new com.toedter.calendar.JDateChooser();
        jBtAlterarEvolucao = new javax.swing.JButton();
        jBtExcluirEvolucao = new javax.swing.JButton();
        jBtSalvarEvolucao = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jBtImpressaoEvolucao = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jFotoInternoPAI = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLogoMarcaAssitenteSocial = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLogoMarcaPsicologia = new javax.swing.JLabel();

        jLabel58.setText("jLabel58");

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: P.A.I. - Programa de Assistência Individualizada {PSICOLOGIA} ::::...");

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setText("Código:");

        jCodigoPesqPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoPesqPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigo.setToolTipText("Pesquisar PAI por Código");
        jBtPesqCodigo.setContentAreaFilled(false);
        jBtPesqCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setText("Data Inicial:");

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel63.setText("Data Final:");

        jDataInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqDataPAI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqDataPAI.setToolTipText("Pesquisar PAI por Código");
        jBtPesqDataPAI.setContentAreaFilled(false);
        jBtPesqDataPAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataPAIActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setText("Nome do Interno:");

        jNomeInternoPesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInternoPAI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInternoPAI.setToolTipText("Pesquisar PAI por Código");
        jBtPesqNomeInternoPAI.setContentAreaFilled(false);
        jBtPesqNomeInternoPAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoPAIActionPerformed(evt);
            }
        });

        jCheckBoxTodosRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTodosRegistros.setText("Todos");
        jCheckBoxTodosRegistros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosRegistrosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqDataPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(jCodigoPesqPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxTodosRegistros))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(jNomeInternoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtPesqNomeInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBoxTodosRegistros)
                    .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCodigoPesqPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addGap(2, 2, 2)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel63)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqDataPAI)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqNomeInternoPAI)
                    .addComponent(jNomeInternoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabelaPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPAI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Status", "Nome do Interno"
            }
        ));
        jTabelaPAI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPAIMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaPAI);
        if (jTabelaPAI.getColumnModel().getColumnCount() > 0) {
            jTabelaPAI.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaPAI.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaPAI.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaPAI.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaPAI.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaPAI.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaPAI.getColumnModel().getColumn(3).setMinWidth(270);
            jTabelaPAI.getColumnModel().getColumn(3).setMaxWidth(270);
        }

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

        jLabel67.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel67))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67)
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

        javax.swing.GroupLayout ListagemLayout = new javax.swing.GroupLayout(Listagem);
        Listagem.setLayout(ListagemLayout);
        ListagemLayout.setHorizontalGroup(
            ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
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
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", Listagem);

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        jCodigoPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoPAI.setEnabled(false);

        jComboBoxStatusPAI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxStatusPAI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));
        jComboBoxStatusPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxStatusPAI.setEnabled(false);

        jDataPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPAI.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCodigoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBoxStatusPAI, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jDataPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCodigoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxStatusPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados Civis", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome da Mãe");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nome do Pai");

        jNomeInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoPAI.setEnabled(false);

        jNomeMaeInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeMaeInternoPAI.setEnabled(false);

        jNomePaiInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomePaiInternoPAI.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nome do Interno");

        jBtPesquisarInternoPAI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarInternoPAI.setToolTipText("Pesquisar Internos");
        jBtPesquisarInternoPAI.setContentAreaFilled(false);
        jBtPesquisarInternoPAI.setEnabled(false);
        jBtPesquisarInternoPAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternoPAIActionPerformed(evt);
            }
        });

        jDataNascimentoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascimentoPAI.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Idade");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Sexo");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Naturalidade");

        jDataEntradaInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntradaInternoPAI.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Estado civil");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Data Entrada");

        jEstadoCivilInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEstadoCivilInternoPAI.setEnabled(false);

        JRGInternoPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        JRGInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        JRGInternoPAI.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Orientação Sexual");

        jCPFInternoPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCPFInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCPFInternoPAI.setEnabled(false);

        jOrientacaoSexual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOrientacaoSexual.setEnabled(false);

        jCartaoSUSPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCartaoSUSPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCartaoSUSPAI.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("RG Nº");

        jCorEtiniaInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCorEtiniaInternoPAI.setEnabled(false);

        jSexoInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSexoInternoPAI.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("CPF Nº");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Cor/Etinia");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Cartão SUS");

        jNaturalidadeInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNaturalidadeInternoPAI.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Dt. Nascimento");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("Código");

        jIdInternoPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoPAI.setEnabled(false);

        jIdadeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdadeInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdadeInterno.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeMaeInternoPAI)
                    .addComponent(jNomePaiInternoPAI)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jNaturalidadeInternoPAI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCorEtiniaInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 237, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataEntradaInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jEstadoCivilInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jSexoInternoPAI)
                                        .addGap(6, 6, 6))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(JRGInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCPFInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jCartaoSUSPAI)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataNascimentoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jIdadeInterno)))
                            .addComponent(jLabel16)
                            .addComponent(jOrientacaoSexual, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jIdInternoPAI))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jNomeInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesquisarInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JRGInternoPAI, jDataEntradaInternoPAI});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel5)
                .addGap(2, 2, 2)
                .addComponent(jNomeMaeInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomePaiInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(7, 7, 7))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(JRGInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCPFInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCartaoSUSPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataNascimentoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdadeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataEntradaInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEstadoCivilInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSexoInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jOrientacaoSexual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNaturalidadeInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCorEtiniaInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
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
                .addComponent(jBtSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoria))
            .addComponent(jBtNovo)
            .addComponent(jBtAlterar)
            .addComponent(jBtExcluir)
            .addComponent(jBtSalvar)
            .addComponent(jBtCancelar)
            .addComponent(jBtSair)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados Pessoais/Endereço Residencial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jEnderecoResidencial.setColumns(20);
        jEnderecoResidencial.setRows(5);
        jEnderecoResidencial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEnderecoResidencial.setEnabled(false);
        jScrollPane1.setViewportView(jEnderecoResidencial);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ManutencaoLayout = new javax.swing.GroupLayout(Manutencao);
        Manutencao.setLayout(ManutencaoLayout);
        ManutencaoLayout.setHorizontalGroup(
            ManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManutencaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ManutencaoLayout.setVerticalGroup(
            ManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManutencaoLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Manutenção", Manutencao);

        ServicoSocial.setToolTipText("Serviço Social");

        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Tem necessidades de regulariazção da Documentação Civil?");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("C. Nascimento:");

        jComboBoxCertidaoNasc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCertidaoNasc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCertidaoNasc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCertidaoNasc.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("RG:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("CPF:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("CTPS:");

        jComboBoxRG.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRG.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxRG.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRG.setEnabled(false);

        jComboBoxCPF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCPF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCPF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCPF.setEnabled(false);

        jComboBoxCTPS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCTPS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCTPS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCTPS.setEnabled(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Outros:");

        jOutrosDocumentos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOutrosDocumentos.setEnabled(false);

        jComboBoxRegulaDocumento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRegulaDocumento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxRegulaDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRegulaDocumento.setEnabled(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxRegulaDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jComboBoxCertidaoNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCTPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jOutrosDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxRegulaDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19)
                    .addComponent(jComboBoxCertidaoNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jComboBoxRG, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jComboBoxCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jComboBoxCTPS, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jOutrosDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtAuditoriaSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaSS.setToolTipText("Auditoria");
        jBtAuditoriaSS.setContentAreaFilled(false);
        jBtAuditoriaSS.setEnabled(false);
        jBtAuditoriaSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaSSActionPerformed(evt);
            }
        });

        jBtNovoSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoSS.setText("Novo");
        jBtNovoSS.setContentAreaFilled(false);
        jBtNovoSS.setEnabled(false);
        jBtNovoSS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoSS.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoSS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoSSActionPerformed(evt);
            }
        });

        jBtAlterarSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarSS.setText("Alterar");
        jBtAlterarSS.setContentAreaFilled(false);
        jBtAlterarSS.setEnabled(false);
        jBtAlterarSS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarSS.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarSS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarSSActionPerformed(evt);
            }
        });

        jBtExcluirSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirSS.setText("Excluir");
        jBtExcluirSS.setContentAreaFilled(false);
        jBtExcluirSS.setEnabled(false);
        jBtExcluirSS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirSS.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirSS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirSSActionPerformed(evt);
            }
        });

        jBtSalvarSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarSS.setText("Gravar");
        jBtSalvarSS.setContentAreaFilled(false);
        jBtSalvarSS.setEnabled(false);
        jBtSalvarSS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarSS.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarSS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarSSActionPerformed(evt);
            }
        });

        jBtCancelarSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarSS.setText("Cancelar");
        jBtCancelarSS.setContentAreaFilled(false);
        jBtCancelarSS.setEnabled(false);
        jBtCancelarSS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarSS.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarSS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarSSActionPerformed(evt);
            }
        });

        jBtSairSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairSS.setText("Sair");
        jBtSairSS.setContentAreaFilled(false);
        jBtSairSS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairSS.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairSS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairSSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addComponent(jBtNovoSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairSS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaSS, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaSS))
            .addComponent(jBtNovoSS)
            .addComponent(jBtAlterarSS)
            .addComponent(jBtExcluirSS)
            .addComponent(jBtSalvarSS)
            .addComponent(jBtCancelarSS)
            .addComponent(jBtSairSS)
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Quantos filhos maiores de 21 anos com necessidades especiais?");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Quantos?");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Filhos sem registro de nascimento?");

        jComboBoxFilhosSemRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFilhosSemRegistros.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxFilhosSemRegistros.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFilhosSemRegistros.setEnabled(false);

        jQuantosFilhosMaiores21.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantosFilhosMaiores21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantosFilhosMaiores21.setEnabled(false);

        jQuantosFilhosSemRegistros.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantosFilhosSemRegistros.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantosFilhosSemRegistros.setEnabled(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Quantos filhos menores de 21 anos?");

        jQuantosFilhosMenores21.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jQuantosFilhosMenores21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuantosFilhosMenores21.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Observação:");

        jObservacaoFilhos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoFilhos.setEnabled(false);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("A familiar se encontra em situação de vulnerabilidade social?");

        jComboBoxVulnerabilidadeSocial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxVulnerabilidadeSocial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxVulnerabilidadeSocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxVulnerabilidadeSocial.setEnabled(false);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Atende às condicionalidades previstas?");

        jComboBoxAtendeCondiPrevistas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAtendeCondiPrevistas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAtendeCondiPrevistas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAtendeCondiPrevistas.setEnabled(false);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Está inserida em algum programa assist. social do governo?");

        jComboBoxProgramaSocial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxProgramaSocial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "CRAS", "CAPS", "CREAS", "Outros" }));
        jComboBoxProgramaSocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxProgramaSocial.setEnabled(false);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Qual?");

        jQualProgramaSocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualProgramaSocial.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel26)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addGap(7, 7, 7)))
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jQuantosFilhosMenores21)
                                    .addComponent(jComboBoxFilhosSemRegistros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jQuantosFilhosSemRegistros)
                            .addComponent(jQuantosFilhosMaiores21)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jObservacaoFilhos))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQualProgramaSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel30))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxProgramaSocial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxAtendeCondiPrevistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxVulnerabilidadeSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jQuantosFilhosMaiores21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jComboBoxFilhosSemRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jQuantosFilhosSemRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jQuantosFilhosMenores21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jObservacaoFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jComboBoxVulnerabilidadeSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jComboBoxAtendeCondiPrevistas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jComboBoxProgramaSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jQualProgramaSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Como tem sido a participação da sua familia durante cumprimento da Pena?");

        buttonGroupParticipaCumprePena.add(jRadioButtonNula);
        jRadioButtonNula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonNula.setText("Nula");
        jRadioButtonNula.setEnabled(false);

        buttonGroupParticipaCumprePena.add(jRadioButtonInsuficiente);
        jRadioButtonInsuficiente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonInsuficiente.setText("Insuficiente");
        jRadioButtonInsuficiente.setEnabled(false);

        buttonGroupParticipaCumprePena.add(jRadioButtonRazoavel);
        jRadioButtonRazoavel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonRazoavel.setSelected(true);
        jRadioButtonRazoavel.setText("Razoável");
        jRadioButtonRazoavel.setEnabled(false);

        buttonGroupParticipaCumprePena.add(jRadioButtonMuitoBoa);
        jRadioButtonMuitoBoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonMuitoBoa.setText("Muito Boa");
        jRadioButtonMuitoBoa.setEnabled(false);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Necessita intervenções do Programa?");

        jComboBoxIntervencaoPrograma.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIntervencaoPrograma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxIntervencaoPrograma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIntervencaoPrograma.setEnabled(false);

        jComboBoxLocalizacaoFamiliares.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxLocalizacaoFamiliares.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Localizar Familiares", "Contatar Familiares", "Agendar Atendimentos" }));
        jComboBoxLocalizacaoFamiliares.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxLocalizacaoFamiliares.setEnabled(false);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Observação:");

        jObservacaoParticipacaoFamilia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoParticipacaoFamilia.setEnabled(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jObservacaoParticipacaoFamilia))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxIntervencaoPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxLocalizacaoFamiliares, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel33)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jRadioButtonNula)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonInsuficiente)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonRazoavel)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonMuitoBoa)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRadioButtonRazoavel)
                    .addComponent(jRadioButtonMuitoBoa)
                    .addComponent(jRadioButtonNula)
                    .addComponent(jRadioButtonInsuficiente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jComboBoxIntervencaoPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxLocalizacaoFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jObservacaoParticipacaoFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout ServicoSocialLayout = new javax.swing.GroupLayout(ServicoSocial);
        ServicoSocial.setLayout(ServicoSocialLayout);
        ServicoSocialLayout.setHorizontalGroup(
            ServicoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServicoSocialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ServicoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ServicoSocialLayout.setVerticalGroup(
            ServicoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServicoSocialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("S. S.1", ServicoSocial);

        jTabelaFamiliarPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaFamiliarPAI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome do Familiar", "Vinculo", "Idade", "Ocupação"
            }
        ));
        jTabelaFamiliarPAI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaFamiliarPAIMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTabelaFamiliarPAI);
        if (jTabelaFamiliarPAI.getColumnModel().getColumnCount() > 0) {
            jTabelaFamiliarPAI.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaFamiliarPAI.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaFamiliarPAI.getColumnModel().getColumn(1).setMinWidth(250);
            jTabelaFamiliarPAI.getColumnModel().getColumn(1).setMaxWidth(250);
            jTabelaFamiliarPAI.getColumnModel().getColumn(2).setMinWidth(120);
            jTabelaFamiliarPAI.getColumnModel().getColumn(2).setMaxWidth(120);
            jTabelaFamiliarPAI.getColumnModel().getColumn(3).setMinWidth(40);
            jTabelaFamiliarPAI.getColumnModel().getColumn(3).setMaxWidth(40);
            jTabelaFamiliarPAI.getColumnModel().getColumn(4).setMinWidth(140);
            jTabelaFamiliarPAI.getColumnModel().getColumn(4).setMaxWidth(140);
        }

        jBtAuditoriaFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaFamiliar.setToolTipText("Auditoria");
        jBtAuditoriaFamiliar.setContentAreaFilled(false);
        jBtAuditoriaFamiliar.setEnabled(false);
        jBtAuditoriaFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaFamiliarActionPerformed(evt);
            }
        });

        jBtNovoFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoFamiliar.setToolTipText("Novo");
        jBtNovoFamiliar.setEnabled(false);
        jBtNovoFamiliar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoFamiliar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoFamiliar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoFamiliarActionPerformed(evt);
            }
        });

        jBtAlterarFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarFamiliar.setToolTipText("Alterar");
        jBtAlterarFamiliar.setEnabled(false);
        jBtAlterarFamiliar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarFamiliar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarFamiliar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarFamiliarActionPerformed(evt);
            }
        });

        jBtExcluirFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirFamiliar.setToolTipText("Excluir");
        jBtExcluirFamiliar.setEnabled(false);
        jBtExcluirFamiliar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirFamiliar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirFamiliar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirFamiliarActionPerformed(evt);
            }
        });

        jBtSalvarFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarFamiliar.setToolTipText("Gravar");
        jBtSalvarFamiliar.setEnabled(false);
        jBtSalvarFamiliar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarFamiliar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarFamiliar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarFamiliarActionPerformed(evt);
            }
        });

        jBtCancelarFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarFamiliar.setToolTipText("Cancelar");
        jBtCancelarFamiliar.setEnabled(false);
        jBtCancelarFamiliar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarFamiliar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarFamiliar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarFamiliarActionPerformed(evt);
            }
        });

        jLabel128.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(0, 0, 255));
        jLabel128.setText("Composição do grupo familiar (nuclear de convivência)");

        jLabel120.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel120.setText("Código");

        jIdFamiliarPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdFamiliarPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdFamiliarPAI.setEnabled(false);

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel121.setText("Nome do Familiar");

        jNomeFamiliarPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeFamiliarPAI.setEnabled(false);

        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel125.setText("idade");

        jIdadeFamiliarPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdadeFamiliarPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdadeFamiliarPAI.setEnabled(false);

        jComboBoxVinculoPAI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxVinculoPAI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Pai", "Mãe", "Avô", "Avó", "Tio", "Tia", "Irmão", "Irmã", "Primo", "Prima" }));
        jComboBoxVinculoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxVinculoPAI.setEnabled(false);

        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel122.setText("Vinculo");

        jLabel123.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel123.setText("Ocupação");

        jOcupacaoFamiliarPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOcupacaoFamiliarPAI.setEnabled(false);

        jEnderecoTelefonePAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEnderecoTelefonePAI.setEnabled(false);

        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel124.setText("Endereço/Telefone");

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setToolTipText("Pessoas de referência para as visitas");

        jIdadeVisita.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdadeVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdadeVisita.setEnabled(false);

        jBtPesqVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqVisita.setContentAreaFilled(false);
        jBtPesqVisita.setEnabled(false);
        jBtPesqVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqVisitaActionPerformed(evt);
            }
        });

        jLabel131.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel131.setText("Ocupação");

        jOcupacaoVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOcupacaoVisita.setEnabled(false);

        jTabelaVisitas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaVisitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item", "Código", "Nome da Visita", "Vinculo", "Idade", "Ocupação"
            }
        ));
        jTabelaVisitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaVisitasMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTabelaVisitas);
        if (jTabelaVisitas.getColumnModel().getColumnCount() > 0) {
            jTabelaVisitas.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaVisitas.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaVisitas.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaVisitas.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaVisitas.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaVisitas.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaVisitas.getColumnModel().getColumn(3).setMinWidth(120);
            jTabelaVisitas.getColumnModel().getColumn(3).setMaxWidth(120);
            jTabelaVisitas.getColumnModel().getColumn(4).setMinWidth(40);
            jTabelaVisitas.getColumnModel().getColumn(4).setMaxWidth(40);
            jTabelaVisitas.getColumnModel().getColumn(5).setMinWidth(140);
            jTabelaVisitas.getColumnModel().getColumn(5).setMaxWidth(140);
        }

        jBtAuditoriaVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaVisita.setToolTipText("Auditoria");
        jBtAuditoriaVisita.setContentAreaFilled(false);
        jBtAuditoriaVisita.setEnabled(false);
        jBtAuditoriaVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaVisitaActionPerformed(evt);
            }
        });

        jBtNovaVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaVisita.setToolTipText("Novo");
        jBtNovaVisita.setEnabled(false);
        jBtNovaVisita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovaVisita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovaVisita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovaVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaVisitaActionPerformed(evt);
            }
        });

        jBtAlterarVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarVisita.setToolTipText("Alterar");
        jBtAlterarVisita.setEnabled(false);
        jBtAlterarVisita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarVisita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarVisita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarVisitaActionPerformed(evt);
            }
        });

        jBtExcluirVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirVisita.setToolTipText("Excluir");
        jBtExcluirVisita.setEnabled(false);
        jBtExcluirVisita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirVisita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirVisita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirVisitaActionPerformed(evt);
            }
        });

        jBtSalvarVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarVisita.setToolTipText("Gravar");
        jBtSalvarVisita.setEnabled(false);
        jBtSalvarVisita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarVisita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarVisita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarVisitaActionPerformed(evt);
            }
        });

        jBtCancelarVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarVisita.setToolTipText("Cancelar");
        jBtCancelarVisita.setEnabled(false);
        jBtCancelarVisita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarVisita.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarVisita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarVisitaActionPerformed(evt);
            }
        });

        jLabel129.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel129.setText("Idade");

        jLabel126.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel126.setText("Código");

        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel127.setText("Nome da Visita");

        jIdVisitaPAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdVisitaPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdVisitaPAI.setEnabled(false);

        jNomeVisitaPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeVisitaPAI.setEnabled(false);

        jParentescoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParentescoPAI.setEnabled(false);

        jLabel134.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel134.setText("Vinculo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtNovaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterarVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvarVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelarVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtAuditoriaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jIdVisitaPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeVisitaPAI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel126)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel127)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jOcupacaoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel131))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel134)
                            .addComponent(jParentescoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdadeVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel129))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel126)
                    .addComponent(jLabel127))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeVisitaPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdVisitaPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel131)
                        .addComponent(jLabel134))
                    .addComponent(jLabel129))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jOcupacaoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jParentescoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdadeVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovaVisita)
                    .addComponent(jBtAlterarVisita)
                    .addComponent(jBtExcluirVisita)
                    .addComponent(jBtSalvarVisita)
                    .addComponent(jBtCancelarVisita)
                    .addComponent(jBtAuditoriaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jTabbedPane2.addTab("P.R.V.", jPanel2);

        jPanel10.setToolTipText("Pessoas de referência para as visitas íntimas");

        jLabel130.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel130.setText("Idade");

        jIdadeVisitaIntima.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdadeVisitaIntima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdadeVisitaIntima.setEnabled(false);

        jBtPesqVisitaIntima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqVisitaIntima.setContentAreaFilled(false);
        jBtPesqVisitaIntima.setEnabled(false);
        jBtPesqVisitaIntima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqVisitaIntimaActionPerformed(evt);
            }
        });

        jLabel132.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel132.setText("Ocupação");

        jOcupacaoVisitaIntima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOcupacaoVisitaIntima.setEnabled(false);

        jBtSalvarVisitaIntima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarVisitaIntima.setToolTipText("Gravar");
        jBtSalvarVisitaIntima.setEnabled(false);
        jBtSalvarVisitaIntima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarVisitaIntima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarVisitaIntima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarVisitaIntima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarVisitaIntimaActionPerformed(evt);
            }
        });

        jBtCancelarVisitaIntima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarVisitaIntima.setToolTipText("Cancelar");
        jBtCancelarVisitaIntima.setEnabled(false);
        jBtCancelarVisitaIntima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarVisitaIntima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarVisitaIntima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarVisitaIntima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarVisitaIntimaActionPerformed(evt);
            }
        });

        jBtAuditoriaVisitaIntima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaVisitaIntima.setToolTipText("Auditoria");
        jBtAuditoriaVisitaIntima.setContentAreaFilled(false);
        jBtAuditoriaVisitaIntima.setEnabled(false);
        jBtAuditoriaVisitaIntima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaVisitaIntimaActionPerformed(evt);
            }
        });

        jBtNovaVisitaIntima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaVisitaIntima.setToolTipText("Novo");
        jBtNovaVisitaIntima.setEnabled(false);
        jBtNovaVisitaIntima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovaVisitaIntima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovaVisitaIntima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovaVisitaIntima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaVisitaIntimaActionPerformed(evt);
            }
        });

        jBtAlterarVisitaIntima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarVisitaIntima.setToolTipText("Alterar");
        jBtAlterarVisitaIntima.setEnabled(false);
        jBtAlterarVisitaIntima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarVisitaIntima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarVisitaIntima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarVisitaIntima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarVisitaIntimaActionPerformed(evt);
            }
        });

        jBtExcluirVisitaIntima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirVisitaIntima.setToolTipText("Excluir");
        jBtExcluirVisitaIntima.setEnabled(false);
        jBtExcluirVisitaIntima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirVisitaIntima.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirVisitaIntima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirVisitaIntima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirVisitaIntimaActionPerformed(evt);
            }
        });

        jTabelaVisitasIntimas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaVisitasIntimas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item", "Código", "Nome da Visita Intima", "Vinculo", "Idade", "Ocupação"
            }
        ));
        jTabelaVisitasIntimas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaVisitasIntimasMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTabelaVisitasIntimas);
        if (jTabelaVisitasIntimas.getColumnModel().getColumnCount() > 0) {
            jTabelaVisitasIntimas.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaVisitasIntimas.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaVisitasIntimas.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaVisitasIntimas.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaVisitasIntimas.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaVisitasIntimas.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaVisitasIntimas.getColumnModel().getColumn(3).setMinWidth(120);
            jTabelaVisitasIntimas.getColumnModel().getColumn(3).setMaxWidth(120);
            jTabelaVisitasIntimas.getColumnModel().getColumn(4).setMinWidth(40);
            jTabelaVisitasIntimas.getColumnModel().getColumn(4).setMaxWidth(40);
            jTabelaVisitasIntimas.getColumnModel().getColumn(5).setMinWidth(140);
            jTabelaVisitasIntimas.getColumnModel().getColumn(5).setMaxWidth(140);
        }

        jNomeVisitaIntima.setEditable(false);
        jNomeVisitaIntima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeVisitaIntima.setEnabled(false);

        jIdVisitaIntima.setEditable(false);
        jIdVisitaIntima.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdVisitaIntima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdVisitaIntima.setEnabled(false);

        jLabel133.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel133.setText("Nome da Visita Intima");

        jLabel135.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel135.setText("Código");

        jLabel136.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel136.setText("Vinculo");

        jParentescoVisitaIntima.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParentescoVisitaIntima.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jBtNovaVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterarVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvarVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelarVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtAuditoriaVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jIdVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNomeVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtPesqVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel135)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel133)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jOcupacaoVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel132))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jParentescoVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel136))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdadeVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel130))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel135)
                    .addComponent(jLabel133))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jNomeVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel132)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jOcupacaoVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jParentescoVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel130)
                            .addComponent(jLabel136))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIdadeVisitaIntima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtNovaVisitaIntima)
                    .addComponent(jBtAlterarVisitaIntima)
                    .addComponent(jBtExcluirVisitaIntima)
                    .addComponent(jBtSalvarVisitaIntima)
                    .addComponent(jBtCancelarVisitaIntima)
                    .addComponent(jBtAuditoriaVisitaIntima))
                .addGap(6, 6, 6))
        );

        jTabbedPane2.addTab("P.R.V.I.", jPanel10);

        javax.swing.GroupLayout FamiliaresLayout = new javax.swing.GroupLayout(Familiares);
        Familiares.setLayout(FamiliaresLayout);
        FamiliaresLayout.setHorizontalGroup(
            FamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FamiliaresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9)
                    .addGroup(FamiliaresLayout.createSequentialGroup()
                        .addGroup(FamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel120)
                            .addComponent(jIdFamiliarPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FamiliaresLayout.createSequentialGroup()
                                .addComponent(jLabel121)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jNomeFamiliarPAI))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIdadeFamiliarPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel125))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel122)
                            .addComponent(jComboBoxVinculoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FamiliaresLayout.createSequentialGroup()
                        .addGroup(FamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel123)
                            .addComponent(jOcupacaoFamiliarPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FamiliaresLayout.createSequentialGroup()
                                .addComponent(jLabel124)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jEnderecoTelefonePAI)))
                    .addGroup(FamiliaresLayout.createSequentialGroup()
                        .addComponent(jBtNovoFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterarFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvarFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelarFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtAuditoriaFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addGroup(FamiliaresLayout.createSequentialGroup()
                        .addComponent(jLabel128)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane2))
                .addContainerGap())
        );
        FamiliaresLayout.setVerticalGroup(
            FamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FamiliaresLayout.createSequentialGroup()
                .addComponent(jLabel128)
                .addGap(1, 1, 1)
                .addGroup(FamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel120)
                    .addComponent(jLabel121)
                    .addComponent(jLabel125)
                    .addComponent(jLabel122))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdFamiliarPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNomeFamiliarPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdadeFamiliarPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxVinculoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(FamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FamiliaresLayout.createSequentialGroup()
                        .addComponent(jLabel123)
                        .addGap(3, 3, 3)
                        .addComponent(jOcupacaoFamiliarPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FamiliaresLayout.createSequentialGroup()
                        .addComponent(jLabel124)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEnderecoTelefonePAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovoFamiliar)
                    .addComponent(jBtAlterarFamiliar)
                    .addComponent(jBtExcluirFamiliar)
                    .addComponent(jBtSalvarFamiliar)
                    .addComponent(jBtCancelarFamiliar)
                    .addComponent(jBtAuditoriaFamiliar))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("S.S.2", Familiares);

        Terapia.setToolTipText("Terapia/Pedagogia");

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados de Escolarização e Trabalho", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Escolaridade:");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Frequenta Escola?");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Demanda de qualificação escolar?");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Qual?");

        jQualEscola.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualEscola.setEnabled(false);

        jComboBoxFrequentaEscola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFrequentaEscola.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxFrequentaEscola.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFrequentaEscola.setEnabled(false);

        jComboBoxDemandaEscolar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDemandaEscolar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDemandaEscolar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDemandaEscolar.setEnabled(false);

        jEscolaridadeInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEscolaridadeInternoPAI.setEnabled(false);

        buttonGroupEscolaridade.add(jRadioButtonAnalfabeto);
        jRadioButtonAnalfabeto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonAnalfabeto.setSelected(true);
        jRadioButtonAnalfabeto.setText("Analfabeto");
        jRadioButtonAnalfabeto.setEnabled(false);

        buttonGroupEscolaridade.add(jRadioButtonFundamental1);
        jRadioButtonFundamental1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonFundamental1.setText("Fundamental 1");
        jRadioButtonFundamental1.setEnabled(false);

        buttonGroupEscolaridade.add(jRadioButtonFundamental2);
        jRadioButtonFundamental2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonFundamental2.setText("Fundamental 2");
        jRadioButtonFundamental2.setEnabled(false);

        buttonGroupEscolaridade.add(jRadioButtonEnsinoMedio);
        jRadioButtonEnsinoMedio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonEnsinoMedio.setText("Ensino Médio");
        jRadioButtonEnsinoMedio.setEnabled(false);

        buttonGroupEscolaridade.add(jRadioButtonSuperiorIncompleto);
        jRadioButtonSuperiorIncompleto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonSuperiorIncompleto.setText("Superior Incompleto");
        jRadioButtonSuperiorIncompleto.setEnabled(false);

        buttonGroupEscolaridade.add(jRadioButtonSuperiorCompleto);
        jRadioButtonSuperiorCompleto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonSuperiorCompleto.setText("Superior Completo");
        jRadioButtonSuperiorCompleto.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Observação:");

        jObservacaoEstudos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoEstudos.setEnabled(false);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Profissão:");

        jProfissaoInternoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jProfissaoInternoPAI.setEnabled(false);

        jComboBoxParticipaAtividadeLab.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxParticipaAtividadeLab.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxParticipaAtividadeLab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxParticipaAtividadeLab.setEnabled(false);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Participa atividade laborativa?");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Qual?");

        jQualAtividadeLab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualAtividadeLab.setEnabled(false);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Observação:");

        jObservacaoLaborativa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoLaborativa.setEnabled(false);

        jComboBoxPartAtivEsporte.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPartAtivEsporte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxPartAtivEsporte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPartAtivEsporte.setEnabled(false);

        jHabilidades.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHabilidades.setEnabled(false);

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Quais?");

        jQualAtividadeEsporte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualAtividadeEsporte.setEnabled(false);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Demanda de quailificação profissional?");

        jComboBoxDemandaQualiProf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDemandaQualiProf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDemandaQualiProf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDemandaQualiProf.setEnabled(false);

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Demandas por práticas de esporte, lazer e/ou de cultura?");

        jComboBoxDemandaEsporte.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDemandaEsporte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDemandaEsporte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDemandaEsporte.setEnabled(false);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Qual?");

        jQualQualificacaoProf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualQualificacaoProf.setEnabled(false);

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Experiências trabalho/geração renda?");

        jComboBoxExperienciaTrab.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxExperienciaTrab.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxExperienciaTrab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxExperienciaTrab.setEnabled(false);

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("Qual?");

        jQualExperiencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualExperiencia.setEnabled(false);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("Participa de atividades esportivas lazer e/ou de cultura?");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Habilidades:");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Esporte:");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Lazer:");

        jComboBoxEsporte.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEsporte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxEsporte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEsporte.setEnabled(false);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Qual?");

        jQualEsporte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualEsporte.setEnabled(false);

        jComboBoxLazer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxLazer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxLazer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxLazer.setEnabled(false);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Qual?");

        jQualLazer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualLazer.setEnabled(false);

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("Cultura:");

        jComboBoxCultura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCultura.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCultura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCultura.setEnabled(false);

        jQualCultura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualCultura.setEnabled(false);

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("Qual?");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jRadioButtonAnalfabeto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonFundamental1))
                            .addComponent(jRadioButtonSuperiorIncompleto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonSuperiorCompleto)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jRadioButtonFundamental2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonEnsinoMedio)))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQualEscola))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxDemandaEscolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxFrequentaEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jEscolaridadeInternoPAI)))
                        .addGap(10, 10, 10))))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxPartAtivEsporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel47))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxExperienciaTrab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxDemandaQualiProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46)
                                    .addComponent(jLabel48))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jQualQualificacaoProf)
                                    .addComponent(jQualExperiencia)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxDemandaEsporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxCultura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxEsporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(jLabel60))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jQualEsporte, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxLazer, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQualLazer))
                            .addComponent(jQualCultura)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jObservacaoEstudos)
                            .addComponent(jProfissaoInternoPAI)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jHabilidades))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxParticipaAtividadeLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualAtividadeLab))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQualAtividadeEsporte))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jObservacaoLaborativa)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jEscolaridadeInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jComboBoxDemandaEscolar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jComboBoxFrequentaEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jQualEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonAnalfabeto)
                    .addComponent(jRadioButtonFundamental1)
                    .addComponent(jRadioButtonFundamental2)
                    .addComponent(jRadioButtonEnsinoMedio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonSuperiorIncompleto)
                    .addComponent(jRadioButtonSuperiorCompleto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jObservacaoEstudos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jProfissaoInternoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jComboBoxParticipaAtividadeLab, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(jQualAtividadeLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jObservacaoLaborativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jComboBoxDemandaQualiProf, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(jQualQualificacaoProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jComboBoxExperienciaTrab, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(jQualExperiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jHabilidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jComboBoxPartAtivEsporte, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jQualAtividadeEsporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jComboBoxDemandaEsporte, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel53)
                    .addComponent(jComboBoxEsporte, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55)
                    .addComponent(jQualEsporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(jComboBoxLazer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56)
                    .addComponent(jQualLazer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jComboBoxCultura, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQualCultura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtAuditoriaTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaTO.setToolTipText("Auditoria");
        jBtAuditoriaTO.setContentAreaFilled(false);
        jBtAuditoriaTO.setEnabled(false);
        jBtAuditoriaTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaTOActionPerformed(evt);
            }
        });

        jBtNovoTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoTO.setText("Novo");
        jBtNovoTO.setContentAreaFilled(false);
        jBtNovoTO.setEnabled(false);
        jBtNovoTO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoTO.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoTO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoTOActionPerformed(evt);
            }
        });

        jBtAlterarTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarTO.setText("Alterar");
        jBtAlterarTO.setContentAreaFilled(false);
        jBtAlterarTO.setEnabled(false);
        jBtAlterarTO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarTO.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarTO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarTOActionPerformed(evt);
            }
        });

        jBtExcluirTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirTO.setText("Excluir");
        jBtExcluirTO.setContentAreaFilled(false);
        jBtExcluirTO.setEnabled(false);
        jBtExcluirTO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirTO.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirTO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirTOActionPerformed(evt);
            }
        });

        jBtSalvarTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarTO.setText("Gravar");
        jBtSalvarTO.setContentAreaFilled(false);
        jBtSalvarTO.setEnabled(false);
        jBtSalvarTO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarTO.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarTO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarTOActionPerformed(evt);
            }
        });

        jBtCancelarTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarTO.setText("Cancelar");
        jBtCancelarTO.setContentAreaFilled(false);
        jBtCancelarTO.setEnabled(false);
        jBtCancelarTO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarTO.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarTO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarTOActionPerformed(evt);
            }
        });

        jBtSairTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairTO.setText("Sair");
        jBtSairTO.setContentAreaFilled(false);
        jBtSairTO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairTO.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairTO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairTOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addComponent(jBtNovoTO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarTO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirTO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarTO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarTO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairTO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaTO, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaTO))
            .addComponent(jBtNovoTO)
            .addComponent(jBtAlterarTO)
            .addComponent(jBtExcluirTO)
            .addComponent(jBtSalvarTO)
            .addComponent(jBtCancelarTO)
            .addComponent(jBtSairTO)
        );

        javax.swing.GroupLayout TerapiaLayout = new javax.swing.GroupLayout(Terapia);
        Terapia.setLayout(TerapiaLayout);
        TerapiaLayout.setHorizontalGroup(
            TerapiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TerapiaLayout.createSequentialGroup()
                .addGroup(TerapiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TerapiaLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(TerapiaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        TerapiaLayout.setVerticalGroup(
            TerapiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TerapiaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("TO/Ped.", Terapia);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("Apresenta episódios de transtorno mental?");

        jComboBoxTranstornoMental.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTranstornoMental.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTranstornoMental.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTranstornoMental.setEnabled(false);

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setText("Tratamento anteriores?");

        jComboBoxTratamentoAnterior.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTratamentoAnterior.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTratamentoAnterior.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTratamentoAnterior.setEnabled(false);

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setText("Quais?");

        jComboBoxQuaisTratamentosMentais.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxQuaisTratamentosMentais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Psiquiatrico", "Psicoterápico", "Médico Clínico", "Psicanalitico", "Religioso", "Outros" }));
        jComboBoxQuaisTratamentosMentais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxQuaisTratamentosMentais.setEnabled(false);

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel69.setText("Outros:");

        jOutrosTratamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jOutrosTratamento.setEnabled(false);

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setText("Já foi internado?");

        jComboBoxFoiInternado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFoiInternado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxFoiInternado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFoiInternado.setEnabled(false);

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel71.setText("Especificar frequencias e Locais:");

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setText("Medicações Utilizadas:");

        jMedicacoesUtilizadas.setColumns(20);
        jMedicacoesUtilizadas.setRows(5);
        jMedicacoesUtilizadas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMedicacoesUtilizadas.setEnabled(false);
        jScrollPane3.setViewportView(jMedicacoesUtilizadas);

        jEspecificarFrequenciasLocais.setColumns(20);
        jEspecificarFrequenciasLocais.setRows(5);
        jEspecificarFrequenciasLocais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEspecificarFrequenciasLocais.setEnabled(false);
        jScrollPane12.setViewportView(jEspecificarFrequenciasLocais);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel72)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane12))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxFoiInternado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel71))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addComponent(jLabel65)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxTranstornoMental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addComponent(jLabel66)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxTratamentoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel68)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxQuaisTratamentosMentais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel69)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jOutrosTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(jComboBoxTranstornoMental, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(jComboBoxTratamentoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68)
                    .addComponent(jComboBoxQuaisTratamentosMentais, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(jOutrosTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxFoiInternado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtAuditoriaPSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaPSI.setToolTipText("Auditoria");
        jBtAuditoriaPSI.setContentAreaFilled(false);
        jBtAuditoriaPSI.setEnabled(false);
        jBtAuditoriaPSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaPSIActionPerformed(evt);
            }
        });

        jBtNovoPSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoPSI.setText("Novo");
        jBtNovoPSI.setContentAreaFilled(false);
        jBtNovoPSI.setEnabled(false);
        jBtNovoPSI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoPSI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoPSI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoPSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoPSIActionPerformed(evt);
            }
        });

        jBtAlterarPSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarPSI.setText("Alterar");
        jBtAlterarPSI.setContentAreaFilled(false);
        jBtAlterarPSI.setEnabled(false);
        jBtAlterarPSI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarPSI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarPSI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarPSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarPSIActionPerformed(evt);
            }
        });

        jBtExcluirPSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirPSI.setText("Excluir");
        jBtExcluirPSI.setContentAreaFilled(false);
        jBtExcluirPSI.setEnabled(false);
        jBtExcluirPSI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirPSI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirPSI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirPSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirPSIActionPerformed(evt);
            }
        });

        jBtSalvarPSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarPSI.setText("Gravar");
        jBtSalvarPSI.setContentAreaFilled(false);
        jBtSalvarPSI.setEnabled(false);
        jBtSalvarPSI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarPSI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarPSI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarPSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarPSIActionPerformed(evt);
            }
        });

        jBtCancelarPSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarPSI.setText("Cancelar");
        jBtCancelarPSI.setContentAreaFilled(false);
        jBtCancelarPSI.setEnabled(false);
        jBtCancelarPSI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarPSI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarPSI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarPSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarPSIActionPerformed(evt);
            }
        });

        jBtSairPSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairPSI.setText("Sair");
        jBtSairPSI.setContentAreaFilled(false);
        jBtSairPSI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairPSI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairPSI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairPSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairPSIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addComponent(jBtNovoPSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarPSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirPSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarPSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarPSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairPSI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaPSI, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaPSI))
            .addComponent(jBtNovoPSI)
            .addComponent(jBtAlterarPSI)
            .addComponent(jBtExcluirPSI)
            .addComponent(jBtSalvarPSI)
            .addComponent(jBtCancelarPSI)
            .addComponent(jBtSairPSI)
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Observações", javax.swing.border.TitledBorder.TRAILING, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jObservacaoComportamentoViolento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoComportamentoViolento.setEnabled(false);

        jObservacaoTentativaSuicidio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoTentativaSuicidio.setEnabled(false);

        jObservacaoUsoMedicacoPsiquiatrica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoUsoMedicacoPsiquiatrica.setEnabled(false);

        jObservacaoEnvolveJustica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoEnvolveJustica.setEnabled(false);

        jComboBoxTentativaSuicidio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTentativaSuicidio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxTentativaSuicidio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTentativaSuicidio.setEnabled(false);

        jComboBoxComportamentoViolento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxComportamentoViolento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxComportamentoViolento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxComportamentoViolento.setEnabled(false);

        jComboBoxEpisodioDepressivo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEpisodioDepressivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxEpisodioDepressivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEpisodioDepressivo.setEnabled(false);

        jComboBoxSurtoPsicotico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSurtoPsicotico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxSurtoPsicotico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSurtoPsicotico.setEnabled(false);

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel78.setText("Uso de medicação psiquiátrica?");

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setText("Envolvimento com a justiça?");

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setText("Comportamento violento?");

        jObservacaoSurto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoSurto.setEnabled(false);

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setText("Episódio depressivo?");

        jObservacaoDepressivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacaoDepressivo.setEnabled(false);

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setText("Tentativa de suicidio?");

        jComboBoxUsoMedicaPsiquia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUsoMedicaPsiquia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxUsoMedicaPsiquia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUsoMedicaPsiquia.setEnabled(false);

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setText("Surto psicótico:");

        jComboBoxEnvolveJustica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEnvolveJustica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxEnvolveJustica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEnvolveJustica.setEnabled(false);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEpisodioDepressivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jObservacaoDepressivo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel78, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel77, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel76, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel74, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jComboBoxUsoMedicaPsiquia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jObservacaoUsoMedicacoPsiquiatrica))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jComboBoxEnvolveJustica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jObservacaoEnvolveJustica))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jComboBoxComportamentoViolento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jObservacaoComportamentoViolento))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jComboBoxTentativaSuicidio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jObservacaoTentativaSuicidio))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jComboBoxSurtoPsicotico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jObservacaoSurto, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(jComboBoxEpisodioDepressivo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jObservacaoDepressivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(jComboBoxSurtoPsicotico, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jObservacaoSurto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jComboBoxTentativaSuicidio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jObservacaoTentativaSuicidio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(jComboBoxComportamentoViolento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jObservacaoComportamentoViolento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxEnvolveJustica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jObservacaoEnvolveJustica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(jComboBoxUsoMedicaPsiquia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jObservacaoUsoMedicacoPsiquiatrica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PsicologiaLayout = new javax.swing.GroupLayout(Psicologia);
        Psicologia.setLayout(PsicologiaLayout);
        PsicologiaLayout.setHorizontalGroup(
            PsicologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PsicologiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PsicologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PsicologiaLayout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PsicologiaLayout.createSequentialGroup()
                        .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(PsicologiaLayout.createSequentialGroup()
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PsicologiaLayout.setVerticalGroup(
            PsicologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PsicologiaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Psi", Psicologia);

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel79.setText("Alguém na família já apresentou episódio de transtorno mental?");

        jComboBoxFamiliaTranstornoMental.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFamiliaTranstornoMental.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxFamiliaTranstornoMental.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFamiliaTranstornoMental.setEnabled(false);

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setText("Se sim, quem?");

        jQuemTranstornoMental.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuemTranstornoMental.setEnabled(false);

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel81.setText("Qual é o transtorno?");

        jQualTranstornoMental.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualTranstornoMental.setEnabled(false);

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel82.setText("Sente necessidade de  acompanha. psicológico e/ou medicamentoso?");

        jComboBoxNecessidadePSI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNecessidadePSI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxNecessidadePSI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNecessidadePSI.setEnabled(false);

        jCheckBoxConsultaPSI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxConsultaPSI.setText("Consulta Psiquiátrica");
        jCheckBoxConsultaPSI.setEnabled(false);

        jCheckBoxAcompanhaPSI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxAcompanhaPSI.setText("Acompanhamento Psicológico");
        jCheckBoxAcompanhaPSI.setEnabled(false);

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel83.setText("Faz ou já fez uso de alguma droga?");

        jComboBoxFazUsoDroga.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFazUsoDroga.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxFazUsoDroga.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFazUsoDroga.setEnabled(false);

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setText("Quais?");

        jQuaisDrogas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisDrogas.setEnabled(false);

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setText("Faz   ou já fez uso  compartilhado de  drogas injetáveis e/ou de  cachimbo para ");

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setText("fumar crack?");

        jComboBoxCompartilhaDrogas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCompartilhaDrogas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxCompartilhaDrogas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCompartilhaDrogas.setEnabled(false);

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setText("Aceita participar de Programa Redução Danos?");

        jComboBoxReducaoDanos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxReducaoDanos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxReducaoDanos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxReducaoDanos.setEnabled(false);

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setText("Porquê?");

        jPorqueReduzDanos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPorqueReduzDanos.setEnabled(false);

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel89.setText("Aceita conhecer o Programa de Redução de Danos?");

        jComboBoxAceitaProgramasDanos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAceitaProgramasDanos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAceitaProgramasDanos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAceitaProgramasDanos.setEnabled(false);

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel90.setText("Porquê?");

        jPorqueAceitaProgroReduDanos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPorqueAceitaProgroReduDanos.setEnabled(false);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel79)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxFamiliaTranstornoMental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                                .addComponent(jCheckBoxConsultaPSI)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxAcompanhaPSI)
                                .addGap(42, 42, 42))))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxNecessidadePSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel80, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jQuemTranstornoMental)
                                    .addComponent(jQualTranstornoMental)))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel88)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPorqueReduzDanos))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel85)
                                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel24Layout.createSequentialGroup()
                                            .addComponent(jLabel83)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxFazUsoDroga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel84)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jQuaisDrogas))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
                                            .addComponent(jLabel86)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxCompartilhaDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel87)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxReducaoDanos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel89)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxAceitaProgramasDanos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel90)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPorqueAceitaProgroReduDanos)))
                        .addGap(10, 10, 10))))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jComboBoxFamiliaTranstornoMental, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(jQuemTranstornoMental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(jQualTranstornoMental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(jComboBoxNecessidadePSI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxConsultaPSI)
                    .addComponent(jCheckBoxAcompanhaPSI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(jComboBoxFazUsoDroga, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84)
                    .addComponent(jQuaisDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel85)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(jComboBoxCompartilhaDrogas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87)
                    .addComponent(jComboBoxReducaoDanos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(jPorqueReduzDanos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89)
                    .addComponent(jComboBoxAceitaProgramasDanos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(jPorqueAceitaProgroReduDanos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtAuditoriaPM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaPM.setToolTipText("Auditoria");
        jBtAuditoriaPM.setContentAreaFilled(false);
        jBtAuditoriaPM.setEnabled(false);
        jBtAuditoriaPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaPMActionPerformed(evt);
            }
        });

        jBtNovoPM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoPM.setText("Novo");
        jBtNovoPM.setContentAreaFilled(false);
        jBtNovoPM.setEnabled(false);
        jBtNovoPM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoPM.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoPM.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoPMActionPerformed(evt);
            }
        });

        jBtAlterarPM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarPM.setText("Alterar");
        jBtAlterarPM.setContentAreaFilled(false);
        jBtAlterarPM.setEnabled(false);
        jBtAlterarPM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarPM.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarPM.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarPMActionPerformed(evt);
            }
        });

        jBtExcluirPM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirPM.setText("Excluir");
        jBtExcluirPM.setContentAreaFilled(false);
        jBtExcluirPM.setEnabled(false);
        jBtExcluirPM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirPM.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirPM.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirPMActionPerformed(evt);
            }
        });

        jBtSalvarPM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarPM.setText("Gravar");
        jBtSalvarPM.setContentAreaFilled(false);
        jBtSalvarPM.setEnabled(false);
        jBtSalvarPM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarPM.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarPM.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarPMActionPerformed(evt);
            }
        });

        jBtCancelarPM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarPM.setText("Cancelar");
        jBtCancelarPM.setContentAreaFilled(false);
        jBtCancelarPM.setEnabled(false);
        jBtCancelarPM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarPM.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarPM.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarPMActionPerformed(evt);
            }
        });

        jBtSairPM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairPM.setText("Sair");
        jBtSairPM.setContentAreaFilled(false);
        jBtSairPM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairPM.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairPM.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairPMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addComponent(jBtNovoPM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarPM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirPM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarPM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarPM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairPM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaPM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaPM))
            .addComponent(jBtNovoPM)
            .addComponent(jBtAlterarPM)
            .addComponent(jBtExcluirPM)
            .addComponent(jBtSalvarPM)
            .addComponent(jBtCancelarPM)
            .addComponent(jBtSairPM)
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Médico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel91.setText("Tem queixa atual de problemas de saúde?");

        jComboBoxQueixaProbSaude.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxQueixaProbSaude.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxQueixaProbSaude.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxQueixaProbSaude.setEnabled(false);

        jCheckBoxDiabetes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxDiabetes.setForeground(new java.awt.Color(255, 0, 0));
        jCheckBoxDiabetes.setText("Diabetes");
        jCheckBoxDiabetes.setEnabled(false);

        jCheckBoxTuberculose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxTuberculose.setForeground(new java.awt.Color(204, 0, 153));
        jCheckBoxTuberculose.setText("Tuberculose");
        jCheckBoxTuberculose.setEnabled(false);

        jCheckBoxDST.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxDST.setForeground(new java.awt.Color(0, 153, 0));
        jCheckBoxDST.setText("DST/HIV/Aids");
        jCheckBoxDST.setEnabled(false);

        jCheckBoxHepatite.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxHepatite.setForeground(new java.awt.Color(204, 0, 0));
        jCheckBoxHepatite.setText("Hepatite");
        jCheckBoxHepatite.setEnabled(false);

        jCheckBoxHanseniase.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxHanseniase.setForeground(new java.awt.Color(0, 51, 51));
        jCheckBoxHanseniase.setText("Hanseniase");
        jCheckBoxHanseniase.setEnabled(false);

        jCheckBoxHipertensao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxHipertensao.setForeground(new java.awt.Color(0, 0, 255));
        jCheckBoxHipertensao.setText("Hipertensão Arterial");
        jCheckBoxHipertensao.setEnabled(false);

        jCheckBoxOutrasDoencas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxOutrasDoencas.setForeground(new java.awt.Color(51, 0, 51));
        jCheckBoxOutrasDoencas.setText("Outras?");
        jCheckBoxOutrasDoencas.setEnabled(false);

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel92.setText("Quais?");

        jQuaisOutrasDoencas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisOutrasDoencas.setEnabled(false);

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel93.setText("Tem problemas de saúde bucal?");

        jComboBoxProblemasSaudeBucal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxProblemasSaudeBucal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxProblemasSaudeBucal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxProblemasSaudeBucal.setEnabled(false);

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel94.setText("Está fazendo tratamento?");

        jComboBoxFazTratamentoBucal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxFazTratamentoBucal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxFazTratamentoBucal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxFazTratamentoBucal.setEnabled(false);

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel95.setText("Quais?");

        jQuaisTratamentoBucal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQuaisTratamentoBucal.setEnabled(false);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel93)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxProblemasSaudeBucal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel94)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxFazTratamentoBucal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jCheckBoxOutrasDoencas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel92)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jQuaisOutrasDoencas))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel91)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxQueixaProbSaude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBoxHipertensao))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jCheckBoxDiabetes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBoxTuberculose)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxDST)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxHepatite)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxHanseniase)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQuaisTratamentoBucal)))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91)
                    .addComponent(jComboBoxQueixaProbSaude, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxHipertensao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxDiabetes)
                    .addComponent(jCheckBoxTuberculose)
                    .addComponent(jCheckBoxDST)
                    .addComponent(jCheckBoxHepatite)
                    .addComponent(jCheckBoxHanseniase))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxOutrasDoencas)
                    .addComponent(jLabel92)
                    .addComponent(jQuaisOutrasDoencas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(jComboBoxProblemasSaudeBucal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel94)
                    .addComponent(jComboBoxFazTratamentoBucal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(jQuaisTratamentoBucal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MedicoLayout = new javax.swing.GroupLayout(Medico);
        Medico.setLayout(MedicoLayout);
        MedicoLayout.setHorizontalGroup(
            MedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MedicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        MedicoLayout.setVerticalGroup(
            MedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MedicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("P.M.", Medico);

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados Instituicionais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel96.setText("Un. Prisional:");

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel97.setText("Nº Matricula:");

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel98.setText("Pavilhão:");

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel99.setText("Cela:");

        jDescricaoUnidadePenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoUnidadePenal.setEnabled(false);

        jBtPesquisarUnidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarUnidade.setContentAreaFilled(false);
        jBtPesquisarUnidade.setEnabled(false);
        jBtPesquisarUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarUnidadeActionPerformed(evt);
            }
        });

        jMatriculaPenal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenal.setEnabled(false);

        jPavilhão.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPavilhão.setEnabled(false);

        jCela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCela.setEnabled(false);

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel100.setText("Alcunha:");

        jAlcunha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlcunha.setEnabled(false);

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel101.setText("Regime:");

        jRegimePenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegimePenal.setEnabled(false);

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel102.setText("Artigo:");

        jArtigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jArtigo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jArtigo.setEnabled(false);

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel103.setText("Sentenciado a:");

        jTempPenaSentenca.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTempPenaSentenca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTempPenaSentenca.setEnabled(false);

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel104.setText("Tempo de pena cumprida:");

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel105.setText("Tempo da pena a cumprir:");

        jTempoPenaCumprida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTempoPenaCumprida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTempoPenaCumprida.setEnabled(false);

        jTempoPenaACumprir.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTempoPenaACumprir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTempoPenaACumprir.setEnabled(false);

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel106.setText("O que sabe sobre a sua situação jurídica:");

        jSituacaoJuridica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSituacaoJuridica.setEnabled(false);

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel107.setText("Data de admissão do Sistema Prisional:");

        jDataEntradaSistemaPenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntradaSistemaPenal.setEnabled(false);

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel108.setText("Reingresso no Sist. Prisional:");

        jComboBoxReintegraSistemaPenal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxReintegraSistemaPenal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxReintegraSistemaPenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxReintegraSistemaPenal.setEnabled(false);

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel109.setText("Tem assistência jurídica?");

        jComboBoxAssistenciaJuridica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAssistenciaJuridica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAssistenciaJuridica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAssistenciaJuridica.setEnabled(false);

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel110.setText("Defensoria Publica:");

        jLabel111.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel111.setText("Outros:");

        jComboBoxDefensorPublico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDefensorPublico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxDefensorPublico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDefensorPublico.setEnabled(false);

        jComboBoxOutroDefensor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOutroDefensor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxOutroDefensor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOutroDefensor.setEnabled(false);

        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel112.setText("Qual?");

        jQualDefensor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jQualDefensor.setEnabled(false);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel28Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel102))
                        .addComponent(jLabel100))
                    .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jDescricaoUnidadePenal, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtPesquisarUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jArtigo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel103))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel28Layout.createSequentialGroup()
                                .addComponent(jMatriculaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel98)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPavilhão)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel99))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel28Layout.createSequentialGroup()
                                .addComponent(jAlcunha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel101)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCela)
                            .addComponent(jRegimePenal)
                            .addComponent(jTempPenaSentenca, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel28Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel105)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTempoPenaACumprir))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel104)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTempoPenaCumprida, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel109)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxAssistenciaJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel108)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxReintegraSistemaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel107, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel106, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jDataEntradaSistemaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSituacaoJuridica))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel110)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxDefensorPublico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jLabel111)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxOutroDefensor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel112)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jQualDefensor)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel96)
                    .addComponent(jDescricaoUnidadePenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarUnidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(jLabel98)
                    .addComponent(jLabel99)
                    .addComponent(jMatriculaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPavilhão, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(jAlcunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101)
                    .addComponent(jRegimePenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(jArtigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103)
                    .addComponent(jTempPenaSentenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel104)
                        .addComponent(jTempoPenaCumprida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jComboBoxAssistenciaJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel109)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel105)
                    .addComponent(jTempoPenaACumprir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel108)
                    .addComponent(jComboBoxReintegraSistemaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel106)
                    .addComponent(jSituacaoJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataEntradaSistemaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(jLabel111)
                    .addComponent(jComboBoxDefensorPublico, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOutroDefensor, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(jQualDefensor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel29.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtAuditoriaCRC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaCRC.setToolTipText("Auditoria");
        jBtAuditoriaCRC.setContentAreaFilled(false);
        jBtAuditoriaCRC.setEnabled(false);
        jBtAuditoriaCRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaCRCActionPerformed(evt);
            }
        });

        jBtNovoCRC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoCRC.setText("Novo");
        jBtNovoCRC.setContentAreaFilled(false);
        jBtNovoCRC.setEnabled(false);
        jBtNovoCRC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoCRC.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoCRC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoCRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoCRCActionPerformed(evt);
            }
        });

        jBtAlterarCRC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarCRC.setText("Alterar");
        jBtAlterarCRC.setContentAreaFilled(false);
        jBtAlterarCRC.setEnabled(false);
        jBtAlterarCRC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarCRC.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarCRC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarCRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarCRCActionPerformed(evt);
            }
        });

        jBtExcluirCRC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirCRC.setText("Excluir");
        jBtExcluirCRC.setContentAreaFilled(false);
        jBtExcluirCRC.setEnabled(false);
        jBtExcluirCRC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirCRC.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirCRC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirCRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirCRCActionPerformed(evt);
            }
        });

        jBtSalvarCRC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarCRC.setText("Gravar");
        jBtSalvarCRC.setContentAreaFilled(false);
        jBtSalvarCRC.setEnabled(false);
        jBtSalvarCRC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarCRC.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarCRC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarCRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarCRCActionPerformed(evt);
            }
        });

        jBtCancelarCRC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarCRC.setText("Cancelar");
        jBtCancelarCRC.setContentAreaFilled(false);
        jBtCancelarCRC.setEnabled(false);
        jBtCancelarCRC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarCRC.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarCRC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarCRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarCRCActionPerformed(evt);
            }
        });

        jBtSairCRC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairCRC.setText("Sair");
        jBtSairCRC.setContentAreaFilled(false);
        jBtSairCRC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairCRC.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairCRC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairCRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairCRCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addComponent(jBtNovoCRC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarCRC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirCRC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarCRC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarCRC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairCRC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaCRC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaCRC))
            .addComponent(jBtNovoCRC)
            .addComponent(jBtAlterarCRC)
            .addComponent(jBtExcluirCRC)
            .addComponent(jBtSalvarCRC)
            .addComponent(jBtCancelarCRC)
            .addComponent(jBtSairCRC)
        );

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EAPI - Estratégia de Acompanhamento Psicossocial Individualizado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel113.setText("PSP - Post de Saíde Penitenciário (Atenção Básica, Saúde Mental)");

        jTextoPSP.setColumns(20);
        jTextoPSP.setRows(5);
        jTextoPSP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoPSP.setEnabled(false);
        jScrollPane4.setViewportView(jTextoPSP);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel113)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jLabel113)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CRCLayout = new javax.swing.GroupLayout(CRC);
        CRC.setLayout(CRCLayout);
        CRCLayout.setHorizontalGroup(
            CRCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CRCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CRCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        CRCLayout.setVerticalGroup(
            CRCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CRCLayout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("CRC/EAPI", CRC);

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "CEDEGEP (Educação, Trabalho, Cultura e Lazer)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 153))); // NOI18N

        jTextoCEDEGEP.setColumns(20);
        jTextoCEDEGEP.setRows(5);
        jTextoCEDEGEP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoCEDEGEP.setEnabled(false);
        jScrollPane5.setViewportView(jTextoCEDEGEP);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jPanel36.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtAuditoriaSS3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaSS3.setToolTipText("Auditoria");
        jBtAuditoriaSS3.setContentAreaFilled(false);
        jBtAuditoriaSS3.setEnabled(false);
        jBtAuditoriaSS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaSS3ActionPerformed(evt);
            }
        });

        jBtNovoSS3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoSS3.setText("Novo");
        jBtNovoSS3.setContentAreaFilled(false);
        jBtNovoSS3.setEnabled(false);
        jBtNovoSS3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoSS3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoSS3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoSS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoSS3ActionPerformed(evt);
            }
        });

        jBtAlterarSS3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarSS3.setText("Alterar");
        jBtAlterarSS3.setContentAreaFilled(false);
        jBtAlterarSS3.setEnabled(false);
        jBtAlterarSS3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarSS3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarSS3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarSS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarSS3ActionPerformed(evt);
            }
        });

        jBtExcluirSS3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirSS3.setText("Excluir");
        jBtExcluirSS3.setContentAreaFilled(false);
        jBtExcluirSS3.setEnabled(false);
        jBtExcluirSS3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirSS3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirSS3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirSS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirSS3ActionPerformed(evt);
            }
        });

        jBtSalvarSS3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarSS3.setText("Gravar");
        jBtSalvarSS3.setContentAreaFilled(false);
        jBtSalvarSS3.setEnabled(false);
        jBtSalvarSS3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarSS3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarSS3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarSS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarSS3ActionPerformed(evt);
            }
        });

        jBtCancelarSS3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarSS3.setText("Cancelar");
        jBtCancelarSS3.setContentAreaFilled(false);
        jBtCancelarSS3.setEnabled(false);
        jBtCancelarSS3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarSS3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarSS3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarSS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarSS3ActionPerformed(evt);
            }
        });

        jBtSairSS3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairSS3.setText("Sair");
        jBtSairSS3.setContentAreaFilled(false);
        jBtSairSS3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairSS3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairSS3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairSS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairSS3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addComponent(jBtNovoSS3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarSS3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirSS3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarSS3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarSS3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairSS3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaSS3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoriaSS3))
            .addComponent(jBtNovoSS3)
            .addComponent(jBtAlterarSS3)
            .addComponent(jBtExcluirSS3)
            .addComponent(jBtSalvarSS3)
            .addComponent(jBtCancelarSS3)
            .addComponent(jBtSairSS3)
        );

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "CRAS e CREAS - Proteção Social(Benefícios, Incentivos às famílias)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jTextoCRASCREAS.setColumns(20);
        jTextoCRASCREAS.setRows(5);
        jTextoCRASCREAS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoCRASCREAS.setEnabled(false);
        jScrollPane6.setViewportView(jTextoCRASCREAS);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Assistência Jurídica(Defensoria Pública, Patronato)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jTextoASSISTENCIA.setColumns(20);
        jTextoASSISTENCIA.setRows(5);
        jTextoASSISTENCIA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoASSISTENCIA.setEnabled(false);
        jScrollPane7.setViewportView(jTextoASSISTENCIA);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Doc. Civil (Posto Pedro Melo, Receita Federal, Vara de Registro Público)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 0, 0))); // NOI18N

        jTextoDOCUMENTOCIVIL.setColumns(20);
        jTextoDOCUMENTOCIVIL.setRows(5);
        jTextoDOCUMENTOCIVIL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoDOCUMENTOCIVIL.setEnabled(false);
        jScrollPane8.setViewportView(jTextoDOCUMENTOCIVIL);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel114.setText("PAI - Programa de Assistência Individualizada (atendimentos, oficinas, grupos,");

        jLabel115.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel115.setText("registros das evoluções e atualizações da Estratégia).");

        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel116.setText("Data de inclusão no Programa PAI:");

        jDataInclusaoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataInclusaoPAI.setEnabled(false);

        jLabel117.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(204, 0, 0));
        jLabel117.setText("Técnicos de Referência:");

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel118.setText("Assistente Social/CRESS:");

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel119.setText("Psicólogo/CRP:");

        jTecnicoServicoSocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTecnicoServicoSocial.setEnabled(false);

        jTecnicoPsicologico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTecnicoPsicologico.setEnabled(false);

        javax.swing.GroupLayout ServicoSocial2Layout = new javax.swing.GroupLayout(ServicoSocial2);
        ServicoSocial2.setLayout(ServicoSocial2Layout);
        ServicoSocial2Layout.setHorizontalGroup(
            ServicoSocial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServicoSocial2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ServicoSocial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ServicoSocial2Layout.createSequentialGroup()
                        .addGroup(ServicoSocial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel114)
                            .addComponent(jLabel115)
                            .addGroup(ServicoSocial2Layout.createSequentialGroup()
                                .addComponent(jLabel116)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataInclusaoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ServicoSocial2Layout.createSequentialGroup()
                        .addGroup(ServicoSocial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel118, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel119, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ServicoSocial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ServicoSocial2Layout.createSequentialGroup()
                                .addComponent(jLabel117)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTecnicoPsicologico)
                            .addComponent(jTecnicoServicoSocial))))
                .addContainerGap())
        );
        ServicoSocial2Layout.setVerticalGroup(
            ServicoSocial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServicoSocial2Layout.createSequentialGroup()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel114)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel115)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ServicoSocial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel116)
                    .addComponent(jDataInclusaoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel117)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ServicoSocial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel118)
                    .addComponent(jTecnicoServicoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ServicoSocial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel119)
                    .addComponent(jTecnicoPsicologico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("S.S.3", ServicoSocial2);

        jTabelaEvolucaoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaEvolucaoPAI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Data", "Evolução"
            }
        ));
        jTabelaEvolucaoPAI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaEvolucaoPAIMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(jTabelaEvolucaoPAI);
        if (jTabelaEvolucaoPAI.getColumnModel().getColumnCount() > 0) {
            jTabelaEvolucaoPAI.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaEvolucaoPAI.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaEvolucaoPAI.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaEvolucaoPAI.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaEvolucaoPAI.getColumnModel().getColumn(2).setMinWidth(350);
            jTabelaEvolucaoPAI.getColumnModel().getColumn(2).setMaxWidth(350);
        }

        jBtCancelarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarEvolucao.setEnabled(false);
        jBtCancelarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarEvolucaoActionPerformed(evt);
            }
        });

        jBtAuditoriaEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaEvolucao.setToolTipText("Auditoria");
        jBtAuditoriaEvolucao.setContentAreaFilled(false);
        jBtAuditoriaEvolucao.setEnabled(false);
        jBtAuditoriaEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaEvolucaoActionPerformed(evt);
            }
        });

        jTextoEvolucao.setColumns(20);
        jTextoEvolucao.setRows(5);
        jTextoEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoEvolucao.setEnabled(false);
        jScrollPane14.setViewportView(jTextoEvolucao);

        jBtNovaEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaEvolucao.setToolTipText("Nova Evolução");
        jBtNovaEvolucao.setEnabled(false);
        jBtNovaEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaEvolucaoActionPerformed(evt);
            }
        });

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Evolução do Acompanhameto PsicoSocial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 51, 204))); // NOI18N

        jLabel137.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel137.setText("Nome Completo do Interno");

        jNomeInternoEvolucaoPAI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoEvolucaoPAI.setEnabled(false);

        jLabel139.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel139.setText("Código");

        jIdEvolucao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdEvolucao.setEnabled(false);

        jLabel140.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel140.setText("Data Evolução");

        jDataEvolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEvolucao.setEnabled(false);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel139)
                    .addComponent(jIdEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel137)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jNomeInternoEvolucaoPAI))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addComponent(jLabel139)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jIdEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel140)
                                .addComponent(jLabel137))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDataEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jNomeInternoEvolucaoPAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtAlterarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jBtAlterarEvolucao.setToolTipText("Alterar Evolução");
        jBtAlterarEvolucao.setEnabled(false);
        jBtAlterarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarEvolucaoActionPerformed(evt);
            }
        });

        jBtExcluirEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirEvolucao.setToolTipText("Excluir Evolução");
        jBtExcluirEvolucao.setEnabled(false);
        jBtExcluirEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirEvolucaoActionPerformed(evt);
            }
        });

        jBtSalvarEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarEvolucao.setToolTipText("Gravar Evolução");
        jBtSalvarEvolucao.setEnabled(false);
        jBtSalvarEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarEvolucaoActionPerformed(evt);
            }
        });

        jBtImpressaoEvolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressaoEvolucao.setToolTipText("Impressão Evolução");
        jBtImpressaoEvolucao.setEnabled(false);
        jBtImpressaoEvolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoEvolucaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addComponent(jScrollPane14)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtNovaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelarEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtImpressaoEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtAuditoriaEvolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoriaEvolucao)
                    .addComponent(jBtCancelarEvolucao)
                    .addComponent(jBtSalvarEvolucao)
                    .addComponent(jBtExcluirEvolucao)
                    .addComponent(jBtAlterarEvolucao)
                    .addComponent(jBtNovaEvolucao)
                    .addComponent(jBtImpressaoEvolucao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 3, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("E-PAI", jPanel1);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jFotoInternoPAI.setToolTipText("Foto do Interno");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoPAI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoPAI, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLogoMarcaAssitenteSocial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLogoMarcaAssitenteSocial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/SERVIÇO_SOCIAL.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLogoMarcaAssitenteSocial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLogoMarcaAssitenteSocial, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );

        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLogoMarcaPsicologia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLogoMarcaPsicologia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/psicologia.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLogoMarcaPsicologia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLogoMarcaPsicologia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel8, jPanel9});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel8, jPanel9});

        setBounds(300, 30, 682, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jCodigoPesqPAI.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um código para pesquisa.");
            jCodigoPesqPAI.requestFocus();
        } else {
            preencherTabelaAtendentimentoPAI("SELECT * FROM PAI_PSICOSOCIAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=PAI_PSICOSOCIAL.IdInternoCrc "
                    + "WHERE IdPai='" + jCodigoPesqPAI.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqCodigoActionPerformed

    private void jCheckBoxTodosRegistrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosRegistrosItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTabelaAtendentimentoPAI("SELECT * FROM PAI_PSICOSOCIAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=PAI_PSICOSOCIAL.IdInternoCrc");
        } else {
            limparTabelaPAISocial();
        }
    }//GEN-LAST:event_jCheckBoxTodosRegistrosItemStateChanged

    private void jBtPesqDataPAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataPAIActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
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
                    preencherTabelaAtendentimentoPAI("SELECT * FROM PAI_PSICOSOCIAL "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=PAI_PSICOSOCIAL.IdInternoCrc "
                            + "WHERE DataPai BETWEEN'" + dataInicial + "'AND '" + dataFinal + "'");
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataPAIActionPerformed

    private void jBtPesqNomeInternoPAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoPAIActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jNomeInternoPesquisa.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisa do registro.");
            jNomeInternoPesquisa.requestFocus();
        } else {
            preencherTabelaAtendentimentoPAI("SELECT * FROM PAI_PSICOSOCIAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=PAI_PSICOSOCIAL.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'" + jNomeInternoPesquisa.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoPAIActionPerformed

    private void jTabelaPAIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPAIMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idAtend = "" + jTabelaPAI.getValueAt(jTabelaPAI.getSelectedRow(), 0);
            jCodigoPesqPAI.setText(idAtend);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(true);
            //
            bloquearCamposManutencao();
            bloquearCampos();
            limparCamposNovo();
            jBtNovoSS.setEnabled(true);
            jBtNovoFamiliar.setEnabled(true);
            jBtNovaVisita.setEnabled(true);
            jBtNovaVisitaIntima.setEnabled(true);
            jBtNovoTO.setEnabled(true);
            jBtNovoPSI.setEnabled(true);
            jBtNovoPM.setEnabled(true);
            jBtNovoCRC.setEnabled(true);
            jBtNovoSS3.setEnabled(true);
            jBtNovaEvolucao.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PAI_PSICOSOCIAL "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=PAI_PSICOSOCIAL.IdInternoCrc "
                        + "INNER JOIN DADOSFISICOSINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN CIDADES "
                        + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                        + "WHERE IdPai='" + idAtend + "'");
                conecta.rs.first();
                jCodigoPAI.setText(String.valueOf(conecta.rs.getInt("IdPai")));
                jComboBoxStatusPAI.setSelectedItem(conecta.rs.getString("StatusPai"));
                jDataPAI.setDate(conecta.rs.getDate("DataPai"));
                jIdInternoPAI.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoPAI.setText(conecta.rs.getString("NomeInternoCrc"));
                jNomeMaeInternoPAI.setText(conecta.rs.getString("MaeInternoCrc"));
                jNomePaiInternoPAI.setText(conecta.rs.getString("PaiInternoCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoPAI.setIcon(i);
                jFotoInternoPAI.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoPAI.getWidth(), jFotoInternoPAI.getHeight(), Image.SCALE_DEFAULT)));
                JRGInternoPAI.setText(conecta.rs.getString("RgInternoCrc"));
                jCPFInternoPAI.setText(conecta.rs.getString("CpfInternoCrc"));
                jCartaoSUSPAI.setText(conecta.rs.getString("CartaoSus"));
                jDataNascimentoPAI.setDate(conecta.rs.getDate("DataNasciCrc"));
                jIdadeInterno.setText(conecta.rs.getString("IdadeInterno"));
                jDataEntradaInternoPAI.setDate(conecta.rs.getDate("DataEntrada"));
                jEstadoCivilInternoPAI.setText(conecta.rs.getString("EstadoCivilCrc"));
                jSexoInternoPAI.setText(conecta.rs.getString("SexoCrc"));
                jOrientacaoSexual.setText(conecta.rs.getString("OrientacaoSexual"));
                jNaturalidadeInternoPAI.setText(conecta.rs.getString("NomeCidade"));
                jCorEtiniaInternoPAI.setText(conecta.rs.getString("Cutis"));
                jEnderecoResidencial.setText(conecta.rs.getString("DadosPessoais"));
                //
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados..." + e);
            }
            // S.S.1
            try {
                conecta.executaSQL("SELECT * FROM SOCIAL1_PAI_PSICOSOCIAL "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON SOCIAL1_PAI_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "WHERE SOCIAL1_PAI_PSICOSOCIAL.IdPai='" + idAtend + "'");
                conecta.rs.first();
                codigoSS1 = conecta.rs.getInt("IdPaiSS1");
                jComboBoxRegulaDocumento.setSelectedItem(conecta.rs.getString("DocumentoCivil"));
                jComboBoxCertidaoNasc.setSelectedItem(conecta.rs.getString("CNascimento"));
                jComboBoxRG.setSelectedItem(conecta.rs.getString("RG"));
                jComboBoxCPF.setSelectedItem(conecta.rs.getString("CPF"));
                jComboBoxCTPS.setSelectedItem(conecta.rs.getString("CTPS"));
                jOutrosDocumentos.setText(conecta.rs.getString("OutrosDoc"));
                jQuantosFilhosMaiores21.setText(conecta.rs.getString("QtdFilhosMaior"));
                jComboBoxFilhosSemRegistros.setSelectedItem(conecta.rs.getString("FilhosSemRegistros"));
                jQuantosFilhosSemRegistros.setText(conecta.rs.getString("QtdFilhosSemRegistro"));
                jQuantosFilhosMenores21.setText(conecta.rs.getString("QtdFilhosMenor"));
                jObservacaoFilhos.setText(conecta.rs.getString("ObservacaoFilhos"));
                jComboBoxVulnerabilidadeSocial.setSelectedItem(conecta.rs.getString("VulnerabilidaSocial"));
                jComboBoxAtendeCondiPrevistas.setSelectedItem(conecta.rs.getString("AtendePrevistas"));
                jComboBoxProgramaSocial.setSelectedItem(conecta.rs.getString("InseriProgramaSocial"));
                jQualProgramaSocial.setText(conecta.rs.getString("QualProgramaSocial"));
                cumpimentoFamiliaPena = conecta.rs.getInt("PartFamiliaCumpre");
                if (cumpimentoFamiliaPena == 0) {
                    jRadioButtonNula.setSelected(true);
                } else if (cumpimentoFamiliaPena == 1) {
                    jRadioButtonInsuficiente.setSelected(true);
                } else if (cumpimentoFamiliaPena == 2) {
                    jRadioButtonRazoavel.setSelected(true);
                } else if (cumpimentoFamiliaPena == 3) {
                    jRadioButtonMuitoBoa.setSelected(true);
                }
                jComboBoxIntervencaoPrograma.setSelectedItem(conecta.rs.getString("IntervencaoPrograma"));
                jComboBoxLocalizacaoFamiliares.setSelectedItem(conecta.rs.getString("LocalizacaoFamiliares"));
                jObservacaoParticipacaoFamilia.setText(conecta.rs.getString("ObservacaoParticipacaoFamilia"));
                if (codigoSS1 != 0) {
                    jBtNovoSS.setEnabled(true);
                    jBtAlterarSS.setEnabled(true);
                    jBtExcluirSS.setEnabled(true);
                    jBtSalvarSS.setEnabled(!true);
                    jBtCancelarSS.setEnabled(!true);
                    jBtAuditoriaSS.setEnabled(true);
                }
            } catch (Exception e) {
            }
            preencherTabelaFamiliar("SELECT * FROM SOCIAL2_PAI_PSICOSOCIAL "
                    + "INNER JOIN PAI_PSICOSOCIAL "
                    + "ON SOCIAL2_PAI_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                    + "WHERE SOCIAL2_PAI_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
            //
            preencherTabelaVisitas("SELECT * FROM SOCIAL2_FAMILIAR_PSICOSOCIAL "
                    + "INNER JOIN PAI_PSICOSOCIAL "
                    + "ON SOCIAL2_FAMILIAR_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON SOCIAL2_FAMILIAR_PSICOSOCIAL.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE SOCIAL2_FAMILIAR_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
            preencherTabelaVisitasIntimas("SELECT * FROM SOCIAL2_VISITA_INTIMA_PSICOSOCIAL "
                    + "INNER JOIN PAI_PSICOSOCIAL "
                    + "ON SOCIAL2_VISITA_INTIMA_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON SOCIAL2_VISITA_INTIMA_PSICOSOCIAL.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE SOCIAL2_VISITA_INTIMA_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
            // TO/Ped
            try {
                conecta.abrirConexao();
                conecta.executaSQL("SELECT * FROM TERAPIA_PEDAGOGIA_PSICOSOCIAL "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON TERAPIA_PEDAGOGIA_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "WHERE TERAPIA_PEDAGOGIA_PSICOSOCIAL.IdPai='" + idAtend + "'");
                conecta.rs.first();
                codTeraPed = conecta.rs.getInt("IdToPed");
                jEscolaridadeInternoPAI.setText(conecta.rs.getString("Escolaridade"));
                jComboBoxDemandaEscolar.setSelectedItem(conecta.rs.getString("DemandaEscolar"));
                jComboBoxFrequentaEscola.setSelectedItem(conecta.rs.getString("FrequnetaEscola"));
                jQualEscola.setText(conecta.rs.getString("QualEscola"));
                codInstrucao = conecta.rs.getInt("Instrucao");
                if (codInstrucao == 0) {
                    jRadioButtonAnalfabeto.setSelected(true);
                } else if (codInstrucao == 1) {
                    jRadioButtonFundamental1.setSelected(true);
                } else if (codInstrucao == 2) {
                    jRadioButtonFundamental2.setSelected(true);
                } else if (codInstrucao == 3) {
                    jRadioButtonSuperiorIncompleto.setSelected(true);
                } else if (codInstrucao == 4) {
                    jRadioButtonSuperiorCompleto.setSelected(true);
                }
                jObservacaoEstudos.setText(conecta.rs.getString("ObservacaoTOPED"));
                jProfissaoInternoPAI.setText(conecta.rs.getString("Profissao"));
                jComboBoxParticipaAtividadeLab.setSelectedItem(conecta.rs.getString("ParticipaLabor"));
                jQualAtividadeLab.setText(conecta.rs.getString("QualLabor"));
                jObservacaoLaborativa.setText(conecta.rs.getString("ObservacaoLabor"));
                jComboBoxDemandaQualiProf.setSelectedItem(conecta.rs.getString("DemandaQualiProf"));
                jQualQualificacaoProf.setText(conecta.rs.getString("QualDemanda"));
                jComboBoxExperienciaTrab.setSelectedItem(conecta.rs.getString("ExperienciaTrabRenda"));
                jQualExperiencia.setText(conecta.rs.getString("QualExperiencia"));
                jHabilidades.setText(conecta.rs.getString("Habilidades"));
                jComboBoxPartAtivEsporte.setSelectedItem(conecta.rs.getString("ParticipaAtividade"));
                jQualAtividadeEsporte.setText(conecta.rs.getString("QuaisAtividades"));
                jComboBoxDemandaEsporte.setSelectedItem(conecta.rs.getString("DemandaParticaCultura"));
                jComboBoxEsporte.setSelectedItem(conecta.rs.getString("Esporte"));
                jQualEsporte.setText(conecta.rs.getString("QualEsporte"));
                jComboBoxLazer.setSelectedItem(conecta.rs.getString("Lazer"));
                jQualLazer.setText(conecta.rs.getString("QualLazer"));
                jComboBoxCultura.setSelectedItem(conecta.rs.getString("Cultura"));
                jQualCultura.setText(conecta.rs.getString("QualCultura"));
                if (codTeraPed != 0) {
                    jBtNovoTO.setEnabled(true);
                    jBtAlterarTO.setEnabled(true);
                    jBtExcluirTO.setEnabled(true);
                    jBtSalvarTO.setEnabled(!true);
                    jBtCancelarTO.setEnabled(!true);
                    jBtAuditoriaTO.setEnabled(true);
                }
            } catch (Exception e) {
            }
            // PSI          
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PSICOLOGIA_PAI_PSICOSOCIAL "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON PSICOLOGIA_PAI_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "WHERE PSICOLOGIA_PAI_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
                conecta.rs.first();
                codigoPSI = conecta.rs.getInt("IdPsiPai");
                jComboBoxTranstornoMental.setSelectedItem(conecta.rs.getString("TranstornoMental"));
                jComboBoxTratamentoAnterior.setSelectedItem(conecta.rs.getString("TratamentoAnterior"));
                jComboBoxQuaisTratamentosMentais.setSelectedItem(conecta.rs.getString("QuaisTratamentosMentais"));
                jOutrosTratamento.setText(conecta.rs.getString("OutrosTratamento"));
                jComboBoxFoiInternado.setSelectedItem(conecta.rs.getString("FoiInternado"));
                jEspecificarFrequenciasLocais.setText(conecta.rs.getString("EspecificarFrequenciasLocais"));
                jMedicacoesUtilizadas.setText(conecta.rs.getString("MedicacoesUtilizadas"));
                jComboBoxEpisodioDepressivo.setSelectedItem(conecta.rs.getString("EpisodioDepressivo"));
                jComboBoxSurtoPsicotico.setSelectedItem(conecta.rs.getString("SurtoPsicotico"));
                jComboBoxTentativaSuicidio.setSelectedItem(conecta.rs.getString("TentativaSuicidio"));
                jComboBoxComportamentoViolento.setSelectedItem(conecta.rs.getString("ComportamentoViolento"));
                jComboBoxEnvolveJustica.setSelectedItem(conecta.rs.getString("EnvolveJustica"));
                jComboBoxUsoMedicaPsiquia.setSelectedItem(conecta.rs.getString("UsoMedicaPsiquia"));
                jObservacaoDepressivo.setText(conecta.rs.getString("ObservacaoDepressivo"));
                jObservacaoSurto.setText(conecta.rs.getString("ObservacaoSurto"));
                jObservacaoTentativaSuicidio.setText(conecta.rs.getString("ObservacaoTentativaSuicidio"));
                jObservacaoComportamentoViolento.setText(conecta.rs.getString("ObservacaoComportamentoViolento"));
                jObservacaoEnvolveJustica.setText(conecta.rs.getString("ObservacaoEnvolveJustica"));
                jObservacaoUsoMedicacoPsiquiatrica.setText(conecta.rs.getString("ObservacaoUsoMedicacoPsiquiatrica"));
                if (codigoPSI != 0) {
                    jBtNovoPSI.setEnabled(true);
                    jBtAlterarPSI.setEnabled(true);
                    jBtExcluirPSI.setEnabled(true);
                    jBtSalvarPSI.setEnabled(!true);
                    jBtCancelarPSI.setEnabled(!true);
                    jBtAuditoriaPSI.setEnabled(true);
                }
            } catch (Exception e) {
            }
            // P.M.          
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "WHERE PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
                conecta.rs.first();
                codigoPM = conecta.rs.getInt("IdPsiMed");
                jComboBoxFamiliaTranstornoMental.setSelectedItem(conecta.rs.getString("FamiliaTranstornoMental"));
                jQuemTranstornoMental.setText(conecta.rs.getString("QuemTranstornoMental"));
                jQualTranstornoMental.setText(conecta.rs.getString("QualTranstornoMental"));
                jComboBoxNecessidadePSI.setSelectedItem(conecta.rs.getString("NecessidadePSI"));
                //
                consultaPSI = conecta.rs.getInt("ConsultaPSI");
                if (consultaPSI == 0) {
                    jCheckBoxConsultaPSI.setSelected(true);
                } else if (consultaPSI == 1) {
                    jCheckBoxConsultaPSI.setSelected(!true);
                }
                acompanhaPSI = conecta.rs.getInt("AcompanhaPSI");
                if (acompanhaPSI == 0) {
                    jCheckBoxAcompanhaPSI.setSelected(true);
                } else if (acompanhaPSI == 1) {
                    jCheckBoxAcompanhaPSI.setSelected(!true);
                }
                jComboBoxFazUsoDroga.setSelectedItem(conecta.rs.getString("FazUsoDroga"));
                jQuaisDrogas.setText(conecta.rs.getString("QuaisDrogas"));
                jComboBoxCompartilhaDrogas.setSelectedItem(conecta.rs.getString("CompartilhaDrogas"));
                jComboBoxReducaoDanos.setSelectedItem(conecta.rs.getString("ReducaoDanos"));
                jPorqueReduzDanos.setText(conecta.rs.getString("PorqueReduzDanos"));
                jComboBoxAceitaProgramasDanos.setSelectedItem(conecta.rs.getString("AceitaProgramasDanos"));
                jPorqueAceitaProgroReduDanos.setText(conecta.rs.getString("PorqueAceitaProgroReduDanos"));
                jComboBoxQueixaProbSaude.setSelectedItem(conecta.rs.getString("QueixaProbSaude"));
                //
                hipertensao = conecta.rs.getInt("Hipertensao");
                if (hipertensao == 0) {
                    jCheckBoxHipertensao.setSelected(true);
                } else if (hipertensao == 1) {
                    jCheckBoxHipertensao.setSelected(!true);
                }
                diabetes = conecta.rs.getInt("Diabetes");
                if (diabetes == 0) {
                    jCheckBoxDiabetes.setSelected(true);
                } else if (diabetes == 1) {
                    jCheckBoxDiabetes.setSelected(!true);
                }
                tuberculose = conecta.rs.getInt("Tuberculose");
                if (tuberculose == 0) {
                    jCheckBoxTuberculose.setSelected(true);
                } else if (tuberculose == 1) {
                    jCheckBoxTuberculose.setSelected(!true);
                }
                dst = conecta.rs.getInt("DST");
                if (dst == 0) {
                    jCheckBoxDST.setSelected(true);
                } else if (dst == 1) {
                    jCheckBoxDST.setSelected(!true);
                }
                hepatite = conecta.rs.getInt("Hepatite");
                if (hepatite == 0) {
                    jCheckBoxHepatite.setSelected(true);
                } else if (hepatite == 1) {
                    jCheckBoxHepatite.setSelected(!true);
                }
                hanseniase = conecta.rs.getInt("Hanseniase");
                if (hanseniase == 0) {
                    jCheckBoxHanseniase.setSelected(true);
                } else if (hanseniase == 1) {
                    jCheckBoxHanseniase.setSelected(!true);
                }
                outrasDoencas = conecta.rs.getInt("OutrasDoencas");
                if (outrasDoencas == 0) {
                    jCheckBoxOutrasDoencas.setSelected(true);
                } else if (outrasDoencas == 1) {
                    jCheckBoxOutrasDoencas.setSelected(!true);
                }
                jQuaisOutrasDoencas.setText(conecta.rs.getString("QuaisOutrasDoencas"));
                jComboBoxProblemasSaudeBucal.setSelectedItem(conecta.rs.getString("ProblemasSaudeBucal"));
                jComboBoxFazTratamentoBucal.setSelectedItem(conecta.rs.getString("FazTratamentoBucal"));
                jQuaisTratamentoBucal.setText(conecta.rs.getString("QuaisTratamentoBucal"));
                if (codigoPM != 0) {
                    jBtNovoPM.setEnabled(true);
                    jBtAlterarPM.setEnabled(true);
                    jBtExcluirPM.setEnabled(true);
                    jBtSalvarPM.setEnabled(!true);
                    jBtCancelarPM.setEnabled(!true);
                    jBtAuditoriaPM.setEnabled(true);
                }
            } catch (Exception e) {
            }
            //EAPI/CRC
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EAPI_CRC_PAI_PSICOSOCIAL "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON EAPI_CRC_PAI_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "INNER JOIN UNIDADE "
                        + "ON EAPI_CRC_PAI_PSICOSOCIAL.IdUnid=UNIDADE.IdUnid "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON EAPI_CRC_PAI_PSICOSOCIAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "JOIN ITENSLOCACAOINTERNO "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                        + "INNER JOIN CELAS "
                        + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                        + "INNER JOIN PAVILHAO "
                        + "ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "WHERE EAPI_CRC_PAI_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
                conecta.rs.first();
                codigoEAPI = conecta.rs.getInt("IdEapi");
                jDescricaoUnidadePenal.setText(conecta.rs.getString("DescricaoUnid"));
                jMatriculaPenal.setText(conecta.rs.getString("MatriculaCrc"));
                jPavilhão.setText(conecta.rs.getString("DescricaoPav"));
                jCela.setText(conecta.rs.getString("EndCelaPav"));
                jAlcunha.setText(conecta.rs.getString("AlcunhaCrc"));
                jRegimePenal.setText(conecta.rs.getString("Regime"));
                jArtigo.setText(conecta.rs.getString("Artigo1"));
                jTempPenaSentenca.setText(conecta.rs.getString("TempPenaSentenca"));
                jTempoPenaCumprida.setText(conecta.rs.getString("TempoPenaCumprida"));
                jComboBoxAssistenciaJuridica.setSelectedItem(conecta.rs.getString("AssistenciaJuridica"));
                jTempoPenaACumprir.setText(conecta.rs.getString("TempoPenaACumprir"));
                jComboBoxReintegraSistemaPenal.setSelectedItem(conecta.rs.getString("ReintegraSistemaPenal"));
                jSituacaoJuridica.setText(conecta.rs.getString("SituacaoJuridica"));
                jDataEntradaSistemaPenal.setDate(conecta.rs.getDate("DataEntradaSistemaPenal"));
                jComboBoxDefensorPublico.setSelectedItem(conecta.rs.getString("DefensorPublico"));
                jComboBoxOutroDefensor.setSelectedItem(conecta.rs.getString("OutroDefensor"));
                jQualDefensor.setText(conecta.rs.getString("QualDefensor"));
                jTextoPSP.setText(conecta.rs.getString("TextoPSP"));
                if (codigoEAPI != 0) {
                    jBtNovoCRC.setEnabled(true);
                    jBtAlterarCRC.setEnabled(true);
                    jBtExcluirCRC.setEnabled(true);
                    jBtSalvarCRC.setEnabled(!true);
                    jBtCancelarCRC.setEnabled(!true);
                    jBtAuditoriaCRC.setEnabled(true);
                }
            } catch (Exception e) {
            }
            //SS3
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM SS3_PAI_PSICOSOCIAL "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON SS3_PAI_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "WHERE SS3_PAI_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
                conecta.rs.first();
                codigoSS3 = conecta.rs.getInt("IdSS3");
                jTextoCEDEGEP.setText(conecta.rs.getString("TextoCEDEGEP"));
                jTextoCRASCREAS.setText(conecta.rs.getString("TextoCRASCREAS"));
                jTextoASSISTENCIA.setText(conecta.rs.getString("TextoASSISTENCIA"));
                jTextoDOCUMENTOCIVIL.setText(conecta.rs.getString("TextoDOCUMENTOCIVIL"));
                jDataInclusaoPAI.setDate(conecta.rs.getDate("DataInclusaoPAI"));
                jTecnicoServicoSocial.setText(conecta.rs.getString("TecnicoServicoSocial"));
                jTecnicoPsicologico.setText(conecta.rs.getString("TecnicoPsicologico"));
                if (codigoSS3 != 0) {
                    jBtNovoSS3.setEnabled(true);
                    jBtAlterarSS3.setEnabled(true);
                    jBtExcluirSS3.setEnabled(true);
                    jBtSalvarSS3.setEnabled(!true);
                    jBtCancelarSS3.setEnabled(!true);
                    jBtAuditoriaSS3.setEnabled(true);
                }
            } catch (Exception e) {
            }
            // EVOLUÇÃO PAI                           
            preencherTabelaEvolucao("SELECT * FROM EVOLUCAO_PAI "
                    + "INNER JOIN PAI_PSICOSOCIAL "
                    + "ON EVOLUCAO_PAI.IdPai=PAI_PSICOSOCIAL.IdPai "
                    + "WHERE EVOLUCAO_PAI.IdPai='" + jCodigoPAI.getText() + "'");
        }
        conecta.desconecta();
    }//GEN-LAST:event_jTabelaPAIMouseClicked

    private void jBtPesquisarInternoPAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternoPAIActionPerformed
        // TODO add your handling code here:
        TelaPesqInternoPAIPsicologia objPesqInternoPAI = new TelaPesqInternoPAIPsicologia();
        TelaModuloPsicologia.jPainelPsicologia.add(objPesqInternoPAI);
        objPesqInternoPAI.show();
    }//GEN-LAST:event_jBtPesquisarInternoPAIActionPerformed

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        acao = 1;
        Novo();
        limparCamposNovo();
        bloquearCampos();
        limparTabelaFamiliar();
        limparTabelaVisitas();
        limparTabelaVisitasIntimas();
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        acao = 2;
        Alterar();
        bloquearCampos();
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        verificarCodigoPAI();
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        if (jCodigoPAI.getText().equals(idPaiSS1)
                || jCodigoPAI.getText().equals(idPaiSS2)
                || jCodigoPAI.getText().equals(idPaiSS2f)
                || jCodigoPAI.getText().equals(idPaiSS2v)
                || jCodigoPAI.getText().equals(idPaiSS2vi)
                || jCodigoPAI.getText().equals(idPaiTera)
                || jCodigoPAI.getText().equals(idPaiPsico)
                || jCodigoPAI.getText().equals(idPaiPsicoMed)
                || jCodigoPAI.getText().equals(idPaiEapi)
                || jCodigoPAI.getText().equals(idPaiSS3)) {
            JOptionPane.showMessageDialog(null, "Esse registro não poderá ser excluído, existem outros registros relacionados.");
        } else {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objPaiPsico.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
                control.excluirPAI(objPaiPsico);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                Excluir();
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
            }
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        verificarExistenciaInternoPAI();
        if (jDataPAI.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data de Cadastro do P.A.I.");
        } else if (jIdInternoPAI.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
        } else if (jNomeInternoPAI.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno.");
        } else {
            objPaiPsico.setStatusPai((String) jComboBoxStatusPAI.getSelectedItem());
            objPaiPsico.setDataPai(jDataPAI.getDate());
            objPaiPsico.setNomeInternoCrc(jNomeInternoPAI.getText());
            objPaiPsico.setIdadeInterno(Integer.valueOf(jIdadeInterno.getText()));
            objPaiPsico.setOrientacaoSexual(jOrientacaoSexual.getText());
            objPaiPsico.setDadosPessoais(jEnderecoResidencial.getText());
            if (acao == 1) {
                if (jIdInternoPAI.getText().equals(codigoInternoPAI) && jNomeMaeInternoPAI.getText().equals(nomeMaeInterno)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse interno já foi incluído no P.A.I.");
                } else {
                    objPaiPsico.setUsuarioInsert(nameUser);
                    objPaiPsico.setDataInsert(dataModFinal);
                    objPaiPsico.setHorarioInsert(horaMov);
                    control.incluirPAI(objPaiPsico);
                    buscarCodigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    Salvar();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
            if (acao == 2) {
                objPaiPsico.setUsuarioUp(nameUser);
                objPaiPsico.setDataUp(dataModFinal);
                objPaiPsico.setHorarioUp(horaMov);
                objPaiPsico.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
                control.alterarPAI(objPaiPsico);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                Salvar();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
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

    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jBtNovoSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoSSActionPerformed
        // TODO add your handling code here:
        acao = 3;
        bloquearCampos();
        NovoSS();
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtNovoSSActionPerformed

    private void jBtAlterarSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarSSActionPerformed
        // TODO add your handling code here:
        acao = 4;
        bloquearCampos();
        AlterarSS();
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtAlterarSSActionPerformed

    private void jBtExcluirSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirSSActionPerformed
        // TODO add your handling code here:
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objSocial1Pai.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
            controle.excluirSocial1Psicosocial(objSocial1Pai);
            objLog1();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            bloquearCampos();
            ExcluirSS();
            JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
        }
    }//GEN-LAST:event_jBtExcluirSSActionPerformed

    private void jBtSalvarSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarSSActionPerformed
        // TODO add your handling code here:
        verificarSS1(); // VERIFICAR SE JÁ EXISTE UM REGISTRO CADASTRADO PARA O INTERNO.(SOMENTE PODERÁ EXISTIR UM POR INTERNO)
        objSocial1Pai.setDocumentoCivil((String) jComboBoxRegulaDocumento.getSelectedItem());
        objSocial1Pai.setcNascimento((String) jComboBoxCertidaoNasc.getSelectedItem());
        objSocial1Pai.setrG((String) jComboBoxRG.getSelectedItem());
        objSocial1Pai.setcPF((String) jComboBoxCPF.getSelectedItem());
        objSocial1Pai.setcTPS((String) jComboBoxCTPS.getSelectedItem());
        objSocial1Pai.setOutrosDoc(jOutrosDocumentos.getText());
        objSocial1Pai.setQtdFilhosMaior(Integer.valueOf(jQuantosFilhosMaiores21.getText()));
        objSocial1Pai.setFilhosSemRegistros((String) jComboBoxFilhosSemRegistros.getSelectedItem());
        objSocial1Pai.setQtdFilhosSemRegistro(Integer.valueOf(jQuantosFilhosSemRegistros.getText()));
        objSocial1Pai.setQtdFilhosMenor(Integer.valueOf(jQuantosFilhosMenores21.getText()));
        objSocial1Pai.setObservacaoFilhos(jObservacaoFilhos.getText());
        objSocial1Pai.setVulnerabilidaSocial((String) jComboBoxVulnerabilidadeSocial.getSelectedItem());
        objSocial1Pai.setAtendePrevistas((String) jComboBoxAtendeCondiPrevistas.getSelectedItem());
        objSocial1Pai.setInseriProgramaSocial((String) jComboBoxProgramaSocial.getSelectedItem());
        objSocial1Pai.setQualProgramaSocial(jQualProgramaSocial.getText());
        if (jRadioButtonNula.isSelected()) {
            cumpimentoFamiliaPena = 0;
        } else if (jRadioButtonInsuficiente.isSelected()) {
            cumpimentoFamiliaPena = 1;
        } else if (jRadioButtonRazoavel.isSelected()) {
            cumpimentoFamiliaPena = 2;
        } else if (jRadioButtonMuitoBoa.isSelected()) {
            cumpimentoFamiliaPena = 3;
        }
        objSocial1Pai.setPartFamiliaCumpre(cumpimentoFamiliaPena);
        objSocial1Pai.setIntervencaoPrograma((String) jComboBoxIntervencaoPrograma.getSelectedItem());
        objSocial1Pai.setLocalizacaoFamiliares((String) jComboBoxLocalizacaoFamiliares.getSelectedItem());
        objSocial1Pai.setObservacaoParticipacaoFamilia(jObservacaoParticipacaoFamilia.getText());
        objSocial1Pai.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
        objSocial1Pai.setNomeInternoCrc(jNomeInternoPAI.getText());
        if (acao == 3) {
            if (jCodigoPAI.getText().equals(codigoPaiSS1) && jIdInternoPAI.getText().equals(codigoInternoSS1)) {
                JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
            } else {
                objSocial1Pai.setUsuarioInsert(nameUser);
                objSocial1Pai.setDataInsert(dataModFinal);
                objSocial1Pai.setHorarioInsert(horaMov);
                controle.incluirSocial1Psicosocial(objSocial1Pai);
                objLog1();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarSS();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
        }
        if (acao == 4) {
            objSocial1Pai.setUsuarioUp(nameUser);
            objSocial1Pai.setDataUp(dataModFinal);
            objSocial1Pai.setHorarioUp(horaMov);
            objSocial1Pai.setIdPaiSS1(codigoSS1);
            controle.alterarSocial1Psicosocial(objSocial1Pai);
            objLog1();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            SalvarSS();
            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
        }
    }//GEN-LAST:event_jBtSalvarSSActionPerformed

    private void jBtCancelarSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarSSActionPerformed
        // TODO add your handling code here:
        CancelarSS();
    }//GEN-LAST:event_jBtCancelarSSActionPerformed

    private void jBtSairSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairSSActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairSSActionPerformed

    private void jBtAuditoriaSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaSSActionPerformed

    private void jBtNovoFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoFamiliarActionPerformed
        // TODO add your handling code here:
        acao = 5;
        bloquearCampos();
        NovoFamiliar();
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtNovoFamiliarActionPerformed

    private void jBtAlterarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarFamiliarActionPerformed
        // TODO add your handling code here:
        acao = 6;
        bloquearCampos();
        AlterarFamiliar();
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtAlterarFamiliarActionPerformed

    private void jBtExcluirFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirFamiliarActionPerformed
        // TODO add your handling code here:
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        bloquearCampos();
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objSocial2Pai.setIdFamiliar(Integer.parseInt(jIdFamiliarPAI.getText()));
            controle2.excluirSocial2PsicoSocial(objSocial2Pai);
            objLog2();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            preencherTabelaFamiliar("SELECT * FROM SOCIAL2_PAI_PSICOSOCIAL "
                    + "INNER JOIN PAI_PSICOSOCIAL "
                    + "ON SOCIAL2_PAI_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                    + "WHERE SOCIAL2_PAI_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
            ExcluirFamiliar();
            JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
        }
    }//GEN-LAST:event_jBtExcluirFamiliarActionPerformed

    private void jBtSalvarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarFamiliarActionPerformed
        // TODO add your handling code here:
        if (jNomeFamiliarPAI.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do familiar para cadastrar.");
        } else {
            objSocial2Pai.setNomeFamiliar(jNomeFamiliarPAI.getText());
            objSocial2Pai.setIdade(Integer.valueOf(jIdadeFamiliarPAI.getText()));
            objSocial2Pai.setVinculo((String) jComboBoxVinculoPAI.getSelectedItem());
            objSocial2Pai.setOcupacao(jOcupacaoFamiliarPAI.getText());
            objSocial2Pai.setEnderecoTelefonePAI(jEnderecoTelefonePAI.getText());
            objSocial2Pai.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
            objSocial2Pai.setNomeInternoCrc(jNomeInternoPAI.getText());
            if (acao == 5) {
                objSocial2Pai.setUsuarioInsert(nameUser);
                objSocial2Pai.setDataInsert(dataModFinal);
                objSocial2Pai.setHorarioInsert(horaMov);
                //
                controle2.incluirSocial2PsicoSocial(objSocial2Pai);
                buscarCodigoFamiliar();
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                preencherTabelaFamiliar("SELECT * FROM SOCIAL2_PAI_PSICOSOCIAL "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON SOCIAL2_PAI_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "WHERE SOCIAL2_PAI_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
                SalvarFamiliar();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
            if (acao == 6) {
                objSocial2Pai.setUsuarioUp(nameUser);
                objSocial2Pai.setDataUp(dataModFinal);
                objSocial2Pai.setHorarioUp(horaMov);
                //
                objSocial2Pai.setIdFamiliar(Integer.valueOf(jIdFamiliarPAI.getText()));
                controle2.alterarSocial2PsicoSocial(objSocial2Pai);
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                preencherTabelaFamiliar("SELECT * FROM SOCIAL2_PAI_PSICOSOCIAL "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON SOCIAL2_PAI_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "WHERE SOCIAL2_PAI_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
                SalvarFamiliar();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
        }

    }//GEN-LAST:event_jBtSalvarFamiliarActionPerformed

    private void jBtCancelarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarFamiliarActionPerformed
        // TODO add your handling code here:
        CancelarFamiliar();
    }//GEN-LAST:event_jBtCancelarFamiliarActionPerformed

    private void jBtAuditoriaFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaFamiliarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaFamiliarActionPerformed

    private void jTabelaFamiliarPAIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaFamiliarPAIMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idFamilia = "" + jTabelaFamiliarPAI.getValueAt(jTabelaFamiliarPAI.getSelectedRow(), 0);
            jIdFamiliarPAI.setText(idFamilia);
            //
            bloquearCampos();
            //
            jBtNovoFamiliar.setEnabled(!true);
            jBtAlterarFamiliar.setEnabled(true);
            jBtExcluirFamiliar.setEnabled(true);
            jBtSalvarFamiliar.setEnabled(!true);
            jBtCancelarFamiliar.setEnabled(true);
            jBtAuditoriaFamiliar.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM SOCIAL2_PAI_PSICOSOCIAL "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON SOCIAL2_PAI_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "WHERE SOCIAL2_PAI_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "' "
                        + "AND IdFamiliar='" + idFamilia + "'");
                conecta.rs.first();
                jIdFamiliarPAI.setText(conecta.rs.getString("IdFamiliar"));
                jNomeFamiliarPAI.setText(conecta.rs.getString("NomeFamiliar"));
                jIdadeFamiliarPAI.setText(conecta.rs.getString("Idade"));
                jComboBoxVinculoPAI.setSelectedItem(conecta.rs.getString("Vinculo"));
                jOcupacaoFamiliarPAI.setText(conecta.rs.getString("Ocupacao"));
                jEnderecoTelefonePAI.setText(conecta.rs.getString("Endereco"));
            } catch (Exception e) {
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaFamiliarPAIMouseClicked

    private void jBtNovaVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaVisitaActionPerformed
        // TODO add your handling code here:
        acao = 7;
        bloquearCampos();
        NovaVisita();
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtNovaVisitaActionPerformed

    private void jBtAlterarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarVisitaActionPerformed
        // TODO add your handling code here:
        acao = 8;
        bloquearCampos();
        AlterarVisita();
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtAlterarVisitaActionPerformed

    private void jBtExcluirVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirVisitaActionPerformed
        // TODO add your handling code here:               
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        bloquearCampos();
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objSocial2Vista.setIdSol2Visita(idSol2Visita);
            controlVisita.excluirVisitaPsicoSocial(objSocial2Vista);
            objLog3();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            preencherTabelaVisitas("SELECT * FROM SOCIAL2_FAMILIAR_PSICOSOCIAL "
                    + "INNER JOIN PAI_PSICOSOCIAL "
                    + "ON SOCIAL2_FAMILIAR_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON SOCIAL2_FAMILIAR_PSICOSOCIAL.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE SOCIAL2_FAMILIAR_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
            ExcluirVisita();
            JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
        }
    }//GEN-LAST:event_jBtExcluirVisitaActionPerformed

    private void jBtSalvarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarVisitaActionPerformed
        // TODO add your handling code here:
        if (jIdVisitaPAI.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome da visita.");
        } else if (jNomeVisitaPAI.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome da Visita");
        } else if (jIdadeVisita.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe a idade da visita.");
        } else {
            objSocial2Vista.setOcupacao(jOcupacaoVisita.getText());
            objSocial2Vista.setIdade(Integer.valueOf(jIdadeVisita.getText()));
            objSocial2Vista.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
            objSocial2Vista.setNomeVisita(jNomeVisitaPAI.getText());
            objSocial2Vista.setNomeInternoCrc(jNomeInternoPAI.getText());
            if (acao == 7) {
                objSocial2Vista.setUsuarioInsert(nameUser);
                objSocial2Vista.setDataInsert(dataModFinal);
                objSocial2Vista.setHorarioInsert(horaMov);
                controlVisita.incluirVisitaPsicoSocial(objSocial2Vista);
                //
                objLog3();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarVisita();
                preencherTabelaVisitas("SELECT * FROM SOCIAL2_FAMILIAR_PSICOSOCIAL "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON SOCIAL2_FAMILIAR_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON SOCIAL2_FAMILIAR_PSICOSOCIAL.IdVisita=VISITASINTERNO.IdVisita "
                        + "WHERE SOCIAL2_FAMILIAR_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
                JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
            }
            if (acao == 8) {
                objSocial2Vista.setUsuarioUp(nameUser);
                objSocial2Vista.setDataUp(dataModFinal);
                objSocial2Vista.setHorarioUp(horaMov);
                //
                objSocial2Vista.setIdSol2Visita(idSol2Visita);
                controlVisita.alterarVisitaPsicoSocial(objSocial2Vista);
                //
                objLog3();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarVisita();
                preencherTabelaVisitas("SELECT * FROM SOCIAL2_FAMILIAR_PSICOSOCIAL "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON SOCIAL2_FAMILIAR_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON SOCIAL2_FAMILIAR_PSICOSOCIAL.IdVisita=VISITASINTERNO.IdVisita "
                        + "WHERE SOCIAL2_FAMILIAR_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
                JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtSalvarVisitaActionPerformed

    private void jBtCancelarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarVisitaActionPerformed
        // TODO add your handling code here:
        CancelarVisita();
    }//GEN-LAST:event_jBtCancelarVisitaActionPerformed

    private void jBtAuditoriaVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaVisitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaVisitaActionPerformed

    private void jTabelaVisitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaVisitasMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idSolVisita = "" + jTabelaVisitas.getValueAt(jTabelaVisitas.getSelectedRow(), 0);
            jIdVisitaPAI.setText(idSolVisita);
            //
            bloquearCampos();
            //
            jBtNovaVisita.setEnabled(!true);
            jBtAlterarVisita.setEnabled(true);
            jBtExcluirVisita.setEnabled(true);
            jBtSalvarVisita.setEnabled(!true);
            jBtCancelarVisita.setEnabled(true);
            jBtAuditoriaVisita.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM SOCIAL2_FAMILIAR_PSICOSOCIAL "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON SOCIAL2_FAMILIAR_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON SOCIAL2_FAMILIAR_PSICOSOCIAL.IdVisita=VISITASINTERNO.IdVisita "
                        + "WHERE SOCIAL2_FAMILIAR_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "' "
                        + "AND IdSol2Visita='" + idSolVisita + "'");
                conecta.rs.first();
                idSol2Visita = conecta.rs.getInt("IdSol2Visita");
                jIdVisitaPAI.setText(conecta.rs.getString("IdVisita"));
                jNomeVisitaPAI.setText(conecta.rs.getString("NomeVisita"));
                jOcupacaoVisita.setText(conecta.rs.getString("Ocupacao"));
                jParentescoPAI.setText(conecta.rs.getString("ParentescoVisita"));
                jIdadeVisita.setText(conecta.rs.getString("Idade"));
            } catch (Exception e) {
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaVisitasMouseClicked

    private void jBtPesqVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqVisitaActionPerformed
        // TODO add your handling code here:
        TelaPesquisaVisitasPAIPsicologia objPesqVisita = new TelaPesquisaVisitasPAIPsicologia();
        TelaModuloPsicologia.jPainelPsicologia.add(objPesqVisita);
        objPesqVisita.show();
    }//GEN-LAST:event_jBtPesqVisitaActionPerformed

    private void jBtNovaVisitaIntimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaVisitaIntimaActionPerformed
        // TODO add your handling code here:
        acao = 9;
        bloquearCampos();
        NovaVisitaIntima();
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtNovaVisitaIntimaActionPerformed

    private void jBtAlterarVisitaIntimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarVisitaIntimaActionPerformed
        // TODO add your handling code here:
        acao = 10;
        bloquearCampos();
        AlterarVisitaIntima();
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtAlterarVisitaIntimaActionPerformed

    private void jBtExcluirVisitaIntimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirVisitaIntimaActionPerformed
        // TODO add your handling code here:
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        bloquearCampos();
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objSocial2Vista.setIdSol2Visita(idSol2VisitaIntima);
            controlVisitaIntima.excluirVisitaIntimaPsicoSocial(objSocial2Vista);
            objLog4();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            preencherTabelaVisitasIntimas("SELECT * FROM SOCIAL2_VISITA_INTIMA_PSICOSOCIAL "
                    + "INNER JOIN PAI_PSICOSOCIAL "
                    + "ON SOCIAL2_VISITA_INTIMA_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON SOCIAL2_VISITA_INTIMA_PSICOSOCIAL.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE SOCIAL2_VISITA_INTIMA_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
            ExcluirVisitaIntima();
            JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
        }
    }//GEN-LAST:event_jBtExcluirVisitaIntimaActionPerformed

    private void jBtSalvarVisitaIntimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarVisitaIntimaActionPerformed
        // TODO add your handling code here:
        if (jIdVisitaIntima.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome da visita.");
        } else if (jNomeVisitaIntima.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome da Visita");
        } else if (jIdadeVisitaIntima.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe a idade da visita.");
        } else {
            objSocial2Vista.setOcupacao(jOcupacaoVisitaIntima.getText());
            objSocial2Vista.setIdade(Integer.valueOf(jIdadeVisitaIntima.getText()));
            objSocial2Vista.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
            objSocial2Vista.setNomeVisita(jNomeVisitaIntima.getText());
            objSocial2Vista.setNomeInternoCrc(jNomeInternoPAI.getText());
            if (acao == 9) {
                objSocial2Vista.setUsuarioInsert(nameUser);
                objSocial2Vista.setDataInsert(dataModFinal);
                objSocial2Vista.setHorarioInsert(horaMov);
                controlVisitaIntima.incluirVisitaIntimaPsicoSocial(objSocial2Vista);
                //
                objLog4();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarVisitaIntima();
                preencherTabelaVisitasIntimas("SELECT * FROM SOCIAL2_VISITA_INTIMA_PSICOSOCIAL "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON SOCIAL2_VISITA_INTIMA_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON SOCIAL2_VISITA_INTIMA_PSICOSOCIAL.IdVisita=VISITASINTERNO.IdVisita "
                        + "WHERE SOCIAL2_VISITA_INTIMA_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
                JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
            }
            if (acao == 10) {
                objSocial2Vista.setUsuarioUp(nameUser);
                objSocial2Vista.setDataUp(dataModFinal);
                objSocial2Vista.setHorarioUp(horaMov);
                //
                objSocial2Vista.setIdSol2Visita(idSol2VisitaIntima);
                controlVisitaIntima.alterarVisitaIntimaPsicoSocial(objSocial2Vista);
                //
                objLog4();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarVisitaIntima();
                preencherTabelaVisitasIntimas("SELECT * FROM SOCIAL2_VISITA_INTIMA_PSICOSOCIAL "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON SOCIAL2_VISITA_INTIMA_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON SOCIAL2_VISITA_INTIMA_PSICOSOCIAL.IdVisita=VISITASINTERNO.IdVisita "
                        + "WHERE SOCIAL2_VISITA_INTIMA_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
                JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtSalvarVisitaIntimaActionPerformed

    private void jBtCancelarVisitaIntimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarVisitaIntimaActionPerformed
        // TODO add your handling code here:
        CancelarVisitaIntima();
    }//GEN-LAST:event_jBtCancelarVisitaIntimaActionPerformed

    private void jBtAuditoriaVisitaIntimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaVisitaIntimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaVisitaIntimaActionPerformed

    private void jBtPesqVisitaIntimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqVisitaIntimaActionPerformed
        // TODO add your handling code here:
        TelaPesquisaVisitasIntimaPAIPsicologia objPesqVisitaIntima = new TelaPesquisaVisitasIntimaPAIPsicologia();
        TelaModuloPsicologia.jPainelPsicologia.add(objPesqVisitaIntima);
        objPesqVisitaIntima.show();
    }//GEN-LAST:event_jBtPesqVisitaIntimaActionPerformed

    private void jTabelaVisitasIntimasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaVisitasIntimasMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idSolVisita = "" + jTabelaVisitasIntimas.getValueAt(jTabelaVisitasIntimas.getSelectedRow(), 0);
            jIdVisitaIntima.setText(idSolVisita);
            //
            bloquearCampos();
            //
            jBtNovaVisitaIntima.setEnabled(!true);
            jBtAlterarVisitaIntima.setEnabled(true);
            jBtExcluirVisitaIntima.setEnabled(true);
            jBtSalvarVisitaIntima.setEnabled(!true);
            jBtCancelarVisitaIntima.setEnabled(true);
            jBtAuditoriaVisitaIntima.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM SOCIAL2_VISITA_INTIMA_PSICOSOCIAL "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON SOCIAL2_VISITA_INTIMA_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON SOCIAL2_VISITA_INTIMA_PSICOSOCIAL.IdVisita=VISITASINTERNO.IdVisita "
                        + "WHERE SOCIAL2_VISITA_INTIMA_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "' "
                        + "AND IdSol2Visita='" + idSolVisita + "'");
                conecta.rs.first();
                idSol2VisitaIntima = conecta.rs.getInt("IdSol2Visita");
                jIdVisitaIntima.setText(conecta.rs.getString("IdVisita"));
                jNomeVisitaIntima.setText(conecta.rs.getString("NomeVisita"));
                jOcupacaoVisitaIntima.setText(conecta.rs.getString("Ocupacao"));
                jParentescoVisitaIntima.setText(conecta.rs.getString("ParentescoVisita"));
                jIdadeVisitaIntima.setText(conecta.rs.getString("Idade"));
            } catch (Exception e) {
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaVisitasIntimasMouseClicked

    private void jBtNovoTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoTOActionPerformed
        // TODO add your handling code here:
        acao = 11;
        bloquearCampos();
        NovoTOPed();
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtNovoTOActionPerformed

    private void jBtAlterarTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarTOActionPerformed
        // TODO add your handling code here:
        acao = 12;
        bloquearCampos();
        AlterarTOPed();
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtAlterarTOActionPerformed

    private void jBtExcluirTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirTOActionPerformed
        // TODO add your handling code here:                      
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objTeraPed.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
            controlTeraPed.excluirTerapiaPedPsicoSocial(objTeraPed);
            objLog5();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            bloquearCampos();
            ExcluirTOPed();
            JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
        }
    }//GEN-LAST:event_jBtExcluirTOActionPerformed

    private void jBtSalvarTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarTOActionPerformed
        // TODO add your handling code here:
        verificarTOPED();
        objTeraPed.setEscolaridade(jEscolaridadeInternoPAI.getText());
        objTeraPed.setDemandaEscolar((String) jComboBoxDemandaEscolar.getSelectedItem());
        objTeraPed.setFrequnetaEscola((String) jComboBoxFrequentaEscola.getSelectedItem());
        objTeraPed.setQualEscola(jQualEscola.getText());
        //
        if (jRadioButtonAnalfabeto.isSelected()) {
            codInstrucao = 0;
        } else if (jRadioButtonFundamental1.isSelected()) {
            codInstrucao = 1;
        } else if (jRadioButtonFundamental2.isSelected()) {
            codInstrucao = 2;
        } else if (jRadioButtonSuperiorIncompleto.isSelected()) {
            codInstrucao = 3;
        } else if (jRadioButtonSuperiorCompleto.isSelected()) {
            codInstrucao = 4;
        }
        objTeraPed.setInstrucao(codInstrucao);
        objTeraPed.setObservacaoTOPED(jObservacaoEstudos.getText());
        objTeraPed.setProfissao(jProfissaoInternoPAI.getText());
        objTeraPed.setParticipaLabor((String) jComboBoxParticipaAtividadeLab.getSelectedItem());
        objTeraPed.setQualLabor(jQualAtividadeLab.getText());
        objTeraPed.setObservacaoLabor(jObservacaoLaborativa.getText());
        objTeraPed.setDemandaQualiProf((String) jComboBoxDemandaQualiProf.getSelectedItem());
        objTeraPed.setQualDemanda(jQualQualificacaoProf.getText());
        objTeraPed.setExperienciaTrabRenda((String) jComboBoxExperienciaTrab.getSelectedItem());
        objTeraPed.setQualExperiencia(jQualExperiencia.getText());
        objTeraPed.setHabilidades(jHabilidades.getText());
        objTeraPed.setParticipaAtividade((String) jComboBoxPartAtivEsporte.getSelectedItem());
        objTeraPed.setQuaisAtividades(jQualAtividadeEsporte.getText());
        objTeraPed.setDemandaParticaCultura((String) jComboBoxDemandaEsporte.getSelectedItem());
        objTeraPed.setEsporte((String) jComboBoxEsporte.getSelectedItem());
        objTeraPed.setQualEsporte(jQualEsporte.getText());
        objTeraPed.setLazer((String) jComboBoxLazer.getSelectedItem());
        objTeraPed.setQualLazer(jQualLazer.getText());
        objTeraPed.setCultura((String) jComboBoxCultura.getSelectedItem());
        objTeraPed.setQualCultura(jQualCultura.getText());
        objTeraPed.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
        objTeraPed.setNomeInternoCrc(jNomeInternoPAI.getText());
        if (acao == 11) {
            if (jCodigoPAI.getText().equals(codigoPaiTOPED) && jIdInternoPAI.getText().equals(codigoInternoTOPED)) {
                JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
            } else {
                objTeraPed.setUsuarioInsert(nameUser);
                objTeraPed.setDataInsert(dataModFinal);
                objTeraPed.setHorarioInsert(horaMov);
                controlTeraPed.incluirTerapiaPedPsicoSocial(objTeraPed);
                buscarCodTOPED();
                objLog5();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarTOPed();
                JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
            }
        }
        if (acao == 12) {
            objTeraPed.setUsuarioUp(nameUser);
            objTeraPed.setDataUp(dataModFinal);
            objTeraPed.setHorarioUp(horaMov);
            objTeraPed.setIdToPed(codTeraPed);
            controlTeraPed.alterarTerapiaPedPsicoSocial(objTeraPed);
            objLog5();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            SalvarTOPed();
            JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
        }
    }//GEN-LAST:event_jBtSalvarTOActionPerformed

    private void jBtCancelarTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarTOActionPerformed
        // TODO add your handling code here:
        CancelarTOPed();
    }//GEN-LAST:event_jBtCancelarTOActionPerformed

    private void jBtSairTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairTOActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairTOActionPerformed

    private void jBtAuditoriaTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaTOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaTOActionPerformed

    private void jBtNovoPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoPSIActionPerformed
        // TODO add your handling code here:
        acao = 13;
        bloquearCampos();
        NovoPSI();
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtNovoPSIActionPerformed

    private void jBtAlterarPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarPSIActionPerformed
        // TODO add your handling code here:
        acao = 14;
        bloquearCampos();
        AlterarPSI();
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtAlterarPSIActionPerformed

    private void jBtExcluirPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirPSIActionPerformed
        // TODO add your handling code here:                     
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objPsicoPaiSocial.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
            controlPSI.excluirPsicologiaPsicoSocial(objPsicoPaiSocial);
            objLog6();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            bloquearCampos();
            ExcluirPSI();
            JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
        }
    }//GEN-LAST:event_jBtExcluirPSIActionPerformed

    private void jBtSalvarPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarPSIActionPerformed
        // TODO add your handling code here:
        verificarCodigoPSI();
        objPsicoPaiSocial.setTranstornoMental((String) jComboBoxTranstornoMental.getSelectedItem());
        objPsicoPaiSocial.setTratamentoAnterior((String) jComboBoxTratamentoAnterior.getSelectedItem());
        objPsicoPaiSocial.setQuaisTratamentosMentais((String) jComboBoxQuaisTratamentosMentais.getSelectedItem());
        objPsicoPaiSocial.setOutrosTratamento(jOutrosTratamento.getText());
        objPsicoPaiSocial.setFoiInternado((String) jComboBoxFoiInternado.getSelectedItem());
        objPsicoPaiSocial.setEspecificarFrequenciasLocais(jEspecificarFrequenciasLocais.getText());
        objPsicoPaiSocial.setMedicacoesUtilizadas(jMedicacoesUtilizadas.getText());
        objPsicoPaiSocial.setEpisodioDepressivo((String) jComboBoxEpisodioDepressivo.getSelectedItem());
        objPsicoPaiSocial.setSurtoPsicotico((String) jComboBoxSurtoPsicotico.getSelectedItem());
        objPsicoPaiSocial.setTentativaSuicidio((String) jComboBoxTentativaSuicidio.getSelectedItem());
        objPsicoPaiSocial.setComportamentoViolento((String) jComboBoxComportamentoViolento.getSelectedItem());
        objPsicoPaiSocial.setEnvolveJustica((String) jComboBoxEnvolveJustica.getSelectedItem());
        objPsicoPaiSocial.setUsoMedicaPsiquia((String) jComboBoxUsoMedicaPsiquia.getSelectedItem());
        objPsicoPaiSocial.setObservacaoDepressivo(jObservacaoDepressivo.getText());
        objPsicoPaiSocial.setObservacaoSurto(jObservacaoSurto.getText());
        objPsicoPaiSocial.setObservacaoTentativaSuicidio(jObservacaoTentativaSuicidio.getText());
        objPsicoPaiSocial.setObservacaoComportamentoViolento(jObservacaoComportamentoViolento.getText());
        objPsicoPaiSocial.setObservacaoEnvolveJustica(jObservacaoEnvolveJustica.getText());
        objPsicoPaiSocial.setObservacaoUsoMedicacoPsiquiatrica(jObservacaoUsoMedicacoPsiquiatrica.getText());
        objPsicoPaiSocial.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
        objPsicoPaiSocial.setNomeInternoCrc(jNomeInternoPAI.getText());
        if (acao == 13) {
            if (jCodigoPAI.getText().equals(codigoPaiPSI) && jIdInternoPAI.getText().equals(codigoInternoPSI)) {
                JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
            } else {
                objPsicoPaiSocial.setUsuarioInsert(nameUser);
                objPsicoPaiSocial.setDataInsert(dataModFinal);
                objPsicoPaiSocial.setHorarioInsert(horaMov);
                controlPSI.incluirPsicologiaPsicoSocial(objPsicoPaiSocial);
                buscarCodigoPSI();
                //
                objLog6();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarPSI();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
            }
        }
        if (acao == 14) {
            objPsicoPaiSocial.setUsuarioUp(nameUser);
            objPsicoPaiSocial.setDataUp(dataModFinal);
            objPsicoPaiSocial.setHorarioUp(horaMov);
            //
            objPsicoPaiSocial.setIdPsiPai(codigoPSI);
            controlPSI.alterarPsicologiaPsicoSocial(objPsicoPaiSocial);
            //
            objLog6();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            SalvarPSI();
            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
        }
    }//GEN-LAST:event_jBtSalvarPSIActionPerformed

    private void jBtCancelarPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarPSIActionPerformed
        // TODO add your handling code here:
        CancelarPSI();
    }//GEN-LAST:event_jBtCancelarPSIActionPerformed

    private void jBtSairPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairPSIActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairPSIActionPerformed

    private void jBtAuditoriaPSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaPSIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaPSIActionPerformed

    private void jBtNovoPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoPMActionPerformed
        // TODO add your handling code here:
        acao = 15;
        bloquearCampos();
        NovoPM();
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtNovoPMActionPerformed

    private void jBtAlterarPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarPMActionPerformed
        // TODO add your handling code here:
        acao = 16;
        bloquearCampos();
        AlterarPM();
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtAlterarPMActionPerformed

    private void jBtExcluirPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirPMActionPerformed
        // TODO add your handling code here:
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objPsiMed.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
            controlPsiMed.excluirPsicologiaMedicoPaiPsicosocial(objPsiMed);
            objLog7();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            bloquearCampos();
            ExcluirPM();
            JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
        }
    }//GEN-LAST:event_jBtExcluirPMActionPerformed

    private void jBtSalvarPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarPMActionPerformed
        // TODO add your handling code here:
        verificarCodigoPM();
        objPsiMed.setFamiliaTranstornoMental((String) jComboBoxFamiliaTranstornoMental.getSelectedItem());
        objPsiMed.setQuemTranstornoMental(jQuemTranstornoMental.getText());
        objPsiMed.setQualTranstornoMental(jQualTranstornoMental.getText());
        objPsiMed.setNecessidadePSI((String) jComboBoxNecessidadePSI.getSelectedItem());
        if (jCheckBoxConsultaPSI.isSelected()) {
            consultaPSI = 0;
        } else if (!jCheckBoxConsultaPSI.isSelected()) {
            consultaPSI = 1;
        }
        objPsiMed.setConsultaPSI(consultaPSI);
        if (jCheckBoxAcompanhaPSI.isSelected()) {
            acompanhaPSI = 0;
        } else if (!jCheckBoxAcompanhaPSI.isSelected()) {
            acompanhaPSI = 1;
        }
        objPsiMed.setAcompanhaPSI(acompanhaPSI);
        objPsiMed.setFazUsoDroga((String) jComboBoxFazUsoDroga.getSelectedItem());
        objPsiMed.setQuaisDrogas(jQuaisDrogas.getText());
        objPsiMed.setCompartilhaDrogas((String) jComboBoxCompartilhaDrogas.getSelectedItem());
        objPsiMed.setReducaoDanos((String) jComboBoxReducaoDanos.getSelectedItem());
        objPsiMed.setPorqueReduzDanos(jPorqueReduzDanos.getText());
        objPsiMed.setAceitaProgramasDanos((String) jComboBoxAceitaProgramasDanos.getSelectedItem());
        objPsiMed.setPorqueAceitaProgroReduDanos(jPorqueAceitaProgroReduDanos.getText());
        objPsiMed.setQueixaProbSaude((String) jComboBoxQueixaProbSaude.getSelectedItem());
        if (jCheckBoxHipertensao.isSelected()) {
            hipertensao = 0;
        } else if (!jCheckBoxHipertensao.isSelected()) {
            hipertensao = 1;
        }
        objPsiMed.setHipertensao(hipertensao);
        if (jCheckBoxDiabetes.isSelected()) {
            diabetes = 0;
        } else if (!jCheckBoxDiabetes.isSelected()) {
            diabetes = 1;
        }
        objPsiMed.setDiabetes(diabetes);
        if (jCheckBoxTuberculose.isSelected()) {
            tuberculose = 0;
        } else if (!jCheckBoxTuberculose.isSelected()) {
            tuberculose = 1;
        }
        objPsiMed.setTuberculose(tuberculose);
        if (jCheckBoxDST.isSelected()) {
            dst = 0;
        } else if (!jCheckBoxDST.isSelected()) {
            dst = 1;
        }
        objPsiMed.setdST(dst);
        if (jCheckBoxHepatite.isSelected()) {
            hepatite = 0;
        } else if (!jCheckBoxHepatite.isSelected()) {
            hepatite = 1;
        }
        objPsiMed.setHepatite(hepatite);
        if (jCheckBoxHanseniase.isSelected()) {
            hanseniase = 0;
        } else if (!jCheckBoxHanseniase.isSelected()) {
            hanseniase = 1;
        }
        objPsiMed.setHanseniase(hanseniase);
        if (jCheckBoxOutrasDoencas.isSelected()) {
            outrasDoencas = 0;
        } else if (!jCheckBoxOutrasDoencas.isSelected()) {
            outrasDoencas = 1;
        }
        objPsiMed.setOutrasDoencas(outrasDoencas);
        objPsiMed.setQuaisOutrasDoencas(jQuaisOutrasDoencas.getText());
        objPsiMed.setProblemasSaudeBucal((String) jComboBoxProblemasSaudeBucal.getSelectedItem());
        objPsiMed.setFazTratamentoBucal((String) jComboBoxFazTratamentoBucal.getSelectedItem());
        objPsiMed.setQuaisTratamentoBucal(jQuaisTratamentoBucal.getText());
        objPsiMed.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
        objPsiMed.setNomeInternoCrc(jNomeInternoPAI.getText());
        if (acao == 15) {
            if (jCodigoPAI.getText().equals(codigoPaiPM) && jIdInternoPAI.getText().equals(codigoInternoPM)) {
                JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
            } else {
                objPsiMed.setUsuarioInsert(nameUser);
                objPsiMed.setDataInsert(dataModFinal);
                objPsiMed.setHorarioInsert(horaMov);
                controlPsiMed.incluirPsicologiaMedicoPaiPsicosocial(objPsiMed);
                buscarCodigoPM();
                objLog7();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                bloquearCampos();
                SalvarPM();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
            }
        }
        if (acao == 16) {
            objPsiMed.setUsuarioUp(nameUser);
            objPsiMed.setDataUp(dataModFinal);
            objPsiMed.setHorarioUp(horaMov);
            objPsiMed.setIdPsiMed(codigoPM);
            controlPsiMed.alterarPsicologiaMedicoPaiPsicosocial(objPsiMed);
            objLog7();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            bloquearCampos();
            SalvarPM();
            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
        }
    }//GEN-LAST:event_jBtSalvarPMActionPerformed

    private void jBtCancelarPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarPMActionPerformed
        // TODO add your handling code here:
        CancelarPM();
    }//GEN-LAST:event_jBtCancelarPMActionPerformed

    private void jBtSairPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairPMActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairPMActionPerformed

    private void jBtAuditoriaPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaPMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaPMActionPerformed

    private void jBtPesquisarUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarUnidadeActionPerformed
        // TODO add your handling code here:
        TelaPesquisaUnidadePaiPsicoSocialPsicologia objPesqUnid = new TelaPesquisaUnidadePaiPsicoSocialPsicologia();
        TelaModuloPsicologia.jPainelPsicologia.add(objPesqUnid);
        objPesqUnid.show();
    }//GEN-LAST:event_jBtPesquisarUnidadeActionPerformed

    private void jBtNovoCRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoCRCActionPerformed
        // TODO add your handling code here:
        acao = 17;
        bloquearCampos();
        NovoEAPI();
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtNovoCRCActionPerformed

    private void jBtAlterarCRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarCRCActionPerformed
        // TODO add your handling code here:
        acao = 18;
        bloquearCampos();
        AlterarEAPI();
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtAlterarCRCActionPerformed

    private void jBtExcluirCRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirCRCActionPerformed
        // TODO add your handling code here:
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objEapi.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
            controlEapi.excluirEapiCrcPaiPsicoSocial(objEapi);
            objLog8();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            bloquearCampos();
            ExcluirEAPI();
            JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
        }
    }//GEN-LAST:event_jBtExcluirCRCActionPerformed

    private void jBtSalvarCRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarCRCActionPerformed
        // TODO add your handling code here:
        verificarCodigoEAPI();
        if (jDescricaoUnidadePenal.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe a unidade prisional do interno.");
        } else {
            objEapi.setTempPenaSentenca(jTempPenaSentenca.getText());
            objEapi.setTempoPenaCumprida(jTempoPenaCumprida.getText());
            objEapi.setAssistenciaJuridica((String) jComboBoxAssistenciaJuridica.getSelectedItem());
            objEapi.setTempoPenaACumprir(jTempoPenaACumprir.getText());
            objEapi.setReintegraSistemaPenal((String) jComboBoxReintegraSistemaPenal.getSelectedItem());
            objEapi.setSituacaoJuridica(jSituacaoJuridica.getText());
            objEapi.setDataEntradaSistemaPenal(jDataEntradaSistemaPenal.getDate());
            objEapi.setDefensorPublico((String) jComboBoxDefensorPublico.getSelectedItem());
            objEapi.setOutroDefensor((String) jComboBoxOutroDefensor.getSelectedItem());
            objEapi.setQualDefensor(jQualDefensor.getText());
            objEapi.setTextoPSP(jTextoPSP.getText());
            objEapi.setDescricaoUnidade(jDescricaoUnidadePenal.getText());
            objEapi.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
            objEapi.setNomeInternoCrc(jNomeInternoPAI.getText());
            if (acao == 17) {
                if (jCodigoPAI.getText().equals(codigoPaiEAPI) && jIdInternoPAI.getText().equals(codigoInternoEAPI)) {
                    JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                } else {
                    objEapi.setUsuarioInsert(nameUser);
                    objEapi.setDataInsert(dataModFinal);
                    objEapi.setHorarioInsert(horaMov);
                    controlEapi.incluirEapiCrcPaiPsicoSocial(objEapi);
                    buscarCodigoEAPI();
                    objLog8();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarEAPI();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                }
            }
            if (acao == 18) {
                objEapi.setUsuarioUp(nameUser);
                objEapi.setDataUp(dataModFinal);
                objEapi.setHorarioUp(horaMov);
                objEapi.setIdEapi(codigoEAPI);
                controlEapi.alterarEapiCrcPaiPsicoSocial(objEapi);
                objLog8();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarEAPI();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
            }
        }
    }//GEN-LAST:event_jBtSalvarCRCActionPerformed

    private void jBtCancelarCRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarCRCActionPerformed
        // TODO add your handling code here:
        CancelarEAPI();
    }//GEN-LAST:event_jBtCancelarCRCActionPerformed

    private void jBtSairCRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairCRCActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairCRCActionPerformed

    private void jBtAuditoriaCRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaCRCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaCRCActionPerformed

    private void jBtNovoSS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoSS3ActionPerformed
        // TODO add your handling code here:
        acao = 19;
        bloquearCampos();
        NovoSS3();
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtNovoSS3ActionPerformed

    private void jBtAlterarSS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarSS3ActionPerformed
        // TODO add your handling code here:
        acao = 20;
        bloquearCampos();
        AlterarSS3();
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtAlterarSS3ActionPerformed

    private void jBtExcluirSS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirSS3ActionPerformed
        // TODO add your handling code here:
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objSS3.setIdPai(Integer.parseInt(jCodigoPAI.getText()));
            controlSS3.excluirSS3PaiPsicoSocial(objSS3);
            objLog9();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            bloquearCampos();
            //   ExcluirSS3();
            JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
        }
    }//GEN-LAST:event_jBtExcluirSS3ActionPerformed

    private void jBtSalvarSS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarSS3ActionPerformed
        // TODO add your handling code here:
        verificarCodigoSS3();
        if (jDataInclusaoPAI.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Informe a data do P.A.I.");
        } else {
            objSS3.setTextoCEDEGEP(jTextoCEDEGEP.getText());
            objSS3.setTextoCRASCREAS(jTextoCRASCREAS.getText());
            objSS3.setTextoASSISTENCIA(jTextoASSISTENCIA.getText());
            objSS3.setTextoDOCUMENTOCIVIL(jTextoDOCUMENTOCIVIL.getText());
            objSS3.setDataInclusaoPAI(jDataInclusaoPAI.getDate());
            objSS3.setTecnicoServicoSocial(jTecnicoServicoSocial.getText());
            objSS3.setTecnicoPsicologico(jTecnicoPsicologico.getText());
            objSS3.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
            objSS3.setNomeInternoCrc(jNomeInternoPAI.getText());
            if (acao == 19) {
                if (jCodigoPAI.getText().equals(codigoPaiSS3) && jIdInternoPAI.getText().equals(codigoInternoSS3)) {
                    JOptionPane.showMessageDialog(rootPane, "Já foi realizado um registro para esse interno.");
                } else {
                    objSS3.setUsuarioInsert(nameUser);
                    objSS3.setDataInsert(dataModFinal);
                    objSS3.setHorarioInsert(horaMov);
                    controlSS3.incluirSS3PaiPsicoSocial(objSS3);
                    objLog9();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarSS3();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
                }
            }
            if (acao == 20) {
                objSS3.setUsuarioUp(nameUser);
                objSS3.setDataUp(dataModFinal);
                objSS3.setHorarioUp(horaMov);
                objSS3.setIdSS3(codigoSS3);
                controlSS3.alterarSS3PaiPsicoSocial(objSS3);
                objLog9();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarSS3();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
            }
        }
    }//GEN-LAST:event_jBtSalvarSS3ActionPerformed

    private void jBtCancelarSS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarSS3ActionPerformed
        // TODO add your handling code here:
        CancelarSS3();
    }//GEN-LAST:event_jBtCancelarSS3ActionPerformed

    private void jBtSairSS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairSS3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairSS3ActionPerformed

    private void jBtAuditoriaSS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaSS3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaSS3ActionPerformed

    private void jTabelaEvolucaoPAIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaEvolucaoPAIMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            String idEvolucao = "" + jTabelaEvolucaoPAI.getValueAt(jTabelaEvolucaoPAI.getSelectedRow(), 0);
            jIdEvolucao.setText(idEvolucao);
            //
            bloquearCampos();
            //
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(true);
            jBtExcluirEvolucao.setEnabled(true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(true);
            jBtAuditoriaEvolucao.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM EVOLUCAO_PAI "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON EVOLUCAO_PAI.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON EVOLUCAO_PAI.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE EVOLUCAO_PAI.IdPai='" + jCodigoPAI.getText() + "' "
                        + "AND IdEvolucao='" + idEvolucao + "'");
                conecta.rs.first();
                jIdEvolucao.setText(conecta.rs.getString("IdEvolucao"));
                jDataEvolucao.setDate(conecta.rs.getDate("DataEvolucao"));
                jNomeInternoEvolucaoPAI.setText(conecta.rs.getString("NomeInternoCrc"));
                jTextoEvolucao.setText(conecta.rs.getString("TextoEvolucao"));
            } catch (Exception e) {
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaEvolucaoPAIMouseClicked

    private void jBtCancelarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarEvolucaoActionPerformed
        // TODO add your handling code here:
        CancelarEvolucao();
    }//GEN-LAST:event_jBtCancelarEvolucaoActionPerformed

    private void jBtAuditoriaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaEvolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAuditoriaEvolucaoActionPerformed

    private void jBtNovaEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaEvolucaoActionPerformed
        // TODO add your handling code here:
        acao = 20;
        bloquearCampos();
        NovaEvolucao();
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtNovaEvolucaoActionPerformed

    private void jBtAlterarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarEvolucaoActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAO_PAI WHERE IdEvolucao='" + jIdEvolucao.getText() + "'");
            conecta.rs.first();
            nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível encontrar o usuário.");
        }
        if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
            acao = 21;
            bloquearCampos();
            AlterarEvolucao();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
            conecta.desconecta();
        }
    }//GEN-LAST:event_jBtAlterarEvolucaoActionPerformed

    private void jBtExcluirEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirEvolucaoActionPerformed
        // TODO add your handling code here:
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAO_PAI WHERE IdEvolucao='" + jIdEvolucao.getText() + "'");
            conecta.rs.first();
            nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível encontrar o usuário.");
        }
        if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
            bloquearCampos();
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            bloquearCampos();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objEvolucaoPAI.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
                objEvolucaoPAI.setIdEvolucaoPAI(Integer.valueOf(jIdEvolucao.getText()));
                objEvolucaoPAI.setIdInternoCrc(Integer.valueOf(jIdInternoPAI.getText()));
                controlePAI.excluirEvolucaoPAI(objEvolucaoPAI);
                //
                objLog10();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                preencherTabelaEvolucao("SELECT * FROM EVOLUCAO_PAI "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON EVOLUCAO_PAI.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "WHERE EVOLUCAO_PAI.IdPai='" + jCodigoPAI.getText() + "'");
                ExcluirEvolucao();
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
            conecta.desconecta();
        }
    }//GEN-LAST:event_jBtExcluirEvolucaoActionPerformed

    private void jBtSalvarEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarEvolucaoActionPerformed
        // TODO add your handling code here:
        if (jNomeInternoEvolucaoPAI.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o nome do interno para evolução.");
        } else if (jDataEvolucao.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Informe a data da evolução.");
        } else {
            objEvolucaoPAI.setDataEvolucaoPAI(jDataEvolucao.getDate());
            objEvolucaoPAI.setNomeInternoCrc(jNomeInternoEvolucaoPAI.getText());
            objEvolucaoPAI.setTextoEvolucaoPAI(jTextoEvolucao.getText());
            objEvolucaoPAI.setIdPai(Integer.valueOf(jCodigoPAI.getText()));
            if (acao == 20) {
                objEvolucaoPAI.setUsuarioInsert(nameUser);
                objEvolucaoPAI.setDataInsert(dataModFinal);
                objEvolucaoPAI.setHorarioInsert(horaMov);
                //
                controlePAI.incluirEvolucaoPAI(objEvolucaoPAI);
                buscarCodigoEvolucao();
                //
                objLog10();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarEvolucao();
                preencherTabelaEvolucao("SELECT * FROM EVOLUCAO_PAI "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON EVOLUCAO_PAI.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "WHERE EVOLUCAO_PAI.IdPai='" + jCodigoPAI.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
            }
            if (acao == 21) {
                objEvolucaoPAI.setUsuarioUp(nameUser);
                objEvolucaoPAI.setDataUp(dataModFinal);
                objEvolucaoPAI.setHorarioUp(horaMov);
                //
                objEvolucaoPAI.setIdEvolucaoPAI(Integer.valueOf(jIdEvolucao.getText()));
                objEvolucaoPAI.setIdInternoCrc(Integer.valueOf(jIdInternoPAI.getText()));
                controlePAI.alterarEvolucaoPAI(objEvolucaoPAI);
                //
                objLog10();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarEvolucao();
                preencherTabelaEvolucao("SELECT * FROM EVOLUCAO_PAI "
                        + "INNER JOIN PAI_PSICOSOCIAL "
                        + "ON EVOLUCAO_PAI.IdPai=PAI_PSICOSOCIAL.IdPai "
                        + "WHERE EVOLUCAO_PAI.IdPai='" + jCodigoPAI.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso !!!");
            }
        }
    }//GEN-LAST:event_jBtSalvarEvolucaoActionPerformed

    private void jBtImpressaoEvolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoEvolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtImpressaoEvolucaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CRC;
    private javax.swing.JPanel Familiares;
    public static javax.swing.JTextField JRGInternoPAI;
    private javax.swing.JPanel Listagem;
    private javax.swing.JPanel Manutencao;
    private javax.swing.JPanel Medico;
    private javax.swing.JPanel Psicologia;
    private javax.swing.JPanel ServicoSocial;
    private javax.swing.JPanel ServicoSocial2;
    private javax.swing.JPanel Terapia;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroupEscolaridade;
    private javax.swing.ButtonGroup buttonGroupParticipaCumprePena;
    public static javax.swing.JTextField jAlcunha;
    public static javax.swing.JTextField jArtigo;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarCRC;
    private javax.swing.JButton jBtAlterarEvolucao;
    private javax.swing.JButton jBtAlterarFamiliar;
    private javax.swing.JButton jBtAlterarPM;
    private javax.swing.JButton jBtAlterarPSI;
    private javax.swing.JButton jBtAlterarSS;
    private javax.swing.JButton jBtAlterarSS3;
    private javax.swing.JButton jBtAlterarTO;
    private javax.swing.JButton jBtAlterarVisita;
    private javax.swing.JButton jBtAlterarVisitaIntima;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaCRC;
    private javax.swing.JButton jBtAuditoriaEvolucao;
    private javax.swing.JButton jBtAuditoriaFamiliar;
    private javax.swing.JButton jBtAuditoriaPM;
    private javax.swing.JButton jBtAuditoriaPSI;
    private javax.swing.JButton jBtAuditoriaSS;
    private javax.swing.JButton jBtAuditoriaSS3;
    private javax.swing.JButton jBtAuditoriaTO;
    private javax.swing.JButton jBtAuditoriaVisita;
    private javax.swing.JButton jBtAuditoriaVisitaIntima;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarCRC;
    private javax.swing.JButton jBtCancelarEvolucao;
    private javax.swing.JButton jBtCancelarFamiliar;
    private javax.swing.JButton jBtCancelarPM;
    private javax.swing.JButton jBtCancelarPSI;
    private javax.swing.JButton jBtCancelarSS;
    private javax.swing.JButton jBtCancelarSS3;
    private javax.swing.JButton jBtCancelarTO;
    private javax.swing.JButton jBtCancelarVisita;
    private javax.swing.JButton jBtCancelarVisitaIntima;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirCRC;
    private javax.swing.JButton jBtExcluirEvolucao;
    private javax.swing.JButton jBtExcluirFamiliar;
    private javax.swing.JButton jBtExcluirPM;
    private javax.swing.JButton jBtExcluirPSI;
    private javax.swing.JButton jBtExcluirSS;
    private javax.swing.JButton jBtExcluirSS3;
    private javax.swing.JButton jBtExcluirTO;
    private javax.swing.JButton jBtExcluirVisita;
    private javax.swing.JButton jBtExcluirVisitaIntima;
    private javax.swing.JButton jBtImpressaoEvolucao;
    private javax.swing.JButton jBtNovaEvolucao;
    private javax.swing.JButton jBtNovaVisita;
    private javax.swing.JButton jBtNovaVisitaIntima;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoCRC;
    private javax.swing.JButton jBtNovoFamiliar;
    private javax.swing.JButton jBtNovoPM;
    private javax.swing.JButton jBtNovoPSI;
    private javax.swing.JButton jBtNovoSS;
    private javax.swing.JButton jBtNovoSS3;
    private javax.swing.JButton jBtNovoTO;
    private javax.swing.JButton jBtPesqCodigo;
    private javax.swing.JButton jBtPesqDataPAI;
    private javax.swing.JButton jBtPesqNomeInternoPAI;
    private javax.swing.JButton jBtPesqVisita;
    private javax.swing.JButton jBtPesqVisitaIntima;
    private javax.swing.JButton jBtPesquisarInternoPAI;
    private javax.swing.JButton jBtPesquisarUnidade;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairCRC;
    private javax.swing.JButton jBtSairPM;
    private javax.swing.JButton jBtSairPSI;
    private javax.swing.JButton jBtSairSS;
    private javax.swing.JButton jBtSairSS3;
    private javax.swing.JButton jBtSairTO;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarCRC;
    private javax.swing.JButton jBtSalvarEvolucao;
    private javax.swing.JButton jBtSalvarFamiliar;
    private javax.swing.JButton jBtSalvarPM;
    private javax.swing.JButton jBtSalvarPSI;
    private javax.swing.JButton jBtSalvarSS;
    private javax.swing.JButton jBtSalvarSS3;
    private javax.swing.JButton jBtSalvarTO;
    private javax.swing.JButton jBtSalvarVisita;
    private javax.swing.JButton jBtSalvarVisitaIntima;
    public static javax.swing.JTextField jCPFInternoPAI;
    public static javax.swing.JTextField jCartaoSUSPAI;
    public static javax.swing.JTextField jCela;
    private javax.swing.JCheckBox jCheckBoxAcompanhaPSI;
    private javax.swing.JCheckBox jCheckBoxConsultaPSI;
    private javax.swing.JCheckBox jCheckBoxDST;
    private javax.swing.JCheckBox jCheckBoxDiabetes;
    private javax.swing.JCheckBox jCheckBoxHanseniase;
    private javax.swing.JCheckBox jCheckBoxHepatite;
    private javax.swing.JCheckBox jCheckBoxHipertensao;
    private javax.swing.JCheckBox jCheckBoxOutrasDoencas;
    private javax.swing.JCheckBox jCheckBoxTodosRegistros;
    private javax.swing.JCheckBox jCheckBoxTuberculose;
    public static javax.swing.JTextField jCodigoPAI;
    private javax.swing.JTextField jCodigoPesqPAI;
    private javax.swing.JComboBox jComboBoxAceitaProgramasDanos;
    private javax.swing.JComboBox jComboBoxAssistenciaJuridica;
    private javax.swing.JComboBox jComboBoxAtendeCondiPrevistas;
    private javax.swing.JComboBox jComboBoxCPF;
    private javax.swing.JComboBox jComboBoxCTPS;
    private javax.swing.JComboBox jComboBoxCertidaoNasc;
    private javax.swing.JComboBox jComboBoxCompartilhaDrogas;
    private javax.swing.JComboBox jComboBoxComportamentoViolento;
    private javax.swing.JComboBox jComboBoxCultura;
    private javax.swing.JComboBox jComboBoxDefensorPublico;
    private javax.swing.JComboBox jComboBoxDemandaEscolar;
    private javax.swing.JComboBox jComboBoxDemandaEsporte;
    private javax.swing.JComboBox jComboBoxDemandaQualiProf;
    private javax.swing.JComboBox jComboBoxEnvolveJustica;
    private javax.swing.JComboBox jComboBoxEpisodioDepressivo;
    private javax.swing.JComboBox jComboBoxEsporte;
    private javax.swing.JComboBox jComboBoxExperienciaTrab;
    private javax.swing.JComboBox jComboBoxFamiliaTranstornoMental;
    private javax.swing.JComboBox jComboBoxFazTratamentoBucal;
    private javax.swing.JComboBox jComboBoxFazUsoDroga;
    private javax.swing.JComboBox jComboBoxFilhosSemRegistros;
    private javax.swing.JComboBox jComboBoxFoiInternado;
    private javax.swing.JComboBox jComboBoxFrequentaEscola;
    private javax.swing.JComboBox jComboBoxIntervencaoPrograma;
    private javax.swing.JComboBox jComboBoxLazer;
    private javax.swing.JComboBox jComboBoxLocalizacaoFamiliares;
    private javax.swing.JComboBox jComboBoxNecessidadePSI;
    private javax.swing.JComboBox jComboBoxOutroDefensor;
    private javax.swing.JComboBox jComboBoxPartAtivEsporte;
    private javax.swing.JComboBox jComboBoxParticipaAtividadeLab;
    private javax.swing.JComboBox jComboBoxProblemasSaudeBucal;
    private javax.swing.JComboBox jComboBoxProgramaSocial;
    private javax.swing.JComboBox jComboBoxQuaisTratamentosMentais;
    private javax.swing.JComboBox jComboBoxQueixaProbSaude;
    private javax.swing.JComboBox jComboBoxRG;
    private javax.swing.JComboBox jComboBoxReducaoDanos;
    private javax.swing.JComboBox jComboBoxRegulaDocumento;
    private javax.swing.JComboBox jComboBoxReintegraSistemaPenal;
    private javax.swing.JComboBox jComboBoxStatusPAI;
    private javax.swing.JComboBox jComboBoxSurtoPsicotico;
    private javax.swing.JComboBox jComboBoxTentativaSuicidio;
    private javax.swing.JComboBox jComboBoxTranstornoMental;
    private javax.swing.JComboBox jComboBoxTratamentoAnterior;
    private javax.swing.JComboBox jComboBoxUsoMedicaPsiquia;
    private javax.swing.JComboBox jComboBoxVinculoPAI;
    private javax.swing.JComboBox jComboBoxVulnerabilidadeSocial;
    public static javax.swing.JTextField jCorEtiniaInternoPAI;
    public static com.toedter.calendar.JDateChooser jDataEntradaInternoPAI;
    private com.toedter.calendar.JDateChooser jDataEntradaSistemaPenal;
    private com.toedter.calendar.JDateChooser jDataEvolucao;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInclusaoPAI;
    private com.toedter.calendar.JDateChooser jDataInicial;
    public static com.toedter.calendar.JDateChooser jDataNascimentoPAI;
    private com.toedter.calendar.JDateChooser jDataPAI;
    public static javax.swing.JTextField jDescricaoUnidadePenal;
    private javax.swing.JTextArea jEnderecoResidencial;
    private javax.swing.JTextField jEnderecoTelefonePAI;
    public static javax.swing.JTextField jEscolaridadeInternoPAI;
    private javax.swing.JTextArea jEspecificarFrequenciasLocais;
    public static javax.swing.JTextField jEstadoCivilInternoPAI;
    public static javax.swing.JLabel jFotoInternoPAI;
    private javax.swing.JTextField jHabilidades;
    private javax.swing.JTextField jIdEvolucao;
    public static javax.swing.JTextField jIdFamiliarPAI;
    public static javax.swing.JTextField jIdInternoPAI;
    public static javax.swing.JTextField jIdVisitaIntima;
    public static javax.swing.JTextField jIdVisitaPAI;
    private javax.swing.JTextField jIdadeFamiliarPAI;
    private javax.swing.JFormattedTextField jIdadeInterno;
    private javax.swing.JTextField jIdadeVisita;
    private javax.swing.JTextField jIdadeVisitaIntima;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
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
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLabel jLogoMarcaAssitenteSocial;
    private javax.swing.JLabel jLogoMarcaPsicologia;
    public static javax.swing.JTextField jMatriculaPenal;
    private javax.swing.JTextArea jMedicacoesUtilizadas;
    public static javax.swing.JTextField jNaturalidadeInternoPAI;
    private javax.swing.JTextField jNomeFamiliarPAI;
    private javax.swing.JTextField jNomeInternoEvolucaoPAI;
    public static javax.swing.JTextField jNomeInternoPAI;
    private javax.swing.JTextField jNomeInternoPesquisa;
    public static javax.swing.JTextField jNomeMaeInternoPAI;
    public static javax.swing.JTextField jNomePaiInternoPAI;
    public static javax.swing.JTextField jNomeVisitaIntima;
    public static javax.swing.JTextField jNomeVisitaPAI;
    private javax.swing.JTextField jObservacaoComportamentoViolento;
    private javax.swing.JTextField jObservacaoDepressivo;
    private javax.swing.JTextField jObservacaoEnvolveJustica;
    private javax.swing.JTextField jObservacaoEstudos;
    private javax.swing.JTextField jObservacaoFilhos;
    private javax.swing.JTextField jObservacaoLaborativa;
    private javax.swing.JTextField jObservacaoParticipacaoFamilia;
    private javax.swing.JTextField jObservacaoSurto;
    private javax.swing.JTextField jObservacaoTentativaSuicidio;
    private javax.swing.JTextField jObservacaoUsoMedicacoPsiquiatrica;
    private javax.swing.JTextField jOcupacaoFamiliarPAI;
    private javax.swing.JTextField jOcupacaoVisita;
    private javax.swing.JTextField jOcupacaoVisitaIntima;
    private javax.swing.JTextField jOrientacaoSexual;
    private javax.swing.JTextField jOutrosDocumentos;
    private javax.swing.JTextField jOutrosTratamento;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JTextField jParentescoPAI;
    public static javax.swing.JTextField jParentescoVisitaIntima;
    public static javax.swing.JTextField jPavilhão;
    private javax.swing.JTextField jPorqueAceitaProgroReduDanos;
    private javax.swing.JTextField jPorqueReduzDanos;
    public static javax.swing.JTextField jProfissaoInternoPAI;
    private javax.swing.JTextField jQuaisDrogas;
    private javax.swing.JTextField jQuaisOutrasDoencas;
    private javax.swing.JTextField jQuaisTratamentoBucal;
    private javax.swing.JTextField jQualAtividadeEsporte;
    private javax.swing.JTextField jQualAtividadeLab;
    private javax.swing.JTextField jQualCultura;
    private javax.swing.JTextField jQualDefensor;
    private javax.swing.JTextField jQualEscola;
    private javax.swing.JTextField jQualEsporte;
    private javax.swing.JTextField jQualExperiencia;
    private javax.swing.JTextField jQualLazer;
    private javax.swing.JTextField jQualProgramaSocial;
    private javax.swing.JTextField jQualQualificacaoProf;
    private javax.swing.JTextField jQualTranstornoMental;
    private javax.swing.JTextField jQuantosFilhosMaiores21;
    private javax.swing.JTextField jQuantosFilhosMenores21;
    private javax.swing.JTextField jQuantosFilhosSemRegistros;
    private javax.swing.JTextField jQuemTranstornoMental;
    private javax.swing.JRadioButton jRadioButtonAnalfabeto;
    private javax.swing.JRadioButton jRadioButtonEnsinoMedio;
    private javax.swing.JRadioButton jRadioButtonFundamental1;
    private javax.swing.JRadioButton jRadioButtonFundamental2;
    private javax.swing.JRadioButton jRadioButtonInsuficiente;
    private javax.swing.JRadioButton jRadioButtonMuitoBoa;
    private javax.swing.JRadioButton jRadioButtonNula;
    private javax.swing.JRadioButton jRadioButtonRazoavel;
    private javax.swing.JRadioButton jRadioButtonSuperiorCompleto;
    private javax.swing.JRadioButton jRadioButtonSuperiorIncompleto;
    public static javax.swing.JTextField jRegimePenal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    public static javax.swing.JTextField jSexoInternoPAI;
    private javax.swing.JTextField jSituacaoJuridica;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaEvolucaoPAI;
    private javax.swing.JTable jTabelaFamiliarPAI;
    private javax.swing.JTable jTabelaPAI;
    private javax.swing.JTable jTabelaVisitas;
    private javax.swing.JTable jTabelaVisitasIntimas;
    private javax.swing.JTextField jTecnicoPsicologico;
    private javax.swing.JTextField jTecnicoServicoSocial;
    private javax.swing.JTextField jTempPenaSentenca;
    private javax.swing.JTextField jTempoPenaACumprir;
    private javax.swing.JTextField jTempoPenaCumprida;
    private javax.swing.JTextArea jTextoASSISTENCIA;
    private javax.swing.JTextArea jTextoCEDEGEP;
    private javax.swing.JTextArea jTextoCRASCREAS;
    private javax.swing.JTextArea jTextoDOCUMENTOCIVIL;
    private javax.swing.JTextArea jTextoEvolucao;
    private javax.swing.JTextArea jTextoPSP;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        // MANUTENÇÃO
        jEnderecoResidencial.setLineWrap(true);
        jEnderecoResidencial.setWrapStyleWord(true);
        jOrientacaoSexual.setDocument(new LimiteDigitosAlfa(21));
        try {
            MaskFormatter idade = new MaskFormatter("###");
            jIdadeInterno.setFormatterFactory(new DefaultFormatterFactory(idade));
        } catch (ParseException ex) {
            Logger.getLogger(TelaPaiPsicologia.class.getName()).log(Level.SEVERE, null, ex);
        }
        //S.S.1
        jOutrosDocumentos.setDocument(new LimiteDigitosAlfa(56));
        jQuantosFilhosMaiores21.setDocument(new LimiteDigitosSoNum(13));
        jQuantosFilhosSemRegistros.setDocument(new LimiteDigitosSoNum(13));
        jQuantosFilhosMenores21.setDocument(new LimiteDigitosSoNum(6));
        jObservacaoFilhos.setDocument(new LimiteDigitosAlfa(62));
        jQualProgramaSocial.setDocument(new LimiteDigitosAlfa(62));
        jObservacaoParticipacaoFamilia.setDocument(new LimiteDigitosAlfa(58));
        // S.S.2
        jNomeFamiliarPAI.setDocument(new LimiteDigitosAlfa(50));
        jIdadeFamiliarPAI.setDocument(new LimiteDigitosNum(3));
        jOcupacaoFamiliarPAI.setDocument(new LimiteDigitosAlfa(20));
        jEnderecoTelefonePAI.setDocument(new LimiteDigitosAlfa(56));
        //
        jOcupacaoVisita.setDocument(new LimiteDigitosAlfa(33));
        jIdadeVisita.setDocument(new LimiteDigitosNum(3));
        //
        jOcupacaoVisitaIntima.setDocument(new LimiteDigitosAlfa(33));
        jIdadeVisitaIntima.setDocument(new LimiteDigitosNum(3));
        // TO/Ped
        jEscolaridadeInternoPAI.setDocument(new LimiteDigitosAlfa(58));
        jQualEscola.setDocument(new LimiteDigitosAlfa(50));
        jObservacaoEstudos.setDocument(new LimiteDigitosAlfa(44));
        jProfissaoInternoPAI.setDocument(new LimiteDigitosAlfa(44));
        jQualAtividadeLab.setDocument(new LimiteDigitosAlfa(29));
        jObservacaoLaborativa.setDocument(new LimiteDigitosAlfa(60));
        jQualQualificacaoProf.setDocument(new LimiteDigitosAlfa(22));
        jQualExperiencia.setDocument(new LimiteDigitosAlfa(22));
        jHabilidades.setDocument(new LimiteDigitosAlfa(61));
        jQualAtividadeEsporte.setDocument(new LimiteDigitosAlfa(66));
        jQualEsporte.setDocument(new LimiteDigitosAlfa(13));
        jQualLazer.setDocument(new LimiteDigitosAlfa(14));
        jQualCultura.setDocument(new LimiteDigitosAlfa(50));
        // PSI       
        jOutrosTratamento.setDocument(new LimiteDigitosAlfa(57));
        jEspecificarFrequenciasLocais.setLineWrap(true);
        jEspecificarFrequenciasLocais.setWrapStyleWord(true);
        jMedicacoesUtilizadas.setLineWrap(true);
        jMedicacoesUtilizadas.setWrapStyleWord(true);
        jObservacaoDepressivo.setDocument(new LimiteDigitosAlfa(33));
        jObservacaoSurto.setDocument(new LimiteDigitosAlfa(33));
        jObservacaoTentativaSuicidio.setDocument(new LimiteDigitosAlfa(33));
        jObservacaoComportamentoViolento.setDocument(new LimiteDigitosAlfa(33));
        jObservacaoEnvolveJustica.setDocument(new LimiteDigitosAlfa(33));
        jObservacaoUsoMedicacoPsiquiatrica.setDocument(new LimiteDigitosAlfa(33));
        //P.M.        
        jQuemTranstornoMental.setDocument(new LimiteDigitosAlfa(54));
        jQualTranstornoMental.setDocument(new LimiteDigitosAlfa(54));
        jQuaisDrogas.setDocument(new LimiteDigitosAlfa(25));
        jPorqueReduzDanos.setDocument(new LimiteDigitosAlfa(66));
        jPorqueAceitaProgroReduDanos.setDocument(new LimiteDigitosAlfa(66));
        jQuaisOutrasDoencas.setDocument(new LimiteDigitosAlfa(54));
        jQuaisTratamentoBucal.setDocument(new LimiteDigitosAlfa(66));
        // CRC/EAPI       
        jTempPenaSentenca.setDocument(new LimiteDigitosAlfa(15));
        jTempoPenaCumprida.setDocument(new LimiteDigitosSoNum(11));
        jTempoPenaACumprir.setDocument(new LimiteDigitosSoNum(11));
        jSituacaoJuridica.setDocument(new LimiteDigitosAlfa(33));
        jQualDefensor.setDocument(new LimiteDigitosAlfa(67));
        jTextoPSP.setLineWrap(true);
        jTextoPSP.setWrapStyleWord(true);
        //S.S.3
        jTextoCEDEGEP.setLineWrap(true);
        jTextoCEDEGEP.setWrapStyleWord(true);
        jTextoCRASCREAS.setLineWrap(true);
        jTextoCRASCREAS.setWrapStyleWord(true);
        jTextoASSISTENCIA.setLineWrap(true);
        jTextoASSISTENCIA.setWrapStyleWord(true);
        jTextoDOCUMENTOCIVIL.setLineWrap(true);
        jTextoDOCUMENTOCIVIL.setWrapStyleWord(true);
        //
        jTecnicoServicoSocial.setDocument(new LimiteDigitosAlfa(53));
        jTecnicoPsicologico.setDocument(new LimiteDigitosAlfa(53));
        // EVOLUÇÃO PAI      
        jTextoEvolucao.setLineWrap(true);
        jTextoEvolucao.setWrapStyleWord(true);
    }

    public void corCampos() {
        jCodigoPAI.setBackground(Color.white);
        jComboBoxStatusPAI.setBackground(Color.white);
        jDataPAI.setBackground(Color.white);
        jIdInternoPAI.setBackground(Color.white);
        jNomeInternoPAI.setBackground(Color.white);
        jNomeMaeInternoPAI.setBackground(Color.white);
        jNomePaiInternoPAI.setBackground(Color.white);
        jFotoInternoPAI.setBackground(Color.white);
        JRGInternoPAI.setBackground(Color.white);
        jCPFInternoPAI.setBackground(Color.white);
        jCartaoSUSPAI.setBackground(Color.white);
        jDataNascimentoPAI.setBackground(Color.white);
        jIdadeInterno.setBackground(Color.white);
        jDataEntradaInternoPAI.setBackground(Color.white);
        jEstadoCivilInternoPAI.setBackground(Color.white);
        jSexoInternoPAI.setBackground(Color.white);
        jOrientacaoSexual.setBackground(Color.white);
        jNaturalidadeInternoPAI.setBackground(Color.white);
        jCorEtiniaInternoPAI.setBackground(Color.white);
        jEnderecoResidencial.setBackground(Color.white);
        // S.S.1
        jComboBoxRegulaDocumento.setBackground(Color.white);
        jComboBoxCertidaoNasc.setBackground(Color.white);
        jComboBoxRG.setBackground(Color.white);
        jComboBoxCPF.setBackground(Color.white);
        jComboBoxCTPS.setBackground(Color.white);
        jOutrosDocumentos.setBackground(Color.white);
        jQuantosFilhosMaiores21.setBackground(Color.white);
        jComboBoxFilhosSemRegistros.setBackground(Color.white);
        jQuantosFilhosSemRegistros.setBackground(Color.white);
        jQuantosFilhosMenores21.setBackground(Color.white);
        jObservacaoFilhos.setBackground(Color.white);
        jComboBoxVulnerabilidadeSocial.setBackground(Color.white);
        jComboBoxAtendeCondiPrevistas.setBackground(Color.white);
        jComboBoxProgramaSocial.setBackground(Color.white);
        jQualProgramaSocial.setBackground(Color.white);
        jComboBoxIntervencaoPrograma.setBackground(Color.white);
        jComboBoxLocalizacaoFamiliares.setBackground(Color.white);
        jObservacaoParticipacaoFamilia.setBackground(Color.white);
        //S.S.2
        jIdFamiliarPAI.setBackground(Color.white);
        jNomeFamiliarPAI.setBackground(Color.white);
        jIdadeFamiliarPAI.setBackground(Color.white);
        jComboBoxVinculoPAI.setBackground(Color.white);
        jOcupacaoFamiliarPAI.setBackground(Color.white);
        jEnderecoTelefonePAI.setBackground(Color.white);
        //
        jIdVisitaPAI.setBackground(Color.white);
        jNomeVisitaPAI.setBackground(Color.white);
        jOcupacaoVisita.setBackground(Color.white);
        jParentescoPAI.setBackground(Color.white);
        jIdadeVisita.setBackground(Color.white);
        //
        jIdVisitaIntima.setBackground(Color.white);
        jNomeVisitaIntima.setBackground(Color.white);
        jParentescoVisitaIntima.setBackground(Color.white);
        jOcupacaoVisitaIntima.setBackground(Color.white);
        jIdadeVisitaIntima.setBackground(Color.white);
        // TO/Ped
        jEscolaridadeInternoPAI.setBackground(Color.white);
        jComboBoxDemandaEscolar.setBackground(Color.white);
        jComboBoxFrequentaEscola.setBackground(Color.white);
        jQualEscola.setBackground(Color.white);
        jObservacaoEstudos.setBackground(Color.white);
        jProfissaoInternoPAI.setBackground(Color.white);
        jComboBoxParticipaAtividadeLab.setBackground(Color.white);
        jQualAtividadeLab.setBackground(Color.white);
        jObservacaoLaborativa.setBackground(Color.white);
        jComboBoxDemandaQualiProf.setBackground(Color.white);
        jQualQualificacaoProf.setBackground(Color.white);
        jComboBoxExperienciaTrab.setBackground(Color.white);
        jQualExperiencia.setBackground(Color.white);
        jHabilidades.setBackground(Color.white);
        jComboBoxPartAtivEsporte.setBackground(Color.white);
        jQualAtividadeEsporte.setBackground(Color.white);
        jComboBoxDemandaEsporte.setBackground(Color.white);
        jComboBoxEsporte.setBackground(Color.white);
        jQualEsporte.setBackground(Color.white);
        jComboBoxLazer.setBackground(Color.white);
        jQualLazer.setBackground(Color.white);
        jComboBoxCultura.setBackground(Color.white);
        jQualCultura.setBackground(Color.white);
        // PSI
        jComboBoxTranstornoMental.setBackground(Color.white);
        jComboBoxTratamentoAnterior.setBackground(Color.white);
        jComboBoxQuaisTratamentosMentais.setBackground(Color.white);
        jOutrosTratamento.setBackground(Color.white);
        jComboBoxFoiInternado.setBackground(Color.white);
        jEspecificarFrequenciasLocais.setBackground(Color.white);
        jMedicacoesUtilizadas.setBackground(Color.white);
        jComboBoxEpisodioDepressivo.setBackground(Color.white);
        jComboBoxSurtoPsicotico.setBackground(Color.white);
        jComboBoxTentativaSuicidio.setBackground(Color.white);
        jComboBoxComportamentoViolento.setBackground(Color.white);
        jComboBoxEnvolveJustica.setBackground(Color.white);
        jComboBoxUsoMedicaPsiquia.setBackground(Color.white);
        jObservacaoDepressivo.setBackground(Color.white);
        jObservacaoSurto.setBackground(Color.white);
        jObservacaoTentativaSuicidio.setBackground(Color.white);
        jObservacaoComportamentoViolento.setBackground(Color.white);
        jObservacaoEnvolveJustica.setBackground(Color.white);
        jObservacaoUsoMedicacoPsiquiatrica.setBackground(Color.white);
        //P.M.
        jComboBoxFamiliaTranstornoMental.setBackground(Color.white);
        jQuemTranstornoMental.setBackground(Color.white);
        jQualTranstornoMental.setBackground(Color.white);
        jComboBoxNecessidadePSI.setBackground(Color.white);
        jComboBoxFazUsoDroga.setBackground(Color.white);
        jQuaisDrogas.setBackground(Color.white);
        jComboBoxCompartilhaDrogas.setBackground(Color.white);
        jComboBoxReducaoDanos.setBackground(Color.white);
        jPorqueReduzDanos.setBackground(Color.white);
        jComboBoxAceitaProgramasDanos.setBackground(Color.white);
        jPorqueAceitaProgroReduDanos.setBackground(Color.white);
        jComboBoxQueixaProbSaude.setBackground(Color.white);
        jQuaisOutrasDoencas.setBackground(Color.white);
        jComboBoxProblemasSaudeBucal.setBackground(Color.white);
        jComboBoxFazTratamentoBucal.setBackground(Color.white);
        jQuaisTratamentoBucal.setBackground(Color.white);
        // CRC/EAPI
        jDescricaoUnidadePenal.setBackground(Color.white);
        jMatriculaPenal.setBackground(Color.white);
        jPavilhão.setBackground(Color.white);
        jCela.setBackground(Color.white);
        jAlcunha.setBackground(Color.white);
        jRegimePenal.setBackground(Color.white);
        jArtigo.setBackground(Color.white);
        jTempPenaSentenca.setBackground(Color.white);
        jTempoPenaCumprida.setBackground(Color.white);
        jComboBoxAssistenciaJuridica.setBackground(Color.white);
        jTempoPenaACumprir.setBackground(Color.white);
        jComboBoxReintegraSistemaPenal.setBackground(Color.white);
        jSituacaoJuridica.setBackground(Color.white);
        jDataEntradaSistemaPenal.setBackground(Color.white);
        jComboBoxDefensorPublico.setBackground(Color.white);
        jComboBoxOutroDefensor.setBackground(Color.white);
        jQualDefensor.setBackground(Color.white);
        jTextoPSP.setBackground(Color.white);
        //S.S.3
        jTextoCEDEGEP.setBackground(Color.white);
        jTextoCRASCREAS.setBackground(Color.white);
        jTextoASSISTENCIA.setBackground(Color.white);
        jTextoDOCUMENTOCIVIL.setBackground(Color.white);
        jDataInclusaoPAI.setBackground(Color.white);
        jTecnicoServicoSocial.setBackground(Color.white);
        jTecnicoPsicologico.setBackground(Color.white);
       // EVOLUÇÃO PAI
        jIdEvolucao.setBackground(Color.white);
        jDataEvolucao.setBackground(Color.white);
        jNomeInternoEvolucaoPAI.setBackground(Color.white);
        jTextoEvolucao.setBackground(Color.white);
    }

    public void Novo() {
        jCodigoPAI.setText("");
        jComboBoxStatusPAI.setSelectedItem("Ativo");
        jDataPAI.setCalendar(Calendar.getInstance());
        jIdInternoPAI.setText("");
        jNomeInternoPAI.setText("");
        jNomeMaeInternoPAI.setText("");
        jNomePaiInternoPAI.setText("");
        jFotoInternoPAI.setIcon(null);
        JRGInternoPAI.setText("");
        jCPFInternoPAI.setText("");
        jCartaoSUSPAI.setText("");
        jDataNascimentoPAI.setDate(null);
        jIdadeInterno.setText("");
        jDataEntradaInternoPAI.setDate(null);
        jEstadoCivilInternoPAI.setText("");
        jSexoInternoPAI.setText("");
        jOrientacaoSexual.setText("");
        jNaturalidadeInternoPAI.setText("");
        jCorEtiniaInternoPAI.setText("");
        jEnderecoResidencial.setText("");
        //
        jComboBoxStatusPAI.setEnabled(true);
        jDataPAI.setEnabled(true);
        jIdadeInterno.setEnabled(true);
        jOrientacaoSexual.setEnabled(true);
        jEnderecoResidencial.setEnabled(true);
        //
        jBtPesquisarInternoPAI.setEnabled(true);
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(!true);
        // EVOLUÇÃO PAI
        jIdEvolucao.setBackground(Color.white);
        jDataEvolucao.setBackground(Color.white);
        jNomeInternoEvolucaoPAI.setBackground(Color.white);
        jTextoEvolucao.setBackground(Color.white);
    }

    public void Alterar() {
        jComboBoxStatusPAI.setEnabled(true);
        jDataPAI.setEnabled(true);
        jIdadeInterno.setEnabled(true);
        jOrientacaoSexual.setEnabled(true);
        jEnderecoResidencial.setEnabled(true);
        //
        jBtPesquisarInternoPAI.setEnabled(true);
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoria.setEnabled(!true);
    }

    public void Excluir() {
        jCodigoPAI.setText("");
        jComboBoxStatusPAI.setSelectedItem("Ativo");
        jDataPAI.setDate(null);
        jIdInternoPAI.setText("");
        jNomeInternoPAI.setText("");
        jNomeMaeInternoPAI.setText("");
        jNomePaiInternoPAI.setText("");
        jFotoInternoPAI.setIcon(null);
        JRGInternoPAI.setText("");
        jCPFInternoPAI.setText("");
        jCartaoSUSPAI.setText("");
        jDataNascimentoPAI.setDate(null);
        jIdadeInterno.setText("");
        jDataEntradaInternoPAI.setDate(null);
        jEstadoCivilInternoPAI.setText("");
        jSexoInternoPAI.setText("");
        jOrientacaoSexual.setText("");
        jNaturalidadeInternoPAI.setText("");
        jCorEtiniaInternoPAI.setText("");
        jEnderecoResidencial.setText("");
        //
        jComboBoxStatusPAI.setEnabled(!true);
        jDataPAI.setEnabled(!true);
        jIdadeInterno.setEnabled(!true);
        jOrientacaoSexual.setEnabled(!true);
        jEnderecoResidencial.setEnabled(!true);
        //
        jBtPesquisarInternoPAI.setEnabled(!true);
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void Salvar() {
        jComboBoxStatusPAI.setEnabled(!true);
        jDataPAI.setEnabled(!true);
        jIdadeInterno.setEnabled(!true);
        jOrientacaoSexual.setEnabled(!true);
        jEnderecoResidencial.setEnabled(!true);
        //
        jBtPesquisarInternoPAI.setEnabled(!true);
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        // BOTÕES DE NOVO DAS ABAS
        jBtNovoSS.setEnabled(true);
        jBtNovoFamiliar.setEnabled(true);
        jBtNovaVisita.setEnabled(true);
        jBtNovaVisitaIntima.setEnabled(true);
        jBtNovoTO.setEnabled(true);
        jBtNovoPSI.setEnabled(true);
        jBtNovoPM.setEnabled(true);
        jBtNovoCRC.setEnabled(true);
        jBtNovoSS3.setEnabled(true);
    }

    public void Cancelar() {
        if (jCodigoPAI.getText().equals("")) {
            jComboBoxStatusPAI.setSelectedItem("Ativo");
            jDataPAI.setDate(null);
            jIdInternoPAI.setText("");
            jNomeInternoPAI.setText("");
            jNomeMaeInternoPAI.setText("");
            jNomePaiInternoPAI.setText("");
            jFotoInternoPAI.setIcon(null);
            JRGInternoPAI.setText("");
            jCPFInternoPAI.setText("");
            jCartaoSUSPAI.setText("");
            jDataNascimentoPAI.setDate(null);
            jIdadeInterno.setText("");
            jDataEntradaInternoPAI.setDate(null);
            jEstadoCivilInternoPAI.setText("");
            jSexoInternoPAI.setText("");
            jOrientacaoSexual.setText("");
            jNaturalidadeInternoPAI.setText("");
            jCorEtiniaInternoPAI.setText("");
            jEnderecoResidencial.setText("");
            //
            jComboBoxStatusPAI.setEnabled(!true);
            jDataPAI.setEnabled(!true);
            jIdadeInterno.setEnabled(!true);
            jOrientacaoSexual.setEnabled(!true);
            jEnderecoResidencial.setEnabled(!true);
            //
            jBtPesquisarInternoPAI.setEnabled(!true);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(!true);
        } else {
            jComboBoxStatusPAI.setEnabled(!true);
            jDataPAI.setEnabled(!true);
            jIdadeInterno.setEnabled(!true);
            jOrientacaoSexual.setEnabled(!true);
            jEnderecoResidencial.setEnabled(!true);
            //
            jBtPesquisarInternoPAI.setEnabled(!true);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoria.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PAI_PSICOSOCIAL "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=PAI_PSICOSOCIAL.IdInternoCrc "
                        + "INNER JOIN DADOSFISICOSINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN CIDADES "
                        + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                        + "WHERE IdPai='" + jCodigoPAI.getText() + "'");
                conecta.rs.first();
                jCodigoPAI.setText(String.valueOf(conecta.rs.getInt("IdPai")));
                jComboBoxStatusPAI.setSelectedItem(conecta.rs.getString("StatusPai"));
                jDataPAI.setDate(conecta.rs.getDate("DataPai"));
                jIdInternoPAI.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoPAI.setText(conecta.rs.getString("NomeInternoCrc"));
                jNomeMaeInternoPAI.setText(conecta.rs.getString("MaeInternoCrc"));
                jNomePaiInternoPAI.setText(conecta.rs.getString("PaiInternoCrc"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoPAI.setIcon(i);
                jFotoInternoPAI.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoPAI.getWidth(), jFotoInternoPAI.getHeight(), Image.SCALE_DEFAULT)));
                JRGInternoPAI.setText(conecta.rs.getString("RgInternoCrc"));
                jCPFInternoPAI.setText(conecta.rs.getString("CpfInternoCrc"));
                jCartaoSUSPAI.setText(conecta.rs.getString("CartaoSus"));
                jDataNascimentoPAI.setDate(conecta.rs.getDate("DataNasciCrc"));
                jIdadeInterno.setText(conecta.rs.getString("IdadeInterno"));
                jDataEntradaInternoPAI.setDate(conecta.rs.getDate("DataEntrada"));
                jEstadoCivilInternoPAI.setText(conecta.rs.getString("EstadoCivilCrc"));
                jSexoInternoPAI.setText(conecta.rs.getString("SexoCrc"));
                jOrientacaoSexual.setText(conecta.rs.getString("OrientacaoSexual"));
                jNaturalidadeInternoPAI.setText(conecta.rs.getString("NomeCidade"));
                jCorEtiniaInternoPAI.setText(conecta.rs.getString("Cutis"));
                jEnderecoResidencial.setText(conecta.rs.getString("DadosPessoais"));
                //
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados..." + e);
            }
            conecta.desconecta();
        }
    }

    public void limparCamposNovo() {
        // S.S.1
        jComboBoxRegulaDocumento.setSelectedItem("Não");
        jComboBoxCertidaoNasc.setSelectedItem("Não");
        jComboBoxRG.setSelectedItem("Não");
        jComboBoxCPF.setSelectedItem("Não");
        jComboBoxCTPS.setSelectedItem("Não");
        jOutrosDocumentos.setText("");
        jQuantosFilhosMaiores21.setText("");
        jComboBoxFilhosSemRegistros.setSelectedItem("Não");
        jQuantosFilhosSemRegistros.setText("");
        jQuantosFilhosMenores21.setText("");
        jObservacaoFilhos.setText("");
        jComboBoxVulnerabilidadeSocial.setSelectedItem("Não");
        jComboBoxAtendeCondiPrevistas.setSelectedItem("Não");
        jComboBoxProgramaSocial.setSelectedItem(null);
        jQualProgramaSocial.setText("");
        jRadioButtonRazoavel.setSelected(true);
        jComboBoxIntervencaoPrograma.setSelectedItem("Não");
        jComboBoxLocalizacaoFamiliares.setSelectedItem("Localizar Familiares");
        jObservacaoParticipacaoFamilia.setText("");
        //
        jBtNovoSS.setEnabled(!true);
        jBtAlterarSS.setEnabled(!true);
        jBtExcluirSS.setEnabled(!true);
        jBtSalvarSS.setEnabled(!true);
        jBtCancelarSS.setEnabled(!true);
        jBtAuditoriaSS.setEnabled(!true);
        //S.S.2
        jIdFamiliarPAI.setText("");
        jNomeFamiliarPAI.setText("");
        jIdadeFamiliarPAI.setText("");
        jComboBoxVinculoPAI.setSelectedItem(null);
        jOcupacaoFamiliarPAI.setText("");
        jEnderecoTelefonePAI.setText("");
        jIdVisitaPAI.setText("");
        jNomeVisitaPAI.setText("");
        jParentescoPAI.setText("");
        jIdVisitaIntima.setText("");
        jNomeVisitaIntima.setText("");
        jParentescoVisitaIntima.setText("");
        jIdadeVisita.setText("");
        jIdadeVisitaIntima.setText("");
        jOcupacaoVisita.setText("");
        jOcupacaoVisitaIntima.setText("");
        // FAMILIAR        
        jBtNovoFamiliar.setEnabled(!true);
        jBtAlterarFamiliar.setEnabled(!true);
        jBtExcluirFamiliar.setEnabled(!true);
        jBtSalvarFamiliar.setEnabled(!true);
        jBtCancelarFamiliar.setEnabled(!true);
        jBtAuditoriaFamiliar.setEnabled(!true);
        // VISITA
        jBtPesqVisita.setEnabled(!true);
        jBtPesqVisitaIntima.setEnabled(!true);
        jBtNovaVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
        // VISITA INTIMA
        jBtNovaVisitaIntima.setEnabled(!true);
        jBtAlterarVisitaIntima.setEnabled(!true);
        jBtExcluirVisitaIntima.setEnabled(!true);
        jBtSalvarVisitaIntima.setEnabled(!true);
        jBtCancelarVisitaIntima.setEnabled(!true);
        jBtAuditoriaVisitaIntima.setEnabled(!true);
        // TO/Ped
        jEscolaridadeInternoPAI.setText("");
        jComboBoxDemandaEscolar.setSelectedItem("Não");
        jComboBoxFrequentaEscola.setSelectedItem("Não");
        jQualEscola.setText("");
        jRadioButtonAnalfabeto.setSelected(true);
        jObservacaoEstudos.setText("");
        jProfissaoInternoPAI.setText("");
        jComboBoxParticipaAtividadeLab.setSelectedItem("Não");
        jQualAtividadeLab.setText("");
        jObservacaoLaborativa.setText("");
        jComboBoxDemandaQualiProf.setSelectedItem("Não");
        jQualQualificacaoProf.setText("");
        jComboBoxExperienciaTrab.setSelectedItem("Não");
        jQualExperiencia.setText("");
        jHabilidades.setText("");
        jComboBoxPartAtivEsporte.setSelectedItem("Não");
        jQualAtividadeEsporte.setText("");
        jComboBoxDemandaEsporte.setSelectedItem("Não");
        jComboBoxEsporte.setSelectedItem("Não");
        jQualEsporte.setText("");
        jComboBoxLazer.setSelectedItem("Não");
        jQualLazer.setText("");
        jComboBoxCultura.setSelectedItem("Não");
        jQualCultura.setText("");
        //
        jBtNovoTO.setEnabled(!true);
        jBtAlterarTO.setEnabled(!true);
        jBtExcluirTO.setEnabled(!true);
        jBtSalvarTO.setEnabled(!true);
        jBtCancelarTO.setEnabled(!true);
        jBtAuditoriaTO.setEnabled(!true);
        // PSI
        jComboBoxTranstornoMental.setSelectedItem("Não");
        jComboBoxTratamentoAnterior.setSelectedItem("Não");
        jComboBoxQuaisTratamentosMentais.setSelectedItem("Selecione...");
        jOutrosTratamento.setText("");
        jComboBoxFoiInternado.setSelectedItem("Não");
        jEspecificarFrequenciasLocais.setText("");
        jMedicacoesUtilizadas.setText("");
        jComboBoxEpisodioDepressivo.setSelectedItem("Não");
        jComboBoxSurtoPsicotico.setSelectedItem("Não");
        jComboBoxTentativaSuicidio.setSelectedItem("Não");
        jComboBoxComportamentoViolento.setSelectedItem("Não");
        jComboBoxEnvolveJustica.setSelectedItem("Não");
        jComboBoxUsoMedicaPsiquia.setSelectedItem("Não");
        jObservacaoDepressivo.setText("");
        jObservacaoSurto.setText("");
        jObservacaoTentativaSuicidio.setText("");
        jObservacaoComportamentoViolento.setText("");
        jObservacaoEnvolveJustica.setText("");
        jObservacaoUsoMedicacoPsiquiatrica.setText("");
        //
        jBtNovoPSI.setEnabled(!true);
        jBtAlterarPSI.setEnabled(!true);
        jBtExcluirPSI.setEnabled(!true);
        jBtSalvarPSI.setEnabled(!true);
        jBtCancelarPSI.setEnabled(!true);
        jBtAuditoriaPSI.setEnabled(!true);
        //P.M.
        jComboBoxFamiliaTranstornoMental.setSelectedItem("Não");
        jQuemTranstornoMental.setText("");
        jQualTranstornoMental.setText("");
        jComboBoxNecessidadePSI.setSelectedItem("Não");
        jCheckBoxConsultaPSI.setSelected(!true);
        jCheckBoxAcompanhaPSI.setSelected(!true);
        jComboBoxFazUsoDroga.setSelectedItem("Não");
        jQuaisDrogas.setText("");
        jComboBoxCompartilhaDrogas.setSelectedItem("Não");
        jComboBoxReducaoDanos.setSelectedItem("Não");
        jPorqueReduzDanos.setText("");
        jComboBoxAceitaProgramasDanos.setSelectedItem("Não");
        jPorqueAceitaProgroReduDanos.setText("");
        jComboBoxQueixaProbSaude.setSelectedItem("Não");
        //
        jCheckBoxHipertensao.setSelected(!true);
        jCheckBoxDiabetes.setSelected(!true);
        jCheckBoxTuberculose.setSelected(!true);
        jCheckBoxDST.setSelected(!true);
        jCheckBoxHepatite.setSelected(!true);
        jCheckBoxHanseniase.setSelected(!true);
        jCheckBoxOutrasDoencas.setSelected(!true);
        jQuaisOutrasDoencas.setText("");
        jComboBoxProblemasSaudeBucal.setSelectedItem("Não");
        jComboBoxFazTratamentoBucal.setSelectedItem("Não");
        jQuaisTratamentoBucal.setText("");
        //
        jBtNovoPM.setEnabled(!true);
        jBtAlterarPM.setEnabled(!true);
        jBtExcluirPM.setEnabled(!true);
        jBtSalvarPM.setEnabled(!true);
        jBtCancelarPM.setEnabled(!true);
        jBtAuditoriaPM.setEnabled(!true);
        // CRC/EAPI
        jDescricaoUnidadePenal.setText("");
        jMatriculaPenal.setText("");
        jPavilhão.setText("");
        jCela.setText("");
        jAlcunha.setText("");
        jRegimePenal.setText("");
        jArtigo.setText("");
        jTempPenaSentenca.setText("");
        jTempoPenaCumprida.setText("");
        jComboBoxAssistenciaJuridica.setSelectedItem("Não");
        jTempoPenaACumprir.setText("");
        jComboBoxReintegraSistemaPenal.setSelectedItem("Não");
        jSituacaoJuridica.setText("");
        jDataEntradaSistemaPenal.setDate(null);
        jComboBoxDefensorPublico.setSelectedItem("Não");
        jComboBoxOutroDefensor.setSelectedItem("Não");
        jQualDefensor.setText("");
        jTextoPSP.setText("");
        //
        jBtNovoCRC.setEnabled(!true);
        jBtAlterarCRC.setEnabled(!true);
        jBtExcluirCRC.setEnabled(!true);
        jBtSalvarCRC.setEnabled(!true);
        jBtCancelarCRC.setEnabled(!true);
        jBtAuditoriaCRC.setEnabled(!true);
        //S.S.3
        jTextoCEDEGEP.setText("");
        jTextoCRASCREAS.setText("");
        jTextoASSISTENCIA.setText("");
        jTextoDOCUMENTOCIVIL.setText("");
        jDataInclusaoPAI.setDate(null);
        jTecnicoServicoSocial.setText("");
        jTecnicoPsicologico.setText("");
        //
        jBtNovoSS3.setEnabled(!true);
        jBtAlterarSS3.setEnabled(!true);
        jBtExcluirSS3.setEnabled(!true);
        jBtSalvarSS3.setEnabled(!true);
        jBtCancelarSS3.setEnabled(!true);
        jBtAuditoriaSS3.setEnabled(!true);
         // EVOLUÇÃO PAI
        jDataEvolucao.setDate(null);
        jTextoEvolucao.setText("");
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);      
    }

    public void bloquearCamposManutencao() {
        jComboBoxStatusPAI.setEnabled(!true);
        jDataPAI.setEnabled(!true);
        jIdadeInterno.setEnabled(!true);
        jOrientacaoSexual.setEnabled(!true);
        jEnderecoResidencial.setEnabled(!true);
    }

    public void bloquearCampos() {
        // S.S.1
        jComboBoxRegulaDocumento.setEnabled(!true);
        jComboBoxCertidaoNasc.setEnabled(!true);
        jComboBoxRG.setEnabled(!true);
        jComboBoxCPF.setEnabled(!true);
        jComboBoxCTPS.setEnabled(!true);
        jOutrosDocumentos.setEnabled(!true);
        jQuantosFilhosMaiores21.setEnabled(!true);
        jComboBoxFilhosSemRegistros.setEnabled(!true);
        jQuantosFilhosSemRegistros.setEnabled(!true);
        jQuantosFilhosMenores21.setEnabled(!true);
        jObservacaoFilhos.setEnabled(!true);
        jComboBoxVulnerabilidadeSocial.setEnabled(!true);
        jComboBoxAtendeCondiPrevistas.setEnabled(!true);
        jComboBoxProgramaSocial.setEnabled(!true);
        jQualProgramaSocial.setEnabled(!true);
        jRadioButtonRazoavel.setEnabled(!true);
        jComboBoxIntervencaoPrograma.setEnabled(!true);
        jComboBoxLocalizacaoFamiliares.setEnabled(!true);
        jObservacaoParticipacaoFamilia.setEnabled(!true);
        //S.S.2
        jIdFamiliarPAI.setEnabled(!true);
        jNomeFamiliarPAI.setEnabled(!true);
        jIdadeFamiliarPAI.setEnabled(!true);
        jComboBoxVinculoPAI.setEnabled(!true);
        jOcupacaoFamiliarPAI.setEnabled(!true);
        jEnderecoTelefonePAI.setEnabled(!true);
        jIdadeVisita.setEnabled(!true);
        jIdadeVisitaIntima.setEnabled(!true);
        jOcupacaoVisita.setEnabled(!true);
        jOcupacaoVisitaIntima.setEnabled(!true);
        // TO/Ped
        jEscolaridadeInternoPAI.setEnabled(!true);
        jComboBoxDemandaEscolar.setEnabled(!true);
        jComboBoxFrequentaEscola.setEnabled(!true);
        jQualEscola.setEnabled(!true);
        jRadioButtonAnalfabeto.setEnabled(!true);
        jRadioButtonFundamental1.setEnabled(!true);
        jRadioButtonFundamental2.setEnabled(!true);
        jRadioButtonEnsinoMedio.setEnabled(!true);
        jRadioButtonSuperiorIncompleto.setEnabled(!true);
        jRadioButtonSuperiorCompleto.setEnabled(!true);
        jObservacaoEstudos.setEnabled(!true);
        jProfissaoInternoPAI.setEnabled(!true);
        jComboBoxParticipaAtividadeLab.setEnabled(!true);
        jQualAtividadeLab.setEnabled(!true);
        jObservacaoLaborativa.setEnabled(!true);
        jComboBoxDemandaQualiProf.setEnabled(!true);
        jQualQualificacaoProf.setEnabled(!true);
        jComboBoxExperienciaTrab.setEnabled(!true);
        jQualExperiencia.setEnabled(!true);
        jHabilidades.setEnabled(!true);
        jComboBoxPartAtivEsporte.setEnabled(!true);
        jQualAtividadeEsporte.setEnabled(!true);
        jComboBoxDemandaEsporte.setEnabled(!true);
        jComboBoxEsporte.setEnabled(!true);
        jQualEsporte.setEnabled(!true);
        jComboBoxLazer.setEnabled(!true);
        jQualLazer.setEnabled(!true);
        jComboBoxCultura.setEnabled(!true);
        jQualCultura.setEnabled(!true);
        // PSI
        jComboBoxTranstornoMental.setEnabled(!true);
        jComboBoxTratamentoAnterior.setEnabled(!true);
        jComboBoxQuaisTratamentosMentais.setEnabled(!true);
        jOutrosTratamento.setEnabled(!true);
        jComboBoxFoiInternado.setEnabled(!true);
        jEspecificarFrequenciasLocais.setEnabled(!true);
        jMedicacoesUtilizadas.setEnabled(!true);
        jComboBoxEpisodioDepressivo.setEnabled(!true);
        jComboBoxSurtoPsicotico.setEnabled(!true);
        jComboBoxTentativaSuicidio.setEnabled(!true);
        jComboBoxComportamentoViolento.setEnabled(!true);
        jComboBoxEnvolveJustica.setEnabled(!true);
        jComboBoxUsoMedicaPsiquia.setEnabled(!true);
        jObservacaoDepressivo.setEnabled(!true);
        jObservacaoSurto.setEnabled(!true);
        jObservacaoTentativaSuicidio.setEnabled(!true);
        jObservacaoComportamentoViolento.setEnabled(!true);
        jObservacaoEnvolveJustica.setEnabled(!true);
        jObservacaoUsoMedicacoPsiquiatrica.setEnabled(!true);
        //P.M.
        jComboBoxFamiliaTranstornoMental.setEnabled(!true);
        jQuemTranstornoMental.setEnabled(!true);
        jQualTranstornoMental.setEnabled(!true);
        jComboBoxNecessidadePSI.setEnabled(!true);
        jCheckBoxConsultaPSI.setEnabled(!true);
        jCheckBoxAcompanhaPSI.setEnabled(!true);
        jComboBoxFazUsoDroga.setEnabled(!true);
        jQuaisDrogas.setEnabled(!true);
        jComboBoxCompartilhaDrogas.setEnabled(!true);
        jComboBoxReducaoDanos.setEnabled(!true);
        jPorqueReduzDanos.setEnabled(!true);
        jComboBoxAceitaProgramasDanos.setEnabled(!true);
        jPorqueAceitaProgroReduDanos.setEnabled(!true);
        jComboBoxQueixaProbSaude.setEnabled(!true);
        jCheckBoxHipertensao.setEnabled(!true);
        jCheckBoxDiabetes.setEnabled(!true);
        jCheckBoxTuberculose.setEnabled(!true);
        jCheckBoxDST.setEnabled(!true);
        jCheckBoxHepatite.setEnabled(!true);
        jCheckBoxHanseniase.setEnabled(!true);
        jCheckBoxOutrasDoencas.setEnabled(!true);
        jQuaisOutrasDoencas.setEnabled(!true);
        jComboBoxProblemasSaudeBucal.setEnabled(!true);
        jComboBoxFazTratamentoBucal.setEnabled(!true);
        jQuaisTratamentoBucal.setEnabled(!true);
        // CRC/EAPI
        jDescricaoUnidadePenal.setEnabled(!true);
        jMatriculaPenal.setEnabled(!true);
        jPavilhão.setEnabled(!true);
        jCela.setEnabled(!true);
        jAlcunha.setEnabled(!true);
        jRegimePenal.setEnabled(!true);
        jArtigo.setEnabled(!true);
        jTempPenaSentenca.setEnabled(!true);
        jTempoPenaCumprida.setEnabled(!true);
        jComboBoxAssistenciaJuridica.setEnabled(!true);
        jTempoPenaACumprir.setEnabled(!true);
        jComboBoxReintegraSistemaPenal.setEnabled(!true);
        jSituacaoJuridica.setEnabled(!true);
        jDataEntradaSistemaPenal.setEnabled(!true);
        jComboBoxDefensorPublico.setEnabled(!true);
        jComboBoxOutroDefensor.setEnabled(!true);
        jQualDefensor.setEnabled(!true);
        jTextoPSP.setEnabled(!true);
        //S.S.3
        jTextoCEDEGEP.setEnabled(!true);
        jTextoCRASCREAS.setEnabled(!true);
        jTextoASSISTENCIA.setEnabled(!true);
        jTextoDOCUMENTOCIVIL.setEnabled(!true);
        jDataInclusaoPAI.setEnabled(!true);
        jTecnicoServicoSocial.setEnabled(!true);
        jTecnicoPsicologico.setEnabled(!true);
        // EVOLUÇÃO PAI
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucao.setEnabled(!true);
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAI_PSICOSOCIAL");
            conecta.rs.last();
            jCodigoPAI.setText(conecta.rs.getString("IdPai"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void verificarExistenciaInternoPAI() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAI_PSICOSOCIAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON PAI_PSICOSOCIAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE PAI_PSICOSOCIAL.IdInternoCrc='" + jIdInternoPAI.getText() + "'");
            conecta.rs.first();
            codigoInternoPAI = conecta.rs.getString("IdInternoCrc");
            nomeMaeInterno = conecta.rs.getString("MaeInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarCodigoPAI() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SOCIAL1_PAI_PSICOSOCIAL WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            idPaiSS1 = conecta.rs.getString("IdPai");
            //
            conecta.executaSQL("SELECT * FROM SOCIAL2_PAI_PSICOSOCIAL WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            idPaiSS2 = conecta.rs.getString("IdPai");
            //
            conecta.executaSQL("SELECT * FROM SOCIAL2_FAMILIAR_PSICOSOCIAL WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            idPaiSS2f = conecta.rs.getString("IdPai");
            //
            conecta.executaSQL("SELECT * FROM SOCIAL2_VISITA_INTIMA_PSICOSOCIAL WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            idPaiSS2vi = conecta.rs.getString("IdPai");
            //
            conecta.executaSQL("SELECT * FROM TERAPIA_PEDAGOGIA_PSICOSOCIAL WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            idPaiTera = conecta.rs.getString("IdPai");
            //
            conecta.executaSQL("SELECT * FROM PSICOLOGIA_PAI_PSICOSOCIAL WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            idPaiPsico = conecta.rs.getString("IdPai");
            //
            conecta.executaSQL("SELECT * FROM PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            idPaiPsicoMed = conecta.rs.getString("IdPai");
            //
            conecta.executaSQL("SELECT * FROM EAPI_CRC_PAI_PSICOSOCIAL WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            idPaiEapi = conecta.rs.getString("IdPai");
            //
            conecta.executaSQL("SELECT * FROM SS3_PAI_PSICOSOCIAL WHERE IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            idPaiSS3 = conecta.rs.getString("IdPai");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoSS() {
        jComboBoxRegulaDocumento.setSelectedItem("Não");
        jComboBoxCertidaoNasc.setSelectedItem("Não");
        jComboBoxRG.setSelectedItem("Não");
        jComboBoxCPF.setSelectedItem("Não");
        jComboBoxCTPS.setSelectedItem("Não");
        jOutrosDocumentos.setText("");
        jQuantosFilhosMaiores21.setText("0");
        jComboBoxFilhosSemRegistros.setSelectedItem("Não");
        jQuantosFilhosSemRegistros.setText("0");
        jQuantosFilhosMenores21.setText("0");
        jObservacaoFilhos.setText("");
        jComboBoxVulnerabilidadeSocial.setSelectedItem("Não");
        jComboBoxAtendeCondiPrevistas.setSelectedItem("Não");
        jComboBoxProgramaSocial.setSelectedItem(null);
        jQualProgramaSocial.setText("");
        jRadioButtonRazoavel.setSelected(true);
        jComboBoxIntervencaoPrograma.setSelectedItem("Não");
        jComboBoxLocalizacaoFamiliares.setSelectedItem("Localizar Familiares");
        jObservacaoParticipacaoFamilia.setText("");
        //
        jBtNovoSS.setEnabled(!true);
        jBtAlterarSS.setEnabled(!true);
        jBtExcluirSS.setEnabled(!true);
        jBtSalvarSS.setEnabled(true);
        jBtCancelarSS.setEnabled(true);
        jBtAuditoriaSS.setEnabled(!true);
        //
        jComboBoxRegulaDocumento.setEnabled(true);
        jComboBoxCertidaoNasc.setEnabled(true);
        jComboBoxRG.setEnabled(true);
        jComboBoxCPF.setEnabled(true);
        jComboBoxCTPS.setEnabled(true);
        jOutrosDocumentos.setEnabled(true);
        jQuantosFilhosMaiores21.setEnabled(true);
        jComboBoxFilhosSemRegistros.setEnabled(true);
        jQuantosFilhosSemRegistros.setEnabled(true);
        jQuantosFilhosMenores21.setEnabled(true);
        jObservacaoFilhos.setEnabled(true);
        jComboBoxVulnerabilidadeSocial.setEnabled(true);
        jComboBoxAtendeCondiPrevistas.setEnabled(true);
        jComboBoxProgramaSocial.setEnabled(true);
        jQualProgramaSocial.setEnabled(true);
        jRadioButtonNula.setEnabled(true);
        jRadioButtonRazoavel.setEnabled(true);
        jRadioButtonInsuficiente.setEnabled(true);
        jRadioButtonMuitoBoa.setEnabled(true);
        jComboBoxIntervencaoPrograma.setEnabled(true);
        jComboBoxLocalizacaoFamiliares.setEnabled(true);
        jObservacaoParticipacaoFamilia.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void AlterarSS() {
        jBtNovoSS.setEnabled(!true);
        jBtAlterarSS.setEnabled(!true);
        jBtExcluirSS.setEnabled(!true);
        jBtSalvarSS.setEnabled(true);
        jBtCancelarSS.setEnabled(true);
        jBtAuditoriaSS.setEnabled(!true);
        //
        jComboBoxRegulaDocumento.setEnabled(true);
        jComboBoxCertidaoNasc.setEnabled(true);
        jComboBoxRG.setEnabled(true);
        jComboBoxCPF.setEnabled(true);
        jComboBoxCTPS.setEnabled(true);
        jOutrosDocumentos.setEnabled(true);
        jQuantosFilhosMaiores21.setEnabled(true);
        jComboBoxFilhosSemRegistros.setEnabled(true);
        jQuantosFilhosSemRegistros.setEnabled(true);
        jQuantosFilhosMenores21.setEnabled(true);
        jObservacaoFilhos.setEnabled(true);
        jComboBoxVulnerabilidadeSocial.setEnabled(true);
        jComboBoxAtendeCondiPrevistas.setEnabled(true);
        jComboBoxProgramaSocial.setEnabled(true);
        jQualProgramaSocial.setEnabled(true);
        jRadioButtonNula.setEnabled(true);
        jRadioButtonRazoavel.setEnabled(true);
        jRadioButtonInsuficiente.setEnabled(true);
        jRadioButtonMuitoBoa.setEnabled(true);;
        jComboBoxIntervencaoPrograma.setEnabled(true);
        jComboBoxLocalizacaoFamiliares.setEnabled(true);
        jObservacaoParticipacaoFamilia.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(!true);
    }

    public void ExcluirSS() {
        jComboBoxRegulaDocumento.setSelectedItem("Não");
        jComboBoxCertidaoNasc.setSelectedItem("Não");
        jComboBoxRG.setSelectedItem("Não");
        jComboBoxCPF.setSelectedItem("Não");
        jComboBoxCTPS.setSelectedItem("Não");
        jOutrosDocumentos.setText("");
        jQuantosFilhosMaiores21.setText("0");
        jComboBoxFilhosSemRegistros.setSelectedItem("Não");
        jQuantosFilhosSemRegistros.setText("0");
        jQuantosFilhosMenores21.setText("0");
        jObservacaoFilhos.setText("");
        jComboBoxVulnerabilidadeSocial.setSelectedItem("Não");
        jComboBoxAtendeCondiPrevistas.setSelectedItem("Não");
        jComboBoxProgramaSocial.setSelectedItem(null);
        jQualProgramaSocial.setText("");
        jRadioButtonRazoavel.setSelected(true);
        jComboBoxIntervencaoPrograma.setSelectedItem("Não");
        jComboBoxLocalizacaoFamiliares.setSelectedItem("Localizar Familiares");
        jObservacaoParticipacaoFamilia.setText("");
        //
        jBtNovoSS.setEnabled(true);
        jBtAlterarSS.setEnabled(!true);
        jBtExcluirSS.setEnabled(!true);
        jBtSalvarSS.setEnabled(!true);
        jBtCancelarSS.setEnabled(!true);
        jBtAuditoriaSS.setEnabled(!true);
        //
        jComboBoxRegulaDocumento.setEnabled(!true);
        jComboBoxCertidaoNasc.setEnabled(!true);
        jComboBoxRG.setEnabled(!true);
        jComboBoxCPF.setEnabled(!true);
        jComboBoxCTPS.setEnabled(!true);
        jOutrosDocumentos.setEnabled(!true);
        jQuantosFilhosMaiores21.setEnabled(!true);
        jComboBoxFilhosSemRegistros.setEnabled(!true);
        jQuantosFilhosSemRegistros.setEnabled(!true);
        jQuantosFilhosMenores21.setEnabled(!true);
        jObservacaoFilhos.setEnabled(!true);
        jComboBoxVulnerabilidadeSocial.setEnabled(!true);
        jComboBoxAtendeCondiPrevistas.setEnabled(!true);
        jComboBoxProgramaSocial.setEnabled(!true);
        jQualProgramaSocial.setEnabled(!true);
        jRadioButtonNula.setEnabled(!true);
        jRadioButtonRazoavel.setEnabled(!true);
        jRadioButtonInsuficiente.setEnabled(!true);
        jRadioButtonMuitoBoa.setEnabled(!true);
        jComboBoxIntervencaoPrograma.setEnabled(!true);
        jComboBoxLocalizacaoFamiliares.setEnabled(!true);
        jObservacaoParticipacaoFamilia.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void SalvarSS() {
        // S.S.1
        jBtNovoSS.setEnabled(true);
        jBtAlterarSS.setEnabled(true);
        jBtExcluirSS.setEnabled(true);
        jBtSalvarSS.setEnabled(!true);
        jBtCancelarSS.setEnabled(!true);
        jBtAuditoriaSS.setEnabled(true);
        //
        jComboBoxRegulaDocumento.setEnabled(!true);
        jComboBoxCertidaoNasc.setEnabled(!true);
        jComboBoxRG.setEnabled(!true);
        jComboBoxCPF.setEnabled(!true);
        jComboBoxCTPS.setEnabled(!true);
        jOutrosDocumentos.setEnabled(!true);
        jQuantosFilhosMaiores21.setEnabled(!true);
        jComboBoxFilhosSemRegistros.setEnabled(!true);
        jQuantosFilhosSemRegistros.setEnabled(!true);
        jQuantosFilhosMenores21.setEnabled(!true);
        jObservacaoFilhos.setEnabled(!true);
        jComboBoxVulnerabilidadeSocial.setEnabled(!true);
        jComboBoxAtendeCondiPrevistas.setEnabled(!true);
        jComboBoxProgramaSocial.setEnabled(!true);
        jQualProgramaSocial.setEnabled(!true);
        jRadioButtonNula.setEnabled(!true);
        jRadioButtonRazoavel.setEnabled(!true);
        jRadioButtonInsuficiente.setEnabled(!true);
        jRadioButtonMuitoBoa.setEnabled(!true);
        jComboBoxIntervencaoPrograma.setEnabled(!true);
        jComboBoxLocalizacaoFamiliares.setEnabled(!true);
        jObservacaoParticipacaoFamilia.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarSS() {
        // S.S.1
        jBtNovoSS.setEnabled(true);
        jBtAlterarSS.setEnabled(!true);
        jBtExcluirSS.setEnabled(!true);
        jBtSalvarSS.setEnabled(!true);
        jBtCancelarSS.setEnabled(!true);
        jBtAuditoriaSS.setEnabled(!true);
        //
        jComboBoxRegulaDocumento.setEnabled(!true);
        jComboBoxCertidaoNasc.setEnabled(!true);
        jComboBoxRG.setEnabled(!true);
        jComboBoxCPF.setEnabled(!true);
        jComboBoxCTPS.setEnabled(!true);
        jOutrosDocumentos.setEnabled(!true);
        jQuantosFilhosMaiores21.setEnabled(!true);
        jComboBoxFilhosSemRegistros.setEnabled(!true);
        jQuantosFilhosSemRegistros.setEnabled(!true);
        jQuantosFilhosMenores21.setEnabled(!true);
        jObservacaoFilhos.setEnabled(!true);
        jComboBoxVulnerabilidadeSocial.setEnabled(!true);
        jComboBoxAtendeCondiPrevistas.setEnabled(!true);
        jComboBoxProgramaSocial.setEnabled(!true);
        jQualProgramaSocial.setEnabled(!true);
        jRadioButtonNula.setEnabled(!true);
        jRadioButtonRazoavel.setEnabled(!true);
        jRadioButtonInsuficiente.setEnabled(!true);
        jRadioButtonMuitoBoa.setEnabled(!true);
        jComboBoxIntervencaoPrograma.setEnabled(!true);
        jComboBoxLocalizacaoFamiliares.setEnabled(!true);
        jObservacaoParticipacaoFamilia.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        // S.S.1 CASO O REGISTRO JÁ EXISTA MOSTRA
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SOCIAL1_PAI_PSICOSOCIAL "
                    + "INNER JOIN PAI_PSICOSOCIAL "
                    + "ON SOCIAL1_PAI_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                    + "WHERE SOCIAL1_PAI_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoSS1 = conecta.rs.getInt("IdPaiSS1");
            jComboBoxRegulaDocumento.setSelectedItem(conecta.rs.getString("DocumentoCivil"));
            jComboBoxCertidaoNasc.setSelectedItem(conecta.rs.getString("CNascimento"));
            jComboBoxRG.setSelectedItem(conecta.rs.getString("RG"));
            jComboBoxCPF.setSelectedItem(conecta.rs.getString("CPF"));
            jComboBoxCTPS.setSelectedItem(conecta.rs.getString("CTPS"));
            jOutrosDocumentos.setText(conecta.rs.getString("OutrosDoc"));
            jQuantosFilhosMaiores21.setText(conecta.rs.getString("QtdFilhosMaior"));
            jComboBoxFilhosSemRegistros.setSelectedItem(conecta.rs.getString("FilhosSemRegistros"));
            jQuantosFilhosSemRegistros.setText(conecta.rs.getString("QtdFilhosSemRegistro"));
            jQuantosFilhosMenores21.setText(conecta.rs.getString("QtdFilhosMenor"));
            jObservacaoFilhos.setText(conecta.rs.getString("ObservacaoFilhos"));
            jComboBoxVulnerabilidadeSocial.setSelectedItem(conecta.rs.getString("VulnerabilidaSocial"));
            jComboBoxAtendeCondiPrevistas.setSelectedItem(conecta.rs.getString("AtendePrevistas"));
            jComboBoxProgramaSocial.setSelectedItem(conecta.rs.getString("InseriProgramaSocial"));
            jQualProgramaSocial.setText(conecta.rs.getString("QualProgramaSocial"));
            cumpimentoFamiliaPena = conecta.rs.getInt("PartFamiliaCumpre");
            if (cumpimentoFamiliaPena == 0) {
                jRadioButtonNula.setSelected(true);
            } else if (cumpimentoFamiliaPena == 1) {
                jRadioButtonInsuficiente.setSelected(true);
            } else if (cumpimentoFamiliaPena == 2) {
                jRadioButtonRazoavel.setSelected(true);
            } else if (cumpimentoFamiliaPena == 3) {
                jRadioButtonMuitoBoa.setSelected(true);
            }
            jComboBoxIntervencaoPrograma.setSelectedItem(conecta.rs.getString("IntervencaoPrograma"));
            jComboBoxLocalizacaoFamiliares.setSelectedItem(conecta.rs.getString("LocalizacaoFamiliares"));
            jObservacaoParticipacaoFamilia.setText(conecta.rs.getString("ObservacaoParticipacaoFamilia"));
            if (codigoSS1 != 0) {
                jBtNovoSS.setEnabled(true);
                jBtAlterarSS.setEnabled(true);
                jBtExcluirSS.setEnabled(true);
                jBtSalvarSS.setEnabled(!true);
                jBtCancelarSS.setEnabled(!true);
                jBtAuditoriaSS.setEnabled(true);
            }
        } catch (Exception e) {

        }
        conecta.desconecta();
    }

    public void verificarSS1() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SOCIAL1_PAI_PSICOSOCIAL "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoPAI.getText() + "'");
            conecta.rs.first();
            codigoPaiSS1 = conecta.rs.getString("IdPai");
            codigoInternoSS1 = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoFamiliar() {
        //S.S.2
        jIdFamiliarPAI.setText("");
        jNomeFamiliarPAI.setText("");
        jIdadeFamiliarPAI.setText("");
        jComboBoxVinculoPAI.setSelectedItem(null);
        jOcupacaoFamiliarPAI.setText("");
        jEnderecoTelefonePAI.setText("");
        //
        jNomeFamiliarPAI.setEnabled(true);
        jIdadeFamiliarPAI.setEnabled(true);
        jComboBoxVinculoPAI.setEnabled(true);
        jOcupacaoFamiliarPAI.setEnabled(true);
        jEnderecoTelefonePAI.setEnabled(true);
        // FAMILIAR        
        jBtNovoFamiliar.setEnabled(!true);
        jBtAlterarFamiliar.setEnabled(!true);
        jBtExcluirFamiliar.setEnabled(!true);
        jBtSalvarFamiliar.setEnabled(true);
        jBtCancelarFamiliar.setEnabled(true);
        jBtAuditoriaFamiliar.setEnabled(!true);
    }

    public void AlterarFamiliar() {
        jNomeFamiliarPAI.setEnabled(true);
        jIdadeFamiliarPAI.setEnabled(true);
        jComboBoxVinculoPAI.setEnabled(true);
        jOcupacaoFamiliarPAI.setEnabled(true);
        jEnderecoTelefonePAI.setEnabled(true);
        // FAMILIAR        
        jBtNovoFamiliar.setEnabled(!true);
        jBtAlterarFamiliar.setEnabled(!true);
        jBtExcluirFamiliar.setEnabled(!true);
        jBtSalvarFamiliar.setEnabled(true);
        jBtCancelarFamiliar.setEnabled(true);
        jBtAuditoriaFamiliar.setEnabled(!true);
    }

    public void ExcluirFamiliar() {
        jIdFamiliarPAI.setText("");
        jNomeFamiliarPAI.setText("");
        jIdadeFamiliarPAI.setText("");
        jComboBoxVinculoPAI.setSelectedItem(null);
        jOcupacaoFamiliarPAI.setText("");
        jEnderecoTelefonePAI.setText("");
        //
        jNomeFamiliarPAI.setEnabled(!true);
        jIdadeFamiliarPAI.setEnabled(!true);
        jComboBoxVinculoPAI.setEnabled(!true);
        jOcupacaoFamiliarPAI.setEnabled(!true);
        jEnderecoTelefonePAI.setEnabled(!true);
        // FAMILIAR        
        jBtNovoFamiliar.setEnabled(true);
        jBtAlterarFamiliar.setEnabled(!true);
        jBtExcluirFamiliar.setEnabled(!true);
        jBtSalvarFamiliar.setEnabled(!true);
        jBtCancelarFamiliar.setEnabled(!true);
        jBtAuditoriaFamiliar.setEnabled(!true);
    }

    public void SalvarFamiliar() {
        jIdFamiliarPAI.setText("");
        jNomeFamiliarPAI.setText("");
        jIdadeFamiliarPAI.setText("");
        jComboBoxVinculoPAI.setSelectedItem(null);
        jOcupacaoFamiliarPAI.setText("");
        jEnderecoTelefonePAI.setText("");
        //
        jNomeFamiliarPAI.setEnabled(!true);
        jIdadeFamiliarPAI.setEnabled(!true);
        jComboBoxVinculoPAI.setEnabled(!true);
        jOcupacaoFamiliarPAI.setEnabled(!true);
        jEnderecoTelefonePAI.setEnabled(!true);
        // FAMILIAR        
        jBtNovoFamiliar.setEnabled(true);
        jBtAlterarFamiliar.setEnabled(!true);
        jBtExcluirFamiliar.setEnabled(!true);
        jBtSalvarFamiliar.setEnabled(!true);
        jBtCancelarFamiliar.setEnabled(!true);
        jBtAuditoriaFamiliar.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarFamiliar() {
        jIdFamiliarPAI.setText("");
        jNomeFamiliarPAI.setText("");
        jIdadeFamiliarPAI.setText("");
        jComboBoxVinculoPAI.setSelectedItem(null);
        jOcupacaoFamiliarPAI.setText("");
        jEnderecoTelefonePAI.setText("");
        //
        jNomeFamiliarPAI.setEnabled(!true);
        jIdadeFamiliarPAI.setEnabled(!true);
        jComboBoxVinculoPAI.setEnabled(!true);
        jOcupacaoFamiliarPAI.setEnabled(!true);
        jEnderecoTelefonePAI.setEnabled(!true);
        // FAMILIAR        
        jBtNovoFamiliar.setEnabled(true);
        jBtAlterarFamiliar.setEnabled(!true);
        jBtExcluirFamiliar.setEnabled(!true);
        jBtSalvarFamiliar.setEnabled(!true);
        jBtCancelarFamiliar.setEnabled(!true);
        jBtAuditoriaFamiliar.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void buscarCodigoFamiliar() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SOCIAL2_PAI_PSICOSOCIAL");
            conecta.rs.last();
            jIdFamiliarPAI.setText(conecta.rs.getString("IdFamiliar"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
    }

    public void NovaVisita() {
        jIdVisitaPAI.setText("");
        jNomeVisitaPAI.setText("");
        jOcupacaoVisita.setText("");
        jParentescoPAI.setText("");
        jIdadeVisita.setText("");
        //
        jOcupacaoVisita.setEnabled(true);
        jIdadeVisita.setEnabled(true);
        //
        jBtPesqVisita.setEnabled(true);
        //
        jBtNovaVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(true);
        jBtCancelarVisita.setEnabled(true);
        jBtAuditoriaVisita.setEnabled(!true);
    }

    public void AlterarVisita() {
        jOcupacaoVisita.setEnabled(true);
        jIdadeVisita.setEnabled(true);
        //
        jBtPesqVisita.setEnabled(true);
        //
        jBtNovaVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(true);
        jBtCancelarVisita.setEnabled(true);
        jBtAuditoriaVisita.setEnabled(!true);
    }

    public void ExcluirVisita() {
        jIdVisitaPAI.setText("");
        jNomeVisitaPAI.setText("");
        jOcupacaoVisita.setText("");
        jParentescoPAI.setText("");
        jIdadeVisita.setText("");
        //
        jOcupacaoVisita.setEnabled(!true);
        jIdadeVisita.setEnabled(!true);
        //
        jBtPesqVisita.setEnabled(!true);
        //
        jBtNovaVisita.setEnabled(true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
    }

    public void SalvarVisita() {
        jIdVisitaPAI.setText("");
        jNomeVisitaPAI.setText("");
        jOcupacaoVisita.setText("");
        jParentescoPAI.setText("");
        jIdadeVisita.setText("");
        //
        jOcupacaoVisita.setEnabled(!true);
        jIdadeVisita.setEnabled(!true);
        //
        jBtPesqVisita.setEnabled(!true);
        //
        jBtNovaVisita.setEnabled(true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarVisita() {
        jIdVisitaPAI.setText("");
        jNomeVisitaPAI.setText("");
        jOcupacaoVisita.setText("");
        jParentescoPAI.setText("");
        jIdadeVisita.setText("");
        //
        jOcupacaoVisita.setEnabled(!true);
        jIdadeVisita.setEnabled(!true);
        //
        jBtPesqVisita.setEnabled(!true);
        //
        jBtNovaVisita.setEnabled(true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void NovaVisitaIntima() {
        jIdVisitaIntima.setText("");
        jNomeVisitaIntima.setText("");
        jOcupacaoVisitaIntima.setText("");
        jParentescoVisitaIntima.setText("");
        jIdadeVisitaIntima.setText("");
        //
        jOcupacaoVisitaIntima.setEnabled(true);
        jIdadeVisitaIntima.setEnabled(true);
        //
        jBtPesqVisitaIntima.setEnabled(true);
        //
        jBtNovaVisitaIntima.setEnabled(!true);
        jBtAlterarVisitaIntima.setEnabled(!true);
        jBtExcluirVisitaIntima.setEnabled(!true);
        jBtSalvarVisitaIntima.setEnabled(true);
        jBtCancelarVisitaIntima.setEnabled(true);
        jBtAuditoriaVisitaIntima.setEnabled(!true);
    }

    public void AlterarVisitaIntima() {
        jOcupacaoVisitaIntima.setEnabled(true);
        jIdadeVisitaIntima.setEnabled(true);
        //
        jBtPesqVisitaIntima.setEnabled(true);
        //
        jBtNovaVisitaIntima.setEnabled(!true);
        jBtAlterarVisitaIntima.setEnabled(!true);
        jBtExcluirVisitaIntima.setEnabled(!true);
        jBtSalvarVisitaIntima.setEnabled(true);
        jBtCancelarVisitaIntima.setEnabled(true);
        jBtAuditoriaVisitaIntima.setEnabled(!true);
    }

    public void ExcluirVisitaIntima() {
        jIdVisitaIntima.setText("");
        jNomeVisitaIntima.setText("");
        jOcupacaoVisitaIntima.setText("");
        jParentescoVisitaIntima.setText("");
        jIdadeVisitaIntima.setText("");
        //
        jOcupacaoVisitaIntima.setEnabled(!true);
        jIdadeVisitaIntima.setEnabled(!true);
        //
        jBtPesqVisitaIntima.setEnabled(!true);
        //
        jBtNovaVisitaIntima.setEnabled(true);
        jBtAlterarVisitaIntima.setEnabled(!true);
        jBtExcluirVisitaIntima.setEnabled(!true);
        jBtSalvarVisitaIntima.setEnabled(!true);
        jBtCancelarVisitaIntima.setEnabled(!true);
        jBtAuditoriaVisitaIntima.setEnabled(!true);
    }

    public void SalvarVisitaIntima() {
        jIdVisitaIntima.setText("");
        jNomeVisitaIntima.setText("");
        jOcupacaoVisitaIntima.setText("");
        jParentescoVisitaIntima.setText("");
        jIdadeVisitaIntima.setText("");
        //
        jOcupacaoVisitaIntima.setEnabled(!true);
        jIdadeVisitaIntima.setEnabled(!true);
        //
        jBtPesqVisitaIntima.setEnabled(!true);
        //
        jBtNovaVisitaIntima.setEnabled(true);
        jBtAlterarVisitaIntima.setEnabled(!true);
        jBtExcluirVisitaIntima.setEnabled(!true);
        jBtSalvarVisitaIntima.setEnabled(!true);
        jBtCancelarVisitaIntima.setEnabled(!true);
        jBtAuditoriaVisitaIntima.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarVisitaIntima() {
        jIdVisitaIntima.setText("");
        jNomeVisitaIntima.setText("");
        jOcupacaoVisitaIntima.setText("");
        jParentescoVisitaIntima.setText("");
        jIdadeVisitaIntima.setText("");
        //
        jOcupacaoVisitaIntima.setEnabled(!true);
        jIdadeVisitaIntima.setEnabled(!true);
        //
        jBtPesqVisitaIntima.setEnabled(!true);
        //
        jBtNovaVisitaIntima.setEnabled(true);
        jBtAlterarVisitaIntima.setEnabled(!true);
        jBtExcluirVisitaIntima.setEnabled(!true);
        jBtSalvarVisitaIntima.setEnabled(!true);
        jBtCancelarVisitaIntima.setEnabled(!true);
        jBtAuditoriaVisitaIntima.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void NovoTOPed() {
        // TO/Ped
        jEscolaridadeInternoPAI.setText("");
        jComboBoxDemandaEscolar.setSelectedItem("Não");
        jComboBoxFrequentaEscola.setSelectedItem("Não");
        jQualEscola.setText("");
        jRadioButtonAnalfabeto.setSelected(true);
        jObservacaoEstudos.setText("");
        jProfissaoInternoPAI.setText("");
        jComboBoxParticipaAtividadeLab.setSelectedItem("Não");
        jQualAtividadeLab.setText("");
        jObservacaoLaborativa.setText("");
        jComboBoxDemandaQualiProf.setSelectedItem("Não");
        jQualQualificacaoProf.setText("");
        jComboBoxExperienciaTrab.setSelectedItem("Não");
        jQualExperiencia.setText("");
        jHabilidades.setText("");
        jComboBoxPartAtivEsporte.setSelectedItem("Não");
        jQualAtividadeEsporte.setText("");
        jComboBoxDemandaEsporte.setSelectedItem("Não");
        jComboBoxEsporte.setSelectedItem("Não");
        jQualEsporte.setText("");
        jComboBoxLazer.setSelectedItem("Não");
        jQualLazer.setText("");
        jComboBoxCultura.setSelectedItem("Não");
        jQualCultura.setText("");
        //
        jEscolaridadeInternoPAI.setEnabled(true);
        jComboBoxDemandaEscolar.setEnabled(true);
        jComboBoxFrequentaEscola.setEnabled(true);
        jQualEscola.setEnabled(true);
        jRadioButtonAnalfabeto.setEnabled(true);
        jRadioButtonFundamental1.setEnabled(true);
        jRadioButtonFundamental2.setEnabled(true);
        jRadioButtonEnsinoMedio.setEnabled(true);
        jRadioButtonSuperiorIncompleto.setEnabled(true);
        jRadioButtonSuperiorCompleto.setEnabled(true);
        jObservacaoEstudos.setEnabled(true);
        jProfissaoInternoPAI.setEnabled(true);
        jComboBoxParticipaAtividadeLab.setEnabled(true);
        jQualAtividadeLab.setEnabled(true);
        jObservacaoLaborativa.setEnabled(true);
        jComboBoxDemandaQualiProf.setEnabled(true);
        jQualQualificacaoProf.setEnabled(true);
        jComboBoxExperienciaTrab.setEnabled(true);
        jQualExperiencia.setEnabled(true);
        jHabilidades.setEnabled(true);
        jComboBoxPartAtivEsporte.setEnabled(true);
        jQualAtividadeEsporte.setEnabled(true);
        jComboBoxDemandaEsporte.setEnabled(true);
        jComboBoxEsporte.setEnabled(true);
        jQualEsporte.setEnabled(true);
        jComboBoxLazer.setEnabled(true);
        jQualLazer.setEnabled(true);
        jComboBoxCultura.setEnabled(true);
        jQualCultura.setEnabled(true);
        //
        jBtNovoTO.setEnabled(!true);
        jBtAlterarTO.setEnabled(!true);
        jBtExcluirTO.setEnabled(!true);
        jBtSalvarTO.setEnabled(true);
        jBtCancelarTO.setEnabled(true);
        jBtAuditoriaTO.setEnabled(!true);
    }

    public void AlterarTOPed() {
        jEscolaridadeInternoPAI.setEnabled(true);
        jComboBoxDemandaEscolar.setEnabled(true);
        jComboBoxFrequentaEscola.setEnabled(true);
        jQualEscola.setEnabled(true);
        jRadioButtonAnalfabeto.setEnabled(true);
        jRadioButtonFundamental1.setEnabled(true);
        jRadioButtonFundamental2.setEnabled(true);
        jRadioButtonEnsinoMedio.setEnabled(true);
        jRadioButtonSuperiorIncompleto.setEnabled(true);
        jRadioButtonSuperiorCompleto.setEnabled(true);
        jObservacaoEstudos.setEnabled(true);
        jProfissaoInternoPAI.setEnabled(true);
        jComboBoxParticipaAtividadeLab.setEnabled(true);
        jQualAtividadeLab.setEnabled(true);
        jObservacaoLaborativa.setEnabled(true);
        jComboBoxDemandaQualiProf.setEnabled(true);
        jQualQualificacaoProf.setEnabled(true);
        jComboBoxExperienciaTrab.setEnabled(true);
        jQualExperiencia.setEnabled(true);
        jHabilidades.setEnabled(true);
        jComboBoxPartAtivEsporte.setEnabled(true);
        jQualAtividadeEsporte.setEnabled(true);
        jComboBoxDemandaEsporte.setEnabled(true);
        jComboBoxEsporte.setEnabled(true);
        jQualEsporte.setEnabled(true);
        jComboBoxLazer.setEnabled(true);
        jQualLazer.setEnabled(true);
        jComboBoxCultura.setEnabled(true);
        jQualCultura.setEnabled(true);
        //
        jBtNovoTO.setEnabled(!true);
        jBtAlterarTO.setEnabled(!true);
        jBtExcluirTO.setEnabled(!true);
        jBtSalvarTO.setEnabled(true);
        jBtCancelarTO.setEnabled(true);
        jBtAuditoriaTO.setEnabled(!true);
    }

    public void ExcluirTOPed() {
        // TO/Ped
        jEscolaridadeInternoPAI.setText("");
        jComboBoxDemandaEscolar.setSelectedItem("Não");
        jComboBoxFrequentaEscola.setSelectedItem("Não");
        jQualEscola.setText("");
        jRadioButtonAnalfabeto.setSelected(true);
        jObservacaoEstudos.setText("");
        jProfissaoInternoPAI.setText("");
        jComboBoxParticipaAtividadeLab.setSelectedItem("Não");
        jQualAtividadeLab.setText("");
        jObservacaoLaborativa.setText("");
        jComboBoxDemandaQualiProf.setSelectedItem("Não");
        jQualQualificacaoProf.setText("");
        jComboBoxExperienciaTrab.setSelectedItem("Não");
        jQualExperiencia.setText("");
        jHabilidades.setText("");
        jComboBoxPartAtivEsporte.setSelectedItem("Não");
        jQualAtividadeEsporte.setText("");
        jComboBoxDemandaEsporte.setSelectedItem("Não");
        jComboBoxEsporte.setSelectedItem("Não");
        jQualEsporte.setText("");
        jComboBoxLazer.setSelectedItem("Não");
        jQualLazer.setText("");
        jComboBoxCultura.setSelectedItem("Não");
        jQualCultura.setText("");
        //
        jEscolaridadeInternoPAI.setEnabled(!true);
        jComboBoxDemandaEscolar.setEnabled(!true);
        jComboBoxFrequentaEscola.setEnabled(!true);
        jQualEscola.setEnabled(!true);
        jRadioButtonAnalfabeto.setEnabled(!true);
        jRadioButtonFundamental1.setEnabled(!true);
        jRadioButtonFundamental2.setEnabled(!true);
        jRadioButtonEnsinoMedio.setEnabled(!true);
        jRadioButtonSuperiorIncompleto.setEnabled(!true);
        jRadioButtonSuperiorCompleto.setEnabled(!true);
        jObservacaoEstudos.setEnabled(!true);
        jProfissaoInternoPAI.setEnabled(!true);
        jComboBoxParticipaAtividadeLab.setEnabled(!true);
        jQualAtividadeLab.setEnabled(!true);
        jObservacaoLaborativa.setEnabled(!true);
        jComboBoxDemandaQualiProf.setEnabled(!true);
        jQualQualificacaoProf.setEnabled(!true);
        jComboBoxExperienciaTrab.setEnabled(!true);
        jQualExperiencia.setEnabled(!true);
        jHabilidades.setEnabled(!true);
        jComboBoxPartAtivEsporte.setEnabled(!true);
        jQualAtividadeEsporte.setEnabled(!true);
        jComboBoxDemandaEsporte.setEnabled(!true);
        jComboBoxEsporte.setEnabled(!true);
        jQualEsporte.setEnabled(!true);
        jComboBoxLazer.setEnabled(!true);
        jQualLazer.setEnabled(!true);
        jComboBoxCultura.setEnabled(!true);
        jQualCultura.setEnabled(!true);
        //
        jBtNovoTO.setEnabled(true);
        jBtAlterarTO.setEnabled(!true);
        jBtExcluirTO.setEnabled(!true);
        jBtSalvarTO.setEnabled(!true);
        jBtCancelarTO.setEnabled(!true);
        jBtAuditoriaTO.setEnabled(!true);
    }

    public void SalvarTOPed() {
        jEscolaridadeInternoPAI.setEnabled(!true);
        jComboBoxDemandaEscolar.setEnabled(!true);
        jComboBoxFrequentaEscola.setEnabled(!true);
        jQualEscola.setEnabled(!true);
        jRadioButtonAnalfabeto.setEnabled(!true);
        jRadioButtonFundamental1.setEnabled(!true);
        jRadioButtonFundamental2.setEnabled(!true);
        jRadioButtonEnsinoMedio.setEnabled(!true);
        jRadioButtonSuperiorIncompleto.setEnabled(!true);
        jRadioButtonSuperiorCompleto.setEnabled(!true);
        jObservacaoEstudos.setEnabled(!true);
        jProfissaoInternoPAI.setEnabled(!true);
        jComboBoxParticipaAtividadeLab.setEnabled(!true);
        jQualAtividadeLab.setEnabled(!true);
        jObservacaoLaborativa.setEnabled(!true);
        jComboBoxDemandaQualiProf.setEnabled(!true);
        jQualQualificacaoProf.setEnabled(!true);
        jComboBoxExperienciaTrab.setEnabled(!true);
        jQualExperiencia.setEnabled(!true);
        jHabilidades.setEnabled(!true);
        jComboBoxPartAtivEsporte.setEnabled(!true);
        jQualAtividadeEsporte.setEnabled(!true);
        jComboBoxDemandaEsporte.setEnabled(!true);
        jComboBoxEsporte.setEnabled(!true);
        jQualEsporte.setEnabled(!true);
        jComboBoxLazer.setEnabled(!true);
        jQualLazer.setEnabled(!true);
        jComboBoxCultura.setEnabled(!true);
        jQualCultura.setEnabled(!true);
        //
        jBtNovoTO.setEnabled(true);
        jBtAlterarTO.setEnabled(true);
        jBtExcluirTO.setEnabled(true);
        jBtSalvarTO.setEnabled(!true);
        jBtCancelarTO.setEnabled(!true);
        jBtAuditoriaTO.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarTOPed() {
        jEscolaridadeInternoPAI.setEnabled(!true);
        jComboBoxDemandaEscolar.setEnabled(!true);
        jComboBoxFrequentaEscola.setEnabled(!true);
        jQualEscola.setEnabled(!true);
        jRadioButtonAnalfabeto.setEnabled(!true);
        jRadioButtonFundamental1.setEnabled(!true);
        jRadioButtonFundamental2.setEnabled(!true);
        jRadioButtonEnsinoMedio.setEnabled(!true);
        jRadioButtonSuperiorIncompleto.setEnabled(!true);
        jRadioButtonSuperiorCompleto.setEnabled(!true);
        jObservacaoEstudos.setEnabled(!true);
        jProfissaoInternoPAI.setEnabled(!true);
        jComboBoxParticipaAtividadeLab.setEnabled(!true);
        jQualAtividadeLab.setEnabled(!true);
        jObservacaoLaborativa.setEnabled(!true);
        jComboBoxDemandaQualiProf.setEnabled(!true);
        jQualQualificacaoProf.setEnabled(!true);
        jComboBoxExperienciaTrab.setEnabled(!true);
        jQualExperiencia.setEnabled(!true);
        jHabilidades.setEnabled(!true);
        jComboBoxPartAtivEsporte.setEnabled(!true);
        jQualAtividadeEsporte.setEnabled(!true);
        jComboBoxDemandaEsporte.setEnabled(!true);
        jComboBoxEsporte.setEnabled(!true);
        jQualEsporte.setEnabled(!true);
        jComboBoxLazer.setEnabled(!true);
        jQualLazer.setEnabled(!true);
        jComboBoxCultura.setEnabled(!true);
        jQualCultura.setEnabled(!true);
        //
        jBtNovoTO.setEnabled(true);
        jBtAlterarTO.setEnabled(!true);
        jBtExcluirTO.setEnabled(!true);
        jBtSalvarTO.setEnabled(!true);
        jBtCancelarTO.setEnabled(!true);
        jBtAuditoriaTO.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TERAPIA_PEDAGOGIA_PSICOSOCIAL "
                    + "INNER JOIN PAI_PSICOSOCIAL "
                    + "ON TERAPIA_PEDAGOGIA_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                    + "WHERE TERAPIA_PEDAGOGIA_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            // TO/Ped
            jEscolaridadeInternoPAI.setText(conecta.rs.getString("Escolaridade"));
            jComboBoxDemandaEscolar.setSelectedItem(conecta.rs.getString("DemandaEscolar"));
            jComboBoxFrequentaEscola.setSelectedItem(conecta.rs.getString("FrequnetaEscola"));
            jQualEscola.setText(conecta.rs.getString("QualEscola"));
            codInstrucao = conecta.rs.getInt("Instrucao");
            if (codInstrucao == 0) {
                jRadioButtonAnalfabeto.setSelected(true);
            } else if (codInstrucao == 1) {
                jRadioButtonFundamental1.setSelected(true);
            } else if (codInstrucao == 2) {
                jRadioButtonFundamental2.setSelected(true);
            } else if (codInstrucao == 3) {
                jRadioButtonSuperiorIncompleto.setSelected(true);
            } else if (codInstrucao == 4) {
                jRadioButtonSuperiorCompleto.setSelected(true);
            }
            jObservacaoEstudos.setText(conecta.rs.getString("ObservacaoTOPED"));
            jProfissaoInternoPAI.setText(conecta.rs.getString("Profissao"));
            jComboBoxParticipaAtividadeLab.setSelectedItem(conecta.rs.getString("ParticipaLabor"));
            jQualAtividadeLab.setText(conecta.rs.getString("QualLabor"));
            jObservacaoLaborativa.setText(conecta.rs.getString("ObservacaoLabor"));
            jComboBoxDemandaQualiProf.setSelectedItem(conecta.rs.getString("DemandaQualiProf"));
            jQualQualificacaoProf.setText(conecta.rs.getString("QualDemanda"));
            jComboBoxExperienciaTrab.setSelectedItem(conecta.rs.getString("ExperienciaTrabRenda"));
            jQualExperiencia.setText(conecta.rs.getString("QualExperiencia"));
            jHabilidades.setText(conecta.rs.getString("Habilidades"));
            jComboBoxPartAtivEsporte.setSelectedItem(conecta.rs.getString("ParticipaAtividade"));
            jQualAtividadeEsporte.setText(conecta.rs.getString("QuaisAtividades"));
            jComboBoxDemandaEsporte.setSelectedItem(conecta.rs.getString("DemandaParticaCultura"));
            jComboBoxEsporte.setSelectedItem(conecta.rs.getString("Esporte"));
            jQualEsporte.setText(conecta.rs.getString("QualEsporte"));
            jComboBoxLazer.setSelectedItem(conecta.rs.getString("Lazer"));
            jQualLazer.setText(conecta.rs.getString("QualLazer"));
            jComboBoxCultura.setSelectedItem(conecta.rs.getString("Cultura"));
            jQualCultura.setText(conecta.rs.getString("QualCultura"));
            if (codTeraPed != 0) {
                jBtNovoTO.setEnabled(true);
                jBtAlterarTO.setEnabled(true);
                jBtExcluirTO.setEnabled(true);
                jBtSalvarTO.setEnabled(!true);
                jBtCancelarTO.setEnabled(!true);
                jBtAuditoriaTO.setEnabled(true);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void buscarCodTOPED() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TERAPIA_PEDAGOGIA_PSICOSOCIAL");
            conecta.rs.last();
            codTeraPed = conecta.rs.getInt("IdToPed");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarTOPED() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TERAPIA_PEDAGOGIA_PSICOSOCIAL "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoPAI.getText() + "'");
            conecta.rs.first();
            codigoPaiTOPED = conecta.rs.getString("IdPai");
            codigoInternoTOPED = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoPSI() {
        jComboBoxTranstornoMental.setSelectedItem("Não");
        jComboBoxTratamentoAnterior.setSelectedItem("Não");
        jComboBoxQuaisTratamentosMentais.setSelectedItem("Selecione...");
        jOutrosTratamento.setText("");
        jComboBoxFoiInternado.setSelectedItem("Não");
        jEspecificarFrequenciasLocais.setText("");
        jMedicacoesUtilizadas.setText("");
        jComboBoxEpisodioDepressivo.setSelectedItem("Não");
        jComboBoxSurtoPsicotico.setSelectedItem("Não");
        jComboBoxTentativaSuicidio.setSelectedItem("Não");
        jComboBoxComportamentoViolento.setSelectedItem("Não");
        jComboBoxEnvolveJustica.setSelectedItem("Não");
        jComboBoxUsoMedicaPsiquia.setSelectedItem("Não");
        jObservacaoDepressivo.setText("");
        jObservacaoSurto.setText("");
        jObservacaoTentativaSuicidio.setText("");
        jObservacaoComportamentoViolento.setText("");
        jObservacaoEnvolveJustica.setText("");
        jObservacaoUsoMedicacoPsiquiatrica.setText("");
        //
        jComboBoxTranstornoMental.setEnabled(true);
        jComboBoxTratamentoAnterior.setEnabled(true);
        jComboBoxQuaisTratamentosMentais.setEnabled(true);
        jOutrosTratamento.setEnabled(true);
        jComboBoxFoiInternado.setEnabled(true);
        jEspecificarFrequenciasLocais.setEnabled(true);
        jMedicacoesUtilizadas.setEnabled(true);
        jComboBoxEpisodioDepressivo.setEnabled(true);
        jComboBoxSurtoPsicotico.setEnabled(true);
        jComboBoxTentativaSuicidio.setEnabled(true);
        jComboBoxComportamentoViolento.setEnabled(true);
        jComboBoxEnvolveJustica.setEnabled(true);
        jComboBoxUsoMedicaPsiquia.setEnabled(true);
        jObservacaoDepressivo.setEnabled(true);
        jObservacaoSurto.setEnabled(true);
        jObservacaoTentativaSuicidio.setEnabled(true);
        jObservacaoComportamentoViolento.setEnabled(true);
        jObservacaoEnvolveJustica.setEnabled(true);
        jObservacaoUsoMedicacoPsiquiatrica.setEnabled(true);
        //
        jBtNovoPSI.setEnabled(!true);
        jBtAlterarPSI.setEnabled(!true);
        jBtExcluirPSI.setEnabled(!true);
        jBtSalvarPSI.setEnabled(true);
        jBtCancelarPSI.setEnabled(true);
        jBtAuditoriaPSI.setEnabled(!true);
    }

    public void AlterarPSI() {
        jComboBoxTranstornoMental.setEnabled(true);
        jComboBoxTratamentoAnterior.setEnabled(true);
        jComboBoxQuaisTratamentosMentais.setEnabled(true);
        jOutrosTratamento.setEnabled(true);
        jComboBoxFoiInternado.setEnabled(true);
        jEspecificarFrequenciasLocais.setEnabled(true);
        jMedicacoesUtilizadas.setEnabled(true);
        jComboBoxEpisodioDepressivo.setEnabled(true);
        jComboBoxSurtoPsicotico.setEnabled(true);
        jComboBoxTentativaSuicidio.setEnabled(true);
        jComboBoxComportamentoViolento.setEnabled(true);
        jComboBoxEnvolveJustica.setEnabled(true);
        jComboBoxUsoMedicaPsiquia.setEnabled(true);
        jObservacaoDepressivo.setEnabled(true);
        jObservacaoSurto.setEnabled(true);
        jObservacaoTentativaSuicidio.setEnabled(true);
        jObservacaoComportamentoViolento.setEnabled(true);
        jObservacaoEnvolveJustica.setEnabled(true);
        jObservacaoUsoMedicacoPsiquiatrica.setEnabled(true);
        //
        jBtNovoPSI.setEnabled(!true);
        jBtAlterarPSI.setEnabled(!true);
        jBtExcluirPSI.setEnabled(!true);
        jBtSalvarPSI.setEnabled(true);
        jBtCancelarPSI.setEnabled(true);
        jBtAuditoriaPSI.setEnabled(!true);
    }

    public void ExcluirPSI() {
        jComboBoxTranstornoMental.setSelectedItem("Não");
        jComboBoxTratamentoAnterior.setSelectedItem("Não");
        jComboBoxQuaisTratamentosMentais.setSelectedItem("Selecione...");
        jOutrosTratamento.setText("");
        jComboBoxFoiInternado.setSelectedItem("Não");
        jEspecificarFrequenciasLocais.setText("");
        jMedicacoesUtilizadas.setText("");
        jComboBoxEpisodioDepressivo.setSelectedItem("Não");
        jComboBoxSurtoPsicotico.setSelectedItem("Não");
        jComboBoxTentativaSuicidio.setSelectedItem("Não");
        jComboBoxComportamentoViolento.setSelectedItem("Não");
        jComboBoxEnvolveJustica.setSelectedItem("Não");
        jComboBoxUsoMedicaPsiquia.setSelectedItem("Não");
        jObservacaoDepressivo.setText("");
        jObservacaoSurto.setText("");
        jObservacaoTentativaSuicidio.setText("");
        jObservacaoComportamentoViolento.setText("");
        jObservacaoEnvolveJustica.setText("");
        jObservacaoUsoMedicacoPsiquiatrica.setText("");
        //
        jComboBoxTranstornoMental.setEnabled(!true);
        jComboBoxTratamentoAnterior.setEnabled(!true);
        jComboBoxQuaisTratamentosMentais.setEnabled(!true);
        jOutrosTratamento.setEnabled(!true);
        jComboBoxFoiInternado.setEnabled(!true);
        jEspecificarFrequenciasLocais.setEnabled(!true);
        jMedicacoesUtilizadas.setEnabled(!true);
        jComboBoxEpisodioDepressivo.setEnabled(!true);
        jComboBoxSurtoPsicotico.setEnabled(!true);
        jComboBoxTentativaSuicidio.setEnabled(!true);
        jComboBoxComportamentoViolento.setEnabled(!true);
        jComboBoxEnvolveJustica.setEnabled(!true);
        jComboBoxUsoMedicaPsiquia.setEnabled(!true);
        jObservacaoDepressivo.setEnabled(!true);
        jObservacaoSurto.setEnabled(!true);
        jObservacaoTentativaSuicidio.setEnabled(!true);
        jObservacaoComportamentoViolento.setEnabled(!true);
        jObservacaoEnvolveJustica.setEnabled(!true);
        jObservacaoUsoMedicacoPsiquiatrica.setEnabled(!true);
        //
        jBtNovoPSI.setEnabled(true);
        jBtAlterarPSI.setEnabled(!true);
        jBtExcluirPSI.setEnabled(!true);
        jBtSalvarPSI.setEnabled(!true);
        jBtCancelarPSI.setEnabled(!true);
        jBtAuditoriaPSI.setEnabled(!true);
    }

    public void SalvarPSI() {
        jComboBoxTranstornoMental.setEnabled(!true);
        jComboBoxTratamentoAnterior.setEnabled(!true);
        jComboBoxQuaisTratamentosMentais.setEnabled(!true);
        jOutrosTratamento.setEnabled(!true);
        jComboBoxFoiInternado.setEnabled(!true);
        jEspecificarFrequenciasLocais.setEnabled(!true);
        jMedicacoesUtilizadas.setEnabled(!true);
        jComboBoxEpisodioDepressivo.setEnabled(!true);
        jComboBoxSurtoPsicotico.setEnabled(!true);
        jComboBoxTentativaSuicidio.setEnabled(!true);
        jComboBoxComportamentoViolento.setEnabled(!true);
        jComboBoxEnvolveJustica.setEnabled(!true);
        jComboBoxUsoMedicaPsiquia.setEnabled(!true);
        jObservacaoDepressivo.setEnabled(!true);
        jObservacaoSurto.setEnabled(!true);
        jObservacaoTentativaSuicidio.setEnabled(!true);
        jObservacaoComportamentoViolento.setEnabled(!true);
        jObservacaoEnvolveJustica.setEnabled(!true);
        jObservacaoUsoMedicacoPsiquiatrica.setEnabled(!true);
        //
        jBtNovoPSI.setEnabled(true);
        jBtAlterarPSI.setEnabled(!true);
        jBtExcluirPSI.setEnabled(!true);
        jBtSalvarPSI.setEnabled(!true);
        jBtCancelarPSI.setEnabled(!true);
        jBtAuditoriaPSI.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarPSI() {
        jComboBoxTranstornoMental.setEnabled(!true);
        jComboBoxTratamentoAnterior.setEnabled(!true);
        jComboBoxQuaisTratamentosMentais.setEnabled(!true);
        jOutrosTratamento.setEnabled(!true);
        jComboBoxFoiInternado.setEnabled(!true);
        jEspecificarFrequenciasLocais.setEnabled(!true);
        jMedicacoesUtilizadas.setEnabled(!true);
        jComboBoxEpisodioDepressivo.setEnabled(!true);
        jComboBoxSurtoPsicotico.setEnabled(!true);
        jComboBoxTentativaSuicidio.setEnabled(!true);
        jComboBoxComportamentoViolento.setEnabled(!true);
        jComboBoxEnvolveJustica.setEnabled(!true);
        jComboBoxUsoMedicaPsiquia.setEnabled(!true);
        jObservacaoDepressivo.setEnabled(!true);
        jObservacaoSurto.setEnabled(!true);
        jObservacaoTentativaSuicidio.setEnabled(!true);
        jObservacaoComportamentoViolento.setEnabled(!true);
        jObservacaoEnvolveJustica.setEnabled(!true);
        jObservacaoUsoMedicacoPsiquiatrica.setEnabled(!true);
        //
        jBtNovoPSI.setEnabled(true);
        jBtAlterarPSI.setEnabled(!true);
        jBtExcluirPSI.setEnabled(!true);
        jBtSalvarPSI.setEnabled(!true);
        jBtCancelarPSI.setEnabled(!true);
        jBtAuditoriaPSI.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PSICOLOGIA_PAI_PSICOSOCIAL "
                    + "INNER JOIN PAI_PSICOSOCIAL "
                    + "ON PSICOLOGIA_PAI_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                    + "WHERE PSICOLOGIA_PAI_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            // PSI
            codigoPSI = conecta.rs.getInt("IdPsiPai");
            jComboBoxTranstornoMental.setSelectedItem(conecta.rs.getString("TranstornoMental"));
            jComboBoxTratamentoAnterior.setSelectedItem(conecta.rs.getString("TratamentoAnterior"));
            jComboBoxQuaisTratamentosMentais.setSelectedItem(conecta.rs.getString("QuaisTratamentosMentais"));
            jOutrosTratamento.setText(conecta.rs.getString("OutrosTratamento"));
            jComboBoxFoiInternado.setSelectedItem(conecta.rs.getString("FoiInternado"));
            jEspecificarFrequenciasLocais.setText(conecta.rs.getString("EspecificarFrequenciasLocais"));
            jMedicacoesUtilizadas.setText(conecta.rs.getString("MedicacoesUtilizadas"));
            jComboBoxEpisodioDepressivo.setSelectedItem(conecta.rs.getString("EpisodioDepressivo"));
            jComboBoxSurtoPsicotico.setSelectedItem(conecta.rs.getString("SurtoPsicotico"));
            jComboBoxTentativaSuicidio.setSelectedItem(conecta.rs.getString("TentativaSuicidio"));
            jComboBoxComportamentoViolento.setSelectedItem(conecta.rs.getString("ComportamentoViolento"));
            jComboBoxEnvolveJustica.setSelectedItem(conecta.rs.getString("EnvolveJustica"));
            jComboBoxUsoMedicaPsiquia.setSelectedItem(conecta.rs.getString("UsoMedicaPsiquia"));
            jObservacaoDepressivo.setText(conecta.rs.getString("ObservacaoDepressivo"));
            jObservacaoSurto.setText(conecta.rs.getString("ObservacaoSurto"));
            jObservacaoTentativaSuicidio.setText(conecta.rs.getString("ObservacaoTentativaSuicidio"));
            jObservacaoComportamentoViolento.setText(conecta.rs.getString("ObservacaoComportamentoViolento"));
            jObservacaoEnvolveJustica.setText(conecta.rs.getString("ObservacaoEnvolveJustica"));
            jObservacaoUsoMedicacoPsiquiatrica.setText(conecta.rs.getString("ObservacaoUsoMedicacoPsiquiatrica"));
            if (codigoPSI != 0) {
                jBtNovoPSI.setEnabled(true);
                jBtAlterarPSI.setEnabled(true);
                jBtExcluirPSI.setEnabled(true);
                jBtSalvarPSI.setEnabled(!true);
                jBtCancelarPSI.setEnabled(!true);
                jBtAuditoriaPSI.setEnabled(true);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodigoPSI() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TERAPIA_PEDAGOGIA_PSICOSOCIAL");
            conecta.rs.last();
            codigoPSI = conecta.rs.getInt("IdToPed");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarCodigoPSI() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoPAI.getText() + "'");
            conecta.rs.first();
            codigoPaiPSI = conecta.rs.getString("IdPai");
            codigoInternoPSI = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoPM() {
        //P.M.
        jComboBoxFamiliaTranstornoMental.setSelectedItem("Não");
        jQuemTranstornoMental.setText("");
        jQualTranstornoMental.setText("");
        jComboBoxNecessidadePSI.setSelectedItem("Não");
        jCheckBoxConsultaPSI.setSelected(!true);
        jCheckBoxAcompanhaPSI.setSelected(!true);
        jComboBoxFazUsoDroga.setSelectedItem("Não");
        jQuaisDrogas.setText("");
        jComboBoxCompartilhaDrogas.setSelectedItem("Não");
        jComboBoxReducaoDanos.setSelectedItem("Não");
        jPorqueReduzDanos.setText("");
        jComboBoxAceitaProgramasDanos.setSelectedItem("Não");
        jPorqueAceitaProgroReduDanos.setText("");
        jComboBoxQueixaProbSaude.setSelectedItem("Não");
        jCheckBoxHipertensao.setSelected(!true);
        jCheckBoxDiabetes.setSelected(!true);
        jCheckBoxTuberculose.setSelected(!true);
        jCheckBoxDST.setSelected(!true);
        jCheckBoxHepatite.setSelected(!true);
        jCheckBoxHanseniase.setSelected(!true);
        jCheckBoxOutrasDoencas.setSelected(!true);
        jQuaisOutrasDoencas.setText("");
        jComboBoxProblemasSaudeBucal.setSelectedItem("Não");
        jComboBoxFazTratamentoBucal.setSelectedItem("Não");
        jQuaisTratamentoBucal.setText("");
        // HABILITAR CAMPOS
        jComboBoxFamiliaTranstornoMental.setEnabled(true);
        jQuemTranstornoMental.setEnabled(true);
        jQualTranstornoMental.setEnabled(true);
        jComboBoxNecessidadePSI.setEnabled(true);
        jCheckBoxConsultaPSI.setEnabled(true);
        jCheckBoxAcompanhaPSI.setEnabled(true);
        jComboBoxFazUsoDroga.setEnabled(true);
        jQuaisDrogas.setEnabled(true);
        jComboBoxCompartilhaDrogas.setEnabled(true);
        jComboBoxReducaoDanos.setEnabled(true);
        jPorqueReduzDanos.setEnabled(true);
        jComboBoxAceitaProgramasDanos.setEnabled(true);
        jPorqueAceitaProgroReduDanos.setEnabled(true);
        jComboBoxQueixaProbSaude.setEnabled(true);
        jCheckBoxHipertensao.setEnabled(true);
        jCheckBoxDiabetes.setEnabled(true);
        jCheckBoxTuberculose.setEnabled(true);
        jCheckBoxDST.setEnabled(true);
        jCheckBoxHepatite.setEnabled(true);
        jCheckBoxHanseniase.setEnabled(true);
        jCheckBoxOutrasDoencas.setEnabled(true);
        jQuaisOutrasDoencas.setEnabled(true);
        jComboBoxProblemasSaudeBucal.setEnabled(true);
        jComboBoxFazTratamentoBucal.setEnabled(true);
        jQuaisTratamentoBucal.setEnabled(true);
        //
        jBtNovoPM.setEnabled(!true);
        jBtAlterarPM.setEnabled(!true);
        jBtExcluirPM.setEnabled(!true);
        jBtSalvarPM.setEnabled(true);
        jBtCancelarPM.setEnabled(true);
        jBtAuditoriaPM.setEnabled(!true);
    }

    public void AlterarPM() {
        jComboBoxFamiliaTranstornoMental.setEnabled(true);
        jQuemTranstornoMental.setEnabled(true);
        jQualTranstornoMental.setEnabled(true);
        jComboBoxNecessidadePSI.setEnabled(true);
        jCheckBoxConsultaPSI.setEnabled(true);
        jCheckBoxAcompanhaPSI.setEnabled(true);
        jComboBoxFazUsoDroga.setEnabled(true);
        jQuaisDrogas.setEnabled(true);
        jComboBoxCompartilhaDrogas.setEnabled(true);
        jComboBoxReducaoDanos.setEnabled(true);
        jPorqueReduzDanos.setEnabled(true);
        jComboBoxAceitaProgramasDanos.setEnabled(true);
        jPorqueAceitaProgroReduDanos.setEnabled(true);
        jComboBoxQueixaProbSaude.setEnabled(true);
        jCheckBoxHipertensao.setEnabled(true);
        jCheckBoxDiabetes.setEnabled(true);
        jCheckBoxTuberculose.setEnabled(true);
        jCheckBoxDST.setEnabled(true);
        jCheckBoxHepatite.setEnabled(true);
        jCheckBoxHanseniase.setEnabled(true);
        jCheckBoxOutrasDoencas.setEnabled(true);
        jQuaisOutrasDoencas.setEnabled(true);
        jComboBoxProblemasSaudeBucal.setEnabled(true);
        jComboBoxFazTratamentoBucal.setEnabled(true);
        jQuaisTratamentoBucal.setEnabled(true);
        //
        jBtNovoPM.setEnabled(!true);
        jBtAlterarPM.setEnabled(!true);
        jBtExcluirPM.setEnabled(!true);
        jBtSalvarPM.setEnabled(true);
        jBtCancelarPM.setEnabled(true);
        jBtAuditoriaPM.setEnabled(!true);
    }

    public void ExcluirPM() {
        jComboBoxFamiliaTranstornoMental.setSelectedItem("Não");
        jQuemTranstornoMental.setText("");
        jQualTranstornoMental.setText("");
        jComboBoxNecessidadePSI.setSelectedItem("Não");
        jCheckBoxConsultaPSI.setSelected(!true);
        jCheckBoxAcompanhaPSI.setSelected(!true);
        jComboBoxFazUsoDroga.setSelectedItem("Não");
        jQuaisDrogas.setText("");
        jComboBoxCompartilhaDrogas.setSelectedItem("Não");
        jComboBoxReducaoDanos.setSelectedItem("Não");
        jPorqueReduzDanos.setText("");
        jComboBoxAceitaProgramasDanos.setSelectedItem("Não");
        jPorqueAceitaProgroReduDanos.setText("");
        jComboBoxQueixaProbSaude.setSelectedItem("Não");
        jCheckBoxHipertensao.setSelected(!true);
        jCheckBoxDiabetes.setSelected(!true);
        jCheckBoxTuberculose.setSelected(!true);
        jCheckBoxDST.setSelected(!true);
        jCheckBoxHepatite.setSelected(!true);
        jCheckBoxHanseniase.setSelected(!true);
        jCheckBoxOutrasDoencas.setSelected(!true);
        jQuaisOutrasDoencas.setText("");
        jComboBoxProblemasSaudeBucal.setSelectedItem("Não");
        jComboBoxFazTratamentoBucal.setSelectedItem("Não");
        jQuaisTratamentoBucal.setText("");
        // HABILITAR CAMPOS
        jComboBoxFamiliaTranstornoMental.setEnabled(!true);
        jQuemTranstornoMental.setEnabled(!true);
        jQualTranstornoMental.setEnabled(!true);
        jComboBoxNecessidadePSI.setEnabled(!true);
        jCheckBoxConsultaPSI.setEnabled(!true);
        jCheckBoxAcompanhaPSI.setEnabled(!true);
        jComboBoxFazUsoDroga.setEnabled(!true);
        jQuaisDrogas.setEnabled(!true);
        jComboBoxCompartilhaDrogas.setEnabled(!true);
        jComboBoxReducaoDanos.setEnabled(!true);
        jPorqueReduzDanos.setEnabled(!true);
        jComboBoxAceitaProgramasDanos.setEnabled(!true);
        jPorqueAceitaProgroReduDanos.setEnabled(!true);
        jComboBoxQueixaProbSaude.setEnabled(!true);
        jCheckBoxHipertensao.setEnabled(!true);
        jCheckBoxDiabetes.setEnabled(!true);
        jCheckBoxTuberculose.setEnabled(!true);
        jCheckBoxDST.setEnabled(!true);
        jCheckBoxHepatite.setEnabled(!true);
        jCheckBoxHanseniase.setEnabled(!true);
        jCheckBoxOutrasDoencas.setEnabled(!true);
        jQuaisOutrasDoencas.setEnabled(!true);
        jComboBoxProblemasSaudeBucal.setEnabled(!true);
        jComboBoxFazTratamentoBucal.setEnabled(!true);
        jQuaisTratamentoBucal.setEnabled(!true);
        //
        jBtNovoPM.setEnabled(true);
        jBtAlterarPM.setEnabled(!true);
        jBtExcluirPM.setEnabled(!true);
        jBtSalvarPM.setEnabled(!true);
        jBtCancelarPM.setEnabled(!true);
        jBtAuditoriaPM.setEnabled(!true);
    }

    public void SalvarPM() {
        jComboBoxFamiliaTranstornoMental.setEnabled(!true);
        jQuemTranstornoMental.setEnabled(!true);
        jQualTranstornoMental.setEnabled(!true);
        jComboBoxNecessidadePSI.setEnabled(!true);
        jCheckBoxConsultaPSI.setEnabled(!true);
        jCheckBoxAcompanhaPSI.setEnabled(!true);
        jComboBoxFazUsoDroga.setEnabled(!true);
        jQuaisDrogas.setEnabled(!true);
        jComboBoxCompartilhaDrogas.setEnabled(!true);
        jComboBoxReducaoDanos.setEnabled(!true);
        jPorqueReduzDanos.setEnabled(!true);
        jComboBoxAceitaProgramasDanos.setEnabled(!true);
        jPorqueAceitaProgroReduDanos.setEnabled(!true);
        jComboBoxQueixaProbSaude.setEnabled(!true);
        jCheckBoxHipertensao.setEnabled(!true);
        jCheckBoxDiabetes.setEnabled(!true);
        jCheckBoxTuberculose.setEnabled(!true);
        jCheckBoxDST.setEnabled(!true);
        jCheckBoxHepatite.setEnabled(!true);
        jCheckBoxHanseniase.setEnabled(!true);
        jCheckBoxOutrasDoencas.setEnabled(!true);
        jQuaisOutrasDoencas.setEnabled(!true);
        jComboBoxProblemasSaudeBucal.setEnabled(!true);
        jComboBoxFazTratamentoBucal.setEnabled(!true);
        jQuaisTratamentoBucal.setEnabled(!true);
        //
        jBtNovoPM.setEnabled(true);
        jBtAlterarPM.setEnabled(true);
        jBtExcluirPM.setEnabled(true);
        jBtSalvarPM.setEnabled(!true);
        jBtCancelarPM.setEnabled(!true);
        jBtAuditoriaPM.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarPM() {
        jComboBoxFamiliaTranstornoMental.setEnabled(!true);
        jQuemTranstornoMental.setEnabled(!true);
        jQualTranstornoMental.setEnabled(!true);
        jComboBoxNecessidadePSI.setEnabled(!true);
        jCheckBoxConsultaPSI.setEnabled(!true);
        jCheckBoxAcompanhaPSI.setEnabled(!true);
        jComboBoxFazUsoDroga.setEnabled(!true);
        jQuaisDrogas.setEnabled(!true);
        jComboBoxCompartilhaDrogas.setEnabled(!true);
        jComboBoxReducaoDanos.setEnabled(!true);
        jPorqueReduzDanos.setEnabled(!true);
        jComboBoxAceitaProgramasDanos.setEnabled(!true);
        jPorqueAceitaProgroReduDanos.setEnabled(!true);
        jComboBoxQueixaProbSaude.setEnabled(!true);
        jCheckBoxHipertensao.setEnabled(!true);
        jCheckBoxDiabetes.setEnabled(!true);
        jCheckBoxTuberculose.setEnabled(!true);
        jCheckBoxDST.setEnabled(!true);
        jCheckBoxHepatite.setEnabled(!true);
        jCheckBoxHanseniase.setEnabled(!true);
        jCheckBoxOutrasDoencas.setEnabled(!true);
        jQuaisOutrasDoencas.setEnabled(!true);
        jComboBoxProblemasSaudeBucal.setEnabled(!true);
        jComboBoxFazTratamentoBucal.setEnabled(!true);
        jQuaisTratamentoBucal.setEnabled(!true);
        //
        jBtNovoPM.setEnabled(true);
        jBtAlterarPM.setEnabled(true);
        jBtExcluirPM.setEnabled(true);
        jBtSalvarPM.setEnabled(!true);
        jBtCancelarPM.setEnabled(!true);
        jBtAuditoriaPM.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL "
                    + "INNER JOIN PAI_PSICOSOCIAL "
                    + "ON PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                    + "WHERE PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoPM = conecta.rs.getInt("IdPsiMed");
            jComboBoxFamiliaTranstornoMental.setSelectedItem(conecta.rs.getString("FamiliaTranstornoMental"));
            jQuemTranstornoMental.setText(conecta.rs.getString("QuemTranstornoMental"));
            jQualTranstornoMental.setText(conecta.rs.getString("QualTranstornoMental"));
            jComboBoxNecessidadePSI.setSelectedItem(conecta.rs.getString("NecessidadePSI"));
            //
            consultaPSI = conecta.rs.getInt("ConsultaPSI");
            if (consultaPSI == 0) {
                jCheckBoxConsultaPSI.setSelected(true);
            } else if (consultaPSI == 1) {
                jCheckBoxConsultaPSI.setSelected(!true);
            }
            acompanhaPSI = conecta.rs.getInt("AcompanhaPSI");
            if (acompanhaPSI == 0) {
                jCheckBoxAcompanhaPSI.setSelected(true);
            } else if (acompanhaPSI == 1) {
                jCheckBoxAcompanhaPSI.setSelected(!true);
            }
            jComboBoxFazUsoDroga.setSelectedItem(conecta.rs.getString("FazUsoDroga"));
            jQuaisDrogas.setText(conecta.rs.getString("QuaisDrogas"));
            jComboBoxCompartilhaDrogas.setSelectedItem(conecta.rs.getString("CompartilhaDrogas"));
            jComboBoxReducaoDanos.setSelectedItem(conecta.rs.getString("ReducaoDanos"));
            jPorqueReduzDanos.setText(conecta.rs.getString("PorqueReduzDanos"));
            jComboBoxAceitaProgramasDanos.setSelectedItem(conecta.rs.getString("AceitaProgramasDanos"));
            jPorqueAceitaProgroReduDanos.setText(conecta.rs.getString("PorqueAceitaProgroReduDanos"));
            jComboBoxQueixaProbSaude.setSelectedItem(conecta.rs.getString("QueixaProbSaude"));
            //
            hipertensao = conecta.rs.getInt("Hipertensao");
            if (hipertensao == 0) {
                jCheckBoxHipertensao.setSelected(true);
            } else if (hipertensao == 1) {
                jCheckBoxHipertensao.setSelected(!true);
            }
            diabetes = conecta.rs.getInt("Diabetes");
            if (diabetes == 0) {
                jCheckBoxDiabetes.setSelected(true);
            } else if (diabetes == 1) {
                jCheckBoxDiabetes.setSelected(!true);
            }
            tuberculose = conecta.rs.getInt("Tuberculose");
            if (tuberculose == 0) {
                jCheckBoxTuberculose.setSelected(true);
            } else if (tuberculose == 1) {
                jCheckBoxTuberculose.setSelected(!true);
            }
            dst = conecta.rs.getInt("DST");
            if (dst == 0) {
                jCheckBoxDST.setSelected(true);
            } else if (dst == 1) {
                jCheckBoxDST.setSelected(!true);
            }
            hepatite = conecta.rs.getInt("Hepatite");
            if (hepatite == 0) {
                jCheckBoxHepatite.setSelected(true);
            } else if (hepatite == 1) {
                jCheckBoxHepatite.setSelected(!true);
            }
            hanseniase = conecta.rs.getInt("Hanseniase");
            if (hanseniase == 0) {
                jCheckBoxHanseniase.setSelected(true);
            } else if (hanseniase == 1) {
                jCheckBoxHanseniase.setSelected(!true);
            }
            outrasDoencas = conecta.rs.getInt("OutrasDoencas");
            if (outrasDoencas == 0) {
                jCheckBoxOutrasDoencas.setSelected(true);
            } else if (outrasDoencas == 1) {
                jCheckBoxOutrasDoencas.setSelected(!true);
            }
            jQuaisOutrasDoencas.setText(conecta.rs.getString("QuaisOutrasDoencas"));
            jComboBoxProblemasSaudeBucal.setSelectedItem(conecta.rs.getString("ProblemasSaudeBucal"));
            jComboBoxFazTratamentoBucal.setSelectedItem(conecta.rs.getString("FazTratamentoBucal"));
            jQuaisTratamentoBucal.setText(conecta.rs.getString("QuaisTratamentoBucal"));
            if (codigoPM != 0) {
                jBtNovoPM.setEnabled(true);
                jBtAlterarPM.setEnabled(true);
                jBtExcluirPM.setEnabled(true);
                jBtSalvarPM.setEnabled(!true);
                jBtCancelarPM.setEnabled(!true);
                jBtAuditoriaPM.setEnabled(true);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodigoPM() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL");
            conecta.rs.last();
            codigoPM = conecta.rs.getInt("IdPsiMed");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarCodigoPM() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoPAI.getText() + "'");
            conecta.rs.first();
            codigoPaiPM = conecta.rs.getString("IdPai");
            codigoInternoPM = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoEAPI() {
        jDescricaoUnidadePenal.setText("");
        jMatriculaPenal.setText("");
        jPavilhão.setText("");
        jCela.setText("");
        jAlcunha.setText("");
        jRegimePenal.setText("");
        jArtigo.setText("");
        jTempPenaSentenca.setText("");
        jTempoPenaCumprida.setText("");
        jComboBoxAssistenciaJuridica.setSelectedItem("Não");
        jTempoPenaACumprir.setText("");
        jComboBoxReintegraSistemaPenal.setSelectedItem("Não");
        jSituacaoJuridica.setText("");
        jDataEntradaSistemaPenal.setCalendar(Calendar.getInstance());
        jComboBoxDefensorPublico.setSelectedItem("Não");
        jComboBoxOutroDefensor.setSelectedItem("Não");
        jQualDefensor.setText("");
        jTextoPSP.setText("");
        //    
        jBtPesquisarUnidade.setEnabled(true);
        jTempPenaSentenca.setEnabled(true);
        jTempoPenaCumprida.setEnabled(true);
        jComboBoxAssistenciaJuridica.setEnabled(true);
        jTempoPenaACumprir.setEnabled(true);
        jComboBoxReintegraSistemaPenal.setEnabled(true);
        jSituacaoJuridica.setEnabled(true);
        jDataEntradaSistemaPenal.setEnabled(true);
        jComboBoxDefensorPublico.setEnabled(true);
        jComboBoxOutroDefensor.setEnabled(true);
        jQualDefensor.setEnabled(true);
        jTextoPSP.setEnabled(true);
        //
        jBtNovoCRC.setEnabled(!true);
        jBtAlterarCRC.setEnabled(!true);
        jBtExcluirCRC.setEnabled(!true);
        jBtSalvarCRC.setEnabled(true);
        jBtCancelarCRC.setEnabled(true);
        jBtAuditoriaCRC.setEnabled(!true);
    }

    public void AlterarEAPI() {
        jBtPesquisarUnidade.setEnabled(true);
        jTempPenaSentenca.setEnabled(true);
        jTempoPenaCumprida.setEnabled(true);
        jComboBoxAssistenciaJuridica.setEnabled(true);
        jTempoPenaACumprir.setEnabled(true);
        jComboBoxReintegraSistemaPenal.setEnabled(true);
        jSituacaoJuridica.setEnabled(true);
        jDataEntradaSistemaPenal.setEnabled(true);
        jComboBoxDefensorPublico.setEnabled(true);
        jComboBoxOutroDefensor.setEnabled(true);
        jQualDefensor.setEnabled(true);
        jTextoPSP.setEnabled(true);
        //
        jBtNovoCRC.setEnabled(!true);
        jBtAlterarCRC.setEnabled(!true);
        jBtExcluirCRC.setEnabled(!true);
        jBtSalvarCRC.setEnabled(true);
        jBtCancelarCRC.setEnabled(true);
        jBtAuditoriaCRC.setEnabled(!true);
    }

    public void ExcluirEAPI() {
        jDescricaoUnidadePenal.setText("");
        jMatriculaPenal.setText("");
        jPavilhão.setText("");
        jCela.setText("");
        jAlcunha.setText("");
        jRegimePenal.setText("");
        jArtigo.setText("");
        jTempPenaSentenca.setText("");
        jTempoPenaCumprida.setText("");
        jComboBoxAssistenciaJuridica.setSelectedItem("Não");
        jTempoPenaACumprir.setText("");
        jComboBoxReintegraSistemaPenal.setSelectedItem("Não");
        jSituacaoJuridica.setText("");
        jDataEntradaSistemaPenal.setDate(null);
        jComboBoxDefensorPublico.setSelectedItem("Não");
        jComboBoxOutroDefensor.setSelectedItem("Não");
        jQualDefensor.setText("");
        jTextoPSP.setText("");
        //    
        jBtPesquisarUnidade.setEnabled(!true);
        jTempPenaSentenca.setEnabled(!true);
        jTempoPenaCumprida.setEnabled(!true);
        jComboBoxAssistenciaJuridica.setEnabled(!true);
        jTempoPenaACumprir.setEnabled(!true);
        jComboBoxReintegraSistemaPenal.setEnabled(!true);
        jSituacaoJuridica.setEnabled(!true);
        jDataEntradaSistemaPenal.setEnabled(!true);
        jComboBoxDefensorPublico.setEnabled(!true);
        jComboBoxOutroDefensor.setEnabled(!true);
        jQualDefensor.setEnabled(!true);
        jTextoPSP.setEnabled(!true);
        //
        jBtNovoCRC.setEnabled(true);
        jBtAlterarCRC.setEnabled(!true);
        jBtExcluirCRC.setEnabled(!true);
        jBtSalvarCRC.setEnabled(!true);
        jBtCancelarCRC.setEnabled(!true);
        jBtAuditoriaCRC.setEnabled(!true);
    }

    public void SalvarEAPI() {
        jBtPesquisarUnidade.setEnabled(!true);
        jTempPenaSentenca.setEnabled(!true);
        jTempoPenaCumprida.setEnabled(!true);
        jComboBoxAssistenciaJuridica.setEnabled(!true);
        jTempoPenaACumprir.setEnabled(!true);
        jComboBoxReintegraSistemaPenal.setEnabled(!true);
        jSituacaoJuridica.setEnabled(!true);
        jDataEntradaSistemaPenal.setEnabled(!true);
        jComboBoxDefensorPublico.setEnabled(!true);
        jComboBoxOutroDefensor.setEnabled(!true);
        jQualDefensor.setEnabled(!true);
        jTextoPSP.setEnabled(!true);
        //
        jBtNovoCRC.setEnabled(true);
        jBtAlterarCRC.setEnabled(true);
        jBtExcluirCRC.setEnabled(true);
        jBtSalvarCRC.setEnabled(!true);
        jBtCancelarCRC.setEnabled(!true);
        jBtAuditoriaCRC.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarEAPI() {
        jBtPesquisarUnidade.setEnabled(!true);
        jTempPenaSentenca.setEnabled(!true);
        jTempoPenaCumprida.setEnabled(!true);
        jComboBoxAssistenciaJuridica.setEnabled(!true);
        jTempoPenaACumprir.setEnabled(!true);
        jComboBoxReintegraSistemaPenal.setEnabled(!true);
        jSituacaoJuridica.setEnabled(!true);
        jDataEntradaSistemaPenal.setEnabled(!true);
        jComboBoxDefensorPublico.setEnabled(!true);
        jComboBoxOutroDefensor.setEnabled(!true);
        jQualDefensor.setEnabled(!true);
        jTextoPSP.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //EAPI/CRC
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EAPI_CRC_PAI_PSICOSOCIAL "
                    + "INNER JOIN PAI_PSICOSOCIAL "
                    + "ON EAPI_CRC_PAI_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                    + "INNER JOIN UNIDADE "
                    + "ON EAPI_CRC_PAI_PSICOSOCIAL.IdUnid=UNIDADE.IdUnid "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON EAPI_CRC_PAI_PSICOSOCIAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE EAPI_CRC_PAI_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            codigoEAPI = conecta.rs.getInt("IdEapi");
            jDescricaoUnidadePenal.setText(conecta.rs.getString("DescricaoUnid"));
            jMatriculaPenal.setText(conecta.rs.getString("MatriculaCrc"));
            jPavilhão.setText(conecta.rs.getString("DescricaoPav"));
            jCela.setText(conecta.rs.getString("EndCelaPav"));
            jAlcunha.setText(conecta.rs.getString("AlcunhaCrc"));
            jRegimePenal.setText(conecta.rs.getString("Regime"));
            jArtigo.setText(conecta.rs.getString("Artigo1"));
            jTempPenaSentenca.setText(conecta.rs.getString("TempPenaSentenca"));
            jTempoPenaCumprida.setText(conecta.rs.getString("TempoPenaCumprida"));
            jComboBoxAssistenciaJuridica.setSelectedItem(conecta.rs.getString("AssistenciaJuridica"));
            jTempoPenaACumprir.setText(conecta.rs.getString("TempoPenaACumprir"));
            jComboBoxReintegraSistemaPenal.setSelectedItem(conecta.rs.getString("ReintegraSistemaPenal"));
            jSituacaoJuridica.setText(conecta.rs.getString("SituacaoJuridica"));
            jDataEntradaSistemaPenal.setDate(conecta.rs.getDate("DataEntradaSistemaPenal"));
            jComboBoxDefensorPublico.setSelectedItem(conecta.rs.getString("DefensorPublico"));
            jComboBoxOutroDefensor.setSelectedItem(conecta.rs.getString("OutroDefensor"));
            jQualDefensor.setText(conecta.rs.getString("QualDefensor"));
            jTextoPSP.setText(conecta.rs.getString("TextoPSP"));
            if (codigoEAPI != 0) {
                jBtNovoCRC.setEnabled(true);
                jBtAlterarCRC.setEnabled(true);
                jBtExcluirCRC.setEnabled(true);
                jBtSalvarCRC.setEnabled(!true);
                jBtCancelarCRC.setEnabled(!true);
                jBtAuditoriaCRC.setEnabled(true);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodigoEAPI() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EAPI_CRC_PAI_PSICOSOCIAL ");
            conecta.rs.last();
            codigoEAPI = conecta.rs.getInt("IdEapi");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter o código do registro.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void verificarCodigoEAPI() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EAPI_CRC_PAI_PSICOSOCIAL "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoPAI.getText() + "'");
            conecta.rs.first();
            codigoPaiEAPI = conecta.rs.getString("IdPai");
            codigoInternoEAPI = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovoSS3() {
        jTextoCEDEGEP.setText("");
        jTextoCRASCREAS.setText("");
        jTextoASSISTENCIA.setText("");
        jTextoDOCUMENTOCIVIL.setText("");
        jDataInclusaoPAI.setCalendar(Calendar.getInstance());
        jTecnicoServicoSocial.setText("");
        jTecnicoPsicologico.setText(nameUser);
        //
        jTextoCEDEGEP.setEnabled(true);
        jTextoCRASCREAS.setEnabled(true);
        jTextoASSISTENCIA.setEnabled(true);
        jTextoDOCUMENTOCIVIL.setEnabled(true);
        jDataInclusaoPAI.setEnabled(true);
        jTecnicoServicoSocial.setEnabled(true);
        jTecnicoPsicologico.setEnabled(true);
        //
        jBtNovoSS3.setEnabled(!true);
        jBtAlterarSS3.setEnabled(!true);
        jBtExcluirSS3.setEnabled(!true);
        jBtSalvarSS3.setEnabled(true);
        jBtCancelarSS3.setEnabled(true);
        jBtAuditoriaSS3.setEnabled(!true);
    }

    public void AlterarSS3() {
        jTextoCEDEGEP.setEnabled(true);
        jTextoCRASCREAS.setEnabled(true);
        jTextoASSISTENCIA.setEnabled(true);
        jTextoDOCUMENTOCIVIL.setEnabled(true);
        jDataInclusaoPAI.setEnabled(true);
        jTecnicoServicoSocial.setEnabled(true);
        jTecnicoPsicologico.setEnabled(true);
        //
        jBtNovoSS3.setEnabled(!true);
        jBtAlterarSS3.setEnabled(!true);
        jBtExcluirSS3.setEnabled(!true);
        jBtSalvarSS3.setEnabled(true);
        jBtCancelarSS3.setEnabled(true);
        jBtAuditoriaSS3.setEnabled(!true);
    }

    public void ExcluirSS3() {
        jTextoCEDEGEP.setText("");
        jTextoCRASCREAS.setText("");
        jTextoASSISTENCIA.setText("");
        jTextoDOCUMENTOCIVIL.setText("");
        jDataInclusaoPAI.setDate(null);
        jTecnicoServicoSocial.setText("");
        jTecnicoPsicologico.setText("");
        //
        jTextoCEDEGEP.setEnabled(!true);
        jTextoCRASCREAS.setEnabled(!true);
        jTextoASSISTENCIA.setEnabled(!true);
        jTextoDOCUMENTOCIVIL.setEnabled(!true);
        jDataInclusaoPAI.setEnabled(!true);
        jTecnicoServicoSocial.setEnabled(!true);
        jTecnicoPsicologico.setEnabled(!true);
        //
        jBtNovoSS3.setEnabled(true);
        jBtAlterarSS3.setEnabled(!true);
        jBtExcluirSS3.setEnabled(!true);
        jBtSalvarSS3.setEnabled(!true);
        jBtCancelarSS3.setEnabled(!true);
        jBtAuditoriaSS3.setEnabled(!true);
    }

    public void SalvarSS3() {
        jTextoCEDEGEP.setEnabled(!true);
        jTextoCRASCREAS.setEnabled(!true);
        jTextoASSISTENCIA.setEnabled(!true);
        jTextoDOCUMENTOCIVIL.setEnabled(!true);
        jDataInclusaoPAI.setEnabled(!true);
        jTecnicoServicoSocial.setEnabled(!true);
        jTecnicoPsicologico.setEnabled(!true);
        //
        jBtNovoSS3.setEnabled(true);
        jBtAlterarSS3.setEnabled(true);
        jBtExcluirSS3.setEnabled(true);
        jBtSalvarSS3.setEnabled(!true);
        jBtCancelarSS3.setEnabled(!true);
        jBtAuditoriaSS3.setEnabled(true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
    }

    public void CancelarSS3() {
        jTextoCEDEGEP.setEnabled(!true);
        jTextoCRASCREAS.setEnabled(!true);
        jTextoASSISTENCIA.setEnabled(!true);
        jTextoDOCUMENTOCIVIL.setEnabled(!true);
        jDataInclusaoPAI.setEnabled(!true);
        jTecnicoServicoSocial.setEnabled(!true);
        jTecnicoPsicologico.setEnabled(!true);
        // MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        //
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SS3_PAI_PSICOSOCIAL "
                    + "INNER JOIN PAI_PSICOSOCIAL "
                    + "ON SS3_PAI_PSICOSOCIAL.IdPai=PAI_PSICOSOCIAL.IdPai "
                    + "WHERE SS3_PAI_PSICOSOCIAL.IdPai='" + jCodigoPAI.getText() + "'");
            conecta.rs.first();
            // SS3
            codigoSS3 = conecta.rs.getInt("IdSS3");
            jTextoCEDEGEP.setText(conecta.rs.getString("TextoCEDEGEP"));
            jTextoCRASCREAS.setText(conecta.rs.getString("TextoCRASCREAS"));
            jTextoASSISTENCIA.setText(conecta.rs.getString("TextoASSISTENCIA"));
            jTextoDOCUMENTOCIVIL.setText(conecta.rs.getString("TextoDOCUMENTOCIVIL"));
            jDataInclusaoPAI.setDate(conecta.rs.getDate("DataInclusaoPAI"));
            jTecnicoServicoSocial.setText(conecta.rs.getString("TecnicoServicoSocial"));
            jTecnicoPsicologico.setText(conecta.rs.getString("TecnicoPsicologico"));
            if (codigoSS3 != 0) {
                jBtNovoSS3.setEnabled(true);
                jBtAlterarSS3.setEnabled(true);
                jBtExcluirSS3.setEnabled(true);
                jBtSalvarSS3.setEnabled(!true);
                jBtCancelarSS3.setEnabled(!true);
                jBtAuditoriaSS3.setEnabled(true);
            }
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodigoSS3() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SS3_PAI_PSICOSOCIAL ");
            conecta.rs.last();
            codigoSS3 = conecta.rs.getInt("IdSS3");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter código do registro.");
        }
        conecta.desconecta();
    }

    public void verificarCodigoSS3() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SS3_PAI_PSICOSOCIAL "
                    + "WHERE IdPai='" + jCodigoPAI.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoPAI.getText() + "'");
            conecta.rs.first();
            codigoPaiSS3 = conecta.rs.getString("IdPai");
            codigoInternoSS3 = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void NovaEvolucao() {
        jIdEvolucao.setText("");
        jDataEvolucao.setCalendar(Calendar.getInstance());
        jNomeInternoEvolucaoPAI.setText(jNomeInternoPAI.getText());
        jTextoEvolucao.setText("");
        //
        jDataEvolucao.setEnabled(true);
        jTextoEvolucao.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void AlterarEvolucao() {
        jDataEvolucao.setEnabled(true);
        jTextoEvolucao.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void ExcluirEvolucao() {
        jIdEvolucao.setText("");
        jDataEvolucao.setDate(null);
        jNomeInternoEvolucaoPAI.setText("");
        jTextoEvolucao.setText("");
        //
        jDataEvolucao.setEnabled(true);
        jTextoEvolucao.setEnabled(true);
        //
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(true);
        jBtCancelarEvolucao.setEnabled(true);
        jBtAuditoriaEvolucao.setEnabled(!true);
    }

    public void SalvarEvolucao() {
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucao.setEnabled(!true);
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(true);
        jBtExcluirEvolucao.setEnabled(true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(true);
    }

    public void CancelarEvolucao() {
        if (jIdEvolucao.getText().equals("")) {
            jIdEvolucao.setText("");
            jDataEvolucao.setDate(null);
            jNomeInternoEvolucaoPAI.setText("");
            jTextoEvolucao.setText("");
            //
            jDataEvolucao.setEnabled(!true);
            jTextoEvolucao.setEnabled(!true);
            //
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(!true);
            jBtExcluirEvolucao.setEnabled(!true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(!true);
        } else {
            jDataEvolucao.setEnabled(!true);
            jTextoEvolucao.setEnabled(!true);
            //
            jBtNovaEvolucao.setEnabled(true);
            jBtAlterarEvolucao.setEnabled(true);
            jBtExcluirEvolucao.setEnabled(true);
            jBtSalvarEvolucao.setEnabled(!true);
            jBtCancelarEvolucao.setEnabled(!true);
            jBtAuditoriaEvolucao.setEnabled(true);
        }
    }

    public void buscarCodigoEvolucao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAO_PAI ");
            conecta.rs.last();
            jIdEvolucao.setText(conecta.rs.getString("IdEvolucao"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter código do registro.");
        }
        conecta.desconecta();
    }

    public void preencherTabelaAtendentimentoPAI(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataPAI = conecta.rs.getString("DataPai");
                String diae = dataPAI.substring(8, 10);
                String mese = dataPAI.substring(5, 7);
                String anoe = dataPAI.substring(0, 4);
                dataPAI = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdPai"), dataPAI, conecta.rs.getString("StatusPai"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPAI.setModel(modelo);
        jTabelaPAI.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPAI.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPAI.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaPAI.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPAI.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPAI.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPAI.getColumnModel().getColumn(3).setPreferredWidth(270);
        jTabelaPAI.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPAI.getTableHeader().setReorderingAllowed(false);
        jTabelaPAI.setAutoResizeMode(jTabelaPAI.AUTO_RESIZE_OFF);
        jTabelaPAI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCelulasTabelaPAISocial();
        conecta.desconecta();
    }

    public void alinharCelulasTabelaPAISocial() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaPAI.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPAI.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaPAI.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void limparTabelaPAISocial() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPAI.setModel(modelo);
        jTabelaPAI.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaPAI.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPAI.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaPAI.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPAI.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaPAI.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPAI.getColumnModel().getColumn(3).setPreferredWidth(270);
        jTabelaPAI.getColumnModel().getColumn(3).setResizable(false);
        jTabelaPAI.getTableHeader().setReorderingAllowed(false);
        jTabelaPAI.setAutoResizeMode(jTabelaPAI.AUTO_RESIZE_OFF);
        jTabelaPAI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaFamiliar(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Familiar", "Vinculo", "Idade", "Ocupação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdFamiliar"), conecta.rs.getString("NomeFamiliar"), conecta.rs.getString("Vinculo"), conecta.rs.getString("Idade"), conecta.rs.getString("Ocupacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaFamiliarPAI.setModel(modelo);
        jTabelaFamiliarPAI.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaFamiliarPAI.getColumnModel().getColumn(0).setResizable(false);
        jTabelaFamiliarPAI.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaFamiliarPAI.getColumnModel().getColumn(1).setResizable(false);
        jTabelaFamiliarPAI.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTabelaFamiliarPAI.getColumnModel().getColumn(2).setResizable(false);
        jTabelaFamiliarPAI.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTabelaFamiliarPAI.getColumnModel().getColumn(3).setResizable(false);
        jTabelaFamiliarPAI.getColumnModel().getColumn(4).setPreferredWidth(140);
        jTabelaFamiliarPAI.getColumnModel().getColumn(4).setResizable(false);
        jTabelaFamiliarPAI.getTableHeader().setReorderingAllowed(false);
        jTabelaFamiliarPAI.setAutoResizeMode(jTabelaFamiliarPAI.AUTO_RESIZE_OFF);
        jTabelaFamiliarPAI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaFamiliar();
        conecta.desconecta();
    }

    public void limparTabelaFamiliar() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Familiar", "Vinculo", "Idade", "Ocupação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaFamiliarPAI.setModel(modelo);
        jTabelaFamiliarPAI.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaFamiliarPAI.getColumnModel().getColumn(0).setResizable(false);
        jTabelaFamiliarPAI.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaFamiliarPAI.getColumnModel().getColumn(1).setResizable(false);
        jTabelaFamiliarPAI.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTabelaFamiliarPAI.getColumnModel().getColumn(2).setResizable(false);
        jTabelaFamiliarPAI.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTabelaFamiliarPAI.getColumnModel().getColumn(3).setResizable(false);
        jTabelaFamiliarPAI.getColumnModel().getColumn(4).setPreferredWidth(140);
        jTabelaFamiliarPAI.getColumnModel().getColumn(4).setResizable(false);
        jTabelaFamiliarPAI.getTableHeader().setReorderingAllowed(false);
        jTabelaFamiliarPAI.setAutoResizeMode(jTabelaFamiliarPAI.AUTO_RESIZE_OFF);
        jTabelaFamiliarPAI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaFamiliar() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaFamiliarPAI.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaFamiliarPAI.getColumnModel().getColumn(3).setCellRenderer(centralizado);
    }

    public void preencherTabelaVisitas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome da Visita", "Vinculo", "Idade", "Ocupação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdSol2Visita"), conecta.rs.getInt("IdVisita"), conecta.rs.getString("NomeVisita"), conecta.rs.getString("ParentescoVisita"), conecta.rs.getString("Idade"), conecta.rs.getString("Ocupacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitas.setModel(modelo);
        jTabelaVisitas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaVisitas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaVisitas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaVisitas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaVisitas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTabelaVisitas.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(5).setPreferredWidth(140);
        jTabelaVisitas.getColumnModel().getColumn(5).setResizable(false);
        jTabelaVisitas.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitas.setAutoResizeMode(jTabelaVisitas.AUTO_RESIZE_OFF);
        jTabelaVisitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaVisitas();
        conecta.desconecta();
    }

    public void limparTabelaVisitas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome da Visita", "Vinculo", "Idade", "Ocupação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitas.setModel(modelo);
        jTabelaVisitas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaVisitas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaVisitas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaVisitas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaVisitas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTabelaVisitas.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisitas.getColumnModel().getColumn(5).setPreferredWidth(140);
        jTabelaVisitas.getColumnModel().getColumn(5).setResizable(false);
        jTabelaVisitas.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitas.setAutoResizeMode(jTabelaVisitas.AUTO_RESIZE_OFF);
        jTabelaVisitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaVisitas() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaVisitas.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaVisitas.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaVisitas.getColumnModel().getColumn(4).setCellRenderer(centralizado);
    }

    public void preencherTabelaVisitasIntimas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome da Visita", "Vinculo", "Idade", "Ocupação"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdSol2Visita"), conecta.rs.getInt("IdVisita"), conecta.rs.getString("NomeVisita"), conecta.rs.getString("ParentescoVisita"), conecta.rs.getString("Idade"), conecta.rs.getString("Ocupacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitasIntimas.setModel(modelo);
        jTabelaVisitasIntimas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaVisitasIntimas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaVisitasIntimas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaVisitasIntimas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaVisitasIntimas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTabelaVisitasIntimas.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(5).setPreferredWidth(140);
        jTabelaVisitasIntimas.getColumnModel().getColumn(5).setResizable(false);
        jTabelaVisitasIntimas.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitasIntimas.setAutoResizeMode(jTabelaVisitasIntimas.AUTO_RESIZE_OFF);
        jTabelaVisitasIntimas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaVisitasIntimas();
        conecta.desconecta();
    }

    public void limparTabelaVisitasIntimas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome da Visita", "Vinculo", "Idade", "Ocupação"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitasIntimas.setModel(modelo);
        jTabelaVisitasIntimas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaVisitasIntimas.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTabelaVisitasIntimas.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaVisitasIntimas.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTabelaVisitasIntimas.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTabelaVisitasIntimas.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisitasIntimas.getColumnModel().getColumn(5).setPreferredWidth(140);
        jTabelaVisitasIntimas.getColumnModel().getColumn(5).setResizable(false);
        jTabelaVisitasIntimas.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitasIntimas.setAutoResizeMode(jTabelaVisitasIntimas.AUTO_RESIZE_OFF);
        jTabelaVisitasIntimas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaVisitasIntimas() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaVisitasIntimas.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaVisitasIntimas.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaVisitasIntimas.getColumnModel().getColumn(4).setCellRenderer(centralizado);
    }

    public void preencherTabelaEvolucao(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Evolução"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEvolucaoPAI = conecta.rs.getString("DataEvolucao");
                String diae = dataEvolucaoPAI.substring(8, 10);
                String mese = dataEvolucaoPAI.substring(5, 7);
                String anoe = dataEvolucaoPAI.substring(0, 4);
                dataEvolucaoPAI = diae + "/" + mese + "/" + anoe;
                dados.add(new Object[]{conecta.rs.getInt("IdEvolucao"), dataEvolucaoPAI, conecta.rs.getString("TextoEvolucao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoPAI.setModel(modelo);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoPAI.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoPAI.setAutoResizeMode(jTabelaEvolucaoPAI.AUTO_RESIZE_OFF);
        jTabelaEvolucaoPAI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCelulasTabelaEvolucao();
        conecta.desconecta();
    }

    public void alinharCelulasTabelaEvolucao() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEvolucaoPAI.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void limparTabelaTabelaEvolucao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Evolução"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoPAI.setModel(modelo);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaEvolucaoPAI.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoPAI.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoPAI.setAutoResizeMode(jTabelaEvolucaoPAI.AUTO_RESIZE_OFF);
        jTabelaEvolucaoPAI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog1() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela1);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog4() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela4);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog5() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela5);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog6() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela6);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog7() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela7);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog8() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela8);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog9() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela9);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog10() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela10);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoPAI.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
