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
public class ItensFrequencia {

    private int idItem;
    private int idFreq;
    private int idInternoCrc;
    private int qtdFrequencia;
    private Date dataEntrada;
    private Date dataSaida;
    private String horarioEntrada;
    private String horarioSaida;
    private String presenca;
    private String utilizacaoMatricula;
    private int idCod;
    private String nomeInstituicao;
    private String nomeInternoCrc;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public ItensFrequencia(int idItem, int idFreq, int idInternoCrc, int qtdFrequencia, Date dataEntrada, Date dataSaida, String horarioEntrada, String horarioSaida, String presenca, String utilizacaoMatricula, int idCod, String nomeInstituicao, String nomeInternoCrc, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.idFreq = idFreq;
        this.idInternoCrc = idInternoCrc;
        this.qtdFrequencia = qtdFrequencia;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.presenca = presenca;
        this.utilizacaoMatricula = utilizacaoMatricula;
        this.idCod = idCod;
        this.nomeInstituicao = nomeInstituicao;
        this.nomeInternoCrc = nomeInternoCrc;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensFrequencia() {
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
     * @return the idFreq
     */
    public int getIdFreq() {
        return idFreq;
    }

    /**
     * @param idFreq the idFreq to set
     */
    public void setIdFreq(int idFreq) {
        this.idFreq = idFreq;
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
     * @return the qtdFrequencia
     */
    public int getQtdFrequencia() {
        return qtdFrequencia;
    }

    /**
     * @param qtdFrequencia the qtdFrequencia to set
     */
    public void setQtdFrequencia(int qtdFrequencia) {
        this.qtdFrequencia = qtdFrequencia;
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
     * @return the presenca
     */
    public String getPresenca() {
        return presenca;
    }

    /**
     * @param presenca the presenca to set
     */
    public void setPresenca(String presenca) {
        this.presenca = presenca;
    }

    /**
     * @return the utilizacaoMatricula
     */
    public String getUtilizacaoMatricula() {
        return utilizacaoMatricula;
    }

    /**
     * @param utilizacaoMatricula the utilizacaoMatricula to set
     */
    public void setUtilizacaoMatricula(String utilizacaoMatricula) {
        this.utilizacaoMatricula = utilizacaoMatricula;
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
