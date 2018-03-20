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
public class IncidenciaPenal {

    private int idInc;
    private int idProc;
    private int idFicha;
    private int idAmparo;
    private String descricaoAmparo;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;  

    public IncidenciaPenal(int idInc, int idProc, int idFicha, int idAmparo, String descricaoAmparo, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idInc = idInc;
        this.idProc = idProc;
        this.idFicha = idFicha;
        this.idAmparo = idAmparo;
        this.descricaoAmparo = descricaoAmparo;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public IncidenciaPenal() {
    }

    /**
     * @return the idInc
     */
    public int getIdInc() {
        return idInc;
    }

    /**
     * @param idInc the idInc to set
     */
    public void setIdInc(int idInc) {
        this.idInc = idInc;
    }

    /**
     * @return the idProc
     */
    public int getIdProc() {
        return idProc;
    }

    /**
     * @param idProc the idProc to set
     */
    public void setIdProc(int idProc) {
        this.idProc = idProc;
    }

    /**
     * @return the idFicha
     */
    public int getIdFicha() {
        return idFicha;
    }

    /**
     * @param idFicha the idFicha to set
     */
    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
    }

    /**
     * @return the idAmparo
     */
    public int getIdAmparo() {
        return idAmparo;
    }

    /**
     * @param idAmparo the idAmparo to set
     */
    public void setIdAmparo(int idAmparo) {
        this.idAmparo = idAmparo;
    }

    /**
     * @return the descricaoAmparo
     */
    public String getDescricaoAmparo() {
        return descricaoAmparo;
    }

    /**
     * @param descricaoAmparo the descricaoAmparo to set
     */
    public void setDescricaoAmparo(String descricaoAmparo) {
        this.descricaoAmparo = descricaoAmparo;
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
