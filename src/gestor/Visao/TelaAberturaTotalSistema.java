/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleFechamentoDadosSistema;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ListaAgendaEscoltaCrcA;
import gestor.Controle.ListagemAdmissaoEducacaoFisicaA;
import gestor.Controle.ListagemAdmissaoEducacaoFisicaNovaA;
import gestor.Controle.ListagemAdmissaoEnfermagemA;
import gestor.Controle.ListagemAdmissaoEnfermagemComplementarA;
import gestor.Controle.ListagemAdmissaoJuridicoAdicionaA;
import gestor.Controle.ListagemAdmissaoMedicaA;
import gestor.Controle.ListagemAdmissaoMedicaComplementarA;
import gestor.Controle.ListagemAdmissaoPedagogicaA;
import gestor.Controle.ListagemAdmissaoPedagogicaNovaA;
import gestor.Controle.ListagemAdmissaoPsicologicaA;
import gestor.Controle.ListagemAdmissaoTerapiaA;
import gestor.Controle.ListagemAgendaLaborativaA;
import gestor.Controle.ListagemAprazamentoMedicacaoA;
import gestor.Controle.ListagemAtendimentoFamiliarA;
import gestor.Controle.ListagemAtendimentoFamiliarJuridicoA;
import gestor.Controle.ListagemAtendimentoGrupoEnfermariaA;
import gestor.Controle.ListagemAtendimentoGrupoPedagogiaA;
import gestor.Controle.ListagemAtendimentoGrupoPsiA;
import gestor.Controle.ListagemAtendimentoGrupoSSA;
import gestor.Controle.ListagemAtendimentoGrupoTOA;
import gestor.Controle.ListagemAtendimentoJuridicoA;
import gestor.Controle.ListagemAtendimentoOdontologicoA;
import gestor.Controle.ListagemAtendimentoSocialA;
import gestor.Controle.ListagemAtendimentoTecnicoEnfermagemA;
import gestor.Controle.ListagemAtendimentoTerapiaA;
import gestor.Controle.ListagemAtividadesComplementaresPedaA;
import gestor.Controle.ListagemAtividadesUnidadesA;
import gestor.Controle.ListagemAtualizacaoDocumentosInternosA;
import gestor.Controle.ListagemAvaliacaoMedicaPsiquiatricaA;
import gestor.Controle.ListagemAvaliacaoPsicologicaA;
import gestor.Controle.ListagemCancelamentoNovaEntradadaA;
import gestor.Controle.ListagemCancelamentoVisitasExternaInteraRolA;
import gestor.Controle.ListagemCapacitacaoInternoTOA;
import gestor.Controle.ListagemComposicaoKitHigieneA;
import gestor.Controle.ListagemComprasFARA;
import gestor.Controle.ListagemControleLigacoesA;
import gestor.Controle.ListagemDepositoAtivosA;
import gestor.Controle.ListagemDepositoInativoA;
import gestor.Controle.ListagemEntradaAdvogadoInternosA;
import gestor.Controle.ListagemEntradaAdvogadosA;
import gestor.Controle.ListagemEntradaColaboradoresA;
import gestor.Controle.ListagemEntradaInternosPortariaA;
import gestor.Controle.ListagemEntradaOficialJusticaInternoA;
import gestor.Controle.ListagemEntradaPertencesA;
import gestor.Controle.ListagemEntradaSaidaVisitasReligiosasA;
import gestor.Controle.ListagemEntradaVeiculosUnidadeA;
import gestor.Controle.ListagemEntradaVisitasDiversasA;
import gestor.Controle.ListagemEntradasFamiliarA;
import gestor.Controle.ListagemEntradasOficialJusticaA;
import gestor.Controle.ListagemEstornoFARA;
import gestor.Controle.ListagemEstornoProdutosA;
import gestor.Controle.ListagemEstornoValoresA;
import gestor.Controle.ListagemEvadidosA;
import gestor.Controle.ListagemFichaJuridicaA;
import gestor.Controle.ListagemFrequanciaPedagogicaExternaA;
import gestor.Controle.ListagemFrequenciaCapacitaTOA;
import gestor.Controle.ListagemFrequenciaLaborTOA;
import gestor.Controle.ListagemInventarioFARA;
import gestor.Controle.ListagemLocacaoInternosA;
import gestor.Controle.ListagemMovimentoPopulcaoA;
import gestor.Controle.ListagemNotasFiscaisComprasA;
import gestor.Controle.ListagemOcorrenciaBaseSegurancaA;
import gestor.Controle.ListagemOcorrenciaBaseSegurancaAuxA;
import gestor.Controle.ListagemOcorrenciaEFA;
import gestor.Controle.ListagemOcorrenciaP1EA;
import gestor.Controle.ListagemOcorrenciaPsicologiaA;
import gestor.Controle.ListagemOcorrenciaSegurancaA;
import gestor.Controle.ListagemOcorrenciaServicoSocialA;
import gestor.Controle.ListagemOcorrenciaTOA;
import gestor.Controle.ListagemOcorrenciasEnferemariaA;
import gestor.Controle.ListagemOcorrenciasOdontologicaA;
import gestor.Controle.ListagemOcorrenciasP1A;
import gestor.Controle.ListagemPagamentoKitHigieneA;
import gestor.Controle.ListagemPerfilCarcerarioSSA;
import gestor.Controle.ListagemPernoiteInternosA;
import gestor.Controle.ListagemPortaEntradaPsicologiaA;
import gestor.Controle.ListagemPortaEntradaSSA;
import gestor.Controle.ListagemProgressoaRegimeA;
import gestor.Controle.ListagemProrrogacaoSaidaTemporariaA;
import gestor.Controle.ListagemRegistroCanceladoRetornosA;
import gestor.Controle.ListagemRegistroRetornoA;
import gestor.Controle.ListagemRegistroSaidaCrcA;
import gestor.Controle.ListagemRegistrosCanceladosA;
import gestor.Controle.ListagemRegressaoRegimeA;
import gestor.Controle.ListagemRequiscaoAvulsaProdutosA;
import gestor.Controle.ListagemRequisicaoFARA;
import gestor.Controle.ListagemRequisicaoProdutosInternoA;
import gestor.Controle.ListagemSaqueAtivosA;
import gestor.Controle.ListagemSaqueInativoA;
import gestor.Controle.ListagemSolicitacaoExamesMedicosA;
import gestor.Controle.ListagemSolicitacaoFARA;
import gestor.Controle.ListagemTransferenciaFARA;
import gestor.Controle.ListagemTransientesA;
import gestor.Controle.ListagemTriagemOcupacionalA;
import gestor.Controle.ListagemVeiculosCargasA;
import gestor.Controle.ListagemVeiculosTerceirosA;
import gestor.Controle.ListarEntradasInternosA;
import gestor.Controle.ListarNovaEntrada_InternosA;
import gestor.Controle.ListarPrevisaoSaida_InternosA;
import gestor.Controle.ListarRetornoAudiencia_InternosA;
import gestor.Controle.ListarRetornoEspontaneo_InternosA;
import gestor.Controle.ListarRetornoMedico_InternosA;
import gestor.Controle.ListarRetornoRecaptura_InternosA;
import gestor.Controle.ListarSaidasInternosA;
import gestor.Controle.ListarRetornoSaidasTMP_InternosA;
import gestor.Controle.ListarRetornoTransferencia_InternosA;
import gestor.Controle.ListarTransferenciasInternosA;
import gestor.Controle.ListgagemAtendimentoGrupoEFA;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FechamentoRegistros;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class TelaAberturaTotalSistema extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FechamentoRegistros objFecha = new FechamentoRegistros();
    //LISTAS CRC
    ListarEntradasInternosA objListaEntradas = new ListarEntradasInternosA();
    ListarSaidasInternosA objListaSaidas = new ListarSaidasInternosA();
    ListarTransferenciasInternosA objListaTrans = new ListarTransferenciasInternosA();
    ListarRetornoSaidasTMP_InternosA objListaST = new ListarRetornoSaidasTMP_InternosA();
    ListarRetornoEspontaneo_InternosA objListaRetEsp = new ListarRetornoEspontaneo_InternosA();
    ListarRetornoRecaptura_InternosA objListaRecap = new ListarRetornoRecaptura_InternosA();
    ListarRetornoAudiencia_InternosA objListaRetAudi = new ListarRetornoAudiencia_InternosA();
    ListarRetornoMedico_InternosA objListaRetMed = new ListarRetornoMedico_InternosA();
    ListarRetornoTransferencia_InternosA objListaRet_TRAN = new ListarRetornoTransferencia_InternosA();
    ListarPrevisaoSaida_InternosA objListaPrevSaida = new ListarPrevisaoSaida_InternosA();
    ListaAgendaEscoltaCrcA objAgendaEscolta = new ListaAgendaEscoltaCrcA();
    ListagemEvadidosA objEvadidos = new ListagemEvadidosA();
    ListagemProgressoaRegimeA objProgressaoRegime = new ListagemProgressoaRegimeA();
    ListagemProrrogacaoSaidaTemporariaA objProrroga = new ListagemProrrogacaoSaidaTemporariaA();
    ListagemCancelamentoNovaEntradadaA objListagemRegCanceladoNE = new ListagemCancelamentoNovaEntradadaA();
    ListagemRegistroCanceladoRetornosA objRegistroCanceladoRetorno = new ListagemRegistroCanceladoRetornosA();
    ListagemRegistrosCanceladosA objRegCancelados = new ListagemRegistrosCanceladosA();
    ListagemRegressaoRegimeA objListaRegressao = new ListagemRegressaoRegimeA();
    //PORTARIA INTERNA
    ListagemEntradaSaidaVisitasReligiosasA LISTAGEM_VISITAS_religiosas = new ListagemEntradaSaidaVisitasReligiosasA();
    ListagemEntradaInternosPortariaA LISTAGEM_ENTRADA_internos = new ListagemEntradaInternosPortariaA();
    ListarNovaEntrada_InternosA LISTAGEM_NOVA_entrada = new ListarNovaEntrada_InternosA();
    ListagemEntradaPertencesA LISTAGEM_pertences = new ListagemEntradaPertencesA();
    ListagemEntradaOficialJusticaInternoA LISTAGEM_OFICIAL_justica = new ListagemEntradaOficialJusticaInternoA();
    ListagemEntradaAdvogadoInternosA LISTAGEM_ADV_internos = new ListagemEntradaAdvogadoInternosA();
    ListagemEntradasFamiliarA LISTAGEM_ENT_familiar = new ListagemEntradasFamiliarA();
    ListagemOcorrenciasP1A LISTAGEM_OCORRENCIA_p1 = new ListagemOcorrenciasP1A();
    ListagemPernoiteInternosA LISTAGEM_pernoite = new ListagemPernoiteInternosA();
    ListagemRegistroRetornoA LISTAGEM_retorno = new ListagemRegistroRetornoA();
    ListagemRegistroSaidaCrcA LISTAGEM_saida = new ListagemRegistroSaidaCrcA();
    ListagemTransientesA LISTAGEM_transientes = new ListagemTransientesA();
    //PORTARIA EXTERNA
    ListagemEntradasOficialJusticaA LISTAGEM_oficial = new ListagemEntradasOficialJusticaA();
    ListagemEntradaAdvogadosA LISTAGEM_advogado = new ListagemEntradaAdvogadosA();
    ListagemEntradaColaboradoresA LISTAGEM__colaborador = new ListagemEntradaColaboradoresA();
    ListagemEntradaVisitasDiversasA LISTAGEM_VISITAS_diversas = new ListagemEntradaVisitasDiversasA();
    ListagemVeiculosCargasA LISTAGEM_VEICULOS_carga = new ListagemVeiculosCargasA();
    ListagemVeiculosTerceirosA LISTAGEM_VEICULOS_terceiros = new ListagemVeiculosTerceirosA();
    ListagemEntradaVeiculosUnidadeA LISTAGEM_VEICULOS_unidade = new ListagemEntradaVeiculosUnidadeA();
    ListagemOcorrenciaP1EA LISTAGEM_OCR_p1e = new ListagemOcorrenciaP1EA();
    //ALMOXARIFADO
    ListagemComposicaoKitHigieneA LISTAGEM_compoKit = new ListagemComposicaoKitHigieneA();
    ListagemEstornoProdutosA LISTAGEM_estorno = new ListagemEstornoProdutosA();
    ListagemNotasFiscaisComprasA LISTAGEM_nf = new ListagemNotasFiscaisComprasA();
    ListagemRequiscaoAvulsaProdutosA LISTAGEM_REQUISISCAO_avulsa = new ListagemRequiscaoAvulsaProdutosA();
    ListagemRequisicaoProdutosInternoA LISTAGEM_REQUISICAO_interno = new ListagemRequisicaoProdutosInternoA();
    ListagemPagamentoKitHigieneA LISTAGEM_pagoKit = new ListagemPagamentoKitHigieneA();
    //BASES
    ListagemLocacaoInternosA LISTAGEM_locacao = new ListagemLocacaoInternosA();
    ListagemOcorrenciaBaseSegurancaA LISTAGEM_OCR_seg = new ListagemOcorrenciaBaseSegurancaA();
    ListagemOcorrenciaBaseSegurancaAuxA LISTAGEM_OCR_sega = new ListagemOcorrenciaBaseSegurancaAuxA();
    // ENFERMAGEM
    ListagemAdmissaoEnfermagemA LISTAGEM_ADM_enfermagem = new ListagemAdmissaoEnfermagemA();
    ListagemAdmissaoEnfermagemComplementarA LISTAGEM_ADM_enfermagemAux = new ListagemAdmissaoEnfermagemComplementarA();
    ListagemAdmissaoMedicaA LISTAGEM_ADM_medico = new ListagemAdmissaoMedicaA();
    ListagemAdmissaoMedicaComplementarA LISTAGEM_ADM_medicoAux = new ListagemAdmissaoMedicaComplementarA();
    ListagemAprazamentoMedicacaoA LISTAGEM_aprazamento = new ListagemAprazamentoMedicacaoA();
    ListagemAtendimentoGrupoEnfermariaA LISTAGEM_atentimentoGRU = new ListagemAtendimentoGrupoEnfermariaA();
    ListagemAtendimentoTecnicoEnfermagemA LISTAGEM_atentimentoTECE = new ListagemAtendimentoTecnicoEnfermagemA();
    ListagemAvaliacaoMedicaPsiquiatricaA LISTAGEM_avalicaoMedPsi = new ListagemAvaliacaoMedicaPsiquiatricaA();
    ListagemOcorrenciasEnferemariaA LISTAGEM_ocr = new ListagemOcorrenciasEnferemariaA();
    ListagemSolicitacaoExamesMedicosA LISTAGEM_exames = new ListagemSolicitacaoExamesMedicosA();
    //GERENCIA ADMINISTRATIVA
    ListagemAtividadesUnidadesA LISTAGEM_atividade = new ListagemAtividadesUnidadesA();
    //JURIDICO
    ListagemAtendimentoJuridicoA LISTAGEM_atendeJuri = new ListagemAtendimentoJuridicoA();
    ListagemAdmissaoJuridicoAdicionaA LISTAGEM_admJuri = new ListagemAdmissaoJuridicoAdicionaA();
    ListagemAtendimentoFamiliarJuridicoA LISTAGEM_atendFamJur = new ListagemAtendimentoFamiliarJuridicoA();
    ListagemFichaJuridicaA LISTAGEM_fichaJU = new ListagemFichaJuridicaA();
    //ODONTOLOGIA
    ListagemAtendimentoOdontologicoA LISTAGEM_odonto = new ListagemAtendimentoOdontologicoA();
    ListagemOcorrenciasOdontologicaA LISTAGEM_OCOR_ODONTO = new ListagemOcorrenciasOdontologicaA();
    //PEDAGOGIA
    ListagemAdmissaoPedagogicaA LISTAGEM_ADM_peda = new ListagemAdmissaoPedagogicaA();
    ListagemAdmissaoPedagogicaNovaA LISTAGEM_ADM_pedaNova = new ListagemAdmissaoPedagogicaNovaA();
    ListagemAtendimentoGrupoPedagogiaA LISTAGEM_ATEND_grupoP = new ListagemAtendimentoGrupoPedagogiaA();
    ListagemAtividadesComplementaresPedaA LISTAGEM_atividadeC = new ListagemAtividadesComplementaresPedaA();
    ListagemFrequanciaPedagogicaExternaA LISTAGEM_frequencia = new ListagemFrequanciaPedagogicaExternaA();
    //PSICOLOGIA
    ListagemAdmissaoPsicologicaA LISTAGEM_adm_psi = new ListagemAdmissaoPsicologicaA();
    ListagemAtendimentoGrupoPsiA LISTAGEM_atd_psi = new ListagemAtendimentoGrupoPsiA();
    ListagemAvaliacaoPsicologicaA LISTAGEM_avalia = new ListagemAvaliacaoPsicologicaA();
    ListagemOcorrenciaPsicologiaA LISTAGEM_OCOR_psi = new ListagemOcorrenciaPsicologiaA();
    ListagemPortaEntradaPsicologiaA LISTAGEM_porta = new ListagemPortaEntradaPsicologiaA();
    //SEGURANÇA
    ListagemMovimentoPopulcaoA LISTAGEM_populcao = new ListagemMovimentoPopulcaoA();
    ListagemOcorrenciaSegurancaA LISTAGEM_OCORR_seg = new ListagemOcorrenciaSegurancaA();
    //SERVIÇO SOCIAL
    ListagemAtendimentoGrupoSSA LISTAGEM_ATEND_grupoSS = new ListagemAtendimentoGrupoSSA();
    ListagemAtendimentoFamiliarA LISTAGEM_ATEND_famSS = new ListagemAtendimentoFamiliarA();
    ListagemAtendimentoSocialA LISTAGEM_ATEND_social = new ListagemAtendimentoSocialA();
    ListagemAtualizacaoDocumentosInternosA LISTAGEM_atualizacao = new ListagemAtualizacaoDocumentosInternosA();
    ListagemCancelamentoVisitasExternaInteraRolA LISTAGEM_cancelaVisista = new ListagemCancelamentoVisitasExternaInteraRolA();
    ListagemControleLigacoesA LISTAGEM_CONTROLE_ligacoes = new ListagemControleLigacoesA();
    ListagemOcorrenciaServicoSocialA LISTAGEM_ocorrencia_ss = new ListagemOcorrenciaServicoSocialA();
    ListagemPerfilCarcerarioSSA LISTAGEM_perfil = new ListagemPerfilCarcerarioSSA();
    ListagemPortaEntradaSSA LISTAGEM_portaEE = new ListagemPortaEntradaSSA();
    //TERAPIA OCUPACIONAL
    ListagemAdmissaoTerapiaA LISTAGEM_terapia = new ListagemAdmissaoTerapiaA();
    ListagemAgendaLaborativaA LISTAGEM_agenda = new ListagemAgendaLaborativaA();
    ListagemAtendimentoGrupoTOA LISTAGEM_atendeGR = new ListagemAtendimentoGrupoTOA();
    ListagemAtendimentoTerapiaA LISTAGEM_atendimentoTO = new ListagemAtendimentoTerapiaA();
    ListagemCapacitacaoInternoTOA LISTAGEM_capacitacaoTO = new ListagemCapacitacaoInternoTOA();
    ListagemFrequenciaCapacitaTOA LISTAGEM_freqCapaTo = new ListagemFrequenciaCapacitaTOA();
    ListagemFrequenciaLaborTOA LISTAGEM_freqLabor = new ListagemFrequenciaLaborTOA();
    ListagemOcorrenciaTOA LISTAGEM_OCORR_to = new ListagemOcorrenciaTOA();
    ListagemTriagemOcupacionalA LISTAGEM_triagemTO = new ListagemTriagemOcupacionalA();
    //FINANCEIRO
    ListagemDepositoAtivosA LISTAGEM_deposito_At = new ListagemDepositoAtivosA();
    ListagemSaqueAtivosA LISTAGEM_saque_At = new ListagemSaqueAtivosA();
    ListagemDepositoInativoA LISTAGEM_deposito_Inat = new ListagemDepositoInativoA();
    ListagemSaqueInativoA LISTAGEM_saque_Inat = new ListagemSaqueInativoA();
    ListagemEstornoValoresA LISTAGEM_estorno_va = new ListagemEstornoValoresA();
    //EDUCAÇÃO FISICA
    ListagemAdmissaoEducacaoFisicaA LISTAGEM_ADM_ef = new ListagemAdmissaoEducacaoFisicaA();
    ListagemAdmissaoEducacaoFisicaNovaA LISTAGEM_EF_nova = new ListagemAdmissaoEducacaoFisicaNovaA();
    ListgagemAtendimentoGrupoEFA LISTAGEM_ATEND_GRUPO_ef = new ListgagemAtendimentoGrupoEFA();
    ListagemOcorrenciaEFA LISTAGEM_OCORR_ef = new ListagemOcorrenciaEFA();
    //FARMÁCIA
    ListagemComprasFARA LISTAGEM_compras_far = new ListagemComprasFARA();
    ListagemInventarioFARA LISTAGEM_inventario_far = new ListagemInventarioFARA();
    ListagemTransferenciaFARA LISTAGEM_transferencia_far = new ListagemTransferenciaFARA();
    ListagemRequisicaoFARA LISTAGEM_requisicao_far = new ListagemRequisicaoFARA();
    ListagemEstornoFARA LISTAGEM_estorno_far = new ListagemEstornoFARA();
    ListagemSolicitacaoFARA LISTAGEM_solicitacao_far = new ListagemSolicitacaoFARA();
    //
    ControleFechamentoDadosSistema control = new ControleFechamentoDadosSistema();
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
    //CRC
    int pTOTAL_GERAL_REGISTROS = 0;
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
    //FINANCEIRO
    public static int pDEPOSITO_ativo = 0;
    public static int pSAQUE_ativo = 0;
    public static int pDEPOSITO_inativo = 0;
    public static int pSAQUE_inativo = 0;
    public static int pESTORNO_valores = 0;
    //EDUCAÇÃO FISICA
    public static int pADMISSAO_ef = 0;
    public static int pADMISSAO_EF_nova = 0;
    public static int pATEND_GRUPO_ef = 0;
    public static int pOCORRE_ef = 0;
    //FARMÁCIA
    public static int pCOMPRAS_far = 0;
    public static int pINVENTARIO_far = 0;
    public static int pTRANSFERENCIAS_far = 0;
    public static int pREQUISICAO_far = 0;
    public static int pESTORNO_far = 0;
    public static int pSOLICITACAO_far = 0;

    /**
     * Creates new form TelaFechamentoSistema
     */
    public static TelaModuloConfiguracoes pCONFIGURACAO;

    public TelaAberturaTotalSistema(TelaModuloConfiguracoes parent, boolean modal) {
        this.pCONFIGURACAO = parent;
        this.setModal(modal);
        setLocationRelativeTo(pCONFIGURACAO);
        initComponents();
        jProgressBar1.setVisible(true);
        jDataFechamento.setCalendar(Calendar.getInstance());
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
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        lblProgresso = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTOTAL_REGISTROS = new javax.swing.JTextField();
        jREGISTROS_PROCESSADOS = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jDataFechamento = new com.toedter.calendar.JDateChooser();
        jBtPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Abertura do Sistema :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtConfirmar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtConfirmar.setForeground(new java.awt.Color(0, 153, 0));
        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        jBtSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSair.setForeground(new java.awt.Color(204, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jBtConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("ATENÇÃO:  Antes  de realizar esse procedimento,  é necessário  que  todos os  usuários");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText(" saiam do sistema. Todos os registros que estiverem com status \"FINALIZADO\", serão ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("ABERTO, e  poderão ser modificados ou excluídos.");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("O sistema será bloqueado e somente liberado após o termino dessa operação.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jProgressBar1.setStringPainted(true);

        lblProgresso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblProgresso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProgresso.setText("Aguardando...");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Total Registros:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Registros Processados:");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTOTAL_REGISTROS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jREGISTROS_PROCESSADOS, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblProgresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jREGISTROS_PROCESSADOS, jTOTAL_REGISTROS});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProgresso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jTOTAL_REGISTROS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jREGISTROS_PROCESSADOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Data de Abertura:");

        jDataFechamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesquisar.setForeground(new java.awt.Color(0, 0, 204));
        jBtPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisar.setText("Pesquisar");
        jBtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(jDataFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        if (jDataFechamento.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data de fechamento dos registros do sistema.");
        } else if (jTOTAL_REGISTROS.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "O total de registro está vazio, pesquise os registros a serem finalizados.");
        } else if (jTOTAL_REGISTROS.getText() == null) {
            JOptionPane.showMessageDialog(rootPane, "O total de registro está vazio, pesquise os registros a serem finalizados.");
        } else if (jTOTAL_REGISTROS.getText().equals("0")) {
            JOptionPane.showMessageDialog(rootPane, "O total de registro está vazio, pesquise os registros a serem finalizados.");
        } else {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar todos os registros do sistema?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //Impedir que a janela seja fechada pelo X 
                //BLOQUEAR SISTEMA PARA OS USUARIOS NÃO ACESSAR
                pSISTEMA_BLOQUEADO = "Sim";
                objFecha.setOpcaoBloquear(pSISTEMA_BLOQUEADO);
                control.bloquearSistema(objFecha);
                jProgressBar1.setVisible(true);
                jDataFechamento.setEnabled(!true);
                jBtPesquisar.setEnabled(!true);
                jBtSair.setEnabled(!true);
                jBtConfirmar.setEnabled(!true);
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                statusMov = "Finalizou";
                gravarDadosBanco();
            }
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarActionPerformed
        // TODO add your handling code here:
        //CRC
        calculoTotais_ENTRADAS_CRC();
        //PORTARIAS
        calcularTotais_PORTARIA_INTERNA();
        //ALMOXARIFADO
        calcularTotais_ALMOXARIFADO();
        //BASE DO PAVILHÃO
        calcularTotais_BASE_PAVILHAO();
        //ENFERMAGEM
        calcularTotais_ENFERMARIA();
        //GERENCIA ADMINISTRATIVA
        calcularTotais_ADMINISTRACAO();
        //JURIDICO
        calcularTotais_JURIDICO();
        //ODONTOLOGIA 
        calcularTotais_ODONTOLOGICO();
        //ATENDIMENTO
        //PEDAGOGIA
        calcularTotais_PEDAGOGIA();
        //PSICOLOGIA
        calcularTotais_PSICOLOGIA();
        //SEGURANÇA
        calcularTotais_SEGURANCA();
        //SERVIÇO SOCIAL
        calcularTotais_SERVICO_SOCIAL();
        //TERAPIA OCUPACIONAL
        calculosTotaisTO();
        //FINANCEIRO
        calcularTotais_FINANCEIRO();
        //EDUCAÇÃO FÍSICA
        calcularTotais_EDUCACAO_FISICA();
        //FARMÁCIA
        calcularTotais_FARMACIA();
        total_REGISTROS();
        jTOTAL_REGISTROS.setText(Integer.toString(pTOTAL_GERAL_REGISTROS));
    }//GEN-LAST:event_jBtPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAberturaTotalSistema dialog = new TelaAberturaTotalSistema(pCONFIGURACAO, true);
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
    private javax.swing.JButton jBtPesquisar;
    private javax.swing.JButton jBtSair;
    public static com.toedter.calendar.JDateChooser jDataFechamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jREGISTROS_PROCESSADOS;
    private javax.swing.JTextField jTOTAL_REGISTROS;
    private javax.swing.JLabel lblProgresso;
    // End of variables declaration//GEN-END:variables

    public void total_REGISTROS() {
        pTOTAL_GERAL_REGISTROS = pTOTAL_ENTRADAS
                + pTOTAL_SAIDAS + pTOTAL_TRANSFERENCIAS
                + pRETORNO_SAIDAS_TMP + pRETORNO_ESPONTANEO
                + pRETORNO_RECAPTURA + pRETORNO_AUDIENCIAS
                + pRETORNO_MEDICO + pRETORNO_TRANSFERENCIA
                + pPREVISAO_SAIDA + pNOVA_ENTRADA
                + pAGENDA_ESCOLTA + pINTERNOS_EVADIDOS
                + pPROGRESSAO_REGIME + pPRORROGA
                + pREGISTRO_CANCELADO_NE + pREGISTRO_CANCELADO_RETORNOS
                + pREGISTRO_CANCELADOS + pREGRESSAO_REGIME
                + pTOTAL_ENTRADAS_SAIDAS_VISITAS_religiosas
                + pENTRADAS_INTERNOS_portaria + pENTRADA_PERTENCES
                + pENTRADA_OFJI + pENTRADA_ADV_INTERNOS + pENTRADA_ADV_INTERNOS
                + pENTRADA_FAMILIAR + pOCORRENCIAS_P1 + pPERNOITE + pRETORNO
                + pSAIDAS_CRC + pTRANSIENTES + pENTRADA_oficial + pENTRADA_advogado
                + pENTRADA_colaborador + pENTRADA_VISITAS_diversas + pENTRADA_VEICULOS_carga
                + pENTRADA_VEICULOS_terceiros + pENTRADA_VEICULOS_unidade + pOCORRENCIAS_p1e
                + pCOMPOSICAO + pESTORNO + pNFC + pREQUISICAO_avulsa + pREQUISICAO_interno
                + pOCR_seg + pOCR_sega + pADM_enfermagem + pADM_enfermagemAux + pADM_medica
                + pADM_medicaAux + pAPRAZAMENTO + pATENDIMENTO_GRUPO_ENF + pATENDIMENTO_TEC_ENFERMAGEM
                + pAVALIACAO_MED_PSI + pOCORRENCIA_ENF + pSOLICITACAO + pATIVIDADE_UNIDADE + pATENDE_JURI
                + pADMISSAO_JURI + pATEND_FAMILIA_juri + pFICHA_juridica + pATEND_ODONTO
                + pOCR_ODONTO + pADMISSAO_pedagogica + pADMISSAO_pedagogicaNova + pATEND_GRUPO_pedagogia
                + pATIVIDADES_COMPLEMENTARES + pFREQUENCIA_pedagogica + pADMISSAO_psicologica
                + pATENDIMENTO_GRUPO_psi + pAVALIACAO_psicologica + pOCORRENCIA_psiologica + pPORTA_entrada
                + pMOVIMENTO_populcao + pOCORRE_seguranca + pATEND_GRUPO_ss + pATEND_FAM_ss + pATEND_social
                + pATUALIZA_documento + pCANCELA_visitas + pCONTROLE_ligacoes + pOCORRENCIAS_servico
                + pPERFIL_carcerario + pPORTA_ENTRADA_ss + pADM_terapia + pAGENDA_laborativa
                + pATENDIMENTO_grupoTO + pATENDIMENTO_TO + pCAPACITACAO_INTERO_to + pFREQUENCIA_capa
                + pFREQUENCIA_labora + pOCORRE_to + pTRIAGEM_to + pADMISSAO_ef + pADMISSAO_EF_nova
                + pATEND_GRUPO_ef + pOCORRE_ef + pDEPOSITO_ativo + pSAQUE_ativo + pDEPOSITO_inativo
                + pSAQUE_inativo + pESTORNO_valores + pCOMPRAS_far + pINVENTARIO_far + pTRANSFERENCIAS_far
                + pREQUISICAO_far + pESTORNO_far + pSOLICITACAO_far;
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
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
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

    //FINANCEIRO
    public void calcularTotais_FINANCEIRO() {
        //DEPOSITO
        try {
            for (FechamentoRegistros pDEPOSITO_av : LISTAGEM_deposito_At.read()) {
                pDEPOSITO_av.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //SAQUE 
        try {
            for (FechamentoRegistros pSAQUE_av : LISTAGEM_saque_At.read()) {
                pSAQUE_av.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //DEPOSITO INATIVO
        try {
            for (FechamentoRegistros pDEPOSITO_inav : LISTAGEM_deposito_Inat.read()) {
                pDEPOSITO_inav.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //SAQUE INATIVO
        try {
            for (FechamentoRegistros pSAQUE_inav : LISTAGEM_saque_Inat.read()) {
                pSAQUE_inav.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ESTORNO DE VALORES
        try {
            for (FechamentoRegistros pESTORNO_va : LISTAGEM_estorno_va.read()) {
                pESTORNO_va.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //EDUCAÇÃO FÍSICA
    public void calcularTotais_EDUCACAO_FISICA() {
        //ADMISSÃO FISICA 
        try {
            for (FechamentoRegistros pADM_ef : LISTAGEM_ADM_ef.read()) {
                pADM_ef.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ADMISSAO FISICA NOVA 
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

    //FARMÁCIA 
    public void calcularTotais_FARMACIA() {
        //COMPRAS
        try {
            for (FechamentoRegistros pCOMPRAS_far : LISTAGEM_compras_far.read()) {
                pCOMPRAS_far.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //INVENTÁRIO 
        try {
            for (FechamentoRegistros pINVENTARIO_far : LISTAGEM_inventario_far.read()) {
                pINVENTARIO_far.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //TRANSFERÊNCIAS
        try {
            for (FechamentoRegistros pTRANS_far : LISTAGEM_transferencia_far.read()) {
                pTRANS_far.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //REQUISIÇÃO
        try {
            for (FechamentoRegistros pREQUISICAO_far : LISTAGEM_requisicao_far.read()) {
                pREQUISICAO_far.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ESTORNO
        try {
            for (FechamentoRegistros pESTORNO_far : LISTAGEM_estorno_far.read()) {
                pESTORNO_far.getStatusRegistro();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAberturaTotalSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        //SOLICITAÇÃO DE COMPRAS 
        try {
            for (FechamentoRegistros pSOLICITA_far : LISTAGEM_solicitacao_far.read()) {
                pSOLICITA_far.getStatusRegistro();
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

    public void gravarDadosBanco() {
        try {
            Thread t0 = new Thread() {
                public void run() {
                    statusMov = "Incluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    if (tipoServidor == null || tipoServidor.equals("")) {
                        JOptionPane.showMessageDialog(null, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
                    } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        pDATA_FECHAMENTO = formatoAmerica.format(jDataFechamento.getDate().getTime());
                    } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        pDATA_FECHAMENTO = formatoAmerica.format(jDataFechamento.getDate().getTime());
                    }
                    for (int i = 0; i < pTOTAL_GERAL_REGISTROS; i++) {//  
                        lblProgresso.setText("Processando Registros, Aguarde...");
                        //MÓDULO CRC
                        objFecha.setStatusRegistro(pFECHAMENTO);
                        objFecha.setDataFechamento(pDATA_FECHAMENTO);
                        objFecha.setHoraFechamento(horaMov);
                        objFecha.setUsuarioUp(nameUser);
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
                        //MÓDULO PORTARIA INTERNA
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
                        //PORTARIA EXTERNA
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
                        //ALMOXARIFADO
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
                        //SEGURANÇA
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
                        //ENFERMAGEM                        
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
                        //GERENCIA ADMINISTRATIVA
                        //ATIVIDADES MENSAL REALIZADAS NA UNIDADE
                        control.fecharATIVI_realizadas(objFecha);
                        //JURIDICO
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
                        //ODONTOLOGIA
                        //ATENDIMENTO ODONTOLOGICO
                        control.fecharATEND_odonto(objFecha);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                        //OCORRÊNCIAS
                        control.fecharOCORRE_odonto(objFecha);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                        //PEDAGOGIA
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
                        //PSICOLOGIA
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
                        //SEGURANÇA
                        //MOVIMENTO POPULAÇÃO
                        control.fecharMOVPOP_seg(objFecha);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                        //OCORRÊNCIAS SEGURANÇA
                        control.fecharOCORR_seg(objFecha);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                        //SERVIÇO SOCIAL
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
                        //TERAPIA OCUPACIONAL
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
                        //FINANCEIRO
                        //DEPOSITO
                        control.fecharDEPOSITO_at(objFecha);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                        //SAQUE
                        control.fecharSAQUE_at(objFecha);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                        //ESTORNO
                        control.fecharESTORNO_valores(objFecha);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                        //DEPOSITO INATIVO
                        control.fecharDEPOSITO_inat(objFecha);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                        //SAQUE INATIVO
                        control.fecharSAQUE_inat(objFecha);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                        //EDUICAÇÃO FÍSICA                        
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
                        //FARMÁCIA
                        //COMPRAS PRODUTOS
                        control.fecharCOMPRAS_far(objFecha);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        //INVENTÁRIO
                        control.fecharINVENTARIO_far(objFecha);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        //TRANSFERÊNCIAS
                        control.fecharTRANSFERENCIAS_far(objFecha);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        //REQUISIÇÃO AVULSA
                        control.fecharREQUISICAO_far(objFecha);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        //ESTORNO TRANSFERÊNCIAS/REQUISIÇÕES
                        control.fecharESTORNO_far(objFecha);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        //SOLICITAÇÃO DE COMPRAS
                        control.fecharSOLICITACAO_far(objFecha);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        //
                        jProgressBar1.setValue(i);
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                    }
                }
            };
            t0.start();
        } catch (Exception e) {
        }
        // THREAD DA BARRA DE EXECUÇÃO
        try {
            Thread t = new Thread() {
                public void run() {
                    jProgressBar1.setMaximum(pTOTAL_GERAL_REGISTROS);
                    for (int i = 0; i < pTOTAL_GERAL_REGISTROS; i++) {
                        if (i == 0) {
                            jProgressBar1.setValue((i + 1));
                        } else if (i > 0) {
                            jProgressBar1.setValue((i + 1));
                            pREGISTROS_PROCESSADOS = i + 1;
                            jREGISTROS_PROCESSADOS.setText(Integer.toString(pREGISTROS_PROCESSADOS));
                            jProgressBar1.setValue(i);
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                        }
                    }
                    if (pTOTAL_GERAL_REGISTROS == pREGISTROS_PROCESSADOS) {
                        jProgressBar1.setValue(100);
                        JOptionPane.showMessageDialog(rootPane, "Operação Concluída com sucesso...");
                        //DESBLOQUEAR SISTEMA PARA ACESSO.
                        pSISTEMA_DESBLOQUEADO = "Não";
                        objFecha.setOpcaoBloquear(pSISTEMA_DESBLOQUEADO);
                        control.bloquearSistema(objFecha);
                        jDataFechamento.setEnabled(true);
                        jBtPesquisar.setEnabled(true);
                        jBtSair.setEnabled(true);
                        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Impedir que a janela seja fechada pelo X 
                        dispose();
                    }
                    try {
                    } catch (Exception e) {
                    }
                }
            };
            t.start();
        } catch (Exception e) {
        }
    }
}
