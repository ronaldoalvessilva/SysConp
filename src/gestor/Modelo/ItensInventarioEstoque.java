/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author user
 */
public class ItensInventarioEstoque {

    private int idItem;
    private int idLanc;
    private int idProduto;
    private String nomeProduto;
    private String unidade;
    private int idLocal;
    private float qtdItem;
    private float valorCusto;
    private String lote;
    private Date DataLote;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String usuarioDelete;
    private String horarioInsert;
    private String horarioUp;
    private String horarioDelete;           

    public ItensInventarioEstoque(int idItem, int idLanc, int idProduto, String nomeProduto, String unidade, int idLocal, float qtdItem, float valorCusto, String lote, Date DataLote, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String dataDelete, String usuarioDelete, String horarioInsert, String horarioUp, String horarioDelete) {
        this.idItem = idItem;
        this.idLanc = idLanc;
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.unidade = unidade;
        this.idLocal = idLocal;
        this.qtdItem = qtdItem;
        this.valorCusto = valorCusto;
        this.lote = lote;
        this.DataLote = DataLote;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.usuarioDelete = usuarioDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.horarioDelete = horarioDelete;
    }

    public ItensInventarioEstoque() {
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
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
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
     * @return the valorCusto
     */
    public float getValorCusto() {
        return valorCusto;
    }

    /**
     * @param valorCusto the valorCusto to set
     */
    public void setValorCusto(float valorCusto) {
        this.valorCusto = valorCusto;
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
     * @return the DataLote
     */
    public Date getDataLote() {
        return DataLote;
    }

    /**
     * @param DataLote the DataLote to set
     */
    public void setDataLote(Date DataLote) {
        this.DataLote = DataLote;
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
     * @return the horarioDelete
     */
    public String getHorarioDelete() {
        return horarioDelete;
    }

    /**
     * @param horarioDelete the horarioDelete to set
     */
    public void setHorarioDelete(String horarioDelete) {
        this.horarioDelete = horarioDelete;
    }
}
