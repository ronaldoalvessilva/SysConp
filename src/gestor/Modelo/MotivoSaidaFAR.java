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
public class MotivoSaidaFAR {

    private int idMot;
    private String statusMot;
    private Date dataMot;
    private String tituloMotivo;
    private String motivo;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public MotivoSaidaFAR(int idMot, String statusMot, Date dataMot, String tituloMotivo, String motivo, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idMot = idMot;
        this.statusMot = statusMot;
        this.dataMot = dataMot;
        this.tituloMotivo = tituloMotivo;
        this.motivo = motivo;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public MotivoSaidaFAR() {
    }

    /**
     * @return the idMot
     */
    public int getIdMot() {
        return idMot;
    }

    /**
     * @param idMot the idMot to set
     */
    public void setIdMot(int idMot) {
        this.idMot = idMot;
    }

    /**
     * @return the statusMot
     */
    public String getStatusMot() {
        return statusMot;
    }

    /**
     * @param statusMot the statusMot to set
     */
    public void setStatusMot(String statusMot) {
        this.statusMot = statusMot;
    }

    /**
     * @return the dataMot
     */
    public Date getDataMot() {
        return dataMot;
    }

    /**
     * @param dataMot the dataMot to set
     */
    public void setDataMot(Date dataMot) {
        this.dataMot = dataMot;
    }

    /**
     * @return the tituloMotivo
     */
    public String getTituloMotivo() {
        return tituloMotivo;
    }

    /**
     * @param tituloMotivo the tituloMotivo to set
     */
    public void setTituloMotivo(String tituloMotivo) {
        this.tituloMotivo = tituloMotivo;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
