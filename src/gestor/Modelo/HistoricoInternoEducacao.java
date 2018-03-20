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
public class HistoricoInternoEducacao {

    private int idLanc;
    private int idInternoCrc;
    private String nomeInterno;
    private int idItem;
    private int idCod;
    private String nomeInstituicao;
    private Date dataEntrada;
    private String horarioEntrada;
    private Date dataSaida;
    private String horarioSaida;   

    public HistoricoInternoEducacao(int idLanc, int idInternoCrc, String nomeInterno, int idItem, int idCod, String nomeInstituicao, Date dataEntrada, String horarioEntrada, Date dataSaida, String horarioSaida) {
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.idItem = idItem;
        this.idCod = idCod;
        this.nomeInstituicao = nomeInstituicao;
        this.dataEntrada = dataEntrada;
        this.horarioEntrada = horarioEntrada;
        this.dataSaida = dataSaida;
        this.horarioSaida = horarioSaida;
    }

    public HistoricoInternoEducacao() {
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
     * @return the nomeInterno
     */
    public String getNomeInterno() {
        return nomeInterno;
    }

    /**
     * @param nomeInterno the nomeInterno to set
     */
    public void setNomeInterno(String nomeInterno) {
        this.nomeInterno = nomeInterno;
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
     * @return the idCod
     */
    public int getIdCod() {
        return idCod;
    }

    /**
     * @param idCod the idCod to set
     */
    public void setIdCod(int idCod) {
        this.idCod = idCod;
    }

    /**
     * @return the nomeInstituicao
     */
    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    /**
     * @param nomeInstituicao the nomeInstituicao to set
     */
    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
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
     * @return the horarioEntrada
     */
    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    /**
     * @param horarioEntrada the horarioEntrada to set
     */
    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
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
     * @return the horarioSaida
     */
    public String getHorarioSaida() {
        return horarioSaida;
    }

    /**
     * @param horarioSaida the horarioSaida to set
     */
    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }
}
