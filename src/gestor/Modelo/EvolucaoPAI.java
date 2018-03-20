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
public class EvolucaoPAI {

    private int idEvolucaoPAI;
    private int idInternoCrc;
    private int idPai;
    private String nomeInternoCrc;
    private Date dataEvolucaoPAI;
    private String textoEvolucaoPAI;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public EvolucaoPAI(int idEvolucaoPAI, int idInternoCrc, int idPai, String nomeInternoCrc, Date dataEvolucaoPAI, String textoEvolucaoPAI, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idEvolucaoPAI = idEvolucaoPAI;
        this.idInternoCrc = idInternoCrc;
        this.idPai = idPai;
        this.nomeInternoCrc = nomeInternoCrc;
        this.dataEvolucaoPAI = dataEvolucaoPAI;
        this.textoEvolucaoPAI = textoEvolucaoPAI;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public EvolucaoPAI() {
    }

    /**
     * @return the idEvolucaoPAI
     */
    public int getIdEvolucaoPAI() {
        return idEvolucaoPAI;
    }

    /**
     * @param idEvolucaoPAI the idEvolucaoPAI to set
     */
    public void setIdEvolucaoPAI(int idEvolucaoPAI) {
        this.idEvolucaoPAI = idEvolucaoPAI;
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
     * @return the idPai
     */
    public int getIdPai() {
        return idPai;
    }

    /**
     * @param idPai the idPai to set
     */
    public void setIdPai(int idPai) {
        this.idPai = idPai;
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
     * @return the dataEvolucaoPAI
     */
    public Date getDataEvolucaoPAI() {
        return dataEvolucaoPAI;
    }

    /**
     * @param dataEvolucaoPAI the dataEvolucaoPAI to set
     */
    public void setDataEvolucaoPAI(Date dataEvolucaoPAI) {
        this.dataEvolucaoPAI = dataEvolucaoPAI;
    }

    /**
     * @return the textoEvolucaoPAI
     */
    public String getTextoEvolucaoPAI() {
        return textoEvolucaoPAI;
    }

    /**
     * @param textoEvolucaoPAI the textoEvolucaoPAI to set
     */
    public void setTextoEvolucaoPAI(String textoEvolucaoPAI) {
        this.textoEvolucaoPAI = textoEvolucaoPAI;
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
