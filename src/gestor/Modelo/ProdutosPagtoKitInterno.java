/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Socializa TI 02
 */
public class ProdutosPagtoKitInterno {

    private int idItemProd;
    private int idPagto;
    private int idItem;
    private int idProd;
    private String descricaoProduto;
    private float quatProd;
    private Date dataEntrega;
    private String horario;
    private byte [] assinaturaDigitalInterno;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;
    private int idInternoCrc; 

    public ProdutosPagtoKitInterno() {
    }

    public ProdutosPagtoKitInterno(int idItemProd, int idPagto, int idItem, int idProd, String descricaoProduto, float quatProd, Date dataEntrega, String horario, byte[] assinaturaDigitalInterno, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp, int idInternoCrc) {
        this.idItemProd = idItemProd;
        this.idPagto = idPagto;
        this.idItem = idItem;
        this.idProd = idProd;
        this.descricaoProduto = descricaoProduto;
        this.quatProd = quatProd;
        this.dataEntrega = dataEntrega;
        this.horario = horario;
        this.assinaturaDigitalInterno = assinaturaDigitalInterno;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
        this.idInternoCrc = idInternoCrc;
    }

    /**
     * @return the idItemProd
     */
    public int getIdItemProd() {
        return idItemProd;
    }

    /**
     * @param idItemProd the idItemProd to set
     */
    public void setIdItemProd(int idItemProd) {
        this.idItemProd = idItemProd;
    }

    /**
     * @return the idPagto
     */
    public int getIdPagto() {
        return idPagto;
    }

    /**
     * @param idPagto the idPagto to set
     */
    public void setIdPagto(int idPagto) {
        this.idPagto = idPagto;
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
     * @return the quatProd
     */
    public float getQuatProd() {
        return quatProd;
    }

    /**
     * @param quatProd the quatProd to set
     */
    public void setQuatProd(float quatProd) {
        this.quatProd = quatProd;
    }

    /**
     * @return the dataEntrega
     */
    public Date getDataEntrega() {
        return dataEntrega;
    }

    /**
     * @param dataEntrega the dataEntrega to set
     */
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the assinaturaDigitalInterno
     */
    public byte[] getAssinaturaDigitalInterno() {
        return assinaturaDigitalInterno;
    }

    /**
     * @param assinaturaDigitalInterno the assinaturaDigitalInterno to set
     */
    public void setAssinaturaDigitalInterno(byte[] assinaturaDigitalInterno) {
        this.assinaturaDigitalInterno = assinaturaDigitalInterno;
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
}
