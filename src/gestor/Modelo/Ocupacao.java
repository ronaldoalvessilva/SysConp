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
public class Ocupacao {

    private int idCodigo;
    private String statusOcupa;
    private String descricaoOcupa;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public Ocupacao(int idCodigo, String statusOcupa, String descricaoOcupa, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idCodigo = idCodigo;
        this.statusOcupa = statusOcupa;
        this.descricaoOcupa = descricaoOcupa;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public Ocupacao() {
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
     * @return the statusOcupa
     */
    public String getStatusOcupa() {
        return statusOcupa;
    }

    /**
     * @param statusOcupa the statusOcupa to set
     */
    public void setStatusOcupa(String statusOcupa) {
        this.statusOcupa = statusOcupa;
    }

    /**
     * @return the descricaoOcupa
     */
    public String getDescricaoOcupa() {
        return descricaoOcupa;
    }

    /**
     * @param descricaoOcupa the descricaoOcupa to set
     */
    public void setDescricaoOcupa(String descricaoOcupa) {
        this.descricaoOcupa = descricaoOcupa;
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
