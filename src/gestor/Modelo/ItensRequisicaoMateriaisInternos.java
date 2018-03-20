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
public class ItensRequisicaoMateriaisInternos {

    private int idItem;
    private int idReq;
    private int idProd;
    private String descricaoProduto;
    private String codigoBarras;
    private String loteProduto;
    private String unidadeProd;
    private Float qtdItem;   
    private int qtdDoses;
    private Float valorUnitarioItem;
    private Float valorTotalItem;
    private String estornoProduto;
    private String atendReq;
    private int TipoRequisicao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;      
    private String dataVenc;      

    public ItensRequisicaoMateriaisInternos(int idItem, int idReq, int idProd, String descricaoProduto, String codigoBarras, String loteProduto, String unidadeProd, Float qtdItem, int qtdDoses, Float valorUnitarioItem, Float valorTotalItem, String estornoProduto, String atendReq, int TipoRequisicao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String dataVenc) {
        this.idItem = idItem;
        this.idReq = idReq;
        this.idProd = idProd;
        this.descricaoProduto = descricaoProduto;
        this.codigoBarras = codigoBarras;
        this.loteProduto = loteProduto;
        this.unidadeProd = unidadeProd;
        this.qtdItem = qtdItem;
        this.qtdDoses = qtdDoses;
        this.valorUnitarioItem = valorUnitarioItem;
        this.valorTotalItem = valorTotalItem;
        this.estornoProduto = estornoProduto;
        this.atendReq = atendReq;
        this.TipoRequisicao = TipoRequisicao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.dataVenc = dataVenc;
    }

    public ItensRequisicaoMateriaisInternos() {
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
     * @return the idReq
     */
    public int getIdReq() {
        return idReq;
    }

    /**
     * @param idReq the idReq to set
     */
    public void setIdReq(int idReq) {
        this.idReq = idReq;
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
     * @return the codigoBarras
     */
    public String getCodigoBarras() {
        return codigoBarras;
    }

    /**
     * @param codigoBarras the codigoBarras to set
     */
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
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
     * @return the unidadeProd
     */
    public String getUnidadeProd() {
        return unidadeProd;
    }

    /**
     * @param unidadeProd the unidadeProd to set
     */
    public void setUnidadeProd(String unidadeProd) {
        this.unidadeProd = unidadeProd;
    }

    /**
     * @return the qtdItem
     */
    public Float getQtdItem() {
        return qtdItem;
    }

    /**
     * @param qtdItem the qtdItem to set
     */
    public void setQtdItem(Float qtdItem) {
        this.qtdItem = qtdItem;
    }

    /**
     * @return the qtdDoses
     */
    public int getQtdDoses() {
        return qtdDoses;
    }

    /**
     * @param qtdDoses the qtdDoses to set
     */
    public void setQtdDoses(int qtdDoses) {
        this.qtdDoses = qtdDoses;
    }

    /**
     * @return the valorUnitarioItem
     */
    public Float getValorUnitarioItem() {
        return valorUnitarioItem;
    }

    /**
     * @param valorUnitarioItem the valorUnitarioItem to set
     */
    public void setValorUnitarioItem(Float valorUnitarioItem) {
        this.valorUnitarioItem = valorUnitarioItem;
    }

    /**
     * @return the valorTotalItem
     */
    public Float getValorTotalItem() {
        return valorTotalItem;
    }

    /**
     * @param valorTotalItem the valorTotalItem to set
     */
    public void setValorTotalItem(Float valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }

    /**
     * @return the estornoProduto
     */
    public String getEstornoProduto() {
        return estornoProduto;
    }

    /**
     * @param estornoProduto the estornoProduto to set
     */
    public void setEstornoProduto(String estornoProduto) {
        this.estornoProduto = estornoProduto;
    }

    /**
     * @return the atendReq
     */
    public String getAtendReq() {
        return atendReq;
    }

    /**
     * @param atendReq the atendReq to set
     */
    public void setAtendReq(String atendReq) {
        this.atendReq = atendReq;
    }

    /**
     * @return the TipoRequisicao
     */
    public int getTipoRequisicao() {
        return TipoRequisicao;
    }

    /**
     * @param TipoRequisicao the TipoRequisicao to set
     */
    public void setTipoRequisicao(int TipoRequisicao) {
        this.TipoRequisicao = TipoRequisicao;
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

    /**
     * @return the dataVenc
     */
    public String getDataVenc() {
        return dataVenc;
    }

    /**
     * @param dataVenc the dataVenc to set
     */
    public void setDataVenc(String dataVenc) {
        this.dataVenc = dataVenc;
    }
}
