/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronaldo
 */
public class ItensSinale {

    private int idSina;
    private int idLanc;
    private Date dataInicio;
    private int idInternoCrc;
    private int diasPz;
    private int diasRz;
    private int cargaPz;
    private int cargaRz;
    private String nomeInternoCrc;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInser;
    private String horarioUp;   

    public ItensSinale(int idSina, int idLanc, Date dataInicio, int idInternoCrc, int diasPz, int diasRz, int cargaPz, int cargaRz, String nomeInternoCrc, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInser, String horarioUp) {
        this.idSina = idSina;
        this.idLanc = idLanc;
        this.dataInicio = dataInicio;
        this.idInternoCrc = idInternoCrc;
        this.diasPz = diasPz;
        this.diasRz = diasRz;
        this.cargaPz = cargaPz;
        this.cargaRz = cargaRz;
        this.nomeInternoCrc = nomeInternoCrc;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInser = horarioInser;
        this.horarioUp = horarioUp;
    }

    public ItensSinale() {
    }

    /**
     * @return the idSina
     */
    public int getIdSina() {
        return idSina;
    }

    /**
     * @param idSina the idSina to set
     */
    public void setIdSina(int idSina) {
        this.idSina = idSina;
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
     * @return the diasPz
     */
    public int getDiasPz() {
        return diasPz;
    }

    /**
     * @param diasPz the diasPz to set
     */
    public void setDiasPz(int diasPz) {
        this.diasPz = diasPz;
    }

    /**
     * @return the diasRz
     */
    public int getDiasRz() {
        return diasRz;
    }

    /**
     * @param diasRz the diasRz to set
     */
    public void setDiasRz(int diasRz) {
        this.diasRz = diasRz;
    }

    /**
     * @return the cargaPz
     */
    public int getCargaPz() {
        return cargaPz;
    }

    /**
     * @param cargaPz the cargaPz to set
     */
    public void setCargaPz(int cargaPz) {
        this.cargaPz = cargaPz;
    }

    /**
     * @return the cargaRz
     */
    public int getCargaRz() {
        return cargaRz;
    }

    /**
     * @param cargaRz the cargaRz to set
     */
    public void setCargaRz(int cargaRz) {
        this.cargaRz = cargaRz;
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
     * @return the usuarioDelete
     */
    public String getUsuarioDelete() {
        return usuarioDelete;
    }

    /**
     * @param usuarioDelete the usuarioDelete to set
     */
    public void setUsuarioDelete(String usuarioDelete) {
        this.usuarioDelete = usuarioDelete;
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
     * @return the dataDelete
     */
    public String getDataDelete() {
        return dataDelete;
    }

    /**
     * @param dataDelete the dataDelete to set
     */
    public void setDataDelete(String dataDelete) {
        this.dataDelete = dataDelete;
    }

    /**
     * @return the horarioInser
     */
    public String getHorarioInser() {
        return horarioInser;
    }

    /**
     * @param horarioInser the horarioInser to set
     */
    public void setHorarioInser(String horarioInser) {
        this.horarioInser = horarioInser;
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
