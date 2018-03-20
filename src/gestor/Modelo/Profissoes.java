/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author Ronaldo
 */
public class Profissoes {

    private int idCodigo;
    private String statusProf;
    private String descricaoProf;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public Profissoes(int idCodigo, String statusProf, String descricaoProf, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idCodigo = idCodigo;
        this.statusProf = statusProf;
        this.descricaoProf = descricaoProf;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public Profissoes() {
    }

    /**
     * @return the idCodigo
     */
    public int getIdCodigo() {
        return idCodigo;
    }

    /**
     * @param idCodigo the idCodigo to set
     */
    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }

    /**
     * @return the statusProf
     */
    public String getStatusProf() {
        return statusProf;
    }

    /**
     * @param statusProf the statusProf to set
     */
    public void setStatusProf(String statusProf) {
        this.statusProf = statusProf;
    }

    /**
     * @return the descricaoProf
     */
    public String getDescricaoProf() {
        return descricaoProf;
    }

    /**
     * @param descricaoProf the descricaoProf to set
     */
    public void setDescricaoProf(String descricaoProf) {
        this.descricaoProf = descricaoProf;
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
