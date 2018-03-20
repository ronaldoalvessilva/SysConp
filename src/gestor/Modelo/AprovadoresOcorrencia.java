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
public class AprovadoresOcorrencia {

    private int idAprova;
    private String statusAprova;
    private Date dataAprova;
    private int idFunc;
    private String nomeColaborador;
    private String observacao;
    private int modDep;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public AprovadoresOcorrencia(int idAprova, String statusAprova, Date dataAprova, int idFunc, String nomeColaborador, String observacao, int modDep, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idAprova = idAprova;
        this.statusAprova = statusAprova;
        this.dataAprova = dataAprova;
        this.idFunc = idFunc;
        this.nomeColaborador = nomeColaborador;
        this.observacao = observacao;
        this.modDep = modDep;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AprovadoresOcorrencia() {
    }

    /**
     * @return the idAprova
     */
    public int getIdAprova() {
        return idAprova;
    }

    /**
     * @param idAprova the idAprova to set
     */
    public void setIdAprova(int idAprova) {
        this.idAprova = idAprova;
    }

    /**
     * @return the statusAprova
     */
    public String getStatusAprova() {
        return statusAprova;
    }

    /**
     * @param statusAprova the statusAprova to set
     */
    public void setStatusAprova(String statusAprova) {
        this.statusAprova = statusAprova;
    }

    /**
     * @return the dataAprova
     */
    public Date getDataAprova() {
        return dataAprova;
    }

    /**
     * @param dataAprova the dataAprova to set
     */
    public void setDataAprova(Date dataAprova) {
        this.dataAprova = dataAprova;
    }

    /**
     * @return the idFunc
     */
    public int getIdFunc() {
        return idFunc;
    }

    /**
     * @param idFunc the idFunc to set
     */
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    /**
     * @return the nomeColaborador
     */
    public String getNomeColaborador() {
        return nomeColaborador;
    }

    /**
     * @param nomeColaborador the nomeColaborador to set
     */
    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
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
     * @return the modDep
     */
    public int getModDep() {
        return modDep;
    }

    /**
     * @param modDep the modDep to set
     */
    public void setModDep(int modDep) {
        this.modDep = modDep;
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
