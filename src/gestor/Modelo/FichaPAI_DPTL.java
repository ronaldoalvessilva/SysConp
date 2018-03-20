/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronaldo.silva7
 */
public class FichaPAI_DPTL {

    private int idDPTL;
    private int idPai;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String profissaoOcupacao;
    private String trabalhaDetido;
    private String desempregado;
    private String carteiraAssinada;
    private int quantoTempoCarteira;
    private Double faixaSalarial;
    private String temBeneficios;
    private String quemTemBeneficios;
    private String demandaReclusao;
    private String demandaDesemprego;
    private String possuiRedimento;
    private String qualRendimento;
    private String exerceAtividade;
    private String qualAtividadeExerce;
    private String geracaoRenda;
    private String aptidaoProfissional;
    private String qualAptidao;
    private String demandaProfissional;
    private String qualDemandaProfissional;
    private String aptidaoArt;
    private String qualAptidaoArt;
    private String demandaLazer;
    private String qualDemandaLazer;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public FichaPAI_DPTL(int idDPTL, int idPai, int idInternoCrc, String nomeInternoCrc, String profissaoOcupacao, String trabalhaDetido, String desempregado, String carteiraAssinada, int quantoTempoCarteira, Double faixaSalarial, String temBeneficios, String quemTemBeneficios, String demandaReclusao, String demandaDesemprego, String possuiRedimento, String qualRendimento, String exerceAtividade, String qualAtividadeExerce, String geracaoRenda, String aptidaoProfissional, String qualAptidao, String demandaProfissional, String qualDemandaProfissional, String aptidaoArt, String qualAptidaoArt, String demandaLazer, String qualDemandaLazer, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idDPTL = idDPTL;
        this.idPai = idPai;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.profissaoOcupacao = profissaoOcupacao;
        this.trabalhaDetido = trabalhaDetido;
        this.desempregado = desempregado;
        this.carteiraAssinada = carteiraAssinada;
        this.quantoTempoCarteira = quantoTempoCarteira;
        this.faixaSalarial = faixaSalarial;
        this.temBeneficios = temBeneficios;
        this.quemTemBeneficios = quemTemBeneficios;
        this.demandaReclusao = demandaReclusao;
        this.demandaDesemprego = demandaDesemprego;
        this.possuiRedimento = possuiRedimento;
        this.qualRendimento = qualRendimento;
        this.exerceAtividade = exerceAtividade;
        this.qualAtividadeExerce = qualAtividadeExerce;
        this.geracaoRenda = geracaoRenda;
        this.aptidaoProfissional = aptidaoProfissional;
        this.qualAptidao = qualAptidao;
        this.demandaProfissional = demandaProfissional;
        this.qualDemandaProfissional = qualDemandaProfissional;
        this.aptidaoArt = aptidaoArt;
        this.qualAptidaoArt = qualAptidaoArt;
        this.demandaLazer = demandaLazer;
        this.qualDemandaLazer = qualDemandaLazer;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public FichaPAI_DPTL() {
    }

    /**
     * @return the idDPTL
     */
    public int getIdDPTL() {
        return idDPTL;
    }

    /**
     * @param idDPTL the idDPTL to set
     */
    public void setIdDPTL(int idDPTL) {
        this.idDPTL = idDPTL;
    }

    /**
     * @return the idPai
     */
    public int getIdPai() {
        return idPai;
    }

    /**
     * @param idPai the idPai to set
     */
    public void setIdPai(int idPai) {
        this.idPai = idPai;
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
     * @return the profissaoOcupacao
     */
    public String getProfissaoOcupacao() {
        return profissaoOcupacao;
    }

    /**
     * @param profissaoOcupacao the profissaoOcupacao to set
     */
    public void setProfissaoOcupacao(String profissaoOcupacao) {
        this.profissaoOcupacao = profissaoOcupacao;
    }

    /**
     * @return the trabalhaDetido
     */
    public String getTrabalhaDetido() {
        return trabalhaDetido;
    }

    /**
     * @param trabalhaDetido the trabalhaDetido to set
     */
    public void setTrabalhaDetido(String trabalhaDetido) {
        this.trabalhaDetido = trabalhaDetido;
    }

    /**
     * @return the desempregado
     */
    public String getDesempregado() {
        return desempregado;
    }

    /**
     * @param desempregado the desempregado to set
     */
    public void setDesempregado(String desempregado) {
        this.desempregado = desempregado;
    }

    /**
     * @return the carteiraAssinada
     */
    public String getCarteiraAssinada() {
        return carteiraAssinada;
    }

    /**
     * @param carteiraAssinada the carteiraAssinada to set
     */
    public void setCarteiraAssinada(String carteiraAssinada) {
        this.carteiraAssinada = carteiraAssinada;
    }

    /**
     * @return the quantoTempoCarteira
     */
    public int getQuantoTempoCarteira() {
        return quantoTempoCarteira;
    }

    /**
     * @param quantoTempoCarteira the quantoTempoCarteira to set
     */
    public void setQuantoTempoCarteira(int quantoTempoCarteira) {
        this.quantoTempoCarteira = quantoTempoCarteira;
    }

    /**
     * @return the faixaSalarial
     */
    public Double getFaixaSalarial() {
        return faixaSalarial;
    }

    /**
     * @param faixaSalarial the faixaSalarial to set
     */
    public void setFaixaSalarial(Double faixaSalarial) {
        this.faixaSalarial = faixaSalarial;
    }

    /**
     * @return the temBeneficios
     */
    public String getTemBeneficios() {
        return temBeneficios;
    }

    /**
     * @param temBeneficios the temBeneficios to set
     */
    public void setTemBeneficios(String temBeneficios) {
        this.temBeneficios = temBeneficios;
    }

    /**
     * @return the quemTemBeneficios
     */
    public String getQuemTemBeneficios() {
        return quemTemBeneficios;
    }

    /**
     * @param quemTemBeneficios the quemTemBeneficios to set
     */
    public void setQuemTemBeneficios(String quemTemBeneficios) {
        this.quemTemBeneficios = quemTemBeneficios;
    }

    /**
     * @return the demandaReclusao
     */
    public String getDemandaReclusao() {
        return demandaReclusao;
    }

    /**
     * @param demandaReclusao the demandaReclusao to set
     */
    public void setDemandaReclusao(String demandaReclusao) {
        this.demandaReclusao = demandaReclusao;
    }

    /**
     * @return the demandaDesemprego
     */
    public String getDemandaDesemprego() {
        return demandaDesemprego;
    }

    /**
     * @param demandaDesemprego the demandaDesemprego to set
     */
    public void setDemandaDesemprego(String demandaDesemprego) {
        this.demandaDesemprego = demandaDesemprego;
    }

    /**
     * @return the possuiRedimento
     */
    public String getPossuiRedimento() {
        return possuiRedimento;
    }

    /**
     * @param possuiRedimento the possuiRedimento to set
     */
    public void setPossuiRedimento(String possuiRedimento) {
        this.possuiRedimento = possuiRedimento;
    }

    /**
     * @return the qualRendimento
     */
    public String getQualRendimento() {
        return qualRendimento;
    }

    /**
     * @param qualRendimento the qualRendimento to set
     */
    public void setQualRendimento(String qualRendimento) {
        this.qualRendimento = qualRendimento;
    }

    /**
     * @return the exerceAtividade
     */
    public String getExerceAtividade() {
        return exerceAtividade;
    }

    /**
     * @param exerceAtividade the exerceAtividade to set
     */
    public void setExerceAtividade(String exerceAtividade) {
        this.exerceAtividade = exerceAtividade;
    }

    /**
     * @return the qualAtividadeExerce
     */
    public String getQualAtividadeExerce() {
        return qualAtividadeExerce;
    }

    /**
     * @param qualAtividadeExerce the qualAtividadeExerce to set
     */
    public void setQualAtividadeExerce(String qualAtividadeExerce) {
        this.qualAtividadeExerce = qualAtividadeExerce;
    }

    /**
     * @return the geracaoRenda
     */
    public String getGeracaoRenda() {
        return geracaoRenda;
    }

    /**
     * @param geracaoRenda the geracaoRenda to set
     */
    public void setGeracaoRenda(String geracaoRenda) {
        this.geracaoRenda = geracaoRenda;
    }

    /**
     * @return the aptidaoProfissional
     */
    public String getAptidaoProfissional() {
        return aptidaoProfissional;
    }

    /**
     * @param aptidaoProfissional the aptidaoProfissional to set
     */
    public void setAptidaoProfissional(String aptidaoProfissional) {
        this.aptidaoProfissional = aptidaoProfissional;
    }

    /**
     * @return the qualAptidao
     */
    public String getQualAptidao() {
        return qualAptidao;
    }

    /**
     * @param qualAptidao the qualAptidao to set
     */
    public void setQualAptidao(String qualAptidao) {
        this.qualAptidao = qualAptidao;
    }

    /**
     * @return the demandaProfissional
     */
    public String getDemandaProfissional() {
        return demandaProfissional;
    }

    /**
     * @param demandaProfissional the demandaProfissional to set
     */
    public void setDemandaProfissional(String demandaProfissional) {
        this.demandaProfissional = demandaProfissional;
    }

    /**
     * @return the qualDemandaProfissional
     */
    public String getQualDemandaProfissional() {
        return qualDemandaProfissional;
    }

    /**
     * @param qualDemandaProfissional the qualDemandaProfissional to set
     */
    public void setQualDemandaProfissional(String qualDemandaProfissional) {
        this.qualDemandaProfissional = qualDemandaProfissional;
    }

    /**
     * @return the aptidaoArt
     */
    public String getAptidaoArt() {
        return aptidaoArt;
    }

    /**
     * @param aptidaoArt the aptidaoArt to set
     */
    public void setAptidaoArt(String aptidaoArt) {
        this.aptidaoArt = aptidaoArt;
    }

    /**
     * @return the qualAptidaoArt
     */
    public String getQualAptidaoArt() {
        return qualAptidaoArt;
    }

    /**
     * @param qualAptidaoArt the qualAptidaoArt to set
     */
    public void setQualAptidaoArt(String qualAptidaoArt) {
        this.qualAptidaoArt = qualAptidaoArt;
    }

    /**
     * @return the demandaLazer
     */
    public String getDemandaLazer() {
        return demandaLazer;
    }

    /**
     * @param demandaLazer the demandaLazer to set
     */
    public void setDemandaLazer(String demandaLazer) {
        this.demandaLazer = demandaLazer;
    }

    /**
     * @return the qualDemandaLazer
     */
    public String getQualDemandaLazer() {
        return qualDemandaLazer;
    }

    /**
     * @param qualDemandaLazer the qualDemandaLazer to set
     */
    public void setQualDemandaLazer(String qualDemandaLazer) {
        this.qualDemandaLazer = qualDemandaLazer;
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
