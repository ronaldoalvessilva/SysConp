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
public class Frequencia {

    private int idFreq;
    private String statusFreq;
    private Date dataFreq;
    private int idMat;    
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String horarioInsert;
    private String dataUp;
    private String horarioUp;          

    public Frequencia(int idFreq, String statusFreq, Date dataFreq, int idMat, String usuarioInsert, String usuarioUp, String dataInsert, String horarioInsert, String dataUp, String horarioUp) {
        this.idFreq = idFreq;
        this.statusFreq = statusFreq;
        this.dataFreq = dataFreq;
        this.idMat = idMat;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
    }

    public Frequencia() {
    }

    /**
     * @return the idFreq
     */
    public int getIdFreq() {
        return idFreq;
    }

    /**
     * @param idFreq the idFreq to set
     */
    public void setIdFreq(int idFreq) {
        this.idFreq = idFreq;
    }

    /**
     * @return the statusFreq
     */
    public String getStatusFreq() {
        return statusFreq;
    }

    /**
     * @param statusFreq the statusFreq to set
     */
    public void setStatusFreq(String statusFreq) {
        this.statusFreq = statusFreq;
    }

    /**
     * @return the dataFreq
     */
    public Date getDataFreq() {
        return dataFreq;
    }

    /**
     * @param dataFreq the dataFreq to set
     */
    public void setDataFreq(Date dataFreq) {
        this.dataFreq = dataFreq;
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
