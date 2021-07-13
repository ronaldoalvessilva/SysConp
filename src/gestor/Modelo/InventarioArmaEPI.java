/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ronaldo.silva7
 */
public class InventarioArmaEPI {

    private Integer idLanc;
    private String statusLanc;
    private String tipoProduto;
    private String tipoInventario;
    private int idLocal;
    private String nomeLocalArmazenamento;
    private String responsavel;
    private Date dataInicio;
    private Date dataTermino;
    private String horarioInicio;
    private String horarioTermino;
    private String observacao;
    private int idItem;
    private int idProduto;
    private String nomeProduto;
    private String unidade;
    private Integer qtdItem;
    private float valorCusto;
    private String lote;
    private Date DataLote;
    private int tipoArmaEPI;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public InventarioArmaEPI() {
    }

    public InventarioArmaEPI(Integer idLanc, String statusLanc, String tipoProduto, String tipoInventario, int idLocal, String nomeLocalArmazenamento, String responsavel, Date dataInicio, Date dataTermino, String horarioInicio, String horarioTermino, String observacao, int idItem, int idProduto, String nomeProduto, String unidade, Integer qtdItem, float valorCusto, String lote, Date DataLote, int tipoArmaEPI, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idLanc = idLanc;
        this.statusLanc = statusLanc;
        this.tipoProduto = tipoProduto;
        this.tipoInventario = tipoInventario;
        this.idLocal = idLocal;
        this.nomeLocalArmazenamento = nomeLocalArmazenamento;
        this.responsavel = responsavel;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
        this.observacao = observacao;
        this.idItem = idItem;
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.unidade = unidade;
        this.qtdItem = qtdItem;
        this.valorCusto = valorCusto;
        this.lote = lote;
        this.DataLote = DataLote;
        this.tipoArmaEPI = tipoArmaEPI;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idLanc
     */
    public Integer getIdLanc() {
        return idLanc;
    }

    /**
     * @param idLanc the idLanc to set
     */
    public void setIdLanc(Integer idLanc) {
        this.idLanc = idLanc;
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
     * @return the tipoProduto
     */
    public String getTipoProduto() {
        return tipoProduto;
    }

    /**
     * @param tipoProduto the tipoProduto to set
     */
    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    /**
     * @return the tipoInventario
     */
    public String getTipoInventario() {
        return tipoInventario;
    }

    /**
     * @param tipoInventario the tipoInventario to set
     */
    public void setTipoInventario(String tipoInventario) {
        this.tipoInventario = tipoInventario;
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
     * @return the nomeLocalArmazenamento
     */
    public String getNomeLocalArmazenamento() {
        return nomeLocalArmazenamento;
    }

    /**
     * @param nomeLocalArmazenamento the nomeLocalArmazenamento to set
     */
    public void setNomeLocalArmazenamento(String nomeLocalArmazenamento) {
        this.nomeLocalArmazenamento = nomeLocalArmazenamento;
    }

    /**
     * @return the responsavel
     */
    public String getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataTermino
     */
    public Date getDataTermino() {
        return dataTermino;
    }

    /**
     * @param dataTermino the dataTermino to set
     */
    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    /**
     * @return the horarioInicio
     */
    public String getHorarioInicio() {
        return horarioInicio;
    }

    /**
     * @param horarioInicio the horarioInicio to set
     */
    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    /**
     * @return the horarioTermino
     */
    public String getHorarioTermino() {
        return horarioTermino;
    }

    /**
     * @param horarioTermino the horarioTermino to set
     */
    public void setHorarioTermino(String horarioTermino) {
        this.horarioTermino = horarioTermino;
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
     * @return the qtdItem
     */
    public Integer getQtdItem() {
        return qtdItem;
    }

    /**
     * @param qtdItem the qtdItem to set
     */
    public void setQtdItem(Integer qtdItem) {
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
     * @return the tipoArmaEPI
     */
    public int getTipoArmaEPI() {
        return tipoArmaEPI;
    }

    /**
     * @param tipoArmaEPI the tipoArmaEPI to set
     */
    public void setTipoArmaEPI(int tipoArmaEPI) {
        this.tipoArmaEPI = tipoArmaEPI;
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
