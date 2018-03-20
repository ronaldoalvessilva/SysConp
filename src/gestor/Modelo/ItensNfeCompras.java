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
public class ItensNfeCompras {

    private int idItem;
    private int idPedido;
    private int idNfEntrada;
    private int idProd;
    private String descricaoProduto;
    private String lote;
    private float qtdItem;
    private float valorUN;
    private float aliquotaICMS;
    private float aliquotaIPI;
    private Date dataVcto;
    private float valorTotalItem;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;                

    public ItensNfeCompras(int idItem, int idPedido, int idNfEntrada, int idProd, String descricaoProduto, String lote, float qtdItem, float valorUN, float aliquotaICMS, float aliquotaIPI, Date dataVcto, float valorTotalItem, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.idPedido = idPedido;
        this.idNfEntrada = idNfEntrada;
        this.idProd = idProd;
        this.descricaoProduto = descricaoProduto;
        this.lote = lote;
        this.qtdItem = qtdItem;
        this.valorUN = valorUN;
        this.aliquotaICMS = aliquotaICMS;
        this.aliquotaIPI = aliquotaIPI;
        this.dataVcto = dataVcto;
        this.valorTotalItem = valorTotalItem;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensNfeCompras() {
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
     * @return the idPedido
     */
    public int getIdPedido() {
        return idPedido;
    }

    /**
     * @param idPedido the idPedido to set
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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
     * @return the lote
     */
    public String getLote() {
        return lote;
    }

    /**
     * @param lote the lote to set
     */
    public void setLote(String lote) {
        this.lote = lote;
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
     * @return the aliquotaICMS
     */
    public float getAliquotaICMS() {
        return aliquotaICMS;
    }

    /**
     * @param aliquotaICMS the aliquotaICMS to set
     */
    public void setAliquotaICMS(float aliquotaICMS) {
        this.aliquotaICMS = aliquotaICMS;
    }

    /**
     * @return the aliquotaIPI
     */
    public float getAliquotaIPI() {
        return aliquotaIPI;
    }

    /**
     * @param aliquotaIPI the aliquotaIPI to set
     */
    public void setAliquotaIPI(float aliquotaIPI) {
        this.aliquotaIPI = aliquotaIPI;
    }

    /**
     * @return the dataVcto
     */
    public Date getDataVcto() {
        return dataVcto;
    }

    /**
     * @param dataVcto the dataVcto to set
     */
    public void setDataVcto(Date dataVcto) {
        this.dataVcto = dataVcto;
    }

    /**
     * @return the valorTotalItem
     */
    public float getValorTotalItem() {
        return valorTotalItem;
    }

    /**
     * @param valorTotalItem the valorTotalItem to set
     */
    public void setValorTotalItem(float valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
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
     * @return the usuarioDelete
     */
    public String getUsuarioDelete() {
        return usuarioDelete;
    }

    /**
     * @param usuarioDelete the usuarioDelete to set
     */
    public void setUsuarioDelete(String usuarioDelete) {
        this.usuarioDelete = usuarioDelete;
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
     * @return the dataDelete
     */
    public String getDataDelete() {
        return dataDelete;
    }

    /**
     * @param dataDelete the dataDelete to set
     */
    public void setDataDelete(String dataDelete) {
        this.dataDelete = dataDelete;
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

    public void setValorCompra(float floatValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
