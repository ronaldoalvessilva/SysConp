/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronaldo.silva7
 */
public class GrupoArmasEPIs {

    private Integer idGrupArma;
    private Integer idGrupEPI;
    private String descricaoArma;
    private String descricaoEPI;
    private Date dataCadastro;
    private String statusArmaEPI;
    private String obsercacao;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;

    public GrupoArmasEPIs() {
    }

    public GrupoArmasEPIs(Integer idGrupArma, Integer idGrupEPI, String descricaoArma, String descricaoEPI, Date dataCadastro, String statusArmaEPI, String obsercacao, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp) {
        this.idGrupArma = idGrupArma;
        this.idGrupEPI = idGrupEPI;
        this.descricaoArma = descricaoArma;
        this.descricaoEPI = descricaoEPI;
        this.dataCadastro = dataCadastro;
        this.statusArmaEPI = statusArmaEPI;
        this.obsercacao = obsercacao;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idGrupArma
     */
    public Integer getIdGrupArma() {
        return idGrupArma;
    }

    /**
     * @param idGrupArma the idGrupArma to set
     */
    public void setIdGrupArma(Integer idGrupArma) {
        this.idGrupArma = idGrupArma;
    }

    /**
     * @return the idGrupEPI
     */
    public Integer getIdGrupEPI() {
        return idGrupEPI;
    }

    /**
     * @param idGrupEPI the idGrupEPI to set
     */
    public void setIdGrupEPI(Integer idGrupEPI) {
        this.idGrupEPI = idGrupEPI;
    }

    /**
     * @return the descricaoArma
     */
    public String getDescricaoArma() {
        return descricaoArma;
    }

    /**
     * @param descricaoArma the descricaoArma to set
     */
    public void setDescricaoArma(String descricaoArma) {
        this.descricaoArma = descricaoArma;
    }

    /**
     * @return the descricaoEPI
     */
    public String getDescricaoEPI() {
        return descricaoEPI;
    }

    /**
     * @param descricaoEPI the descricaoEPI to set
     */
    public void setDescricaoEPI(String descricaoEPI) {
        this.descricaoEPI = descricaoEPI;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the statusArmaEPI
     */
    public String getStatusArmaEPI() {
        return statusArmaEPI;
    }

    /**
     * @param statusArmaEPI the statusArmaEPI to set
     */
    public void setStatusArmaEPI(String statusArmaEPI) {
        this.statusArmaEPI = statusArmaEPI;
    }

    /**
     * @return the obsercacao
     */
    public String getObsercacao() {
        return obsercacao;
    }

    /**
     * @param obsercacao the obsercacao to set
     */
    public void setObsercacao(String obsercacao) {
        this.obsercacao = obsercacao;
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
