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
public class HistoricoMovimentacaoEstoque {

    private int idHistorico;
    private int idProd;
    private int idLocal;
    private String descricaoLocal;
    private String tipoOpe;
    private String nomeOperacao;
    private String loteProduto;
    private int idDoc;
    private Date dataMov;
    private float qtdItem;
    private float saldoAtual;   
    private int pQtdItemKit;

    public HistoricoMovimentacaoEstoque() {
    }

    public HistoricoMovimentacaoEstoque(int idHistorico, int idProd, int idLocal, String descricaoLocal, String tipoOpe, String nomeOperacao, String loteProduto, int idDoc, Date dataMov, float qtdItem, float saldoAtual, int pQtdItemKit) {
        this.idHistorico = idHistorico;
        this.idProd = idProd;
        this.idLocal = idLocal;
        this.descricaoLocal = descricaoLocal;
        this.tipoOpe = tipoOpe;
        this.nomeOperacao = nomeOperacao;
        this.loteProduto = loteProduto;
        this.idDoc = idDoc;
        this.dataMov = dataMov;
        this.qtdItem = qtdItem;
        this.saldoAtual = saldoAtual;
        this.pQtdItemKit = pQtdItemKit;
    }

    /**
     * @return the idHistorico
     */
    public int getIdHistorico() {
        return idHistorico;
    }

    /**
     * @param idHistorico the idHistorico to set
     */
    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
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
     * @return the tipoOpe
     */
    public String getTipoOpe() {
        return tipoOpe;
    }

    /**
     * @param tipoOpe the tipoOpe to set
     */
    public void setTipoOpe(String tipoOpe) {
        this.tipoOpe = tipoOpe;
    }

    /**
     * @return the nomeOperacao
     */
    public String getNomeOperacao() {
        return nomeOperacao;
    }

    /**
     * @param nomeOperacao the nomeOperacao to set
     */
    public void setNomeOperacao(String nomeOperacao) {
        this.nomeOperacao = nomeOperacao;
    }

    /**
     * @return the loteProduto
     */
    public String getLoteProduto() {
        return loteProduto;
    }

    /**
     * @param loteProduto the loteProduto to set
     */
    public void setLoteProduto(String loteProduto) {
        this.loteProduto = loteProduto;
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
     * @return the saldoAtual
     */
    public float getSaldoAtual() {
        return saldoAtual;
    }

    /**
     * @param saldoAtual the saldoAtual to set
     */
    public void setSaldoAtual(float saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    /**
     * @return the pQtdItemKit
     */
    public int getpQtdItemKit() {
        return pQtdItemKit;
    }

    /**
     * @param pQtdItemKit the pQtdItemKit to set
     */
    public void setpQtdItemKit(int pQtdItemKit) {
        this.pQtdItemKit = pQtdItemKit;
    }
}
