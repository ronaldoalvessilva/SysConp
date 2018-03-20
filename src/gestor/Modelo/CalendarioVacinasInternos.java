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
public class CalendarioVacinasInternos {

    private int idCart;
    private String statusCart;
    private Date dataCart;
    private int idInternoCrc;
    private String nomeInternoCrcVacina;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public CalendarioVacinasInternos(int idCart, String statusCart, Date dataCart, int idInternoCrc, String nomeInternoCrcVacina, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idCart = idCart;
        this.statusCart = statusCart;
        this.dataCart = dataCart;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrcVacina = nomeInternoCrcVacina;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public CalendarioVacinasInternos() {
    }

    /**
     * @return the idCart
     */
    public int getIdCart() {
        return idCart;
    }

    /**
     * @param idCart the idCart to set
     */
    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    /**
     * @return the statusCart
     */
    public String getStatusCart() {
        return statusCart;
    }

    /**
     * @param statusCart the statusCart to set
     */
    public void setStatusCart(String statusCart) {
        this.statusCart = statusCart;
    }

    /**
     * @return the dataCart
     */
    public Date getDataCart() {
        return dataCart;
    }

    /**
     * @param dataCart the dataCart to set
     */
    public void setDataCart(Date dataCart) {
        this.dataCart = dataCart;
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
     * @return the nomeInternoCrcVacina
     */
    public String getNomeInternoCrcVacina() {
        return nomeInternoCrcVacina;
    }

    /**
     * @param nomeInternoCrcVacina the nomeInternoCrcVacina to set
     */
    public void setNomeInternoCrcVacina(String nomeInternoCrcVacina) {
        this.nomeInternoCrcVacina = nomeInternoCrcVacina;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
