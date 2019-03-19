/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronal
 */
public class ProdutoInternosKitLote {

    private int idRegProdKit;
    private int idRegistroComp;
    private int idKit;
    private int idPav;
    private String descricaoPavilhao;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int idProd;
    private String descricaoProduto;
    private String unidadeProd;
    private float quantidadeProd;
    private int tipoKitCI;
    private String agrupado;
    private int gravado;
    private String liberado;
    private String pUtili;
    private String pago;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private float qtdKit;
    private Date dataPagto;
    private float qtdEstoque;    

    public ProdutoInternosKitLote() {
    }

    public ProdutoInternosKitLote(int idRegProdKit, int idRegistroComp, int idKit, int idPav, String descricaoPavilhao, int idInternoCrc, String nomeInternoCrc, int idProd, String descricaoProduto, String unidadeProd, float quantidadeProd, int tipoKitCI, String agrupado, int gravado, String liberado, String pUtili, String pago, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, float qtdKit, Date dataPagto, float qtdEstoque) {
        this.idRegProdKit = idRegProdKit;
        this.idRegistroComp = idRegistroComp;
        this.idKit = idKit;
        this.idPav = idPav;
        this.descricaoPavilhao = descricaoPavilhao;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idProd = idProd;
        this.descricaoProduto = descricaoProduto;
        this.unidadeProd = unidadeProd;
        this.quantidadeProd = quantidadeProd;
        this.tipoKitCI = tipoKitCI;
        this.agrupado = agrupado;
        this.gravado = gravado;
        this.liberado = liberado;
        this.pUtili = pUtili;
        this.pago = pago;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.qtdKit = qtdKit;
        this.dataPagto = dataPagto;
        this.qtdEstoque = qtdEstoque;
    }

    /**
     * @return the idRegProdKit
     */
    public int getIdRegProdKit() {
        return idRegProdKit;
    }

    /**
     * @param idRegProdKit the idRegProdKit to set
     */
    public void setIdRegProdKit(int idRegProdKit) {
        this.idRegProdKit = idRegProdKit;
    }

    /**
     * @return the idRegistroComp
     */
    public int getIdRegistroComp() {
        return idRegistroComp;
    }

    /**
     * @param idRegistroComp the idRegistroComp to set
     */
    public void setIdRegistroComp(int idRegistroComp) {
        this.idRegistroComp = idRegistroComp;
    }

    /**
     * @return the idKit
     */
    public int getIdKit() {
        return idKit;
    }

    /**
     * @param idKit the idKit to set
     */
    public void setIdKit(int idKit) {
        this.idKit = idKit;
    }

    /**
     * @return the idPav
     */
    public int getIdPav() {
        return idPav;
    }

    /**
     * @param idPav the idPav to set
     */
    public void setIdPav(int idPav) {
        this.idPav = idPav;
    }

    /**
     * @return the descricaoPavilhao
     */
    public String getDescricaoPavilhao() {
        return descricaoPavilhao;
    }

    /**
     * @param descricaoPavilhao the descricaoPavilhao to set
     */
    public void setDescricaoPavilhao(String descricaoPavilhao) {
        this.descricaoPavilhao = descricaoPavilhao;
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
     * @return the quantidadeProd
     */
    public float getQuantidadeProd() {
        return quantidadeProd;
    }

    /**
     * @param quantidadeProd the quantidadeProd to set
     */
    public void setQuantidadeProd(float quantidadeProd) {
        this.quantidadeProd = quantidadeProd;
    }

    /**
     * @return the tipoKitCI
     */
    public int getTipoKitCI() {
        return tipoKitCI;
    }

    /**
     * @param tipoKitCI the tipoKitCI to set
     */
    public void setTipoKitCI(int tipoKitCI) {
        this.tipoKitCI = tipoKitCI;
    }

    /**
     * @return the agrupado
     */
    public String getAgrupado() {
        return agrupado;
    }

    /**
     * @param agrupado the agrupado to set
     */
    public void setAgrupado(String agrupado) {
        this.agrupado = agrupado;
    }

    /**
     * @return the gravado
     */
    public int getGravado() {
        return gravado;
    }

    /**
     * @param gravado the gravado to set
     */
    public void setGravado(int gravado) {
        this.gravado = gravado;
    }

    /**
     * @return the liberado
     */
    public String getLiberado() {
        return liberado;
    }

    /**
     * @param liberado the liberado to set
     */
    public void setLiberado(String liberado) {
        this.liberado = liberado;
    }

    /**
     * @return the pUtili
     */
    public String getpUtili() {
        return pUtili;
    }

    /**
     * @param pUtili the pUtili to set
     */
    public void setpUtili(String pUtili) {
        this.pUtili = pUtili;
    }

    /**
     * @return the pago
     */
    public String getPago() {
        return pago;
    }

    /**
     * @param pago the pago to set
     */
    public void setPago(String pago) {
        this.pago = pago;
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
     * @return the qtdKit
     */
    public float getQtdKit() {
        return qtdKit;
    }

    /**
     * @param qtdKit the qtdKit to set
     */
    public void setQtdKit(float qtdKit) {
        this.qtdKit = qtdKit;
    }

    /**
     * @return the dataPagto
     */
    public Date getDataPagto() {
        return dataPagto;
    }

    /**
     * @param dataPagto the dataPagto to set
     */
    public void setDataPagto(Date dataPagto) {
        this.dataPagto = dataPagto;
    }

    /**
     * @return the qtdEstoque
     */
    public float getQtdEstoque() {
        return qtdEstoque;
    }

    /**
     * @param qtdEstoque the qtdEstoque to set
     */
    public void setQtdEstoque(float qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
}
