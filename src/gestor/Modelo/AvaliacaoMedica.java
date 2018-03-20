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
public class AvaliacaoMedica {

    private int idAvalia;
    private String statusAval;
    private Date dataAval;
    private int idInternoCrc;
    private String nomeInterno;
    private String textoAvaliacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public AvaliacaoMedica(int idAvalia, String statusAval, Date dataAval, int idInternoCrc, String nomeInterno, String textoAvaliacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idAvalia = idAvalia;
        this.statusAval = statusAval;
        this.dataAval = dataAval;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.textoAvaliacao = textoAvaliacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AvaliacaoMedica() {
    }

    /**
     * @return the idAvalia
     */
    public int getIdAvalia() {
        return idAvalia;
    }

    /**
     * @param idAvalia the idAvalia to set
     */
    public void setIdAvalia(int idAvalia) {
        this.idAvalia = idAvalia;
    }

    /**
     * @return the statusAval
     */
    public String getStatusAval() {
        return statusAval;
    }

    /**
     * @param statusAval the statusAval to set
     */
    public void setStatusAval(String statusAval) {
        this.statusAval = statusAval;
    }

    /**
     * @return the dataAval
     */
    public Date getDataAval() {
        return dataAval;
    }

    /**
     * @param dataAval the dataAval to set
     */
    public void setDataAval(Date dataAval) {
        this.dataAval = dataAval;
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
     * @return the textoAvaliacao
     */
    public String getTextoAvaliacao() {
        return textoAvaliacao;
    }

    /**
     * @param textoAvaliacao the textoAvaliacao to set
     */
    public void setTextoAvaliacao(String textoAvaliacao) {
        this.textoAvaliacao = textoAvaliacao;
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
