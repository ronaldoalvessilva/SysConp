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
public class AgendaEscolta {

    private int idAgenda;
    private String statusAgenda;
    private Date dataAgenda;
    private String obsAgenda;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;

    public AgendaEscolta(int idAgenda, String statusAgenda, Date dataAgenda, String obsAgenda, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp) {
        this.idAgenda = idAgenda;
        this.statusAgenda = statusAgenda;
        this.dataAgenda = dataAgenda;
        this.obsAgenda = obsAgenda;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
    }

    public AgendaEscolta() {
    }

    /**
     * @return the idAgenda
     */
    public int getIdAgenda() {
        return idAgenda;
    }

    /**
     * @param idAgenda the idAgenda to set
     */
    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    /**
     * @return the statusAgenda
     */
    public String getStatusAgenda() {
        return statusAgenda;
    }

    /**
     * @param statusAgenda the statusAgenda to set
     */
    public void setStatusAgenda(String statusAgenda) {
        this.statusAgenda = statusAgenda;
    }

    /**
     * @return the dataAgenda
     */
    public Date getDataAgenda() {
        return dataAgenda;
    }

    /**
     * @param dataAgenda the dataAgenda to set
     */
    public void setDataAgenda(Date dataAgenda) {
        this.dataAgenda = dataAgenda;
    }

    /**
     * @return the obsAgenda
     */
    public String getObsAgenda() {
        return obsAgenda;
    }

    /**
     * @param obsAgenda the obsAgenda to set
     */
    public void setObsAgenda(String obsAgenda) {
        this.obsAgenda = obsAgenda;
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
     * @return the horaInsert
     */
    public String getHoraInsert() {
        return horaInsert;
    }

    /**
     * @param horaInsert the horaInsert to set
     */
    public void setHoraInsert(String horaInsert) {
        this.horaInsert = horaInsert;
    }

    /**
     * @return the horaUp
     */
    public String getHoraUp() {
        return horaUp;
    }

    /**
     * @param horaUp the horaUp to set
     */
    public void setHoraUp(String horaUp) {
        this.horaUp = horaUp;
    }
}
