/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronaldo
 */
public class InternosVitimas {

    private int idIntVitima;
    private int idLanc;
    private int idInternoCrcVitima;
    private String nomeInternoVitima;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public InternosVitimas(int idIntVitima, int idLanc, int idInternoCrcVitima, String nomeInternoVitima, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idIntVitima = idIntVitima;
        this.idLanc = idLanc;
        this.idInternoCrcVitima = idInternoCrcVitima;
        this.nomeInternoVitima = nomeInternoVitima;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public InternosVitimas() {
    }

    /**
     * @return the idIntVitima
     */
    public int getIdIntVitima() {
        return idIntVitima;
    }

    /**
     * @param idIntVitima the idIntVitima to set
     */
    public void setIdIntVitima(int idIntVitima) {
        this.idIntVitima = idIntVitima;
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
     * @return the idInternoCrcVitima
     */
    public int getIdInternoCrcVitima() {
        return idInternoCrcVitima;
    }

    /**
     * @param idInternoCrcVitima the idInternoCrcVitima to set
     */
    public void setIdInternoCrcVitima(int idInternoCrcVitima) {
        this.idInternoCrcVitima = idInternoCrcVitima;
    }

    /**
     * @return the nomeInternoVitima
     */
    public String getNomeInternoVitima() {
        return nomeInternoVitima;
    }

    /**
     * @param nomeInternoVitima the nomeInternoVitima to set
     */
    public void setNomeInternoVitima(String nomeInternoVitima) {
        this.nomeInternoVitima = nomeInternoVitima;
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
