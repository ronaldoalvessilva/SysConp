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
public class SaldoEstoqueAcervo {

    private int idEstoque;
    private Date dataLanc;
    private String tipoMov;
    private int idLivro;
    private String nomeLivro;
    private int idLocal;
    private String descricaoLocal;
    private float qtdItem;
    private float saldoEstoque;    

    public SaldoEstoqueAcervo(int idEstoque, Date dataLanc, String tipoMov, int idLivro, String nomeLivro, int idLocal, String descricaoLocal, float qtdItem, float saldoEstoque) {
        this.idEstoque = idEstoque;
        this.dataLanc = dataLanc;
        this.tipoMov = tipoMov;
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.idLocal = idLocal;
        this.descricaoLocal = descricaoLocal;
        this.qtdItem = qtdItem;
        this.saldoEstoque = saldoEstoque;
    }

    public SaldoEstoqueAcervo() {
    }

    /**
     * @return the idEstoque
     */
    public int getIdEstoque() {
        return idEstoque;
    }

    /**
     * @param idEstoque the idEstoque to set
     */
    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
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
     * @return the tipoMov
     */
    public String getTipoMov() {
        return tipoMov;
    }

    /**
     * @param tipoMov the tipoMov to set
     */
    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    /**
     * @return the idLivro
     */
    public int getIdLivro() {
        return idLivro;
    }

    /**
     * @param idLivro the idLivro to set
     */
    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    /**
     * @return the nomeLivro
     */
    public String getNomeLivro() {
        return nomeLivro;
    }

    /**
     * @param nomeLivro the nomeLivro to set
     */
    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
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
     * @return the qtdItem
     */
    public float getQtdItem() {
        return qtdItem;
    }

    /**
     * @param qtdItem the qtdItem to set
     */
    public void setQtdItem(float qtdItem) {
        this.qtdItem = qtdItem;
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
