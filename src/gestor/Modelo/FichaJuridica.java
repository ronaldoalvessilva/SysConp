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
public class FichaJuridica {

    private int idFicha;
    private String statusFicha;
    private Date dataFicha;
    private int idInternoCrc;
    private String nomeInterno;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String horarioInsert;
    private String dataUp;
    private String horarioUp;

    public FichaJuridica(int idFicha, String statusFicha, Date dataFicha, int idInternoCrc, String nomeInterno, String usuarioInsert, String usuarioUp, String dataInsert, String horarioInsert, String dataUp, String horarioUp) {
        this.idFicha = idFicha;
        this.statusFicha = statusFicha;
        this.dataFicha = dataFicha;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
    }

    public FichaJuridica() {
    }

    /**
     * @return the idFicha
     */
    public int getIdFicha() {
        return idFicha;
    }

    /**
     * @param idFicha the idFicha to set
     */
    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
    }

    /**
     * @return the statusFicha
     */
    public String getStatusFicha() {
        return statusFicha;
    }

    /**
     * @param statusFicha the statusFicha to set
     */
    public void setStatusFicha(String statusFicha) {
        this.statusFicha = statusFicha;
    }

    /**
     * @return the dataFicha
     */
    public Date getDataFicha() {
        return dataFicha;
    }

    /**
     * @param dataFicha the dataFicha to set
     */
    public void setDataFicha(Date dataFicha) {
        this.dataFicha = dataFicha;
    }

    /**
     * @return the idInternoCrc
     */
    public int getIdInternoCrc() {
        return idInternoCrc;
    }

    /**
     * @param idInternoCrc the idInternoCrc to set
     */
    public void setIdInternoCrc(int idInternoCrc) {
        this.idInternoCrc = idInternoCrc;
    }

    /**
     * @return the nomeInterno
     */
    public String getNomeInterno() {
        return nomeInterno;
    }

    /**
     * @param nomeInterno the nomeInterno to set
     */
    public void setNomeInterno(String nomeInterno) {
        this.nomeInterno = nomeInterno;
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
