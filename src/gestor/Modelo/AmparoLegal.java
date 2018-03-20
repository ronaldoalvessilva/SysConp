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
public class AmparoLegal {

    private int idLanc;
    private String statusLanc;
    private Date dataLanc;
    private String descricaoAmparoLegal;
    private String artigo;
    private String paragrafo;
    private String inciso;
    private String alinea;
    private String texto;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public AmparoLegal(int idLanc, String statusLanc, Date dataLanc, String descricaoAmparoLegal, String artigo, String paragrafo, String inciso, String alinea, String texto, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idLanc = idLanc;
        this.statusLanc = statusLanc;
        this.dataLanc = dataLanc;
        this.descricaoAmparoLegal = descricaoAmparoLegal;
        this.artigo = artigo;
        this.paragrafo = paragrafo;
        this.inciso = inciso;
        this.alinea = alinea;
        this.texto = texto;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AmparoLegal() {
    }

    /**
     * @return the idLanc
     */
    public int getIdLanc() {
        return idLanc;
    }

    /**
     * @param idLanc the idLanc to set
     */
    public void setIdLanc(int idLanc) {
        this.idLanc = idLanc;
    }

    /**
     * @return the statusLanc
     */
    public String getStatusLanc() {
        return statusLanc;
    }

    /**
     * @param statusLanc the statusLanc to set
     */
    public void setStatusLanc(String statusLanc) {
        this.statusLanc = statusLanc;
    }

    /**
     * @return the dataLanc
     */
    public Date getDataLanc() {
        return dataLanc;
    }

    /**
     * @param dataLanc the dataLanc to set
     */
    public void setDataLanc(Date dataLanc) {
        this.dataLanc = dataLanc;
    }

    /**
     * @return the descricaoAmparoLegal
     */
    public String getDescricaoAmparoLegal() {
        return descricaoAmparoLegal;
    }

    /**
     * @param descricaoAmparoLegal the descricaoAmparoLegal to set
     */
    public void setDescricaoAmparoLegal(String descricaoAmparoLegal) {
        this.descricaoAmparoLegal = descricaoAmparoLegal;
    }

    /**
     * @return the artigo
     */
    public String getArtigo() {
        return artigo;
    }

    /**
     * @param artigo the artigo to set
     */
    public void setArtigo(String artigo) {
        this.artigo = artigo;
    }

    /**
     * @return the paragrafo
     */
    public String getParagrafo() {
        return paragrafo;
    }

    /**
     * @param paragrafo the paragrafo to set
     */
    public void setParagrafo(String paragrafo) {
        this.paragrafo = paragrafo;
    }

    /**
     * @return the inciso
     */
    public String getInciso() {
        return inciso;
    }

    /**
     * @param inciso the inciso to set
     */
    public void setInciso(String inciso) {
        this.inciso = inciso;
    }

    /**
     * @return the alinea
     */
    public String getAlinea() {
        return alinea;
    }

    /**
     * @param alinea the alinea to set
     */
    public void setAlinea(String alinea) {
        this.alinea = alinea;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
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
