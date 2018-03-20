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
public class IndicacaoVisitas {

    private int idInd;
    private int idAtend;
    private Date dataInd;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String nomeVisitante;
    private String grauParentesco;
    private String textoArea;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public IndicacaoVisitas(int idInd, int idAtend, Date dataInd, int idInternoCrc, String nomeInternoCrc, String nomeVisitante, String grauParentesco, String textoArea, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idInd = idInd;
        this.idAtend = idAtend;
        this.dataInd = dataInd;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.nomeVisitante = nomeVisitante;
        this.grauParentesco = grauParentesco;
        this.textoArea = textoArea;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public IndicacaoVisitas() {
    }

    /**
     * @return the idInd
     */
    public int getIdInd() {
        return idInd;
    }

    /**
     * @param idInd the idInd to set
     */
    public void setIdInd(int idInd) {
        this.idInd = idInd;
    }

    /**
     * @return the idAtend
     */
    public int getIdAtend() {
        return idAtend;
    }

    /**
     * @param idAtend the idAtend to set
     */
    public void setIdAtend(int idAtend) {
        this.idAtend = idAtend;
    }

    /**
     * @return the dataInd
     */
    public Date getDataInd() {
        return dataInd;
    }

    /**
     * @param dataInd the dataInd to set
     */
    public void setDataInd(Date dataInd) {
        this.dataInd = dataInd;
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
     * @return the nomeVisitante
     */
    public String getNomeVisitante() {
        return nomeVisitante;
    }

    /**
     * @param nomeVisitante the nomeVisitante to set
     */
    public void setNomeVisitante(String nomeVisitante) {
        this.nomeVisitante = nomeVisitante;
    }

    /**
     * @return the grauParentesco
     */
    public String getGrauParentesco() {
        return grauParentesco;
    }

    /**
     * @param grauParentesco the grauParentesco to set
     */
    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    /**
     * @return the textoArea
     */
    public String getTextoArea() {
        return textoArea;
    }

    /**
     * @param textoArea the textoArea to set
     */
    public void setTextoArea(String textoArea) {
        this.textoArea = textoArea;
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
