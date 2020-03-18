/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Socializa TI 02
 */
public class AdmissaoPedagogicaNova {

    private int idAdm;
    private String statusAdm;
    private Date dataAdm;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String ultimaEscola;
    private String serieAno;
    private String turno;
    private String observacao;
    private String deptoPedagogia;
    private int idFam;
    private String relacaoPai;
    private String relacaoMae;
    private String irmaos;
    private String paisLerEscrever;
    private String paisSeparados;
    private String religiao;
    private int idadeAndou;
    private int idadeFalou;
    private String dificuldadeFala;
    private String qualDificuldadeFala;
    private String comunicacao;
    private String relacionamento;
    private String lider;
    private String repetiuAno;
    private String porqueRepetiuAno;
    private String problemaProfessor;
    private String qualProblemaProfessor;
    private String comoAtitudeSala;
    private String faltaEscola;
    private String porqueFaltaEscola;
    private String achaEscola;
    private int idSocial;
    private String amigosFacilidade;
    private int introvertido;
    private int afetuoso;
    private int obediente;
    private int resistente;
    private int cooperador;
    private int medroso;
    private int inseguro;
    private int outros;
    private String qualOutros;
    private int idadeEscolar;
    private String familiarPresente;
    private String adaptacao;
    private String repetencias;
    private String antecedentes;
    private String qualProblemaAprendizado;
    private String observacaoSocializacao;
    private int idFemAdm;
    private String filhoDesejado;
    private String queriaEngravidar;
    private String foiAcidental;
    private String perturbou;
    private String comoFoiGestacao;
    private String comoFoiParto;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public AdmissaoPedagogicaNova() {
    }

    public AdmissaoPedagogicaNova(int idAdm, String statusAdm, Date dataAdm, int idInternoCrc, String nomeInternoCrc, String ultimaEscola, String serieAno, String turno, String observacao, String deptoPedagogia, int idFam, String relacaoPai, String relacaoMae, String irmaos, String paisLerEscrever, String paisSeparados, String religiao, int idadeAndou, int idadeFalou, String dificuldadeFala, String qualDificuldadeFala, String comunicacao, String relacionamento, String lider, String repetiuAno, String porqueRepetiuAno, String problemaProfessor, String qualProblemaProfessor, String comoAtitudeSala, String faltaEscola, String porqueFaltaEscola, String achaEscola, int idSocial, String amigosFacilidade, int introvertido, int afetuoso, int obediente, int resistente, int cooperador, int medroso, int inseguro, int outros, String qualOutros, int idadeEscolar, String familiarPresente, String adaptacao, String repetencias, String antecedentes, String qualProblemaAprendizado, String observacaoSocializacao, int idFemAdm, String filhoDesejado, String queriaEngravidar, String foiAcidental, String perturbou, String comoFoiGestacao, String comoFoiParto, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idAdm = idAdm;
        this.statusAdm = statusAdm;
        this.dataAdm = dataAdm;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.ultimaEscola = ultimaEscola;
        this.serieAno = serieAno;
        this.turno = turno;
        this.observacao = observacao;
        this.deptoPedagogia = deptoPedagogia;
        this.idFam = idFam;
        this.relacaoPai = relacaoPai;
        this.relacaoMae = relacaoMae;
        this.irmaos = irmaos;
        this.paisLerEscrever = paisLerEscrever;
        this.paisSeparados = paisSeparados;
        this.religiao = religiao;
        this.idadeAndou = idadeAndou;
        this.idadeFalou = idadeFalou;
        this.dificuldadeFala = dificuldadeFala;
        this.qualDificuldadeFala = qualDificuldadeFala;
        this.comunicacao = comunicacao;
        this.relacionamento = relacionamento;
        this.lider = lider;
        this.repetiuAno = repetiuAno;
        this.porqueRepetiuAno = porqueRepetiuAno;
        this.problemaProfessor = problemaProfessor;
        this.qualProblemaProfessor = qualProblemaProfessor;
        this.comoAtitudeSala = comoAtitudeSala;
        this.faltaEscola = faltaEscola;
        this.porqueFaltaEscola = porqueFaltaEscola;
        this.achaEscola = achaEscola;
        this.idSocial = idSocial;
        this.amigosFacilidade = amigosFacilidade;
        this.introvertido = introvertido;
        this.afetuoso = afetuoso;
        this.obediente = obediente;
        this.resistente = resistente;
        this.cooperador = cooperador;
        this.medroso = medroso;
        this.inseguro = inseguro;
        this.outros = outros;
        this.qualOutros = qualOutros;
        this.idadeEscolar = idadeEscolar;
        this.familiarPresente = familiarPresente;
        this.adaptacao = adaptacao;
        this.repetencias = repetencias;
        this.antecedentes = antecedentes;
        this.qualProblemaAprendizado = qualProblemaAprendizado;
        this.observacaoSocializacao = observacaoSocializacao;
        this.idFemAdm = idFemAdm;
        this.filhoDesejado = filhoDesejado;
        this.queriaEngravidar = queriaEngravidar;
        this.foiAcidental = foiAcidental;
        this.perturbou = perturbou;
        this.comoFoiGestacao = comoFoiGestacao;
        this.comoFoiParto = comoFoiParto;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idAdm
     */
    public int getIdAdm() {
        return idAdm;
    }

    /**
     * @param idAdm the idAdm to set
     */
    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
    }

    /**
     * @return the statusAdm
     */
    public String getStatusAdm() {
        return statusAdm;
    }

    /**
     * @param statusAdm the statusAdm to set
     */
    public void setStatusAdm(String statusAdm) {
        this.statusAdm = statusAdm;
    }

    /**
     * @return the dataAdm
     */
    public Date getDataAdm() {
        return dataAdm;
    }

    /**
     * @param dataAdm the dataAdm to set
     */
    public void setDataAdm(Date dataAdm) {
        this.dataAdm = dataAdm;
    }

    /**
     * @return the idInternoCrc
     */
    public int getIdInternoCrc() {
        return idInternoCrc;
    }

    /**
     * @param idInternoCrc the idInternoCrc to set
     */
    public void setIdInternoCrc(int idInternoCrc) {
        this.idInternoCrc = idInternoCrc;
    }

    /**
     * @return the nomeInternoCrc
     */
    public String getNomeInternoCrc() {
        return nomeInternoCrc;
    }

    /**
     * @param nomeInternoCrc the nomeInternoCrc to set
     */
    public void setNomeInternoCrc(String nomeInternoCrc) {
        this.nomeInternoCrc = nomeInternoCrc;
    }

    /**
     * @return the ultimaEscola
     */
    public String getUltimaEscola() {
        return ultimaEscola;
    }

    /**
     * @param ultimaEscola the ultimaEscola to set
     */
    public void setUltimaEscola(String ultimaEscola) {
        this.ultimaEscola = ultimaEscola;
    }

    /**
     * @return the serieAno
     */
    public String getSerieAno() {
        return serieAno;
    }

    /**
     * @param serieAno the serieAno to set
     */
    public void setSerieAno(String serieAno) {
        this.serieAno = serieAno;
    }

    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
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
     * @return the deptoPedagogia
     */
    public String getDeptoPedagogia() {
        return deptoPedagogia;
    }

    /**
     * @param deptoPedagogia the deptoPedagogia to set
     */
    public void setDeptoPedagogia(String deptoPedagogia) {
        this.deptoPedagogia = deptoPedagogia;
    }

    /**
     * @return the idFam
     */
    public int getIdFam() {
        return idFam;
    }

    /**
     * @param idFam the idFam to set
     */
    public void setIdFam(int idFam) {
        this.idFam = idFam;
    }

    /**
     * @return the relacaoPai
     */
    public String getRelacaoPai() {
        return relacaoPai;
    }

    /**
     * @param relacaoPai the relacaoPai to set
     */
    public void setRelacaoPai(String relacaoPai) {
        this.relacaoPai = relacaoPai;
    }

    /**
     * @return the relacaoMae
     */
    public String getRelacaoMae() {
        return relacaoMae;
    }

    /**
     * @param relacaoMae the relacaoMae to set
     */
    public void setRelacaoMae(String relacaoMae) {
        this.relacaoMae = relacaoMae;
    }

    /**
     * @return the irmaos
     */
    public String getIrmaos() {
        return irmaos;
    }

    /**
     * @param irmaos the irmaos to set
     */
    public void setIrmaos(String irmaos) {
        this.irmaos = irmaos;
    }

    /**
     * @return the paisLerEscrever
     */
    public String getPaisLerEscrever() {
        return paisLerEscrever;
    }

    /**
     * @param paisLerEscrever the paisLerEscrever to set
     */
    public void setPaisLerEscrever(String paisLerEscrever) {
        this.paisLerEscrever = paisLerEscrever;
    }

    /**
     * @return the paisSeparados
     */
    public String getPaisSeparados() {
        return paisSeparados;
    }

    /**
     * @param paisSeparados the paisSeparados to set
     */
    public void setPaisSeparados(String paisSeparados) {
        this.paisSeparados = paisSeparados;
    }

    /**
     * @return the religiao
     */
    public String getReligiao() {
        return religiao;
    }

    /**
     * @param religiao the religiao to set
     */
    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }

    /**
     * @return the idadeAndou
     */
    public int getIdadeAndou() {
        return idadeAndou;
    }

    /**
     * @param idadeAndou the idadeAndou to set
     */
    public void setIdadeAndou(int idadeAndou) {
        this.idadeAndou = idadeAndou;
    }

    /**
     * @return the idadeFalou
     */
    public int getIdadeFalou() {
        return idadeFalou;
    }

    /**
     * @param idadeFalou the idadeFalou to set
     */
    public void setIdadeFalou(int idadeFalou) {
        this.idadeFalou = idadeFalou;
    }

    /**
     * @return the dificuldadeFala
     */
    public String getDificuldadeFala() {
        return dificuldadeFala;
    }

    /**
     * @param dificuldadeFala the dificuldadeFala to set
     */
    public void setDificuldadeFala(String dificuldadeFala) {
        this.dificuldadeFala = dificuldadeFala;
    }

    /**
     * @return the qualDificuldadeFala
     */
    public String getQualDificuldadeFala() {
        return qualDificuldadeFala;
    }

    /**
     * @param qualDificuldadeFala the qualDificuldadeFala to set
     */
    public void setQualDificuldadeFala(String qualDificuldadeFala) {
        this.qualDificuldadeFala = qualDificuldadeFala;
    }

    /**
     * @return the comunicacao
     */
    public String getComunicacao() {
        return comunicacao;
    }

    /**
     * @param comunicacao the comunicacao to set
     */
    public void setComunicacao(String comunicacao) {
        this.comunicacao = comunicacao;
    }

    /**
     * @return the relacionamento
     */
    public String getRelacionamento() {
        return relacionamento;
    }

    /**
     * @param relacionamento the relacionamento to set
     */
    public void setRelacionamento(String relacionamento) {
        this.relacionamento = relacionamento;
    }

    /**
     * @return the lider
     */
    public String getLider() {
        return lider;
    }

    /**
     * @param lider the lider to set
     */
    public void setLider(String lider) {
        this.lider = lider;
    }

    /**
     * @return the repetiuAno
     */
    public String getRepetiuAno() {
        return repetiuAno;
    }

    /**
     * @param repetiuAno the repetiuAno to set
     */
    public void setRepetiuAno(String repetiuAno) {
        this.repetiuAno = repetiuAno;
    }

    /**
     * @return the porqueRepetiuAno
     */
    public String getPorqueRepetiuAno() {
        return porqueRepetiuAno;
    }

    /**
     * @param porqueRepetiuAno the porqueRepetiuAno to set
     */
    public void setPorqueRepetiuAno(String porqueRepetiuAno) {
        this.porqueRepetiuAno = porqueRepetiuAno;
    }

    /**
     * @return the problemaProfessor
     */
    public String getProblemaProfessor() {
        return problemaProfessor;
    }

    /**
     * @param problemaProfessor the problemaProfessor to set
     */
    public void setProblemaProfessor(String problemaProfessor) {
        this.problemaProfessor = problemaProfessor;
    }

    /**
     * @return the qualProblemaProfessor
     */
    public String getQualProblemaProfessor() {
        return qualProblemaProfessor;
    }

    /**
     * @param qualProblemaProfessor the qualProblemaProfessor to set
     */
    public void setQualProblemaProfessor(String qualProblemaProfessor) {
        this.qualProblemaProfessor = qualProblemaProfessor;
    }

    /**
     * @return the comoAtitudeSala
     */
    public String getComoAtitudeSala() {
        return comoAtitudeSala;
    }

    /**
     * @param comoAtitudeSala the comoAtitudeSala to set
     */
    public void setComoAtitudeSala(String comoAtitudeSala) {
        this.comoAtitudeSala = comoAtitudeSala;
    }

    /**
     * @return the faltaEscola
     */
    public String getFaltaEscola() {
        return faltaEscola;
    }

    /**
     * @param faltaEscola the faltaEscola to set
     */
    public void setFaltaEscola(String faltaEscola) {
        this.faltaEscola = faltaEscola;
    }

    /**
     * @return the porqueFaltaEscola
     */
    public String getPorqueFaltaEscola() {
        return porqueFaltaEscola;
    }

    /**
     * @param porqueFaltaEscola the porqueFaltaEscola to set
     */
    public void setPorqueFaltaEscola(String porqueFaltaEscola) {
        this.porqueFaltaEscola = porqueFaltaEscola;
    }

    /**
     * @return the achaEscola
     */
    public String getAchaEscola() {
        return achaEscola;
    }

    /**
     * @param achaEscola the achaEscola to set
     */
    public void setAchaEscola(String achaEscola) {
        this.achaEscola = achaEscola;
    }

    /**
     * @return the idSocial
     */
    public int getIdSocial() {
        return idSocial;
    }

    /**
     * @param idSocial the idSocial to set
     */
    public void setIdSocial(int idSocial) {
        this.idSocial = idSocial;
    }

    /**
     * @return the amigosFacilidade
     */
    public String getAmigosFacilidade() {
        return amigosFacilidade;
    }

    /**
     * @param amigosFacilidade the amigosFacilidade to set
     */
    public void setAmigosFacilidade(String amigosFacilidade) {
        this.amigosFacilidade = amigosFacilidade;
    }

    /**
     * @return the introvertido
     */
    public int getIntrovertido() {
        return introvertido;
    }

    /**
     * @param introvertido the introvertido to set
     */
    public void setIntrovertido(int introvertido) {
        this.introvertido = introvertido;
    }

    /**
     * @return the afetuoso
     */
    public int getAfetuoso() {
        return afetuoso;
    }

    /**
     * @param afetuoso the afetuoso to set
     */
    public void setAfetuoso(int afetuoso) {
        this.afetuoso = afetuoso;
    }

    /**
     * @return the obediente
     */
    public int getObediente() {
        return obediente;
    }

    /**
     * @param obediente the obediente to set
     */
    public void setObediente(int obediente) {
        this.obediente = obediente;
    }

    /**
     * @return the resistente
     */
    public int getResistente() {
        return resistente;
    }

    /**
     * @param resistente the resistente to set
     */
    public void setResistente(int resistente) {
        this.resistente = resistente;
    }

    /**
     * @return the cooperador
     */
    public int getCooperador() {
        return cooperador;
    }

    /**
     * @param cooperador the cooperador to set
     */
    public void setCooperador(int cooperador) {
        this.cooperador = cooperador;
    }

    /**
     * @return the medroso
     */
    public int getMedroso() {
        return medroso;
    }

    /**
     * @param medroso the medroso to set
     */
    public void setMedroso(int medroso) {
        this.medroso = medroso;
    }

    /**
     * @return the inseguro
     */
    public int getInseguro() {
        return inseguro;
    }

    /**
     * @param inseguro the inseguro to set
     */
    public void setInseguro(int inseguro) {
        this.inseguro = inseguro;
    }

    /**
     * @return the outros
     */
    public int getOutros() {
        return outros;
    }

    /**
     * @param outros the outros to set
     */
    public void setOutros(int outros) {
        this.outros = outros;
    }

    /**
     * @return the qualOutros
     */
    public String getQualOutros() {
        return qualOutros;
    }

    /**
     * @param qualOutros the qualOutros to set
     */
    public void setQualOutros(String qualOutros) {
        this.qualOutros = qualOutros;
    }

    /**
     * @return the idadeEscolar
     */
    public int getIdadeEscolar() {
        return idadeEscolar;
    }

    /**
     * @param idadeEscolar the idadeEscolar to set
     */
    public void setIdadeEscolar(int idadeEscolar) {
        this.idadeEscolar = idadeEscolar;
    }

    /**
     * @return the familiarPresente
     */
    public String getFamiliarPresente() {
        return familiarPresente;
    }

    /**
     * @param familiarPresente the familiarPresente to set
     */
    public void setFamiliarPresente(String familiarPresente) {
        this.familiarPresente = familiarPresente;
    }

    /**
     * @return the adaptacao
     */
    public String getAdaptacao() {
        return adaptacao;
    }

    /**
     * @param adaptacao the adaptacao to set
     */
    public void setAdaptacao(String adaptacao) {
        this.adaptacao = adaptacao;
    }

    /**
     * @return the repetencias
     */
    public String getRepetencias() {
        return repetencias;
    }

    /**
     * @param repetencias the repetencias to set
     */
    public void setRepetencias(String repetencias) {
        this.repetencias = repetencias;
    }

    /**
     * @return the antecedentes
     */
    public String getAntecedentes() {
        return antecedentes;
    }

    /**
     * @param antecedentes the antecedentes to set
     */
    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    /**
     * @return the qualProblemaAprendizado
     */
    public String getQualProblemaAprendizado() {
        return qualProblemaAprendizado;
    }

    /**
     * @param qualProblemaAprendizado the qualProblemaAprendizado to set
     */
    public void setQualProblemaAprendizado(String qualProblemaAprendizado) {
        this.qualProblemaAprendizado = qualProblemaAprendizado;
    }

    /**
     * @return the observacaoSocializacao
     */
    public String getObservacaoSocializacao() {
        return observacaoSocializacao;
    }

    /**
     * @param observacaoSocializacao the observacaoSocializacao to set
     */
    public void setObservacaoSocializacao(String observacaoSocializacao) {
        this.observacaoSocializacao = observacaoSocializacao;
    }

    /**
     * @return the idFemAdm
     */
    public int getIdFemAdm() {
        return idFemAdm;
    }

    /**
     * @param idFemAdm the idFemAdm to set
     */
    public void setIdFemAdm(int idFemAdm) {
        this.idFemAdm = idFemAdm;
    }

    /**
     * @return the filhoDesejado
     */
    public String getFilhoDesejado() {
        return filhoDesejado;
    }

    /**
     * @param filhoDesejado the filhoDesejado to set
     */
    public void setFilhoDesejado(String filhoDesejado) {
        this.filhoDesejado = filhoDesejado;
    }

    /**
     * @return the queriaEngravidar
     */
    public String getQueriaEngravidar() {
        return queriaEngravidar;
    }

    /**
     * @param queriaEngravidar the queriaEngravidar to set
     */
    public void setQueriaEngravidar(String queriaEngravidar) {
        this.queriaEngravidar = queriaEngravidar;
    }

    /**
     * @return the foiAcidental
     */
    public String getFoiAcidental() {
        return foiAcidental;
    }

    /**
     * @param foiAcidental the foiAcidental to set
     */
    public void setFoiAcidental(String foiAcidental) {
        this.foiAcidental = foiAcidental;
    }

    /**
     * @return the perturbou
     */
    public String getPerturbou() {
        return perturbou;
    }

    /**
     * @param perturbou the perturbou to set
     */
    public void setPerturbou(String perturbou) {
        this.perturbou = perturbou;
    }

    /**
     * @return the comoFoiGestacao
     */
    public String getComoFoiGestacao() {
        return comoFoiGestacao;
    }

    /**
     * @param comoFoiGestacao the comoFoiGestacao to set
     */
    public void setComoFoiGestacao(String comoFoiGestacao) {
        this.comoFoiGestacao = comoFoiGestacao;
    }

    /**
     * @return the comoFoiParto
     */
    public String getComoFoiParto() {
        return comoFoiParto;
    }

    /**
     * @param comoFoiParto the comoFoiParto to set
     */
    public void setComoFoiParto(String comoFoiParto) {
        this.comoFoiParto = comoFoiParto;
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
}
