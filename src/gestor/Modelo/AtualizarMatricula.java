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
public class AtualizarMatricula {

    private int idAtual;
    private String statusAtual;
    private Date dataRegistro;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int idMat;
    private String statusAluno;
    private String situacaoAluno;
    private Date dataAvaliacao;
    private float avaliacao;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public AtualizarMatricula() {
    }

    public AtualizarMatricula(int idAtual, String statusAtual, Date dataRegistro, int idInternoCrc, String nomeInternoCrc, int idMat, String statusAluno, String situacaoAluno, Date dataAvaliacao, float avaliacao, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idAtual = idAtual;
        this.statusAtual = statusAtual;
        this.dataRegistro = dataRegistro;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idMat = idMat;
        this.statusAluno = statusAluno;
        this.situacaoAluno = situacaoAluno;
        this.dataAvaliacao = dataAvaliacao;
        this.avaliacao = avaliacao;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idAtual
     */
    public int getIdAtual() {
        return idAtual;
    }

    /**
     * @param idAtual the idAtual to set
     */
    public void setIdAtual(int idAtual) {
        this.idAtual = idAtual;
    }

    /**
     * @return the statusAtual
     */
    public String getStatusAtual() {
        return statusAtual;
    }

    /**
     * @param statusAtual the statusAtual to set
     */
    public void setStatusAtual(String statusAtual) {
        this.statusAtual = statusAtual;
    }

    /**
     * @return the dataRegistro
     */
    public Date getDataRegistro() {
        return dataRegistro;
    }

    /**
     * @param dataRegistro the dataRegistro to set
     */
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
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
     * @return the dataAvaliacao
     */
    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    /**
     * @param dataAvaliacao the dataAvaliacao to set
     */
    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    /**
     * @return the avaliacao
     */
    public float getAvaliacao() {
        return avaliacao;
    }

    /**
     * @param avaliacao the avaliacao to set
     */
    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
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
}
