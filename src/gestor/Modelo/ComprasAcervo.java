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
public class ComprasAcervo {

    private int idCompra;
    private String statusLanc;
    private String classeCompra;
    private Date dataCompra;
    private int idForn;
    private String nomeFornecedor;
    private int numeroDoc;
    private String serieDoc;
    private Date dataRecebe;
    private Date dataEmissao;
    private int formaPagto;
    private float valorProdutos;
    private float valorNFE;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public ComprasAcervo(int idCompra, String statusLanc, String classeCompra, Date dataCompra, int idForn, String nomeFornecedor, int numeroDoc, String serieDoc, Date dataRecebe, Date dataEmissao, int formaPagto, float valorProdutos, float valorNFE, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idCompra = idCompra;
        this.statusLanc = statusLanc;
        this.classeCompra = classeCompra;
        this.dataCompra = dataCompra;
        this.idForn = idForn;
        this.nomeFornecedor = nomeFornecedor;
        this.numeroDoc = numeroDoc;
        this.serieDoc = serieDoc;
        this.dataRecebe = dataRecebe;
        this.dataEmissao = dataEmissao;
        this.formaPagto = formaPagto;
        this.valorProdutos = valorProdutos;
        this.valorNFE = valorNFE;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ComprasAcervo() {
    }

    /**
     * @return the idCompra
     */
    public int getIdCompra() {
        return idCompra;
    }

    /**
     * @param idCompra the idCompra to set
     */
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    /**
     * @return the statusLanc
     */
    public String getStatusLanc() {
        return statusLanc;
    }

    /**
     * @param statusLanc the statusLanc to set
     */
    public void setStatusLanc(String statusLanc) {
        this.statusLanc = statusLanc;
    }

    /**
     * @return the classeCompra
     */
    public String getClasseCompra() {
        return classeCompra;
    }

    /**
     * @param classeCompra the classeCompra to set
     */
    public void setClasseCompra(String classeCompra) {
        this.classeCompra = classeCompra;
    }

    /**
     * @return the dataCompra
     */
    public Date getDataCompra() {
        return dataCompra;
    }

    /**
     * @param dataCompra the dataCompra to set
     */
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
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
     * @return the numeroDoc
     */
    public int getNumeroDoc() {
        return numeroDoc;
    }

    /**
     * @param numeroDoc the numeroDoc to set
     */
    public void setNumeroDoc(int numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    /**
     * @return the serieDoc
     */
    public String getSerieDoc() {
        return serieDoc;
    }

    /**
     * @param serieDoc the serieDoc to set
     */
    public void setSerieDoc(String serieDoc) {
        this.serieDoc = serieDoc;
    }

    /**
     * @return the dataRecebe
     */
    public Date getDataRecebe() {
        return dataRecebe;
    }

    /**
     * @param dataRecebe the dataRecebe to set
     */
    public void setDataRecebe(Date dataRecebe) {
        this.dataRecebe = dataRecebe;
    }

    /**
     * @return the dataEmissao
     */
    public Date getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao the dataEmissao to set
     */
    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    /**
     * @return the formaPagto
     */
    public int getFormaPagto() {
        return formaPagto;
    }

    /**
     * @param formaPagto the formaPagto to set
     */
    public void setFormaPagto(int formaPagto) {
        this.formaPagto = formaPagto;
    }

    /**
     * @return the valorProdutos
     */
    public float getValorProdutos() {
        return valorProdutos;
    }

    /**
     * @param valorProdutos the valorProdutos to set
     */
    public void setValorProdutos(float valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    /**
     * @return the valorNFE
     */
    public float getValorNFE() {
        return valorNFE;
    }

    /**
     * @param valorNFE the valorNFE to set
     */
    public void setValorNFE(float valorNFE) {
        this.valorNFE = valorNFE;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
