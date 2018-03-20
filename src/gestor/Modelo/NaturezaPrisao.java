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
public class NaturezaPrisao {

    private int idNatp;
    private String statusNatp;
    private Date dataNatp;
    private String descricaoNatureza;
    private String textoNatureza;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public NaturezaPrisao(int idNatp, String statusNatp, Date dataNatp, String descricaoNatureza, String textoNatureza, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idNatp = idNatp;
        this.statusNatp = statusNatp;
        this.dataNatp = dataNatp;
        this.descricaoNatureza = descricaoNatureza;
        this.textoNatureza = textoNatureza;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public NaturezaPrisao() {
    }

    /**
     * @return the idNatp
     */
    public int getIdNatp() {
        return idNatp;
    }

    /**
     * @param idNatp the idNatp to set
     */
    public void setIdNatp(int idNatp) {
        this.idNatp = idNatp;
    }

    /**
     * @return the statusNatp
     */
    public String getStatusNatp() {
        return statusNatp;
    }

    /**
     * @param statusNatp the statusNatp to set
     */
    public void setStatusNatp(String statusNatp) {
        this.statusNatp = statusNatp;
    }

    /**
     * @return the dataNatp
     */
    public Date getDataNatp() {
        return dataNatp;
    }

    /**
     * @param dataNatp the dataNatp to set
     */
    public void setDataNatp(Date dataNatp) {
        this.dataNatp = dataNatp;
    }

    /**
     * @return the descricaoNatureza
     */
    public String getDescricaoNatureza() {
        return descricaoNatureza;
    }

    /**
     * @param descricaoNatureza the descricaoNatureza to set
     */
    public void setDescricaoNatureza(String descricaoNatureza) {
        this.descricaoNatureza = descricaoNatureza;
    }

    /**
     * @return the textoNatureza
     */
    public String getTextoNatureza() {
        return textoNatureza;
    }

    /**
     * @param textoNatureza the textoNatureza to set
     */
    public void setTextoNatureza(String textoNatureza) {
        this.textoNatureza = textoNatureza;
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