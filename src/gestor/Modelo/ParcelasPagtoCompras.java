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
public class ParcelasPagtoCompras {

    private int idParc;
    private int idNfEntrada;
    private int idItem;
    private int idForn;
    private String nomeFornecedor;
    private Date dataVcto;
    private float valorParcela;
    private float valorTotalParcelas;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;   

    public ParcelasPagtoCompras(int idParc, int idNfEntrada, int idItem, int idForn, String nomeFornecedor, Date dataVcto, float valorParcela, float valorTotalParcelas, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp) {
        this.idParc = idParc;
        this.idNfEntrada = idNfEntrada;
        this.idItem = idItem;
        this.idForn = idForn;
        this.nomeFornecedor = nomeFornecedor;
        this.dataVcto = dataVcto;
        this.valorParcela = valorParcela;
        this.valorTotalParcelas = valorTotalParcelas;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ParcelasPagtoCompras() {
    }

    /**
     * @return the idParc
     */
    public int getIdParc() {
        return idParc;
    }

    /**
     * @param idParc the idParc to set
     */
    public void setIdParc(int idParc) {
        this.idParc = idParc;
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
     * @return the valorParcela
     */
    public float getValorParcela() {
        return valorParcela;
    }

    /**
     * @param valorParcela the valorParcela to set
     */
    public void setValorParcela(float valorParcela) {
        this.valorParcela = valorParcela;
    }

    /**
     * @return the valorTotalParcelas
     */
    public float getValorTotalParcelas() {
        return valorTotalParcelas;
    }

    /**
     * @param valorTotalParcelas the valorTotalParcelas to set
     */
    public void setValorTotalParcelas(float valorTotalParcelas) {
        this.valorTotalParcelas = valorTotalParcelas;
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
}
