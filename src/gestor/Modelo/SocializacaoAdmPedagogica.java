/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author Ronaldo
 */
public class SocializacaoAdmPedagogica {

    private int idSocial;
    private int idAdm;
    private int idInternoCrc;
    private String nomeInternoCrc;
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
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public SocializacaoAdmPedagogica(int idSocial, int idAdm, int idInternoCrc, String nomeInternoCrc, String amigosFacilidade, int introvertido, int afetuoso, int obediente, int resistente, int cooperador, int medroso, int inseguro, int outros, String qualOutros, int idadeEscolar, String familiarPresente, String adaptacao, String repetencias, String antecedentes, String qualProblemaAprendizado, String observacaoSocializacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idSocial = idSocial;
        this.idAdm = idAdm;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
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
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public SocializacaoAdmPedagogica() {
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
