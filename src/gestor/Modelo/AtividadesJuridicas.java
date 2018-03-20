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
public class AtividadesJuridicas {

    private int idAtiv;
    private String statusAtiv;
    private Date dataAtiv;
    private String descricaoAtiv;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;

    public AtividadesJuridicas(int idAtiv, String statusAtiv, Date dataAtiv, String descricaoAtiv, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp) {
        this.idAtiv = idAtiv;
        this.statusAtiv = statusAtiv;
        this.dataAtiv = dataAtiv;
        this.descricaoAtiv = descricaoAtiv;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AtividadesJuridicas() {
    }

    /**
     * @return the idAtiv
     */
    public int getIdAtiv() {
        return idAtiv;
    }

    /**
     * @param idAtiv the idAtiv to set
     */
    public void setIdAtiv(int idAtiv) {
        this.idAtiv = idAtiv;
    }

    /**
     * @return the statusAtiv
     */
    public String getStatusAtiv() {
        return statusAtiv;
    }

    /**
     * @param statusAtiv the statusAtiv to set
     */
    public void setStatusAtiv(String statusAtiv) {
        this.statusAtiv = statusAtiv;
    }

    /**
     * @return the dataAtiv
     */
    public Date getDataAtiv() {
        return dataAtiv;
    }

    /**
     * @param dataAtiv the dataAtiv to set
     */
    public void setDataAtiv(Date dataAtiv) {
        this.dataAtiv = dataAtiv;
    }

    /**
     * @return the descricaoAtiv
     */
    public String getDescricaoAtiv() {
        return descricaoAtiv;
    }

    /**
     * @param descricaoAtiv the descricaoAtiv to set
     */
    public void setDescricaoAtiv(String descricaoAtiv) {
        this.descricaoAtiv = descricaoAtiv;
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
