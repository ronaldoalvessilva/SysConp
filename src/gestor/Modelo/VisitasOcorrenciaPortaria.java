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
public class VisitasOcorrenciaPortaria {

    private int idItem;
    private int idReg;
    private int idVisita;
    private String nomeVisita;
    private int IdInternoCrc;
    private String nomeVisitaInterna;
    private String statusVisitaRol;
    private int bloqueioLiberacao;
    private int tipoBloqueio;
    private Date dataBloq;
    private Date dataBloq1;
    private Date dataLib;
    private Date dataAprovaSocial;
    private String confirmar;
    private String indisciplina;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;                           

    public VisitasOcorrenciaPortaria(int idItem, int idReg, int idVisita, String nomeVisita, int IdInternoCrc, String nomeVisitaInterna, String statusVisitaRol, int bloqueioLiberacao, int tipoBloqueio, Date dataBloq, Date dataBloq1, Date dataLib, Date dataAprovaSocial, String confirmar, String indisciplina, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.idReg = idReg;
        this.idVisita = idVisita;
        this.nomeVisita = nomeVisita;
        this.IdInternoCrc = IdInternoCrc;
        this.nomeVisitaInterna = nomeVisitaInterna;
        this.statusVisitaRol = statusVisitaRol;
        this.bloqueioLiberacao = bloqueioLiberacao;
        this.tipoBloqueio = tipoBloqueio;
        this.dataBloq = dataBloq;
        this.dataBloq1 = dataBloq1;
        this.dataLib = dataLib;
        this.dataAprovaSocial = dataAprovaSocial;
        this.confirmar = confirmar;
        this.indisciplina = indisciplina;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public VisitasOcorrenciaPortaria() {
    }

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the idReg
     */
    public int getIdReg() {
        return idReg;
    }

    /**
     * @param idReg the idReg to set
     */
    public void setIdReg(int idReg) {
        this.idReg = idReg;
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
     * @return the IdInternoCrc
     */
    public int getIdInternoCrc() {
        return IdInternoCrc;
    }

    /**
     * @param IdInternoCrc the IdInternoCrc to set
     */
    public void setIdInternoCrc(int IdInternoCrc) {
        this.IdInternoCrc = IdInternoCrc;
    }

    /**
     * @return the nomeVisitaInterna
     */
    public String getNomeVisitaInterna() {
        return nomeVisitaInterna;
    }

    /**
     * @param nomeVisitaInterna the nomeVisitaInterna to set
     */
    public void setNomeVisitaInterna(String nomeVisitaInterna) {
        this.nomeVisitaInterna = nomeVisitaInterna;
    }

    /**
     * @return the statusVisitaRol
     */
    public String getStatusVisitaRol() {
        return statusVisitaRol;
    }

    /**
     * @param statusVisitaRol the statusVisitaRol to set
     */
    public void setStatusVisitaRol(String statusVisitaRol) {
        this.statusVisitaRol = statusVisitaRol;
    }

    /**
     * @return the bloqueioLiberacao
     */
    public int getBloqueioLiberacao() {
        return bloqueioLiberacao;
    }

    /**
     * @param bloqueioLiberacao the bloqueioLiberacao to set
     */
    public void setBloqueioLiberacao(int bloqueioLiberacao) {
        this.bloqueioLiberacao = bloqueioLiberacao;
    }

    /**
     * @return the tipoBloqueio
     */
    public int getTipoBloqueio() {
        return tipoBloqueio;
    }

    /**
     * @param tipoBloqueio the tipoBloqueio to set
     */
    public void setTipoBloqueio(int tipoBloqueio) {
        this.tipoBloqueio = tipoBloqueio;
    }

    /**
     * @return the dataBloq
     */
    public Date getDataBloq() {
        return dataBloq;
    }

    /**
     * @param dataBloq the dataBloq to set
     */
    public void setDataBloq(Date dataBloq) {
        this.dataBloq = dataBloq;
    }

    /**
     * @return the dataBloq1
     */
    public Date getDataBloq1() {
        return dataBloq1;
    }

    /**
     * @param dataBloq1 the dataBloq1 to set
     */
    public void setDataBloq1(Date dataBloq1) {
        this.dataBloq1 = dataBloq1;
    }

    /**
     * @return the dataLib
     */
    public Date getDataLib() {
        return dataLib;
    }

    /**
     * @param dataLib the dataLib to set
     */
    public void setDataLib(Date dataLib) {
        this.dataLib = dataLib;
    }

    /**
     * @return the dataAprovaSocial
     */
    public Date getDataAprovaSocial() {
        return dataAprovaSocial;
    }

    /**
     * @param dataAprovaSocial the dataAprovaSocial to set
     */
    public void setDataAprovaSocial(Date dataAprovaSocial) {
        this.dataAprovaSocial = dataAprovaSocial;
    }

    /**
     * @return the confirmar
     */
    public String getConfirmar() {
        return confirmar;
    }

    /**
     * @param confirmar the confirmar to set
     */
    public void setConfirmar(String confirmar) {
        this.confirmar = confirmar;
    }

    /**
     * @return the indisciplina
     */
    public String getIndisciplina() {
        return indisciplina;
    }

    /**
     * @param indisciplina the indisciplina to set
     */
    public void setIndisciplina(String indisciplina) {
        this.indisciplina = indisciplina;
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
