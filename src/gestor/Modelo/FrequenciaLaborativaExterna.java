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
public class FrequenciaLaborativaExterna {

    private int idFreqLab;
    private String statusFreqLab;
    private Date dataFreqLab;
    private int tipoAtiv;
    private int idEmp;
    private String nomeEmpresa;
    private String observacao;
    private String mesReferencia;
    private int anoReferencia;
    private Date dataInicio;
    private Date dataTermino;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;            

    public FrequenciaLaborativaExterna(int idFreqLab, String statusFreqLab, Date dataFreqLab, int tipoAtiv, int idEmp, String nomeEmpresa, String observacao, String mesReferencia, int anoReferencia, Date dataInicio, Date dataTermino, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idFreqLab = idFreqLab;
        this.statusFreqLab = statusFreqLab;
        this.dataFreqLab = dataFreqLab;
        this.tipoAtiv = tipoAtiv;
        this.idEmp = idEmp;
        this.nomeEmpresa = nomeEmpresa;
        this.observacao = observacao;
        this.mesReferencia = mesReferencia;
        this.anoReferencia = anoReferencia;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public FrequenciaLaborativaExterna() {
    }

    /**
     * @return the idFreqLab
     */
    public int getIdFreqLab() {
        return idFreqLab;
    }

    /**
     * @param idFreqLab the idFreqLab to set
     */
    public void setIdFreqLab(int idFreqLab) {
        this.idFreqLab = idFreqLab;
    }

    /**
     * @return the statusFreqLab
     */
    public String getStatusFreqLab() {
        return statusFreqLab;
    }

    /**
     * @param statusFreqLab the statusFreqLab to set
     */
    public void setStatusFreqLab(String statusFreqLab) {
        this.statusFreqLab = statusFreqLab;
    }

    /**
     * @return the dataFreqLab
     */
    public Date getDataFreqLab() {
        return dataFreqLab;
    }

    /**
     * @param dataFreqLab the dataFreqLab to set
     */
    public void setDataFreqLab(Date dataFreqLab) {
        this.dataFreqLab = dataFreqLab;
    }

    /**
     * @return the tipoAtiv
     */
    public int getTipoAtiv() {
        return tipoAtiv;
    }

    /**
     * @param tipoAtiv the tipoAtiv to set
     */
    public void setTipoAtiv(int tipoAtiv) {
        this.tipoAtiv = tipoAtiv;
    }

    /**
     * @return the idEmp
     */
    public int getIdEmp() {
        return idEmp;
    }

    /**
     * @param idEmp the idEmp to set
     */
    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    /**
     * @return the nomeEmpresa
     */
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    /**
     * @param nomeEmpresa the nomeEmpresa to set
     */
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
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
    public int getAnoReferencia() {
        return anoReferencia;
    }

    /**
     * @param anoReferencia the anoReferencia to set
     */
    public void setAnoReferencia(int anoReferencia) {
        this.anoReferencia = anoReferencia;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataTermino
     */
    public Date getDataTermino() {
        return dataTermino;
    }

    /**
     * @param dataTermino the dataTermino to set
     */
    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
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
