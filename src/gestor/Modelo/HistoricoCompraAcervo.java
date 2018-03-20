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
public class HistoricoCompraAcervo {

    private int idHistCompra;
    private Date dataMov;
    private int idCompra;
    private int nfCompra;
    private int idLivro;
    private String nomeLivro;
    private float qtdeCompra;
    private float valorUnit;
    private float valorTotal;       

    public HistoricoCompraAcervo(int idHistCompra, Date dataMov, int idCompra, int nfCompra, int idLivro, String nomeLivro, float qtdeCompra, float valorUnit, float valorTotal) {
        this.idHistCompra = idHistCompra;
        this.dataMov = dataMov;
        this.idCompra = idCompra;
        this.nfCompra = nfCompra;
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.qtdeCompra = qtdeCompra;
        this.valorUnit = valorUnit;
        this.valorTotal = valorTotal;
    }

    public HistoricoCompraAcervo() {
    }

    /**
     * @return the idHistCompra
     */
    public int getIdHistCompra() {
        return idHistCompra;
    }

    /**
     * @param idHistCompra the idHistCompra to set
     */
    public void setIdHistCompra(int idHistCompra) {
        this.idHistCompra = idHistCompra;
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
     * @return the idCompra
     */
    public int getIdCompra() {
        return idCompra;
    }

    /**
     * @param idCompra the idCompra to set
     */
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    /**
     * @return the nfCompra
     */
    public int getNfCompra() {
        return nfCompra;
    }

    /**
     * @param nfCompra the nfCompra to set
     */
    public void setNfCompra(int nfCompra) {
        this.nfCompra = nfCompra;
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
     * @return the qtdeCompra
     */
    public float getQtdeCompra() {
        return qtdeCompra;
    }

    /**
     * @param qtdeCompra the qtdeCompra to set
     */
    public void setQtdeCompra(float qtdeCompra) {
        this.qtdeCompra = qtdeCompra;
    }

    /**
     * @return the valorUnit
     */
    public float getValorUnit() {
        return valorUnit;
    }

    /**
     * @param valorUnit the valorUnit to set
     */
    public void setValorUnit(float valorUnit) {
        this.valorUnit = valorUnit;
    }

    /**
     * @return the valorTotal
     */
    public float getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
