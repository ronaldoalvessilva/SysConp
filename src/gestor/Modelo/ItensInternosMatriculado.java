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
public class ItensInternosMatriculado {

    private int idItem;
    private int idMat;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String bloqueio;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   
    private String statusAluno;
    private String situacaoAluno;
    private Date dataConclusaoDesistencia;
    private String observacao;   

    public ItensInternosMatriculado() {
    }

    public ItensInternosMatriculado(int idItem, int idMat, int idInternoCrc, String nomeInternoCrc, String bloqueio, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String statusAluno, String situacaoAluno, Date dataConclusaoDesistencia, String observacao) {
        this.idItem = idItem;
        this.idMat = idMat;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.bloqueio = bloqueio;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.statusAluno = statusAluno;
        this.situacaoAluno = situacaoAluno;
        this.dataConclusaoDesistencia = dataConclusaoDesistencia;
        this.observacao = observacao;
    }

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the idMat
     */
    public int getIdMat() {
        return idMat;
    }

    /**
     * @param idMat the idMat to set
     */
    public void setIdMat(int idMat) {
        this.idMat = idMat;
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
     * @return the bloqueio
     */
    public String getBloqueio() {
        return bloqueio;
    }

    /**
     * @param bloqueio the bloqueio to set
     */
    public void setBloqueio(String bloqueio) {
        this.bloqueio = bloqueio;
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
     * @return the statusAluno
     */
    public String getStatusAluno() {
        return statusAluno;
    }

    /**
     * @param statusAluno the statusAluno to set
     */
    public void setStatusAluno(String statusAluno) {
        this.statusAluno = statusAluno;
    }

    /**
     * @return the situacaoAluno
     */
    public String getSituacaoAluno() {
        return situacaoAluno;
    }

    /**
     * @param situacaoAluno the situacaoAluno to set
     */
    public void setSituacaoAluno(String situacaoAluno) {
        this.situacaoAluno = situacaoAluno;
    }

    /**
     * @return the dataConclusaoDesistencia
     */
    public Date getDataConclusaoDesistencia() {
        return dataConclusaoDesistencia;
    }

    /**
     * @param dataConclusaoDesistencia the dataConclusaoDesistencia to set
     */
    public void setDataConclusaoDesistencia(Date dataConclusaoDesistencia) {
        this.dataConclusaoDesistencia = dataConclusaoDesistencia;
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
}
