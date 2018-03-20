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
public class TempoFormativo {

    private int idTempo;
    private String statusTempo;
    private Date dataCad;
    private String descricaoTempo;
    private int idTurno;
    private String descricaoTurno;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;   

    public TempoFormativo(int idTempo, String statusTempo, Date dataCad, String descricaoTempo, int idTurno, String descricaoTurno, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp) {
        this.idTempo = idTempo;
        this.statusTempo = statusTempo;
        this.dataCad = dataCad;
        this.descricaoTempo = descricaoTempo;
        this.idTurno = idTurno;
        this.descricaoTurno = descricaoTurno;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public TempoFormativo() {
    }

    /**
     * @return the idTempo
     */
    public int getIdTempo() {
        return idTempo;
    }

    /**
     * @param idTempo the idTempo to set
     */
    public void setIdTempo(int idTempo) {
        this.idTempo = idTempo;
    }

    /**
     * @return the statusTempo
     */
    public String getStatusTempo() {
        return statusTempo;
    }

    /**
     * @param statusTempo the statusTempo to set
     */
    public void setStatusTempo(String statusTempo) {
        this.statusTempo = statusTempo;
    }

    /**
     * @return the dataCad
     */
    public Date getDataCad() {
        return dataCad;
    }

    /**
     * @param dataCad the dataCad to set
     */
    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
    }

    /**
     * @return the descricaoTempo
     */
    public String getDescricaoTempo() {
        return descricaoTempo;
    }

    /**
     * @param descricaoTempo the descricaoTempo to set
     */
    public void setDescricaoTempo(String descricaoTempo) {
        this.descricaoTempo = descricaoTempo;
    }

    /**
     * @return the idTurno
     */
    public int getIdTurno() {
        return idTurno;
    }

    /**
     * @param idTurno the idTurno to set
     */
    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    /**
     * @return the descricaoTurno
     */
    public String getDescricaoTurno() {
        return descricaoTurno;
    }

    /**
     * @param descricaoTurno the descricaoTurno to set
     */
    public void setDescricaoTurno(String descricaoTurno) {
        this.descricaoTurno = descricaoTurno;
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
     * @return the usuarioDelete
     */
    public String getUsuarioDelete() {
        return usuarioDelete;
    }

    /**
     * @param usuarioDelete the usuarioDelete to set
     */
    public void setUsuarioDelete(String usuarioDelete) {
        this.usuarioDelete = usuarioDelete;
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
}
