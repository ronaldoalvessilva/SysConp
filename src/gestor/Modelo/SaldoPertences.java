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
public class SaldoPertences {

    private int idItem;
    private int idMov;
    private String statusMov;
    private Date dataLanc;
    private int idItemMov;
    private int idObj;
    private String descricaoObjeto;
    private int idLocal;
    private String descricaoLocal;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private float qtdLanc;
    private float saldoEstoque;

    public SaldoPertences(int idItem, int idMov, String statusMov, Date dataLanc, int idItemMov, int idObj, String descricaoObjeto, int idLocal, String descricaoLocal, int idInternoCrc, String nomeInternoCrc, float qtdLanc, float saldoEstoque) {
        this.idItem = idItem;
        this.idMov = idMov;
        this.statusMov = statusMov;
        this.dataLanc = dataLanc;
        this.idItemMov = idItemMov;
        this.idObj = idObj;
        this.descricaoObjeto = descricaoObjeto;
        this.idLocal = idLocal;
        this.descricaoLocal = descricaoLocal;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.qtdLanc = qtdLanc;
        this.saldoEstoque = saldoEstoque;
    }

    public SaldoPertences() {
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
     * @return the statusMov
     */
    public String getStatusMov() {
        return statusMov;
    }

    /**
     * @param statusMov the statusMov to set
     */
    public void setStatusMov(String statusMov) {
        this.statusMov = statusMov;
    }

    /**
     * @return the dataLanc
     */
    public Date getDataLanc() {
        return dataLanc;
    }

    /**
     * @param dataLanc the dataLanc to set
     */
    public void setDataLanc(Date dataLanc) {
        this.dataLanc = dataLanc;
    }

    /**
     * @return the idItemMov
     */
    public int getIdItemMov() {
        return idItemMov;
    }

    /**
     * @param idItemMov the idItemMov to set
     */
    public void setIdItemMov(int idItemMov) {
        this.idItemMov = idItemMov;
    }

    /**
     * @return the idObj
     */
    public int getIdObj() {
        return idObj;
    }

    /**
     * @param idObj the idObj to set
     */
    public void setIdObj(int idObj) {
        this.idObj = idObj;
    }

    /**
     * @return the descricaoObjeto
     */
    public String getDescricaoObjeto() {
        return descricaoObjeto;
    }

    /**
     * @param descricaoObjeto the descricaoObjeto to set
     */
    public void setDescricaoObjeto(String descricaoObjeto) {
        this.descricaoObjeto = descricaoObjeto;
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
     * @return the descricaoLocal
     */
    public String getDescricaoLocal() {
        return descricaoLocal;
    }

    /**
     * @param descricaoLocal the descricaoLocal to set
     */
    public void setDescricaoLocal(String descricaoLocal) {
        this.descricaoLocal = descricaoLocal;
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
     * @return the qtdLanc
     */
    public float getQtdLanc() {
        return qtdLanc;
    }

    /**
     * @param qtdLanc the qtdLanc to set
     */
    public void setQtdLanc(float qtdLanc) {
        this.qtdLanc = qtdLanc;
    }

    /**
     * @return the saldoEstoque
     */
    public float getSaldoEstoque() {
        return saldoEstoque;
    }

    /**
     * @param saldoEstoque the saldoEstoque to set
     */
    public void setSaldoEstoque(float saldoEstoque) {
        this.saldoEstoque = saldoEstoque;
    }
}
