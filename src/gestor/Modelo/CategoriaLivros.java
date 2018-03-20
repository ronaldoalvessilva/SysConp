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
public class CategoriaLivros {

    private int idCat;
    private String statusCat;
    private String tipoCategoria;
    private Date dataCat;
    private String descricaoCategoria;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public CategoriaLivros(int idCat, String statusCat, String tipoCategoria, Date dataCat, String descricaoCategoria, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idCat = idCat;
        this.statusCat = statusCat;
        this.tipoCategoria = tipoCategoria;
        this.dataCat = dataCat;
        this.descricaoCategoria = descricaoCategoria;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public CategoriaLivros() {
    }

    /**
     * @return the idCat
     */
    public int getIdCat() {
        return idCat;
    }

    /**
     * @param idCat the idCat to set
     */
    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    /**
     * @return the statusCat
     */
    public String getStatusCat() {
        return statusCat;
    }

    /**
     * @param statusCat the statusCat to set
     */
    public void setStatusCat(String statusCat) {
        this.statusCat = statusCat;
    }

    /**
     * @return the tipoCategoria
     */
    public String getTipoCategoria() {
        return tipoCategoria;
    }

    /**
     * @param tipoCategoria the tipoCategoria to set
     */
    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    /**
     * @return the dataCat
     */
    public Date getDataCat() {
        return dataCat;
    }

    /**
     * @param dataCat the dataCat to set
     */
    public void setDataCat(Date dataCat) {
        this.dataCat = dataCat;
    }

    /**
     * @return the descricaoCategoria
     */
    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    /**
     * @param descricaoCategoria the descricaoCategoria to set
     */
    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
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
