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
public class EscalFolgas {
    private Integer IdRegistro;
    private String statusEscala;
    private Date dataCadastro;
    private Integer quantidadeTrab;
    private Integer quantidadeFolga;
    private String descricaoEscala;
    private String turno;
    private String turma;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;

    public EscalFolgas() {
    }

    public EscalFolgas(Integer IdRegistro, String statusEscala, Date dataCadastro, Integer quantidadeTrab, Integer quantidadeFolga, String descricaoEscala, String turno, String turma, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp) {
        this.IdRegistro = IdRegistro;
        this.statusEscala = statusEscala;
        this.dataCadastro = dataCadastro;
        this.quantidadeTrab = quantidadeTrab;
        this.quantidadeFolga = quantidadeFolga;
        this.descricaoEscala = descricaoEscala;
        this.turno = turno;
        this.turma = turma;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the IdRegistro
     */
    public Integer getIdRegistro() {
        return IdRegistro;
    }

    /**
     * @param IdRegistro the IdRegistro to set
     */
    public void setIdRegistro(Integer IdRegistro) {
        this.IdRegistro = IdRegistro;
    }

    /**
     * @return the statusEscala
     */
    public String getStatusEscala() {
        return statusEscala;
    }

    /**
     * @param statusEscala the statusEscala to set
     */
    public void setStatusEscala(String statusEscala) {
        this.statusEscala = statusEscala;
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
     * @return the quantidadeTrab
     */
    public Integer getQuantidadeTrab() {
        return quantidadeTrab;
    }

    /**
     * @param quantidadeTrab the quantidadeTrab to set
     */
    public void setQuantidadeTrab(Integer quantidadeTrab) {
        this.quantidadeTrab = quantidadeTrab;
    }

    /**
     * @return the quantidadeFolga
     */
    public Integer getQuantidadeFolga() {
        return quantidadeFolga;
    }

    /**
     * @param quantidadeFolga the quantidadeFolga to set
     */
    public void setQuantidadeFolga(Integer quantidadeFolga) {
        this.quantidadeFolga = quantidadeFolga;
    }

    /**
     * @return the descricaoEscala
     */
    public String getDescricaoEscala() {
        return descricaoEscala;
    }

    /**
     * @param descricaoEscala the descricaoEscala to set
     */
    public void setDescricaoEscala(String descricaoEscala) {
        this.descricaoEscala = descricaoEscala;
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
     * @return the turma
     */
    public String getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(String turma) {
        this.turma = turma;
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
