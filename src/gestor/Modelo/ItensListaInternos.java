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
public class ItensListaInternos {

    private int idItem;
    private int idLista;
    private int idInternoCrc;
    private String nomeInterno;
    private String statusInterno;
    private Date dataValidade;
    private String grauParentescoInterno;
    private String usuarioInsert;
    private String usuarioUpdate;
    private String DataInsert;
    private String DataUpdate;
    private String horaInsert;
    private String horaUpdate;   

    public ItensListaInternos(int idItem, int idLista, int idInternoCrc, String nomeInterno, String statusInterno, Date dataValidade, String grauParentescoInterno, String usuarioInsert, String usuarioUpdate, String DataInsert, String DataUpdate, String horaInsert, String horaUpdate) {
        this.idItem = idItem;
        this.idLista = idLista;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.statusInterno = statusInterno;
        this.dataValidade = dataValidade;
        this.grauParentescoInterno = grauParentescoInterno;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUpdate = usuarioUpdate;
        this.DataInsert = DataInsert;
        this.DataUpdate = DataUpdate;
        this.horaInsert = horaInsert;
        this.horaUpdate = horaUpdate;
    }

    public ItensListaInternos() {
    }

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
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
     * @return the nomeInterno
     */
    public String getNomeInterno() {
        return nomeInterno;
    }

    /**
     * @param nomeInterno the nomeInterno to set
     */
    public void setNomeInterno(String nomeInterno) {
        this.nomeInterno = nomeInterno;
    }

    /**
     * @return the statusInterno
     */
    public String getStatusInterno() {
        return statusInterno;
    }

    /**
     * @param statusInterno the statusInterno to set
     */
    public void setStatusInterno(String statusInterno) {
        this.statusInterno = statusInterno;
    }

    /**
     * @return the dataValidade
     */
    public Date getDataValidade() {
        return dataValidade;
    }

    /**
     * @param dataValidade the dataValidade to set
     */
    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    /**
     * @return the grauParentescoInterno
     */
    public String getGrauParentescoInterno() {
        return grauParentescoInterno;
    }

    /**
     * @param grauParentescoInterno the grauParentescoInterno to set
     */
    public void setGrauParentescoInterno(String grauParentescoInterno) {
        this.grauParentescoInterno = grauParentescoInterno;
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
     * @return the usuarioUpdate
     */
    public String getUsuarioUpdate() {
        return usuarioUpdate;
    }

    /**
     * @param usuarioUpdate the usuarioUpdate to set
     */
    public void setUsuarioUpdate(String usuarioUpdate) {
        this.usuarioUpdate = usuarioUpdate;
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
