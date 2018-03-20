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
public class ItensCancelamentoVisita {

    private int idItemCanExt;
    private Date dataCan;
    private int idCan;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int idVisita;
    private String nomeVisita;
    private Date dataBloqueio;
    private String statusVisitaInterno;
    private String motivoCancela;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;       

    public ItensCancelamentoVisita(int idItemCanExt, Date dataCan, int idCan, int idInternoCrc, String nomeInternoCrc, int idVisita, String nomeVisita, Date dataBloqueio, String statusVisitaInterno, String motivoCancela, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp) {
        this.idItemCanExt = idItemCanExt;
        this.dataCan = dataCan;
        this.idCan = idCan;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idVisita = idVisita;
        this.nomeVisita = nomeVisita;
        this.dataBloqueio = dataBloqueio;
        this.statusVisitaInterno = statusVisitaInterno;
        this.motivoCancela = motivoCancela;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
    }

    public ItensCancelamentoVisita() {
    }

    /**
     * @return the idItemCanExt
     */
    public int getIdItemCanExt() {
        return idItemCanExt;
    }

    /**
     * @param idItemCanExt the idItemCanExt to set
     */
    public void setIdItemCanExt(int idItemCanExt) {
        this.idItemCanExt = idItemCanExt;
    }

    /**
     * @return the dataCan
     */
    public Date getDataCan() {
        return dataCan;
    }

    /**
     * @param dataCan the dataCan to set
     */
    public void setDataCan(Date dataCan) {
        this.dataCan = dataCan;
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
     * @return the statusVisitaInterno
     */
    public String getStatusVisitaInterno() {
        return statusVisitaInterno;
    }

    /**
     * @param statusVisitaInterno the statusVisitaInterno to set
     */
    public void setStatusVisitaInterno(String statusVisitaInterno) {
        this.statusVisitaInterno = statusVisitaInterno;
    }

    /**
     * @return the motivoCancela
     */
    public String getMotivoCancela() {
        return motivoCancela;
    }

    /**
     * @param motivoCancela the motivoCancela to set
     */
    public void setMotivoCancela(String motivoCancela) {
        this.motivoCancela = motivoCancela;
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
