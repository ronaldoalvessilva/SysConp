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
public class CursosDiversos {

    private int idCurso;
    private String statusCurso;
    private Date dataCurso;
    private String descricaoCurso;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelet;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;

    public CursosDiversos(int idCurso, String statusCurso, Date dataCurso, String descricaoCurso, String usuarioInsert, String usuarioUp, String usuarioDelet, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp) {
        this.idCurso = idCurso;
        this.statusCurso = statusCurso;
        this.dataCurso = dataCurso;
        this.descricaoCurso = descricaoCurso;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelet = usuarioDelet;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public CursosDiversos() {
    }

    /**
     * @return the idCurso
     */
    public int getIdCurso() {
        return idCurso;
    }

    /**
     * @param idCurso the idCurso to set
     */
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * @return the statusCurso
     */
    public String getStatusCurso() {
        return statusCurso;
    }

    /**
     * @param statusCurso the statusCurso to set
     */
    public void setStatusCurso(String statusCurso) {
        this.statusCurso = statusCurso;
    }

    /**
     * @return the dataCurso
     */
    public Date getDataCurso() {
        return dataCurso;
    }

    /**
     * @param dataCurso the dataCurso to set
     */
    public void setDataCurso(Date dataCurso) {
        this.dataCurso = dataCurso;
    }

    /**
     * @return the descricaoCurso
     */
    public String getDescricaoCurso() {
        return descricaoCurso;
    }

    /**
     * @param descricaoCurso the descricaoCurso to set
     */
    public void setDescricaoCurso(String descricaoCurso) {
        this.descricaoCurso = descricaoCurso;
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
     * @return the usuarioDelet
     */
    public String getUsuarioDelet() {
        return usuarioDelet;
    }

    /**
     * @param usuarioDelet the usuarioDelet to set
     */
    public void setUsuarioDelet(String usuarioDelet) {
        this.usuarioDelet = usuarioDelet;
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
     * @return the dataDelete
     */
    public String getDataDelete() {
        return dataDelete;
    }

    /**
     * @param dataDelete the dataDelete to set
     */
    public void setDataDelete(String dataDelete) {
        this.dataDelete = dataDelete;
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

    @Override
    public String toString() {
        return getDescricaoCurso(); //To change body of generated methods, choose Tools | Templates.
    }    
}
