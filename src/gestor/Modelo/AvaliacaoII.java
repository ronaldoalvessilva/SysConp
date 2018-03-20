/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Ronaldo
 */
public class AvaliacaoII {

    private int idAvaliaII;
    private int idLanc;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String organizoTempo;
    private String mantenhoPapeis;
    private String souRotina;
    private String consigoOutros;
    private String tenhoSocial;
    private String planejoAgir;
    private String concentroTrabalho;
    private String identificoProblemas;
    private String identificoSolucaoProblemas;
    private String quandoAgir;
    private String consigoHigiene;
    private String consigoCotidianas;
    private String consigoFinancas;
    private String consigoCasa;
    private String sintoPreciso;
    private String costumoFrequentar;
    private Date dataAplicacao;
    private String responsavelAplicacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public AvaliacaoII(int idAvaliaII, int idLanc, int idInternoCrc, String nomeInternoCrc, String organizoTempo, String mantenhoPapeis, String souRotina, String consigoOutros, String tenhoSocial, String planejoAgir, String concentroTrabalho, String identificoProblemas, String identificoSolucaoProblemas, String quandoAgir, String consigoHigiene, String consigoCotidianas, String consigoFinancas, String consigoCasa, String sintoPreciso, String costumoFrequentar, Date dataAplicacao, String responsavelAplicacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idAvaliaII = idAvaliaII;
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.organizoTempo = organizoTempo;
        this.mantenhoPapeis = mantenhoPapeis;
        this.souRotina = souRotina;
        this.consigoOutros = consigoOutros;
        this.tenhoSocial = tenhoSocial;
        this.planejoAgir = planejoAgir;
        this.concentroTrabalho = concentroTrabalho;
        this.identificoProblemas = identificoProblemas;
        this.identificoSolucaoProblemas = identificoSolucaoProblemas;
        this.quandoAgir = quandoAgir;
        this.consigoHigiene = consigoHigiene;
        this.consigoCotidianas = consigoCotidianas;
        this.consigoFinancas = consigoFinancas;
        this.consigoCasa = consigoCasa;
        this.sintoPreciso = sintoPreciso;
        this.costumoFrequentar = costumoFrequentar;
        this.dataAplicacao = dataAplicacao;
        this.responsavelAplicacao = responsavelAplicacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AvaliacaoII() {
    }

    /**
     * @return the idAvaliaII
     */
    public int getIdAvaliaII() {
        return idAvaliaII;
    }

    /**
     * @param idAvaliaII the idAvaliaII to set
     */
    public void setIdAvaliaII(int idAvaliaII) {
        this.idAvaliaII = idAvaliaII;
    }

    /**
     * @return the idLanc
     */
    public int getIdLanc() {
        return idLanc;
    }

    /**
     * @param idLanc the idLanc to set
     */
    public void setIdLanc(int idLanc) {
        this.idLanc = idLanc;
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
     * @return the organizoTempo
     */
    public String getOrganizoTempo() {
        return organizoTempo;
    }

    /**
     * @param organizoTempo the organizoTempo to set
     */
    public void setOrganizoTempo(String organizoTempo) {
        this.organizoTempo = organizoTempo;
    }

    /**
     * @return the mantenhoPapeis
     */
    public String getMantenhoPapeis() {
        return mantenhoPapeis;
    }

    /**
     * @param mantenhoPapeis the mantenhoPapeis to set
     */
    public void setMantenhoPapeis(String mantenhoPapeis) {
        this.mantenhoPapeis = mantenhoPapeis;
    }

    /**
     * @return the souRotina
     */
    public String getSouRotina() {
        return souRotina;
    }

    /**
     * @param souRotina the souRotina to set
     */
    public void setSouRotina(String souRotina) {
        this.souRotina = souRotina;
    }

    /**
     * @return the consigoOutros
     */
    public String getConsigoOutros() {
        return consigoOutros;
    }

    /**
     * @param consigoOutros the consigoOutros to set
     */
    public void setConsigoOutros(String consigoOutros) {
        this.consigoOutros = consigoOutros;
    }

    /**
     * @return the tenhoSocial
     */
    public String getTenhoSocial() {
        return tenhoSocial;
    }

    /**
     * @param tenhoSocial the tenhoSocial to set
     */
    public void setTenhoSocial(String tenhoSocial) {
        this.tenhoSocial = tenhoSocial;
    }

    /**
     * @return the planejoAgir
     */
    public String getPlanejoAgir() {
        return planejoAgir;
    }

    /**
     * @param planejoAgir the planejoAgir to set
     */
    public void setPlanejoAgir(String planejoAgir) {
        this.planejoAgir = planejoAgir;
    }

    /**
     * @return the concentroTrabalho
     */
    public String getConcentroTrabalho() {
        return concentroTrabalho;
    }

    /**
     * @param concentroTrabalho the concentroTrabalho to set
     */
    public void setConcentroTrabalho(String concentroTrabalho) {
        this.concentroTrabalho = concentroTrabalho;
    }

    /**
     * @return the identificoProblemas
     */
    public String getIdentificoProblemas() {
        return identificoProblemas;
    }

    /**
     * @param identificoProblemas the identificoProblemas to set
     */
    public void setIdentificoProblemas(String identificoProblemas) {
        this.identificoProblemas = identificoProblemas;
    }

    /**
     * @return the identificoSolucaoProblemas
     */
    public String getIdentificoSolucaoProblemas() {
        return identificoSolucaoProblemas;
    }

    /**
     * @param identificoSolucaoProblemas the identificoSolucaoProblemas to set
     */
    public void setIdentificoSolucaoProblemas(String identificoSolucaoProblemas) {
        this.identificoSolucaoProblemas = identificoSolucaoProblemas;
    }

    /**
     * @return the quandoAgir
     */
    public String getQuandoAgir() {
        return quandoAgir;
    }

    /**
     * @param quandoAgir the quandoAgir to set
     */
    public void setQuandoAgir(String quandoAgir) {
        this.quandoAgir = quandoAgir;
    }

    /**
     * @return the consigoHigiene
     */
    public String getConsigoHigiene() {
        return consigoHigiene;
    }

    /**
     * @param consigoHigiene the consigoHigiene to set
     */
    public void setConsigoHigiene(String consigoHigiene) {
        this.consigoHigiene = consigoHigiene;
    }

    /**
     * @return the consigoCotidianas
     */
    public String getConsigoCotidianas() {
        return consigoCotidianas;
    }

    /**
     * @param consigoCotidianas the consigoCotidianas to set
     */
    public void setConsigoCotidianas(String consigoCotidianas) {
        this.consigoCotidianas = consigoCotidianas;
    }

    /**
     * @return the consigoFinancas
     */
    public String getConsigoFinancas() {
        return consigoFinancas;
    }

    /**
     * @param consigoFinancas the consigoFinancas to set
     */
    public void setConsigoFinancas(String consigoFinancas) {
        this.consigoFinancas = consigoFinancas;
    }

    /**
     * @return the consigoCasa
     */
    public String getConsigoCasa() {
        return consigoCasa;
    }

    /**
     * @param consigoCasa the consigoCasa to set
     */
    public void setConsigoCasa(String consigoCasa) {
        this.consigoCasa = consigoCasa;
    }

    /**
     * @return the sintoPreciso
     */
    public String getSintoPreciso() {
        return sintoPreciso;
    }

    /**
     * @param sintoPreciso the sintoPreciso to set
     */
    public void setSintoPreciso(String sintoPreciso) {
        this.sintoPreciso = sintoPreciso;
    }

    /**
     * @return the costumoFrequentar
     */
    public String getCostumoFrequentar() {
        return costumoFrequentar;
    }

    /**
     * @param costumoFrequentar the costumoFrequentar to set
     */
    public void setCostumoFrequentar(String costumoFrequentar) {
        this.costumoFrequentar = costumoFrequentar;
    }

    /**
     * @return the dataAplicacao
     */
    public Date getDataAplicacao() {
        return dataAplicacao;
    }

    /**
     * @param dataAplicacao the dataAplicacao to set
     */
    public void setDataAplicacao(Date dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    /**
     * @return the responsavelAplicacao
     */
    public String getResponsavelAplicacao() {
        return responsavelAplicacao;
    }

    /**
     * @param responsavelAplicacao the responsavelAplicacao to set
     */
    public void setResponsavelAplicacao(String responsavelAplicacao) {
        this.responsavelAplicacao = responsavelAplicacao;
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
