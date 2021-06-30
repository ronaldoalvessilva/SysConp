/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author user
 */
public class LocalArmazenamento {

    private int idLocal;
    private String statusLocal;
    private int nivelLocal;
    private String descricaLocal;   
    private String descricaoResumida;
    private String modulo;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;       

    public LocalArmazenamento() {
    }

    public LocalArmazenamento(int idLocal, String statusLocal, int nivelLocal, String descricaLocal, String descricaoResumida, String modulo, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp) {
        this.idLocal = idLocal;
        this.statusLocal = statusLocal;
        this.nivelLocal = nivelLocal;
        this.descricaLocal = descricaLocal;
        this.descricaoResumida = descricaoResumida;
        this.modulo = modulo;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idLocal
     */
    public int getIdLocal() {
        return idLocal;
    }

    /**
     * @param idLocal the idLocal to set
     */
    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    /**
     * @return the statusLocal
     */
    public String getStatusLocal() {
        return statusLocal;
    }

    /**
     * @param statusLocal the statusLocal to set
     */
    public void setStatusLocal(String statusLocal) {
        this.statusLocal = statusLocal;
    }

    /**
     * @return the nivelLocal
     */
    public int getNivelLocal() {
        return nivelLocal;
    }

    /**
     * @param nivelLocal the nivelLocal to set
     */
    public void setNivelLocal(int nivelLocal) {
        this.nivelLocal = nivelLocal;
    }

    /**
     * @return the descricaLocal
     */
    public String getDescricaLocal() {
        return descricaLocal;
    }

    /**
     * @param descricaLocal the descricaLocal to set
     */
    public void setDescricaLocal(String descricaLocal) {
        this.descricaLocal = descricaLocal;
    }

    /**
     * @return the descricaoResumida
     */
    public String getDescricaoResumida() {
        return descricaoResumida;
    }

    /**
     * @param descricaoResumida the descricaoResumida to set
     */
    public void setDescricaoResumida(String descricaoResumida) {
        this.descricaoResumida = descricaoResumida;
    }

    /**
     * @return the modulo
     */
    public String getModulo() {
        return modulo;
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(String modulo) {
        this.modulo = modulo;
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
