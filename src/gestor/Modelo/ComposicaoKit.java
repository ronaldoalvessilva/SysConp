/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronal
 */
public class ComposicaoKit {
        private int idRegistroComp;
	private String statusComp;
	private Date dataComp;
	private String usuarioInsert;
	private String usuarioUp;
	private String dataInsert;
	private String dataUp;
	private String horarioInsert;
	private String horarioUp;

    public ComposicaoKit() {
    }

    public ComposicaoKit(int idRegistroComp, String statusComp, Date dataComp, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idRegistroComp = idRegistroComp;
        this.statusComp = statusComp;
        this.dataComp = dataComp;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idRegistroComp
     */
    public int getIdRegistroComp() {
        return idRegistroComp;
    }

    /**
     * @param idRegistroComp the idRegistroComp to set
     */
    public void setIdRegistroComp(int idRegistroComp) {
        this.idRegistroComp = idRegistroComp;
    }

    /**
     * @return the statusComp
     */
    public String getStatusComp() {
        return statusComp;
    }

    /**
     * @param statusComp the statusComp to set
     */
    public void setStatusComp(String statusComp) {
        this.statusComp = statusComp;
    }

    /**
     * @return the dataComp
     */
    public Date getDataComp() {
        return dataComp;
    }

    /**
     * @param dataComp the dataComp to set
     */
    public void setDataComp(Date dataComp) {
        this.dataComp = dataComp;
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
