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
public class CotacaoCompras {

    private int IdCota;
    private String StatusCota;
    private Date DataCotacao;
    private int IdDepartamento;
    private String descricaoDepartamento;
    private int IdCusto;
    private String descricaoCentroCusto;
    private String TipoCotacao;
    private String FreteCotacao;
    private String ObservacaoCotacao;
    private String UsuarioInsert;
    private String UsuarioUp;
    private String DataInsert;
    private String DataUp;
    private String HorarioInsert;
    private String HorarioUp;
    private int IdCotFor;
    private int IdForn;
    private String descricaoFornecedor;
    private int IdForma;
    private String descricaoFormaPagto;
    private String PrazoEntrega;
    private Date dataVencimento;
    private String ObservacaoFornecedor;         

    public CotacaoCompras(int IdCota, String StatusCota, Date DataCotacao, int IdDepartamento, String descricaoDepartamento, int IdCusto, String descricaoCentroCusto, String TipoCotacao, String FreteCotacao, String ObservacaoCotacao, String UsuarioInsert, String UsuarioUp, String DataInsert, String DataUp, String HorarioInsert, String HorarioUp, int IdCotFor, int IdForn, String descricaoFornecedor, int IdForma, String descricaoFormaPagto, String PrazoEntrega, Date dataVencimento, String ObservacaoFornecedor) {
        this.IdCota = IdCota;
        this.StatusCota = StatusCota;
        this.DataCotacao = DataCotacao;
        this.IdDepartamento = IdDepartamento;
        this.descricaoDepartamento = descricaoDepartamento;
        this.IdCusto = IdCusto;
        this.descricaoCentroCusto = descricaoCentroCusto;
        this.TipoCotacao = TipoCotacao;
        this.FreteCotacao = FreteCotacao;
        this.ObservacaoCotacao = ObservacaoCotacao;
        this.UsuarioInsert = UsuarioInsert;
        this.UsuarioUp = UsuarioUp;
        this.DataInsert = DataInsert;
        this.DataUp = DataUp;
        this.HorarioInsert = HorarioInsert;
        this.HorarioUp = HorarioUp;
        this.IdCotFor = IdCotFor;
        this.IdForn = IdForn;
        this.descricaoFornecedor = descricaoFornecedor;
        this.IdForma = IdForma;
        this.descricaoFormaPagto = descricaoFormaPagto;
        this.PrazoEntrega = PrazoEntrega;
        this.dataVencimento = dataVencimento;
        this.ObservacaoFornecedor = ObservacaoFornecedor;
    }

    public CotacaoCompras() {
    }

    /**
     * @return the IdCota
     */
    public int getIdCota() {
        return IdCota;
    }

    /**
     * @param IdCota the IdCota to set
     */
    public void setIdCota(int IdCota) {
        this.IdCota = IdCota;
    }

    /**
     * @return the StatusCota
     */
    public String getStatusCota() {
        return StatusCota;
    }

    /**
     * @param StatusCota the StatusCota to set
     */
    public void setStatusCota(String StatusCota) {
        this.StatusCota = StatusCota;
    }

    /**
     * @return the DataCotacao
     */
    public Date getDataCotacao() {
        return DataCotacao;
    }

    /**
     * @param DataCotacao the DataCotacao to set
     */
    public void setDataCotacao(Date DataCotacao) {
        this.DataCotacao = DataCotacao;
    }

    /**
     * @return the IdDepartamento
     */
    public int getIdDepartamento() {
        return IdDepartamento;
    }

    /**
     * @param IdDepartamento the IdDepartamento to set
     */
    public void setIdDepartamento(int IdDepartamento) {
        this.IdDepartamento = IdDepartamento;
    }

    /**
     * @return the descricaoDepartamento
     */
    public String getDescricaoDepartamento() {
        return descricaoDepartamento;
    }

    /**
     * @param descricaoDepartamento the descricaoDepartamento to set
     */
    public void setDescricaoDepartamento(String descricaoDepartamento) {
        this.descricaoDepartamento = descricaoDepartamento;
    }

    /**
     * @return the IdCusto
     */
    public int getIdCusto() {
        return IdCusto;
    }

    /**
     * @param IdCusto the IdCusto to set
     */
    public void setIdCusto(int IdCusto) {
        this.IdCusto = IdCusto;
    }

    /**
     * @return the descricaoCentroCusto
     */
    public String getDescricaoCentroCusto() {
        return descricaoCentroCusto;
    }

    /**
     * @param descricaoCentroCusto the descricaoCentroCusto to set
     */
    public void setDescricaoCentroCusto(String descricaoCentroCusto) {
        this.descricaoCentroCusto = descricaoCentroCusto;
    }

    /**
     * @return the TipoCotacao
     */
    public String getTipoCotacao() {
        return TipoCotacao;
    }

    /**
     * @param TipoCotacao the TipoCotacao to set
     */
    public void setTipoCotacao(String TipoCotacao) {
        this.TipoCotacao = TipoCotacao;
    }

    /**
     * @return the FreteCotacao
     */
    public String getFreteCotacao() {
        return FreteCotacao;
    }

    /**
     * @param FreteCotacao the FreteCotacao to set
     */
    public void setFreteCotacao(String FreteCotacao) {
        this.FreteCotacao = FreteCotacao;
    }

    /**
     * @return the ObservacaoCotacao
     */
    public String getObservacaoCotacao() {
        return ObservacaoCotacao;
    }

    /**
     * @param ObservacaoCotacao the ObservacaoCotacao to set
     */
    public void setObservacaoCotacao(String ObservacaoCotacao) {
        this.ObservacaoCotacao = ObservacaoCotacao;
    }

    /**
     * @return the UsuarioInsert
     */
    public String getUsuarioInsert() {
        return UsuarioInsert;
    }

    /**
     * @param UsuarioInsert the UsuarioInsert to set
     */
    public void setUsuarioInsert(String UsuarioInsert) {
        this.UsuarioInsert = UsuarioInsert;
    }

    /**
     * @return the UsuarioUp
     */
    public String getUsuarioUp() {
        return UsuarioUp;
    }

    /**
     * @param UsuarioUp the UsuarioUp to set
     */
    public void setUsuarioUp(String UsuarioUp) {
        this.UsuarioUp = UsuarioUp;
    }

    /**
     * @return the DataInsert
     */
    public String getDataInsert() {
        return DataInsert;
    }

    /**
     * @param DataInsert the DataInsert to set
     */
    public void setDataInsert(String DataInsert) {
        this.DataInsert = DataInsert;
    }

    /**
     * @return the DataUp
     */
    public String getDataUp() {
        return DataUp;
    }

    /**
     * @param DataUp the DataUp to set
     */
    public void setDataUp(String DataUp) {
        this.DataUp = DataUp;
    }

    /**
     * @return the HorarioInsert
     */
    public String getHorarioInsert() {
        return HorarioInsert;
    }

    /**
     * @param HorarioInsert the HorarioInsert to set
     */
    public void setHorarioInsert(String HorarioInsert) {
        this.HorarioInsert = HorarioInsert;
    }

    /**
     * @return the HorarioUp
     */
    public String getHorarioUp() {
        return HorarioUp;
    }

    /**
     * @param HorarioUp the HorarioUp to set
     */
    public void setHorarioUp(String HorarioUp) {
        this.HorarioUp = HorarioUp;
    }

    /**
     * @return the IdCotFor
     */
    public int getIdCotFor() {
        return IdCotFor;
    }

    /**
     * @param IdCotFor the IdCotFor to set
     */
    public void setIdCotFor(int IdCotFor) {
        this.IdCotFor = IdCotFor;
    }

    /**
     * @return the IdForn
     */
    public int getIdForn() {
        return IdForn;
    }

    /**
     * @param IdForn the IdForn to set
     */
    public void setIdForn(int IdForn) {
        this.IdForn = IdForn;
    }

    /**
     * @return the descricaoFornecedor
     */
    public String getDescricaoFornecedor() {
        return descricaoFornecedor;
    }

    /**
     * @param descricaoFornecedor the descricaoFornecedor to set
     */
    public void setDescricaoFornecedor(String descricaoFornecedor) {
        this.descricaoFornecedor = descricaoFornecedor;
    }

    /**
     * @return the IdForma
     */
    public int getIdForma() {
        return IdForma;
    }

    /**
     * @param IdForma the IdForma to set
     */
    public void setIdForma(int IdForma) {
        this.IdForma = IdForma;
    }

    /**
     * @return the descricaoFormaPagto
     */
    public String getDescricaoFormaPagto() {
        return descricaoFormaPagto;
    }

    /**
     * @param descricaoFormaPagto the descricaoFormaPagto to set
     */
    public void setDescricaoFormaPagto(String descricaoFormaPagto) {
        this.descricaoFormaPagto = descricaoFormaPagto;
    }

    /**
     * @return the PrazoEntrega
     */
    public String getPrazoEntrega() {
        return PrazoEntrega;
    }

    /**
     * @param PrazoEntrega the PrazoEntrega to set
     */
    public void setPrazoEntrega(String PrazoEntrega) {
        this.PrazoEntrega = PrazoEntrega;
    }

    /**
     * @return the dataVencimento
     */
    public Date getDataVencimento() {
        return dataVencimento;
    }

    /**
     * @param dataVencimento the dataVencimento to set
     */
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    /**
     * @return the ObservacaoFornecedor
     */
    public String getObservacaoFornecedor() {
        return ObservacaoFornecedor;
    }

    /**
     * @param ObservacaoFornecedor the ObservacaoFornecedor to set
     */
    public void setObservacaoFornecedor(String ObservacaoFornecedor) {
        this.ObservacaoFornecedor = ObservacaoFornecedor;
    }
}
