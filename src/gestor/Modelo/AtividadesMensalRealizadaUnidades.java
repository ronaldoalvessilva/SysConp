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
    private Integer idFunc;
    private String colaboradorResponsavel;
    private String matricula;
    private String departamento;
    private String observacao;
    //ABA ASSI
    private Integer atendimentoPsiPreso;    
    private Integer atendimentoPsiFamilaPreso;
    private Integer numeroDiasVisitas;
    private Integer numeroVistantesInternos;
    private Date dataAtendimento;
    private Date dataEntradaVisita;
    private Date dataSaidaVisita;
    private String tipoAtendimento;
    private float mediaVisitasDia;
    private float mediaVisitasInterno;
    private Integer numeroCriancasVisitas;
    private Integer presoIdentCivil;
    private Integer presoAtiviReligiosa;
    private Date dataMatricula;
    private Date dataFrequencia;
    //ASI
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
    //AMI
    private String aparelhoBarbear;
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
    //SEG
    private Date DataProcedimento;
    private Integer quantidadeCelular;
    private Integer quantidadeObjetos;
    private Integer quantidadeProcedCelas;

    public AtividadesMensalRealizadaUnidades() {
    }

    public AtividadesMensalRealizadaUnidades(Integer chave, String status, Date dataCriacao, Date dataAtualizacao, String mes, Integer ano, Integer idUnidade, String unidadePrisional, Integer mediaPopulacao, Integer quantidadeTotalPopulacao, Date dataPeriodoInicial, Date dataPeriodoFinal, Integer idFunc, String colaboradorResponsavel, String matricula, String departamento, String observacao, Integer atendimentoPsiPreso, Integer atendimentoPsiFamilaPreso, Integer numeroDiasVisitas, Integer numeroVistantesInternos, Date dataAtendimento, Date dataEntradaVisita, Date dataSaidaVisita, String tipoAtendimento, float mediaVisitasDia, float mediaVisitasInterno, Integer numeroCriancasVisitas, Integer presoIdentCivil, Integer presoAtiviReligiosa, Date dataMatricula, Date dataFrequencia, Date dataAgravo, Integer vdrl, Integer hepatiteB, Integer hepatiteC, Integer hiv, Integer sifilis, Integer hpv, Integer diabetes, Integer hipertensao, Integer tuberculose, Integer hanseniase, Integer escabiose, Integer dst, Integer quantidadeAgravosTotal, Integer quantidadeAdmInfectoTotal, Integer quantidadeEvoInfectoTotal, String aparelhoBarbear, Integer absorvente, Integer bermuda, Integer caneca, Integer camisa, Integer cobertor, Integer colchao, Integer colher, Integer cueca, Integer cremeDental, Integer desodorante, Integer escova, Integer lencol, Integer papelHigienico, Integer parChinelos, Integer pote, Integer sabaoPo, Integer sabonete, Integer toalha, Integer uniformeCompleto, Date DataProcedimento, Integer quantidadeCelular, Integer quantidadeObjetos, Integer quantidadeProcedCelas) {
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
        this.idFunc = idFunc;
        this.colaboradorResponsavel = colaboradorResponsavel;
        this.matricula = matricula;
        this.departamento = departamento;
        this.observacao = observacao;
        this.atendimentoPsiPreso = atendimentoPsiPreso;
        this.atendimentoPsiFamilaPreso = atendimentoPsiFamilaPreso;
        this.numeroDiasVisitas = numeroDiasVisitas;
        this.numeroVistantesInternos = numeroVistantesInternos;
        this.dataAtendimento = dataAtendimento;
        this.dataEntradaVisita = dataEntradaVisita;
        this.dataSaidaVisita = dataSaidaVisita;
        this.tipoAtendimento = tipoAtendimento;
        this.mediaVisitasDia = mediaVisitasDia;
        this.mediaVisitasInterno = mediaVisitasInterno;
        this.numeroCriancasVisitas = numeroCriancasVisitas;
        this.presoIdentCivil = presoIdentCivil;
        this.presoAtiviReligiosa = presoAtiviReligiosa;
        this.dataMatricula = dataMatricula;
        this.dataFrequencia = dataFrequencia;
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
        this.DataProcedimento = DataProcedimento;
        this.quantidadeCelular = quantidadeCelular;
        this.quantidadeObjetos = quantidadeObjetos;
        this.quantidadeProcedCelas = quantidadeProcedCelas;
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
     * @return the mediaVisitasDia
     */
    public float getMediaVisitasDia() {
        return mediaVisitasDia;
    }

    /**
     * @param mediaVisitasDia the mediaVisitasDia to set
     */
    public void setMediaVisitasDia(float mediaVisitasDia) {
        this.mediaVisitasDia = mediaVisitasDia;
    }

    /**
     * @return the mediaVisitasInterno
     */
    public float getMediaVisitasInterno() {
        return mediaVisitasInterno;
    }

    /**
     * @param mediaVisitasInterno the mediaVisitasInterno to set
     */
    public void setMediaVisitasInterno(float mediaVisitasInterno) {
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
     * @return the aparelhoBarbear
     */
    public String getAparelhoBarbear() {
        return aparelhoBarbear;
    }

    /**
     * @param aparelhoBarbear the aparelhoBarbear to set
     */
    public void setAparelhoBarbear(String aparelhoBarbear) {
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
}
