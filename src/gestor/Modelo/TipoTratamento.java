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
public class TipoTratamento {

    private int idTipo;
    private String statusTipo;
    private Date dataTipo;
    private String descricaoTipo;
    private String observacaoTipo;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public TipoTratamento() {
    }

    public TipoTratamento(int idTipo, String statusTipo, Date dataTipo, String descricaoTipo, String observacaoTipo, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idTipo = idTipo;
        this.statusTipo = statusTipo;
        this.dataTipo = dataTipo;
        this.descricaoTipo = descricaoTipo;
        this.observacaoTipo = observacaoTipo;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idTipo
     */
    public int getIdTipo() {
        return idTipo;
    }

    /**
     * @param idTipo the idTipo to set
     */
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    /**
     * @return the statusTipo
     */
    public String getStatusTipo() {
        return statusTipo;
    }

    /**
     * @param statusTipo the statusTipo to set
     */
    public void setStatusTipo(String statusTipo) {
        this.statusTipo = statusTipo;
    }

    /**
     * @return the dataTipo
     */
    public Date getDataTipo() {
        return dataTipo;
    }

    /**
     * @param dataTipo the dataTipo to set
     */
    public void setDataTipo(Date dataTipo) {
        this.dataTipo = dataTipo;
    }

    /**
     * @return the descricaoTipo
     */
    public String getDescricaoTipo() {
        return descricaoTipo;
    }

    /**
     * @param descricaoTipo the descricaoTipo to set
     */
    public void setDescricaoTipo(String descricaoTipo) {
        this.descricaoTipo = descricaoTipo;
    }

    /**
     * @return the observacaoTipo
     */
    public String getObservacaoTipo() {
        return observacaoTipo;
    }

    /**
     * @param observacaoTipo the observacaoTipo to set
     */
    public void setObservacaoTipo(String observacaoTipo) {
        this.observacaoTipo = observacaoTipo;
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
