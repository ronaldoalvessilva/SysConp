/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Ronaldo
 */
public class ListaInternos {

    private int idLista;
    private String statusLista;
    private Date dataLista;
    private String observacao;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String UsuarioInsert;
    private String UsuarioUpdate;
    private String DataInsert;
    private String DataUpdate;   
    private String horaInsert;
    private String horaUpdate; 

    public ListaInternos(int idLista, String statusLista, Date dataLista, String observacao, int idInternoCrc, String nomeInternoCrc, String UsuarioInsert, String UsuarioUpdate, String DataInsert, String DataUpdate, String horaInsert, String horaUpdate) {
        this.idLista = idLista;
        this.statusLista = statusLista;
        this.dataLista = dataLista;
        this.observacao = observacao;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.UsuarioInsert = UsuarioInsert;
        this.UsuarioUpdate = UsuarioUpdate;
        this.DataInsert = DataInsert;
        this.DataUpdate = DataUpdate;
        this.horaInsert = horaInsert;
        this.horaUpdate = horaUpdate;
    }

    public ListaInternos() {
    }

    /**
     * @return the idLista
     */
    public int getIdLista() {
        return idLista;
    }

    /**
     * @param idLista the idLista to set
     */
    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    /**
     * @return the statusLista
     */
    public String getStatusLista() {
        return statusLista;
    }

    /**
     * @param statusLista the statusLista to set
     */
    public void setStatusLista(String statusLista) {
        this.statusLista = statusLista;
    }

    /**
     * @return the dataLista
     */
    public Date getDataLista() {
        return dataLista;
    }

    /**
     * @param dataLista the dataLista to set
     */
    public void setDataLista(Date dataLista) {
        this.dataLista = dataLista;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
     * @return the UsuarioInsert
     */
    public String getUsuarioInsert() {
        return UsuarioInsert;
    }

    /**
     * @param UsuarioInsert the UsuarioInsert to set
     */
    public void setUsuarioInsert(String UsuarioInsert) {
        this.UsuarioInsert = UsuarioInsert;
    }

    /**
     * @return the UsuarioUpdate
     */
    public String getUsuarioUpdate() {
        return UsuarioUpdate;
    }

    /**
     * @param UsuarioUpdate the UsuarioUpdate to set
     */
    public void setUsuarioUpdate(String UsuarioUpdate) {
        this.UsuarioUpdate = UsuarioUpdate;
    }

    /**
     * @return the DataInsert
     */
    public String getDataInsert() {
        return DataInsert;
    }

    /**
     * @param DataInsert the DataInsert to set
     */
    public void setDataInsert(String DataInsert) {
        this.DataInsert = DataInsert;
    }

    /**
     * @return the DataUpdate
     */
    public String getDataUpdate() {
        return DataUpdate;
    }

    /**
     * @param DataUpdate the DataUpdate to set
     */
    public void setDataUpdate(String DataUpdate) {
        this.DataUpdate = DataUpdate;
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
     * @return the horaUpdate
     */
    public String getHoraUpdate() {
        return horaUpdate;
    }

    /**
     * @param horaUpdate the horaUpdate to set
     */
    public void setHoraUpdate(String horaUpdate) {
        this.horaUpdate = horaUpdate;
    }
}
