/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author user
 */
public class ItensRolVisitas {

    private int idItemRol;
    private Date dataRol;
    private int idRol;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int idVisita;
    private String nomeVisita;
    private String parentescoVisita;
    private Date dataInicio;
    private String statusVisitaInterno;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private int idInstituicao;
    private String nomeInstituicao;
    private int domingoVisita;
    private int segundaVisita;
    private int tercaVisita;
    private int quartaVisita;
    private int quintaVisita;
    private int sextaVisita;
    private int sabadoVisita;

    public ItensRolVisitas() {
    }

    public ItensRolVisitas(int idItemRol, Date dataRol, int idRol, int idInternoCrc, String nomeInternoCrc, int idVisita, String nomeVisita, String parentescoVisita, Date dataInicio, String statusVisitaInterno, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, int idInstituicao, String nomeInstituicao, int domingoVisita, int segundaVisita, int tercaVisita, int quartaVisita, int quintaVisita, int sextaVisita, int sabadoVisita) {
        this.idItemRol = idItemRol;
        this.dataRol = dataRol;
        this.idRol = idRol;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idVisita = idVisita;
        this.nomeVisita = nomeVisita;
        this.parentescoVisita = parentescoVisita;
        this.dataInicio = dataInicio;
        this.statusVisitaInterno = statusVisitaInterno;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.idInstituicao = idInstituicao;
        this.nomeInstituicao = nomeInstituicao;
        this.domingoVisita = domingoVisita;
        this.segundaVisita = segundaVisita;
        this.tercaVisita = tercaVisita;
        this.quartaVisita = quartaVisita;
        this.quintaVisita = quintaVisita;
        this.sextaVisita = sextaVisita;
        this.sabadoVisita = sabadoVisita;
    }

    /**
     * @return the idItemRol
     */
    public int getIdItemRol() {
        return idItemRol;
    }

    /**
     * @param idItemRol the idItemRol to set
     */
    public void setIdItemRol(int idItemRol) {
        this.idItemRol = idItemRol;
    }

    /**
     * @return the dataRol
     */
    public Date getDataRol() {
        return dataRol;
    }

    /**
     * @param dataRol the dataRol to set
     */
    public void setDataRol(Date dataRol) {
        this.dataRol = dataRol;
    }

    /**
     * @return the idRol
     */
    public int getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(int idRol) {
        this.idRol = idRol;
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
     * @return the parentescoVisita
     */
    public String getParentescoVisita() {
        return parentescoVisita;
    }

    /**
     * @param parentescoVisita the parentescoVisita to set
     */
    public void setParentescoVisita(String parentescoVisita) {
        this.parentescoVisita = parentescoVisita;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
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

    /**
     * @return the idInstituicao
     */
    public int getIdInstituicao() {
        return idInstituicao;
    }

    /**
     * @param idInstituicao the idInstituicao to set
     */
    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    /**
     * @return the nomeInstituicao
     */
    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    /**
     * @param nomeInstituicao the nomeInstituicao to set
     */
    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    /**
     * @return the domingoVisita
     */
    public int getDomingoVisita() {
        return domingoVisita;
    }

    /**
     * @param domingoVisita the domingoVisita to set
     */
    public void setDomingoVisita(int domingoVisita) {
        this.domingoVisita = domingoVisita;
    }

    /**
     * @return the segundaVisita
     */
    public int getSegundaVisita() {
        return segundaVisita;
    }

    /**
     * @param segundaVisita the segundaVisita to set
     */
    public void setSegundaVisita(int segundaVisita) {
        this.segundaVisita = segundaVisita;
    }

    /**
     * @return the tercaVisita
     */
    public int getTercaVisita() {
        return tercaVisita;
    }

    /**
     * @param tercaVisita the tercaVisita to set
     */
    public void setTercaVisita(int tercaVisita) {
        this.tercaVisita = tercaVisita;
    }

    /**
     * @return the quartaVisita
     */
    public int getQuartaVisita() {
        return quartaVisita;
    }

    /**
     * @param quartaVisita the quartaVisita to set
     */
    public void setQuartaVisita(int quartaVisita) {
        this.quartaVisita = quartaVisita;
    }

    /**
     * @return the quintaVisita
     */
    public int getQuintaVisita() {
        return quintaVisita;
    }

    /**
     * @param quintaVisita the quintaVisita to set
     */
    public void setQuintaVisita(int quintaVisita) {
        this.quintaVisita = quintaVisita;
    }

    /**
     * @return the sextaVisita
     */
    public int getSextaVisita() {
        return sextaVisita;
    }

    /**
     * @param sextaVisita the sextaVisita to set
     */
    public void setSextaVisita(int sextaVisita) {
        this.sextaVisita = sextaVisita;
    }

    /**
     * @return the sabadoVisita
     */
    public int getSabadoVisita() {
        return sabadoVisita;
    }

    /**
     * @param sabadoVisita the sabadoVisita to set
     */
    public void setSabadoVisita(int sabadoVisita) {
        this.sabadoVisita = sabadoVisita;
    }
}
