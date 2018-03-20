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
public class HistoricoProdutoFornecedor {

    private int idHistCompra;
    private int nfCompra;
    private Date dataMov;
    private int idForn;
    private String nomeFornecedor;
    private int idNfEntrada;
    private int idProd;
    private String descricaoProduto;
    private float qtdeCompra;
    private float valorUnit;

    public HistoricoProdutoFornecedor(int idHistCompra, int nfCompra, Date dataMov, int idForn, String nomeFornecedor, int idNfEntrada, int idProd, String descricaoProduto, float qtdeCompra, float valorUnit) {
        this.idHistCompra = idHistCompra;
        this.nfCompra = nfCompra;
        this.dataMov = dataMov;
        this.idForn = idForn;
        this.nomeFornecedor = nomeFornecedor;
        this.idNfEntrada = idNfEntrada;
        this.idProd = idProd;
        this.descricaoProduto = descricaoProduto;
        this.qtdeCompra = qtdeCompra;
        this.valorUnit = valorUnit;
    }

    public HistoricoProdutoFornecedor() {
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
     * @return the idForn
     */
    public int getIdForn() {
        return idForn;
    }

    /**
     * @param idForn the idForn to set
     */
    public void setIdForn(int idForn) {
        this.idForn = idForn;
    }

    /**
     * @return the nomeFornecedor
     */
    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    /**
     * @param nomeFornecedor the nomeFornecedor to set
     */
    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    /**
     * @return the idNfEntrada
     */
    public int getIdNfEntrada() {
        return idNfEntrada;
    }

    /**
     * @param idNfEntrada the idNfEntrada to set
     */
    public void setIdNfEntrada(int idNfEntrada) {
        this.idNfEntrada = idNfEntrada;
    }

    /**
     * @return the idProd
     */
    public int getIdProd() {
        return idProd;
    }

    /**
     * @param idProd the idProd to set
     */
    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
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
}
