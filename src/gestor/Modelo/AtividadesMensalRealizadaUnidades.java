/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronal
 */
public class AtividadesMensalRealizadaUnidades {

    //MANUTENÇÃO
    private Integer chave;
    private String status;
    private Date dataCriacao;
    private Date dataAtualizacao;
    private String mes;
    private Integer ano;
    private Integer idUnidade;
    private String unidadePrisional;
    private Integer mediaPopulacao;
    private Integer quantidadeTotalPopulacao;
    private Date dataPeriodoInicial;
    private Date dataPeriodoFinal;
    private String mesReferencia;
    private String anoReferencia;
    private Integer idFunc;
    private String colaboradorResponsavel;
    private String matricula;
    private String departamento;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    //ABA ASSI
    private Integer idAtividadeVisita;
    private Integer atendimentoPsiPreso;
    private Integer atendimentoPsiFamilaPreso;
    private Date dataAtendimento;
    private Date dataEntradaVisita;
    private Date dataSaidaVisita;
    private String tipoAtendimento;
    private Integer numeroVistantesInternos;
    private Integer numeroDiasVisitas;
    private Integer mediaVisitasDia;
    private Integer mediaVisitasInterno;
    private Integer numeroCriancasVisitas;
    private Integer presoIdentCivil;
    private Integer presoAtiviReligiosa;
    //AFV
    private Integer idAtividadeAlimentacao;
    private Integer lanchesVisitantes;
    private Integer cafeContratada;
    private Integer almocoContratada;
    private Integer jantarContratada;
    private Integer lancheContratada;
    private Integer cafeContratante;
    private Integer almocoContratante;
    private Integer jantarContratante;
    private Integer lancheContratante;
    private Integer totalAlimentacao;
    //ASI
    private Integer idAtividadeAtendimentoSaude;
    private Integer atendimentoClinico;
    private Integer atendimentoPsiquiatrico;
    private Integer atendimentoEnfermagem;
    private Integer atendimentoOdontologico;
    private Integer procedimentoOdontologico;
    private Integer atendimentoPsicologico;
    private Integer saudeBucal;
    private Date dataAgravo;
    private Integer vdrl;
    private Integer hepatiteB;
    private Integer hepatiteC;
    private Integer hiv;
    private Integer sifilis;
    private Integer hpv;
    private Integer diabetes;
    private Integer hipertensao;
    private Integer tuberculose;
    private Integer hanseniase;
    private Integer escabiose;
    private Integer dst;
    private Integer quantidadeAgravosTotal;
    private Integer quantidadeAdmInfectoTotal;
    private Integer quantidadeEvoInfectoTotal;
    private Integer sexualidade;
    private Integer vacinados;
    private Integer totalSaude;
    //AEI
    private Date dataMatricula;
    private Date dataFrequencia;
    private Integer idAtividadeAtendimentoEducacional;
    private Integer matriculadoEnsinoFormal;
    private Integer frequentandoEnsinoFormal;
    private Integer matriculadoCursoProfissionalizante;
    private Integer certificadoCursoProfissionalizante;
    private Integer totalEducacional;
    //AMI
    private Integer aparelhoBarbear;
    private Integer absorvente;
    private Integer bermuda;
    private Integer caneca;
    private Integer camisa;
    private Integer cobertor;
    private Integer colchao;
    private Integer colher;
    private Integer cueca;
    private Integer cremeDental;
    private Integer desodorante;
    private Integer escova;
    private Integer lencol;
    private Integer papelHigienico;
    private Integer parChinelos;
    private Integer pote;
    private Integer sabaoPo;
    private Integer sabonete;
    private Integer toalha;
    private Integer uniformeCompleto;
    private Integer idAtividadeMaterial;
    private Integer totalMaterial;
    //SEG
    private Date DataProcedimento;
    private Integer quantidadeCelular;
    private Integer quantidadeObjetos;
    private Integer quantidadeProcedCelas;
    private Integer idAtividadeSeguranca;
    private Integer pessoasRefem;
    private Integer ocorrenciaFuga;
    private Integer ocorrenciaRebeliao;
    private Integer ocorrenciaFerido;
    private Integer ocorrenciaIndisciplina;
    private Integer ocorrenciaGravementeFeridoMorto;
    private Integer horasInterrupcaoCFTV;
    private Integer diasInterrupcaoScannerCorporal;
    private Integer diasInterrupcaoRaioXDetectorMetais;
    private Integer diasInterrupcaoVeiculoTransportePreso;
    private Integer falhaGeradorEnergia;
    private Integer horasMauFuncionamentoBRS;
    private Integer absorventesEntreguesPortariaScanner;
    private Integer fraldasEntreguesPortariaScanner;
    private Integer totalMaterialSeg;
    //AJ
    private Integer idAtividadeJuridica;
    private Integer internoFamiliaSAJ;
    private Integer alvaraSolturaRecebido;
    private Integer alvaraSolturaCumprido;
    private Integer audienciaProvocada;
    private Integer audienciaCumprida;
    private Integer juriProvocado;
    private Integer juriCumprido;
    private Integer liberdadeProvisoriaRequerida;
    private Integer liberdadeProvisoriaDeferida;
    private Integer indultosRequeridos;
    private Integer indultosDeferidos;
    private Integer remicaoRequerida;
    private Integer remicaoDeferida;
    private Integer condicionalRequerida;
    private Integer condicionalDeferida;
    private Integer progressaoRegimeRequerida;
    private Integer progressaoRegimeDeferida;
    private Integer saidasTemporariasRequerida;
    private Integer saidasTemporariasDeferida;
    private Integer habeasCorpusRequerido;
    private Integer habeasCorpusDeferido;
    private Integer laudosPsicologicos;
    private Integer laudosPsiquiatricos;
    private Integer transferenciaProvimento;
    private Integer totalJuridico;
    //AL
    private Integer triagem;
    private Integer laborativaRemunerada;
    private Integer laborativaNaoRemunerada;
    private Integer totalLaboral;
    private Integer idAtividadeRecreativa;
    private Integer artesPlasticas;
    private Integer literatura;
    private Integer cantoTeatroCinema;
    private Integer esportes;
    private Integer religiosa;
    private Integer totalRecreativaReligiosa;
    //AFI
    private Integer cafeInterno;
    private Integer almocoInterno;
    private Integer jantarInterno;
    //TOT
    private Integer total01;
    private Integer total02;
    private Integer total03;
    private Integer total04;
    private Integer total05;
    private Integer total06;
    private Integer total07;
    private Integer total08;
    private Integer total09;

    public AtividadesMensalRealizadaUnidades() {
    }

    public AtividadesMensalRealizadaUnidades(Integer chave, String status, Date dataCriacao, Date dataAtualizacao, String mes, Integer ano, Integer idUnidade, String unidadePrisional, Integer mediaPopulacao, Integer quantidadeTotalPopulacao, Date dataPeriodoInicial, Date dataPeriodoFinal, String mesReferencia, String anoReferencia, Integer idFunc, String colaboradorResponsavel, String matricula, String departamento, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, Integer idAtividadeVisita, Integer atendimentoPsiPreso, Integer atendimentoPsiFamilaPreso, Date dataAtendimento, Date dataEntradaVisita, Date dataSaidaVisita, String tipoAtendimento, Integer numeroVistantesInternos, Integer numeroDiasVisitas, Integer mediaVisitasDia, Integer mediaVisitasInterno, Integer numeroCriancasVisitas, Integer presoIdentCivil, Integer presoAtiviReligiosa, Integer idAtividadeAlimentacao, Integer lanchesVisitantes, Integer cafeContratada, Integer almocoContratada, Integer jantarContratada, Integer lancheContratada, Integer cafeContratante, Integer almocoContratante, Integer jantarContratante, Integer lancheContratante, Integer totalAlimentacao, Integer idAtividadeAtendimentoSaude, Integer atendimentoClinico, Integer atendimentoPsiquiatrico, Integer atendimentoEnfermagem, Integer atendimentoOdontologico, Integer procedimentoOdontologico, Integer atendimentoPsicologico, Integer saudeBucal, Date dataAgravo, Integer vdrl, Integer hepatiteB, Integer hepatiteC, Integer hiv, Integer sifilis, Integer hpv, Integer diabetes, Integer hipertensao, Integer tuberculose, Integer hanseniase, Integer escabiose, Integer dst, Integer quantidadeAgravosTotal, Integer quantidadeAdmInfectoTotal, Integer quantidadeEvoInfectoTotal, Integer sexualidade, Integer vacinados, Integer totalSaude, Date dataMatricula, Date dataFrequencia, Integer idAtividadeAtendimentoEducacional, Integer matriculadoEnsinoFormal, Integer frequentandoEnsinoFormal, Integer matriculadoCursoProfissionalizante, Integer certificadoCursoProfissionalizante, Integer totalEducacional, Integer aparelhoBarbear, Integer absorvente, Integer bermuda, Integer caneca, Integer camisa, Integer cobertor, Integer colchao, Integer colher, Integer cueca, Integer cremeDental, Integer desodorante, Integer escova, Integer lencol, Integer papelHigienico, Integer parChinelos, Integer pote, Integer sabaoPo, Integer sabonete, Integer toalha, Integer uniformeCompleto, Integer idAtividadeMaterial, Integer totalMaterial, Date DataProcedimento, Integer quantidadeCelular, Integer quantidadeObjetos, Integer quantidadeProcedCelas, Integer idAtividadeSeguranca, Integer pessoasRefem, Integer ocorrenciaFuga, Integer ocorrenciaRebeliao, Integer ocorrenciaFerido, Integer ocorrenciaIndisciplina, Integer ocorrenciaGravementeFeridoMorto, Integer horasInterrupcaoCFTV, Integer diasInterrupcaoScannerCorporal, Integer diasInterrupcaoRaioXDetectorMetais, Integer diasInterrupcaoVeiculoTransportePreso, Integer falhaGeradorEnergia, Integer horasMauFuncionamentoBRS, Integer absorventesEntreguesPortariaScanner, Integer fraldasEntreguesPortariaScanner, Integer totalMaterialSeg, Integer idAtividadeJuridica, Integer internoFamiliaSAJ, Integer alvaraSolturaRecebido, Integer alvaraSolturaCumprido, Integer audienciaProvocada, Integer audienciaCumprida, Integer juriProvocado, Integer juriCumprido, Integer liberdadeProvisoriaRequerida, Integer liberdadeProvisoriaDeferida, Integer indultosRequeridos, Integer indultosDeferidos, Integer remicaoRequerida, Integer remicaoDeferida, Integer condicionalRequerida, Integer condicionalDeferida, Integer progressaoRegimeRequerida, Integer progressaoRegimeDeferida, Integer saidasTemporariasRequerida, Integer saidasTemporariasDeferida, Integer habeasCorpusRequerido, Integer habeasCorpusDeferido, Integer laudosPsicologicos, Integer laudosPsiquiatricos, Integer transferenciaProvimento, Integer totalJuridico, Integer triagem, Integer laborativaRemunerada, Integer laborativaNaoRemunerada, Integer totalLaboral, Integer idAtividadeRecreativa, Integer artesPlasticas, Integer literatura, Integer cantoTeatroCinema, Integer esportes, Integer religiosa, Integer totalRecreativaReligiosa, Integer cafeInterno, Integer almocoInterno, Integer jantarInterno, Integer total01, Integer total02, Integer total03, Integer total04, Integer total05, Integer total06, Integer total07, Integer total08, Integer total09) {
        this.chave = chave;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.mes = mes;
        this.ano = ano;
        this.idUnidade = idUnidade;
        this.unidadePrisional = unidadePrisional;
        this.mediaPopulacao = mediaPopulacao;
        this.quantidadeTotalPopulacao = quantidadeTotalPopulacao;
        this.dataPeriodoInicial = dataPeriodoInicial;
        this.dataPeriodoFinal = dataPeriodoFinal;
        this.mesReferencia = mesReferencia;
        this.anoReferencia = anoReferencia;
        this.idFunc = idFunc;
        this.colaboradorResponsavel = colaboradorResponsavel;
        this.matricula = matricula;
        this.departamento = departamento;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.idAtividadeVisita = idAtividadeVisita;
        this.atendimentoPsiPreso = atendimentoPsiPreso;
        this.atendimentoPsiFamilaPreso = atendimentoPsiFamilaPreso;
        this.dataAtendimento = dataAtendimento;
        this.dataEntradaVisita = dataEntradaVisita;
        this.dataSaidaVisita = dataSaidaVisita;
        this.tipoAtendimento = tipoAtendimento;
        this.numeroVistantesInternos = numeroVistantesInternos;
        this.numeroDiasVisitas = numeroDiasVisitas;
        this.mediaVisitasDia = mediaVisitasDia;
        this.mediaVisitasInterno = mediaVisitasInterno;
        this.numeroCriancasVisitas = numeroCriancasVisitas;
        this.presoIdentCivil = presoIdentCivil;
        this.presoAtiviReligiosa = presoAtiviReligiosa;
        this.idAtividadeAlimentacao = idAtividadeAlimentacao;
        this.lanchesVisitantes = lanchesVisitantes;
        this.cafeContratada = cafeContratada;
        this.almocoContratada = almocoContratada;
        this.jantarContratada = jantarContratada;
        this.lancheContratada = lancheContratada;
        this.cafeContratante = cafeContratante;
        this.almocoContratante = almocoContratante;
        this.jantarContratante = jantarContratante;
        this.lancheContratante = lancheContratante;
        this.totalAlimentacao = totalAlimentacao;
        this.idAtividadeAtendimentoSaude = idAtividadeAtendimentoSaude;
        this.atendimentoClinico = atendimentoClinico;
        this.atendimentoPsiquiatrico = atendimentoPsiquiatrico;
        this.atendimentoEnfermagem = atendimentoEnfermagem;
        this.atendimentoOdontologico = atendimentoOdontologico;
        this.procedimentoOdontologico = procedimentoOdontologico;
        this.atendimentoPsicologico = atendimentoPsicologico;
        this.saudeBucal = saudeBucal;
        this.dataAgravo = dataAgravo;
        this.vdrl = vdrl;
        this.hepatiteB = hepatiteB;
        this.hepatiteC = hepatiteC;
        this.hiv = hiv;
        this.sifilis = sifilis;
        this.hpv = hpv;
        this.diabetes = diabetes;
        this.hipertensao = hipertensao;
        this.tuberculose = tuberculose;
        this.hanseniase = hanseniase;
        this.escabiose = escabiose;
        this.dst = dst;
        this.quantidadeAgravosTotal = quantidadeAgravosTotal;
        this.quantidadeAdmInfectoTotal = quantidadeAdmInfectoTotal;
        this.quantidadeEvoInfectoTotal = quantidadeEvoInfectoTotal;
        this.sexualidade = sexualidade;
        this.vacinados = vacinados;
        this.totalSaude = totalSaude;
        this.dataMatricula = dataMatricula;
        this.dataFrequencia = dataFrequencia;
        this.idAtividadeAtendimentoEducacional = idAtividadeAtendimentoEducacional;
        this.matriculadoEnsinoFormal = matriculadoEnsinoFormal;
        this.frequentandoEnsinoFormal = frequentandoEnsinoFormal;
        this.matriculadoCursoProfissionalizante = matriculadoCursoProfissionalizante;
        this.certificadoCursoProfissionalizante = certificadoCursoProfissionalizante;
        this.totalEducacional = totalEducacional;
        this.aparelhoBarbear = aparelhoBarbear;
        this.absorvente = absorvente;
        this.bermuda = bermuda;
        this.caneca = caneca;
        this.camisa = camisa;
        this.cobertor = cobertor;
        this.colchao = colchao;
        this.colher = colher;
        this.cueca = cueca;
        this.cremeDental = cremeDental;
        this.desodorante = desodorante;
        this.escova = escova;
        this.lencol = lencol;
        this.papelHigienico = papelHigienico;
        this.parChinelos = parChinelos;
        this.pote = pote;
        this.sabaoPo = sabaoPo;
        this.sabonete = sabonete;
        this.toalha = toalha;
        this.uniformeCompleto = uniformeCompleto;
        this.idAtividadeMaterial = idAtividadeMaterial;
        this.totalMaterial = totalMaterial;
        this.DataProcedimento = DataProcedimento;
        this.quantidadeCelular = quantidadeCelular;
        this.quantidadeObjetos = quantidadeObjetos;
        this.quantidadeProcedCelas = quantidadeProcedCelas;
        this.idAtividadeSeguranca = idAtividadeSeguranca;
        this.pessoasRefem = pessoasRefem;
        this.ocorrenciaFuga = ocorrenciaFuga;
        this.ocorrenciaRebeliao = ocorrenciaRebeliao;
        this.ocorrenciaFerido = ocorrenciaFerido;
        this.ocorrenciaIndisciplina = ocorrenciaIndisciplina;
        this.ocorrenciaGravementeFeridoMorto = ocorrenciaGravementeFeridoMorto;
        this.horasInterrupcaoCFTV = horasInterrupcaoCFTV;
        this.diasInterrupcaoScannerCorporal = diasInterrupcaoScannerCorporal;
        this.diasInterrupcaoRaioXDetectorMetais = diasInterrupcaoRaioXDetectorMetais;
        this.diasInterrupcaoVeiculoTransportePreso = diasInterrupcaoVeiculoTransportePreso;
        this.falhaGeradorEnergia = falhaGeradorEnergia;
        this.horasMauFuncionamentoBRS = horasMauFuncionamentoBRS;
        this.absorventesEntreguesPortariaScanner = absorventesEntreguesPortariaScanner;
        this.fraldasEntreguesPortariaScanner = fraldasEntreguesPortariaScanner;
        this.totalMaterialSeg = totalMaterialSeg;
        this.idAtividadeJuridica = idAtividadeJuridica;
        this.internoFamiliaSAJ = internoFamiliaSAJ;
        this.alvaraSolturaRecebido = alvaraSolturaRecebido;
        this.alvaraSolturaCumprido = alvaraSolturaCumprido;
        this.audienciaProvocada = audienciaProvocada;
        this.audienciaCumprida = audienciaCumprida;
        this.juriProvocado = juriProvocado;
        this.juriCumprido = juriCumprido;
        this.liberdadeProvisoriaRequerida = liberdadeProvisoriaRequerida;
        this.liberdadeProvisoriaDeferida = liberdadeProvisoriaDeferida;
        this.indultosRequeridos = indultosRequeridos;
        this.indultosDeferidos = indultosDeferidos;
        this.remicaoRequerida = remicaoRequerida;
        this.remicaoDeferida = remicaoDeferida;
        this.condicionalRequerida = condicionalRequerida;
        this.condicionalDeferida = condicionalDeferida;
        this.progressaoRegimeRequerida = progressaoRegimeRequerida;
        this.progressaoRegimeDeferida = progressaoRegimeDeferida;
        this.saidasTemporariasRequerida = saidasTemporariasRequerida;
        this.saidasTemporariasDeferida = saidasTemporariasDeferida;
        this.habeasCorpusRequerido = habeasCorpusRequerido;
        this.habeasCorpusDeferido = habeasCorpusDeferido;
        this.laudosPsicologicos = laudosPsicologicos;
        this.laudosPsiquiatricos = laudosPsiquiatricos;
        this.transferenciaProvimento = transferenciaProvimento;
        this.totalJuridico = totalJuridico;
        this.triagem = triagem;
        this.laborativaRemunerada = laborativaRemunerada;
        this.laborativaNaoRemunerada = laborativaNaoRemunerada;
        this.totalLaboral = totalLaboral;
        this.idAtividadeRecreativa = idAtividadeRecreativa;
        this.artesPlasticas = artesPlasticas;
        this.literatura = literatura;
        this.cantoTeatroCinema = cantoTeatroCinema;
        this.esportes = esportes;
        this.religiosa = religiosa;
        this.totalRecreativaReligiosa = totalRecreativaReligiosa;
        this.cafeInterno = cafeInterno;
        this.almocoInterno = almocoInterno;
        this.jantarInterno = jantarInterno;
        this.total01 = total01;
        this.total02 = total02;
        this.total03 = total03;
        this.total04 = total04;
        this.total05 = total05;
        this.total06 = total06;
        this.total07 = total07;
        this.total08 = total08;
        this.total09 = total09;
    }

    /**
     * @return the chave
     */
    public Integer getChave() {
        return chave;
    }

    /**
     * @param chave the chave to set
     */
    public void setChave(Integer chave) {
        this.chave = chave;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the dataCriacao
     */
    public Date getDataCriacao() {
        return dataCriacao;
    }

    /**
     * @param dataCriacao the dataCriacao to set
     */
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    /**
     * @return the dataAtualizacao
     */
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    /**
     * @param dataAtualizacao the dataAtualizacao to set
     */
    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * @return the ano
     */
    public Integer getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    /**
     * @return the idUnidade
     */
    public Integer getIdUnidade() {
        return idUnidade;
    }

    /**
     * @param idUnidade the idUnidade to set
     */
    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    /**
     * @return the unidadePrisional
     */
    public String getUnidadePrisional() {
        return unidadePrisional;
    }

    /**
     * @param unidadePrisional the unidadePrisional to set
     */
    public void setUnidadePrisional(String unidadePrisional) {
        this.unidadePrisional = unidadePrisional;
    }

    /**
     * @return the mediaPopulacao
     */
    public Integer getMediaPopulacao() {
        return mediaPopulacao;
    }

    /**
     * @param mediaPopulacao the mediaPopulacao to set
     */
    public void setMediaPopulacao(Integer mediaPopulacao) {
        this.mediaPopulacao = mediaPopulacao;
    }

    /**
     * @return the quantidadeTotalPopulacao
     */
    public Integer getQuantidadeTotalPopulacao() {
        return quantidadeTotalPopulacao;
    }

    /**
     * @param quantidadeTotalPopulacao the quantidadeTotalPopulacao to set
     */
    public void setQuantidadeTotalPopulacao(Integer quantidadeTotalPopulacao) {
        this.quantidadeTotalPopulacao = quantidadeTotalPopulacao;
    }

    /**
     * @return the dataPeriodoInicial
     */
    public Date getDataPeriodoInicial() {
        return dataPeriodoInicial;
    }

    /**
     * @param dataPeriodoInicial the dataPeriodoInicial to set
     */
    public void setDataPeriodoInicial(Date dataPeriodoInicial) {
        this.dataPeriodoInicial = dataPeriodoInicial;
    }

    /**
     * @return the dataPeriodoFinal
     */
    public Date getDataPeriodoFinal() {
        return dataPeriodoFinal;
    }

    /**
     * @param dataPeriodoFinal the dataPeriodoFinal to set
     */
    public void setDataPeriodoFinal(Date dataPeriodoFinal) {
        this.dataPeriodoFinal = dataPeriodoFinal;
    }

    /**
     * @return the mesReferencia
     */
    public String getMesReferencia() {
        return mesReferencia;
    }

    /**
     * @param mesReferencia the mesReferencia to set
     */
    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    /**
     * @return the anoReferencia
     */
    public String getAnoReferencia() {
        return anoReferencia;
    }

    /**
     * @param anoReferencia the anoReferencia to set
     */
    public void setAnoReferencia(String anoReferencia) {
        this.anoReferencia = anoReferencia;
    }

    /**
     * @return the idFunc
     */
    public Integer getIdFunc() {
        return idFunc;
    }

    /**
     * @param idFunc the idFunc to set
     */
    public void setIdFunc(Integer idFunc) {
        this.idFunc = idFunc;
    }

    /**
     * @return the colaboradorResponsavel
     */
    public String getColaboradorResponsavel() {
        return colaboradorResponsavel;
    }

    /**
     * @param colaboradorResponsavel the colaboradorResponsavel to set
     */
    public void setColaboradorResponsavel(String colaboradorResponsavel) {
        this.colaboradorResponsavel = colaboradorResponsavel;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the usuarioInsert
     */
    public String getUsuarioInsert() {
        return usuarioInsert;
    }

    /**
     * @param usuarioInsert the usuarioInsert to set
     */
    public void setUsuarioInsert(String usuarioInsert) {
        this.usuarioInsert = usuarioInsert;
    }

    /**
     * @return the usuarioUp
     */
    public String getUsuarioUp() {
        return usuarioUp;
    }

    /**
     * @param usuarioUp the usuarioUp to set
     */
    public void setUsuarioUp(String usuarioUp) {
        this.usuarioUp = usuarioUp;
    }

    /**
     * @return the dataInsert
     */
    public String getDataInsert() {
        return dataInsert;
    }

    /**
     * @param dataInsert the dataInsert to set
     */
    public void setDataInsert(String dataInsert) {
        this.dataInsert = dataInsert;
    }

    /**
     * @return the dataUp
     */
    public String getDataUp() {
        return dataUp;
    }

    /**
     * @param dataUp the dataUp to set
     */
    public void setDataUp(String dataUp) {
        this.dataUp = dataUp;
    }

    /**
     * @return the horarioInsert
     */
    public String getHorarioInsert() {
        return horarioInsert;
    }

    /**
     * @param horarioInsert the horarioInsert to set
     */
    public void setHorarioInsert(String horarioInsert) {
        this.horarioInsert = horarioInsert;
    }

    /**
     * @return the horarioUp
     */
    public String getHorarioUp() {
        return horarioUp;
    }

    /**
     * @param horarioUp the horarioUp to set
     */
    public void setHorarioUp(String horarioUp) {
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idAtividadeVisita
     */
    public Integer getIdAtividadeVisita() {
        return idAtividadeVisita;
    }

    /**
     * @param idAtividadeVisita the idAtividadeVisita to set
     */
    public void setIdAtividadeVisita(Integer idAtividadeVisita) {
        this.idAtividadeVisita = idAtividadeVisita;
    }

    /**
     * @return the atendimentoPsiPreso
     */
    public Integer getAtendimentoPsiPreso() {
        return atendimentoPsiPreso;
    }

    /**
     * @param atendimentoPsiPreso the atendimentoPsiPreso to set
     */
    public void setAtendimentoPsiPreso(Integer atendimentoPsiPreso) {
        this.atendimentoPsiPreso = atendimentoPsiPreso;
    }

    /**
     * @return the atendimentoPsiFamilaPreso
     */
    public Integer getAtendimentoPsiFamilaPreso() {
        return atendimentoPsiFamilaPreso;
    }

    /**
     * @param atendimentoPsiFamilaPreso the atendimentoPsiFamilaPreso to set
     */
    public void setAtendimentoPsiFamilaPreso(Integer atendimentoPsiFamilaPreso) {
        this.atendimentoPsiFamilaPreso = atendimentoPsiFamilaPreso;
    }

    /**
     * @return the dataAtendimento
     */
    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    /**
     * @param dataAtendimento the dataAtendimento to set
     */
    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    /**
     * @return the dataEntradaVisita
     */
    public Date getDataEntradaVisita() {
        return dataEntradaVisita;
    }

    /**
     * @param dataEntradaVisita the dataEntradaVisita to set
     */
    public void setDataEntradaVisita(Date dataEntradaVisita) {
        this.dataEntradaVisita = dataEntradaVisita;
    }

    /**
     * @return the dataSaidaVisita
     */
    public Date getDataSaidaVisita() {
        return dataSaidaVisita;
    }

    /**
     * @param dataSaidaVisita the dataSaidaVisita to set
     */
    public void setDataSaidaVisita(Date dataSaidaVisita) {
        this.dataSaidaVisita = dataSaidaVisita;
    }

    /**
     * @return the tipoAtendimento
     */
    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    /**
     * @param tipoAtendimento the tipoAtendimento to set
     */
    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    /**
     * @return the numeroVistantesInternos
     */
    public Integer getNumeroVistantesInternos() {
        return numeroVistantesInternos;
    }

    /**
     * @param numeroVistantesInternos the numeroVistantesInternos to set
     */
    public void setNumeroVistantesInternos(Integer numeroVistantesInternos) {
        this.numeroVistantesInternos = numeroVistantesInternos;
    }

    /**
     * @return the numeroDiasVisitas
     */
    public Integer getNumeroDiasVisitas() {
        return numeroDiasVisitas;
    }

    /**
     * @param numeroDiasVisitas the numeroDiasVisitas to set
     */
    public void setNumeroDiasVisitas(Integer numeroDiasVisitas) {
        this.numeroDiasVisitas = numeroDiasVisitas;
    }

    /**
     * @return the mediaVisitasDia
     */
    public Integer getMediaVisitasDia() {
        return mediaVisitasDia;
    }

    /**
     * @param mediaVisitasDia the mediaVisitasDia to set
     */
    public void setMediaVisitasDia(Integer mediaVisitasDia) {
        this.mediaVisitasDia = mediaVisitasDia;
    }

    /**
     * @return the mediaVisitasInterno
     */
    public Integer getMediaVisitasInterno() {
        return mediaVisitasInterno;
    }

    /**
     * @param mediaVisitasInterno the mediaVisitasInterno to set
     */
    public void setMediaVisitasInterno(Integer mediaVisitasInterno) {
        this.mediaVisitasInterno = mediaVisitasInterno;
    }

    /**
     * @return the numeroCriancasVisitas
     */
    public Integer getNumeroCriancasVisitas() {
        return numeroCriancasVisitas;
    }

    /**
     * @param numeroCriancasVisitas the numeroCriancasVisitas to set
     */
    public void setNumeroCriancasVisitas(Integer numeroCriancasVisitas) {
        this.numeroCriancasVisitas = numeroCriancasVisitas;
    }

    /**
     * @return the presoIdentCivil
     */
    public Integer getPresoIdentCivil() {
        return presoIdentCivil;
    }

    /**
     * @param presoIdentCivil the presoIdentCivil to set
     */
    public void setPresoIdentCivil(Integer presoIdentCivil) {
        this.presoIdentCivil = presoIdentCivil;
    }

    /**
     * @return the presoAtiviReligiosa
     */
    public Integer getPresoAtiviReligiosa() {
        return presoAtiviReligiosa;
    }

    /**
     * @param presoAtiviReligiosa the presoAtiviReligiosa to set
     */
    public void setPresoAtiviReligiosa(Integer presoAtiviReligiosa) {
        this.presoAtiviReligiosa = presoAtiviReligiosa;
    }

    /**
     * @return the idAtividadeAlimentacao
     */
    public Integer getIdAtividadeAlimentacao() {
        return idAtividadeAlimentacao;
    }

    /**
     * @param idAtividadeAlimentacao the idAtividadeAlimentacao to set
     */
    public void setIdAtividadeAlimentacao(Integer idAtividadeAlimentacao) {
        this.idAtividadeAlimentacao = idAtividadeAlimentacao;
    }

    /**
     * @return the lanchesVisitantes
     */
    public Integer getLanchesVisitantes() {
        return lanchesVisitantes;
    }

    /**
     * @param lanchesVisitantes the lanchesVisitantes to set
     */
    public void setLanchesVisitantes(Integer lanchesVisitantes) {
        this.lanchesVisitantes = lanchesVisitantes;
    }

    /**
     * @return the cafeContratada
     */
    public Integer getCafeContratada() {
        return cafeContratada;
    }

    /**
     * @param cafeContratada the cafeContratada to set
     */
    public void setCafeContratada(Integer cafeContratada) {
        this.cafeContratada = cafeContratada;
    }

    /**
     * @return the almocoContratada
     */
    public Integer getAlmocoContratada() {
        return almocoContratada;
    }

    /**
     * @param almocoContratada the almocoContratada to set
     */
    public void setAlmocoContratada(Integer almocoContratada) {
        this.almocoContratada = almocoContratada;
    }

    /**
     * @return the jantarContratada
     */
    public Integer getJantarContratada() {
        return jantarContratada;
    }

    /**
     * @param jantarContratada the jantarContratada to set
     */
    public void setJantarContratada(Integer jantarContratada) {
        this.jantarContratada = jantarContratada;
    }

    /**
     * @return the lancheContratada
     */
    public Integer getLancheContratada() {
        return lancheContratada;
    }

    /**
     * @param lancheContratada the lancheContratada to set
     */
    public void setLancheContratada(Integer lancheContratada) {
        this.lancheContratada = lancheContratada;
    }

    /**
     * @return the cafeContratante
     */
    public Integer getCafeContratante() {
        return cafeContratante;
    }

    /**
     * @param cafeContratante the cafeContratante to set
     */
    public void setCafeContratante(Integer cafeContratante) {
        this.cafeContratante = cafeContratante;
    }

    /**
     * @return the almocoContratante
     */
    public Integer getAlmocoContratante() {
        return almocoContratante;
    }

    /**
     * @param almocoContratante the almocoContratante to set
     */
    public void setAlmocoContratante(Integer almocoContratante) {
        this.almocoContratante = almocoContratante;
    }

    /**
     * @return the jantarContratante
     */
    public Integer getJantarContratante() {
        return jantarContratante;
    }

    /**
     * @param jantarContratante the jantarContratante to set
     */
    public void setJantarContratante(Integer jantarContratante) {
        this.jantarContratante = jantarContratante;
    }

    /**
     * @return the lancheContratante
     */
    public Integer getLancheContratante() {
        return lancheContratante;
    }

    /**
     * @param lancheContratante the lancheContratante to set
     */
    public void setLancheContratante(Integer lancheContratante) {
        this.lancheContratante = lancheContratante;
    }

    /**
     * @return the totalAlimentacao
     */
    public Integer getTotalAlimentacao() {
        return totalAlimentacao;
    }

    /**
     * @param totalAlimentacao the totalAlimentacao to set
     */
    public void setTotalAlimentacao(Integer totalAlimentacao) {
        this.totalAlimentacao = totalAlimentacao;
    }

    /**
     * @return the idAtividadeAtendimentoSaude
     */
    public Integer getIdAtividadeAtendimentoSaude() {
        return idAtividadeAtendimentoSaude;
    }

    /**
     * @param idAtividadeAtendimentoSaude the idAtividadeAtendimentoSaude to set
     */
    public void setIdAtividadeAtendimentoSaude(Integer idAtividadeAtendimentoSaude) {
        this.idAtividadeAtendimentoSaude = idAtividadeAtendimentoSaude;
    }

    /**
     * @return the atendimentoClinico
     */
    public Integer getAtendimentoClinico() {
        return atendimentoClinico;
    }

    /**
     * @param atendimentoClinico the atendimentoClinico to set
     */
    public void setAtendimentoClinico(Integer atendimentoClinico) {
        this.atendimentoClinico = atendimentoClinico;
    }

    /**
     * @return the atendimentoPsiquiatrico
     */
    public Integer getAtendimentoPsiquiatrico() {
        return atendimentoPsiquiatrico;
    }

    /**
     * @param atendimentoPsiquiatrico the atendimentoPsiquiatrico to set
     */
    public void setAtendimentoPsiquiatrico(Integer atendimentoPsiquiatrico) {
        this.atendimentoPsiquiatrico = atendimentoPsiquiatrico;
    }

    /**
     * @return the atendimentoEnfermagem
     */
    public Integer getAtendimentoEnfermagem() {
        return atendimentoEnfermagem;
    }

    /**
     * @param atendimentoEnfermagem the atendimentoEnfermagem to set
     */
    public void setAtendimentoEnfermagem(Integer atendimentoEnfermagem) {
        this.atendimentoEnfermagem = atendimentoEnfermagem;
    }

    /**
     * @return the atendimentoOdontologico
     */
    public Integer getAtendimentoOdontologico() {
        return atendimentoOdontologico;
    }

    /**
     * @param atendimentoOdontologico the atendimentoOdontologico to set
     */
    public void setAtendimentoOdontologico(Integer atendimentoOdontologico) {
        this.atendimentoOdontologico = atendimentoOdontologico;
    }

    /**
     * @return the procedimentoOdontologico
     */
    public Integer getProcedimentoOdontologico() {
        return procedimentoOdontologico;
    }

    /**
     * @param procedimentoOdontologico the procedimentoOdontologico to set
     */
    public void setProcedimentoOdontologico(Integer procedimentoOdontologico) {
        this.procedimentoOdontologico = procedimentoOdontologico;
    }

    /**
     * @return the atendimentoPsicologico
     */
    public Integer getAtendimentoPsicologico() {
        return atendimentoPsicologico;
    }

    /**
     * @param atendimentoPsicologico the atendimentoPsicologico to set
     */
    public void setAtendimentoPsicologico(Integer atendimentoPsicologico) {
        this.atendimentoPsicologico = atendimentoPsicologico;
    }

    /**
     * @return the saudeBucal
     */
    public Integer getSaudeBucal() {
        return saudeBucal;
    }

    /**
     * @param saudeBucal the saudeBucal to set
     */
    public void setSaudeBucal(Integer saudeBucal) {
        this.saudeBucal = saudeBucal;
    }

    /**
     * @return the dataAgravo
     */
    public Date getDataAgravo() {
        return dataAgravo;
    }

    /**
     * @param dataAgravo the dataAgravo to set
     */
    public void setDataAgravo(Date dataAgravo) {
        this.dataAgravo = dataAgravo;
    }

    /**
     * @return the vdrl
     */
    public Integer getVdrl() {
        return vdrl;
    }

    /**
     * @param vdrl the vdrl to set
     */
    public void setVdrl(Integer vdrl) {
        this.vdrl = vdrl;
    }

    /**
     * @return the hepatiteB
     */
    public Integer getHepatiteB() {
        return hepatiteB;
    }

    /**
     * @param hepatiteB the hepatiteB to set
     */
    public void setHepatiteB(Integer hepatiteB) {
        this.hepatiteB = hepatiteB;
    }

    /**
     * @return the hepatiteC
     */
    public Integer getHepatiteC() {
        return hepatiteC;
    }

    /**
     * @param hepatiteC the hepatiteC to set
     */
    public void setHepatiteC(Integer hepatiteC) {
        this.hepatiteC = hepatiteC;
    }

    /**
     * @return the hiv
     */
    public Integer getHiv() {
        return hiv;
    }

    /**
     * @param hiv the hiv to set
     */
    public void setHiv(Integer hiv) {
        this.hiv = hiv;
    }

    /**
     * @return the sifilis
     */
    public Integer getSifilis() {
        return sifilis;
    }

    /**
     * @param sifilis the sifilis to set
     */
    public void setSifilis(Integer sifilis) {
        this.sifilis = sifilis;
    }

    /**
     * @return the hpv
     */
    public Integer getHpv() {
        return hpv;
    }

    /**
     * @param hpv the hpv to set
     */
    public void setHpv(Integer hpv) {
        this.hpv = hpv;
    }

    /**
     * @return the diabetes
     */
    public Integer getDiabetes() {
        return diabetes;
    }

    /**
     * @param diabetes the diabetes to set
     */
    public void setDiabetes(Integer diabetes) {
        this.diabetes = diabetes;
    }

    /**
     * @return the hipertensao
     */
    public Integer getHipertensao() {
        return hipertensao;
    }

    /**
     * @param hipertensao the hipertensao to set
     */
    public void setHipertensao(Integer hipertensao) {
        this.hipertensao = hipertensao;
    }

    /**
     * @return the tuberculose
     */
    public Integer getTuberculose() {
        return tuberculose;
    }

    /**
     * @param tuberculose the tuberculose to set
     */
    public void setTuberculose(Integer tuberculose) {
        this.tuberculose = tuberculose;
    }

    /**
     * @return the hanseniase
     */
    public Integer getHanseniase() {
        return hanseniase;
    }

    /**
     * @param hanseniase the hanseniase to set
     */
    public void setHanseniase(Integer hanseniase) {
        this.hanseniase = hanseniase;
    }

    /**
     * @return the escabiose
     */
    public Integer getEscabiose() {
        return escabiose;
    }

    /**
     * @param escabiose the escabiose to set
     */
    public void setEscabiose(Integer escabiose) {
        this.escabiose = escabiose;
    }

    /**
     * @return the dst
     */
    public Integer getDst() {
        return dst;
    }

    /**
     * @param dst the dst to set
     */
    public void setDst(Integer dst) {
        this.dst = dst;
    }

    /**
     * @return the quantidadeAgravosTotal
     */
    public Integer getQuantidadeAgravosTotal() {
        return quantidadeAgravosTotal;
    }

    /**
     * @param quantidadeAgravosTotal the quantidadeAgravosTotal to set
     */
    public void setQuantidadeAgravosTotal(Integer quantidadeAgravosTotal) {
        this.quantidadeAgravosTotal = quantidadeAgravosTotal;
    }

    /**
     * @return the quantidadeAdmInfectoTotal
     */
    public Integer getQuantidadeAdmInfectoTotal() {
        return quantidadeAdmInfectoTotal;
    }

    /**
     * @param quantidadeAdmInfectoTotal the quantidadeAdmInfectoTotal to set
     */
    public void setQuantidadeAdmInfectoTotal(Integer quantidadeAdmInfectoTotal) {
        this.quantidadeAdmInfectoTotal = quantidadeAdmInfectoTotal;
    }

    /**
     * @return the quantidadeEvoInfectoTotal
     */
    public Integer getQuantidadeEvoInfectoTotal() {
        return quantidadeEvoInfectoTotal;
    }

    /**
     * @param quantidadeEvoInfectoTotal the quantidadeEvoInfectoTotal to set
     */
    public void setQuantidadeEvoInfectoTotal(Integer quantidadeEvoInfectoTotal) {
        this.quantidadeEvoInfectoTotal = quantidadeEvoInfectoTotal;
    }

    /**
     * @return the sexualidade
     */
    public Integer getSexualidade() {
        return sexualidade;
    }

    /**
     * @param sexualidade the sexualidade to set
     */
    public void setSexualidade(Integer sexualidade) {
        this.sexualidade = sexualidade;
    }

    /**
     * @return the vacinados
     */
    public Integer getVacinados() {
        return vacinados;
    }

    /**
     * @param vacinados the vacinados to set
     */
    public void setVacinados(Integer vacinados) {
        this.vacinados = vacinados;
    }

    /**
     * @return the totalSaude
     */
    public Integer getTotalSaude() {
        return totalSaude;
    }

    /**
     * @param totalSaude the totalSaude to set
     */
    public void setTotalSaude(Integer totalSaude) {
        this.totalSaude = totalSaude;
    }

    /**
     * @return the dataMatricula
     */
    public Date getDataMatricula() {
        return dataMatricula;
    }

    /**
     * @param dataMatricula the dataMatricula to set
     */
    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    /**
     * @return the dataFrequencia
     */
    public Date getDataFrequencia() {
        return dataFrequencia;
    }

    /**
     * @param dataFrequencia the dataFrequencia to set
     */
    public void setDataFrequencia(Date dataFrequencia) {
        this.dataFrequencia = dataFrequencia;
    }

    /**
     * @return the idAtividadeAtendimentoEducacional
     */
    public Integer getIdAtividadeAtendimentoEducacional() {
        return idAtividadeAtendimentoEducacional;
    }

    /**
     * @param idAtividadeAtendimentoEducacional the idAtividadeAtendimentoEducacional to set
     */
    public void setIdAtividadeAtendimentoEducacional(Integer idAtividadeAtendimentoEducacional) {
        this.idAtividadeAtendimentoEducacional = idAtividadeAtendimentoEducacional;
    }

    /**
     * @return the matriculadoEnsinoFormal
     */
    public Integer getMatriculadoEnsinoFormal() {
        return matriculadoEnsinoFormal;
    }

    /**
     * @param matriculadoEnsinoFormal the matriculadoEnsinoFormal to set
     */
    public void setMatriculadoEnsinoFormal(Integer matriculadoEnsinoFormal) {
        this.matriculadoEnsinoFormal = matriculadoEnsinoFormal;
    }

    /**
     * @return the frequentandoEnsinoFormal
     */
    public Integer getFrequentandoEnsinoFormal() {
        return frequentandoEnsinoFormal;
    }

    /**
     * @param frequentandoEnsinoFormal the frequentandoEnsinoFormal to set
     */
    public void setFrequentandoEnsinoFormal(Integer frequentandoEnsinoFormal) {
        this.frequentandoEnsinoFormal = frequentandoEnsinoFormal;
    }

    /**
     * @return the matriculadoCursoProfissionalizante
     */
    public Integer getMatriculadoCursoProfissionalizante() {
        return matriculadoCursoProfissionalizante;
    }

    /**
     * @param matriculadoCursoProfissionalizante the matriculadoCursoProfissionalizante to set
     */
    public void setMatriculadoCursoProfissionalizante(Integer matriculadoCursoProfissionalizante) {
        this.matriculadoCursoProfissionalizante = matriculadoCursoProfissionalizante;
    }

    /**
     * @return the certificadoCursoProfissionalizante
     */
    public Integer getCertificadoCursoProfissionalizante() {
        return certificadoCursoProfissionalizante;
    }

    /**
     * @param certificadoCursoProfissionalizante the certificadoCursoProfissionalizante to set
     */
    public void setCertificadoCursoProfissionalizante(Integer certificadoCursoProfissionalizante) {
        this.certificadoCursoProfissionalizante = certificadoCursoProfissionalizante;
    }

    /**
     * @return the totalEducacional
     */
    public Integer getTotalEducacional() {
        return totalEducacional;
    }

    /**
     * @param totalEducacional the totalEducacional to set
     */
    public void setTotalEducacional(Integer totalEducacional) {
        this.totalEducacional = totalEducacional;
    }

    /**
     * @return the aparelhoBarbear
     */
    public Integer getAparelhoBarbear() {
        return aparelhoBarbear;
    }

    /**
     * @param aparelhoBarbear the aparelhoBarbear to set
     */
    public void setAparelhoBarbear(Integer aparelhoBarbear) {
        this.aparelhoBarbear = aparelhoBarbear;
    }

    /**
     * @return the absorvente
     */
    public Integer getAbsorvente() {
        return absorvente;
    }

    /**
     * @param absorvente the absorvente to set
     */
    public void setAbsorvente(Integer absorvente) {
        this.absorvente = absorvente;
    }

    /**
     * @return the bermuda
     */
    public Integer getBermuda() {
        return bermuda;
    }

    /**
     * @param bermuda the bermuda to set
     */
    public void setBermuda(Integer bermuda) {
        this.bermuda = bermuda;
    }

    /**
     * @return the caneca
     */
    public Integer getCaneca() {
        return caneca;
    }

    /**
     * @param caneca the caneca to set
     */
    public void setCaneca(Integer caneca) {
        this.caneca = caneca;
    }

    /**
     * @return the camisa
     */
    public Integer getCamisa() {
        return camisa;
    }

    /**
     * @param camisa the camisa to set
     */
    public void setCamisa(Integer camisa) {
        this.camisa = camisa;
    }

    /**
     * @return the cobertor
     */
    public Integer getCobertor() {
        return cobertor;
    }

    /**
     * @param cobertor the cobertor to set
     */
    public void setCobertor(Integer cobertor) {
        this.cobertor = cobertor;
    }

    /**
     * @return the colchao
     */
    public Integer getColchao() {
        return colchao;
    }

    /**
     * @param colchao the colchao to set
     */
    public void setColchao(Integer colchao) {
        this.colchao = colchao;
    }

    /**
     * @return the colher
     */
    public Integer getColher() {
        return colher;
    }

    /**
     * @param colher the colher to set
     */
    public void setColher(Integer colher) {
        this.colher = colher;
    }

    /**
     * @return the cueca
     */
    public Integer getCueca() {
        return cueca;
    }

    /**
     * @param cueca the cueca to set
     */
    public void setCueca(Integer cueca) {
        this.cueca = cueca;
    }

    /**
     * @return the cremeDental
     */
    public Integer getCremeDental() {
        return cremeDental;
    }

    /**
     * @param cremeDental the cremeDental to set
     */
    public void setCremeDental(Integer cremeDental) {
        this.cremeDental = cremeDental;
    }

    /**
     * @return the desodorante
     */
    public Integer getDesodorante() {
        return desodorante;
    }

    /**
     * @param desodorante the desodorante to set
     */
    public void setDesodorante(Integer desodorante) {
        this.desodorante = desodorante;
    }

    /**
     * @return the escova
     */
    public Integer getEscova() {
        return escova;
    }

    /**
     * @param escova the escova to set
     */
    public void setEscova(Integer escova) {
        this.escova = escova;
    }

    /**
     * @return the lencol
     */
    public Integer getLencol() {
        return lencol;
    }

    /**
     * @param lencol the lencol to set
     */
    public void setLencol(Integer lencol) {
        this.lencol = lencol;
    }

    /**
     * @return the papelHigienico
     */
    public Integer getPapelHigienico() {
        return papelHigienico;
    }

    /**
     * @param papelHigienico the papelHigienico to set
     */
    public void setPapelHigienico(Integer papelHigienico) {
        this.papelHigienico = papelHigienico;
    }

    /**
     * @return the parChinelos
     */
    public Integer getParChinelos() {
        return parChinelos;
    }

    /**
     * @param parChinelos the parChinelos to set
     */
    public void setParChinelos(Integer parChinelos) {
        this.parChinelos = parChinelos;
    }

    /**
     * @return the pote
     */
    public Integer getPote() {
        return pote;
    }

    /**
     * @param pote the pote to set
     */
    public void setPote(Integer pote) {
        this.pote = pote;
    }

    /**
     * @return the sabaoPo
     */
    public Integer getSabaoPo() {
        return sabaoPo;
    }

    /**
     * @param sabaoPo the sabaoPo to set
     */
    public void setSabaoPo(Integer sabaoPo) {
        this.sabaoPo = sabaoPo;
    }

    /**
     * @return the sabonete
     */
    public Integer getSabonete() {
        return sabonete;
    }

    /**
     * @param sabonete the sabonete to set
     */
    public void setSabonete(Integer sabonete) {
        this.sabonete = sabonete;
    }

    /**
     * @return the toalha
     */
    public Integer getToalha() {
        return toalha;
    }

    /**
     * @param toalha the toalha to set
     */
    public void setToalha(Integer toalha) {
        this.toalha = toalha;
    }

    /**
     * @return the uniformeCompleto
     */
    public Integer getUniformeCompleto() {
        return uniformeCompleto;
    }

    /**
     * @param uniformeCompleto the uniformeCompleto to set
     */
    public void setUniformeCompleto(Integer uniformeCompleto) {
        this.uniformeCompleto = uniformeCompleto;
    }

    /**
     * @return the idAtividadeMaterial
     */
    public Integer getIdAtividadeMaterial() {
        return idAtividadeMaterial;
    }

    /**
     * @param idAtividadeMaterial the idAtividadeMaterial to set
     */
    public void setIdAtividadeMaterial(Integer idAtividadeMaterial) {
        this.idAtividadeMaterial = idAtividadeMaterial;
    }

    /**
     * @return the totalMaterial
     */
    public Integer getTotalMaterial() {
        return totalMaterial;
    }

    /**
     * @param totalMaterial the totalMaterial to set
     */
    public void setTotalMaterial(Integer totalMaterial) {
        this.totalMaterial = totalMaterial;
    }

    /**
     * @return the DataProcedimento
     */
    public Date getDataProcedimento() {
        return DataProcedimento;
    }

    /**
     * @param DataProcedimento the DataProcedimento to set
     */
    public void setDataProcedimento(Date DataProcedimento) {
        this.DataProcedimento = DataProcedimento;
    }

    /**
     * @return the quantidadeCelular
     */
    public Integer getQuantidadeCelular() {
        return quantidadeCelular;
    }

    /**
     * @param quantidadeCelular the quantidadeCelular to set
     */
    public void setQuantidadeCelular(Integer quantidadeCelular) {
        this.quantidadeCelular = quantidadeCelular;
    }

    /**
     * @return the quantidadeObjetos
     */
    public Integer getQuantidadeObjetos() {
        return quantidadeObjetos;
    }

    /**
     * @param quantidadeObjetos the quantidadeObjetos to set
     */
    public void setQuantidadeObjetos(Integer quantidadeObjetos) {
        this.quantidadeObjetos = quantidadeObjetos;
    }

    /**
     * @return the quantidadeProcedCelas
     */
    public Integer getQuantidadeProcedCelas() {
        return quantidadeProcedCelas;
    }

    /**
     * @param quantidadeProcedCelas the quantidadeProcedCelas to set
     */
    public void setQuantidadeProcedCelas(Integer quantidadeProcedCelas) {
        this.quantidadeProcedCelas = quantidadeProcedCelas;
    }

    /**
     * @return the idAtividadeSeguranca
     */
    public Integer getIdAtividadeSeguranca() {
        return idAtividadeSeguranca;
    }

    /**
     * @param idAtividadeSeguranca the idAtividadeSeguranca to set
     */
    public void setIdAtividadeSeguranca(Integer idAtividadeSeguranca) {
        this.idAtividadeSeguranca = idAtividadeSeguranca;
    }

    /**
     * @return the pessoasRefem
     */
    public Integer getPessoasRefem() {
        return pessoasRefem;
    }

    /**
     * @param pessoasRefem the pessoasRefem to set
     */
    public void setPessoasRefem(Integer pessoasRefem) {
        this.pessoasRefem = pessoasRefem;
    }

    /**
     * @return the ocorrenciaFuga
     */
    public Integer getOcorrenciaFuga() {
        return ocorrenciaFuga;
    }

    /**
     * @param ocorrenciaFuga the ocorrenciaFuga to set
     */
    public void setOcorrenciaFuga(Integer ocorrenciaFuga) {
        this.ocorrenciaFuga = ocorrenciaFuga;
    }

    /**
     * @return the ocorrenciaRebeliao
     */
    public Integer getOcorrenciaRebeliao() {
        return ocorrenciaRebeliao;
    }

    /**
     * @param ocorrenciaRebeliao the ocorrenciaRebeliao to set
     */
    public void setOcorrenciaRebeliao(Integer ocorrenciaRebeliao) {
        this.ocorrenciaRebeliao = ocorrenciaRebeliao;
    }

    /**
     * @return the ocorrenciaFerido
     */
    public Integer getOcorrenciaFerido() {
        return ocorrenciaFerido;
    }

    /**
     * @param ocorrenciaFerido the ocorrenciaFerido to set
     */
    public void setOcorrenciaFerido(Integer ocorrenciaFerido) {
        this.ocorrenciaFerido = ocorrenciaFerido;
    }

    /**
     * @return the ocorrenciaIndisciplina
     */
    public Integer getOcorrenciaIndisciplina() {
        return ocorrenciaIndisciplina;
    }

    /**
     * @param ocorrenciaIndisciplina the ocorrenciaIndisciplina to set
     */
    public void setOcorrenciaIndisciplina(Integer ocorrenciaIndisciplina) {
        this.ocorrenciaIndisciplina = ocorrenciaIndisciplina;
    }

    /**
     * @return the ocorrenciaGravementeFeridoMorto
     */
    public Integer getOcorrenciaGravementeFeridoMorto() {
        return ocorrenciaGravementeFeridoMorto;
    }

    /**
     * @param ocorrenciaGravementeFeridoMorto the ocorrenciaGravementeFeridoMorto to set
     */
    public void setOcorrenciaGravementeFeridoMorto(Integer ocorrenciaGravementeFeridoMorto) {
        this.ocorrenciaGravementeFeridoMorto = ocorrenciaGravementeFeridoMorto;
    }

    /**
     * @return the horasInterrupcaoCFTV
     */
    public Integer getHorasInterrupcaoCFTV() {
        return horasInterrupcaoCFTV;
    }

    /**
     * @param horasInterrupcaoCFTV the horasInterrupcaoCFTV to set
     */
    public void setHorasInterrupcaoCFTV(Integer horasInterrupcaoCFTV) {
        this.horasInterrupcaoCFTV = horasInterrupcaoCFTV;
    }

    /**
     * @return the diasInterrupcaoScannerCorporal
     */
    public Integer getDiasInterrupcaoScannerCorporal() {
        return diasInterrupcaoScannerCorporal;
    }

    /**
     * @param diasInterrupcaoScannerCorporal the diasInterrupcaoScannerCorporal to set
     */
    public void setDiasInterrupcaoScannerCorporal(Integer diasInterrupcaoScannerCorporal) {
        this.diasInterrupcaoScannerCorporal = diasInterrupcaoScannerCorporal;
    }

    /**
     * @return the diasInterrupcaoRaioXDetectorMetais
     */
    public Integer getDiasInterrupcaoRaioXDetectorMetais() {
        return diasInterrupcaoRaioXDetectorMetais;
    }

    /**
     * @param diasInterrupcaoRaioXDetectorMetais the diasInterrupcaoRaioXDetectorMetais to set
     */
    public void setDiasInterrupcaoRaioXDetectorMetais(Integer diasInterrupcaoRaioXDetectorMetais) {
        this.diasInterrupcaoRaioXDetectorMetais = diasInterrupcaoRaioXDetectorMetais;
    }

    /**
     * @return the diasInterrupcaoVeiculoTransportePreso
     */
    public Integer getDiasInterrupcaoVeiculoTransportePreso() {
        return diasInterrupcaoVeiculoTransportePreso;
    }

    /**
     * @param diasInterrupcaoVeiculoTransportePreso the diasInterrupcaoVeiculoTransportePreso to set
     */
    public void setDiasInterrupcaoVeiculoTransportePreso(Integer diasInterrupcaoVeiculoTransportePreso) {
        this.diasInterrupcaoVeiculoTransportePreso = diasInterrupcaoVeiculoTransportePreso;
    }

    /**
     * @return the falhaGeradorEnergia
     */
    public Integer getFalhaGeradorEnergia() {
        return falhaGeradorEnergia;
    }

    /**
     * @param falhaGeradorEnergia the falhaGeradorEnergia to set
     */
    public void setFalhaGeradorEnergia(Integer falhaGeradorEnergia) {
        this.falhaGeradorEnergia = falhaGeradorEnergia;
    }

    /**
     * @return the horasMauFuncionamentoBRS
     */
    public Integer getHorasMauFuncionamentoBRS() {
        return horasMauFuncionamentoBRS;
    }

    /**
     * @param horasMauFuncionamentoBRS the horasMauFuncionamentoBRS to set
     */
    public void setHorasMauFuncionamentoBRS(Integer horasMauFuncionamentoBRS) {
        this.horasMauFuncionamentoBRS = horasMauFuncionamentoBRS;
    }

    /**
     * @return the absorventesEntreguesPortariaScanner
     */
    public Integer getAbsorventesEntreguesPortariaScanner() {
        return absorventesEntreguesPortariaScanner;
    }

    /**
     * @param absorventesEntreguesPortariaScanner the absorventesEntreguesPortariaScanner to set
     */
    public void setAbsorventesEntreguesPortariaScanner(Integer absorventesEntreguesPortariaScanner) {
        this.absorventesEntreguesPortariaScanner = absorventesEntreguesPortariaScanner;
    }

    /**
     * @return the fraldasEntreguesPortariaScanner
     */
    public Integer getFraldasEntreguesPortariaScanner() {
        return fraldasEntreguesPortariaScanner;
    }

    /**
     * @param fraldasEntreguesPortariaScanner the fraldasEntreguesPortariaScanner to set
     */
    public void setFraldasEntreguesPortariaScanner(Integer fraldasEntreguesPortariaScanner) {
        this.fraldasEntreguesPortariaScanner = fraldasEntreguesPortariaScanner;
    }

    /**
     * @return the totalMaterialSeg
     */
    public Integer getTotalMaterialSeg() {
        return totalMaterialSeg;
    }

    /**
     * @param totalMaterialSeg the totalMaterialSeg to set
     */
    public void setTotalMaterialSeg(Integer totalMaterialSeg) {
        this.totalMaterialSeg = totalMaterialSeg;
    }

    /**
     * @return the idAtividadeJuridica
     */
    public Integer getIdAtividadeJuridica() {
        return idAtividadeJuridica;
    }

    /**
     * @param idAtividadeJuridica the idAtividadeJuridica to set
     */
    public void setIdAtividadeJuridica(Integer idAtividadeJuridica) {
        this.idAtividadeJuridica = idAtividadeJuridica;
    }

    /**
     * @return the internoFamiliaSAJ
     */
    public Integer getInternoFamiliaSAJ() {
        return internoFamiliaSAJ;
    }

    /**
     * @param internoFamiliaSAJ the internoFamiliaSAJ to set
     */
    public void setInternoFamiliaSAJ(Integer internoFamiliaSAJ) {
        this.internoFamiliaSAJ = internoFamiliaSAJ;
    }

    /**
     * @return the alvaraSolturaRecebido
     */
    public Integer getAlvaraSolturaRecebido() {
        return alvaraSolturaRecebido;
    }

    /**
     * @param alvaraSolturaRecebido the alvaraSolturaRecebido to set
     */
    public void setAlvaraSolturaRecebido(Integer alvaraSolturaRecebido) {
        this.alvaraSolturaRecebido = alvaraSolturaRecebido;
    }

    /**
     * @return the alvaraSolturaCumprido
     */
    public Integer getAlvaraSolturaCumprido() {
        return alvaraSolturaCumprido;
    }

    /**
     * @param alvaraSolturaCumprido the alvaraSolturaCumprido to set
     */
    public void setAlvaraSolturaCumprido(Integer alvaraSolturaCumprido) {
        this.alvaraSolturaCumprido = alvaraSolturaCumprido;
    }

    /**
     * @return the audienciaProvocada
     */
    public Integer getAudienciaProvocada() {
        return audienciaProvocada;
    }

    /**
     * @param audienciaProvocada the audienciaProvocada to set
     */
    public void setAudienciaProvocada(Integer audienciaProvocada) {
        this.audienciaProvocada = audienciaProvocada;
    }

    /**
     * @return the audienciaCumprida
     */
    public Integer getAudienciaCumprida() {
        return audienciaCumprida;
    }

    /**
     * @param audienciaCumprida the audienciaCumprida to set
     */
    public void setAudienciaCumprida(Integer audienciaCumprida) {
        this.audienciaCumprida = audienciaCumprida;
    }

    /**
     * @return the juriProvocado
     */
    public Integer getJuriProvocado() {
        return juriProvocado;
    }

    /**
     * @param juriProvocado the juriProvocado to set
     */
    public void setJuriProvocado(Integer juriProvocado) {
        this.juriProvocado = juriProvocado;
    }

    /**
     * @return the juriCumprido
     */
    public Integer getJuriCumprido() {
        return juriCumprido;
    }

    /**
     * @param juriCumprido the juriCumprido to set
     */
    public void setJuriCumprido(Integer juriCumprido) {
        this.juriCumprido = juriCumprido;
    }

    /**
     * @return the liberdadeProvisoriaRequerida
     */
    public Integer getLiberdadeProvisoriaRequerida() {
        return liberdadeProvisoriaRequerida;
    }

    /**
     * @param liberdadeProvisoriaRequerida the liberdadeProvisoriaRequerida to set
     */
    public void setLiberdadeProvisoriaRequerida(Integer liberdadeProvisoriaRequerida) {
        this.liberdadeProvisoriaRequerida = liberdadeProvisoriaRequerida;
    }

    /**
     * @return the liberdadeProvisoriaDeferida
     */
    public Integer getLiberdadeProvisoriaDeferida() {
        return liberdadeProvisoriaDeferida;
    }

    /**
     * @param liberdadeProvisoriaDeferida the liberdadeProvisoriaDeferida to set
     */
    public void setLiberdadeProvisoriaDeferida(Integer liberdadeProvisoriaDeferida) {
        this.liberdadeProvisoriaDeferida = liberdadeProvisoriaDeferida;
    }

    /**
     * @return the indultosRequeridos
     */
    public Integer getIndultosRequeridos() {
        return indultosRequeridos;
    }

    /**
     * @param indultosRequeridos the indultosRequeridos to set
     */
    public void setIndultosRequeridos(Integer indultosRequeridos) {
        this.indultosRequeridos = indultosRequeridos;
    }

    /**
     * @return the indultosDeferidos
     */
    public Integer getIndultosDeferidos() {
        return indultosDeferidos;
    }

    /**
     * @param indultosDeferidos the indultosDeferidos to set
     */
    public void setIndultosDeferidos(Integer indultosDeferidos) {
        this.indultosDeferidos = indultosDeferidos;
    }

    /**
     * @return the remicaoRequerida
     */
    public Integer getRemicaoRequerida() {
        return remicaoRequerida;
    }

    /**
     * @param remicaoRequerida the remicaoRequerida to set
     */
    public void setRemicaoRequerida(Integer remicaoRequerida) {
        this.remicaoRequerida = remicaoRequerida;
    }

    /**
     * @return the remicaoDeferida
     */
    public Integer getRemicaoDeferida() {
        return remicaoDeferida;
    }

    /**
     * @param remicaoDeferida the remicaoDeferida to set
     */
    public void setRemicaoDeferida(Integer remicaoDeferida) {
        this.remicaoDeferida = remicaoDeferida;
    }

    /**
     * @return the condicionalRequerida
     */
    public Integer getCondicionalRequerida() {
        return condicionalRequerida;
    }

    /**
     * @param condicionalRequerida the condicionalRequerida to set
     */
    public void setCondicionalRequerida(Integer condicionalRequerida) {
        this.condicionalRequerida = condicionalRequerida;
    }

    /**
     * @return the condicionalDeferida
     */
    public Integer getCondicionalDeferida() {
        return condicionalDeferida;
    }

    /**
     * @param condicionalDeferida the condicionalDeferida to set
     */
    public void setCondicionalDeferida(Integer condicionalDeferida) {
        this.condicionalDeferida = condicionalDeferida;
    }

    /**
     * @return the progressaoRegimeRequerida
     */
    public Integer getProgressaoRegimeRequerida() {
        return progressaoRegimeRequerida;
    }

    /**
     * @param progressaoRegimeRequerida the progressaoRegimeRequerida to set
     */
    public void setProgressaoRegimeRequerida(Integer progressaoRegimeRequerida) {
        this.progressaoRegimeRequerida = progressaoRegimeRequerida;
    }

    /**
     * @return the progressaoRegimeDeferida
     */
    public Integer getProgressaoRegimeDeferida() {
        return progressaoRegimeDeferida;
    }

    /**
     * @param progressaoRegimeDeferida the progressaoRegimeDeferida to set
     */
    public void setProgressaoRegimeDeferida(Integer progressaoRegimeDeferida) {
        this.progressaoRegimeDeferida = progressaoRegimeDeferida;
    }

    /**
     * @return the saidasTemporariasRequerida
     */
    public Integer getSaidasTemporariasRequerida() {
        return saidasTemporariasRequerida;
    }

    /**
     * @param saidasTemporariasRequerida the saidasTemporariasRequerida to set
     */
    public void setSaidasTemporariasRequerida(Integer saidasTemporariasRequerida) {
        this.saidasTemporariasRequerida = saidasTemporariasRequerida;
    }

    /**
     * @return the saidasTemporariasDeferida
     */
    public Integer getSaidasTemporariasDeferida() {
        return saidasTemporariasDeferida;
    }

    /**
     * @param saidasTemporariasDeferida the saidasTemporariasDeferida to set
     */
    public void setSaidasTemporariasDeferida(Integer saidasTemporariasDeferida) {
        this.saidasTemporariasDeferida = saidasTemporariasDeferida;
    }

    /**
     * @return the habeasCorpusRequerido
     */
    public Integer getHabeasCorpusRequerido() {
        return habeasCorpusRequerido;
    }

    /**
     * @param habeasCorpusRequerido the habeasCorpusRequerido to set
     */
    public void setHabeasCorpusRequerido(Integer habeasCorpusRequerido) {
        this.habeasCorpusRequerido = habeasCorpusRequerido;
    }

    /**
     * @return the habeasCorpusDeferido
     */
    public Integer getHabeasCorpusDeferido() {
        return habeasCorpusDeferido;
    }

    /**
     * @param habeasCorpusDeferido the habeasCorpusDeferido to set
     */
    public void setHabeasCorpusDeferido(Integer habeasCorpusDeferido) {
        this.habeasCorpusDeferido = habeasCorpusDeferido;
    }

    /**
     * @return the laudosPsicologicos
     */
    public Integer getLaudosPsicologicos() {
        return laudosPsicologicos;
    }

    /**
     * @param laudosPsicologicos the laudosPsicologicos to set
     */
    public void setLaudosPsicologicos(Integer laudosPsicologicos) {
        this.laudosPsicologicos = laudosPsicologicos;
    }

    /**
     * @return the laudosPsiquiatricos
     */
    public Integer getLaudosPsiquiatricos() {
        return laudosPsiquiatricos;
    }

    /**
     * @param laudosPsiquiatricos the laudosPsiquiatricos to set
     */
    public void setLaudosPsiquiatricos(Integer laudosPsiquiatricos) {
        this.laudosPsiquiatricos = laudosPsiquiatricos;
    }

    /**
     * @return the transferenciaProvimento
     */
    public Integer getTransferenciaProvimento() {
        return transferenciaProvimento;
    }

    /**
     * @param transferenciaProvimento the transferenciaProvimento to set
     */
    public void setTransferenciaProvimento(Integer transferenciaProvimento) {
        this.transferenciaProvimento = transferenciaProvimento;
    }

    /**
     * @return the totalJuridico
     */
    public Integer getTotalJuridico() {
        return totalJuridico;
    }

    /**
     * @param totalJuridico the totalJuridico to set
     */
    public void setTotalJuridico(Integer totalJuridico) {
        this.totalJuridico = totalJuridico;
    }

    /**
     * @return the triagem
     */
    public Integer getTriagem() {
        return triagem;
    }

    /**
     * @param triagem the triagem to set
     */
    public void setTriagem(Integer triagem) {
        this.triagem = triagem;
    }

    /**
     * @return the laborativaRemunerada
     */
    public Integer getLaborativaRemunerada() {
        return laborativaRemunerada;
    }

    /**
     * @param laborativaRemunerada the laborativaRemunerada to set
     */
    public void setLaborativaRemunerada(Integer laborativaRemunerada) {
        this.laborativaRemunerada = laborativaRemunerada;
    }

    /**
     * @return the laborativaNaoRemunerada
     */
    public Integer getLaborativaNaoRemunerada() {
        return laborativaNaoRemunerada;
    }

    /**
     * @param laborativaNaoRemunerada the laborativaNaoRemunerada to set
     */
    public void setLaborativaNaoRemunerada(Integer laborativaNaoRemunerada) {
        this.laborativaNaoRemunerada = laborativaNaoRemunerada;
    }

    /**
     * @return the totalLaboral
     */
    public Integer getTotalLaboral() {
        return totalLaboral;
    }

    /**
     * @param totalLaboral the totalLaboral to set
     */
    public void setTotalLaboral(Integer totalLaboral) {
        this.totalLaboral = totalLaboral;
    }

    /**
     * @return the idAtividadeRecreativa
     */
    public Integer getIdAtividadeRecreativa() {
        return idAtividadeRecreativa;
    }

    /**
     * @param idAtividadeRecreativa the idAtividadeRecreativa to set
     */
    public void setIdAtividadeRecreativa(Integer idAtividadeRecreativa) {
        this.idAtividadeRecreativa = idAtividadeRecreativa;
    }

    /**
     * @return the artesPlasticas
     */
    public Integer getArtesPlasticas() {
        return artesPlasticas;
    }

    /**
     * @param artesPlasticas the artesPlasticas to set
     */
    public void setArtesPlasticas(Integer artesPlasticas) {
        this.artesPlasticas = artesPlasticas;
    }

    /**
     * @return the literatura
     */
    public Integer getLiteratura() {
        return literatura;
    }

    /**
     * @param literatura the literatura to set
     */
    public void setLiteratura(Integer literatura) {
        this.literatura = literatura;
    }

    /**
     * @return the cantoTeatroCinema
     */
    public Integer getCantoTeatroCinema() {
        return cantoTeatroCinema;
    }

    /**
     * @param cantoTeatroCinema the cantoTeatroCinema to set
     */
    public void setCantoTeatroCinema(Integer cantoTeatroCinema) {
        this.cantoTeatroCinema = cantoTeatroCinema;
    }

    /**
     * @return the esportes
     */
    public Integer getEsportes() {
        return esportes;
    }

    /**
     * @param esportes the esportes to set
     */
    public void setEsportes(Integer esportes) {
        this.esportes = esportes;
    }

    /**
     * @return the religiosa
     */
    public Integer getReligiosa() {
        return religiosa;
    }

    /**
     * @param religiosa the religiosa to set
     */
    public void setReligiosa(Integer religiosa) {
        this.religiosa = religiosa;
    }

    /**
     * @return the totalRecreativaReligiosa
     */
    public Integer getTotalRecreativaReligiosa() {
        return totalRecreativaReligiosa;
    }

    /**
     * @param totalRecreativaReligiosa the totalRecreativaReligiosa to set
     */
    public void setTotalRecreativaReligiosa(Integer totalRecreativaReligiosa) {
        this.totalRecreativaReligiosa = totalRecreativaReligiosa;
    }

    /**
     * @return the cafeInterno
     */
    public Integer getCafeInterno() {
        return cafeInterno;
    }

    /**
     * @param cafeInterno the cafeInterno to set
     */
    public void setCafeInterno(Integer cafeInterno) {
        this.cafeInterno = cafeInterno;
    }

    /**
     * @return the almocoInterno
     */
    public Integer getAlmocoInterno() {
        return almocoInterno;
    }

    /**
     * @param almocoInterno the almocoInterno to set
     */
    public void setAlmocoInterno(Integer almocoInterno) {
        this.almocoInterno = almocoInterno;
    }

    /**
     * @return the jantarInterno
     */
    public Integer getJantarInterno() {
        return jantarInterno;
    }

    /**
     * @param jantarInterno the jantarInterno to set
     */
    public void setJantarInterno(Integer jantarInterno) {
        this.jantarInterno = jantarInterno;
    }

    /**
     * @return the total01
     */
    public Integer getTotal01() {
        return total01;
    }

    /**
     * @param total01 the total01 to set
     */
    public void setTotal01(Integer total01) {
        this.total01 = total01;
    }

    /**
     * @return the total02
     */
    public Integer getTotal02() {
        return total02;
    }

    /**
     * @param total02 the total02 to set
     */
    public void setTotal02(Integer total02) {
        this.total02 = total02;
    }

    /**
     * @return the total03
     */
    public Integer getTotal03() {
        return total03;
    }

    /**
     * @param total03 the total03 to set
     */
    public void setTotal03(Integer total03) {
        this.total03 = total03;
    }

    /**
     * @return the total04
     */
    public Integer getTotal04() {
        return total04;
    }

    /**
     * @param total04 the total04 to set
     */
    public void setTotal04(Integer total04) {
        this.total04 = total04;
    }

    /**
     * @return the total05
     */
    public Integer getTotal05() {
        return total05;
    }

    /**
     * @param total05 the total05 to set
     */
    public void setTotal05(Integer total05) {
        this.total05 = total05;
    }

    /**
     * @return the total06
     */
    public Integer getTotal06() {
        return total06;
    }

    /**
     * @param total06 the total06 to set
     */
    public void setTotal06(Integer total06) {
        this.total06 = total06;
    }

    /**
     * @return the total07
     */
    public Integer getTotal07() {
        return total07;
    }

    /**
     * @param total07 the total07 to set
     */
    public void setTotal07(Integer total07) {
        this.total07 = total07;
    }

    /**
     * @return the total08
     */
    public Integer getTotal08() {
        return total08;
    }

    /**
     * @param total08 the total08 to set
     */
    public void setTotal08(Integer total08) {
        this.total08 = total08;
    }

    /**
     * @return the total09
     */
    public Integer getTotal09() {
        return total09;
    }

    /**
     * @param total09 the total09 to set
     */
    public void setTotal09(Integer total09) {
        this.total09 = total09;
    }
}
