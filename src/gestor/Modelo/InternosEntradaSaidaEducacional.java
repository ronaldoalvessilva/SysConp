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
public class InternosEntradaSaidaEducacional {

    private int idItem;
    private int idLanc;
    private int idInternoCrc;
    private String nomeInternoEduca;
    private Date dataSaida;
    private String horarioSaida;
    private Date dataEntrada;
    private String horarioEntrada;
    private int qtdInt;
    private String mesReferencia;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;  
    private byte [] pAssinaturaDigital;

    public InternosEntradaSaidaEducacional() {
    }

    public InternosEntradaSaidaEducacional(int idItem, int idLanc, int idInternoCrc, String nomeInternoEduca, Date dataSaida, String horarioSaida, Date dataEntrada, String horarioEntrada, int qtdInt, String mesReferencia, String observacao, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp, byte[] pAssinaturaDigital) {
        this.idItem = idItem;
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoEduca = nomeInternoEduca;
        this.dataSaida = dataSaida;
        this.horarioSaida = horarioSaida;
        this.dataEntrada = dataEntrada;
        this.horarioEntrada = horarioEntrada;
        this.qtdInt = qtdInt;
        this.mesReferencia = mesReferencia;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.pAssinaturaDigital = pAssinaturaDigital;
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
     * @return the nomeInternoEduca
     */
    public String getNomeInternoEduca() {
        return nomeInternoEduca;
    }

    /**
     * @param nomeInternoEduca the nomeInternoEduca to set
     */
    public void setNomeInternoEduca(String nomeInternoEduca) {
        this.nomeInternoEduca = nomeInternoEduca;
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
     * @return the qtdInt
     */
    public int getQtdInt() {
        return qtdInt;
    }

    /**
     * @param qtdInt the qtdInt to set
     */
    public void setQtdInt(int qtdInt) {
        this.qtdInt = qtdInt;
    }

    /**
     * @return the mesReferencia
     */
    public String getMesReferencia() {
        return mesReferencia;
    }

    /**
     * @param mesReferencia the mesReferencia to set
     */
    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
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

    /**
     * @return the pAssinaturaDigital
     */
    public byte[] getpAssinaturaDigital() {
        return pAssinaturaDigital;
    }

    /**
     * @param pAssinaturaDigital the pAssinaturaDigital to set
     */
    public void setpAssinaturaDigital(byte[] pAssinaturaDigital) {
        this.pAssinaturaDigital = pAssinaturaDigital;
    }
}
