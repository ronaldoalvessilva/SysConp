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
public class TarefasDiversas {

    private int idTarefa;
    private String statusTarefa;
    private Date dataTarefa;
    private String descricaoTarefa;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;

    public TarefasDiversas(int idTarefa, String statusTarefa, Date dataTarefa, String descricaoTarefa, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp) {
        this.idTarefa = idTarefa;
        this.statusTarefa = statusTarefa;
        this.dataTarefa = dataTarefa;
        this.descricaoTarefa = descricaoTarefa;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public TarefasDiversas() {
    }

    /**
     * @return the idTarefa
     */
    public int getIdTarefa() {
        return idTarefa;
    }

    /**
     * @param idTarefa the idTarefa to set
     */
    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    /**
     * @return the statusTarefa
     */
    public String getStatusTarefa() {
        return statusTarefa;
    }

    /**
     * @param statusTarefa the statusTarefa to set
     */
    public void setStatusTarefa(String statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    /**
     * @return the dataTarefa
     */
    public Date getDataTarefa() {
        return dataTarefa;
    }

    /**
     * @param dataTarefa the dataTarefa to set
     */
    public void setDataTarefa(Date dataTarefa) {
        this.dataTarefa = dataTarefa;
    }

    /**
     * @return the descricaoTarefa
     */
    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    /**
     * @param descricaoTarefa the descricaoTarefa to set
     */
    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
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
