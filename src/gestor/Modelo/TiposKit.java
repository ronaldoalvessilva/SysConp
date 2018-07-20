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
public class TiposKit {

    private int idKit;
    private String statusKit;
    private Date dataKit;
    private int mostraTodos;
    private int kitInicial;
    private int kitQuinzenal;
    private int kitDecendial;
    private int kitMensal;
    private int kitSemestral;
    private int kitAnual;
    private String observacaoKit;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public TiposKit() {
    }

    public TiposKit(int idKit, String statusKit, Date dataKit, int mostraTodos, int kitInicial, int kitQuinzenal, int kitDecendial, int kitMensal, int kitSemestral, int kitAnual, String observacaoKit, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idKit = idKit;
        this.statusKit = statusKit;
        this.dataKit = dataKit;
        this.mostraTodos = mostraTodos;
        this.kitInicial = kitInicial;
        this.kitQuinzenal = kitQuinzenal;
        this.kitDecendial = kitDecendial;
        this.kitMensal = kitMensal;
        this.kitSemestral = kitSemestral;
        this.kitAnual = kitAnual;
        this.observacaoKit = observacaoKit;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idKit
     */
    public int getIdKit() {
        return idKit;
    }

    /**
     * @param idKit the idKit to set
     */
    public void setIdKit(int idKit) {
        this.idKit = idKit;
    }

    /**
     * @return the statusKit
     */
    public String getStatusKit() {
        return statusKit;
    }

    /**
     * @param statusKit the statusKit to set
     */
    public void setStatusKit(String statusKit) {
        this.statusKit = statusKit;
    }

    /**
     * @return the dataKit
     */
    public Date getDataKit() {
        return dataKit;
    }

    /**
     * @param dataKit the dataKit to set
     */
    public void setDataKit(Date dataKit) {
        this.dataKit = dataKit;
    }

    /**
     * @return the mostraTodos
     */
    public int getMostraTodos() {
        return mostraTodos;
    }

    /**
     * @param mostraTodos the mostraTodos to set
     */
    public void setMostraTodos(int mostraTodos) {
        this.mostraTodos = mostraTodos;
    }

    /**
     * @return the kitInicial
     */
    public int getKitInicial() {
        return kitInicial;
    }

    /**
     * @param kitInicial the kitInicial to set
     */
    public void setKitInicial(int kitInicial) {
        this.kitInicial = kitInicial;
    }

    /**
     * @return the kitQuinzenal
     */
    public int getKitQuinzenal() {
        return kitQuinzenal;
    }

    /**
     * @param kitQuinzenal the kitQuinzenal to set
     */
    public void setKitQuinzenal(int kitQuinzenal) {
        this.kitQuinzenal = kitQuinzenal;
    }

    /**
     * @return the kitDecendial
     */
    public int getKitDecendial() {
        return kitDecendial;
    }

    /**
     * @param kitDecendial the kitDecendial to set
     */
    public void setKitDecendial(int kitDecendial) {
        this.kitDecendial = kitDecendial;
    }

    /**
     * @return the kitMensal
     */
    public int getKitMensal() {
        return kitMensal;
    }

    /**
     * @param kitMensal the kitMensal to set
     */
    public void setKitMensal(int kitMensal) {
        this.kitMensal = kitMensal;
    }

    /**
     * @return the kitSemestral
     */
    public int getKitSemestral() {
        return kitSemestral;
    }

    /**
     * @param kitSemestral the kitSemestral to set
     */
    public void setKitSemestral(int kitSemestral) {
        this.kitSemestral = kitSemestral;
    }

    /**
     * @return the kitAnual
     */
    public int getKitAnual() {
        return kitAnual;
    }

    /**
     * @param kitAnual the kitAnual to set
     */
    public void setKitAnual(int kitAnual) {
        this.kitAnual = kitAnual;
    }

    /**
     * @return the observacaoKit
     */
    public String getObservacaoKit() {
        return observacaoKit;
    }

    /**
     * @param observacaoKit the observacaoKit to set
     */
    public void setObservacaoKit(String observacaoKit) {
        this.observacaoKit = observacaoKit;
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
