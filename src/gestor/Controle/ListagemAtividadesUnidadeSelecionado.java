/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtividadesMensalRealizadaUnidades;
import static gestor.Visao.TelaAtividadesMensalUnidade.jCodigoAtividade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ListagemAtividadesUnidadeSelecionado {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {

        List<AtividadesMensalRealizadaUnidades> listaTodasAtividades = new ArrayList<AtividadesMensalRealizadaUnidades>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ATIVIDADES_UNIDADE "
                    + "INNER JOIN UNIDADE_PENAL_EMPRESA "
                    + "ON ATIVIDADES_UNIDADE.IdUnidEmp=UNIDADE_PENAL_EMPRESA.IdUnidEmp "
                    + "INNER JOIN COLABORADOR "
                    + "ON ATIVIDADES_UNIDADE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTO "
                    + "ON COLABORADOR.IdDepartamento=COLABORADOR.IdDepartamento "
                    + "INNER JOIN ATIVIDADES_UNIDADE_SERVICO_SOCIAL "
                    + "ON ATIVIDADES_UNIDADE.IdAtividade=ATIVIDADES_UNIDADE_SERVICO_SOCIAL.IdAtividade "
                    + "INNER JOIN ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA "
                    + "ON ATIVIDADES_UNIDADE.IdAtividade=ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA.IdAtividade "
                    + "INNER JOIN ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE "
                    + "ON ATIVIDADES_UNIDADE.IdAtividade=ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE.IdAtividade "
                    + "INNER JOIN ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL "
                    + "ON ATIVIDADES_UNIDADE.IdAtividade=ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL.IdAtividade "
                    + "INNER JOIN ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL "
                    + "ON ATIVIDADES_UNIDADE.IdAtividade=ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL.IdAtividdade "
                    + "INNER JOIN ATIVIDADES_UNIDADE_SEGURANCA "
                    + "ON ATIVIDADES_UNIDADE.IdAtividade=ATIVIDADES_UNIDADE_SEGURANCA.IdAtividade "
                    + "INNER JOIN ATIVIDADES_UNIDADE_JURIDICA "
                    + "ON ATIVIDADES_UNIDADE.IdAtividade=ATIVIDADES_UNIDADE_JURIDICA.IdAtividade "
                    + "INNER JOIN ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL "
                    + "ON ATIVIDADES_UNIDADE.IdAtividade=ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL.IdAtividade "
                    + "INNER JOIN ATIVIDADES_UNIDADE_ALIMENTACAO_INTERNO "
                    + "ON ATIVIDADES_UNIDADE.IdAtividade=ATIVIDADES_UNIDADE_ALIMENTACAO_INTERNO.IdAtividade "
                    + "INNER JOIN ATIVIDADES_UNIDADE_VISITA_INTERNO "
                    + "ON ATIVIDADES_UNIDADE.IdAtividade=ATIVIDADES_UNIDADE_VISITA_INTERNO.IdAtividade "
                    + "WHERE ATIVIDADES_UNIDADE.IdAtividade='" + jCodigoAtividade.getText() + "' ");
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pAtividade = new AtividadesMensalRealizadaUnidades();
                //ABA MANUTENÇÃO
                pAtividade.setChave(conecta.rs.getInt("IdAtividade"));
                pAtividade.setDataCriacao(conecta.rs.getDate("DataCadastro"));
                pAtividade.setDataAtualizacao(conecta.rs.getDate("DataAtualizacao"));
                pAtividade.setIdUnidade(conecta.rs.getInt("IdUnidEmp"));
                pAtividade.setUnidadePrisional(conecta.rs.getString("DescricaoUnidade"));
                pAtividade.setMediaPopulacao(conecta.rs.getInt("Populacao"));
                pAtividade.setDataPeriodoInicial(conecta.rs.getDate("DataInicial"));
                pAtividade.setDataPeriodoFinal(conecta.rs.getDate("DataFinal"));
                pAtividade.setMesReferencia(conecta.rs.getString("MesReferencia"));
                pAtividade.setAnoReferencia(conecta.rs.getString("AnoReferencia"));
                pAtividade.setIdFunc(conecta.rs.getInt("IdFunc"));
                pAtividade.setColaboradorResponsavel(conecta.rs.getString("NomeFunc"));
                pAtividade.setMatricula(conecta.rs.getString("MatriculaFunc"));
                pAtividade.setObservacao(conecta.rs.getString("Observacao"));
                //ABA ASSI
                pAtividade.setAtendimentoPsiPreso(conecta.rs.getInt("AtendimentoPsicossocialPreso"));
                pAtividade.setAtendimentoPsiFamilaPreso(conecta.rs.getInt("AtendimentoPsicossocialFamiliaPreso"));
                pAtividade.setNumeroDiasVisitas(conecta.rs.getInt("NroDiasVisita"));
                pAtividade.setNumeroVistantesInternos(conecta.rs.getInt("NroVisitantes"));
                pAtividade.setMediaVisitasDia(conecta.rs.getInt("MediaVisitantesDia"));
                pAtividade.setMediaVisitasInterno(conecta.rs.getInt("MediaVisitantesInterno"));
                pAtividade.setNumeroCriancasVisitas(conecta.rs.getInt("NroCriancasVisitantes"));
                pAtividade.setPresoIdentCivil(conecta.rs.getInt("IdentificadoCivilmente"));
                pAtividade.setPresoAtiviReligiosa(conecta.rs.getInt("Religiosa"));
//                pAtividade.setTotal01(conecta.rs.getInt(""));
                //ABA AFV
                pAtividade.setLanchesVisitantes(conecta.rs.getInt("LanchesVisitantes"));
                pAtividade.setCafeContratada(conecta.rs.getInt("CafeContratada"));
                pAtividade.setAlmocoContratada(conecta.rs.getInt("AlmocoContratada"));
                pAtividade.setJantarContratada(conecta.rs.getInt("JantarContratada"));
                pAtividade.setLancheContratada(conecta.rs.getInt("LancheContratada"));
                pAtividade.setCafeContratante(conecta.rs.getInt("CafeContratante"));
                pAtividade.setAlmocoContratante(conecta.rs.getInt("AlmocoContratante"));
                pAtividade.setJantarContratante(conecta.rs.getInt("JantarContratante"));
                pAtividade.setLancheContratante(conecta.rs.getInt("LancheContratante"));
                pAtividade.setTotal02(conecta.rs.getInt("TotalAlimentacao"));
                //ABA ASI
                pAtividade.setAtendimentoClinico(conecta.rs.getInt("AtendimentoClinico"));
                pAtividade.setAtendimentoPsiquiatrico(conecta.rs.getInt("AtendimentoPsiquiatrico"));
                pAtividade.setAtendimentoEnfermagem(conecta.rs.getInt("AtendimentoEnfermagem"));
                pAtividade.setProcedimentoOdontologico(conecta.rs.getInt("ProcedimentoOdontologico"));
                pAtividade.setAtendimentoPsicologico(conecta.rs.getInt("AtendimentoPsicologico"));
                pAtividade.setTratamentoAgravosPNAISP(conecta.rs.getInt("TratamentoAgravosPNAISP"));
                pAtividade.setSensibilizadoSaudeBucal(conecta.rs.getInt("SensibilizadoSaudeBucal"));
                pAtividade.setSensibilizadoInfectocontagiosas(conecta.rs.getInt("SensibilizadoInfectocontagiosas"));
                pAtividade.setSensibilizadoHipertensao(conecta.rs.getInt("SensibilizadoHipertensao"));
                pAtividade.setSensibilizadoDiabetes(conecta.rs.getInt("SensibilizadoDiabetes"));
                pAtividade.setSensibilizadoSexualidade(conecta.rs.getInt("SensibilizadoSexualidade"));
                pAtividade.setVacinadosPNI(conecta.rs.getInt("VacinadosPNI"));
                pAtividade.setTotalSaude(conecta.rs.getInt("TotalSaude"));
                //AEI
                pAtividade.setMatriculadoEnsinoFormal(conecta.rs.getInt("MatriculadoEnsinoFormal"));
                pAtividade.setFrequentandoEnsinoFormal(conecta.rs.getInt("FrequentandoEnsinoFormal"));
                pAtividade.setMatriculadoCursoProfissionalizante(conecta.rs.getInt("MatriculadoCursoProfissionalizante"));
                pAtividade.setCertificadoCursoProfissionalizante(conecta.rs.getInt("CertificadoCursoProfissionalizante"));
                pAtividade.setTotal03(conecta.rs.getInt("TotalEducacional"));
                //ABA AMI
                pAtividade.setCobertor(conecta.rs.getInt("Cobertor"));
                pAtividade.setColchao(conecta.rs.getInt("Colchao"));
                pAtividade.setLencol(conecta.rs.getInt("Lencol"));
                pAtividade.setToalha(conecta.rs.getInt("Toalha"));
                pAtividade.setPote(conecta.rs.getInt("Pote"));
                pAtividade.setCaneca(conecta.rs.getInt("Caneca"));
                pAtividade.setAparelhoBarbear(conecta.rs.getInt("AparelhoBarbear"));
                pAtividade.setCremeDental(conecta.rs.getInt("CremeDental"));
                pAtividade.setEscova(conecta.rs.getInt("EscovaDente"));
                pAtividade.setAbsorvente(conecta.rs.getInt("Absorvente"));
                pAtividade.setPapelHigienico(conecta.rs.getInt("PapelHigienico"));
                pAtividade.setSabaoPo(conecta.rs.getInt("SabaoPo"));
                pAtividade.setSabonete(conecta.rs.getInt("Sabonete"));
                pAtividade.setDesodorante(conecta.rs.getInt("Desodorante"));
                pAtividade.setBermuda(conecta.rs.getInt("Bermuda"));
                pAtividade.setCamisa(conecta.rs.getInt("CamisaCamiseta"));
                pAtividade.setCueca(conecta.rs.getInt("Cueca"));
                pAtividade.setParChinelos(conecta.rs.getInt("Chinelo"));
                pAtividade.setUniformeCompleto(conecta.rs.getInt("UniformeEsportivo"));
                pAtividade.setTotal05(conecta.rs.getInt("TotalMaterial"));
                //SEG
                pAtividade.setCelularLocalizadoConvivencia(conecta.rs.getInt("CelularLocalizadoConvivencia"));
                pAtividade.setObjetoNaoAutorizadoLocalizadoConvivencia(conecta.rs.getInt("ObjetoNaoAutorizadoLocalizadoConvivencia"));
                pAtividade.setRevistaCela(conecta.rs.getInt("RevistaCela"));
                pAtividade.setTentativaFuga(conecta.rs.getInt("TentativaFuga"));
                pAtividade.setOcorrenciaFuga(conecta.rs.getInt("OcorrenciaFuga"));
                pAtividade.setOcorrenciaRebeliao(conecta.rs.getInt("OcorrenciaRebeliao"));
                pAtividade.setOcorrenciaFerido(conecta.rs.getInt("OcorrenciaFerido"));
                pAtividade.setOcorrenciaIndisciplina(conecta.rs.getInt("OcorrenciaIndisciplina"));
                pAtividade.setOcorrenciaRefem(conecta.rs.getInt("OcorrenciaRefem"));
                pAtividade.setOcorrenciaGravementeFeridoMorto(conecta.rs.getInt("OcorrenciaGravementeFeridoMorto"));
                pAtividade.setHorasInterrupcaoCFTV(conecta.rs.getInt("HorasInterrupcaoCFTV"));
                pAtividade.setDiasInterrupcaoScannerCorporal(conecta.rs.getInt("DiasInterrupcaoScannerCorporal"));
                pAtividade.setDiasInterrupcaoRaioXDetectorMetais(conecta.rs.getInt("DiasInterrupcaoRaioXDetectorMetais"));
                pAtividade.setDiasInterrupcaoVeiculoTransportePreso(conecta.rs.getInt("DiasInterrupcaoVeiculoTransportePreso"));
                pAtividade.setFalhaGeradorEnergia(conecta.rs.getInt("FalhaGeradorEnergia"));
                pAtividade.setHorasMauFuncionamentoBRS(conecta.rs.getInt("HorasMauFuncionamentoBRS"));
                pAtividade.setAbsorventesEntreguesPortariaScanner(conecta.rs.getInt("AbsorventesEntreguesPortariaScanner"));
                pAtividade.setFraldasEntreguesPortariaScanner(conecta.rs.getInt("FraldasEntreguesPortariaScanner"));
                //ABA AJ
                pAtividade.setInternoFamiliaSAJ(conecta.rs.getInt("InternoFamiliaSAJ"));
                pAtividade.setAlvaraSolturaRecebido(conecta.rs.getInt("AlvaraSolturaRecebido"));
                pAtividade.setAlvaraSolturaCumprido(conecta.rs.getInt("AlvaraSolturaCumprido"));
                pAtividade.setLivramentoCondicionalRequerido(conecta.rs.getInt("LivramentoCondicionalRequerido"));
                pAtividade.setAudienciaProvocada(conecta.rs.getInt("AudienciaProvocada"));
                pAtividade.setAudienciaCumprida(conecta.rs.getInt("AudienciaCumprida"));
                pAtividade.setJuriProvocado(conecta.rs.getInt("JuriProvocado"));
                pAtividade.setJuriCumprido(conecta.rs.getInt("JuriCumprido"));
                pAtividade.setLiberdadeProvisoriaRequerida(conecta.rs.getInt("LiberdadeProvisoriaRequerida"));
                pAtividade.setLiberdadeProvisoriaDeferida(conecta.rs.getInt("LiberdadeProvisoriaDeferida"));
                pAtividade.setIndultosRequeridos(conecta.rs.getInt("IndultosRequeridos"));
                pAtividade.setIndultosDeferidos(conecta.rs.getInt("IndultosDeferidos"));
                pAtividade.setRemicaoRequerida(conecta.rs.getInt("RemicaoRequerida"));
                pAtividade.setRemicaoDeferida(conecta.rs.getInt("RemicaoDeferida"));
                pAtividade.setCondicionalRequerida(conecta.rs.getInt("CondicionalRequerida"));
                pAtividade.setCondicionalDeferida(conecta.rs.getInt("CondicionalDeferida"));
                pAtividade.setProgressaoRegimeRequerida(conecta.rs.getInt("ProgressaoRegimeRequerida"));
                pAtividade.setProgressaoRegimeDeferida(conecta.rs.getInt("ProgressaoRegimeDeferida"));
                pAtividade.setSaidasTemporariasRequerida(conecta.rs.getInt("SaidasTemporariasRequerida"));
                pAtividade.setSaidasTemporariasDeferida(conecta.rs.getInt("SaidasTemporariasDeferida"));
                pAtividade.setHabeasCorpusRequerido(conecta.rs.getInt("HabeasCorpusRequerido"));
                pAtividade.setHabeasCorpusDeferido(conecta.rs.getInt("HabeasCorpusDeferido"));
                pAtividade.setLaudosPsicologicos(conecta.rs.getInt("LaudosPsicologicos"));
                pAtividade.setLaudosPsiquiatricos(conecta.rs.getInt("LaudosPsiquiatricos"));
                pAtividade.setTransferenciaProvimento(conecta.rs.getInt("TransferenciaProvimento"));
                pAtividade.setTotal07(conecta.rs.getInt("TotalJuridico"));
                // ABA AL
                pAtividade.setTriagem(conecta.rs.getInt("Triagem"));
                pAtividade.setLaborativaRemunerada(conecta.rs.getInt("LaborativaRemunerada"));
                pAtividade.setLaborativaNaoRemunerada(conecta.rs.getInt("LaborativaNaoRemunerada"));
                pAtividade.setTotal08(conecta.rs.getInt("TotalLaboral"));
                //ABA AL - COMPLEMENTO
                pAtividade.setArtesPlasticas(conecta.rs.getInt("ArtesPlasticas"));
                pAtividade.setLiteratura(conecta.rs.getInt("Literatura"));
                pAtividade.setCantoTeatroCinema(conecta.rs.getInt("CantoTeatroCinema"));
                pAtividade.setEsportes(conecta.rs.getInt("Esportes"));
                pAtividade.setReligiosa(conecta.rs.getInt("Religiosa"));
                pAtividade.setTotal09(conecta.rs.getInt("TotalRecreativaReligiosa"));
                //ABA AFI
                pAtividade.setCafeInterno(conecta.rs.getInt("CafeInterno"));
                pAtividade.setAlmocoInterno(conecta.rs.getInt("AlmocoInterno"));
                pAtividade.setJantarInterno(conecta.rs.getInt("JantarInterno"));
                pAtividade.setTotal09(conecta.rs.getInt("TotalAlimentacaoInterno"));
                listaTodasAtividades.add(pAtividade);
            }
            return listaTodasAtividades;
        } catch (SQLException ex) {
            Logger.getLogger(ListagemAtividadesUnidadeSelecionado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
