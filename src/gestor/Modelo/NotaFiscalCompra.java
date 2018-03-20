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
public class NotaFiscalCompra {
    
    private int idNfEntrada;
    private String modelo;
    private String serieNf;
    private String numeroNf;
    private String statusNf;
    private int idLocal;
    private String descricaoLocal; 
    private int idForn;
    private String NomeFornecedor;
    private Date dataEmissao;
    private String tipodocumento;
    private String formaPagamento;
    private Date dataEntrada;
    private float baseCalculoICMS;
    private float valorICMS;
    private float baseCalculoICMSSub;
    private float valorICMSSub;
    private float valorTotalProdutos;
    private float valorTotalFrete;
    private float valorTotalSeguro;
    private float valorTotalDesconto;
    private float valorTotalIPI;
    private float valorTotalNFE;
    private String observacaoNF;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;   

    public NotaFiscalCompra(int idNfEntrada, String modelo, String serieNf, String numeroNf, String statusNf, int idLocal, String descricaoLocal, int idForn, String NomeFornecedor, Date dataEmissao, String tipodocumento, String formaPagamento, Date dataEntrada, float baseCalculoICMS, float valorICMS, float baseCalculoICMSSub, float valorICMSSub, float valorTotalProdutos, float valorTotalFrete, float valorTotalSeguro, float valorTotalDesconto, float valorTotalIPI, float valorTotalNFE, String observacaoNF, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp) {
        this.idNfEntrada = idNfEntrada;
        this.modelo = modelo;
        this.serieNf = serieNf;
        this.numeroNf = numeroNf;
        this.statusNf = statusNf;
        this.idLocal = idLocal;
        this.descricaoLocal = descricaoLocal;
        this.idForn = idForn;
        this.NomeFornecedor = NomeFornecedor;
        this.dataEmissao = dataEmissao;
        this.tipodocumento = tipodocumento;
        this.formaPagamento = formaPagamento;
        this.dataEntrada = dataEntrada;
        this.baseCalculoICMS = baseCalculoICMS;
        this.valorICMS = valorICMS;
        this.baseCalculoICMSSub = baseCalculoICMSSub;
        this.valorICMSSub = valorICMSSub;
        this.valorTotalProdutos = valorTotalProdutos;
        this.valorTotalFrete = valorTotalFrete;
        this.valorTotalSeguro = valorTotalSeguro;
        this.valorTotalDesconto = valorTotalDesconto;
        this.valorTotalIPI = valorTotalIPI;
        this.valorTotalNFE = valorTotalNFE;
        this.observacaoNF = observacaoNF;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public NotaFiscalCompra() {
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
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the serieNf
     */
    public String getSerieNf() {
        return serieNf;
    }

    /**
     * @param serieNf the serieNf to set
     */
    public void setSerieNf(String serieNf) {
        this.serieNf = serieNf;
    }

    /**
     * @return the numeroNf
     */
    public String getNumeroNf() {
        return numeroNf;
    }

    /**
     * @param numeroNf the numeroNf to set
     */
    public void setNumeroNf(String numeroNf) {
        this.numeroNf = numeroNf;
    }

    /**
     * @return the statusNf
     */
    public String getStatusNf() {
        return statusNf;
    }

    /**
     * @param statusNf the statusNf to set
     */
    public void setStatusNf(String statusNf) {
        this.statusNf = statusNf;
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
     * @return the NomeFornecedor
     */
    public String getNomeFornecedor() {
        return NomeFornecedor;
    }

    /**
     * @param NomeFornecedor the NomeFornecedor to set
     */
    public void setNomeFornecedor(String NomeFornecedor) {
        this.NomeFornecedor = NomeFornecedor;
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
     * @return the tipodocumento
     */
    public String getTipodocumento() {
        return tipodocumento;
    }

    /**
     * @param tipodocumento the tipodocumento to set
     */
    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    /**
     * @return the formaPagamento
     */
    public String getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * @param formaPagamento the formaPagamento to set
     */
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    /**
     * @return the dataEntrada
     */
    public Date getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * @return the baseCalculoICMS
     */
    public float getBaseCalculoICMS() {
        return baseCalculoICMS;
    }

    /**
     * @param baseCalculoICMS the baseCalculoICMS to set
     */
    public void setBaseCalculoICMS(float baseCalculoICMS) {
        this.baseCalculoICMS = baseCalculoICMS;
    }

    /**
     * @return the valorICMS
     */
    public float getValorICMS() {
        return valorICMS;
    }

    /**
     * @param valorICMS the valorICMS to set
     */
    public void setValorICMS(float valorICMS) {
        this.valorICMS = valorICMS;
    }

    /**
     * @return the baseCalculoICMSSub
     */
    public float getBaseCalculoICMSSub() {
        return baseCalculoICMSSub;
    }

    /**
     * @param baseCalculoICMSSub the baseCalculoICMSSub to set
     */
    public void setBaseCalculoICMSSub(float baseCalculoICMSSub) {
        this.baseCalculoICMSSub = baseCalculoICMSSub;
    }

    /**
     * @return the valorICMSSub
     */
    public float getValorICMSSub() {
        return valorICMSSub;
    }

    /**
     * @param valorICMSSub the valorICMSSub to set
     */
    public void setValorICMSSub(float valorICMSSub) {
        this.valorICMSSub = valorICMSSub;
    }

    /**
     * @return the valorTotalProdutos
     */
    public float getValorTotalProdutos() {
        return valorTotalProdutos;
    }

    /**
     * @param valorTotalProdutos the valorTotalProdutos to set
     */
    public void setValorTotalProdutos(float valorTotalProdutos) {
        this.valorTotalProdutos = valorTotalProdutos;
    }

    /**
     * @return the valorTotalFrete
     */
    public float getValorTotalFrete() {
        return valorTotalFrete;
    }

    /**
     * @param valorTotalFrete the valorTotalFrete to set
     */
    public void setValorTotalFrete(float valorTotalFrete) {
        this.valorTotalFrete = valorTotalFrete;
    }

    /**
     * @return the valorTotalSeguro
     */
    public float getValorTotalSeguro() {
        return valorTotalSeguro;
    }

    /**
     * @param valorTotalSeguro the valorTotalSeguro to set
     */
    public void setValorTotalSeguro(float valorTotalSeguro) {
        this.valorTotalSeguro = valorTotalSeguro;
    }

    /**
     * @return the valorTotalDesconto
     */
    public float getValorTotalDesconto() {
        return valorTotalDesconto;
    }

    /**
     * @param valorTotalDesconto the valorTotalDesconto to set
     */
    public void setValorTotalDesconto(float valorTotalDesconto) {
        this.valorTotalDesconto = valorTotalDesconto;
    }

    /**
     * @return the valorTotalIPI
     */
    public float getValorTotalIPI() {
        return valorTotalIPI;
    }

    /**
     * @param valorTotalIPI the valorTotalIPI to set
     */
    public void setValorTotalIPI(float valorTotalIPI) {
        this.valorTotalIPI = valorTotalIPI;
    }

    /**
     * @return the valorTotalNFE
     */
    public float getValorTotalNFE() {
        return valorTotalNFE;
    }

    /**
     * @param valorTotalNFE the valorTotalNFE to set
     */
    public void setValorTotalNFE(float valorTotalNFE) {
        this.valorTotalNFE = valorTotalNFE;
    }

    /**
     * @return the observacaoNF
     */
    public String getObservacaoNF() {
        return observacaoNF;
    }

    /**
     * @param observacaoNF the observacaoNF to set
     */
    public void setObservacaoNF(String observacaoNF) {
        this.observacaoNF = observacaoNF;
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
