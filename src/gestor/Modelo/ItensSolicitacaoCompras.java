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
public class ItensSolicitacaoCompras {

    private int idItem;
    private int idSol;
    private int idProd;
    private int idAprova;
    private Date dataAprova;
    private String nomeProduto;
    private String codigoBarras;
    private String statusAprovacao;
    private String unidadeProd;
    private float qtdItem;
    private float valorUnitarioItem;
    private float valorTotalItem;
    private String aprovaSolicitacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;            

    public ItensSolicitacaoCompras(int idItem, int idSol, int idProd, int idAprova, Date dataAprova, String nomeProduto, String codigoBarras, String statusAprovacao, String unidadeProd, float qtdItem, float valorUnitarioItem, float valorTotalItem, String aprovaSolicitacao, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.idSol = idSol;
        this.idProd = idProd;
        this.idAprova = idAprova;
        this.dataAprova = dataAprova;
        this.nomeProduto = nomeProduto;
        this.codigoBarras = codigoBarras;
        this.statusAprovacao = statusAprovacao;
        this.unidadeProd = unidadeProd;
        this.qtdItem = qtdItem;
        this.valorUnitarioItem = valorUnitarioItem;
        this.valorTotalItem = valorTotalItem;
        this.aprovaSolicitacao = aprovaSolicitacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensSolicitacaoCompras() {
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
     * @return the idSol
     */
    public int getIdSol() {
        return idSol;
    }

    /**
     * @param idSol the idSol to set
     */
    public void setIdSol(int idSol) {
        this.idSol = idSol;
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
     * @return the idAprova
     */
    public int getIdAprova() {
        return idAprova;
    }

    /**
     * @param idAprova the idAprova to set
     */
    public void setIdAprova(int idAprova) {
        this.idAprova = idAprova;
    }

    /**
     * @return the dataAprova
     */
    public Date getDataAprova() {
        return dataAprova;
    }

    /**
     * @param dataAprova the dataAprova to set
     */
    public void setDataAprova(Date dataAprova) {
        this.dataAprova = dataAprova;
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
     * @return the statusAprovacao
     */
    public String getStatusAprovacao() {
        return statusAprovacao;
    }

    /**
     * @param statusAprovacao the statusAprovacao to set
     */
    public void setStatusAprovacao(String statusAprovacao) {
        this.statusAprovacao = statusAprovacao;
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
     * @return the valorUnitarioItem
     */
    public float getValorUnitarioItem() {
        return valorUnitarioItem;
    }

    /**
     * @param valorUnitarioItem the valorUnitarioItem to set
     */
    public void setValorUnitarioItem(float valorUnitarioItem) {
        this.valorUnitarioItem = valorUnitarioItem;
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
     * @return the aprovaSolicitacao
     */
    public String getAprovaSolicitacao() {
        return aprovaSolicitacao;
    }

    /**
     * @param aprovaSolicitacao the aprovaSolicitacao to set
     */
    public void setAprovaSolicitacao(String aprovaSolicitacao) {
        this.aprovaSolicitacao = aprovaSolicitacao;
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
