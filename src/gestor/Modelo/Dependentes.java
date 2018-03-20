/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author CPLF
 */
public class Dependentes {

    private int idDep;
    private String nomeDep;
    private int idFunc;
    private String nomeColaborador;
    private Date dataNascDep;
    private String parenteDep;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;         

    public Dependentes(int idDep, String nomeDep, int idFunc, String nomeColaborador, Date dataNascDep, String parenteDep, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idDep = idDep;
        this.nomeDep = nomeDep;
        this.idFunc = idFunc;
        this.nomeColaborador = nomeColaborador;
        this.dataNascDep = dataNascDep;
        this.parenteDep = parenteDep;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public Dependentes() {
    }

    /**
     * @return the idDep
     */
    public int getIdDep() {
        return idDep;
    }

    /**
     * @param idDep the idDep to set
     */
    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    /**
     * @return the nomeDep
     */
    public String getNomeDep() {
        return nomeDep;
    }

    /**
     * @param nomeDep the nomeDep to set
     */
    public void setNomeDep(String nomeDep) {
        this.nomeDep = nomeDep;
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
     * @return the dataNascDep
     */
    public Date getDataNascDep() {
        return dataNascDep;
    }

    /**
     * @param dataNascDep the dataNascDep to set
     */
    public void setDataNascDep(Date dataNascDep) {
        this.dataNascDep = dataNascDep;
    }

    /**
     * @return the parenteDep
     */
    public String getParenteDep() {
        return parenteDep;
    }

    /**
     * @param parenteDep the parenteDep to set
     */
    public void setParenteDep(String parenteDep) {
        this.parenteDep = parenteDep;
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
