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
public class ItensObjetosPertences {

    private int idItem;
    private int idLanc;
    private int idPertence;
    private String nomePertence;
    private int idLocal;
    private String descricaoLocal;
    private int idIntenoCrc;
    private String nomeInternoCrc;
    private String statusMov;
    private float quant;
    private Date dataEntrada;
    private Date dataSaida;
    private float saldoEstoque;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;    

    public ItensObjetosPertences(int idItem, int idLanc, int idPertence, String nomePertence, int idLocal, String descricaoLocal, int idIntenoCrc, String nomeInternoCrc, String statusMov, float quant, Date dataEntrada, Date dataSaida, float saldoEstoque, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.idLanc = idLanc;
        this.idPertence = idPertence;
        this.nomePertence = nomePertence;
        this.idLocal = idLocal;
        this.descricaoLocal = descricaoLocal;
        this.idIntenoCrc = idIntenoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.statusMov = statusMov;
        this.quant = quant;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.saldoEstoque = saldoEstoque;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensObjetosPertences() {
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
     * @return the idPertence
     */
    public int getIdPertence() {
        return idPertence;
    }

    /**
     * @param idPertence the idPertence to set
     */
    public void setIdPertence(int idPertence) {
        this.idPertence = idPertence;
    }

    /**
     * @return the nomePertence
     */
    public String getNomePertence() {
        return nomePertence;
    }

    /**
     * @param nomePertence the nomePertence to set
     */
    public void setNomePertence(String nomePertence) {
        this.nomePertence = nomePertence;
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
     * @return the idIntenoCrc
     */
    public int getIdIntenoCrc() {
        return idIntenoCrc;
    }

    /**
     * @param idIntenoCrc the idIntenoCrc to set
     */
    public void setIdIntenoCrc(int idIntenoCrc) {
        this.idIntenoCrc = idIntenoCrc;
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
     * @return the statusMov
     */
    public String getStatusMov() {
        return statusMov;
    }

    /**
     * @param statusMov the statusMov to set
     */
    public void setStatusMov(String statusMov) {
        this.statusMov = statusMov;
    }

    /**
     * @return the quant
     */
    public float getQuant() {
        return quant;
    }

    /**
     * @param quant the quant to set
     */
    public void setQuant(float quant) {
        this.quant = quant;
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
     * @return the dataSaida
     */
    public Date getDataSaida() {
        return dataSaida;
    }

    /**
     * @param dataSaida the dataSaida to set
     */
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * @return the saldoEstoque
     */
    public float getSaldoEstoque() {
        return saldoEstoque;
    }

    /**
     * @param saldoEstoque the saldoEstoque to set
     */
    public void setSaldoEstoque(float saldoEstoque) {
        this.saldoEstoque = saldoEstoque;
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
