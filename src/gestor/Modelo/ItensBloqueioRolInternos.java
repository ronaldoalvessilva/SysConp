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
public class ItensBloqueioRolInternos {

    private int idItemCanInt;
    private Date dataRolCan;
    private int idCan;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int idVisita;
    private String nomeVisita;
    private Date dataBloqueio;
    private String statusVisita;
    private String motivoBloqueio;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public ItensBloqueioRolInternos(int idItemCanInt, Date dataRolCan, int idCan, int idInternoCrc, String nomeInternoCrc, int idVisita, String nomeVisita, Date dataBloqueio, String statusVisita, String motivoBloqueio, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItemCanInt = idItemCanInt;
        this.dataRolCan = dataRolCan;
        this.idCan = idCan;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idVisita = idVisita;
        this.nomeVisita = nomeVisita;
        this.dataBloqueio = dataBloqueio;
        this.statusVisita = statusVisita;
        this.motivoBloqueio = motivoBloqueio;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensBloqueioRolInternos() {
    }

    /**
     * @return the idItemCanInt
     */
    public int getIdItemCanInt() {
        return idItemCanInt;
    }

    /**
     * @param idItemCanInt the idItemCanInt to set
     */
    public void setIdItemCanInt(int idItemCanInt) {
        this.idItemCanInt = idItemCanInt;
    }

    /**
     * @return the dataRolCan
     */
    public Date getDataRolCan() {
        return dataRolCan;
    }

    /**
     * @param dataRolCan the dataRolCan to set
     */
    public void setDataRolCan(Date dataRolCan) {
        this.dataRolCan = dataRolCan;
    }

    /**
     * @return the idCan
     */
    public int getIdCan() {
        return idCan;
    }

    /**
     * @param idCan the idCan to set
     */
    public void setIdCan(int idCan) {
        this.idCan = idCan;
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
     * @return the nomeInternoCrc
     */
    public String getNomeInternoCrc() {
        return nomeInternoCrc;
    }

    /**
     * @param nomeInternoCrc the nomeInternoCrc to set
     */
    public void setNomeInternoCrc(String nomeInternoCrc) {
        this.nomeInternoCrc = nomeInternoCrc;
    }

    /**
     * @return the idVisita
     */
    public int getIdVisita() {
        return idVisita;
    }

    /**
     * @param idVisita the idVisita to set
     */
    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    /**
     * @return the nomeVisita
     */
    public String getNomeVisita() {
        return nomeVisita;
    }

    /**
     * @param nomeVisita the nomeVisita to set
     */
    public void setNomeVisita(String nomeVisita) {
        this.nomeVisita = nomeVisita;
    }

    /**
     * @return the dataBloqueio
     */
    public Date getDataBloqueio() {
        return dataBloqueio;
    }

    /**
     * @param dataBloqueio the dataBloqueio to set
     */
    public void setDataBloqueio(Date dataBloqueio) {
        this.dataBloqueio = dataBloqueio;
    }

    /**
     * @return the statusVisita
     */
    public String getStatusVisita() {
        return statusVisita;
    }

    /**
     * @param statusVisita the statusVisita to set
     */
    public void setStatusVisita(String statusVisita) {
        this.statusVisita = statusVisita;
    }

    /**
     * @return the motivoBloqueio
     */
    public String getMotivoBloqueio() {
        return motivoBloqueio;
    }

    /**
     * @param motivoBloqueio the motivoBloqueio to set
     */
    public void setMotivoBloqueio(String motivoBloqueio) {
        this.motivoBloqueio = motivoBloqueio;
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
