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
public class CargaHoraria {

    private int idCarga;
    private String statusCarga;
    private Date dataCad;
    private String descricaoCarga;
    private String qtdDias;
    private String qtdHoras;
    private String mesReferencia;
    private int anoReferencia;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;      

    public CargaHoraria(int idCarga, String statusCarga, Date dataCad, String descricaoCarga, String qtdDias, String qtdHoras, String mesReferencia, int anoReferencia, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp) {
        this.idCarga = idCarga;
        this.statusCarga = statusCarga;
        this.dataCad = dataCad;
        this.descricaoCarga = descricaoCarga;
        this.qtdDias = qtdDias;
        this.qtdHoras = qtdHoras;
        this.mesReferencia = mesReferencia;
        this.anoReferencia = anoReferencia;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public CargaHoraria() {
    }

    /**
     * @return the idCarga
     */
    public int getIdCarga() {
        return idCarga;
    }

    /**
     * @param idCarga the idCarga to set
     */
    public void setIdCarga(int idCarga) {
        this.idCarga = idCarga;
    }

    /**
     * @return the statusCarga
     */
    public String getStatusCarga() {
        return statusCarga;
    }

    /**
     * @param statusCarga the statusCarga to set
     */
    public void setStatusCarga(String statusCarga) {
        this.statusCarga = statusCarga;
    }

    /**
     * @return the dataCad
     */
    public Date getDataCad() {
        return dataCad;
    }

    /**
     * @param dataCad the dataCad to set
     */
    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
    }

    /**
     * @return the descricaoCarga
     */
    public String getDescricaoCarga() {
        return descricaoCarga;
    }

    /**
     * @param descricaoCarga the descricaoCarga to set
     */
    public void setDescricaoCarga(String descricaoCarga) {
        this.descricaoCarga = descricaoCarga;
    }

    /**
     * @return the qtdDias
     */
    public String getQtdDias() {
        return qtdDias;
    }

    /**
     * @param qtdDias the qtdDias to set
     */
    public void setQtdDias(String qtdDias) {
        this.qtdDias = qtdDias;
    }

    /**
     * @return the qtdHoras
     */
    public String getQtdHoras() {
        return qtdHoras;
    }

    /**
     * @param qtdHoras the qtdHoras to set
     */
    public void setQtdHoras(String qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    /**
     * @return the mesReferencia
     */
    public String getMesReferencia() {
        return mesReferencia;
    }

    /**
     * @param mesReferencia the mesReferencia to set
     */
    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    /**
     * @return the anoReferencia
     */
    public int getAnoReferencia() {
        return anoReferencia;
    }

    /**
     * @param anoReferencia the anoReferencia to set
     */
    public void setAnoReferencia(int anoReferencia) {
        this.anoReferencia = anoReferencia;
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
