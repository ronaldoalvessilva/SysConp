/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronaldo
 */
public class EvadidoIndividual {

    private int idLanc;
    private String statusLanc;
    private Date dataLanc;
    private String tipoOperacao;
    private int nrDocSaida;
    private int tipoEvasao;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private String internoEvadido;
    private Date dataEvasao;  
    private int idSaida;       

    public EvadidoIndividual(int idLanc, String statusLanc, Date dataLanc, String tipoOperacao, int nrDocSaida, int tipoEvasao, int idInternoCrc, String nomeInternoCrc, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String internoEvadido, Date dataEvasao, int idSaida) {
        this.idLanc = idLanc;
        this.statusLanc = statusLanc;
        this.dataLanc = dataLanc;
        this.tipoOperacao = tipoOperacao;
        this.nrDocSaida = nrDocSaida;
        this.tipoEvasao = tipoEvasao;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.internoEvadido = internoEvadido;
        this.dataEvasao = dataEvasao;
        this.idSaida = idSaida;
    }

    public EvadidoIndividual() {
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
     * @return the statusLanc
     */
    public String getStatusLanc() {
        return statusLanc;
    }

    /**
     * @param statusLanc the statusLanc to set
     */
    public void setStatusLanc(String statusLanc) {
        this.statusLanc = statusLanc;
    }

    /**
     * @return the dataLanc
     */
    public Date getDataLanc() {
        return dataLanc;
    }

    /**
     * @param dataLanc the dataLanc to set
     */
    public void setDataLanc(Date dataLanc) {
        this.dataLanc = dataLanc;
    }

    /**
     * @return the tipoOperacao
     */
    public String getTipoOperacao() {
        return tipoOperacao;
    }

    /**
     * @param tipoOperacao the tipoOperacao to set
     */
    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    /**
     * @return the nrDocSaida
     */
    public int getNrDocSaida() {
        return nrDocSaida;
    }

    /**
     * @param nrDocSaida the nrDocSaida to set
     */
    public void setNrDocSaida(int nrDocSaida) {
        this.nrDocSaida = nrDocSaida;
    }

    /**
     * @return the tipoEvasao
     */
    public int getTipoEvasao() {
        return tipoEvasao;
    }

    /**
     * @param tipoEvasao the tipoEvasao to set
     */
    public void setTipoEvasao(int tipoEvasao) {
        this.tipoEvasao = tipoEvasao;
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
     * @return the internoEvadido
     */
    public String getInternoEvadido() {
        return internoEvadido;
    }

    /**
     * @param internoEvadido the internoEvadido to set
     */
    public void setInternoEvadido(String internoEvadido) {
        this.internoEvadido = internoEvadido;
    }

    /**
     * @return the dataEvasao
     */
    public Date getDataEvasao() {
        return dataEvasao;
    }

    /**
     * @param dataEvasao the dataEvasao to set
     */
    public void setDataEvasao(Date dataEvasao) {
        this.dataEvasao = dataEvasao;
    }

    /**
     * @return the idSaida
     */
    public int getIdSaida() {
        return idSaida;
    }

    /**
     * @param idSaida the idSaida to set
     */
    public void setIdSaida(int idSaida) {
        this.idSaida = idSaida;
    }
}
