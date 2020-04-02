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
    private Integer populacaoAtual;
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
    //SEG
    private Date DataProcedimento;
    private Integer quantidadeCelular;
    private Integer quantidadeObjetos;
    private Integer quantidadeProcedCelas;

    public AtividadesMensalRealizadaUnidades() {
    }

    public AtividadesMensalRealizadaUnidades(Integer chave, String status, Date dataCriacao, Date dataAtualizacao, String mes, Integer ano, Integer idUnidade, String unidadePrisional, Integer populacaoAtual, Date dataPeriodoInicial, Date dataPeriodoFinal, Integer idFunc, String colaboradorResponsavel, String matricula, String departamento, String observacao, Integer atendimentoPsiPreso, Integer atendimentoPsiFamilaPreso, Integer numeroDiasVisitas, Integer numeroVistantesInternos, Date dataAtendimento, Date dataEntradaVisita, Date dataSaidaVisita, String tipoAtendimento, float mediaVisitasDia, float mediaVisitasInterno, Integer numeroCriancasVisitas, Integer presoIdentCivil, Integer presoAtiviReligiosa, Date dataMatricula, Date dataFrequencia, Date DataProcedimento, Integer quantidadeCelular, Integer quantidadeObjetos, Integer quantidadeProcedCelas) {
        this.chave = chave;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.mes = mes;
        this.ano = ano;
        this.idUnidade = idUnidade;
        this.unidadePrisional = unidadePrisional;
        this.populacaoAtual = populacaoAtual;
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
     * @return the populacaoAtual
     */
    public Integer getPopulacaoAtual() {
        return populacaoAtual;
    }

    /**
     * @param populacaoAtual the populacaoAtual to set
     */
    public void setPopulacaoAtual(Integer populacaoAtual) {
        this.populacaoAtual = populacaoAtual;
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
