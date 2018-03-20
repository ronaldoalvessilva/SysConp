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
public class MovimentoCrc {
  
    private int idMov;
    private int idInternoCrc;
    private int idDoc;
    private String nomeOpe;
    private Date dataMov;
    private int idItem;      

    public MovimentoCrc(int idMov, int idInternoCrc, int idDoc, String nomeOpe, Date dataMov, int idItem) {
        this.idMov = idMov;
        this.idInternoCrc = idInternoCrc;
        this.idDoc = idDoc;
        this.nomeOpe = nomeOpe;
        this.dataMov = dataMov;
        this.idItem = idItem;
    }

    public MovimentoCrc() {
    }

    /**
     * @return the idMov
     */
    public int getIdMov() {
        return idMov;
    }

    /**
     * @param idMov the idMov to set
     */
    public void setIdMov(int idMov) {
        this.idMov = idMov;
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
     * @return the idDoc
     */
    public int getIdDoc() {
        return idDoc;
    }

    /**
     * @param idDoc the idDoc to set
     */
    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    /**
     * @return the nomeOpe
     */
    public String getNomeOpe() {
        return nomeOpe;
    }

    /**
     * @param nomeOpe the nomeOpe to set
     */
    public void setNomeOpe(String nomeOpe) {
        this.nomeOpe = nomeOpe;
    }

    /**
     * @return the dataMov
     */
    public Date getDataMov() {
        return dataMov;
    }

    /**
     * @param dataMov the dataMov to set
     */
    public void setDataMov(Date dataMov) {
        this.dataMov = dataMov;
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
}
