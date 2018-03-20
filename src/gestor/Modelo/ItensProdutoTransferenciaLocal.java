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
public class ItensProdutoTransferenciaLocal {

    private int idItem;
    private int idItemTrans;
    private Date dataLanc;
    private int idLanc;
    private int idLocal;
    private String nomeLocal;
    private int idReqFar;
    private int idProd;
    private String descricaoProduto;
    private String codigoBarras;
    private String unidadeProd;
    private float qtdItem;
    private float valorUN;
    private float valorTotal;
    private String loteProduto;
    private Date dataVctoLote;
    private String atendeReqEnfermaria;
    private String estornoProduto;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;                      

    public ItensProdutoTransferenciaLocal(int idItem, int idItemTrans, Date dataLanc, int idLanc, int idLocal, String nomeLocal, int idReqFar, int idProd, String descricaoProduto, String codigoBarras, String unidadeProd, float qtdItem, float valorUN, float valorTotal, String loteProduto, Date dataVctoLote, String atendeReqEnfermaria, String estornoProduto, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.idItemTrans = idItemTrans;
        this.dataLanc = dataLanc;
        this.idLanc = idLanc;
        this.idLocal = idLocal;
        this.nomeLocal = nomeLocal;
        this.idReqFar = idReqFar;
        this.idProd = idProd;
        this.descricaoProduto = descricaoProduto;
        this.codigoBarras = codigoBarras;
        this.unidadeProd = unidadeProd;
        this.qtdItem = qtdItem;
        this.valorUN = valorUN;
        this.valorTotal = valorTotal;
        this.loteProduto = loteProduto;
        this.dataVctoLote = dataVctoLote;
        this.atendeReqEnfermaria = atendeReqEnfermaria;
        this.estornoProduto = estornoProduto;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensProdutoTransferenciaLocal() {
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
     * @return the idItemTrans
     */
    public int getIdItemTrans() {
        return idItemTrans;
    }

    /**
     * @param idItemTrans the idItemTrans to set
     */
    public void setIdItemTrans(int idItemTrans) {
        this.idItemTrans = idItemTrans;
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
     * @return the idLanc
     */
    public int getIdLanc() {
        return idLanc;
    }

    /**
     * @param idLanc the idLanc to set
     */
    public void setIdLanc(int idLanc) {
        this.idLanc = idLanc;
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
     * @return the nomeLocal
     */
    public String getNomeLocal() {
        return nomeLocal;
    }

    /**
     * @param nomeLocal the nomeLocal to set
     */
    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    /**
     * @return the idReqFar
     */
    public int getIdReqFar() {
        return idReqFar;
    }

    /**
     * @param idReqFar the idReqFar to set
     */
    public void setIdReqFar(int idReqFar) {
        this.idReqFar = idReqFar;
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
     * @return the valorUN
     */
    public float getValorUN() {
        return valorUN;
    }

    /**
     * @param valorUN the valorUN to set
     */
    public void setValorUN(float valorUN) {
        this.valorUN = valorUN;
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
     * @return the dataVctoLote
     */
    public Date getDataVctoLote() {
        return dataVctoLote;
    }

    /**
     * @param dataVctoLote the dataVctoLote to set
     */
    public void setDataVctoLote(Date dataVctoLote) {
        this.dataVctoLote = dataVctoLote;
    }

    /**
     * @return the atendeReqEnfermaria
     */
    public String getAtendeReqEnfermaria() {
        return atendeReqEnfermaria;
    }

    /**
     * @param atendeReqEnfermaria the atendeReqEnfermaria to set
     */
    public void setAtendeReqEnfermaria(String atendeReqEnfermaria) {
        this.atendeReqEnfermaria = atendeReqEnfermaria;
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
}