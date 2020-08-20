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
public class ItensMovSaidaRetorno {

    private int idItem;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int idSaida;
    private Date dataSaida;
    private Date DataPrevRetorno;
    private String nrDocSaida;
    private int idRetorno;
    private Date dataRetorno;
    private String nrDocRetorno;
    private String dataEvasao;
    private String confirmaEvasao;
    private String tipoSaida;

    public ItensMovSaidaRetorno() {
    }

    public ItensMovSaidaRetorno(int idItem, int idInternoCrc, String nomeInternoCrc, int idSaida, Date dataSaida, Date DataPrevRetorno, String nrDocSaida, int idRetorno, Date dataRetorno, String nrDocRetorno, String dataEvasao, String confirmaEvasao, String tipoSaida) {
        this.idItem = idItem;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idSaida = idSaida;
        this.dataSaida = dataSaida;
        this.DataPrevRetorno = DataPrevRetorno;
        this.nrDocSaida = nrDocSaida;
        this.idRetorno = idRetorno;
        this.dataRetorno = dataRetorno;
        this.nrDocRetorno = nrDocRetorno;
        this.dataEvasao = dataEvasao;
        this.confirmaEvasao = confirmaEvasao;
        this.tipoSaida = tipoSaida;
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
     * @return the idSaida
     */
    public int getIdSaida() {
        return idSaida;
    }

    /**
     * @param idSaida the idSaida to set
     */
    public void setIdSaida(int idSaida) {
        this.idSaida = idSaida;
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
     * @return the DataPrevRetorno
     */
    public Date getDataPrevRetorno() {
        return DataPrevRetorno;
    }

    /**
     * @param DataPrevRetorno the DataPrevRetorno to set
     */
    public void setDataPrevRetorno(Date DataPrevRetorno) {
        this.DataPrevRetorno = DataPrevRetorno;
    }

    /**
     * @return the nrDocSaida
     */
    public String getNrDocSaida() {
        return nrDocSaida;
    }

    /**
     * @param nrDocSaida the nrDocSaida to set
     */
    public void setNrDocSaida(String nrDocSaida) {
        this.nrDocSaida = nrDocSaida;
    }

    /**
     * @return the idRetorno
     */
    public int getIdRetorno() {
        return idRetorno;
    }

    /**
     * @param idRetorno the idRetorno to set
     */
    public void setIdRetorno(int idRetorno) {
        this.idRetorno = idRetorno;
    }

    /**
     * @return the dataRetorno
     */
    public Date getDataRetorno() {
        return dataRetorno;
    }

    /**
     * @param dataRetorno the dataRetorno to set
     */
    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    /**
     * @return the nrDocRetorno
     */
    public String getNrDocRetorno() {
        return nrDocRetorno;
    }

    /**
     * @param nrDocRetorno the nrDocRetorno to set
     */
    public void setNrDocRetorno(String nrDocRetorno) {
        this.nrDocRetorno = nrDocRetorno;
    }

    /**
     * @return the dataEvasao
     */
    public String getDataEvasao() {
        return dataEvasao;
    }

    /**
     * @param dataEvasao the dataEvasao to set
     */
    public void setDataEvasao(String dataEvasao) {
        this.dataEvasao = dataEvasao;
    }

    /**
     * @return the confirmaEvasao
     */
    public String getConfirmaEvasao() {
        return confirmaEvasao;
    }

    /**
     * @param confirmaEvasao the confirmaEvasao to set
     */
    public void setConfirmaEvasao(String confirmaEvasao) {
        this.confirmaEvasao = confirmaEvasao;
    }

    /**
     * @return the tipoSaida
     */
    public String getTipoSaida() {
        return tipoSaida;
    }

    /**
     * @param tipoSaida the tipoSaida to set
     */
    public void setTipoSaida(String tipoSaida) {
        this.tipoSaida = tipoSaida;
    }
}
