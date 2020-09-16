/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAberturaDadosSistemaPorModulo;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ListaAgendaEscoltaCrcM;
import gestor.Controle.ListagemAdmissaoEducacaoFisicaM;
import gestor.Controle.ListagemAdmissaoEducacaoFisicaNovaM;
import gestor.Controle.ListagemAdmissaoEnfermagemComplementarM;
import gestor.Controle.ListagemAdmissaoEnfermagemM;
import gestor.Controle.ListagemAdmissaoJuridicoAdicionaM;
import gestor.Controle.ListagemAdmissaoMedicaComplementarM;
import gestor.Controle.ListagemAdmissaoMedicaM;
import gestor.Controle.ListagemAdmissaoPedagogicaM;
import gestor.Controle.ListagemAdmissaoPedagogicaNovaM;
import gestor.Controle.ListagemAdmissaoPsicologicaM;
import gestor.Controle.ListagemAdmissaoTerapiaM;
import gestor.Controle.ListagemAgendaLaborativaM;
import gestor.Controle.ListagemAprazamentoMedicacaoM;
import gestor.Controle.ListagemAtendimentoFamiliarJuridicoM;
import gestor.Controle.ListagemAtendimentoFamiliarM;
import gestor.Controle.ListagemAtendimentoGrupoEnfermariaM;
import gestor.Controle.ListagemAtendimentoGrupoPedagogiaM;
import gestor.Controle.ListagemAtendimentoGrupoPsiM;
import gestor.Controle.ListagemAtendimentoGrupoSSM;
import gestor.Controle.ListagemAtendimentoGrupoTOM;
import gestor.Controle.ListagemAtendimentoJuridicoM;
import gestor.Controle.ListagemAtendimentoOdontologicoM;
import gestor.Controle.ListagemAtendimentoSocialM;
import gestor.Controle.ListagemAtendimentoTecnicoEnfermagemM;
import gestor.Controle.ListagemAtendimentoTerapiaM;
import gestor.Controle.ListagemAtividadesComplementaresPedaM;
import gestor.Controle.ListagemAtividadesUnidadesM;
import gestor.Controle.ListagemAtualizacaoDocumentosInternosM;
import gestor.Controle.ListagemAvaliacaoMedicaPsiquiatricaM;
import gestor.Controle.ListagemAvaliacaoPsicologicaM;
import gestor.Controle.ListagemCancelamentoNovaEntradadaM;
import gestor.Controle.ListagemCancelamentoVisitasExternaInteraRolM;
import gestor.Controle.ListagemCapacitacaoInternoTOM;
import gestor.Controle.ListagemComposicaoKitHigieneM;
import gestor.Controle.ListagemControleLigacoesM;
import gestor.Controle.ListagemEntradaAdvogadoInternosM;
import gestor.Controle.ListagemEntradaAdvogadosM;
import gestor.Controle.ListagemEntradaColaboradoresM;
import gestor.Controle.ListagemEntradaInternosPortariaM;
import gestor.Controle.ListagemEntradaOficialJusticaInternoM;
import gestor.Controle.ListagemEntradaPertencesM;
import gestor.Controle.ListagemEntradaSaidaVisitasReligiosasM;
import gestor.Controle.ListagemEntradaVeiculosUnidadeM;
import gestor.Controle.ListagemEntradaVisitasDiversasM;
import gestor.Controle.ListagemEntradasFamiliarM;
import gestor.Controle.ListagemEntradasOficialJusticaM;
import gestor.Controle.ListagemEstornoProdutosM;
import gestor.Controle.ListagemEvadidosM;
import gestor.Controle.ListagemFichaJuridicaM;
import gestor.Controle.ListagemFrequanciaPedagogicaExternaM;
import gestor.Controle.ListagemFrequenciaCapacitaTOM;
import gestor.Controle.ListagemFrequenciaLaborTOM;
import gestor.Controle.ListagemLocacaoInternosM;
import gestor.Controle.ListagemMovimentoPopulcaoM;
import gestor.Controle.ListagemNotasFiscaisComprasM;
import gestor.Controle.ListagemOcorrenciaBaseSegurancaAuxM;
import gestor.Controle.ListagemOcorrenciaBaseSegurancaM;
import gestor.Controle.ListagemOcorrenciaEFM;
import gestor.Controle.ListagemOcorrenciaP1EM;
import gestor.Controle.ListagemOcorrenciaPsicologiaM;
import gestor.Controle.ListagemOcorrenciaSegurancaM;
import gestor.Controle.ListagemOcorrenciaServicoSocialM;
import gestor.Controle.ListagemOcorrenciaTOM;
import gestor.Controle.ListagemOcorrenciasEnferemariaM;
import gestor.Controle.ListagemOcorrenciasOdontologicaM;
import gestor.Controle.ListagemOcorrenciasP1M;
import gestor.Controle.ListagemPagamentoKitHigieneM;
import gestor.Controle.ListagemPerfilCarcerarioSSM;
import gestor.Controle.ListagemPernoiteInternosM;
import gestor.Controle.ListagemPortaEntradaPsicologiaM;
import gestor.Controle.ListagemPortaEntradaSSM;
import gestor.Controle.ListagemProgressoaRegimeM;
import gestor.Controle.ListagemProrrogacaoSaidaTemporariaM;
import gestor.Controle.ListagemRegistroCanceladoRetornosM;
import gestor.Controle.ListagemRegistroRetornoM;
import gestor.Controle.ListagemRegistroSaidaCrcM;
import gestor.Controle.ListagemRegistrosCanceladosM;
import gestor.Controle.ListagemRegressaoRegimeM;
import gestor.Controle.ListagemRequiscaoAvulsaProdutosM;
import gestor.Controle.ListagemRequisicaoProdutosInternoM;
import gestor.Controle.ListagemSolicitacaoExamesMedicosM;
import gestor.Controle.ListagemTransientesM;
import gestor.Controle.ListagemTriagemOcupacionalM;
import gestor.Controle.ListagemVeiculosCargasM;
import gestor.Controle.ListagemVeiculosTerceirosM;
import gestor.Controle.ListarEntradasInternosM;
import gestor.Controle.ListarNovaEntrada_InternosM;
import gestor.Controle.ListarPrevisaoSaida_InternosM;
import gestor.Controle.ListarRetornoAudiencia_InternosM;
import gestor.Controle.ListarRetornoEspontaneo_InternosM;
import gestor.Controle.ListarRetornoMedico_InternosM;
import gestor.Controle.ListarRetornoRecaptura_InternosM;
import gestor.Controle.ListarRetornoSaidasTMP_InternosM;
import gestor.Controle.ListarRetornoTransferencia_InternosM;
import gestor.Controle.ListarSaidasInternosM;
import gestor.Controle.ListarTransferenciasInternosM;
import gestor.Controle.ListgagemAtendimentoGrupoEFM;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FechamentoRegistros;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class TelaAberturaRegistroSistema extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FechamentoRegistros objFecha = new FechamentoRegistros();
    //LISTAS CRC
    ListarEntradasInternosM objListaEntradas = new ListarEntradasInternosM();
    ListarSaidasInternosM objListaSaidas = new ListarSaidasInternosM();
    ListarTransferenciasInternosM objListaTrans = new ListarTransferenciasInternosM();
    ListarRetornoSaidasTMP_InternosM objListaST = new ListarRetornoSaidasTMP_InternosM();
    ListarRetornoEspontaneo_InternosM objListaRetEsp = new ListarRetornoEspontaneo_InternosM();
    ListarRetornoRecaptura_InternosM objListaRecap = new ListarRetornoRecaptura_InternosM();
    ListarRetornoAudiencia_InternosM objListaRetAudi = new ListarRetornoAudiencia_InternosM();
    ListarRetornoMedico_InternosM objListaRetMed = new ListarRetornoMedico_InternosM();
    ListarRetornoTransferencia_InternosM objListaRet_TRAN = new ListarRetornoTransferencia_InternosM();
    ListarPrevisaoSaida_InternosM objListaPrevSaida = new ListarPrevisaoSaida_InternosM();
    ListaAgendaEscoltaCrcM objAgendaEscolta = new ListaAgendaEscoltaCrcM();
    ListagemEvadidosM objEvadidos = new ListagemEvadidosM();
    ListagemProgressoaRegimeM objProgressaoRegime = new ListagemProgressoaRegimeM();
    ListagemProrrogacaoSaidaTemporariaM objProrroga = new ListagemProrrogacaoSaidaTemporariaM();
    ListagemCancelamentoNovaEntradadaM objListagemRegCanceladoNE = new ListagemCancelamentoNovaEntradadaM();
    ListagemRegistroCanceladoRetornosM objRegistroCanceladoRetorno = new ListagemRegistroCanceladoRetornosM();
    ListagemRegistrosCanceladosM objRegCancelados = new ListagemRegistrosCanceladosM();
    ListagemRegressaoRegimeM objListaRegressao = new ListagemRegressaoRegimeM();
    //PORTARIA INTERNA
    ListagemEntradaSaidaVisitasReligiosasM LISTAGEM_VISITAS_religiosas = new ListagemEntradaSaidaVisitasReligiosasM();
    ListagemEntradaInternosPortariaM LISTAGEM_ENTRADA_internos = new ListagemEntradaInternosPortariaM();
    ListarNovaEntrada_InternosM LISTAGEM_NOVA_entrada = new ListarNovaEntrada_InternosM();
    ListagemEntradaPertencesM LISTAGEM_pertences = new ListagemEntradaPertencesM();
    ListagemEntradaOficialJusticaInternoM LISTAGEM_OFICIAL_justica = new ListagemEntradaOficialJusticaInternoM();
    ListagemEntradaAdvogadoInternosM LISTAGEM_ADV_internos = new ListagemEntradaAdvogadoInternosM();
    ListagemEntradasFamiliarM LISTAGEM_ENT_familiar = new ListagemEntradasFamiliarM();
    ListagemOcorrenciasP1M LISTAGEM_OCORRENCIA_p1 = new ListagemOcorrenciasP1M();
    ListagemPernoiteInternosM LISTAGEM_pernoite = new ListagemPernoiteInternosM();
    ListagemRegistroRetornoM LISTAGEM_retorno = new ListagemRegistroRetornoM();
    ListagemRegistroSaidaCrcM LISTAGEM_saida = new ListagemRegistroSaidaCrcM();
    ListagemTransientesM LISTAGEM_transientes = new ListagemTransientesM();
    //PORTARIA EXTERNA
    ListagemEntradasOficialJusticaM LISTAGEM_oficial = new ListagemEntradasOficialJusticaM();
    ListagemEntradaAdvogadosM LISTAGEM_advogado = new ListagemEntradaAdvogadosM();
    ListagemEntradaColaboradoresM LISTAGEM__colaborador = new ListagemEntradaColaboradoresM();
    ListagemEntradaVisitasDiversasM LISTAGEM_VISITAS_diversas = new ListagemEntradaVisitasDiversasM();
    ListagemVeiculosCargasM LISTAGEM_VEICULOS_carga = new ListagemVeiculosCargasM();
    ListagemVeiculosTerceirosM LISTAGEM_VEICULOS_terceiros = new ListagemVeiculosTerceirosM();
    ListagemEntradaVeiculosUnidadeM LISTAGEM_VEICULOS_unidade = new ListagemEntradaVeiculosUnidadeM();
    ListagemOcorrenciaP1EM LISTAGEM_OCR_p1e = new ListagemOcorrenciaP1EM();
    //ALMOXARIFADO
    ListagemComposicaoKitHigieneM LISTAGEM_compoKit = new ListagemComposicaoKitHigieneM();
    ListagemEstornoProdutosM LISTAGEM_estorno = new ListagemEstornoProdutosM();
    ListagemNotasFiscaisComprasM LISTAGEM_nf = new ListagemNotasFiscaisComprasM();
    ListagemRequiscaoAvulsaProdutosM LISTAGEM_REQUISISCAO_avulsa = new ListagemRequiscaoAvulsaProdutosM();
    ListagemRequisicaoProdutosInternoM LISTAGEM_REQUISICAO_interno = new ListagemRequisicaoProdutosInternoM();
    ListagemPagamentoKitHigieneM LISTAGEM_pagoKit = new ListagemPagamentoKitHigieneM();
    //BASES
    ListagemLocacaoInternosM LISTAGEM_locacao = new ListagemLocacaoInternosM();
    ListagemOcorrenciaBaseSegurancaM LISTAGEM_OCR_seg = new ListagemOcorrenciaBaseSegurancaM();
    ListagemOcorrenciaBaseSegurancaAuxM LISTAGEM_OCR_sega = new ListagemOcorrenciaBaseSegurancaAuxM();
    // ENFERMAGEM
    ListagemAdmissaoEnfermagemM LISTAGEM_ADM_enfermagem = new ListagemAdmissaoEnfermagemM();
    ListagemAdmissaoEnfermagemComplementarM LISTAGEM_ADM_enfermagemAux = new ListagemAdmissaoEnfermagemComplementarM();
    ListagemAdmissaoMedicaM LISTAGEM_ADM_medico = new ListagemAdmissaoMedicaM();
    ListagemAdmissaoMedicaComplementarM LISTAGEM_ADM_medicoAux = new ListagemAdmissaoMedicaComplementarM();
    ListagemAprazamentoMedicacaoM LISTAGEM_aprazamento = new ListagemAprazamentoMedicacaoM();
    ListagemAtendimentoGrupoEnfermariaM LISTAGEM_atentimentoGRU = new ListagemAtendimentoGrupoEnfermariaM();
    ListagemAtendimentoTecnicoEnfermagemM LISTAGEM_atentimentoTECE = new ListagemAtendimentoTecnicoEnfermagemM();
    ListagemAvaliacaoMedicaPsiquiatricaM LISTAGEM_avalicaoMedPsi = new ListagemAvaliacaoMedicaPsiquiatricaM();
    ListagemOcorrenciasEnferemariaM LISTAGEM_ocr = new ListagemOcorrenciasEnferemariaM();
    ListagemSolicitacaoExamesMedicosM LISTAGEM_exames = new ListagemSolicitacaoExamesMedicosM();
    //GERENCIA ADMINISTRATIVA
    ListagemAtividadesUnidadesM LISTAGEM_atividade = new ListagemAtividadesUnidadesM();
    //JURIDICO
    ListagemAtendimentoJuridicoM LISTAGEM_atendeJuri = new ListagemAtendimentoJuridicoM();
    ListagemAdmissaoJuridicoAdicionaM LISTAGEM_admJuri = new ListagemAdmissaoJuridicoAdicionaM();
    ListagemAtendimentoFamiliarJuridicoM LISTAGEM_atendFamJur = new ListagemAtendimentoFamiliarJuridicoM();
    ListagemFichaJuridicaM LISTAGEM_fichaJU = new ListagemFichaJuridicaM();
    //ODONTOLOGIA
    ListagemAtendimentoOdontologicoM LISTAGEM_odonto = new ListagemAtendimentoOdontologicoM();
    ListagemOcorrenciasOdontologicaM LISTAGEM_OCOR_ODONTO = new ListagemOcorrenciasOdontologicaM();
    //PEDAGOGIA
    ListagemAdmissaoPedagogicaM LISTAGEM_ADM_peda = new ListagemAdmissaoPedagogicaM();
    ListagemAdmissaoPedagogicaNovaM LISTAGEM_ADM_pedaNova = new ListagemAdmissaoPedagogicaNovaM();
    ListagemAtendimentoGrupoPedagogiaM LISTAGEM_ATEND_grupoP = new ListagemAtendimentoGrupoPedagogiaM();
    ListagemAtividadesComplementaresPedaM LISTAGEM_atividadeC = new ListagemAtividadesComplementaresPedaM();
    ListagemFrequanciaPedagogicaExternaM LISTAGEM_frequencia = new ListagemFrequanciaPedagogicaExternaM();
    //PSICOLOGIA
    ListagemAdmissaoPsicologicaM LISTAGEM_adm_psi = new ListagemAdmissaoPsicologicaM();
    ListagemAtendimentoGrupoPsiM LISTAGEM_atd_psi = new ListagemAtendimentoGrupoPsiM();
    ListagemAvaliacaoPsicologicaM LISTAGEM_avalia = new ListagemAvaliacaoPsicologicaM();
    ListagemOcorrenciaPsicologiaM LISTAGEM_OCOR_psi = new ListagemOcorrenciaPsicologiaM();
    ListagemPortaEntradaPsicologiaM LISTAGEM_porta = new ListagemPortaEntradaPsicologiaM();
    //SEGURANÇA
    ListagemMovimentoPopulcaoM LISTAGEM_populcao = new ListagemMovimentoPopulcaoM();
    ListagemOcorrenciaSegurancaM LISTAGEM_OCORR_seg = new ListagemOcorrenciaSegurancaM();
    //SERVIÇO SOCIAL
    ListagemAtendimentoGrupoSSM LISTAGEM_ATEND_grupoSS = new ListagemAtendimentoGrupoSSM();
    ListagemAtendimentoFamiliarM LISTAGEM_ATEND_famSS = new ListagemAtendimentoFamiliarM();
    ListagemAtendimentoSocialM LISTAGEM_ATEND_social = new ListagemAtendimentoSocialM();
    ListagemAtualizacaoDocumentosInternosM LISTAGEM_atualizacao = new ListagemAtualizacaoDocumentosInternosM();
    ListagemCancelamentoVisitasExternaInteraRolM LISTAGEM_cancelaVisista = new ListagemCancelamentoVisitasExternaInteraRolM();
    ListagemControleLigacoesM LISTAGEM_CONTROLE_ligacoes = new ListagemControleLigacoesM();
    ListagemOcorrenciaServicoSocialM LISTAGEM_ocorrencia_ss = new ListagemOcorrenciaServicoSocialM();
    ListagemPerfilCarcerarioSSM LISTAGEM_perfil = new ListagemPerfilCarcerarioSSM();
    ListagemPortaEntradaSSM LISTAGEM_portaEE = new ListagemPortaEntradaSSM();
    //TERAPIA OCUPACIONAL
    ListagemAdmissaoTerapiaM LISTAGEM_terapia = new ListagemAdmissaoTerapiaM();
    ListagemAgendaLaborativaM LISTAGEM_agenda = new ListagemAgendaLaborativaM();
    ListagemAtendimentoGrupoTOM LISTAGEM_atendeGR = new ListagemAtendimentoGrupoTOM();
    ListagemAtendimentoTerapiaM LISTAGEM_atendimentoTO = new ListagemAtendimentoTerapiaM();
    ListagemCapacitacaoInternoTOM LISTAGEM_capacitacaoTO = new ListagemCapacitacaoInternoTOM();
    ListagemFrequenciaCapacitaTOM LISTAGEM_freqCapaTo = new ListagemFrequenciaCapacitaTOM();
    ListagemFrequenciaLaborTOM LISTAGEM_freqLabor = new ListagemFrequenciaLaborTOM();
    ListagemOcorrenciaTOM LISTAGEM_OCORR_to = new ListagemOcorrenciaTOM();
    ListagemTriagemOcupacionalM LISTAGEM_triagemTO = new ListagemTriagemOcupacionalM();
    //EDUCAÇÃO FISICA
    ListagemAdmissaoEducacaoFisicaM LISTAGEM_ADM_ef = new ListagemAdmissaoEducacaoFisicaM();
    ListagemAdmissaoEducacaoFisicaNovaM LISTAGEM_EF_nova = new ListagemAdmissaoEducacaoFisicaNovaM();
    ListgagemAtendimentoGrupoEFM LISTAGEM_ATEND_GRUPO_ef = new ListgagemAtendimentoGrupoEFM();
    ListagemOcorrenciaEFM LISTAGEM_OCORR_ef = new ListagemOcorrenciaEFM();
    //
    ControleAberturaDadosSistemaPorModulo control = new ControleAberturaDadosSistemaPorModulo();
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    String nomeModuloTela = "Configurações:Utilitários:Abertura de Movimentos do Sistema";
    String statusMov;
    String horaMov;
    String dataModFinal;
    String pFECHAMENTO = "ABERTO";
    String pDATA_FECHAMENTO = "";
    int pREGISTROS_PROCESSADOS = 0;
    String pSISTEMA_BLOQUEADO = "Sim"; // DEFAULT É "Não"
    String pSISTEMA_DESBLOQUEADO = "Não";
    //TOTALIZADORES DOS MÓDULOS
    int pTOTAL_GERAL_REGISTROS_CRC = 0;
    int pTOTAL_GERAL_REGISTROS_PORTARIA_INT = 0;
    int pTOTAL_GERAL_REGISTROS_PORTARIA_EXT = 0;
    int pTOTAL_GERAL_REGISTROS_GTE_ADM = 0;
    int pTOTAL_GERAL_REGISTROS_GTE_OPE = 0;
    int pTOTAL_GERAL_REGISTROS_PSICOLOGIA = 0;
    int pTOTAL_GERAL_REGISTROS_SERVICO_SOCIAL = 0;
    int pTOTAL_GERAL_REGISTROS_PEDAGOGIA = 0;
    int pTOTAL_GERAL_REGISTROS_TERAPIA = 0;
    int pTOTAL_GERAL_REGISTROS_JURIDICO = 0;
    int pTOTAL_GERAL_REGISTROS_EDUCACAO_FISICA = 0;
    int pTOTAL_GERAL_REGISTROS_ENFERMARIA = 0;
    int pTOTAL_GERAL_REGISTROS_BASE_I = 0;
    int pTOTAL_GERAL_REGISTROS_BASE_II = 0;
    int pTOTAL_GERAL_REGISTROS_NUTRICAO = 0;
    int pTOTAL_GERAL_REGISTROS_ALMOXARIFADO = 0;
    int pTOTAL_GERAL_REGISTROS_ODONTOLOGIA = 0;

    public static int pTOTAL_ENTRADAS = 0;
    public static int pTOTAL_SAIDAS = 0;
    public static int pTOTAL_TRANSFERENCIAS = 0;
    public static int pRETORNO_SAIDAS_TMP = 0;
    public static int pRETORNO_ESPONTANEO = 0;
    public static int pRETORNO_RECAPTURA = 0;
    public static int pRETORNO_AUDIENCIAS = 0;
    public static int pRETORNO_MEDICO = 0;
    public static int pRETORNO_TRANSFERENCIA = 0;
    public static int pPREVISAO_SAIDA = 0;
    public static int pAGENDA_ESCOLTA = 0;
    public static int pINTERNOS_EVADIDOS = 0;
    public static int pPROGRESSAO_REGIME = 0;
    public static int pPRORROGA = 0;
    public static int pRECAPTURA = 0;
    public static int pREGISTRO_CANCELADO_NE = 0;
    public static int pREGISTRO_CANCELADO_RETORNOS = 0;
    public static int pREGISTRO_CANCELADOS = 0;
    public static int pREGRESSAO_REGIME = 0;
    //PORTARIA INTERNA
    public static int pTOTAL_ENTRADAS_SAIDAS_VISITAS_religiosas = 0;
    public static int pENTRADAS_INTERNOS_portaria = 0;
    public static int pNOVA_ENTRADA = 0;
    public static int pENTRADA_PERTENCES = 0;
    public static int pENTRADA_OFJI = 0;
    public static int pENTRADA_ADV_INTERNOS = 0;
    public static int pENTRADA_FAMILIAR = 0;
    public static int pOCORRENCIAS_P1 = 0;
    public static int pPERNOITE = 0;
    public static int pRETORNO = 0;
    public static int pSAIDAS_CRC = 0;
    public static int pTRANSIENTES = 0;
    //PORTARIA EXTERNA
    public static int pENTRADA_oficial = 0;
    public static int pENTRADA_advogado = 0;
    public static int pENTRADA_colaborador = 0;
    public static int pENTRADA_VISITAS_diversas = 0;
    public static int pENTRADA_VEICULOS_carga = 0;
    public static int pENTRADA_VEICULOS_terceiros = 0;
    public static int pENTRADA_VEICULOS_unidade = 0;
    public static int pOCORRENCIAS_p1e = 0;
    //ALMOXARIFADO
    public static int pCOMPOSICAO = 0;
    public static int pESTORNO = 0;
    public static int pNFC = 0;
    public static int pREQUISICAO_avulsa = 0;
    public static int pREQUISICAO_interno = 0;
    //BASE
    public static int pLOCACAO_interno = 0;
    public static int pOCR_seg = 0;
    public static int pOCR_sega = 0;
    //ENFERMAGEM
    public static int pADM_enfermagem = 0;
    public static int pADM_enfermagemAux = 0;
    public static int pADM_medica = 0;
    public static int pADM_medicaAux = 0;
    public static int pAPRAZAMENTO = 0;
    public static int pATENDIMENTO_GRUPO_ENF = 0;
    public static int pATENDIMENTO_TEC_ENFERMAGEM = 0;
    public static int pAVALIACAO_MED_PSI = 0;
    public static int pOCORRENCIA_ENF = 0;
    public static int pSOLICITACAO = 0;
    //GERENCIA ADMINISGTRATIVA
    public static int pATIVIDADE_UNIDADE = 0;
    //JURIDICO
    public static int pATENDE_JURI = 0;
    public static int pADMISSAO_JURI = 0;
    public static int pATEND_FAMILIA_juri = 0;
    public static int pFICHA_juridica = 0;
    //ALMOXARIFADO
    //PAGAMENTO DE KIT
    public static int pPAGO_kit = 0;
    //ODONTOLOGIA
    public static int pATEND_ODONTO = 0;
    public static int pOCR_ODONTO = 0;
    //PEDAGOGIA
    public static int pADMISSAO_pedagogica = 0;
    public static int pADMISSAO_pedagogicaNova = 0;
    public static int pATEND_GRUPO_pedagogia = 0;
    public static int pATIVIDADES_COMPLEMENTARES = 0;
    public static int pFREQUENCIA_pedagogica = 0;
    //PSICOLOGIA
    public static int pADMISSAO_psicologica = 0;
    public static int pATENDIMENTO_GRUPO_psi = 0;
    public static int pAVALIACAO_psicologica = 0;
    public static int pOCORRENCIA_psiologica = 0;
    public static int pPORTA_entrada = 0;
    //SEGURANÇA
    public static int pMOVIMENTO_populcao = 0;
    public static int pOCORRE_seguranca = 0;
    //SERVIÇO SOCIAL
    public static int pATEND_GRUPO_ss = 0;
    public static int pATEND_FAM_ss = 0;
    public static int pATEND_social = 0;
    public static int pATUALIZA_documento = 0;
    public static int pCANCELA_visitas = 0;
    public static int pCONTROLE_ligacoes = 0;
    public static int pOCORRENCIAS_servico = 0;
    public static int pPERFIL_carcerario = 0;
    public static int pPORTA_ENTRADA_ss = 0;
    //TERAPIA OCUPACIONAL
    public static int pADM_terapia = 0;
    public static int pAGENDA_laborativa = 0;
    public static int pATENDIMENTO_grupoTO = 0;
    public static int pATENDIMENTO_TO = 0;
    public static int pCAPACITACAO_INTERO_to = 0;
    public static int pFREQUENCIA_capa = 0;
    public static int pFREQUENCIA_labora = 0;
    public static int pOCORRE_to = 0;
    public static int pTRIAGEM_to = 0;
    //EDUCAÇÃO FISICA
    public static int pADMISSAO_ef = 0;
    public static int pADMISSAO_EF_nova = 0;
    public static int pATEND_GRUPO_ef = 0;
    public static int pOCORRE_ef = 0;

    String pDATA_INICIAL = "";
    String pDATA_FINAL = "";

    /**
     * Creates new form TelaAberturaRegistroSistema
     */
    public static TelaModuloConfiguracoes pABRIR_REGISTROS;

    public TelaAberturaRegistroSistema(TelaModuloConfiguracoes parent, boolean modal) {
        this.pABRIR_REGISTROS = parent;
        this.setModal(modal);
        setLocationRelativeTo(pABRIR_REGISTROS);
        initComponents();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxModulo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jTOTAL_REGISTROS = new javax.swing.JTextField();
        jREGISTROS_PROCESSADOS = new javax.swing.JTextField();
        jBtPesquisarRegistros = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...:::Abrir Registros Finalizados Por Módulo :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("ATENÇÃO: Selecione o módulo e o range de datas para abrir os registros. Essa ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("operação irá \"ABRIR\" dos os registros do módulo selecionado.");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Solicite aos usuários do módulo (s) a ser(em) aberto(s) não acessar o sistema");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText(" no momento dessa operação.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Módulo:");

        jComboBoxModulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxModulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Módulo Crc", "Módulo Gerência Adminstrativa", "Módulo Almoxarifado", "Módulo Pedagogia", "Módulo Psicologia", "Módulo Enfermaria", "Módulo Serviço Social", "Módulo Jurídico", "Módulo Odontologia", "Módulo Terapia Ocupacional", "Módulo Financeiro", "Módulo Gerência Operacional", "Módulo Base I", "Módulo Base II", "Módulo Portaria Interna", "Módulo Portaria Externa", "Módulo Educação Física", "Módulo Nutrição" }));
        jComboBoxModulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data Inicial:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data Final:");

        jDataInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Total Registros:");

        jTOTAL_REGISTROS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTOTAL_REGISTROS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTOTAL_REGISTROS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTOTAL_REGISTROS.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTOTAL_REGISTROS.setEnabled(false);

        jREGISTROS_PROCESSADOS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jREGISTROS_PROCESSADOS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jREGISTROS_PROCESSADOS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jREGISTROS_PROCESSADOS.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jREGISTROS_PROCESSADOS.setEnabled(false);

        jBtPesquisarRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarRegistros.setText("Pesquisar");
        jBtPesquisarRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarRegistrosActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Registros Processados:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxModulo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTOTAL_REGISTROS)
                            .addComponent(jDataInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jREGISTROS_PROCESSADOS, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesquisarRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtPesquisarRegistros, jREGISTROS_PROCESSADOS, jTOTAL_REGISTROS});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jBtPesquisarRegistros))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jTOTAL_REGISTROS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jREGISTROS_PROCESSADOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtConfirmar.setForeground(new java.awt.Color(0, 153, 0));
        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        jBtSair.setForeground(new java.awt.Color(204, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jBtConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesquisarRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarRegistrosActionPerformed
        // TODO add your handling code here:
        if (jComboBoxModulo.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um módulo a ser aberto.");
        } else if (jDataInicial.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
            jDataInicial.requestFocus();
        } else if (jDataFinal.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
            jDataFinal.requestFocus();
        } else if (jDataInicial.getDate().after(jDataFinal.getDate())) {
            JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
        } else {
            if (jComboBoxModulo.getSelectedItem().equals("Módulo Crc")) {
                pTOTAL_GERAL_REGISTROS_CRC = 0;
                calculoTotais_ENTRADAS_CRC();
                total_GERAL_REGISTROS_CRC();
                jTOTAL_REGISTROS.setText(Integer.toString(pTOTAL_GERAL_REGISTROS_CRC));
            } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Portaria Interna")) {
                pTOTAL_GERAL_REGISTROS_PORTARIA_INT = 0;
                calcularTotais_PORTARIA_INTERNA();
                total_GERAL_REGISTROS_PORTARIA_INTERNA();
                jTOTAL_REGISTROS.setText(Integer.toString(pTOTAL_GERAL_REGISTROS_PORTARIA_INT));
            } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Almoxarifado")) {
                pTOTAL_GERAL_REGISTROS_ALMOXARIFADO = 0;
                calcularTotais_ALMOXARIFADO();
                total_GERAL_REGISTROS_ALMOXARIFADO();
                jTOTAL_REGISTROS.setText(Integer.toString(pTOTAL_GERAL_REGISTROS_ALMOXARIFADO));
            } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Base I")) {
                pTOTAL_GERAL_REGISTROS_BASE_I = 0;
                calcularTotais_BASE_PAVILHAO();
                total_GERAL_REGISTROS_BASE_I();
                jTOTAL_REGISTROS.setText(Integer.toString(pTOTAL_GERAL_REGISTROS_BASE_I));
            } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Enfermaria")) {
                pTOTAL_GERAL_REGISTROS_ENFERMARIA = 0;
                calcularTotais_ENFERMARIA();
                total_GERAL_REGISTROS_ENFERMARIA();
                jTOTAL_REGISTROS.setText(Integer.toString(pTOTAL_GERAL_REGISTROS_ENFERMARIA));
            } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Gerência Adminstrativa")) {
                pTOTAL_GERAL_REGISTROS_GTE_ADM = 0;
                calcularTotais_ADMINISTRACAO();
                total_GERAL_REGISTROS_GTE_ADM();
                jTOTAL_REGISTROS.setText(Integer.toString(pTOTAL_GERAL_REGISTROS_GTE_ADM));
            } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Jurídico")) {
                pTOTAL_GERAL_REGISTROS_JURIDICO = 0;
                calcularTotais_JURIDICO();
                total_GERAL_REGISTROS_JURIDICO();
                jTOTAL_REGISTROS.setText(Integer.toString(pTOTAL_GERAL_REGISTROS_JURIDICO));
            } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Odontologia")) {
                pTOTAL_GERAL_REGISTROS_ODONTOLOGIA = 0;
                calcularTotais_ODONTOLOGICO();
                total_GERAL_REGISTROS_ODONTOLOGIA();
                jTOTAL_REGISTROS.setText(Integer.toString(pTOTAL_GERAL_REGISTROS_PORTARIA_INT));
            } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Pedagogia")) {
                pTOTAL_GERAL_REGISTROS_PEDAGOGIA = 0;
                calcularTotais_PEDAGOGIA();
                total_GERAL_REGISTROS_PEDAGOGIA();
                jTOTAL_REGISTROS.setText(Integer.toString(pTOTAL_GERAL_REGISTROS_PEDAGOGIA));
            } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Psicologia")) {
                calcularTotais_PSICOLOGIA();
                total_GERAL_REGISTROS_PSICOLOGIA();
                jTOTAL_REGISTROS.setText(Integer.toString(pTOTAL_GERAL_REGISTROS_PORTARIA_INT));
            } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Gerência Operacional")) {
                pTOTAL_GERAL_REGISTROS_GTE_OPE = 0;
                calcularTotais_SEGURANCA();
                total_GERAL_REGISTROS_GTE_OP();
                jTOTAL_REGISTROS.setText(Integer.toString(pTOTAL_GERAL_REGISTROS_GTE_OPE));
            } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Serviço Social")) {
                pTOTAL_GERAL_REGISTROS_SERVICO_SOCIAL = 0;
                calcularTotais_SERVICO_SOCIAL();
                total_GERAL_REGISTROS_SERVICO_SOCIAL();
                jTOTAL_REGISTROS.setText(Integer.toString(pTOTAL_GERAL_REGISTROS_SERVICO_SOCIAL));
            } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Terapia Ocupacional")) {
                pTOTAL_GERAL_REGISTROS_TERAPIA = 0;
                calculosTotaisTO();
                total_GERAL_REGISTROS_TERAPAIA();
                jTOTAL_REGISTROS.setText(Integer.toString(pTOTAL_GERAL_REGISTROS_TERAPIA));
            } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Educação Física")) {
                pTOTAL_GERAL_REGISTROS_EDUCACAO_FISICA = 0;
                calcularTotais_EDUCACAO_FISICA();
                total_GERAL_REGISTROS_EDUCACAO_FISICA();
                jTOTAL_REGISTROS.setText(Integer.toString(pTOTAL_GERAL_REGISTROS_EDUCACAO_FISICA));
            }
        }
    }//GEN-LAST:event_jBtPesquisarRegistrosActionPerformed

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        if (jComboBoxModulo.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um módulo a ser aberto.");
        } else if (jTOTAL_REGISTROS.getText().equals("0")) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível executar essa operação com o total de registros zerado...");
        } else if (jTOTAL_REGISTROS.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível executar essa operação com o campo total de registros vazio...");
        } else if (jDataInicial.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
            jDataInicial.requestFocus();
        } else if (jDataFinal.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
            jDataFinal.requestFocus();
        } else if (jDataInicial.getDate().after(jDataFinal.getDate())) {
            JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
        } else {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente abrir os lançamentos do módulo selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                if (tipoServidor == null || tipoServidor.equals("")) {
                    JOptionPane.showMessageDialog(null, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
                } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
                    SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                    pDATA_INICIAL = formatoAmerica.format(jDataInicial.getDate().getTime());
                    pDATA_FINAL = formatoAmerica.format(jDataFinal.getDate().getTime());
                } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
                    SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                    pDATA_INICIAL = formatoAmerica.format(jDataInicial.getDate().getTime());
                    pDATA_FINAL = formatoAmerica.format(jDataFinal.getDate().getTime());
                }
                objFecha.setStatusRegistro(pFECHAMENTO);
                objFecha.setDataInicial(pDATA_INICIAL);
                objFecha.setDataFinal(pDATA_FINAL);
                objFecha.setHoraFechamento(horaMov);
                objFecha.setUsuarioUp(nameUser);
                if (jComboBoxModulo.getSelectedItem().equals("Selecione...")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe o módulo para ser reaberto...");
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Crc")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloCrc();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde                     
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Gerência Adminstrativa")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloGerenciaAdminstrativa();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde    
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Almoxarifado")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloAlmoxarifado();
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde  
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Pedagogia")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloPedagogia();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde     
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Psicologia")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloPsicologia();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde     
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Enfermaria")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloEnfermaria();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde     
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Serviço Social")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloServicoSocial();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde     
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Jurídico")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloJurídico();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde     
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Odontologia")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloOdontologia();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde     
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Terapia Ocupacional")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloTerapiaOcupacional();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde     
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Financeiro")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloFinanceiro();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde     
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Gerência Operacional")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloGerenciaOperacional();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde     
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Base I")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloBaseI();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde     
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Base II")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloBaseII();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde     
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Portaria Interna")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloPortariaInterna();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde     
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Portaria Externa")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloPortariaExterna();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde     
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Educação Física")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloEducacaoFisica();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde     
                } else if (jComboBoxModulo.getSelectedItem().equals("Módulo Nutrição")) {
                    final ViewAguarde carregando = new ViewAguarde(); //Teste tela aguarde
                    carregando.setVisible(true);//Teste tela aguarde
                    Thread t = new Thread() { //Teste tela aguarde
                        public void run() { //Teste
                            ModuloNutrição();
                            carregando.dispose(); //Teste tela aguarde
                            jREGISTROS_PROCESSADOS.setText(jTOTAL_REGISTROS.getText());
                            jTOTAL_REGISTROS.setText("0");
                            JOptionPane.showMessageDialog(rootPane, "Módulo aberto com sucesso.");
                        }
                    }; //Teste tela aguarde
                    t.start(); //Teste tela aguarde     
                }
            }
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAberturaRegistroSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAberturaRegistroSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAberturaRegistroSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAberturaRegistroSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAberturaRegistroSistema dialog = new TelaAberturaRegistroSistema(pABRIR_REGISTROS, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtPesquisarRegistros;
    private javax.swing.JButton jBtSair;
    private javax.swing.JComboBox<String> jComboBoxModulo;
    public static com.toedter.calendar.JDateChooser jDataFinal;
    public static com.toedter.calendar.JDateChooser jDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jREGISTROS_PROCESSADOS;
    private javax.swing.JTextField jTOTAL_REGISTROS;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jTOTAL_REGISTROS.setBackground(Color.white);
        jREGISTROS_PROCESSADOS.setBackground(Color.white);
    }

    public void ModuloCrc() {
        //ENTRADAS DE INTERNOS
        control.fecharEntradas(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                        
        //SAIDAS DE INTERNOS
        control.fecharSaidas(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
        //TRANSFERENCIA
        control.fecharTransferencias(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
        //RETORNO SAIDA TEMPORARIA
        control.fecharRetornoSaidaTemporaria(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
        //RETORNO ESPONTANEO
        control.fecharRetornoEspontaneo(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
        //RECAPTURA
        control.fecharRecaptura(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //RETORNO AUDIÊNCIA
        control.fecharRetornoAudiencia(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
        //RETORNO MÉDICO
        control.fecharRetornoMedico(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
        //PREVISÃO DE SAÍDA
        control.fecharPrevisaoSaida(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
        //RETORNO POR TRANSFERENCIA
        control.fecharRetornoPorTransferencia(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
        //AGENDAMENTO DE ESCOLTA
        control.fecharAgendaEscolta(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //EVADIDOS                        
        control.fecharEvadidos(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //PROGRESSÃO DE REGIME
        control.fecharProgressaoRegime(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //PRORROGAÇÃO DE SAIDA TEMPORÁRIA E PRISÃO DOMICILIAR
        control.fecharProrrogacao_SAIDA_tmp(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                                                 
        //REGISTRO CANCELADO NOVA ENTRADA
        control.fecharRegistroCanceladoNE(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
        //REGISTRO CANCELADO RETORNOS
        control.fecharRegistroCanceladoRetorno(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
        //REGISTRO CANCELADO
        control.fecharRegistroCancelado(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
        //REGRESSÃO
        control.fecharRegressaoRegime(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
    }

    public void ModuloGerenciaAdminstrativa() {
        //ATIVIDADES MENSAL REALIZADAS NA UNIDADE
        control.fecharATIVI_realizadas(objFecha);
    }

    public void ModuloAlmoxarifado() {
        //COMPOSIÇÃO DE KIT DE HIGIÊNE
        control.fecharALMOX(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ESTORNO DE PRODUTO
        control.fecharESTORNO(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //NOTA FISCAL DE COMPRAS
        control.fecharNFC(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //REQUISIÇÃO AVULSA DE PRODUTOS
        control.fecharRAP(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //REQUISIÇÃO DE INTERNOS
        control.fecharRPI(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //PAGAMENTO DE KIT HIGIENE
        control.fecharPAGTO_kit(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
    }

    public void ModuloPedagogia() {
        //ADMISSAO PEDAGOGIA
        control.fecharADM_peda(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ADMISSAO PEDAGOGICA NOVA
        control.fecharADM_pedaNova(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ATENDIMENTO EM GRUPO
        control.fecharATM_GRUPO_peda(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ATIVIDADES COMPLEMENTARES
        control.fecharATV_complementar(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //FREQUENCIA PEDAGOGICA
        control.fecharFrequencia(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
    }

    public void ModuloPsicologia() {
        //ADMISSAO PSICOLOGICA
        control.fecharADM_psi(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ATENDIMENTO GRUPO
        control.fecharATG_psi(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //AVALIAÇÃO PSICOLOGICA
        control.fecharAVA_psi(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //OCORRÊNCIAS
        control.fecharOCO_psi(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //PORTA ENTRADA PSICOLOGICA
        control.fecharPORTA_psi(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
    }

    public void ModuloEnfermaria() {
        //ADMISSÃO ENFERMEIRA
        control.fecharADMEnfermagem(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ADMISSÃO ENFERMEIRA COMPLEMENTAR
        control.fecharADMEnfermagemAux(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ADMISSAÕ MEDICA
        control.fecharADMmedica(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ADMISSÃO MEDICA ADICIONAL
        control.fecharADMmedicaAux(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //APRAZAMENTO MEDICAÇÃO
        control.fecharAPRAZAMENTO(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ATENDIMENTO EM GRUPO ENFERMAGEM
        control.fecharATGRUE(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ATENDIMENTO TÉCNICO ENFERMAGEM
        control.fecharATTENF(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //AVALIAÇÃO MÉDICA PSIQUIATRA
        control.fecharAVAMP(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //OCORRÊNCIAS
        control.fecharOCEN(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //SOLICITAÇÃO EXAMES MEDICO E PSIQUIATRICO
        control.fecharSOLIX(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
    }

    public void ModuloServicoSocial() {
        //ATENDIMENTO EM GRUPO
        control.fecharATEND_grupoSS(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ATENDIMENTO FAMILIAR
        control.fecharATEND_famSS(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ATENDIMENTOSOCIAL
        control.fecharATEND_social(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ATUALIZAÇÃO DOCUMENTOS DE INTERNOS
        control.fecharATUALIZACAO_documentos(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //CANCELAMENTO DE VISITAS EXTERNA AOS INTERNOS
        control.fecharCANCELA_visita(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //CONTROLE DE LIGAÇÕES
        control.fecharCONTROLE_ligacoes(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //OCORRÊNCIAS SERVIÇO SOCIAL
        control.fecharOCORR(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //PERFIL CARCERÁRIO
        control.fecharPERFIL(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //PORTA DE ENTRADA
        control.fecharPORTA(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
    }

    public void ModuloJurídico() {
        //ATENCIMENTO JURIDICO
        control.fecharATEND_JURI(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ADMISSAO JURIDICO ADICIONAL
        control.fecharADM_JURI(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ATENDIMENTO FAMILIAR JURIDICO
        control.fecharATEND_FAM_JURI(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //FICHA JURÍDICA
        control.fecharFICHA_juri(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação        
    }

    public void ModuloOdontologia() {
        //ATENDIMENTO ODONTOLOGICO
        control.fecharATEND_odonto(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //OCORRÊNCIAS
        control.fecharOCORRE_odonto(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
    }

    public void ModuloTerapiaOcupacional() {
        //ADMISSÃO TERAPIA
        control.fecharADM_to(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //AGENDA LABORATIVA
        control.fecharAGENDA_to(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ATENDIMENTO EM GRUPO
        control.fecharATENDE_GRU_to(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ATENDIMENTO TERAPIA
        control.fecharATENDE_to(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //CAPACITAÇÃO INTERNO
        control.fecharCAPACITA_to(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //FREQUENCIA CAPACITAÇÃO DE INTERNO
        control.fecharFREQUENTA_to(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //FREQUENCIA LABORATIVA DE INTERNO
        control.fecharFREQUENTA_labor_to(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação .
        //OCORRÊNCIAS
        control.fecharOCORR_to(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //TRIAGEM OCUPACIONAL
        control.fecharTRIAGEM_to(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
    }

    public void ModuloFinanceiro() {
        objFecha.setStatusRegistro(pFECHAMENTO);
        objFecha.setDataFechamento(pDATA_FECHAMENTO);
        objFecha.setHoraFechamento(horaMov);
        objFecha.setUsuarioUp(nameUser);
        //ESTÁ FALTANDO IMPLEMENTAR
    }

    public void ModuloGerenciaOperacional() {
        //LOCAÇÃO DE INTERNOS
        control.fecharLOCA(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //OCORRÊNCIAS BASE SEGURANÇA
        control.fecharOCRbs(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //OCORRÊNCIAS BASE SEGURANÇA AUXILIAR
        control.fecharOCRbsa(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //MOVIMENTO POPULAÇÃO
        control.fecharMOVPOP_seg(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //OCORRÊNCIAS SEGURANÇA
        control.fecharOCORR_seg(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
    }

    public void ModuloBaseI() {
        //ESTÁ FALTANDO IMPLEMENTAR
    }

    public void ModuloBaseII() {
        //ESTÁ FALTANDO IMPLEMENTAR
    }

    public void ModuloPortariaInterna() {
        //VISITAS RELIGIOSAS
        control.fecharVisitasReligiosas(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
        //NOVA ENTRADA
        control.fecharNovaEntrada(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ENTRADA PELA PRIMEIRA VEZ
        control.fecharEntradaInternosPortaria(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ENTRADA DE PERTENCES
        control.fecharEntradaPertences(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ENTRADA DE OFICIAL DE JUSTIÇA INTERNOS
        control.fecharEntradaOFJI(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ENTRADAS DE ADVOGADOS INTERNOS
        control.fecharEntradaADVI(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ENTRADAS FAMILIARES AOS INTERNOS
        control.fecharEntradaFamiliar(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //OCORRÊNCIAS P1
        control.fecharOcorrenciasP1(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //PERNOITE DE INTERNOS
        control.fecharPernoiteInternos(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //RETORNO DE INTERNO
        control.fecharRegistroRetorno(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //SAIDA NA PORTARIA
        control.fecharSaidaPortaria(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //TRANSIENTES
        control.fecharTransientes(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
    }

    public void ModuloPortariaExterna() {
        //ENTRADAS OFICIAL DE JUSTIÇA
        control.fecharOFF(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ENTRADAS ADVOGADOS
        control.fecharADV(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ENTRADA COLABORADORES
        control.fecharCOL(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ENTRADA VISITAS DIVERSAS
        control.fecharVD(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ENTRAVA VEICULOS DE CARGAS
        control.fecharEVC(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ENTRADA VEICULOS TERCEIROS
        control.fecharEVCt(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //ENTRADA VEICULOS DA UNIDADE
        control.fecharEVCu(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
        //OCORRÊNCIAS P1E
        control.fecharOCRP1e(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
    }

    public void ModuloEducacaoFisica() {
        //ADMISSÃO EDUCAÇÃO FÍSICA
        control.fecharADM_ef(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
        //ADMISSÃO EDUCAÇÃO FÍSICA NOVA
        control.fecharADM_EF_nova(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
        //ATENDIMENTO EM GRUPO
        control.fecharATEND_GRUPO_ef(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
        //OCORRÊNCIAS
        control.fecharOCORRE_ef(objFecha);
        objLog();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
    }

    public void ModuloNutrição() {
        //ESTÁ FALTANDO IMPLEMENTAR
    }

    public void total_GERAL_REGISTROS_CRC() {
        pTOTAL_GERAL_REGISTROS_CRC = pTOTAL_ENTRADAS
                + pTOTAL_SAIDAS + pTOTAL_TRANSFERENCIAS
                + pRETORNO_SAIDAS_TMP + pRETORNO_ESPONTANEO
                + pRETORNO_RECAPTURA + pRETORNO_AUDIENCIAS
                + pRETORNO_MEDICO + pRETORNO_TRANSFERENCIA
                + pPREVISAO_SAIDA + pNOVA_ENTRADA
                + pAGENDA_ESCOLTA + pINTERNOS_EVADIDOS
                + pPROGRESSAO_REGIME + pPRORROGA;
    }

    public void total_GERAL_REGISTROS_PORTARIA_INTERNA() {
        pTOTAL_GERAL_REGISTROS_PORTARIA_INT = pREGISTRO_CANCELADO_NE + pREGISTRO_CANCELADO_RETORNOS
                + pREGISTRO_CANCELADOS + pREGRESSAO_REGIME
                + pTOTAL_ENTRADAS_SAIDAS_VISITAS_religiosas
                + pENTRADAS_INTERNOS_portaria + pENTRADA_PERTENCES
                + pENTRADA_OFJI + pENTRADA_ADV_INTERNOS + pENTRADA_ADV_INTERNOS
                + pENTRADA_FAMILIAR + pOCORRENCIAS_P1 + pPERNOITE + pRETORNO
                + pSAIDAS_CRC + pTRANSIENTES;
    }

    public void total_GERAL_REGISTROS_PORTARIA_EXTERNA() {
        pTOTAL_GERAL_REGISTROS_PORTARIA_EXT = pENTRADA_oficial + pENTRADA_advogado
                + pENTRADA_colaborador + pENTRADA_VISITAS_diversas + pENTRADA_VEICULOS_carga
                + pENTRADA_VEICULOS_terceiros + pENTRADA_VEICULOS_unidade + pOCORRENCIAS_p1e;
    }

    public void total_GERAL_REGISTROS_ALMOXARIFADO() {
        pTOTAL_GERAL_REGISTROS_ALMOXARIFADO = pCOMPOSICAO
                + pESTORNO + pNFC + pREQUISICAO_avulsa
                + pREQUISICAO_interno;
    }

    public void total_GERAL_REGISTROS_BASE_I() {
        pTOTAL_GERAL_REGISTROS_BASE_I = pOCR_seg;
    }

    public void total_GERAL_REGISTROS_BASE_II() {
        pTOTAL_GERAL_REGISTROS_BASE_II = pOCR_sega;
    }

    public void total_GERAL_REGISTROS_ENFERMARIA() {
        pTOTAL_GERAL_REGISTROS_ENFERMARIA = pADM_enfermagem
                + pADM_enfermagemAux + pADM_medica
                + pADM_medicaAux + pAPRAZAMENTO
                + pATENDIMENTO_GRUPO_ENF
                + pATENDIMENTO_TEC_ENFERMAGEM
                + pAVALIACAO_MED_PSI + pOCORRENCIA_ENF
                + pSOLICITACAO;
    }

    public void total_GERAL_REGISTROS_GTE_ADM() {
        pTOTAL_GERAL_REGISTROS_GTE_ADM = pATIVIDADE_UNIDADE;
    }

    public void total_GERAL_REGISTROS_JURIDICO() {
        pTOTAL_GERAL_REGISTROS_JURIDICO = pATENDE_JURI
                + pADMISSAO_JURI + pATEND_FAMILIA_juri + pFICHA_juridica;
    }

    public void total_GERAL_REGISTROS_ODONTOLOGIA() {
        pTOTAL_GERAL_REGISTROS_ODONTOLOGIA = pATEND_ODONTO
                + pOCR_ODONTO;
    }

    public void total_GERAL_REGISTROS_PEDAGOGIA() {
        pTOTAL_GERAL_REGISTROS_PEDAGOGIA = pADMISSAO_pedagogica
                + pADMISSAO_pedagogicaNova + pATEND_GRUPO_pedagogia
                + pATIVIDADES_COMPLEMENTARES + pFREQUENCIA_pedagogica;
    }

    public void total_GERAL_REGISTROS_PSICOLOGIA() {
        pTOTAL_GERAL_REGISTROS_PSICOLOGIA = pADMISSAO_psicologica
                + pATENDIMENTO_GRUPO_psi + pAVALIACAO_psicologica
                + pOCORRENCIA_psiologica + pPORTA_entrada;
    }

    public void total_GERAL_REGISTROS_SERVICO_SOCIAL() {
        pTOTAL_GERAL_REGISTROS_SERVICO_SOCIAL = pATEND_GRUPO_ss
                + pATEND_FAM_ss + pATEND_social
                + pATUALIZA_documento + pCANCELA_visitas
                + pCONTROLE_ligacoes + pOCORRENCIAS_servico
                + pPERFIL_carcerario + pPORTA_ENTRADA_ss;
    }

    public void total_GERAL_REGISTROS_TERAPAIA() {
        pTOTAL_GERAL_REGISTROS_TERAPIA = pADM_terapia
                + pAGENDA_laborativa
                + pATENDIMENTO_grupoTO + pATENDIMENTO_TO
                + pCAPACITACAO_INTERO_to + pFREQUENCIA_capa
                + pFREQUENCIA_labora + pOCORRE_to + pTRIAGEM_to;
    }

    public void total_GERAL_REGISTROS_GTE_OP() {
        pTOTAL_GERAL_REGISTROS_GTE_OPE = pMOVIMENTO_populcao
                + pOCORRE_seguranca;
    }

    public void total_GERAL_REGISTROS_EDUCACAO_FISICA() {
        pTOTAL_GERAL_REGISTROS_EDUCACAO_FISICA = pADMISSAO_ef
                + pADMISSAO_EF_nova + pATEND_GRUPO_ef + pOCORRE_ef;
    }

    public void total_GERAL_REGISTROS_NUTRICAO() {
//    int pTOTAL_GERAL_REGISTROS_NUTRICAO = 0;
    }

    public void calculoTotais_ENTRADAS_CRC() {
        //ENTRADAS CRC
        try {
            for (FechamentoRegistros pE : objListaEntradas.read()) {
                pE.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //SAIDAS CRC
        try {
            for (FechamentoRegistros pS : objListaSaidas.read()) {
                pS.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //TRANSFERÊNCIAS
        try {
            for (FechamentoRegistros pT : objListaTrans.read()) {
                pT.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //RETORNO ESPONTANEO
        try {
            for (FechamentoRegistros pRE : objListaRetEsp.read()) {
                pRE.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //RETORNO RECAPTURA
        try {
            for (FechamentoRegistros pREC : objListaRecap.read()) {
                pREC.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //RETORNO AUDIÊNCIA objListaRetAudi
        try {
            for (FechamentoRegistros pRA : objListaRetAudi.read()) {
                pRA.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //RETORNO MÉDICO 
        try {
            for (FechamentoRegistros pM : objListaRetMed.read()) {
                pM.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //RETORNO TRANSFERENCIA
        try {
            for (FechamentoRegistros pRT : objListaRet_TRAN.read()) {
                pRT.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        //PREVISÃO SAIDA
        try {
            for (FechamentoRegistros pPS : objListaPrevSaida.read()) {
                pPS.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //AGENDA ESCOLTA       
        try {
            for (FechamentoRegistros pAGC : objAgendaEscolta.read()) {
                pAGC.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //EVADIDOS 
        try {
            for (FechamentoRegistros pEVA : objEvadidos.read()) {
                pEVA.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //PROGRESSAO REGIME
        try {
            for (FechamentoRegistros pPRR : objProgressaoRegime.read()) {
                pPRR.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //PRORROGAÇÃO DE SAIDA TEMPORARIA E PRISAO DOMICILIAR         
        try {
            for (FechamentoRegistros pPRRO : objProrroga.read()) {
                pPRRO.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //REGISTRO CANCELADO NOVA ENTRADA
        try {
            for (FechamentoRegistros pREGCNE : objListagemRegCanceladoNE.read()) {
                pREGCNE.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //REGISTRO CANCELADO RETORNOS
        try {
            for (FechamentoRegistros pRECR : objRegistroCanceladoRetorno.read()) {
                pRECR.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //REGISTROS CANCELADOS
        try {
            for (FechamentoRegistros pREC : objRegCancelados.read()) {
                pREC.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //REGRESSÃO
        try {
            for (FechamentoRegistros pREG : objListaRegressao.read()) {
                pREG.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //PORTARIA
    public void calcularTotais_PORTARIA_INTERNA() {
        //NOVA ENTRADA
        try {
            for (FechamentoRegistros pNV : LISTAGEM_NOVA_entrada.read()) {
                pNV.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //VISITAS RELIGIOSAS
        try {
            for (FechamentoRegistros pVR : LISTAGEM_VISITAS_religiosas.read()) {
                pVR.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ENTRADA PRIMEIRA VEZ
        try {
            for (FechamentoRegistros pEP : LISTAGEM_ENTRADA_internos.read()) {
                pEP.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ENTRADA DE PERTENCES
        try {
            for (FechamentoRegistros pEPE : LISTAGEM_pertences.read()) {
                pEPE.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ENTRADA OFICIAL JUSTIÇA INTERNOS
        try {
            for (FechamentoRegistros pOFI : LISTAGEM_OFICIAL_justica.read()) {
                pOFI.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ENTRADA DE ADVIGADOS AOS INTENOS
        try {
            for (FechamentoRegistros pADV : LISTAGEM_ADV_internos.read()) {
                pADV.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ENTRADAS FAMILIARES
        try {
            for (FechamentoRegistros pEFI : LISTAGEM_ENT_familiar.read()) {
                pEFI.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        //
        try {
            for (FechamentoRegistros pOP1 : LISTAGEM_OCORRENCIA_p1.read()) {
                pOP1.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //PERNOITE 
        try {
            for (FechamentoRegistros pPER : LISTAGEM_pernoite.read()) {
                pPER.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //REGISTRO DE RETORNO        
        try {
            for (FechamentoRegistros pRET : LISTAGEM_retorno.read()) {
                pRET.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //SAÍDA NA PORTARIA
        try {
            for (FechamentoRegistros pSAI : LISTAGEM_saida.read()) {
                pSAI.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //TRANSIENTES
        try {
            for (FechamentoRegistros pTRANS : LISTAGEM_transientes.read()) {
                pTRANS.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ENTRADA OFICIAL DE JUSTIÇA
        try {
            for (FechamentoRegistros pOFF : LISTAGEM_oficial.read()) {
                pOFF.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ENTRADAS ADVOGADOS 
        try {
            for (FechamentoRegistros pADV : LISTAGEM_advogado.read()) {
                pADV.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ENTRADAS COLABORADORES        
        try {
            for (FechamentoRegistros pCOL : LISTAGEM__colaborador.read()) {
                pCOL.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ENTRADAS VISITAS DIVERSAS 
        try {
            for (FechamentoRegistros pVD : LISTAGEM_VISITAS_diversas.read()) {
                pVD.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ENTRADA VEICULOS CARGAS 
        try {
            for (FechamentoRegistros pEVC : LISTAGEM_VEICULOS_carga.read()) {
                pEVC.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ENTRADAS VEICULOS TERCEIROS 
        try {
            for (FechamentoRegistros pEVCt : LISTAGEM_VEICULOS_terceiros.read()) {
                pEVCt.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ENTRADA VEICULOS UNIDADE 
        try {
            for (FechamentoRegistros pEVCu : LISTAGEM_VEICULOS_unidade.read()) {
                pEVCu.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //OCORRÊNCIAS P1 EXTERNA 
        try {
            for (FechamentoRegistros pOCRP1e : LISTAGEM_OCR_p1e.read()) {
                pOCRP1e.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ALMOXARIFADO
    public void calcularTotais_ALMOXARIFADO() {
        //COMPOSIÇÃO DO KIT DE HIGIENE
        try {
            for (FechamentoRegistros pCOMP : LISTAGEM_compoKit.read()) {
                pCOMP.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ESTORNO DE PRODUTO 
        try {
            for (FechamentoRegistros pESTOR : LISTAGEM_estorno.read()) {
                pESTOR.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //NOTA FISCAL DE COMPRAS 
        try {
            for (FechamentoRegistros pNF : LISTAGEM_nf.read()) {
                pNF.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //REQUISIÇÃO AVULSA DE PRODUTOS 
        try {
            for (FechamentoRegistros pRAP : LISTAGEM_REQUISISCAO_avulsa.read()) {
                pRAP.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //REQUISIÇÃO DE INTERNOS 
        try {
            for (FechamentoRegistros pRPI : LISTAGEM_REQUISICAO_interno.read()) {
                pRPI.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //PAGAMENTO DE KIT 
        try {
            for (FechamentoRegistros pPAGTO_kit : LISTAGEM_pagoKit.read()) {
                pPAGTO_kit.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //BASES DOS PAVILHÕES
    public void calcularTotais_BASE_PAVILHAO() {
        //LOCAÇÃO DOS INTERNOS NA CELA
        try {
            for (FechamentoRegistros pLOCA : LISTAGEM_locacao.read()) {
                pLOCA.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //OCORRÊNCIAS BASE SEGURANÇA 
        try {
            for (FechamentoRegistros pOCR_seg : LISTAGEM_OCR_seg.read()) {
                pOCR_seg.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //OCORRÊNCIAS BASE SEGURANÇA AUXILIAR LISTAGEM_OCR_sega
        try {
            for (FechamentoRegistros pOCR_sega : LISTAGEM_OCR_sega.read()) {
                pOCR_sega.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ENFERMAGEM
    public void calcularTotais_ENFERMARIA() {
        //ADMISSÃO ENFERMEIRA 
        try {
            for (FechamentoRegistros pADM_enfermagem : LISTAGEM_ADM_enfermagem.read()) {
                pADM_enfermagem.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ADMISSÃO ENFERMEIRA COMPLEMENTAR 
        try {
            for (FechamentoRegistros pADM_enfermagemAux : LISTAGEM_ADM_enfermagemAux.read()) {
                pADM_enfermagemAux.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ADMISSAÕ MEDICA LISTAGEM_ADM_medico
        try {
            for (FechamentoRegistros pADM_medico : LISTAGEM_ADM_medico.read()) {
                pADM_medico.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ADMISSÃO MEDICA ADICIONAL 
        try {
            for (FechamentoRegistros pADM_medicoAux : LISTAGEM_ADM_medicoAux.read()) {
                pADM_medicoAux.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //APRAZAMENTO MEDICAÇÃO LISTAGEM_aprazamento
        try {
            for (FechamentoRegistros pAPRAZA : LISTAGEM_aprazamento.read()) {
                pAPRAZA.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ATENDIMENTO EM GRUPO ENFERMAGEM 
        try {
            for (FechamentoRegistros pATGRU : LISTAGEM_atentimentoGRU.read()) {
                pATGRU.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ATENDDIMENTO TÉCNICO ENFERMAGEM 
        try {
            for (FechamentoRegistros pATTENF : LISTAGEM_atentimentoTECE.read()) {
                pATTENF.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //AVALIAÇÃO MÉDICA PSIQUIATRA 
        try {
            for (FechamentoRegistros pAVAMP : LISTAGEM_avalicaoMedPsi.read()) {
                pAVAMP.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //OCORRÊNCIAS
        try {
            for (FechamentoRegistros pOCREN : LISTAGEM_ocr.read()) {
                pOCREN.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //SOLICITAÇÃO EXAMES MEDICO E PSIQUIATRICO 
        try {
            for (FechamentoRegistros pEXAME : LISTAGEM_exames.read()) {
                pEXAME.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //GERENCIA ADMINISTRATIVA
    public void calcularTotais_ADMINISTRACAO() {
        //ATIVIDADES UNIDADE
        try {
            for (FechamentoRegistros pEXAME : LISTAGEM_atividade.read()) {
                pEXAME.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //JURIDICO
    public void calcularTotais_JURIDICO() {
        //ATENDIMENTO JURIDICO
        try {
            for (FechamentoRegistros pATJ : LISTAGEM_atendeJuri.read()) {
                pATJ.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ADMISSAO JURIDICO ADICIONAL 
        try {
            for (FechamentoRegistros pAJ : LISTAGEM_admJuri.read()) {
                pAJ.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ATENDIMENTO FAMILIAR JURIDICO 
        try {
            for (FechamentoRegistros pAFJ : LISTAGEM_atendFamJur.read()) {
                pAFJ.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //FICHA JURÍDICA 
        try {
            for (FechamentoRegistros pFJ : LISTAGEM_fichaJU.read()) {
                pFJ.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ODONTOLOGIA 
    public void calcularTotais_ODONTOLOGICO() {
        //ATENDIMENTO
        try {
            for (FechamentoRegistros pATEN_ODON : LISTAGEM_odonto.read()) {
                pATEN_ODON.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //OCORRÊNCIAS
        try {
            for (FechamentoRegistros pOCR_ODON : LISTAGEM_OCOR_ODONTO.read()) {
                pOCR_ODON.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //PEDAGOGIA
    public void calcularTotais_PEDAGOGIA() {
        //ADMISSAO PEDAGOGIA LISTAGEM_ADM_peda
        try {
            for (FechamentoRegistros pADM_peda : LISTAGEM_ADM_peda.read()) {
                pADM_peda.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ADMISSAO PEDAGOGICA NOVA 
        try {
            for (FechamentoRegistros pADM_pedaNova : LISTAGEM_ADM_pedaNova.read()) {
                pADM_pedaNova.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ATENDIMENTO EM GRUPO 
        try {
            for (FechamentoRegistros pADM_grupo : LISTAGEM_ATEND_grupoP.read()) {
                pADM_grupo.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ATIVIDADES COMPLEMENTARES 
        try {
            for (FechamentoRegistros pADM_compl : LISTAGEM_atividadeC.read()) {
                pADM_compl.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //FREQUENCIA PEDAGOGICA 
        try {
            for (FechamentoRegistros pFreq : LISTAGEM_frequencia.read()) {
                pFreq.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //PSICOLOGIA
    public void calcularTotais_PSICOLOGIA() {
        //ADMISSAO PSICOLOGICA
        try {
            for (FechamentoRegistros pADM_psi : LISTAGEM_adm_psi.read()) {
                pADM_psi.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ATENDIMENTO GRUPO 
        try {
            for (FechamentoRegistros pATD_psi : LISTAGEM_atd_psi.read()) {
                pATD_psi.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //AVALIAÇÃO PSICOLOGICA 
        try {
            for (FechamentoRegistros pAVA_psi : LISTAGEM_avalia.read()) {
                pAVA_psi.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //OCORRÊNCIAS LISTAGGEM_OCOR_psi
        try {
            for (FechamentoRegistros pOCO_psi : LISTAGEM_OCOR_psi.read()) {
                pOCO_psi.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //PORTA ENTRADA PSICOLOGICA 
        try {
            for (FechamentoRegistros pPORTA_ENT_psi : LISTAGEM_porta.read()) {
                pPORTA_ENT_psi.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //SEGURANÇA
    public void calcularTotais_SEGURANCA() {
        //MOVIMENTO POPULÇÃO 
        try {
            for (FechamentoRegistros pMOV_pop : LISTAGEM_populcao.read()) {
                pMOV_pop.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //OCORRÊNCIA SEGURANÇA 
        try {
            for (FechamentoRegistros pOCORR_seg : LISTAGEM_OCORR_seg.read()) {
                pOCORR_seg.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void calcularTotais_SERVICO_SOCIAL() {
        //ATENDIMENTO EM GRUPO LISTAGEM_ATEND_grupoSS
        try {
            for (FechamentoRegistros pATEND_GRU_ss : LISTAGEM_ATEND_grupoSS.read()) {
                pATEND_GRU_ss.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ATENDIMENTO FAMILIAR
        try {
            for (FechamentoRegistros pATEND_FAN_ss : LISTAGEM_ATEND_famSS.read()) {
                pATEND_FAN_ss.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ATENDIMENTOSOCIAL 
        try {
            for (FechamentoRegistros pATEND_SOS_ss : LISTAGEM_ATEND_social.read()) {
                pATEND_SOS_ss.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ATUALIZAÇÃO DOCUMENTOS DE INTERNOS 
        try {
            for (FechamentoRegistros pATUALiza_DOC_ss : LISTAGEM_atualizacao.read()) {
                pATUALiza_DOC_ss.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //CANCELAMENTO DE VISITAS EXTERNA AOS INTERNOS 
        try {
            for (FechamentoRegistros pCANCELA_VISITA_ss : LISTAGEM_cancelaVisista.read()) {
                pCANCELA_VISITA_ss.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //CONTROLE DE LIGAÇÕES 
        try {
            for (FechamentoRegistros pCONTROLE_ligacoes_ss : LISTAGEM_CONTROLE_ligacoes.read()) {
                pCONTROLE_ligacoes_ss.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //OCORRÊNCIAS SERVIÇO SOCIAL 
        try {
            for (FechamentoRegistros pOCORR_ss : LISTAGEM_ocorrencia_ss.read()) {
                pOCORR_ss.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //PERFIL CARCERÁRIO 
        try {
            for (FechamentoRegistros pPERFIL_ss : LISTAGEM_perfil.read()) {
                pPERFIL_ss.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //PORTA DE ENTRADA         
        try {
            for (FechamentoRegistros pPORTA_ss : LISTAGEM_portaEE.read()) {
                pPORTA_ss.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //TERAPIA OCUPACIONAL
    public void calculosTotaisTO() {
        //ADMISSÃO TERAPIA 
        try {
            for (FechamentoRegistros pADM_to : LISTAGEM_terapia.read()) {
                pADM_to.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //AGENDA LABORATIVA 
        try {
            for (FechamentoRegistros pAGENDA_to : LISTAGEM_agenda.read()) {
                pAGENDA_to.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ATENDIMENTO EM GRUPO 
        try {
            for (FechamentoRegistros pATENDE_GRU_to : LISTAGEM_atendeGR.read()) {
                pATENDE_GRU_to.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ATENDIMENTO TERAPIA 
        try {
            for (FechamentoRegistros pATENDE_to : LISTAGEM_atendimentoTO.read()) {
                pATENDE_to.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //CAPACITAÇÃO INTERNO 
        try {
            for (FechamentoRegistros pCAPACITA_to : LISTAGEM_capacitacaoTO.read()) {
                pCAPACITA_to.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //FREQUENCIA CAPACITAÇÃO DE INTERNO 
        try {
            for (FechamentoRegistros pFREQUENTA_to : LISTAGEM_freqCapaTo.read()) {
                pFREQUENTA_to.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //FREQUENCIA LABORATIVA DE INTERNO 
        try {
            for (FechamentoRegistros pFREQUENTA_labor_to : LISTAGEM_freqLabor.read()) {
                pFREQUENTA_labor_to.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //OCORRÊNCIAS 
        try {
            for (FechamentoRegistros pOCORRE_to : LISTAGEM_OCORR_to.read()) {
                pOCORRE_to.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //TRIAGEM OCUPACIONAL 
        try {
            for (FechamentoRegistros pTRIAGEM_to : LISTAGEM_triagemTO.read()) {
                pTRIAGEM_to.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //EDUCAÇÃO FÍSICA
    public void calcularTotais_EDUCACAO_FISICA() {
        //ADMISSÃO FISICA LISTAGEM_ADM_ef
        try {
            for (FechamentoRegistros pADM_ef : LISTAGEM_ADM_ef.read()) {
                pADM_ef.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ADMISSAO FISICA NOVA LISTAGEM_EF_nova
        try {
            for (FechamentoRegistros pADM_EF_nova : LISTAGEM_EF_nova.read()) {
                pADM_EF_nova.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ATENDIMENTO EM GRUPO 
        try {
            for (FechamentoRegistros pAT_GR : LISTAGEM_ATEND_GRUPO_ef.read()) {
                pAT_GR.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //OCORRÊNCIA 
        try {
            for (FechamentoRegistros pOCORRE_ef : LISTAGEM_OCORR_ef.read()) {
                pOCORRE_ef.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
