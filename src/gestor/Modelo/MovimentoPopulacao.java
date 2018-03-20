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
public class MovimentoPopulacao {

    private int idPopMov;
    private Date dataPopMov;
    private String statusPop;
    private int totalGeralAgentes;
    private int totalGeralInternos;
    private int totalMotoristas;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;      

    public MovimentoPopulacao(int idPopMov, Date dataPopMov, String statusPop, int totalGeralAgentes, int totalGeralInternos, int totalMotoristas, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp) {
        this.idPopMov = idPopMov;
        this.dataPopMov = dataPopMov;
        this.statusPop = statusPop;
        this.totalGeralAgentes = totalGeralAgentes;
        this.totalGeralInternos = totalGeralInternos;
        this.totalMotoristas = totalMotoristas;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
    }

    public MovimentoPopulacao() {
    }

    /**
     * @return the idPopMov
     */
    public int getIdPopMov() {
        return idPopMov;
    }

    /**
     * @param idPopMov the idPopMov to set
     */
    public void setIdPopMov(int idPopMov) {
        this.idPopMov = idPopMov;
    }

    /**
     * @return the dataPopMov
     */
    public Date getDataPopMov() {
        return dataPopMov;
    }

    /**
     * @param dataPopMov the dataPopMov to set
     */
    public void setDataPopMov(Date dataPopMov) {
        this.dataPopMov = dataPopMov;
    }

    /**
     * @return the statusPop
     */
    public String getStatusPop() {
        return statusPop;
    }

    /**
     * @param statusPop the statusPop to set
     */
    public void setStatusPop(String statusPop) {
        this.statusPop = statusPop;
    }

    /**
     * @return the totalGeralAgentes
     */
    public int getTotalGeralAgentes() {
        return totalGeralAgentes;
    }

    /**
     * @param totalGeralAgentes the totalGeralAgentes to set
     */
    public void setTotalGeralAgentes(int totalGeralAgentes) {
        this.totalGeralAgentes = totalGeralAgentes;
    }

    /**
     * @return the totalGeralInternos
     */
    public int getTotalGeralInternos() {
        return totalGeralInternos;
    }

    /**
     * @param totalGeralInternos the totalGeralInternos to set
     */
    public void setTotalGeralInternos(int totalGeralInternos) {
        this.totalGeralInternos = totalGeralInternos;
    }

    /**
     * @return the totalMotoristas
     */
    public int getTotalMotoristas() {
        return totalMotoristas;
    }

    /**
     * @param totalMotoristas the totalMotoristas to set
     */
    public void setTotalMotoristas(int totalMotoristas) {
        this.totalMotoristas = totalMotoristas;
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
}
